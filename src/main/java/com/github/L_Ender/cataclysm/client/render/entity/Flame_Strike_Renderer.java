package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.entity.effect.Flame_Strike_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class Flame_Strike_Renderer extends EntityRenderer<Flame_Strike_Entity> {
    public static final ResourceLocation FLAME_STRIKE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/flame_strike_sigil.png");
    public static final ResourceLocation SOUL_FLAME_STRIKE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/soul_flame_strike_sigil.png");

    public Flame_Strike_Renderer(EntityRendererProvider.Context mgr) {
        super(mgr);
    }

    @Override
    public ResourceLocation getTextureLocation(Flame_Strike_Entity entity) {
        return entity.isSoul() ? SOUL_FLAME_STRIKE : FLAME_STRIKE;
    }

    @Override
    public void render(Flame_Strike_Entity flameStrike, float entityYaw, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        float f2 = (float) flameStrike.tickCount + delta;
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucentEmissive(this.getTextureLocation(flameStrike)));
        matrixStackIn.scale(flameStrike.getRadius(), flameStrike.getRadius(), flameStrike.getRadius());
        matrixStackIn.translate(0.0D, 0.001D, 0.0D);
        if(flameStrike.isSoul()) {
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(f2));
        }else{
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F - flameStrike.getYRot() + f2));
        }
        PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
        if(flameStrike.isSee()) {
            this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
        }
        matrixStackIn.popPose();
        super.render(flameStrike, entityYaw, delta, matrixStackIn, bufferIn, packedLightIn);
    }


    public void drawVertex( PoseStack.Pose p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.addVertex(p_229039_2_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).setColor(255, 255, 255, 255).setUv(p_229039_7_, p_229039_8_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_229039_12_).setNormal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_);
    }
}
