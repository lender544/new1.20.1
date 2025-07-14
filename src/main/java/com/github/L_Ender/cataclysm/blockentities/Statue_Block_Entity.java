package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

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

    public AABB getRenderBoundingBox() {
        BlockPos pos = this.getBlockPos();
        return new AABB((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), (double)pos.getX() + (double)1.0F, (double)pos.getY() + 3.0D, (double)pos.getZ() + (double)1.0F);
    }

}