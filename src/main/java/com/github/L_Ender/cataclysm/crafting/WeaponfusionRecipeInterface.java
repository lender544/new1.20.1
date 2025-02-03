package com.github.L_Ender.cataclysm.crafting;

import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public interface WeaponfusionRecipeInterface extends Recipe<WeaponfusionRecipeInput> {
    @Override
    default RecipeType<?> getType() {
        return ModRecipeTypes.WEAPON_FUSION.get();
    }

    @Override
    default boolean canCraftInDimensions(int p_44528_, int p_44529_) {
        return p_44528_ * p_44529_ >= 2;
    }


    @Override
    default ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.MECHANICAL_FUSION_ANVIL.get());
    }


    boolean isBaseIngredient(ItemStack pStack);

    boolean isAdditionIngredient(ItemStack pStack);

}
