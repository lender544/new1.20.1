package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Model_Maledictus;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.layer.Maledictus_Cicle_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Maledictus_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderNameTagEvent;

import javax.annotation.Nullable;
import java.util.HashMap;

@OnlyIn(Dist.CLIENT)
public class RendererMaledictus extends MobRenderer<Maledictus_Entity, Model_Maledictus> {

    private static final ResourceLocation MALEDICTUS_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/maledictus/maledictus_ghost.png");

    public RendererMaledictus(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Model_Maledictus(), 0.75F);
        this.addLayer(new Maledictus_Layer(this));
        this.addLayer(new Maledictus_Cicle_Layer(this, renderManagerIn));
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
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Pre<Maledictus_Entity, Model_Maledictus>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn)))
            return;
        matrixStackIn.pushPose();
        this.model.attackTime = this.getAttackAnim(entityIn, partialTicks);

        boolean shouldSit = entityIn.isPassenger() && (entityIn.getVehicle() != null && entityIn.getVehicle().shouldRiderSit());
        this.model.riding = shouldSit;
        this.model.young = entityIn.isBaby();
        float f = Mth.rotLerp(partialTicks, entityIn.yBodyRotO, entityIn.yBodyRot);
        float f1 = Mth.rotLerp(partialTicks, entityIn.yHeadRotO, entityIn.yHeadRot);
        float f2 = f1 - f;
        if (shouldSit && entityIn.getVehicle() instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity) entityIn.getVehicle();
            f = Mth.rotLerp(partialTicks, livingentity.yBodyRotO, livingentity.yBodyRot);
            f2 = f1 - f;
            float f3 = Mth.wrapDegrees(f2);
            if (f3 < -85.0F) {
                f3 = -85.0F;
            }

            if (f3 >= 85.0F) {
                f3 = 85.0F;
            }

            f = f1 - f3;
            if (f3 * f3 > 2500.0F) {
                f += f3 * 0.2F;
            }

            f2 = f1 - f;
        }

        float f6 = Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot());
        if (entityIn.getPose() == Pose.SLEEPING) {
            Direction direction = entityIn.getBedOrientation();
            if (direction != null) {
                float f4 = entityIn.getEyeHeight(Pose.STANDING) - 0.1F;
                matrixStackIn.translate((float) (-direction.getStepX()) * f4, 0.0D, (float) (-direction.getStepZ()) * f4);
            }
        }

        float f7 = this.getBob(entityIn, partialTicks);
        this.setupRotations(entityIn, matrixStackIn, f7, f, partialTicks);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        this.scale(entityIn, matrixStackIn, partialTicks);
        matrixStackIn.translate(0.0D, -1.501F, 0.0D);
        float f8 = 0.0F;
        float f5 = 0.0F;
        if (!shouldSit && entityIn.isAlive()) {
            f8 = entityIn.walkAnimation.speed(partialTicks);
            f5 = entityIn.walkAnimation.position(partialTicks);
            if (entityIn.isBaby()) {
                f5 *= 3.0F;
            }

            if (f8 > 1.0F) {
                f8 = 1.0F;
            }
        }
        this.model.prepareMobModel(entityIn, f5, f8, partialTicks);
        this.model.setupAnim(entityIn, f5, f8, f7, f2, f6);
        Minecraft minecraft = Minecraft.getInstance();
        boolean flag = this.isBodyVisible(entityIn);
        boolean flag1 = !flag && !entityIn.isInvisibleTo(minecraft.player);
        boolean flag2 = minecraft.shouldEntityAppearGlowing(entityIn);
        RenderType rendertype = this.getRenderType(entityIn, flag, flag1, flag2);
        if (rendertype != null) {
            float hide = (entityIn.getHealth() / entityIn.getMaxHealth()) - 0.4F;
            float alpha = (1F - hide) * 0.6F;
            int i = getOverlayCoords(entityIn, this.getWhiteOverlayProgress(entityIn, partialTicks));
            this.renderMaledictusModel(matrixStackIn, bufferIn, rendertype, partialTicks, packedLightIn, i, flag1 ? 0.15F : Mth.clamp(alpha, 0, 1), entityIn);
        }
        if (!entityIn.isSpectator()) {
            for (RenderLayer layerrenderer : this.layers) {
                layerrenderer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f8, partialTicks, f7, f2, f6);
            }
        }

        matrixStackIn.popPose();
        RenderNameTagEvent renderNameplateEvent = new RenderNameTagEvent(entityIn, entityIn.getDisplayName(), this, matrixStackIn, bufferIn, packedLightIn, partialTicks);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(renderNameplateEvent);
        if (renderNameplateEvent.getResult() != net.minecraftforge.eventbus.api.Event.Result.DENY && (renderNameplateEvent.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW || this.shouldShowName(entityIn))) {
            this.renderNameTag(entityIn, renderNameplateEvent.getContent(), matrixStackIn, bufferIn, packedLightIn);
        }
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.client.event.RenderLivingEvent.Post<Maledictus_Entity, Model_Maledictus>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn));

    }



    private void renderMaledictusModel(PoseStack matrixStackIn, MultiBufferSource source, RenderType defRenderType, float partialTicks, int packedLightIn, int overlayColors, float alphaIn, Maledictus_Entity entityIn) {
        boolean hurt = Math.max(entityIn.hurtTime, entityIn.deathTime) > 0;
        this.model.renderToBuffer(matrixStackIn, source.getBuffer(defRenderType), packedLightIn, LivingEntityRenderer.getOverlayCoords(entityIn, this.getWhiteOverlayProgress(entityIn, partialTicks)), hurt ? 0.4F : 1.0F, hurt ? 0.8F : 1.0F, hurt ? 0.7F : 1.0F, alphaIn);
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

