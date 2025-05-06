package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class Poison_Dart_Entity extends AbstractArrow {

    public Poison_Dart_Entity(EntityType type, Level worldIn) {
        super(type, worldIn);
    }

    public Poison_Dart_Entity(EntityType type, double x, double y, double z, Level worldIn) {
        this(type, worldIn);
        this.setPos(x, y, z);
    }

    public Poison_Dart_Entity(Level worldIn, LivingEntity shooter) {
        this(ModEntities.POISON_DART.get(), shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
        this.setOwner(shooter);
        if (shooter instanceof Player) {
            this.pickup = Pickup.ALLOWED;
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.discard();
    }

    protected void doPostHurtEffects(LivingEntity p_36873_) {
        super.doPostHurtEffects(p_36873_);
        Entity entity = this.getEffectSource();
        p_36873_.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1), entity);

    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.ARROW);
    }

}
