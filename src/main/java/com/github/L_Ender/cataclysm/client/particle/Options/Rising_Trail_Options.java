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

public record Rising_Trail_Options(float r, float g, float b, float width, float indewidth)  implements ParticleOptions {

    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, Rising_Trail_Options> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.r);
                buf.writeFloat(option.g);
                buf.writeFloat(option.b);
                buf.writeFloat(option.width);
                buf.writeFloat(option.indewidth);
            },
            (buf) -> {
                return new Rising_Trail_Options(buf.readFloat(), buf.readFloat(), buf.readFloat(),buf.readFloat(), buf.readFloat());
            }
    );



    //For command only?
    public static MapCodec<Rising_Trail_Options> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("r").forGetter(p -> ((Rising_Trail_Options) p).r),
                    Codec.FLOAT.fieldOf("g").forGetter(p -> ((Rising_Trail_Options) p).g),
                    Codec.FLOAT.fieldOf("b").forGetter(p -> ((Rising_Trail_Options) p).b),
                    Codec.FLOAT.fieldOf("width").forGetter(p -> ((Rising_Trail_Options) p).width),
                    Codec.FLOAT.fieldOf("indewidth").forGetter(p -> ((Rising_Trail_Options) p).indewidth)
            ).apply(object, Rising_Trail_Options::new
            ));

    public @NotNull ParticleType<Rising_Trail_Options> getType() {
        return ModParticle.RISING_TRAIL.get();
    }
}
