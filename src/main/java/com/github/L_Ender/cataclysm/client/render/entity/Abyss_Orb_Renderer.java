package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Orb_Entity;
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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class Abyss_Orb_Renderer extends EntityRenderer<Abyss_Orb_Entity> {
    private static final ResourceLocation TEXTURE_LOCATION = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/leviathan/abyss_orb.png");
    private static final RenderType RENDER_TYPE = RenderType.entityCutoutNoCull(TEXTURE_LOCATION);

    public Abyss_Orb_Renderer(EntityRendererProvider.Context p_173962_) {
        super(p_173962_);
    }

    protected int getBlockLightLevel(Abyss_Orb_Entity p_114087_, BlockPos p_114088_) {
        return 15;
    }

    public void render(Abyss_Orb_Entity p_114080_, float p_114081_, float p_114082_, PoseStack p_114083_, MultiBufferSource p_114084_, int p_114085_) {
        p_114083_.pushPose();
        p_114083_.scale(1.0F, 1.0F, 1.0F);
        p_114083_.mulPose(this.entityRenderDispatcher.cameraOrientation());
        p_114083_.mulPose(Axis.YP.rotationDegrees(180.0F));
        PoseStack.Pose posestack$pose = p_114083_.last();

        VertexConsumer vertexconsumer = p_114084_.getBuffer(RENDER_TYPE);
        vertex(vertexconsumer, posestack$pose, p_114085_, 0.0F, 0, 0, 1);
        vertex(vertexconsumer, posestack$pose, p_114085_, 1.0F, 0, 1, 1);
        vertex(vertexconsumer, posestack$pose, p_114085_, 1.0F, 1, 1, 0);
        vertex(vertexconsumer, posestack$pose, p_114085_, 0.0F, 1, 0, 0);
        p_114083_.popPose();
        super.render(p_114080_, p_114081_, p_114082_, p_114083_, p_114084_, p_114085_);
    }

    private static void vertex(VertexConsumer p_114090_, PoseStack.Pose normals, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_) {
        p_114090_.addVertex(normals, p_114094_ - 0.5F, (float)p_114095_ - 0.25F, 0.0F).setColor(255, 255, 255, 255).setUv((float)p_114096_, (float)p_114097_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_114093_).setNormal(normals, 0.0F, 1.0F, 0.0F);
    }

    public ResourceLocation getTextureLocation(Abyss_Orb_Entity p_114078_) {
        return TEXTURE_LOCATION;
    }
}
