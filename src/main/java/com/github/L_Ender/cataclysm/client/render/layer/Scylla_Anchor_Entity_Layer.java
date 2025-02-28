package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Scylla_Model;
import com.github.L_Ender.cataclysm.client.model.entity.Storm_Bringer_Model;
import com.github.L_Ender.cataclysm.client.model.entity.The_Leviathan_Tongue_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Maledictus_Renderer;
import com.github.L_Ender.cataclysm.client.render.entity.Scylla_Renderer;
import com.github.L_Ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.L_Ender.cataclysm.client.render.etc.LightningRender;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.ShulkerHeadLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Vector4f;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;

@OnlyIn(Dist.CLIENT)
public class Scylla_Anchor_Entity_Layer extends RenderLayer<Scylla_Entity, Scylla_Model> {
    protected final EntityRenderDispatcher entityRenderDispatcher;
    private static final ResourceLocation CHAIN_TEXTURE = ResourceLocation.withDefaultNamespace("textures/block/chain.png");
    private static final ResourceLocation GUARDIAN_BEAM_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/guardian_beam.png");
    public Scylla_Anchor_Entity_Layer(Scylla_Renderer renderIn, EntityRendererProvider.Context context) {
        super(renderIn);
        entityRenderDispatcher = context.getEntityRenderDispatcher();
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Scylla_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
       // renderStromBringer(entity,partialTicks,matrixStackIn,bufferIn,packedLightIn);
      //  renderBeam(entity, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }




    public void renderStromBringer(Scylla_Entity entity, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        Entity weapon = entity.getAnchor();
        float bodyYaw = Mth.rotLerp(partialTicks, entity.yBodyRotO, entity.yBodyRot);
        if (weapon != null && entity.isAlive() && weapon.isAlive()) {
            matrixStackIn.pushPose();
            Vec3 translateFrom = entity.getPosition(partialTicks);

            Vec3 offset = new Vec3(0, 0.0F, 0F);
            Vec3 ridePos = getHandPosition(offset);
            Vec3 chainTo = entity.getChainFrom(partialTicks).add(ridePos).subtract(translateFrom);

            Vec3 chainFrom = entity.getChainTo(partialTicks).subtract(translateFrom).subtract(chainTo);
            matrixStackIn.translate(chainTo.x, chainTo.y, chainTo.z);
            VertexConsumer chainBuffer = bufferIn.getBuffer(RenderType.entityCutoutNoCull(CHAIN_TEXTURE));
            renderChainCube(chainFrom, matrixStackIn, chainBuffer, packedLightIn, LivingEntityRenderer.getOverlayCoords(entity, 0.0F));
            matrixStackIn.popPose();

        }
    }



    public static void renderChainCube(Vec3 to, PoseStack poseStack, VertexConsumer buffer, int packedLightIn, int setOverlay) {
        double d = to.horizontalDistance();
        float rotY = (float) (Mth.atan2(to.x, to.z) * (double) (180F / (float) Math.PI));
        float rotX = (float) (-(Mth.atan2(to.y, d) * (double) (180F / (float) Math.PI))) - 90.0F;
        float chainWidth = 3F / 16F;
        float chainOffset = chainWidth * -0.5F;
        float chainLength = (float) to.length();
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
        poseStack.mulPose(Axis.XP.rotationDegrees(rotX));
        poseStack.translate(0, -chainLength, 0);
        PoseStack.Pose posestack$pose = poseStack.last();
        //x links
        buffer.addVertex(posestack$pose, chainOffset, 0, 0).setColor(255, 255, 255, 255).setUv((float) 0, (float) chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        buffer.addVertex(posestack$pose, chainWidth + chainOffset, 0, 0).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        buffer.addVertex(posestack$pose, chainWidth + chainOffset, chainLength, 0).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) 0).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        buffer.addVertex(posestack$pose, chainOffset, chainLength, 0).setColor(255, 255, 255, 255).setUv((float) 0, (float) 0).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        float pixelSkip = 2.5F / 16F;
        //z links
        buffer.addVertex(posestack$pose, 0, pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        buffer.addVertex(posestack$pose, 0, pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth * 2, (float) chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        buffer.addVertex(posestack$pose, 0, chainLength + pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth * 2, (float) pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        buffer.addVertex(posestack$pose, 0, chainLength + pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
        poseStack.popPose();
    }

    private Vec3 getPosition(Entity livingEntity, double yOffset, float partialTick) {
        double d0 = Mth.lerp((double)partialTick, livingEntity.xOld, livingEntity.getX());
        double d1 = Mth.lerp((double)partialTick, livingEntity.yOld, livingEntity.getY()) + yOffset;
        double d2 = Mth.lerp((double)partialTick, livingEntity.zOld, livingEntity.getZ());
        return new Vec3(d0, d1, d2);
    }

    public void renderBeam(Scylla_Entity entity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        Entity target = entity.getAnchor();
        if (target != null) {


            float f3 = entity.getEyeHeight();
            poseStack.pushPose();
            poseStack.translate(0.0F, f3, 0.0F);
            Vec3 vec3 = this.getPosition(target, -f3, partialTicks);

            Vec3 offset = new Vec3(0, 0.0F, 0F);
            Vec3 modelOffset = getHandPosition2(entity,partialTicks);
            //Vec3 vec31 = getHandPosition2(entity,partialTicks);
            Vec3 vec31 = this.getPosition(entity, (double)f3, partialTicks);

            Vec3 vec32 = vec3.subtract(vec31);
            float f4 = (float)(vec32.length() + (double)1.0F);
            vec32 = vec32.normalize();
            float f5 = (float)Math.acos(vec32.y);
            float f6 = (float)Math.atan2(vec32.z, vec32.x);
            poseStack.mulPose(Axis.YP.rotationDegrees((((float)Math.PI / 2F) - f6) * (180F / (float)Math.PI)));
            poseStack.mulPose(Axis.XP.rotationDegrees(f5 * (180F / (float)Math.PI)));
            int i = 1;
            float f7 = 3 * 0.05F * -1.5F;

            int j = 64 ;
            int k = 32 ;
            int l = 128 ;
            float f9 = 0.2F;
            float f10 = 0.282F;
            float f11 = Mth.cos(f7 + 2.3561945F) * 0.282F;
            float f12 = Mth.sin(f7 + 2.3561945F) * 0.282F;
            float f13 = Mth.cos(f7 + ((float)Math.PI / 4F)) * 0.282F;
            float f14 = Mth.sin(f7 + ((float)Math.PI / 4F)) * 0.282F;
            float f15 = Mth.cos(f7 + 3.926991F) * 0.282F;
            float f16 = Mth.sin(f7 + 3.926991F) * 0.282F;
            float f17 = Mth.cos(f7 + 5.4977875F) * 0.282F;
            float f18 = Mth.sin(f7 + 5.4977875F) * 0.282F;
            float f19 = Mth.cos(f7 + (float)Math.PI) * 0.2F;
            float f20 = Mth.sin(f7 + (float)Math.PI) * 0.2F;
            float f21 = Mth.cos(f7 + 0.0F) * 0.2F;
            float f22 = Mth.sin(f7 + 0.0F) * 0.2F;
            float f23 = Mth.cos(f7 + ((float)Math.PI / 2F)) * 0.2F;
            float f24 = Mth.sin(f7 + ((float)Math.PI / 2F)) * 0.2F;
            float f25 = Mth.cos(f7 + ((float)Math.PI * 1.5F)) * 0.2F;
            float f26 = Mth.sin(f7 + ((float)Math.PI * 1.5F)) * 0.2F;
            float f27 = 0.0F;
            float f28 = 0.4999F;
            float f29 = -1.0F;
            float f30 = f4 * 2.5F + f29;
            VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(GUARDIAN_BEAM_LOCATION));
            PoseStack.Pose posestack$pose = poseStack.last();
            vertex(vertexconsumer, posestack$pose, f19, f4, f20, j, k, l, 0.4999F, f30);
            vertex(vertexconsumer, posestack$pose, f19, 0.0F, f20, j, k, l, 0.4999F, f29);
            vertex(vertexconsumer, posestack$pose, f21, 0.0F, f22, j, k, l, 0.0F, f29);
            vertex(vertexconsumer, posestack$pose, f21, f4, f22, j, k, l, 0.0F, f30);
            vertex(vertexconsumer, posestack$pose, f23, f4, f24, j, k, l, 0.4999F, f30);
            vertex(vertexconsumer, posestack$pose, f23, 0.0F, f24, j, k, l, 0.4999F, f29);
            vertex(vertexconsumer, posestack$pose, f25, 0.0F, f26, j, k, l, 0.0F, f29);
            vertex(vertexconsumer, posestack$pose, f25, f4, f26, j, k, l, 0.0F, f30);
            float f31 = 0.0F;
            if (entity.tickCount % 2 == 0) {
                f31 = 0.5F;
            }

            vertex(vertexconsumer, posestack$pose, f11, f4, f12, j, k, l, 0.5F, f31 + 0.5F);
            vertex(vertexconsumer, posestack$pose, f13, f4, f14, j, k, l, 1.0F, f31 + 0.5F);
            vertex(vertexconsumer, posestack$pose, f17, f4, f18, j, k, l, 1.0F, f31);
            vertex(vertexconsumer, posestack$pose, f15, f4, f16, j, k, l, 0.5F, f31);
            poseStack.popPose();
        }

    }

    private Vec3 getHandPosition2(LivingEntity entity, float partialTick) {
        double x = Mth.lerp(partialTick, entity.xOld, entity.getX());
        double y = Mth.lerp(partialTick, entity.yOld, entity.getY()) + entity.getBbHeight() * 0.5; // 중심 높이
        double z = Mth.lerp(partialTick, entity.zOld, entity.getZ());

        PoseStack poseStack = new PoseStack();
        poseStack.pushPose();

        this.getParentModel().translateHand(poseStack);

        Vector4f handOffset = new Vector4f(0.0F, 0.0F, 0.0F, 1.0F);
        handOffset.mul(poseStack.last().pose());

        poseStack.popPose();

        return new Vec3(x + handOffset.x(), y + handOffset.y(), z + handOffset.z());
    }


    private static void vertex(VertexConsumer consumer, PoseStack.Pose pose, float x, float y, float z, int red, int green, int blue, float u, float v) {
        consumer.addVertex(pose, x, y, z).setColor(red, green, blue, 255).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(15728880).setNormal(pose, 0.0F, 1.0F, 0.0F);
    }


    public Vec3 getHandPosition(Vec3 offsetIn) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        this.getParentModel().translateHand(translationStack);
        Vector4f armOffsetVec = new Vector4f((float) offsetIn.x, (float) offsetIn.y, (float) offsetIn.z, 1.0F);
        armOffsetVec.mul(translationStack.last().pose());
        Vec3 vec3 = new Vec3(armOffsetVec.x(), armOffsetVec.y(), armOffsetVec.z());
        translationStack.popPose();
        return vec3;
    }
}


