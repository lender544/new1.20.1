package com.github.L_Ender.cataclysm.entity.Pet.Summoned_Entity;

import com.github.L_Ender.cataclysm.entity.etc.IFollower;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

import java.util.EnumSet;


public class FlyingFollowSummonerGoal extends Goal {
    private final Abstract_Summoned_Entity tameAnimal;
    private LivingEntity owner;
    private final LevelReader world;
    private final double followSpeed;
    private final PathNavigation navigator;
    private int timeToRecalcPath;
    private final float maxDist;
    private final float minDist;
    private float oldWaterCost;
    private final boolean teleportToLeaves;
    private final IFollower follower;

    public FlyingFollowSummonerGoal(Abstract_Summoned_Entity tameAnimal, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
        this.tameAnimal = tameAnimal;
        this.world = tameAnimal.level();
        this.followSpeed = speed;
        this.navigator = tameAnimal.getNavigation();
        this.minDist = minDist;
        this.maxDist = maxDist;
        this.teleportToLeaves = teleportToLeaves;
        follower = (IFollower)tameAnimal;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        LivingEntity livingentity = this.tameAnimal.getOwner();
        if (livingentity == null) {
            return false;
        } else if (livingentity.isSpectator()) {
            return false;
        } else if (this.tameAnimal.distanceToSqr(livingentity) < (double)(this.minDist * this.minDist) || isInCombat()) {
            return false;
        } else {
            this.owner = livingentity;
            return follower.shouldFollow();
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean canContinueToUse() {
        if (isInCombat()) {
            return false;
        } else {
            return this.tameAnimal.distanceToSqr(this.owner) > (double)(this.maxDist * this.maxDist);
        }
    }

    private boolean isInCombat() {
        Entity owner = tameAnimal.getOwner();
        if(owner != null){
            return tameAnimal.distanceTo(owner) < 30 && tameAnimal.getTarget() != null && tameAnimal.getTarget().isAlive();
        }
        return false;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void start() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.tameAnimal.getPathfindingMalus(PathType.WATER);
        this.tameAnimal.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void stop() {
        this.owner = null;
        this.navigator.stop();
        this.tameAnimal.setPathfindingMalus(PathType.WATER, this.oldWaterCost);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        this.tameAnimal.getLookControl().setLookAt(this.owner, 10.0F, (float)this.tameAnimal.getMaxHeadXRot());
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = 10;
            if (!this.tameAnimal.isLeashed() && !this.tameAnimal.isPassenger()) {
                if (this.tameAnimal.distanceToSqr(this.owner) >= 144.0D) {
                    this.tryToTeleportNearEntity();
                }
                follower.followEntity(tameAnimal, owner, followSpeed);
            }
        }
    }

    private void tryToTeleportNearEntity() {
        BlockPos blockpos = this.owner.blockPosition();

        for(int i = 0; i < 10; ++i) {
            int j = this.getRandomNumber(-3, 3);
            int k = this.getRandomNumber(-1, 1);
            int l = this.getRandomNumber(-3, 3);
            boolean flag = this.tryToTeleportToLocation(blockpos.getX() + j, blockpos.getY() + k, blockpos.getZ() + l);
            if (flag) {
                return;
            }
        }

    }

    private boolean tryToTeleportToLocation(int x, int y, int z) {
        if (Math.abs((double)x - this.owner.getX()) < 2.0D && Math.abs((double)z - this.owner.getZ()) < 2.0D) {
            return false;
        } else if (!this.isTeleportFriendlyBlock(new BlockPos(x, y, z))) {
            return false;
        } else {
            this.tameAnimal.moveTo((double)x + 0.5D, (double)y, (double)z + 0.5D, this.tameAnimal.getYRot(), this.tameAnimal.getXRot());
            this.navigator.stop();
            return true;
        }
    }

    private boolean isTeleportFriendlyBlock(BlockPos pos) {
        if(this.world.getBlockState(pos).isAir()){
            BlockPos blockpos = pos.subtract(this.tameAnimal.blockPosition());
            return this.world.noCollision(this.tameAnimal, this.tameAnimal.getBoundingBox().move(blockpos));
        }
        PathType pathnodetype = WalkNodeEvaluator.getPathTypeStatic(this.tameAnimal, pos);
        if (pathnodetype != PathType.WALKABLE) {
            return false;
        } else {
            BlockState blockstate = this.world.getBlockState(pos.below());
            if (!this.teleportToLeaves && blockstate.getBlock() instanceof LeavesBlock) {
                return false;
            } else {
                BlockPos blockpos = pos.subtract(this.tameAnimal.blockPosition());
                return this.world.noCollision(this.tameAnimal, this.tameAnimal.getBoundingBox().move(blockpos));
            }
        }
    }

    private int getRandomNumber(int min, int max) {
        return this.tameAnimal.getRandom().nextInt(max - min + 1) + min;
    }
}
