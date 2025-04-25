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



public record NotSpinTrailParticleOptions(float r, float g, float b,float gravity,float reduction,float acceleration,double direction, int life) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, NotSpinTrailParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.r);
                buf.writeFloat(option.g);
                buf.writeFloat(option.b);
                buf.writeFloat(option.gravity);
                buf.writeFloat(option.reduction);
                buf.writeFloat(option.acceleration);
                buf.writeDouble(option.direction);
                buf.writeInt(option.life);
            },
            (buf) -> {
                return new NotSpinTrailParticleOptions(buf.readFloat(), buf.readFloat(), buf.readFloat(),buf.readFloat(),buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<NotSpinTrailParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("r").forGetter(p -> ((NotSpinTrailParticleOptions) p).r),
                    Codec.FLOAT.fieldOf("g").forGetter(p -> ((NotSpinTrailParticleOptions) p).g),
                    Codec.FLOAT.fieldOf("b").forGetter(p -> ((NotSpinTrailParticleOptions) p).b),
                    Codec.FLOAT.fieldOf("gravity").forGetter(p -> ((NotSpinTrailParticleOptions) p).gravity),
                    Codec.FLOAT.fieldOf("reduction").forGetter(p -> ((NotSpinTrailParticleOptions) p).reduction),
                    Codec.FLOAT.fieldOf("acceleration").forGetter(p -> ((NotSpinTrailParticleOptions) p).acceleration),
                    Codec.DOUBLE.fieldOf("direction").forGetter(p -> ((NotSpinTrailParticleOptions) p).direction),
                    Codec.INT.fieldOf("life").forGetter(p -> ((NotSpinTrailParticleOptions) p).life)
            ).apply(object, NotSpinTrailParticleOptions::new
            ));

    public @NotNull ParticleType<NotSpinTrailParticleOptions> getType() {
        return ModParticle.NOT_SPIN_PARTICLE.get();
    }
}
