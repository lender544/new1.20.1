package com.github.L_Ender.cataclysm.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class MeltingNetherrack extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    public MeltingNetherrack(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    public void randomTick(BlockState p_221238_, ServerLevel p_221239_, BlockPos p_221240_, RandomSource p_221241_) {
        this.tick(p_221238_, p_221239_, p_221240_, p_221241_);
    }

    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (((randomSource.nextInt(3) == 0 && this.slightlyMelt(blockState, serverLevel, blockPos)))) {
            serverLevel.scheduleTick(blockPos, this, Mth.nextInt(randomSource, 20, 40));
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    private boolean slightlyMelt(BlockState blockState, ServerLevel level, BlockPos blockPos) {
        final int MAX_AGE_BEFORE_LAVA = 3;
        int i = blockState.getValue(AGE);
        if (i < MAX_AGE_BEFORE_LAVA) {
            level.setBlock(blockPos, blockState.setValue(AGE, Integer.valueOf(i + 1)), 2);
            return false;
        } else {
            this.melt(blockState, level, blockPos);
            return true;
        }
    }

    private void melt(BlockState blockState, ServerLevel level, BlockPos blockPos) {
        level.setBlockAndUpdate(blockPos, Blocks.LAVA.defaultBlockState());
    }
    public ItemStack getCloneItemStack(BlockGetter p_53570_, BlockPos p_53571_, BlockState p_53572_) {
        return ItemStack.EMPTY;
    }
}
