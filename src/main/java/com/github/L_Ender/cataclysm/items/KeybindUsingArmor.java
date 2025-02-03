package com.github.L_Ender.cataclysm.items;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface KeybindUsingArmor {
    void onKeyPacket(Player keyPresser, ItemStack itemStack, int type);
}
