package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.client.model.entity.Model_Sandstorm;
import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RendererSandstorm extends EntityRenderer<Sandstorm_Entity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("cataclysm:textures/entity/ancient_remnant/sandstorm.png");
    private final Model_Sandstorm model = new Model_Sandstorm();

    public RendererSandstorm(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Sandstorm_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, (double)3F, 0.0D);
        matrixStackIn.scale(-2.0F, -2.0F, 2.0F);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(TEXTURE));
        model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, 0, 0);
        this.model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public ResourceLocation getTextureLocation(Sandstorm_Entity entity) {
        return TEXTURE;
    }
}
