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


public record LightningZapParticleOptions(int r, int g, int b, float gravity) implements ParticleOptions {

    public static final Codec<LightningZapParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("r").forGetter(LightningZapParticleOptions::r),
                    Codec.INT.fieldOf("g").forGetter(LightningZapParticleOptions::g),
                    Codec.INT.fieldOf("b").forGetter(LightningZapParticleOptions::b),
                    Codec.FLOAT.fieldOf("gravity").forGetter(LightningZapParticleOptions::gravity)
            ).apply(instance, LightningZapParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<LightningZapParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull LightningZapParticleOptions fromCommand(@NotNull ParticleType<LightningZapParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            int r = reader.readInt();
            reader.expect(' ');
            int g = reader.readInt();
            reader.expect(' ');
            int b = reader.readInt();
            reader.expect(' ');
            float size = reader.readFloat();
            return new LightningZapParticleOptions(r,g,b,size);
        }

        @Override
        public @NotNull LightningZapParticleOptions fromNetwork(@NotNull ParticleType<LightningZapParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new LightningZapParticleOptions(
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
    public @NotNull ParticleType<LightningZapParticleOptions> getType() {
        return ModParticle.LIGHTNING_ZAP.get();
    }
}

