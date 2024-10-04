package com.github.L_Ender.cataclysm.structures;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.Koboleton_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Draugr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Elite_Draugr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
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
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProtectedBlockProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Map;

public class Frosted_Prison_Structure extends CataclysmStructure {

    public static final Codec<Frosted_Prison_Structure> CODEC = simpleCodec(Frosted_Prison_Structure::new);

    private static final ResourceLocation BOTTOM1 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_1");
    private static final ResourceLocation BOTTOM2 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_2");
    private static final ResourceLocation BOTTOM3 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_3");
    private static final ResourceLocation BOTTOM4 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_4");
    private static final ResourceLocation BOTTOM5 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_5");
    private static final ResourceLocation BOTTOM6 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_6");
    private static final ResourceLocation BOTTOM7 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_7");
    private static final ResourceLocation BOTTOM8 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_8");
    private static final ResourceLocation BOTTOM9 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_9");
    private static final ResourceLocation BOTTOM10 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_10");
    private static final ResourceLocation BOTTOM11 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_11");
    private static final ResourceLocation BOTTOM12 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_bottom_12");

    private static final ResourceLocation MID1 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_mid_1");
    private static final ResourceLocation MID2 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_mid_2");
    private static final ResourceLocation MID3 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_mid_3");
    private static final ResourceLocation MID5 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_mid_5");
    private static final ResourceLocation MID6 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_mid_6");
    private static final ResourceLocation MID7 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_mid_7");
    private static final ResourceLocation MID9 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_mid_9");
    private static final ResourceLocation MID10 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_mid_10");
    private static final ResourceLocation MID11 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_mid_11");

    private static final ResourceLocation TOP6 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_top_6");
    private static final ResourceLocation TOP7 = new ResourceLocation(Cataclysm.MODID, "frosted_prison_top_7");


    private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.<ResourceLocation, BlockPos>builder()
            .put(BOTTOM1, new BlockPos(0, 1, 0))
            .put(BOTTOM2, new BlockPos(0, 1, 0))
            .put(BOTTOM3, new BlockPos(0, 1, 0))
            .put(BOTTOM4, new BlockPos(0, 1, 0))
            .put(BOTTOM5, new BlockPos(0, 1, 0))
            .put(BOTTOM6, new BlockPos(0, 1, 0))
            .put(BOTTOM7, new BlockPos(0, 1, 0))
            .put(BOTTOM8, new BlockPos(0, 1, 0))
            .put(BOTTOM9, new BlockPos(0, 1, 0))
            .put(BOTTOM10, new BlockPos(0, 1, 0))
            .put(BOTTOM11, new BlockPos(0, 1, 0))
            .put(BOTTOM12, new BlockPos(0, 1, 0))
            .put(MID1, new BlockPos(0, 1, 0))
            .put(MID2, new BlockPos(0, 1, 0))
            .put(MID3, new BlockPos(0, 1, 0))
            .put(MID5, new BlockPos(0, 1, 0))
            .put(MID6, new BlockPos(0, 1, 0))
            .put(MID7, new BlockPos(0, 1, 0))
            .put(MID9, new BlockPos(0, 1, 0))
            .put(MID10, new BlockPos(0, 1, 0))
            .put(MID11, new BlockPos(0, 1, 0))
            .put(TOP6, new BlockPos(0, 1, 0))
            .put(TOP7, new BlockPos(0, 1, 0))
            .build();


    /*
     * Begins assembling your structure and where the pieces needs to go.
     */

    public Frosted_Prison_Structure(StructureSettings p_227593_) {
        super(p_227593_);
    }


    private static BlockPos posToSurface(ChunkGenerator generator, BlockPos pos, LevelHeightAccessor heightAccessor, RandomState state) {
        int surfaceY = generator.getBaseHeight(pos.getX(), pos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, heightAccessor, state);
        return new BlockPos(pos.getX(), surfaceY - 1, pos.getZ());
    }

