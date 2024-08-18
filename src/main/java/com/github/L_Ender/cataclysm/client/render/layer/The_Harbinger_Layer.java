package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelThe_Harbinger;
import com.github.L_Ender.cataclysm.client.render.entity.RendererThe_Harbinger;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
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
public class The_Harbinger_Layer extends RenderLayer<The_Harbinger_Entity, ModelThe_Harbinger> {
    private static final ResourceLocation HARBINGER_LAYER_TEXTURES  = new ResourceLocation(Cataclysm.MODID,"textures/entity/harbinger/the_harbinger_layer.png");

    public The_Harbinger_Layer(RendererThe_Harbinger renderIn) {
        super(renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F - entity.deactivateProgress / 40;
        RenderType eyes = RenderType.eyes(HARBINGER_LAYER_TEXTURES);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, f, f, f, f);

    }
}


