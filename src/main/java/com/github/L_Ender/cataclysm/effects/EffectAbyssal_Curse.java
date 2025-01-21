package com.github.L_Ender.cataclysm.effects;


import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class EffectAbyssal_Curse extends MobEffect {

    public EffectAbyssal_Curse() {
        super(MobEffectCategory.HARMFUL, 0x8a3eff);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        LivingEntityIn.hurt(LivingEntityIn.damageSources().source(CMDamageTypes.ABYSSAL_BURN), 1.0F);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int p_295629_, int p_295734_) {
        int i = 40 >> p_295734_;
        return i > 0 ? p_295629_ % i == 0 : true;
    }
}
