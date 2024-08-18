package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelWadjet;
import com.github.L_Ender.cataclysm.client.render.layer.Kobolediator_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Wadjet_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererWadjet extends MobRenderer<Wadjet_Entity, ModelWadjet> {

    private static final ResourceLocation KOBOLEDIATOR_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/koboleton/wadjet.png");
    ;

    public RendererWadjet(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelWadjet(), 0.75F);
        this.addLayer(new Wadjet_Layer(this));
    }
    @Override
    public ResourceLocation getTextureLocation(Wadjet_Entity entity) {
        return KOBOLEDIATOR_TEXTURES;
    }

    @Override
    protected float getFlipDegrees(Wadjet_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Wadjet_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

