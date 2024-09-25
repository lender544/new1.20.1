package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Ignited_Revenant_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.layer.Revenant_Layer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignited_Revenant_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Ignited_Revenant_Renderer extends MobRenderer<Ignited_Revenant_Entity, Ignited_Revenant_Model> {

    private static final ResourceLocation IGNITED_REVENANT_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/revenant_body.png");
    private static final ResourceLocation IGNITED_REVENANT_LAYER_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/revenant_layer.png");
    private final RandomSource rnd = RandomSource.create();

    public Ignited_Revenant_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Ignited_Revenant_Model(), 0.5F);
        this.addLayer(new Ignited_Revenant_GlowLayer(this));
        this.addLayer(new Revenant_Layer(this));

    }
    @Override
    public ResourceLocation getTextureLocation(Ignited_Revenant_Entity entity) {
        return IGNITED_REVENANT_TEXTURES;
    }

    @Override
    protected void scale(Ignited_Revenant_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.1F, 1.1F, 1.1F);
    }

    public Vec3 getRenderOffset(Ignited_Revenant_Entity entityIn, float partialTicks) {
        if (entityIn.getAnimation() == Ignited_Revenant_Entity.ASH_BREATH_ATTACK && entityIn.getAnimationTick() >= 28 && entityIn.getAnimationTick() <= 43) {
            double d0 = 0.02D;
            return new Vec3(this.rnd.nextGaussian() * d0, 0.0D, this.rnd.nextGaussian() * d0);
        } else {
            return super.getRenderOffset(entityIn, partialTicks);
        }
    }

    static class Ignited_Revenant_GlowLayer extends RenderLayer<Ignited_Revenant_Entity, Ignited_Revenant_Model> {
        public Ignited_Revenant_GlowLayer(Ignited_Revenant_Renderer p_i50928_1_) {
            super(p_i50928_1_);
        }

        public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignited_Revenant_Entity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getFlickering(IGNITED_REVENANT_LAYER_TEXTURES, 0));
            float alpha = 0.5F + (Mth.cos(ageInTicks * 0.2F) + 1F) * 0.2F;
            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, 240, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), 1.0F, 1.0F, 1.0F, alpha);

        }
    }

}
