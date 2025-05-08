package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.github.L_Ender.cataclysm.client.particle.LightningParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AdvancedHurtByTargetGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AttackAniamtionGoal3;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.HurtByNearestTargetGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.projectile.*;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;


public class The_Harbinger_Entity extends LLibrary_Boss_Monster implements RangedAttackMob, PowerableMob {
    public static final Animation DEATHLASER_ANIMATION = Animation.create(124);
    public static final Animation CHARGE_ANIMATION = Animation.create(45);
    public static final Animation DEATH_ANIMATION = Animation.create(144);
    public static final Animation LAUNCH_ANIAMATION = Animation.create(59);
    public static final Animation MISSILE_FIRE_ANIAMATION = Animation.create(118);
    public static final Animation MISSILE_FIRE_FAST_ANIAMATION = Animation.create(96);
    public static final Animation STUN_ANIAMATION = Animation.create(105);
    public static final int SKILL_COOLDOWN = 240;
    private static final EntityDataAccessor<Integer> FIRST_HEAD_TARGET = SynchedEntityData.defineId(The_Harbinger_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SECOND_HEAD_TARGET = SynchedEntityData.defineId(The_Harbinger_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> THIRD_HEAD_TARGET = SynchedEntityData.defineId(The_Harbinger_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> OVERLOAD = SynchedEntityData.defineId(The_Harbinger_Entity.class, EntityDataSerializers.INT);
    private static final List<EntityDataAccessor<Integer>> HEAD_TARGETS = ImmutableList.of(FIRST_HEAD_TARGET, SECOND_HEAD_TARGET, THIRD_HEAD_TARGET);
    private static final EntityDataAccessor<Boolean> LASER_MODE = SynchedEntityData.defineId(The_Harbinger_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> ISCHARGE = SynchedEntityData.defineId(The_Harbinger_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_ACT = SynchedEntityData.defineId(The_Harbinger_Entity.class, EntityDataSerializers.BOOLEAN);
    public static final int MODE_CHANGE_COOLDOWN = 300;
    private final float[] xRotHeads = new float[2];
    private final float[] yRotHeads = new float[2];
    private final float[] xRotOHeads = new float[2];
    private final float[] yRotOHeads = new float[2];
    private final int[] nextHeadUpdate = new int[2];
    private final int[] idleHeadUpdates = new int[2];
    public float Laser_Mode_Progress;
    public float prev_Laser_Mode_Progress;
    public float deactivateProgress;
    public float prevdeactivateProgress;
    private int destroyBlocksTick;
    private int blockBreakCounter;
    private final CMBossInfoServer bossEvent = new CMBossInfoServer(this.getDisplayName(),BossEvent.BossBarColor.RED,true,4);

    private int mode_change_cooldown = 0;
    private int skill_cooldown = 160;

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.attackable() && !(p_31504_.getType().is(ModTag.TEAM_THE_HARBINGER));
    };
    private static final TargetingConditions TARGETING_CONDITIONS = TargetingConditions.forCombat().range(20.0D).selector(LIVING_ENTITY_SELECTOR);


    public The_Harbinger_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 300;
        this.moveControl = new FlyingMoveControl(this, 10, false);
        setConfigattribute(this, CMConfig.HarbingerHealthMultiplier, CMConfig.HarbingerDamageMultiplier);
    }

    protected PathNavigation createNavigation(Level p_186262_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_186262_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{
                NO_ANIMATION, DEATHLASER_ANIMATION, CHARGE_ANIMATION, DEATH_ANIMATION, LAUNCH_ANIAMATION, MISSILE_FIRE_ANIAMATION, STUN_ANIAMATION, MISSILE_FIRE_FAST_ANIAMATION};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new AwakenGoal());
        this.goalSelector.addGoal(1, new DeathLaserGoal(this, DEATHLASER_ANIMATION));
        this.goalSelector.addGoal(1, new ChargeGoal(this, CHARGE_ANIMATION));
        this.goalSelector.addGoal(1, new LaunchGoal(this, LAUNCH_ANIAMATION));
        this.goalSelector.addGoal(1, new MissileLaunchGoal(this, MISSILE_FIRE_ANIAMATION));
        this.goalSelector.addGoal(1, new MissileLaunchGoal2(this, MISSILE_FIRE_FAST_ANIAMATION));
        this.goalSelector.addGoal(1, new AttackAniamtionGoal3<>(this, STUN_ANIAMATION));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByNearestTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
    }

    public static AttributeSupplier.Builder harbinger() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 390.0D)
                .add(Attributes.MOVEMENT_SPEED, (double) 0.6F)
                .add(Attributes.ATTACK_DAMAGE, (double) 9F)
                .add(Attributes.FLYING_SPEED, (double) 0.6F)
                .add(Attributes.FOLLOW_RANGE, 40.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .add(Attributes.ARMOR, 12.0D);
    }


    protected int decreaseAirSupply(int air) {
        return air;
    }


    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LASER_MODE, false);
        this.entityData.define(ISCHARGE, false);
        this.entityData.define(IS_ACT, true);
        this.entityData.define(FIRST_HEAD_TARGET, 0);
        this.entityData.define(SECOND_HEAD_TARGET, 0);
        this.entityData.define(THIRD_HEAD_TARGET, 0);
        this.entityData.define(OVERLOAD, 0);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Is_Act", this.getIsAct());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setIsAct(compound.getBoolean("Is_Act"));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public boolean hurt(DamageSource source, float damage) {
        Entity entity1 = source.getEntity();
        if (entity1 instanceof The_Harbinger_Entity) {
            return false;
        } else {
            for (int i = 0; i < this.idleHeadUpdates.length; ++i) {
                this.idleHeadUpdates[i] += 3;
            }
            double range = calculateRange(source);
            if (range > CMConfig.HarbingerLongRangelimit * CMConfig.HarbingerLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                return false;
            }

            if (this.destroyBlocksTick <= 0) {
                this.destroyBlocksTick = 20;
            }

            if (this.getAnimation() != STUN_ANIAMATION && this.getAnimation() != DEATHLASER_ANIMATION) {
                if (source.is(CMDamageTypes.EMP)) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, STUN_ANIAMATION);
                }
            }
            if (this.isPowered()) {
                Entity entity = source.getDirectEntity();
                if (entity instanceof AbstractArrow) {
                    return false;
                }
            }

            if (this.deactivateProgress > 0) {
                if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                    return false;
                }
            }

            return super.hurt(source, damage);
        }
    }

    
    public float DamageCap() {
        return (float) CMConfig.HarbingerDamageCap;
    }

    public int DamageTime() {
        return CMConfig.HarbingerDamageTime;
    }

    public boolean canBeSeenAsEnemy() {
        return this.getIsAct() && super.canBeSeenAsEnemy();
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_THE_HARBINGER)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    public void aiStep() {
        Vec3 vec3 = this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D);
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        prev_Laser_Mode_Progress = Laser_Mode_Progress;
        if (this.getIsLaserMode() && Laser_Mode_Progress < 30f) {
            Laser_Mode_Progress++;
        }
        if (!this.getIsLaserMode() && Laser_Mode_Progress > 0F) {
            Laser_Mode_Progress--;
        }
        prevdeactivateProgress = deactivateProgress;
        if (!this.getIsAct() && deactivateProgress < 40F) {
            deactivateProgress = 40;
        }
        if (this.getIsAct() && deactivateProgress > 0F) {
            deactivateProgress--;
        }
        if (this.getIsAct()) {
            if (skill_cooldown > 0) skill_cooldown--;
        }


        Entity entity = this.level().getEntity(this.getAlternativeTarget(0));
        if (!this.level().isClientSide && this.getAlternativeTarget(0) > 0 && this.isAlive() && !this.getIsCharge() && this.getAnimation() != STUN_ANIAMATION) {
            if (entity != null) {
                double d0 = vec3.y;
                double l0 = (this.getAnimation() == MISSILE_FIRE_FAST_ANIAMATION || this.getAnimation() == MISSILE_FIRE_ANIAMATION || this.getAnimation() == LAUNCH_ANIAMATION) ? 1.0D : 2.25d;
                if (this.getY() < entity.getY() + l0) {
                    d0 = Math.max(0.0D, d0);
                    d0 += 0.3D - d0 * (double) 0.6F;
                }
                vec3 = new Vec3(vec3.x, d0, vec3.z);
                Vec3 vec31 = new Vec3(entity.getX() - this.getX(), 0.0D, entity.getZ() - this.getZ());
                if (vec31.horizontalDistanceSqr() > 25.0D && !(this.getAnimation() == DEATHLASER_ANIMATION && this.getAnimationTick() > 13 || this.getAnimation() == MISSILE_FIRE_ANIAMATION || this.getAnimation() == MISSILE_FIRE_FAST_ANIAMATION)) {
                    Vec3 vec32 = vec31.normalize();
                    vec3 = vec3.add(vec32.x * 0.3D - vec3.x * 0.6D, 0.0D, vec32.z * 0.3D - vec3.z * 0.6D);
                }

            }
        }

        LivingEntity target = this.getTarget();
        if (this.getIsAct()) {
            if (this.isAlive() && this.deactivateProgress == 0) {
                if (target != null && target.isAlive() && skill_cooldown <= 0 && (Laser_Mode_Progress == 30 || Laser_Mode_Progress == 0)) {
                    if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() >= 3 && this.getRandom().nextFloat() * 100.0F < 3f) {
                        skill_cooldown = SKILL_COOLDOWN;
                        this.setAnimation(DEATHLASER_ANIMATION);
                    } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.distanceToSqr(target) < 64 && (this.getRandom().nextFloat() * 100.0F < 4f && this.hasLineOfSight(target) || this.getRandom().nextFloat() * 100.0F < 20f && !this.hasLineOfSight(target))) {
                        skill_cooldown = SKILL_COOLDOWN;
                        this.setAnimation(CHARGE_ANIMATION);
                    } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.getRandom().nextFloat() * 100.0F < 3f && Laser_Mode_Progress == 0) {
                        skill_cooldown = SKILL_COOLDOWN;
                        this.setAnimation(LAUNCH_ANIAMATION);
                    } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.getOverload() < 3 && this.getRandom().nextFloat() * 100.0F < 1.5f) {
                        skill_cooldown = SKILL_COOLDOWN;
                        Animation missile = this.isPowered() ? MISSILE_FIRE_FAST_ANIAMATION : MISSILE_FIRE_ANIAMATION;
                        this.setAnimation(missile);
                    }
                }
            }
        }
        this.setDeltaMovement(vec3);
        if (vec3.horizontalDistanceSqr() > 0.05D) {
            this.setYRot((float) Mth.atan2(vec3.z, vec3.x) * (180F / (float) Math.PI) - 90.0F);
        }

        super.aiStep();
        for (int i = 0; i < 2; ++i) {
            this.yRotOHeads[i] = this.yRotHeads[i];
            this.xRotOHeads[i] = this.xRotHeads[i];
        }


        if ((this.getAnimation() != CHARGE_ANIMATION) && getIsCharge()) {
            setIsCharge(false);
        }
        //setInvulnerable(!getIsAct());
        if (this.getAnimation() == STUN_ANIAMATION) {
            if (this.getAnimationTick() == 15) {
                this.level().playSound((Player) null, this, ModSounds.HARBINGER_STUN.get(), SoundSource.HOSTILE, 4F, level().random.nextFloat() * 0.2F + 1.0F);
            }
        }
        if (this.getAnimation() == DEATHLASER_ANIMATION) {
            if (this.getAnimationTick() == 33) {
                this.level().playSound((Player) null, this, ModSounds.DEATH_LASER.get(), SoundSource.HOSTILE, 4.0f, 0.75f);
            }
        }

        if (this.getAnimation() == CHARGE_ANIMATION) {
            if (this.getAnimationTick() == 24) {
                this.level().playSound((Player) null, this, ModSounds.HARBINGER_CHARGE.get(), SoundSource.HOSTILE, 4.0f, 0.65f);
            }
        }
        if (this.getAnimation() == MISSILE_FIRE_ANIAMATION || this.getAnimation() == MISSILE_FIRE_FAST_ANIAMATION) {
            if (this.getAnimationTick() == 24) {
                this.level().playSound((Player) null, this, ModSounds.HARBINGER_PREPARE.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
            }
        }


        for (int j = 0; j < 2; ++j) {
            int k = this.getAlternativeTarget(j + 1);
            Entity entity1 = null;
            if (k > 0) {
                entity1 = this.level().getEntity(k);
            }

            if (entity1 != null) {
                double d9 = this.getHeadX(j + 1);
                double d1 = this.getHeadY(j + 1);
                double d3 = this.getHeadZ(j + 1);
                double d4 = entity1.getX() - d9;
                double d5 = entity1.getEyeY() - d1;
                double d6 = entity1.getZ() - d3;
                double d7 = Math.sqrt(d4 * d4 + d6 * d6);
                float f = (float) (Mth.atan2(d6, d4) * (double) (180F / (float) Math.PI)) - 90.0F;
                float f1 = (float) (-(Mth.atan2(d5, d7) * (double) (180F / (float) Math.PI)));
                this.xRotHeads[j] = this.m_31442_(this.xRotHeads[j], f1, 40.0F);
                this.yRotHeads[j] = this.m_31442_(this.yRotHeads[j], f, 10.0F);
            } else {
                this.yRotHeads[j] = this.m_31442_(this.yRotHeads[j], this.yBodyRot, 10.0F);
            }
        }
        if (this.level().isClientSide) {
            if (this.getIsAct()) {
                double d0 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().x;
                double d1 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().y;
                double d2 = (random.nextFloat() - 0.5F) + this.getDeltaMovement().z;
                double dist = 1F + random.nextFloat() * 0.2F;
                double d3 = d0 * dist;
                double d4 = d1 * dist;
                double d5 = d2 * dist;
                this.level().addParticle(new LightningParticle.OrbData(255, 51,  0), this.getX() + d0, this.getY() + 2, this.getZ() + d2, d3, d4, d5);

                if (entity != null && this.getAnimation() != MISSILE_FIRE_ANIAMATION) {
                    float f = Mth.cos((yBodyRot) * ((float) Math.PI / 180F));
                    float f1 = Mth.sin((yBodyRot) * ((float) Math.PI / 180F));
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    double vec = -1.75D;
                    double math = 1.35;
                    for (int i1 = 0; i1 < 10; i1++) {
                        float angle = (0.01745329251F * this.yBodyRot) + i1;
                        double extraX = 0.2F * Mth.sin((float) (Math.PI + angle));
                        double extraY = 2.75F;
                        double extraZ = 0.2F * Mth.cos(angle);
                        this.level().addParticle(ParticleTypes.FLAME, getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, 0, -0.07, 0);
                        this.level().addParticle(ParticleTypes.FLAME, getX() + vec * vecX + extraX + f * -math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * -math, 0, -0.07, 0);
                    }
                    for (int i1 = 0; i1 < 5; i1++) {
                        float angle = (0.01745329251F * this.yBodyRot) + i1;
                        double extraX = 0.2F * Mth.sin((float) (Math.PI + angle));
                        double extraY = 2.75F;
                        double extraZ = 0.2F * Mth.cos(angle);
                        this.level().addParticle(ParticleTypes.SMOKE, getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, 0, -0.07, 0);
                        this.level().addParticle(ParticleTypes.SMOKE, getX() + vec * vecX + extraX + f * -math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * -math, 0, -0.07, 0);
                    }
                }
                if (this.getAnimation() == STUN_ANIAMATION)
                    for (int i = 0; i < 2; ++i) {
                        this.level().addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(1.5D), this.getRandomY(), this.getRandomZ(1.5D), 0.0D, 0.0D, 0.0D);
                    }
            }
        }

    }


    private void blockbreak() {
        if (getIsCharge()) {
            if (!this.level().isClientSide) {
                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    boolean flag = false;
                    AABB aabb = this.getBoundingBox().inflate(1.5D, 0.2D, 1.5D);
                    for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                        BlockState blockstate = this.level().getBlockState(blockpos);
                        if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.HARBINGER_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                            if (random.nextInt(3) == 0 && !blockstate.hasBlockEntity()) {
                                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), blockpos.getX() + 0.5D, blockpos.getY() + 0.5D, blockpos.getZ() + 0.5D, blockstate, 20);
                                flag = this.level().destroyBlock(blockpos, false, this) || flag;
                                fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2D + random.nextDouble()) / 3, 0.2D + getRandom().nextGaussian() * 0.15D, (-1.2D + random.nextDouble()) / 3)));
                                level().addFreshEntity(fallingBlockEntity);
                            } else {
                                flag = this.level().destroyBlock(blockpos, false, this) || flag;
                            }
                        }


                    }
                    if (flag) {
                        this.level().levelEvent((Player) null, 1022, this.blockPosition(), 0);

                    }
                }
            }
            if (this.tickCount % 4 == 0) {
                for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.5D))) {
                    if (!isAlliedTo(Lentity) && !(Lentity instanceof The_Harbinger_Entity) && Lentity != this) {
                        boolean flag = Lentity.hurt(this.damageSources().mobAttack(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + this.random.nextInt(5) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), Lentity.getMaxHealth() * CMConfig.HarbingerChargeHpDamage)));
                        if (flag) {
                            if (Lentity.onGround()) {
                                double d0 = Lentity.getX() - this.getX();
                                double d1 = Lentity.getZ() - this.getZ();
                                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                                float f = 1.5F;
                                Lentity.push(d0 / d2 * f, 0.5F, d1 / d2 * f);
                            }
                        }
                    }
                }
            }
        }
    }


    private void destoryblock2() {
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
            return;
        }
        boolean flag = false;
        if (this.getAnimation() == NO_ANIMATION) {
            if (!getIsCharge()) {
                if (!level().isClientSide && this.blockBreakCounter == 0 && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level(), this)) {
                    AABB aabb = this.getBoundingBox().inflate(0.2D);
                    for (BlockPos pos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                        BlockState blockstate = level().getBlockState(pos);
                        if (!blockstate.isAir()  && blockstate.canEntityDestroy(this.level(), pos, this) && !blockstate.is(ModTag.HARBINGER_IMMUNE)) {
                            if (random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, blockstate, 20);
                                flag = this.level().destroyBlock(pos, false, this) || flag;
                                fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2D + random.nextDouble()) / 3, 0.2D + getRandom().nextGaussian() * 0.15D, (-1.2D + random.nextDouble()) / 3)));
                                level().addFreshEntity(fallingBlockEntity);
                            } else {
                                flag = this.level().destroyBlock(pos, false, this) || flag;
                                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6F, 1, 0.6F));
                            }
                        }
                    }
                }
            }
        }
        if (flag) {
            blockBreakCounter = 20;
            this.level().levelEvent((Player) null, 1022, this.blockPosition(), 0);
        }
    }

    private void destroyBlock(){
        if(this.getAnimation() != STUN_ANIAMATION) {
            if (!this.level().isClientSide){
                if (this.destroyBlocksTick > 0) {
                    --this.destroyBlocksTick;
                    if (this.destroyBlocksTick == 0 && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                        int j1 = Mth.floor(this.getY());
                        int i2 = Mth.floor(this.getX());
                        int j2 = Mth.floor(this.getZ());
                        boolean flag = false;

                        for (int j = -1; j <= 1; ++j) {
                            for (int k2 = -1; k2 <= 1; ++k2) {
                                for (int k = 0; k <= 3; ++k) {
                                    int l2 = i2 + j;
                                    int l = j1 + k;
                                    int i1 = j2 + k2;
                                    BlockPos blockpos = new BlockPos(l2, l, i1);
                                    BlockState blockstate = this.level().getBlockState(blockpos);
                                    if (!blockstate.isAir()  && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.HARBINGER_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                                        if (random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                                            Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), blockpos.getX() + 0.5D, blockpos.getY() + 0.5D, blockpos.getZ() + 0.5D, blockstate, 20);
                                            flag = this.level().destroyBlock(blockpos, false, this) || flag;
                                            fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2D + random.nextDouble()) / 3, 0.2D + getRandom().nextGaussian() * 0.15D, (-1.2D + random.nextDouble()) / 3)));
                                            level().addFreshEntity(fallingBlockEntity);
                                        } else {
                                            flag = this.level().destroyBlock(blockpos, false, this) || flag;
                                        }
                                    }
                                }
                            }
                        }

                        if (flag) {
                            this.level().levelEvent((Player) null, 1022, this.blockPosition(), 0);
                        }
                    }
                }
            }
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (item == Items.NETHER_STAR && !this.getIsAct()) {
            if (!player.isCreative()) {
                itemstack.shrink(1);
            }
            this.setIsAct(true);
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    protected void customServerAiStep() {
        if (this.getIsAct()) {
            if (this.deactivateProgress > 0) {
                float k1 = deactivateProgress - 1;
                if (k1 <= 0) {
                    if (!this.isSilent()) {
                        this.level().globalLevelEvent(1023, this.blockPosition(), 0);
                    }
                }
            }else{
                super.customServerAiStep();
                for (int i = 1; i < 3; ++i) {
                    if (this.tickCount >= this.nextHeadUpdate[i - 1]) {
                        this.nextHeadUpdate[i - 1] = this.tickCount + 10 + this.random.nextInt(10);
                        int l1 = this.getAlternativeTarget(i);
                        if (l1 > 0) {
                            LivingEntity livingentity = (LivingEntity) this.level().getEntity(l1);
                            if (livingentity != null && this.canAttack(livingentity) && !(this.distanceToSqr(livingentity) > 1600.0D) && this.hasLineOfSight(livingentity) && (Laser_Mode_Progress == 30 || Laser_Mode_Progress == 0) && this.getAnimation() == NO_ANIMATION) {
                                this.performRangedAttack(i + 1, livingentity);
                                int f = this.getIsLaserMode() ? 15 + this.random.nextInt(5) : 30 + this.random.nextInt(20);
                                this.nextHeadUpdate[i - 1] = this.tickCount + f;
                                this.idleHeadUpdates[i - 1] = 0;
                            } else {
                                this.setAlternativeTarget(i, 0);
                            }
                        } else {
                            List<LivingEntity> list = this.level().getNearbyEntities(LivingEntity.class, TARGETING_CONDITIONS, this, this.getBoundingBox().inflate(20.0D, 8.0D, 20.0D));
                            if (!list.isEmpty()) {
                                LivingEntity livingentity1 = list.get(this.random.nextInt(list.size()));
                                this.setAlternativeTarget(i, livingentity1.getId());
                            }
                        }
                    }
                }
                blockbreak();
                destroyBlock();
                if (this.getTarget() != null) {
                    destoryblock2();
                }

                if (mode_change_cooldown < MODE_CHANGE_COOLDOWN) {
                    mode_change_cooldown++;
                } else if (this.getAnimation() == NO_ANIMATION) {
                    this.setIsLaserMode(!this.getIsLaserMode());
                    this.playSound(ModSounds.HARBINGER_MODE_CHANGE.get(), 3.0f, 1.0f);
                    mode_change_cooldown = this.random.nextInt(50);
                }

                if (this.getTarget() != null) {
                    this.setAlternativeTarget(0, this.getTarget().getId());
                } else {
                    this.setAlternativeTarget(0, 0);
                }
                if (this.tickCount % 20 == 0) {
                    this.heal((float) CMConfig.HarbingerHealingMultiplier);
                }
            }
        }else{
            if (this.tickCount % 20 == 0) {
                this.heal(50 * (float) CMConfig.HarbingerHealthMultiplier);
            }
        }
    }

    protected SoundEvent getAmbientSound() {
        return this.getIsAct() ? ModSounds.HARBINGER_IDLE.get() : super.getAmbientSound();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.HARBINGER_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.HARBINGER_HURT.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.HARBINGER_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && getIsAct();
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        this.move(MoverType.SELF, new Vec3(0.0D, (double)0.15F, 0.0D));
        this.setYRot(this.yRotO);
        this.yBodyRot = this.getYRot();
        this.yHeadRot = this.getYRot();
        if (this.deathTime == 123) {
            if(!level().isClientSide){
                this.level().explode(this, this.getX(), this.getEyeY(), this.getZ(), 7.0F, false, Level.ExplosionInteraction.MOB);
            }
        }

    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        if (!this.level().isClientSide) {
            if (this.getHomePos() != BlockPos.ZERO) {
                int newX = Mth.floor(this.getHomePos().getX());
                int newY = Mth.floor(this.getHomePos().getY());
                int newZ = Mth.floor(this.getHomePos().getZ());
                BlockPos pos = new BlockPos(newX,newY,newZ);
                BlockState block = ModBlocks.BOSS_RESPAWNER.get().defaultBlockState();
                this.level().setBlock(pos, block, 2);
                if (level().getBlockEntity(pos) instanceof Boss_Respawn_Spawner_Block_Entity spawnerblockentity) {
                    spawnerblockentity.setEntityId(ModEntities.THE_HARBINGER.get());
                    spawnerblockentity.setItem(0,ModItems.MECH_EYE.get().getDefaultInstance());
                }
            }
        }
    }

    private double getHeadX(int head) {
        if (head <= 0) {
            return this.getX();
        } else {
            float f = (this.yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
            float f1 = Mth.cos(f);
            double f2 = this.getIsLaserMode() ? 1.65D : 1.5D;
            return this.getX() + (double)f1 * f2;
        }
    }

    private double getHeadY(int head) {
        return head <= 0 ? this.getY() + 3.0D : this.getY() + 2.6D;
    }

    private double getHeadZ(int head) {
        if (head <= 0) {
            return this.getZ();
        } else {
            float f = (this.yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
            float f1 = Mth.sin(f);
            double f2 = this.getIsLaserMode() ? 1.65D : 1.5D;
            return this.getZ() + (double)f1 * f2;
        }
    }

    private float m_31442_(float p_31443_, float p_31444_, float p_31445_) {
        float f = Mth.wrapDegrees(p_31444_ - p_31443_);
        if (f > p_31445_) {
            f = p_31445_;
        }

        if (f < -p_31445_) {
            f = -p_31445_;
        }

        return p_31443_ + f;
    }

    private void performRangedAttack(int head, LivingEntity target) {
        this.performRangedAttack(head, target.getX(), target.getY() + (double)target.getEyeHeight() * 0.5D, target.getZ());
    }

    private void performRangedAttack(int head, double targetX, double targetY, double targetZ) {
        double d0 = this.getHeadX(head);
        double d1 = this.getHeadY(head);
        double d2 = this.getHeadZ(head);
        double d3 = targetX - d0;
        double d4 = targetY - d1;
        double d5 = targetZ - d2;
        if(this.getIsLaserMode()) {
            if (!this.isSilent()) {
                this.playSound(ModSounds.HARBINGER_LASER.get(),1,1.0F);
            }

            Laser_Beam_Entity laser = new Laser_Beam_Entity(this, d3,d4,d5,this.level(),(float) CMConfig.HarbingerLaserdamage);
            Vec3 vec3 = new Vec3(d3, d4, d5);
            float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;
            float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));

            laser.setYRot(yRot);
            laser.setXRot(xRot);
            laser.setPosRaw(d0, d1, d2);

            this.level().addFreshEntity(laser);
        }else{
            if (!this.isSilent()) {
                this.playSound(ModSounds.ROCKET_LAUNCH.get(),1,0.8F);
            }
            Wither_Missile_Entity witherskull = new Wither_Missile_Entity(this, d3, d4, d5, this.level(),(float) CMConfig.HarbingerWitherMissiledamage);
            witherskull.setPosRaw(d0, d1, d2);
            this.level().addFreshEntity(witherskull);
        }
    }

    public void performRangedAttack(LivingEntity p_31468_, float p_31469_) {
        this.performRangedAttack(0, p_31468_);
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    public float getHeadYRot(int head) {
        return this.yRotHeads[head];
    }

    public float getHeadXRot(int head) {
        return this.xRotHeads[head];
    }

    public int getAlternativeTarget(int head) {
        return this.entityData.get(HEAD_TARGETS.get(head));
    }

    public void setAlternativeTarget(int targetOffset, int newId) {
        this.entityData.set(HEAD_TARGETS.get(targetOffset), newId);
    }


    public void setIsLaserMode(boolean isLaserMode) {
        this.entityData.set(LASER_MODE, isLaserMode);
    }

    public boolean getIsLaserMode() {
        return this.entityData.get(LASER_MODE);
    }

    public void setIsAct(boolean isAct) {
        this.entityData.set(IS_ACT, isAct);
        this.bossEvent.setVisible(isAct);
        this.setHomePos(this.blockPosition());
    }

    public boolean getIsAct() {
        return this.entityData.get(IS_ACT);
    }

    public void setIsCharge(boolean isCharge) {
        this.entityData.set(ISCHARGE, isCharge);
    }

    public boolean getIsCharge() {
        return this.entityData.get(ISCHARGE);
    }

    public void setOverload(int Overload) {
        this.entityData.set(OVERLOAD, Overload);
    }

    public int getOverload() {
        return this.entityData.get(OVERLOAD);
    }


    public boolean isPowered() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    public boolean canChangeDimensions() {
        return false;
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return DEATH_ANIMATION;
    }

    public boolean canBeAffected(MobEffectInstance p_31495_) {
        return p_31495_.getEffect() != MobEffects.MOVEMENT_SLOWDOWN
                && p_31495_.getEffect() != MobEffects.POISON
                && p_31495_.getEffect() != MobEffects.WITHER
                && p_31495_.getEffect() != MobEffects.WEAKNESS
                && p_31495_.getEffect() != MobEffects.LEVITATION
                && super.canBeAffected(p_31495_);
    }


    public BossEvent.BossBarColor bossBarColor() {
        return BossEvent.BossBarColor.PURPLE;
    }


    static class DeathLaserGoal extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public DeathLaserGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            super.start();
            entity.level().playSound((Player) null, entity, ModSounds.HARBINGER_DEATHLASER_PREPARE.get(), SoundSource.HOSTILE, 8.0f, 1.2f);
            entity.setOverload(0);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            if (entity.getAnimationTick() == 18 && !entity.level().isClientSide) {
                //Death_Laser_Beam_Entity DeathBeam = new Death_Laser_Beam_Entity(ModEntities.DEATH_LASER_BEAM.get(), entity.level(), entity, entity.getX() + radius1 * Math.sin(-entity.getYRot() * Math.PI / 180), entity.getY() + 2.9, entity.getZ() + radius1 * Math.cos(-entity.getYRot() * Math.PI / 180), (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 20);
                Death_Laser_Beam_Entity DeathBeam = new Death_Laser_Beam_Entity(ModEntities.DEATH_LASER_BEAM.get(), entity.level(), entity, entity.getX(), entity.getY() + 2.9, entity.getZ(), (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 60,(float) CMConfig.DeathLaserdamage,(float) CMConfig.DeathLaserHpdamage);
                if(entity.isPowered()){
                    DeathBeam.setFire(true);
                }
                entity.level().addFreshEntity(DeathBeam);
            }

            if (entity.getAnimationTick() >= 35) {
                if (target != null) {
                    entity.getLookControl().setLookAt(target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ(), 6, 90);
                    entity.lookAt(target, 30, 30);
                }
            }
        }
    }

    static class ChargeGoal extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public ChargeGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            super.start();
            entity.setOverload(entity.getOverload() + 1);
            entity.level().playSound((Player) null, entity, ModSounds.HARBINGER_CHARGE_PREPARE.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();


            if (entity.getAnimationTick() == 24) {
                entity.setIsCharge(true);

            }
            if (entity.getAnimationTick() == 36) {
                entity.setIsCharge(false);
            }

            if (target != null) {
                if (entity.getAnimationTick() < 24) {
                    entity.lookAt(target, 30, 30);
                    entity.getLookControl().setLookAt(target, 30, 30);
                }
                if (entity.getAnimationTick() == 24) {
                    //  Vec3 vec3 = (new Vec3(target.getX() - entity.getX(), target.getY() - entity.getY(), target.getZ() - entity.getZ()));
                    // entity.setDeltaMovement(vec3.x * 0.8,vec3.y * 1.0, vec3.z * 0.8);
                    //entity.setDeltaMovement(entity.getDeltaMovement().add(vec3.x * 0.8D, 0.9D, vec3.z * 0.8D));
                    Vec3 rot = target.position().subtract(0.0, 2.0, 0.0).add(entity.position().multiply(-1.0, -1.0, -1.0)).normalize();
                    entity.setDeltaMovement(rot.multiply(4.0, 5.0, 4.0));
                }
                if (entity.getAnimationTick() == 45) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(entity, CHARGE_ANIMATION);
                }
            }

        }

        public void stop() {
            super.stop();
            LivingEntity target = entity.getTarget();
            if(entity.getOverload() < 3 && entity.isPowered() && target !=null && entity.random.nextInt(2) == 0){
                AnimationHandler.INSTANCE.sendAnimationMessage(entity, CHARGE_ANIMATION);
            }
        }

    }


    static class LaunchGoal extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public LaunchGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            super.start();
            entity.setOverload(entity.getOverload() + 1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                if (entity.getAnimationTick() == 13) {
                    this.launch(2, (LivingEntity) target);
                }

                if (entity.getAnimationTick() == 19) {
                    this.launch(1, (LivingEntity) target);
                }
            }


        }


        private void launch(int head, LivingEntity p_31459_) {
            this.launch(head, p_31459_.getX(), p_31459_.getY() + (double)p_31459_.getEyeHeight() * 0.5D, p_31459_.getZ());
        }


        private void launch(int head, double p_31450_, double p_31451_, double p_31452_) {
            if (!entity.isSilent()) {
                entity.playSound(ModSounds.ROCKET_LAUNCH.get(),1,1.0F);
            }
            double d0 = entity.getHeadX(head);
            double d1 = entity.getHeadY(head);
            double d2 = entity.getHeadZ(head);
            double d3 = p_31450_ - d0;
            double d4 = p_31451_ - d1;
            double d5 = p_31452_ - d2;
            double d6 = Mth.sqrt((float) (d3 * d3 + d5 * d5));

            int b = entity.isPowered() ? 7 : 5;
            for (int i = 0; i < b; ++i) {
                Wither_Howitzer_Entity lava = new Wither_Howitzer_Entity(ModEntities.WITHER_HOWITZER.get(), entity.level(), entity);
                lava.setPosRaw(d0, d1, d2);
                lava.setRadius(3.0F);
                lava.shoot(d3, d4 + d6 * 6F, d5, 0.6F, 60);
                entity.level().addFreshEntity(lava);
            }
        }
    }


    static class MissileLaunchGoal extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public MissileLaunchGoal(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            super.start();
            entity.setOverload(entity.getOverload() + 1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.lookAt(target, 30, 30);
                entity.getLookControl().setLookAt(target, 30, 30);
                if (entity.getAnimationTick() == 80 || entity.getAnimationTick() == 84  || entity.getAnimationTick() == 88) {
                    this.mlaunch(2, target);
                }
                if (entity.getAnimationTick() == 98 || entity.getAnimationTick() == 102 || entity.getAnimationTick() == 106) {
                    this.mlaunch(1, target);
                }


            }
        }

        private void mlaunch(int head, LivingEntity target) {
            if (!entity.isSilent()) {
                entity.playSound(ModSounds.ROCKET_LAUNCH.get(),1,1.0F);
            }
            double d0 = this.getLauncherX(head);
            double d1 = this.getLauncherY(head);
            double d2 = this.getLauncherZ(head);

            Wither_Homing_Missile_Entity laserBeam = new Wither_Homing_Missile_Entity(entity.level(),entity,target);
            laserBeam.setPosRaw(d0, d1, d2);
            entity.level().addFreshEntity(laserBeam);
        }


        private double getLauncherX(int head) {
            if (head <= 0) {
                return entity.getX();
            } else {
                double theta = (entity.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                float f = (entity.yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
                float f1 = Mth.cos(f);
                return entity.getX() + (double)f1 * 1.25D + vecX * 1.35D;
            }
        }

        private double getLauncherY(int head) {
            return head <= 0 ? entity.getY() + 3.0D : entity.getY() + 3.8D;
        }

        private double getLauncherZ(int head) {
            if (head <= 0) {
                return entity.getZ();
            } else {
                double theta = (entity.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecZ = Math.sin(theta);
                float f = (entity.yBodyRot + (float)(180 * (head - 1))) * ((float)Math.PI / 180F);
                float f1 = Mth.sin(f);
                return entity.getZ() + (double)f1 * 1.25D + vecZ * 1.35D;
            }
        }



    }

    class AwakenGoal extends Goal {

        public AwakenGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public boolean canUse() {
            return deactivateProgress > 0F;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            The_Harbinger_Entity.this.setDeltaMovement(0, The_Harbinger_Entity.this.getDeltaMovement().y, 0);
        }
    }

    static class MissileLaunchGoal2 extends SimpleAnimationGoal<The_Harbinger_Entity> {

        public MissileLaunchGoal2(The_Harbinger_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            super.start();
            entity.setOverload(entity.getOverload() + 1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.lookAt(target, 30, 30);
                entity.getLookControl().setLookAt(target, 30, 30);
                if (entity.getAnimationTick() == 71 || entity.getAnimationTick() == 75 || entity.getAnimationTick() == 79) {
                    this.mlaunch(2, target);
                    this.mlaunch(1, target);
                }
            }
        }

        private void mlaunch(int head, LivingEntity target) {
            if (!entity.isSilent()) {
                entity.playSound(ModSounds.ROCKET_LAUNCH.get(),1,1.0F);
            }
            double d0 = this.getLauncherX(head);
            double d1 = this.getLauncherY(head);
            double d2 = this.getLauncherZ(head);

            Wither_Homing_Missile_Entity laserBeam = new Wither_Homing_Missile_Entity(entity.level(), entity, target);
            laserBeam.setPosRaw(d0, d1, d2);
            entity.level().addFreshEntity(laserBeam);
        }


        private double getLauncherX(int head) {
            if (head <= 0) {
                return entity.getX();
            } else {
                double theta = (entity.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                float f = (entity.yBodyRot + (float) (180 * (head - 1))) * ((float) Math.PI / 180F);
                float f1 = Mth.cos(f);
                return entity.getX() + (double) f1 * 1.25D + vecX * 1.35D;
            }
        }

        private double getLauncherY(int head) {
            return head <= 0 ? entity.getY() + 3.0D : entity.getY() + 3.8D;
        }

        private double getLauncherZ(int head) {
            if (head <= 0) {
                return entity.getZ();
            } else {
                double theta = (entity.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecZ = Math.sin(theta);
                float f = (entity.yBodyRot + (float) (180 * (head - 1))) * ((float) Math.PI / 180F);
                float f1 = Mth.sin(f);
                return entity.getZ() + (double) f1 * 1.25D + vecZ * 1.35D;
            }
        }
    }
}





