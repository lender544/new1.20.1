package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.world.structures.placements.CataclysmRandomSpread;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public final class ModStructurePlacementType {


    public static final DeferredRegister<StructurePlacementType<?>> STRUCTURE_PLACEMENT_TYPES = DeferredRegister.create(Registries.STRUCTURE_PLACEMENT,   Cataclysm.MODID);

    public static final DeferredHolder<StructurePlacementType<?>, StructurePlacementType<CataclysmRandomSpread>> ADVANCED_RANDOM_SPREAD = registerPlacer("cataclysm_random_spread", () -> () -> CataclysmRandomSpread.CODEC);

    private static <P extends StructurePlacement> DeferredHolder<StructurePlacementType<?>, StructurePlacementType<P>> registerPlacer(String name, Supplier<StructurePlacementType<P>> factory) {
        return STRUCTURE_PLACEMENT_TYPES.register(name, factory);
    }


}

