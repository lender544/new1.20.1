package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Maledictus_Model;
import com.github.L_Ender.cataclysm.client.model.entity.Scylla_Model;
import com.github.L_Ender.cataclysm.client.render.layer.LayerGenericGlowing;
import com.github.L_Ender.cataclysm.client.render.layer.Scylla_Eye_Spark_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Scylla_Snake_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderNameTagEvent;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector4f;

@OnlyIn(Dist.CLIENT)
public class Scylla_Renderer extends MobRenderer<Scylla_Entity, Scylla_Model> {

    private static final ResourceLocation SCYLLA_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/scylla/scylla_no_snake.png");

    private static final ResourceLocation SCYLLA_EYE_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/scylla/scylla_eye.png");

    private static final ResourceLocation CHAIN_TEXTURE  = new ResourceLocation(Cataclysm.MODID,"textures/entity/scylla/scylla_chain.png");

    public Scylla_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Scylla_Model(renderManagerIn.bakeLayer(CMModelLayers.SCYLLA_MODEL)), 0.75F);
        this.addLayer(new Scylla_Snake_Layer(this));
        this.addLayer(new Scylla_Eye_Spark_Layer(this, renderManagerIn));;
        this.addLayer(new LayerGenericGlowing(this, SCYLLA_EYE_TEXTURES));
        //this.addLayer(new Scylla_Anchor_Layer(this, renderManagerIn));;
    }
    @Override
    public ResourceLocation getTextureLocation(Scylla_Entity entity) {
        return SCYLLA_TEXTURES;
    }


    public void render(Scylla_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Pre<Scylla_Entity, Scylla_Model>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn)))
            return;

        matrixStackIn.pushPose();
        this.model.attackTime = this.getAttackAnim(entityIn, partialTicks);
        boolean shouldSit = entityIn.isPassenger() && (entityIn.getVehicle() != null && entityIn.getVehicle().shouldRiderSit());
        this.model.riding = shouldSit;
        this.model.young = entityIn.isBaby();
        float f = Mth.rotLerp(partialTicks, entityIn.yBodyRotO, entityIn.yBodyRot);
        float f1 = Mth.rotLerp(partialTicks, entityIn.yHeadRotO, entityIn.yHeadRot);
        float f2 = f1 - f;
        if (shouldSit && entityIn.getVehicle() instanceof LivingEntity livingentity) {
            f = Mth.rotLerp(partialTicks, livingentity.yBodyRotO, livingentity.yBodyRot);
            f2 = f1 - f;
            float f7 = Mth.wrapDegrees(f2);
            if (f7 < -85.0F) {
                f7 = -85.0F;
            }

            if (f7 >= 85.0F) {
                f7 = 85.0F;
            }

            f = f1 - f7;
            if (f7 * f7 > 2500.0F) {
                f += f7 * 0.2F;
            }

            f2 = f1 - f;
        }

        float f6 = Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot());
        if (isEntityUpsideDown(entityIn)) {
            f6 *= -1.0F;
            f2 *= -1.0F;
        }

        f2 = Mth.wrapDegrees(f2);
        if (entityIn.hasPose(Pose.SLEEPING)) {
            Direction direction = entityIn.getBedOrientation();
            if (direction != null) {
                float f3 = entityIn.getEyeHeight(Pose.STANDING) - 0.1F;
                matrixStackIn.translate((float)(-direction.getStepX()) * f3, 0.0F, (float)(-direction.getStepZ()) * f3);
            }
        }

        float f9 = this.getBob(entityIn, partialTicks);
        this.setupRotations(entityIn, matrixStackIn, f9, f, partialTicks);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        this.scale(entityIn, matrixStackIn, partialTicks);
        matrixStackIn.translate(0.0F, -1.501F, 0.0F);
        float f4 = 0.0F;
        float f5 = 0.0F;
        if (!shouldSit && entityIn.isAlive()) {
            f4 = entityIn.walkAnimation.speed(partialTicks);
            f5 = entityIn.walkAnimation.position(partialTicks);
            if (entityIn.isBaby()) {
                f5 *= 3.0F;
            }

            if (f4 > 1.0F) {
                f4 = 1.0F;
            }
        }

        this.model.prepareMobModel(entityIn, f5, f4, partialTicks);
        this.model.setupAnim(entityIn, f5, f4, f9, f2, f6);
        Minecraft minecraft = Minecraft.getInstance();
        boolean flag ;
        if(entityIn.isDeadOrDying()){
            flag = false;
        }else{
            flag = this.isBodyVisible(entityIn) ;
        }

        boolean flag1 = !flag && !entityIn.isInvisibleTo(minecraft.player);
        boolean flag2 = minecraft.shouldEntityAppearGlowing(entityIn);
        RenderType rendertype = this.getRenderType(entityIn, flag, flag1, flag2);
        if (rendertype != null) {
            VertexConsumer vertexconsumer = bufferIn.getBuffer(rendertype);
            int i = entityIn.isDeadOrDying() ? OverlayTexture.NO_OVERLAY : getOverlayCoords(entityIn, this.getWhiteOverlayProgress(entityIn, partialTicks));
            int alpha;
            if(entityIn.getAttackState() != 12){
                alpha = 1;
            }else{
                if(entityIn.attackTicks <100){
                    alpha = 255;
                }else{
                    alpha = Math.max(35, 255 - (entityIn.deathTime - 100) * 255 / (entityIn.deathtimer() - 100));
                }
            }
            float i1 = alpha/255F;
            this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, i, 1.0F, 1.0F, 1.0F, flag1 ? i1 : 1.0F);
        }

        if (!entityIn.isSpectator()) {
            for (RenderLayer<Scylla_Entity, Scylla_Model> renderlayer : this.layers) {
                renderlayer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f4, partialTicks, f9, f2, f6);
            }
        }

        matrixStackIn.popPose();
        RenderNameTagEvent renderNameplateEvent = new RenderNameTagEvent(entityIn, entityIn.getDisplayName(), this, matrixStackIn, bufferIn, packedLightIn, partialTicks);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(renderNameplateEvent);
        if (renderNameplateEvent.getResult() != net.minecraftforge.eventbus.api.Event.Result.DENY && (renderNameplateEvent.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW || this.shouldShowName(entityIn))) {
            this.renderNameTag(entityIn, renderNameplateEvent.getContent(), matrixStackIn, bufferIn, packedLightIn);
        }
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Post<Scylla_Entity, Scylla_Model>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn));

       // renderStromBringer(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

        renderChain(entityIn, partialTicks, matrixStackIn, bufferIn, packedLightIn);

        this.shadowRadius = entityIn.getAct() ? 0.75F : 0F ;
    }


    public void renderChain(Scylla_Entity entity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int packedLight) {
        float bodyYaw = Mth.rotLerp(partialTicks, entity.yBodyRotO, entity.yBodyRot);
        Vec3 beamEndVec = entity.getClientAnchorEndPosition(partialTicks);
        Entity target = entity.getAnchor();
        if (target != null && entity.isAlive() && beamEndVec != null && entity.isAnchorTicks() > 3) {
            Vec3 modelOffset = getHandPosition(new Vec3(0, 0.0F, 0F)).yRot((float) (Math.PI - bodyYaw * ((float) Math.PI / 180F)));

            Vec3 rawBeamPosition = beamEndVec.subtract(entity.getPosition(partialTicks).add(modelOffset));


            poseStack.pushPose();
            poseStack.translate(modelOffset.x, modelOffset.y, modelOffset.z);
            VertexConsumer chainBuffer = source.getBuffer(RenderType.entityCutoutNoCull(CHAIN_TEXTURE));
            renderChainCube(rawBeamPosition,poseStack,chainBuffer,packedLight, OverlayTexture.NO_OVERLAY);

            poseStack.popPose();
        }
    }

    public Vec3 getHandPosition(Vec3 offsetIn) {
        PoseStack translationStack = new PoseStack();
        translationStack.pushPose();
        model.translateHand(translationStack);
        Vector4f armOffsetVec = new Vector4f((float) offsetIn.x, (float) offsetIn.y, (float) offsetIn.z, 1.0F);
        armOffsetVec.mul(translationStack.last().pose());
        Vec3 vec3 = new Vec3(-armOffsetVec.x(), -armOffsetVec.y(), armOffsetVec.z());
        translationStack.popPose();
        return vec3.add(0, 1.5, 0);
    }

    public static void renderChainCube(Vec3 to, PoseStack poseStack, VertexConsumer buffer, int packedLightIn, int setOverlay) {
        double d = to.horizontalDistance();
        float rotY = (float) (Mth.atan2(to.x, to.z) * (double) (180F / (float) Math.PI));
        float rotX = (float) (-(Mth.atan2(to.y, d) * (double) (180F / (float) Math.PI))) - 90.0F;
        float chainWidth = 6F / 32F;
        float chainOffset = chainWidth * -0.5F;
        float chainLength = (float) to.length()/2.3F;
        poseStack.pushPose();
        poseStack.scale(2.3F, 2.3F, 2.3F);
        poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
        poseStack.mulPose(Axis.XP.rotationDegrees(rotX));
        poseStack.translate(0, -chainLength, 0);
        PoseStack.Pose posestack$pose = poseStack.last();

        Matrix4f matrix4f = posestack$pose.pose();
        Matrix3f matrix3f = posestack$pose.normal();
        //x links
        buffer.vertex(matrix4f, chainOffset, 0, 0).color(255, 255, 255, 255).uv((float) 0, (float) chainLength).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        buffer.vertex(matrix4f, chainWidth + chainOffset, 0, 0).color(255, 255, 255, 255).uv((float) chainWidth, (float) chainLength).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        buffer.vertex(matrix4f, chainWidth + chainOffset, chainLength, 0).color(255, 255, 255, 255).uv((float) chainWidth, (float) 0).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        buffer.vertex(matrix4f, chainOffset, chainLength, 0).color(255, 255, 255, 255).uv((float) 0, (float) 0).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        float pixelSkip = 8F / 32F;
        //z links
        buffer.vertex(matrix4f, 0, pixelSkip, chainOffset).color(255, 255, 255, 255).uv((float) chainWidth, (float) chainLength + pixelSkip).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        buffer.vertex(matrix4f, 0, pixelSkip, chainWidth + chainOffset).color(255, 255, 255, 255).uv((float) chainWidth * 2, (float) chainLength + pixelSkip).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        buffer.vertex(matrix4f, 0, chainLength + pixelSkip, chainWidth + chainOffset).color(255, 255, 255, 255).uv((float) chainWidth * 2, (float) pixelSkip).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        buffer.vertex(matrix4f, 0, chainLength + pixelSkip, chainOffset).color(255, 255, 255, 255).uv((float) chainWidth, (float) pixelSkip).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        poseStack.popPose();
    }


    public boolean shouldRender(Scylla_Entity livingentity, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender(livingentity, camera, camX, camY, camZ)) {
            return true;
        } else {
            Entity weapon = livingentity.getAnchor();
            if (weapon != null) {
                Vec3 vec3 = livingentity.position();
                Vec3 vec31 = weapon.position();
                return camera.isVisible(new AABB(vec31.x, vec31.y, vec31.z, vec3.x, vec3.y, vec3.z));
            }
            return false;
        }
    }


    @Override
    protected float getFlipDegrees(Scylla_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Scylla_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.15F, 1.15F, 1.15F);
    }
}

