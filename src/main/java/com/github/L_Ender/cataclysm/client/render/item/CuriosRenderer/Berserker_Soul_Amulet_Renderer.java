package com.github.L_Ender.cataclysm.client.render.item.CuriosRenderer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.item.CuriosModel.Berserker_Soul_Amulet_Model;
import com.github.L_Ender.cataclysm.client.model.item.CuriosModel.Blazing_Grips_Model;
import com.github.L_Ender.cataclysm.client.model.item.CuriosModel.Vitality_Ankh_Model;
import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class Berserker_Soul_Amulet_Renderer implements ICurioRenderer {
    private final Berserker_Soul_Amulet_Model model;
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/curiositem/berserker_soul_amulet.png");
    private static final ResourceLocation TEXTURE_LAYER = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/curiositem/berserker_soul_amulet_layer.png");

    public Berserker_Soul_Amulet_Renderer() {
        this.model = new Berserker_Soul_Amulet_Model(Minecraft.getInstance().getEntityModels().bakeLayer(CMModelLayers.BERSERKER_SOUL_AMULET_MODEL));
    }


    public ResourceLocation getCuriosTexture() {
        return TEXTURE;
    }

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource buffer, int packedLight, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        model.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        model.prepareMobModel(slotContext.entity(), limbSwing, limbSwingAmount, partialTicks);
        ICurioRenderer.followBodyRotations(slotContext.entity(), model);

        renderArm(model, poseStack, buffer, packedLight, stack.hasFoil());
    }

    protected void renderArm(Berserker_Soul_Amulet_Model model, PoseStack matrixStack, MultiBufferSource buffer, int light, boolean hasFoil) {
        RenderType renderType = model.renderType(getCuriosTexture());
        VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer(buffer, renderType, false, hasFoil);
        model.renderToBuffer(matrixStack, vertexBuilder, light, OverlayTexture.NO_OVERLAY);
        VertexConsumer builder = ItemRenderer.getFoilBuffer(buffer, CMRenderTypes.CMEyes(TEXTURE_LAYER), false, hasFoil);
        model.renderToBuffer(matrixStack, builder, LightTexture.pack(15, 15), OverlayTexture.NO_OVERLAY);

    }
}
