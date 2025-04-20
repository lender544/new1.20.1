package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.world.structures.placements.CataclysmRandomSpread;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public final class ModStructurePlacementType {
    public static final DeferredRegister<StructurePlacementType<?>> STRUCTURE_PLACEMENT_TYPE = DeferredRegister.create(Registries.STRUCTURE_PLACEMENT, Cataclysm.MODID);

    public static final RegistryObject<StructurePlacementType<CataclysmRandomSpread>> CATACLYSM_RANDOM_SPREAD = STRUCTURE_PLACEMENT_TYPE.register("cataclysm_random_spread", () -> () -> CataclysmRandomSpread.CODEC);
}
