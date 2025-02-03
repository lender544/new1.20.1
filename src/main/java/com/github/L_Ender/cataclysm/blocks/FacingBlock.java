package com.github.L_Ender.cataclysm.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class FacingBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<FacingBlock> CODEC = simpleCodec(FacingBlock::new);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;


    @Override
    public MapCodec<FacingBlock> codec() {
        return CODEC;
    }

    public FacingBlock(Properties p_49046_) {
        super(p_49046_);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49088_) {
        p_49088_.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
