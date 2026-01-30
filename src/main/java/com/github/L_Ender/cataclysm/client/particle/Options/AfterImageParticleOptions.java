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

public record AfterImageParticleOptions(int entityid,int r, int g, int b,boolean ghost,int lifeticks) implements ParticleOptions {
    //For networking. Encoder/Decoder functions very intuitive
    public static StreamCodec<? super ByteBuf, AfterImageParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeInt(option.entityid);
                buf.writeInt(option.r);
                buf.writeInt(option.g);
                buf.writeInt(option.b);
                buf.writeBoolean(option.ghost);
                buf.writeInt(option.lifeticks);
            },
            (buf) -> {
                return new AfterImageParticleOptions(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt(),buf.readBoolean(), buf.readInt());
            }
    );

    //For command only?
    public static MapCodec<AfterImageParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("entityid").forGetter(p -> ((AfterImageParticleOptions) p).entityid),
                    Codec.INT.fieldOf("r").forGetter(p -> ((AfterImageParticleOptions) p).r),
                    Codec.INT.fieldOf("g").forGetter(p -> ((AfterImageParticleOptions) p).g),
                    Codec.INT.fieldOf("b").forGetter(p -> ((AfterImageParticleOptions) p).b),
                    Codec.BOOL.fieldOf("ghost").forGetter(p -> ((AfterImageParticleOptions) p).ghost),
                    Codec.INT.fieldOf("lifeticks").forGetter(p -> ((AfterImageParticleOptions) p).lifeticks)
            ).apply(object, AfterImageParticleOptions::new
            ));

    public @NotNull ParticleType<AfterImageParticleOptions> getType() {
        return ModParticle.AFTER_IMAGE.get();
    }
}
