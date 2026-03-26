package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Coral_Spear_Model;
import com.github.L_Ender.cataclysm.client.model.item.Brontes_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Brontes_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Brontes_Renderer extends EntityRenderer<Brontes_Entity> {

	private final Brontes_Model model = new Brontes_Model();

	private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/item/brontes.png");

	private static final ResourceLocation TEXTURE_LAYER = new ResourceLocation(Cataclysm.MODID,"textures/item/brontes_layer.png");
	public Brontes_Renderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
	}

	public void render(Brontes_Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot())));
		poseStack.mulPose(Axis.XP.rotationDegrees((entity.tickCount + partialTicks) * 40.0F));



		VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(buffer, this.model.renderType(this.getTextureLocation(entity)), false, false);
		this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY,1.0f,1.0f,1.0f,1.0f);
		VertexConsumer vertexconsumer2 = ItemRenderer.getFoilBuffer(buffer, CMRenderTypes.CMEyes(TEXTURE_LAYER), false, false);
		this.model.renderToBuffer(poseStack, vertexconsumer2, packedLight, OverlayTexture.NO_OVERLAY,1.0f,1.0f,1.0f,1.0f);
		poseStack.popPose();
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
	}


	@Override
	public ResourceLocation getTextureLocation(Brontes_Entity entity) {
		return TEXTURE;
	}


}