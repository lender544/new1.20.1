package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Urchinkin_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Urchinkin_Renderer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AcropolisMonsters.Urchinkin_Entity;
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
public class Urchinkin_Layer extends RenderLayer<Urchinkin_Entity, Urchinkin_Model> {

    private static final ResourceLocation URCHIN_LAYER_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/sea/urchinkin_layer.png");

    private static final ResourceLocation MEAT_BOY_LAYER_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/sea/meat_boy_layer.png");


    public Urchinkin_Layer(Urchinkin_Renderer renderIn) {
        super(renderIn);

    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Urchinkin_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

            RenderType eyes = RenderType.eyes(Texture(entity));
            VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
            this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY,1,1,1,1);;

    }

    public ResourceLocation Texture(Urchinkin_Entity entity) {
        if (entity.isMeatBoy()) {
            return MEAT_BOY_LAYER_TEXTURES;
        } else {
            return URCHIN_LAYER_TEXTURES;
        }
    }
}


