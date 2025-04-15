package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.particle.Options.LightningParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.SparkTrailParticleOptions;
import com.github.L_Ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.L_Ender.cataclysm.client.render.etc.LightningRender;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector4f;

import java.util.Random;

public class SparkTrailParticle extends Particle {


    private double toX;
    private double toY;
    private double toZ;
    private LightningRender lightningRender = new LightningRender();

    public SparkTrailParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int r, int g, int b) {
        super(world, x, y, z);
        this.setSize(1, 1);
        this.gravity = 0.0F;
        this.lifetime = 5 + new Random().nextInt(3);
        this.toX = xSpeed;
        this.toY = ySpeed;
        this.toZ = zSpeed;
        this.rCol = r;
        this.gCol = g;
        this.bCol =  b;

    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    public void render(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        Vec3 vec3 = camera.getPosition();
        PoseStack posestack = new PoseStack();
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        float f = (float)(Mth.lerp((double)partialTick, this.xo, this.x) - vec3.x());
        float f1 = (float)(Mth.lerp((double)partialTick, this.yo, this.y) - vec3.y());
        float f2 = (float)(Mth.lerp((double)partialTick, this.zo, this.z) - vec3.z());
        float scale = 1.85F;
        posestack.pushPose();
        posestack.translate(f, f1, f2);
        posestack.scale(scale, scale, scale);
        LightningBoltData.BoltRenderInfo lightningBoltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f(rCol /255, gCol /255, bCol /255, 1.0F), 0.9F);
        LightningBoltData bolt = new LightningBoltData(lightningBoltData, Vec3.ZERO, new Vec3(toX, toY, toZ), 2)
                .size(0.05F)
                .lifespan(this.lifetime)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        lightningRender.update(this, bolt, partialTick);
        lightningRender.render(partialTick, posestack, multibuffersource$buffersource);

        //multibuffersource$buffersource.endBatch();
        posestack.popPose();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SparkTrailParticleOptions> {

        @Override
        public Particle createParticle(SparkTrailParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            SparkTrailParticle particle;
            particle = new SparkTrailParticle(level, x, y, z,xSpeed,ySpeed,zSpeed, data.r(),data.g(),data.b());
            return particle;
        }

    }
}
