package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class The_Leviathan_Tongue_Entity extends Entity {

    private static final EntityDataAccessor<Optional<UUID>> CONTROLLER_UUID = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> CONTROLLER_ID = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TARGET_ID = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MAX_DURATION = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> COMING_BACK = SynchedEntityData.defineId(The_Leviathan_Tongue_Entity.class, EntityDataSerializers.BOOLEAN);
    private int destroyBlocksTick;

    public The_Leviathan_Tongue_Entity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(CONTROLLER_UUID, Optional.empty());
        p_326229_.define(CONTROLLER_ID, -1);
        p_326229_.define(TARGET_ID, -1);
        p_326229_.define(DURATION, 0);
        p_326229_.define(MAX_DURATION, 0);
        p_326229_.define(COMING_BACK, false);
    }


    public void tick() {
        super.tick();
        Entity controller = getController();
        Entity target = getTarget();

        if (!this.getPassengers().isEmpty() && this.getPassengers().get(0).isShiftKeyDown()) {
            this.getPassengers().get(0).setShiftKeyDown(false);
        }

        if(this.getDuration() <= this.getMaxDuration()) {
            this.setDuration(this.getDuration() + 1);
        }


        if (!this.level().isClientSide) {
            if(CMConfig.LeviathanBlockBreaking){
                blockbreak(0.25d,0.25d,0.25d);
            }else{
                if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
                    blockbreak(0.25d,0.25d,0.25d);
                }
            }
        }

        if (controller instanceof The_Leviathan_Entity levi) {
            this.entityData.set(CONTROLLER_ID, levi.getId());
            levi.setTongueUUID(this.getUUID());
            if (!level().isClientSide) {
                Entity e = levi.getTarget();
                this.entityData.set(TARGET_ID, e != null && e.isAlive() ? e.getId() : -1);
            }


            boolean attacking = !this.getComingBack() && target != null && target.isAlive();
            Vec3 vec3 = attacking ? target.getEyePosition() : levi.getTonguePosition();
            float speed = attacking ? 0.095f : 0.15f;
            Vec3 want = vec3.subtract(this.position());
            if (target != null && !this.getComingBack()) {
                if (want.length() < target.getBbWidth() + 1F) {
                    hurtEntity(levi, target);
                    this.setComingBack(true);
                }
            }
            directMovementTowards(vec3, speed);

            if (this.getDuration() >= this.getMaxDuration() / 2) {
                if (!this.getComingBack()) {
                    this.setComingBack(true);
                }
            }
        }
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale(0.9F));
    }

    private void hurtEntity(LivingEntity holder, Entity target) {
        if(target.hurt(damageSources().mobAttack(holder), 6)){
            if (!this.level().isClientSide) {
                target.startRiding(this);
            }
        }
    }




    private void blockbreak(double x, double y, double z) {
        if (!this.level().isClientSide) {
            if (this.destroyBlocksTick > 0) {
                --this.destroyBlocksTick;
                return;
            }

            boolean flag = false;
            AABB aabb = this.getBoundingBox().inflate(x, y, z);
            for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.LEVIATHAN_IMMUNE)) {
                    flag = this.level().destroyBlock(blockpos, false, this) || flag;
                }
            }
            if (flag) {
                destroyBlocksTick = 15;
            }
        }
    }


    private boolean shouldDropItem(BlockEntity tileEntity) {
        if (tileEntity == null) {
            return random.nextInt(3) + 1 == 3;
        }
        return true;
    }


    private void directMovementTowards(Vec3 moveTo, float speed) {
        Vec3 want = moveTo.subtract(this.position());
        if (want.length() > 1F) {
            want = want.normalize();
        }
        float targetXRot = (float) (-(Mth.atan2(want.y, want.horizontalDistance()) * (double) (180F / (float) Math.PI)));
        float targetYRot = (float) (-Mth.atan2(want.x, want.z) * (double) (180F / (float) Math.PI));
        this.setXRot(Mth.approachDegrees(this.getXRot(), targetXRot, 5F));
        this.setYRot(Mth.approachDegrees(this.getYRot(), targetYRot, 5F));
        this.setDeltaMovement(this.getDeltaMovement().add(want.scale(speed)));

    }

    public boolean shouldRiderSit() {
        return false;
    }

    public double getPassengersRidingOffset() {
        return -0.5D;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.hasUUID("ControllerUUID")) {
            this.setControllerUUID(tag.getUUID("ControllerUUID"));
        }
        this.setDuration(tag.getInt("Duration"));
        this.setDuration(tag.getInt("Max_Duration"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        if (this.getControllerUUID() != null) {
            tag.putUUID("ControllerUUID", this.getControllerUUID());
        }
        tag.putInt("Duration", getDuration());
        tag.putInt("Max_Duration", getMaxDuration());
    }


    @Nullable
    public UUID getControllerUUID() {
        return this.entityData.get(CONTROLLER_UUID).orElse(null);
    }

    public void setControllerUUID(@Nullable UUID uniqueId) {
        this.entityData.set(CONTROLLER_UUID, Optional.ofNullable(uniqueId));
    }

    public int getDuration() {
        return this.entityData.get(DURATION);
    }

    public void setDuration(int i) {
        this.entityData.set(DURATION, i);
    }

    public int getMaxDuration() {
        return this.entityData.get(MAX_DURATION);
    }

    public void setMaxDuration(int i) {
        this.entityData.set(MAX_DURATION, i);
    }

    public boolean getComingBack() {
        return this.entityData.get(COMING_BACK);
    }

    public void setComingBack(boolean i) {
        this.entityData.set(COMING_BACK, i);
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

    public Entity getTarget() {
        int id = this.entityData.get(TARGET_ID);
        return id == -1 ? null : level().getEntity(id);
    }
}
