package com.github.L_Ender.cataclysm.entity.util;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.capabilities.TidalTentacleCapability;
import com.github.L_Ender.cataclysm.entity.projectile.Tidal_Tentacle_Entity;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import com.github.L_Ender.cataclysm.message.MessageTidalTentacle;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class TidalTentacleUtil {



    public static void setLastTentacle(LivingEntity entity, Tidal_Tentacle_Entity tendon) {
        TidalTentacleCapability.ITentacleCapability TentacleCapability = ModCapabilities.getCapability(entity, ModCapabilities.TENTACLE_CAPABILITY);
        if (TentacleCapability != null) {
            TentacleCapability.setHasTentacle(tendon != null);
        }
    }

    public static void retractFarTentacles(Level level, LivingEntity livingEntity) {
        Tidal_Tentacle_Entity last = getLastTendon(livingEntity);
        if (last != null) {
            last.remove(Entity.RemovalReason.DISCARDED);
            setLastTentacle(livingEntity, null);
        }
    }

    public static boolean canLaunchTentacles(Level level, LivingEntity livingEntity) {
        Tidal_Tentacle_Entity last = getLastTendon(livingEntity);
        if (last != null) {
            return last.isRemoved();
        }
        return true;
    }


    public static Tidal_Tentacle_Entity getLastTendon(LivingEntity livingEntity) {
        TidalTentacleCapability.ITentacleCapability TentacleCapability = ModCapabilities.getCapability(livingEntity, ModCapabilities.TENTACLE_CAPABILITY);
        if (TentacleCapability != null) {
            UUID uuid = TentacleCapability.getLastTentacleUUID();
            int id = TentacleCapability.getLastTentacleID();
            if (!livingEntity.level().isClientSide) {
                if (uuid != null) {
                    Entity e = livingEntity.level().getEntity(id);
                    return e instanceof Tidal_Tentacle_Entity ? (Tidal_Tentacle_Entity) e : null;
                }
            } else {
                if (id != -1) {
                    Entity e = livingEntity.level().getEntity(id);
                    return e instanceof Tidal_Tentacle_Entity ? (Tidal_Tentacle_Entity) e : null;
                }
            }
            return null;
        }
        return null;
    }
}
