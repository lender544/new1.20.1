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

public record GatheringWaterParticleOptions(float r, float g, float b) implements ParticleOptions {

    public static final Codec<GatheringWaterParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("r").forGetter(GatheringWaterParticleOptions::r),
                    Codec.FLOAT.fieldOf("g").forGetter(GatheringWaterParticleOptions::g),
                    Codec.FLOAT.fieldOf("b").forGetter(GatheringWaterParticleOptions::b)
            ).apply(instance, GatheringWaterParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<GatheringWaterParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull GatheringWaterParticleOptions fromCommand(@NotNull ParticleType<GatheringWaterParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float r = reader.readInt();
            reader.expect(' ');
            float g = reader.readInt();
            reader.expect(' ');
            float b = reader.readInt();
            return new GatheringWaterParticleOptions(r, g, b);
        }

        @Override
        public @NotNull GatheringWaterParticleOptions fromNetwork(@NotNull ParticleType<GatheringWaterParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new GatheringWaterParticleOptions(
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat()
            );
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
    public @NotNull ParticleType<GatheringWaterParticleOptions> getType() {
        return ModParticle.GATHERING_WATER.get();
    }
}
