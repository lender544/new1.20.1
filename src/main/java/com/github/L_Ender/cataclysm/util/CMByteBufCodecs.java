package com.github.L_Ender.cataclysm.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public interface CMByteBufCodecs {
    StreamCodec<ByteBuf, Vec3> VEC3 = new StreamCodec<ByteBuf, Vec3>() {
        public Vec3 decode(ByteBuf p_319897_) {
            return CMMathUtil.readVec3(p_319897_);
        }

        public void encode(ByteBuf p_320441_, Vec3 p_340932_) {
            CMMathUtil.writeVec3(p_320441_, p_340932_);
        }
    };

}
