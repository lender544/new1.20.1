package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Ignis_Fireball_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Flare_Bomb_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Ignis_Fireball_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class Ignis_Fireball_Renderer extends EntityRenderer<Ignis_Fireball_Entity>
{
	private static final ResourceLocation IGNIS_FIRE_BALL = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/ignis_fireball.png");
	private static final ResourceLocation IGNIS_FIRE_BALL_SOUL = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/ignis_fireball_soul.png");
	private static final ResourceLocation TRAIL_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/particle/storm.png");
	public Ignis_Fireball_Model model;
	private final RandomSource random = RandomSource.create();
	public Ignis_Fireball_Renderer(EntityRendererProvider.Context manager)
	{
		super(manager);
		this.model = new Ignis_Fireball_Model();
	}
	
	@Override
	protected int getBlockLightLevel(Ignis_Fireball_Entity entity, BlockPos pos)
	{
		return 15;
	}

	@Override
	public void render(Ignis_Fireball_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn)
	{
		matrixStackIn.pushPose();
		float f = rotLerp(entityIn.yRotO, entityIn.getYRot(), partialTicks);
		float f1 = Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot());
		float f2 = (float) entityIn.tickCount + partialTicks;
		matrixStackIn.translate(0.0D, (double) 0.3F, 0.0D);
		matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.sin(f2 * 0.1F) * 180.0F));
		matrixStackIn.mulPose(Axis.XP.rotationDegrees(Mth.cos(f2 * 0.1F) * 180.0F));
		matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.sin(f2 * 0.15F) * 360.0F));
		this.model.setupAnim(entityIn, 0.0F, 0.0F, 0.0F, f, f1);
		VertexConsumer VertexConsumer = bufferIn.getBuffer(this.model.renderType(getTextureLocation(entityIn)));
		this.model.renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY);;
		matrixStackIn.popPose();
		if (entityIn.hasTrail()) {
			double x = Mth.lerp(partialTicks, entityIn.xOld, entityIn.getX());
			double y = Mth.lerp(partialTicks, entityIn.yOld, entityIn.getY());
			double z = Mth.lerp(partialTicks, entityIn.zOld, entityIn.getZ());
			float ran = 0.04f;
			float r = (!entityIn.isSoul() ? 205/255F : 83/255F) + random.nextFloat() * ran;
			float g = (!entityIn.isSoul() ? 126/255F : 239/255F)+ random.nextFloat() * ran;
			float b = (!entityIn.isSoul() ? 0 : 244/255F )+ random.nextFloat() * ran;
			matrixStackIn.pushPose();
			matrixStackIn.translate(-x, -y, -z);
			renderTrail(entityIn, partialTicks, matrixStackIn, bufferIn, r, g, b, 1.0F, packedLightIn);
			matrixStackIn.popPose();
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(Ignis_Fireball_Entity entity)
	{
		return entity.isSoul() ? IGNIS_FIRE_BALL_SOUL : IGNIS_FIRE_BALL;
	}

	private void renderTrail(Ignis_Fireball_Entity entityIn, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, float trailR, float trailG, float trailB, float trailA, int packedLightIn) {
		int sampleSize = 10;
		float trailWidth = 0.2F;

		PoseStack.Pose lastPose = poseStack.last();
		Matrix4f matrix = lastPose.pose();
		VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getLightTrailEffect(TRAIL_TEXTURE));


		Vec3 drawFrom = entityIn.getTrailPosition(0, partialTicks);

		Vec3 cameraPos = this.entityRenderDispatcher.camera.getPosition();

		for (int i = 0; i < sampleSize; i++) {
			Vec3 sample = entityIn.getTrailPosition(i + 1, partialTicks);
			float u1 = i / (float) sampleSize;
			float u2 = u1 + (1.0F / sampleSize);

			Vec3 forward = sample.subtract(drawFrom);
			if (forward.lengthSqr() == 0) continue;

			Vec3 toCamera = cameraPos.subtract(drawFrom);

			Vec3 side = forward.cross(toCamera).normalize();

			Vec3 offset = side.scale(trailWidth / 2.0F);

			addVertex(vertexconsumer, matrix, drawFrom.add(offset),       trailR, trailG, trailB, u1, 0F, packedLightIn); // Top-left
			addVertex(vertexconsumer, matrix, drawFrom.add(offset.scale(-1)), trailR, trailG, trailB, u1, 1F, packedLightIn); // Bottom-left
			addVertex(vertexconsumer, matrix, sample.add(offset.scale(-1)),   trailR, trailG, trailB, u2, 1F, packedLightIn); // Bottom-right
			addVertex(vertexconsumer, matrix, sample.add(offset),           trailR, trailG, trailB, u2, 0F, packedLightIn); // Top-right

			drawFrom = sample;
		}
	}


	private void addVertex(VertexConsumer consumer, Matrix4f matrix, Vec3 pos, float r, float g, float b, float u, float v, int light) {
		consumer.addVertex(matrix, (float)pos.x, (float)pos.y, (float)pos.z)
				.setColor(r, g, b, 1.0F)
				.setUv(u, v)
				.setOverlay(OverlayTexture.NO_OVERLAY)
				.setLight(light)
				.setNormal(0.0F, 1.0F, 0.0F); // Normal can be fixed as lighting is emissive
	}

	/**
	 * A helper method to do some Math Magic
	 */
	private float rotLerp(float prevRotation, float rotation, float partialTicks)
	{
		float f;
		for(f = rotation - prevRotation; f < -180.0F; f += 360.0F)
		{
			;
		}

		while(f >= 180.0F)
		{
			f -= 360.0F;
		}

		return prevRotation + partialTicks * f;
	}
}