package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Maledictus_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Maledictus_Renderer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.ShulkerHeadLayer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Maledictus_Layer extends RenderLayer<Maledictus_Entity, Maledictus_Model> {
    private static final ResourceLocation LAYER_TEXTURES  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/maledictus/maledictus_armor.png");

    public Maledictus_Layer(Maledictus_Renderer renderIn) {
        super(renderIn);

    }

    public ResourceLocation getLayerTextureLocation() {
        return LAYER_TEXTURES;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType ghost = RenderType.entityCutoutNoCull(this.getLayerTextureLocation());
        VertexConsumer VertexConsumer = bufferIn.getBuffer(ghost);
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn,LivingEntityRenderer.getOverlayCoords(entity, 0.0F));
    }
}


