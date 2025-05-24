package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.L_Ender.cataclysm.client.render.etc.LightningRender;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Death_Laser_Beam_Entity;
import com.github.L_Ender.cataclysm.util.CMMathUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public class Death_Laser_beam_Renderer extends EntityRenderer<Death_Laser_Beam_Entity> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/harbinger/death_laser_beam.png");
    private static final float TEXTURE_WIDTH = 256;
    private static final float TEXTURE_HEIGHT = 32;
    private static final float START_RADIUS = 0.75f;
    private static final float BEAM_RADIUS = 0.75F;
    private boolean clearerView = false;
    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<>();

    public Death_Laser_beam_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    @Override
    public ResourceLocation getTextureLocation(Death_Laser_Beam_Entity entity) {
        return TEXTURE;
    }

    @Override
    public void render(Death_Laser_Beam_Entity solarBeam, float entityYaw, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        clearerView = solarBeam.caster instanceof Player && Minecraft.getInstance().player == solarBeam.caster && Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON;

        double collidePosX = solarBeam.prevCollidePosX + (solarBeam.collidePosX - solarBeam.prevCollidePosX) * delta;
        double collidePosY = solarBeam.prevCollidePosY + (solarBeam.collidePosY - solarBeam.prevCollidePosY) * delta;
        double collidePosZ = solarBeam.prevCollidePosZ + (solarBeam.collidePosZ - solarBeam.prevCollidePosZ) * delta;
        double posX = solarBeam.xo + (solarBeam.getX() - solarBeam.xo) * delta;
        double posY = solarBeam.yo + (solarBeam.getY() - solarBeam.yo) * delta;
        double posZ = solarBeam.zo + (solarBeam.getZ() - solarBeam.zo) * delta;
        float yaw = solarBeam.prevYaw + (solarBeam.renderYaw - solarBeam.prevYaw) * delta;
        float pitch = solarBeam.prevPitch + (solarBeam.renderPitch - solarBeam.prevPitch) * delta;

        float length = (float) Math.sqrt(Math.pow(collidePosX - posX, 2) + Math.pow(collidePosY - posY, 2) + Math.pow(collidePosZ - posZ, 2));
        int frame = Mth.floor((solarBeam.appear.getTimer() - 1 + delta) * 2);
        if (frame < 0) {
            frame = 6;
        }
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(getTextureLocation(solarBeam)));


        renderBeam(length, 180f / (float) Math.PI * yaw, 180f / (float) Math.PI * pitch, frame, matrixStackIn, ivertexbuilder, packedLightIn);

        matrixStackIn.pushPose();
        matrixStackIn.translate(collidePosX - posX, collidePosY - posY, collidePosZ - posZ);
        renderEnd(frame, solarBeam.blockSide, matrixStackIn, ivertexbuilder, packedLightIn);
        matrixStackIn.popPose();
        renderLighting(delta,matrixStackIn,solarBeam,bufferIn);
    }

    private void renderFlatQuad(int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        float minU = 0 + 16F / TEXTURE_WIDTH * frame;
        float minV = 0;
        float maxU = minU + 16F / TEXTURE_WIDTH;
        float maxV = minV + 16F / TEXTURE_HEIGHT;
        PoseStack.Pose matrixstack$entry = matrixStackIn.last();

        drawVertex(matrixstack$entry, builder, -START_RADIUS, -START_RADIUS, 0, minU, minV, 1, packedLightIn);
        drawVertex(matrixstack$entry, builder, -START_RADIUS, START_RADIUS, 0, minU, maxV, 1, packedLightIn);
        drawVertex(matrixstack$entry, builder, START_RADIUS, START_RADIUS, 0, maxU, maxV, 1, packedLightIn);
        drawVertex(matrixstack$entry, builder, START_RADIUS, -START_RADIUS, 0, maxU, minV, 1, packedLightIn);
    }


    private void renderLighting(float frame, PoseStack poseStack,Death_Laser_Beam_Entity entity, MultiBufferSource buffer) {
        double x = Mth.lerp(frame, entity.xOld, entity.getX());
        double y = Mth.lerp(frame, entity.yOld, entity.getY());
        double z = Mth.lerp(frame, entity.zOld, entity.getZ());


        float f1 = 0.0F;

        if (entity.tickCount > 20) {
            poseStack.pushPose();

            poseStack.translate(-x, -y, -z);
            LightningBoltData.BoltRenderInfo RedboltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.15F, 0.25F, 0.25F, new Vector4f((float) 255 / 255, (float) 26 / 255, (float) 0 / 255, 0.9F), 0.86F);
            LightningBoltData bolt1 = new LightningBoltData(RedboltData, new Vec3(x, y, z), new Vec3(entity.collidePosX, entity.collidePosY, entity.collidePosZ), 5)
                    .size(0.1f)
                    .lifespan(1)
                    .spawn(LightningBoltData.SpawnFunction.NO_DELAY)
                    .fade(LightningBoltData.FadeFunction.NONE);

            LightningBoltData.BoltRenderInfo YellowboltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.25F, 0.15F, new Vector4f((float) 249 / 255, (float) 194 / 255, (float) 43 / 255, 0.7F), 0.86F);
            LightningBoltData bolt2 = new LightningBoltData(YellowboltData, new Vec3(x, y, z), new Vec3(entity.collidePosX, entity.collidePosY, entity.collidePosZ), 5)
                    .size(0.07f)
                    .lifespan(1)
                    .spawn(LightningBoltData.SpawnFunction.NO_DELAY)
                    .fade(LightningBoltData.FadeFunction.NONE);

            LightningRender lightningRender = getLightingRender(entity.getUUID());
            if (!Minecraft.getInstance().isPaused()) {
                lightningRender.update(entity, bolt1, frame);
                lightningRender.update(entity, bolt2, frame);
            }
            lightningRender.render(frame, poseStack, buffer);

            poseStack.popPose();

        }
        if (entity.isRemoved() && lightningRenderMap.containsKey(entity.getUUID())) {
            lightningRenderMap.remove(entity.getUUID());
        }
    }

    private LightningRender getLightingRender(UUID uuid) {
        if (lightningRenderMap.get(uuid) == null) {
            lightningRenderMap.put(uuid, new LightningRender());
        }
        return lightningRenderMap.get(uuid);
    }

    private void renderStart(int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        if (clearerView) {
            return;
        }
        matrixStackIn.pushPose();
        Quaternionf quat = this.entityRenderDispatcher.cameraOrientation();
        matrixStackIn.mulPose(quat);
        renderFlatQuad(frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.popPose();
    }

    private void renderEnd(int frame, Direction side, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        matrixStackIn.pushPose();
        Quaternionf quat = this.entityRenderDispatcher.cameraOrientation();
        matrixStackIn.mulPose(quat);
        renderFlatQuad(frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.popPose();
        if (side == null) {
            return;
        }
        matrixStackIn.pushPose();
        Quaternionf sideQuat = side.getRotation();
        sideQuat.mul(CMMathUtil.quatFromRotationXYZ(90, 0, 0, true));
        matrixStackIn.mulPose(sideQuat);
        matrixStackIn.translate(0, 0, -0.01f);
        renderFlatQuad(frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.popPose();
    }

    private void drawBeam(float length, int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        float minU = 0;
        float minV = 16 / TEXTURE_HEIGHT + 1 / TEXTURE_HEIGHT * frame;
        float maxU = minU + 20 / TEXTURE_WIDTH;
        float maxV = minV + 1 / TEXTURE_HEIGHT;
        PoseStack.Pose matrixstack$entry = matrixStackIn.last();

        float offset = clearerView ? -1 : 0;
        drawVertex(matrixstack$entry, builder, -BEAM_RADIUS, offset, 0, minU, minV, 1, packedLightIn);
        drawVertex(matrixstack$entry, builder, -BEAM_RADIUS, length, 0, minU, maxV, 1, packedLightIn);
        drawVertex(matrixstack$entry, builder, BEAM_RADIUS, length, 0, maxU, maxV, 1, packedLightIn);
        drawVertex(matrixstack$entry, builder, BEAM_RADIUS, offset, 0, maxU, minV, 1, packedLightIn);
    }

    private void renderBeam(float length, float yaw, float pitch, int frame, PoseStack matrixStackIn, VertexConsumer builder, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.mulPose(CMMathUtil.quatFromRotationXYZ(90, 0, 0, true));
        matrixStackIn.mulPose(CMMathUtil.quatFromRotationXYZ(0, 0, yaw - 90f, true));
        matrixStackIn.mulPose(CMMathUtil.quatFromRotationXYZ(-pitch, 0, 0, true));
        matrixStackIn.pushPose();
        if (!clearerView) {
            matrixStackIn.mulPose((new Quaternionf()).rotationY((Minecraft.getInstance().gameRenderer.getMainCamera().getXRot() + 90)));
        }
        drawBeam(length, frame, matrixStackIn, builder, packedLightIn);
        matrixStackIn.popPose();

        if (!clearerView) {
            matrixStackIn.pushPose();
            matrixStackIn.mulPose((new Quaternionf()).rotationY((-Minecraft.getInstance().gameRenderer.getMainCamera().getXRot() - 90) * ((float)Math.PI / 180F)));
            drawBeam(length, frame, matrixStackIn, builder, packedLightIn);
            matrixStackIn.popPose();
        }
        matrixStackIn.popPose();
    }

    public void drawVertex(PoseStack.Pose normals, VertexConsumer vertexBuilder, float offsetX, float offsetY, float offsetZ, float textureX, float textureY, float alpha, int packedLightIn) {
        vertexBuilder
                .addVertex(normals, offsetX, offsetY, offsetZ)
                .setColor(1, 1, 1, 1 * alpha)
                .setUv(textureX, textureY).setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(packedLightIn)
                .setNormal(normals, 0.0F, 1.0F, 0.0F);
    }
}
