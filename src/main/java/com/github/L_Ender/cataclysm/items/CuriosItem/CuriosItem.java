package com.github.L_Ender.cataclysm.items.CuriosItem;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CuriosItem extends Item implements ICurioItem {

    String attributeSlot = "";
    Function<Integer, Multimap<Holder<Attribute>, AttributeModifier>> attributes = null;
    Map<String, Integer> slotModifiers = new HashMap<>();
    public CuriosItem(Properties properties) {
        super(properties);

    }


    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }


    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = LinkedHashMultimap.create();
        if (slotContext.identifier().equals(this.attributeSlot) && this.attributes != null) {
            modifiers.putAll(this.attributes.apply(slotContext.index()));
        }
        if (!this.slotModifiers.isEmpty()) {
            this.slotModifiers.forEach((slotId, amount) -> {
                CuriosApi.addSlotModifier(modifiers, slotId, id, amount, AttributeModifier.Operation.ADD_VALUE);
            });
        }
        CurioAttributeModifierEvent evt =
                new CurioAttributeModifierEvent(stack, slotContext, id, modifiers);
        NeoForge.EVENT_BUS.post(evt);
        return modifiers;
    }


    public CuriosItem withAttributes(String slot, AttributeContainer... attributes) {
        this.attributeSlot = slot;
        this.attributes = (index) -> {
            ImmutableMultimap.Builder<Holder<Attribute>, AttributeModifier> builder = ImmutableMultimap.builder();
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