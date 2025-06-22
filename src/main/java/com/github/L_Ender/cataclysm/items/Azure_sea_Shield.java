package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;


public class Azure_sea_Shield extends ShieldItem {

	public Azure_sea_Shield(Properties properties) {
		super(properties);
	}


	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return repair.is(ModItems.LACRIMA.get()) || !repair.is(ItemTags.PLANKS) && super.isValidRepairItem(toRepair, repair);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, net.neoforged.neoforge.common.ItemAbility itemAbility) {
		return net.neoforged.neoforge.common.ItemAbilities.DEFAULT_SHIELD_ACTIONS.contains(itemAbility);
	}

	
}