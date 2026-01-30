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

public record IgnisSwingParticleOptions(int lifetime, float scale, float yaw, float pitch, float roll) implements ParticleOptions {

    public static StreamCodec<? super ByteBuf, IgnisSwingParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeInt(option.lifetime);
                buf.writeFloat(option.scale);
                buf.writeFloat(option.yaw);
                buf.writeFloat(option.pitch);
                buf.writeFloat(option.roll);
            },
            (buf) -> new IgnisSwingParticleOptions(buf.readInt(),buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat())
    );

    public static MapCodec<IgnisSwingParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("lifetime").forGetter(p -> ((IgnisSwingParticleOptions) p).lifetime),
                    Codec.FLOAT.fieldOf("scale").forGetter(p -> ((IgnisSwingParticleOptions) p).scale),
                    Codec.FLOAT.fieldOf("yaw").forGetter(p -> ((IgnisSwingParticleOptions) p).yaw),
                    Codec.FLOAT.fieldOf("pitch").forGetter(p -> ((IgnisSwingParticleOptions) p).pitch),
                    Codec.FLOAT.fieldOf("roll").forGetter(p -> ((IgnisSwingParticleOptions) p).roll)
            ).apply(object, IgnisSwingParticleOptions::new
            ));

    public @NotNull ParticleType<IgnisSwingParticleOptions> getType() {
        return ModParticle.IGNIS_SWING.get();
    }
}
