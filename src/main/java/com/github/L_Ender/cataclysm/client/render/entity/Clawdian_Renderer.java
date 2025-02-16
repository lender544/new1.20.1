package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Clawdian_Model;
import com.github.L_Ender.cataclysm.client.model.entity.Hippocamtus_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Hippocamtus_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.LayerGenericGlowing;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Clawdian_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Hippocamtus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Clawdian_Renderer extends MobRenderer<Clawdian_Entity, Clawdian_Model> {

    private static final ResourceLocation KOBOLEDIATOR_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/shrimp.png");
    private static final ResourceLocation LAYER = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/shrimp_glow.png");

    public Clawdian_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Clawdian_Model(renderManagerIn.bakeLayer(CMModelLayers.CLAWDIAN_MODEL)), 1.8F);
        this.addLayer(new LayerGenericGlowing(this, LAYER));
    }
    @Override
    public ResourceLocation getTextureLocation(Clawdian_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    @Override
    protected float getFlipDegrees(Clawdian_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Clawdian_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.1F, 1.1F, 1.1F);
    }
}

