package com.github.L_Ender.cataclysm.config;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.lionfishapi.config.biome.SpawnBiomeConfig;
import com.github.L_Ender.lionfishapi.config.biome.SpawnBiomeData;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BiomeConfig {

	public static final Pair<String, SpawnBiomeData> deepling = Pair.of("cataclysm:deepling_spawns", DefaultBiomes.DEEPLING);
	public static final Pair<String, SpawnBiomeData> deepling_angler = Pair.of("cataclysm:deepling_angler_spawns", DefaultBiomes.DEEPLING);
	public static final Pair<String, SpawnBiomeData> coral_golem = Pair.of("cataclysm:coral_golem_spawns", DefaultBiomes.DEEPLING);
	public static final Pair<String, SpawnBiomeData> deepling_brute = Pair.of("cataclysm:deepling_brute_spawns", DefaultBiomes.DEEPLING);
	public static final Pair<String, SpawnBiomeData> deepling_priest = Pair.of("cataclysm:deepling_priest_spawns", DefaultBiomes.DEEPLING);
	public static final Pair<String, SpawnBiomeData> deepling_warlock = Pair.of("cataclysm:deepling_warlock_spawns", DefaultBiomes.DEEPLING);
	public static final Pair<String, SpawnBiomeData> amethyst_crab = Pair.of("cataclysm:amethyst_crab_spawns", DefaultBiomes.CRAB);
	public static final Pair<String, SpawnBiomeData> koboleton = Pair.of("cataclysm:koboleton_spawns", DefaultBiomes.KOBOLETON);

	private static boolean init = false;
	private static final Map<String, SpawnBiomeData> biomeConfigValues = new HashMap<>();

    public static void init() {
        try {
            for (Field f : BiomeConfig.class.getDeclaredFields()) {
                Object obj = f.get(null);
               if(obj instanceof Pair){
				   String id = (String)((Pair) obj).getLeft();
				   SpawnBiomeData data = (SpawnBiomeData)((Pair) obj).getRight();
				   biomeConfigValues.put(id, SpawnBiomeConfig.create(new ResourceLocation(id), data));
               }
            }
        }catch (Exception e){
            Cataclysm.LOGGER.warn("Encountered error building cataclysm biome config .json files");
            e.printStackTrace();
        }
		init = true;
    }

    public static boolean test(Pair<String, SpawnBiomeData> entry, Holder<Biome> biome, ResourceLocation name){
    	if(!init){
    		return false;
		}
		return biomeConfigValues.get(entry.getKey()).matches(biome, name);
	}

	public static boolean test(Pair<String, SpawnBiomeData> spawns, Holder<Biome> biome) {
		return test(spawns, biome, ForgeRegistries.BIOMES.getKey(biome.value()));
	}
}
