package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.L_Ender.cataclysm.structures.jisaw.CataclysmPoolElement;
import com.github.L_Ender.cataclysm.structures.jisaw.FallbackPoolElement;
import com.github.L_Ender.cataclysm.structures.jisaw.element.CataclysmJigsawSinglePoolElement;
import com.github.L_Ender.cataclysm.world.structures.placements.CataclysmRandomSpread;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacementType;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModJigsaw {

    public static final DeferredRegister<StructurePoolElementType<?>> STRUCTURE_POOL_ELEMENT = DeferredRegister.create(BuiltInRegistries.STRUCTURE_POOL_ELEMENT, Cataclysm.MODID);

    public static final DeferredHolder<StructurePoolElementType<?>, StructurePoolElementType<CataclysmJigsawSinglePoolElement>> CATACLYSM_ELEMENT = STRUCTURE_POOL_ELEMENT.register("cataclysm_element",() -> () -> CataclysmJigsawSinglePoolElement.CODEC);

}
