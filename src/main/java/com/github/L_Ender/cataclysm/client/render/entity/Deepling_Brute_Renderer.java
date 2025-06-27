package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Deepling_Brute_Model;
import com.github.L_Ender.cataclysm.client.render.layer.AbstractDeepling_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.LayerDeeplingBruteItem;
import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Brute_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Deepling_Brute_Renderer extends MobRenderer<Deepling_Brute_Entity, Deepling_Brute_Model> {

    private static final ResourceLocation SSAPBUG_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/deepling_brute.png");
    private static final ResourceLocation DEEPLING_LAYER_TEXTURES  = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/deepling_brute_layer.png");
    public Deepling_Brute_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Deepling_Brute_Model(), 0.7F);
        this.addLayer(new AbstractDeepling_Layer(this,DEEPLING_LAYER_TEXTURES));
        this.addLayer(new LayerDeeplingBruteItem(this, renderManagerIn.getItemInHandRenderer()));

    }
    @Override
    public ResourceLocation getTextureLocation(Deepling_Brute_Entity entity) {
        return SSAPBUG_TEXTURES;
    }

    @Override
    protected void scale(Deepling_Brute_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.125F, 1.125F, 1.125F);
    }
    @Override
    protected void setupRotations(Deepling_Brute_Entity p_115317_, PoseStack p_115318_, float p_115319_, float p_115320_, float p_115321_) {
        if (this.isShaking(p_115317_)) {
            p_115320_ += (float)(Math.cos((double)p_115317_.tickCount * 3.25D) * Math.PI * (double)0.4F);
        }

        if (!p_115317_.hasPose(Pose.SLEEPING)) {
            p_115318_.mulPose(Axis.YP.rotationDegrees(180.0F - p_115320_));
        }

        if (p_115317_.deathTime > 0) {
            float f = ((float)p_115317_.deathTime + p_115321_ - 1.0F) / 20.0F * 1.6F;
            f = Mth.sqrt(f);
            if (f > 1.0F) {
                f = 1.0F;
            }

            p_115318_.mulPose(Axis.ZP.rotationDegrees(f * this.getFlipDegrees(p_115317_)));
        } else if (p_115317_.isAutoSpinAttack()|| p_115317_.getSpinAttack()) {
            p_115318_.mulPose(Axis.XP.rotationDegrees(-90.0F - p_115317_.getXRot()));
            p_115318_.mulPose(Axis.YP.rotationDegrees(((float)p_115317_.tickCount + p_115321_) * -75.0F));
        } else if (p_115317_.hasPose(Pose.SLEEPING)) {
            Direction direction = p_115317_.getBedOrientation();
            float f1 = direction != null ? sleepDirectionToRotation(direction) : p_115320_;
            p_115318_.mulPose(Axis.YP.rotationDegrees(f1));
            p_115318_.mulPose(Axis.ZP.rotationDegrees(this.getFlipDegrees(p_115317_)));
            p_115318_.mulPose(Axis.YP.rotationDegrees(270.0F));
        } else if (isEntityUpsideDown(p_115317_)) {
            p_115318_.translate(0.0F, p_115317_.getBbHeight() + 0.1F, 0.0F);
            p_115318_.mulPose(Axis.ZP.rotationDegrees(180.0F));
        }

    }

    private static float sleepDirectionToRotation(Direction p_115329_) {
        switch (p_115329_) {
            case SOUTH:
                return 90.0F;
            case WEST:
                return 0.0F;
            case NORTH:
                return 270.0F;
            case EAST:
                return 180.0F;
            default:
                return 0.0F;
        }
    }
}