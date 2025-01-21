package com.github.L_Ender.cataclysm.effects;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectGhostForm extends MobEffect {

    private int lastDuration = -1;
    private static final ResourceLocation GHOST_SPEED =  ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ghost_speed");

    public EffectGhostForm() {
        super(MobEffectCategory.BENEFICIAL, 0x39d2b2);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, GHOST_SPEED, 0.4D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (lastDuration == 1) {
            LivingEntityIn.addEffect(new MobEffectInstance(ModEffect.EFFECTGHOST_SICKNESS, 7200, 0,false,false,true));
        }
        return true;
    }



    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int p_295734_) {
        lastDuration = duration;
        return duration > 0;
    }

}
