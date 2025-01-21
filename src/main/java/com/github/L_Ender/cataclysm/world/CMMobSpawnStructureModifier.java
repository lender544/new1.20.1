package com.github.L_Ender.cataclysm.world;

import com.github.L_Ender.cataclysm.Cataclysm;

import com.github.L_Ender.cataclysm.init.ModBiomeModifiers;
import com.github.L_Ender.cataclysm.init.ModStructureModifiers;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableStructureInfo;
import net.neoforged.neoforge.common.world.NoneStructureModifier;
import net.neoforged.neoforge.common.world.StructureModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


public class CMMobSpawnStructureModifier implements StructureModifier {

    public static final CMMobSpawnStructureModifier INSTANCE = new CMMobSpawnStructureModifier();

    @Override
    public void modify(Holder<Structure> structure, Phase phase, ModifiableStructureInfo.StructureInfo.Builder builder) {
        if (phase == Phase.ADD) {
            CMWorldRegistry.modifyStructure(structure, builder);

        }
    }

    @Override
    public MapCodec<? extends StructureModifier> codec() {
        return ModStructureModifiers.ADD_SPAWNS_STRUCTURE_MODIFIER_TYPE.get();
    }


}
