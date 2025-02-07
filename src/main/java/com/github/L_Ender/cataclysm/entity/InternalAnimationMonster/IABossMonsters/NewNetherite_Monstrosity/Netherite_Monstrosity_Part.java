package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity;

import com.github.L_Ender.cataclysm.entity.partentity.Cm_Part_Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;

public class Netherite_Monstrosity_Part extends Cm_Part_Entity<Netherite_Monstrosity_Entity> {
    public final Netherite_Monstrosity_Entity parentMob;
    private final EntityDimensions size;
    public float scale = 1;

    public Netherite_Monstrosity_Part(Netherite_Monstrosity_Entity parent, float sizeX, float sizeY) {
        super(parent);
        this.size = EntityDimensions.scalable(sizeX, sizeY);
        this.parentMob = parent;
        this.refreshDimensions();
    }



    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {

    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean isPickable() {
        return this.getParent().isAlive();
    }

    @Override
    protected void setSize(EntityDimensions size) {
        super.setSize(size);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return this.isInvulnerableTo(source) ? false : this.parentMob.hurtParts(this, source, amount);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {

    }

    @Override
    public boolean is(Entity entity) {
        return this == entity || this.getParent() == entity;
    }

    @Override
    protected void setRot(float yaw, float pitch) {
        this.setYRot(yaw % 360.0F);
        this.setXRot(pitch % 360.0F);
    }

    @Override
    protected boolean canRide(Entity entityIn) {
        return false;
    }

    @Override
    public boolean canUsePortal(boolean p_352936_) {
        return false;
    }


    @Override
    public EntityDimensions getDimensions(Pose poseIn) {
        return this.size;
    }

}
