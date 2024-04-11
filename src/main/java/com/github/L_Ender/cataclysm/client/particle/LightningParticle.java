package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.L_Ender.cataclysm.client.render.etc.LightningRender;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector4f;

import java.util.Locale;
import java.util.Random;

public class LightningParticle extends Particle {


    private float r ;
    private float g ;
    private float b ;
    private float toX;
    private float toY;
    private float toZ;
    private LightningRender lightningRender = new LightningRender();

    public LightningParticle(ClientLevel world, double x, double y, double z, float xSpeed, float ySpeed, float zSpeed, float r, float g, float b) {
        super(world, x, y, z);
        this.setSize(1, 1);
        this.gravity = 0.0F;
        this.lifetime = 5 + new Random().nextInt(3);
        this.toX = xSpeed;
        this.toY = ySpeed;
        this.toZ = zSpeed;
        this.r = r;
        this.g = g;
        this.b = b;

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
        float lerpAge = this.age + partialTick;
        float ageProgress = lerpAge / (float) this.lifetime;
        float scale = 1.85F;
        posestack.pushPose();
        posestack.translate(f, f1, f2);
        posestack.scale(scale, scale, scale);
        LightningBoltData.BoltRenderInfo lightningBoltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f(r, g, b, (1.0F - ageProgress) * 0.8F), 0.1F);
        LightningBoltData bolt = new LightningBoltData(lightningBoltData, Vec3.ZERO, new Vec3(toX, toY, toZ), 4)
                .size(0.05F)
                .lifespan(this.lifetime)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        lightningRender.update(this, bolt, partialTick);
        lightningRender.render(partialTick, posestack, multibuffersource$buffersource);

        multibuffersource$buffersource.endBatch();
        posestack.popPose();
    }



    @OnlyIn(Dist.CLIENT)
    public static final class OrbFactory implements ParticleProvider<OrbData> {

        @Override
        public Particle createParticle(OrbData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            LightningParticle particle;
            particle = new LightningParticle(worldIn, x, y, z, (float)xSpeed, (float)ySpeed, (float)zSpeed, typeIn.getR(), typeIn.getG(), typeIn.getB());

            return particle;
        }
    }

    public static class OrbData implements ParticleOptions {
        public static final Deserializer<OrbData> DESERIALIZER = new Deserializer<OrbData>() {
            public OrbData fromCommand(ParticleType<OrbData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float r = (float) reader.readDouble();
                reader.expect(' ');
                float g = (float) reader.readDouble();
                reader.expect(' ');
                float b = (float) reader.readDouble();
                return new OrbData(r, g, b);
            }

            public OrbData fromNetwork(ParticleType<OrbData> particleTypeIn, FriendlyByteBuf buffer) {
                return new OrbData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
            }
        };

        private final float r;
        private final float g;
        private final float b;



        public OrbData(float r, float g, float b) {
            this.r = r;
            this.g = g;
            this.b = b;


        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeFloat(this.r);
            buffer.writeFloat(this.g);
            buffer.writeFloat(this.b);
        }

        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f %d", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                    this.r, this.g, this.b);
        }

        @Override
        public ParticleType<OrbData> getType() {
            return ModParticle.LIGHTNING.get();
        }

        @OnlyIn(Dist.CLIENT)
        public float getR() {
            return this.r;
        }

        @OnlyIn(Dist.CLIENT)
        public float getG() {
            return this.g;
        }

        @OnlyIn(Dist.CLIENT)
        public float getB() {
            return this.b;
        }


        public static Codec<OrbData> CODEC(ParticleType<OrbData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                    Codec.FLOAT.fieldOf("r").forGetter(OrbData::getR),
                    Codec.FLOAT.fieldOf("g").forGetter(OrbData::getG),
                    Codec.FLOAT.fieldOf("b").forGetter(OrbData::getB)
                    ).apply(codecBuilder, OrbData::new)
            );
        }
    }
}
