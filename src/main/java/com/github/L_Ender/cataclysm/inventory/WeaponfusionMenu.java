package com.github.L_Ender.cataclysm.inventory;

import com.github.L_Ender.cataclysm.crafting.WeaponfusionRecipe;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModMenu;
import com.github.L_Ender.cataclysm.init.ModRecipeTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class WeaponfusionMenu extends ItemCombinerMenu {
    private final Level level;
    @Nullable
    private WeaponfusionRecipe selectedRecipe;
    private final List<WeaponfusionRecipe> recipes;

    public WeaponfusionMenu(int p_40245_, Inventory p_40246_) {
        this(p_40245_, p_40246_, ContainerLevelAccess.NULL);
    }

    public WeaponfusionMenu(int p_40248_, Inventory p_40249_, ContainerLevelAccess p_40250_) {
        super(ModMenu.WEAPON_FUSION.get(), p_40248_, p_40249_, p_40250_);
        this.level = p_40249_.player.level();
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.WEAPON_FUSION.get());
    }

    protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create().withSlot(0, 27, 47, (p_266883_) -> {
            return true;
        }).withSlot(1, 76, 47, (p_267323_) -> {
            return true;
        }).withResultSlot(2, 134, 47).build();
    }

    protected boolean isValidBlock(BlockState p_266887_) {
        return p_266887_.is(ModBlocks.MECHANICAL_FUSION_ANVIL.get());
    }

    protected boolean mayPickup(Player p_267240_, boolean p_266679_) {
        return this.selectedRecipe != null && this.selectedRecipe.matches(this.inputSlots, this.level);
    }

    protected void onTake(Player p_267006_, ItemStack p_266731_) {
        p_266731_.onCraftedBy(p_267006_.level(), p_267006_, p_266731_.getCount());
        this.resultSlots.awardUsedRecipes(p_267006_, this.getRelevantItems());
        this.shrinkStackInSlot(0);
        this.shrinkStackInSlot(1);
        this.access.execute((p_267191_, p_267098_) -> {
            p_267191_.levelEvent(1044, p_267098_, 0);
        });

    }

    private List<ItemStack> getRelevantItems() {
        return List.of(this.inputSlots.getItem(0), this.inputSlots.getItem(1), this.inputSlots.getItem(2));
    }

    private void shrinkStackInSlot(int p_267273_) {
        ItemStack itemstack = this.inputSlots.getItem(p_267273_);
        itemstack.shrink(1);
        this.inputSlots.setItem(p_267273_, itemstack);
    }

    public void createResult() {
        List<WeaponfusionRecipe> list = this.level.getRecipeManager().getRecipesFor(ModRecipeTypes.WEAPON_FUSION.get(), this.inputSlots, this.level).stream().filter((p_267116_) -> {
            return p_267116_ instanceof WeaponfusionRecipe;
        }).map((p_266971_) -> {
            return (WeaponfusionRecipe)p_266971_;
        }).toList();
        if (list.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        } else {
            WeaponfusionRecipe legacyupgraderecipe = list.get(0);
            ItemStack itemstack = legacyupgraderecipe.assemble(this.inputSlots, this.level.registryAccess());
            if (itemstack.isItemEnabled(this.level.enabledFeatures())) {
                this.selectedRecipe = legacyupgraderecipe;
                this.resultSlots.setRecipeUsed(legacyupgraderecipe);
                this.resultSlots.setItem(0, itemstack);
            }
        }

    }

    public int getSlotToQuickMoveTo(ItemStack p_267241_) {
        return this.shouldQuickMoveToAdditionalSlot(p_267241_) ? 1 : 0;
    }

    protected boolean shouldQuickMoveToAdditionalSlot(ItemStack p_267176_) {
        return this.recipes.stream().anyMatch((p_267065_) -> {
            return p_267065_.isAdditionIngredient(p_267176_);
        });
    }

    public boolean canTakeItemForPickAll(ItemStack p_266810_, Slot p_267252_) {
        return p_267252_.container != this.resultSlots && super.canTakeItemForPickAll(p_266810_, p_267252_);
    }
}
