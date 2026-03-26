package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

public class InternalMoveGoal extends Goal {
    private final Internal_Animation_Monster monster;
    private final boolean followingTargetEvenIfNotSeen;
    private Path path;
    private int delayCounter;
    protected final double moveSpeed;


    public InternalMoveGoal(Internal_Animation_Monster boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
        this.monster = boss;
        this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
        this.moveSpeed = moveSpeed;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }


    public boolean canUse() {
        LivingEntity target = this.monster.getTarget();
        return target != null && target.isAlive();
    }


    public void stop() {
        this.monster.getNavigation().stop();
        LivingEntity livingentity = this.monster.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
            this.monster.setTarget((LivingEntity) null);
        }
        this.monster.setAggressive(false);
    }

    public boolean canContinueToUse() {
        LivingEntity target = this.monster.getTarget();
        if (target == null) {
            return false;
        } else if (!target.isAlive()) {
            return false;
        } else if (!this.followingTargetEvenIfNotSeen) {
            return !this.monster.getNavigation().isDone();
        } else if (!this.monster.isWithinRestriction(target.blockPosition())) {
            return false;
        } else {
            return !(target instanceof Player) || !target.isSpectator() && !((Player) target).isCreative();
        }
    }

    public void start() {
        this.monster.getNavigation().moveTo(this.path, this.moveSpeed);
        this.monster.setAggressive(true);
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity target = this.monster.getTarget();
        if (target != null) {
            monster.getLookControl().setLookAt(target, 30.0F, 30.0F);
            double distSq = this.monster.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
            if (--this.delayCounter <= 0) {
                this.delayCounter = 4 + this.monster.getRandom().nextInt(7);
                if (distSq > Math.pow(this.monster.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0D)) {
                    if (!this.monster.isPathFinding()) {
                        if (!this.monster.getNavigation().moveTo(target, 1.0D)) {
                            this.delayCounter += 5;
                        }
                    }
                } else {
                    this.monster.getNavigation().moveTo(target, this.moveSpeed);
                }
            }
        }
    }
}
