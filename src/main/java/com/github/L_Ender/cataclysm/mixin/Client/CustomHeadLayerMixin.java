package com.github.L_Ender.cataclysm.mixin.Client;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.Abstract_Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.blocks.Wall_Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.client.model.block.Cataclysm_Skull_Model_Base;
import com.github.L_Ender.cataclysm.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(CustomHeadLayer.class)
public abstract class CustomHeadLayerMixin<T extends LivingEntity, M extends EntityModel<T> & HeadedModel> extends RenderLayer<T, M> {
    @Shadow
    @Final
    private float scaleX;
    @Shadow @Final private float scaleY;
    @Shadow @Final private float scaleZ;
    @Unique private Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> headModelBaseMap;

    public CustomHeadLayerMixin(RenderLayerParent<T, M> p_117346_) {
        super(p_117346_);
    }

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/RenderLayerParent;Lnet/minecraft/client/model/geom/EntityModelSet;FFFLnet/minecraft/client/renderer/ItemInHandRenderer;)V")
    private void renderCataclysmHeads(RenderLayerParent p_234822_, EntityModelSet p_234823_, float p_234824_, float p_234825_, float p_234826_, ItemInHandRenderer p_234827_, CallbackInfo ci) {
        this.headModelBaseMap = Cataclysm_Skull_Block_Renderer.createSkullRenderers(p_234823_);
    }

    @Inject(at = @At("HEAD"), method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V", cancellable = true)
    private void renderCataclysmHeads(PoseStack poseStack, MultiBufferSource bufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5, CallbackInfo ci) {
        ItemStack itemstack = t.getItemBySlot(EquipmentSlot.HEAD);
        Item item = itemstack.getItem();
        if (!itemstack.isEmpty() && item instanceof BlockItem) {
            Block block = ((BlockItem)item).getBlock();
            if (block instanceof Cataclysm_Skull_Block || block instanceof Wall_Cataclysm_Skull_Block) {
                ci.cancel();
                poseStack.pushPose();
                poseStack.scale(this.scaleX, this.scaleY, this.scaleZ);
                boolean flag = t instanceof Villager || t instanceof ZombieVillager;
                if (t.isBaby() && !(t instanceof Villager)) {
                    poseStack.translate(0.0F, 0.03125F, 0.0F);
                    poseStack.scale(0.7F, 0.7F, 0.7F);
                    poseStack.translate(0.0F, 1.0F, 0.0F);
                }

                this.getParentModel().getHead().translateAndRotate(poseStack);
                poseStack.scale(1.1875F, -1.1875F, -1.1875F);
                if (flag) {
                    poseStack.translate(0.0F, 0.0625F, 0.0F);
                }
                poseStack.translate(-0.5D, 0.0D, -0.5D);

                Cataclysm_Skull_Block.Type type = block instanceof Cataclysm_Skull_Block ? ((Cataclysm_Skull_Block)block).getType() : ((Wall_Cataclysm_Skull_Block)block).getType();
                Cataclysm_Skull_Model_Base skullmodelbase = this.headModelBaseMap.get(type);
                RenderType rendertype = Cataclysm_Skull_Block_Renderer.getRenderType(type);
                Entity entity = t.getVehicle();
                WalkAnimationState walkanimationstate;
                if (entity instanceof LivingEntity livingEntity) {
                    walkanimationstate = livingEntity.walkAnimation;
                } else walkanimationstate = t.walkAnimation;
                float f3 = walkanimationstate.position(v2);
                Cataclysm_Skull_Block_Renderer.renderSkull(null, 180.0F, f3, poseStack, bufferSource, i, skullmodelbase, rendertype, type, true);

                poseStack.popPose();
            }
        }

    }

}
