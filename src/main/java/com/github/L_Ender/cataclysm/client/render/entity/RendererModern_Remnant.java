package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.client.model.entity.ModelModern_Remnant;
import com.github.L_Ender.cataclysm.entity.Pet.Modern_Remnant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererModern_Remnant extends MobRenderer<Modern_Remnant_Entity, ModelModern_Remnant> {

    private static final ResourceLocation MODERN_REMNANT_TEXTURES = new ResourceLocation("cataclysm:textures/entity/ancient_remnant/modern_remnant.png");
    ;

    public RendererModern_Remnant(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelModern_Remnant(), 0.25F);
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

