package com.github.L_Ender.cataclysm;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nullable;
import java.util.UUID;

public class ServerProxy {

    public void init() {
    }

    public boolean isFirstPersonPlayer(Entity entity) {
        return false;
    }

    public void blockRenderingEntity(UUID id) {
    }

    public void releaseRenderingEntity(UUID id) {
    }

    public void clearSoundCacheFor(Entity entity) {

    }



    public boolean isKeyDown(int keyType) {
        return false;
    }

    public void clearSoundCacheFor(BlockEntity entity) {

    }

    public void playWorldSound(@Nullable Object soundEmitter, byte type) {

    }
}
