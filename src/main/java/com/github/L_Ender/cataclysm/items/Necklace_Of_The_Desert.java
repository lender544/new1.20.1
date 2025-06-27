package com.github.L_Ender.cataclysm.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class Necklace_Of_The_Desert extends Item {

    public Necklace_Of_The_Desert(Properties group) {
        super(group);

    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.cataclysm.necklace_of_the_desert.desc").withStyle(ChatFormatting.DARK_GREEN));
    }
}

