package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CMCommonConfig;
import com.github.L_Ender.cataclysm.entity.effect.Void_Vortex_Entity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class Gauntlet_of_Maelstrom extends Cataclysm_Weapon {


    public Gauntlet_of_Maelstrom(Properties group) {
        super(group);
    }


    public UseAnim getUseAnimation(ItemStack p_77661_1_) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return 72000;
    }

    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player p_77659_2_, InteractionHand p_77659_3_) {
        ItemStack item = p_77659_2_.getItemInHand(p_77659_3_);
        InteractionHand otherhand = p_77659_3_ == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;

        ItemStack otheritem = p_77659_2_.getItemInHand(otherhand);

        if (otheritem.canPerformAction(net.neoforged.neoforge.common.ItemAbilities.SHIELD_BLOCK) && !p_77659_2_.getCooldowns().isOnCooldown(otheritem.getItem())) {
            return InteractionResultHolder.fail(item);
        }else{
            p_77659_2_.startUsingItem(p_77659_3_);
            return InteractionResultHolder.consume(item);
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {

        if (entityLiving instanceof Player player) {
            int standingOnY = Mth.floor(entityLiving.getY()) - 10;
            boolean hasSucceeded = false;
            float yawRadians = (float) (Math.toRadians(90 + player.getYRot()));
            HitResult result = player.pick(32D, 1.0F, true);
            if (result.getType() == HitResult.Type.BLOCK) {
                if (!level.isClientSide) {
                    BlockPos startPos = ((BlockHitResult) result).getBlockPos();
                    if (this.spawnVortex(startPos.getX() + 0.5, startPos.getY(), startPos.getZ() + 0.5, standingOnY, yawRadians, level, player)) {
                        hasSucceeded = true;
                    }

                    if (hasSucceeded) {
                        player.getCooldowns().addCooldown(this,  CMCommonConfig.GauntletOfMaelstrom.cooldown);
                        player.awardStat(Stats.ITEM_USED.get(this));
                    }
                }
            }
        }
    }


    private boolean spawnVortex(double x, double y, double z, int lowestYCheck, float rotation, Level world, Player player) {
        BlockPos blockpos = BlockPos.containing(x, y, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = world.getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(world, blockpos1, Direction.UP)) {
                if (!world.isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = world.getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(world, blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= lowestYCheck);

        if (flag) {
            world.addFreshEntity(new Void_Vortex_Entity(world, x, (double)blockpos.getY() + d0, z, rotation, player,150));
            return true;
        }
        return false;
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
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add(Component.translatable("item.cataclysm.gauntlet_of_maelstrom.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}