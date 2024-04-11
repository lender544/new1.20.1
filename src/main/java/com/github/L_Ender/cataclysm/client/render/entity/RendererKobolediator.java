package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.ModelKobolediator;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererKobolediator extends MobRenderer<Kobolediator_Entity, ModelKobolediator<Kobolediator_Entity>> {

    private static final ResourceLocation KOBOLEDIATOR_TEXTURES = new ResourceLocation("cataclysm:textures/entity/koboleton/kobolediator.png");
    ;

    public RendererKobolediator(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelKobolediator<>(renderManagerIn.bakeLayer(CMModelLayers.KOBOLEDIATOR_MODEL)), 1.25F);

    }
    @Override
    public ResourceLocation getTextureLocation(Kobolediator_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    @Override
    protected float getFlipDegrees(Kobolediator_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Kobolediator_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

