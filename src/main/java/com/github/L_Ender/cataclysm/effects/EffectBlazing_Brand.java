package com.github.L_Ender.cataclysm.effects;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectBlazing_Brand extends MobEffect {

    public EffectBlazing_Brand() {
        super(MobEffectCategory.HARMFUL, 0xDC143C);
        this.addAttributeModifier(Attributes.ARMOR, "68078724-8653-42D5-A245-9D14A1F54685", -0.2D, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "B237E76D-15E8-4513-A735-55BB25C33603", -0.2D, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    public void applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {

    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

}
