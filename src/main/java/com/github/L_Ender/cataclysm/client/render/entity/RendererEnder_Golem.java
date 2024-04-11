package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.client.model.entity.ModelEnder_Golem;
import com.github.L_Ender.cataclysm.client.render.layer.Ender_Golem_Layer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererEnder_Golem extends MobRenderer<Ender_Golem_Entity, ModelEnder_Golem> {

    private static final ResourceLocation ENDER_GOLEM_TEXTURES = new ResourceLocation("cataclysm:textures/entity/ender_golem.png");
    ;

    public RendererEnder_Golem(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelEnder_Golem(), 1.5F);
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

