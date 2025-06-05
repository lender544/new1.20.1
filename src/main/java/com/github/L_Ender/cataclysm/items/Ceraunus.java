package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.effect.Wave_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Spark_Entity;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

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
                p_43395_.playSound((Player) null, player.getX(), player.getY(), player.getZ(), ModSounds.HEAVY_SMASH.get(), SoundSource.PLAYERS, 0.6F, 1.0F);
                player.getCooldowns().addCooldown(this, CMConfig.CeraunusCooldown);
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

                    if (!p_43395_.isClientSide()) {
                        if (p_43396_.isShiftKeyDown()) {
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
                            for (int k = 0; k < numberOfWaves; k++) {
                                double angle = player.getYRot() - firstAngleOffset + (k * angleStep);
                                double rad = Math.toRadians(angle);
                                double dx = -Math.sin(rad);
                                double dz = Math.cos(rad);
                                Spark_Entity peq = new Spark_Entity(p_43395_, p_43396_);
                                peq.setDamage((float) CMConfig.CeraunusLightningStormDamage);
                                peq.setAreaRadius(2.0F);
                                peq.shoot(dx, 0.5d, dz, f, 1F);
                                peq.setPos(spawnX, spawnY + 0.03, spawnZ);
                                p_43395_.addFreshEntity(peq);
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
