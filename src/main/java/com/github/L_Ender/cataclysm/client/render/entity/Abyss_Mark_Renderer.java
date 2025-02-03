package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.effect.Abyss_Mark_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class Abyss_Mark_Renderer extends EntityRenderer<Abyss_Mark_Entity> {
    public static final ResourceLocation ABYSS_MARK1 = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/deepling/deepling_warlock_mark1.png");
    public static final ResourceLocation ABYSS_MARK2 = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/deepling/deepling_warlock_mark2.png");
    public Abyss_Mark_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    @Override
    public ResourceLocation getTextureLocation(Abyss_Mark_Entity entity) {
        float f = entity.getLifespan();

        return f > -1 && f / 5 % 2 == 0 ? ABYSS_MARK2 : ABYSS_MARK1;
    }

    @Override
    public void render(Abyss_Mark_Entity flameStrike, float entityYaw, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(CMRenderTypes.getGlowingEffect(this.getTextureLocation(flameStrike)));
        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
        matrixStackIn.translate(0.0D, 0.001D, 0.0D);
        PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
        this.drawVertex( lvt_19_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
        this.drawVertex( lvt_19_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
        this.drawVertex( lvt_19_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
        this.drawVertex( lvt_19_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
        matrixStackIn.popPose();
        super.render(flameStrike, entityYaw, delta, matrixStackIn, bufferIn, packedLightIn);
    }


    public void drawVertex(PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_2_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_);
    }
}
