package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;


public class Gathering_Water_Particle extends SpinTrailParticle {

    private static final ResourceLocation MAIN_TEXTURE = new ResourceLocation(Cataclysm.MODID, "textures/particle/gathering_lightning.png");
    private static final ResourceLocation NULL_TEXTURE = new ResourceLocation(Cataclysm.MODID, "textures/particle/lightning_storm_7.png");
    private static final ResourceLocation PROTON_TRAIL_TEXTURE = new ResourceLocation(Cataclysm.MODID, "textures/particle/gathering_lightning.png");

    protected Gathering_Water_Particle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float r, float g, float b) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed, r, g, b);
        this.orbitAxis = random.nextInt(3);
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.orbitOffset = new Vec3(0, 0, 0);
        this.orbitDistance = 3;
        this.orbitSpeed = 12;
        this.alpha = 1;
        this.hasPhysics = false;
        this.lifetime = 20 + this.random.nextInt(10);
    }

    public int getLightColor(float partialTicks) {
        return 240;
    }

    public void render(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        super.render(vertexConsumer, camera, partialTick);

    }

    public float getAlpha() {
        return Mth.clamp(1F - age / (float) this.lifetime, 0.0F, 1.0F);
    }


    public void tick() {
        this.xd *= 0.9;
        this.yd *= 0.9;
        this.zd *= 0.9;
        super.tick();
        float fadeIn = 0.8F * Mth.clamp(age / (float) this.lifetime * 32.0F, 0.0F, 1.0F);
        float fadeOut = Mth.clamp(1F - age / (float) this.lifetime, 0.0F, 1.0F);
        this.trailA = fadeIn * fadeOut;

    }

    @Override
    public Vec3 getOrbitPosition(float angle) {
        Vec3 center = new Vec3(orbitX, orbitY, orbitZ);
        float f = reverseOrbit ? -1 : 1;
        Vec3 add = Vec3.ZERO;
        float rot = angle * 3 * orbitSpeed * (float) (Math.PI / 180F);
        switch (orbitAxis) {
            case 0:
                add = new Vec3(0, orbitDistance * 0.5F, orbitDistance * 0.5F).xRot(rot * f);
                break;
            case 1:
                add = new Vec3(orbitDistance * 0.5F, 0, orbitDistance * 0.5F).yRot(rot * f);
                break;
            case 2:
                add = new Vec3(orbitDistance * 0.5F, orbitDistance * 0.5F, 0).zRot(rot * f);
                break;
        }
        return center.add(add);
    }

    @Override
    public float getTrailHeight() {
        return 0.4F;
    }


    @Override
    public ResourceLocation getTrailTexture() {
        return PROTON_TRAIL_TEXTURE;
    }

    @Override
    public int sampleCount() {
        return Math.min(10, lifetime - age);
    }


    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<Gathering_Water_Particle.GatheringData> {

        @Override
        public Particle createParticle(Gathering_Water_Particle.GatheringData data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {

            Gathering_Water_Particle particle;
            particle = new Gathering_Water_Particle(level, x, y, z, xSpeed, ySpeed, zSpeed, data.getR(), data.getG(), data.getB());
            return particle;
        }
    }



    public static class GatheringData implements ParticleOptions {
        public static final Deserializer<Gathering_Water_Particle.GatheringData> DESERIALIZER = new Deserializer<Gathering_Water_Particle.GatheringData>() {
            public Gathering_Water_Particle.GatheringData fromCommand(ParticleType<Gathering_Water_Particle.GatheringData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float r = reader.readFloat();
                reader.expect(' ');
                float g = reader.readFloat();
                reader.expect(' ');
                float b = reader.readFloat();

                return new Gathering_Water_Particle.GatheringData(r, g, b);
            }

            public Gathering_Water_Particle.GatheringData fromNetwork(ParticleType<Gathering_Water_Particle.GatheringData> particleTypeIn, FriendlyByteBuf buffer) {
                return new Gathering_Water_Particle.GatheringData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
            }
        };

        private final float r;
        private final float g;
        private final float b;

        public GatheringData(float r, float g, float b) {
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
            return String.format(Locale.ROOT, "%s %.2f %.2f %.2f", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                    this.r, this.g, this.b);
        }

        @Override
        public ParticleType<Gathering_Water_Particle.GatheringData> getType() {
            return ModParticle.GATHERING_WATER.get();
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


        public static Codec<Gathering_Water_Particle.GatheringData> CODEC(ParticleType<Gathering_Water_Particle.GatheringData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.FLOAT.fieldOf("r").forGetter(Gathering_Water_Particle.GatheringData::getR),
                            Codec.FLOAT.fieldOf("g").forGetter(Gathering_Water_Particle.GatheringData::getG),
                            Codec.FLOAT.fieldOf("b").forGetter(Gathering_Water_Particle.GatheringData::getB)
                    ).apply(codecBuilder, Gathering_Water_Particle.GatheringData::new)
            );
        }
    }

}
