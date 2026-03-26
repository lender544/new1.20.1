package com.github.L_Ender.cataclysm.client.particle.Options;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

public record AfterImageParticleOptions(int entityid, int r, int g, int b, boolean ghost, int lifeticks) implements ParticleOptions {

    public static final Codec<AfterImageParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("entityid").forGetter(AfterImageParticleOptions::entityid),
                    Codec.INT.fieldOf("r").forGetter(AfterImageParticleOptions::r),
                    Codec.INT.fieldOf("g").forGetter(AfterImageParticleOptions::g),
                    Codec.INT.fieldOf("b").forGetter(AfterImageParticleOptions::b),
                    Codec.BOOL.fieldOf("ghost").forGetter(AfterImageParticleOptions::ghost),
                    Codec.INT.fieldOf("lifeticks").forGetter(AfterImageParticleOptions::lifeticks)
            ).apply(instance, AfterImageParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<AfterImageParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull AfterImageParticleOptions fromCommand(@NotNull ParticleType<AfterImageParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            int entityid = reader.readInt();
            reader.expect(' ');
            int r = reader.readInt();
            reader.expect(' ');
            int g = reader.readInt();
            reader.expect(' ');
            int b = reader.readInt();
            reader.expect(' ');
            boolean ghost = reader.readBoolean();
            reader.expect(' ');
            int lifeticks = reader.readInt();
            return new AfterImageParticleOptions(entityid, r, g, b, ghost, lifeticks);
        }

        @Override
        public @NotNull AfterImageParticleOptions fromNetwork(@NotNull ParticleType<AfterImageParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new AfterImageParticleOptions(
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readBoolean(),
                    buffer.readInt()
            );
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeInt(this.entityid);
        buffer.writeInt(this.r);
        buffer.writeInt(this.g);
        buffer.writeInt(this.b);
        buffer.writeBoolean(this.ghost);
        buffer.writeInt(this.lifeticks);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.entityid + " " + this.r + " " + this.g + " " + this.b + " " + this.ghost + " " + this.lifeticks;
    }

    @Override
    public @NotNull ParticleType<AfterImageParticleOptions> getType() {
        return ModParticle.AFTER_IMAGE.get();
    }
}
