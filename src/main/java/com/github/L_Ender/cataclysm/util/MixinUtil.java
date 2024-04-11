package com.github.L_Ender.cataclysm.util;

import com.github.L_Ender.cataclysm.mixin.StructureManagerAccessor;
import com.github.L_Ender.cataclysm.mixin.WorldGenRegionAccessor;
import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Util methods taken from vanilla, with slight tweaks to prevent log spam.
 */
public class MixinUtil {
    public static StructureStart getStructureAt(StructureManager structureManager, BlockPos pos, Structure structure) {
        for (StructureStart structurestart : startsForStructure(structureManager, SectionPos.of(pos), structure)) {
            if (structurestart.getBoundingBox().isInside(pos)) {
                return structurestart;
            }
        }

        return StructureStart.INVALID_START;
    }

    private static List<StructureStart> startsForStructure(StructureManager structureManager, SectionPos sectionPos, Structure structure) {
        LongSet longset = ((StructureManagerAccessor) structureManager).getLevel().getChunk(sectionPos.x(), sectionPos.z(), ChunkStatus.STRUCTURE_REFERENCES).getReferencesForStructure(structure);
        ImmutableList.Builder<StructureStart> builder = ImmutableList.builder();
        fillStartsForStructure(structureManager, structure, longset, builder::add);
        return builder.build();
    }

    private static void fillStartsForStructure(StructureManager structureManager, Structure structure, LongSet longSet, Consumer<StructureStart> consumer) {
        for (long i : longSet) {
            SectionPos sectionpos = SectionPos.of(new ChunkPos(i), ((StructureManagerAccessor) structureManager).getLevel().getMinSection());
            Optional<ChunkAccess> structureAccess = getChunk((WorldGenRegion) ((StructureManagerAccessor) structureManager).getLevel(), sectionpos.x(), sectionpos.z());
            if (structureAccess.isPresent()) {
                StructureStart structurestart = structureManager.getStartForStructure(sectionpos, structure, structureAccess.get());
                if (structurestart != null && structurestart.isValid()) {
                    consumer.accept(structurestart);
                }
            }
        }
    }

    private static Optional<ChunkAccess> getChunk(WorldGenRegion worldGenRegion, int chunkX, int chunkZ) {
        WorldGenRegionAccessor accessor = ((WorldGenRegionAccessor) worldGenRegion);
        if (worldGenRegion.hasChunk(chunkX, chunkZ)) {
            int i = chunkX - accessor.getFirstPos().x;
            int j = chunkZ - accessor.getFirstPos().z;
            ChunkAccess chunkAccess = accessor.getCache().get(i + j * accessor.getSize());
            if (chunkAccess.getStatus().isOrAfter(ChunkStatus.STRUCTURE_STARTS)) {
                return Optional.of(chunkAccess);
            }
        }

        return Optional.empty();
    }
}
