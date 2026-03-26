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


public record NotSpinTrailParticleOptions(float r, float g, float b,float gravity,float reduction,float acceleration,double direction, int life) implements ParticleOptions {

    public static final Codec<NotSpinTrailParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("r").forGetter(NotSpinTrailParticleOptions::r),
                    Codec.FLOAT.fieldOf("g").forGetter(NotSpinTrailParticleOptions::g),
                    Codec.FLOAT.fieldOf("b").forGetter(NotSpinTrailParticleOptions::b),
                    Codec.FLOAT.fieldOf("gravity").forGetter(NotSpinTrailParticleOptions::gravity),
                    Codec.FLOAT.fieldOf("reduction").forGetter(NotSpinTrailParticleOptions::reduction),
                    Codec.FLOAT.fieldOf("acceleration").forGetter(NotSpinTrailParticleOptions::acceleration),
                    Codec.DOUBLE.fieldOf("direction").forGetter(NotSpinTrailParticleOptions::direction),
                    Codec.INT.fieldOf("life").forGetter(NotSpinTrailParticleOptions::life)
                    
                    
            ).apply(instance, NotSpinTrailParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<NotSpinTrailParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull NotSpinTrailParticleOptions fromCommand(@NotNull ParticleType<NotSpinTrailParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float r = reader.readInt();
            reader.expect(' ');
            float g = reader.readInt();
            reader.expect(' ');
            float b = reader.readInt();
            reader.expect(' ');
            float gravity = reader.readFloat();
            reader.expect(' ');
            float reduction = reader.readFloat();
            reader.expect(' ');
            float acceleration = reader.readFloat();
            reader.expect(' ');
            double direction = reader.readDouble();
            reader.expect(' ');
            int life = reader.readInt();
            return new NotSpinTrailParticleOptions(r,g,b,gravity,reduction,acceleration,direction,life);
        }

        @Override
        public @NotNull NotSpinTrailParticleOptions fromNetwork(@NotNull ParticleType<NotSpinTrailParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new NotSpinTrailParticleOptions(
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readDouble(),
                    buffer.readInt()
            );
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeFloat(this.r);
        buffer.writeFloat(this.g);
        buffer.writeFloat(this.b);
        buffer.writeFloat(this.gravity);
        buffer.writeFloat(this.reduction);
        buffer.writeFloat(this.acceleration);
        buffer.writeDouble(this.direction);
        buffer.writeInt(this.life);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.r + " " + this.g + " " + this.b + " " + this.gravity + " " + this.reduction + " " + this.acceleration + " " + this.direction + " " + this.life;
    }

    @Override
    public @NotNull ParticleType<NotSpinTrailParticleOptions> getType() {
        return ModParticle.NOT_SPIN_PARTICLE.get();
    }
}

