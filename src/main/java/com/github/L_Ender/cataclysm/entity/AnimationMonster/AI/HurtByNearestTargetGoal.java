package com.github.L_Ender.cataclysm.entity.AnimationMonster.AI;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class HurtByNearestTargetGoal extends HurtByTargetGoal {
    public HurtByNearestTargetGoal(PathfinderMob creatureIn, Class<?>... excludeReinforcementTypes) {
        super(creatureIn, excludeReinforcementTypes);
    }

    public boolean canUse() {
        if (!super.canUse()) {
            LivingEntity lastTarget = this.mob.getLastHurtMob();
            if (lastTarget != null && this.mob.getLastHurtByMob() == null) {
                this.mob.setLastHurtByMob(lastTarget);
            }

            return false;
        } else {
            return true;
        }
    }

    public boolean canContinueToUse() {
        if (!super.canContinueToUse()) {
            return false;
        } else {
            LivingEntity revengeTarget = this.mob.getLastHurtByMob();
            if (super.canUse() && revengeTarget != this.targetMob && targetMob !=null && revengeTarget !=null && this.mob.distanceToSqr(revengeTarget) < this.mob.distanceToSqr(this.targetMob)) {
                this.mob.setLastHurtMob(this.targetMob);
                return false;
            } else {
                return true;
            }
        }
    }

}
