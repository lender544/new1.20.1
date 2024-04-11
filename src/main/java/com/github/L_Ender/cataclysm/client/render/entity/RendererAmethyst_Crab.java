package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.client.model.entity.ModelAmethyst_Crab;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Amethyst_Crab_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererAmethyst_Crab extends MobRenderer<Amethyst_Crab_Entity, ModelAmethyst_Crab> {

    private static final ResourceLocation TEXTURES = new ResourceLocation("cataclysm:textures/entity/amethyst_crab.png");
    private static final ResourceLocation KRABS_TEXTURES = new ResourceLocation("cataclysm:textures/entity/mr_amethyst_krabs.png");

    public RendererAmethyst_Crab(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelAmethyst_Crab(), 1.5F);

    }
    @Override
    public ResourceLocation getTextureLocation(Amethyst_Crab_Entity entity) {
        return entity.isKrusty() ? KRABS_TEXTURES : TEXTURES;
    }

    @Override
    protected void scale(Amethyst_Crab_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

    @Override
    protected float getFlipDegrees(Amethyst_Crab_Entity entity) {
        return 0;
    }

}

