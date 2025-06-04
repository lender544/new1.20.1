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

public record RainFogParticleOptions(float size) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, RainFogParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.size);
            },
            (buf) -> {
                return new RainFogParticleOptions(buf.readFloat());
            }
    );

    //For command only?
    public static MapCodec<RainFogParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("size").forGetter(p -> ((RainFogParticleOptions) p).size)
            ).apply(object, RainFogParticleOptions::new
            ));

    public @NotNull ParticleType<RainFogParticleOptions> getType() {
        return ModParticle.RAIN_FOG.get();
    }
}
