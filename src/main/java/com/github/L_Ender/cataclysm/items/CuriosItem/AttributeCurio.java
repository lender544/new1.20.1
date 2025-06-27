package com.github.L_Ender.cataclysm.items.CuriosItem;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.Map;
import java.util.UUID;

public class AttributeCurio extends CuriosItem {

    private final Multimap<Attribute, AttributeModifier> attributeMap;

    public AttributeCurio(Item.Properties properties, Multimap<Attribute, AttributeModifier> attributeMap) {
        super(properties);
        this.attributeMap = attributeMap;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = new ImmutableMultimap.Builder<>();
        for (Map.Entry<Attribute, AttributeModifier> entry : attributeMap.entries()) {
            builder.put(entry.getKey(), new AttributeModifier(
                    uuid,
                    entry.getValue().getName(),
                    entry.getValue().getAmount(),
                    entry.getValue().getOperation()
            ));
        }
        return builder.build();
    }

}