package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.github.L_Ender.cataclysm.blockentities.AltarOfVoid_Block_Entity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class Altar_Of_Void_Block extends BaseEntityBlock {
    public static final MapCodec<Altar_Of_Void_Block> CODEC = simpleCodec(Altar_Of_Void_Block::new);
    private static final VoxelShape BASE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 4.0D, 15.0D);
    private static final VoxelShape MID = Block.box(2.0D, 4.0D, 2.0D, 14.0D, 10.0D, 14.0D);
    private static final VoxelShape TOP = Block.box(0.0D, 10.0D, 0.0D, 16.0D, 14.0D, 16.0D);
    private static final VoxelShape AXIS_AABB = Shapes.or(BASE,MID, TOP);

    @Override
    public MapCodec<Altar_Of_Void_Block> codec() {
        return CODEC;
    }


    public Altar_Of_Void_Block(BlockBehaviour.Properties p_54257_) {
        super(p_54257_);

    }

    public VoxelShape getShape(BlockState p_48816_, BlockGetter p_48817_, BlockPos p_48818_, CollisionContext p_48819_) {
        return AXIS_AABB;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AltarOfVoid_Block_Entity(pos, state);
    }


    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return createTickerHelper(p_152182_, ModTileentites.ALTAR_OF_VOID.get(), AltarOfVoid_Block_Entity::commonTick);
    }
}