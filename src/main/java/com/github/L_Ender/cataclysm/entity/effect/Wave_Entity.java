package com.github.L_Ender.cataclysm.entity.effect;

import com.github.L_Ender.cataclysm.client.particle.Options.CustomPoofParticleOptions;
import com.github.L_Ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.UUID;

public class Wave_Entity extends Entity {

    private static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Wave_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MAX_TICKS = SynchedEntityData.defineId(Wave_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> Y_ROT = SynchedEntityData.defineId(Wave_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Wave_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Wave_Entity.class, EntityDataSerializers.FLOAT);
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState DespawnAnimationState = new AnimationState();
    public AnimationState idleAnimationState = new AnimationState();
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;
    private boolean sentEvent;
    private boolean clientSideAttackEnded;
    private int lSteps;
    private double lx;
    private double ly;
    private double lz;
    private double lyr;
    private double lxr;
    private double lxd;
    private double lyd;
    private double lzd;

    public Wave_Entity(EntityType entityType, Level level) {
        super(entityType, level);
    }

    public Wave_Entity(Level level, LivingEntity shooter,int life,float damage) {
        this(ModEntities.WAVE.get(), level);
        this.setOwner(shooter);
        this.setMaxTicks(life);
        this.setDamage(damage);
        this.setLifespan(0);
    }

    public float maxUpStep() {
        return 2.0F;
    }

    public void setOwner(@Nullable LivingEntity living) {
        this.owner = living;
        this.ownerUUID = living == null ? null : living.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUUID != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel) this.level()).getEntity(this.ownerUUID);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity) entity;
            }
        }

        return this.owner;
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(LIFESPAN, 0);
        p_326229_.define(MAX_TICKS, 0);
        p_326229_.define(Y_ROT, 0F);
        p_326229_.define(STATE, 0);
        p_326229_.define(DAMAGE, 0F);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "spawn") {
            return this.SpawnAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "despawn") {
            return this.DespawnAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (STATE.equals(p_21104_)) {
            switch (this.getState()) {
                case 0 -> this.stopAllAnimationStates();
                case 1 -> {
                    stopAllAnimationStates();
                    this.SpawnAnimationState.startIfStopped(this.tickCount);
                }
                case 2 -> {
                    stopAllAnimationStates();
                    this.idleAnimationState.startIfStopped(this.tickCount);
                }
                case 3 -> {
                    stopAllAnimationStates();
                    this.DespawnAnimationState.startIfStopped(this.tickCount);
                }
            }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.DespawnAnimationState.stop();
        this.idleAnimationState.stop();
        this.SpawnAnimationState.stop();
    }

    public int getState() {
        return entityData.get(STATE);
    }

    public void setState(int state) {
        entityData.set(STATE, state);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }



    protected void readAdditionalSaveData(CompoundTag tag) {
        if (tag.hasUUID("Owner")) {
            this.ownerUUID = tag.getUUID("Owner");
        }
        if (tag.contains("Lifespan")) {
            this.setLifespan(tag.getInt("Lifespan"));
        }
        if (tag.contains("Maxticks")) {
            this.setMaxTicks(tag.getInt("Maxticks"));
        }
    }

    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        if (this.ownerUUID != null) {
            compoundTag.putUUID("Owner", this.ownerUUID);
        }
        compoundTag.putInt("Lifespan", this.getLifespan());
        compoundTag.putInt("Maxticks", this.getMaxTicks());
    }

    public float getYRot() {
        return this.entityData.get(Y_ROT);
    }

    public void setYRot(float f) {
        this.entityData.set(Y_ROT, f);
    }

    public int getLifespan() {
        return this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int time) {
        this.entityData.set(LIFESPAN, time);
    }

    public int getMaxTicks() {
        return this.entityData.get(MAX_TICKS);
    }

    public void setMaxTicks(int time) {
        this.entityData.set(MAX_TICKS, time);
    }


    private void spawnParticleAt(float yOffset, float zOffset, float xOffset, ParticleOptions particleType) {
        Vec3 vec3 = new Vec3(xOffset, yOffset, zOffset).yRot((float) Math.toRadians(-this.getYRot()));
        this.level().addParticle(particleType, this.getX() + vec3.x, this.getY() + vec3.y, this.getZ() + vec3.z, this.getDeltaMovement().x, 0.1F, this.getDeltaMovement().z);
    }

    public void tick() {
        super.tick();
        if (!this.isNoGravity() && !this.isInWaterOrBubble()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, (double) -0.04F, 0.0D));
        }
        if(this.getState() == 1) {
            if (this.getLifespan() >= 5) {
                this.setState(2);
            }
        }
        if(this.getState() == 2) {
            if(this.getLifespan() >= this.getMaxTicks() - 30) {
                if (!this.sentEvent) {
                    this.level().broadcastEntityEvent(this, (byte)4);
                    this.sentEvent = true;
                }
            }
            if(this.getLifespan() >= this.getMaxTicks() - 10) {
                this.setState(3);
            }
        }


        this.setLifespan(this.getLifespan() + 1);

        if (this.getLifespan() >= this.getMaxTicks()) {
            //Cataclysm.PROXY.clearSoundCacheFor(this);
            this.remove(RemovalReason.DISCARDED);
        }
        float f = Math.max(1F - (this.getLifespan() / (1F * getMaxTicks())), 0F);
        Vec3 directionVec = new Vec3(0, 0, f * f * 0.1F).yRot((float) Math.toRadians(-this.getYRot()));
        if (this.level().isClientSide) {
            if (this.lSteps > 0) {
                double d5 = this.getX() + (this.lx - this.getX()) / (double) this.lSteps;
                double d6 = this.getY() + (this.ly - this.getY()) / (double) this.lSteps;
                double d7 = this.getZ() + (this.lz - this.getZ()) / (double) this.lSteps;
                this.setYRot(Mth.wrapDegrees((float) this.lyr));
                this.setXRot(this.getXRot() + (float) (this.lxr - (double) this.getXRot()) / (float) this.lSteps);
                --this.lSteps;
                this.setPos(d5, d6, d7);
            } else {
                this.reapplyPosition();
            }
            if (!this.clientSideAttackEnded) {
                for (int particleCount = 0; particleCount < 2; particleCount++) {
                    for (int i = 0; i < 2; i++) {
                        float xOffset = (float) (i - 1) / 2.0F + 0.25F + (random.nextFloat() - 0.5F) * 0.2F;
                        int rand = this.random.nextInt(20);
                        spawnParticleAt((0.1F + random.nextFloat() * 0.2F), 0.7F, xOffset * 3.5F, new CustomPoofParticleOptions(76 + rand, 147 + rand, 173 + rand, 0.1F));
                    }
                }
            }
        } else {
            this.reapplyPosition();
            this.setRot(this.getYRot(), this.getXRot());
            attackEntities(1.5,Mth.sin(this.getYRot() * ((float) Math.PI / 180F)), (-Mth.cos(this.getYRot() * ((float) Math.PI / 180F))));
        }



        Vec3 vec3 = this.getDeltaMovement().scale(0.9F).add(directionVec);
        this.move(MoverType.SELF, vec3);
        this.setDeltaMovement(vec3.multiply((double) 0.99F, (double) 0.98F, (double) 0.99F));
    }


    protected void attackEntities(double strength,double x,double z) {
        AABB bashBox = this.getBoundingBox().inflate(0.01f);
        DamageSource source = damageSources().mobProjectile(this, owner);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, bashBox)) {
            if (!isAlliedTo(entity) && (owner == null || !owner.equals(entity) && !owner.isAlliedTo(entity))) {
                boolean flag = entity.hurt(source, this.getDamage());

                if(flag) {
                    MobEffectInstance effectinstance1 = entity.getEffect(ModEffect.EFFECTWETNESS);
                    int i = 1;
                    if (effectinstance1 != null) {
                        i += effectinstance1.getAmplifier();
                        entity.removeEffectNoUpdate(ModEffect.EFFECTWETNESS);
                    } else {
                        --i;
                    }

                    i = Mth.clamp(i, 0, 4);
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTWETNESS, 200, i, false, true, true);
                    entity.addEffect(effectinstance);
                }

                entity.hasImpulse = true;
                Vec3 vec3;
                for(vec3 = entity.getDeltaMovement(); x * x + z * z < (double)1.0E-5F; z = (Math.random() - Math.random()) * 0.01) {
                    x = (Math.random() - Math.random()) * 0.01;
                }
                Vec3 vec31 = (new Vec3(x, (double)0.0F, z)).normalize().scale(strength);
                entity.setDeltaMovement(vec3.x / (double)2.0F - vec31.x, entity.onGround() ? Math.min(0.5, vec3.y / (double)2.0F + strength) : vec3.y, vec3.z / (double)2.0F - vec31.z);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.clientSideAttackEnded = true;

        }

    }

    @Override
    public void lerpTo(double x, double y, double z, float yr, float xr, int steps) {
        this.lx = x;
        this.ly = y;
        this.lz = z;
        this.lyr = yr;
        this.lxr = xr;
        this.lSteps = steps;
        this.setDeltaMovement(this.lxd, this.lyd, this.lzd);
    }

    @Override
    public void lerpMotion(double lerpX, double lerpY, double lerpZ) {
        this.lxd = lerpX;
        this.lyd = lerpY;
        this.lzd = lerpZ;
        this.setDeltaMovement(this.lxd, this.lyd, this.lzd);
    }
}
