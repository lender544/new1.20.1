package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelEnder_Guardian;
import com.github.L_Ender.cataclysm.client.render.entity.RendererEnder_Guardian;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
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
public class Ender_Guardian_Layer extends RenderLayer<Ender_Guardian_Entity, ModelEnder_Guardian> {
    private static final ResourceLocation ENDER_GUARDIAN_LAYER_TEXTURES  = new ResourceLocation(Cataclysm.MODID,"textures/entity/ender_guardian_layer.png");

    public Ender_Guardian_Layer(RendererEnder_Guardian renderIn) {
        super(renderIn);

    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ender_Guardian_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.deathTime < 100) {
            //need rework
            RenderType eyes = RenderType.eyes(ENDER_GUARDIAN_LAYER_TEXTURES);
            VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
            this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}


