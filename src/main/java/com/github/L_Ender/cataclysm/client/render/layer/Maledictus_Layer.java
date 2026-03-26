package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Maledictus_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
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
import net.minecraft.util.FastColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Maledictus_Layer extends RenderLayer<Maledictus_Entity, Maledictus_Model> {
    private static final ResourceLocation LAYER_TEXTURES  = new ResourceLocation(Cataclysm.MODID,"textures/entity/maledictus/maledictus_ghost.png");

    public Maledictus_Layer(Maledictus_Renderer renderIn) {
        super(renderIn);

    }

    public ResourceLocation getLayerTextureLocation() {
        return LAYER_TEXTURES;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Maledictus_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        VertexConsumer vertexconsumer = bufferIn.getBuffer(CMRenderTypes.getGhost(getLayerTextureLocation()));
        float hide = (entity.getHealth() / entity.getMaxHealth()) - 0.4F;
        float alpha = (1F - hide) * 0.6F;
        boolean hurt = Math.max(entity.hurtTime, entity.deathTime) > 0;

        this.getParentModel().renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn,LivingEntityRenderer.getOverlayCoords(entity, 0.0F),hurt ?0.4F : 1.0F ,hurt ? 0.8F : 1.0F, hurt ? 0.7F : 1.0F, alpha);

    }
}


