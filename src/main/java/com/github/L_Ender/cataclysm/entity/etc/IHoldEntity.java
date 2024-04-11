package com.github.L_Ender.cataclysm.entity.etc;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Marker interface for entities that can forcefully pick up the player.
 */
public interface IHoldEntity {
    void setHeldUUID(@Nullable UUID uniqueId);

    UUID getHeldUUID();

    Entity getHeldEntity();

    int getId();
}
