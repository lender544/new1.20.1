package com.github.L_Ender.cataclysm.effects;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class EffectCurse_Of_Desert extends MobEffect {

    public EffectCurse_Of_Desert() {
        super(MobEffectCategory.HARMFUL, 0xfff2cb);
    }


    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }
}
