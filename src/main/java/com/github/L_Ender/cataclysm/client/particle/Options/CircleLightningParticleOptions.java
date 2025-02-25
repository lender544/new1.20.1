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

public record CircleLightningParticleOptions(int r, int g, int b) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, CircleLightningParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeInt(option.r);
                buf.writeInt(option.g);
                buf.writeInt(option.b);
            },
            (buf) -> {
                return new CircleLightningParticleOptions(buf.readInt(), buf.readInt(), buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<CircleLightningParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("r").forGetter(p -> ((CircleLightningParticleOptions) p).r),
                    Codec.INT.fieldOf("g").forGetter(p -> ((CircleLightningParticleOptions) p).g),
                    Codec.INT.fieldOf("b").forGetter(p -> ((CircleLightningParticleOptions) p).b)
            ).apply(object, CircleLightningParticleOptions::new
            ));

    public @NotNull ParticleType<CircleLightningParticleOptions> getType() {
        return ModParticle.CIRCLE_LIGHTNING.get();
    }
}
