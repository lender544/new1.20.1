package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Ender_Golem_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Ender_Golem_Layer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Ender_Golem_Renderer extends MobRenderer<Ender_Golem_Entity, Ender_Golem_Model> {

    private static final ResourceLocation ENDER_GOLEM_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/ender_golem.png");
    ;

    public Ender_Golem_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Ender_Golem_Model(), 1.5F);
        this.addLayer(new Ender_Golem_Layer(this));

    }
    @Override
    public ResourceLocation getTextureLocation(Ender_Golem_Entity entity) {
        return ENDER_GOLEM_TEXTURES;
    }

    @Override
    protected void scale(Ender_Golem_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

    @Override
    protected float getFlipDegrees(Ender_Golem_Entity entity) {
        return 0;
    }

}

