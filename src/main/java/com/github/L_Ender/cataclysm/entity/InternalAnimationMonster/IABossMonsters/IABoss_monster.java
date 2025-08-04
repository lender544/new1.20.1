package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters;


import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.portal.DimensionTransition;

import javax.annotation.Nullable;

public class IABoss_monster extends Internal_Animation_Monster implements Enemy {
    private int reducedDamageTicks;
    private int homeTicks;
    protected final int HOME_COOLDOWN = CMConfig.Return_Home * 20;
    protected final int NATURE_HEAL_COOLDOWN = 200;
    private int self_regen;
    private static final EntityDataAccessor<BlockPos> HOME_POS = SynchedEntityData.defineId(IABoss_monster.class, EntityDataSerializers.BLOCK_POS);
    private static final EntityDataAccessor<String> DIMENSION_TYPE = SynchedEntityData.defineId(IABoss_monster.class, EntityDataSerializers.STRING);

    public IABoss_monster(EntityType entity, Level world) {
        super(entity, world);
    }

    public void setHomePos(BlockPos homePos) {
        this.entityData.set(HOME_POS, homePos);
    }


    public BlockPos getHomePos() {
        return (BlockPos)this.entityData.get(HOME_POS);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(HOME_POS, BlockPos.ZERO);
        builder.define(DIMENSION_TYPE, "minecraft:overworld");
    }

    public String getDimensionType() {
        return this.entityData.get(DIMENSION_TYPE);
    }

    public void setDimensionType(String dimenType) {
        this.entityData.set(DIMENSION_TYPE, dimenType);
    }


    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("HomePosX", this.getHomePos().getX());
        compound.putInt("HomePosY", this.getHomePos().getY());
        compound.putInt("HomePosZ", this.getHomePos().getZ());
        compound.putString("DimensionType", this.getDimensionType());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        int i = compound.getInt("HomePosX");
        int j = compound.getInt("HomePosY");
        int k = compound.getInt("HomePosZ");
        this.setHomePos(new BlockPos(i, j, k));
        this.setDimensionType(compound.getString("DimensionType"));

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
        if (source.is(ModTag.BLOCK_SELF_REGEN)) {
            self_regen = NATURE_HEAL_COOLDOWN;
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
        if (reducedDamageTicks > 0) reducedDamageTicks--;
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
                if (CMConfig.Return_Home > 0) {
                    if (homeTicks > 0) homeTicks--;
                    if (target != null) {
                        homeTicks = HOME_COOLDOWN;
                    }

                    if (homeTicks <= 0) {
                        ReturnToHome();
                    }

                }
            }

        }

    }

    protected void ReturnToHome() {
        if (this.getHomePos() != null && this.getHomePos() != BlockPos.ZERO) {
            if (this.level() instanceof ServerLevel serverLevel) {
                String dimStr = this.getDimensionType();

                ResourceLocation parsed = ResourceLocation.tryParse(dimStr);
                boolean isInvalidDim = dimStr == null || dimStr.contains("ResourceKey") || parsed == null;

                if (isInvalidDim) {
                    System.err.println("[DIM] Malformed dimension string detected: " + dimStr + " → Replacing with current dimension.");
                    parsed = serverLevel.dimension().location();
                    this.setDimensionType(parsed.toString());
                }

                ResourceKey<Level> targetDim = ResourceKey.create(Registries.DIMENSION, parsed);

                if (!serverLevel.dimension().location().equals(parsed)) {
                    ServerLevel targetLevel = serverLevel.getServer().getLevel(targetDim);
                    if (targetLevel != null) {
                        this.changeDimension(
                                new DimensionTransition(
                                        targetLevel, this.position(), this.getDeltaMovement(), this.getYRot(), this.getXRot(), DimensionTransition.DO_NOTHING
                                )
                        );

                        this.moveTo(this.getHomePos().getX() + 0.5, this.getHomePos().getY(), this.getHomePos().getZ() + 0.5, this.getYRot(), this.getXRot());
                        homeTicks = HOME_COOLDOWN;
                        return;
                    }
                }

                if (!this.getHomePos().closerToCenterThan(this.position(), 16.0)) {
                    this.moveTo(this.getHomePos().getX() + 0.5, this.getHomePos().getY(), this.getHomePos().getZ() + 0.5, this.getYRot(), this.getXRot());
                    homeTicks = HOME_COOLDOWN;
                }
            }
        }
    }


    public float DamageCap() {
        return Float.MAX_VALUE;
    }

    public float NatureRegen() {
        return 0;
    }

    public int DamageTime() {
        return 40;
    }

    public boolean canBePushedByEntity(Entity entity) {
        return true;
    }

    @Override
    public boolean canUsePortal(boolean allowPassengers) {
        return false;
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
