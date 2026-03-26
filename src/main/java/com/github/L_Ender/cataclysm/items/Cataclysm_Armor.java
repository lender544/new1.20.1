package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.config.CommonConfig;
import com.google.common.collect.ImmutableMultimap;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;


import java.util.Map;
import java.util.UUID;

public abstract class Cataclysm_Armor extends ArmorItem {
    public static final UUID[] ARMOR_MODIFIERS = new UUID[]{
            UUID.fromString("3BD9274F-FE23-4E27-94A1-3E1794623051"),
            UUID.fromString("2F1E6347-2602-4A27-9171-81EFBE6E6847"),
            UUID.fromString("4542676C-AF71-44B4-80BD-78659018D2F3"),
            UUID.fromString("5AD6415F-E5D2-4000-9F4D-3D5A030AF75E")};

    public Cataclysm_Armor(CataclysmArmorMaterial material, Type type, Properties settings) {
        super(material, type, settings);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        float defense = material.getDefenseForType(type);
        float toughness = material.getToughness();
        float knockbackResistance = material.getKnockbackResistance();
        UUID uuid = ARMOR_MODIFIERS[type.getSlot().getIndex()];
        builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", defense, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", toughness, AttributeModifier.Operation.ADDITION));
        if (knockbackResistance > 0) {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance", knockbackResistance, AttributeModifier.Operation.ADDITION));
        }
        for (Map.Entry<Attribute, AttributeModifier> modifierEntry : material.getAdditionalAttributes().entrySet()) {
            AttributeModifier atr = modifierEntry.getValue();
            atr = new AttributeModifier(uuid, atr.getName(), atr.getAmount(), atr.getOperation());
            builder.put(modifierEntry.getKey(), atr);
        }

        this.defaultModifiers =  builder.build();

    }


}