    @Override
    public void generatePieces(StructurePiecesBuilder builder, GenerationContext context) {
        StructureTemplateManager templateManager = context.structureTemplateManager();
        Rotation rotation = Rotation.values()[context.random().nextInt(Rotation.values().length)];
        int x = (context.chunkPos().x << 4) + 7;
        int z = (context.chunkPos().z << 4) + 7;
        BlockPos centerPos = new BlockPos(x, 1, z);

        ChunkGenerator generator = context.chunkGenerator();
        LevelHeightAccessor heightLimitView = context.heightAccessor();

        int surfaceY = generator.getBaseHeight(centerPos.getX(), centerPos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, heightLimitView, context.randomState());
        int oceanFloorY = generator.getBaseHeight(centerPos.getX(), centerPos.getZ(), Heightmap.Types.OCEAN_FLOOR_WG, heightLimitView, context.randomState());
        if (oceanFloorY < surfaceY) return;

        BlockPos spawncenterPos = posToSurface(generator, centerPos, heightLimitView, context.randomState());

        int y = -23;

        BlockPos bottom_1 = spawncenterPos.offset(new BlockPos(-48, y, 48).rotate(rotation));

        BlockPos bottom_2 = spawncenterPos.offset(new BlockPos(0, y, 48).rotate(rotation));

        BlockPos bottom_3 = spawncenterPos.offset(new BlockPos(48, y, 48).rotate(rotation));

        BlockPos bottom_4 = spawncenterPos.offset(new BlockPos(95, y, 48).rotate(rotation));

        BlockPos bottom_5 = spawncenterPos.offset(new BlockPos(-48, y, 0).rotate(rotation));

        BlockPos bottom_6 = spawncenterPos.offset(0, y, 0);

        BlockPos bottom_7 = spawncenterPos.offset(new BlockPos(48, y, 0).rotate(rotation));

        BlockPos bottom_8 = spawncenterPos.offset(new BlockPos(95, y, 0).rotate(rotation));

        BlockPos bottom_9 = spawncenterPos.offset(new BlockPos(-48, y, -47).rotate(rotation));

        BlockPos bottom_10 = spawncenterPos.offset(new BlockPos(0, y, -47).rotate(rotation));

        BlockPos bottom_11 = spawncenterPos.offset(new BlockPos(48, y, -47).rotate(rotation));

        BlockPos bottom_12 = spawncenterPos.offset(new BlockPos(95, y, -47).rotate(rotation));

        BlockPos mid_1 = spawncenterPos.offset(new BlockPos(-48, y + 48, 48).rotate(rotation));

        BlockPos mid_2 = spawncenterPos.offset(new BlockPos(0, y + 48, 48).rotate(rotation));

        BlockPos mid_3 = spawncenterPos.offset(new BlockPos(48, y + 48, 48).rotate(rotation));

        BlockPos mid_5 = spawncenterPos.offset(new BlockPos(-48, y + 48, 0).rotate(rotation));

        BlockPos mid_6 = spawncenterPos.offset(new BlockPos(0, y + 48, 0).rotate(rotation));

        BlockPos mid_7 = spawncenterPos.offset(new BlockPos(48, y + 48, 0).rotate(rotation));

        BlockPos mid_9 = spawncenterPos.offset(new BlockPos(-48, y + 48, -47).rotate(rotation));

        BlockPos mid_10 = spawncenterPos.offset(new BlockPos(0, y + 48, -47).rotate(rotation));

        BlockPos mid_11 = spawncenterPos.offset(new BlockPos(48, y + 48, -47).rotate(rotation));

        BlockPos top_6 = spawncenterPos.offset(new BlockPos(0, y + 96, 0).rotate(rotation));

        BlockPos top_7 = spawncenterPos.offset(new BlockPos(48, y + 96, 0).rotate(rotation));


        // 9 10 11 12
      //  5  6  7  8
      //  1  2  3  4

        builder.addPiece(new Piece(templateManager, BOTTOM1, bottom_1, rotation));
        builder.addPiece(new Piece(templateManager, BOTTOM2, bottom_2, rotation));
        builder.addPiece(new Piece(templateManager, BOTTOM3, bottom_3, rotation));
        builder.addPiece(new Piece(templateManager, BOTTOM4, bottom_4, rotation));

        builder.addPiece(new Piece(templateManager, BOTTOM5, bottom_5, rotation));
        builder.addPiece(new Piece(templateManager, BOTTOM6, bottom_6, rotation));
        builder.addPiece(new Piece(templateManager, BOTTOM7, bottom_7, rotation));
        builder.addPiece(new Piece(templateManager, BOTTOM8, bottom_8, rotation));

        builder.addPiece(new Piece(templateManager, BOTTOM9, bottom_9, rotation));
        builder.addPiece(new Piece(templateManager, BOTTOM10, bottom_10, rotation));
        builder.addPiece(new Piece(templateManager, BOTTOM11, bottom_11, rotation));
        builder.addPiece(new Piece(templateManager, BOTTOM12, bottom_12, rotation));

        builder.addPiece(new Piece(templateManager, MID1, mid_1, rotation));
        builder.addPiece(new Piece(templateManager, MID2, mid_2, rotation));
        builder.addPiece(new Piece(templateManager, MID3, mid_3, rotation));
        builder.addPiece(new Piece(templateManager, MID5, mid_5, rotation));

        builder.addPiece(new Piece(templateManager, MID6, mid_6, rotation));
        builder.addPiece(new Piece(templateManager, MID7, mid_7, rotation));

        builder.addPiece(new Piece(templateManager, MID9, mid_9, rotation));


        builder.addPiece(new Piece(templateManager, MID10, mid_10, rotation));

        builder.addPiece(new Piece(templateManager, MID11, mid_11, rotation));

        builder.addPiece(new Piece(templateManager, TOP6, top_6, rotation));

        builder.addPiece(new Piece(templateManager, TOP7, top_7, rotation));
    }


