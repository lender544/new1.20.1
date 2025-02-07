package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Cindaria_Model;

import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.layer.Cindaria_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Maledictus_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Cindaria_Entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.NeoForge;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class Cindaria_Renderer extends MobRenderer<Cindaria_Entity, Cindaria_Model> {

    private static final ResourceLocation CINDARIA_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/cindaria_armor.png");
    ;

    public Cindaria_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Cindaria_Model(renderManagerIn.bakeLayer(CMModelLayers.CINDARIA_MODEL)), 0.5F);
        this.addLayer(new Cindaria_Layer(this));
    }
    @Override
    public ResourceLocation getTextureLocation(Cindaria_Entity entity) {
        return CINDARIA_TEXTURES;
    }


    @Override
    protected float getFlipDegrees(Cindaria_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Cindaria_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.8F, 0.8F, 0.8F);
    }
}

