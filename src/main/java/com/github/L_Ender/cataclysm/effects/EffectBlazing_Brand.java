package com.github.L_Ender.cataclysm.effects;


import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectBlazing_Brand extends MobEffect {

    private static final ResourceLocation ARMOR_DOWN_ID =  ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"blazing_brand_armor");
    private static final ResourceLocation ARMOR_TOUGHNESS_DOWN_ID =  ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"blazing_brand_armor_toughness");
    public EffectBlazing_Brand() {
        super(MobEffectCategory.HARMFUL, 0xDC143C);
        this.addAttributeModifier(Attributes.ARMOR, ARMOR_DOWN_ID, -0.2D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ARMOR_TOUGHNESS_DOWN_ID, -0.2D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {

        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }

}
