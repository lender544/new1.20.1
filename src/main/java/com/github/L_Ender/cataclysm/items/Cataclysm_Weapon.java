package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.items.CuriosItem.AttributeContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class Cataclysm_Weapon extends Item  {

    public Cataclysm_Weapon(Properties group) {
        super(group);
    }


    public static ItemAttributeModifiers createAttributes(int attackDamage, float attackSpeed) {
        return createAttributes((float)attackDamage, attackSpeed);
    }

    public static ItemAttributeModifiers createAttributes(float p_331976_, float p_332104_, AttributeContainer... attributes) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();

        builder.add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(
                        BASE_ATTACK_DAMAGE_ID, (double)p_331976_, AttributeModifier.Operation.ADD_VALUE
                ),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)p_332104_, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );

        for (AttributeContainer holder : attributes) {

            AttributeModifier modifier = holder.createModifier(EquipmentSlot.MAINHAND.getName());
            if (modifier.amount() != 0.0) {
                builder.add(holder.attribute(), modifier, EquipmentSlotGroup.MAINHAND);
            }
        }

        return builder.build();
    }

}