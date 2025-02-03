package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Abyss_Blast_Portal_Model;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Portal_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class Abyss_Blast_Portal_Renderer extends EntityRenderer<Abyss_Blast_Portal_Entity> {

	private static final ResourceLocation PORTAL = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/leviathan/portal/abyss_blast_portal.png");
	public Abyss_Blast_Portal_Model model;

	public Abyss_Blast_Portal_Renderer(EntityRendererProvider.Context manager)
	{
		super(manager);
		this.model = new Abyss_Blast_Portal_Model();
	}

	@Override
	protected int getBlockLightLevel(Abyss_Blast_Portal_Entity entity, BlockPos pos)
	{
		return 15;
	}

	@Override
	public void render(Abyss_Blast_Portal_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		float activateProgress = entityIn.prevactivateProgress + (entityIn.activateProgress - entityIn.prevactivateProgress) * partialTicks;

		float d = activateProgress * 0.15F;

		matrixStackIn.scale(-d, -d, d);
		matrixStackIn.translate(0f, -1.5F, 0F);
		matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F - entityIn.getYRot()));
		VertexConsumer vertexconsumer = bufferIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn)));
		this.model.setupAnim(entityIn, 0.0F, 0.0F, entityIn.tickCount + partialTicks, 0, 0);
		this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(Abyss_Blast_Portal_Entity entity)
	{
		return PORTAL;
	}
}
