package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.client.model.entity.ModelDeepling_Priest;
import com.github.L_Ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.LayerDeepling_PriestItem;
import com.github.L_Ender.cataclysm.client.render.layer.LayerDeepling_Priest_Light;
import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Priest_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererDeepling_Priest extends MobRenderer<Deepling_Priest_Entity, ModelDeepling_Priest> {

    private static final ResourceLocation DEEPLING_TEXTURES = new ResourceLocation("cataclysm:textures/entity/deepling/deepling_priest.png");
    private static final ResourceLocation DEEPLING_LAYER_TEXTURES  = new ResourceLocation("cataclysm:textures/entity/deepling/deepling_priest_layer.png");

    public RendererDeepling_Priest(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelDeepling_Priest(), 0.7F);
        this.addLayer(new AbstractDeepling_Layer(this,DEEPLING_LAYER_TEXTURES));
        this.addLayer(new LayerDeepling_PriestItem(this, renderManagerIn.getItemInHandRenderer()));
        this.addLayer(new LayerDeepling_Priest_Light(this));

    }
    @Override
    public ResourceLocation getTextureLocation(Deepling_Priest_Entity entity) {
        return DEEPLING_TEXTURES;
    }

    @Override
    protected void scale(Deepling_Priest_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }

}