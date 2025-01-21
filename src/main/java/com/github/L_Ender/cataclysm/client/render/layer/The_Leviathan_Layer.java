package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.The_Leviathan_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.The_Leviathan_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
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
public class The_Leviathan_Layer extends RenderLayer<The_Leviathan_Entity, The_Leviathan_Model> {
    private static final ResourceLocation LEVIATHAN_LAYER = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/leviathan/the_leviathan_layer.png");
    private static final ResourceLocation BURNING_LEVIATHAN_LAYER = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/leviathan/the_burning_leviathan_layer.png");

    public The_Leviathan_Layer(The_Leviathan_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Leviathan_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float alpha = entity.getMeltDown() ? 1 :entity.LayerBrightness;

        ResourceLocation resourceLocation = entity.getMeltDown() ? BURNING_LEVIATHAN_LAYER : LEVIATHAN_LAYER;
        RenderType eyes = CMRenderTypes.CMEyes(resourceLocation);

        int i = FastColor.ARGB32.color(255, (int) (255 * alpha), (int) (255 * alpha),(int) (255 * alpha));

        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, i);

    }
}


