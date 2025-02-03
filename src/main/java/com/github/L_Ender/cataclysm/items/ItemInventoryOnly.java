package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.util.CustomTabBehavior;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ItemInventoryOnly extends Item implements CustomTabBehavior {

    public ItemInventoryOnly(Properties properties) {
        super(properties);
    }

    @Override
    public void fillItemCategory(CreativeModeTab.Output contents) {

    }
}
