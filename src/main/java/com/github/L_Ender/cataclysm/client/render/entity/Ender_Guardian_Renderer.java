package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Ender_Guardian_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Ender_Guardian_Layer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Ender_Guardian_Renderer extends MobRenderer<Ender_Guardian_Entity, Ender_Guardian_Model> {

    private static final ResourceLocation ENDER_GUARDIAN_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/ender_guardian.png");

    public Ender_Guardian_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Ender_Guardian_Model(), 1.5F);
        this.addLayer(new Ender_Guardian_Layer(this));

    }
    @Override
    public ResourceLocation getTextureLocation(Ender_Guardian_Entity entity) {
        return ENDER_GUARDIAN_TEXTURES;
    }

    @Override
    protected void scale(Ender_Guardian_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

    @Override
    protected float getFlipDegrees(Ender_Guardian_Entity entity) {
        return 0;
    }

}

