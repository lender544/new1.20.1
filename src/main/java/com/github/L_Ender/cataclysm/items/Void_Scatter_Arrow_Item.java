package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.entity.projectile.Void_Scatter_Arrow_Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Void_Scatter_Arrow_Item extends ArrowItem {
    public Void_Scatter_Arrow_Item(Properties group) {
        super(group);
    }

    public AbstractArrow createArrow(Level level, ItemStack itemStack, LivingEntity livingEntity) {
        return new Void_Scatter_Arrow_Entity(level, livingEntity);
    }

}
