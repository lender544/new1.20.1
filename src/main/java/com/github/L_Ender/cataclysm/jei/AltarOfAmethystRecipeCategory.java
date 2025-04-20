package com.github.L_Ender.cataclysm.jei;

import com.github.L_Ender.cataclysm.crafting.AltarOfAmethystRecipe;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
public class AltarOfAmethystRecipeCategory implements IRecipeCategory<AltarOfAmethystRecipe> {
    private final IDrawable background;
    private final IDrawable icon;

    public AltarOfAmethystRecipeCategory(IGuiHelper guiHelper) {
        background = new AltarOfAmethystDrawable();
        icon = guiHelper.createDrawableItemStack(new ItemStack(ModBlocks.ALTAR_OF_AMETHYST.get()));
    }

    @Override
    public RecipeType<AltarOfAmethystRecipe> getRecipeType() {
        return LEnderCataclysmJEIPlugin.ALTAR_OF_AMETHYST_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return ModBlocks.ALTAR_OF_AMETHYST.get().getName().append(Component.literal(" ")).append(Component.translatable("cataclysm.gui.altar_of_amethyst_blessing"));
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
    public void setRecipe(IRecipeLayoutBuilder builder, AltarOfAmethystRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 21, 23).addIngredients(recipe.getbaseIngredient());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 94, 23).addItemStack(recipe.getResult());
    }

    @Override
    public boolean isHandled(AltarOfAmethystRecipe recipe) {
        return true;
    }
}

