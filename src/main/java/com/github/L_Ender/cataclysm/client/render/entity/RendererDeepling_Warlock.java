package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelDeepling_Warlock;
import com.github.L_Ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.LayerDeepling_WarlockItem;
import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Warlock_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererDeepling_Warlock extends MobRenderer<Deepling_Warlock_Entity, ModelDeepling_Warlock> {

    private static final ResourceLocation DEEPLING_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/deepling_warlock.png");
    private static final ResourceLocation DEEPLING_LAYER_TEXTURES  = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/deepling_warlock_layer.png");

    public RendererDeepling_Warlock(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelDeepling_Warlock(), 0.7F);
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