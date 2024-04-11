package com.github.L_Ender.cataclysm.world;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.config.BiomeConfig;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.config.biome.SpawnBiomeData;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.common.world.ModifiableStructureInfo;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = Cataclysm.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CMWorldRegistry {

    private static ResourceLocation getBiomeName(Holder<Biome> biome) {
        return biome.unwrap().map((resourceKey) -> resourceKey.location(), (noKey) -> null);
    }

    public static boolean testBiome(Pair<String, SpawnBiomeData> entry, Holder<Biome> biome) {
        boolean result = false;
        try {
            result = BiomeConfig.test(entry, biome, getBiomeName(biome));
        } catch (Exception e) {
            Cataclysm.LOGGER.warn("could not test biome config for " + entry.getLeft() + ", defaulting to no spawns for mob");
            result = false;
        }
        return result;
    }

    public static void addBiomeSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (testBiome(BiomeConfig.deepling, biome) && CMConfig.DeeplingSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING.get(), CMConfig.DeeplingSpawnWeight, 1, 1));
        }
        if (testBiome(BiomeConfig.deepling_angler, biome) && CMConfig.DeeplingAnglerSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_ANGLER.get(), CMConfig.DeeplingAnglerSpawnWeight, 1, 1));
        }
        if (testBiome(BiomeConfig.deepling_brute, biome) && CMConfig.DeeplingBruteSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_BRUTE.get(), CMConfig.DeeplingBruteSpawnWeight, 1, 1));
        }

        if (testBiome(BiomeConfig.deepling_priest, biome) && CMConfig.DeeplingPriestSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_PRIEST.get(), CMConfig.DeeplingPriestSpawnWeight, 1, 1));
        }

        if (testBiome(BiomeConfig.deepling_warlock, biome) && CMConfig.DeeplingWarlockSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.DEEPLING_WARLOCK.get(), CMConfig.DeeplingWarlockSpawnWeight, 1, 1));
        }


        if (testBiome(BiomeConfig.amethyst_crab, biome) && CMConfig.AmethystCrabSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.AMETHYST_CRAB.get(), CMConfig.AmethystCrabSpawnWeight, 1, 1));
        }

        if (testBiome(BiomeConfig.koboleton, biome) && CMConfig.KoboletonSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(ModEntities.KOBOLETON.get(), CMConfig.KoboletonSpawnWeight, 1, 2));
        }

    }

    public static void modifyStructure(Holder<Structure> structure, ModifiableStructureInfo.StructureInfo.Builder builder) {
        if (structure.is(ModTag.BERSERKER_SPAWN) && CMConfig.IgnitedBerserkerSpawnWeight > 0) {
            builder.getStructureSettings().getOrAddSpawnOverrides(MobCategory.MONSTER).addSpawn(new MobSpawnSettings.SpawnerData(ModEntities.IGNITED_BERSERKER.get(), CMConfig.IgnitedBerserkerSpawnWeight, 1, 1));
        }
    }

}
