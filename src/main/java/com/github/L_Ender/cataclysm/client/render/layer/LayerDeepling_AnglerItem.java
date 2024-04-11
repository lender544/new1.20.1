package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.ModelDeepling_Angler;
import com.github.L_Ender.cataclysm.entity.Deepling.Deepling_Angler_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class LayerDeepling_AnglerItem extends RenderLayer<Deepling_Angler_Entity, ModelDeepling_Angler> {
    private final ItemInHandRenderer itemInHandRenderer;

    public LayerDeepling_AnglerItem(RenderLayerParent p_234846_, ItemInHandRenderer p_234847_) {
        super(p_234846_);
        this.itemInHandRenderer = p_234847_;
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Deepling_Angler_Entity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = entitylivingbaseIn.getItemBySlot(EquipmentSlot.MAINHAND);
        matrixStackIn.pushPose();
        boolean left = entitylivingbaseIn.isLeftHanded();
        matrixStackIn.pushPose();
        translateToHand(matrixStackIn, left);
        matrixStackIn.translate(0F, 1.4225F, -0.1F);
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(-90F));
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(180F));
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        ItemInHandRenderer renderer = Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer();
        renderer.renderItem(entitylivingbaseIn, itemstack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, false, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.popPose();
        matrixStackIn.popPose();

    }

    protected void translateToHand(PoseStack matrixStack, boolean left) {
        this.getParentModel().root.translateRotate(matrixStack);
        this.getParentModel().body.translateRotate(matrixStack);
        if(left){
            this.getParentModel().left_arm.translateRotate(matrixStack);
        }else{
            this.getParentModel().right_arm.translateRotate(matrixStack);
        }
    }
}
