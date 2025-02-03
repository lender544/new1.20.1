package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.The_Harbinger_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.The_Harbinger_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class The_Harbinger_Layer extends RenderLayer<The_Harbinger_Entity, The_Harbinger_Model> {
    private static final ResourceLocation HARBINGER_LAYER_TEXTURES  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/harbinger/the_harbinger_layer.png");

    public The_Harbinger_Layer(The_Harbinger_Renderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        int f = (int) (255 - entity.deactivateProgress * 255 / 40);
        RenderType eyes = RenderType.eyes(HARBINGER_LAYER_TEXTURES);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

        int i = FastColor.ARGB32.color(255, f, f, f);

        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, i);

    }
}


