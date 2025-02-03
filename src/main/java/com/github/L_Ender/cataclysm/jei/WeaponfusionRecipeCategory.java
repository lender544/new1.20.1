package com.github.L_Ender.cataclysm.jei;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class WeaponfusionRecipeCategory implements IRecipeCategory<WeaponfusionRecipe> {
    private final IDrawable background;
    private final IDrawable icon;
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/gui/fusion.png");

    public WeaponfusionRecipeCategory(IGuiHelper guiHelper) {
        background = guiHelper.createDrawable(TEXTURE,26, 46, 125, 18);
        icon = guiHelper.createDrawableItemStack(new ItemStack(ModBlocks.MECHANICAL_FUSION_ANVIL.get()));
    }

    @Override
    public RecipeType<WeaponfusionRecipe> getRecipeType() {
        return LEnderCataclysmJEIPlugin.WEAPON_FUSION;
    }

    @Override
    public Component getTitle() {
        return ModBlocks.MECHANICAL_FUSION_ANVIL.get().getName();
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WeaponfusionRecipe recipe, IFocusGroup focuses) {

        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addIngredients(recipe.getbaseIngredient());

        builder.addSlot(RecipeIngredientRole.INPUT, 50, 1)
                .addIngredients(recipe.getAdditionIngredient());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 1)
                .addItemStack(recipe.getResultItem(RegistryAccess.EMPTY));
    }

    @Override
    public boolean isHandled(WeaponfusionRecipe recipe) {
        return !recipe.isSpecial();
    }
}
