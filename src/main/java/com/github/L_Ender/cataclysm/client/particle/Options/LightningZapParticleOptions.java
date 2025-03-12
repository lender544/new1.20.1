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

public record LightningZapParticleOptions(int r, int g, int b, float gravity) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, LightningZapParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeInt(option.r);
                buf.writeInt(option.g);
                buf.writeInt(option.b);
                buf.writeFloat(option.gravity);
            },
            (buf) -> {
                return new LightningZapParticleOptions(buf.readInt(), buf.readInt(), buf.readInt(),buf.readFloat());
            }
    );

    //For command only?
    public static MapCodec<LightningZapParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("r").forGetter(p -> ((LightningZapParticleOptions) p).r),
                    Codec.INT.fieldOf("g").forGetter(p -> ((LightningZapParticleOptions) p).g),
                    Codec.INT.fieldOf("b").forGetter(p -> ((LightningZapParticleOptions) p).b),
                    Codec.FLOAT.fieldOf("gravity").forGetter(p -> ((LightningZapParticleOptions) p).gravity)
            ).apply(object, LightningZapParticleOptions::new
            ));

    public @NotNull ParticleType<LightningZapParticleOptions> getType() {
        return ModParticle.LIGHTNING_ZAP.get();
    }
}
