package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelNameless_Sorcerer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Nameless_Sorcerer_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererNameless_Sorcerer extends MobRenderer<Nameless_Sorcerer_Entity, ModelNameless_Sorcerer> {

    private static final ResourceLocation NAMELESS_SORCERER_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/nameless_sorcerer.png");

    public RendererNameless_Sorcerer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelNameless_Sorcerer(), 0.5F);

    }
    @Override
    public ResourceLocation getTextureLocation(Nameless_Sorcerer_Entity entity) {
        return NAMELESS_SORCERER_TEXTURES;
    }

    @Override
    protected void scale(Nameless_Sorcerer_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.9375F, 0.9375F, 0.9375F);
    }

}
