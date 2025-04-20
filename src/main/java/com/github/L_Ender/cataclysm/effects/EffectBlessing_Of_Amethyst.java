package com.github.L_Ender.cataclysm.effects;

import com.github.L_Ender.cataclysm.init.ModEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectBlessing_Of_Amethyst extends MobEffect {

    public EffectBlessing_Of_Amethyst() {
        super(MobEffectCategory.BENEFICIAL, 0xfecbe6);
    }

    public void applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if(LivingEntityIn.hasEffect(ModEffect.EFFECTABYSSAL_BURN.get())){
            LivingEntityIn.removeEffect(ModEffect.EFFECTABYSSAL_BURN.get());
        }
        if(LivingEntityIn.hasEffect(ModEffect.EFFECTABYSSAL_FEAR.get())){
            LivingEntityIn.removeEffect(ModEffect.EFFECTABYSSAL_FEAR.get());
        }
        if(LivingEntityIn.hasEffect(MobEffects.DARKNESS)){
            LivingEntityIn.removeEffect(MobEffects.DARKNESS);
        }
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

}
