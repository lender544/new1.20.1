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

    public static final RegistryObject<BlockEntityType<ObsidianExplosionTrapBricks_Block_Entity>> OBSIDIAN_EXPLOSION_TRAP_BRICKS = TILE_ENTITY_TYPES.register("obsidian_explosion_trap_bricks", () ->
            BlockEntityType.Builder.of(ObsidianExplosionTrapBricks_Block_Entity::new, ModBlocks.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get()).build(null));

    public static final RegistryObject<BlockEntityType<SandstoneIgniteTrap_Block_Entity>> SANDSTONE_IGNITE_TRAP = TILE_ENTITY_TYPES.register("sadsotne_ignite_trap", () ->
            BlockEntityType.Builder.of(SandstoneIgniteTrap_Block_Entity::new, ModBlocks.SANDSTONE_IGNITE_TRAP.get()).build(null));

    public static final RegistryObject<BlockEntityType<AltarOfVoid_Block_Entity>> ALTAR_OF_VOID = TILE_ENTITY_TYPES.register("altar_of_void", () ->
            BlockEntityType.Builder.of(AltarOfVoid_Block_Entity::new, ModBlocks.ALTAR_OF_VOID.get()).build(null));

    public static final RegistryObject<BlockEntityType<AltarOfFire_Block_Entity>> ALTAR_OF_FIRE = TILE_ENTITY_TYPES.register("altar_of_fire", () ->
            BlockEntityType.Builder.of(AltarOfFire_Block_Entity::new, ModBlocks.ALTAR_OF_FIRE.get()).build(null));

    public static final RegistryObject<BlockEntityType<AltarOfAmethyst_Block_Entity>> ALTAR_OF_AMETHYST = TILE_ENTITY_TYPES.register("altar_of_amethyst", () ->
            BlockEntityType.Builder.of(AltarOfAmethyst_Block_Entity::new, ModBlocks.ALTAR_OF_AMETHYST.get()).build(null));

    public static final RegistryObject<BlockEntityType<AltarOfAbyss_Block_Entity>> ALTAR_OF_ABYSS = TILE_ENTITY_TYPES.register("altar_of_abyss", () ->
            BlockEntityType.Builder.of(AltarOfAbyss_Block_Entity::new, ModBlocks.ALTAR_OF_ABYSS.get()).build(null));

    public static final RegistryObject<BlockEntityType<Cursed_tombstone_Entity>> CURSED_TOMBSTONE = TILE_ENTITY_TYPES.register("cursed_tombstone", () ->
            BlockEntityType.Builder.of(Cursed_tombstone_Entity::new, ModBlocks.CURSED_TOMBSTONE.get()).build(null));

    public static final RegistryObject<BlockEntityType<Abyssal_Egg_Block_Entity>> ABYSSAL_EGG = TILE_ENTITY_TYPES.register("abyssal_egg", () ->
            BlockEntityType.Builder.of(Abyssal_Egg_Block_Entity::new, ModBlocks.ABYSSAL_EGG.get()).build(null));

    public static final RegistryObject<BlockEntityType<EMP_Block_Entity>> EMP = TILE_ENTITY_TYPES.register("emp", () ->
            BlockEntityType.Builder.of(EMP_Block_Entity::new, ModBlocks.EMP.get()).build(null));

    public static final RegistryObject<BlockEntityType<Cataclysm_Skull_BlockEntity>> CATACLYSM_SKULL = TILE_ENTITY_TYPES.register("cataclysm_skull", () ->
            BlockEntityType.Builder.of(Cataclysm_Skull_BlockEntity::new, ModBlocks.KOBOLEDIATOR_SKULL.get(), ModBlocks.KOBOLEDIATOR_WALL_SKULL.get(),ModBlocks.APTRGANGR_HEAD.get(), ModBlocks.APTRGANGR_WALL_HEAD.get(),ModBlocks.DRAUGR_HEAD.get(), ModBlocks.DRAUGR_WALL_HEAD.get()).build(null));

    public static final RegistryObject<BlockEntityType<Mechanical_fusion_Anvil_Block_Entity>> MECHANICAL_FUSION_ANVIL = TILE_ENTITY_TYPES.register("mechanical_fusion_anvil", () ->
            BlockEntityType.Builder.of(Mechanical_fusion_Anvil_Block_Entity::new, ModBlocks.MECHANICAL_FUSION_ANVIL.get()).build(null));


    public static final RegistryObject<BlockEntityType<Door_Of_Seal_BlockEntity>> DOOR_OF_SEAL = TILE_ENTITY_TYPES.register("door_of_seal", () ->
            BlockEntityType.Builder.of(Door_Of_Seal_BlockEntity::new, ModBlocks.DOOR_OF_SEAL.get()).build(null));


    public static final RegistryObject<BlockEntityType<Statue_Block_Entity>> GODDESS_STATUE = TILE_ENTITY_TYPES.register("goddess_statue", () ->
            BlockEntityType.Builder.of(Statue_Block_Entity::new, ModBlocks.GODDESS_STATUE.get()).build(null));

    public static final RegistryObject<BlockEntityType<Boss_Respawn_Spawner_Block_Entity>> BOSS_RESPAWNER = TILE_ENTITY_TYPES.register("boss_respawner", () ->
            BlockEntityType.Builder.of(Boss_Respawn_Spawner_Block_Entity::new, ModBlocks.BOSS_RESPAWNER.get()).build(null));
}
