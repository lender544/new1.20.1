package com.github.L_Ender.cataclysm.entity.effect;


import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;


import java.util.ArrayList;
import java.util.List;


public class Wall_Watcher_Entity extends Entity {
    static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Wall_Watcher_Entity.class, EntityDataSerializers.INT);
    int effectiveChargeTime;
    double knockbackSpeedIndex;
    float damagePerEffectiveCharge;
    double dx;
    double dz;
    LivingEntity source;
    List<YUnchangedLivingEntity> watchedEntities;


    public Wall_Watcher_Entity(EntityType<? extends Wall_Watcher_Entity> entityTypeIn, Level level) {
        super(entityTypeIn, level);
    }

    public Wall_Watcher_Entity(Level level, BlockPos pos, int timer, int effectiveChargeTime, double knockbackSpeedIndex, float damagePerEffectiveCharge, double dx, double dz, LivingEntity source) {
        super(ModEntities.WALL_WATCHER.get(), level);
        setPos(pos.getX(), pos.getY(), pos.getZ());
        entityData.set(TIMER, timer);
        this.effectiveChargeTime = effectiveChargeTime;
        this.knockbackSpeedIndex = knockbackSpeedIndex;
        this.damagePerEffectiveCharge = damagePerEffectiveCharge;
        this.dx = dx;
        this.dz = dz;
        this.source = source;
        watchedEntities = new ArrayList<>();
    }

    public void watch(LivingEntity livingEntity) {
        if (livingEntity != null) {
            watchedEntities.add(new YUnchangedLivingEntity(livingEntity));
        }
    }

    public void removeFromWatchList(YUnchangedLivingEntity yUnchangedLivingEntity) {
        if (yUnchangedLivingEntity != null) {
            watchedEntities.remove(yUnchangedLivingEntity);
        }
    }


    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide()) {
            int temp = entityData.get(TIMER);
            if (watchedEntities != null && source != null) {
                if (!watchedEntities.isEmpty()) {
                    List<YUnchangedLivingEntity> entitiesRemoveFromWatchList = new ArrayList<>();
                    for (YUnchangedLivingEntity entity : watchedEntities) {
                        if (entity.livingEntity.horizontalCollision) {
                            if (!entity.livingEntity.isAlliedTo(source)) {
                                entity.livingEntity.invulnerableTime = 0;
                                float realDamageApplied = damagePerEffectiveCharge * effectiveChargeTime + 1;
                                boolean flag = entity.livingEntity.hurt(this.damageSources().mobProjectile(this, source), realDamageApplied);
                                if (flag) {
                                    entity.livingEntity.playSound(ModSounds.EXPLOSION.get(), 0.3F, 1);
                                    entity.livingEntity.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, 50));
                                }
                            }

                            entitiesRemoveFromWatchList.add(entity);
                        } else {
                            entity.setMotion(dx * knockbackSpeedIndex, dz * knockbackSpeedIndex);
                        }
                    }
                    for (YUnchangedLivingEntity remove : entitiesRemoveFromWatchList) {
                        removeFromWatchList(remove);
                    }
                    if (temp - 1 == 0) {
                        watchedEntities.clear();
                        remove(RemovalReason.DISCARDED);
                    } else entityData.set(TIMER, temp - 1);
                } else {
                    if (temp - 1 == 0) remove(RemovalReason.DISCARDED);
                    else entityData.set(TIMER, temp - 1);
                }
            } else {
                remove(RemovalReason.DISCARDED);
            }
        }
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {
        source = null;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(TIMER, 0);
    }


    

    static class YUnchangedLivingEntity {
        LivingEntity livingEntity;
        double Y;

        public YUnchangedLivingEntity(LivingEntity livingEntity) {
            this.livingEntity = livingEntity;
            Y = livingEntity.getY();
        }

        void setMotion(double X, double Z) {
            livingEntity.setDeltaMovement(X, 0, Z);
            livingEntity.setPos(livingEntity.getX(), Y, livingEntity.getZ());
            livingEntity.hurtMarked = true;
        }

    }
}
