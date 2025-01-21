package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.The_Harbinger_Model;
import com.github.L_Ender.cataclysm.client.render.entity.The_Harbinger_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.WitherArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class The_Harbinger_Shield_Layer extends RenderLayer<The_Harbinger_Entity, The_Harbinger_Model> {

    private static final ResourceLocation HARBINGER_LAYER_TEXTURES  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/harbinger/the_harbinger_shield_layer.png");


    public The_Harbinger_Shield_Layer(The_Harbinger_Renderer rendererTheHarbinger) {
        super(rendererTheHarbinger);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity harbinger, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = (float) harbinger.tickCount + partialTicks;
        if(harbinger.isPowered()) {
            matrixStackIn.pushPose();
            matrixStackIn.scale(1.02f,1.02f,1.02f);
            EntityModel<The_Harbinger_Entity> entitymodel = this.getParentModel();
            entitymodel.prepareMobModel(harbinger, limbSwing, limbSwingAmount, partialTicks);
            this.getParentModel().copyPropertiesTo(entitymodel);
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.energySwirl(this.getTextureLocation(), this.xOffset(f), f * 0.01F));
            entitymodel.setupAnim(harbinger, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            entitymodel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY,-8355712);
            matrixStackIn.popPose();
        }
    }

    protected float xOffset(float p_117702_) {
        return Mth.cos(p_117702_ * 0.02F) * 2F;
    }

    protected ResourceLocation getTextureLocation() {
        return HARBINGER_LAYER_TEXTURES;
    }

}


