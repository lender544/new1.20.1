package com.github.L_Ender.cataclysm.config;


import com.github.L_Ender.lionfishapi.config.biome.BiomeEntryType;
import com.github.L_Ender.lionfishapi.config.biome.SpawnBiomeData;

public class DefaultBiomes {

    public static final SpawnBiomeData EMPTY = new SpawnBiomeData();

    public static final SpawnBiomeData DEEPLING = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_ocean", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_lukewarm_ocean", 1)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_cold_ocean", 2)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:ocean", 3)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:lukewarm_ocean", 4)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:warm_ocean", 5)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "alexscaves:abyssal_chasm", 6);


    public static final SpawnBiomeData CRAB = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:lush_caves", 0);

    public static final SpawnBiomeData KOBOLETON = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_dry/overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_hot/overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_sandy", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, true, "minecraft:is_badlands", 0);
}
