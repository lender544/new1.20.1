package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters;


import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class IABoss_monster extends Internal_Animation_Monster implements Enemy {
    private int reducedDamageTicks;
    private int homeTicks;
    public static final int HOME_COOLDOWN = CMConfig.Return_Home * 20;
    private static final EntityDataAccessor<BlockPos> HOME_POS = SynchedEntityData.defineId(IABoss_monster.class, EntityDataSerializers.BLOCK_POS);

    public IABoss_monster(EntityType entity, Level world) {
        super(entity, world);
    }

    public void setHomePos(BlockPos homePos) {
        this.entityData.set(HOME_POS, homePos);
    }


    BlockPos getHomePos() {
        return (BlockPos)this.entityData.get(HOME_POS);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(HOME_POS, BlockPos.ZERO);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("HomePosX", this.getHomePos().getX());
        compound.putInt("HomePosY", this.getHomePos().getY());
        compound.putInt("HomePosZ", this.getHomePos().getZ());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        int i = compound.getInt("HomePosX");
        int j = compound.getInt("HomePosY");
        int k = compound.getInt("HomePosZ");
        this.setHomePos(new BlockPos(i, j, k));
        super.readAdditionalSaveData(compound);

    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        this.homeTicks = HOME_COOLDOWN;
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.hurt(source, damage);
        } else {
            damage = Math.min(DamageCap(), damage);
        }
        if (ReducedDamage(source)) {
            if (reducedDamageTicks > 0) {
                float reductionFactor = 1.0f - ((float) reducedDamageTicks / DamageTime());
                damage *= reductionFactor;
            }
        }
        boolean flag = super.hurt(source, damage);
        if (ReducedDamage(source)) {
            if (flag) {
                reducedDamageTicks = DamageTime();
            }
        }
        return flag;
    }


    public boolean ReducedDamage(DamageSource damageSource){
        return !damageSource.is(ModTag.BYPASSES_HURT_TIME) && DamageTime() > 0;
    }



    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            if (reducedDamageTicks > 0) reducedDamageTicks--;
            if (homeTicks > 0) homeTicks--;
            LivingEntity target = this.getTarget();

            if(CMConfig.Return_Home > 0) {
                if (homeTicks > 0) homeTicks--;
                if (!isNoAi() ) {
                    if (target != null) {
                        homeTicks = HOME_COOLDOWN;
                    }

                    if (homeTicks <= 0) {
                        if (this.getHomePos() != BlockPos.ZERO) {
                            if (!this.getHomePos().closerToCenterThan(this.position(), (double) 16.0F)) {
                                this.moveTo((double) this.getHomePos().getX() + (double) 0.5F, (double) this.getHomePos().getY(), (double) this.getHomePos().getZ() + (double) 0.5F, this.getYRot(), this.getXRot());
                                homeTicks = HOME_COOLDOWN;
                            }
                        }
                    }
                }
            }
        }

    }

    public float DamageCap() {
        return Float.MAX_VALUE;
    }

    public int DamageTime() {
        return 40;
    }

    public boolean canBePushedByEntity(Entity entity) {
        return true;
    }


    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect().getDelegate().is(ModTag.EFFECTIVE_FOR_BOSSES) && super.canBeAffected(p_34192_);
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
