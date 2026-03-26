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

public record RingParticleOptions(float yaw, float pitch, int duration, int r, int g, int b, float a, float scale, boolean facesCamera, int behavior) implements ParticleOptions {
    public static final Codec<RingParticleOptions> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.FLOAT.fieldOf("yaw").forGetter(RingParticleOptions::yaw),
                    Codec.FLOAT.fieldOf("pitch").forGetter(RingParticleOptions::pitch),
                    Codec.INT.fieldOf("duration").forGetter(RingParticleOptions::duration),
                    Codec.INT.fieldOf("r").forGetter(RingParticleOptions::r),
                    Codec.INT.fieldOf("g").forGetter(RingParticleOptions::g),
                    Codec.INT.fieldOf("b").forGetter(RingParticleOptions::b),
                    Codec.FLOAT.fieldOf("a").forGetter(RingParticleOptions::a),
                    Codec.FLOAT.fieldOf("scale").forGetter(RingParticleOptions::scale),
                    Codec.BOOL.fieldOf("facescamera").forGetter(RingParticleOptions::facesCamera),
                    Codec.INT.fieldOf("behavior").forGetter(RingParticleOptions::behavior)
            ).apply(instance, RingParticleOptions::new)
    );


    public static final ParticleOptions.Deserializer<RingParticleOptions> DESERIALIZER = new ParticleOptions.Deserializer<>() {

        @Override
        public @NotNull RingParticleOptions fromCommand(@NotNull ParticleType<RingParticleOptions> particleType, @NotNull StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float yaw = reader.readFloat();

            reader.expect(' ');
            float pitch = reader.readFloat();

            reader.expect(' ');
            int duration = reader.readInt();

            reader.expect(' ');
            int r = reader.readInt();

            reader.expect(' ');
            int g = reader.readInt();

            reader.expect(' ');
            int b = reader.readInt();

            reader.expect(' ');
            float a = reader.readFloat();

            reader.expect(' ');
            float scale = reader.readFloat();
            reader.expect(' ');
            boolean facesCamera = reader.readBoolean();

            reader.expect(' ');
            int behavior = reader.readInt();

            return new RingParticleOptions(yaw,pitch,duration,r,g,b,a,scale,facesCamera,behavior);
        }

        @Override
        public @NotNull RingParticleOptions fromNetwork(@NotNull ParticleType<RingParticleOptions> particleType, @NotNull FriendlyByteBuf buffer) {
            return new RingParticleOptions(
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readInt(),
                    buffer.readFloat(),
                    buffer.readFloat(),
                    buffer.readBoolean(),
                    buffer.readInt()
            );
        }
    };

    @Override
    public void writeToNetwork(@NotNull FriendlyByteBuf buffer) {
        buffer.writeFloat(this.yaw);
        buffer.writeFloat(this.pitch);
        buffer.writeInt(this.duration);
        buffer.writeInt(this.r);
        buffer.writeInt(this.g);
        buffer.writeInt(this.b);
        buffer.writeFloat(this.a);
        buffer.writeFloat(this.scale);
        buffer.writeBoolean(this.facesCamera);
        buffer.writeInt(this.behavior);
    }

    @Override
    public @NotNull String writeToString() {
        return BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()) + " " + this.yaw + " " + this.pitch + " " + this.duration + " " + this.r + " " + this.g + " " + this.b + " " + this.a
                + " " + this.scale + " " + this.facesCamera + " " + this.behavior
                ;
    }

    @Override
    public @NotNull ParticleType<RingParticleOptions> getType() {
        return ModParticle.RING.get();
    }
}


