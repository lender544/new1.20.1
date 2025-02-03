package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Ancient_Desert_Stele_Model;
import com.github.L_Ender.cataclysm.entity.projectile.Ancient_Desert_Stele_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Ancient_Desert_Stele_Renderer extends EntityRenderer<Ancient_Desert_Stele_Entity> {
    private static final ResourceLocation ANCIENT_DESERT_STELE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/ancient_desert_stele.png");
    private final Ancient_Desert_Stele_Model model = new Ancient_Desert_Stele_Model();

    public Ancient_Desert_Stele_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Ancient_Desert_Stele_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F - entityIn.getYRot()));
        matrixStackIn.translate(0.0D, 1.5F, 0.0D);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
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
