package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.Options.ParryParticleOptions;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix4f;


public class ParryParticle extends TextureSheetParticle {
    private Vec3[] trailPositions = new Vec3[64];
    private int trailPointer = -1;
    private static final ResourceLocation TRAIL_TEXTURE = new ResourceLocation(Cataclysm.MODID, "textures/particle/gathering_lightning.png");

    protected float trailA = 1.0F;
    protected ParryParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed,float r,float g,float b) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.gravity = 0.95F;
        this.friction = 0.999F;
        this.rCol = r;
        this.gCol = g;
        this.bCol = b;
        this.alpha = 0.6F;
        this.xd += (double)xSpeed;
        this.yd += (double)ySpeed;
        this.zd += (double)zSpeed;
        this.yd = (double)(this.random.nextFloat() * 0.4F + 0.05F);
        this.quadSize *= 0.5F;
        this.lifetime = 9 + level.random.nextInt(3);
    }


    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public int getLightColor(float p_107086_) {
        int i = super.getLightColor(p_107086_);
        int j = 240;
        int k = i >> 16 & 255;
        return 240 | k << 16;
    }

    public float getQuadSize(float p_107089_) {
        float f = ((float)this.age + p_107089_) / (float)this.lifetime;
        return this.quadSize * (1.0F - f * f);
    }

    public void tick() {
        super.tick();

        if (!this.removed) {
            float f = (float)this.age / (float)this.lifetime;

            this.xd *= (1.0F - f * f);
            this.yd *= (1.0F - f * f);
            this.zd *= (1.0F - f * f);

            tickTrail();
        }
        if (this.onGround) {
            this.remove();
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

    @Override
    public void render(VertexConsumer consumer, Camera camera, float partialTick) {
        //super.render(consumer, camera, partialTick);
        if (trailPointer > -1) {
            MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
            VertexConsumer vertexConsumer = getVetrexConsumer(bufferSource);
            Vec3 cameraPos = camera.getPosition();
            float renderX = (float) (Mth.lerp((double) partialTick, this.xo, this.x));
            float renderY = (float) (Mth.lerp((double) partialTick, this.yo, this.y));
            float renderZ = (float) (Mth.lerp((double) partialTick, this.zo, this.z));

            PoseStack poseStack = new PoseStack();
            poseStack.pushPose();
            poseStack.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);

            int light = getLightColor(partialTick);
            float trailWidth = 0.08F;

            PoseStack.Pose lastPose = poseStack.last();
            Matrix4f matrix = lastPose.pose();

            Vec3 drawFrom = new Vec3(renderX, renderY, renderZ);

            int subSteps = 5;
            int totalSamples = sampleCount();
            float totalLength = totalSamples * subSteps;
            for (int i = 0; i < totalSamples - 1; i++) {
                Vec3 p0 = getTrailPosition(Math.max(0, i - 1) * sampleStep(), partialTick);
                Vec3 p1 = getTrailPosition(i * sampleStep(), partialTick);
                Vec3 p2 = getTrailPosition((i + 1) * sampleStep(), partialTick);
                Vec3 p3 = getTrailPosition(Math.min(totalSamples - 1, i + 2) * sampleStep(), partialTick);

                for (int step = 1; step <= subSteps; step++) {
                    float t = step / (float) subSteps;

                    Vec3 sample = catmullRom(t, p0, p1, p2, p3);
                    float currentStepIndex = (i * subSteps) + step;
                    float u1 = (currentStepIndex - 1) / totalLength;
                    float u2 = currentStepIndex / totalLength;

                    Vec3 forward = sample.subtract(drawFrom);
                    if (forward.lengthSqr() == 0) continue;

                    Vec3 toCamera = cameraPos.subtract(drawFrom);
                    Vec3 side = forward.cross(toCamera).normalize();
                    Vec3 offset = side.scale(trailWidth / 2.0F);

                    addVertex(vertexConsumer, matrix, drawFrom.add(offset), rCol, gCol, bCol, u1, 0F, light);
                    addVertex(vertexConsumer, matrix, drawFrom.add(offset.scale(-1)), rCol, gCol, bCol, u1, 1F, light);
                    addVertex(vertexConsumer, matrix, sample.add(offset.scale(-1)), rCol, gCol, bCol, u2, 1F, light);
                    addVertex(vertexConsumer, matrix, sample.add(offset), rCol, gCol, bCol, u2, 0F, light);

                    drawFrom = sample;
                }
            }
            bufferSource.endBatch();
            poseStack.popPose();
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
        }
    }

    private Vec3 catmullRom(float t, Vec3 p0, Vec3 p1, Vec3 p2, Vec3 p3) {
        double t2 = t * t;
        double t3 = t2 * t;

        double x = 0.5 * ((2 * p1.x) + (-p0.x + p2.x) * t + (2 * p0.x - 5 * p1.x + 4 * p2.x - p2.x) * t2 + (-p0.x + 3 * p1.x - 3 * p2.x + p3.x) * t3);
        double y = 0.5 * ((2 * p1.y) + (-p0.y + p2.y) * t + (2 * p0.y - 5 * p1.y + 4 * p2.y - p2.y) * t2 + (-p0.y + 3 * p1.y - 3 * p2.y + p3.y) * t3);
        double z = 0.5 * ((2 * p1.z) + (-p0.z + p2.z) * t + (2 * p0.z - 5 * p1.z + 4 * p2.z - p2.z) * t2 + (-p0.z + 3 * p1.z - 3 * p2.z + p3.z) * t3);

        return new Vec3(x, y, z);
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, float r, float g, float b, float u, float v, int light) {
        consumer.vertex(matrix, (float) pos.x, (float) pos.y, (float) pos.z)
                .color(r, g, b, 1.0F)
                .uv(u, v)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(light)
                .normal(0.0F, 1.0F, 0.0F)
                .endVertex();
    }


    protected VertexConsumer getVetrexConsumer(MultiBufferSource.BufferSource multibuffersource$buffersource) {
        return multibuffersource$buffersource.getBuffer(CMRenderTypes.getLightTrailEffect(getTrailTexture()));
    }

    public float getTrailRot(Camera camera) {
        return -0.017453292F * camera.getXRot();
    }


    public float getTrailHeight() {
        return 0.4F;
    }

    public ResourceLocation getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    public int sampleCount() {
        return Math.min(6, (lifetime - age) /2);
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


    @OnlyIn(Dist.CLIENT)
    public static class ParryFactory implements ParticleProvider<ParryParticleOptions> {
        private final SpriteSet spriteSet;

        public ParryFactory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        public Particle createParticle(ParryParticleOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ParryParticle particle = new ParryParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn.r(), typeIn.g(), typeIn.b());
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}