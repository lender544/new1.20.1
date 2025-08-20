package com.github.L_Ender.cataclysm.util;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

import java.util.List;

public class EntityUtil {

    public static void sendPlayerVelocityPacket(Entity entity) {
        if (entity instanceof ServerPlayer severplayer) {
            severplayer.connection.send(new ClientboundSetEntityMotionPacket(entity));
        }
    }
}
