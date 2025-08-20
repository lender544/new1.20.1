package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Wither_Homing_Missile_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Flare_Bomb_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Wither_Homing_Missile_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class Wither_Homing_Missile_Renderer extends EntityRenderer<Wither_Homing_Missile_Entity>
{
    private static final ResourceLocation WITHER_MISSILE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/harbinger/wither_homing_missile.png");
    private static final ResourceLocation TRAIL_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/particle/amogus.png");
    protected final EntityRenderDispatcher entityRenderDispatcher;
    public Wither_Homing_Missile_Model model;

    public Wither_Homing_Missile_Renderer(EntityRendererProvider.Context manager)
    {
        super(manager);
        this.model = new Wither_Homing_Missile_Model();
        entityRenderDispatcher = manager.getEntityRenderDispatcher();
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
        if (entityIn.hasTrail()) {
            double x = Mth.lerp(partialTicks, entityIn.xOld, entityIn.getX());
            double y = Mth.lerp(partialTicks, entityIn.yOld, entityIn.getY());
            double z = Mth.lerp(partialTicks, entityIn.zOld, entityIn.getZ());
            float r = 251/255F;
            float g = 107/255F;
            float b = 29/255F;
            matrixStackIn.pushPose();
            matrixStackIn.translate(-x, -y, -z);
            renderTrail(entityIn, partialTicks, matrixStackIn, bufferIn, r, g, b, 1.0F, packedLightIn);
            matrixStackIn.popPose();
        }


        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private void renderTrail(Wither_Homing_Missile_Entity entityIn, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, float trailR, float trailG, float trailB, float trailA, int packedLightIn) {

        int sampleSize = 10;
        float trailWidth = 0.2F;

        PoseStack.Pose lastPose = poseStack.last();
        Matrix4f matrix = lastPose.pose();
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getLightTrailEffect(TRAIL_TEXTURE));


        Vec3 drawFrom = entityIn.getTrailPosition(0, partialTicks);

        Vec3 cameraPos = this.entityRenderDispatcher.camera.getPosition();

        for (int i = 0; i < sampleSize; i++) {
            Vec3 sample = entityIn.getTrailPosition(i + 1, partialTicks);
            float u1 = i / (float) sampleSize;
            float u2 = u1 + (1.0F / sampleSize);

            Vec3 forward = sample.subtract(drawFrom);
            if (forward.lengthSqr() == 0) continue;

            Vec3 toCamera = cameraPos.subtract(drawFrom);

            Vec3 side = forward.cross(toCamera).normalize();

            Vec3 offset = side.scale(trailWidth / 2.0F);

            addVertex(vertexconsumer, matrix, drawFrom.add(offset),       trailR, trailG, trailB, u1, 0F, packedLightIn); // Top-left
            addVertex(vertexconsumer, matrix, drawFrom.add(offset.scale(-1)), trailR, trailG, trailB, u1, 1F, packedLightIn); // Bottom-left
            addVertex(vertexconsumer, matrix, sample.add(offset.scale(-1)),   trailR, trailG, trailB, u2, 1F, packedLightIn); // Bottom-right
            addVertex(vertexconsumer, matrix, sample.add(offset),           trailR, trailG, trailB, u2, 0F, packedLightIn); // Top-right

            drawFrom = sample;
        }
    }

    // Update the addVertex method to simplify its signature
    private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, float r, float g, float b, float u, float v, int light) {
        consumer.addVertex(matrix, (float)pos.x, (float)pos.y, (float)pos.z)
                .setColor(r, g, b, 1.0F)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(0.0F, 1.0F, 0.0F); // Normal can be fixed as lighting is emissive
    }

    @Override
    public ResourceLocation getTextureLocation(Wither_Homing_Missile_Entity entity)
    {
        return WITHER_MISSILE;
    }
}
