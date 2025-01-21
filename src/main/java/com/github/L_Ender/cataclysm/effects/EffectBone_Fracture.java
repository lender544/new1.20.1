package com.github.L_Ender.cataclysm.effects;


import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectBone_Fracture extends MobEffect {

    private static final ResourceLocation BONE_FRACTURE_SPEED = (ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"bone_fracture_speed"));
    private static final ResourceLocation BONE_FRACTURE_ATTACK_SPEED = (ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"bone_fracture_attack_speed"));

    public EffectBone_Fracture() {
        super(MobEffectCategory.HARMFUL, 0xadabad);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, BONE_FRACTURE_SPEED, -0.02D, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ATTACK_SPEED, BONE_FRACTURE_ATTACK_SPEED, -0.15D, AttributeModifier.Operation.ADD_VALUE);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration > 0;
    }

}
