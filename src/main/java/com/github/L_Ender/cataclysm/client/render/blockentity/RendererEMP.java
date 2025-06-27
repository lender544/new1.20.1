package com.github.L_Ender.cataclysm.client.render.blockentity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.EMP_Block;
import com.github.L_Ender.cataclysm.client.model.block.EMP_Model;
import com.github.L_Ender.cataclysm.blockentities.EMP_Block_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class RendererEMP<T extends EMP_Block_Entity> implements BlockEntityRenderer<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/emp.png");
    private static final EMP_Model MODEL_EMP = new EMP_Model();

    public RendererEMP(Context rendererDispatcherIn) {
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        Direction dir = tileEntityIn.getBlockState().getValue(EMP_Block.TIP_DIRECTION);
        if(dir == Direction.UP){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }else {
            matrixStackIn.translate(0.5F, -0.5F, 0.5F);
        }
        matrixStackIn.mulPose(dir.getOpposite().getRotation());
        matrixStackIn.pushPose();
        matrixStackIn.translate(0, 0.15F, 0.0F);
        matrixStackIn.scale(0.9f,0.9f,0.9f);
        MODEL_EMP.animate(tileEntityIn, partialTicks);
        MODEL_EMP.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn, 1, 1F, 1, 1);
        matrixStackIn.popPose();
        matrixStackIn.popPose();
    }

}


