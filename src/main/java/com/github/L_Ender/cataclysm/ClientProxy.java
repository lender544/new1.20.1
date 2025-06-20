package com.github.L_Ender.cataclysm;

import com.github.L_Ender.cataclysm.client.sound.MeatShredderSound;
import com.github.L_Ender.cataclysm.client.sound.SandstormSound;
import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nullable;
import java.util.*;

public class ClientProxy extends ServerProxy {
    public static final Int2ObjectMap<AbstractTickableSoundInstance> ENTITY_SOUND_INSTANCE_MAP = new Int2ObjectOpenHashMap<>();
    public static final Map<BlockEntity, AbstractTickableSoundInstance> BLOCK_ENTITY_SOUND_INSTANCE_MAP = new HashMap<>();
    public static List<UUID> blockedEntityRenders = new ArrayList<>();
    public static Map<UUID, Integer> bossBarRenderTypes = new HashMap<>();

    @Override
    public boolean isFirstPersonPlayer(Entity entity) {
        return entity.equals(Minecraft.getInstance().cameraEntity) && Minecraft.getInstance().options.getCameraType().isFirstPerson();
    }
    @Override
    public void blockRenderingEntity(UUID id) {
        blockedEntityRenders.add(id);
    }
    @Override
    public void releaseRenderingEntity(UUID id) {
        blockedEntityRenders.remove(id);
    }

    @Override
    public void playWorldSound(@Nullable Object soundEmitter, byte type) {
        if (soundEmitter instanceof Entity entity && !entity.level().isClientSide) {
            return;
        }
        switch (type) {
            case 1:
                if (soundEmitter instanceof LivingEntity livingEntity) {
                    MeatShredderSound sound;
                    AbstractTickableSoundInstance old = ENTITY_SOUND_INSTANCE_MAP.get(livingEntity.getId());
                    if (old == null || !(old instanceof MeatShredderSound shredderSound && shredderSound.isSameEntity(livingEntity))) {
                        sound = new MeatShredderSound(livingEntity);
                        ENTITY_SOUND_INSTANCE_MAP.put(livingEntity.getId(), sound);
                    } else {
                        sound = (MeatShredderSound) old;
                    }
                    if (!Minecraft.getInstance().getSoundManager().isActive(sound) && sound.canPlaySound()) {
                        Minecraft.getInstance().getSoundManager().queueTickingSound(sound);
                    }
                }
                break;
            case 2:
                if (soundEmitter instanceof Sandstorm_Entity sandstom) {
                    SandstormSound sound;
                    AbstractTickableSoundInstance old = ENTITY_SOUND_INSTANCE_MAP.get(sandstom.getId());
                    if (old == null || !(old instanceof SandstormSound sandstomSound && sandstomSound.isSameEntity(sandstom))) {
                        sound = new SandstormSound(sandstom);
                        ENTITY_SOUND_INSTANCE_MAP.put(sandstom.getId(), sound);
                    } else {
                        sound = (SandstormSound) old;
                    }
                    if (!Minecraft.getInstance().getSoundManager().isActive(sound) && sound.canPlaySound()) {
                        Minecraft.getInstance().getSoundManager().queueTickingSound(sound);
                    }
                }
                break;
        }
    }
    @Override
    public void clearSoundCacheFor(Entity entity) {
        ENTITY_SOUND_INSTANCE_MAP.remove(entity.getId());
    }

    @Override
    public void clearSoundCacheFor(BlockEntity entity) {
        BLOCK_ENTITY_SOUND_INSTANCE_MAP.remove(entity);
    }
}
