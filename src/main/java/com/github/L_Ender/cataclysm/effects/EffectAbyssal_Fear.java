package com.github.L_Ender.cataclysm.effects;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class EffectAbyssal_Fear extends MobEffect {

    public EffectAbyssal_Fear() {
        super(MobEffectCategory.HARMFUL, 0x741aff);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {

        return true;
    }


    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }

}
