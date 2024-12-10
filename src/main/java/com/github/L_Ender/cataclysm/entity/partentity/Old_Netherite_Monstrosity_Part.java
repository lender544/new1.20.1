package com.github.L_Ender.cataclysm.entity.partentity;

import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Old_Netherite_Monstrosity_Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.gameevent.GameEvent;

public class Old_Netherite_Monstrosity_Part extends Cm_Part_Entity<Old_Netherite_Monstrosity_Entity> {

    private final EntityDimensions size;
    public float scale = 1;

    public Old_Netherite_Monstrosity_Part(Old_Netherite_Monstrosity_Entity parent, float sizeX, float sizeY) {
        super(parent);
        this.size = EntityDimensions.scalable(sizeX, sizeY);
        this.refreshDimensions();
    }

    public Old_Netherite_Monstrosity_Part(Old_Netherite_Monstrosity_Entity nm, float sizeX, float sizeY, EntityDimensions size) {
        super(nm);
        this.size = size;
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {

    }

    public boolean canBeCollidedWith() {
        return true;
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
        boolean flag = this.getParent() != null && this.getParent().attackEntityFromPart(this, source, amount * 1.35F);
        if (flag) {
            this.gameEvent(GameEvent.ENTITY_DAMAGE);
        }
        return flag;
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
    public boolean canChangeDimensions() {
        return false;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }

    @Override
    public EntityDimensions getDimensions(Pose poseIn) {
        return this.size;
    }

}
