package com.github.L_Ender.cataclysm.client.render.blockentity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blockentities.TileEntityAbyssal_Egg;
import com.github.L_Ender.cataclysm.client.model.block.Abyssal_Egg_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class RendererAbyssal_Egg implements BlockEntityRenderer<TileEntityAbyssal_Egg> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/abyssal_egg.png");
    private static final ResourceLocation LAYER_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/abyssal_egg_layer.png");
    private static final Abyssal_Egg_Model MODEL = new Abyssal_Egg_Model();

    public RendererAbyssal_Egg(Context rendererDispatcherIn) {
    }

    @Override
    public void render(TileEntityAbyssal_Egg tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        matrixStackIn.scale(1.0F, -1.0F, -1.0F);
        MODEL.animate(tileEntityIn, partialTicks);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn, 1, 1F, 1, 1);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.getghost(LAYER_TEXTURE)), combinedLightIn, combinedOverlayIn, 1, 1F, 1, 1);
        matrixStackIn.popPose();
    }


}


