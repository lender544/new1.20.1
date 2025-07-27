package com.github.L_Ender.cataclysm.effects;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.WaterFluid;

public class EffectWetness extends MobEffect {

    private static final ResourceLocation WETNESS_SPEED =  ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"wetness_speed");

    public EffectWetness() {
        super(MobEffectCategory.HARMFUL, 0X5a76ce);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, WETNESS_SPEED, -0.05D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (LivingEntityIn.isSensitiveToWater()) {
            LivingEntityIn.hurt(LivingEntityIn.damageSources().magic(), 1.0F);
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int p_295391_, int p_294280_) {
        return true;
    }

}
