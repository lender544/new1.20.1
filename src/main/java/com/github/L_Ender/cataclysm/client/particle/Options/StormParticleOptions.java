package com.github.L_Ender.cataclysm.client.particle.Options;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public record StormParticleOptions(float r,float g,float b,float width,float height,int entityid)  implements ParticleOptions {

    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, StormParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.r);
                buf.writeFloat(option.g);
                buf.writeFloat(option.b);
                buf.writeFloat(option.width);
                buf.writeFloat(option.height);
                buf.writeInt(option.entityid);
            },
            (buf) -> {
                return new StormParticleOptions(buf.readInt(), buf.readInt(), buf.readInt(),buf.readFloat(), buf.readFloat(),buf.readInt());
            }
    );



    //For command only?
    public static MapCodec<StormParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("r").forGetter(p -> ((StormParticleOptions) p).r),
                    Codec.FLOAT.fieldOf("g").forGetter(p -> ((StormParticleOptions) p).g),
                    Codec.FLOAT.fieldOf("b").forGetter(p -> ((StormParticleOptions) p).b),
                    Codec.FLOAT.fieldOf("width").forGetter(p -> ((StormParticleOptions) p).width),
                    Codec.FLOAT.fieldOf("height").forGetter(p -> ((StormParticleOptions) p).height),
                    Codec.INT.fieldOf("entityid").forGetter(p -> ((StormParticleOptions) p).entityid)
            ).apply(object, StormParticleOptions::new
            ));

    public @NotNull ParticleType<StormParticleOptions> getType() {
        return ModParticle.STORM.get();
    }
}
