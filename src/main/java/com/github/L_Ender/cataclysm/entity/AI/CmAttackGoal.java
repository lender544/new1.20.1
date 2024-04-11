package com.github.L_Ender.cataclysm.entity.AI;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class CmAttackGoal extends MeleeAttackGoal {
    private LivingEntity target;
    private int delayCounter;
    protected final double moveSpeed;



    public CmAttackGoal(PathfinderMob creatureEntity, double moveSpeed) {
        super(creatureEntity, moveSpeed, true);
        this.moveSpeed = moveSpeed;
    }

    @Override
    public boolean canUse() {
        this.target = this.mob.getTarget();
        return this.target != null && target.isAlive();
    }

    @Override
    public void stop() {
        this.mob.getNavigation().stop();
        if (this.mob.getTarget() == null) {
            this.mob.setAggressive(false);
            this.mob.getNavigation().stop();
        }
    }


    @Override
    public void tick() {
        LivingEntity target = this.mob.getTarget();
        if (target == null) {
            return;
        }
        this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
        double distSq = this.mob.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
        if (--this.delayCounter <= 0) {
            this.delayCounter = 4 + this.mob.getRandom().nextInt(7);
            if (distSq > Math.pow(this.mob.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0D)) {
                if (!this.mob.isPathFinding()) {
                    if (!this.mob.getNavigation().moveTo(target, 1.0D)) {
                        this.delayCounter += 5;
                    }
                }
            } else {
                this.mob.getNavigation().moveTo(target, this.moveSpeed);
            }
        }
    }
}

