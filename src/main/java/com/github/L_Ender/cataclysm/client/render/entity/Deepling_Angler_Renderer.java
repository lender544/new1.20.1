package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Deepling_Angler_Model;
import com.github.L_Ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.LayerDeepling_AnglerItem;
import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Angler_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Deepling_Angler_Renderer extends MobRenderer<Deepling_Angler_Entity, Deepling_Angler_Model> {

    private static final ResourceLocation SSAPBUG_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/deepling/deepling_angler.png");
    private static final ResourceLocation DEEPLING_LAYER_TEXTURES  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/deepling/deepling_angler_layer.png");

    public Deepling_Angler_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Deepling_Angler_Model(), 0.7F);
        this.addLayer(new AbstractDeepling_Layer(this,DEEPLING_LAYER_TEXTURES));
        this.addLayer(new LayerDeepling_AnglerItem(this, renderManagerIn.getItemInHandRenderer()));

    }
    @Override
    public ResourceLocation getTextureLocation(Deepling_Angler_Entity entity) {
        return SSAPBUG_TEXTURES;
    }

    @Override
    protected void scale(Deepling_Angler_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0625F, 1.0625F, 1.0625F);
    }
}