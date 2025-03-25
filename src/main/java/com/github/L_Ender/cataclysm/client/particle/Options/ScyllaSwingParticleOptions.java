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

public record ScyllaSwingParticleOptions(float scale,float yaw,float pitch) implements ParticleOptions {

    public static StreamCodec<? super ByteBuf, ScyllaSwingParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeFloat(option.scale);
                buf.writeFloat(option.yaw);
                buf.writeFloat(option.pitch);
            },
            (buf) -> new ScyllaSwingParticleOptions(buf.readFloat(), buf.readFloat(), buf.readFloat())
    );

    public static MapCodec<ScyllaSwingParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.FLOAT.fieldOf("scale").forGetter(p -> ((ScyllaSwingParticleOptions) p).scale),
                    Codec.FLOAT.fieldOf("yaw").forGetter(p -> ((ScyllaSwingParticleOptions) p).yaw),
                    Codec.FLOAT.fieldOf("pitch").forGetter(p -> ((ScyllaSwingParticleOptions) p).pitch)
            ).apply(object, ScyllaSwingParticleOptions::new
            ));

    public @NotNull ParticleType<ScyllaSwingParticleOptions> getType() {
        return ModParticle.SCYLLA_SWING.get();
    }
}
