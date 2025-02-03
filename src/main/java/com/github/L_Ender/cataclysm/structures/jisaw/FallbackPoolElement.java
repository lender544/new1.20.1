package com.github.L_Ender.cataclysm.structures.jisaw;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Collections;
import java.util.List;

public class FallbackPoolElement extends StructurePoolElement {
    public static final MapCodec<FallbackPoolElement> CODEC = MapCodec.unit(() -> {
        return FallbackPoolElement.INSTANCE;
    });
    public static final FallbackPoolElement INSTANCE = new FallbackPoolElement();

    private FallbackPoolElement() {
        super(StructureTemplatePool.Projection.TERRAIN_MATCHING);
    }

    public Vec3i getSize(StructureTemplateManager p_210191_, Rotation p_210192_) {
        return Vec3i.ZERO;
    }

    public List<StructureTemplate.StructureBlockInfo> getShuffledJigsawBlocks(StructureTemplateManager p_210198_, BlockPos p_210199_, Rotation p_210200_, RandomSource p_210201_) {
        return Collections.emptyList();
    }

    public BoundingBox getBoundingBox(StructureTemplateManager p_210194_, BlockPos p_210195_, Rotation p_210196_) {
        throw new IllegalStateException("Invalid call to MowzieFallbackElement.getBoundingBox, filter me!");
    }

    public boolean place(StructureTemplateManager p_227336_, WorldGenLevel p_227337_, StructureManager p_227338_, ChunkGenerator p_227339_, BlockPos p_227340_, BlockPos p_227341_, Rotation p_227342_, BoundingBox p_227343_, RandomSource p_227344_, LiquidSettings p_352159_, boolean p_227345_) {
        return true;
    }


    public StructurePoolElementType<?> getType() {
        return StructurePoolElementType.EMPTY;
    }

    public String toString() {
        return "Fallback";
    }
}
