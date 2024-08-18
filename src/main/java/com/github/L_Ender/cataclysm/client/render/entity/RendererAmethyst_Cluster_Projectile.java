package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelAmethyst_Cluster_Projectile;
import com.github.L_Ender.cataclysm.client.model.entity.ModelWither_Howitzer;
import com.github.L_Ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Wither_Howitzer_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class RendererAmethyst_Cluster_Projectile extends EntityRenderer<Amethyst_Cluster_Projectile_Entity> {

    private static final ResourceLocation WITHER_HOWITZER_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/amethyst_cluster_projectile.png");
    private final ModelAmethyst_Cluster_Projectile model = new ModelAmethyst_Cluster_Projectile();


    public RendererAmethyst_Cluster_Projectile(Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(Amethyst_Cluster_Projectile_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot()) + 90.0F));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        
    }

    protected int getBlockLightLevel(Amethyst_Cluster_Projectile_Entity entityIn, BlockPos pos) {
        return 15;
    }

    @Override
    public ResourceLocation getTextureLocation(Amethyst_Cluster_Projectile_Entity entity) {
        return WITHER_HOWITZER_TEXTURES;
    }
}
