package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Dimensional_Rift_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class RendererDimensional_Rift extends EntityRenderer<Dimensional_Rift_Entity> {
    private static final ResourceLocation TEXTURE_IDLE_1 = new ResourceLocation(Cataclysm.MODID,"textures/entity/leviathan/dimensional_rift/dimensional_rift_idle1.png");
    private static final ResourceLocation TEXTURE_IDLE_2 = new ResourceLocation(Cataclysm.MODID,"textures/entity/leviathan/dimensional_rift/dimensional_rift_idle2.png");
    private static final ResourceLocation TEXTURE_IDLE_3 = new ResourceLocation(Cataclysm.MODID,"textures/entity/leviathan/dimensional_rift/dimensional_rift_idle3.png");
    private static final ResourceLocation TEXTURE_IDLE_4 = new ResourceLocation(Cataclysm.MODID,"textures/entity/leviathan/dimensional_rift/dimensional_rift_idle4.png");

    private static final ResourceLocation TEXTURE_GROW_1 = new ResourceLocation(Cataclysm.MODID,"textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_0.png");
    private static final ResourceLocation TEXTURE_GROW_2 = new ResourceLocation(Cataclysm.MODID,"textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_1.png");
    private static final ResourceLocation TEXTURE_GROW_3 = new ResourceLocation(Cataclysm.MODID,"textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_2.png");
    private static final ResourceLocation TEXTURE_GROW_4 = new ResourceLocation(Cataclysm.MODID,"textures/entity/leviathan/dimensional_rift/dimensional_rift_grow_3.png");



    public RendererDimensional_Rift(EntityRendererProvider.Context mgr) {
        super(mgr);

    }

    public void render(Dimensional_Rift_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        ResourceLocation tex = entityIn.getStage() <1 ? TEXTURE_GROW_1 : entityIn.getStage() < 2 ? TEXTURE_GROW_2 : entityIn.getStage() < 3 ? TEXTURE_GROW_3 : entityIn.getStage() < 4 ? TEXTURE_GROW_4 : this.getIdleTexture(entityIn.tickCount % 9);

        matrixStackIn.mulPose(this.entityRenderDispatcher.cameraOrientation());
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0F));
        matrixStackIn.scale(7, 7, 7);
        PoseStack.Pose posestack$pose = matrixStackIn.last();
        Matrix4f matrix4f = posestack$pose.pose();
        Matrix3f matrix3f = posestack$pose.normal();
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getfullBright(tex));
        vertex(vertexconsumer, matrix4f, matrix3f, packedLightIn, 0.0F, 0, 0, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, packedLightIn, 1.0F, 0, 1, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, packedLightIn, 1.0F, 1, 1, 0);
        vertex(vertexconsumer, matrix4f, matrix3f, packedLightIn, 0.0F, 1, 0, 0);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private static void vertex(VertexConsumer p_114090_, Matrix4f p_114091_, Matrix3f p_114092_, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_) {
        p_114090_.vertex(p_114091_, p_114094_ - 0.5F, (float)p_114095_ - 0.25F, 0.0F).color(255, 255, 255, 255).uv((float)p_114096_, (float)p_114097_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_114093_).normal(p_114092_, 0.0F, 1.0F, 0.0F).endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(Dimensional_Rift_Entity entity) {
        return TEXTURE_IDLE_1;
    }

    public ResourceLocation getIdleTexture(int age) {
        if (age < 3) {
            return TEXTURE_IDLE_1;
        } else if (age < 6) {
            return TEXTURE_IDLE_2;
        } else if (age < 10) {
            return TEXTURE_IDLE_3;
        } else {
            return TEXTURE_IDLE_4;
        }
    }
}
