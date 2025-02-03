package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.projectile.Laser_Beam_Entity;
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

public class Laser_Beam_Renderer extends EntityRenderer<Laser_Beam_Entity> {

    private static final ResourceLocation TEXTURE_RED = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/harbinger/laser_beam.png");
    private static final RenderType RENDER_TYPE_RED = RenderType.eyes(TEXTURE_RED);

    public Laser_Beam_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    @Override
    public void render(Laser_Beam_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));

        matrixStackIn.mulPose(Axis.XP.rotationDegrees(45.0F));
        matrixStackIn.scale(0.05625F, 0.05625F, 0.05625F);
        matrixStackIn.translate(0.0D, 0.0D, 0.0D);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(RENDER_TYPE_RED);
        PoseStack.Pose posestack$pose = matrixStackIn.last();
        Matrix4f matrix4f = posestack$pose.pose();
        this.vertex(matrix4f, posestack$pose, vertexconsumer, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, packedLightIn);
        this.vertex(matrix4f, posestack$pose, vertexconsumer, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, packedLightIn);
        this.vertex(matrix4f, posestack$pose, vertexconsumer, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, packedLightIn);
        this.vertex(matrix4f, posestack$pose, vertexconsumer, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, packedLightIn);
        this.vertex(matrix4f, posestack$pose, vertexconsumer, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, packedLightIn);
        this.vertex(matrix4f, posestack$pose, vertexconsumer, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, packedLightIn);
        this.vertex(matrix4f, posestack$pose, vertexconsumer, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, packedLightIn);
        this.vertex(matrix4f, posestack$pose, vertexconsumer, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, packedLightIn);

        for(int j = 0; j < 4; ++j) {
            matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F));
            this.vertex(matrix4f, posestack$pose, vertexconsumer, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, packedLightIn);
            this.vertex(matrix4f, posestack$pose, vertexconsumer, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, packedLightIn);
            this.vertex(matrix4f, posestack$pose, vertexconsumer, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, packedLightIn);
            this.vertex(matrix4f, posestack$pose, vertexconsumer, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, packedLightIn);
        }

        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public void vertex(Matrix4f p_229039_1_, PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_1_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_);
    }

    @Override
    public ResourceLocation getTextureLocation(Laser_Beam_Entity entity) {
        return TEXTURE_RED;
    }
}
