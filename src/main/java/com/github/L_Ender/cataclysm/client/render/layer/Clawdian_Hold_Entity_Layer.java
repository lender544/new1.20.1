package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Clawdian_Model;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Clawdian_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Clawdian_Hold_Entity_Layer extends RenderLayer<Clawdian_Entity, Clawdian_Model> {
    private final EntityRenderDispatcher entityRenderer;

    public Clawdian_Hold_Entity_Layer(RenderLayerParent<Clawdian_Entity, Clawdian_Model> renderer, EntityRenderDispatcher entityRenderer) {
        super(renderer);
        this.entityRenderer = entityRenderer;
    }


    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Clawdian_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.isVehicle()) {
            for (Entity passenger : entity.getPassengers()) {
                if (passenger == Minecraft.getInstance().player && Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
                    continue;
                }
                renderEntityInClaw(partialTicks, matrixStackIn, bufferIn, packedLightIn, passenger, this.entityRenderer);

            }

        }

        /*
        Entity holdentity = entity.HoldEntity();
        if (entity.getCatch() && holdentity != null) {
            renderEntityInClaw(partialTicks, matrixStackIn, bufferIn, packedLightIn, holdentity, this.entityRenderer);
        }

         */

    }

    public void renderEntityInClaw(float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, Entity entity, EntityRenderDispatcher entityRenderer) {
        Cataclysm.PROXY.releaseRenderingEntity(entity.getUUID());
        poseStack.pushPose();
        this.getParentModel().translateToHand(poseStack);
        poseStack.translate(0.0F, -0.25F , 0F);

        poseStack.scale(1, 1, 1);
        entityRenderer.render(entity, (double)0.0F, (double)0.0F, (double)0.0F, 0.0F, partialTick, poseStack, buffer, packedLight);
        poseStack.popPose();
        Cataclysm.PROXY.blockRenderingEntity(entity.getUUID());
    }


}


