package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.L_Ender.cataclysm.crafting.WeaponfusionRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipeSerializers
{


	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Cataclysm.MODID);

	public static final DeferredHolder<RecipeSerializer<?>,WeaponfusionRecipe.Serializer> WEAPON_FUSION = RECIPE_SERIALIZERS.register("weapon_fusion", WeaponfusionRecipe.Serializer::new);

	public static final DeferredHolder<RecipeSerializer<?>,AltarOfAmethystRecipe.Serializer> AMETHYST_BLESS = RECIPE_SERIALIZERS.register("amethyst_bless", AltarOfAmethystRecipe.Serializer::new);

}
