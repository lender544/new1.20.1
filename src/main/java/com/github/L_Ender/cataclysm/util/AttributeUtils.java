package com.github.L_Ender.cataclysm.util;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.HashSet;
import java.util.Set;

public class AttributeUtils {

	public static void mergeAttributes(DataComponentPatch.Builder builder, Item item, ItemAttributeModifiers newModifiers) {

		ItemAttributeModifiers existingModifiers = item.components().getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);
		Set<Holder<Attribute>> attributesOverwritten = new HashSet<>();
		for (var entry : newModifiers.modifiers()) {
			attributesOverwritten.add(entry.attribute());
		}

		ItemAttributeModifiers.Builder combinedBuilder = ItemAttributeModifiers.builder();

		for (var entry : existingModifiers.modifiers()) {
			if (!attributesOverwritten.contains(entry.attribute())) {
				combinedBuilder.add(entry.attribute(), entry.modifier(), entry.slot());
			}
		}

		for (var entry : newModifiers.modifiers()) {
			combinedBuilder.add(entry.attribute(), entry.modifier(), entry.slot());
		}

		builder.set(DataComponents.ATTRIBUTE_MODIFIERS, combinedBuilder.build());
	}
}
