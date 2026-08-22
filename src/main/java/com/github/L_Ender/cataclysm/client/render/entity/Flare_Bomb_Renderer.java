package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Flare_Bomb_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.etc.TrailRenderer;
import com.github.L_Ender.cataclysm.client.render.etc.TrailSettings;
import com.github.L_Ender.cataclysm.entity.projectile.Flare_Bomb_Entity;
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

import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

import java.util.List;


public class Flare_Bomb_Renderer extends EntityRenderer<Flare_Bomb_Entity> {

    private static final ResourceLocation OUTER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/monstrosity/flare_bomb_outer.png");

    private static final ResourceLocation INNER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/monstrosity/flare_bomb_inner.png");
    private static final ResourceLocation TRAIL_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/particle/amogus.png");

    private static final ResourceLocation NEW_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/entity/monstrosity/new_flare_bomb.png");


    private final Flare_Bomb_Model model;
    private final RandomSource random = RandomSource.create();
    public Flare_Bomb_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        model = new Flare_Bomb_Model(renderManagerIn.bakeLayer(CMModelLayers.FLARE_BOMB_MODEL));
    }


    @Override
    public void render(Flare_Bomb_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(Axis.YN.rotationDegrees(entityYaw));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(RenderType.beaconBeam(this.getTextureLocation(entityIn),true));
        model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, 0, 0);
        model.renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
        matrixStackIn.popPose();

        if (entityIn.shouldTrailRender()) {
            matrixStackIn.pushPose();
            PoseStack.Pose pose = matrixStackIn.last();
            List<Vec3> points = entityIn.getTrailPoints();
            Vec3 anchor = entityIn.getPosition(partialTicks);
            points.addFirst(anchor);
            TrailSettings settings = entityIn.getTrailSettings();
            TrailRenderer.drawTrail(anchor, points, pose, packedLightIn, partialTicks, settings, bufferIn);
            matrixStackIn.popPose();
        }
    }

    protected int getBlockLightLevel(Flare_Bomb_Entity entityIn, BlockPos pos) {
        return 15;
    }


    @Override
    public ResourceLocation getTextureLocation(Flare_Bomb_Entity entity) {
        return NEW_TEXTURE;
    }
}
