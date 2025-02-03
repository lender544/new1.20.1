package com.github.L_Ender.cataclysm.effects;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectMonstrous extends MobEffect {

    private static final ResourceLocation MONSTROUS_KNOCKBACK =  ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrous_knockback");
    private static final ResourceLocation MONSTROUS_ARMOR =  ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrous_armor");
    private static final ResourceLocation MONSTROUS_ARMOR_TOUGHNESS =  ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrous_armor_toughness");

    public EffectMonstrous() {
        super(MobEffectCategory.BENEFICIAL, 0X865337);
        this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, MONSTROUS_KNOCKBACK, 0.5D, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ARMOR, MONSTROUS_ARMOR, 3.0D, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, MONSTROUS_ARMOR_TOUGHNESS, 2.0D, AttributeModifier.Operation.ADD_VALUE);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (LivingEntityIn.getHealth() < LivingEntityIn.getMaxHealth() * 1/2) {
            LivingEntityIn.heal(1.0F);
        }

        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int k = 50 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

}
