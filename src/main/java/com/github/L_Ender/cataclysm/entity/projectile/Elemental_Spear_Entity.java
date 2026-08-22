package com.github.L_Ender.cataclysm.entity.projectile;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Elemental_Spear_Entity extends CustomAbstractHurtingProjectile {
    private float damage;



    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Elemental_Spear_Entity.class, EntityDataSerializers.INT);

    private static final AnimationState EMPTY_ANIMATION_STATE = new AnimationState();
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState idlespawnAnimationState = new AnimationState();
    private int animationTicks;

    public Elemental_Spear_Entity(EntityType<? extends Elemental_Spear_Entity> type, Level level) {
        super(type, level);

    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(STATE,0);
    }



    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "spawn" -> this.SpawnAnimationState;
            case "idle" -> this.idlespawnAnimationState;
            default -> EMPTY_ANIMATION_STATE;
        };
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (STATE.equals(p_21104_)) {
            this.animationTicks = 0;
            switch (this.getState()) {

                case 0 -> this.stopAllAnimationStates();
                case 1 -> {
                    stopAllAnimationStates();
                    this.SpawnAnimationState.startIfStopped(this.tickCount);
                }
                case 2 -> {
                    stopAllAnimationStates();
                    this.idlespawnAnimationState.startIfStopped(this.tickCount);
                }
            }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idlespawnAnimationState.stop();
        this.SpawnAnimationState.stop();
    }

    public int getState() {
        return entityData.get(STATE);
    }

    public void setState(int state) {
        this.animationTicks = 0;
        entityData.set(STATE, state);
    }

    public float getDamage() {
        return this.damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }


    public void tick() {
        super.tick();
        int state = this.getState();
        if(this.getState() > 0) {
            this.animationTicks++;
        }
        if (state == 1 && this.animationTicks > 5) {
            this.setState(2);
        }


    }
    protected float RotationSpeed(){
        return 1.0F;
    }

    @Override
    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
    }


    protected void onHit(HitResult result) {
        HitResult.Type hitresult$type = result.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            EntityHitResult entityhitresult = (EntityHitResult)result;
            Entity entity = entityhitresult.getEntity();
            if (entity.getType().is(EntityTypeTags.REDIRECTABLE_PROJECTILE) && entity instanceof Projectile) {
                Projectile projectile = (Projectile)entity;
                projectile.deflect(ProjectileDeflection.AIM_DEFLECT, this.getOwner(), this.getOwner(), true);
            }

            this.onHitEntity(entityhitresult);
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, result.getLocation(), GameEvent.Context.of(this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)result;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }

    }

    protected boolean canHitEntity(Entity p_36842_) {
        return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
    }


    protected float getInertia() {
        return 0.95F;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        compound.putFloat("Damage", this.getDamage());
        compound.putInt("State", this.getState());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setDamage(compound.getFloat("Damage"));
        this.setState(compound.getInt("State"));
    }



}


