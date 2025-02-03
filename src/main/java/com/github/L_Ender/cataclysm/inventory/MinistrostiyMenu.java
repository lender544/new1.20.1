package com.github.L_Ender.cataclysm.inventory;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.github.L_Ender.cataclysm.init.ModMenu;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.HorseInventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MinistrostiyMenu extends AbstractContainerMenu {
    private final Container horseContainer;
    private final Netherite_Ministrosity_Entity horse;


    public MinistrostiyMenu(int p_39656_, Inventory p_39657_, Container p_39658_, final Netherite_Ministrosity_Entity p_39659_) {
        super(null, p_39656_);
        this.horseContainer = p_39658_;
        this.horse = p_39659_;
        int i = 3;
        p_39658_.startOpen(p_39657_.player);
        int j = -18;

        for(int k = 0; k < 3; ++k) {
            for(int l = 0; l < ((Netherite_Ministrosity_Entity)p_39659_).getInventoryColumns(); ++l) {
                this.addSlot(new MinistrositySlot(p_39658_, 2 + l + k * ((Netherite_Ministrosity_Entity)p_39659_).getInventoryColumns(), 71 + l * 18, 18 + k * 18));
            }
        }


        for(int i1 = 0; i1 < 3; ++i1) {
            for(int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(p_39657_, k1 + i1 * 9 + 9, 8 + k1 * 18, 102 + i1 * 18 + -18));
            }
        }

        for(int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(p_39657_, j1, 8 + j1 * 18, 142));
        }

    }



    public boolean stillValid(Player p_39661_) {
        return !this.horse.hasInventoryChanged(this.horseContainer) && this.horseContainer.stillValid(p_39661_) && this.horse.isAlive() && this.horse.distanceTo(p_39661_) < 8.0F;
    }


    public ItemStack quickMoveStack(Player p_40199_, int p_40200_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_40200_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_40200_ < this.horseContainer.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.horseContainer.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.horseContainer.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    public boolean mayPlace(ItemStack p_40231_) {
        return true;
    }

    public void removed(Player p_39663_) {
        super.removed(p_39663_);
        this.horseContainer.stopOpen(p_39663_);
        if (horse != null) horse.setAttackState(5);

    }
}
