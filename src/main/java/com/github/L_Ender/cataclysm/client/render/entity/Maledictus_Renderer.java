package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Maledictus_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.layer.MaledictusRiderLayer;
import com.github.L_Ender.cataclysm.client.render.layer.Maledictus_Cicle_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Maledictus_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.NeoForge;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class Maledictus_Renderer extends MobRenderer<Maledictus_Entity, Maledictus_Model> {

    private static final ResourceLocation MALEDICTUS_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/maledictus/maledictus_ghost.png");

    public Maledictus_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Maledictus_Model(renderManagerIn.bakeLayer(CMModelLayers.MALEDICTUS_MODEL)), 0.75F);
        this.addLayer(new Maledictus_Layer(this));
        this.addLayer(new Maledictus_Cicle_Layer(this, renderManagerIn));
        this.addLayer(new MaledictusRiderLayer(this));
    }
    @Override
    public ResourceLocation getTextureLocation(Maledictus_Entity entity) {
        return MALEDICTUS_TEXTURES;
    }

    @Override
    protected float getFlipDegrees(Maledictus_Entity entity) {
        return 0;
    }


    public void render(Maledictus_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        if (net.neoforged.neoforge.common.NeoForge.EVENT_BUS.post(new net.neoforged.neoforge.client.event.RenderLivingEvent.Pre<Maledictus_Entity, Maledictus_Model>(entityIn, this, partialTicks, matrixStackIn,  bufferIn, packedLightIn)).isCanceled()) return;
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
        boolean flag = this.isBodyVisible(entityIn);
        boolean flag1 = !flag && !entityIn.isInvisibleTo(minecraft.player);
        boolean flag2 = minecraft.shouldEntityAppearGlowing(entityIn);
        RenderType rendertype = this.getRenderType(entityIn, flag, flag1, flag2);
        if (rendertype != null) {
            VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(getTextureLocation(entityIn)));
            float hide = (entityIn.getHealth() / entityIn.getMaxHealth()) - 0.4F;
            float alpha = (1F - hide) * 0.6F;
            boolean hurt = Math.max(entityIn.hurtTime, entityIn.deathTime) > 0;
            int i = FastColor.ARGB32.color((int) (alpha * 255),  hurt ? 102 : 255, hurt ? 204 : 255,  hurt ? 178 : 255);

          //  this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, LivingEntityRenderer.getOverlayCoords(entityIn, this.getWhiteOverlayProgress(entityIn, partialTicks)),i);

            int i1 = getOverlayCoords(entityIn, this.getWhiteOverlayProgress(entityIn, partialTicks));
            this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, i1, i);

        }

        if (!entityIn.isSpectator()) {
            for (RenderLayer<Maledictus_Entity, Maledictus_Model> renderlayer : this.layers) {
                renderlayer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f4, partialTicks, f9, f2, f6);
            }
        }

        matrixStackIn.popPose();
        renderetc(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.post(new net.neoforged.neoforge.client.event.RenderLivingEvent.Post<Maledictus_Entity, Maledictus_Model>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn));
    }

    private void renderetc(Maledictus_Entity p_entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        RenderNameTagEvent event = new RenderNameTagEvent(p_entity, p_entity.getDisplayName(), this, poseStack, bufferSource, packedLight, partialTick);
        NeoForge.EVENT_BUS.post(event);
        if (event.canRender().isTrue() || event.canRender().isDefault() && this.shouldShowName(p_entity)) {
            this.renderNameTag(p_entity, event.getContent(), poseStack, bufferSource, packedLight, partialTick);
        }

    }
    

    private void renderMaledictusModel(PoseStack matrixStackIn, MultiBufferSource source, RenderType defRenderType, float partialTicks, int packedLightIn,  float alphaIn, Maledictus_Entity entityIn) {
        boolean hurt = Math.max(entityIn.hurtTime, entityIn.deathTime) > 0;
        int i = FastColor.ARGB32.color(Mth.floor(alphaIn), (int) (hurt ? 0.4F : 1.0F * 255), (int) (hurt ? 0.8F : 1.0F * 255), (int) (hurt ? 0.7F : 1.0F *255));
        this.model.renderToBuffer(matrixStackIn, source.getBuffer(defRenderType), packedLightIn, LivingEntityRenderer.getOverlayCoords(entityIn, this.getWhiteOverlayProgress(entityIn, partialTicks)),i);
    }


    @Nullable
    protected RenderType getRenderType(Maledictus_Entity maledictus, boolean normal, boolean invis, boolean outline) {
        ResourceLocation resourcelocation = this.getTextureLocation(maledictus);
        return outline ? RenderType.outline(resourcelocation) : CMRenderTypes.getGhost(resourcelocation);
    }

    @Override
    protected void scale(Maledictus_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}

