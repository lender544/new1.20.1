package com.github.L_Ender.cataclysm.effects;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectBone_Fracture extends MobEffect {

    public EffectBone_Fracture() {
        super(MobEffectCategory.HARMFUL, 0xadabad);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "AEB87FD5-A4E9-4BA8-A52C-38BBE582D491", -0.02D, AttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(Attributes.ATTACK_SPEED, "804053B1-7703-4E67-AB0E-FC53D5A2CE10", -0.15D, AttributeModifier.Operation.ADDITION);
    }

    public void applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {

    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

}
