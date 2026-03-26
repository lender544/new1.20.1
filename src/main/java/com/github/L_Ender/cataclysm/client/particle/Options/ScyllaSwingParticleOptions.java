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

public record ScyllaSwingParticleOptions(float scale, float yaw, float pitch) implements ParticleOptions {

    public static final Codec<ScyllaSwingParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("scale").forGetter(ScyllaSwingParticleOptions::scale),
                    Codec.FLOAT.fieldOf("yaw").forGetter(ScyllaSwingParticleOptions::yaw),
                    Codec.FLOAT.fieldOf("pitch").forGetter(ScyllaSwingParticleOptions::pitch)
            ).apply(instance, ScyllaSwingParticleOptions::new)
    );

    public static final ParticleOptions.Deserializer<ScyllaSwingParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {
        @Override
        public @NotNull ScyllaSwingParticleOptions fromCommand(@NotNull ParticleType<ScyllaSwingParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float scale = reader.readFloat();
            reader.expect(' ');
            float yaw = reader.readFloat();
            reader.expect(' ');
            float pitch = reader.readFloat();
            return new ScyllaSwingParticleOptions(scale, yaw, pitch);
        }

        @Override
        public @NotNull ScyllaSwingParticleOptions fromNetwork(@NotNull ParticleType<ScyllaSwingParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new ScyllaSwingParticleOptions(buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeFloat(this.scale);
        buffer.writeFloat(this.yaw);
        buffer.writeFloat(this.pitch);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.scale + " " + this.yaw + " " + this.pitch;
    }

    @Override
    public @NotNull ParticleType<ScyllaSwingParticleOptions> getType() {
        return ModParticle.SCYLLA_SWING.get();
    }
}

