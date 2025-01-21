package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface RangeTool {


    ResourceLocation BASE_ENTITY_INTERACTION_RANGE_ID = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"base_entity_interaction_range");
    ResourceLocation BASE_BLOCK_INTERACTION_RANGE_ID = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"base_block_interaction_range");

    ResourceLocation BASE_ENTITY_ARMOR_ID = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"base_armor_range");
    ResourceLocation BASE_ENTITY_ARMOR_TOUGHNESS_ID = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"base_armor_toughness_range");

    ResourceLocation BASE_ENTITY_KNOCKBACK_RESISTANCE_ID = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"base_knockback_resistance");


}
