package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface RangeTool {


    ResourceLocation BASE_ENTITY_INTERACTION_RANGE_ID = new ResourceLocation(Cataclysm.MODID,"base_entity_interaction_range");
    ResourceLocation BASE_BLOCK_INTERACTION_RANGE_ID = new ResourceLocation(Cataclysm.MODID,"base_block_interaction_range");

    ResourceLocation BASE_ENTITY_ARMOR_ID = new ResourceLocation(Cataclysm.MODID,"base_armor_range");
    ResourceLocation BASE_ENTITY_ARMOR_TOUGHNESS_ID = new ResourceLocation(Cataclysm.MODID,"base_armor_toughness_range");

    ResourceLocation BASE_ENTITY_KNOCKBACK_RESISTANCE_ID = new ResourceLocation(Cataclysm.MODID,"base_knockback_resistance");

    ResourceLocation BASE_ENTITY_CRITICAL_DAMAGE_ID = new ResourceLocation(Cataclysm.MODID,"base_critical_damage");
}
