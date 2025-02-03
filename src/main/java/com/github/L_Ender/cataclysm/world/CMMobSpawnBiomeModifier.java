package com.github.L_Ender.cataclysm.world;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModBiomeModifiers;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


public class CMMobSpawnBiomeModifier implements BiomeModifier {

    public static final CMMobSpawnBiomeModifier INSTANCE = new CMMobSpawnBiomeModifier();


    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD) {
            CMWorldRegistry.addBiomeSpawns(biome, builder);
        }
    }


    @Override
    public MapCodec<? extends BiomeModifier> codec() {
        return ModBiomeModifiers.CM_MOB_SPAWN_BIOME_MODIFIER_TYPE.get();
    }
}
