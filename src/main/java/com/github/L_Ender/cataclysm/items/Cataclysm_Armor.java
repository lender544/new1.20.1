package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.items.CuriosItem.AttributeContainer;
import com.google.common.base.Suppliers;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Supplier;

public class Cataclysm_Armor extends ArmorItem {
    private final Supplier<ItemAttributeModifiers> catdefaultModifiers;

    public Cataclysm_Armor(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties, AttributeContainer... attributes) {
        super(pMaterial, pType, pProperties);

        this.catdefaultModifiers = Suppliers.memoize(
                () -> {
                    int i = material.value().getDefense(type);
                    float f = material.value().toughness();
                    ItemAttributeModifiers.Builder itemattributemodifiers$builder = ItemAttributeModifiers.builder();
                    EquipmentSlotGroup equipmentslotgroup = EquipmentSlotGroup.bySlot(type.getSlot());
                    ResourceLocation resourcelocation = ResourceLocation.withDefaultNamespace("armor." + type.getName());
                    itemattributemodifiers$builder.add(
                            Attributes.ARMOR, new AttributeModifier(resourcelocation, (double)i, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup
                    );
                    itemattributemodifiers$builder.add(
                            Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourcelocation, (double)f, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup
                    );
                    float f1 = material.value().knockbackResistance();
                    if (f1 > 0.0F) {
                        itemattributemodifiers$builder.add(
                                Attributes.KNOCKBACK_RESISTANCE,
                                new AttributeModifier(resourcelocation, (double)f1, AttributeModifier.Operation.ADD_VALUE),
                                equipmentslotgroup
                        );
                    }
                    for (AttributeContainer holder : attributes) {
                        itemattributemodifiers$builder.add(holder.attribute(), holder.createModifier(pType.getSlot().getName()), equipmentslotgroup);
                    }
                    return itemattributemodifiers$builder.build();
                }
        );
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.catdefaultModifiers.get();
    }


    public static ItemAttributeModifiers createArmorAttributes(Holder<ArmorMaterial> material,
            float configDefense,
            float configToughness,
            float configKnockback,
            ArmorItem.Type Type,
            AttributeContainer... attributes)
    {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup slotGroup = EquipmentSlotGroup.bySlot(Type.getSlot());
        ResourceLocation resLoc = ResourceLocation.withDefaultNamespace("armor." + Type.getName());
        int i = Math.round(configDefense) * material.value().getDefense(Type);
        builder.add(
                Attributes.ARMOR,
                new AttributeModifier(resLoc, i, AttributeModifier.Operation.ADD_VALUE),
                slotGroup
        );
        builder.add(
                Attributes.ARMOR_TOUGHNESS,
                new AttributeModifier(resLoc, configToughness, AttributeModifier.Operation.ADD_VALUE),
                slotGroup
        );
        if (configKnockback > 0.0F) {
            builder.add(
                    Attributes.KNOCKBACK_RESISTANCE,
                    new AttributeModifier(resLoc, configKnockback, AttributeModifier.Operation.ADD_VALUE),
                    slotGroup
            );
        }

        for (AttributeContainer holder : attributes) {
            AttributeModifier modifier = holder.createModifier(Type.getSlot().getName());
            if (modifier.amount() != 0.0) {
                builder.add(holder.attribute(), modifier, slotGroup);
            }
        }
        return builder.build();
    }

}
