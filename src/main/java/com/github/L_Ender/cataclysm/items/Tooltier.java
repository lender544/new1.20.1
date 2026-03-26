package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;


import java.util.List;
import java.util.Locale;


public class Tooltier {

    private static ResourceLocation prefix(String name) {
        return new ResourceLocation(Cataclysm.MODID, name.toLowerCase(Locale.ROOT));
    }


    public static final Tier ANCIENT_METAL = TierSortingRegistry.registerTier(
            new ForgeTier(3, 750, 8F, 2, 25,
                    BlockTags.create(prefix("needs_ancient_metal_tool")), () -> Ingredient.of(ModItems.ANCIENT_METAL_INGOT.get())),
            prefix("ancient_metal"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier BLACK_STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(3, 750, 8F, 2, 25,
                    BlockTags.create(prefix("needs_black_steel_tool")), () -> Ingredient.of(ModItems.BLACK_STEEL_INGOT.get())),
            prefix("black_steel"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier MONSTROSITY = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2800, 9F, 4, 25,
                    BlockTags.create(prefix("needs_monstrosity_tool")), () -> Ingredient.of(ModItems.MONSTROUS_HORN.get())),
            prefix("monstrosity"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier CURSIUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2800, 9F, 2, 16,
                    BlockTags.create(prefix("needs_cursium_tool")), () -> Ingredient.of(ModItems.CURSIUM_INGOT.get())),
            prefix("cursium"), List.of(Tiers.NETHERITE),  List.of());

    public static final Tier IGNITIUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2800, 9F, 2, 16,
                    BlockTags.create(prefix("needs_ignitium_tool")), () -> Ingredient.of(ModItems.IGNITIUM_INGOT.get())),
            prefix("ignitium"), List.of(Tiers.NETHERITE),  List.of());

    public static final Tier SCYLLA = TierSortingRegistry.registerTier(
            new ForgeTier(4, 2800, 9F, 2, 16,
                    BlockTags.create(prefix("needs_scylla_tool")), () -> Ingredient.of(ModItems.LACRIMA.get())),
            prefix("scylla"), List.of(Tiers.NETHERITE),  List.of());

}



