package com.github.L_Ender.cataclysm.crafting;

import com.github.L_Ender.cataclysm.init.ModRecipeSerializers;
import com.github.L_Ender.cataclysm.init.ModRecipeTypes;
import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class AltarOfAmethystRecipe implements Recipe<Container> {
    private final Ingredient ingredients;
    private ItemStack result;
    private int time;
    private final ResourceLocation id;

    public AltarOfAmethystRecipe(ResourceLocation p_44523_,Ingredient ingredients, ItemStack result, int time) {
        this.id = p_44523_;
        this.ingredients = ingredients;
        this.result = result;
        this.time = time;
    }

    public ItemStack getResult() {
        return result;
    }

    @Override
    public boolean matches(Container p_44002_, Level p_44003_) {
        return this.ingredients.test(p_44002_.getItem(0));
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    public Ingredient getbaseIngredient() {
        return this.ingredients;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return this.result;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.AMETHYST_BLESS.get();
    }

    public RecipeType<?> getType() {
        return ModRecipeTypes.AMETHYST_BLESS.get();
    }

    public int getTime() {
        return time;
    }


    public static class Serializer implements RecipeSerializer<AltarOfAmethystRecipe> {

        public AltarOfAmethystRecipe fromJson(ResourceLocation p_44562_, JsonObject p_44563_) {
            Ingredient ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(p_44563_, "ingredients"));
            ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(p_44563_, "result"));
            int i = GsonHelper.getAsInt(p_44563_, "time", 200);
            return new AltarOfAmethystRecipe(p_44562_, ingredient, itemstack, i);
        }

        public AltarOfAmethystRecipe fromNetwork(ResourceLocation p_44565_, FriendlyByteBuf p_44566_) {
            Ingredient ingredient = Ingredient.fromNetwork(p_44566_);
            ItemStack itemstack = p_44566_.readItem();
            int i = p_44566_.readVarInt();
            return new AltarOfAmethystRecipe(p_44565_, ingredient, itemstack, i);
        }

        public void toNetwork(FriendlyByteBuf p_44553_, AltarOfAmethystRecipe p_44554_) {
            p_44554_.ingredients.toNetwork(p_44553_);
            p_44553_.writeItem(p_44554_.result);
            p_44553_.writeVarInt(p_44554_.time);
        }


    }
}
