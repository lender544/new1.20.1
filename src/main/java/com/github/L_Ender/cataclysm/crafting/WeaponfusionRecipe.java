package com.github.L_Ender.cataclysm.crafting;

import com.github.L_Ender.cataclysm.init.ModRecipeSerializers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.item.crafting.SmithingRecipeInput;
import net.minecraft.world.level.Level;

import java.util.stream.Stream;

public class WeaponfusionRecipe implements WeaponfusionRecipeInterface {
    final Ingredient base;
    final Ingredient addition;
    final ItemStack result;


    public WeaponfusionRecipe(Ingredient p_44524_, Ingredient p_44525_, ItemStack p_44526_) {
        this.base = p_44524_;
        this.addition = p_44525_;
        this.result = p_44526_;
    }

    public boolean matches(WeaponfusionRecipeInput pInput, Level pLevel) {
        return this.base.test(pInput.base()) && this.addition.test(pInput.addition());
    }

    public ItemStack assemble(WeaponfusionRecipeInput p_345093_, HolderLookup.Provider p_345488_) {
        ItemStack itemstack = p_345093_.base().transmuteCopy(this.result.getItem(), this.result.getCount());
        itemstack.applyComponents(this.result.getComponentsPatch());
        return itemstack;
    }


    public ItemStack getResultItem(HolderLookup.Provider p_335712_) {
        return this.result;
    }

    @Override
    public boolean isBaseIngredient(ItemStack p_267276_) {
        return this.base.test(p_267276_);
    }

    public Ingredient getbaseIngredient() {
        return this.base;
    }

    public Ingredient getAdditionIngredient() {
        return this.addition;
    }

    @Override
    public boolean isAdditionIngredient(ItemStack p_267260_) {
        return this.addition.test(p_267260_);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.WEAPON_FUSION.get();
    }

    @Override
    public boolean isIncomplete() {
        return Stream.of(this.base, this.addition).anyMatch(Ingredient::hasNoItems);
    }

    public static class Serializer implements RecipeSerializer<WeaponfusionRecipe> {
        private static final MapCodec<WeaponfusionRecipe> CODEC = RecordCodecBuilder.mapCodec(
                p_340782_ -> p_340782_.group(
                                Ingredient.CODEC.fieldOf("base").forGetter(p_300938_ -> p_300938_.base),
                                Ingredient.CODEC.fieldOf("addition").forGetter(p_301153_ -> p_301153_.addition),
                                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_300935_ -> p_300935_.result)
                        )
                        .apply(p_340782_, WeaponfusionRecipe::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, WeaponfusionRecipe> STREAM_CODEC = StreamCodec.of(
                Serializer::toNetwork, Serializer::fromNetwork
        );

        @Override
        public MapCodec<WeaponfusionRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WeaponfusionRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static WeaponfusionRecipe fromNetwork(RegistryFriendlyByteBuf p_320375_) {
            Ingredient ingredient1 = Ingredient.CONTENTS_STREAM_CODEC.decode(p_320375_);
            Ingredient ingredient2 = Ingredient.CONTENTS_STREAM_CODEC.decode(p_320375_);
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(p_320375_);
            return new WeaponfusionRecipe(ingredient1, ingredient2, itemstack);
        }

        private static void toNetwork(RegistryFriendlyByteBuf p_320743_, WeaponfusionRecipe p_319840_) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(p_320743_, p_319840_.base);
            Ingredient.CONTENTS_STREAM_CODEC.encode(p_320743_, p_319840_.addition);
            ItemStack.STREAM_CODEC.encode(p_320743_, p_319840_.result);
        }
    }

}
