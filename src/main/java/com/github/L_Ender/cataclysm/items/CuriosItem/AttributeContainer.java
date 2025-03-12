package com.github.L_Ender.cataclysm.items.CuriosItem;


import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public record AttributeContainer(Holder<Attribute> attribute, double value, AttributeModifier.Operation operation) {
    public AttributeModifier createModifier(String slot) {
        var attributeName = ResourceLocation.parse(attribute.getRegisteredName()).getPath();
        return new AttributeModifier(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,String.format("%s_%s_modifier", slot, attributeName)), value, operation);
    }
}
