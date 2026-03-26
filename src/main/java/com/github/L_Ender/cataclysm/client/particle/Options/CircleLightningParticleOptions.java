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


public record CircleLightningParticleOptions(float size,int r, int g, int b) implements ParticleOptions {

    public static final Codec<CircleLightningParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("size").forGetter(CircleLightningParticleOptions::size),
                    Codec.INT.fieldOf("r").forGetter(CircleLightningParticleOptions::r),
                    Codec.INT.fieldOf("g").forGetter(CircleLightningParticleOptions::g),
                    Codec.INT.fieldOf("b").forGetter(CircleLightningParticleOptions::b)

            ).apply(instance, CircleLightningParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<CircleLightningParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull CircleLightningParticleOptions fromCommand(@NotNull ParticleType<CircleLightningParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float size = reader.readFloat();
            reader.expect(' ');
            int r = reader.readInt();
            reader.expect(' ');
            int g = reader.readInt();
            reader.expect(' ');
            int b = reader.readInt();
            return new CircleLightningParticleOptions(size, r, g, b);
        }

        @Override
        public @NotNull CircleLightningParticleOptions fromNetwork(@NotNull ParticleType<CircleLightningParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new CircleLightningParticleOptions(
                    buffer.readFloat(),
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readInt()
            );
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeFloat(this.size);
        buffer.writeInt(this.r);
        buffer.writeInt(this.g);
        buffer.writeInt(this.b);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.size + " " + this.r + " " + this.g + " " + this.b;
    }

    @Override
    public @NotNull ParticleType<CircleLightningParticleOptions> getType() {
        return ModParticle.CIRCLE_LIGHTNING.get();
    }
}
