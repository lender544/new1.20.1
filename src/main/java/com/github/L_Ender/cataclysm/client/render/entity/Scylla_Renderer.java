package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.*;
import com.github.L_Ender.cataclysm.client.model.entity.Scylla_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.layer.*;

import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Part;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;

import com.github.L_Ender.cataclysm.entity.projectile.Storm_Bringer_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector4f;

@OnlyIn(Dist.CLIENT)
public class Scylla_Renderer extends MobRenderer<Scylla_Entity, Scylla_Model> {

    private static final ResourceLocation SCYLLA_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/scylla/scylla_no_snake.png");

    private static final ResourceLocation SCYLLA_EYE_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/scylla/scylla_eye.png");

    private static final ResourceLocation CHAIN_TEXTURE  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/scylla/scylla_chain.png");
    private static final ResourceLocation GUARDIAN_BEAM_LOCATION = ResourceLocation.withDefaultNamespace("textures/block/chain.png");

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
        if (net.neoforged.neoforge.common.NeoForge.EVENT_BUS.post(new net.neoforged.neoforge.client.event.RenderLivingEvent.Pre<Scylla_Entity, Scylla_Model>(entityIn, this, partialTicks, matrixStackIn,  bufferIn, packedLightIn)).isCanceled()) return;
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

        float f8 = entityIn.getScale();
        matrixStackIn.scale(f8, f8, f8);
        float f9 = this.getBob(entityIn, partialTicks);
        this.setupRotations(entityIn, matrixStackIn, f9, f, partialTicks, f8);
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
                alpha =255;
            }else{
                if(entityIn.attackTicks <100){
                    alpha =  255;
                }else{
                    alpha = Math.max(35, 255 - (entityIn.deathTime - 100) * 255 / (entityIn.deathtimer() - 100));
                }
            }
            int i1 = FastColor.ARGB32.color(alpha,255, 255, 255);
            this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, i, flag1 ? i1 : -1);
        }

        if (!entityIn.isSpectator()) {
            for (RenderLayer<Scylla_Entity, Scylla_Model> renderlayer : this.layers) {
                renderlayer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f4, partialTicks, f9, f2, f6);
            }
        }

        matrixStackIn.popPose();
        renderetc(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.post(new net.neoforged.neoforge.client.event.RenderLivingEvent.Post<Scylla_Entity, Scylla_Model>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn));

       // renderStromBringer(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

        renderChain(entityIn, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private void renderetc(Scylla_Entity p_entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        RenderNameTagEvent event = new RenderNameTagEvent(p_entity, p_entity.getDisplayName(), this, poseStack, bufferSource, packedLight, partialTick);
        NeoForge.EVENT_BUS.post(event);
        if (event.canRender().isTrue() || event.canRender().isDefault() && this.shouldShowName(p_entity)) {
            this.renderNameTag(p_entity, event.getContent(), poseStack, bufferSource, packedLight, partialTick);
        }

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
        //x links
        buffer.addVertex(posestack$pose, chainOffset, 0, 0).setColor(255, 255, 255, 255).setUv((float) 0, (float) chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
        buffer.addVertex(posestack$pose, chainWidth + chainOffset, 0, 0).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
        buffer.addVertex(posestack$pose, chainWidth + chainOffset, chainLength, 0).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) 0).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
        buffer.addVertex(posestack$pose, chainOffset, chainLength, 0).setColor(255, 255, 255, 255).setUv((float) 0, (float) 0).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
        float pixelSkip = 8F / 32F;
        //z links
        buffer.addVertex(posestack$pose, 0, pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
        buffer.addVertex(posestack$pose, 0, pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth * 2, (float) chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
        buffer.addVertex(posestack$pose, 0, chainLength + pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth * 2, (float) pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
        buffer.addVertex(posestack$pose, 0, chainLength + pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
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

