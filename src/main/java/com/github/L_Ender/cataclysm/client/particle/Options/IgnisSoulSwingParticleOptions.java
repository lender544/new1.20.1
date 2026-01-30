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

public record IgnisSoulSwingParticleOptions(int lifetime,float scale, float yaw, float pitch,float roll) implements ParticleOptions {

    public static StreamCodec<? super ByteBuf, IgnisSoulSwingParticleOptions> STREAM_CODEC = StreamCodec.of(
            (buf, option) -> {
                buf.writeInt(option.lifetime);
                buf.writeFloat(option.scale);
                buf.writeFloat(option.yaw);
                buf.writeFloat(option.pitch);
                buf.writeFloat(option.roll);
            },
            (buf) -> new IgnisSoulSwingParticleOptions(buf.readInt(),buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat())
    );

    public static MapCodec<IgnisSoulSwingParticleOptions> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT.fieldOf("lifetime").forGetter(p -> ((IgnisSoulSwingParticleOptions) p).lifetime),
                    Codec.FLOAT.fieldOf("scale").forGetter(p -> ((IgnisSoulSwingParticleOptions) p).scale),
                    Codec.FLOAT.fieldOf("yaw").forGetter(p -> ((IgnisSoulSwingParticleOptions) p).yaw),
                    Codec.FLOAT.fieldOf("pitch").forGetter(p -> ((IgnisSoulSwingParticleOptions) p).pitch),
                    Codec.FLOAT.fieldOf("roll").forGetter(p -> ((IgnisSoulSwingParticleOptions) p).roll)
            ).apply(object, IgnisSoulSwingParticleOptions::new
            ));

    public @NotNull ParticleType<IgnisSoulSwingParticleOptions> getType() {
        return ModParticle.IGNIS_SOUL_SWING.get();
    }
}
