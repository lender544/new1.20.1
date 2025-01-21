package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;


public class Armortier {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, Cataclysm.MODID);


    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }

 public static final DeferredHolder<ArmorMaterial, ArmorMaterial> IGNITIUM = ARMOR_MATERIALS.register("ignitium", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
     map.put(ArmorItem.Type.BOOTS, 6);
     map.put(ArmorItem.Type.LEGGINGS, 9);
     map.put(ArmorItem.Type.CHESTPLATE, 11);
     map.put(ArmorItem.Type.HELMET, 6);
     map.put(ArmorItem.Type.BODY, 15);
 }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(ModItems.IGNITIUM_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignitium"))), 4.0F, 0.15F));

 public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CURSIUM = ARMOR_MATERIALS.register("cursium", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
     map.put(ArmorItem.Type.BOOTS, 5);
     map.put(ArmorItem.Type.LEGGINGS, 8);
     map.put(ArmorItem.Type.CHESTPLATE, 10);
     map.put(ArmorItem.Type.HELMET, 5);
     map.put(ArmorItem.Type.BODY, 13);
 }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(ModItems.IGNITIUM_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"cursium"))), 4.0F, 0.05F));

 public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CRAB = ARMOR_MATERIALS.register("crab", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
     map.put(ArmorItem.Type.BOOTS, 4);
     map.put(ArmorItem.Type.LEGGINGS, 7);
     map.put(ArmorItem.Type.CHESTPLATE, 9);
     map.put(ArmorItem.Type.HELMET, 4);
     map.put(ArmorItem.Type.BODY, 13);
 }), 25, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(ModItems.AMETHYST_CRAB_SHELL.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"crab"))), 2.0F, 0.1F));

 public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BONE_REPTILE = ARMOR_MATERIALS.register("bone_reptile", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
     map.put(ArmorItem.Type.BOOTS, 4);
     map.put(ArmorItem.Type.LEGGINGS, 7);
     map.put(ArmorItem.Type.CHESTPLATE, 11);
     map.put(ArmorItem.Type.HELMET, 6);
     map.put(ArmorItem.Type.BODY, 13);
 }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(ModItems.ANCIENT_METAL_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"bone_reptile"))), 2.5F, 0.1F));
}





