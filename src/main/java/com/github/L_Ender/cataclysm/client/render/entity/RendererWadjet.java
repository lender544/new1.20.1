package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Model_Wadjet;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererWadjet extends MobRenderer<Wadjet_Entity, Model_Wadjet<Wadjet_Entity>> {

    private static final ResourceLocation KOBOLEDIATOR_TEXTURES = new ResourceLocation("cataclysm:textures/entity/koboleton/wadjet.png");
    ;

    public RendererWadjet(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Model_Wadjet<>(renderManagerIn.bakeLayer(CMModelLayers.WADJET_MODEL)), 0.75F);

    }
    @Override
    public ResourceLocation getTextureLocation(Wadjet_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    @Override
    protected float getFlipDegrees(Wadjet_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Wadjet_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