    @Override
    public StructureType<?> type() {
        return ModStructures.FROSTED_PRISON.get();
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    public static class Piece extends TemplateStructurePiece {

        public Piece(StructureTemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotation) {
            super(ModStructures.FPP.get(), 0, templateManagerIn, resourceLocationIn, resourceLocationIn.toString(), makeSettings(rotation), makecenterPos(resourceLocationIn, pos));
        }

        public Piece(StructureTemplateManager templateManagerIn, CompoundTag tagCompound) {
            super(ModStructures.FPP.get(), tagCompound, templateManagerIn, (p_162451_) -> {
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

        private static BlockPos makecenterPos(ResourceLocation p_162453_, BlockPos p_162454_) {
            return p_162454_.offset(OFFSET.get(p_162453_));
        }

        protected void addAdditionalSaveData(StructurePieceSerializationContext p_162444_, CompoundTag tagCompound) {
            super.addAdditionalSaveData(p_162444_, tagCompound);
            tagCompound.putString("Rot", this.placeSettings.getRotation().name());
        }


        @Override
        protected void handleDataMarker(String function, BlockPos pos, ServerLevelAccessor worldIn, RandomSource rand, BoundingBox sbb) {
            switch (function) {
                case "draugr" -> {
                    Draugr_Entity koboleton = ModEntities.DRAUGR.get().create(worldIn.getLevel());
                    if (koboleton != null) {
                        koboleton.setPersistenceRequired();
                        koboleton.moveTo(pos, 0.0F, 0.0F);
                        koboleton.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(koboleton.blockPosition()), MobSpawnType.STRUCTURE, (SpawnGroupData) null, (CompoundTag) null);
                        worldIn.addFreshEntityWithPassengers(koboleton);
                        worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
                case "elite_draugr" -> {
                    Elite_Draugr_Entity wadjet = ModEntities.ELITE_DRAUGR.get().create(worldIn.getLevel());
                    if (wadjet != null) {
                        wadjet.setPersistenceRequired();
                        wadjet.moveTo(pos, 0.0F, 0.0F);
                        wadjet.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(wadjet.blockPosition()), MobSpawnType.STRUCTURE, (SpawnGroupData) null, (CompoundTag) null);
                        worldIn.addFreshEntityWithPassengers(wadjet);
                        worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
                case "royal_draugr" -> {
                    Royal_Draugr_Entity kobolediator = ModEntities.ROYAL_DRAUGR.get().create(worldIn.getLevel());
                    if (kobolediator != null) {
                        kobolediator.setPersistenceRequired();
                        kobolediator.moveTo(pos, 0.0F, 0.0F);
                        kobolediator.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(kobolediator.blockPosition()), MobSpawnType.STRUCTURE, (SpawnGroupData) null, (CompoundTag) null);
                        worldIn.addFreshEntityWithPassengers(kobolediator);
                        worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
                case "aptrgangr" -> {
                    Aptrgangr_Entity remnant = ModEntities.APTRGANGR.get().create(worldIn.getLevel());
                    if (remnant != null) {
                        remnant.setPersistenceRequired();
                        remnant.moveTo(pos, 0.0F, 0.0F);
                        remnant.finalizeSpawn(worldIn, worldIn.getCurrentDifficultyAt(remnant.blockPosition()), MobSpawnType.STRUCTURE, (SpawnGroupData) null, (CompoundTag) null);
                        worldIn.addFreshEntityWithPassengers(remnant);
                        worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
            }
        }
    }
}
