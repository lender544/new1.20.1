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

public record GatheringWaterParticleOptions(float r, float g, float b) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, GatheringWaterParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.r);
                buf.writeFloat(option.g);
                buf.writeFloat(option.b);
            },
            (buf) -> {
                return new GatheringWaterParticleOptions(buf.readInt(), buf.readInt(), buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<GatheringWaterParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("r").forGetter(p -> ((GatheringWaterParticleOptions) p).r),
                    Codec.FLOAT.fieldOf("g").forGetter(p -> ((GatheringWaterParticleOptions) p).g),
                    Codec.FLOAT.fieldOf("b").forGetter(p -> ((GatheringWaterParticleOptions) p).b)
            ).apply(object, GatheringWaterParticleOptions::new
            ));

    public @NotNull ParticleType<GatheringWaterParticleOptions> getType() {
        return ModParticle.GATHERING_WATER.get();
    }
}
