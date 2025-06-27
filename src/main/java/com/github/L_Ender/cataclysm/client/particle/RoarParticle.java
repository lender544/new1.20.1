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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import java.util.Locale;

/**
 * Created by BobMowzie on 6/2/2017.
 */
public class RoarParticle extends TextureSheetParticle {
    public int r, g, b;
    public float endsize;
    public float startsize;
    public float increase;
    private final SpriteSet sprites;


    public RoarParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ, int duration, int r, int g, int b, float opacity, float startsize, float increase, float endsize, SpriteSet sprites) {
        super(world, x, y, z);
        this.sprites = sprites;
        setSize(1, 1);
        this.setSpriteFromAge(this.sprites);
        this.quadSize = startsize;
        this.startsize = startsize;
        this.increase = increase;
        this.endsize = endsize;
        this.lifetime = duration;
        this.rCol = r/255F;
        this.gCol = g/255F;
        this.bCol = b/255F;
        this.alpha = opacity;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
    }

    @Override
    public int getLightColor(float delta) {
        return 240 | super.getLightColor(delta) & 0xFF0000;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age++ >= this.lifetime) {
            this.remove();
        }else{
            this.setSpriteFromAge(this.sprites);
            this.quadSize += this.increase;
            if (this.increase > 0) {
                this.quadSize = Math.min(this.quadSize, this.endsize);
            } else if (this.increase < 0) {
                this.quadSize = Math.max(this.quadSize, this.endsize);
            }
            this.alpha = Math.max(0f, 1f - ((float) this.age / this.lifetime));
        }
    }



    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static final class RoarFactory implements ParticleProvider<RoarParticle.RoarData> {
        private final SpriteSet spriteSet;

        public RoarFactory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        @Override
        public Particle createParticle(RoarParticle.RoarData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            RoarParticle particle = new RoarParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn.getDuration(), typeIn.getR(), typeIn.getG(), typeIn.getB(), typeIn.getA(), typeIn.getStart(),typeIn.getIncrease(),typeIn.getEnd(),spriteSet);
            return particle;
        }
    }

    public static class RoarData implements ParticleOptions {
        public static final Deserializer<RoarParticle.RoarData> DESERIALIZER = new Deserializer<RoarParticle.RoarData>() {
            public RoarParticle.RoarData fromCommand(ParticleType<RoarParticle.RoarData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                int duration = reader.readInt();
                reader.expect(' ');
                int r = reader.readInt();
                reader.expect(' ');
                int g = reader.readInt();
                reader.expect(' ');
                int b = reader.readInt();
                reader.expect(' ');
                float a = reader.readFloat();
                reader.expect(' ');
                float start = reader.readFloat();
                reader.expect(' ');
                float increase = reader.readFloat();
                reader.expect(' ');
                float end = reader.readFloat();
                return new RoarParticle.RoarData(duration, r, g, b, a, start, increase, end);
            }

            public RoarParticle.RoarData fromNetwork(ParticleType<RoarParticle.RoarData> particleTypeIn, FriendlyByteBuf buf) {
                return new RoarParticle.RoarData(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(),buf.readFloat() ,buf.readFloat(),buf.readFloat(),buf.readFloat());
            }
        };

        private final int duration;
        private final int r;
        private final int g;
        private final int b;
        private final float a;
        private final float startsize;
        private final float increase;
        private final float endsize;
        public RoarData(int duration, int r, int g, int b, float a, float startsize,float increase, float endsize) {
            this.duration = duration;
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
            this.startsize = startsize;
            this.increase = increase;
            this.endsize = endsize;
        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeInt(this.duration);
            buffer.writeInt(this.r);
            buffer.writeInt(this.g);
            buffer.writeInt(this.b);
            buffer.writeFloat(this.a);
            buffer.writeFloat(this.startsize);
            buffer.writeFloat(this.increase);
            buffer.writeFloat(this.endsize);
        }

        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %d %d %d %d %.2f %.2f %.2f %.2f", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                    this.duration, this.r, this.g, this.b, this.a, this.startsize, this.increase, this.endsize);
        }

        @Override
        public ParticleType<RoarParticle.RoarData> getType() {
            return ModParticle.ROAR.get();
        }

        @OnlyIn(Dist.CLIENT)
        public int getDuration() {
            return this.duration;
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
        public float getA() {
            return this.a;
        }

        @OnlyIn(Dist.CLIENT)
        public float getStart() {
            return this.startsize;
        }

        @OnlyIn(Dist.CLIENT)
        public float getIncrease() {
            return this.increase;
        }

        @OnlyIn(Dist.CLIENT)
        public float getEnd() {
            return this.endsize;
        }


        public static Codec<RoarParticle.RoarData> CODEC(ParticleType<RoarParticle.RoarData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                    Codec.INT.fieldOf("duration").forGetter(RoarParticle.RoarData::getDuration),
                    Codec.INT.fieldOf("r").forGetter(RoarParticle.RoarData::getR),
                    Codec.INT.fieldOf("g").forGetter(RoarParticle.RoarData::getG),
                    Codec.INT.fieldOf("b").forGetter(RoarParticle.RoarData::getB),
                    Codec.FLOAT.fieldOf("a").forGetter(RoarParticle.RoarData::getA),
                    Codec.FLOAT.fieldOf("start").forGetter(RoarParticle.RoarData::getStart),
                    Codec.FLOAT.fieldOf("increase").forGetter(RoarParticle.RoarData::getIncrease),
                    Codec.FLOAT.fieldOf("end").forGetter(RoarParticle.RoarData::getEnd)
            ).apply(codecBuilder, RoarParticle.RoarData::new)  );
        }
    }
}

