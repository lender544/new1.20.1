package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.projectile.Octo_Ink_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.LlamaSpitModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Octo_Ink_Renderer extends EntityRenderer<Octo_Ink_Entity> {
    private static final ResourceLocation LLAMA_SPIT_LOCATION = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/octo_ink.png");
    private final LlamaSpitModel<Octo_Ink_Entity> model;

    public Octo_Ink_Renderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new LlamaSpitModel<>(context.bakeLayer(ModelLayers.LLAMA_SPIT));
    }

    public void render(Octo_Ink_Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.15F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));
        this.model.setupAnim(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = buffer.getBuffer(this.model.renderType(LLAMA_SPIT_LOCATION));
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(Octo_Ink_Entity entity) {
        return LLAMA_SPIT_LOCATION;
    }
}