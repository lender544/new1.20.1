package com.github.L_Ender.cataclysm.blocks;


import com.github.L_Ender.cataclysm.blockentities.AltarOfAbyss_Block_Entity;
import com.github.L_Ender.cataclysm.blockentities.Cursed_tombstone_Entity;
import com.github.L_Ender.cataclysm.entity.Pet.AnimationPet;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class Cursed_Tombstone_Block extends BaseEntityBlock {
    public static final MapCodec<Cursed_Tombstone_Block> CODEC = simpleCodec(Cursed_Tombstone_Block::new);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private static final VoxelShape X_BASE = Block.box(5.0D, 0.0D, 0.0D, 11.0D, 2.0D, 16.0D);
    private static final VoxelShape Z_BASE = Block.box(0.0D, 0.0D, 5.0D, 16.0D, 2.0D, 11.0D);

    private static final VoxelShape X_MID = Block.box(6.0D, 2.0D, 1.0D, 10.0D, 24.0D, 15.0D);
    private static final VoxelShape Z_MID = Block.box(1.0D, 2.0D, 6.0D, 15.0D, 24.0D, 10.0D);

    private static final VoxelShape X_AXIS_AABB = Shapes.or(X_BASE, X_MID);
    private static final VoxelShape Z_AXIS_AABB = Shapes.or(Z_BASE, Z_MID);

    @Override
    public MapCodec<Cursed_Tombstone_Block> codec() {
        return CODEC;
    }

    public Cursed_Tombstone_Block(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)).setValue(POWERED, Boolean.valueOf(false)));
    }


    public BlockState getStateForPlacement(BlockPlaceContext p_48689_) {
        return this.defaultBlockState().setValue(FACING, p_48689_.getHorizontalDirection().getOpposite());
    }


    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack p_316383_, BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand p_316216_, BlockHitResult p_316827_) {
        if (state.getValue(POWERED)) {
            if (!state.getValue(LIT)) {
                state = state.setValue(LIT, Boolean.valueOf(true));
                worldIn.setBlock(pos, state, 10);
                return ItemInteractionResult.SUCCESS;
            }
        }else{
            player.displayClientMessage(Component.translatable("block.cataclysm.cursed_tombstone.message"), true);
            return ItemInteractionResult.FAIL;
        }
        return ItemInteractionResult.FAIL;
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(FACING,LIT,POWERED);
    }

    public VoxelShape getShape(BlockState p_48816_, BlockGetter p_48817_, BlockPos p_48818_, CollisionContext p_48819_) {
        Direction direction = p_48816_.getValue(FACING);
        return direction.getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Cursed_tombstone_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return createTickerHelper(p_152182_, ModTileentites.CURSED_TOMBSTONE.get(), Cursed_tombstone_Entity::commonTick);
    }

}