package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Flare_Bomb_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Flare_Bomb_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
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


public class Flare_Bomb_Renderer extends EntityRenderer<Flare_Bomb_Entity> {

    private static final ResourceLocation OUTER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/monstrosity/flare_bomb_outer.png");

    private static final ResourceLocation INNER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/monstrosity/flare_bomb_inner.png");
    private static final ResourceLocation TRAIL_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/particle/amogus.png");

    private final Flare_Bomb_Model model;
    private final RandomSource random = RandomSource.create();
    public Flare_Bomb_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        model = new Flare_Bomb_Model(renderManagerIn.bakeLayer(CMModelLayers.FLARE_BOMB_MODEL));
    }


    @Override
    public void render(Flare_Bomb_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose((new Quaternionf()).setAngleAxis(entityYaw * ((float)Math.PI / 180F), 0, -1.0F, 0));
        VertexConsumer VertexConsumer = bufferIn.getBuffer(CMRenderTypes.CMEyes(this.getTextureLocation(entityIn)));
        model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, 0, 0);
        model.renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
        VertexConsumer VertexConsumer2 = bufferIn.getBuffer(CMRenderTypes.CMEyes(OUTER_TEXTURES));

        int i = FastColor.ARGB32.color(102, 255, 255, 255);
        model.renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, i);
        matrixStackIn.popPose();
        if (entityIn.hasTrail()) {
            double x = Mth.lerp(partialTicks, entityIn.xOld, entityIn.getX());
            double y = Mth.lerp(partialTicks, entityIn.yOld, entityIn.getY());
            double z = Mth.lerp(partialTicks, entityIn.zOld, entityIn.getZ());
            float ran = 0.04f;
            float r = 195/255F + random.nextFloat() * ran * 1.5F;
            float g = 95/255F + random.nextFloat() * ran;
            float b = 3/255F + random.nextFloat() * ran;
            matrixStackIn.pushPose();
            matrixStackIn.translate(-x, -y, -z);
            renderTrail(entityIn, partialTicks, matrixStackIn, bufferIn, r, g, b, 1.0F, packedLightIn);
            matrixStackIn.popPose();
        }
    }

    protected int getBlockLightLevel(Flare_Bomb_Entity entityIn, BlockPos pos) {
        return 15;
    }

    private void renderTrail(Flare_Bomb_Entity entityIn, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, float trailR, float trailG, float trailB, float trailA, int packedLightIn) {
        int sampleSize = 10;
        float trailHeight = 0.5F;
        float trailZRot = 0;
        Vec3 topAngleVec = new Vec3(0, trailHeight, 0).zRot(trailZRot);
        Vec3 bottomAngleVec = new Vec3(0, -trailHeight, 0).zRot(trailZRot);
        Vec3 drawFrom = entityIn.getTrailPosition(0, partialTicks);
        PoseStack.Pose lastPose = poseStack.last();
        Matrix4f matrix = lastPose.pose();
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getLightTrailEffect(TRAIL_TEXTURE));

        for (int samples = 0; samples < sampleSize; samples++) {
            Vec3 sample = entityIn.getTrailPosition(samples + 2, partialTicks);
            float u1 = samples / (float) sampleSize;
            float u2 = u1 + 1 / (float) sampleSize;

            addVertex(vertexconsumer, matrix, drawFrom, bottomAngleVec, trailR,trailG,trailB,u1, 1F, packedLightIn);
            addVertex(vertexconsumer, matrix, sample, bottomAngleVec,  trailR,trailG,trailB,u2,1F, packedLightIn);
            addVertex(vertexconsumer, matrix, sample, topAngleVec, trailR,trailG,trailB,u2,0F, packedLightIn);
            addVertex(vertexconsumer, matrix, drawFrom, topAngleVec, trailR,trailG,trailB, u1,0F, packedLightIn);

            drawFrom = sample;
        }
    }

    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, Vec3 offset,float r,float g,float b, float u, float v, int light) {
        consumer.addVertex(matrix,
                        (float) (pos.x + offset.x),
                        (float) (pos.y + offset.y),
                        (float) (pos.z + offset.z))
                .setColor(r, g, b, 1.0F)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(0.0F, 1.0F, 0.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(Flare_Bomb_Entity entity) {
        return INNER_TEXTURES;
    }
}
