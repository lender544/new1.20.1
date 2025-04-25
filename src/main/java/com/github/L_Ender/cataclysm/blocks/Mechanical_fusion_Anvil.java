package com.github.L_Ender.cataclysm.blocks;



import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.github.L_Ender.cataclysm.inventory.WeaponfusionMenu;
import com.github.L_Ender.cataclysm.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class Mechanical_fusion_Anvil extends BaseEntityBlock {
    public static final MapCodec<Mechanical_fusion_Anvil> CODEC = simpleCodec(Mechanical_fusion_Anvil::new);
    private static final Component CONTAINER_TITLE = Component.translatable("cataclysm.container.weapon_fusion");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape X_BASE = Block.box(1.0D, 0.0D, 3.0D, 15.0D, 3.0D, 13.0D);

    private static final VoxelShape Z_BASE = Block.box(3.0D, 0.0D, 1.0D, 13.0D, 3.0D, 15.0D);

    private static final VoxelShape X_LEG1 = Block.box(3.0D, 3.0D, 5.0D, 13.0D, 8.0D, 11.0D);


   // private static final VoxelShape X_LEG2 = Block.box(4.0D, 5.0D, 6.0D, 12.0D, 10.0D, 10.0D);
    private static final VoxelShape X_TOP = Block.box(1.0D, 8.0D, 0.0D, 15.0D, 13.0D, 16.0D);

    private static final VoxelShape Z_LEG1 = Block.box(5.0D, 3.0D, 3.0D, 11.0D, 8.0D, 13.0D);

    //private static final VoxelShape Z_LEG2 = Block.box(6.0D, 5.0D, 4.0D, 10.0D, 10.0D, 12.0D);
    private static final VoxelShape Z_TOP = Block.box(0.0D, 8.0D, 1.0D, 16.0D, 13.0D, 15.0D);

    private static final VoxelShape X_AXIS_AABB = Shapes.or(X_BASE, X_LEG1, X_TOP);

    private static final VoxelShape Z_AXIS_AABB = Shapes.or(Z_BASE, Z_LEG1, Z_TOP);

    @Override
    public MapCodec<Mechanical_fusion_Anvil> codec() {
        return CODEC;
    }


    public Mechanical_fusion_Anvil(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48781_) {
        return this.defaultBlockState().setValue(FACING, p_48781_.getHorizontalDirection().getClockWise());
    }

    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));
            pPlayer.awardStat(Stats.INTERACT_WITH_SMITHING_TABLE);
            return InteractionResult.CONSUME;
        }
    }

    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((i, inv, player) -> {
            return new WeaponfusionMenu(i, inv, ContainerLevelAccess.create(level, pos));
        }, CONTAINER_TITLE);
    }


    public VoxelShape getShape(BlockState p_48816_, BlockGetter p_48817_, BlockPos p_48818_, CollisionContext p_48819_) {
        Direction direction = p_48816_.getValue(FACING);
        return direction.getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    public BlockState rotate(BlockState p_48811_, Rotation p_48812_) {
        return p_48811_.setValue(FACING, p_48812_.rotate(p_48811_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(FACING);
    }

    protected boolean isPathfindable(BlockState p_51023_, PathComputationType p_51026_) {
        return false;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Mechanical_fusion_Anvil_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return createTickerHelper(p_152182_, ModTileentites.MECHANICAL_FUSION_ANVIL.get(), Mechanical_fusion_Anvil_Block_Entity::commonTick);
    }
}
