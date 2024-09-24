package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blockentities.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModTileentites {

    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
            Cataclysm.MODID);

    public static final RegistryObject<BlockEntityType<TileEntityObsidianExplosionTrapBricks>> OBSIDIAN_EXPLOSION_TRAP_BRICKS = TILE_ENTITY_TYPES.register("obsidian_explosion_trap_bricks", () ->
            BlockEntityType.Builder.of(TileEntityObsidianExplosionTrapBricks::new, ModBlocks.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get()).build(null));

    public static final RegistryObject<BlockEntityType<TileEntitySandstoneIgniteTrap>> SANDSTONE_IGNITE_TRAP = TILE_ENTITY_TYPES.register("sadsotne_ignite_trap", () ->
            BlockEntityType.Builder.of(TileEntitySandstoneIgniteTrap::new, ModBlocks.SANDSTONE_IGNITE_TRAP.get()).build(null));

    public static final RegistryObject<BlockEntityType<TileEntityAltarOfVoid>> ALTAR_OF_VOID = TILE_ENTITY_TYPES.register("altar_of_void", () ->
            BlockEntityType.Builder.of(TileEntityAltarOfVoid::new, ModBlocks.ALTAR_OF_VOID.get()).build(null));

    public static final RegistryObject<BlockEntityType<TileEntityAltarOfFire>> ALTAR_OF_FIRE = TILE_ENTITY_TYPES.register("altar_of_fire", () ->
            BlockEntityType.Builder.of(TileEntityAltarOfFire::new, ModBlocks.ALTAR_OF_FIRE.get()).build(null));

    public static final RegistryObject<BlockEntityType<TileEntityAltarOfAmethyst>> ALTAR_OF_AMETHYST = TILE_ENTITY_TYPES.register("altar_of_amethyst", () ->
            BlockEntityType.Builder.of(TileEntityAltarOfAmethyst::new, ModBlocks.ALTAR_OF_AMETHYST.get()).build(null));

    public static final RegistryObject<BlockEntityType<TileEntityAltarOfAbyss>> ALTAR_OF_ABYSS = TILE_ENTITY_TYPES.register("altar_of_abyss", () ->
            BlockEntityType.Builder.of(TileEntityAltarOfAbyss::new, ModBlocks.ALTAR_OF_ABYSS.get()).build(null));

    public static final RegistryObject<BlockEntityType<TileEntityAbyssal_Egg>> ABYSSAL_EGG = TILE_ENTITY_TYPES.register("abyssal_egg", () ->
            BlockEntityType.Builder.of(TileEntityAbyssal_Egg::new, ModBlocks.ABYSSAL_EGG.get()).build(null));

    public static final RegistryObject<BlockEntityType<TileEntityEMP>> EMP = TILE_ENTITY_TYPES.register("emp", () ->
            BlockEntityType.Builder.of(TileEntityEMP::new, ModBlocks.EMP.get()).build(null));

    public static final RegistryObject<BlockEntityType<Cataclysm_Skull_BlockEntity>> CATACLYSM_SKULL = TILE_ENTITY_TYPES.register("cataclysm_skull", () ->
            BlockEntityType.Builder.of(Cataclysm_Skull_BlockEntity::new, ModBlocks.KOBOLEDIATOR_SKULL.get(), ModBlocks.KOBOLEDIATOR_WALL_SKULL.get(),ModBlocks.APTRGANGR_HEAD.get(), ModBlocks.APTRGANGR_WALL_HEAD.get(),ModBlocks.DRAUGR_HEAD.get(), ModBlocks.DRAUGR_WALL_HEAD.get()).build(null));

    public static final RegistryObject<BlockEntityType<TileEntityMechanical_fusion_Anvil>> MECHANICAL_FUSION_ANVIL = TILE_ENTITY_TYPES.register("mechanical_fusion_anvil", () ->
            BlockEntityType.Builder.of(TileEntityMechanical_fusion_Anvil::new, ModBlocks.MECHANICAL_FUSION_ANVIL.get()).build(null));

}
