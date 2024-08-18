package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.effect.Void_Vortex_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class RendererVoid_Vortex extends EntityRenderer<Void_Vortex_Entity> {
    private static final ResourceLocation TEXTURE_1 = new ResourceLocation(Cataclysm.MODID,"textures/entity/void_vortex/void_vortex_idle1.png");
    private static final ResourceLocation TEXTURE_2 = new ResourceLocation(Cataclysm.MODID,"textures/entity/void_vortex/void_vortex_idle2.png");
    private static final ResourceLocation TEXTURE_3 = new ResourceLocation(Cataclysm.MODID,"textures/entity/void_vortex/void_vortex_idle3.png");
    private static final ResourceLocation TEXTURE_4 = new ResourceLocation(Cataclysm.MODID,"textures/entity/void_vortex/void_vortex_idle4.png");
    private static final ResourceLocation[] TEXTURE_PROGRESS = new ResourceLocation[4];


    public RendererVoid_Vortex(EntityRendererProvider.Context mgr) {
        super(mgr);
        for(int i = 0; i < 4; i++) {
            TEXTURE_PROGRESS[i] = new ResourceLocation(Cataclysm.MODID,"textures/entity/void_vortex/void_vortex_grow_" + i + ".png");
        }
    }

    public void render(Void_Vortex_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 0.001D, 0.0D);
        ResourceLocation tex;
        if(entityIn.getLifespan() < 16){
            tex = getGrowingTexture((int) ((entityIn.getLifespan() * 0.5F) % 20));
        }else if(entityIn.tickCount < 16){
            tex = getGrowingTexture((int) ((entityIn.tickCount * 0.5F) % 20));
        }else{
            tex = getIdleTexture(entityIn.tickCount % 9);
        }
        matrixStackIn.scale(3, 3, 3);
        renderArc(matrixStackIn, bufferIn, tex);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private void renderArc(PoseStack matrixStackIn, MultiBufferSource bufferIn, ResourceLocation res) {
        matrixStackIn.pushPose();
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getfullBright(res));
        PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
        Matrix4f lvt_20_1_ = lvt_19_1_.pose();
        Matrix3f lvt_21_1_ = lvt_19_1_.normal();
        this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
        this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
        this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
        this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
        matrixStackIn.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(Void_Vortex_Entity entity) {
        return TEXTURE_1;
    }


    public void drawVertex(Matrix4f p_229039_1_, Matrix3f p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.vertex(p_229039_1_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).uv(p_229039_7_, p_229039_8_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_).endVertex();
    }


    public ResourceLocation getIdleTexture(int age) {
        if (age < 3) {
            return TEXTURE_1;
        } else if (age < 6) {
            return TEXTURE_2;
        } else if (age < 10) {
            return TEXTURE_3;
        } else {
            return TEXTURE_4;
        }
    }

    public ResourceLocation getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[Mth.clamp(age/2, 0, 3)];
    }
}
