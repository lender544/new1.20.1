package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.client.model.entity.ModelThe_Baby_Leviathan;
import com.github.L_Ender.cataclysm.entity.Pet.The_Baby_Leviathan_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererThe_Baby_Leviathan extends MobRenderer<The_Baby_Leviathan_Entity, ModelThe_Baby_Leviathan> {

    private static final ResourceLocation BABY_LEVIATHAN_TEXTURES = new ResourceLocation("cataclysm:textures/entity/leviathan/the_baby_leviathan.png");
    ;

    public RendererThe_Baby_Leviathan(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelThe_Baby_Leviathan(), 0.25F);
    }
    @Override
    public ResourceLocation getTextureLocation(The_Baby_Leviathan_Entity entity) {
        return BABY_LEVIATHAN_TEXTURES;
    }

    @Override
    protected void scale(The_Baby_Leviathan_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

}

