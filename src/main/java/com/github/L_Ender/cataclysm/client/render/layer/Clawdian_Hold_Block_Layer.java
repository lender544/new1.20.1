package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.Clawdian_Model;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Clawdian_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Clawdian_Hold_Block_Layer extends RenderLayer<Clawdian_Entity, Clawdian_Model> {
    private final BlockRenderDispatcher blockRenderer;

    public Clawdian_Hold_Block_Layer(RenderLayerParent<Clawdian_Entity, Clawdian_Model> renderer, BlockRenderDispatcher blockRenderer) {
        super(renderer);
        this.blockRenderer = blockRenderer;
    }


    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Clawdian_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        BlockState blockstate = entity.getHoldBlock();
        if (blockstate != null) {
            int amount = 2;
            for (int i = 0; i < amount; i++) {
                for (int l = 0; l < amount; l++) {
                    float xOffset = (i * 2 - 1) * 0.5F;
                    float zOffset = (l * 2 - 1) * 0.5F;

                    matrixStackIn.pushPose();
                    this.getParentModel().translateToHand(matrixStackIn);
                    matrixStackIn.translate(0.5F + xOffset, 1.0F + 0.08 * (i + l), -0.7F + zOffset);
                    matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
                    this.blockRenderer.renderSingleBlock(blockstate, matrixStackIn, bufferIn, packedLightIn, OverlayTexture.NO_OVERLAY);
                    matrixStackIn.popPose();
                }
            }
        }
    }
}


