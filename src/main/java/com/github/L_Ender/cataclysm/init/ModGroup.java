package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.util.CustomTabBehavior;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModGroup {


    public static final DeferredRegister<CreativeModeTab> DEF_REG = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cataclysm.MODID);


    public static final RegistryObject<CreativeModeTab> ITEM = DEF_REG.register("cataclysm_item", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Cataclysm.MODID + ".item"))
            .icon(() -> new ItemStack(ModItems.THE_INCINERATOR.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ModItems.WITHERITE_INGOT.get());
                entries.accept(ModItems.ANCIENT_METAL_INGOT.get());
                entries.accept(ModItems.ANCIENT_METAL_NUGGET.get());
                entries.accept(ModItems.BLACK_STEEL_INGOT.get());
                entries.accept(ModItems.BLACK_STEEL_NUGGET.get());
                entries.accept(ModItems.LACRIMA.get());
                entries.accept(ModItems.ESSENCE_OF_THE_STORM.get());
                entries.accept(ModItems.IGNITIUM_INGOT.get());
                entries.accept(ModItems.CURSIUM_INGOT.get());
                entries.accept(ModItems.IGNITIUM_UPGARDE_SMITHING_TEMPLATE.get());
                entries.accept(ModItems.CURSIUM_UPGARDE_SMITHING_TEMPLATE.get());
                entries.accept(ModItems.MONSTROUS_HORN.get());
                entries.accept(ModItems.LAVA_POWER_CELL.get());
                entries.accept(ModItems.BURNING_ASHES.get());
                entries.accept(ModItems.DYING_EMBER.get());
                entries.accept(ModItems.KOBOLETON_BONE.get());
                entries.accept(ModItems.VOID_JAW.get());
                entries.accept(ModItems.CRYSTALLIZED_CORAL_FRAGMENTS.get());
                entries.accept(ModItems.CRYSTALLIZED_CORAL.get());
                entries.accept(ModItems.CORAL_CHUNK.get());
                entries.accept(ModItems.ABYSSAL_SACRIFICE.get());
                entries.accept(ModItems.NECKLACE_OF_THE_DESERT.get());
                entries.accept(ModItems.STRANGE_KEY.get());
                entries.accept(ModItems.CORAL_SPEAR.get());
                entries.accept(ModItems.CORAL_BARDICHE.get());
                entries.accept(ModItems.ATHAME.get());
                entries.accept(ModItems.KHOPESH.get());
                entries.accept(ModItems.BLACK_STEEL_SWORD.get());
                entries.accept(ModItems.BLACK_STEEL_SHOVEL.get());
                entries.accept(ModItems.BLACK_STEEL_PICKAXE.get());
                entries.accept(ModItems.BLACK_STEEL_AXE.get());
                entries.accept(ModItems.BLACK_STEEL_HOE.get());
                entries.accept(ModItems.BLACK_STEEL_TARGE.get());
                entries.accept(ModItems.AZURE_SEA_SHIELD.get());
                entries.accept(ModItems.BULWARK_OF_THE_FLAME.get());
                entries.accept(ModItems.GAUNTLET_OF_GUARD.get());
                entries.accept(ModItems.GAUNTLET_OF_BULWARK.get());
                entries.accept(ModItems.GAUNTLET_OF_MAELSTROM.get());
                entries.accept(ModItems.THE_INCINERATOR.get());
                entries.accept(ModItems.BLAZING_GRIPS.get());
                entries.accept(ModItems.CHITIN_CLAW.get());
                entries.accept(ModItems.CURSED_BOW.get());
                entries.accept(ModItems.WRATH_OF_THE_DESERT.get());
                entries.accept(ModItems.SOUL_RENDER.get());
                entries.accept(ModItems.THE_ANNIHILATOR.get());
                entries.accept(ModItems.THE_IMMOLATOR.get());
                entries.accept(ModItems.MEAT_SHREDDER.get());
                entries.accept(ModItems.LASER_GATLING.get());
                entries.accept(ModItems.WITHER_ASSULT_SHOULDER_WEAPON.get());
                entries.accept(ModItems.VOID_ASSULT_SHOULDER_WEAPON.get());
                entries.accept(ModItems.VOID_FORGE.get());
                entries.accept(ModItems.ASTRAPE.get());
                entries.accept(ModItems.CERAUNUS.get());
                entries.accept(ModItems.TIDAL_CLAWS.get());
                entries.accept(ModItems.INFERNAL_FORGE.get());
                entries.accept(ModItems.SANDSTORM_IN_A_BOTTLE.get());
                entries.accept(ModItems.ANCIENT_SPEAR.get());
                entries.accept(ModItems.STICKY_GLOVES.get());
                entries.accept(ModItems.VOID_CORE.get());
                entries.accept(ModItems.VOID_SCATTER_ARROW.get());
                entries.accept(ModItems.REMNANT_SKULL.get());
                entries.accept(ModItems.NETHERITE_EFFIGY.get());
                entries.accept(ModItems.BONE_REPTILE_HELMET.get());
                entries.accept(ModItems.BONE_REPTILE_CHESTPLATE.get());
                entries.accept(ModItems.IGNITIUM_HELMET.get());
                entries.accept(ModItems.IGNITIUM_ELYTRA_CHESTPLATE.get());
                entries.accept(ModItems.IGNITIUM_CHESTPLATE.get());
                entries.accept(ModItems.IGNITIUM_LEGGINGS.get());
                entries.accept(ModItems.IGNITIUM_BOOTS.get());
                entries.accept(ModItems.CURSIUM_HELMET.get());
                entries.accept(ModItems.CURSIUM_CHESTPLATE.get());
                entries.accept(ModItems.CURSIUM_LEGGINGS.get());
                entries.accept(ModItems.CURSIUM_BOOTS.get());
                entries.accept(ModItems.MONSTROUS_HELM.get());
                entries.accept(ModItems.BLOOM_STONE_PAULDRONS.get());
                entries.accept(ModItems.MECH_EYE.get());
                entries.accept(ModItems.FLAME_EYE.get());
                entries.accept(ModItems.VOID_EYE.get());
                entries.accept(ModItems.MONSTROUS_EYE.get());
                entries.accept(ModItems.ABYSS_EYE.get());
                entries.accept(ModItems.DESERT_EYE.get());
                entries.accept(ModItems.CURSED_EYE.get());
                entries.accept(ModItems.STORM_EYE.get());
                entries.accept(ModItems.THE_BABY_LEVIATHAN_BUCKET.get());
                entries.accept(ModItems.MODERN_REMNANT_BUCKET.get());
                entries.accept(ModItems.NETHERITE_MINISTROSITY_BUCKET.get());

                entries.accept(ModItems.MUSIC_DISC_NETHERITE_MONSTROSITY.get());
                entries.accept(ModItems.MUSIC_DISC_ENDER_GUARDIAN.get());
                entries.accept(ModItems.MUSIC_DISC_IGNIS.get());
                entries.accept(ModItems.MUSIC_DISC_THE_HARBINGER.get());
                entries.accept(ModItems.MUSIC_DISC_THE_LEVIATHAN.get());
                entries.accept(ModItems.MUSIC_DISC_ANCIENT_REMNANT.get());
                entries.accept(ModItems.MUSIC_DISC_MALEDICTUS.get());
                entries.accept(ModItems.MUSIC_DISC_SCYLLA.get());
                entries.accept(ModItems.MUSIC_DISC_THE_CATACLYSMFARER.get());
                entries.accept(ModItems.LIONFISH.get());
                entries.accept(ModItems.AMETHYST_CRAB_MEAT.get());
                entries.accept(ModItems.BLESSED_AMETHYST_CRAB_MEAT.get());
                entries.accept(ModItems.AMETHYST_CRAB_SHELL.get());

                entries.accept(ModItems.ENDER_GUARDIAN_SPAWN_EGG.get());
                entries.accept(ModItems.ENDER_GOLEM_SPAWN_EGG.get());
                entries.accept(ModItems.ENDERMAPTERA_SPAWN_EGG.get());
                entries.accept(ModItems.NETHERITE_MONSTROSITY_SPAWN_EGG.get());
                entries.accept(ModItems.NETHERITE_MINISTROSITY_SPAWN_EGG.get());
                entries.accept(ModItems.IGNIS_SPAWN_EGG.get());
                entries.accept(ModItems.IGNITED_REVENANT_SPAWN_EGG.get());
                entries.accept(ModItems.IGNITED_BERSERKER_SPAWN_EGG.get());
                entries.accept(ModItems.THE_HARBINGER_SPAWN_EGG.get());
                entries.accept(ModItems.THE_PROWLER_SPAWN_EGG.get());
                entries.accept(ModItems.THE_WATCHER_SPAWN_EGG.get());
                entries.accept(ModItems.THE_LEVIATHAN_SPAWN_EGG.get());
                entries.accept(ModItems.THE_BABY_LEVIATHAN_SPAWN_EGG.get());
                entries.accept(ModItems.TEDDY_BEAR_SPAWN_EGG.get());
                entries.accept(ModItems.CORALSSUS_SPAWN_EGG.get());
                entries.accept(ModItems.CORAL_GOLEM_SPAWN_EGG.get());
                entries.accept(ModItems.DEEPLING_BRUTE_SPAWN_EGG.get());
                entries.accept(ModItems.DEEPLING_WARLOCK_SPAWN_EGG.get());
                entries.accept(ModItems.DEEPLING_PRIEST_SPAWN_EGG.get());
                entries.accept(ModItems.DEEPLING_ANGLER_SPAWN_EGG.get());
                entries.accept(ModItems.DEEPLING_SPAWN_EGG.get());
                entries.accept(ModItems.LIONFISH_SPAWN_EGG.get());
                entries.accept(ModItems.AMETHYST_CRAB_SPAWN_EGG.get());
                entries.accept(ModItems.ANCIENT_REMNANT_SPAWN_EGG.get());
                entries.accept(ModItems.MODERN_REMNANT_SPAWN_EGG.get());
                entries.accept(ModItems.KOBOLEDIATOR_SPAWN_EGG.get());
                entries.accept(ModItems.WADJET_SPAWN_EGG.get());
                entries.accept(ModItems.KOBOLETON_SPAWN_EGG.get());
                entries.accept(ModItems.MALEDICTUS_SPAWN_EGG.get());
                entries.accept(ModItems.APTRGANGR_SPAWN_EGG.get());
                entries.accept(ModItems.ELITE_DRAUGR_SPAWN_EGG.get());
                entries.accept(ModItems.ROYAL_DRAUGR_SPAWN_EGG.get());
                entries.accept(ModItems.DRAUGR_SPAWN_EGG.get());
                entries.accept(ModItems.SCYLLA_SPAWN_EGG.get());
                entries.accept(ModItems.CLAWDIAN_SPAWN_EGG.get());
                entries.accept(ModItems.HIPPOCAMTUS_SPAWN_EGG.get());
                entries.accept(ModItems.CINDARIA_SPAWN_EGG.get());
                entries.accept(ModItems.URCHINKIN_SPAWN_EGG.get());
                entries.accept(ModItems.OCTOHOST_SPAWN_EGG.get());
                entries.accept(ModItems.SYMBIOCTO_SPAWN_EGG.get());
            })
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .build());


    public static final RegistryObject<CreativeModeTab> BLOCK = DEF_REG.register("cataclysm_block", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Cataclysm.MODID + ".block"))
            .icon(() -> new ItemStack(ModItems.VOID_STONE.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ModItems.ENDERITE_BLOCK.get());
                entries.accept(ModItems.WITHERITE_BLCOK.get());
                entries.accept(ModItems.IGNITIUM_BLOCK.get());
                entries.accept(ModItems.ANCIENT_METAL_BLOCK.get());
                entries.accept(ModItems.CURSIUM_BLOCK.get());
                entries.accept(ModItems.DUNGEON_BLOCK.get());
                entries.accept(ModItems.POLISHED_SANDSTONE.get());
                entries.accept(ModItems.POLISHED_END_STONE.get());
                entries.accept(ModItems.POLISHED_END_STONE_SLAB.get());
                entries.accept(ModItems.POLISHED_END_STONE_STAIRS.get());
                entries.accept(ModItems.CHISELED_END_STONE_BRICKS.get());
                entries.accept(ModItems.END_STONE_PILLAR.get());
                entries.accept(ModItems.VOID_INFUSED_END_STONE_BRICKS.get());
                entries.accept(ModItems.VOID_STONE.get());
                entries.accept(ModItems.VOID_CRYSTAL.get());
                entries.accept(ModItems.VOID_LANTERN_BLOCK.get());
                entries.accept(ModItems.OBSIDIAN_BRICKS.get());
                entries.accept(ModItems.OBSIDIAN_BRICK_SLAB.get());
                entries.accept(ModItems.OBSIDIAN_BRICK_STAIRS.get());
                entries.accept(ModItems.OBSIDIAN_BRICK_WALL.get());
                entries.accept(ModItems.POLISHED_OBSIDIAN.get());
                entries.accept(ModItems.CHISELED_OBSIDIAN_BRICKS.get());

                entries.accept(ModItems.CHISELED_PURPUR_BLOCK.get());
                entries.accept(ModItems.PURPUR_WALL.get());
                entries.accept(ModItems.PURPUR_VOID_RUNE_TRAP_BLOCK.get());
                entries.accept(ModItems.END_STONE_TELEPORT_TRAP_BRICKS.get());
                entries.accept(ModItems.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get());
                entries.accept(ModItems.SANDSTONE_POISON_DART_TRAP.get());
                entries.accept(ModItems.SANDSTONE_IGNITE_TRAP.get());
                entries.accept(ModItems.SANDSTONE_FALLING_TRAP.get());
                entries.accept(ModItems.CHORUS_STEM.get());
                entries.accept(ModItems.CHORUS_PLANKS.get());
                entries.accept(ModItems.CHORUS_SLAB.get());
                entries.accept(ModItems.CHORUS_STAIRS.get());
                entries.accept(ModItems.CHORUS_FENCE.get());
                entries.accept(ModItems.PRISMARINE_BRICK_FENCE.get());
                entries.accept(ModItems.QUARTZ_BRICK_WALL.get());
                entries.accept(ModItems.PRISMARINE_BRICK_WALL.get());
                entries.accept(ModItems.STONE_PILLAR.get());
                entries.accept(ModItems.CHISELED_STONE_BRICK_PILLAR.get());
                entries.accept(ModItems.STONE_TILES.get());
                entries.accept(ModItems.STONE_TILE_SLAB.get());
                entries.accept(ModItems.STONE_TILE_STAIRS.get());
                entries.accept(ModItems.STONE_TILE_WALL.get());
                entries.accept(ModItems.BLACKSTONE_PILLAR.get());
                entries.accept(ModItems.AZURE_SEASTONE.get());
                entries.accept(ModItems.AZURE_SEASTONE_SLAB.get());
                entries.accept(ModItems.AZURE_SEASTONE_STAIRS.get());
                entries.accept(ModItems.AZURE_SEASTONE_WALL.get());
                entries.accept(ModItems.AZURE_SEASTONE_FENCE.get());
                entries.accept(ModItems.AZURE_SEASTONE_TILES.get());
                entries.accept(ModItems.CHISELED_AZURE_SEASTONE.get());
                entries.accept(ModItems.AZURE_SEASTONE_BRICKS.get());
                entries.accept(ModItems.AZURE_SEASTONE_BRICK_SLAB.get());
                entries.accept(ModItems.AZURE_SEASTONE_BRICK_STAIRS.get());
                entries.accept(ModItems.AZURE_SEASTONE_BRICK_WALL.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_EMPTY.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_URCHINKIN.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_CINDARIA.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_HIPPOCAMTUS.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_CLAWDIAN.get());

                entries.accept(ModItems.AZURE_SEASTONE_MURAL_THUNDER.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_SEA.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_UNDERWORLD.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_HARVEST.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_WISDOM.get());
                entries.accept(ModItems.AZURE_SEASTONE_MURAL_SMITHING.get());

                entries.accept(ModItems.CURVED_SEASTONE_SCYLLA_7.get());
                entries.accept(ModItems.CURVED_SEASTONE_SCYLLA_8.get());
                entries.accept(ModItems.CURVED_SEASTONE_SCYLLA_9.get());

                entries.accept(ModItems.CURVED_SEASTONE_CLAWDIAN_3.get());
                entries.accept(ModItems.CURVED_SEASTONE_CLAWDIAN_4.get());

                entries.accept(ModItems.CURVED_SEASTONE_HIPPOCAMTUS_3.get());
                entries.accept(ModItems.CURVED_SEASTONE_HIPPOCAMTUS_4.get());

                entries.accept(ModItems.CURVED_SEASTONE_CINDARIA_3.get());
                entries.accept(ModItems.CURVED_SEASTONE_CINDARIA_4.get());

                entries.accept(ModItems.CURVED_SEASTONE_SCYLLA_4.get());
                entries.accept(ModItems.CURVED_SEASTONE_SCYLLA_5.get());
                entries.accept(ModItems.CURVED_SEASTONE_SCYLLA_6.get());

                entries.accept(ModItems.CURVED_SEASTONE_CLAWDIAN_1.get());
                entries.accept(ModItems.CURVED_SEASTONE_CLAWDIAN_2.get());

                entries.accept(ModItems.CURVED_SEASTONE_HIPPOCAMTUS_1.get());
                entries.accept(ModItems.CURVED_SEASTONE_HIPPOCAMTUS_2.get());

                entries.accept(ModItems.CURVED_SEASTONE_CINDARIA_1.get());
                entries.accept(ModItems.CURVED_SEASTONE_CINDARIA_2.get());

                entries.accept(ModItems.CURVED_SEASTONE_SCYLLA_1.get());
                entries.accept(ModItems.CURVED_SEASTONE_SCYLLA_2.get());
                entries.accept(ModItems.CURVED_SEASTONE_SCYLLA_3.get());

                entries.accept(ModItems.CURVED_SEASTONE_URCHINKIN.get());




                entries.accept(ModItems.POLISHED_AZURE_SEASTONE.get());
                entries.accept(ModItems.POLISHED_AZURE_SEASTONE_SLAB.get());
                entries.accept(ModItems.POLISHED_AZURE_SEASTONE_STAIRS.get());
                entries.accept(ModItems.POLISHED_AZURE_SEASTONE_WALL.get());
                entries.accept(ModItems.AZURE_SEASTONE_PILLAR.get());
                entries.accept(ModItems.AZURE_SEASTONE_PILLAR_WALL.get());
                entries.accept(ModItems.CHISELED_AZURE_SEASTONE_PILLAR.get());
                entries.accept(ModItems.CHISELED_AZURE_SEASTONE_PILLAR_WALL.get());
                entries.accept(ModItems.FROSTED_STONE_BRICKS.get());
                entries.accept(ModItems.FROSTED_STONE_BRICK_SLAB.get());
                entries.accept(ModItems.FROSTED_STONE_BRICK_STAIRS.get());
                entries.accept(ModItems.FROSTED_STONE_BRICK_WALL.get());
                entries.accept(ModItems.BLACK_STEEL_BLOCK.get());
                entries.accept(ModItems.BLACK_STEEL_FENCE.get());
                entries.accept(ModItems.BLACK_STEEL_WALL.get());
                entries.accept(ModItems.POINTED_ICICLE.get());
                entries.accept(ModBlocks.ALTAR_OF_FIRE.get().asItem());
                entries.accept(ModBlocks.ALTAR_OF_VOID.get().asItem());
                entries.accept(ModBlocks.ALTAR_OF_AMETHYST.get().asItem());
                entries.accept(ModBlocks.ALTAR_OF_ABYSS.get().asItem());
                entries.accept(ModBlocks.CURSED_TOMBSTONE.get().asItem());
                entries.accept(ModBlocks.EMP.get().asItem());
                entries.accept(ModBlocks.MECHANICAL_FUSION_ANVIL.get().asItem());
                entries.accept(ModBlocks.DOOR_OF_SEAL.get().asItem());
                entries.accept(ModBlocks.GODDESS_STATUE.get().asItem());
                entries.accept(ModBlocks.ABYSSAL_EGG.get().asItem());
                entries.accept(ModItems.APTRGANGR_HEAD.get());
                entries.accept(ModItems.DRAUGR_HEAD.get());
                entries.accept(ModItems.KOBOLEDIATOR_SKULL.get());
                entries.accept(ModItems.PURPUR_TILES.get());
                entries.accept(ModItems.PURPUR_TILE_SLAB.get());
                entries.accept(ModItems.PURPUR_TILE_STAIRS.get());
                entries.accept(ModItems.PURPUR_TILE_WALL.get());
                entries.accept(ModItems.PURPUR_TILE_PILLAR.get());
                entries.accept(ModItems.VOID_PURPUR_TILES.get());
                entries.accept(ModItems.POLISHED_OBSIDIAN_SLAB.get());
                entries.accept(ModItems.POLISHED_OBSIDIAN_STAIRS.get());
                entries.accept(ModItems.POLISHED_OBSIDIAN_WALL.get());
                entries.accept(ModItems.OBSIDIAN_PILLAR.get());
                entries.accept(ModItems.CHORUS_TRAPDOOR.get());
            })
            .withTabsBefore(ITEM.getKey())
            .build());



}

