package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.blockentities.Cataclysm_Skull_BlockEntity;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

import javax.annotation.Nullable;


public abstract class Abstract_Cataclysm_Skull_Block extends BaseEntityBlock implements Equipable {
    private final Cataclysm_Skull_Block.Type type;

    public Abstract_Cataclysm_Skull_Block(Cataclysm_Skull_Block.Type p_48745_, BlockBehaviour.Properties p_48746_) {
        super(p_48746_);
        this.type = p_48745_;
    }

    public BlockEntity newBlockEntity(BlockPos p_151996_, BlockState p_151997_) {
        return new Cataclysm_Skull_BlockEntity(p_151996_, p_151997_);
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

    public Cataclysm_Skull_Block.Type getType() {
        return this.type;
    }

    public boolean isPathfindable(BlockState p_48750_, BlockGetter p_48751_, BlockPos p_48752_, PathComputationType p_48753_) {
        return false;
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}
