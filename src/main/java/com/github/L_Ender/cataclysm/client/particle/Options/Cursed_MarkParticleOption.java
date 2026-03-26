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


public record Cursed_MarkParticleOption(float size) implements ParticleOptions {

    public static final Codec<Cursed_MarkParticleOption> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("size").forGetter(Cursed_MarkParticleOption::size)
            ).apply(instance, Cursed_MarkParticleOption::new)
    );


    public static final ParticleOptions.Deserializer<Cursed_MarkParticleOption> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull Cursed_MarkParticleOption fromCommand(@NotNull ParticleType<Cursed_MarkParticleOption> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float size = reader.readFloat();
            return new Cursed_MarkParticleOption(size);
        }

        @Override
        public @NotNull Cursed_MarkParticleOption fromNetwork(@NotNull ParticleType<Cursed_MarkParticleOption> particleType, @NotNull FriendlyByteBuf buffer) {
            return new Cursed_MarkParticleOption(
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
    public @NotNull ParticleType<Cursed_MarkParticleOption> getType() {
        return ModParticle.CURSED_MARK.get();
    }
}
