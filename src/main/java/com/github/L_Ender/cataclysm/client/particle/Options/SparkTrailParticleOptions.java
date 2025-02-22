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

public record SparkTrailParticleOptions(int r, int g, int b) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, SparkTrailParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeInt(option.r);
                buf.writeInt(option.g);
                buf.writeInt(option.b);
            },
            (buf) -> {
                return new SparkTrailParticleOptions(buf.readInt(), buf.readInt(), buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<SparkTrailParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("r").forGetter(p -> ((SparkTrailParticleOptions) p).r),
                    Codec.INT.fieldOf("g").forGetter(p -> ((SparkTrailParticleOptions) p).g),
                    Codec.INT.fieldOf("b").forGetter(p -> ((SparkTrailParticleOptions) p).b)
            ).apply(object, SparkTrailParticleOptions::new
            ));

    public @NotNull ParticleType<SparkTrailParticleOptions> getType() {
        return ModParticle.SPARK_TRAIL.get();
    }
}
