package com.github.L_Ender.cataclysm.structures;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModStructures;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Map;
import java.util.Optional;

public class Burning_Arena_Structure extends Structure {

    public static final Codec<Burning_Arena_Structure> CODEC = simpleCodec(Burning_Arena_Structure::new);

    private static final ResourceLocation ARENA1 = new ResourceLocation(Cataclysm.MODID, "burning_arena1");
    private static final ResourceLocation ARENA2 = new ResourceLocation(Cataclysm.MODID, "burning_arena2");
    private static final ResourceLocation ARENA3 = new ResourceLocation(Cataclysm.MODID, "burning_arena3");
    private static final ResourceLocation ARENA4 = new ResourceLocation(Cataclysm.MODID, "burning_arena4");
    private static final ResourceLocation ARENA5 = new ResourceLocation(Cataclysm.MODID, "burning_arena5");
    private static final ResourceLocation ARENA6 = new ResourceLocation(Cataclysm.MODID, "burning_arena6");
    private static final ResourceLocation ARENA7 = new ResourceLocation(Cataclysm.MODID, "burning_arena7");
    private static final ResourceLocation ARENA8 = new ResourceLocation(Cataclysm.MODID, "burning_arena8");

    private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.<ResourceLocation, BlockPos>builder()
            .put(ARENA1, new BlockPos(0, 1, 0))
            .put(ARENA2, new BlockPos(0, 1, 0))
            .put(ARENA3, new BlockPos(0, 1, 0))
            .put(ARENA4, new BlockPos(0, 1, 0))
            .put(ARENA5, new BlockPos(0, 1, 0))
            .put(ARENA6, new BlockPos(0, 1, 0))
            .put(ARENA7, new BlockPos(0, 1, 0))
            .put(ARENA8, new BlockPos(0, 1, 0))
            .build();


    /*
     * Begins assembling your structure and where the pieces needs to go.
     */
    public static void start(StructureTemplateManager templateManager, BlockPos pos, Rotation rotation, StructurePieceAccessor pieceList, RandomSource random) {
        int x = pos.getX();
        int z = pos.getZ();

        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA1, blockpos, rotation));

        rotationOffSet = new BlockPos(0, 0, 38).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA2, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA3, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 0, 38).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA4, blockpos, rotation));

        rotationOffSet = new BlockPos(0, 48, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA5, blockpos, rotation));

        rotationOffSet = new BlockPos(0, 48, 38).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA6, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 48, 0).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA7, blockpos, rotation));

        rotationOffSet = new BlockPos(47, 48, 38).rotate(rotation);
        blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.addPiece(new Piece(templateManager, ARENA8, blockpos, rotation));
    }

    public Burning_Arena_Structure(StructureSettings p_227593_) {
        super(p_227593_);
    }
    
    public Optional<GenerationStub> findGenerationPoint(GenerationContext p_228964_) {
        int i = p_228964_.chunkPos().x >> 16;
        int j = p_228964_.chunkPos().z >> 16;
        BlockPos blockpos = new BlockPos(p_228964_.chunkPos().getMinBlockX(), 21, p_228964_.chunkPos().getMinBlockZ());
        WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(0L));
        worldgenrandom.setSeed((long) (i ^ j << 9) ^ p_228964_.seed());
        worldgenrandom.nextInt();
        return Optional.of(new GenerationStub(blockpos, (p_228526_) -> {
            generatePieces(p_228526_, p_228964_);
        }));
    }

    private static void generatePieces(StructurePiecesBuilder p_197233_, GenerationContext p_197234_) {
        BlockPos blockpos = new BlockPos(p_197234_.chunkPos().getMinBlockX(), 21, p_197234_.chunkPos().getMinBlockZ());
        Rotation rotation = Rotation.getRandom(p_197234_.random());
        Burning_Arena_Structure.start(p_197234_.structureTemplateManager(), blockpos, rotation, p_197233_, p_197234_.random());
    }

    @Override
    public StructureType<?> type() {
        return ModStructures.BURNING_ARENA.get();
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    public static class Piece extends TemplateStructurePiece {

        public Piece(StructureTemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotation) {
            super(ModStructures.BAP.get(), 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), makeSettings(rotation), makePosition(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, CompoundTag tagCompound) {
            super(ModStructures.BAP.get(), tagCompound, templateManagerIn, (p_162451_) -> {
                return makeSettings(Rotation.valueOf(tagCompound.getString("Rot")));
            });

        }

        public Piece(StructurePieceSerializationContext context, CompoundTag tag) {
            this(context.structureTemplateManager(), tag);
        }

        private static StructurePlaceSettings makeSettings(Rotation p_163156_) {
            BlockIgnoreProcessor blockignoreprocessor = BlockIgnoreProcessor.STRUCTURE_BLOCK;

            StructurePlaceSettings structureplacesettings = (new StructurePlaceSettings()).setRotation(p_163156_).setMirror(Mirror.NONE)
                    .addProcessor(blockignoreprocessor)
                    .addProcessor(new ProtectedBlockProcessor(BlockTags.FEATURES_CANNOT_REPLACE));


            return structureplacesettings;
        }

        private static BlockPos makePosition(ResourceLocation p_162453_, BlockPos p_162454_) {
            return p_162454_.offset(OFFSET.get(p_162453_));
        }

        protected void addAdditionalSaveData(StructurePieceSerializationContext p_162444_, CompoundTag tagCompound) {
            super.addAdditionalSaveData(p_162444_, tagCompound);
            tagCompound.putString("Rot", this.placeSettings.getRotation().name());
        }


        @Override
        protected void handleDataMarker(String function, BlockPos pos, ServerLevelAccessor worldIn, RandomSource rand, BoundingBox sbb) {
            if ("revenant".equals(function)) {
                worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                Ignited_Revenant_Entity revenant = ModEntities.IGNITED_REVENANT.get().create(worldIn.getLevel());
                revenant.moveTo(pos, 180.0F, 180.0F);
                worldIn.addFreshEntity(revenant);
            }
        }
    }
}
