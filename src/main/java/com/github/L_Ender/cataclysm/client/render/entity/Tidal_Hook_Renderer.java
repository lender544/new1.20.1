package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Tidal_Hook_Model;
import com.github.L_Ender.cataclysm.entity.projectile.Tidal_Hook_Entity;

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
import org.joml.Matrix3f;
import org.joml.Matrix4f;


public class Tidal_Hook_Renderer extends EntityRenderer<Tidal_Hook_Entity> {
	private final Tidal_Hook_Model model = new Tidal_Hook_Model();
	private static final ResourceLocation TEXTURE = new ResourceLocation( Cataclysm.MODID,"textures/entity/tidal_hook.png");
	private static final ResourceLocation CHAIN_TEXTURE = new ResourceLocation( Cataclysm.MODID,"textures/entity/tidal_hook_chain.png");
	private static final RenderType CHAIN_LAYER = RenderType.entitySmoothCutout(CHAIN_TEXTURE);

	public Tidal_Hook_Renderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public void render(Tidal_Hook_Entity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource provider, int light) {
		matrices.pushPose();

		float yRot = Mth.lerp(tickDelta, entity.yRotO, entity.getYRot());
		float xRot = Mth.lerp(tickDelta, entity.xRotO, entity.getXRot());

		matrices.mulPose(Axis.YP.rotationDegrees(yRot - 90.0F));
		matrices.mulPose(Axis.ZP.rotationDegrees(xRot + 90.0F));

		VertexConsumer vertexConsumer = provider.getBuffer(this.model.renderType(getTextureLocation(entity)));
		model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY,1.0F,1.0F,1.0F,1.0F);

		matrices.popPose();
		Entity fromEntity = entity.getOwner();
		if (fromEntity != null) {
			Vec3 entityPos = entity.getPosition(tickDelta);

			PoseStack poseForModel = new PoseStack();
			poseForModel.mulPose(Axis.YP.rotationDegrees(yRot - 90.0F));
			poseForModel.mulPose(Axis.ZP.rotationDegrees(xRot + 90.0F));

			Vec3 modelOffset = model.getChainPosition(new Vec3(0, 0.0F, 0), poseForModel);
			Vec3 fromPos = getPositionOfPriorMob(fromEntity, tickDelta);
			Vec3 chainTo = fromPos.subtract(entityPos);
			Vec3 chainBase = modelOffset;

			matrices.pushPose();
			matrices.translate(chainBase.x, chainBase.y, chainBase.z);

			VertexConsumer chainBuffer = provider.getBuffer(RenderType.entityCutoutNoCull(CHAIN_TEXTURE));
			renderChainCube(chainTo.subtract(chainBase), matrices, chainBuffer, light, OverlayTexture.NO_OVERLAY);
			matrices.popPose();
		}

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




	//The old code was taken from https://github.com/CammiesCorner/Hookshot/blob/1.20.1/src/main/java/dev/cammiescorner/hookshot/client/entity/renderer/HookshotEntityRenderer.java#L64-L108
	//This code was taken from https://github.com/AlexModGuy/AlexsCaves/blob/main/src/main/java/com/github/alexmodguy/alexscaves/client/render/entity/BoundroidWinchRenderer.java
	public static void renderChainCube(Vec3 to, PoseStack poseStack, VertexConsumer buffer, int packedLightIn, int setOverlay) {
		double d = to.horizontalDistance();
		float rotY = (float) (Mth.atan2(to.x, to.z) * (double) (180F / (float) Math.PI));
		float rotX = (float) (-(Mth.atan2(to.y, d) * (double) (180F / (float) Math.PI))) - 90.0F;
		float chainWidth = 3F / 32F;
		float chainOffset = chainWidth * -0.5F;
		float chainLength = (float) to.length()/2.3F;
		poseStack.pushPose();
		poseStack.scale(2.3F, 2.3F, 2.3F);
		poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
		poseStack.mulPose(Axis.XP.rotationDegrees(rotX));
		poseStack.translate(0, -chainLength, 0);
		PoseStack.Pose posestack$pose = poseStack.last();

		Matrix4f matrix4f = posestack$pose.pose();
		Matrix3f matrix3f = posestack$pose.normal();
		//x links
		buffer.vertex(matrix4f, chainOffset, 0, 0).color(255, 255, 255, 255).uv((float) 0, (float) chainLength).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
		buffer.vertex(matrix4f, chainWidth + chainOffset, 0, 0).color(255, 255, 255, 255).uv((float) chainWidth, (float) chainLength).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
		buffer.vertex(matrix4f, chainWidth + chainOffset, chainLength, 0).color(255, 255, 255, 255).uv((float) chainWidth, (float) 0).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
		buffer.vertex(matrix4f, chainOffset, chainLength, 0).color(255, 255, 255, 255).uv((float) 0, (float) 0).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
		float pixelSkip = 4F / 32F;
		//z links
		buffer.vertex(matrix4f, 0, pixelSkip, chainOffset).color(255, 255, 255, 255).uv((float) chainWidth, (float) chainLength + pixelSkip).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
		buffer.vertex(matrix4f, 0, pixelSkip, chainWidth + chainOffset).color(255, 255, 255, 255).uv((float) chainWidth * 2, (float) chainLength + pixelSkip).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
		buffer.vertex(matrix4f, 0, chainLength + pixelSkip, chainWidth + chainOffset).color(255, 255, 255, 255).uv((float) chainWidth * 2, (float) pixelSkip).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
		buffer.vertex(matrix4f, 0, chainLength + pixelSkip, chainOffset).color(255, 255, 255, 255).uv((float) chainWidth, (float) pixelSkip).overlayCoords(setOverlay).uv2(packedLightIn).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
		poseStack.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(Tidal_Hook_Entity entity) {
		return TEXTURE;
	}
}