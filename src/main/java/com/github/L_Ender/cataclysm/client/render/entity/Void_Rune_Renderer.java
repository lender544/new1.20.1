package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Void_Rune_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class Void_Rune_Renderer extends EntityRenderer<Void_Rune_Entity> {
    private static final ResourceLocation VOID_RUNE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/void_rune.png");
    private final Void_Rune_Model model = new Void_Rune_Model();
    private final Random rnd = new Random();

    public Void_Rune_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(Void_Rune_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {

        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F - entityIn.getYRot()));
        matrixStackIn.translate(0.0D, 3F, 0.0D);
        matrixStackIn.scale(-2.0F, -2.0F, 2.0F);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(CMRenderTypes.getBright(this.getTextureLocation(entityIn)));
        model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, 0, 0);
        this.model.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

    }

    public Vec3 getRenderOffset(Void_Rune_Entity entityIn, float partialTicks) {
        if (entityIn.activateProgress == 10) {
            return super.getRenderOffset(entityIn, partialTicks);
        } else {
            double d0 = 0.02D;
            return new Vec3(this.rnd.nextGaussian() * d0, 0.0D, this.rnd.nextGaussian() * d0);
        }
    }

    protected int getBlockLightLevel(Void_Rune_Entity entityIn, BlockPos pos) {
        return 15;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(Void_Rune_Entity entity) {
        return VOID_RUNE;
    }
}
