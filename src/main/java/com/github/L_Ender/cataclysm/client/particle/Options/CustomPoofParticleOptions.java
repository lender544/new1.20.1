package com.github.L_Ender.cataclysm.client.particle.Options;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

public record CustomPoofParticleOptions(int r, int g, int b,float gravity) implements ParticleOptions {

    public static final Codec<CustomPoofParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("r").forGetter(CustomPoofParticleOptions::r),
                    Codec.INT.fieldOf("g").forGetter(CustomPoofParticleOptions::g),
                    Codec.INT.fieldOf("b").forGetter(CustomPoofParticleOptions::b),
                    Codec.FLOAT.fieldOf("gravity").forGetter(CustomPoofParticleOptions::gravity)
            ).apply(instance, CustomPoofParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<CustomPoofParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull CustomPoofParticleOptions fromCommand(@NotNull ParticleType<CustomPoofParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            int r = reader.readInt();
            reader.expect(' ');
            int g = reader.readInt();
            reader.expect(' ');
            int b = reader.readInt();
            reader.expect(' ');
            float gravity = reader.readFloat();
            return new CustomPoofParticleOptions(r, g, b,gravity);
        }

        @Override
        public @NotNull CustomPoofParticleOptions fromNetwork(@NotNull ParticleType<CustomPoofParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new CustomPoofParticleOptions(
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readFloat()
            );
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeInt(this.r);
        buffer.writeInt(this.g);
        buffer.writeInt(this.b);
        buffer.writeFloat(this.gravity);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.r + " " + this.g + " " + this.b + " " + this.gravity;
    }

    @Override
    public @NotNull ParticleType<CustomPoofParticleOptions> getType() {
        return ModParticle.CUSTOM_POOF.get();
    }
}
