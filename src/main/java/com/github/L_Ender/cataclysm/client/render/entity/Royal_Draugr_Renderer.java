package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Royal_Draugr_Model;
import com.github.L_Ender.cataclysm.client.render.layer.LayerGenericGlowing;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class Royal_Draugr_Renderer extends MobRenderer<Royal_Draugr_Entity, Royal_Draugr_Model> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/draugar/royal_draugr.png");
    private static final ResourceLocation LAYER = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/draugar/draugr_layer.png");

    public Royal_Draugr_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Royal_Draugr_Model(renderManagerIn.bakeLayer(CMModelLayers.ROYAL_DRAUGR_MODEL)), 0.5F);
        this.addLayer(new LayerGenericGlowing(this, LAYER));
        this.addLayer(new ItemInHandLayer<>(this, renderManagerIn.getItemInHandRenderer()));
    }

    protected void scale(Royal_Draugr_Entity p_114907_, PoseStack p_114908_, float p_114909_) {
        float f = 1.0625F;
        p_114908_.scale(f, f, f);
        super.scale(p_114907_, p_114908_, p_114909_);
    }

    public ResourceLocation getTextureLocation(Royal_Draugr_Entity entity) {
        return TEXTURE;
    }

}


