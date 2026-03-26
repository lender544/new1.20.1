package com.github.L_Ender.cataclysm.client.particle.Options;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

public record StormParticleOptions(float r, float g, float b, float width, float height, int entityid) implements ParticleOptions {

    public static final Codec<StormParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("r").forGetter(StormParticleOptions::r),
                    Codec.FLOAT.fieldOf("g").forGetter(StormParticleOptions::g),
                    Codec.FLOAT.fieldOf("b").forGetter(StormParticleOptions::b),
                    Codec.FLOAT.fieldOf("width").forGetter(StormParticleOptions::width),
                    Codec.FLOAT.fieldOf("height").forGetter(StormParticleOptions::height),
                    Codec.INT.fieldOf("entityid").forGetter(StormParticleOptions::entityid)
            ).apply(instance, StormParticleOptions::new)
    );

    public static final ParticleOptions.Deserializer<StormParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {
        @Override
        public @NotNull StormParticleOptions fromCommand(@NotNull ParticleType<StormParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float r = reader.readFloat();
            reader.expect(' ');
            float g = reader.readFloat();
            reader.expect(' ');
            float b = reader.readFloat();
            reader.expect(' ');
            float width = reader.readFloat();
            reader.expect(' ');
            float height = reader.readFloat();
            reader.expect(' ');
            int entityid = reader.readInt();
            return new StormParticleOptions(r, g, b, width, height, entityid);
        }

        @Override
        public @NotNull StormParticleOptions fromNetwork(@NotNull ParticleType<StormParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new StormParticleOptions(
                    buffer.readFloat(), buffer.readFloat(), buffer.readFloat(),
                    buffer.readFloat(), buffer.readFloat(), buffer.readInt()
            );
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeFloat(this.r);
        buffer.writeFloat(this.g);
        buffer.writeFloat(this.b);
        buffer.writeFloat(this.width);
        buffer.writeFloat(this.height);
        buffer.writeInt(this.entityid);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.r + " " + this.g + " " + this.b + " " + this.width + " " + this.height + " " + this.entityid;
    }

    @Override
    public @NotNull ParticleType<StormParticleOptions> getType() {
        return ModParticle.STORM.get();
    }
}
