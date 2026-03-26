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

public record SparkTrailParticleOptions(int r, int g, int b) implements ParticleOptions {

    public static final Codec<SparkTrailParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("r").forGetter(SparkTrailParticleOptions::r),
                    Codec.INT.fieldOf("g").forGetter(SparkTrailParticleOptions::g),
                    Codec.INT.fieldOf("b").forGetter(SparkTrailParticleOptions::b)
            ).apply(instance, SparkTrailParticleOptions::new)
    );

    public static final ParticleOptions.Deserializer<SparkTrailParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {
        @Override
        public @NotNull SparkTrailParticleOptions fromCommand(@NotNull ParticleType<SparkTrailParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            int r = reader.readInt();
            reader.expect(' ');
            int g = reader.readInt();
            reader.expect(' ');
            int b = reader.readInt();
            return new SparkTrailParticleOptions(r, g, b);
        }

        @Override
        public @NotNull SparkTrailParticleOptions fromNetwork(@NotNull ParticleType<SparkTrailParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new SparkTrailParticleOptions(buffer.readInt(), buffer.readInt(), buffer.readInt());
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
    public @NotNull ParticleType<SparkTrailParticleOptions> getType() {
        return ModParticle.SPARK_TRAIL.get();
    }
}