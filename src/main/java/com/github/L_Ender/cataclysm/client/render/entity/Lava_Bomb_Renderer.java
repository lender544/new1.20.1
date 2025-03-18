package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Lava_Bomb_Model;
import com.github.L_Ender.cataclysm.entity.projectile.Lava_Bomb_Entity;
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
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Quaternionf;


@OnlyIn(Dist.CLIENT)
public class Lava_Bomb_Renderer extends EntityRenderer<Lava_Bomb_Entity> {

    private static final ResourceLocation FIRE_BOMB_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/fire_bomb.png");
    private final Lava_Bomb_Model model = new Lava_Bomb_Model();


    public Lava_Bomb_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void render(Lava_Bomb_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, (double)0.25F, 0.0D);
        float scale = entityIn.getGround() ? 0F : 1F;
        matrixStackIn.scale(scale,scale,scale);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 180.0F));
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(entityIn)));
        model.renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        matrixStackIn.popPose();
    }

    protected int getBlockLightLevel(Lava_Bomb_Entity entityIn, BlockPos pos) {
        return 15;
    }

    @Override
    public ResourceLocation getTextureLocation(Lava_Bomb_Entity entity) {
        return FIRE_BOMB_TEXTURES;
    }
}
