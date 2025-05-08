package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.projectile.*;
import com.github.L_Ender.cataclysm.init.ModDataComponents;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.items.Components.ChargeAnimationComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class Lightning_Spear_Item extends Item  {


    public Lightning_Spear_Item(Properties group) {
        super(group);

    }


    @Override
    public boolean canAttackBlock(BlockState p_43409_, Level p_43410_, BlockPos p_43411_, Player p_43412_) {
        return !p_43412_.isCreative();
    }

    public UseAnim getUseAnimation(ItemStack p_43417_) {
        return UseAnim.SPEAR;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }


    public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player player) {
            int i = this.getUseDuration(p_43394_,p_43396_) - p_43397_;
            float f = getPowerForTime(i);
            if (!((double) f < 0.5D)) {
                p_43395_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), ModSounds.EMP_ACTIVATED.get(), SoundSource.PLAYERS,1.0F, 0.8F);
                player.getCooldowns().addCooldown(this, 50);
                if (!p_43395_.isClientSide) {
                        float d7 = p_43396_.getYRot();
                        float d = p_43396_.getXRot();
                        float d1 = -Mth.sin(d7 * ((float) Math.PI / 180F)) * Mth.cos(d * ((float) Math.PI / 180F));
                        float d2 = -Mth.sin(d * ((float) Math.PI / 180F));
                        float d3 = Mth.cos(d7 * ((float) Math.PI / 180F)) * Mth.cos(d * ((float) Math.PI / 180F));
                        double theta = d7 * (Math.PI / 180);
                        theta += Math.PI / 2;
                        double vecX = Math.cos(theta);
                        double vecZ = Math.sin(theta);
                        double x = p_43396_.getX() + vecX;
                        double y = p_43396_.getY() + p_43396_.getBbHeight()/2;
                        double Z = p_43396_.getZ() + vecZ;
                        Vec3 vec3 = new Vec3(d1, d2, d3).normalize();
                        float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;
                        float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));
                        Lightning_Spear_Entity lightning = new Lightning_Spear_Entity(player, vec3.normalize(),p_43395_,(float) CMConfig.WASWMissileDamage);
                    lightning.accelerationPower = 0.15D;
                        lightning.setYRot(yRot);
                        lightning.setXRot(xRot);
                        lightning.setPosRaw(x, y, Z);
                        lightning.setAreaDamage(3);
                        lightning.setAreaRadius(1);
                        p_43395_.addFreshEntity(lightning);



                    }
                }
            }


    }

    public static float getPowerForTime(int p_40662_) {
        float f = (float)p_40662_ / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }



    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }
}
