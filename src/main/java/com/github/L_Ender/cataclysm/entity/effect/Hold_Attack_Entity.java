package com.github.L_Ender.cataclysm.entity.effect;

import com.github.L_Ender.cataclysm.entity.etc.IHoldEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class Hold_Attack_Entity extends Entity {
    public LivingEntity caster;

    private static final EntityDataAccessor<Optional<UUID>> CONTROLLER_UUID = SynchedEntityData.defineId(Hold_Attack_Entity.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> CONTROLLER_ID = SynchedEntityData.defineId(Hold_Attack_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(Hold_Attack_Entity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Float> POS_X = SynchedEntityData.defineId(Hold_Attack_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> POS_Y = SynchedEntityData.defineId(Hold_Attack_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> POS_Z = SynchedEntityData.defineId(Hold_Attack_Entity.class, EntityDataSerializers.FLOAT);

    public Hold_Attack_Entity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public Hold_Attack_Entity(EntityType<? extends Hold_Attack_Entity> type,Level worldIn, LivingEntity caster, double x, double y, double z, int duration, LivingEntity finalTarget) {
        this(type, worldIn);
        this.caster = caster;
        this.setDuration(duration);
        this.setPos(x, y, z);
        finalTarget.startRiding(this, true);
        if (!worldIn.isClientSide) {
            this.setCasterID(caster.getId());
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(CONTROLLER_UUID, Optional.empty());
        this.entityData.define(CONTROLLER_ID, -1);
        this.entityData.define(DURATION, 0);
        this.entityData.define(POS_X, 0f);
        this.entityData.define(POS_Y, 0f);
        this.entityData.define(POS_Z, 0f);

    }


    public void tick() {
        super.tick();
        Entity controller = getController();
        if (!this.getPassengers().isEmpty() && this.getPassengers().get(0).isShiftKeyDown()) {
            this.getPassengers().get(0).setShiftKeyDown(false);
        }

        if (this.tickCount > this.getDuration()) {
            discard();
        }

        if (controller instanceof IHoldEntity levi) {
            this.entityData.set(CONTROLLER_ID, levi.getId());
            levi.setHeldUUID(this.getUUID());
        }

        if (caster != null && !caster.isAlive()) discard();

        if (caster != null) {
            this.setPos(this.getPosX(),this.getPosY(), this.getPosZ());
        }else{
            this.setPos(this.getX(),this.getY(), this.getZ());
        }
    }

    private void updatePos() {
        this.setPos(this.getPosX(),this.getPosY(), this.getPosZ());
    }

    public boolean shouldRiderSit() {
        return false;
    }

    public double getPassengersRidingOffset() {
        return 0.35D;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.hasUUID("ControllerUUID")) {
            this.setControllerUUID(tag.getUUID("ControllerUUID"));
        }
        this.setDuration(tag.getInt("Duration"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        if (this.getControllerUUID() != null) {
            tag.putUUID("ControllerUUID", this.getControllerUUID());
        }
        tag.putInt("Duration", getDuration());
    }


    @Nullable
    public UUID getControllerUUID() {
        return this.entityData.get(CONTROLLER_UUID).orElse(null);
    }

    public void setControllerUUID(@Nullable UUID uniqueId) {
        this.entityData.set(CONTROLLER_UUID, Optional.ofNullable(uniqueId));
    }

    public int getCasterID() {
        return entityData.get(CONTROLLER_ID);
    }

    public void setCasterID(int id) {
        entityData.set(CONTROLLER_ID, id);
    }

    public int getDuration() {
        return this.entityData.get(DURATION);
    }

    public void setDuration(int i) {
        this.entityData.set(DURATION, i);
    }

    public float getPosX() {
        return this.entityData.get(POS_X);
    }

    public void setPosX(float i) {
        this.entityData.set(POS_X, i);
    }

    public float getPosY() {
        return this.entityData.get(POS_Y);
    }

    public void setPosY(float i) {
        this.entityData.set(POS_Y, i);
    }

    public float getPosZ() {
        return this.entityData.get(POS_Z);
    }

    public void setPosZ(float i) {
        this.entityData.set(POS_Z, i);
    }

    public Entity getController() {
        if (!level().isClientSide) {
            final UUID id = getControllerUUID();
            return id == null ? null : ((ServerLevel) level()).getEntity(id);
        } else {
            int id = this.entityData.get(CONTROLLER_ID);
            return id == -1 ? null : level().getEntity(id);
        }
    }
}
