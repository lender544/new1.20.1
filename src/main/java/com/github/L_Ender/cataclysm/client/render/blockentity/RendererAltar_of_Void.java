package com.github.L_Ender.cataclysm.client.render.blockentity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.block.Altar_of_Void_Model;
import com.github.L_Ender.cataclysm.blockentities.AltarOfVoid_Block_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class RendererAltar_of_Void<T extends AltarOfVoid_Block_Entity> implements BlockEntityRenderer<T> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/block/altar_of_void.png");
    private static final Altar_of_Void_Model MODEL = new Altar_of_Void_Model();

    public RendererAltar_of_Void(Context rendererDispatcherIn) {
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        matrixStackIn.scale(1.0F, -1.0F, -1.0F);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.popPose();
    }

}


