package com.github.L_Ender.cataclysm.entity.AnimationMonster.AI;

import com.github.L_Ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.world.entity.LivingEntity;

import java.util.EnumSet;

public class AttackAnimationGoal2<T extends LLibrary_Monster & IAnimatedEntity> extends SimpleAnimationGoal<T> {
    private final int look1;
    private final int look2;
    public AttackAnimationGoal2(T entity, Animation animation, int look1, int look2) {
        super(entity, animation);
        this.look1 = look1;
        this.look2 = look2;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
    }
    public void tick() {
        LivingEntity target = entity.getTarget();
        if(target !=null){
            boolean flag = entity.getAnimationTick() < look1 || entity.getAnimationTick() > look2;
            if(flag){
                entity.getLookControl().setLookAt(target,  30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            }else{
                entity.getLookControl().setLookAt(target,0F, 30.0F);
                entity.setYRot(entity.yRotO);
            }

        }else{
            entity.setYRot(entity.yRotO);
        }

        entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
    }

}
