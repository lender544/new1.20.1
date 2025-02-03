package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class Bone_Reptile_Armor extends ArmorItem {

    public Bone_Reptile_Armor(Holder<ArmorMaterial> material, Type slot, Properties properties) {
        super(material, slot, properties);

    }


    @Override
    public ResourceLocation getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
        return ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/armor/bone_reptile_armor.png");
    }

}