package com.github.L_Ender.cataclysm.util;

import com.github.L_Ender.cataclysm.init.ModAttribute;
import com.github.L_Ender.cataclysm.items.Cataclysm_Armor;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.ItemAttributeModifierEvent;

import java.util.*;

public class AttributeUtils {

	public static void replaceWeaponAttributes(ItemAttributeModifierEvent event, double damage, double attackspeed) {
		Item item = event.getItemStack().getItem();
		EquipmentSlot slot = event.getSlotType();
		if (slot == EquipmentSlot.MAINHAND) {
			replaceSpecificModifier(event, Attributes.ATTACK_DAMAGE, Item.BASE_ATTACK_DAMAGE_UUID, -1.0D + damage);
			replaceSpecificModifier(event, Attributes.ATTACK_SPEED, Item.BASE_ATTACK_SPEED_UUID, -4.0D + attackspeed);
		}
	}

	public static void replaceArmorAttributes(ItemAttributeModifierEvent event, double defenseMultiplier, double toughness, double knockback) {
		Item item = event.getItemStack().getItem();
		EquipmentSlot slot = event.getSlotType();

		if (item instanceof Cataclysm_Armor armor && slot == armor.getType().getSlot()) {

			UUID armorUuid = Cataclysm_Armor.ARMOR_MODIFIERS[slot.getIndex()];
			int Defense = armor.getMaterial().getDefenseForType(armor.getType());
			double finalDefense = Math.round(defenseMultiplier * Defense);

			replaceSpecificModifier(event, Attributes.ARMOR, armorUuid, finalDefense);


			replaceSpecificModifier(event, Attributes.ARMOR_TOUGHNESS, armorUuid, toughness);

			if (knockback > 0 || hasModifier(event, Attributes.KNOCKBACK_RESISTANCE, armorUuid)) {
				replaceSpecificModifier(event, Attributes.KNOCKBACK_RESISTANCE, armorUuid, knockback);
			}
		}
	}


	private static void replaceSpecificModifier(ItemAttributeModifierEvent event, Attribute attribute, UUID uuid, double amount) {
		event.getModifiers().get(attribute).stream()
				.filter(mod -> mod.getId().equals(uuid))
				.findFirst()
				.ifPresent(mod -> event.removeModifier(attribute, mod));

		event.addModifier(attribute, new AttributeModifier(uuid, "Cataclysm Modifier", amount, AttributeModifier.Operation.ADDITION));
	}

	private static boolean hasModifier(ItemAttributeModifierEvent event, Attribute attribute, UUID uuid) {
		return event.getModifiers().get(attribute).stream().anyMatch(mod -> mod.getId().equals(uuid));
	}

	public static float OriginDamage(LivingEntity living, ItemStack itemStack) {
		double totalDamage = living.getAttributeValue(Attributes.ATTACK_DAMAGE);

		if (living.getMainHandItem() == itemStack) {
			return (float) totalDamage;
		}

		ItemStack mainHandStack = living.getMainHandItem();
		if (!mainHandStack.isEmpty()) {
			Multimap<Attribute, AttributeModifier> modifiers = mainHandStack.getAttributeModifiers(EquipmentSlot.MAINHAND);

			if (modifiers.containsKey(Attributes.ATTACK_DAMAGE)) {
				for (AttributeModifier modifier : modifiers.get(Attributes.ATTACK_DAMAGE)) {
					if (modifier.getOperation() == AttributeModifier.Operation.ADDITION) {
						totalDamage -= modifier.getAmount();
					}
				}
			}
		}

		Multimap<Attribute, AttributeModifier> shredderModifiers = itemStack.getAttributeModifiers(EquipmentSlot.MAINHAND);
		if (shredderModifiers.containsKey(Attributes.ATTACK_DAMAGE)) {
			for (AttributeModifier modifier : shredderModifiers.get(Attributes.ATTACK_DAMAGE)) {
				if (modifier.getOperation() == AttributeModifier.Operation.ADDITION) {
					totalDamage += modifier.getAmount();
				}
			}
		}

		return (float) totalDamage;
	}



}