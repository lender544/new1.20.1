package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.world.CMMobSpawnBiomeModifier;
import com.github.L_Ender.cataclysm.world.CMMobSpawnStructureModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.StructureModifier;
import net.neoforged.neoforge.common.world.StructureModifiers;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModStructureModifiers {
	public static final DeferredRegister<MapCodec<? extends StructureModifier>> STRUCTURE_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, Cataclysm.MODID);


	public static final DeferredHolder<MapCodec<? extends StructureModifier>, MapCodec<CMMobSpawnStructureModifier>> ADD_SPAWNS_STRUCTURE_MODIFIER_TYPE = STRUCTURE_MODIFIER_SERIALIZERS.register("cataclysm_structure_spawns", () -> MapCodec.unit(CMMobSpawnStructureModifier.INSTANCE));

}
