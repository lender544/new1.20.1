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

public record SpinTrailParticleOptions(float r, float g, float b) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, SpinTrailParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.r);
                buf.writeFloat(option.g);
                buf.writeFloat(option.b);
            },
            (buf) -> {
                return new SpinTrailParticleOptions(buf.readInt(), buf.readInt(), buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<SpinTrailParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("r").forGetter(p -> ((SpinTrailParticleOptions) p).r),
                    Codec.FLOAT.fieldOf("g").forGetter(p -> ((SpinTrailParticleOptions) p).g),
                    Codec.FLOAT.fieldOf("b").forGetter(p -> ((SpinTrailParticleOptions) p).b)
            ).apply(object, SpinTrailParticleOptions::new
            ));

    public @NotNull ParticleType<SpinTrailParticleOptions> getType() {
        return ModParticle.SPIN_TRAIL_PARTICLE.get();
    }
}
