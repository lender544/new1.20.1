package com.github.L_Ender.cataclysm.items.CuriosItem;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.function.Function;

public class CuriosItem extends Item implements ICurioItem {

    String attributeSlot = "";
    Function<Integer, Multimap<Holder<Attribute>, AttributeModifier>> attributes = null;
    public CuriosItem(Properties properties) {
        super(properties);

    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }


    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        return slotContext.identifier().equals(this.attributeSlot) ? attributes.apply(slotContext.index()) : ICurioItem.super.getAttributeModifiers(slotContext, id, stack);
    }

    public CuriosItem withAttributes(String slot, AttributeContainer... attributes) {
        this.attributeSlot = slot;
        this.attributes = (index) -> {
            ImmutableMultimap.Builder<Holder<Attribute>, AttributeModifier> builder = ImmutableMultimap.builder();
            for (AttributeContainer holder : attributes) {
                String id = String.format("%s_%s", attributeSlot, index);
                builder.put(holder.attribute(), holder.createModifier(id));
            }
            return builder.build();
        };
        return this;
    }

}