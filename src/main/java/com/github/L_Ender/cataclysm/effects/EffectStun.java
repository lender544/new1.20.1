package com.github.L_Ender.cataclysm.effects;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectStun extends MobEffect {

    private static final ResourceLocation STUN_SPEED =  ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"stun_speed");

    public EffectStun() {
        super(MobEffectCategory.HARMFUL, 0xFF8C00);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, STUN_SPEED, -0.5D, AttributeModifier.Operation.ADD_VALUE);

    }

    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }

}
