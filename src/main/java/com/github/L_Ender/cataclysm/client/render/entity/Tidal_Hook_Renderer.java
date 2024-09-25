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
		matrices.mulPose(Axis.YP.rotationDegrees(Mth.lerp(tickDelta, entity.yRotO, entity.getYRot()) - 90.0F));
		matrices.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(tickDelta, entity.xRotO, entity.getXRot()) + 90.0F));

		VertexConsumer vertexConsumer = provider.getBuffer(this.model.renderType(getTextureLocation(entity)));
		model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		matrices.popPose();

		matrices.pushPose();
		Entity fromEntity = entity.getOwner();

		float x = (float)Mth.lerp(tickDelta, entity.xo, entity.getX());
		float y = (float)Mth.lerp(tickDelta, entity.yo, entity.getY());
		float z = (float)Mth.lerp(tickDelta, entity.zo, entity.getZ());
		if(fromEntity != null) {
			Vec3 distVec = getPositionOfPriorMob(fromEntity, tickDelta).subtract(x, y, z);
			Vec3 from = distVec;
			renderChainCube(from, tickDelta, entity.tickCount, matrices, provider, light);
		}

		matrices.popPose();

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

	public static void renderChainCube(Vec3 from, float tickDelta, int age, PoseStack stack, MultiBufferSource provider, int light) {
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
		Matrix4f matrix4f = entry.pose();
		Matrix3f matrix3f = entry.normal();

		vertexConsumer.vertex(matrix4f, vertX1, vertY1, 0F).color(0, 0, 0, 255).uv(minU, minV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
		vertexConsumer.vertex(matrix4f, vertX1, vertY1, length).color(255, 255, 255, 255).uv(minU, maxV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
		vertexConsumer.vertex(matrix4f, vertX2, vertY2, length).color(255, 255, 255, 255).uv(maxU, maxV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
		vertexConsumer.vertex(matrix4f, vertX2, vertY2, 0F).color(0, 0, 0, 255).uv(maxU, minV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();

		stack.popPose();
		stack.mulPose(Axis.ZP.rotationDegrees(90));
		stack.translate(-0.015, -0.2, 0);

		entry = stack.last();
		matrix4f = entry.pose();
		matrix3f = entry.normal();

		vertexConsumer.vertex(matrix4f, vertX1, vertY1, 0F).color(0, 0, 0, 255).uv(minU, minV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
		vertexConsumer.vertex(matrix4f, vertX1, vertY1, length).color(255, 255, 255, 255).uv(minU, maxV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
		vertexConsumer.vertex(matrix4f, vertX2, vertY2, length).color(255, 255, 255, 255).uv(maxU, maxV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
		vertexConsumer.vertex(matrix4f, vertX2, vertY2, 0F).color(0, 0, 0, 255).uv(maxU, minV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();

		stack.popPose();
	}


	@Override
	public ResourceLocation getTextureLocation(Tidal_Hook_Entity entity) {
		return TEXTURE;
	}
}