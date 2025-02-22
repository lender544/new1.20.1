package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.entity.projectile.Lionfish_Spike_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Urchin_Spike_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Urchin_Spike_Renderer extends EntityRenderer<Urchin_Spike_Entity> {

    public Urchin_Spike_Renderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public void render(Urchin_Spike_Entity entity, float yaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int light) {
        stack.pushPose();
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(-45));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));
        stack.translate(0f, 0f, 0);
        Minecraft.getInstance().getItemRenderer().renderStatic(entity.getItem(), ItemDisplayContext.GROUND, light, OverlayTexture.NO_OVERLAY, stack, buffer, entity.level(), entity.getId());
        stack.popPose();
        stack.popPose();
    }


    @Override
    public ResourceLocation getTextureLocation(Urchin_Spike_Entity entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
