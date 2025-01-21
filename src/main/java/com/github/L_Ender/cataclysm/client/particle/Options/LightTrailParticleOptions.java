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

public record LightTrailParticleOptions(float r, float g, float b, float width, float height, int entityid)  implements ParticleOptions {

    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, LightTrailParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.r);
                buf.writeFloat(option.g);
                buf.writeFloat(option.b);
                buf.writeFloat(option.width);
                buf.writeFloat(option.height);
                buf.writeInt(option.entityid);
            },
            (buf) -> {
                return new LightTrailParticleOptions(buf.readInt(), buf.readInt(), buf.readInt(),buf.readFloat(), buf.readFloat(),buf.readInt());
            }
    );



    //For command only?
    public static MapCodec<LightTrailParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("r").forGetter(p -> ((LightTrailParticleOptions) p).r),
                    Codec.FLOAT.fieldOf("g").forGetter(p -> ((LightTrailParticleOptions) p).g),
                    Codec.FLOAT.fieldOf("b").forGetter(p -> ((LightTrailParticleOptions) p).b),
                    Codec.FLOAT.fieldOf("width").forGetter(p -> ((LightTrailParticleOptions) p).width),
                    Codec.FLOAT.fieldOf("height").forGetter(p -> ((LightTrailParticleOptions) p).height),
                    Codec.INT.fieldOf("entityid").forGetter(p -> ((LightTrailParticleOptions) p).entityid)
            ).apply(object, LightTrailParticleOptions::new
            ));

    public @NotNull ParticleType<LightTrailParticleOptions> getType() {
        return ModParticle.LIGHT_TRAIL.get();
    }
}
