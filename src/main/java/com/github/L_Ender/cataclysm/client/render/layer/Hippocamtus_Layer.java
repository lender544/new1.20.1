package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Hippocamtus_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.Hippocamtus_Renderer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AcropolisMonsters.Hippocamtus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Hippocamtus_Layer extends RenderLayer<Hippocamtus_Entity, Hippocamtus_Model> {
    private static final ResourceLocation PROWLER_LAYER_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/sea/hippocamtus_layer.png");


    public Hippocamtus_Layer(Hippocamtus_Renderer renderIn) {
        super(renderIn);
    }


    protected ResourceLocation getTextureLocation(Hippocamtus_Entity entity) {
        return PROWLER_LAYER_TEXTURES;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Hippocamtus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getAttackState() == 4) {

            float f;
            if (entity.attackTicks < 12) {
                f = Mth.clamp((entity.attackTicks / 12.0f), 0.0f, 1.0f);
            } else if (entity.attackTicks <= 17) {
                f = 1.0f;
            } else {
                f = Mth.clamp(1.0f - ((entity.attackTicks - 17) / 21.0f), 0.0f, 1.0f);
            }

            RenderType eyes = CMRenderTypes.CMEyes(this.getTextureLocation(entity));
            VertexConsumer vertexConsumer = bufferIn.getBuffer(eyes);

            this.getParentModel().renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, f,f,f,f);
        }
    }
}


