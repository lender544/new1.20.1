package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Ceraunus_Model;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Part;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Ceraunus_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Player_Ceraunus_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Tidal_Hook_Entity;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WitherSkullRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;


public class Player_Ceraunus_Renderer extends EntityRenderer<Player_Ceraunus_Entity> {

	private final Ceraunus_Model model;



	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/player_ceraunus.png");
	private static final ResourceLocation CHAIN_TEXTURE  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/item/ceraunus_chain.png");


	public Player_Ceraunus_Renderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
		this.model = new Ceraunus_Model(renderManagerIn.bakeLayer(CMModelLayers.CERAUNUS_MODEL));
	}


	@Override
	public void render(Player_Ceraunus_Entity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource provider, int light) {
		matrices.pushPose();

		float yRot = Mth.lerp(tickDelta, entity.yRotO, entity.getYRot());
		float xRot = Mth.lerp(tickDelta, entity.xRotO, entity.getXRot());

		matrices.mulPose(Axis.YP.rotationDegrees(yRot - 90.0F));
		matrices.mulPose(Axis.ZP.rotationDegrees(xRot + 90.0F));

		VertexConsumer vertexConsumer = provider.getBuffer(this.model.renderType(getTextureLocation(entity)));
		model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY);

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

	public boolean shouldRender(Player_Ceraunus_Entity entity, Frustum camera, double camX, double camY, double camZ) {
		if (super.shouldRender(entity, camera, camX, camY, camZ)) {
			return true;
		} else {
			Entity weapon = entity.getOwner();
			if (weapon != null) {
				Vec3 vec3 = entity.position();
				Vec3 vec31 = weapon.position();
				return camera.isVisible(new AABB(vec31.x, vec31.y, vec31.z, vec3.x, vec3.y, vec3.z));
			}
			return false;
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
			if (!itemstack.is(ModItems.CERAUNUS.get())) {
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
				d4 = Mth.lerp((double) partialTicks, player.xo, player.getX()) - d1 * d2 - d0 * -0.2D;
				d5 = player.yo + (double) player.getEyeHeight() + (player.getY() - player.yo) * (double) partialTicks - 0.65D;
				d6 = Mth.lerp((double) partialTicks, player.zo, player.getZ()) - d0 * d2 + d1 * -0.2D;
				f3 = (player.isCrouching() ? -0.1875F : 0.0F);
			}
		}

		return new Vec3(d4, d5 + f3, d6);
	}

	public static void renderChainCube(Vec3 to, PoseStack poseStack, VertexConsumer buffer, int packedLightIn, int setOverlay) {
		double d = to.horizontalDistance();
		float rotY = (float) (Mth.atan2(to.x, to.z) * (double) (180F / (float) Math.PI));
		float rotX = (float) (-(Mth.atan2(to.y, d) * (double) (180F / (float) Math.PI))) - 90.0F;
		float chainWidth = 6F / 32F;
		float chainOffset = chainWidth * -0.5F;
		float chainLength = (float) to.length()/2.3F;
		poseStack.pushPose();
		poseStack.scale(2.3F, 2.3F, 2.3F);
		poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
		poseStack.mulPose(Axis.XP.rotationDegrees(rotX));
		poseStack.translate(0, -chainLength, 0);
		PoseStack.Pose posestack$pose = poseStack.last();
		//x links
		buffer.addVertex(posestack$pose, chainOffset, 0, 0).setColor(255, 255, 255, 255).setUv((float) 0, (float) chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
		buffer.addVertex(posestack$pose, chainWidth + chainOffset, 0, 0).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) chainLength).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
		buffer.addVertex(posestack$pose, chainWidth + chainOffset, chainLength, 0).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) 0).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
		buffer.addVertex(posestack$pose, chainOffset, chainLength, 0).setColor(255, 255, 255, 255).setUv((float) 0, (float) 0).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
		float pixelSkip = 8F / 32F;
		//z links
		buffer.addVertex(posestack$pose, 0, pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
		buffer.addVertex(posestack$pose, 0, pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth * 2, (float) chainLength + pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
		buffer.addVertex(posestack$pose, 0, chainLength + pixelSkip, chainWidth + chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth * 2, (float) pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
		buffer.addVertex(posestack$pose, 0, chainLength + pixelSkip, chainOffset).setColor(255, 255, 255, 255).setUv((float) chainWidth, (float) pixelSkip).setOverlay(setOverlay).setLight(packedLightIn).setNormal(posestack$pose, 0.0F, 1.0F, 0.0F);
		poseStack.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(Player_Ceraunus_Entity entity) {
		return TEXTURE;
	}
}