package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Wither_Homing_Missile_Model;
import com.github.L_Ender.cataclysm.entity.projectile.Wither_Homing_Missile_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Wither_Homing_Missile_Renderer extends EntityRenderer<Wither_Homing_Missile_Entity>
{
    private static final ResourceLocation WITHER_MISSILE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/harbinger/wither_homing_missile.png");

    public Wither_Homing_Missile_Model model;

    public Wither_Homing_Missile_Renderer(EntityRendererProvider.Context manager)
    {
        super(manager);
        this.model = new Wither_Homing_Missile_Model();
    }

    @Override
    protected int getBlockLightLevel(Wither_Homing_Missile_Entity entity, BlockPos pos)
    {
        return 15;
    }

    @Override
    public void render(Wither_Homing_Missile_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(-1.5F, -1.5F, 1.5F);
        matrixStackIn.translate(0F, 0.04F, 0F);
        float f = Mth.rotLerp(partialTicks, entityIn.yRotO, entityIn.getYRot());
        float f1 = Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot());
        VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn)));
        this.model.setupAnim(entityIn, 0.0F, 0.0F, 0.0F, f, f1);
        this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(Wither_Homing_Missile_Entity entity)
    {
        return WITHER_MISSILE;
    }
}
