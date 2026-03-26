package com.github.L_Ender.cataclysm.items.CuriosItem;


import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

public record AttributeContainer(Attribute attribute, double value, AttributeModifier.Operation operation) {
    public AttributeModifier createModifier(String slot) {

        String attributeName = ForgeRegistries.ATTRIBUTES.getKey(attribute).getPath();

        String modifierName = String.format("%s_%s_modifier", slot, attributeName);
        String fullIdentifier = Cataclysm.MODID + ":" + modifierName;

        UUID uuid = UUID.nameUUIDFromBytes(fullIdentifier.getBytes());

        return new AttributeModifier(uuid, modifierName, value, operation);
    }
}