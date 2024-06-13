package com.github.L_Ender.cataclysm.effects;

import com.github.L_Ender.cataclysm.init.ModEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectPhantomForm extends MobEffect {

    private int lastDuration = -1;

    public EffectPhantomForm() {
        super(MobEffectCategory.BENEFICIAL, 0x39d2b2);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "FBF4116E-056E-4420-865B-C098705DDAB2", 0.4D, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    public void applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (lastDuration == 1) {
            LivingEntityIn.addEffect(new MobEffectInstance(ModEffect.EFFECTRESURRECTION_SICKNESS.get(), 7200, 0,false,false,true));
        }
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        lastDuration = duration;
        return duration > 0;
    }

}
