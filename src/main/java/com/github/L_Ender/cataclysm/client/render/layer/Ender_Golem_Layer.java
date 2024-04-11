package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.ModelEnder_Golem;
import com.github.L_Ender.cataclysm.client.render.entity.RendererEnder_Golem;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Ender_Golem_Layer extends RenderLayer<Ender_Golem_Entity, ModelEnder_Golem> {
    private static final ResourceLocation ENDER_GOLEM_LAYER_TEXTURES  = new ResourceLocation("cataclysm:textures/entity/ender_golem_layer.png");

    public Ender_Golem_Layer(RendererEnder_Golem renderIn) {
        super(renderIn);

    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ender_Golem_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if ( entity.deathTime <= 45) {
            //need rework
            float f = 1.0F - entity.deactivateProgress / 30;
            RenderType eyes = RenderType.eyes(ENDER_GOLEM_LAYER_TEXTURES);
            VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
            this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, f, f, f, f);
        }
    }
}


