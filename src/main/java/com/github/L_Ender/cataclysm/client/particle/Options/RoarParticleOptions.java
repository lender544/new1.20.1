package com.github.L_Ender.cataclysm.client.particle.Options;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

public record RoarParticleOptions(int duration, int r, int g, int b, float a, float startsize,float increase, float endsize) implements ParticleOptions {
    public static final Codec<RoarParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("duration").forGetter(RoarParticleOptions::duration),
                    Codec.INT.fieldOf("r").forGetter(RoarParticleOptions::r),
                    Codec.INT.fieldOf("g").forGetter(RoarParticleOptions::g),
                    Codec.INT.fieldOf("b").forGetter(RoarParticleOptions::b),
                    Codec.FLOAT.fieldOf("a").forGetter(RoarParticleOptions::a),
                    Codec.FLOAT.fieldOf("startsize").forGetter(RoarParticleOptions::startsize),
                    Codec.FLOAT.fieldOf("increase").forGetter(RoarParticleOptions::increase),
                    Codec.FLOAT.fieldOf("endsize").forGetter(RoarParticleOptions::endsize)
            ).apply(instance, RoarParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<RoarParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull RoarParticleOptions fromCommand(@NotNull ParticleType<RoarParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
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
            float startsize = reader.readFloat();
            reader.expect(' ');
            float increase = reader.readFloat();
            reader.expect(' ');
            float endsize = reader.readFloat();
            return new RoarParticleOptions(duration,r,g,b,a,startsize,increase,endsize);
        }

        @Override
        public @NotNull RoarParticleOptions fromNetwork(@NotNull ParticleType<RoarParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new RoarParticleOptions(
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat()
            );
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
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
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.duration + " " + this.r + " " + this.g + " " + this.b + " " + this.a + " " + this.startsize+ " " + this.increase+ " " + this.endsize;

    }

    @Override
    public @NotNull ParticleType<RoarParticleOptions> getType() {
        return ModParticle.ROAR.get();
    }
}