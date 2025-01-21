package com.github.L_Ender.cataclysm.entity.Pet.AI;

import com.github.L_Ender.cataclysm.entity.Pet.AnimationPet;
import com.github.L_Ender.cataclysm.entity.etc.IFollower;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.PathfindingContext;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

import java.util.EnumSet;

public class TameableAIFollowOwnerWater extends Goal {
    private final AnimationPet tameable;
    private final LevelReader world;
    private final double followSpeed;
    private final float maxDist;
    private final float minDist;
    private final boolean teleportToLeaves;
    private LivingEntity owner;
    private int timeToRecalcPath;
    private float oldWaterCost;

    public TameableAIFollowOwnerWater(AnimationPet tamed, double speed, float minDist, float maxDist, boolean leaves) {
        this.tameable = tamed;
        this.world = tamed.level();
        this.followSpeed = speed;
        this.minDist = minDist;
        this.maxDist = maxDist;
        this.teleportToLeaves = leaves;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    public boolean canUse() {
        LivingEntity lvt_1_1_ = this.tameable.getOwner();
        if (lvt_1_1_ == null) {
            return false;
        } else if (lvt_1_1_.isSpectator()) {
            return false;
        } else if (!((IFollower)this.tameable).shouldFollow() || isInCombat()) {
            return false;
        } else if (this.tameable.distanceToSqr(lvt_1_1_) < (double) (this.minDist * this.minDist)) {
            return false;
        } else if (this.tameable.getTarget() != null && this.tameable.getTarget().isAlive()) {
            return false;
        } else {
            this.owner = lvt_1_1_;
            return true;
        }
    }

    public boolean canContinueToUse() {
        if (this.tameable.getNavigation().isDone() || isInCombat()) {
            return false;
        } else if (!((IFollower)this.tameable).shouldFollow()) {
            return false;
        } else if (this.tameable.getTarget() != null && this.tameable.getTarget().isAlive()) {
            return false;
        } else {
            return this.tameable.distanceToSqr(this.owner) > (double) (this.maxDist * this.maxDist);
        }
    }

    private boolean isInCombat() {
        Entity owner = tameable.getOwner();
        if(owner != null){
            return tameable.distanceTo(owner) < 30 && tameable.getTarget() != null && tameable.getTarget().isAlive();
        }
        return false;
    }

    public void start() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.tameable.getPathfindingMalus(PathType.WATER);
        this.tameable.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    public void stop() {
        this.owner = null;
        this.tameable.getNavigation().stop();
        this.tameable.setPathfindingMalus(PathType.WATER, this.oldWaterCost);
    }

    public void tick() {

        this.tameable.getLookControl().setLookAt(this.owner, 10.0F, (float) this.tameable.getMaxHeadXRot());
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = 10;
            if (!this.tameable.isLeashed() && !this.tameable.isPassenger()) {
                if (this.tameable.distanceToSqr(this.owner) >= 144.0D) {
                    this.tryToTeleportNearEntity();
                } else {
                    this.tameable.getNavigation().moveTo(this.owner, this.followSpeed);
                }

            }
        }
    }

    private void tryToTeleportNearEntity() {
        BlockPos lvt_1_1_ = this.owner.blockPosition();

        for (int lvt_2_1_ = 0; lvt_2_1_ < 10; ++lvt_2_1_) {
            int lvt_3_1_ = this.getRandomNumber(-3, 3);
            int lvt_4_1_ = this.getRandomNumber(-1, 1);
            int lvt_5_1_ = this.getRandomNumber(-3, 3);
            boolean lvt_6_1_ = this.tryToTeleportToLocation(lvt_1_1_.getX() + lvt_3_1_, lvt_1_1_.getY() + lvt_4_1_, lvt_1_1_.getZ() + lvt_5_1_);
            if (lvt_6_1_) {
                return;
            }
        }

    }

    private boolean tryToTeleportToLocation(int p_226328_1_, int p_226328_2_, int p_226328_3_) {
        if (Math.abs((double) p_226328_1_ - this.owner.getX()) < 2.0D && Math.abs((double) p_226328_3_ - this.owner.getZ()) < 2.0D) {
            return false;
        } else if (!this.isTeleportFriendlyBlock(new BlockPos(p_226328_1_, p_226328_2_, p_226328_3_))) {
            return false;
        } else {
            this.tameable.moveTo((double) p_226328_1_ + 0.5D, p_226328_2_, (double) p_226328_3_ + 0.5D, this.tameable.getYRot(), this.tameable.getXRot());
            this.tameable.getNavigation().stop();
            return true;
        }
    }

    private boolean isTeleportFriendlyBlock(BlockPos pos) {
        PathfindingContext pathfindingcontext = new PathfindingContext(this.world, this.tameable);
        PathType blockPathType = WalkNodeEvaluator.getPathTypeStatic(pathfindingcontext, pos.mutable());
        if (world.getFluidState(pos).is(FluidTags.WATER) || !world.getFluidState(pos).is(FluidTags.WATER) && world.getFluidState(pos.below()).is(FluidTags.WATER)) {
            return true;
        }
        if (blockPathType != PathType.WALKABLE || avoidsLand()) {
            return false;
        } else {
            BlockState lvt_3_1_ = this.world.getBlockState(pos.below());
            if (!this.teleportToLeaves && lvt_3_1_.getBlock() instanceof LeavesBlock) {
                return false;
            } else {
                BlockPos lvt_4_1_ = pos.subtract(this.tameable.blockPosition());
                return this.world.noCollision(this.tameable, this.tameable.getBoundingBox().move(lvt_4_1_));
            }
        }
    }

    public boolean avoidsLand() {
        return false;
    }

    private int getRandomNumber(int p_226327_1_, int p_226327_2_) {
        return this.tameable.getRandom().nextInt(p_226327_2_ - p_226327_1_ + 1) + p_226327_1_;
    }
}
