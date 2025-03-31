package com.github.L_Ender.cataclysm.blocks;


import com.github.L_Ender.cataclysm.blockentities.AltarOfAmethyst_Block_Entity;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class Altar_Of_Amethyst_Block extends BaseEntityBlock {
    public static final MapCodec<Altar_Of_Amethyst_Block> CODEC = simpleCodec(Altar_Of_Amethyst_Block::new);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final VoxelShape BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);
    private static final VoxelShape MID = Block.box(2.0D, 3.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    private static final VoxelShape TOP = Block.box(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape AXIS_AABB = Shapes.or(BASE,MID, TOP);
    public static final int MINIMUM_COOKING_TIME = 60;
    @Override
    public MapCodec<Altar_Of_Amethyst_Block> codec() {
        return CODEC;
    }

    public Altar_Of_Amethyst_Block(Properties p_54257_) {
        super(p_54257_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_48781_) {
        return this.defaultBlockState().setValue(FACING, p_48781_.getHorizontalDirection().getClockWise());
    }

    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity tileEntity = level.getBlockEntity(pos);
        if (tileEntity instanceof AltarOfAmethyst_Block_Entity skilletEntity) {
            if (!level.isClientSide) {
                ItemStack heldStack = player.getItemInHand(hand);
                EquipmentSlot heldSlot = hand.equals(InteractionHand.MAIN_HAND) ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                if (heldStack.isEmpty()) {
                    ItemStack extractedStack = skilletEntity.removeItem();
                    if (!player.isCreative()) {
                        player.setItemSlot(heldSlot, extractedStack);
                    }
                    return ItemInteractionResult.SUCCESS;
                } else {
                    ItemStack remainderStack = skilletEntity.addItemToCook(heldStack, player);
                    if (remainderStack.getCount() != heldStack.getCount()) {
                        if (!player.isCreative()) {
                            player.setItemSlot(heldSlot, remainderStack);
                        }
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }
            return ItemInteractionResult.CONSUME;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public BlockState rotate(BlockState p_48811_, Rotation p_48812_) {
        return p_48811_.setValue(FACING, p_48812_.rotate(p_48811_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(FACING);
    }

    public VoxelShape getShape(BlockState p_48816_, BlockGetter p_48817_, BlockPos p_48818_, CollisionContext p_48819_) {
        return AXIS_AABB;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AltarOfAmethyst_Block_Entity(pos, state);
    }


    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return  createTickerHelper(blockEntityType, ModTileentites.ALTAR_OF_AMETHYST.get(), AltarOfAmethyst_Block_Entity::cookingTick);

    }

    public static int getCookingTime(int originalCookingTime) {
        int cookingTime = originalCookingTime > 0 ? originalCookingTime : 600;
        int cookingSeconds = cookingTime / 20;
        float cookingTimeReduction = 0.2F;

        int result = (int) (cookingSeconds * cookingTimeReduction) * 20;

        return Mth.clamp(result, MINIMUM_COOKING_TIME, originalCookingTime);
    }

}