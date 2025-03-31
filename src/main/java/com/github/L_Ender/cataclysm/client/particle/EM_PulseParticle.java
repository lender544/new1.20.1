package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class EM_PulseParticle extends Particle {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/particle/em_pulse.png");
    private float size;
    private float prevSize;
    private float prevAlpha;
    private float alphaDecrease;


    private EM_PulseParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z);
        this.setSize(1, 0.1F);
        this.alpha = 1F;
        this.gravity = 0.0F;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
        this.lifetime = 20 ;
        this.alphaDecrease = 1F / (float)Math.max(this.lifetime, 1F);
        this.size = 0.1F;
    }

    public void tick(){
        super.tick();
        this.prevSize = size;
        this.prevAlpha = alpha;
        this.size += 0.3F;
        this.xd *= 0.1D;
        this.yd *= 0.8D;
        this.zd *= 0.1D;
        if(this.alpha > 0.0F){
            this.alpha = Math.max(this.alpha - alphaDecrease, 0.0F);
        }
        this.setSize(1 + size, 0.1F);
    }
    public void render(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        Vec3 vec3 = camera.getPosition();
        float f = (float)(Mth.lerp((double)partialTick, this.xo, this.x) - vec3.x());
        float f1 = (float)(Mth.lerp((double)partialTick, this.yo, this.y) - vec3.y());
        float f2 = (float)(Mth.lerp((double)partialTick, this.zo, this.z) - vec3.z());
        Quaternionf quaternion = Axis.XP.rotationDegrees(90F);
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        VertexConsumer portalStatic = multibuffersource$buffersource.getBuffer(CMRenderTypes.getPulse());
        PoseStack posestack = new PoseStack();
        PoseStack.Pose posestack$pose = posestack.last();
        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float f4 = prevSize + partialTick * (size - prevSize);
        float alphaLerp = prevAlpha + partialTick * (alpha - prevAlpha);
        for(int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            vector3f.rotate(quaternion);
            vector3f.mul(f4);
            vector3f.add(f, f1, f2);
        }
        float f7 = 0;
        float f8 = 1;
        float f5 = 0;
        float f6 = 1;
        int j = 240;
        portalStatic.addVertex((float)avector3f[0].x(), (float)avector3f[0].y(), (float)avector3f[0].z()).setColor(this.rCol, this.gCol, this.bCol, alphaLerp).setUv(f8, f6).setOverlay(OverlayTexture.NO_OVERLAY).setLight(j).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        portalStatic.addVertex((float)avector3f[1].x(), (float)avector3f[1].y(), (float)avector3f[1].z()).setColor(this.rCol, this.gCol, this.bCol, alphaLerp).setUv(f8, f5).setOverlay(OverlayTexture.NO_OVERLAY).setLight(j).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        portalStatic.addVertex((float) avector3f[2].x(), (float)avector3f[2].y(), (float)avector3f[2].z()).setColor(this.rCol, this.gCol, this.bCol, alphaLerp).setUv(f7, f5).setOverlay(OverlayTexture.NO_OVERLAY).setLight(j).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        portalStatic.addVertex((float) avector3f[3].x(), (float)avector3f[3].y(), (float)avector3f[3].z()).setColor(this.rCol, this.gCol, this.bCol, alphaLerp).setUv(f7, f6).setOverlay(OverlayTexture.NO_OVERLAY).setLight(j).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);

        //multibuffersource$buffersource.endBatch();
    }
    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new EM_PulseParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }
}
