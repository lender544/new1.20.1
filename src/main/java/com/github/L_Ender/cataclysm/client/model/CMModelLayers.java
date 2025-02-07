package com.github.L_Ender.cataclysm.client.model;

import com.github.L_Ender.cataclysm.client.model.armor.*;
import com.github.L_Ender.cataclysm.client.model.block.AptrgangrHeadModel;
import com.github.L_Ender.cataclysm.client.model.block.DraugrHeadModel;
import com.github.L_Ender.cataclysm.client.model.block.KobolediatorHeadModel;
import com.github.L_Ender.cataclysm.client.model.entity.*;
import com.github.L_Ender.cataclysm.client.model.item.CuriosModel.Blazing_Grips_Model;
import com.github.L_Ender.cataclysm.client.model.item.CuriosModel.Sandstorm_In_A_BottleModel;
import com.github.L_Ender.cataclysm.client.model.item.CuriosModel.Sticky_Gloves_Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
public class CMModelLayers {
    public static final ModelLayerLocation ELYTRA_ARMOR = createLocation("elytra_armor", "main");
    public static final ModelLayerLocation MONSTROUS_HELM = createLocation("monstrous", "main");
    public static final ModelLayerLocation IGNITIUM_ARMOR_MODEL = createLocation("ignitium_armor_model", "main");
    public static final ModelLayerLocation IGNITIUM_ARMOR_MODEL_LEGS = createLocation("ignitium_armor_model_leg", "main");
    public static final ModelLayerLocation CURSIUM_ARMOR_MODEL = createLocation("cursium_armor_model", "main");
    public static final ModelLayerLocation CURSIUM_ARMOR_MODEL_LEGS = createLocation("cursium_armor_model_leg", "main");

    public static final ModelLayerLocation BLOOM_STONE_PAULDRONS_MODEL = createLocation("bloom_stone_pauldrons_model", "main");
    public static final ModelLayerLocation BONE_REPTILE_ARMOR_MODEL = createLocation("bone_reptile_armor_model", "main");
    public static final ModelLayerLocation SANDSTORM_IN_A_BOTTLE_MODEL = createLocation("sandstorm_in_a_bottle_model", "main");
    public static final ModelLayerLocation STICKY_GLOVES_MODEL = createLocation("sticky_gloves_model", "main");
    public static final ModelLayerLocation STICKY_GLOVES_SLIM_MODEL = createLocation("sticky_gloves_slim_model", "main");
    public static final ModelLayerLocation BLAZING_GRIPS_MODEL = createLocation("blazing_grips_model", "main");
    public static final ModelLayerLocation BLAZING_GRIPS_SLIM_MODEL = createLocation("blazing_grips_slim_model", "main");
    public static final ModelLayerLocation KOBOLEDIATOR_HEAD_MODEL = createLocation("kobolediator_head_model", "main");
    public static final ModelLayerLocation APTRGANGR_HEAD_MODEL = createLocation("aptrgangr_head_model", "main");
    public static final ModelLayerLocation DRAUGR_HEAD_MODEL = createLocation("draugr_head_model", "main");
    public static final ModelLayerLocation IGNITED_BERSERKER_MODEL = createLocation("ignited_berserker_model", "main");
    public static final ModelLayerLocation NETHERITE_MONSTROSITY_MODEL = createLocation("netherite_monstrosity_model", "main");
    public static final ModelLayerLocation NETHERITE_MINISTROSITY_MODEL = createLocation("netherite_ministrosity_model", "main");
    public static final ModelLayerLocation FLARE_BOMB_MODEL = createLocation("flare_bomb_model", "main");

    public static final ModelLayerLocation ROYAL_DRAUGR_MODEL = createLocation("royal_draugr_model", "main");
    public static final ModelLayerLocation DRAUGR_MODEL = createLocation("draugr_model", "main");
    public static final ModelLayerLocation ELITE_DRAUGR_MODEL = createLocation("elite_draugr_model", "main");

    public static final ModelLayerLocation ANCIENT_REMNANT_MODEL = createLocation("ancient_remnant_model", "main");
    public static final ModelLayerLocation MALEDICTUS_MODEL = createLocation("maledictus_model", "main");
    public static final ModelLayerLocation APTRGANGR_MODEL = createLocation("aptrgangr_model", "main");
    public static final ModelLayerLocation KOBOLEDIATOR_MODEL = createLocation("kobolediator_model", "main");
    public static final ModelLayerLocation PROWLER_MODEL = createLocation("prowler_model", "main");

    public static final ModelLayerLocation HIPPOCAMTUS_MODEL = createLocation("hippocamtus_model", "main");
    public static final ModelLayerLocation URCHINKIN_MODEL = createLocation("urchinkin_model", "main");
    public static final ModelLayerLocation WATER_SPEAR_MODEL = createLocation("water_spear_model", "main");
    public static final ModelLayerLocation CINDARIA_MODEL = createLocation("cindaria", "main");

