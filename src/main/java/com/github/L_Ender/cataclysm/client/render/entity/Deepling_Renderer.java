package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Deepling_Model;
import com.github.L_Ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.LayerDeeplingItem;
import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Deepling_Renderer extends MobRenderer<Deepling_Entity, Deepling_Model> {

    private static final ResourceLocation SSAPBUG_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/deepling_1.png");
    private static final ResourceLocation DEEPLING_LAYER_TEXTURES  = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/deepling_layer.png");
    public Deepling_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Deepling_Model(), 0.7F);
        this.addLayer(new AbstractDeepling_Layer(this,DEEPLING_LAYER_TEXTURES));
        this.addLayer(new LayerDeeplingItem(this, renderManagerIn.getItemInHandRenderer()));

    }
    @Override
    public ResourceLocation getTextureLocation(Deepling_Entity entity) {
        return SSAPBUG_TEXTURES;
    }

    @Override
    protected void scale(Deepling_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }


}