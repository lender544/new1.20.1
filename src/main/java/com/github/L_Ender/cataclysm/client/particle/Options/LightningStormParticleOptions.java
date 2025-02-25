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

public record LightningStormParticleOptions(int r, int g, int b) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, LightningStormParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeInt(option.r);
                buf.writeInt(option.g);
                buf.writeInt(option.b);
            },
            (buf) -> {
                return new LightningStormParticleOptions(buf.readInt(), buf.readInt(), buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<LightningStormParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("r").forGetter(p -> ((LightningStormParticleOptions) p).r),
                    Codec.INT.fieldOf("g").forGetter(p -> ((LightningStormParticleOptions) p).g),
                    Codec.INT.fieldOf("b").forGetter(p -> ((LightningStormParticleOptions) p).b)
            ).apply(object, LightningStormParticleOptions::new
            ));

    public @NotNull ParticleType<LightningStormParticleOptions> getType() {
        return ModParticle.LIGHTNING_STORM.get();
    }
}
