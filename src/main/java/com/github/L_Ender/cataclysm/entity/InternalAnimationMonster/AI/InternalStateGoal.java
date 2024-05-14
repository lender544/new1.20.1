package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class InternalStateGoal extends Goal {
    protected final Internal_Animation_Monster entity;
    private final int getattackstate;
    private final int attackstate;
    protected final int attackendstate;
    private final int attackfinaltick;
    protected final int attackseetick;

    public InternalStateGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public InternalStateGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, boolean interruptsAI) {
        this.entity = entity;
        if (interruptsAI) this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    public InternalStateGoal(Internal_Animation_Monster entity, int getattackstate, int attackstate, int attackendstate, int attackfinaltick, int attackseetick, EnumSet<Flag> interruptFlagTypes) {
        this.entity = entity;
        setFlags(interruptFlagTypes);
        this.getattackstate = getattackstate;
        this.attackstate = attackstate;
        this.attackendstate = attackendstate;
        this.attackfinaltick = attackfinaltick;
        this.attackseetick = attackseetick;
    }

    @Override
    public boolean canUse() {
        return this.entity.getAttackState() == getattackstate;
    }

    @Override
    public void start() {
        if(getattackstate != attackstate) {
            this.entity.setAttackState(attackstate);
        }
    }

    @Override
    public void stop() {
        this.entity.setAttackState(attackendstate);
        this.entity.attackCooldown = 0;
    }

    @Override
    public boolean canContinueToUse() {
        return attackfinaltick > 0 ? this.entity.attackTicks <= attackfinaltick : canUse();
    }


    public void tick() {
        LivingEntity target = entity.getTarget();
        if (entity.attackTicks < attackseetick && target != null) {
            entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            entity.lookAt(target, 30.0F, 30.0F);
        } else {
            entity.setYRot(entity.yRotO);
        }
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