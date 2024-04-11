package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;


 public enum Armortier implements ArmorMaterial {
     IGNITIUM(new int[] {5, 10, 8, 5}, 4.0f, 45, 15, 0.15f, SoundEvents.ARMOR_EQUIP_NETHERITE , ModItems.IGNITIUM_INGOT),
     CRAB(new int[] {3, 8, 6, 3}, 2.0f, 30, 25, 0.1f, SoundEvents.ARMOR_EQUIP_NETHERITE , ModItems.AMETHYST_CRAB_SHELL),
     BONE_REPTILE(new int[] {5, 8, 6, 3}, 2.5f, 35, 15, 0.1f, SoundEvents.ARMOR_EQUIP_NETHERITE , ModItems.ANCIENT_METAL_INGOT);



     private static final int[] DURABILITY_ARRAY = new int[] {11, 16, 15, 13};
     private final int durability, enchantability;
     private final int[] dmgReduction; // helm[0], chest[1], leggings[2], boots[3]
     private final float toughness, knockbackResistance;
     private final SoundEvent sound;
     private final LazyLoadedValue<Item> repairMaterial;

     Armortier(int[] dmgReduction, float toughness, int durability, int enchantability, float knockbackResistance, SoundEvent sound, Supplier<Item> repairMaterial)
     {
         this.durability = durability;
         this.dmgReduction = dmgReduction;
         this.enchantability = enchantability;
         this.toughness = toughness;
         this.knockbackResistance = knockbackResistance;
         this.sound = sound;
         this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
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

     @Override
     public float getKnockbackResistance()
     {
         return knockbackResistance;
     }

 }



