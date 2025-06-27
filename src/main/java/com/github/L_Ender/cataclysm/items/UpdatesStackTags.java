package com.github.L_Ender.cataclysm.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public interface UpdatesStackTags {

    default void updateTagFromServer(Entity holder, ItemStack stack, CompoundTag tag){
        stack.setTag(tag);
    }
}
