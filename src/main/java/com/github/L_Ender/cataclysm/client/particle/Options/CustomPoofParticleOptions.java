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

public record CustomPoofParticleOptions(int r, int g, int b,float gravity) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, CustomPoofParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeInt(option.r);
                buf.writeInt(option.g);
                buf.writeInt(option.b);
                buf.writeFloat(option.gravity);
            },
            (buf) -> {
                return new CustomPoofParticleOptions(buf.readInt(), buf.readInt(), buf.readInt(),buf.readFloat());
            }
    );

    //For command only?
    public static MapCodec<CustomPoofParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("r").forGetter(p -> ((CustomPoofParticleOptions) p).r),
                    Codec.INT.fieldOf("g").forGetter(p -> ((CustomPoofParticleOptions) p).g),
                    Codec.INT.fieldOf("b").forGetter(p -> ((CustomPoofParticleOptions) p).b),
                    Codec.FLOAT.fieldOf("gravity").forGetter(p -> ((CustomPoofParticleOptions) p).gravity)
            ).apply(object, CustomPoofParticleOptions::new
            ));

    public @NotNull ParticleType<CustomPoofParticleOptions> getType() {
        return ModParticle.CUSTOM_POOF.get();
    }
}
