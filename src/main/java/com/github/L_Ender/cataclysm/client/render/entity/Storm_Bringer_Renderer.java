package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Storm_Bringer_Model;
import com.github.L_Ender.cataclysm.entity.projectile.Storm_Bringer_Entity;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector4f;


public class Storm_Bringer_Renderer extends EntityRenderer<Storm_Bringer_Entity> {

	private final Storm_Bringer_Model model;

	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath( Cataclysm.MODID,"textures/entity/scylla/storm_bringer.png");
	private static final ResourceLocation CHAIN_TEXTURE = ResourceLocation.withDefaultNamespace("textures/block/chain.png");
	private static final RenderType CHAIN_LAYER = RenderType.entitySmoothCutout(CHAIN_TEXTURE);

	public Storm_Bringer_Renderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
		this.model = new Storm_Bringer_Model(renderManagerIn.bakeLayer(CMModelLayers.STORM_BRINGER_MODEL));
	}

	@Override
	public void render(Storm_Bringer_Entity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource provider, int light) {
		matrices.pushPose();
		matrices.mulPose(Axis.YP.rotationDegrees(Mth.lerp(tickDelta, entity.yRotO, entity.getYRot()) - 90.0F));
		matrices.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(tickDelta, entity.xRotO, entity.getXRot()) + 90.0F));
		matrices.mulPose(Axis.YP.rotationDegrees(-90.0F));
		VertexConsumer vertexConsumer = provider.getBuffer(this.model.renderType(getTextureLocation(entity)));
		model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
		matrices.popPose();

		Entity fromEntity = entity.getOwner();
		Vec3 translateFrom = entity.getPosition(tickDelta);
		Vec3 modelOffset = this.getRiderPosition(new Vec3(0, 0.0F, 0),tickDelta,entity);
		VertexConsumer chainBuffer = provider.getBuffer(CHAIN_LAYER);

		matrices.pushPose();
		if(fromEntity != null) {
			Vec3 chainTo = entity.getChainFrom(tickDelta).add(modelOffset).subtract(translateFrom);
			Vec3 distVec = getPositionOfPriorMob(fromEntity, tickDelta).subtract(translateFrom).subtract(chainTo);
			Vec3 from = distVec;
			matrices.translate(chainTo.x, chainTo.y, chainTo.z);
			renderChainCube(from, matrices, chainBuffer, light, OverlayTexture.NO_OVERLAY);
			//renderChainCube1(from, tickDelta,  entity.tickCount, matrices, provider, light);
		}
		matrices.popPose();
	}




	public Vec3 getRiderPosition(Vec3 offsetIn,float tickDelta,Storm_Bringer_Entity entity) {
		PoseStack translationStack = new PoseStack();
		translationStack.pushPose();
		translationStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(tickDelta, entity.yRotO, entity.getYRot()) - 90.0F));
		translationStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(tickDelta, entity.xRotO, entity.getXRot()) + 90.0F));
		model.translateToHand(translationStack);

		Vector4f armOffsetVec = new Vector4f((float) offsetIn.x, (float) offsetIn.y, (float) offsetIn.z, 1.0F);
		armOffsetVec.mul(translationStack.last().pose());
		Vec3 vec3 = new Vec3(armOffsetVec.x(), armOffsetVec.y(), armOffsetVec.z());
		translationStack.popPose();
		return vec3.add(0, 0.0, 0);
	}


	private Vec3 getPositionOfPriorMob(Entity mob, float partialTicks){
		double d4 = Mth.lerp(partialTicks, mob.xo, mob.getX());
		double d5 = Mth.lerp(partialTicks, mob.yo, mob.getY());
		double d6 = Mth.lerp(partialTicks, mob.zo, mob.getZ());
		float f3 = 0;
		if(mob instanceof Player){
			Player player = (Player) mob;
			float f = player.getAttackAnim(partialTicks);
			float f1 = Mth.sin(Mth.sqrt(f) * (float) Math.PI);
			float f2 = Mth.lerp(partialTicks, player.yBodyRotO, player.yBodyRot) * ((float) Math.PI / 180F);
			int i = player.getMainArm() == HumanoidArm.RIGHT ? 1 : -1;
			ItemStack itemstack = player.getMainHandItem();
			if (!itemstack.is(ModItems.TIDAL_CLAWS.get())) {
				i = -i;
			}
			double d0 = (double) Mth.sin(f2);
			double d1 = (double) Mth.cos(f2);
			double d2 = (double) i * 0.35D;
			if ((this.entityRenderDispatcher.options == null || this.entityRenderDispatcher.options.getCameraType().isFirstPerson()) && player == Minecraft.getInstance().player) {
				double d7 = 960.0D / (double)this.entityRenderDispatcher.options.fov().get().intValue();
				Vec3 vec3 = this.entityRenderDispatcher.camera.getNearPlane().getPointOnPlane((float) i * 0.6F, -1);
				vec3 = vec3.scale(d7);
				vec3 = vec3.yRot(f1 * 0.25F);
				vec3 = vec3.xRot(-f1 * 0.35F);
				d4 = Mth.lerp((double) partialTicks, player.xo, player.getX()) + vec3.x;
				d5 = Mth.lerp((double) partialTicks, player.yo, player.getY()) + vec3.y;
				d6 = Mth.lerp((double) partialTicks, player.zo, player.getZ()) + vec3.z;
				f3 = player.getEyeHeight() * 0.5F;
			} else {
				d4 = Mth.lerp((double) partialTicks, player.xo, player.getX()) - d1 * d2 - d0 * 0.2D;
				d5 = player.yo + (double) player.getEyeHeight() + (player.getY() - player.yo) * (double) partialTicks - 0.45D;
				d6 = Mth.lerp((double) partialTicks, player.zo, player.getZ()) - d0 * d2 + d1 * 0.2D;
				f3 = (player.isCrouching() ? -0.1875F : 0.0F);
			}
		}

		return new Vec3(d4, d5 + f3, d6);
	}


	public static void renderChainCube(Vec3 to, PoseStack poseStack, VertexConsumer buffer, int packedLightIn, int setOverlay) {
		double d = to.horizontalDistance();
		float rotY = (float) (Mth.atan2(to.x, to.z) * (double) (180F / (float) Math.PI));
		float rotX = (float) (-(Mth.atan2(to.y, d) * (double) (180F / (float) Math.PI))) - 90.0F;
		float chainWidth = 3F / 16F;
		float chainOffset = chainWidth * -0.5F;
		float chainLength = (float) to.length();
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
		poseStack.mulPose(Axis.XP.rotationDegrees(rotX));
		poseStack.translate(0, -chainLength, 0);
		PoseStack.Pose posestack$pose = poseStack.last();
		//x links
		buffer.addVertex(posestack$pose, chainOffset, 0, 0).setColor(255, 255, 255, 255).setUv((float) 0, (float) chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
		buffer.addVertex(posestack$pose, chainWidth + chainOffset, 0, 0).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
		buffer.addVertex(posestack$pose, chainWidth + chainOffset, chainLength, 0).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) 0).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
		buffer.addVertex(posestack$pose, chainOffset, chainLength, 0).setColor(255, 255, 255, 255).setUv((float) 0, (float) 0).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
		float pixelSkip = 2.5F / 16F;
		//z links
		buffer.addVertex(posestack$pose, 0, pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
		buffer.addVertex(posestack$pose, 0, pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth * 2, (float) chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
		buffer.addVertex(posestack$pose, 0, chainLength + pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth * 2, (float) pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
		buffer.addVertex(posestack$pose, 0, chainLength + pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, -1.0F, 0.0F);
		poseStack.popPose();
	}
	public static void renderChainCube1(Vec3 from, float tickDelta, int age, PoseStack stack, MultiBufferSource provider, int light) {
		float lengthXY = Mth.sqrt((float) (from.x * from.x + from.z * from.z));
		float squaredLength = (float) (from.x * from.x + from.y * from.y + from.z * from.z);
		float length = Mth.sqrt(squaredLength);

		stack.pushPose();
		stack.mulPose(Axis.YP.rotation((float) (-Math.atan2(from.z, from.x)) - 1.5707964F));
		stack.mulPose(Axis.XP.rotation((float) (-Math.atan2(lengthXY, from.y)) - 1.5707964F));
		stack.mulPose(Axis.ZP.rotationDegrees(25));
		stack.pushPose();
		stack.translate(0.015, -0.2, 0);

		VertexConsumer vertexConsumer = provider.getBuffer(CHAIN_LAYER);
		float vertX1 = 0F;
		float vertY1 = 0.25F;
		float vertX2 = Mth.sin(6.2831855F) * 0.125F;
		float vertY2 = Mth.cos(6.2831855F) * 0.125F;
		float minU = 0F;
		float maxU = 0.1875F;
		float minV = 0.0F - ((float) age + tickDelta) * 0.01F;
		float maxV = Mth.sqrt(squaredLength) / 8F - ((float) age + tickDelta) * 0.01F;
		PoseStack.Pose entry = stack.last();


		vertexConsumer.addVertex(entry, vertX1, vertY1, 0F).setColor(0, 0, 0, 255).setUv(minU, minV).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.addVertex(entry, vertX1, vertY1, length).setColor(255, 255, 255, 255).setUv(minU, maxV).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.addVertex(entry, vertX2, vertY2, length).setColor(255, 255, 255, 255).setUv(maxU, maxV).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.addVertex(entry, vertX2, vertY2, 0F).setColor(0, 0, 0, 255).setUv(maxU, minV).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(entry, 0.0F, -1.0F, 0.0F);

		stack.popPose();
		stack.mulPose(Axis.ZP.rotationDegrees(90));
		stack.translate(-0.015, -0.2, 0);

		entry = stack.last();
		vertexConsumer.addVertex(entry, vertX1, vertY1, 0F).setColor(0, 0, 0, 255).setUv(minU, minV).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.addVertex(entry, vertX1, vertY1, length).setColor(255, 255, 255, 255).setUv(minU, maxV).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.addVertex(entry, vertX2, vertY2, length).setColor(255, 255, 255, 255).setUv(maxU, maxV).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(entry, 0.0F, -1.0F, 0.0F);
		vertexConsumer.addVertex(entry, vertX2, vertY2, 0F).setColor(0, 0, 0, 255).setUv(maxU, minV).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(entry, 0.0F, -1.0F, 0.0F);

		stack.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(Storm_Bringer_Entity entity) {
		return TEXTURE;
	}
}