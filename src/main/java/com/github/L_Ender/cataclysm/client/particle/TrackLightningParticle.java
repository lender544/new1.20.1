package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.particle.Options.LightningParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.TrackLightningParticleOptions;
import com.github.L_Ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.L_Ender.cataclysm.client.render.etc.LightningRender;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector4f;

import java.util.Locale;

public class TrackLightningParticle extends Particle {

    private LightningRender lightningRender = new LightningRender();

    public TrackLightningParticle(ClientLevel world, double x, double y, double z, double xd, double yd, double zd, int r, int g, int b) {
        super(world, x, y, z);
        this.setSize(6.0F, 6.0F);
        this.x = x;
        this.y = y;
        this.z = z;
        this.rCol = r;
        this.gCol = g;
        this.bCol =  b;
        Vec3 lightningTo = new Vec3(xd - x, yd - y, zd - z);
        this.lifetime = 5;
        int sections = 1 + (int) (9 * lightningTo.length());
        LightningBoltData.BoltRenderInfo boltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f(rCol /255, gCol /255, bCol /255, 0.8F), 0.1F);   LightningBoltData bolt = new LightningBoltData(boltData, Vec3.ZERO, lightningTo, sections)
                .size(0.1F + random.nextFloat() * 0.1F)
                .lifespan(this.lifetime)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        lightningRender.update(this, bolt, 1.0F);
    }

    public AABB getRenderBoundingBox(float partialTicks) {
        return getBoundingBox().inflate(0.0);
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);
            this.yd -= (double) this.gravity;
        }
    }


    public void render(VertexConsumer consumer, Camera camera, float partialTick) {
        MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
        Vec3 cameraPos = camera.getPosition();
        float x = (float) (Mth.lerp((double) partialTick, this.xo, this.x));
        float y = (float) (Mth.lerp((double) partialTick, this.yo, this.y));
        float z = (float) (Mth.lerp((double) partialTick, this.zo, this.z));
        PoseStack posestack = new PoseStack();
        posestack.pushPose();
        posestack.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
        posestack.translate(x, y, z);
        lightningRender.render(partialTick, posestack, multibuffersource$buffersource);
        //multibuffersource$buffersource.endBatch();
        posestack.popPose();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }


    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<TrackLightningParticleOptions> {

        @Override
        public Particle createParticle(TrackLightningParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TrackLightningParticle particle;
            particle = new TrackLightningParticle(level, x, y, z, xSpeed,ySpeed,zSpeed, data.r(), data.g(),data.b());
            return particle;
        }

    }

}
