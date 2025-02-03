package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Void_Rune_Entity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

public class void_core extends Item {

    public void_core(Properties group) {
        super(group);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        int standingOnY = Mth.floor(player.getY()) - 1;
        double headY = player.getY() + 1.0D;
        float yawRadians = (float) (Math.toRadians(90 + player.getYRot()));
        boolean hasSucceeded = false;
        if (player.getXRot() > 70) {
            for (int i = 0; i < 5; i++) {
                float mulPosedYaw = yawRadians + (float) i * (float) Math.PI * 0.4F;
                if (this.spawnFangs(player.getX() + (double) Mth.cos(mulPosedYaw) * 1.5D, headY, player.getZ() + (double) Mth.sin(mulPosedYaw) * 1.5D, standingOnY, mulPosedYaw, 0, world, player))
                    hasSucceeded = true;

            }
            for (int k = 0; k < 8; k++) {
                float mulPosedYaw = yawRadians + (float) k * (float) Math.PI * 2.0F / 8.0F + 1.2566371F;
                if (this.spawnFangs(player.getX() + (double) Mth.cos(mulPosedYaw) * 2.5D, headY, player.getZ() + (double) Mth.sin(mulPosedYaw) * 2.5D, standingOnY, mulPosedYaw, 3, world, player))
                    hasSucceeded = true;

            }
        } else {
            for (int l = 0; l < 10; l++) {
                double d2 = 1.25D * (double) (l + 1);
                if(this.spawnFangs(player.getX() + (double) Mth.cos(yawRadians) * d2, headY, player.getZ() + (double) Mth.sin(yawRadians) * d2, standingOnY, yawRadians, l, world, player))
                    hasSucceeded = true;

            }
        }
        ItemStack stack = player.getItemInHand(hand);
        if (hasSucceeded) {
            player.getCooldowns().addCooldown(this, CMConfig.VoidCoreCooldown);
            return InteractionResultHolder.success(stack);
        }
        return InteractionResultHolder.pass(stack);
    }

    private boolean spawnFangs(double x, double y, double z, int lowestYCheck, float yRot, int warmupDelayTicks, Level world, Player player) {
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
            world.addFreshEntity(new Void_Rune_Entity(world, x, (double) blockpos.getY() + d0, z, yRot, warmupDelayTicks,(float) CMConfig.Voidrunedamage, player));
            return true;
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
        tooltip.add(Component.translatable("item.cataclysm.void_core.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

