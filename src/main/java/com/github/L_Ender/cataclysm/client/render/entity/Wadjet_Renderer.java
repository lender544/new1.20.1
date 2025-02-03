package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Wadjet_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Wadjet_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Wadjet_Renderer extends MobRenderer<Wadjet_Entity, Wadjet_Model> {

    private static final ResourceLocation KOBOLEDIATOR_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/koboleton/wadjet.png");
    ;

    public Wadjet_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Wadjet_Model(), 0.75F);
        this.addLayer(new Wadjet_Layer(this));
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