    public static void register(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MONSTROUS_HELM, () -> MonstrousHelm_Model.createArmorLayer(new CubeDeformation(0.3F)));
        event.registerLayerDefinition(IGNITIUM_ARMOR_MODEL, () -> Ignitium_Armor_Model.createArmorLayer(new CubeDeformation(0.6F)));
        event.registerLayerDefinition(BLOOM_STONE_PAULDRONS_MODEL, () -> Bloom_Stone_Pauldrons_Model.createArmorLayer(new CubeDeformation(0.5F)));
        event.registerLayerDefinition(ELYTRA_ARMOR, () -> Ignitium_Elytra_chestplate_Model.createArmorLayer(new CubeDeformation(0.5F)));
        event.registerLayerDefinition(IGNITIUM_ARMOR_MODEL_LEGS, () -> Ignitium_Armor_Model.createArmorLayer(new CubeDeformation(0.2F)));
        event.registerLayerDefinition(SANDSTORM_IN_A_BOTTLE_MODEL, () -> Sandstorm_In_A_BottleModel.createLayer(new CubeDeformation(0.2F)));
        event.registerLayerDefinition(BONE_REPTILE_ARMOR_MODEL, () -> Bone_Reptile_Armor_Model.createArmorLayer(new CubeDeformation(1.0F)));
        event.registerLayerDefinition(STICKY_GLOVES_MODEL, () -> Sticky_Gloves_Model.createLayer(false,new CubeDeformation(0.2F)));
        event.registerLayerDefinition(STICKY_GLOVES_SLIM_MODEL, () -> Sticky_Gloves_Model.createLayer(true,new CubeDeformation(0.2F)));
        event.registerLayerDefinition(BLAZING_GRIPS_MODEL, () -> Blazing_Grips_Model.createLayer(false,new CubeDeformation(0.0F)));
        event.registerLayerDefinition(BLAZING_GRIPS_SLIM_MODEL, () -> Blazing_Grips_Model.createLayer(true,new CubeDeformation(0.0F)));
        event.registerLayerDefinition(KOBOLEDIATOR_HEAD_MODEL, KobolediatorHeadModel::createHeadLayer);
        event.registerLayerDefinition(APTRGANGR_HEAD_MODEL, AptrgangrHeadModel::createHeadLayer);
        event.registerLayerDefinition(DRAUGR_HEAD_MODEL, DraugrHeadModel::createHeadLayer);
        event.registerLayerDefinition(IGNITED_BERSERKER_MODEL, Ignited_Berserker_Model::createBodyLayer);
        event.registerLayerDefinition(NETHERITE_MONSTROSITY_MODEL, Netherite_Monstrosity_Model::createBodyLayer);
        event.registerLayerDefinition(NETHERITE_MINISTROSITY_MODEL, Netherite_Ministrosity_Model::createBodyLayer);
        event.registerLayerDefinition(FLARE_BOMB_MODEL, Flare_Bomb_Model::createBodyLayer);
        event.registerLayerDefinition(CURSIUM_ARMOR_MODEL, () -> Cursium_Armor_Model.createArmorLayer(new CubeDeformation(0.5F)));
        event.registerLayerDefinition(CURSIUM_ARMOR_MODEL_LEGS, () -> Cursium_Armor_Model.createArmorLayer(new CubeDeformation(0.2F)));
        event.registerLayerDefinition(ROYAL_DRAUGR_MODEL, Royal_Draugr_Model::createBodyLayer);
        event.registerLayerDefinition(DRAUGR_MODEL, Draugr_Model::createBodyLayer);
        event.registerLayerDefinition(ELITE_DRAUGR_MODEL, Elite_Draugr_Model::createBodyLayer);
        event.registerLayerDefinition(ANCIENT_REMNANT_MODEL, Ancient_Remnant_Rework_Model::createBodyLayer);
        event.registerLayerDefinition(MALEDICTUS_MODEL, Maledictus_Model::createBodyLayer);
        event.registerLayerDefinition(APTRGANGR_MODEL, Aptrgangr_Model::createBodyLayer);
        event.registerLayerDefinition(KOBOLEDIATOR_MODEL, Kobolediator_Model::createBodyLayer);
        event.registerLayerDefinition(PROWLER_MODEL, The_Prowler_Model::createBodyLayer);

        event.registerLayerDefinition(HIPPOCAMTUS_MODEL, Hippocamtus_Model::createBodyLayer);
        event.registerLayerDefinition(URCHINKIN_MODEL, Urchinkin_Model::createBodyLayer);
        event.registerLayerDefinition(WATER_SPEAR_MODEL, Water_Spear_Model::createBodyLayer);
        event.registerLayerDefinition(CINDARIA_MODEL, Cindaria_Model::createBodyLayer);
    }

    private static ModelLayerLocation createLocation(String model, String layer) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("cataclysm", model), layer);
    }

}
