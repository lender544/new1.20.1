package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Void_Howitzer_Model;
import com.github.L_Ender.cataclysm.entity.projectile.Void_Howitzer_Entity;
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class Void_Howitzer_Renderer extends EntityRenderer<Void_Howitzer_Entity> {

    private static final ResourceLocation VOID_HOWITZER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/void_howitzer.png");
    private final Void_Howitzer_Model model = new Void_Howitzer_Model();


    public Void_Howitzer_Renderer(Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(Void_Howitzer_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(1.5F, 1.5F, 1.5F);
        matrixStackIn.translate(0.0D, (double)0.25F, 0.0D);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 180.0F));
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY);;
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        
    }

    protected int getBlockLightLevel(Void_Howitzer_Entity entityIn, BlockPos pos) {
        return 15;
    }

    @Override
    public ResourceLocation getTextureLocation(Void_Howitzer_Entity entity) {
        return VOID_HOWITZER_TEXTURES;
    }
}
