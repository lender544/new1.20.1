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

public record SpinTrailParticleOptions(float r, float g, float b) implements ParticleOptions {

    public static final Codec<SpinTrailParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("r").forGetter(SpinTrailParticleOptions::r),
                    Codec.FLOAT.fieldOf("g").forGetter(SpinTrailParticleOptions::g),
                    Codec.FLOAT.fieldOf("b").forGetter(SpinTrailParticleOptions::b)
            ).apply(instance, SpinTrailParticleOptions::new)
    );

    public static final ParticleOptions.Deserializer<SpinTrailParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {
        @Override
        public @NotNull SpinTrailParticleOptions fromCommand(@NotNull ParticleType<SpinTrailParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float r = reader.readFloat();
            reader.expect(' ');
            float g = reader.readFloat();
            reader.expect(' ');
            float b = reader.readFloat();
            return new SpinTrailParticleOptions(r, g, b);
        }

        @Override
        public @NotNull SpinTrailParticleOptions fromNetwork(@NotNull ParticleType<SpinTrailParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new SpinTrailParticleOptions(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeFloat(this.r);
        buffer.writeFloat(this.g);
        buffer.writeFloat(this.b);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.r + " " + this.g + " " + this.b;
    }

    @Override
    public @NotNull ParticleType<SpinTrailParticleOptions> getType() {
        return ModParticle.SPIN_TRAIL_PARTICLE.get();
    }
}
