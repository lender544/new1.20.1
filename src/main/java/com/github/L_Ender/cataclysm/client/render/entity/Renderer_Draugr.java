package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Model_Draugr;
import com.github.L_Ender.cataclysm.client.model.entity.Model_Royal_Draugr;
import com.github.L_Ender.cataclysm.client.render.layer.LayerGenericGlowing;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Draugr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class Renderer_Draugr extends MobRenderer<Draugr_Entity, Model_Draugr> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/draugar/draugr.png");
    private static final ResourceLocation LAYER = new ResourceLocation(Cataclysm.MODID,"textures/entity/draugar/draugr_layer.png");

    public Renderer_Draugr(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Model_Draugr(), 0.5F);
        this.addLayer(new LayerGenericGlowing(this, LAYER));
        this.addLayer(new ItemInHandLayer<>(this, renderManagerIn.getItemInHandRenderer()));
    }

    protected void scale(Draugr_Entity p_114907_, PoseStack p_114908_, float p_114909_) {
        float f = 1.0F;
        p_114908_.scale(f, f, f);
        super.scale(p_114907_, p_114908_, p_114909_);
    }

    public ResourceLocation getTextureLocation(Draugr_Entity entity) {
        return TEXTURE;
    }

}


