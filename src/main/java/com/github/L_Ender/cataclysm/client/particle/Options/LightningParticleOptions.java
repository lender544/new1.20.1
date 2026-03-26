package com.github.L_Ender.cataclysm.client.particle.Options;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

public record LightningParticleOptions(int r, int g, int b) implements ParticleOptions {

    public static final Codec<LightningParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("r").forGetter(LightningParticleOptions::r),
                    Codec.INT.fieldOf("g").forGetter(LightningParticleOptions::g),
                    Codec.INT.fieldOf("b").forGetter(LightningParticleOptions::b)
            ).apply(instance, LightningParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<LightningParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull LightningParticleOptions fromCommand(@NotNull ParticleType<LightningParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            int r = reader.readInt();
            reader.expect(' ');
            int g = reader.readInt();
            reader.expect(' ');
            int b = reader.readInt();
            return new LightningParticleOptions(r, g, b);
        }

        @Override
        public @NotNull LightningParticleOptions fromNetwork(@NotNull ParticleType<LightningParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new LightningParticleOptions(
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readInt()
            );
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeInt(this.r);
        buffer.writeInt(this.g);
        buffer.writeInt(this.b);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.r + " " + this.g + " " + this.b;
    }

    @Override
    public @NotNull ParticleType<LightningParticleOptions> getType() {
        return ModParticle.LIGHTNING.get();
    }
}

