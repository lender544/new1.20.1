package com.github.L_Ender.cataclysm.client.particle.Options;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

public record Circle_ParticleOptions(float yaw, float pitch, int duration, int r, int g, int b, float a, float aStart,float scale, boolean facesCamera, int behavior) implements ParticleOptions {

    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, Circle_ParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.yaw);
                buf.writeFloat(option.pitch);
                buf.writeInt(option.duration);
                buf.writeInt(option.r);
                buf.writeInt(option.g);
                buf.writeInt(option.b);
                buf.writeFloat(option.a);
                buf.writeFloat(option.aStart);
                buf.writeFloat(option.scale);
                buf.writeBoolean(option.facesCamera);
                buf.writeInt(option.behavior);
            },
            (buf) -> {
                return new Circle_ParticleOptions(buf.readFloat(), buf.readFloat(),buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(), buf.readFloat(), buf.readFloat(), buf.readFloat() ,buf.readBoolean() ,buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<Circle_ParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("yaw").forGetter(p -> ((Circle_ParticleOptions) p).yaw),
                    Codec.FLOAT.fieldOf("pitch").forGetter(p -> ((Circle_ParticleOptions) p).pitch),
                    Codec.INT.fieldOf("duration").forGetter(p -> ((Circle_ParticleOptions) p).duration),
                    Codec.INT.fieldOf("r").forGetter(p -> ((Circle_ParticleOptions) p).r),
                    Codec.INT.fieldOf("g").forGetter(p -> ((Circle_ParticleOptions) p).g),
                    Codec.INT.fieldOf("b").forGetter(p -> ((Circle_ParticleOptions) p).b),
                    Codec.FLOAT.fieldOf("a").forGetter(p -> ((Circle_ParticleOptions) p).a),
                    Codec.FLOAT.fieldOf("aStart").forGetter(p -> ((Circle_ParticleOptions) p).aStart),
                    Codec.FLOAT.fieldOf("scale").forGetter(p -> ((Circle_ParticleOptions) p).scale),
                    Codec.BOOL.fieldOf("facescamera").forGetter(p -> ((Circle_ParticleOptions) p).facesCamera),
                    Codec.INT.fieldOf("behavior").forGetter(p -> ((Circle_ParticleOptions) p).behavior)
            ).apply(object, Circle_ParticleOptions::new
            ));

    public @NotNull ParticleType<Circle_ParticleOptions> getType() {
        return ModParticle.CIRCLE.get();
    }
}
