package com.github.L_Ender.cataclysm.client.particle;


import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;


@OnlyIn(Dist.CLIENT)
public class Custom_Poof_Particle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private float initialR ;
    private float initialG;
    private float initialB;

    protected Custom_Poof_Particle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites, float r, float g, float b, float gravity) {
        super(level, x, y, z);
        this.gravity = gravity;
        this.friction = 0.9F;
        this.sprites = sprites;
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.rCol = r/255F;
        this.gCol = g/255F;
        this.bCol = b/255F;
        this.initialR = r/255F;
        this.initialG = g/255F;
        this.initialB = b/255F;
        this.quadSize = 0.25F + level.random.nextFloat() * 0.1F;
        this.lifetime = (int)((double)24.0F / ((double)this.random.nextFloat() * 0.8 + 0.2)) + 2;
        this.setSpriteFromAge(sprites);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public int getLightColor(float p_106821_) {
        return 240;
    }


    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {

            this.yd = this.yd - 0.04 * (double)this.gravity;
            this.move(this.xd, this.yd, this.zd);
            if (this.speedUpWhenYMotionIsBlocked && this.y == this.yo) {
                this.xd *= 1.1;
                this.zd *= 1.1;
            }

            this.xd = this.xd * (double)this.friction;
            this.yd = this.yd * (double)this.friction;
            this.zd = this.zd * (double)this.friction;
            if (this.onGround) {
                this.xd *= 0.7F;
                this.zd *= 0.7F;
            }
            float progress = (float)this.age / (float)this.lifetime;

            this.rCol = Mth.lerp(progress, initialR, 1.0F);
            this.gCol = Mth.lerp(progress, initialG, 1.0F);
            this.bCol = Mth.lerp(progress, initialB, 1.0F);
            this.alpha = Mth.lerp(progress, 1.0F, 0.5F);
        }
        this.setSpriteFromAge(this.sprites);
    }


    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<Custom_Poof_Particle.PoofData> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(Custom_Poof_Particle.PoofData type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new Custom_Poof_Particle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites,type.getR(), type.getG(), type.getB(),type.getGravity());
        }
    }



    public static class PoofData implements ParticleOptions {
        public static final Deserializer<Custom_Poof_Particle.PoofData> DESERIALIZER = new Deserializer<Custom_Poof_Particle.PoofData>() {
            public Custom_Poof_Particle.PoofData fromCommand(ParticleType<Custom_Poof_Particle.PoofData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                int r = reader.readInt();
                reader.expect(' ');
                int g = reader.readInt();
                reader.expect(' ');
                int b = reader.readInt();
                reader.expect(' ');
                float gravity = reader.readFloat();

                return new Custom_Poof_Particle.PoofData(r, g, b,gravity);
            }

            public Custom_Poof_Particle.PoofData fromNetwork(ParticleType<Custom_Poof_Particle.PoofData> particleTypeIn, FriendlyByteBuf buffer) {
                return new Custom_Poof_Particle.PoofData(buffer.readInt(), buffer.readInt(),buffer.readInt(),buffer.readFloat());
            }
        };

        private final int r;
        private final int g;
        private final int b;
        private final float gravity;

        public PoofData(int r, int g, int b,float gravity) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.gravity = gravity;
        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeInt(this.r);
            buffer.writeInt(this.g);
            buffer.writeInt(this.b);
            buffer.writeFloat(this.gravity);
        }

        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %d %d %d %.2f", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                    this.r, this.g, this.b,this.gravity);
        }

        @Override
        public ParticleType<Custom_Poof_Particle.PoofData> getType() {
            return ModParticle.CUSTOM_POOF.get();
        }

        @OnlyIn(Dist.CLIENT)
        public int getR() {
            return this.r;
        }

        @OnlyIn(Dist.CLIENT)
        public int getG() {
            return this.g;
        }

        @OnlyIn(Dist.CLIENT)
        public int getB() {
            return this.b;
        }

        @OnlyIn(Dist.CLIENT)
        public float getGravity() {
            return this.gravity;
        }


        public static Codec<Custom_Poof_Particle.PoofData> CODEC(ParticleType<Custom_Poof_Particle.PoofData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.INT.fieldOf("r").forGetter(Custom_Poof_Particle.PoofData::getR),
                            Codec.INT.fieldOf("g").forGetter(Custom_Poof_Particle.PoofData::getG),
                            Codec.INT.fieldOf("b").forGetter(Custom_Poof_Particle.PoofData::getB),
                    Codec.FLOAT.fieldOf("gravity").forGetter(Custom_Poof_Particle.PoofData::getGravity)
                    ).apply(codecBuilder, Custom_Poof_Particle.PoofData::new)
            );
        }
    }

}
