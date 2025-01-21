package com.github.L_Ender.cataclysm.entity.Pet;


import com.github.L_Ender.cataclysm.entity.etc.IFollower;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class LLibraryAnimationPet extends AnimationPet implements IAnimatedEntity, IFollower {
    private int animationTick;
    private Animation currentAnimation;

    public LLibraryAnimationPet(EntityType entity, Level world) {
        super(entity, world);

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


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }


}
