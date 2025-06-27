package com.github.L_Ender.cataclysm.effects;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectWetness extends MobEffect {


    public EffectWetness() {
        super(MobEffectCategory.HARMFUL, 0X5a76ce);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "720B6A7D-41DF-4063-BB4B-6900CB132840", -0.05D, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    public void applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (LivingEntityIn.isSensitiveToWater()) {
            LivingEntityIn.hurt(LivingEntityIn.damageSources().magic(), 1.0F);
        }
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

}
