package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Wave_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.effect.Wave_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Wave_Renderer extends EntityRenderer<Wave_Entity> {

    private static final ResourceLocation WAVE_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/wave.png");
    public Wave_Model model;

    public Wave_Renderer(EntityRendererProvider.Context manager)
    {
        super(manager);
        this.model = new Wave_Model(manager.bakeLayer(CMModelLayers.WAVE_MODEL));
    }


    @Override
    public void render(Wave_Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YN.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) + 180.0F));
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        model.setupAnim(entity, 0, 0, entity.tickCount + partialTicks, 0, 0);
        VertexConsumer vertexconsumer = buffer.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entity)));
      //  this.model.setupAnim(f, f1);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }



    @Override
    public ResourceLocation getTextureLocation(Wave_Entity entity)
    {
        return WAVE_TEXTURES;
    }
}
