package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.world.CMMobSpawnBiomeModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModBiomeModifiers {
	public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Cataclysm.MODID);

	public static final DeferredHolder<MapCodec<? extends BiomeModifier>, MapCodec<CMMobSpawnBiomeModifier>> CM_MOB_SPAWN_BIOME_MODIFIER_TYPE = BIOME_MODIFIER_SERIALIZERS.register("cataclysm_mob_spawns", () -> MapCodec.unit(CMMobSpawnBiomeModifier.INSTANCE));

}
