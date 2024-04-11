package com.github.L_Ender.cataclysm.jei;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.L_Ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModMenu;
import com.github.L_Ender.cataclysm.inventory.WeaponfusionMenu;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class LEnderCataclysmJEIPlugin implements IModPlugin {
    public static final ResourceLocation MOD = new ResourceLocation(Cataclysm.MODID, "jei_plugin");

    public static final RecipeType<WeaponfusionRecipe> WEAPON_FUSION = RecipeType.create(Cataclysm.MODID, "weapon_infusion", WeaponfusionRecipe.class);

    public static final RecipeType<AltarOfAmethystRecipe> ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE = RecipeType.create(Cataclysm.MODID, "altar_of_amethyst", AltarOfAmethystRecipe.class);

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new WeaponfusionRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new AltarOfAmethystRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
    }

    public ResourceLocation getPluginUid() {
        return MOD;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        CMRecipes modRecipes = new CMRecipes();
        registration.addRecipes(WEAPON_FUSION, modRecipes.getWeaponfusionRecipes());
        registration.addRecipes(ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE, modRecipes.getAmethystBlessRecipes());
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(WeaponfusionMenu.class, ModMenu.WEAPON_FUSION.get(), WEAPON_FUSION, 0, 6, 9, 36);

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MECHANICAL_FUSION_ANVIL.get()), WEAPON_FUSION);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ALTAR_OF_AMETHYST.get()), ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE);

    }
}
