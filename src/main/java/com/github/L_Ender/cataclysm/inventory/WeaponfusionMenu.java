package com.github.L_Ender.cataclysm.inventory;

import com.github.L_Ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.L_Ender.cataclysm.crafting.WeaponfusionRecipeInput;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModMenu;
import com.github.L_Ender.cataclysm.init.ModRecipeTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.OptionalInt;

public class WeaponfusionMenu extends ItemCombinerMenu {
    private final Level level;
    @Nullable
    private RecipeHolder<WeaponfusionRecipe> selectedRecipe;
    private final List<RecipeHolder<WeaponfusionRecipe>> recipes;

    public WeaponfusionMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public WeaponfusionMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(ModMenu.WEAPON_FUSION.get(), pContainerId, pPlayerInventory, pAccess);
        this.level = pPlayerInventory.player.level();
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.WEAPON_FUSION.get());
    }

    @Override
    protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create()
                .withSlot(0, 27, 47, p_286208_ -> this.recipes.stream().anyMatch(p_300802_ -> p_300802_.value().isBaseIngredient(p_286208_)))
                .withSlot(1, 76, 47, p_286207_ -> this.recipes.stream().anyMatch(p_300798_ -> p_300798_.value().isAdditionIngredient(p_286207_)))
                .withResultSlot(2, 134, 47)
                .build();
    }



    @Override
    protected boolean isValidBlock(BlockState pState) {
        return pState.is(ModBlocks.MECHANICAL_FUSION_ANVIL.get());
    }

    @Override
    protected boolean mayPickup(Player pPlayer, boolean pHasStack) {
        return this.selectedRecipe != null && this.selectedRecipe.value().matches(this.createRecipeInput(), this.level);
    }

    @Override
    protected void onTake(Player pPlayer, ItemStack pStack) {
        pStack.onCraftedBy(pPlayer.level(), pPlayer, pStack.getCount());
        this.resultSlots.awardUsedRecipes(pPlayer, this.getRelevantItems());
        this.shrinkStackInSlot(0);
        this.shrinkStackInSlot(1);
        this.shrinkStackInSlot(2);
        this.access.execute((p_40263_, p_40264_) -> p_40263_.levelEvent(1044, p_40264_, 0));
    }

    private List<ItemStack> getRelevantItems() {
        return List.of(this.inputSlots.getItem(0), this.inputSlots.getItem(1), this.inputSlots.getItem(2));
    }

    private WeaponfusionRecipeInput createRecipeInput() {
        return new WeaponfusionRecipeInput(this.inputSlots.getItem(0), this.inputSlots.getItem(1));
    }



    private void shrinkStackInSlot(int pIndex) {
        ItemStack itemstack = this.inputSlots.getItem(pIndex);
        if (!itemstack.isEmpty()) {
            itemstack.shrink(1);
            this.inputSlots.setItem(pIndex, itemstack);
        }
    }

    @Override
    public void createResult() {
        WeaponfusionRecipeInput smithingrecipeinput = this.createRecipeInput();
        List<RecipeHolder<WeaponfusionRecipe>> list = this.level.getRecipeManager().getRecipesFor(ModRecipeTypes.WEAPON_FUSION.get(), smithingrecipeinput, this.level);
        if (list.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        } else {
            RecipeHolder<WeaponfusionRecipe> recipeholder = list.get(0);
            ItemStack itemstack = recipeholder.value().assemble(smithingrecipeinput, this.level.registryAccess());
            if (itemstack.isItemEnabled(this.level.enabledFeatures())) {
                this.selectedRecipe = recipeholder;
                this.resultSlots.setRecipeUsed(recipeholder);
                this.resultSlots.setItem(0, itemstack);
            }
        }
    }

    @Override
    public int getSlotToQuickMoveTo(ItemStack pStack) {
        return this.findSlotToQuickMoveTo(pStack).orElse(0);
    }

    private static OptionalInt findSlotMatchingIngredient(WeaponfusionRecipe p_266790_, ItemStack p_266818_) {
        if (p_266790_.isBaseIngredient(p_266818_)) {
            return OptionalInt.of(0);
        } else {
            return p_266790_.isAdditionIngredient(p_266818_) ? OptionalInt.of(1) : OptionalInt.empty();
        }
    }
    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in is null for the initial slot that was double-clicked.
     */
    @Override
    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
        return pSlot.container != this.resultSlots && super.canTakeItemForPickAll(pStack, pSlot);
    }

    @Override
    public boolean canMoveIntoInputSlots(ItemStack pStack) {
        return this.findSlotToQuickMoveTo(pStack).isPresent();
    }

    private OptionalInt findSlotToQuickMoveTo(ItemStack pStack) {
        return this.recipes
                .stream()
                .flatMapToInt(p_300800_ -> findSlotMatchingIngredient(p_300800_.value(), pStack).stream())
                .filter(p_294045_ -> !this.getSlot(p_294045_).hasItem())
                .findFirst();
    }
}
