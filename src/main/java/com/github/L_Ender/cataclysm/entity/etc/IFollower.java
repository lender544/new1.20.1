package com.github.L_Ender.cataclysm.entity.etc;

import com.github.L_Ender.cataclysm.entity.Pet.Summoned_Entity.Abstract_Summoned_Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;

public interface IFollower {
    boolean shouldFollow();

   default void followEntity(TamableAnimal tameable, LivingEntity owner, double followSpeed){
       tameable.getNavigation().moveTo(owner, followSpeed);
   }

    default void followEntity(Abstract_Summoned_Entity tameable, LivingEntity owner, double followSpeed){
        tameable.getNavigation().moveTo(owner, followSpeed);
    }
}
