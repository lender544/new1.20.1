package com.github.L_Ender.cataclysm.client.render.blockentity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.block.Altar_of_Fire_Model;
import com.github.L_Ender.cataclysm.blockentities.AltarOfFire_Block_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class RendererAltar_of_Fire<T extends AltarOfFire_Block_Entity> implements BlockEntityRenderer<T> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/block/altar_of_fire/altar_of_fire.png");
    private static final ResourceLocation[] TEXTURE_FIRE_PROGRESS = new ResourceLocation[8];
    public static final ResourceLocation FLAME_STRIKE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/flame_strike_sigil.png");
    private static final Altar_of_Fire_Model MODEL = new Altar_of_Fire_Model();

    public RendererAltar_of_Fire(Context rendererDispatcherIn) {
        for(int i = 0; i < 8; i++){
            TEXTURE_FIRE_PROGRESS[i] = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/block/altar_of_fire/altar_fire_" + i + ".png");
        }
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        float f2 = (float) tileEntityIn.tickCount + partialTicks;
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        matrixStackIn.scale(1.0F, -1.0F, -1.0F);
        MODEL.animate(tileEntityIn, partialTicks);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn);
        renderFlamePart(f2,matrixStackIn,bufferIn,15);
        matrixStackIn.popPose();
        renderItem(tileEntityIn, partialTicks,matrixStackIn,bufferIn,combinedLightIn);
        renderSigil(tileEntityIn,partialTicks,matrixStackIn,bufferIn);
    }

    private ResourceLocation getIdleTexture(int age) {
        return TEXTURE_FIRE_PROGRESS[Mth.clamp(age, 0, 7)];
    }

    public void renderItem(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn) {
        ItemStack stack = tileEntityIn.getItem(0);
        float f2 = (float) tileEntityIn.tickCount + partialTicks;
        if (!stack.isEmpty()) {
            matrixStackIn.pushPose();
            matrixStackIn.translate(0.5F, 1.0F, 0.5F);

            matrixStackIn.mulPose(Axis.YP.rotationDegrees(f2));
            BakedModel ibakedmodel = Minecraft.getInstance().getItemRenderer().getModel(stack, tileEntityIn.getLevel(), (LivingEntity) null, 0);
            boolean flag = ibakedmodel.isGui3d();
            if (!flag) {
                matrixStackIn.translate(0.0F, 0.0F, 0.0F);
            }
            Minecraft.getInstance().getItemRenderer().render(stack, ItemDisplayContext.GROUND, false, matrixStackIn, bufferIn, combinedLightIn, OverlayTexture.NO_OVERLAY, ibakedmodel);
            matrixStackIn.popPose();
        }
    }

    public void renderSigil(T tileEntityIn, float delta, PoseStack matrixStackIn, MultiBufferSource bufferIn) {
        if(tileEntityIn.summoningthis) {
            float f2 = (float) tileEntityIn.tickCount + delta;
            float f3 = Mth.clamp(tileEntityIn.summoningticks, 0, 25);
            matrixStackIn.pushPose();
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucentEmissive(FLAME_STRIKE));
            matrixStackIn.translate(0.5D, 0.001D, 0.5D);
            matrixStackIn.scale(f3 * 0.1f, f3 * 0.1f, f3 * 0.1f);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F + f2));
            PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
            this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_19_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
            matrixStackIn.popPose();
        }
    }

    private void renderFlamePart(float f2,PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        VertexConsumer builder = bufferSource.getBuffer(RenderType.beaconBeam(getIdleTexture((int) ((f2 * 0.5F) % 7)),true));

        poseStack.pushPose();
        poseStack.translate(0,0.75,0);
        poseStack.scale(1.0F, -1.0F, -1.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(45.0F));
        for (int i = 0; i < 4; i++) {
            renderQuad(poseStack, builder, 0.5f, 0.0f, 1.0f, packedLight);
            poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
        }
        poseStack.popPose();
    }

    private void renderQuad(PoseStack poseStack, VertexConsumer builder, float size, float yMin, float yMax, int light) {
        PoseStack.Pose lastPose = poseStack.last();

        float u0 = 0.0f;
        float u1 = 1.0f;
        float v0 = 0.0f;
        float v1 = 1.0f;

        vertex(builder, lastPose, -size, yMin, 0.0f, u0, v1, light);
        vertex(builder, lastPose, size, yMin, 0.0f, u1, v1, light);
        vertex(builder, lastPose, size, yMax, 0.0f, u1, v0, light);
        vertex(builder, lastPose, -size, yMax, 0.0f, u0, v0, light);
    }

    private void vertex(VertexConsumer builder, PoseStack.Pose pose, float x, float y, float z, float u, float v, int light) {
        builder.addVertex(pose, x, y, z)
                .setColor(255, 255, 255, 255)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(pose, 0.0F, 1.0F, 0.0F);
    }
    public void drawVertex(PoseStack.Pose p_324380_, VertexConsumer p_253902_, int p_254058_, int p_254338_, int p_254196_, float p_254003_, float p_254165_, int p_253982_, int p_254037_, int p_254038_, int p_254271_) {
        p_253902_.addVertex(p_324380_, (float)p_254058_, (float)p_254338_, (float)p_254196_).setColor(255, 255, 255, 255).setUv(p_254003_, p_254165_).setOverlay(OverlayTexture.NO_OVERLAY).setLight(p_254271_).setNormal(p_324380_, (float)p_253982_, (float)p_254038_, (float)p_254037_);
    }
}


