package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Eye_Of_Dungeon_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;


@OnlyIn(Dist.CLIENT)
public class Eye_Of_Dungeon_Renderer extends EntityRenderer<Eye_Of_Dungeon_Entity> {
    private final ItemRenderer itemRenderer;
    private static final ResourceLocation TRAIL_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/particle/gathering_lightning.png");

    public Eye_Of_Dungeon_Renderer(Context renderManagerIn) {
        super(renderManagerIn);
        this.itemRenderer = renderManagerIn.getItemRenderer();
    }


    @Override
    public void render(Eye_Of_Dungeon_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        if (entityIn.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(entityIn) < 12.25)) {
            matrixStackIn.pushPose();
            matrixStackIn.mulPose(this.entityRenderDispatcher.cameraOrientation());
            this.itemRenderer
                    .renderStatic(
                            entityIn.getItem(),
                            ItemDisplayContext.GROUND,
                            packedLightIn,
                            OverlayTexture.NO_OVERLAY,
                            matrixStackIn,
                            bufferIn,
                            entityIn.level(),
                            entityIn.getId()
                    );
            matrixStackIn.popPose();
            if (entityIn.hasTrail()) {
                double x = Mth.lerp(partialTicks, entityIn.xOld, entityIn.getX());
                double y = Mth.lerp(partialTicks, entityIn.yOld, entityIn.getY());
                double z = Mth.lerp(partialTicks, entityIn.zOld, entityIn.getZ());
                float r = entityIn.getR()/255F ;
                float g = entityIn.getG()/255F;
                float b = entityIn.getB()/255F;
                matrixStackIn.pushPose();
                matrixStackIn.translate(-x, -y, -z);
                renderTrail(entityIn, partialTicks, matrixStackIn, bufferIn, r, g, b, 1.0F, packedLightIn);
                matrixStackIn.popPose();
            }
            super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        }

    }

    private void renderTrail(Eye_Of_Dungeon_Entity entityIn, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, float trailR, float trailG, float trailB, float trailA, int packedLightIn) {
        int sampleSize = 10;
        float trailHeight = 0.1F;
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
    protected int getBlockLightLevel(Eye_Of_Dungeon_Entity entity, BlockPos pos) {
        return 15;
    }


    public ResourceLocation getTextureLocation(Eye_Of_Dungeon_Entity p_114632_) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
