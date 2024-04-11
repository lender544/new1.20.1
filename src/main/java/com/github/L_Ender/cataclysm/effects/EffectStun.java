package com.github.L_Ender.cataclysm.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectStun extends MobEffect {

    public EffectStun() {
        super(MobEffectCategory.HARMFUL, 0xFF8C00);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "57F1BADC-F545-4D89-B218-751C2FF8053D", -0.5D, AttributeModifier.Operation.ADDITION);

    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {

    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

}
