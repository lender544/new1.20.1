package com.github.L_Ender.cataclysm.client.render.etc;

import com.github.L_Ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.blocks.Cataclysm_Wall_Skull_Block;
import com.github.L_Ender.cataclysm.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

import java.util.Map;

public class CurioHeadRenderer implements ICurioRenderer {
    private Map<Cataclysm_Skull_Block.Type, SkullModelBase> skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (renderLayerParent.getModel() instanceof HeadedModel headModel) {
            Item item = stack.getItem();
            if (!stack.isEmpty() && item instanceof BlockItem) {
                Block block = ((BlockItem) item).getBlock();
                if (block instanceof Cataclysm_Skull_Block || block instanceof Cataclysm_Wall_Skull_Block) {

                    matrixStack.pushPose();

                    headModel.getHead().translateAndRotate(matrixStack);
                    matrixStack.scale(1.1875F, -1.1875F, -1.1875F);
                    matrixStack.translate(-0.5D, 0.0D, -0.5D);

                    Cataclysm_Skull_Block.Type type = block instanceof Cataclysm_Skull_Block ? ((Cataclysm_Skull_Block) block).getType() : ((Cataclysm_Wall_Skull_Block) block).getType();
                    SkullModelBase skullmodelbase = this.skullModels.get(type);
                    RenderType rendertype = Cataclysm_Skull_Block_Renderer.getRenderType(type);
                    Entity entity = slotContext.entity().getVehicle();
                    WalkAnimationState walkanimationstate;
                    if (entity instanceof LivingEntity livingEntity) {
                        walkanimationstate = livingEntity.walkAnimation;
                    } else walkanimationstate = slotContext.entity().walkAnimation;
                    float f3 = walkanimationstate.position(partialTicks);
                    Cataclysm_Skull_Block_Renderer.renderSkull(null, 180.0F, f3, matrixStack, renderTypeBuffer, light, skullmodelbase, rendertype, type, true);

                    matrixStack.popPose();

                }
            }
        }
    }
}
