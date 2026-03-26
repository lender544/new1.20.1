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

public record Rising_Trail_Options(float r, float g, float b, float width, float indewidth) implements ParticleOptions {

    public static final Codec<Rising_Trail_Options> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("r").forGetter(Rising_Trail_Options::r),
                    Codec.FLOAT.fieldOf("g").forGetter(Rising_Trail_Options::g),
                    Codec.FLOAT.fieldOf("b").forGetter(Rising_Trail_Options::b),
                    Codec.FLOAT.fieldOf("width").forGetter(Rising_Trail_Options::width),
                    Codec.FLOAT.fieldOf("indewidth").forGetter(Rising_Trail_Options::indewidth)
            ).apply(instance, Rising_Trail_Options::new)
    );

    public static final ParticleOptions.Deserializer<Rising_Trail_Options> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull Rising_Trail_Options fromCommand(@NotNull ParticleType<Rising_Trail_Options> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float r = reader.readFloat();
            reader.expect(' ');
            float g = reader.readFloat();
            reader.expect(' ');
            float b = reader.readFloat();
            reader.expect(' ');
            float width = reader.readFloat();
            reader.expect(' ');
            float indewidth = reader.readFloat();
            return new Rising_Trail_Options(r, g, b, width, indewidth);
        }

        @Override
        public @NotNull Rising_Trail_Options fromNetwork(@NotNull ParticleType<Rising_Trail_Options> particleType, @NotNull FriendlyByteBuf buffer) {
            return new Rising_Trail_Options(
                    buffer.readFloat(),
                    buffer.readFloat(),
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
        buffer.writeFloat(this.width);
        buffer.writeFloat(this.indewidth);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.r + " " + this.g + " " + this.b + " " + this.width + " " + this.indewidth;
    }

    @Override
    public @NotNull ParticleType<Rising_Trail_Options> getType() {
        return ModParticle.RISING_TRAIL.get();
    }
}