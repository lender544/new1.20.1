package com.github.L_Ender.cataclysm.client.render.blockentity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.block.Altar_of_Fire_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
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
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class RendererAltar_of_Fire<T extends AltarOfFire_Block_Entity> implements BlockEntityRenderer<T> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_fire/altar_of_fire.png");
    private static final ResourceLocation[] TEXTURE_FIRE_PROGRESS = new ResourceLocation[8];
    public static final ResourceLocation FLAME_STRIKE = new ResourceLocation(Cataclysm.MODID,"textures/entity/flame_strike_sigil.png");
    private static final Altar_of_Fire_Model MODEL = new Altar_of_Fire_Model();

    public RendererAltar_of_Fire(Context rendererDispatcherIn) {
        for(int i = 0; i < 8; i++){
            TEXTURE_FIRE_PROGRESS[i] = new ResourceLocation(Cataclysm.MODID,"textures/block/altar_of_fire/altarfire_" + i + ".png");
        }
    }

    @Override
    public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        float f2 = (float) tileEntityIn.tickCount + partialTicks;
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.5F, 1.5F, 0.5F);
        matrixStackIn.scale(1.0F, -1.0F, -1.0F);
        MODEL.animate(tileEntityIn, partialTicks);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), combinedLightIn, combinedOverlayIn, 1, 1F, 1, 1);
        MODEL.renderToBuffer(matrixStackIn, bufferIn.getBuffer(CMRenderTypes.CMEyes(getIdleTexture((int) ((f2 * 0.5F) % 7)))), 210, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
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
            Matrix4f lvt_20_1_ = lvt_19_1_.pose();
            Matrix3f lvt_21_1_ = lvt_19_1_.normal();
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
            this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
            matrixStackIn.popPose();
        }
    }

    public void drawVertex(Matrix4f p_229039_1_, Matrix3f p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.vertex(p_229039_1_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).uv(p_229039_7_, p_229039_8_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_).endVertex();
    }
}


