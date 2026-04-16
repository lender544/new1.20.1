package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;


import com.github.L_Ender.cataclysm.config.CMCommonConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.L_Ender.cataclysm.entity.etc.IHomeEntity;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;

public class LLibrary_Boss_Monster extends LLibrary_Monster implements IAnimatedEntity, Enemy, IHomeEntity {
    private int homeTicks;
    protected final int HOME_COOLDOWN = CMCommonConfig.ETC.ReturnHome * 20;
    private float damageBucket = 0.0f;
    private int self_regen;
    private static final EntityDataAccessor<Optional<GlobalPos>> HOME_POS = SynchedEntityData.defineId(LLibrary_Boss_Monster.class, EntityDataSerializers.OPTIONAL_GLOBAL_POS);

    public LLibrary_Boss_Monster(EntityType entity, Level world) {
        super(entity, world);
    }

    public void setHomePos(@Nullable GlobalPos vec3) {
        this.entityData.set(HOME_POS, Optional.ofNullable(vec3));
    }

    @Nullable
    public GlobalPos getHomePos() {
        return this.entityData.get(HOME_POS).orElse(null);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HOME_POS, Optional.empty());
    }


    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.addAdditionalHomePoint(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        this.readAdditionalHomePoint(compound);

        super.readAdditionalSaveData(compound);

    }
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType,@Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag p_21438_) {
        this.homeTicks = HOME_COOLDOWN;
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData,p_21438_);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        }

        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.hurt(source, amount);
        } else {
            amount = Math.min(DamageCap(), amount);
        }

        double distSqr = calculateRange(source);

        if (distSqr != -1) {
            double limit = this.RangeLimit();
            double maxLimit = limit * 1.5;

            double limitSqr = limit * limit;
            double maxLimitSqr = maxLimit * maxLimit;

            if (distSqr >= maxLimitSqr) {
                return false;
            }

            if (distSqr > limitSqr) {
                double distance = Math.sqrt(distSqr);
                float multiplier = (float) ((maxLimit - distance) / (maxLimit - limit));
                amount *= multiplier;

                if (amount <= 0) return false;
            }
        }

        float BUCKET = this.damageBucket;

        if (!source.is(ModTag.BYPASSES_HURT_TIME)) {
            float projectedBucket = damageBucket + amount;
            float limit = this.DamageCap();

            if (projectedBucket > limit) {
                float roomLeft = limit - damageBucket;

                if (roomLeft > 0) {
                    amount = roomLeft;
                    damageBucket = limit;
                } else {
                    amount = 0.1F;
                }
            } else {
                damageBucket += amount;
            }
        }

        boolean flag = super.hurt(source, amount);

        if (flag) {
            if (source.is(ModTag.BLOCK_SELF_REGEN)) {
                self_regen = HealCooldown();
            }
        } else {
            this.damageBucket = BUCKET;
        }

        return flag;
    }

    public float DamageCap() {
        return Float.MAX_VALUE;
    }

    public float DpsCap() {
        return Float.MAX_VALUE;
    }

    public float NatureRegen() {
        return 0;
    }

    public double RangeLimit() {
        return Double.MAX_VALUE;
    }

    public int HealCooldown() {
        return 200;
    }

    public void tick() {
        super.tick();
        if (self_regen > 0) self_regen--;
        if (!this.level().isClientSide()) {
            LivingEntity target = this.getTarget();

            if (!isNoAi() ) {
                if (self_regen <= 0) {
                    if (!isNoAi() && this.NatureRegen() > 0 && target == null) {
                        if (this.tickCount % 20 == 0) {
                            this.heal(this.NatureRegen());
                        }
                    }
                }
                if (HOME_COOLDOWN > 0) {
                    if (homeTicks > 0) homeTicks--;
                    if (target != null) {
                        homeTicks = HOME_COOLDOWN;
                    }

                    if (homeTicks <= 0) {
                        ReturnToHome();
                    }

                }
                if(damageBucket > 0) {
                    damageBucket -= (this.DpsCap() / 20.0f);
                    if (damageBucket < 0) damageBucket = 0;
                }

            }

        }
    }


    protected void ReturnToHome() {
        if (this.getHomePos() != null) {
            if (this.level() instanceof ServerLevel serverLevel) {
                ResourceKey<Level> targetDim = this.getHomePos().dimension();
                BlockPos homeBlockPos = this.getHomePos().pos();
                Vec3 homeVec = new Vec3(homeBlockPos.getX() + 0.5, homeBlockPos.getY(), homeBlockPos.getZ() + 0.5);

                if (!targetDim.equals(this.level().dimension())) {
                    ServerLevel targetLevel = serverLevel.getServer().getLevel(targetDim);
                    if (targetLevel != null) {
                        this.changeDimension(targetLevel);
                        this.moveTo(homeVec.x + 0.5, homeVec.y, homeVec.z + 0.5, this.getYRot(), this.getXRot());

                        homeTicks = HOME_COOLDOWN;
                        return;
                    }
                }
                if (!homeBlockPos.closerToCenterThan(this.position(), 16.0)) {
                    this.moveTo(homeVec.x, homeVec.y, homeVec.z, this.getYRot(), this.getXRot());
                    homeTicks = HOME_COOLDOWN;
                }
            }
        }
    }

    protected void onDeathAIUpdate() {}



    public boolean canChangeDimensions() {
        return false;
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return ModTag.EFFECTIVE_FOR_BOSSES_LOOKUP.contains(p_34192_.getEffect()) && super.canBeAffected(p_34192_);
    }


    public boolean removeWhenFarAway(double p_21542_) {
        return false;
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }
}
