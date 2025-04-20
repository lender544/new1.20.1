package com.github.L_Ender.cataclysm.effects;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class EffectCurse_Of_Desert extends MobEffect {

    public EffectCurse_Of_Desert() {
        super(MobEffectCategory.HARMFUL, 0xfff2cb);
    }

    public void applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {

    }


    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

}
