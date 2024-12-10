package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.Old_Netherite_Monstrosity_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Netherite_Monstrosity_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Old_Netherite_Monstrosity_Entity;
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
public class Old_Netherite_Monstrosity_Layer extends RenderLayer<Old_Netherite_Monstrosity_Entity, Old_Netherite_Monstrosity_Model> {
    private static final ResourceLocation NETHERITE_MONSTRISITY_LAYER_TEXTURES  = new ResourceLocation("cataclysm:textures/entity/netherite_monstrosity_layer.png");

    public Old_Netherite_Monstrosity_Layer(Netherite_Monstrosity_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Old_Netherite_Monstrosity_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        float f = 1.0F - entity.deactivateProgress / 40;
        f = (float) (f - Mth.clamp((float) entity.deathTime / 100, 0, 1.0));
        RenderType eyes = RenderType.eyes(NETHERITE_MONSTRISITY_LAYER_TEXTURES);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, f, f, f, f);

    }
}


