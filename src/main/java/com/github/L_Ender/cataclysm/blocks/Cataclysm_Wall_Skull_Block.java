package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.blockentities.Cataclysm_Skull_BlockEntity;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class Cataclysm_Wall_Skull_Block extends WallSkullBlock {

    public Cataclysm_Wall_Skull_Block(SkullBlock.Type type, Properties props) {
        super(type, props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Cataclysm_Skull_BlockEntity(pos, state);
    }


    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_151992_, BlockState p_151993_, BlockEntityType<T> p_151994_) {
        if (p_151992_.isClientSide) {
            boolean flag = p_151993_.is(ModBlocks.APTRGANGR_HEAD.get()) || p_151993_.is(ModBlocks.APTRGANGR_WALL_HEAD.get()) || p_151993_.is(ModBlocks.KOBOLEDIATOR_SKULL.get()) || p_151993_.is(ModBlocks.KOBOLEDIATOR_WALL_SKULL.get());
            if (flag) {
                return createTickerHelper(p_151994_, ModTileentites.CATACLYSM_SKULL.get(), Cataclysm_Skull_BlockEntity::animation);
            }
        }

        return null;
    }
}
