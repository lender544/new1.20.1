package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.Lionfish_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.Lionfish_Renderer;
import com.github.L_Ender.cataclysm.entity.Deepling.Lionfish_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LionFish_Layer extends RenderLayer<Lionfish_Entity, Lionfish_Model> {
	private static final ResourceLocation LION_LAYER_TEXTURES  = new ResourceLocation("cataclysm:textures/entity/deepling/lionfish_layer.png");

    public LionFish_Layer(Lionfish_Renderer renderIn) {
		super(renderIn);

	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Lionfish_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
	{
		RenderType eyes = CMRenderTypes.CMEyes(LION_LAYER_TEXTURES);
		VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

		float strength = 0.5F + Mth.clamp(((float) Math.cos((entity.LayerTicks + partialTicks) * 0.1F)) - 0.5F, -0.5F, 0.5F);

		strength += Mth.lerp(partialTicks, entity.oLayerBrightness, entity.LayerBrightness) * 1 * Mth.PI;
		strength = Mth.clamp(strength, 0.1f, 1);

		this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, strength, strength, strength, 1.0F);
	}


}