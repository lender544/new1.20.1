package com.github.L_Ender.cataclysm.client.render.item;

import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.armor.*;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class CustomArmorRenderProperties implements IClientItemExtensions {

    private static boolean init;

    public static ignitium_Elytra_chestplate_Model ELYTRA_ARMOR;
    public static MonstrousHelm_Model MONSTROUS_HELM_MODEL;
    public static Ignitium_Armor_Model IGNITIUM_ARMOR_MODEL;
    public static Ignitium_Armor_Model IGNITIUM_ARMOR_MODEL_LEGS;
    public static Bloom_Stone_Pauldrons_Model BLOOM_STONE_PAULDRONS_MODEL;
    public static Bone_Reptile_Armor_Model BONE_REPTILE_ARMOR_MODEL;

    public static Cursium_Armor_Model CURSIUM_ARMOR_MODEL;
    public static Cursium_Armor_Model CURSIUM_ARMOR_MODEL_LEGS;

    public static void initializeModels() {
        init = true;
        MONSTROUS_HELM_MODEL = new MonstrousHelm_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.MONSTROUS_HELM));
        IGNITIUM_ARMOR_MODEL = new Ignitium_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.IGNITIUM_ARMOR_MODEL));
        ELYTRA_ARMOR = new ignitium_Elytra_chestplate_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.ELYTRA_ARMOR));
        IGNITIUM_ARMOR_MODEL_LEGS = new Ignitium_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.IGNITIUM_ARMOR_MODEL_LEGS));
        BLOOM_STONE_PAULDRONS_MODEL = new Bloom_Stone_Pauldrons_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.BLOOM_STONE_PAULDRONS_MODEL));
        BONE_REPTILE_ARMOR_MODEL = new Bone_Reptile_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.BONE_REPTILE_ARMOR_MODEL));
        CURSIUM_ARMOR_MODEL = new Cursium_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.CURSIUM_ARMOR_MODEL));
        CURSIUM_ARMOR_MODEL_LEGS = new Cursium_Armor_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.CURSIUM_ARMOR_MODEL_LEGS));

    }

    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
        if(!init){
            initializeModels();
        }

        if(itemStack.getItem() == ModItems.MONSTROUS_HELM.get()){
            return MONSTROUS_HELM_MODEL;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_HELMET.get()){
            return IGNITIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_CHESTPLATE.get()){
            return IGNITIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_LEGGINGS.get()){
            return IGNITIUM_ARMOR_MODEL_LEGS;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_BOOTS.get()){
            return IGNITIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.CURSIUM_HELMET.get()){
            return CURSIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.CURSIUM_CHESTPLATE.get()){
            return CURSIUM_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.CURSIUM_LEGGINGS.get()){
            return CURSIUM_ARMOR_MODEL_LEGS;
        }

        if(itemStack.getItem() == ModItems.CURSIUM_BOOTS.get()){
            return CURSIUM_ARMOR_MODEL;
        }


        if(itemStack.getItem() == ModItems.BLOOM_STONE_PAULDRONS.get()){
            return BLOOM_STONE_PAULDRONS_MODEL;
        }

        if(itemStack.getItem() == ModItems.BONE_REPTILE_HELMET.get()){
            return BONE_REPTILE_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.BONE_REPTILE_CHESTPLATE.get()){
            return BONE_REPTILE_ARMOR_MODEL;
        }

        if(itemStack.getItem() == ModItems.IGNITIUM_ELYTRA_CHESTPLATE.get()){
            return ELYTRA_ARMOR.withAnimations(entityLiving);
        }
        return _default;
    }
}
