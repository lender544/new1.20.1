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

public record TrackLightningParticleOptions(int r, int g, int b) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, TrackLightningParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeInt(option.r);
                buf.writeInt(option.g);
                buf.writeInt(option.b);
            },
            (buf) -> {
                return new TrackLightningParticleOptions(buf.readInt(), buf.readInt(), buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<TrackLightningParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("r").forGetter(p -> ((TrackLightningParticleOptions) p).r),
                    Codec.INT.fieldOf("g").forGetter(p -> ((TrackLightningParticleOptions) p).g),
                    Codec.INT.fieldOf("b").forGetter(p -> ((TrackLightningParticleOptions) p).b)
            ).apply(object, TrackLightningParticleOptions::new
            ));

    public @NotNull ParticleType<TrackLightningParticleOptions> getType() {
        return ModParticle.TRACK_LIGHTNING.get();
    }
}
