package com.github.L_Ender.cataclysm.entity.Pet.AI;

import com.github.L_Ender.cataclysm.entity.Pet.AnimationPet;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public abstract class PetAnimationGoal<T extends AnimationPet & IAnimatedEntity> extends Goal {
    protected final T entity;

    protected PetAnimationGoal(T entity) {
        this(entity, true);
    }

    protected PetAnimationGoal(T entity, boolean interruptsAI) {
        this.entity = entity;
        if (interruptsAI) this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
    }

    @Override
    public boolean canUse() {
        return this.test(this.entity.getAnimation());
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    //@Override
    //public boolean canContinueToUse() {
    //    return this.test(this.entity.getAnimation()) && this.entity.getAnimationTick() < this.entity.getAnimation().getDuration();
    //}

    protected abstract boolean test(Animation animation);
}