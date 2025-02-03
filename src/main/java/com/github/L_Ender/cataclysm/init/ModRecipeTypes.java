package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.L_Ender.cataclysm.crafting.WeaponfusionRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModRecipeTypes
{
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, Cataclysm.MODID);

	public static final DeferredHolder<RecipeType<?>, RecipeType<WeaponfusionRecipe>> WEAPON_FUSION = RECIPE_TYPES.register("weapon_fusion", () -> registerRecipeType("weapon_fusion"));

	public static final DeferredHolder<RecipeType<?>,RecipeType<AltarOfAmethystRecipe>> AMETHYST_BLESS = RECIPE_TYPES.register("amethyst_bless", () -> registerRecipeType("amethyst_bless"));



	public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
		return new RecipeType<>()
		{
			public String toString() {
				return Cataclysm.MODID + ":" + identifier;
			}
		};
	}
}
