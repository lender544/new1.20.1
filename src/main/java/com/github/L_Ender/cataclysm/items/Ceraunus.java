package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.effect.Wave_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Player_Ceraunus_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Spark_Entity;
import com.github.L_Ender.cataclysm.init.ModDataAttachments;
import com.github.L_Ender.cataclysm.init.ModDataComponents;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class Ceraunus extends Item implements RangeTool  {


    public Ceraunus(Properties group) {
        super(group);

    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 15.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -3.3F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(BASE_ENTITY_KNOCKBACK_RESISTANCE_ID, 1.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .build();
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity holder, int slot, boolean isSelected) {
        if (!level.isClientSide() && stack.get(ModDataComponents.THROWN_ANCHOR) != null && this.getThrownEntity(level, stack) == null) {
            stack.remove(ModDataComponents.THROWN_ANCHOR);
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
                    float yawRadians = (float) (Math.toRadians(90 + player.getYRot()));
                    double vecX = Math.cos(yawRadians);
                    double vecZ = Math.sin(yawRadians);
                    double vec = 2.0D;
                    double spawnX = p_43396_.getX() + vecX * vec;
                    double spawnY = p_43396_.getY();
                    double spawnZ = p_43396_.getZ() + vecZ * vec;
                    int numberOfWaves = 4;
                    float angleStep = 25.0f;
                    double firstAngleOffset = (numberOfWaves - 1) / 2.0 * angleStep;

                    if (p_43396_.isShiftKeyDown()) {
                        player.getCooldowns().addCooldown(this, CMConfig.CeraunusCooldown);
                        p_43395_.playSound((Player) null, player.getX(), player.getY(), player.getZ(), ModSounds.HEAVY_SMASH.get(), SoundSource.PLAYERS, 0.6F, 1.0F);
                        for (int k = 0; k < numberOfWaves; k++) {
                            double angle = player.getYRot() - firstAngleOffset + (k * angleStep);
                            double rad = Math.toRadians(angle);
                            double dx = -Math.sin(rad);
                            double dz = Math.cos(rad);

                            Wave_Entity WaveEntity = new Wave_Entity(p_43395_, p_43396_, 60, (float) CMConfig.CeraunusWaveDamage);
                            WaveEntity.setPos(spawnX, spawnY, spawnZ);
                            WaveEntity.setState(1);
                            WaveEntity.setYRot(-(float) (Mth.atan2(dx, dz) * (180F / Math.PI)));
                            p_43396_.level().addFreshEntity(WaveEntity);
                            }
                        } else {
                        if (p_43394_.get(ModDataComponents.THROWN_ANCHOR) == null && p_43395_.getWorldBorder().isWithinBounds(player.blockPosition())) {
                            Player_Ceraunus_Entity launchedBlock = new Player_Ceraunus_Entity(p_43395_, player);
                            launchedBlock.setBaseDamage((float) player.getAttributeValue(Attributes.ATTACK_DAMAGE));
                            launchedBlock.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                            if (p_43395_.addFreshEntity(launchedBlock)) {
                                p_43394_.set(ModDataComponents.THROWN_ANCHOR, launchedBlock.getUUID());

                            }
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
    private Player_Ceraunus_Entity getThrownEntity(Level level, ItemStack stack) {
        if (level instanceof ServerLevel server) {
            UUID id = stack.get(ModDataComponents.THROWN_ANCHOR);
            if (id != null) {
                Entity e = server.getEntity(id);
                if (e instanceof Player_Ceraunus_Entity playerCeraunus) {
                    return playerCeraunus;
                }
            }
        }

        return null;
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.get(ModDataComponents.THROWN_ANCHOR) == null && world.getWorldBorder().isWithinBounds(player.blockPosition())) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }else{
            return InteractionResultHolder.fail(itemstack);
        }
    }




    public static boolean getThrowing(ItemStack itemStack){
        return itemStack.get(ModDataComponents.THROWN_ANCHOR) == null;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add(Component.translatable("item.cataclysm.ceraunus.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltips.add(Component.translatable("item.cataclysm.ceraunus2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
        return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }
}
