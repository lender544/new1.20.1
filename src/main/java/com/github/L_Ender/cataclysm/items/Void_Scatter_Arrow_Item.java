package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.entity.projectile.Void_Scatter_Arrow_Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class Void_Scatter_Arrow_Item extends ArrowItem {
    public Void_Scatter_Arrow_Item(Properties group) {
        super(group);
    }

    @Override
    public AbstractArrow createArrow(Level p_43237_, ItemStack p_43238_, LivingEntity p_43239_, @Nullable ItemStack p_345773_) {
        return new Void_Scatter_Arrow_Entity(p_43237_, p_43239_, p_43238_.copyWithCount(1), p_345773_);
    }

    @Override
    public Projectile asProjectile(Level p_338332_, Position p_338313_, ItemStack p_338304_, Direction p_338842_) {
        Void_Scatter_Arrow_Entity spectralarrow = new Void_Scatter_Arrow_Entity(p_338332_, p_338313_.x(), p_338313_.y(), p_338313_.z(), p_338304_.copyWithCount(1), null);
        spectralarrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return spectralarrow;
    }
}
