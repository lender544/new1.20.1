package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.The_Harbinger_Model;
import com.github.L_Ender.cataclysm.client.render.RenderUtils;
import com.github.L_Ender.cataclysm.client.render.entity.The_Harbinger_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class The_Harbinger_Item_Layer extends RenderLayer<The_Harbinger_Entity, The_Harbinger_Model> {
    private AdvancedModelBox AdvancedModelBox;
    private ItemStack itemstack;
    private ItemDisplayContext transformType;

    public The_Harbinger_Item_Layer(The_Harbinger_Renderer renderIn, AdvancedModelBox AdvancedModelBox, ItemStack itemstack, ItemDisplayContext transformType) {
        super(renderIn);
        this.itemstack = itemstack;
        this.AdvancedModelBox = AdvancedModelBox;
        this.transformType = transformType;
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, The_Harbinger_Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.getIsAct()) {
            matrixStackIn.pushPose();
            RenderUtils.matrixStackFromCitadelModel(matrixStackIn, getAdvancedModelBox());
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

    public AdvancedModelBox getAdvancedModelBox() {
        return AdvancedModelBox;
    }

    public void setAdvancedModelBox(AdvancedModelBox AdvancedModelBox) {
        this.AdvancedModelBox = AdvancedModelBox;
    }
}
