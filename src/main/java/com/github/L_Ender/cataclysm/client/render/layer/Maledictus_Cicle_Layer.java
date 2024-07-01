package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Model_Maledictus;
import com.github.L_Ender.cataclysm.client.render.entity.RendererMaledictus;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.*;

import static net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;

@OnlyIn(Dist.CLIENT)
public class Maledictus_Cicle_Layer extends RenderLayer<Maledictus_Entity, Model_Maledictus> {
    protected final EntityRenderDispatcher entityRenderDispatcher;

    public Maledictus_Cicle_Layer(RendererMaledictus renderIn, EntityRendererProvider.Context context) {
        super(renderIn);
        entityRenderDispatcher = context.getEntityRenderDispatcher();
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        rendercicle(matrixStackIn,bufferIn,packedLightIn,entity ,true);
        rendercicle(matrixStackIn,bufferIn,packedLightIn,entity ,false);
    }


    private void rendercicle(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Maledictus_Entity entity, boolean right){
        Quaternionf camera = this.entityRenderDispatcher.cameraOrientation();
        matrixStackIn.pushPose();
        matrixStackIn.pushPose();
        translateToHand(matrixStackIn, right);
        matrixStackIn.mulPose(camera);
        matrixStackIn.translate(0.0F, -0.1F, 0.0F);
        PoseStack.Pose posestack$pose = matrixStackIn.last();
        Matrix4f matrix4f = posestack$pose.pose();
        Matrix3f matrix3f = posestack$pose.normal();
        VertexConsumer portalStatic = bufferIn.getBuffer(RenderType.entityTranslucent(new ResourceLocation(Cataclysm.MODID, "textures/particle/ring_2.png"),true));
        if(entity.getAttackState() == 1) {
            if (entity.attackTicks <= 50 ) {
                drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.95f, 0.5215f, 0.1333F);
            }
        }
        if(entity.getAttackState() == 2) {
            if (entity.attackTicks <= 50) {
                drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.09f,0.42f,0.35F);
            }
        }
        if(entity.getAttackState() == 3) {
            if (entity.attackTicks >= 15 && entity.attackTicks <= 65) {
                drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.09f,0.42f,0.35F);
            }
        }
        if(entity.getAttackState() == 7) {
            if (entity.attackTicks <= 50 ) {
                drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f,0.062f,0.019F);
            }
        }
        if(entity.getAttackState() == 8) {
            if (entity.attackTicks <= 50 ) {
                drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f,0.062f,0.019F);
            }
        }
        if(entity.getAttackState() == 12 || entity.getAttackState() == 13 || entity.getAttackState() == 14 || entity.getAttackState() == 11) {
            if (entity.attackTicks <= 50 ) {
                drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f,0.062f,0.019F);
            }
        }
        if(entity.getAttackState() == 15 || entity.getAttackState() == 16) {
            if (entity.attackTicks <= 50 ) {
                drawCircle(portalStatic, matrix4f, matrix3f, packedLightIn, 0.423f,0.062f,0.019F);
            }
        }
        matrixStackIn.popPose();
        matrixStackIn.popPose();
    }

    private void drawCircle(VertexConsumer vertex,Matrix4f matrix4f, Matrix3f matrix3f, int packedLightIn, float r,float g,float b) {

        cirlceVertex(vertex, matrix4f, matrix3f, packedLightIn, 0.0F, 0, 0, 1, 1.0F,r,g,b);
        cirlceVertex(vertex, matrix4f, matrix3f, packedLightIn, 1.0F, 0, 1, 1, 1.0F,r,g,b);
        cirlceVertex(vertex, matrix4f, matrix3f, packedLightIn, 1.0F, 1, 1, 0, 1.0F,r,g,b);
        cirlceVertex(vertex, matrix4f, matrix3f, packedLightIn, 0.0F, 1, 0, 0, 1.0F,r,g,b);
    }

    private static void cirlceVertex(VertexConsumer vertex, Matrix4f mat4f, Matrix3f mat3f, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_, float alpha, float r,float g,float b) {
        vertex.vertex(mat4f, p_114094_ - 0.5F, (float)p_114095_ - 0.25F, 0.0F).color(r, g, b,  alpha).uv((float)p_114096_, (float)p_114097_).overlayCoords(NO_OVERLAY).uv2(240).normal(mat3f, 0.0F, -1.0F, 0.0F).endVertex();
    }
    

    public void translateToHand(PoseStack matrixStack,boolean right) {
        this.getParentModel().root.translateAndRotate(matrixStack);
        this.getParentModel().berserker.translateAndRotate(matrixStack);
        this.getParentModel().pelvis.translateAndRotate(matrixStack);
        this.getParentModel().body.translateAndRotate(matrixStack);
        if(right) {
            this.getParentModel().right_shoulder.translateAndRotate(matrixStack);
            this.getParentModel().right_arm.translateAndRotate(matrixStack);
            this.getParentModel().right_front_arm.translateAndRotate(matrixStack);
            this.getParentModel().right_particle.translateAndRotate(matrixStack);
        }else{
            this.getParentModel().left_shoulder.translateAndRotate(matrixStack);
            this.getParentModel().left_arm.translateAndRotate(matrixStack);
            this.getParentModel().left_front_arm.translateAndRotate(matrixStack);
            this.getParentModel().left_particle.translateAndRotate(matrixStack);
        }
    }


}


