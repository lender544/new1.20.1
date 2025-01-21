package com.github.L_Ender.cataclysm.crafting;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record WeaponfusionRecipeInput(ItemStack base, ItemStack addition) implements RecipeInput {

    @Override
    public ItemStack getItem(int p_346205_) {
        return switch (p_346205_) {
            case 0 -> this.base;
            case 1 -> this.addition;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + p_346205_);
        };
    }

    public int size() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return this.base.isEmpty() && this.addition.isEmpty();
    }

}
