package com.github.L_Ender.cataclysm.items.CuriosItem;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.common.MinecraftForge;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;


public class CuriosItem extends Item implements ICurioItem {

    String attributeSlot = "";
    Function<Integer, Multimap<Attribute, AttributeModifier>> attributes = null;
    Map<String, Integer> slotModifiers = new HashMap<>();

    public CuriosItem(Properties properties) {
        super(properties);

    }


    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }


    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> modifiers = LinkedHashMultimap.create();

        if (slotContext.identifier().equals(this.attributeSlot) && this.attributes != null) {
            modifiers.putAll(this.attributes.apply(slotContext.index()));
        }
        if (!this.slotModifiers.isEmpty()) {
            this.slotModifiers.forEach((slotId, amount) -> {
                CuriosApi.addSlotModifier(modifiers, slotId, uuid, amount, AttributeModifier.Operation.ADDITION);
            });
        }

        CurioAttributeModifierEvent evt = new CurioAttributeModifierEvent(stack, slotContext, uuid, modifiers);
        MinecraftForge.EVENT_BUS.post(evt);

        return modifiers;
    }

    public CuriosItem withAttributes(String slot, AttributeContainer... attributes) {
        this.attributeSlot = slot;
        this.attributes = (index) -> {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            for (AttributeContainer holder : attributes) {
                String name = String.format("%s_%s", attributeSlot, index);
                builder.put(holder.attribute(), holder.createModifier(name));
            }
            return builder.build();
        };
        return this;
    }

    public CuriosItem withSlotModifier(String slotToModify, int amount) {
        this.slotModifiers.put(slotToModify, amount);
        return this;
    }

}