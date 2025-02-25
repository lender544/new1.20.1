package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;

import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class The_Annihilator extends Item {

    public The_Annihilator(Properties group) {
        super(group);

    }


    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 6.5D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.4F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .build();
    }


    public UseAnim getUseAnimation(ItemStack p_77661_1_) {
        return UseAnim.SPEAR;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player player) {
            int i = this.getUseDuration(p_43394_,p_43396_) - p_43397_;

            if (i >= 40) {
                yall(p_43395_,p_43396_);
                if (!p_43395_.isClientSide) {
                    player.getCooldowns().addCooldown(this, 100);
                }
            }
        }
    }

    public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        int i = this.getUseDuration(stack,livingEntityIn) - count;
        if (i == 10) {
            masseffectParticle(worldIn,livingEntityIn,2.0F);
        }

        if (i == 20) {
            masseffectParticle(worldIn,livingEntityIn,3.5F);
        }

        if (i == 30) {
            masseffectParticle(worldIn,livingEntityIn,5F);
        }
        if (i == 40) {
            livingEntityIn.playSound(ModSounds.MALEDICTUS_SHORT_ROAR.get(), 1.0F, 1.0f);
        }
    }

    private void yall(Level world,LivingEntity caster) {
        double radius = 6.0D;
        ScreenShake_Entity.ScreenShake(world, caster.position(), 30, 0.1f, 0, 30);
        world.playSound(null, caster.getX(), caster.getY(), caster.getZ(), ModSounds.EXPLOSION.get(), SoundSource.PLAYERS, 1.5f, 1F / (caster.getRandom().nextFloat() * 0.4F + 0.8F));
        List<Entity> list = world.getEntities(caster, caster.getBoundingBox().inflate(radius, radius, radius));
        for (Entity entity : list) {
            if (entity instanceof LivingEntity) {
                entity.hurt(world.damageSources().mobAttack(caster), (float) caster.getAttributeValue(Attributes.ATTACK_DAMAGE) * 2F);
            }
        }
        if (world.isClientSide) {
            world.addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, 30, 86, 236, 204, 1.0f, 85, false, 0), caster.getX() , caster.getY() + 0.03f, caster.getZ(), 0, 0, 0);
        }
    }

    private void masseffectParticle(Level world,LivingEntity caster,float radius) {
        if (world.isClientSide) {
            for (int j = 0; j < 70; ++j) {
                float angle = (float) (Math.random() * 2 * Math.PI);
                double distance = Math.sqrt(Math.random()) * radius;
                double extraX = caster.getX() + distance * Mth.cos(angle);
                double extraY = caster.getY() + 0.3F;
                double extraZ = caster.getZ() + distance * Mth.sin(angle);

                world.addParticle(ModParticle.PHANTOM_WING_FLAME.get(), extraX, extraY, extraZ, 0.0D, world.random.nextGaussian() * 0.04D, 0.0D);
            }
        }
    }



    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        ItemStack otherHand = hand == InteractionHand.MAIN_HAND ? player.getItemInHand(InteractionHand.OFF_HAND) : player.getItemInHand(InteractionHand.MAIN_HAND);
        if (otherHand.is(ModItems.THE_ANNIHILATOR.get())) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantmentValue() {
        return 16;
    }

    public boolean canAttackBlock(BlockState state, Level worldIn, BlockPos pos, Player player) {
        return !player.isCreative();
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add(Component.translatable("item.cataclysm.annihilator.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltips.add(Component.translatable("item.cataclysm.annihilator2.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}