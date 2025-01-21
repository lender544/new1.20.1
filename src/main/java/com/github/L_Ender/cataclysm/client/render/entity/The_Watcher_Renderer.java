package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.The_Watcher_Model;
import com.github.L_Ender.cataclysm.client.render.layer.LayerGenericGlowing;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.The_Watcher_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class The_Watcher_Renderer extends MobRenderer<The_Watcher_Entity, The_Watcher_Model> {

    private static final ResourceLocation WATCHER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/factory/the_watcher.png");
    private static final ResourceLocation WATCHER_LAYER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/factory/the_watcher_layer.png");

    public The_Watcher_Renderer(Context renderManagerIn) {
        super(renderManagerIn, new The_Watcher_Model(), 0.7F);
        this.addLayer(new LayerGenericGlowing(this, WATCHER_LAYER_TEXTURES));

    }
    @Override
    public ResourceLocation getTextureLocation(The_Watcher_Entity entity) {
        return WATCHER_TEXTURES;
    }

    @Override
    protected void scale(The_Watcher_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}