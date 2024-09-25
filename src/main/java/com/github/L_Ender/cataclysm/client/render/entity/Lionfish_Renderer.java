package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Lionfish_Model;
import com.github.L_Ender.cataclysm.client.render.layer.LionFish_Layer;
import com.github.L_Ender.cataclysm.entity.Deepling.Lionfish_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Lionfish_Renderer extends MobRenderer<Lionfish_Entity, Lionfish_Model> {

    private static final ResourceLocation LIONFISH_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/lionfish.png");

    public Lionfish_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Lionfish_Model(), 0.4F);
        this.addLayer(new LionFish_Layer(this));

    }
    @Override
    public ResourceLocation getTextureLocation(Lionfish_Entity entity) {
        return LIONFISH_TEXTURES;
    }

    @Override
    protected void scale(Lionfish_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }


}