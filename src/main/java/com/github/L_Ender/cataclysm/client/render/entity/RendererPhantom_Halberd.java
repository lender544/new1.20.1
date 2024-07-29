package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.client.model.entity.ModelVoid_Rune;
import com.github.L_Ender.cataclysm.client.model.entity.Model_Phantom_Halberd;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class RendererPhantom_Halberd extends EntityRenderer<Phantom_Halberd_Entity> {
    private static final ResourceLocation PHANTOM_HALBERD = new ResourceLocation("cataclysm:textures/entity/phantom_halberd.png");
    private final Model_Phantom_Halberd model = new Model_Phantom_Halberd();
    private static final RenderType DECAL = RenderType.entityDecal(PHANTOM_HALBERD);
    private static final RenderType RENDER_TYPE = RenderType.entityCutoutNoCull(PHANTOM_HALBERD);
    public RendererPhantom_Halberd(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Phantom_Halberd_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {

        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F - entityIn.getYRot()));
        matrixStackIn.translate(0.0D, 1.25F, 0.0D);
        matrixStackIn.scale(-0.8F, -0.8F, 0.8F);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entityIn)));
        model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, 0, 0);
        if (entityIn.lifeTicks > 0) {
            float f2 = (float)entityIn.lifeTicks / 70F;
            VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.DragonDeath(this.getTextureLocation(entityIn)));
            this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, f2);
            VertexConsumer vertexconsumer1 = bufferIn.getBuffer(DECAL);
            this.model.renderToBuffer(matrixStackIn, vertexconsumer1, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        } else {
            VertexConsumer vertexconsumer3 = bufferIn.getBuffer(RENDER_TYPE);
            this.model.renderToBuffer(matrixStackIn, vertexconsumer3, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

    }
    protected int getBlockLightLevel(Phantom_Halberd_Entity entityIn, BlockPos pos) {
        return 15;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(Phantom_Halberd_Entity entity) {
        return PHANTOM_HALBERD;
    }
}
