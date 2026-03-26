package com.github.L_Ender.cataclysm.effects;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModAttribute;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

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
