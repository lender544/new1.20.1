package com.github.L_Ender.cataclysm.items;


import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class infernal_forge extends PickaxeItem {
    public infernal_forge(Tier toolMaterial, Properties props) {

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
    public InteractionResult useOn(UseOnContext context) {
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();
        if (player.getMainHandItem() == stack) {
            EarthQuake(context);
            player.getCooldowns().addCooldown(this, CMConfig.InfernalForgeCooldown);
            return InteractionResult.SUCCESS;
        }
        return super.useOn(context);
    }

    private void EarthQuake(UseOnContext context) {
        Player player = context.getPlayer();
        Level world = context.getLevel();
        boolean berserk = player.getMaxHealth() * 1 / 2 >= player.getHealth();
        double radius = 4.0D;
        ScreenShake_Entity.ScreenShake(world, player.position(), 30, 0.1f, 0, 30);
        world.playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.EXPLOSION.get(), SoundSource.PLAYERS, 1.5f, 1F / (player.getRandom().nextFloat() * 0.4F + 0.8F));
        List<Entity> list = world.getEntities(player, player.getBoundingBox().inflate(radius, radius, radius));
        for (Entity entity : list) {
            if (entity instanceof LivingEntity) {
                entity.hurt(world.damageSources().mobAttack(player), (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE));
                entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.0, 2.0, 0.0));
                if (berserk) {
                    entity.igniteForSeconds((int) 5.0);
                }
            }
        }
        if (world.isClientSide) {
            BlockState block = world.getBlockState(player.blockPosition().below());
            double NumberofParticles = radius * 4.0D;

            for (double i = 0.0D; i < 80; i++) {
                double d0 = player.getX() + radius * Mth.sin((float) (i / NumberofParticles * 360.0f));
                double d1 = player.getY() + 0.15;
                double d2 = player.getZ() + radius * Mth.cos((float) (i / NumberofParticles * 360.0f));
                double d3 = world.getRandom().nextGaussian() * 0.2D;
                double d4 = world.getRandom().nextGaussian() * 0.2D;
                double d5 = world.getRandom().nextGaussian() * 0.2D;
                world.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                if (berserk) {
                    world.addParticle(ParticleTypes.FLAME, d0, d1, d2, d3, d4, d5);

                }
            }

        }
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
        tooltip.add(Component.translatable("item.cataclysm.infernal_forge.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.cataclysm.infernal_forge.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}







