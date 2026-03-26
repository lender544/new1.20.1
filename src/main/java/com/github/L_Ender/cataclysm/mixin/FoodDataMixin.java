package com.github.L_Ender.cataclysm.mixin;

import com.github.L_Ender.cataclysm.init.ModAttribute;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;

@Mixin(FoodData.class)
public abstract class FoodDataMixin {

    @WrapOperation(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/player/Player;heal(F)V"
            )
    )
    private void wrapHeal(Player player, float amount, Operation<Void> original) {
        float healAttrValue = (float) player.getAttributeValue(ModAttribute.NATURE_HEAL.get());
        float healMultiplier = 1.0F + (healAttrValue / 100.0F);

        healMultiplier = Math.max(0.0F, healMultiplier);
        original.call(player, amount * healMultiplier);
    }
}
