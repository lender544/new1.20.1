package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Ignited_Berserker_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Ignited_Berserker_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Ignited_Berserker_Renderer extends MobRenderer<Ignited_Berserker_Entity, Ignited_Berserker_Model<Ignited_Berserker_Entity>> {

    private static final ResourceLocation BERSERKER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/ignited_berserker.png");
    private static final ResourceLocation BERSERKER_LAYER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/ignited_berserker_layer.png");

    public Ignited_Berserker_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Ignited_Berserker_Model<>(renderManagerIn.bakeLayer(CMModelLayers.IGNITED_BERSERKER_MODEL)), 0.5F);
        this.addLayer(new Ignited_Berserker_GlowLayer(this));
    }
    @Override
    public ResourceLocation getTextureLocation(Ignited_Berserker_Entity entity) {
        return BERSERKER_TEXTURES;
    }

    @Override
    protected void scale(Ignited_Berserker_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.05F, 1.05F, 1.05F);
    }

    static class Ignited_Berserker_GlowLayer extends RenderLayer<Ignited_Berserker_Entity, Ignited_Berserker_Model<Ignited_Berserker_Entity>> {
        public Ignited_Berserker_GlowLayer(Ignited_Berserker_Renderer p_i50928_1_) {
            super(p_i50928_1_);
        }

        public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignited_Berserker_Entity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getFlickering(BERSERKER_LAYER_TEXTURES));
            float alpha = 0.5F + (Mth.cos(ageInTicks * 0.2F) + 1F) * 0.2F;
            int i = FastColor.ARGB32.color(Mth.floor(alpha * 255.0F), 255, 255, 255);
            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, 240, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F),  i);

        }
    }

}

