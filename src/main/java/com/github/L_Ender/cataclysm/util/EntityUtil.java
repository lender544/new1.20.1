package com.github.L_Ender.cataclysm.util;

import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EntityUtil {

    public static void sendPlayerVelocityPacket(Entity entity) {
        if (entity instanceof ServerPlayer severplayer) {
            severplayer.connection.send(new ClientboundSetEntityMotionPacket(entity));
        }
    }

    public static void disableShield(Player player, int ticks) {
        if (!player.level().isClientSide) {
            if (player.isBlocking()) {
                player.getCooldowns().addCooldown(player.getUseItem().getItem(), ticks);
                player.stopUsingItem();
                player.level().broadcastEntityEvent(player, (byte)30);
            }
        }
    }
    
    public static boolean OverDistanceAndHeight(LivingEntity entity,LivingEntity target,float dis,float height) {
        double y = target.getY(0.5D) - entity.getY(0.5D);
        boolean yDistant = Math.abs(y) > height;
        return entity.distanceToSqr(target) > dis * dis || yDistant;
    }

    public static boolean UnderDistanceAndHeight(LivingEntity entity,LivingEntity target,float dis,float height) {
        double y = target.getY(0.5D) - entity.getY(0.5D);
        boolean yDistant = Math.abs(y) < height;
        return entity.distanceToSqr(target) < dis * dis && yDistant;
    }

    public static boolean OverHorizontalDistance(LivingEntity entity,LivingEntity target,float dis) {
        double dx = target.getX() - entity.getX();
        double dz = target.getZ() - entity.getZ();
        double distSqr = dx * dx + dz * dz;

        return distSqr > dis * dis;
    }

    public static boolean UnderHorizontalDistance(LivingEntity entity,LivingEntity target,float dis) {
        double dx = target.getX() - entity.getX();
        double dz = target.getZ() - entity.getZ();
        double distSqr = dx * dx + dz * dz;

        return distSqr < dis * dis;
    }

    public static boolean isEquipped(Item item, @Nullable LivingEntity entity) {
        return entity != null && CuriosApi.getCuriosInventory(entity).map(inv -> inv.findFirstCurio(item).isPresent()).orElse(false);
    }
    

}
