package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Netherite_Ministrosity_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.Netherite_Ministrosity_Renderer;
import com.github.L_Ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;


public class Netherite_Ministrosity_Layer extends RenderLayer<Netherite_Ministrosity_Entity, Netherite_Ministrosity_Model> {
    private static final ResourceLocation NETHERITE_MONSTRISITY_LAYER_TEXTURES  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/monstrosity/netherite_ministrosity_layer.png");

    public Netherite_Ministrosity_Layer(Netherite_Ministrosity_Renderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Netherite_Ministrosity_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {


        RenderType eyes = CMRenderTypes.CMEyes(NETHERITE_MONSTRISITY_LAYER_TEXTURES);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

        float strength = 0.5F + Mth.clamp(((float) Math.cos((entity.LayerTicks + partialTicks) * 0.1F)) - 0.25F, -0.25F, 0.5F);

        if(!entity.getIsAwaken()){
            strength = 0F;
        }

        strength += Mth.lerp(partialTicks, entity.oLayerBrightness, entity.LayerBrightness) * 1 * Mth.PI;
        strength = Mth.clamp(strength, 0.25f, 1.0F);
        int i = FastColor.ARGB32.color((int) (255 * strength), (int) (255 * strength), (int) (255 * strength), 255);
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, i);


    }
}


