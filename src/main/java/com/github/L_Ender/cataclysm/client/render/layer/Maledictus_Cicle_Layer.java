package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Maledictus_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Maledictus_Renderer;
import com.github.L_Ender.cataclysm.client.render.etc.LightningBoltData;
import com.github.L_Ender.cataclysm.client.render.etc.LightningRender;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;

@OnlyIn(Dist.CLIENT)
public class Maledictus_Cicle_Layer extends RenderLayer<Maledictus_Entity, Maledictus_Model> {
    protected final EntityRenderDispatcher entityRenderDispatcher;

    private Map<UUID, LightningRender> lightningRenderMap = new HashMap<>();
    private final RandomSource rnd = RandomSource.create();
    public Maledictus_Cicle_Layer(Maledictus_Renderer renderIn, EntityRendererProvider.Context context) {
        super(renderIn);
        entityRenderDispatcher = context.getEntityRenderDispatcher();
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        rendercicle(matrixStackIn,bufferIn,packedLightIn,entity ,true);
        rendercicle(matrixStackIn,bufferIn,packedLightIn,entity ,false);
        renderLightning(matrixStackIn,bufferIn,entity,partialTicks ,true);
        renderLightning(matrixStackIn,bufferIn,entity,partialTicks ,false);
    }


    private void rendercicle(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Maledictus_Entity entity, boolean right){
        Quaternionf camera = this.entityRenderDispatcher.cameraOrientation();
        matrixStackIn.pushPose();
        matrixStackIn.pushPose();

        Vec3 offset = new Vec3(0, 0.0F, 0F);
        Vec3 ridePos = getRiderPosition(offset,right);
        matrixStackIn.translate(ridePos.x, ridePos.y, ridePos.z);
        matrixStackIn.mulPose(camera);
        matrixStackIn.translate(0.0F, -0.1F, 0.0F);
        matrixStackIn.scale(0.9F, 0.9F, 0.9F);
        PoseStack.Pose posestack$pose = matrixStackIn.last();
        Matrix4f matrix4f = posestack$pose.pose();
        Matrix3f matrix3f = posestack$pose.normal();
        VertexConsumer portalStatic = bufferIn.getBuffer(RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/particle/ring_1.png"),true));
        matrixStackIn.translate(0.0F, 0.1F, 0.0F);
        if (entity.attackTicks > 1 ) {
            if (entity.getAttackState() == 1) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 2) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.09f, 0.42f, 0.35F);
                }
            }
            if (entity.getAttackState() == 3) {
                if (entity.attackTicks >= 15 && entity.attackTicks <= 65) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.09f, 0.42f, 0.35F);
                }
            }
            if (entity.getAttackState() == 7) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 8) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 12 || entity.getAttackState() == 13 || entity.getAttackState() == 14 || entity.getAttackState() == 11) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 15 || entity.getAttackState() == 16) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 18) {
                if (entity.attackTicks <= 21) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.09f, 0.42f, 0.35F);
                }
                if (entity.attackTicks >= 25 && entity.attackTicks <= 34) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 19) {
                if (entity.attackTicks <= 10) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.09f, 0.42f, 0.35F);
                }
                if (entity.attackTicks >= 13 && entity.attackTicks <= 20) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 21) {
                if (entity.attackTicks <= 10) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
                if (entity.attackTicks >= 13 && entity.attackTicks <= 20) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 22 || entity.getAttackState() == 23) {
                if (entity.attackTicks <= 21) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 24) {
                if (entity.attackTicks <= 50) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 27) {
                if (entity.attackTicks <= 44) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.95f, 0.5215f, 0.1333F);
                }
            }
            if (entity.getAttackState() == 28) {
                if (entity.attackTicks <= 26) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }
            if (entity.getAttackState() == 29) {
                if (entity.attackTicks <= 26) {
                    drawCircle(portalStatic, posestack$pose, packedLightIn, 0.423f, 0.062f, 0.019F);
                }
            }

        }

        matrixStackIn.popPose();
        matrixStackIn.popPose();
    }


    private void renderLightning(PoseStack matrixStackIn, MultiBufferSource bufferIn, Maledictus_Entity entity,float partialtick, boolean right){
        matrixStackIn.pushPose();
        Vec3 offset = new Vec3(0, 0.0F, 0F);
        Vec3 ridePos = getRiderPosition(offset,right);
        matrixStackIn.translate(ridePos.x, ridePos.y, ridePos.z);
        if (entity.attackTicks > 1 ) {
            if (entity.getAttackState() == 1) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
            }
            if (entity.getAttackState() == 2) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.09f, 0.42f, 0.35F, partialtick);
                }
            }
            if (entity.getAttackState() == 3) {
                if (entity.attackTicks >= 15 && entity.attackTicks <= 65) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.09f, 0.42f, 0.35F, partialtick);
                }
            }
            if (entity.getAttackState() == 7) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 8) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 12 || entity.getAttackState() == 13 || entity.getAttackState() == 14 || entity.getAttackState() == 11) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 15 || entity.getAttackState() == 16) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 18) {

                if (entity.attackTicks <= 21) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.09f, 0.42f, 0.35F, partialtick);
                }
                if (entity.attackTicks >= 25 && entity.attackTicks <= 34) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }

            }
            if (entity.getAttackState() == 19) {
                if (entity.attackTicks <= 10) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
                if (entity.attackTicks >= 13 && entity.attackTicks <= 20) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
            }

            if (entity.getAttackState() == 21) {
                if (entity.attackTicks <= 10) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
                if (entity.attackTicks >= 13 && entity.attackTicks <= 20) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }

            if (entity.getAttackState() == 22 || entity.getAttackState() == 23) {
                if (entity.attackTicks <= 21) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
            }
            if (entity.getAttackState() == 24) {
                if (entity.attackTicks <= 50) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 27) {
                if (entity.attackTicks <= 44) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.95f, 0.5215f, 0.1333F, partialtick);
                }
            }
            if (entity.getAttackState() == 28) {
                if (entity.attackTicks <= 26) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
            if (entity.getAttackState() == 29) {
                if (entity.attackTicks <= 26) {
                    drawLightning(matrixStackIn, bufferIn, entity, 0.423f, 0.062f, 0.019F, partialtick);
                }
            }
        }

        matrixStackIn.popPose();
    }


    private void drawLightning(PoseStack matrixStackIn, MultiBufferSource bufferIn, Maledictus_Entity entity, float r, float g, float b, float partialTicks){

        matrixStackIn.pushPose();


        double x = (rnd.nextFloat() - 0.25F);
        double y = (rnd.nextFloat() - 0.25F);
        double z = (rnd.nextFloat() - 0.25F);

        LightningBoltData.BoltRenderInfo blueBoltData = new LightningBoltData.BoltRenderInfo(0.5F, 0.1F, 0.5F, 0.85F, new Vector4f(r, g, b, 0.8F), 0.1F);

        LightningBoltData bolt1 = new LightningBoltData(blueBoltData, Vec3.ZERO, new Vec3(x, y, z), 8)
                .size(0.1F)
                .lifespan(1)
                .spawn(LightningBoltData.SpawnFunction.CONSECUTIVE);
        LightningRender lightningRender = getLightingRender(entity.getUUID());
        lightningRender.update(entity, bolt1, partialTicks);

        lightningRender.render(partialTicks, matrixStackIn, bufferIn);
        matrixStackIn.popPose();

        if (!entity.isAlive() && lightningRenderMap.containsKey(entity.getUUID())) {
            lightningRenderMap.remove(entity.getUUID());
        }

    }


    private LightningRender getLightingRender(UUID uuid) {
        if (lightningRenderMap.get(uuid) == null) {
            lightningRenderMap.put(uuid, new LightningRender());
        }
        return lightningRenderMap.get(uuid);
    }



    private void drawCircle(VertexConsumer vertex,PoseStack.Pose normals, int packedLightIn, float r,float g,float b) {

        cirlceVertex(vertex, normals, packedLightIn, 0.0F, 0, 0, 1, 1.0F,r,g,b);
        cirlceVertex(vertex, normals, packedLightIn, 1.0F, 0, 1, 1, 1.0F,r,g,b);
        cirlceVertex(vertex, normals, packedLightIn, 1.0F, 1, 1, 0, 1.0F,r,g,b);
        cirlceVertex(vertex, normals, packedLightIn, 0.0F, 1, 0, 0, 1.0F,r,g,b);
    }

    private static void cirlceVertex(VertexConsumer vertex, PoseStack.Pose normals, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_, float alpha, float r,float g,float b) {
        vertex.addVertex(normals, p_114094_ - 0.5F, (float)p_114095_ - 0.25F, 0.0F)
                .setColor(r, g, b,  alpha)
                .setUv((float)p_114096_, (float)p_114097_)
                .setOverlay(NO_OVERLAY)
                .setLight(240)
                .setNormal(normals, 0.0F, -1.0F, 0.0F);
    }




    public Vec3 getRiderPosition(Vec3 offsetIn,boolean right) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        this.getParentModel().translateToHand(translationStack,right);
        Vector4f armOffsetVec = new Vector4f((float) offsetIn.x, (float) offsetIn.y, (float) offsetIn.z, 1.0F);
        armOffsetVec.mul(translationStack.last().pose());
        Vec3 vec3 = new Vec3(armOffsetVec.x(), armOffsetVec.y(), armOffsetVec.z());
        translationStack.popPose();
        return vec3;
    }

}


