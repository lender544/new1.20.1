package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Cindaria_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.Cindaria_Renderer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AcropolisMonsters.Cindaria_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Cindaria_Layer extends RenderLayer<Cindaria_Entity, Cindaria_Model> {
    private static final ResourceLocation LAYER_TEXTURES  = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/cindaria_body.png");

    public Cindaria_Layer(Cindaria_Renderer renderIn) {
        super(renderIn);

    }

    public ResourceLocation getLayerTextureLocation() {
        return LAYER_TEXTURES;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Cindaria_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {



        if (!entity.isInvisible()) {
            RenderType ghost = RenderType.entityTranslucent(this.getLayerTextureLocation());
            VertexConsumer VertexConsumer = bufferIn.getBuffer(ghost);
            float alpha = 0.65F;
            boolean hurt = Math.max(entity.hurtTime, entity.deathTime) > 0;
            int i1 = FastColor.ARGB32.color((int) (alpha * 255),255,hurt ? 127 : 255, hurt ? 127 :255);
            this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, packedLightIn, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), i1);
        }

    }
}


