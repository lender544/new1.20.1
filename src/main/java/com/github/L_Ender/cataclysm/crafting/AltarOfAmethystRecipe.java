package com.github.L_Ender.cataclysm.crafting;

import com.github.L_Ender.cataclysm.init.ModRecipeSerializers;
import com.github.L_Ender.cataclysm.init.ModRecipeTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class AltarOfAmethystRecipe implements Recipe<SingleRecipeInput> {

    private final Ingredient ingredient;
    private ItemStack result;
    private int time;

    public AltarOfAmethystRecipe(Ingredient ingredients, ItemStack result, int time) {
        this.ingredient = ingredients;
        this.result = result;
        this.time = time;
    }


    public boolean matches(SingleRecipeInput p_344849_, Level p_345973_) {
        return this.ingredient.test(p_344849_.item());
    }

    public ItemStack assemble(SingleRecipeInput p_344838_, HolderLookup.Provider p_336115_) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int p_43743_, int p_43744_) {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider p_336110_) {
        return this.result;
    }


    public int getTime() {
        return this.time;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.AMETHYST_BLESS.get();
    }


    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.AMETHYST_BLESS.get();
    }

    public static class Serializer implements RecipeSerializer<AltarOfAmethystRecipe> {
        private static final MapCodec<AltarOfAmethystRecipe> CODEC = RecordCodecBuilder.mapCodec(
                p_340782_ -> p_340782_.group(
                                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_300833_ -> p_300833_.ingredient),
                                ItemStack.CODEC.fieldOf("result").forGetter(p_300827_ -> p_300827_.result),
                                Codec.INT.fieldOf("time").orElse(200).forGetter(p_300834_ -> p_300834_.time)
                        )
                        .apply(p_340782_, AltarOfAmethystRecipe::new)
        );


        public static final StreamCodec<RegistryFriendlyByteBuf, AltarOfAmethystRecipe> STREAM_CODEC = StreamCodec.of(
                AltarOfAmethystRecipe.Serializer::toNetwork, AltarOfAmethystRecipe.Serializer::fromNetwork
        );

        @Override
        public MapCodec<AltarOfAmethystRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, AltarOfAmethystRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static AltarOfAmethystRecipe fromNetwork(RegistryFriendlyByteBuf p_320375_) {

            Ingredient ingredient1 = Ingredient.CONTENTS_STREAM_CODEC.decode(p_320375_);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(p_320375_);
            int i = p_320375_.readVarInt();
            return new AltarOfAmethystRecipe(ingredient1, itemstack,i);
        }

        private static void toNetwork(RegistryFriendlyByteBuf p_320743_, AltarOfAmethystRecipe p_319840_) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(p_320743_, p_319840_.ingredient);
            ItemStack.STREAM_CODEC.encode(p_320743_, p_319840_.result);
            p_320743_.writeVarInt(p_319840_.time);
        }
    }
}



