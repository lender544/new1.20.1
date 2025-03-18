package com.github.L_Ender.cataclysm.entity.AnimationMonster.AI;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class AdvancedHurtByTargetGoal extends HurtByTargetGoal {
    private int forcedAggroTime;
    private float intensity;

    public AdvancedHurtByTargetGoal(PathfinderMob mob, Class<?>... ToIgnoreDamage) {
        super(mob, ToIgnoreDamage);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.timestamp != this.mob.getLastHurtByMobTimestamp()) {
            this.timestamp = this.mob.getLastHurtByMobTimestamp();
            if (mob.getLastHurtByMob() != targetMob) {
                forcedAggroTime -= 20;
            } else {
                forcedAggroTime += (int) (20 * intensity);
                intensity *= 0.8f;
            }
        }
    }

    @Override
    public void start() {
        super.start();
        this.forcedAggroTime = 40 + this.mob.getRandom().nextInt(140);
        intensity = 1f;
    }

    @Override
    public boolean canContinueToUse() {
        return --forcedAggroTime > 0 && super.canContinueToUse();
    }
}
