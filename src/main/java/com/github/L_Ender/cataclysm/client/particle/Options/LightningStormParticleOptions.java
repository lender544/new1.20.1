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

public record LightningStormParticleOptions(float size) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, LightningStormParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.size);
            },
            (buf) -> {
                return new LightningStormParticleOptions(buf.readFloat());
            }
    );

    //For command only?
    public static MapCodec<LightningStormParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("size").forGetter(p -> ((LightningStormParticleOptions) p).size)
            ).apply(object, LightningStormParticleOptions::new
            ));

    public @NotNull ParticleType<LightningStormParticleOptions> getType() {
        return ModParticle.LIGHTNING_STORM.get();
    }
}
