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


public record LightTrailParticleOptions(float r, float g, float b, float width, float height, int entityid) implements ParticleOptions {
    public static final Codec<LightTrailParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("r").forGetter(LightTrailParticleOptions::r),
                    Codec.FLOAT.fieldOf("g").forGetter(LightTrailParticleOptions::g),
                    Codec.FLOAT.fieldOf("b").forGetter(LightTrailParticleOptions::b),
                    Codec.FLOAT.fieldOf("width").forGetter(LightTrailParticleOptions::width),
                    Codec.FLOAT.fieldOf("height").forGetter(LightTrailParticleOptions::height),
                    Codec.INT.fieldOf("entityid").forGetter(LightTrailParticleOptions::entityid)
            ).apply(instance, LightTrailParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<LightTrailParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull LightTrailParticleOptions fromCommand(@NotNull ParticleType<LightTrailParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
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
            return new LightTrailParticleOptions(r,g,b,width,height,entityid);
        }

        @Override
        public @NotNull LightTrailParticleOptions fromNetwork(@NotNull ParticleType<LightTrailParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new LightTrailParticleOptions(
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readInt()
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
    public @NotNull ParticleType<LightTrailParticleOptions> getType() {
        return ModParticle.LIGHT_TRAIL.get();
    }
}



