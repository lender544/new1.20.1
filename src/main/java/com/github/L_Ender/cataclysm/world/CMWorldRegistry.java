package com.github.L_Ender.cataclysm.world;

import com.github.L_Ender.cataclysm.config.CMCommonConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.structure.Structure;

import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import net.neoforged.neoforge.common.world.ModifiableStructureInfo;

public class CMWorldRegistry {


    public static void addBiomeSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING.get(), CMCommonConfig.Spawning.DeeplingSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN)  && CMCommonConfig.Spawning.DeeplingAnglerSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_ANGLER.get(), CMCommonConfig.Spawning.DeeplingAnglerSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN)  && CMCommonConfig.Spawning.DeeplingBruteSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_BRUTE.get(), CMCommonConfig.Spawning.DeeplingBruteSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.DeeplingPriestSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_PRIEST.get(), CMCommonConfig.Spawning.DeeplingPriestSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.DEEPLINGS_SPAWN)  && CMCommonConfig.Spawning.DeeplingWarlockSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_WARLOCK.get(), CMCommonConfig.Spawning.DeeplingWarlockSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMCommonConfig.Spawning.CoralgolemSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.CORAL_GOLEM.get(), CMCommonConfig.Spawning.CoralgolemSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.AMETHYST_CRAB_SPAWN) && CMCommonConfig.Spawning.AmethystCrabSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.AMETHYST_CRAB.get(), CMCommonConfig.Spawning.AmethystCrabSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.KOBOLETON_SPAWN) && CMCommonConfig.Spawning.KoboletonSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.KOBOLETON.get(), CMCommonConfig.Spawning.KoboletonSpawnWeight, 2, 3));
        }

    }

    public static void modifyStructure(Holder<Structure> structure, ModifiableStructureInfo.StructureInfo.Builder builder) {
        if (structure.is(ModTag.BERSERKER_SPAWN) && CMCommonConfig.Spawning.IgnitedBerserkerSpawnWeight > 0) {
            builder.getStructureSettings().getOrAddSpawnOverrides(MobCategory.MONSTER).addSpawn(new MobSpawnSettings.SpawnerData(ModEntities.IGNITED_BERSERKER.get(), CMCommonConfig.Spawning.IgnitedBerserkerSpawnWeight, 1, 1));
        }
    }

}
