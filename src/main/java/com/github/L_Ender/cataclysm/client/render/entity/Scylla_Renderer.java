package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Hippocamtus_Model;
import com.github.L_Ender.cataclysm.client.model.entity.Scylla_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Cindaria_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Hippocamtus_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Scylla_Snake_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Hippocamtus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Scylla_Renderer extends MobRenderer<Scylla_Entity, Scylla_Model> {

    private static final ResourceLocation SCYLLA_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/scylla/scylla_no_snake.png");


    public Scylla_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Scylla_Model(renderManagerIn.bakeLayer(CMModelLayers.SCYLLA_MODEL)), 0.75F);
        this.addLayer(new Scylla_Snake_Layer(this));
    }
    @Override
    public ResourceLocation getTextureLocation(Scylla_Entity entity) {
        return SCYLLA_TEXTURES;
    }

    @Override
    protected float getFlipDegrees(Scylla_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Scylla_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.15F, 1.15F, 1.15F);
    }
}

