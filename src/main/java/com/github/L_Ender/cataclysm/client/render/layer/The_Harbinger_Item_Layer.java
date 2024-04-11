package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.ModelThe_Harbinger;
import com.github.L_Ender.cataclysm.client.render.RenderUtils;
import com.github.L_Ender.cataclysm.client.render.entity.RendererThe_Harbinger;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelPart;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class The_Harbinger_Item_Layer extends RenderLayer<The_Harbinger_Entity, ModelThe_Harbinger> {
    private AdvancedModelPart AdvancedModelPart;
    private ItemStack itemstack;
    private ItemDisplayContext transformType;

    public The_Harbinger_Item_Layer(RendererThe_Harbinger renderIn, AdvancedModelPart AdvancedModelPart, ItemStack itemstack, ItemDisplayContext transformType) {
        super(renderIn);
        this.itemstack = itemstack;
        this.AdvancedModelPart = AdvancedModelPart;
        this.transformType = transformType;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getIsAct()) {
            matrixStackIn.pushPose();
            RenderUtils.matrixStackFromCitadelModel(matrixStackIn, getAdvancedModelPart());
            matrixStackIn.translate(-0.0125F, 0.0F, 0.0F);
            Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer().renderItem(entity, getItemstack(), transformType, false, matrixStackIn, bufferIn, packedLightIn);
            matrixStackIn.popPose();
        }
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
