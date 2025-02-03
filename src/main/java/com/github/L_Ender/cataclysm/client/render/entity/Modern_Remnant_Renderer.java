package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Modern_Remnant_Model;
import com.github.L_Ender.cataclysm.entity.Pet.Modern_Remnant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Modern_Remnant_Renderer extends MobRenderer<Modern_Remnant_Entity, Modern_Remnant_Model> {

    private static final ResourceLocation MODERN_REMNANT_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/ancient_remnant/modern_remnant.png");
    ;

    public Modern_Remnant_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Modern_Remnant_Model(), 0.25F);
    }
    @Override
    public ResourceLocation getTextureLocation(Modern_Remnant_Entity entity) {
        return MODERN_REMNANT_TEXTURES;
    }

    @Override
    protected void scale(Modern_Remnant_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

}

