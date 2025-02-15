package com.github.L_Ender.cataclysm.world;


import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.structure.Structure;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import net.neoforged.neoforge.common.world.ModifiableStructureInfo;
import org.apache.commons.lang3.tuple.Pair;

public class CMWorldRegistry {




    public static void addBiomeSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMConfig.DeeplingSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING.get(), CMConfig.DeeplingSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN)  && CMConfig.DeeplingAnglerSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_ANGLER.get(), CMConfig.DeeplingAnglerSpawnWeight, 1, 1));
        }
        if (biome.is(ModTag.DEEPLINGS_SPAWN)  && CMConfig.DeeplingBruteSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_BRUTE.get(), CMConfig.DeeplingBruteSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMConfig.DeeplingPriestSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_PRIEST.get(), CMConfig.DeeplingPriestSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.DEEPLINGS_SPAWN)  && CMConfig.DeeplingWarlockSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_WARLOCK.get(), CMConfig.DeeplingWarlockSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.DEEPLINGS_SPAWN) && CMConfig.CoralgolemSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.CORAL_GOLEM.get(), CMConfig.CoralgolemSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.AMETHYST_CRAB_SPAWN) && CMConfig.AmethystCrabSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.AMETHYST_CRAB.get(), CMConfig.AmethystCrabSpawnWeight, 1, 1));
        }

        if (biome.is(ModTag.KOBOLETON_SPAWN) && CMConfig.KoboletonSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.KOBOLETON.get(), CMConfig.KoboletonSpawnWeight, 2, 3));
        }

    }

    public static void modifyStructure(Holder<Structure> structure, ModifiableStructureInfo.StructureInfo.Builder builder) {
        if (structure.is(ModTag.BERSERKER_SPAWN) && CMConfig.IgnitedBerserkerSpawnWeight > 0) {
            builder.getStructureSettings().getOrAddSpawnOverrides(MobCategory.MONSTER).addSpawn(new MobSpawnSettings.SpawnerData(ModEntities.IGNITED_BERSERKER.get(), CMConfig.IgnitedBerserkerSpawnWeight, 1, 1));
        }
    }

}
