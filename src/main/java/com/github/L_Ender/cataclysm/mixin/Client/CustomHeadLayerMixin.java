package com.github.L_Ender.cataclysm.mixin.Client;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.Abstract_Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.blocks.Cataclysm_Skull_Block;
import com.github.L_Ender.cataclysm.client.model.block.Cataclysm_Skull_Model_Base;
import com.github.L_Ender.cataclysm.client.render.blockentity.Cataclysm_Skull_Block_Renderer;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HeadedModel;
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
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(CustomHeadLayer.class)
public abstract class CustomHeadLayerMixin  extends RenderLayer implements HeadedModel {
    @Unique
    private final Map<Cataclysm_Skull_Block.Type, Cataclysm_Skull_Model_Base> new1_20Modding$skullModels = Cataclysm_Skull_Block_Renderer.createSkullRenderers(Minecraft.getInstance().getEntityModels());

    @Unique
    private final Map<Cataclysm_Skull_Block.Type, ResourceLocation> SKIN_BY_TYPE = Util.make(Maps.newHashMap(), (p_261388_) -> {
        p_261388_.put(Cataclysm_Skull_Block.Types.KOBOLEDIATOR, new ResourceLocation(Cataclysm.MODID,"textures/entity/koboleton/kobolediator.png"));
    });

    public CustomHeadLayerMixin(RenderLayerParent p_117346_) {
        super(p_117346_);
    }

    @Inject(
            method = {"Lnet/minecraft/client/renderer/entity/layers/CustomHeadLayer;render*"},
            at = @At(value = "HEAD"),
            remap = true,
            cancellable = true
    )
    private void cm_headlayer(PoseStack p_116731_, MultiBufferSource p_116732_, int p_116733_, LivingEntity livingEntity, float p_116735_, float p_116736_, float p_116737_, float p_116738_, float p_116739_, float p_116740_, CallbackInfo ci) {
        ItemStack itemstack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        if (!itemstack.isEmpty()) {
            Item item = itemstack.getItem();
            p_116731_.pushPose();
            boolean flag = livingEntity instanceof Villager || livingEntity instanceof ZombieVillager;
            if (item instanceof BlockItem && ((BlockItem)item).getBlock() instanceof Abstract_Cataclysm_Skull_Block) {
                float f2 = 1.1875F;
                p_116731_.scale(1.1875F, -1.1875F, -1.1875F);
                if (flag) {
                    p_116731_.translate(0.0F, 0.0625F, 0.0F);
                }

                p_116731_.translate(-0.5D, 0.0D, -0.5D);
                Cataclysm_Skull_Block.Type skullblock$type = ((Abstract_Cataclysm_Skull_Block)((BlockItem)item).getBlock()).getType();
                Cataclysm_Skull_Model_Base skullmodelbase = this.new1_20Modding$skullModels.get(skullblock$type);
                ResourceLocation resourcelocation = SKIN_BY_TYPE.get(skullblock$type);
                RenderType rendertype = RenderType.entityCutoutNoCullZOffset(resourcelocation);
                Entity entity = livingEntity.getVehicle();
                WalkAnimationState walkanimationstate;
                if (entity instanceof LivingEntity) {
                    LivingEntity livingentity = (LivingEntity)entity;
                    walkanimationstate = livingentity.walkAnimation;
                } else {
                    walkanimationstate = livingEntity.walkAnimation;
                }

                float f3 = walkanimationstate.position(p_116737_);
                Cataclysm_Skull_Block_Renderer.renderSkull((Direction)null, 180.0F, f3, p_116731_, p_116732_, p_116733_, skullmodelbase, rendertype);
            }
            p_116731_.popPose();
        }
    }
}
