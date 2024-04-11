package com.github.L_Ender.cataclysm.structures;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ancient_Remnant_Entity;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.Koboleton_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModStructures;
import com.github.L_Ender.cataclysm.world.structures.Processor.WaterLoggingFixProcessor;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Map;
import java.util.Optional;

public class Cursed_Pyramid_Structure extends Structure {

    public static final Codec<Cursed_Pyramid_Structure> CODEC = simpleCodec(Cursed_Pyramid_Structure::new);

    private static final ResourceLocation LOWER1 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_lower1");
    private static final ResourceLocation LOWER2 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_lower2");
    private static final ResourceLocation LOWER3 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_lower3");
    private static final ResourceLocation LOWER4 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_lower4");
    private static final ResourceLocation UPPER1 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_upper1");
    private static final ResourceLocation UPPER2 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_upper2");
    private static final ResourceLocation UPPER3 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_upper3");
    private static final ResourceLocation UPPER4 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_upper4");
    private static final ResourceLocation OBELISK1 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_obelisk1");
    private static final ResourceLocation OBELISK2 = new ResourceLocation(Cataclysm.MODID, "cursed_pyramid_obelisk2");

    private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.<ResourceLocation, BlockPos>builder()
            .put(LOWER1, new BlockPos(0, 1, 0))
            .put(LOWER2, new BlockPos(0, 1, 0))
            .put(LOWER3, new BlockPos(0, 1, 0))
            .put(LOWER4, new BlockPos(0, 1, 0))
            .put(UPPER1, new BlockPos(0, 1, 0))
            .put(UPPER2, new BlockPos(0, 1, 0))
            .put(UPPER3, new BlockPos(0, 1, 0))
            .put(UPPER4, new BlockPos(0, 1, 0))
            .put(OBELISK1, new BlockPos(0, 1, 0))
            .put(OBELISK2, new BlockPos(0, 1, 0))
            .build();


