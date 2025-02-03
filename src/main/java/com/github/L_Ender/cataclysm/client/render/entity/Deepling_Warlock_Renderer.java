package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Deepling_Warlock_Model;
import com.github.L_Ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.LayerDeepling_WarlockItem;
import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Warlock_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Deepling_Warlock_Renderer extends MobRenderer<Deepling_Warlock_Entity, Deepling_Warlock_Model> {

    private static final ResourceLocation DEEPLING_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/deepling/deepling_warlock.png");
    private static final ResourceLocation DEEPLING_LAYER_TEXTURES  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/deepling/deepling_warlock_layer.png");

    public Deepling_Warlock_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Deepling_Warlock_Model(), 0.7F);
        this.addLayer(new AbstractDeepling_Layer(this,DEEPLING_LAYER_TEXTURES));
        this.addLayer(new LayerDeepling_WarlockItem(this, renderManagerIn.getItemInHandRenderer()));

    }
    @Override
    public ResourceLocation getTextureLocation(Deepling_Warlock_Entity entity) {
        return DEEPLING_TEXTURES;
    }

    @Override
    protected void scale(Deepling_Warlock_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }

}