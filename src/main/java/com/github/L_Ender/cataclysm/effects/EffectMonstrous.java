package com.github.L_Ender.cataclysm.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectMonstrous extends MobEffect {

    public EffectMonstrous() {
        super(MobEffectCategory.BENEFICIAL, 0X865337);
        this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "953533ED-0994-4421-9E4E-47557FA8EE2A", 0.5D, AttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(Attributes.ARMOR, "E6C06C84-8021-4296-A512-AFB0C98806CA", 3.0D, AttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "1F329CAC-F59E-41C1-A5E6-18A45A3237B8", 2.0D, AttributeModifier.Operation.ADDITION);
    }

    public void applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (LivingEntityIn.getHealth() < LivingEntityIn.getMaxHealth() * 1/2) {
            LivingEntityIn.heal(1.0F);
        }

    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

}
