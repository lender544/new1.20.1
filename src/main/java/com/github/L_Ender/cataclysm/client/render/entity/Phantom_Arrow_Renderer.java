package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
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
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class Phantom_Arrow_Renderer extends EntityRenderer<Phantom_Arrow_Entity> {

    private static final ResourceLocation TEXTURE_RED = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/maledictus/phantom_arrow.png");
    private static final RenderType RENDER_TYPE_RED = CMRenderTypes.getGhost(TEXTURE_RED);

    public Phantom_Arrow_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    @Override
    public void render(Phantom_Arrow_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
        float f1 = 0.15625F;
        float f2 = 0.3125F;
        float f9 = (float)entityIn.shakeTime - partialTicks;
        if (f9 > 0.0F) {
            float f10 = -Mth.sin(f9 * 3.0F) * f9;
            matrixStackIn.mulPose(Axis.ZP.rotationDegrees(f10));
        }

        matrixStackIn.mulPose(Axis.XP.rotationDegrees(45.0F));
        matrixStackIn.scale(0.075F, 0.075F, 0.075F);
        matrixStackIn.translate(-4.0F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(RENDER_TYPE_RED);
        PoseStack.Pose posestack$pose = matrixStackIn.last();

        float hide = ((float) entityIn.getTransparency() / 200);
        float alpha = (1F - hide);
        int light = (int) (255 * Mth.clamp(alpha, 0, 1));

        this.vertex(posestack$pose, vertexconsumer, -7, -2, -2, light,0.0F, 0.15625F, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, -2, 2, light,0.15625F, 0.15625F, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, 2, light,0.15625F, 0.3125F, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, -2, light,0.0F, 0.3125F, -1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, -2, light,0.0F, 0.15625F, 1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, 2, 2, light,0.15625F, 0.15625F, 1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, -2, 2, light,0.15625F, 0.3125F, 1, 0, 0, packedLightIn);
        this.vertex(posestack$pose, vertexconsumer, -7, -2, -2, light,0.0F, 0.3125F, 1, 0, 0, packedLightIn);

        for(int j = 0; j < 4; ++j) {
            matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F));
            this.vertex(posestack$pose, vertexconsumer, -8, -2, 0, light,0.0F, 0.0F, 0, 1, 0, packedLightIn);
            this.vertex(posestack$pose, vertexconsumer, 8, -2, 0, light,0.65F, 0.0F, 0, 1, 0, packedLightIn);
            this.vertex(posestack$pose, vertexconsumer, 8, 2, 0, light,0.65F, 0.15625F, 0, 1, 0, packedLightIn);
            this.vertex(posestack$pose, vertexconsumer, -8, 2, 0, light,0.0F, 0.15625F, 0, 1, 0, packedLightIn);
        }



        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public void vertex(PoseStack.Pose p_324380_, VertexConsumer p_253902_, int p_254058_, int p_254338_, int p_254196_,int light, float p_254003_, float p_254165_, int p_253982_, int p_254037_, int p_254038_, int p_254271_) {
        p_253902_.addVertex(p_324380_, (float)p_254058_, (float)p_254338_, (float)p_254196_).setColor(255, 255, 255, light).setUv(p_254003_, p_254165_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_254271_).setNormal(p_324380_, (float)p_253982_, (float)p_254038_, (float)p_254037_);
    }


    @Override
    public ResourceLocation getTextureLocation(Phantom_Arrow_Entity entity) {
        return TEXTURE_RED;
    }
}
