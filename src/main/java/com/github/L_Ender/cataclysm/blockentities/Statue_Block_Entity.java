package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class Statue_Block_Entity extends BlockEntity {



    public int tickCount;

    public Statue_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.GODDESS_STATUE.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, Statue_Block_Entity entity) {
        entity.tick();

    }

    public void tick() {
        tickCount++;

    }

}