package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Goals;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Elite_Draugr_Entity;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;

public class Elite_DraugrAttackGoal extends Goal {
    public static final UniformInt PATHFINDING_DELAY_RANGE = TimeUtil.rangeOfSeconds(1, 2);
    private final Elite_Draugr_Entity mob;
    private final double speedModifier;
    private final float attackRadiusSqr;
    private int seeTime;
    private int updatePathDelay;
    private final boolean followingTargetEvenIfNotSeen;
    private Path path;
    private double pathedTargetX;
    private double pathedTargetY;
    private double pathedTargetZ;
    private int ticksUntilNextPathRecalculation;
    private int ticksUntilNextAttack;
    private final int attackInterval = 20;
    private long lastCanUseCheck;
    private static final long COOLDOWN_BETWEEN_CAN_USE_CHECKS = 20L;
    private int failedPathFindingPenalty = 0;
    private boolean canPenalize = false;


    public Elite_DraugrAttackGoal(Elite_Draugr_Entity p_25814_, double p_25815_, float p_25816_, boolean p_25554_) {
        this.mob = p_25814_;
        this.speedModifier = p_25815_;
        this.attackRadiusSqr = p_25816_ * p_25816_;
        this.followingTargetEvenIfNotSeen = p_25554_;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        if(this.isHoldingCrossbow()){
            return  true;
        }else{
            long i = this.mob.level().getGameTime();
            if (i - this.lastCanUseCheck < 20L) {
                return false;
            } else {
                this.lastCanUseCheck = i;
                LivingEntity livingentity = this.mob.getTarget();
                if (livingentity == null) {
                    return false;
                } else if (!livingentity.isAlive()) {
                    return false;
                } else {
                    if (canPenalize) {
                        if (--this.ticksUntilNextPathRecalculation <= 0) {
                            this.path = this.mob.getNavigation().createPath(livingentity, 0);
                            this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                            return this.path != null;
                        } else {
                            return true;
                        }
                    }
                    this.path = this.mob.getNavigation().createPath(livingentity, 0);
                    if (this.path != null) {
                        return true;
                    } else {
                        return this.getAttackReachSqr(livingentity) >= this.mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                    }
                }
            }
        }
    }

    private boolean isHoldingCrossbow() {
        return this.mob.isHolding(is -> is.getItem() instanceof CrossbowItem);
    }

    public boolean canContinueToUse() {
        LivingEntity livingentity = this.mob.getTarget();
        if(this.isHoldingCrossbow()){
          return this.isValidTarget() && (this.canUse() || !this.mob.getNavigation().isDone());
        }else{
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else if (isHoldingCrossbow()) {
                return false;
            } else if (!this.followingTargetEvenIfNotSeen) {
                return !this.mob.getNavigation().isDone();
            } else if (!this.mob.isWithinRestriction(livingentity.blockPosition())) {
                return false;
            } else {
                return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player)livingentity).isCreative();
            }
        }

    }


    private boolean isValidTarget() {
        return this.mob.getTarget() != null && this.mob.getTarget().isAlive();
    }

    public void stop() {
        super.stop();
        this.mob.setAggressive(false);
        this.mob.setTarget((LivingEntity)null);
        this.seeTime = 0;
        if (isHoldingCrossbow()) {
            if (this.mob.isUsingItem()) {
                this.mob.stopUsingItem();
                this.mob.setChargingCrossbow(false);
                CrossbowItem.setCharged(this.mob.getUseItem(), false);
            }
        }

    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity target = this.mob.getTarget();
        if (target != null) {
            double t0 = this.mob.distanceToSqr(target);
            if (isHoldingCrossbow()) {
                boolean flag = this.mob.getSensing().hasLineOfSight(target);
                boolean flag1 = this.seeTime > 0;
                if (flag != flag1) {
                    this.seeTime = 0;
                }

                if (flag) {
                    ++this.seeTime;
                } else {
                    --this.seeTime;
                }

                boolean flag2 = (t0 > (double) this.attackRadiusSqr || this.seeTime < 5);
                if (flag2) {
                    --this.updatePathDelay;
                    if (this.updatePathDelay <= 0) {
                        this.mob.getNavigation().moveTo(target, this.speedModifier * 0.5F);
                        this.updatePathDelay = PATHFINDING_DELAY_RANGE.sample(this.mob.getRandom());
                    }
                } else {
                    this.updatePathDelay = 0;
                    this.mob.getNavigation().stop();
                }
                if(t0 < 10){
                    this.mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.BLACK_STEEL_SWORD.get()));
                }

                this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);

            }else{
                this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
                double d0 = this.mob.getPerceivedTargetDistanceSquareForMeleeAttack(target);
                this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);


                if ((this.followingTargetEvenIfNotSeen || this.mob.getSensing().hasLineOfSight(target)) && this.ticksUntilNextPathRecalculation <= 0 && (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D && this.pathedTargetZ == 0.0D || target.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D || this.mob.getRandom().nextFloat() < 0.05F)) {
                    this.pathedTargetX = target.getX();
                    this.pathedTargetY = target.getY();
                    this.pathedTargetZ = target.getZ();
                    this.ticksUntilNextPathRecalculation = 4 + this.mob.getRandom().nextInt(7);
                    if (this.canPenalize) {
                        this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
                        if (this.mob.getNavigation().getPath() != null) {
                            net.minecraft.world.level.pathfinder.Node finalPathPoint = this.mob.getNavigation().getPath().getEndNode();
                            if (finalPathPoint != null && target.distanceToSqr(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
                                failedPathFindingPenalty = 0;
                            else
                                failedPathFindingPenalty += 10;
                        } else {
                            failedPathFindingPenalty += 10;
                        }
                    }
                    if (d0 > 1024.0D) {
                        this.ticksUntilNextPathRecalculation += 10;
                    } else if (d0 > 256.0D) {
                        this.ticksUntilNextPathRecalculation += 5;
                    }

                    if (!this.mob.getNavigation().moveTo(target, this.speedModifier)) {
                        this.ticksUntilNextPathRecalculation += 15;
                    }

                    this.ticksUntilNextPathRecalculation = this.adjustedTickDelay(this.ticksUntilNextPathRecalculation);
                }

                if(t0 > 10){
                    this.mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.CROSSBOW));
                }
                this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
                this.checkAndPerformAttack(target, d0);
            }
        }

    }


    protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
        double d0 = this.getAttackReachSqr(p_25557_);
        if (p_25558_ <= d0 && this.ticksUntilNextAttack <= 0) {
            this.resetAttackCooldown();
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(p_25557_);
        }

    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(20);
    }

    protected double getAttackReachSqr(LivingEntity p_25556_) {
        float f = p_25556_.getBbWidth();
        return (double)(f * 2.25F * f * 2.25F + p_25556_.getBbWidth());
    }


}