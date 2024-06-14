package com.github.L_Ender.cataclysm.structures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Optional;
import java.util.Set;

public abstract class CataclysmStructure extends Structure {
    private Set<Holder<Biome>> allowedBiomes;
    private boolean doCheckHeight;
    private boolean doAvoidWater;
    private boolean doAvoidStructures;

    public CataclysmStructure(StructureSettings settings, Set<Holder<Biome>> allowedBiomes, boolean doCheckHeight, boolean doAvoidWater, boolean doAvoidStructures) {
        super(settings);
        this.allowedBiomes = allowedBiomes;
        this.doCheckHeight = doCheckHeight;
        this.doAvoidWater = doAvoidWater;
        this.doAvoidStructures = doAvoidStructures;
    }

    public CataclysmStructure(StructureSettings settings, Set<Holder<Biome>> allowedBiomes) {
        this(settings, allowedBiomes, true, true, true);
    }

    public CataclysmStructure(StructureSettings settings) {
        super(settings);
    }
    
    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
    	if(this.checkLocation(context)) {
    		return onTopOfChunkCenter(context, Heightmap.Types.WORLD_SURFACE_WG, (builder) -> {
    			this.generatePieces(builder, context);
    		});
    	}
    	return Optional.empty();
    }
    
    public void generatePieces(StructurePiecesBuilder builder, GenerationContext context) {
    	
    }
    
    public boolean checkLocation(GenerationContext context) {
    	return this.checkLocation(context, allowedBiomes, doCheckHeight, doAvoidWater, doAvoidStructures);
    }

    protected boolean checkLocation(GenerationContext context, Set<Holder<Biome>> allowedBiomes, boolean checkHeight, boolean avoidWater, boolean avoidStructures) {
        ChunkPos chunkPos = context.chunkPos();
        BlockPos centerOfChunk = new BlockPos((chunkPos.x << 4) + 7, 0, (chunkPos.z << 4) + 7);

//        int i = chunkPos.getMiddleBlockX();
//        int j = chunkPos.getMiddleBlockZ();
//        int k = context.chunkGenerator().getFirstOccupiedHeight(i, j, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
//        Holder<Biome> biome = context.chunkGenerator().getBiomeSource().getNoiseBiome(QuartPos.fromBlock(i), QuartPos.fromBlock(k), QuartPos.fromBlock(j), context.randomState().sampler());
//        if (!allowedBiomes.contains(biome)) {
//            return false;
//        }
//
//        if (checkHeight) {
//        	double minHeight = config.heightMin.get();
//            double maxHeight = config.heightMax.get();
//            int landHeight = getLowestY(context, 16, 16);
//            if (minHeight != -65 && landHeight < minHeight) return false;
//            if (maxHeight != -65 && landHeight > maxHeight) return false;
//        }

        if (avoidWater) {
            ChunkGenerator chunkGenerator = context.chunkGenerator();
            LevelHeightAccessor heightLimitView = context.heightAccessor();
            int centerHeight = chunkGenerator.getBaseHeight(centerOfChunk.getX(), centerOfChunk.getZ(), Heightmap.Types.WORLD_SURFACE_WG, heightLimitView, context.randomState());
            NoiseColumn columnOfBlocks = chunkGenerator.getBaseColumn(centerOfChunk.getX(), centerOfChunk.getZ(), heightLimitView, context.randomState());
            BlockState topBlock = columnOfBlocks.getBlock(centerHeight);
            if (!topBlock.getFluidState().isEmpty()) return false;
        }

        return true;
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

}
