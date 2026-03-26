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

public record RainFogParticleOptions(float size) implements ParticleOptions {
    public static final Codec<RainFogParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("size").forGetter(RainFogParticleOptions::size)
            ).apply(instance, RainFogParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<RainFogParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull RainFogParticleOptions fromCommand(@NotNull ParticleType<RainFogParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float size = reader.readFloat();

            return new RainFogParticleOptions(size);
        }

        @Override
        public @NotNull RainFogParticleOptions fromNetwork(@NotNull ParticleType<RainFogParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new RainFogParticleOptions(
                    buffer.readFloat()
            );
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeFloat(this.size);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.size;
    }

    @Override
    public @NotNull ParticleType<RainFogParticleOptions> getType() {
        return ModParticle.RAIN_FOG.get();
    }
}


