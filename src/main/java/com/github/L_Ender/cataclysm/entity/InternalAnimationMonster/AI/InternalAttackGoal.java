package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

import java.util.EnumSet;

public class InternalAttackGoal extends Goal {
    protected final Internal_Animation_Monster entity;
    protected final int getattackstate;
    protected final int attackstate;
    protected final int attackendstate;
    protected final int attackMaxtick;
    protected final int attackseetick;
    protected final float attackrange;

    public InternalAttackGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackrange) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }

    public InternalAttackGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackrange, EnumSet<Flag> interruptFlagTypes) {
        this.entity = entity;
        setFlags(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackMaxtick = attackMaxtick;
        this.attackseetick = attackseetick;
        this.attackrange = attackrange;
    }


    @Override
    public boolean canUse() {
        LivingEntity target = entity.getTarget();
        return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate;
    }


    @Override
    public void start() {
        this.entity.setAttackState(attackstate);
        this.entity.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.entity.setAttackState(attackendstate);
        LivingEntity target = entity.getTarget();
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
            this.entity.setTarget((LivingEntity)null);
        }
        this.entity.getNavigation().stop();
        if (this.entity.getTarget() == null) {
            this.entity.setAggressive(false);
        }
    }

    @Override
    public boolean canContinueToUse() {
        return  this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
    }


    public void tick() {
        LivingEntity target = entity.getTarget();
        if (entity.attackTicks < attackseetick && target != null) {
            entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            entity.lookAt(target, 30.0F, 30.0F);
        } else {
            entity.setYRot(entity.yRotO);
        }
        this.entity.getNavigation().stop();
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    //@Override
    //public boolean canContinueToUse() {
    //    return this.test(this.entity.getAnimation()) && this.entity.getAnimationTick() < this.entity.getAnimation().getDuration();
    //}

}