package com.github.L_Ender.cataclysm.client.particle.Options;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
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

public record TrackLightningParticleOptions(int r, int g, int b) implements ParticleOptions {

    public static final Codec<TrackLightningParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("r").forGetter(TrackLightningParticleOptions::r),
                    Codec.INT.fieldOf("g").forGetter(TrackLightningParticleOptions::g),
                    Codec.INT.fieldOf("b").forGetter(TrackLightningParticleOptions::b)
            ).apply(instance, TrackLightningParticleOptions::new)
    );

    public static final ParticleOptions.Deserializer<TrackLightningParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {
        @Override
        public @NotNull TrackLightningParticleOptions fromCommand(@NotNull ParticleType<TrackLightningParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            int r = reader.readInt();
            reader.expect(' ');
            int g = reader.readInt();
            reader.expect(' ');
            int b = reader.readInt();
            return new TrackLightningParticleOptions(r, g, b);
        }

        @Override
        public @NotNull TrackLightningParticleOptions fromNetwork(@NotNull ParticleType<TrackLightningParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new TrackLightningParticleOptions(buffer.readInt(), buffer.readInt(), buffer.readInt());
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
    public @NotNull ParticleType<TrackLightningParticleOptions> getType() {
        return ModParticle.TRACK_LIGHTNING.get();
    }
}