package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.client.model.entity.ModelAncient_Desert_Stele;
import com.github.L_Ender.cataclysm.entity.projectile.Ancient_Desert_Stele_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererAncient_Desert_Stele extends EntityRenderer<Ancient_Desert_Stele_Entity> {
    private static final ResourceLocation ANCIENT_DESERT_STELE = new ResourceLocation("cataclysm:textures/entity/ancient_desert_stele.png");
    private final ModelAncient_Desert_Stele model = new ModelAncient_Desert_Stele();

    public RendererAncient_Desert_Stele(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Ancient_Desert_Stele_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F - entityIn.getYRot()));
        matrixStackIn.translate(0.0D, 1.5F, 0.0D);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(Ancient_Desert_Stele_Entity entity) {
        return ANCIENT_DESERT_STELE;
    }
}
