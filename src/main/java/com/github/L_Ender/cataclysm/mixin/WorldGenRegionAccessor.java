package com.github.L_Ender.cataclysm.mixin;

import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(WorldGenRegion.class)
public interface WorldGenRegionAccessor {
    @Accessor("structureManager")
    StructureManager getStructureManager();

    @Accessor
    List<ChunkAccess> getCache();

    @Accessor
    ChunkPos getFirstPos();

    @Accessor
    ChunkPos getLastPos();

    @Accessor
    int getSize();
}
