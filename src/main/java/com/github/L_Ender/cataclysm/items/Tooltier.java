package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;

import net.neoforged.neoforge.common.SimpleTier;

import java.util.Locale;


public class Tooltier {

    private static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, name.toLowerCase(Locale.ROOT));
    }


    public static final Tier ANCIENT_METAL = new
            SimpleTier(BlockTags.create(prefix("needs_ancient_metal_tool")), 750, 8.0F, 2.0F, 25, () -> Ingredient.of(ModItems.ANCIENT_METAL_INGOT.get()));


    public static final Tier BLACK_STEEL = new
            SimpleTier(BlockTags.create(prefix("needs_black_steel_tool")), 750, 8.0F, 2.0F, 25, () -> Ingredient.of(ModItems.BLACK_STEEL_INGOT.get()));


    public static final Tier MONSTROSITY = new
            SimpleTier(BlockTags.create(prefix("needs_monstrosity_tool")), 2800, 9.0F, 4.0F, 25, () -> Ingredient.of(ModItems.MONSTROUS_HORN.get()));


}



