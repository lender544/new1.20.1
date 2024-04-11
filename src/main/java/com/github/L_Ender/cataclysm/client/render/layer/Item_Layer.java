package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.render.RenderUtils;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class Item_Layer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private AdvancedModelPart AdvancedModelPart;
    private ItemStack itemstack;
    private ItemDisplayContext transformType;

    public Item_Layer(RenderLayerParent<T, M> renderer, AdvancedModelPart AdvancedModelPart, ItemStack itemstack, ItemDisplayContext transformType) {
        super(renderer);
        this.itemstack = itemstack;
        this.AdvancedModelPart = AdvancedModelPart;
        this.transformType = transformType;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!AdvancedModelPart.showModel) return;
        matrixStackIn.pushPose();
        RenderUtils.matrixStackFromCitadelModel(matrixStackIn, getAdvancedModelPart());
        Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().renderItem(entitylivingbaseIn, getItemstack(), transformType, false, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.popPose();
    }

    public ItemStack getItemstack() {
        return itemstack;
    }

    public void setItemstack(ItemStack itemstack) {
        this.itemstack = itemstack;
    }

    public AdvancedModelPart getAdvancedModelPart() {
        return AdvancedModelPart;
    }

    public void setAdvancedModelPart(AdvancedModelPart AdvancedModelPart) {
        this.AdvancedModelPart = AdvancedModelPart;
    }
}
