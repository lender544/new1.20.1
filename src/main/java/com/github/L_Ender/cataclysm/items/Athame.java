package com.github.L_Ender.cataclysm.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.UUID;

public class Athame extends SwordItem implements RangeTool {

    public Athame(Properties group) {
        super(Tiers.STONE, group);

    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 4.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -1.8F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, -1.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .build();
    }



    public boolean isValidRepairItem(ItemStack pickaxe, ItemStack stack) {
        return stack.is(Items.PRISMARINE_SHARD);
    }
}