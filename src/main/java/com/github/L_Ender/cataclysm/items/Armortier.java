package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.init.ModAttribute;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;


import java.util.Map;
import java.util.function.Supplier;


public enum Armortier implements CataclysmArmorMaterial {
    IGNITIUM(new int[] {6, 11, 9, 6}, 4.0f, 45, 15, 0.15f, SoundEvents.ARMOR_EQUIP_NETHERITE , ModItems.IGNITIUM_INGOT, Map.of()),
    CURSIUM(new int[] {5, 10, 8, 5}, 4.0f, 45, 15, 0.05f, SoundEvents.ARMOR_EQUIP_NETHERITE , ModItems.CURSIUM_INGOT, Map.of()),
    CRAB(new int[] {3, 8, 6, 3}, 2.0f, 30, 25, 0.1f, SoundEvents.ARMOR_EQUIP_NETHERITE , ModItems.AMETHYST_CRAB_SHELL, Map.of(ModAttribute.NATURE_HEAL.get(), new AttributeModifier("nature_heal", 15, AttributeModifier.Operation.ADDITION))),
    BONE_REPTILE(new int[] {6, 11, 7, 4}, 3f, 35, 15, 0.2f, SoundEvents.ARMOR_EQUIP_NETHERITE , ModItems.ANCIENT_METAL_INGOT, Map.of());



    private static final int[] DURABILITY_ARRAY = new int[] {11, 16, 15, 13};
    private final int durability, enchantability;
    private final int[] dmgReduction; // helm[0], chest[1], leggings[2], boots[3]
    private final float toughness, knockbackResistance;
    private final SoundEvent sound;
    private final LazyLoadedValue<Item> repairMaterial;
    private final Map<Attribute, AttributeModifier> additionalAttributes;
    Armortier(int[] dmgReduction, float toughness, int durability, int enchantability, float knockbackResistance, SoundEvent sound, Supplier<Item> repairMaterial, Map<Attribute, AttributeModifier> additionalAttributes)
    {
        this.durability = durability;
        this.dmgReduction = dmgReduction;
        this.enchantability = enchantability;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.sound = sound;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
        this.additionalAttributes = additionalAttributes;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return DURABILITY_ARRAY[type.ordinal()] * this.durability;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.dmgReduction[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue()
    {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(repairMaterial.get());
    }

    @Override
    public String getName()
    {
        return toString().toLowerCase();
    }

    @Override
    public float getToughness()
    {
        return toughness;
    }


    public Map<Attribute, AttributeModifier> getAdditionalAttributes() {
        return additionalAttributes;
    }
    @Override
    public float getKnockbackResistance()
    {
        return knockbackResistance;
    }

}



