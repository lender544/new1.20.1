package com.github.L_Ender.cataclysm.entity.AnimationMonster;


import com.github.L_Ender.cataclysm.entity.etc.Animation_Monsters;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class LLibrary_Monster extends Animation_Monsters implements IAnimatedEntity, Enemy {
    public int animationTick;
    public Animation currentAnimation;


    public LLibrary_Monster(EntityType entity, Level world) {
        super(entity, world);
    }


    @Override
    public void tick() {
        super.tick();
        AnimationHandler.INSTANCE.updateAnimations(this);
    }

    protected void onDeathAIUpdate() {}

    @Override
    protected void tickDeath() {
        if (this.getAnimation() != getDeathAnimation()) {
            AnimationHandler.INSTANCE.sendAnimationMessage(this, getDeathAnimation());
        }
        Animation death;
        if ((death = getDeathAnimation()) != null) {
            onDeathUpdate(death.getDuration() - 20);
        } else {
            onDeathUpdate(20);
        }
    }

    protected void onAnimationFinish(Animation animation) {}

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION};
    }

    @Override
    public int getAnimationTick() {
        return animationTick;
    }


    @Override
    public void setAnimationTick(int tick) {
        animationTick = tick;
    }

    @Override
    public Animation getAnimation() {
        return this.currentAnimation;
    }


    @Override
    public void setAnimation(Animation animation) {
        if (animation == NO_ANIMATION) {
            onAnimationFinish(this.currentAnimation);
        }
        this.currentAnimation = animation;
        setAnimationTick(0);
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return null;
    }
}
