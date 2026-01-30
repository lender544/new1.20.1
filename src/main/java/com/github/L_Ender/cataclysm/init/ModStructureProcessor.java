package com.github.L_Ender.cataclysm.init;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.world.structures.Processor.WaterlogWhenReplacingWaterProcessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public final class ModStructureProcessor {

    public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSOR = DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, Cataclysm.MODID);

    public static final DeferredHolder<StructureProcessorType<?>, StructureProcessorType<WaterlogWhenReplacingWaterProcessor>> WATERLOGGING_WHEN_REPLACING_WATER_PROCESSOR = STRUCTURE_PROCESSOR.register("waterlogging_when_replacing_water_processor", () -> () -> WaterlogWhenReplacingWaterProcessor.CODEC);


}
