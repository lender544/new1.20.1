package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.Cataclysm;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;


public class SpinTrailParticle extends AbstractTrailParticle {

    private static final ResourceLocation PROTON_TRAIL_TEXTURE = new ResourceLocation(Cataclysm.MODID, "textures/particle/gathering_lightning.png");
    protected double orbitX;
    protected double orbitY;
    protected double orbitZ;
    protected double orbitDistance;
    protected Vec3 orbitOffset;
    protected boolean reverseOrbit;
    protected int orbitAxis;

    protected float orbitSpeed = 1F;

    public SpinTrailParticle(ClientLevel world, double x, double y, double z, double xd, double yd, double zd, float r, float g, float b) {
        super(world, x, y, z, 0, 0, 0,r,g,b);
        this.trailA = 0.8F;
        this.lifetime = 50 + this.random.nextInt(30);
        this.gravity = 0;
        this.orbitX = xd;
        this.orbitY = yd;
        this.orbitZ = zd;
        this.orbitDistance = 4F;
        orbitOffset = new Vec3(0, 0, 0);
        this.reverseOrbit = random.nextBoolean();
        this.orbitAxis = random.nextInt(2);
        this.orbitSpeed = 10F;
    }

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

    public void tick() {
        Vec3 vec3 = getOrbitPosition(age);
        Vec3 movement = vec3.subtract(this.x, this.y, this.z).normalize().scale(orbitSpeed * 0.01F);
        this.xd += movement.x;
        this.yd += movement.y;
        this.zd += movement.z;

        float fade = 1F - age / (float) lifetime;
        this.trailA = 0.8F * fade;
        super.tick();
    }

    public int getLightColor(float f) {
        return 240;
    }


    @Override
    public float getTrailHeight() {
        return 0.2F;
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
    public static class Factory implements ParticleProvider<SpinTrailParticle.SpinData> {

        @Override
        public Particle createParticle(SpinTrailParticle.SpinData data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {

            SpinTrailParticle particle;
            particle = new SpinTrailParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, data.getR(),data.getG(),data.getB());
            return particle;
        }
    }

    public static class SpinData implements ParticleOptions {
        public static final Deserializer<SpinTrailParticle.SpinData> DESERIALIZER = new Deserializer<SpinTrailParticle.SpinData>() {
            public SpinTrailParticle.SpinData fromCommand(ParticleType<SpinTrailParticle.SpinData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float r = reader.readFloat();
                reader.expect(' ');
                float g = reader.readFloat();
                reader.expect(' ');
                float b = reader.readFloat();

                return new SpinTrailParticle.SpinData(r, g, b);
            }

            public SpinTrailParticle.SpinData fromNetwork(ParticleType<SpinTrailParticle.SpinData> particleTypeIn, FriendlyByteBuf buffer) {
                return new SpinTrailParticle.SpinData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
            }
        };

        private final float r;
        private final float g;
        private final float b;

        public SpinData(float r, float g, float b) {
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
        public ParticleType<SpinTrailParticle.SpinData> getType() {
            return ModParticle.SPIN_TRAIL_PARTICLE.get();
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


        public static Codec<SpinTrailParticle.SpinData> CODEC(ParticleType<SpinTrailParticle.SpinData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.FLOAT.fieldOf("r").forGetter(SpinTrailParticle.SpinData::getR),
                            Codec.FLOAT.fieldOf("g").forGetter(SpinTrailParticle.SpinData::getG),
                            Codec.FLOAT.fieldOf("b").forGetter(SpinTrailParticle.SpinData::getB)
                    ).apply(codecBuilder, SpinTrailParticle.SpinData::new)
            );
        }
    }

}
