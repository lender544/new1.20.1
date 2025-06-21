package com.github.L_Ender.cataclysm.init;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Cataclysm.MODID);

    public static final DeferredBlock<Block> WITHERITE_BLOCK = BLOCKS.register("witherite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                    .strength(50f, 1200f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK)));

    public static final DeferredBlock<Block> ENDERRITE_BLOCK = BLOCKS.register("enderite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                    .strength(50f, 1200f)
                    .sound(SoundType.NETHERITE_BLOCK)));

    public static final DeferredBlock<Block> IGNITIUM_BLOCK = BLOCKS.register("ignitium_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                    .strength(50f, 1200f)
                    .sound(SoundType.NETHERITE_BLOCK).lightLevel((state) -> {
                        return 15;
                    })));

    public static final DeferredBlock<Block> ANCIENT_METAL_BLOCK = BLOCKS.register("ancient_metal_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .strength(25f, 600f)
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> CURSIUM_BLOCK = BLOCKS.register("cursium_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .strength(50f, 1200f)
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> POLISHED_END_STONE = BLOCKS.register("polished_end_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));


    public static final DeferredBlock<Block> POLISHED_END_STONE_SLAB = BLOCKS.register("polished_end_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_END_STONE.get())));

    public static final DeferredBlock<Block> POLISHED_END_STONE_STAIRS = BLOCKS.register("polished_end_stone_stairs",
            () -> new StairBlock(POLISHED_END_STONE.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(POLISHED_END_STONE.get())));


    public static final DeferredBlock<Block> CHISELED_END_STONE_BRICKS = BLOCKS.register("chiseled_end_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)));

    public static final DeferredBlock<Block> VOID_INFUSED_END_STONE_BRICKS = BLOCKS.register("void_infused_end_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)
                    .lightLevel((state) -> {
                        return 7;
                    })));

    public static final DeferredBlock<Block> VOID_STONE = BLOCKS.register("void_stone",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .requiresCorrectToolForDrops()
                    .strength(50f, 1200f).lightLevel((state) -> {
                        return 7;
                    })));

    public static final DeferredBlock<Block> VOID_CRYSTAL = BLOCKS.register("void_crystal",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .sound(SoundType.GLASS)
                    .requiresCorrectToolForDrops()
                    .strength(50f, 1200f).lightLevel((state) -> {
                        return 7;
                    })));

    public static final DeferredBlock<Block> VOID_LANTERN_BLOCK = BLOCKS.register("void_lantern_block" ,
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ)
            .sound(SoundType.GLASS)
            .requiresCorrectToolForDrops()
            .strength(50f, 1200f)
            .lightLevel((state) -> {
        return 15;
    })));

    public static final DeferredBlock<Block> END_STONE_PILLAR = BLOCKS.register("end_stone_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND)
                    .requiresCorrectToolForDrops()
                    .strength(3f, 9f)));

    

    public static final DeferredBlock<Block> CHISELED_PURPUR_BLOCK = BLOCKS.register("chiseled_purpur_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));

    public static final DeferredBlock<Block> OBSIDIAN_BRICKS = BLOCKS.register("obsidian_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));

    public static final DeferredBlock<Block> POLISHED_OBSIDIAN = BLOCKS.register("polished_obsidian",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN)));

    public static final DeferredBlock<Block> CHISELED_OBSIDIAN_BRICKS = BLOCKS.register("chiseled_obsidian_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(OBSIDIAN_BRICKS.get())));

    public static final DeferredBlock<Block> OBSIDIAN_BRICK_SLAB = BLOCKS.register("obsidian_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(OBSIDIAN_BRICKS.get())));

    public static final DeferredBlock<Block> OBSIDIAN_BRICK_STAIRS = BLOCKS.register("obsidian_brick_stairs",
            () -> new StairBlock(OBSIDIAN_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(OBSIDIAN_BRICKS.get())));

    public static final DeferredBlock<Block> OBSIDIAN_BRICK_WALL = BLOCKS.register("obsidian_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(OBSIDIAN_BRICKS.get())));

    public static final DeferredBlock<Block> PURPUR_WALL = BLOCKS.register("purpur_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));

    public static final DeferredBlock<Block> PURPUR_VOID_RUNE_TRAP_BLOCK = BLOCKS.register("purpur_void_rune_trap_block",
            () -> new PurpurVoidRuneTrapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK).randomTicks().lightLevel(getLightValueLit(7))));

    public static final DeferredBlock<Block> END_STONE_TELEPORT_TRAP_BRICKS = BLOCKS.register("end_stone_teleport_trap_bricks",
            () -> new EndStoneTeleportTrapBricks(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS).randomTicks().lightLevel(getLightValueLit(7))));

    public static final DeferredBlock<Block> OBSIDIAN_EXPLOSION_TRAP_BRICKS = BLOCKS.register("obsidian_explosion_trap_bricks",
            () -> new ObsidianExplosionTrapBricks(BlockBehaviour.Properties.ofFullCopy(OBSIDIAN_BRICKS.get()).randomTicks().lightLevel(getLightValueLit(7))));

    public static final DeferredBlock<Block> SANDSTONE_POISON_DART_TRAP = BLOCKS.register("sandstone_poison_dart_trap",
            () -> new Sandstone_Poison_Dart_Trap((BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(0.8F))));

    public static final DeferredBlock<Block> SANDSTONE_IGNITE_TRAP = BLOCKS.register("sandstone_ignite_trap",
            () -> new Sandstone_Ignite_Trap(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .randomTicks()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(0.8F)));

    public static final DeferredBlock<Block> SANDSTONE_FALLING_TRAP = BLOCKS.register("sandstone_falling_trap",
            () -> new Sandstone_Falling_Trap(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .randomTicks()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(0.8F)));

    public static final DeferredBlock<Block> ALTAR_OF_FIRE = BLOCKS.register("altar_of_fire",
            () -> new Altar_Of_Fire_Block(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .lightLevel((block) -> 7)
                    .strength(-1.0F, 3600000.0F)
                    .noLootTable()
                    .sound(SoundType.METAL)));


    public static final DeferredBlock<Block> ALTAR_OF_VOID = BLOCKS.register("altar_of_void",
            () -> new Altar_Of_Void_Block(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .lightLevel((block) -> 7)
                    .strength(-1.0F, 3600000.0F)
                    .noLootTable()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> ALTAR_OF_AMETHYST = BLOCKS.register("altar_of_amethyst",
            () -> new Altar_Of_Amethyst_Block(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .lightLevel((block) -> 7)
                    .strength(-1.0F, 3600000.0F)
                    .noLootTable()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> ALTAR_OF_ABYSS = BLOCKS.register("altar_of_abyss",
           () -> new Altar_Of_Abyss_Block(BlockBehaviour.Properties.of()
                   .noOcclusion()
                   .lightLevel((block) -> 7)
                   .emissiveRendering((block, world, pos) -> true)
                   .strength(-1.0F, 3600000.0F)
                   .noLootTable()
                   .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BOSS_RESPAWNER = BLOCKS.register("boss_respawner",
            () -> new Boss_Respawn_Spawner_Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .noOcclusion()
                    .strength(-1.0F, 3600000.0F)
                    .noLootTable()
                    .sound(SoundType.STONE)));


    public static final DeferredBlock<Block> CURSED_TOMBSTONE = BLOCKS.register("cursed_tombstone",
            () -> new Cursed_Tombstone_Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .noOcclusion()
                    .strength(-1.0F, 3600000.0F)
                    .noLootTable()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DUNGEON_BLOCK = BLOCKS.register("dungeon_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(-1.0F, 3600000.0F).noLootTable()));

    public static final DeferredBlock<Block> EMP = BLOCKS.register("emp",
            () -> new EMP_Block(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .lightLevel((block) -> 7)
                    .noLootTable()
                    .strength(-1.0F, 3600000.0F)
                    .sound(SoundType.METAL)));


    public static final DeferredBlock<Block> MECHANICAL_FUSION_ANVIL = BLOCKS.register("mechanical_fusion_anvil",
            () -> new Mechanical_fusion_Anvil(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(50.0F, 1200.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.ANVIL)));

    public static final DeferredBlock<Block> GODDESS_STATUE = BLOCKS.register("goddess_statue",
            () -> new Statue_Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.QUARTZ)
                    .noOcclusion()
                    .strength(30.0F, 400.0F)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DOOR_OF_SEAL = BLOCKS.register("door_of_seal",
            () -> new Door_of_Seal_Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .noOcclusion()
                    .dynamicShape()
                    .strength(-1.0F, 3600000.0F)
                    .noLootTable()
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> DOOR_OF_SEAL_PART = BLOCKS.register("door_of_seal_part", () -> new
            Door_of_Seal_Block.Door_Of_Seal_Part_Block(BlockBehaviour.Properties.ofFullCopy(ModBlocks.DOOR_OF_SEAL.get())));

    public static final DeferredBlock<Block> KOBOLEDIATOR_SKULL = BLOCKS.register("kobolediator_skull", () -> new Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<Block> KOBOLEDIATOR_WALL_SKULL = BLOCKS.register("kobolediator_wall_skull", () -> new Wall_Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, BlockBehaviour.Properties.of().strength(1.0F).dropsLike(KOBOLEDIATOR_SKULL.get()).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<Block> APTRGANGR_HEAD = BLOCKS.register("aptrgangr_head", () -> new Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.APTRGANGR, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<Block> APTRGANGR_WALL_HEAD = BLOCKS.register("aptrgangr_wall_head", () -> new Wall_Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.APTRGANGR, BlockBehaviour.Properties.of().strength(1.0F).dropsLike(APTRGANGR_HEAD.get()).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> DRAUGR_HEAD = BLOCKS.register("draugr_head", () -> new Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.DRAUGR, BlockBehaviour.Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<Block> DRAUGR_WALL_HEAD = BLOCKS.register("draugr_wall_head", () -> new Wall_Cataclysm_Skull_Block(Cataclysm_Skull_Block.Types.DRAUGR, BlockBehaviour.Properties.of().strength(1.0F).dropsLike(APTRGANGR_HEAD.get()).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<Block> ABYSSAL_EGG = BLOCKS.register("abyssal_egg",
            () -> new Abyssal_Egg_Block(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .lightLevel((block) -> 1)
                    .pushReaction(PushReaction.DESTROY)
                    .mapColor(MapColor.COLOR_BLACK)
                    .emissiveRendering((block, world, pos) -> true)
                    .strength(3.0F, 9.0F)
                    .sound(SoundType.METAL)));


    public static final DeferredBlock<Block> CHORUS_STEM = BLOCKS.register("chorus_stem",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).
                    strength(2.0F, 3.0F)
                    .instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD)));


    public static final DeferredBlock<Block> CHORUS_PLANKS = BLOCKS.register("chorus_planks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).
                    strength(2.0F, 3.0F)
                    .instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD)));

    public static final DeferredBlock<Block> CHORUS_SLAB = BLOCKS.register("chorus_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(CHORUS_PLANKS.get())));

    public static final DeferredBlock<Block> CHORUS_STAIRS = BLOCKS.register("chorus_stairs",
            () -> new StairBlock(CHORUS_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(CHORUS_PLANKS.get())));
    
    public static final DeferredBlock<Block> CHORUS_FENCE = BLOCKS.register("chorus_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(CHORUS_PLANKS.get())));

    public static final DeferredBlock<Block> PRISMARINE_BRICK_FENCE = BLOCKS.register("prismarine_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));

    public static final DeferredBlock<Block> QUARTZ_BRICK_WALL = BLOCKS.register("quartz_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS)));

    public static final DeferredBlock<Block> PRISMARINE_BRICK_WALL = BLOCKS.register("prismarine_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));


    public static final DeferredBlock<Block> STONE_PILLAR = BLOCKS.register("stone_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));

    public static final DeferredBlock<Block> CHISELED_STONE_BRICK_PILLAR = BLOCKS.register("chiseled_stone_brick_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));

    public static final DeferredBlock<Block> STONE_TILES = BLOCKS.register("stone_tiles",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));

    public static final DeferredBlock<Block> FROSTED_STONE_BRICKS = BLOCKS.register("frosted_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));

    public static final DeferredBlock<Block> FROSTED_STONE_BRICK_SLAB = BLOCKS.register("frosted_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(FROSTED_STONE_BRICKS.get())));

    public static final DeferredBlock<Block> FROSTED_STONE_BRICK_STAIRS = BLOCKS.register("frosted_stone_brick_stairs",
            () -> new StairBlock(FROSTED_STONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(FROSTED_STONE_BRICKS.get())));

    public static final DeferredBlock<Block> FROSTED_STONE_BRICK_WALL = BLOCKS.register("frosted_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(FROSTED_STONE_BRICKS.get())));

    public static final DeferredBlock<Block> BLACK_STEEL_BLOCK = BLOCKS.register("black_steel_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                    .strength(25f, 600f)
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> BLACK_STEEL_FENCE = BLOCKS.register("black_steel_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(BLACK_STEEL_BLOCK.get())));

    public static final DeferredBlock<Block> BLACK_STEEL_WALL = BLOCKS.register("black_steel_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(BLACK_STEEL_BLOCK.get())));

    public static final DeferredBlock<Block> STONE_TILE_SLAB = BLOCKS.register("stone_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(STONE_TILES.get())));

    public static final DeferredBlock<Block> STONE_TILE_STAIRS = BLOCKS.register("stone_tile_stairs",
            () -> new StairBlock(STONE_TILES.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(STONE_TILES.get())));

    public static final DeferredBlock<Block> STONE_TILE_WALL = BLOCKS.register("stone_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(STONE_TILES.get())));

    public static final DeferredBlock<Block> POLISHED_SANDSTONE = BLOCKS.register("polished_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));

    public static final DeferredBlock<Block> BLACKSTONE_PILLAR = BLOCKS.register("blackstone_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));


    public static final DeferredBlock<Block> AZURE_SEASTONE = BLOCKS.register("azure_seastone",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));

    public static final DeferredBlock<Block> AZURE_SEASTONE_SLAB = BLOCKS.register("azure_seastone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_STAIRS = BLOCKS.register("azure_seastone_stairs",
            () -> new StairBlock(AZURE_SEASTONE.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_WALL = BLOCKS.register("azure_seastone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_FENCE = BLOCKS.register("azure_seastone_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_TILES = BLOCKS.register("azure_seastone_tiles",
            () -> new FacingBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CHISELED_AZURE_SEASTONE = BLOCKS.register("chiseled_azure_seastone",
            () -> new FacingBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_BRICKS = BLOCKS.register("azure_seastone_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_BRICK_SLAB = BLOCKS.register("azure_seastone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE_BRICKS.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_BRICK_STAIRS = BLOCKS.register("azure_seastone_brick_stairs",
            () -> new StairBlock(AZURE_SEASTONE_BRICKS.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE_BRICKS.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_BRICK_WALL = BLOCKS.register("azure_seastone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE_BRICKS.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_EMPTY = BLOCKS.register("azure_seastone_mural_empty",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_CLAWDIAN = BLOCKS.register("azure_seastone_mural_clawdian",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_CINDARIA = BLOCKS.register("azure_seastone_mural_cindaria",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_HIPPOCAMTUS = BLOCKS.register("azure_seastone_mural_hippocamtus",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_URCHINKIN = BLOCKS.register("azure_seastone_mural_urchinkin",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_THUNDER = BLOCKS.register("azure_seastone_mural_thunder",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_SEA = BLOCKS.register("azure_seastone_mural_sea",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_UNDERWORLD = BLOCKS.register("azure_seastone_mural_underworld",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_HARVEST = BLOCKS.register("azure_seastone_mural_harvest",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_SMITHING = BLOCKS.register("azure_seastone_mural_smithing",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_MURAL_WISDOM = BLOCKS.register("azure_seastone_mural_wisdom",
            () -> new Ink_Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_URCHINKIN = BLOCKS.register("curved_azure_seastone_urchinkin",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_CINDARIA_1 = BLOCKS.register("curved_azure_seastone_cindaria_1",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_CINDARIA_2 = BLOCKS.register("curved_azure_seastone_cindaria_2",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_CINDARIA_3 = BLOCKS.register("curved_azure_seastone_cindaria_3",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_CINDARIA_4 = BLOCKS.register("curved_azure_seastone_cindaria_4",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_HIPPOCAMTUS_1 = BLOCKS.register("curved_azure_seastone_hippocamtus_1",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_HIPPOCAMTUS_2 = BLOCKS.register("curved_azure_seastone_hippocamtus_2",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_HIPPOCAMTUS_3 = BLOCKS.register("curved_azure_seastone_hippocamtus_3",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_HIPPOCAMTUS_4 = BLOCKS.register("curved_azure_seastone_hippocamtus_4",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_CLAWDIAN_1 = BLOCKS.register("curved_azure_seastone_clawdian_1",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_CLAWDIAN_2 = BLOCKS.register("curved_azure_seastone_clawdian_2",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_CLAWDIAN_3 = BLOCKS.register("curved_azure_seastone_clawdian_3",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_CLAWDIAN_4 = BLOCKS.register("curved_azure_seastone_clawdian_4",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_1 = BLOCKS.register("curved_azure_seastone_scylla_1",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_2 = BLOCKS.register("curved_azure_seastone_scylla_2",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_3 = BLOCKS.register("curved_azure_seastone_scylla_3",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_4 = BLOCKS.register("curved_azure_seastone_scylla_4",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_5 = BLOCKS.register("curved_azure_seastone_scylla_5",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_6 = BLOCKS.register("curved_azure_seastone_scylla_6",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_7 = BLOCKS.register("curved_azure_seastone_scylla_7",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_8 = BLOCKS.register("curved_azure_seastone_scylla_8",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CURVED_SEASTONE_SCYLLA_9 = BLOCKS.register("curved_azure_seastone_scylla_9",
            () -> new Mural_Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> POLISHED_AZURE_SEASTONE = BLOCKS.register("polished_azure_seastone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> POLISHED_AZURE_SEASTONE_SLAB = BLOCKS.register("polished_azure_seastone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> POLISHED_AZURE_SEASTONE_STAIRS = BLOCKS.register("polished_azure_seastone_stairs",
            () -> new StairBlock(POLISHED_AZURE_SEASTONE.get().defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(POLISHED_AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> POLISHED_AZURE_SEASTONE_WALL = BLOCKS.register("polished_azure_seastone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_PILLAR = BLOCKS.register("azure_seastone_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> AZURE_SEASTONE_PILLAR_WALL = BLOCKS.register("azure_seastone_pillar_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CHISELED_AZURE_SEASTONE_PILLAR = BLOCKS.register("chiseled_azure_seastone_pillar",
            () -> new FacingPillarBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));

    public static final DeferredBlock<Block> CHISELED_AZURE_SEASTONE_PILLAR_WALL = BLOCKS.register("chiseled_azure_seastone_pillar_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(AZURE_SEASTONE.get())));


    public static final DeferredBlock<Block> POINTED_ICICLE = BLOCKS.register("pointed_icicle",
            () -> new PointedIcicleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.ICE)
                    .forceSolidOn().instrument(NoteBlockInstrument.CHIME)
                    .noOcclusion()
                    .randomTicks()
                    .sound(SoundType.GLASS)
                    .strength(0.5F)
                    .dynamicShape()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }
}
