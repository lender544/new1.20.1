package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Aptrgangr_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.Aptrgangr_Renderer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Aptrgangr_Layer extends RenderLayer<Aptrgangr_Entity, Aptrgangr_Model> {
    private static final ResourceLocation LAYER = new ResourceLocation(Cataclysm.MODID,"textures/entity/draugar/aptrgangr_layer.png");

    public Aptrgangr_Layer(Aptrgangr_Renderer renderIn) {
        super(renderIn);
    }

    public ResourceLocation getLayerTextureLocation() {
        return LAYER;
    }
    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Aptrgangr_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            //need rework
        float f = 1.0F - entity.deathTime / (float) entity.deathtimer();
        RenderType eyes = CMRenderTypes.CMEyes(this.getLayerTextureLocation());
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, f, f, f, 1.0F);

    }
}


