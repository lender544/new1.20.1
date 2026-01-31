package com.github.L_Ender.cataclysm.items;


import com.github.L_Ender.cataclysm.config.CMCommonConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Brontes_Entity;
import com.github.L_Ender.cataclysm.init.ModDataComponents;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.util.AttributeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class Brontes extends PickaxeItem {
    public Brontes(Tier toolMaterial, Properties props) {

        super(toolMaterial, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack heldItemStack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide) {
            target.playSound(ModSounds.HAMMERTIME.get(), 0.5F, 0.5F);
            target.knockback( 1F, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        }
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity holder, int slot, boolean isSelected) {
        if (!level.isClientSide() && stack.get(ModDataComponents.THROWN_HAMMER) != null && this.getThrownEntity(level, stack) == null) {
            stack.remove(ModDataComponents.THROWN_HAMMER);
        }
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
            int i = this.getUseDuration(p_43394_, p_43396_) - p_43397_;
            float f = getPowerForTime(i);
            if (!((double) f < 0.5D)) {
                if (!p_43395_.isClientSide) {
                    if (p_43394_.get(ModDataComponents.THROWN_HAMMER) == null && p_43395_.getWorldBorder().isWithinBounds(player.blockPosition())) {
                        Brontes_Entity brontes = new Brontes_Entity(p_43395_, player);
                        brontes.setBaseDamage(AttributeUtils.OriginDamage(p_43396_,p_43394_));
                        brontes.setAreaDamage((float) CMCommonConfig.Brontes.stormareadamage);
                        brontes.setStormDamage((float) CMCommonConfig.Brontes.stormdamage);
                        brontes.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                        if (p_43395_.addFreshEntity(brontes)) {
                            p_43394_.set(ModDataComponents.THROWN_HAMMER, brontes.getUUID());

                        }
                    }
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

    @Nullable
    private Brontes_Entity getThrownEntity(Level level, ItemStack stack) {
        if (level instanceof ServerLevel server) {
            UUID id = stack.get(ModDataComponents.THROWN_HAMMER);
            if (id != null) {
                Entity e = server.getEntity(id);
                if (e instanceof Brontes_Entity playerCeraunus) {
                    return playerCeraunus;
                }
            }
        }

        return null;
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.get(ModDataComponents.THROWN_HAMMER) == null && world.getWorldBorder().isWithinBounds(player.blockPosition())) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }else{
            return InteractionResultHolder.fail(itemstack);
        }
    }



    public static boolean getThrowing(ItemStack itemStack){
        return itemStack.get(ModDataComponents.THROWN_HAMMER) == null;
    }


    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }



    @Override
    public void setDamage(ItemStack stack, int damage){
        super.setDamage(stack, 0);
    }


    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }

    @Override
    public boolean isValidRepairItem(ItemStack itemStack, ItemStack itemStackMaterial) {
        return false;
    }

    @Override
    public int getEnchantmentValue() {
        return 16;
    }



    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add(Component.translatable("item.cataclysm.brontes.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.cataclysm.brontes.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}







