package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Ceraunus_Model;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Ceraunus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;


public class Ceraunus_Renderer extends EntityRenderer<Scylla_Ceraunus_Entity> {

	private final Ceraunus_Model model;



	private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/scylla/ceraunus.png");


	public Ceraunus_Renderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
		this.model = new Ceraunus_Model(renderManagerIn.bakeLayer(CMModelLayers.CERAUNUS_MODEL));
	}

	@Override
	public void render(Scylla_Ceraunus_Entity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource provider, int light) {
		matrices.pushPose();
		matrices.mulPose(Axis.YP.rotationDegrees(Mth.lerp(tickDelta, entity.yRotO, entity.getYRot()) - 90.0F));
		matrices.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(tickDelta, entity.xRotO, entity.getXRot()) + 90.0F));
		matrices.mulPose(Axis.YP.rotationDegrees(-90.0F));
		VertexConsumer vertexConsumer = provider.getBuffer(this.model.renderType(getTextureLocation(entity)));
		model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY,1,1,1,1);
		matrices.popPose();

	}


	@Override
	public ResourceLocation getTextureLocation(Scylla_Ceraunus_Entity entity) {
		return TEXTURE;
	}
}