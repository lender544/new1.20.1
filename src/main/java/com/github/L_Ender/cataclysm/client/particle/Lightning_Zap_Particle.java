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


@OnlyIn(Dist.CLIENT)
public class Lightning_Zap_Particle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private int getR;
    private int getG;
    private int getB;

    protected Lightning_Zap_Particle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites, int r, int g, int b, float gravity) {
        super(level, x, y, z);
        this.gravity = gravity;
        this.friction = 0.1F;
        this.sprites = sprites;
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.rCol = r/255F;
        this.gCol = g/255F;
        this.bCol = b/255F;
        this.getR = r ;
        this.getG = g;
        this.getB = b;
        this.quadSize = 0.25F + level.random.nextFloat() * 0.15F;
        this.lifetime = 6;
        this.setSpriteFromAge(sprites);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public int getLightColor(float p_106821_) {
        return 240;
    }


    public void tick() {
        super.tick();
        if(this.age == 3){
            this.rCol = 1f;
            this.gCol = 1f;
            this.bCol = 1f;
        }else{
            this.rCol = this.getR /255F;
            this.gCol = this.getG /255F;
            this.bCol = this.getB /255F;
        }
        if (this.age++ >= this.lifetime) {
            this.remove();
        }else{
            this.setSpriteFromAge(this.sprites);
        }
    }


    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<Lightning_Zap_Particle.ZapData> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(Lightning_Zap_Particle.ZapData type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new Lightning_Zap_Particle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites,type.getR(), type.getG(), type.getB(),type.getGravity());
        }
    }

    public static class ZapData implements ParticleOptions {
        public static final Deserializer<Lightning_Zap_Particle.ZapData> DESERIALIZER = new Deserializer<Lightning_Zap_Particle.ZapData>() {
            public Lightning_Zap_Particle.ZapData fromCommand(ParticleType<Lightning_Zap_Particle.ZapData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                int r = reader.readInt();
                reader.expect(' ');
                int g = reader.readInt();
                reader.expect(' ');
                int b = reader.readInt();
                reader.expect(' ');
                float gravity = reader.readFloat();

                return new Lightning_Zap_Particle.ZapData(r, g, b,gravity);
            }

            public Lightning_Zap_Particle.ZapData fromNetwork(ParticleType<Lightning_Zap_Particle.ZapData> particleTypeIn, FriendlyByteBuf buffer) {
                return new Lightning_Zap_Particle.ZapData(buffer.readInt(), buffer.readInt(),buffer.readInt(),buffer.readFloat());
            }
        };

        private final int r;
        private final int g;
        private final int b;
        private final float gravity;

        public ZapData(int r, int g, int b,float gravity) {
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
        public ParticleType<Lightning_Zap_Particle.ZapData> getType() {
            return ModParticle.LIGHTNING_ZAP.get();
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


        public static Codec<Lightning_Zap_Particle.ZapData> CODEC(ParticleType<Lightning_Zap_Particle.ZapData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.INT.fieldOf("r").forGetter(Lightning_Zap_Particle.ZapData::getR),
                            Codec.INT.fieldOf("g").forGetter(Lightning_Zap_Particle.ZapData::getG),
                            Codec.INT.fieldOf("b").forGetter(Lightning_Zap_Particle.ZapData::getB),
                            Codec.FLOAT.fieldOf("gravity").forGetter(Lightning_Zap_Particle.ZapData::getGravity)
                    ).apply(codecBuilder, Lightning_Zap_Particle.ZapData::new)
            );
        }
    }
}
