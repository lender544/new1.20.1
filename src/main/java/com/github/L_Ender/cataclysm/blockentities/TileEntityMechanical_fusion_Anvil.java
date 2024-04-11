package com.github.L_Ender.cataclysm.blockentities;


import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityMechanical_fusion_Anvil extends BlockEntity {



    public int tickCount;

    public TileEntityMechanical_fusion_Anvil(BlockPos pos, BlockState state) {
        super(ModTileentites.MECHANICAL_FUSION_ANVIL.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, TileEntityMechanical_fusion_Anvil entity) {
        entity.tick();

    }

    public void tick() {
        tickCount++;

    }

}
