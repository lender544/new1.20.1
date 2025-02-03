package com.github.L_Ender.cataclysm.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.EffectCure;

import java.util.Set;

public class EffectGhost_Sickness extends MobEffect {

    public EffectGhost_Sickness() {
        super(MobEffectCategory.HARMFUL, 0x945b31);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

    public Set<EffectCure> getCures() {
        return null;
    }

}
