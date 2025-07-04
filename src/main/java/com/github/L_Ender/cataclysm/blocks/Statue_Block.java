package com.github.L_Ender.cataclysm.blocks;


import com.github.L_Ender.cataclysm.blockentities.Statue_Block_Entity;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class Statue_Block extends BaseEntityBlock {


    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;


    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;



    protected static final VoxelShape NORTH_AABB = Block.box(2.0, 0.0, 6.0, 14.0, 16.0, 13.0);
    protected static final VoxelShape WEST_AABB = Block.box(6.0, 0.0, 2.0, 13.0, 16.0, 14.0);


    protected static final VoxelShape EAST_AABB = Block.box(3.0, 0.0, 2.0, 10.0, 16.0, 14.0);

    protected static final VoxelShape SOUTH_SHAPE = Block.box(2.0, 0.0, 3.0, 14.0, 16.0, 10.0);



    public Statue_Block() {
        super(Properties.of()
                .mapColor(MapColor.QUARTZ)
                .noOcclusion()
                .strength(30.0F, 400.0F)
                .sound(SoundType.STONE));
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER));
    }



    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }


    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        DoubleBlockHalf half = state.getValue(HALF);

        if (facing.getAxis() == Direction.Axis.Y) {
            if (half == DoubleBlockHalf.UPPER && facing == Direction.DOWN) {
                if (!(facingState.getBlock() instanceof Statue_Block) || facingState.getValue(HALF) != DoubleBlockHalf.LOWER) {
                    return Blocks.AIR.defaultBlockState();
                }
            } else if (half == DoubleBlockHalf.LOWER && facing == Direction.UP) {
                if (!(facingState.getBlock() instanceof Statue_Block) || facingState.getValue(HALF) != DoubleBlockHalf.UPPER) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
        }

        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(context)) {
            return this.defaultBlockState()
                    .setValue(FACING, context.getHorizontalDirection().getOpposite())
                    .setValue(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);

        return switch (direction) {
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_AABB;
            case NORTH -> NORTH_AABB;
            default -> EAST_AABB;
        };
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(FACING,HALF);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && (player.isCreative() || !player.hasCorrectToolForDrops(state))) {
            preventDropFromBottomPart(level, pos, state, player);
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    private void preventDropFromBottomPart(Level level, BlockPos pos, BlockState state, Player player) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pos.below();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(state.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockpos, blockstate1, 35);
                level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }


    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = level.getBlockState(blockpos);
        return state.getValue(HALF) == DoubleBlockHalf.LOWER ? blockstate.isFaceSturdy(level, blockpos, Direction.UP) : blockstate.is(this);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    public long getSeed(BlockState state, BlockPos pos) {
        return Mth.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }


    public boolean isPathfindable(BlockState p_49510_, BlockGetter p_49511_, BlockPos p_49512_, PathComputationType p_49513_) {
        return false;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Statue_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return createTickerHelper(p_152182_, ModTileentites.GODDESS_STATUE.get(), Statue_Block_Entity::commonTick);
    }
}
