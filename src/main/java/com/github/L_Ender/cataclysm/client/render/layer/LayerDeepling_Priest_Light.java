package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.ModelDeepling_Priest;
import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Priest_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.RandomSource;
import org.joml.Matrix4f;

public class LayerDeepling_Priest_Light extends RenderLayer<Deepling_Priest_Entity, ModelDeepling_Priest> {
    private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0D) / 2.0D);

    public LayerDeepling_Priest_Light(RenderLayerParent p_234846_) {
        super(p_234846_);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Deepling_Priest_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();
        if (entity.getAnimation() == Deepling_Priest_Entity.DEEPLING_BLIND && entity.getAnimationTick() >18 && entity.getAnimationTick() <47) {
            float f5 = ((float)entity.getAnimationTick() + partialTicks) / 144;
            float f7 = Math.min(f5 > 0.8F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
            RandomSource randomsource = RandomSource.create(432L);
            VertexConsumer vertexconsumer2 = bufferIn.getBuffer(RenderType.lightning());
            matrixStackIn.pushPose();
            translateToLight(matrixStackIn);

            for(int i = 0; (float)i < 4; ++i) {
                matrixStackIn.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.mulPose(Axis.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
                matrixStackIn.mulPose(Axis.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F + f5 * 90.0F));
                float f3 = 2.75F;
                float f4 = 2.75F;
                Matrix4f matrix4f = matrixStackIn.last().pose();
                int j = (int)(255.0F * (1.0F - f7));
                vertex01(vertexconsumer2, matrix4f, j);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex3(vertexconsumer2, matrix4f, f3, f4);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex01(vertexconsumer2, matrix4f, j);
                vertex4(vertexconsumer2, matrix4f, f3, f4);
                vertex2(vertexconsumer2, matrix4f, f3, f4);
            }

            matrixStackIn.popPose();
        }

        matrixStackIn.popPose();

    }

    private static void vertex01(VertexConsumer p_114220_, Matrix4f p_114221_, int p_114222_) {
        p_114220_.vertex(p_114221_, 0.0F, 0.0F, 0.0F).color(51, 255, 255, p_114222_).endVertex();
    }

    private static void vertex2(VertexConsumer p_114215_, Matrix4f p_114216_, float p_114217_, float p_114218_) {
        p_114215_.vertex(p_114216_, -HALF_SQRT_3 * p_114218_, p_114217_, -0.5F * p_114218_).color(51, 255, 255, 0).endVertex();
    }

    private static void vertex3(VertexConsumer p_114224_, Matrix4f p_114225_, float p_114226_, float p_114227_) {
        p_114224_.vertex(p_114225_, HALF_SQRT_3 * p_114227_, p_114226_, -0.5F * p_114227_).color(51, 255, 255, 0).endVertex();
    }

    private static void vertex4(VertexConsumer p_114229_, Matrix4f p_114230_, float p_114231_, float p_114232_) {
        p_114229_.vertex(p_114230_, 0.0F, p_114231_, 1.0F * p_114232_).color(51, 255, 255, 0).endVertex();
    }

    private void translateToLight(PoseStack matrixStack) {
        this.getParentModel().root.translateAndRotate(matrixStack);
        this.getParentModel().body.translateAndRotate(matrixStack);
        this.getParentModel().head.translateAndRotate(matrixStack);
        this.getParentModel().head2.translateAndRotate(matrixStack);
        this.getParentModel().fin.translateAndRotate(matrixStack);
        this.getParentModel().light.translateAndRotate(matrixStack);
    }

}
