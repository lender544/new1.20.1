package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Storm_Bringer_Model;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla.Scylla_Storm_Bringer_Entity;
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


public class Scylla_Storm_Bringer_Renderer extends EntityRenderer<Scylla_Storm_Bringer_Entity> {

	private final Storm_Bringer_Model model;



	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath( Cataclysm.MODID,"textures/entity/scylla/storm_bringer.png");
	private static final ResourceLocation CHAIN_TEXTURE = ResourceLocation.withDefaultNamespace("textures/block/chain.png");

	public Scylla_Storm_Bringer_Renderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
		this.model = new Storm_Bringer_Model(renderManagerIn.bakeLayer(CMModelLayers.STORM_BRINGER_MODEL));
	}

	@Override
	public void render(Scylla_Storm_Bringer_Entity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource provider, int light) {
		matrices.pushPose();
		matrices.mulPose(Axis.YP.rotationDegrees(Mth.lerp(tickDelta, entity.yRotO, entity.getYRot()) - 90.0F));
		matrices.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(tickDelta, entity.xRotO, entity.getXRot()) + 90.0F));
		matrices.mulPose(Axis.YP.rotationDegrees(-90.0F));
		VertexConsumer vertexConsumer = provider.getBuffer(this.model.renderType(getTextureLocation(entity)));
		model.renderToBuffer(matrices, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
		matrices.popPose();

	}


	@Override
	public ResourceLocation getTextureLocation(Scylla_Storm_Bringer_Entity entity) {
		return TEXTURE;
	}
}