    /*
     * Begins assembling your structure and where the pieces needs to go.
     */
    public static void start(final GenerationContext context, final BlockPos position, final Rotation rotation, final StructurePieceAccessor pieceList) {
        StructureTemplateManager templateManager = context.structureTemplateManager();
        BlockPos entranceStart = position.offset(new BlockPos(20 + 2, 0, 94 + 7).rotate(rotation));

        // Make sure the entrance is on a reasonable height (this should reduce the chance of floating entrances)
        int height = context.chunkGenerator().getFirstOccupiedHeight(entranceStart.getX(), entranceStart.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
        int difference = height - entranceStart.getY();

        BlockPos obelisk1Offset = position.offset(new BlockPos(20, -4, 94).rotate(rotation)).offset(0, difference, 0);
        BlockPos obelisk2Offset = position.offset(new BlockPos(45, -4, 94).rotate(rotation)).offset(0, difference, 0);

        BlockPos lower1Offset = position.offset(0, -39, 0).offset(0, difference, 0);
        BlockPos lower2Offset = position.offset(new BlockPos(0, -39, 47).rotate(rotation)).offset(0, difference, 0);
        BlockPos lower3Offset = position.offset(new BlockPos(47, -39, 0).rotate(rotation)).offset(0, difference, 0);
        BlockPos lower4Offset = position.offset(new BlockPos(47, -39, 47).rotate(rotation)).offset(0, difference, 0);

        BlockPos upper1Offset = position.offset(0, 9, 0).offset(0, difference, 0);
        BlockPos upper2Offset = position.offset(new BlockPos(0, 9, 47).rotate(rotation)).offset(0, difference, 0);
        BlockPos upper3Offset = position.offset(new BlockPos(47, 9, 0).rotate(rotation)).offset(0, difference, 0);
        BlockPos upper4Offset = position.offset(new BlockPos(47, 9, 47).rotate(rotation)).offset(0, difference, 0);

        pieceList.addPiece(new Piece(templateManager, LOWER1, lower1Offset, rotation));
        pieceList.addPiece(new Piece(templateManager, LOWER2, lower2Offset, rotation));
        pieceList.addPiece(new Piece(templateManager, LOWER3, lower3Offset, rotation));
        pieceList.addPiece(new Piece(templateManager, LOWER4, lower4Offset, rotation));

        pieceList.addPiece(new Piece(templateManager, UPPER1, upper1Offset, rotation));
        pieceList.addPiece(new Piece(templateManager, UPPER2, upper2Offset, rotation));
        pieceList.addPiece(new Piece(templateManager, UPPER3, upper3Offset, rotation));
        pieceList.addPiece(new Piece(templateManager, UPPER4, upper4Offset, rotation));

        pieceList.addPiece(new Piece(templateManager, OBELISK1, obelisk1Offset, rotation));
        pieceList.addPiece(new Piece(templateManager, OBELISK2, obelisk2Offset, rotation));
    }

    public Cursed_Pyramid_Structure(StructureSettings p_227593_) {
        super(p_227593_);
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(final GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        int x = chunkPos.getMiddleBlockX();
        int z = chunkPos.getMiddleBlockZ();
        int y = context.chunkGenerator().getFirstFreeHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
        BlockPos position = new BlockPos(x, y, z);

        if (y < context.chunkGenerator().getSeaLevel()) {
            return Optional.empty();
        }

        return Optional.of(new GenerationStub(position, builder -> generatePieces(builder, context, position, Rotation.getRandom(context.random()))));
    }

    private void generatePieces(final StructurePiecesBuilder builder, final GenerationContext context, final BlockPos position, final Rotation rotation) {
        Cursed_Pyramid_Structure.start(context, position, rotation, builder);
    }


    @Override
    public StructureType<?> type() {
        return ModStructures.CURSED_PYRAMID.get();
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    public static class Piece extends TemplateStructurePiece {

        public Piece(StructureTemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotation) {
            super(ModStructures.CPD.get(), 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), makeSettings(rotation), makePosition(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, CompoundTag tagCompound) {
            super(ModStructures.CPD.get(), tagCompound, templateManagerIn, (p_162451_) -> {
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
                    .addProcessor(new WaterLoggingFixProcessor())
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
            switch (function) {
                case "necklace" -> {
                    worldIn.setBlock(pos, Blocks.SUSPICIOUS_SAND.defaultBlockState(), 2);
                    worldIn.getBlockEntity(pos, BlockEntityType.BRUSHABLE_BLOCK).ifPresent((blockEntity) -> {
                        ResourceLocation lootTableLocation = new ResourceLocation(Cataclysm.MODID, "archaeology/cursed_pyramid_necklace");
                        blockEntity.setLootTable(lootTableLocation, pos.asLong());
                    });
                }
                case "sus" -> {
                    worldIn.setBlock(pos, Blocks.SUSPICIOUS_SAND.defaultBlockState(), 2);
                    worldIn.getBlockEntity(pos, BlockEntityType.BRUSHABLE_BLOCK).ifPresent((blockEntity) -> {
                        ResourceLocation lootTableLocation = new ResourceLocation(Cataclysm.MODID, "archaeology/cursed_pyramid");
                        blockEntity.setLootTable(lootTableLocation, pos.asLong());
                    });
                }
                case "koboleton" -> {
                    Koboleton_Entity koboleton = ModEntities.KOBOLETON.get().create(worldIn.getLevel());
                    if (koboleton != null) {
                        koboleton.setPersistenceRequired();
                        koboleton.moveTo(pos, 0.0F, 0.0F);
                        koboleton.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(koboleton.blockPosition()), MobSpawnType.STRUCTURE, (SpawnGroupData) null, (CompoundTag) null);
                        worldIn.addFreshEntityWithPassengers(koboleton);
                        worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
                case "remnant" -> {
                    Ancient_Remnant_Entity remnant = ModEntities.ANCIENT_REMNANT.get().create(worldIn.getLevel());
                    if (remnant != null) {
                        remnant.setPersistenceRequired();
                        remnant.moveTo(pos, 0.0F, 0.0F);
                        remnant.setIsAct(false);
                        remnant.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(remnant.blockPosition()), MobSpawnType.STRUCTURE, (SpawnGroupData) null, (CompoundTag) null);
                        worldIn.addFreshEntityWithPassengers(remnant);
                        worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
            }
        }
    }
}
