package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.blockentities.Abyssal_Egg_Block_Entity;
import com.github.L_Ender.cataclysm.entity.Pet.The_Baby_Leviathan_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class Abyssal_Egg_Block extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final int MAX_HATCH_LEVEL = 2;
    public static final IntegerProperty HATCH = BlockStateProperties.HATCH;
    private static final int REGULAR_HATCH_TIME_TICKS = 12000;
    private static final int RANDOM_HATCH_OFFSET_TICKS = 300;
    private static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    public Abyssal_Egg_Block() {
        super(Properties.of()
                .noOcclusion()
                .lightLevel((block) -> 1)
                .pushReaction(PushReaction.DESTROY)
                .mapColor(MapColor.COLOR_BLACK)
                .emissiveRendering((block, world, pos) -> true)
                .strength(3.0F, 9.0F)
                .sound(SoundType.METAL));
        this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, Integer.valueOf(0)).setValue(WATERLOGGED, Boolean.FALSE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_277441_) {
        p_277441_.add(HATCH,WATERLOGGED);
    }

    public VoxelShape getShape(BlockState p_277872_, BlockGetter p_278090_, BlockPos p_277364_, CollisionContext p_278016_) {
        return SHAPE;
    }

    public FluidState getFluidState(BlockState p_51581_) {
        return p_51581_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_51581_);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48781_) {
        FluidState fluidstate = p_48781_.getLevel().getFluidState(p_48781_.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    public BlockState updateShape(BlockState p_51555_, Direction p_51556_, BlockState p_51557_, LevelAccessor p_51558_, BlockPos p_51559_, BlockPos p_51560_) {
        if (p_51555_.getValue(WATERLOGGED)) {
            p_51558_.scheduleTick(p_51559_, Fluids.WATER, Fluids.WATER.getTickDelay(p_51558_));
        }
        return super.updateShape(p_51555_, p_51556_, p_51557_, p_51558_, p_51559_, p_51560_);
    }

    public int getHatchLevel(BlockState p_279125_) {
        return p_279125_.getValue(HATCH);
    }

    private boolean isReadyToHatch(BlockState p_278021_) {
        return this.getHatchLevel(p_278021_) == 2;
    }

    public void tick(BlockState p_277841_, ServerLevel p_277739_, BlockPos p_277692_, RandomSource p_277973_) {
        if (!this.isReadyToHatch(p_277841_)) {
            p_277739_.playSound((Player)null, p_277692_, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 0.7F, 0.9F + p_277973_.nextFloat() * 0.2F);
            p_277739_.setBlock(p_277692_, p_277841_.setValue(HATCH, Integer.valueOf(this.getHatchLevel(p_277841_) + 1)), 2);
        } else {
            p_277739_.playSound((Player)null, p_277692_, SoundEvents.TURTLE_EGG_HATCH, SoundSource.BLOCKS, 0.7F, 0.9F + p_277973_.nextFloat() * 0.2F);
            p_277739_.destroyBlock(p_277692_, false);
            The_Baby_Leviathan_Entity levia = ModEntities.THE_BABY_LEVIATHAN.get().create(p_277739_);
            if (levia != null) {
                levia.moveTo((double)p_277692_.getX() + 0.5D, (double)p_277692_.getY() + 0.5D, (double)p_277692_.getZ() + 0.5D, Mth.wrapDegrees(p_277739_.random.nextFloat() * 360.0F), 0.0F);
                p_277739_.addFreshEntity(levia);
            }

        }
    }

    public void onPlace(BlockState p_277964_, Level p_277827_, BlockPos p_277526_, BlockState p_277618_, boolean p_277819_) {
        int j = REGULAR_HATCH_TIME_TICKS / 3;
        p_277827_.gameEvent(GameEvent.BLOCK_PLACE, p_277526_, GameEvent.Context.of(p_277964_));
        p_277827_.scheduleTick(p_277526_, this, j + p_277827_.random.nextInt(RANDOM_HATCH_OFFSET_TICKS));
    }

    public boolean isPathfindable(BlockState p_279414_, BlockGetter p_279243_, BlockPos p_279294_, PathComputationType p_279299_) {
        return false;
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Abyssal_Egg_Block_Entity(pos, state);
    }


    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return createTickerHelper(p_152182_, ModTileentites.ABYSSAL_EGG.get(), Abyssal_Egg_Block_Entity::commonTick);
    }
}