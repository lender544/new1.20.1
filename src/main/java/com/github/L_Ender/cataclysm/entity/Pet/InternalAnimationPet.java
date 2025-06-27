package com.github.L_Ender.cataclysm.entity.Pet;


import com.github.L_Ender.cataclysm.entity.etc.IFollower;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class InternalAnimationPet extends AnimationPet implements IFollower {
    public static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(InternalAnimationPet.class, EntityDataSerializers.INT);

    public int attackTicks;

    public InternalAnimationPet(EntityType entity, Level world) {
        super(entity, world);

    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK_STATE, 0);
    }
    public int getAttackState() {
        return this.entityData.get(ATTACK_STATE);
    }

    public void setAttackState(int input) {
        this.attackTicks = 0;
        this.entityData.set(ATTACK_STATE, input);
        this.level().broadcastEntityEvent(this, (byte) -input);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.attackTicks = 0;
        }else {
            super.handleEntityEvent(id);
        }
    }

    public void tick() {
        super.tick();

        if (this.getAttackState() > 0) {
            ++this.attackTicks;
        }

    }

}
