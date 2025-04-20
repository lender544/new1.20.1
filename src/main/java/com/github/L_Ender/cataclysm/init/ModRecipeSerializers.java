package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.L_Ender.cataclysm.crafting.WeaponfusionRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeSerializers
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Cataclysm.MODID);

	public static final RegistryObject<RecipeSerializer<?>> WEAPON_FUSION = RECIPE_SERIALIZERS.register("weapon_fusion", WeaponfusionRecipe.Serializer::new);

	public static final RegistryObject<RecipeSerializer<?>> AMETHYST_BLESS = RECIPE_SERIALIZERS.register("amethyst_bless", AltarOfAmethystRecipe.Serializer::new);

}
