package com.github.L_Ender.cataclysm.client.render.blockentity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.Mechanical_fusion_Anvil;
import com.github.L_Ender.cataclysm.client.model.block.Mechanical_Anvil_Model;
import com.github.L_Ender.cataclysm.blockentities.Mechanical_fusion_Anvil_Block_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class RendererMechanical_fusion_anvil<T extends Mechanical_fusion_Anvil_Block_Entity> implements BlockEntityRenderer<T> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/block/mechanical_fusion_anvil.png");
    private static final Mechanical_Anvil_Model MODEL = new Mechanical_Anvil_Model();

    public RendererMechanical_fusion_anvil(Context rendererDispatcherIn) {
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.pushPose();
        Direction dir = tileEntityIn.getBlockState().getValue(Mechanical_fusion_Anvil.FACING);
        if(dir == Direction.NORTH){
            matrixStackIn.translate(0.5, 1.5F, 0.5F);
        }else if(dir == Direction.EAST){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }else if(dir == Direction.SOUTH){
            matrixStackIn.translate(0.5, 1.5F, 0.5F);
        }else if(dir == Direction.WEST){
            matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        }
        matrixStackIn.mulPose(dir.getOpposite().getRotation());
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(90.0F));
        matrixStackIn.pushPose();
        MODEL.animate(tileEntityIn, partialTicks);;
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn);
        matrixStackIn.popPose();
        matrixStackIn.popPose();
    }

}


