package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {

    TOOL_WITHERITE(5, 6666, 11.F, 7, 12, ModItems.WITHERITE_INGOT),
    TOOL_ENDERITE(5, 6666, 11.0F, 7, 12, ModItems.ENDERITE_INGOT);

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Item> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Supplier<Item> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = damage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(repairMaterial.get());
    }

}