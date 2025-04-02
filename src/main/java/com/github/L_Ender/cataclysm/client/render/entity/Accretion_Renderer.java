package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Wither_Howitzer_Model;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Accretion_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Wither_Howitzer_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.RenderTypeHelper;
import net.neoforged.neoforge.client.model.data.ModelData;

import java.util.Iterator;


@OnlyIn(Dist.CLIENT)
public class Accretion_Renderer extends EntityRenderer<Accretion_Entity> {
    private final BlockRenderDispatcher blockRenderer;
    private final RandomSource rnd = RandomSource.create();
    public Accretion_Renderer(Context renderManagerIn) {
        super(renderManagerIn);
        this.blockRenderer  = renderManagerIn.getBlockRenderDispatcher();
    }



    @Override
    public void render(Accretion_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        BlockState blockstate = entityIn.getBlockState();
        if (blockstate != null) {
            if (blockstate.getRenderShape() == RenderShape.MODEL) {
                matrixStackIn.pushPose();
                matrixStackIn.translate(0.0, 0.5, 0.0);
                float f2 = (float) entityIn.tickCount + partialTicks;
                float random = (rnd.nextFloat()) * 0.03F;
                matrixStackIn.mulPose(Axis.ZP.rotationDegrees(random *f2 * 60.0F));
                matrixStackIn.mulPose(Axis.ZN.rotationDegrees(f2 * 36.0F));
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
                matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot()) + 90.0F));
                matrixStackIn.translate(-0.5, -0.5F, -0.5);
                matrixStackIn.scale(1.0F, 1.0F, 1.0F);
                this.blockRenderer.renderSingleBlock(blockstate, matrixStackIn, bufferIn, packedLightIn, OverlayTexture.NO_OVERLAY);
                matrixStackIn.popPose();
                super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
            }
        }

    }

    private float rotLerp(float prevRotation, float rotation, float partialTicks)
    {
        float f;
        for(f = rotation - prevRotation; f < -180.0F; f += 360.0F)
        {
            ;
        }

        while(f >= 180.0F)
        {
            f -= 360.0F;
        }

        return prevRotation + partialTicks * f;
    }

    public ResourceLocation getTextureLocation(Accretion_Entity p_114632_) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
