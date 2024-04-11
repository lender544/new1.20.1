package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.entity.projectile.Blazing_Bone_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererBlazing_Bone extends EntityRenderer<Blazing_Bone_Entity> {

    public RendererBlazing_Bone(EntityRendererProvider.Context manager) {
        super(manager);
    }

    @Override
    public void render(Blazing_Bone_Entity entity, float yaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int light) {
        stack.pushPose();
        float spin = (entity.tickCount + partialTicks) * 30F;
        // size up
        stack.scale(1.25F, 1.25F, 1.25F);

        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(yaw + 90));
        stack.mulPose(Axis.ZP.rotationDegrees(spin));
        stack.translate(0f, 0f, 0);

        Minecraft.getInstance().getItemRenderer().renderStatic(entity.getItem(), ItemDisplayContext.GROUND, light, OverlayTexture.NO_OVERLAY, stack, buffer, entity.level(), entity.getId());
        stack.popPose();
        stack.popPose();
    }


    @Override
    public ResourceLocation getTextureLocation(Blazing_Bone_Entity entity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}
