package com.github.L_Ender.cataclysm.util;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class AttributeUtils {
	public static void mergeAttributes(DataComponentPatch.Builder builder, Item item, ItemAttributeModifiers newModifiers) {

		ItemAttributeModifiers existingModifiers = item.components().getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);

		ItemAttributeModifiers.Builder combinedBuilder = ItemAttributeModifiers.builder();

		for (var existingEntry : existingModifiers.modifiers()) {
			boolean shouldReplace = false;

			for (var newEntry : newModifiers.modifiers()) {
				if (existingEntry.attribute().equals(newEntry.attribute()) &&
						existingEntry.slot().equals(newEntry.slot())) {
					shouldReplace = true;
					break;
				}
			}

			if (!shouldReplace) {
				combinedBuilder.add(existingEntry.attribute(), existingEntry.modifier(), existingEntry.slot());
			}
		}

		for (var newEntry : newModifiers.modifiers()) {
			combinedBuilder.add(newEntry.attribute(), newEntry.modifier(), newEntry.slot());
		}

		builder.set(DataComponents.ATTRIBUTE_MODIFIERS, combinedBuilder.build());
	}

	public static float OriginDamage(LivingEntity living, ItemStack itemStack) {
		double totalDamage = living.getAttributeValue(Attributes.ATTACK_DAMAGE);

		if (living.getMainHandItem() == itemStack) {
			return (float) totalDamage;
		}
		ItemStack mainHandStack = living.getMainHandItem();
		if (!mainHandStack.isEmpty()) {
			ItemAttributeModifiers modifiers = mainHandStack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);
			for (ItemAttributeModifiers.Entry entry : modifiers.modifiers()) {
				if (entry.attribute().is(Attributes.ATTACK_DAMAGE) && entry.slot().test(EquipmentSlot.MAINHAND)) {
					if (entry.modifier().operation() == AttributeModifier.Operation.ADD_VALUE) {
						totalDamage -= entry.modifier().amount();
					}
				}
			}
		}
		ItemAttributeModifiers shredderModifiers = itemStack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);
		for (ItemAttributeModifiers.Entry entry : shredderModifiers.modifiers()) {
			if (entry.attribute().is(Attributes.ATTACK_DAMAGE) && entry.slot().test(EquipmentSlot.MAINHAND)) {
				if (entry.modifier().operation() == AttributeModifier.Operation.ADD_VALUE) {
					totalDamage += entry.modifier().amount();
				}
			}
		}

		return (float) totalDamage;
	}

}
