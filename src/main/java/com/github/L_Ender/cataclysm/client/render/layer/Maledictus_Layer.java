package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.Model_Maledictus;
import com.github.L_Ender.cataclysm.client.render.entity.RendererMaledictus;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Maledictus_Layer extends RenderLayer<Maledictus_Entity, Model_Maledictus> {
    private static final ResourceLocation LAYER_TEXTURES  = new ResourceLocation("cataclysm:textures/entity/maledictus/maledictus_armor.png");

    public Maledictus_Layer(RendererMaledictus renderIn) {
        super(renderIn);

    }


    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType ghost = RenderType.entityCutoutNoCull(LAYER_TEXTURES);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(ghost);
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
    }
}


