package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.client.model.entity.ModelKoboleton;
import com.github.L_Ender.cataclysm.client.render.layer.LayerKoboletonItem;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.Koboleton_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererKoboleton extends MobRenderer<Koboleton_Entity, ModelKoboleton> {

    private static final ResourceLocation KOBOLETON_TEXTURES = new ResourceLocation("cataclysm:textures/entity/koboleton/koboleton.png");
    ;

    public RendererKoboleton(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelKoboleton(), 0.5F);
        this.addLayer(new LayerKoboletonItem(this, renderManagerIn.getItemInHandRenderer()));

    }
    @Override
    public ResourceLocation getTextureLocation(Koboleton_Entity entity) {
        return KOBOLETON_TEXTURES;
    }

    @Override
    protected void scale(Koboleton_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

