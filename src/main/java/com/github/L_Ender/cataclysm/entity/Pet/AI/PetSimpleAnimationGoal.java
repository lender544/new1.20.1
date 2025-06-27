package com.github.L_Ender.cataclysm.entity.Pet.AI;

import com.github.L_Ender.cataclysm.entity.Pet.AnimationPet;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;

import java.util.EnumSet;

public class PetSimpleAnimationGoal<T extends AnimationPet & IAnimatedEntity> extends PetAnimationGoal<T> {

    private final Animation animation;

    public PetSimpleAnimationGoal(T entity, Animation animation) {
        super(entity);
        this.animation = animation;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
    }

    @Override
    protected boolean test(Animation animation) {
        return animation == this.animation;
    }


}