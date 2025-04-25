package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.Mural_Block;
import com.github.L_Ender.cataclysm.items.*;
import com.github.L_Ender.cataclysm.items.CuriosItem.AttributeContainer;
import com.github.L_Ender.cataclysm.items.CuriosItem.Blazing_Grips;
import com.github.L_Ender.cataclysm.items.CuriosItem.Chitin_Claw;
import com.github.L_Ender.cataclysm.items.CuriosItem.Sticky_Gloves;
import com.github.L_Ender.cataclysm.items.Dungeon_Eye.*;
import net.minecraft.core.BlockPos;

import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluids;

import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cataclysm.MODID);
    
    
    public static final DeferredItem<BlockItem> ENDERITE_BLOCK = ITEMS.register("enderite_block",
            () -> new BlockItem(ModBlocks.ENDERRITE_BLOCK.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> WITHERITE_BLCOK = ITEMS.register("witherite_block",
            () -> new BlockItem(ModBlocks.WITHERITE_BLOCK.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> IGNITIUM_BLOCK = ITEMS.register("ignitium_block",
            () -> new BlockItem(ModBlocks.IGNITIUM_BLOCK.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> ANCIENT_METAL_BLOCK = ITEMS.register("ancient_metal_block",
            () -> new BlockItem(ModBlocks.ANCIENT_METAL_BLOCK.get(), new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<BlockItem> CURSIUM_BLOCK = ITEMS.register("cursium_block",
            () -> new BlockItem(ModBlocks.CURSIUM_BLOCK.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> DUNGEON_BLOCK = ITEMS.register("dungeon_block",
            () -> new BlockItem(ModBlocks.DUNGEON_BLOCK.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> POLISHED_SANDSTONE = ITEMS.register("polished_sandstone",
            () -> new BlockItem(ModBlocks.POLISHED_SANDSTONE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> POLISHED_END_STONE = ITEMS.register("polished_end_stone",
            () -> new BlockItem(ModBlocks.POLISHED_END_STONE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> POLISHED_END_STONE_SLAB = ITEMS.register("polished_end_stone_slab",
            () -> new BlockItem(ModBlocks.POLISHED_END_STONE_SLAB.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> POLISHED_END_STONE_STAIRS = ITEMS.register("polished_end_stone_stairs",
            () -> new BlockItem(ModBlocks.POLISHED_END_STONE_STAIRS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHISELED_END_STONE_BRICKS = ITEMS.register("chiseled_end_stone_bricks",
            () -> new BlockItem(ModBlocks.CHISELED_END_STONE_BRICKS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> END_STONE_PILLAR = ITEMS.register("end_stone_pillar",
            () -> new BlockItem(ModBlocks.END_STONE_PILLAR.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> VOID_INFUSED_END_STONE_BRICKS = ITEMS.register("void_infused_end_stone_bricks",
            () -> new BlockItem(ModBlocks.VOID_INFUSED_END_STONE_BRICKS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> VOID_STONE = ITEMS.register("void_stone",
            () -> new BlockItem(ModBlocks.VOID_STONE.get(), new Item.Properties().fireResistant()));

    public static final DeferredItem<BlockItem> VOID_CRYSTAL = ITEMS.register("void_crystal",
            () -> new BlockItem(ModBlocks.VOID_CRYSTAL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> VOID_LANTERN_BLOCK = ITEMS.register("void_lantern_block",
            () -> new BlockItem(ModBlocks.VOID_LANTERN_BLOCK.get(), new Item.Properties().fireResistant()));

    public static final DeferredItem<BlockItem> OBSIDIAN_BRICKS = ITEMS.register("obsidian_bricks",
            () -> new BlockItem(ModBlocks.OBSIDIAN_BRICKS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> POLISHED_OBSIDIAN = ITEMS.register("polished_obsidian",
            () -> new BlockItem(ModBlocks.POLISHED_OBSIDIAN.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHISELED_OBSIDIAN_BRICKS = ITEMS.register("chiseled_obsidian_bricks",
            () -> new BlockItem(ModBlocks.CHISELED_OBSIDIAN_BRICKS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_SLAB = ITEMS.register("obsidian_brick_slab",
            () -> new BlockItem(ModBlocks.OBSIDIAN_BRICK_SLAB.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_STAIRS = ITEMS.register("obsidian_brick_stairs",
            () -> new BlockItem(ModBlocks.OBSIDIAN_BRICK_STAIRS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> OBSIDIAN_BRICK_WALL = ITEMS.register("obsidian_brick_wall",
            () -> new BlockItem(ModBlocks.OBSIDIAN_BRICK_WALL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHISELED_PURPUR_BLOCK = ITEMS.register("chiseled_purpur_block",
            () -> new BlockItem(ModBlocks.CHISELED_PURPUR_BLOCK.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> PURPUR_WALL = ITEMS.register("purpur_wall",
            () -> new BlockItem(ModBlocks.PURPUR_WALL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> PURPUR_VOID_RUNE_TRAP_BLOCK = ITEMS.register("purpur_void_rune_trap_block",
            () -> new BlockItem(ModBlocks.PURPUR_VOID_RUNE_TRAP_BLOCK.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> END_STONE_TELEPORT_TRAP_BRICKS = ITEMS.register("end_stone_teleport_trap_bricks",
            () -> new BlockItem(ModBlocks.END_STONE_TELEPORT_TRAP_BRICKS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> OBSIDIAN_EXPLOSION_TRAP_BRICKS = ITEMS.register("obsidian_explosion_trap_bricks",
            () -> new BlockItem(ModBlocks.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> SANDSTONE_POISON_DART_TRAP = ITEMS.register("sandstone_poison_dart_trap",
            () -> new BlockItem(ModBlocks.SANDSTONE_POISON_DART_TRAP.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> SANDSTONE_IGNITE_TRAP = ITEMS.register("sandstone_ignite_trap",
            () -> new BlockItem(ModBlocks.SANDSTONE_IGNITE_TRAP.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> SANDSTONE_FALLING_TRAP = ITEMS.register("sandstone_falling_trap",
            () -> new BlockItem(ModBlocks.SANDSTONE_FALLING_TRAP.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHORUS_STEM = ITEMS.register("chorus_stem",
            () -> new BlockItem(ModBlocks.CHORUS_STEM.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHORUS_PLANKS = ITEMS.register("chorus_planks",
            () -> new BlockItem(ModBlocks.CHORUS_PLANKS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHORUS_SLAB = ITEMS.register("chorus_slab",
            () -> new BlockItem(ModBlocks.CHORUS_SLAB.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHORUS_STAIRS = ITEMS.register("chorus_stairs",
            () -> new BlockItem(ModBlocks.CHORUS_STAIRS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHORUS_FENCE = ITEMS.register("chorus_fence",
            () -> new BlockItem(ModBlocks.CHORUS_FENCE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> PRISMARINE_BRICK_FENCE = ITEMS.register("prismarine_brick_fence",
            () -> new BlockItem(ModBlocks.PRISMARINE_BRICK_FENCE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> QUARTZ_BRICK_WALL = ITEMS.register("quartz_brick_wall",
            () -> new BlockItem(ModBlocks.QUARTZ_BRICK_WALL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> PRISMARINE_BRICK_WALL = ITEMS.register("prismarine_brick_wall",
            () -> new BlockItem(ModBlocks.PRISMARINE_BRICK_WALL.get(), new Item.Properties()));


    public static final DeferredItem<BlockItem> STONE_PILLAR = ITEMS.register("stone_pillar",
            () -> new BlockItem(ModBlocks.STONE_PILLAR.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHISELED_STONE_BRICK_PILLAR = ITEMS.register("chiseled_stone_brick_pillar",
            () -> new BlockItem(ModBlocks.CHISELED_STONE_BRICK_PILLAR.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> STONE_TILES = ITEMS.register("stone_tiles",
            () -> new BlockItem(ModBlocks.STONE_TILES.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> STONE_TILE_SLAB = ITEMS.register("stone_tile_slab",
            () -> new BlockItem(ModBlocks.STONE_TILE_SLAB.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> STONE_TILE_STAIRS = ITEMS.register("stone_tile_stairs",
            () -> new BlockItem(ModBlocks.STONE_TILE_STAIRS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> STONE_TILE_WALL = ITEMS.register("stone_tile_wall",
            () -> new BlockItem(ModBlocks.STONE_TILE_WALL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> BLACKSTONE_PILLAR = ITEMS.register("blackstone_pillar",
            () -> new BlockItem(ModBlocks.BLACKSTONE_PILLAR.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE = ITEMS.register("azure_seastone",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_SLAB = ITEMS.register("azure_seastone_slab",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_SLAB.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_STAIRS = ITEMS.register("azure_seastone_stairs",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_STAIRS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_WALL = ITEMS.register("azure_seastone_wall",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_WALL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_FENCE = ITEMS.register("azure_seastone_fence",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_FENCE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_TILES = ITEMS.register("azure_seastone_tiles",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_TILES.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHISELED_AZURE_SEASTONE = ITEMS.register("chiseled_azure_seastone",
            () -> new BlockItem(ModBlocks.CHISELED_AZURE_SEASTONE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_BRICKS = ITEMS.register("azure_seastone_bricks",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_BRICKS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_BRICK_SLAB = ITEMS.register("azure_seastone_brick_slab",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_BRICK_SLAB.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_BRICK_STAIRS = ITEMS.register("azure_seastone_brick_stairs",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_BRICK_STAIRS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_BRICK_WALL = ITEMS.register("azure_seastone_brick_wall",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_BRICK_WALL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_EMPTY = ITEMS.register("azure_seastone_mural_empty",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_EMPTY.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_URCHINKIN = ITEMS.register("azure_seastone_mural_urchinkin",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_URCHINKIN.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_CINDARIA = ITEMS.register("azure_seastone_mural_cindaria",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_CINDARIA.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_HIPPOCAMTUS = ITEMS.register("azure_seastone_mural_hippocamtus",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_HIPPOCAMTUS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_CLAWDIAN = ITEMS.register("azure_seastone_mural_clawdian",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_CLAWDIAN.get(), new Item.Properties()));


    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_THUNDER = ITEMS.register("azure_seastone_mural_thunder",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_THUNDER.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_SEA = ITEMS.register("azure_seastone_mural_sea",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_SEA.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_UNDERWORLD = ITEMS.register("azure_seastone_mural_underworld",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_UNDERWORLD.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_HARVEST = ITEMS.register("azure_seastone_mural_harvest",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_HARVEST.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_SMITHING = ITEMS.register("azure_seastone_mural_smithing",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_SMITHING.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_MURAL_WISDOM = ITEMS.register("azure_seastone_mural_wisdom",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_MURAL_WISDOM.get(), new Item.Properties()));


    public static final DeferredItem<BlockItem> CURVED_SEASTONE_URCHINKIN = ITEMS.register("curved_azure_seastone_urchinkin",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_URCHINKIN.get(), new Item.Properties()));


    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CINDARIA_1 = ITEMS.register("curved_azure_seastone_cindaria_1",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_CINDARIA_1.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CINDARIA_2 = ITEMS.register("curved_azure_seastone_cindaria_2",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_CINDARIA_2.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CINDARIA_3 = ITEMS.register("curved_azure_seastone_cindaria_3",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_CINDARIA_3.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CINDARIA_4 = ITEMS.register("curved_azure_seastone_cindaria_4",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_CINDARIA_4.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_HIPPOCAMTUS_1 = ITEMS.register("curved_azure_seastone_hippocamtus_1",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_HIPPOCAMTUS_1.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_HIPPOCAMTUS_2 = ITEMS.register("curved_azure_seastone_hippocamtus_2",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_HIPPOCAMTUS_2.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_HIPPOCAMTUS_3 = ITEMS.register("curved_azure_seastone_hippocamtus_3",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_HIPPOCAMTUS_3.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_HIPPOCAMTUS_4 = ITEMS.register("curved_azure_seastone_hippocamtus_4",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_HIPPOCAMTUS_4.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CLAWDIAN_1 = ITEMS.register("curved_azure_seastone_clawdian_1",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_CLAWDIAN_1.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CLAWDIAN_2 = ITEMS.register("curved_azure_seastone_clawdian_2",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_CLAWDIAN_2.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CLAWDIAN_3 = ITEMS.register("curved_azure_seastone_clawdian_3",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_CLAWDIAN_3.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_CLAWDIAN_4 = ITEMS.register("curved_azure_seastone_clawdian_4",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_CLAWDIAN_4.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_1 = ITEMS.register("curved_azure_seastone_scylla_1",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_SCYLLA_1.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_2 = ITEMS.register("curved_azure_seastone_scylla_2",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_SCYLLA_2.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_3 = ITEMS.register("curved_azure_seastone_scylla_3",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_SCYLLA_3.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_4 = ITEMS.register("curved_azure_seastone_scylla_4",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_SCYLLA_4.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_5 = ITEMS.register("curved_azure_seastone_scylla_5",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_SCYLLA_5.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_6 = ITEMS.register("curved_azure_seastone_scylla_6",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_SCYLLA_6.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_7 = ITEMS.register("curved_azure_seastone_scylla_7",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_SCYLLA_7.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_8 = ITEMS.register("curved_azure_seastone_scylla_8",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_SCYLLA_8.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CURVED_SEASTONE_SCYLLA_9 = ITEMS.register("curved_azure_seastone_scylla_9",
            () -> new BlockItem(ModBlocks.CURVED_SEASTONE_SCYLLA_9.get(), new Item.Properties()));
    
    public static final DeferredItem<BlockItem> POLISHED_AZURE_SEASTONE = ITEMS.register("polished_azure_seastone",
            () -> new BlockItem(ModBlocks.POLISHED_AZURE_SEASTONE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> POLISHED_AZURE_SEASTONE_SLAB = ITEMS.register("polished_azure_seastone_slab",
            () -> new BlockItem(ModBlocks.POLISHED_AZURE_SEASTONE_SLAB.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> POLISHED_AZURE_SEASTONE_STAIRS = ITEMS.register("polished_azure_seastone_stairs",
            () -> new BlockItem(ModBlocks.POLISHED_AZURE_SEASTONE_STAIRS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> POLISHED_AZURE_SEASTONE_WALL = ITEMS.register("polished_azure_seastone_wall",
            () -> new BlockItem(ModBlocks.POLISHED_AZURE_SEASTONE_WALL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_PILLAR = ITEMS.register("azure_seastone_pillar",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_PILLAR.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> AZURE_SEASTONE_PILLAR_WALL = ITEMS.register("azure_seastone_pillar_wall",
            () -> new BlockItem(ModBlocks.AZURE_SEASTONE_PILLAR_WALL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHISELED_AZURE_SEASTONE_PILLAR = ITEMS.register("chiseled_azure_seastone_pillar",
            () -> new BlockItem(ModBlocks.CHISELED_AZURE_SEASTONE_PILLAR.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> CHISELED_AZURE_SEASTONE_PILLAR_WALL = ITEMS.register("chiseled_azure_seastone_pillar_wall",
            () -> new BlockItem(ModBlocks.CHISELED_AZURE_SEASTONE_PILLAR_WALL.get(), new Item.Properties()));

    
    public static final DeferredItem<BlockItem> FROSTED_STONE_BRICKS = ITEMS.register("frosted_stone_bricks",
            () -> new BlockItem(ModBlocks.FROSTED_STONE_BRICKS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> FROSTED_STONE_BRICK_SLAB = ITEMS.register("frosted_stone_brick_slab",
            () -> new BlockItem(ModBlocks.FROSTED_STONE_BRICK_SLAB.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> FROSTED_STONE_BRICK_STAIRS = ITEMS.register("frosted_stone_brick_stairs",
            () -> new BlockItem(ModBlocks.FROSTED_STONE_BRICK_STAIRS.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> FROSTED_STONE_BRICK_WALL = ITEMS.register("frosted_stone_brick_wall",
            () -> new BlockItem(ModBlocks.FROSTED_STONE_BRICK_WALL.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> BLACK_STEEL_BLOCK = ITEMS.register("black_steel_block",
            () -> new BlockItem(ModBlocks.BLACK_STEEL_BLOCK.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> BLACK_STEEL_FENCE = ITEMS.register("black_steel_fence",
            () -> new BlockItem(ModBlocks.BLACK_STEEL_FENCE.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> BLACK_STEEL_WALL = ITEMS.register("black_steel_wall",
            () -> new BlockItem(ModBlocks.BLACK_STEEL_WALL.get(), new Item.Properties()));


    public static final DeferredItem<BlockItem> POINTED_ICICLE = ITEMS.register("pointed_icicle",
            () -> new BlockItem(ModBlocks.POINTED_ICICLE.get(), new Item.Properties()));

    public static final DeferredItem<Item> WITHERITE_INGOT = ITEMS.register("witherite_ingot",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot",
            () -> new ItemInventoryOnly(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> ANCIENT_METAL_INGOT = ITEMS.register("ancient_metal_ingot",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> ANCIENT_METAL_NUGGET = ITEMS.register("ancient_metal_nugget",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));


    public static final DeferredItem<Item> BLACK_STEEL_INGOT = ITEMS.register("black_steel_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLACK_STEEL_NUGGET = ITEMS.register("black_steel_nugget",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> IGNITIUM_INGOT = ITEMS.register("ignitium_ingot",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> CURSIUM_INGOT = ITEMS.register("cursium_ingot",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> IGNITIUM_UPGARDE_SMITHING_TEMPLATE = ITEMS.register("ignitium_upgrade_smithing_template",
            () -> ModTemplate.createignitiumUpgradeTemplate());

    public static final DeferredItem<Item> CURSIUM_UPGARDE_SMITHING_TEMPLATE = ITEMS.register("cursium_upgrade_smithing_template",
            () -> ModTemplate.createcursiumUpgradeTemplate());

    public static final DeferredItem<Item> CHAIN_OF_SOUL_BINDING = ITEMS.register("chain_of_soul_binding",
            () -> new ItemInventoryOnly(new Item.Properties()));

    public static final DeferredItem<Item> CORAL_SPEAR = ITEMS.register("coral_spear",
            () -> new Coral_Spear((new Item.Properties()).durability(110).attributes(Coral_Spear.createAttributes())));

    public static final DeferredItem<Item> CORAL_BARDICHE = ITEMS.register("coral_bardiche",
            () -> new Coral_Bardiche((new Item.Properties()).durability(160).attributes(Coral_Bardiche.createAttributes())));

    public static final DeferredItem<Item> ATHAME = ITEMS.register("athame",
            () -> new Athame((new Item.Properties()).durability(250).attributes(Athame.createAttributes())));

    public static final DeferredItem<Item> KHOPESH = ITEMS.register("khopesh",
            () -> new SwordItem(Tooltier.ANCIENT_METAL, new Item.Properties().attributes(SwordItem.createAttributes(Tooltier.ANCIENT_METAL, 3, -2.4F))));

    public static final DeferredItem<Item> BLACK_STEEL_SWORD = ITEMS.register("black_steel_sword",
            () -> new SwordItem(Tooltier.BLACK_STEEL , new Item.Properties().attributes(SwordItem.createAttributes(Tooltier.BLACK_STEEL, 3, -2.4F))));

    public static final DeferredItem<Item> BLACK_STEEL_SHOVEL = ITEMS.register("black_steel_shovel",
            () -> new ShovelItem(Tooltier.BLACK_STEEL, new Item.Properties().attributes(ShovelItem.createAttributes(Tooltier.BLACK_STEEL,1.5F, -3.0F))));


    public static final DeferredItem<Item> BLACK_STEEL_PICKAXE = ITEMS.register("black_steel_pickaxe",
            () -> new PickaxeItem(Tooltier.BLACK_STEEL, new Item.Properties().attributes(PickaxeItem.createAttributes(Tooltier.BLACK_STEEL,1, -2.8F))));


    public static final DeferredItem<Item> BLACK_STEEL_AXE = ITEMS.register("black_steel_axe",
            () -> new AxeItem(Tooltier.BLACK_STEEL, new Item.Properties().attributes(AxeItem.createAttributes(Tooltier.BLACK_STEEL,6.0F, -3.1F))));


    public static final DeferredItem<Item> BLACK_STEEL_HOE = ITEMS.register("black_steel_hoe",
            () -> new HoeItem(Tooltier.BLACK_STEEL, new Item.Properties().attributes(HoeItem.createAttributes(Tooltier.BLACK_STEEL,-2, -1.0F))));

    public static final DeferredItem<Item> BLACK_STEEL_TARGE = ITEMS.register("black_steel_targe",
            () -> new Black_Steel_Targe(new Item.Properties().durability(840)));

    public static final DeferredItem<Item> BULWARK_OF_THE_FLAME = ITEMS.register("bulwark_of_the_flame",
            () -> new Bulwark_of_the_flame(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> GAUNTLET_OF_GUARD = ITEMS.register("gauntlet_of_guard",
            () -> new Gauntlet_of_Guard(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Gauntlet_of_Guard.createAttributes())));

    public static final DeferredItem<Item> GAUNTLET_OF_BULWARK = ITEMS.register("gauntlet_of_bulwark",
            () -> new Gauntlet_of_Bulwark(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Gauntlet_of_Bulwark.createAttributes())));

    public static final DeferredItem<Item> GAUNTLET_OF_MAELSTROM = ITEMS.register("gauntlet_of_maelstrom",
            () -> new Gauntlet_of_Maelstrom(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Gauntlet_of_Maelstrom.createAttributes())));


    public static final DeferredItem<Item> THE_INCINERATOR = ITEMS.register("the_incinerator",
            () -> new The_Incinerator(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(The_Incinerator.createAttributes())));

    public static final DeferredItem<Item> BLAZING_GRIPS = ITEMS.register("blazing_grips",
            () -> new Blazing_Grips(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> CHITIN_CLAW = ITEMS.register("chitin_claw",
            () -> new Chitin_Claw(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant())
                    .withAttributes("hands",
                            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 0.5, AttributeModifier.Operation.ADD_VALUE),
                            new AttributeContainer(Attributes.BLOCK_INTERACTION_RANGE, 0.75, AttributeModifier.Operation.ADD_VALUE)
                    )
    );

    public static final DeferredItem<Item> CURSED_BOW = ITEMS.register("cursed_bow",
            () -> new Cursed_bow(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> WRATH_OF_THE_DESERT = ITEMS.register("wrath_of_the_desert",
            () -> new Wrath_of_the_desert(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> SOUL_RENDER = ITEMS.register("soul_render",
            () -> new Soul_Render(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).attributes(Soul_Render.createAttributes())));

    public static final DeferredItem<Item> THE_ANNIHILATOR = ITEMS.register("the_annihilator",
            () -> new The_Annihilator(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).attributes(The_Annihilator.createAttributes())));

    public static final DeferredItem<Item> THE_IMMOLATOR = ITEMS.register("the_immolator",
            () -> new The_Immolator(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).attributes(The_Immolator.createAttributes())));

    public static final DeferredItem<Item> MEAT_SHREDDER = ITEMS.register("meat_shredder",
            () -> new Meat_Shredder(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC).attributes(Meat_Shredder.createAttributes())));

    public static final DeferredItem<Item> LASER_GATLING = ITEMS.register("laser_gatling",
            () -> new Laser_Gatling(new Item.Properties().stacksTo(1).fireResistant().durability(50).rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> WITHER_ASSULT_SHOULDER_WEAPON = ITEMS.register("wither_assault_shoulder_weapon",
            () -> new Wither_Assault_SHoulder_Weapon(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> VOID_ASSULT_SHOULDER_WEAPON = ITEMS.register("void_assault_shoulder_weapon",
            () -> new Void_Assault_SHoulder_Weapon(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> VOID_FORGE = ITEMS.register("void_forge",
            () -> new void_forge(Tooltier.MONSTROSITY, new Item.Properties().fireResistant().rarity(Rarity.EPIC).attributes(PickaxeItem.createAttributes(Tooltier.MONSTROSITY,8, -3.0F))));

    public static final DeferredItem<Item> TIDAL_CLAWS = ITEMS.register("tidal_claws",
            () -> new Tidal_Claws(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().attributes(Tidal_Claws.createAttributes())));


    public static final DeferredItem<Item> INFERNAL_FORGE = ITEMS.register("infernal_forge",
            () -> new infernal_forge(Tooltier.MONSTROSITY, new Item.Properties().fireResistant().rarity(Rarity.EPIC).attributes(PickaxeItem.createAttributes(Tooltier.MONSTROSITY,8, -3.0F))));

    public static final DeferredItem<Item> SANDSTORM_IN_A_BOTTLE = ITEMS.register("sandstorm_in_a_bottle",
            () -> new Sandstorm_In_A_Bottle(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> ANCIENT_SPEAR = ITEMS.register("ancient_spear",
            () -> new Ancient_Spear(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().durability(1800).attributes(Ancient_Spear.createAttributes())));

    public static final DeferredItem<Item> STICKY_GLOVES = ITEMS.register("sticky_gloves",
            () -> new Sticky_Gloves(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> REMNANT_SKULL = ITEMS.register("remnant_skull",
            () -> new Remnant_Skull(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> NETHERITE_EFFIGY = ITEMS.register("netherite_effigy",
            () -> new Netherite_Effigy(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> VOID_SCATTER_ARROW = ITEMS.register("void_scatter_arrow",
            () -> new Void_Scatter_Arrow_Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> VOID_SHARD = ITEMS.register("void_shard",
            () -> new ItemInventoryOnly(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> BLAZING_BONE = ITEMS.register("blazing_bone",
            () -> new ItemInventoryOnly(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> KOBOLETON_BONE = ITEMS.register("koboleton_bone",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> VOID_JAW = ITEMS.register("void_jaw",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> VOID_CORE = ITEMS.register("void_core",
            () -> new void_core(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> CRYSTALLIZED_CORAL_FRAGMENTS = ITEMS.register("crystallized_coral_fragments",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CRYSTALLIZED_CORAL = ITEMS.register("crystallized_coral",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CORAL_CHUNK = ITEMS.register("coral_chunk",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ABYSSAL_SACRIFICE = ITEMS.register("abyssal_sacrifice",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final DeferredItem<Item> NECKLACE_OF_THE_DESERT = ITEMS.register("necklace_of_the_desert",
            () -> new Necklace_Of_The_Desert(new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final DeferredItem<Item> APTRGANGR_HEAD = ITEMS.register("aptrgangr_head",
            () -> new CataclysmSkullItem(ModBlocks.APTRGANGR_HEAD.get(), ModBlocks.APTRGANGR_WALL_HEAD.get(), (new Item.Properties()).rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> DRAUGR_HEAD = ITEMS.register("draugr_head",
            () -> new CataclysmSkullItem(ModBlocks.DRAUGR_HEAD.get(), ModBlocks.DRAUGR_WALL_HEAD.get(), (new Item.Properties()).rarity(Rarity.UNCOMMON)));


    public static final DeferredItem<Item> KOBOLEDIATOR_SKULL = ITEMS.register("kobolediator_skull",
            () -> new CataclysmSkullItem(ModBlocks.KOBOLEDIATOR_SKULL.get(), ModBlocks.KOBOLEDIATOR_WALL_SKULL.get(), (new Item.Properties()).rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> BONE_REPTILE_HELMET = ITEMS.register("bone_reptile_helmet",
            () -> new Bone_Reptile_Armor(Armortier.BONE_REPTILE, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(35))));

    public static final DeferredItem<Item> BONE_REPTILE_CHESTPLATE = ITEMS.register("bone_reptile_chestplate",
            () -> new Bone_Reptile_Armor(Armortier.BONE_REPTILE, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(35))));

    public static final DeferredItem<Item> IGNITIUM_HELMET = ITEMS.register("ignitium_helmet",
            () -> new Ignitium_Armor(Armortier.IGNITIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(ArmorItem.Type.HELMET.getDurability(45))));

    public static final DeferredItem<Item> IGNITIUM_CHESTPLATE = ITEMS.register("ignitium_chestplate",
            () -> new Ignitium_Armor(Armortier.IGNITIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(ArmorItem.Type.CHESTPLATE.getDurability(45))));

    public static final DeferredItem<Item> IGNITIUM_ELYTRA_CHESTPLATE = ITEMS.register("ignitium_elytra_chestplate",
            () -> new Ignitium_Elytra_ChestPlate(new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(ArmorItem.Type.CHESTPLATE.getDurability(45)), Armortier.IGNITIUM));

    public static final DeferredItem<Item> IGNITIUM_LEGGINGS = ITEMS.register("ignitium_leggings",
            () -> new Ignitium_Armor(Armortier.IGNITIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(ArmorItem.Type.LEGGINGS.getDurability(45))));

    public static final DeferredItem<Item> IGNITIUM_BOOTS = ITEMS.register("ignitium_boots",
            () -> new Ignitium_Armor(Armortier.IGNITIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(ArmorItem.Type.BOOTS.getDurability(45))));

    public static final DeferredItem<Item> CURSIUM_HELMET = ITEMS.register("cursium_helmet",
            () -> new Cursium_Armor(Armortier.CURSIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(ArmorItem.Type.HELMET.getDurability(45))));

    public static final DeferredItem<Item> CURSIUM_CHESTPLATE = ITEMS.register("cursium_chestplate",
            () -> new Cursium_Armor(Armortier.CURSIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(ArmorItem.Type.CHESTPLATE.getDurability(45))));

    public static final DeferredItem<Item> CURSIUM_LEGGINGS = ITEMS.register("cursium_leggings",
            () -> new Cursium_Armor(Armortier.CURSIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(ArmorItem.Type.LEGGINGS.getDurability(45))));

    public static final DeferredItem<Item> CURSIUM_BOOTS = ITEMS.register("cursium_boots",
            () -> new Cursium_Armor(Armortier.CURSIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().rarity(Rarity.EPIC).durability(ArmorItem.Type.BOOTS.getDurability(45))));

    public static final DeferredItem<Item> MONSTROUS_HORN = ITEMS.register("monstrous_horn",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> LAVA_POWER_CELL = ITEMS.register("lava_power_cell",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> MONSTROUS_HELM = ITEMS.register("monstrous_helm",
            () -> new Monstrous_Helm(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(45)).rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> BLOOM_STONE_PAULDRONS = ITEMS.register("bloom_stone_pauldrons",
            () -> new Bloom_Stone_Pauldrons(Armortier.CRAB, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON).durability(ArmorItem.Type.CHESTPLATE.getDurability(30))));

    public static final DeferredItem<Item> BURNING_ASHES = ITEMS.register("burning_ashes",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final DeferredItem<Item> DYING_EMBER = ITEMS.register("dying_ember",
            () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> MUSIC_DISC_NETHERITE_MONSTROSITY = ITEMS.register("music_disc_netherite_monstrosity",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.MONSTROSITY_THEME)));

    public static final DeferredItem<Item> MUSIC_DISC_ENDER_GUARDIAN = ITEMS.register("music_disc_ender_guardian",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.ENDERGUARDIAN_THEME)));

    public static final DeferredItem<Item> MUSIC_DISC_IGNIS = ITEMS.register("music_disc_ignis",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.IGNIS_THEME)));

    public static final DeferredItem<Item> MUSIC_DISC_THE_HARBINGER = ITEMS.register("music_disc_the_harbinger",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.HARBINGER_THEME)));

    public static final DeferredItem<Item> MUSIC_DISC_THE_LEVIATHAN = ITEMS.register("music_disc_the_leviathan",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.LEVIATHAN_THEME)));

    public static final DeferredItem<Item> MUSIC_DISC_ANCIENT_REMNANT = ITEMS.register("music_disc_ancient_remnant",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.REMNANT_THEME)));

    public static final DeferredItem<Item> MUSIC_DISC_MALEDICTUS = ITEMS.register("music_disc_maledictus",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().jukeboxPlayable(ModJukeboxSongs.MALEDICTUS_THEME)));


    public static final DeferredItem<Item> MECH_EYE = ITEMS.register("mech_eye",
            () -> new MechEyeItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> FLAME_EYE = ITEMS.register("flame_eye",
            () -> new FlameEyeItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> VOID_EYE = ITEMS.register("void_eye",
            () -> new VoidEyeItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> MONSTROUS_EYE = ITEMS.register("monstrous_eye",
            () -> new MonstrousEyeItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> ABYSS_EYE = ITEMS.register("abyss_eye",
            () -> new AbyssEyeItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> DESERT_EYE = ITEMS.register("desert_eye",
            () -> new DesertEyeItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> CURSED_EYE = ITEMS.register("cursed_eye",
            () -> new CursedEyeItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> LIONFISH = ITEMS.register("lionfish",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F)
                    .effect(new MobEffectInstance(MobEffects.POISON, 60, 0), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 60, 0), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 240 * 20, 0), 1.0F)
                    .build())));

    public static final DeferredItem<Item> AMETHYST_CRAB_MEAT = ITEMS.register("amethyst_crab_meat",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(1.2F)
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build())));


    public static final DeferredItem<Item> BLESSED_AMETHYST_CRAB_MEAT = ITEMS.register("blessed_amethyst_crab_meat",
            () -> new Blessed_Amethyst_Crab_Meat(new Item.Properties().rarity(Rarity.EPIC).food(new FoodProperties.Builder().nutrition(6).saturationModifier(1.2F)
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
                    .effect(new MobEffectInstance(ModEffect.EFFECTBLESSING_OF_AMETHYST, 1800, 0), 1.0F)
                    .alwaysEdible()
                    .build())));

    public static final DeferredItem<Item> AMETHYST_CRAB_SHELL = ITEMS.register("amethyst_crab_shell",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> LIONFISH_SPIKE = ITEMS.register("lionfish_spike",
            () -> new ItemInventoryOnly(new Item.Properties()));

    public static final DeferredItem<Item> URCHIN_SPIKE = ITEMS.register("urchin_spike",
            () -> new ItemInventoryOnly(new Item.Properties()));

    public static final DeferredItem<Item> BLOOD_CLOT = ITEMS.register("blood_clot",
            () -> new ItemInventoryOnly(new Item.Properties()));

    public static final DeferredItem<Item> THE_BABY_LEVIATHAN_BUCKET = ITEMS.register("the_baby_leviathan_bucket",
            () -> new ModFishBucket(ModEntities.THE_BABY_LEVIATHAN.get(), Fluids.WATER, new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> MODERN_REMNANT_BUCKET = ITEMS.register("modern_remnant_bucket",
            () -> new ModernRemantBucket(ModEntities.MODERN_REMNANT.get(), Fluids.EMPTY, new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> NETHERITE_MINISTROSITY_BUCKET = ITEMS.register("netherite_ministrosity_bucket",
            () -> new ModernRemantBucket(ModEntities.NETHERITE_MINISTROSITY.get(), Fluids.EMPTY, new Item.Properties().fireResistant()));

    public static final DeferredItem<SpawnEggItem> ENDER_GOLEM_SPAWN_EGG = ITEMS.register("ender_golem_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ENDER_GOLEM.get(), 0x2a1a42, 0xa153fe, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> NETHERITE_MONSTROSITY_SPAWN_EGG = ITEMS.register("netherite_monstrosity_spawn_egg",
            () -> new SpawnEggItem(ModEntities.NETHERITE_MONSTROSITY.get(), 0x4d494d, 0xf48522, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> NETHERITE_MINISTROSITY_SPAWN_EGG = ITEMS.register("netherite_ministrosity_spawn_egg",
            () -> new SpawnEggItem(ModEntities.NETHERITE_MINISTROSITY.get(), 0x6b686b, 0xc25f01, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> ENDER_GUARDIAN_SPAWN_EGG = ITEMS.register("ender_guardian_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ENDER_GUARDIAN.get(), 0x2a1a42, 9725844, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> ENDERMAPTERA_SPAWN_EGG = ITEMS.register("endermaptera_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ENDERMAPTERA.get(), 0x2a1a42, 7237230, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> IGNIS_SPAWN_EGG = ITEMS.register("ignis_spawn_egg",
            () -> new SpawnEggItem(ModEntities.IGNIS.get(), 16167425, 16579584, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> IGNITED_REVENANT_SPAWN_EGG = ITEMS.register("ignited_revenant_spawn_egg",
            () -> new SpawnEggItem(ModEntities.IGNITED_REVENANT.get(), 4672845, 16579584, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> IGNITED_BERSERKER_SPAWN_EGG = ITEMS.register("ignited_berserker_spawn_egg",
            () -> new SpawnEggItem(ModEntities.IGNITED_BERSERKER.get(), 4672845, 16579584, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> THE_WATCHER_SPAWN_EGG = ITEMS.register("the_watcher_spawn_egg",
            () -> new SpawnEggItem(ModEntities.THE_WATCHER.get(), 0x737c8b, 0xe83b3b, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> THE_PROWLER_SPAWN_EGG = ITEMS.register("the_prowler_spawn_egg",
            () -> new SpawnEggItem(ModEntities.THE_PROWLER.get(), 0x1e2021, 0x682e22, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> THE_HARBINGER_SPAWN_EGG = ITEMS.register("the_harbinger_spawn_egg",
            () -> new SpawnEggItem(ModEntities.THE_HARBINGER.get(), 0x1e2021, 0xae2334, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> THE_LEVIATHAN_SPAWN_EGG = ITEMS.register("the_leviathan_spawn_egg",
            () -> new SpawnEggItem(ModEntities.THE_LEVIATHAN.get(), 0x150e1b, 0x6500ff, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> THE_BABY_LEVIATHAN_SPAWN_EGG = ITEMS.register("the_baby_leviathan_spawn_egg",
            () -> new SpawnEggItem(ModEntities.THE_BABY_LEVIATHAN.get(), 0x322141, 0x8a3eff, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> DEEPLING_SPAWN_EGG = ITEMS.register("deepling_spawn_egg",
            () -> new SpawnEggItem(ModEntities.DEEPLING.get(), 0x182a3c, 0xbaedf4, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> DEEPLING_BRUTE_SPAWN_EGG = ITEMS.register("deepling_brute_spawn_egg",
            () -> new SpawnEggItem(ModEntities.DEEPLING_BRUTE.get(), 0x182a3c, 0x6500ff, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> DEEPLING_ANGLER_SPAWN_EGG = ITEMS.register("deepling_angler_spawn_egg",
            () -> new SpawnEggItem(ModEntities.DEEPLING_ANGLER.get(), 0x182a3c, 0x98d8e2, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> DEEPLING_PRIEST_SPAWN_EGG = ITEMS.register("deepling_priest_spawn_egg",
            () -> new SpawnEggItem(ModEntities.DEEPLING_PRIEST.get(), 0x182a3c, 0x082054, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> DEEPLING_WARLOCK_SPAWN_EGG = ITEMS.register("deepling_warlock_spawn_egg",
            () -> new SpawnEggItem(ModEntities.DEEPLING_WARLOCK.get(), 0x182a3c, 0xd66a98, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> LIONFISH_SPAWN_EGG = ITEMS.register("lionfish_spawn_egg",
            () -> new SpawnEggItem(ModEntities.LIONFISH.get(), 0x98d8e2, 0x182a3c, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> CORAL_GOLEM_SPAWN_EGG = ITEMS.register("coral_golem_spawn_egg",
            () -> new SpawnEggItem(ModEntities.CORAL_GOLEM.get(), 0x2143a4, 0xa4222f, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> CORALSSUS_SPAWN_EGG = ITEMS.register("coralssus_spawn_egg",
            () -> new SpawnEggItem(ModEntities.CORALSSUS.get(), 0x3f6ce5, 0xedec4c, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> AMETHYST_CRAB_SPAWN_EGG = ITEMS.register("amethyst_crab_spawn_egg",
            () -> new SpawnEggItem(ModEntities.AMETHYST_CRAB.get(), 0x646464, 0x7a5bb5, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> KOBOLETON_SPAWN_EGG = ITEMS.register("koboleton_spawn_egg",
            () -> new SpawnEggItem(ModEntities.KOBOLETON.get(), 0xb7b196, 0xe18103, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> KOBOLEDIATOR_SPAWN_EGG = ITEMS.register("kobolediator_spawn_egg",
            () -> new SpawnEggItem(ModEntities.KOBOLEDIATOR.get(), 0xb7b196, 0x945b31, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> WADJET_SPAWN_EGG = ITEMS.register("wadjet_spawn_egg",
            () -> new SpawnEggItem(ModEntities.WADJET.get(), 0xb7b196, 0xdbb86a, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> ANCIENT_REMNANT_SPAWN_EGG = ITEMS.register("ancient_remnant_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ANCIENT_REMNANT.get(), 0xb7b196, 0x682e22, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> MODERN_REMNANT_SPAWN_EGG = ITEMS.register("modern_remnant_spawn_egg",
            () -> new SpawnEggItem(ModEntities.MODERN_REMNANT.get(), 0xb7b196, 0xdbcca7, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> MALEDICTUS_SPAWN_EGG = ITEMS.register("maledictus_spawn_egg",
            () -> new SpawnEggItem(ModEntities.MALEDICTUS.get(),0x39d2b2, 0x945b31, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> APTRGANGR_SPAWN_EGG = ITEMS.register("aptrgangr_spawn_egg",
            () -> new SpawnEggItem(ModEntities.APTRGANGR.get(),0x392116, 0xe8e7e4, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> ELITE_DRAUGR_SPAWN_EGG = ITEMS.register("elite_draugr_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ELITE_DRAUGR.get(),0x392116, 0x442318, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> ROYAL_DRAUGR_SPAWN_EGG = ITEMS.register("royal_draugr_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ROYAL_DRAUGR.get(),0x392116, 0x945b31, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> DRAUGR_SPAWN_EGG = ITEMS.register("draugr_spawn_egg",
            () -> new SpawnEggItem(ModEntities.DRAUGR.get(),0x392116, 0x2b2825, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> SCYLLA_SPAWN_EGG = ITEMS.register("scylla_spawn_egg",
            () -> new SpawnEggItem(ModEntities.SCYLLA.get(),0x80a1af, 0x3f569b, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> CLAWDIAN_SPAWN_EGG = ITEMS.register("clawdian_spawn_egg",
            () -> new SpawnEggItem(ModEntities.CLAWDIAN.get(),0x8b261d, 0xc96546, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> HIPPOCAMTUS_SPAWN_EGG = ITEMS.register("hippocamtus_spawn_egg",
            () -> new SpawnEggItem(ModEntities.HIPPOCAMTUS.get(),0x7e8fab, 0xffe98e, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> CINDARIA_SPAWN_EGG = ITEMS.register("cindaria_spawn_egg",
            () -> new SpawnEggItem(ModEntities.CINDARIA.get(),0xcf95ff, 0x62eaad, new Item.Properties()));

    public static final DeferredItem<SpawnEggItem> URCHINKIN_SPAWN_EGG = ITEMS.register("urchinkin_spawn_egg",
            () -> new SpawnEggItem(ModEntities.URCHINKIN.get(),0x000000, 0x2b1052, new Item.Properties()));

    public static final DeferredItem<BlockItem> ALTAR_OF_VOID = ITEMS.register("altar_of_void",
            () -> new BlockItem(ModBlocks.ALTAR_OF_VOID.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> ALTAR_OF_FIRE = ITEMS.register("altar_of_fire",
            () -> new BlockItem(ModBlocks.ALTAR_OF_FIRE.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> ALTAR_OF_AMETHYST = ITEMS.register("altar_of_amethyst",
            () -> new BlockItem(ModBlocks.ALTAR_OF_AMETHYST.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> ALTAR_OF_ABYSS = ITEMS.register("altar_of_abyss",
            () -> new BlockItem(ModBlocks.ALTAR_OF_ABYSS.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> CURSED_TOMBSTONE = ITEMS.register("cursed_tombstone",
            () -> new BlockItem(ModBlocks.CURSED_TOMBSTONE.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> EMP = ITEMS.register("emp",
            () -> new BlockItem(ModBlocks.EMP.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> ABYSSAL_EGG = ITEMS.register("abyssal_egg",
            () -> new BlockItem(ModBlocks.ABYSSAL_EGG.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));


    public static final DeferredItem<BlockItem> MECHANICAL_FUSION_ANVIL = ITEMS.register("mechanical_fusion_anvil",
            () -> new BlockItem(ModBlocks.MECHANICAL_FUSION_ANVIL.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));


    public static final DeferredItem<BlockItem> DOOR_OF_SEAL = ITEMS.register("door_of_seal",
            () -> new BlockItem(ModBlocks.DOOR_OF_SEAL.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<BlockItem> GODDESS_STATUE = ITEMS.register("goddess_statue",
            () -> new BlockItem(ModBlocks.GODDESS_STATUE.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));


    public static void initDispenser(){
        DispenserBlock.registerProjectileBehavior(ModItems.VOID_SCATTER_ARROW.get());
        DispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior() {
            private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

            public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
                DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem) itemStack.getItem();
                BlockPos blockPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));
                Level level = blockSource.level().getLevel();
                if (dispensibleContainerItem.emptyContents(null, level, blockPos, null)) {
                    dispensibleContainerItem.checkExtraContent(null, level, itemStack, blockPos);
                    return new ItemStack(Items.BUCKET);
                } else {
                    return this.defaultDispenseItemBehavior.dispense(blockSource, itemStack);
                }
            }
        };
        DispenserBlock.registerBehavior(THE_BABY_LEVIATHAN_BUCKET.get(), dispenseItemBehavior);
        DispenserBlock.registerBehavior(MODERN_REMNANT_BUCKET.get(), dispenseItemBehavior);
    }
}


