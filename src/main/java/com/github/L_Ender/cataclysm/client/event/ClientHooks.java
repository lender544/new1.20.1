package com.github.L_Ender.cataclysm.client.event;


import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;

import java.util.*;

public class ClientHooks {
    /**
     * Set of UUIDs of boss bars that belong to Aether bosses.
     */
    public static Map<UUID, Integer> bossBarRenderTypes = new HashMap<>();

    public static List<UUID> blockedEntityRenders = new ArrayList<>();

    public static boolean isFirstPersonPlayer(Entity entity) {
        return entity.equals(Minecraft.getInstance().cameraEntity) && Minecraft.getInstance().options.getCameraType().isFirstPerson();
    }

    public static void blockRenderingEntity(UUID id) {
        blockedEntityRenders.add(id);
    }

    public static void releaseRenderingEntity(UUID id) {
        blockedEntityRenders.remove(id);
    }

}
