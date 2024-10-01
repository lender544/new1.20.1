package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.blocks.Door_of_Seal_Block;
import com.github.L_Ender.cataclysm.blocks.ObsidianExplosionTrapBricks;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Door_Of_Seal_BlockEntity extends BlockEntity {
    public int Animaitonticks;
    public int tickCount;
    public int animation = 0;
    public Direction facing;
    public AnimationState openingAnimationState = new AnimationState();
    public AnimationState openAnimationState = new AnimationState();

    public Door_Of_Seal_BlockEntity(BlockPos pos, BlockState state) {
        super(ModTileentites.DOOR_OF_SEAL.get(), pos, state);
        facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "opening") {
            return this.openingAnimationState;
        } else if (input == "open") {
            return this.openAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public boolean triggerEvent(int p_58837_, int p_58838_) {
        if (p_58837_ == 1) {
            this.openingAnimationState.start(this.tickCount);
            return true;
        } else {
            return super.triggerEvent(p_58837_, p_58838_);
        }
    }


    public static void tick(Level level, BlockPos pos, BlockState blockState, Door_Of_Seal_BlockEntity entity) {
        entity.tickCount++;
        if(blockState.getBlock() instanceof Door_of_Seal_Block) {
            if (blockState.getValue(Door_of_Seal_Block.LIT)) {
                ++entity.Animaitonticks;
                if (blockState.getBlock() instanceof Door_of_Seal_Block) {
                    if (!blockState.getValue(Door_of_Seal_Block.OPEN)) {
                        if (entity.Animaitonticks == 1) {
                            ScreenShake_Entity.ScreenShake(level, Vec3.atCenterOf(pos), 20, 0.05f, 0, 120);
                        }

                        if (entity.Animaitonticks == 28) {
                            level.playSound((Player)null, pos, ModSounds.DOOR_OF_SEAL_OPEN.get(), SoundSource.BLOCKS, 4F, level.random.nextFloat() * 0.2F + 1.0F);

                            float x = pos.getX() + 0.5F;
                            float y = pos.getY();
                            float z = pos.getZ() + 0.5F;
                            if (!level.isClientSide) {
                                level.explode(null, x, y + 1, z, 2.0F, Level.ExplosionInteraction.NONE);
                            }
                        }
                        if (entity.Animaitonticks >= 145) {
                            if (!level.isClientSide) {
                                level.setBlock(pos, blockState.setValue(Door_of_Seal_Block.OPEN, Boolean.valueOf(true)), 2);
                                for (int i = 0; i <= 7; i++) {
                                    BlockPos abovePos = pos.above(i);
                                    BlockPos blockpos1 = abovePos.relative(blockState.getValue(Door_of_Seal_Block.FACING).getClockWise());
                                    BlockPos blockpos2 = abovePos;
                                    BlockPos blockpos3 = abovePos.relative(blockState.getValue(Door_of_Seal_Block.FACING).getCounterClockWise());
                                    BlockPos blockpos4 = abovePos.relative(blockState.getValue(Door_of_Seal_Block.FACING).getClockWise(), 2);
                                    BlockPos blockpos5 = abovePos.relative(blockState.getValue(Door_of_Seal_Block.FACING).getCounterClockWise(), 2);
                                    BlockPos[] toBreakPoses = {blockpos1, blockpos2, blockpos3, blockpos4, blockpos5};
                                    for (BlockPos toBreakPos : toBreakPoses) {
                                        BlockState blockstate = level.getBlockState(toBreakPos);
                                        if (blockstate.is(ModBlocks.DOOR_OF_SEAL_PART.get())) {
                                            level.setBlock(toBreakPos, blockstate.setValue(Door_of_Seal_Block.Door_Of_Seal_Part_Block.OPEN, Boolean.valueOf(true)), 2);
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        entity.Animaitonticks = 0;
                    }
                }
            }
        }
        if(blockState.getBlock() instanceof Door_of_Seal_Block) {
            if (blockState.getValue(Door_of_Seal_Block.LIT)) {
                if (blockState.getValue(Door_of_Seal_Block.OPEN)) {
                    if (level.isClientSide) {
                        entity.openingAnimationState.stop();
                        entity.openAnimationState.startIfStopped(entity.tickCount);
                    }
                }
            }
        }
    }

    public void onHit(Level level) {
        BlockPos blockpos = this.getBlockPos();
        BlockState state = this.getBlockState();
        if (!state.getValue(Door_of_Seal_Block.LIT)) {
            level.setBlock(blockpos, state.setValue(Door_of_Seal_Block.LIT, Boolean.valueOf(true)), 2);
            this.level.blockEvent(blockpos, this.getBlockState().getBlock(), 1, 0);
        }
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        this.Animaitonticks = compound.getInt("animationTicks");

    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        compound.putInt("animationTicks", this.Animaitonticks);
    }


    public AABB getRenderBoundingBox() {
        AABB bounds = super.getRenderBoundingBox();

        bounds = bounds.expandTowards(new Vec3(facing.getClockWise().step()).scale(3));

        bounds = bounds.expandTowards(new Vec3(facing.getCounterClockWise().step()).scale(3));

        bounds = bounds.expandTowards(0, 8, 0);

        return bounds;
    }
}
