package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Koboleton_Model;
import com.github.L_Ender.cataclysm.client.render.layer.LayerGenericGlowing;
import com.github.L_Ender.cataclysm.client.render.layer.LayerKoboletonItem;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.Koboleton_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Koboleton_Renderer extends MobRenderer<Koboleton_Entity, Koboleton_Model> {

    private static final ResourceLocation KOBOLETON_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/koboleton/koboleton.png");
    private static final ResourceLocation KOBOLETON_LAYER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/koboleton/koboleton_layer.png");

    public Koboleton_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Koboleton_Model(), 0.5F);
        this.addLayer(new LayerKoboletonItem(this, renderManagerIn.getItemInHandRenderer()));
        this.addLayer(new LayerGenericGlowing(this, KOBOLETON_LAYER_TEXTURES));

    }
    @Override
    public ResourceLocation getTextureLocation(Koboleton_Entity entity) {
        return KOBOLETON_TEXTURES;
    }

    @Override
    protected void scale(Koboleton_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

