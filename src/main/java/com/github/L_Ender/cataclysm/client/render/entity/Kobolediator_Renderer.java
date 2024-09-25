package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Kobolediator_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Kobolediator_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Kobolediator_Renderer extends MobRenderer<Kobolediator_Entity, Kobolediator_Model> {
    private static final ResourceLocation KOBOLEDIATOR_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/koboleton/kobolediator.png");

    public Kobolediator_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Kobolediator_Model(), 1.25F);
        this.addLayer(new Kobolediator_Layer(this));

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

