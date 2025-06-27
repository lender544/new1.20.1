package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Cursed_Sandstorm_Model;
import com.github.L_Ender.cataclysm.client.model.entity.Sandstorm_Projectile_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.projectile.Cursed_Sandstorm_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Sandstorm_Projectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Cursed_Sandstorm_Renderer extends EntityRenderer<Cursed_Sandstorm_Entity>
{
	private static final ResourceLocation SANDSTORM = new ResourceLocation(Cataclysm.MODID,"textures/entity/cursed_sandstorm.png");

	public Cursed_Sandstorm_Model model;

	public Cursed_Sandstorm_Renderer(EntityRendererProvider.Context manager) {
		super(manager);
		this.model = new Cursed_Sandstorm_Model();
	}

	@Override
	public void render(Cursed_Sandstorm_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		matrixStackIn.scale(-0.5F, -0.5F, 0.5F);
		matrixStackIn.translate(0F, -1.5F, 0F);
		float f = Mth.rotLerp(partialTicks, entityIn.yRotO, entityIn.getYRot());
		float f1 = Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot());
		VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(this.getTextureLocation(entityIn)));
		this.model.setupAnim(entityIn, 0.0F, 0.0F,entityIn.tickCount + partialTicks, f, f1);
		this.model.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.6f);
		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(Cursed_Sandstorm_Entity entity)
	{
		return SANDSTORM;
	}
}