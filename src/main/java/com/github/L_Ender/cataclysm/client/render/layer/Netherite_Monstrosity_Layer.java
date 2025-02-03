package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Netherite_Monstrosity_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;

import com.github.L_Ender.cataclysm.client.render.entity.New_Netherite_Monstrosity_Renderer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;


public class Netherite_Monstrosity_Layer extends RenderLayer<Netherite_Monstrosity_Entity, Netherite_Monstrosity_Model> {
    private static final ResourceLocation NETHERITE_MONSTRISITY_LAYER_TEXTURES  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/monstrosity/netherite_monstrosity_layer.png");

    public Netherite_Monstrosity_Layer(New_Netherite_Monstrosity_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Netherite_Monstrosity_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        float f = 0.5F;
         f = (float) (f - Mth.clamp((float) entity.deathTime / entity.deathtimer(), 0, 0.5));
        RenderType eyes = CMRenderTypes.CMEyes(NETHERITE_MONSTRISITY_LAYER_TEXTURES);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        int i = FastColor.ARGB32.color((int) (255 * f), (int) (255 * f), (int) (255 * f), (int) (255 * f));
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, i);

    }
}


