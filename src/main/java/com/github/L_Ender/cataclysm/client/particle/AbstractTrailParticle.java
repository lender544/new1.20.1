package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.ForgeRenderTypes;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import static net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;

public abstract class AbstractTrailParticle extends Particle {

    private Vec3[] trailPositions = new Vec3[64];
    private int trailPointer = -1;

    public float r;
    public float g;
    public float b;

    protected float trailA = 1.0F;

    public AbstractTrailParticle(ClientLevel world, double x, double y, double z, double xd, double yd, double zd,float r, float g, float b) {
        super(world, x, y, z);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void tick() {
        tickTrail();
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.xd *= 0.99;
        this.yd *= 0.99;
        this.zd *= 0.99;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);
            this.yd -= (double) this.gravity;
        }
    }

    public void tickTrail() {

        Vec3 currentPosition = new Vec3(this.x, this.y, this.z);
        if (trailPointer == -1) {
            for (int i = 0; i < trailPositions.length; i++) {
                trailPositions[i] = currentPosition;
            }
        }
        if (++this.trailPointer == this.trailPositions.length) {
            this.trailPointer = 0;
        }
        this.trailPositions[this.trailPointer] = currentPosition;
    }

    public void render(VertexConsumer consumer, Camera camera, float partialTick) {
        if (trailPointer > -1) {
            MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
            VertexConsumer vertexconsumer = getVetrexConsumer(multibuffersource$buffersource);
            Vec3 cameraPos = camera.getPosition();
            float x = (float) (Mth.lerp((double) partialTick, this.xo, this.x));
            float y = (float) (Mth.lerp((double) partialTick, this.yo, this.y));
            float z = (float) (Mth.lerp((double) partialTick, this.zo, this.z));

            PoseStack posestack = new PoseStack();
            posestack.pushPose();
            posestack.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);

            int light = getLightColor(partialTick);
            float zRot = getTrailRot(camera);
            Vec3 topAngleVec = new Vec3(0, getTrailHeight() / 2F, 0).zRot(zRot);
            Vec3 bottomAngleVec = new Vec3(0, -getTrailHeight() / 2F, 0).zRot(zRot);

            Vec3 drawFrom = new Vec3(x, y, z);
            PoseStack.Pose posestack$pose = posestack.last();
            Matrix4f matrix4f = posestack$pose.pose();
            Matrix3f matrix3f = posestack$pose.normal();
            for (int samples = 0; samples < sampleCount(); samples++) {
                Vec3 sample = getTrailPosition(samples * sampleStep(), partialTick);
                float u1 = samples / (float) sampleCount();
                float u2 = (samples + 1) / (float) sampleCount();

                addVertex(vertexconsumer, matrix4f,matrix3f, drawFrom, bottomAngleVec, u1, 1F, light);
                addVertex(vertexconsumer, matrix4f,matrix3f, sample, bottomAngleVec, u2, 1F, light);
                addVertex(vertexconsumer, matrix4f,matrix3f, sample, topAngleVec, u2, 0F, light);
                addVertex(vertexconsumer, matrix4f,matrix3f, drawFrom, topAngleVec, u1, 0F, light);

                drawFrom = sample;
            }
            posestack.popPose();
           // multibuffersource$buffersource.endBatch();
        }
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix,Matrix3f matrix3f, Vec3 pos, Vec3 offset, float u, float v, int light) {
        consumer.vertex(matrix,
                        (float) (pos.x + offset.x),
                        (float) (pos.y + offset.y),
                        (float) (pos.z + offset.z))
                .color(r, g, b, trailA)
                .uv(u, v)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(light)
                .normal(matrix3f,0.0F, 1.0F, 0.0F)
                .endVertex();
    }

    protected VertexConsumer getVetrexConsumer(MultiBufferSource.BufferSource multibuffersource$buffersource) {
        return multibuffersource$buffersource.getBuffer(CMRenderTypes.NEW_TRAIL_EFFECT.apply(getTrailTexture()));
    }


    public float getTrailRot(Camera camera) {
        return -0.017453292F * camera.getXRot();
    }

    public abstract float getTrailHeight();

    public abstract ResourceLocation getTrailTexture();

    public int sampleCount() {
        return 20;
    }

    public int sampleStep() {
        return 1;
    }


    public Vec3 getTrailPosition(int pointer, float partialTick) {
        if (this.removed) {
            partialTick = 1.0F;
        }
        int i = this.trailPointer - pointer & 63;
        int j = this.trailPointer - pointer - 1 & 63;
        Vec3 d0 = this.trailPositions[j];
        Vec3 d1 = this.trailPositions[i].subtract(d0);
        return d0.add(d1.scale(partialTick));
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }
}