package com.github.L_Ender.cataclysm.items;


import com.github.L_Ender.cataclysm.config.CMCommonConfig;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Flame_Jet_Entity;
import com.github.L_Ender.cataclysm.init.ModDataComponents;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.util.AttributeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class Infernal_forge extends PickaxeItem {
    public Infernal_forge(Tier toolMaterial, Properties props) {

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
        if(player !=null){
            if (player.getMainHandItem() == stack) {
                EarthQuake(context,player);
                player.getCooldowns().addCooldown(this, CMCommonConfig.InfernalForge.cooldown);
                return InteractionResult.SUCCESS;
            }
        }
        return super.useOn(context);
    }

    private void EarthQuake(UseOnContext context, Player player) {
        Level world = context.getLevel();

        boolean berserk = player.getHealth() <= player.getMaxHealth() * 0.5F;
        double radius = 4.0D;

        world.playSound(player, player.blockPosition(), ModSounds.EXPLOSION.get(), SoundSource.PLAYERS, 1.5F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

        if (world.isClientSide) {
            BlockState block = world.getBlockState(context.getClickedPos());
            int numParticles = 80;
            for (int i = 0; i < numParticles; i++) {

                double angle = (double) i / numParticles * (Math.PI * 2.0D);
                double d0 = player.getX() + radius * Math.sin(angle);
                double d1 = player.getY() + 0.15D;
                double d2 = player.getZ() + radius * Math.cos(angle);

                double d3 = world.getRandom().nextGaussian() * 0.1D;
                double d4 = world.getRandom().nextGaussian() * 0.1D;
                double d5 = world.getRandom().nextGaussian() * 0.1D;

                world.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                if (berserk) {
                    world.addParticle(ParticleTypes.FLAME, d0, d1, d2, d3, d4, d5);
                }
            }
        } else if (world instanceof ServerLevel serverLevel) {
            ScreenShake_Entity.ScreenShake(serverLevel, player.position(), 30, 0.1f, 0, 30);

            DamageSource shredderDamage = serverLevel.damageSources().playerAttack(player);
            float basedmg = AttributeUtils.OriginDamage(player, context.getItemInHand());

            List<Entity> list = serverLevel.getEntities(player, player.getBoundingBox().inflate(radius));
            for (Entity entity : list) {
                if (entity instanceof LivingEntity living) {
                    float enchanteddmg = EnchantmentHelper.modifyDamage(serverLevel, context.getItemInHand(), living, shredderDamage, basedmg);

                    if (living.hurt(shredderDamage, enchanteddmg)) {
                        living.setDeltaMovement(living.getDeltaMovement().multiply(0.5D, 1.0D, 0.5D).add(0.0D, 0.6D, 0.0D));
                        if (berserk) {
                            living.igniteForSeconds(5);
                        }
                    }

                }
            }
        }
    }




    private void spawnJet(Level level,LivingEntity player,double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.containing(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = level.getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(level, blockpos1, Direction.UP)) {
                if (!level.isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = level.getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(level, blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            level.addFreshEntity(new Flame_Jet_Entity(level, x, (double) blockpos.getY() + d0, z, rotation, delay,  7F,player));
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
        super.appendHoverText(stack, context, tooltip, flags);
        tooltip.add(Component.translatable("item.cataclysm.infernal_forge.desc").withStyle(ChatFormatting.DARK_GREEN));
        tooltip.add(Component.translatable("item.cataclysm.infernal_forge.desc2").withStyle(ChatFormatting.DARK_GREEN));
    }
}








