package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;


public class Sandstorm_Projectile extends CustomAbstractHurtingProjectile {

    private static final EntityDataAccessor<Integer> STATE =
            SynchedEntityData.defineId(Sandstorm_Projectile.class, EntityDataSerializers.INT);
    private static final AnimationState EMPTY_ANIMATION_STATE = new AnimationState();

    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState DespawnAnimationState = new AnimationState();

    private float damage;
    private int animationTicks;
    private int lifeTicks = LIFE_TICKS;
    private static final int LIFE_TICKS = 290;

    private static final int SPAWN_ANIM_TICKS = 5;
    private static final int DESPAWN_ANIM_TICKS = 10;
    public Sandstorm_Projectile(EntityType<? extends Sandstorm_Projectile> entityType, Level level) {
        super(entityType, level);
    }

    public Sandstorm_Projectile(Level level, LivingEntity owner, Vec3 movement, float damage) {
        super(ModEntities.SANDSTORM_PROJECTILE.get(), owner, movement, level);
        this.setDamage(damage);
        this.setState(1);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(STATE, 0);
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "spawn" -> this.SpawnAnimationState;
            case "despawn" -> this.DespawnAnimationState;
            default -> EMPTY_ANIMATION_STATE;
        };
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        if (STATE.equals(key)) {
            this.animationTicks = 0;
            switch (this.getState()) {
                case 0 -> this.stopAllAnimationStates();
                case 1 -> {
                    this.stopAllAnimationStates();
                    this.SpawnAnimationState.startIfStopped(this.tickCount);
                }
                case 2 -> {
                    this.stopAllAnimationStates();
                    this.DespawnAnimationState.startIfStopped(this.tickCount);
                }
            }
        }

        super.onSyncedDataUpdated(key);
    }

    public void stopAllAnimationStates() {
        this.DespawnAnimationState.stop();
        this.SpawnAnimationState.stop();
    }

    public int getState() {
        return this.entityData.get(STATE);
    }

    public void setState(int state) {
        this.animationTicks = 0;
        this.entityData.set(STATE, state);
    }

    public float getDamage() {
        return this.damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distSqr) {
        double d0 = this.getBoundingBox().getSize() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return distSqr < d0 * d0;
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.isRemoved()) {
            int state = this.getState();
            if (state > 0) {
                this.animationTicks++;
            }
            if (!this.level().isClientSide) {
                if (state == 1 && this.animationTicks > SPAWN_ANIM_TICKS) {
                    this.setState(0);
                }

                if (this.lifeTicks > 0) {
                    this.lifeTicks--;
                } else if (state == 0) {
                    this.setState(2);
                }

                if (state == 2 && this.animationTicks > DESPAWN_ANIM_TICKS) {
                    this.discard();
                }

            }
        }
    }

    @Override
    public void remove(RemovalReason reason) {
        Cataclysm.PROXY.clearSoundCacheFor(this);
        super.remove(reason);
    }

    @Override
    protected void TrailParticle() {
        if (this.level().isClientSide) {


            RandomSource rand = this.random;
            float ran = 0.04F;
            float r = 0.89F + rand.nextFloat() * ran;
            float g = 0.85F + rand.nextFloat() * ran;
            float b = 0.69F + rand.nextFloat() * ran * 1.5F;

            this.level().addParticle(
                    new StormParticleOptions(r, g, b,
                            0.25F + rand.nextFloat() * 0.45F,
                            0.35F + rand.nextFloat() * 0.45F,
                            this.getId()),
                    this.getX(), this.getY(), this.getZ(), 0, 0, 0);

            if (!this.isSilent()) {
                Cataclysm.PROXY.playWorldSound(this, (byte) 2);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (this.level() instanceof ServerLevel serverlevel) {
            Entity entity = result.getEntity();
            Entity owner = this.getOwner();
            boolean flag = false;

            if (owner instanceof LivingEntity livingOwner) {
                if (!(entity.getType().is(ModTag.TEAM_ANCIENT_REMNANT) && owner.getType().is(ModTag.TEAM_ANCIENT_REMNANT))) {
                    DamageSource damagesource = this.damageSources().mobProjectile(this, livingOwner);
                    flag = entity.hurt(damagesource, this.getDamage());
                    if (flag) {
                        if (entity.isAlive()) {
                            EnchantmentHelper.doPostAttackEffects(serverlevel, entity, damagesource);
                        }
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().magic(), this.getDamage());
            }

            if (flag && entity instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 100, 1), this.getEffectSource());
            }

            this.setState(2);
        }
    }


    @Override
    protected float getInertia() {
        return 0.9F;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("state", this.getState());
        compound.putInt("lifeTicks", this.lifeTicks);
        compound.putFloat("damage", this.getDamage());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setState(compound.getInt("state"));
        if (compound.contains("lifeTicks")) {
            this.lifeTicks = compound.getInt("lifeTicks");
        }
        this.setDamage(compound.getFloat("damage"));
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public float getPickRadius() {
        return 1.0F;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }
}