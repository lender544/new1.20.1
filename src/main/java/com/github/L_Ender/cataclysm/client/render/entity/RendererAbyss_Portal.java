package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Portal_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class RendererAbyss_Portal extends EntityRenderer<Abyss_Portal_Entity> {
    private static final ResourceLocation TEXTURE_0 = new ResourceLocation("cataclysm:textures/entity/leviathan/portal/abyss_portal_idle_0.png");
    private static final ResourceLocation TEXTURE_1 = new ResourceLocation("cataclysm:textures/entity/leviathan/portal/abyss_portal_idle_1.png");
    private static final ResourceLocation TEXTURE_2 = new ResourceLocation("cataclysm:textures/entity/leviathan/portal/abyss_portal_idle_2.png");
    private static final ResourceLocation TEXTURE_3 = new ResourceLocation("cataclysm:textures/entity/leviathan/portal/abyss_portal_idle_3.png");
    private static final ResourceLocation[] TEXTURE_PROGRESS = new ResourceLocation[8];

    private static final ResourceLocation[] TEXTURE_IDLE = new ResourceLocation[4];

    public RendererAbyss_Portal(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
        for(int i = 0; i < 8; i++){
            TEXTURE_PROGRESS[i] = new ResourceLocation("cataclysm:textures/entity/leviathan/portal/abyss_portal_grow_" + i + ".png");
        }
        for(int i = 0; i < 4; i++){
            TEXTURE_IDLE[i] = new ResourceLocation("cataclysm:textures/entity/leviathan/portal/abyss_portal_idle_" + i + ".png");
        }

    }

    public void render(Abyss_Portal_Entity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0f, 0.01f, 0f);
        matrixStackIn.scale(4F, 4F, 4F);
        renderPortal(entityIn, matrixStackIn, bufferIn, false);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private void renderPortal(Abyss_Portal_Entity entityIn, PoseStack matrixStackIn, MultiBufferSource bufferIn, boolean shattered){
        ResourceLocation tex;
        if(entityIn.getLifespan() < 20){
            tex = getGrowingTexture((int) ((entityIn.getLifespan() * 0.5F) % 20));
        }else if(entityIn.tickCount < 20){
            tex = getGrowingTexture((int) ((entityIn.tickCount * 0.5F) % 20));
        }else{
            tex = getIdleTexture((int) ((entityIn.tickCount * 0.35F) % 3));
        }
        VertexConsumer ivertexbuilder =  bufferIn.getBuffer(CMRenderTypes.getfullBright(tex));
        renderArc(matrixStackIn, ivertexbuilder);
    }
    private void renderArc(PoseStack matrixStackIn, VertexConsumer ivertexbuilder) {
        matrixStackIn.pushPose();
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
    public ResourceLocation getTextureLocation(Abyss_Portal_Entity entity) {
        return TEXTURE_0;
    }


    public void drawVertex(Matrix4f p_229039_1_, Matrix3f p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.vertex(p_229039_1_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).uv(p_229039_7_, p_229039_8_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_).endVertex();
    }

    public ResourceLocation getIdleTexture(int age) {
        return TEXTURE_IDLE[Mth.clamp(age, 0, 3)];
    }


    public ResourceLocation getGrowingTexture(int age) {
        return TEXTURE_PROGRESS[Mth.clamp(age, 0, 7)];
    }
}
