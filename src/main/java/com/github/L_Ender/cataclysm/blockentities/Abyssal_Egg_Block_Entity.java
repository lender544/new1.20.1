package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class Abyssal_Egg_Block_Entity extends BlockEntity {



    public int tickCount;

    public Abyssal_Egg_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.ABYSSAL_EGG.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, Abyssal_Egg_Block_Entity entity) {
        entity.tick();

    }

    public void tick() {
        tickCount++;

    }

}
