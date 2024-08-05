package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.*;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Flame_Strike_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Hold_Attack_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.IHoldEntity;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Ignis_Abyss_Fireball_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Ignis_Fireball_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.world.data.CMWorldData;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import com.google.common.collect.ImmutableList;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Stream;

public class Ignis_Entity extends LLibrary_Boss_Monster implements IHoldEntity {
    private final CMBossInfoServer bossInfo = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.YELLOW, false,2);
    public static final Animation SWING_ATTACK = Animation.create(55);
    public static final Animation SWING_ATTACK_SOUL = Animation.create(46);
    public static final Animation SWING_ATTACK_BERSERK = Animation.create(37);
    public static final Animation HORIZONTAL_SWING_ATTACK = Animation.create(68);
    public static final Animation HORIZONTAL_SWING_ATTACK_SOUL = Animation.create(58);
    public static final Animation SHIELD_SMASH_ATTACK = Animation.create(70);
    public static final Animation PHASE_2 = Animation.create(68);
    public static final Animation POKE_ATTACK = Animation.create(65);
    public static final Animation POKE_ATTACK2 = Animation.create(56);
    public static final Animation POKE_ATTACK3 = Animation.create(50);
    public static final Animation POKED_ATTACK = Animation.create(65);
    public static final Animation PHASE_3 = Animation.create(120);
    public static final Animation MAGIC_ATTACK = Animation.create(69);
    public static final Animation SMASH_IN_AIR = Animation.create(105);
    public static final Animation SMASH = Animation.create(47);
    public static final Animation BODY_CHECK_ATTACK1 = Animation.create(62);
    public static final Animation BODY_CHECK_ATTACK2 = Animation.create(62);
    public static final Animation BODY_CHECK_ATTACK3 = Animation.create(62);
    public static final Animation BODY_CHECK_ATTACK4 = Animation.create(62);
    public static final Animation BODY_CHECK_ATTACK_SOUL1 = Animation.create(45);
    public static final Animation BODY_CHECK_ATTACK_SOUL2 = Animation.create(45);
    public static final Animation BODY_CHECK_ATTACK_SOUL3 = Animation.create(45);
    public static final Animation BODY_CHECK_ATTACK_SOUL4 = Animation.create(45);
    public static final Animation IGNIS_DEATH = Animation.create(124);
    public static final Animation COUNTER = Animation.create(61);
    public static final Animation STRIKE = Animation.create(62);
    public static final Animation COMBO1 = Animation.create(102);
    public static final Animation COMBO2 = Animation.create(131);
    public static final Animation BREAK_THE_SHIELD = Animation.create(87);
    public static final Animation SWING_UPPERCUT = Animation.create(65);
    public static final Animation SWING_UPPERSLASH = Animation.create(54);
    public static final Animation SPIN_ATTACK = Animation.create(38);
    public static final Animation EARTH_SHUDDERS_ATTACK = Animation.create(138);
    public static final Animation HORIZONTAL_SMALL_SWING_ATTACK = Animation.create(44);
    public static final Animation HORIZONTAL_SMALL_SWING_ALT_ATTACK2 = Animation.create(38);
    public static final Animation REINFORCED_SMASH_IN_AIR = Animation.create(162);
    public static final Animation REINFORCED_SMASH = Animation.create(115);
    public static final Animation REINFORCED_SMASH_IN_AIR_SOUL = Animation.create(162);
    public static final Animation REINFORCED_SMASH_SOUL = Animation.create(115);
    public static final Animation SHIELD_BREAK_COUNTER = Animation.create(53);
    public static final Animation SHIELD_BREAK_STRIKE = Animation.create(64);
    public static final Animation ULTIMATE_ATTACK = Animation.create(114);
    public static final int NATURE_HEAL_COOLDOWN = 200;
    public static final int AIR_SMASH_COOLDOWN = 240;
    public static final int BODY_CHECK_COOLDOWN = 200;
    public static final int POKE_COOLDOWN = 240;
    public static final int CONTER_STRIKE_COOLDOWN = 360;
    public static final int EARTH_SHUDDERS_COOLDOWN = 800;
    public static final int SWORD_DANCE_COOLDOWN = 600;
    public static final int HORIZONTAL_SMALL_SWING_COOLDOWN = 100;
    public static final int HORIZONTAL_SWING_COOLDOWN = 160;
    public static final int MAGIC_COOLDOWN = 300;
    public static final int REINFORCED_SMASH_COOLDOWN = 1800;
    public static final int ULTIMATE_COOLDOWN = 1200;
    private static final EntityDataAccessor<Boolean> IS_BLOCKING = SynchedEntityData.defineId(Ignis_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_SHIELD_BREAK = SynchedEntityData.defineId(Ignis_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> SHIELD_DURABILITY = SynchedEntityData.defineId(Ignis_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> IS_SHIELD = SynchedEntityData.defineId(Ignis_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SHOW_SHIELD = SynchedEntityData.defineId(Ignis_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_SWORD = SynchedEntityData.defineId(Ignis_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> BOSS_PHASE = SynchedEntityData.defineId(Ignis_Entity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Optional<UUID>> HELD_UUID = SynchedEntityData.defineId(Ignis_Entity.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> HELD_ID = SynchedEntityData.defineId(Ignis_Entity.class, EntityDataSerializers.INT);

    private Vec3 prevBladePos = new Vec3(0, 0, 0);

    private int air_smash_cooldown = 0;
    private int body_check_cooldown = 0;
    private int poke_cooldown = 0;
    private int counter_strike_cooldown = 0;
    private int horizontal_small_swing_cooldown = 0;
    private int horizontal_swing_cooldown = 0;
    private int magic_cooldown = 0;
    private int earth_shudders_cooldown = 0;
    private int sword_dance_cooldown = 0;
    private int reinforced_smash_cooldown = 1800;
    private int ultimate_cooldown = 0;
    private boolean Combo = false;
    private int CanSpin = 0;

    private int timeWithoutTarget;
    private int destroyBlocksTick;
    public float blockingProgress;
    public float swordProgress;
    public float prevblockingProgress;
    public float prevswordProgress;

    public Ignis_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
        this.setMaxUpStep(2.5F);
        if (world.isClientSide)
            socketPosArray = new Vec3[]{new Vec3(0, 0, 0)};
        setConfigattribute(this, CMConfig.IgnisHealthMultiplier, CMConfig.IgnisDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{
                NO_ANIMATION,
                SWING_ATTACK,
                SWING_ATTACK_SOUL,
                SWING_ATTACK_BERSERK,
                SWING_UPPERCUT,
                SWING_UPPERSLASH,
                SPIN_ATTACK,
                HORIZONTAL_SWING_ATTACK,
                HORIZONTAL_SWING_ATTACK_SOUL,
                POKE_ATTACK,
                POKE_ATTACK2,
                POKE_ATTACK3,
                POKED_ATTACK,
                MAGIC_ATTACK,
                PHASE_3,
                SHIELD_SMASH_ATTACK,
                PHASE_2,
                BODY_CHECK_ATTACK4,
                BODY_CHECK_ATTACK3,
                BODY_CHECK_ATTACK2,
                BODY_CHECK_ATTACK1,
                BODY_CHECK_ATTACK_SOUL1,
                BODY_CHECK_ATTACK_SOUL2,
                BODY_CHECK_ATTACK_SOUL3,
                BODY_CHECK_ATTACK_SOUL4,
                SMASH,
                COUNTER,
                STRIKE,
                SMASH_IN_AIR,
                BREAK_THE_SHIELD,
                COMBO1,
                COMBO2,
                EARTH_SHUDDERS_ATTACK,
                HORIZONTAL_SMALL_SWING_ATTACK,
                HORIZONTAL_SMALL_SWING_ALT_ATTACK2,
                REINFORCED_SMASH_IN_AIR,
                REINFORCED_SMASH,
                REINFORCED_SMASH_IN_AIR_SOUL,
                REINFORCED_SMASH_SOUL,
                SHIELD_BREAK_COUNTER,
                SHIELD_BREAK_STRIKE,
                ULTIMATE_ATTACK,
                IGNIS_DEATH};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new AttackMoveGoal(this, true, 1.0D));
        this.goalSelector.addGoal(1, new Hornzontal_SwingGoal(this, HORIZONTAL_SWING_ATTACK, 31, 51, 20, 36));
        this.goalSelector.addGoal(1, new Hornzontal_SwingGoal(this, HORIZONTAL_SWING_ATTACK_SOUL, 27, 47, 16, 31));
        this.goalSelector.addGoal(1, new PokeGoal(this, POKE_ATTACK, 39, 59, 34, 41, 34, 40));
        this.goalSelector.addGoal(1, new PokeGoal(this, POKE_ATTACK2, 33, 53, 28, 35, 28, 34));
        this.goalSelector.addGoal(1, new PokeGoal(this, POKE_ATTACK3, 29, 49, 24, 31, 24, 30));
        this.goalSelector.addGoal(1, new Combo1(this, COMBO1));
        this.goalSelector.addGoal(1, new Combo2(this, COMBO2, 34, 12.0F, 27, 0.3f, 0.3f));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, PHASE_3, 34, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, SWING_UPPERSLASH, 23, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, BREAK_THE_SHIELD, 35, false));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, COMBO1, 10, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, MAGIC_ATTACK, 49, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, ULTIMATE_ATTACK, 72, true) {
            @Override
            public void start() {
                super.start();
                float f1 = (float) Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
                float f0 = (float) Mth.atan2(f1, f2);
                Ignis_Entity.this.spawnFlameStrike(Ignis_Entity.this.getX(), Ignis_Entity.this.getZ(), Ignis_Entity.this.getY(), Ignis_Entity.this.getY(), f0, 30, 68, 0, 5.0f, true);
            }
        });
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, COUNTER, 55, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, SHIELD_BREAK_COUNTER, 60, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, STRIKE, 34, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, SHIELD_BREAK_STRIKE, 34, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal2<>(this, PHASE_2, 34, 54));
        this.goalSelector.addGoal(1, new AttackAniamtionGoal3<>(this, SMASH));
        this.goalSelector.addGoal(1, new AttackAniamtionGoal3<>(this, REINFORCED_SMASH_SOUL));
        this.goalSelector.addGoal(1, new AttackAniamtionGoal3<>(this, REINFORCED_SMASH));
        this.goalSelector.addGoal(1, new PredictiveChargeAttackAnimationGoal<>(this, SWING_UPPERCUT, 34, 50, 12.0F, 27, 0.3f, 0.3f));
        this.goalSelector.addGoal(1, new Shield_Smash(this, SHIELD_SMASH_ATTACK));
        this.goalSelector.addGoal(1, new Poked(this, POKED_ATTACK));
        this.goalSelector.addGoal(1, new Air_Smash(this, SMASH_IN_AIR));
        this.goalSelector.addGoal(1, new Swing_Attack_Goal(this, SWING_ATTACK, 24, 30));
        this.goalSelector.addGoal(1, new Swing_Attack_Goal(this, SWING_ATTACK_SOUL, 18, 24));
        this.goalSelector.addGoal(1, new Swing_Attack_Goal(this, SWING_ATTACK_BERSERK, 17, 23));
        this.goalSelector.addGoal(1, new Hornzontal_Small_SwingGoal(this, 19, 13, 12, 21));
        this.goalSelector.addGoal(1, new Body_Check_Attack(this));
        this.goalSelector.addGoal(1, new Earth_Shudders(this, EARTH_SHUDDERS_ATTACK));
        this.goalSelector.addGoal(1, new Reinforced_Air_Smash(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

    }


    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        LivingEntity target = this.getTarget();
        double range = calculateRange(source);

        if (entity != null && !isNoAi() && (blockingProgress == 10 || swordProgress == 10)) {
            if (target != null && target.isAlive()) {
                if (this.getAnimation() == NO_ANIMATION) {
                    if (this.getRandom().nextFloat() * 100.0F < 12f && counter_strike_cooldown <= 0 && range < 225) {
                        counter_strike_cooldown = CONTER_STRIKE_COOLDOWN;
                        Animation counter = this.getIsShieldBreak() ? SHIELD_BREAK_COUNTER : COUNTER;
                        this.setAnimation(counter);
                    }
                }
            }
            if (this.getAnimation() == COUNTER) {
                if (this.getAnimationTick() > 16 && this.getAnimationTick() <= 46) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, STRIKE);
                    this.playSound(SoundEvents.BLAZE_HURT, 0.5f, 0.4F + this.getRandom().nextFloat() * 0.1F);
                    if( !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                        return false;
                    }
                }
            }
            if (this.getAnimation() == SHIELD_BREAK_COUNTER) {
                if (this.getAnimationTick() > 8 && this.getAnimationTick() <= 38) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, SHIELD_BREAK_STRIKE);
                    this.playSound(SoundEvents.BLAZE_HURT, 0.5f, 0.4F + this.getRandom().nextFloat() * 0.1F);
                    if(!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                        return false;
                    }
                }
            }
        }

        if (source.getDirectEntity() instanceof Ignis_Abyss_Fireball_Entity) {
            if (!(source.getEntity() instanceof Ignis_Entity)) {
                if (source.is(DamageTypeTags.IS_PROJECTILE)) {
                    if (this.getShieldDurability() < 3) {
                        this.playSound(ModSounds.IGNIS_ARMOR_BREAK.get(), 1.0F, 0.8F);
                        if (!level().isClientSide) {
                            this.setShieldDurability(this.getShieldDurability() + 1);
                        }
                    }
                }
            } else {
                return false;
            }
        }

        if (range > CMConfig.IgnisLongRangelimit * CMConfig.IgnisLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        if ((this.getAnimation() == ULTIMATE_ATTACK || this.getBossPhase() == 1 && this.getHealth() <= this.getMaxHealth() * 1 / 3 || this.getBossPhase() == 0 && this.getHealth() <= this.getMaxHealth() * 2 / 3) && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            damage *= 0.5;
        }

        if ((this.getAnimation() == PHASE_3 || this.getAnimation() == PHASE_2 || this.getAnimation() == STRIKE) && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (source.getDirectEntity() instanceof Ignis_Fireball_Entity) {
            return false;
        }
        if (damage > 0.0F && this.canBlockDamageSource(source)) {
            this.hurtCurrentlyUsedShield(damage);
            if (!source.is(DamageTypeTags.IS_PROJECTILE)) {
                if (entity instanceof LivingEntity) {
                    this.blockUsingShield((LivingEntity) entity);
                }
            }
            this.playSound(SoundEvents.BLAZE_HURT, 0.5f, 0.4F + this.getRandom().nextFloat() * 0.1F);
            return false;
        }

        if (this.destroyBlocksTick <= 0) {
            this.destroyBlocksTick = 20;
        }

        Crackiness irongolem$crackiness = this.getCrackiness();
        boolean attack = super.hurt(source, damage);
        if (attack && this.getCrackiness() != irongolem$crackiness) {
            this.playSound(ModSounds.IGNIS_ARMOR_BREAK.get(), 1.0f, 0.8f);
        }

        return attack;
    }

    @Override
    public float DamageCap() {
        return (float) CMConfig.IgnisDamageCap;
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Entity entity = damageSourceIn.getDirectEntity();
        boolean flag = false;

        if (entity instanceof Ignis_Abyss_Fireball_Entity) {
            if (!(damageSourceIn.getEntity() instanceof Ignis_Entity)) {
                flag = true;
            }
        }

        if (!damageSourceIn.is(DamageTypeTags.BYPASSES_SHIELD) && !flag && this.getIsShield()) {
            Vec3 vector3d2 = damageSourceIn.getSourcePosition();
            if (vector3d2 != null) {
                Vec3 vector3d = this.getViewVector(1.0F);
                Vec3 vector3d1 = vector3d2.vectorTo(this.position()).normalize();
                vector3d1 = new Vec3(vector3d1.x, 0.0D, vector3d1.z);
                return vector3d1.dot(vector3d) < 0.0D;
            }
        }
        return false;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_BLOCKING, false);
        this.entityData.define(IS_SHIELD, false);
        this.entityData.define(IS_SHIELD_BREAK, false);
        this.entityData.define(SHIELD_DURABILITY, 0);
        this.entityData.define(IS_SWORD, false);
        this.entityData.define(SHOW_SHIELD, true);
        this.entityData.define(BOSS_PHASE, 0);
        this.entityData.define(HELD_UUID, Optional.empty());
        this.entityData.define(HELD_ID, -1);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("BossPhase", this.getBossPhase());
        compound.putBoolean("Is_Shield_Break", this.getIsShieldBreak());
        compound.putInt("Shield_Durability", this.getShieldDurability());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setBossPhase(compound.getInt("BossPhase"));
        this.setIsShieldBreak(compound.getBoolean("Is_Shield_Break"));
        this.setShieldDurability(compound.getInt("Shield_Durability"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void setIsBlocking(boolean isBlocking) {
        if (isBlocking) {
            if (this.getIsSword()) {
                this.setIsSword(false);
            }
        }
        this.entityData.set(IS_BLOCKING, isBlocking);
    }

    public boolean getIsBlocking() {
        return this.entityData.get(IS_BLOCKING);
    }

    public void setIsShield(boolean isShield) {
        this.entityData.set(IS_SHIELD, isShield);
    }

    public boolean getIsShield() {
        return this.entityData.get(IS_SHIELD);
    }

    public void setIsSword(boolean isSword) {
        if (isSword) {
            if (this.getIsBlocking()) {
                this.setIsBlocking(false);
            }
        }
        this.entityData.set(IS_SWORD, isSword);
    }

    public boolean getIsSword() {
        return this.entityData.get(IS_SWORD);
    }

    public void setIsShieldBreak(boolean isShieldBreak) {
        if (isShieldBreak) {
            if (this.getIsBlocking()) {
                this.setIsBlocking(false);
                this.setIsSword(true);
            }
            this.setShieldDurability(3);
            this.setShowShield(false);
        }
        this.entityData.set(IS_SHIELD_BREAK, isShieldBreak);
    }

    public boolean getIsShieldBreak() {
        return this.entityData.get(IS_SHIELD_BREAK);
    }

    public void setShieldDurability(int ShieldDurability) {
        this.entityData.set(SHIELD_DURABILITY, ShieldDurability);
    }

    public int getShieldDurability() {
        return this.entityData.get(SHIELD_DURABILITY);
    }

    public void setShowShield(boolean showShield) {
        this.entityData.set(SHOW_SHIELD, showShield);
    }

    public boolean getShowShield() {
        return this.entityData.get(SHOW_SHIELD);
    }

    public void setBossPhase(int bossPhase) {
        this.entityData.set(BOSS_PHASE, bossPhase);
    }

    public int getBossPhase() {
        return this.entityData.get(BOSS_PHASE);
    }


    public void setHeldUUID(@Nullable UUID uniqueId) {
        this.entityData.set(HELD_UUID, Optional.ofNullable(uniqueId));
    }

    public UUID getHeldUUID() {
        return this.entityData.get(HELD_UUID).orElse(null);
    }

    public Entity getHeldEntity() {
        if (!level().isClientSide) {
            UUID id = getHeldUUID();
            return id == null ? null : ((ServerLevel) level()).getEntity(id);
        } else {
            int id = this.entityData.get(HELD_ID);
            return id == -1 ? null : level().getEntity(id);
        }
    }

    public Crackiness getCrackiness() {
        return Crackiness.byFraction(this.getHealth() / this.getMaxHealth());
    }

    public static AttributeSupplier.Builder ignis() {
        return createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.33F)
                .add(Attributes.ATTACK_DAMAGE, 14)
                .add(Attributes.MAX_HEALTH, 450)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    private void floatStrider() {
        if (this.isInLava()) {
            CollisionContext lvt_1_1_ = CollisionContext.of(this);
            if (lvt_1_1_.isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition().below(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.LAVA)) {
                this.setOnGround(true);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5D).add(0.0D, random.nextFloat() * 0.5, 0.0D));
            }
        }

    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setDeltaMovement(itementity.getDeltaMovement().multiply(0.0, 1.5, 0.0));
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.IGNIS_AMBIENT.get();
    }

    private static Animation getRandomPoke(RandomSource rand) {
        switch (rand.nextInt(3)) {
            case 0:
                return POKE_ATTACK;
            case 1:
                return POKE_ATTACK2;
            case 2:
                return POKE_ATTACK3;
        }
        return POKE_ATTACK;
    }

    private static Animation getRandomReinforced(RandomSource rand) {
        switch (rand.nextInt(2)) {
            case 0:
                return REINFORCED_SMASH_IN_AIR;
            case 1:
                return REINFORCED_SMASH_IN_AIR_SOUL;
        }
        return REINFORCED_SMASH_IN_AIR;
    }

    public boolean canStandOnFluid(FluidState p_204067_) {
        return p_204067_.is(FluidTags.LAVA);
    }

    public void tick() {
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        prevblockingProgress = blockingProgress;
        prevswordProgress = swordProgress;
        floatStrider();
        if (this.getIsBlocking() && blockingProgress < 10F) {
            blockingProgress++;
        }
        if (!this.getIsBlocking() && blockingProgress > 0F) {
            blockingProgress--;
        }
        if (this.getIsSword() && swordProgress < 10F) {
            swordProgress++;
        }
        if (!this.getIsSword() && swordProgress > 0F) {
            swordProgress--;
        }

        LivingEntity target = this.getTarget();
        SwingParticles();
        if (this.level().isClientSide) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.level().playLocalSound(this.getX() + 0.5D, this.getY() + 0.5D, this.getZ() + 0.5D, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }
            if (this.getBossPhase() > 1) {
                int i = this.getCrackiness() == Crackiness.NONE ? 5 : this.getCrackiness() == Crackiness.LOW ? 4 : this.getCrackiness() == Crackiness.MEDIUM ? 3 : 2;
                if (random.nextInt(i) == 0) {
                    this.level().addParticle(ModParticle.SOUL_LAVA.get(), this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
                }
            } else {
                for (int i = 0; i < 2; ++i) {
                    this.level().addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
                }
            }

        } else {
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
                if (this.getIsShieldBreak()) {
                    this.setIsSword(true);
                } else {
                    this.setIsBlocking(true);
                }
            }

            if (this.getAnimation() == NO_ANIMATION && timeWithoutTarget <= 0) {
                if(!isNoAi() && CMConfig.IgnisNatureHealing > 0 ) {
                    if (this.tickCount % 20 == 0) {
                        this.heal((float) CMConfig.IgnisNatureHealing);
                    }
                }
                if(this.getIsBlocking() || this.getIsSword() && target == null){
                    this.setIsSword(false);
                    this.setIsBlocking(false);
                }
            }
            if (this.getBossPhase() > 0) {
                this.bossInfo.setColor(BossEvent.BossBarColor.BLUE);
                this.bossInfo.setRenderType(3);
            }
            if (this.getBossPhase() > 1) {
                bossInfo.setDarkenScreen(true);
                if (this.getAnimation() != PHASE_3) {
                    this.setIsShieldBreak(true);
                }
            }

            if (this.getIsBlocking() && blockingProgress == 10) {
                if (this.getAnimation() == NO_ANIMATION) {
                    setIsShield(true);
                } else if (this.getAnimation() == COUNTER) {
                    setIsShield(true);
                } else if (this.getAnimation() == STRIKE) {
                    setIsShield(false);
                } else if (this.getAnimation() == POKED_ATTACK) {
                    setIsShield(false);
                } else if (this.getAnimation() == BREAK_THE_SHIELD) {
                    setIsShield(false);
                } else if (this.getAnimation() == HORIZONTAL_SWING_ATTACK) {
                    setIsShield(this.getAnimationTick() > 31);
                } else if (this.getAnimation() == HORIZONTAL_SWING_ATTACK_SOUL) {
                    setIsShield(this.getAnimationTick() > 27);
                } else if (this.getAnimation() == BODY_CHECK_ATTACK1 || this.getAnimation() == BODY_CHECK_ATTACK2 ||
                        this.getAnimation() == BODY_CHECK_ATTACK3 || this.getAnimation() == BODY_CHECK_ATTACK4) {
                    setIsShield(this.getAnimationTick() < 25);
                } else if (this.getAnimation() == BODY_CHECK_ATTACK_SOUL1 || this.getAnimation() == BODY_CHECK_ATTACK_SOUL2 ||
                        this.getAnimation() == BODY_CHECK_ATTACK_SOUL3 || this.getAnimation() == BODY_CHECK_ATTACK_SOUL4) {
                    setIsShield(this.getAnimationTick() < 21);
                } else if (this.getAnimation() == POKE_ATTACK) {
                    setIsShield(this.getAnimationTick() < 39);
                } else if (this.getAnimation() == POKE_ATTACK2) {
                    setIsShield(this.getAnimationTick() < 34);
                } else if (this.getAnimation() == POKE_ATTACK3) {
                    setIsShield(this.getAnimationTick() < 29);
                } else if (this.getAnimation() == SWING_ATTACK) {
                    setIsShield(this.getAnimationTick() < 24);
                } else if (this.getAnimation() == SWING_ATTACK_SOUL) {
                    setIsShield(this.getAnimationTick() < 18);
                } else if (this.getAnimation() == SWING_ATTACK_BERSERK) {
                    setIsShield(this.getAnimationTick() < 15);
                } else if (this.getAnimation() == SWING_UPPERSLASH) {
                    setIsShield(this.getAnimationTick() > 27);
                } else if (this.getAnimation() == MAGIC_ATTACK) {
                    setIsShield(this.getAnimationTick() > 34 && this.getAnimationTick() < 46);
                } else if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ATTACK) {
                    setIsShield(false);
                } else if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ALT_ATTACK2) {
                    setIsShield(false);
                } else if (this.getAnimation() == EARTH_SHUDDERS_ATTACK) {
                    setIsShield(false);
                } else if (this.getAnimation() == REINFORCED_SMASH_SOUL || this.getAnimation() == REINFORCED_SMASH) {
                    setIsShield(this.getAnimationTick() > 6 && this.getAnimationTick() < 19);
                } else if (this.getAnimation() == REINFORCED_SMASH_IN_AIR_SOUL || this.getAnimation() == REINFORCED_SMASH_IN_AIR) {
                    setIsShield(false);
                }
            } else {
                setIsShield(false);
            }

        }
        
        if (body_check_cooldown > 0) body_check_cooldown--;
        if (air_smash_cooldown > 0) air_smash_cooldown--;
        if (counter_strike_cooldown > 0) counter_strike_cooldown--;
        if (poke_cooldown > 0) poke_cooldown--;
        if (earth_shudders_cooldown > 0) earth_shudders_cooldown--;
        if (horizontal_small_swing_cooldown > 0) horizontal_small_swing_cooldown--;
        if (horizontal_swing_cooldown > 0) horizontal_swing_cooldown--;
        if (magic_cooldown > 0) magic_cooldown--;
        if (reinforced_smash_cooldown > 0) reinforced_smash_cooldown--;
        if (sword_dance_cooldown > 0) sword_dance_cooldown--;
        if (ultimate_cooldown > 0) ultimate_cooldown--;
        repelEntities(1.4F, 4, 1.4F, 1.4F);

        Animation animation = getRandomPoke(random);
        if (this.isAlive()) {
            if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.getShieldDurability() > 2 && !this.getIsShieldBreak()) {
                this.setAnimation(BREAK_THE_SHIELD);
            } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.getHealth() <= this.getMaxHealth() * 2 / 3 && this.getBossPhase() < 1) {
                this.setAnimation(PHASE_2);
            } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.getHealth() <= this.getMaxHealth() * 1 / 3 && this.getBossPhase() < 2) {
                this.setAnimation(PHASE_3);
            } else if (target != null && target.isAlive()) {
                if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr(target) <= 225.0D && ultimate_cooldown <= 0 && this.getBossPhase() > 1) {
                    ultimate_cooldown = ULTIMATE_COOLDOWN;
                    this.setAnimation(ULTIMATE_ATTACK);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr(target) <= 400.0D && reinforced_smash_cooldown <= 0) {
                    reinforced_smash_cooldown = REINFORCED_SMASH_COOLDOWN;
                    Animation ranimation = getRandomReinforced(random);
                    this.setAnimation(ranimation);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr(target) >= 225 && this.distanceToSqr(target) <= 1024.0D && target.onGround() && air_smash_cooldown <= 0) {
                    air_smash_cooldown = AIR_SMASH_COOLDOWN;
                    this.setAnimation(SMASH_IN_AIR);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && (this.getAnimation() == NO_ANIMATION && this.distanceToSqr(target) >= 81 && this.distanceToSqr(target) <= 625 && magic_cooldown <= 0 && this.getRandom().nextFloat() * 100.0F < 1f)
                        // || (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr(target) >= 25 && this.distanceToSqr(target) <= 81 && magic_cooldown <= 0 && this.getRandom().nextFloat() * 100.0F < 0.6f
                        || (!isNoAi() && (this.getAnimation() == NO_ANIMATION && this.getRandom().nextFloat() * 100.0F < 10f && this.getY() + 5 <= target.getY()) && magic_cooldown <= 0)) {
                    magic_cooldown = MAGIC_COOLDOWN;
                    this.setAnimation(MAGIC_ATTACK);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 12F && this.distanceTo(target) > 5 && poke_cooldown <= 0 && this.getRandom().nextFloat() * 100.0F < 4f) {
                    poke_cooldown = POKE_COOLDOWN;
                    this.setAnimation(animation);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 12F && this.getRandom().nextFloat() * 100.0F < 15F && poke_cooldown <= 0 && target.hasEffect(ModEffect.EFFECTSTUN.get())) {
                    poke_cooldown = POKE_COOLDOWN;
                    this.setAnimation(animation);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 6.5F && this.getRandom().nextFloat() * 100.0F < 4f) {
                    Animation animation2 = this.getBossPhase() > 0 ? HORIZONTAL_SWING_ATTACK_SOUL : HORIZONTAL_SWING_ATTACK;
                    horizontal_swing_cooldown = HORIZONTAL_SWING_COOLDOWN;
                    this.setAnimation(animation2);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 4.25F && this.getRandom().nextFloat() * 100.0F < 8f) {
                    Animation animation3 = this.getBossPhase() > 1 ? SWING_ATTACK_BERSERK : this.getBossPhase() > 0 ? SWING_ATTACK_SOUL : SWING_ATTACK;
                    this.setAnimation(animation3);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 5.25F && this.getRandom().nextFloat() * 100.0F < 5f && this.getIsShieldBreak() && sword_dance_cooldown <= 0) {
                    sword_dance_cooldown = this.getBossPhase() > 1 ? SWORD_DANCE_COOLDOWN : this.getBossPhase() > 0 ? SWORD_DANCE_COOLDOWN + 120 : SWORD_DANCE_COOLDOWN + 240;
                    this.setAnimation(COMBO1);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 3F && this.getRandom().nextFloat() * 100.0F < 20f && !this.getIsShieldBreak()) {
                    this.setAnimation(SHIELD_SMASH_ATTACK);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 5F && this.getRandom().nextFloat() * 100.0F < 0.7f && counter_strike_cooldown <= 0 && !target.hasEffect(ModEffect.EFFECTSTUN.get())) {
                    counter_strike_cooldown = CONTER_STRIKE_COOLDOWN;
                    Animation counter = this.getIsShieldBreak() ? SHIELD_BREAK_COUNTER : COUNTER;
                    this.setAnimation(counter);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) > 4.5F && this.distanceTo(target) < 11F && earth_shudders_cooldown <= 0 && this.getRandom().nextFloat() * 100.0F < 1F && (this.getY() >= target.getY() - 2.5D && this.getY() <= target.getY() + 2.5D)) {
                    earth_shudders_cooldown = EARTH_SHUDDERS_COOLDOWN;
                    this.setAnimation(EARTH_SHUDDERS_ATTACK);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 5.5F && this.getRandom().nextFloat() * 100.0F < 15f && horizontal_small_swing_cooldown <= 0) {
                    horizontal_small_swing_cooldown = HORIZONTAL_SMALL_SWING_COOLDOWN;
                    this.setAnimation(HORIZONTAL_SMALL_SWING_ATTACK);
                } else if ((blockingProgress == 10 || swordProgress == 10) && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 3F && this.getRandom().nextFloat() * 100.0F < 10f && body_check_cooldown <= 0) {
                    body_check_cooldown = BODY_CHECK_COOLDOWN;
                    Animation animation5 = this.getBossPhase() > 0 ? BODY_CHECK_ATTACK_SOUL1 : BODY_CHECK_ATTACK1;
                    this.setAnimation(animation5);
                }
            }
        }
        blockbreak();

        super.tick();
    }




    public void aiStep() {
        super.aiStep();
        int brand = this.getBossPhase() > 0 ? 240 : 200;
        if (this.getAnimation() == SWING_ATTACK) {
            if (this.getAnimationTick() == 24) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 70, 1.0f, 0.05f, 80, 2, brand, 5, false, 0);
            }
        }
        if (this.getAnimation() == HORIZONTAL_SWING_ATTACK) {
            if (this.getAnimationTick() == 31) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.25f, 6, 210, 1.0f, 0.06f, 120, 3, brand, 5, false, 0);
            }
        }
        if (this.getAnimation() == SWING_ATTACK_SOUL) {
            if (this.getAnimationTick() == 18) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 70, 1.0f, 0.05f, 80, 2, brand, 5, false, 0);
            }
        }
        if (this.getAnimation() == SWING_ATTACK_BERSERK) {
            if (this.getAnimationTick() == 17) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 70, 1.0f, 0.05f, 80, 2, brand, 7, false, 0);
            }
        }

        if (this.getAnimation() == HORIZONTAL_SWING_ATTACK_SOUL) {
            if (this.getAnimationTick() == 27) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.25f, 6, 210, 1.0f, 0.06f, 120, 3, brand, 5, false, 0);
            }
        }
        if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ATTACK) {
            if (this.getAnimationTick() == 19) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.25f, 6, 120, 0.4f, 0.03f, 0, 2, brand, 3, true, 0);
            }
        }

        if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ALT_ATTACK2) {
            if (this.getAnimationTick() == 13) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.25f, 6, 120, 0.4f, 0.03f, 40, 2, brand, 3, false, 0);
            }
        }

        if (this.getAnimation() == SPIN_ATTACK) {
            if (this.getAnimationTick() == 14) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 310, 1.0f, 0.06f, 120, 3, brand, 5, false, 0.3F);
            }

        }

        if (this.getAnimation() == BREAK_THE_SHIELD) {
            if (this.getAnimationTick() == 25) {
                this.setShowShield(false);
                ShieldExplode(-2.75f, 1.5f, 2);
            }
            if (this.getAnimationTick() == 79) {
                this.setIsShieldBreak(true);
            }
            if (this.getAnimationTick() == 55) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.15f, 0, 50);
                List<LivingEntity> entities = getEntityLivingBaseNearby(12, 12, 12, 12);
                this.playSound(ModSounds.FLAME_BURST.get(), 1.0f, 0.8F);
                for (LivingEntity inRange : entities) {
                    if (inRange instanceof Player && ((Player) inRange).getAbilities().invulnerable) continue;
                    if (isAlliedTo(inRange)) continue;
                    inRange.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), 60));
                }
            }
        }
        if (this.getAnimation() == PHASE_2) {
            if (this.getAnimationTick() == 29) {
                this.playSound(ModSounds.FLAME_BURST.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.getAnimationTick() > 29 && this.getAnimationTick() < 39) {
                Sphereparticle(2, 0, 5);
                Phase_Transition(14, 0.4f, 0.03f, 5, 240);
            }
            if (this.getAnimationTick() == 34) {
                setBossPhase(1);
            }
        }
        if (this.getAnimation() == PHASE_3) {
            if (this.getAnimationTick() == 58) {
                this.setBossPhase(2);
                this.setShowShield(false);
                if (!this.getIsShieldBreak()) {
                    ShieldExplode(2, 0.575f, 2);
                }
                this.playSound(ModSounds.FLAME_BURST.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                this.playSound(ModSounds.SWORD_STOMP.get(), 1.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.15f, 0, 10);
                ShieldSmashparticle(0.5f, 1.0f, -0.15f);
            }

            if (this.getAnimationTick() > 58 && this.getAnimationTick() < 68) {
                Sphereparticle(0.5f, 1.0f, 6);
                Phase_Transition(27, 0.6f, 0.05f, 5, 240);
            }
        }

        if (this.getAnimation() == SHIELD_SMASH_ATTACK) {
            if (this.getAnimationTick() == 34) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                AreaAttack(4.85f, 2.5f, 45, 1.5f, 0.15f, 200, 0, 0, 5, false, 0);
                ShieldSmashparticle(1.3f, 2.75f, -0.1f);
            }

            for (int i = 34, j = 4; i <= 40; i = i + 3, j++) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(2, j, 1.5f, 2.75f, false, 0, 1, 0.02f, 0.1f);
                }
            }

        }
        if (this.getAnimation() == SMASH) {
            float vec = this.getIsShieldBreak() ? 1.8F : 1.5f;
            float radius = this.getIsShieldBreak() ? 0.8F : 1.3f;
            float math = this.getIsShieldBreak() ? 0.3F : 0.0f;
            if (this.getAnimationTick() == 5) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                AreaAttack(4.85f, 2.5f, 45, 1.5f, 0.15f, 200, 0, 0, 5, false, 0);
                ShieldSmashparticle(radius, vec, math);
            }

            for (int i = 5, j = 3; i <= 14; i = i + 3, j++) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(2, j, 1.5f, vec, false, 0, 1, 0.02f, 0.1f);
                }
            }

        }
        float vec = this.getIsShieldBreak() ? 1.5F : 3.00F;
        if (this.getAnimation() == REINFORCED_SMASH) {
            if (this.getAnimationTick() == 5) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.25D))) {
                    if (!isAlliedTo(entity) && !(entity instanceof Ignis_Entity) && entity != this) {
                        DamageSource damagesource = this.damageSources().mobAttack(this);
                        entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5F + entity.getMaxHealth() * 0.15F));
                        if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player) {
                            disableShield(player, 200);
                        }

                    }
                }
                ShieldSmashparticle(1.3f, vec, 0.0f);
            }

            for (int i = 5, j = 3; i <= 19; i = i + 2, j++) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(2, j, 2.5f, 2f, false, 80, 1.1F, 0.06f, 0.075f);

                }
            }

            if (this.getAnimationTick() == 46) {
                this.playSound(ModSounds.SWORD_STOMP.get(), 1.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.15f, 0, 20);
                ShieldSmashparticle(0.5f, 2f, 0.6f);
                AreaAttack(4.85f, 2.5f, 45, 1.5f, 0.15f, 200, 0, 0, 5, false, 0);
                switch (random.nextInt(3)) {
                    case 0 -> {
                        this.shootAbyssFireball(new Vec3(2, 3, 0), 54);
                        this.shootFireball(new Vec3(-2, 3, 0), 41);
                        this.shootFireball(new Vec3(0, 3, 0), 28);
                    }
                    case 1 -> {
                        this.shootFireball(new Vec3(2, 3, 0), 28);
                        this.shootAbyssFireball(new Vec3(-2, 3, 0), 54);
                        this.shootFireball(new Vec3(0, 3, 0), 41);
                    }
                    case 2 -> {
                        this.shootFireball(new Vec3(2, 3, 0), 28);
                        this.shootFireball(new Vec3(-2, 3, 0), 41);
                        this.shootAbyssFireball(new Vec3(0, 3, 0), 54);
                    }
                    default -> {

                    }
                }
            }

            if (this.getAnimationTick() > 46 && this.getAnimationTick() < 56) {
                Sphereparticle(0.75f, 2.0f, 6);
                //  Phase_Transition(21, 0.3f, 0.03f, 2, 240);
            }

            for (int i = 46, j = 16; i <= 57; i++, j--) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(2, j, 2.5f, 2f, false, 80, 1.1F, 0.06f, 0.075f);
                }
            }

        }

        if (this.getAnimation() == REINFORCED_SMASH_SOUL) {
            if (this.getAnimationTick() == 5) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.25D))) {
                    if (!isAlliedTo(entity) && !(entity instanceof Ignis_Entity) && entity != this) {
                        DamageSource damagesource = this.damageSources().mobAttack(this);
                        boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5F + entity.getMaxHealth() * 0.15F));
                        if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player) {
                            disableShield(player, 200);
                        }
                    }
                }
                ShieldSmashparticle(1.3f, vec, 0.0f);
            }

            for (int i = 5, j = 16; i <= 25; i = i + 2, j--) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(2, j, 2.5f, vec, true, 80, 1.1F, 0.06f, 0.075f);
                }
            }


            if (this.getAnimationTick() == 46) {
                this.playSound(ModSounds.SWORD_STOMP.get(), 1.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.15f, 0, 20);
                ShieldSmashparticle(0.5f, 2f, 0.6f);
                AreaAttack(4.85f, 2.5f, 45, 1.5f, 0.15f, 200, 0, 0, 5, false, 0);
                switch (random.nextInt(3)) {
                    case 0 -> {
                        this.shootAbyssFireball(new Vec3(2, 3, 0), 54);
                        this.shootFireball(new Vec3(-2, 3, 0), 41);
                        this.shootFireball(new Vec3(0, 3, 0), 28);
                    }
                    case 1 -> {
                        this.shootFireball(new Vec3(2, 3, 0), 28);
                        this.shootAbyssFireball(new Vec3(-2, 3, 0), 54);
                        this.shootFireball(new Vec3(0, 3, 0), 41);
                    }
                    case 2 -> {
                        this.shootFireball(new Vec3(2, 3, 0), 28);
                        this.shootFireball(new Vec3(-2, 3, 0), 41);
                        this.shootAbyssFireball(new Vec3(0, 3, 0), 54);
                    }
                    default -> {

                    }
                }
            }
            if (this.getAnimationTick() > 46 && this.getAnimationTick() < 56) {
                Sphereparticle(0.75f, 2.0f, 6);
                //Phase_Transition(21, 0.3f, 0.03f, 2, 240);
            }

            for (int l = 48; l <= 55; ++l) {
                if (this.getAnimationTick() == l) {
                    int d = l - 45;
                    ShieldSmashDamage(2, d, 2.5f, 2f, false, 80, 1.1F, 0.06f, 0.075f);
                }
            }
        }


        if (this.getAnimation() == REINFORCED_SMASH_IN_AIR) {
            if (this.getAnimationTick() == 23) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(4.5f, 8, 100, 1.0f, 0.1f, 120, 3, brand, 5, false, 0.65f);
            }
            if (this.getAnimationTick() == 53) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 70, 1.1f, 0.1f, 120, 2, brand, 5, false, 0);
            }
            if (this.getAnimationTick() > 74 && this.getAnimationTick() < 81) {
                PatternParticle(1.5f, 0, 1, false);
            }

            if (this.getAnimationTick() == 21) {
                this.bladeFireball(2, -1.5F, 5F, 30);
            }
            if (this.getAnimationTick() == 23) {
                this.bladeFireball(3, 0F, 4F, 28);
            }
            if (this.getAnimationTick() == 25) {
                this.bladeFireball(2, 1.5F, 3F, 26);
            }

        }

        if (this.getAnimation() == REINFORCED_SMASH_IN_AIR_SOUL) {
            if (this.getAnimationTick() == 23) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(4.5f, 8, 100, 1.0f, 0.1f, 120, 3, brand, 5, false, 0.65f);
            }
            if (this.getAnimationTick() == 53) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 70, 1.1f, 0.1f, 120, 2, brand, 5, false, 0);
            }

            if (this.getAnimationTick() == 21) {
                this.bladeFireball(2, -1.5F, 5F, 30);
            }
            if (this.getAnimationTick() == 23) {
                this.bladeFireball(3, 0F, 4F, 28);
            }
            if (this.getAnimationTick() == 25) {
                this.bladeFireball(2, 1.5F, 3F, 26);
            }

            if (this.getAnimationTick() > 74 && this.getAnimationTick() < 81) {
                PatternParticle(1.5f, 0, 1, true);
            }
        }

        if (this.getAnimation() == STRIKE) {
            if (this.getAnimationTick() == 31) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.25f, 6, 120, 1.25f, 0.1f, 120, 5, brand, 7, false, 0);
            }

            if (this.getAnimationTick() > 31 && this.getAnimationTick() < 35) {
                StrikeParticle(0.75f, 5, 0);
            }

            for (int i = 36, j = 4; i <= 48; i = i + 2, j = j + 2) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(0.75f, j, 2.5f, 0, true, 240, 1.1f, 0.12f, 0.1f);
                    ShieldSmashDamage(0.75f, j + 1, 2.5f, 0, true, 240, 1.1f, 0.12f, 0.1f);
                    earthquakesound((j + j + 1) / 2);
                }
            }

        }

        if (this.getAnimation() == SHIELD_BREAK_STRIKE) {
            if (this.getAnimationTick() == 15) {
                this.playSound(ModSounds.FLAME_BURST.get(), 1.0f, 0.8F);
            }

            if (this.getAnimationTick() == 17) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.15f, 0, 50);
                List<LivingEntity> entities = getEntityLivingBaseNearby(12, 12, 12, 12);
                for (LivingEntity inRange : entities) {
                    if (inRange instanceof Player && ((Player) inRange).getAbilities().invulnerable) continue;
                    if (isAlliedTo(inRange)) continue;
                    inRange.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), 60));
                }
            }

            if (this.getAnimationTick() == 44) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.0f, 6, 310, 1.25f, 0.1f, 120, 5, brand, 7, false, 0.3F);
            }

            for (int i = 49, j = 4; i <= 61; i = i + 2, j = j + 2) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(0.75f, j, 2.5f, 0, true, 240, 1.1f, 0.12f, 0.1f);
                    ShieldSmashDamage(0.75f, j + 1, 2.5f, 0, true, 240, 1.1f, 0.12f, 0.1f);
                    earthquakesound((j + j + 1) / 2);
                }
            }


            if (this.getAnimationTick() > 44 && this.getAnimationTick() < 48) {
                StrikeParticle(0.75f, 5, 0);
            }
        }

        if (this.getAnimation() == POKE_ATTACK) {
            if (this.getAnimationTick() == 37) {
                this.playSound(ModSounds.IGNIS_POKE.get(), 1.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.getAnimationTick() == 39) {
                Poke(7, 70, 160);
            }
        }

        if (this.getAnimation() == POKE_ATTACK2) {
            if (this.getAnimationTick() == 32) {
                this.playSound(ModSounds.IGNIS_POKE.get(), 1.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.getAnimationTick() == 34) {
                Poke(7, 65, 160);
            }
        }

        if (this.getAnimation() == POKE_ATTACK3) {
            if (this.getAnimationTick() == 27) {
                this.playSound(ModSounds.IGNIS_POKE.get(), 1.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.getAnimationTick() == 29) {
                Poke(7, 60, 160);
            }
        }

        if (this.getAnimation() == BODY_CHECK_ATTACK1
                || this.getAnimation() == BODY_CHECK_ATTACK2
                || this.getAnimation() == BODY_CHECK_ATTACK3
                || this.getAnimation() == BODY_CHECK_ATTACK4) {
            if (this.getAnimationTick() == 25) {
                BodyCheckAttack(3.0f, 6, 120, 0.8f, 0.03f, 80, 80, 0.2f);
            }
        }
        if (this.getAnimation() == BODY_CHECK_ATTACK_SOUL1
                || this.getAnimation() == BODY_CHECK_ATTACK_SOUL2
                || this.getAnimation() == BODY_CHECK_ATTACK_SOUL3
                || this.getAnimation() == BODY_CHECK_ATTACK_SOUL4) {
            if (this.getAnimationTick() == 21) {
                BodyCheckAttack(3.0f, 6, 120, 0.9f, 0.03f, 100, 100, 0.2f);
            }
        }

        if (this.getAnimation() == SWING_UPPERCUT) {
            if (this.getAnimationTick() == 32) {
                BodyCheckAttack(4.5f, 8, 120, 1.0f, 0.03f, 60, 70, 0.8);
            }
        }
        if (this.getAnimation() == SWING_UPPERSLASH) {
            if (this.getAnimationTick() == 24) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(4.5f, 8, 100, 1.0f, 0.05f, 120, 3, brand, 5, false, 0.65f);
            }
            for (int l = 26; l <= 30; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d = l - 23;
                    int d2 = l - 22;
                    float ds = (d + d2) / 2;
                    ShieldSmashDamage(0.4f, d, 2.5f, 0, false, 80, 1.0f, 0.03f, 0.1f);
                    earthquakesound(ds);
                    ShieldSmashDamage(0.4f, d2, 2.5f, 0, false, 80, 1.0f, 0.03f, 0.1f);

                }
            }

        }

        if (this.getAnimation() == EARTH_SHUDDERS_ATTACK) {
            if (this.getAnimationTick() == 32) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                AreaAttack(4f, 6, 80, 1.2f, 0.08f, 120, 5, brand, 5, false, 0);
                ShieldSmashparticle(0.75f, 2.3f, -0.65f);
                //ShieldSmashDamage(2f,10,3f,2.3f,false,80,1.0f,0.05f,0.05f);
                //ShieldSmashDamage(2f,9,3f,2.3f,false,80,1.0f,0.05f,0.05f);
                for (int l = 7; l >= 4; --l) {
                    ShieldSmashDamage(2f, l, 3f, 2.3f, false, 80, 1.0f, 0.05f, 0.05f);
                }
            }

            if (this.getAnimationTick() == 73) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                AreaAttack(4f, 6, 80, 1.2f, 0.08f, 120, 5, brand, 5, false, 0);
                ShieldSmashparticle(0.75f, 1.85f, -0.6f);
            }

            for (int i = 73, j = 16; i <= 85; i = i + 3, j = j - 2) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(2f, j, 3f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
                    ShieldSmashDamage(2f, j - 1, 3f, 2.3f, true, 80, 1.0f, 0.08f, 0.05f);
                }
            }

            if (this.getAnimationTick() == 117) {
                this.playSound(SoundEvents.TOTEM_USE, 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                ShieldSmashparticle(0.75f, 2.3f, -0.65f);
                AreaAttack(4f, 6, 80, 1.2f, 0.08f, 120, 5, brand, 5, false, 0);
            }

            for (int i = 117, j = 3; i <= 135; i = i + 3, j = j + 2) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(2f, j, 3f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
                    ShieldSmashDamage(2f, j + 1, 3f, 2.3f, false, 80, 1.0f, 0.08f, 0.05f);
                }
            }
        }

        if (this.getAnimation() == MAGIC_ATTACK) {
            if (this.getAnimationTick() == 5) {
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.EVOKER_PREPARE_SUMMON, this.getSoundSource(), 5f, 1.4F + this.getRandom().nextFloat() * 0.1F, false);
                switch (random.nextInt(5)) {
                    case 0 -> {
                        this.shootAbyssFireball(new Vec3(-5, 3, 0), 109);
                        this.shootFireball(new Vec3(-2, 3, 0), 45);
                        this.shootFireball(new Vec3(0, 3, 0), 61);
                        this.shootFireball(new Vec3(2, 3, 0), 77);
                        this.shootFireball(new Vec3(5, 3, 0), 93);
                    }
                    case 1 -> {
                        this.shootFireball(new Vec3(-5, 3, 0), 45);
                        this.shootAbyssFireball(new Vec3(-2, 3, 0), 109);
                        this.shootFireball(new Vec3(0, 3, 0), 61);
                        this.shootFireball(new Vec3(2, 3, 0), 77);
                        this.shootFireball(new Vec3(5, 3, 0), 93);
                    }
                    case 2 -> {
                        this.shootFireball(new Vec3(-5, 3, 0), 45);
                        this.shootFireball(new Vec3(-2, 3, 0), 61);
                        this.shootAbyssFireball(new Vec3(0, 3, 0), 109);
                        this.shootFireball(new Vec3(2, 3, 0), 77);
                        this.shootFireball(new Vec3(5, 3, 0), 93);
                    }
                    case 3 -> {
                        this.shootFireball(new Vec3(-5, 3, 0), 45);
                        this.shootFireball(new Vec3(-2, 3, 0), 61);
                        this.shootFireball(new Vec3(0, 3, 0), 77);
                        this.shootAbyssFireball(new Vec3(2, 3, 0), 109);
                        this.shootFireball(new Vec3(5, 3, 0), 93);
                    }
                    case 4 -> {
                        this.shootFireball(new Vec3(-5, 3, 0), 45);
                        this.shootFireball(new Vec3(-2, 3, 0), 61);
                        this.shootFireball(new Vec3(0, 3, 0), 77);
                        this.shootFireball(new Vec3(2, 3, 0), 93);
                        this.shootAbyssFireball(new Vec3(5, 3, 0), 109);
                    }
                    default -> {

                    }
                }
            }

        }

        if (this.getAnimation() == ULTIMATE_ATTACK) {
            float f1 = (float) Math.cos(Math.toRadians(this.getYRot() + 90));
            float f2 = (float) Math.sin(Math.toRadians(this.getYRot() + 90));
            float f0 = (float) Mth.atan2(f1, f2);
            if (this.getAnimationTick() == 74) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 0.5F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.3f, 0, 20);
                LivingEntity target = this.getTarget();
                AreaAttack(6f, 6f, 45, 2.0f, 0.25f, 300, 5, brand, 7, false, 0);
                if (target != null) {
                    double d0 = Math.min(target.getY(), this.getY());
                    double d1 = Math.max(target.getY(), this.getY()) + 1.0D;
                    for (int l = 0; l < 8; ++l) {
                        double d2 = 4.25D * (double) (l + 2);
                        int j2 = (int) (1.5F * l);
                        this.spawnFlameStrike(this.getX() + f1 * d2, this.getZ() + f2 * d2, d0, d1, f0, 60, j2, j2, 2.0f, false);
                    }
                } else {
                    for (int l = 0; l < 8; ++l) {
                        double d2 = 4.25D * (double) (l + 2);
                        int j2 = (int) (1.5F * l);
                        this.spawnFlameStrike(this.getX() + f1 * d2, this.getZ() + f2 * d2, this.getY(), this.getY(), f0, 60, j2, j2, 2.0f, false);
                    }
                }
                for (int l = 4; l < 38; ++l) {
                    UltimateAttack(l, 3, 1.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, -1.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, 2.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, -2.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, 3.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, -3.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, 4.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, -4.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, 5.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, -5.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, 6.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, -6.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, 7.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, -7.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, 8.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, -8.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, 9.5F, 150, 1.5F, 0.15F, 1);
                    UltimateAttack(l, 3, -9.5F, 150, 1.5F, 0.15F, 1);
                }
                earthquakesound(10f);
            }
        }
        if (this.getAnimation() == COMBO1) {
            if (this.getAnimationTick() == 19) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 90, 0.75f, 0.05f, 60, 2, brand, 5, false, 0);
            }
            if (this.getAnimationTick() == 38) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 120, 0.75f, 0.05f, 60, 2, brand, 5, false, 0);
            }

            if (this.getAnimationTick() == 61) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 70, 0.75f, 0.05f, 60, 2, brand, 5, false, 0);
            }

            if (this.getAnimationTick() == 76) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.5f, 6, 310, 0.75f, 0.05f, 60, 3, brand, 5, false, 0.3F);
            }
        }

        if (this.getAnimation() == COMBO2) {
            if (this.getAnimationTick() == 32) {
                BodyCheckAttack(4.5f, 8, 120, 1.0f, 0.03f, 60, 40, 0.8);
            }

            if (this.getAnimationTick() == 59) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.25f, 6, 120, 0.4f, 0.03f, 0, 2, brand, 3, false, 0);
            }
            if (this.getAnimationTick() == 74) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.25f, 6, 120, 0.4f, 0.03f, 50, 2, brand, 3, false, 0);
            }

            if (this.getAnimationTick() == 108) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.25f, 6, 225, 1.25f, 0.1f, 150, 5, brand, 7, false, 0);
            }

            if (this.getAnimationTick() > 108 && this.getAnimationTick() < 112) {
                StrikeParticle(1.25f, 5, 0);
            }

            for (int i = 108, j = 3; i <= 116; i = i + 2, j = j + 2) {
                if (this.getAnimationTick() == i) {
                    ShieldSmashDamage(1.25f, j, 2.5f, 0, true, 240, 1.1f, 0.12f, 0.1f);
                    ShieldSmashDamage(1.25f, j + 1, 2.5f, 0, true, 240, 1.1f, 0.12f, 0.1f);
                    earthquakesound((j + j + 1) / 2);
                }
            }
        }
        if (this.getAnimation() == POKED_ATTACK) {
            HoldAttack();
        }
    }

    private void blockbreak() {
        if (!this.isNoAi()) {
            if (!this.level().isClientSide) {
                if (this.destroyBlocksTick > 0) {
                    --this.destroyBlocksTick;
                    if (this.destroyBlocksTick == 0 && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                        boolean flag = false;
                        AABB aabb = this.getBoundingBox().inflate(0.2D);
                        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                            BlockState blockstate = this.level().getBlockState(blockpos);
                            if (blockstate != Blocks.AIR.defaultBlockState() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.IGNIS_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                                flag = this.level().destroyBlock(blockpos, true, this) || flag;
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

    @Nullable
    public Animation getDeathAnimation() {
        return IGNIS_DEATH;
    }

    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int firetime, int brandticks, int heal, boolean combo, float airborne) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.yBodyRot % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }
            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!(entityHit instanceof Ignis_Entity)) {

                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + entityHit.getMaxHealth() * hpdamage));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    if (flag) {
                        entityHit.setSecondsOnFire(firetime);
                        if (brandticks > 0) {
                            MobEffectInstance effectinstance1 = entityHit.getEffect(ModEffect.EFFECTBLAZING_BRAND.get());
                            int i = 1;
                            if (effectinstance1 != null) {
                                i += effectinstance1.getAmplifier();
                                entityHit.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND.get());
                            } else {
                                --i;
                            }

                            i = Mth.clamp(i, 0, 4);
                            MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), brandticks, i, false, true, true);
                            entityHit.addEffect(effectinstance);
                            this.heal(heal * (float) CMConfig.IgnisHealingMultiplier * (i + 1));
                        }
                        if (combo) {
                            if (!Combo) {
                                Combo = true;
                                CanSpin++;
                            }
                        }
                        if (airborne > 0) {
                            entityHit.setDeltaMovement(entityHit.getDeltaMovement().add(0.0D, airborne, 0.0D));
                        }
                    }
                }
            }
        }
    }


    private void BodyCheckAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int slowticks, double airborne) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.yBodyRot % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }
            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ignis_Entity)) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + entityHit.getMaxHealth() * hpdamage));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    if (flag) {
                        this.playSound(SoundEvents.ANVIL_LAND, 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F);
                        double d0 = entityHit.getX() - this.getX();
                        double d1 = entityHit.getZ() - this.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        entityHit.push(d0 / d2 * 2.5D, airborne, d1 / d2 * 2.5D);
                        if (slowticks > 0) {
                            entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), slowticks));
                        }
                    }
                }
            }
        }
    }

    private void Poke(float range, float arc, int shieldbreakticks) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, range, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.yBodyRot % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }
            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            if (this.distanceTo(entityHit) <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ignis_Entity)) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + entityHit.getMaxHealth() * 0.1f);
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    if (flag && !entityHit.getType().is(ModTag.IGNIS_CANT_POKE) && entityHit.isAlive()) {
                        if (entityHit.isShiftKeyDown()) {
                            entityHit.setShiftKeyDown(false);
                        }
                        if (this.getHeldEntity() == null) {
                            float radius = 4F;
                            float angle = (0.01745329251F * this.yBodyRot);
                            double extraX = radius * Mth.sin((float) (Math.PI + angle));
                            double extraZ = radius * Mth.cos(angle);
                            Hold_Attack_Entity hold = new Hold_Attack_Entity(ModEntities.HOLD_ATTACK.get(), this.level(), this, this.getX() + extraX, this.getY() + 1.2F, this.getZ() + extraZ, 46, entityHit);
                            hold.setPosX((float) (this.getX() + extraX));
                            hold.setPosY((float) (this.getY() + 1.2F));
                            hold.setPosZ((float) (this.getZ() + extraZ));
                            hold.setControllerUUID(this.getUUID());
                            this.setHeldUUID(hold.getUUID());
                            this.level().addFreshEntity(hold);

                            AnimationHandler.INSTANCE.sendAnimationMessage(this, POKED_ATTACK);
                        }
                    }
                }
            }
        }
    }

    private void HoldAttack() {
        Entity hold = this.getHeldEntity();
        if (hold instanceof Hold_Attack_Entity hold_attack_entity) {
            int tick = this.getAnimationTick();
            float radius = 4F;
            float angle = (0.01745329251F * this.yBodyRot);
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            double extraY = tick < 10 ? 0 : 0.2F * Mth.clamp(tick - 10, 0, 15);
            this.yHeadRot = yBodyRot;
            hold_attack_entity.setPosX((float) (this.getX() + extraX));
            hold_attack_entity.setPosY((float) (this.getY() + extraY + 1.2F));
            hold_attack_entity.setPosZ((float) (this.getZ() + extraZ));

            this.entityData.set(HELD_ID, hold_attack_entity.getId());
            hold_attack_entity.setControllerUUID(this.getUUID());

            if (this.getAnimationTick() == 46) {
                hold_attack_entity.discard();
            }

            if (!hold_attack_entity.getPassengers().isEmpty()) {
                if(hold_attack_entity.getPassengers().get(0) instanceof LivingEntity lifted) {
                    if ((tick - 10) % 4 == 0) {
                        boolean flag = lifted.hurt(this.damageSources().mobAttack(this), 4 + lifted.getMaxHealth() * 0.02f);
                        if (flag) {
                            MobEffectInstance effectinstance1 = lifted.getEffect(ModEffect.EFFECTBLAZING_BRAND.get());
                            int i = 1;
                            if (effectinstance1 != null) {
                                i += effectinstance1.getAmplifier();
                                lifted.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND.get());
                            } else {
                                --i;
                            }
                            i = Mth.clamp(i, 0, 4);
                            MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 240, i, false, true, true);
                            lifted.addEffect(effectinstance);
                            this.heal(2f * (float) CMConfig.IgnisHealingMultiplier * (i + 1));
                        }
                    }
                }

            }

        }

    }

    private void Flameswing() {
        Vec3 bladePos = socketPosArray[0];
        int Density = 4;
        float Randomness = 0.5f;
        double length = prevBladePos.subtract(bladePos).length();
        int numClouds = (int) Math.floor(2 * length);
        for (int i = 0; i < numClouds; i++) {
            double x = prevBladePos.x + i * (bladePos.x - prevBladePos.x) / numClouds;
            double y = prevBladePos.y + i * (bladePos.y - prevBladePos.y) / numClouds;
            double z = prevBladePos.z + i * (bladePos.z - prevBladePos.z) / numClouds;
            for (int j = 0; j < Density; j++) {
                float xOffset = Randomness * (2 * random.nextFloat() - 1);
                float yOffset = Randomness * (2 * random.nextFloat() - 1);
                float zOffset = Randomness * (2 * random.nextFloat() - 1);
                ParticleOptions type = this.getBossPhase() > 0 ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
                level().addParticle(type, x + xOffset, y + yOffset, z + zOffset, 0, 0, 0);
            }
        }
    }

    private void SwingParticles() {
        if (level().isClientSide) {
            Vec3 bladePos = socketPosArray[0];
            if (this.getAnimation() == HORIZONTAL_SWING_ATTACK) {
                if (this.getAnimationTick() > 27 && this.getAnimationTick() < 33) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == SWING_ATTACK) {
                if (this.getAnimationTick() > 15 && this.getAnimationTick() < 27) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == SWING_ATTACK_BERSERK) {
                if (this.getAnimationTick() > 12 && this.getAnimationTick() < 17) {
                    Flameswing();
                }
            }

            if (this.getAnimation() == HORIZONTAL_SWING_ATTACK_SOUL) {
                if (this.getAnimationTick() > 24 && this.getAnimationTick() < 28) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == SWING_ATTACK_SOUL) {
                if (this.getAnimationTick() > 16 && this.getAnimationTick() < 19) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == PHASE_3) {
                if (this.getAnimationTick() > 96 && this.getAnimationTick() < 100) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == STRIKE) {
                if (this.getAnimationTick() > 28 && this.getAnimationTick() < 33) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == SWING_UPPERSLASH) {
                if (this.getAnimationTick() > 23 && this.getAnimationTick() < 28) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ATTACK) {
                if (this.getAnimationTick() > 7) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == HORIZONTAL_SMALL_SWING_ALT_ATTACK2) {
                if (this.getAnimationTick() > 3) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == SPIN_ATTACK) {
                if (this.getAnimationTick() > 10 && this.getAnimationTick() < 18) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == REINFORCED_SMASH_IN_AIR || this.getAnimation() == REINFORCED_SMASH_IN_AIR_SOUL) {
                if (this.getAnimationTick() > 19 && this.getAnimationTick() < 58) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == SHIELD_BREAK_STRIKE) {
                if (this.getAnimationTick() > 37 && this.getAnimationTick() < 49) {
                    Flameswing();
                }
            }

            if (this.getAnimation() == ULTIMATE_ATTACK) {
                if (this.getAnimationTick() > 71 && this.getAnimationTick() < 74) {
                    Flameswing();
                }
            }
            if (this.getAnimation() == COMBO1) {
                if (this.getAnimationTick() > 16 && this.getAnimationTick() < 21
                        || this.getAnimationTick() > 36 && this.getAnimationTick() < 40
                        || this.getAnimationTick() > 60 && this.getAnimationTick() < 78) {
                    Flameswing();
                }
            }

            if (this.getAnimation() == COMBO2) {
                if (this.getAnimationTick() > 59 && this.getAnimationTick() < 62
                        || this.getAnimationTick() > 74 && this.getAnimationTick() < 77
                        || this.getAnimationTick() > 107 && this.getAnimationTick() < 114) {
                    Flameswing();
                }
            }

            prevBladePos = bladePos;
        }
    }

    private void ShieldSmashparticle(float radius, float vec, float math) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
            float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double motionX = getRandom().nextGaussian() * 0.07D;
                double motionY = getRandom().nextGaussian() * 0.07D;
                double motionZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = radius * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = radius * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX + extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, motionX, motionY, motionZ);

            }
            this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 25, 1f, 1f, 1f, 1f, 25f, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.3f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
        }
    }

    private void ShieldExplode(float radius, float math, float y) {
        if (!this.level().isClientSide) {
            float angle = (0.01745329251F * this.yBodyRot);
            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            this.level().explode(this, this.getX() + extraX + f * math, this.getY() + y, this.getZ() + extraZ + f1 * math, 2.0F, Level.ExplosionInteraction.NONE);
        }
    }


    private void ShieldSmashDamage(float spreadarc, int distance, float mxy, float vec, boolean grab, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        double minY = this.getY() - 1;
        double maxY = this.getY() + mxy;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            float factor = 1 - distance / (float) 12;
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = level().getBlockState(pos);

            int maxDepth = 256;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderShape() == RenderShape.MODEL) {
                    break;
                }
                pos = pos.below();
                block = level().getBlockState(pos);
            }

            if (block.getRenderShape() != RenderShape.MODEL) {
                block = Blocks.AIR.defaultBlockState();
            }
            Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
            fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
            level().addFreshEntity(fallingBlockEntity);
            if (!this.level().isClientSide && block.is(ModTag.IGNIS_CAN_DESTROY_CRACKED_BLOCK)) {
                if (CMConfig.IgnisBlockBreaking) {
                    this.level().destroyBlock(pos, false, this);
                } else {
                    if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                        this.level().destroyBlock(pos, false, this);
                    }
                }
            }
            AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isAlliedTo(entity) && !(entity instanceof Ignis_Entity) && entity != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + entity.getMaxHealth() * hpdamage));
                    if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player  && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    if (flag) {
                        if (grab) {
                            double magnitude = -4;
                            double x = vx * (1 - factor) * magnitude;
                            double y = 0;
                            if (entity.onGround()) {
                                y += 0.15;
                            }
                            double z = vz * (1 - factor) * magnitude;
                            entity.setDeltaMovement(entity.getDeltaMovement().add(x, y, z));
                        } else {
                            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne * distance + level().random.nextDouble() * 0.15, 0.0D));
                        }
                    }

                }
            }
        }
    }

    private void UltimateAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double minY = this.getY() - 2;
        double maxY = this.getY() + mxy;
        float angle = (0.01745329251F * this.yBodyRot);
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double extraX = distance * Mth.sin((float) (Math.PI + angle));
        double extraZ = distance * Mth.cos(angle);
        double px = this.getX() + extraX + f * math;
        double pz = this.getZ() + extraZ + f1 * math;
        int hitX = Mth.floor(px);
        int hitZ = Mth.floor(pz);
        BlockPos pos = new BlockPos(hitX, hitY, hitZ);
        BlockState block = level().getBlockState(pos);

        int maxDepth = 30;
        for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
            if (block.getRenderShape() == RenderShape.MODEL) {
                break;
            }
            pos = pos.below();
            block = level().getBlockState(pos);
        }

        if (block.getRenderShape() != RenderShape.MODEL) {
            block = Blocks.AIR.defaultBlockState();
        }
        Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
        fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
        level().addFreshEntity(fallingBlockEntity);
        if (!this.level().isClientSide && block.is(ModTag.IGNIS_CAN_DESTROY_CRACKED_BLOCK)) {
            if (CMConfig.IgnisBlockBreaking) {
                this.level().destroyBlock(pos, false, this);
            } else {
                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    this.level().destroyBlock(pos, false, this);
                }
            }

        }
        AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
        List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
        for (LivingEntity entity : hit) {
            if (!isAlliedTo(entity) && !(entity instanceof Ignis_Entity) && entity != this) {
                DamageSource damagesource = this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + entity.getMaxHealth() * hpdamage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }

                if (flag) {
                    entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne + level().random.nextDouble() * 0.15, 0.0D));
                }

            }
        }

    }


    private void earthquakesound(float distance) {
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        this.level().playLocalSound(this.getX() + distance * vecX, this.getY(), this.getZ() + distance * vecZ, SoundEvents.TOTEM_USE, this.getSoundSource(), 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F, false);
    }

    private void StrikeParticle(float spreadarc, int distance, float vec) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil((distance) * spread);
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double vy = Mth.sqrt((float) (vx * distance * vx * distance + vz * distance * vz * distance));
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            if (this.level().isClientSide) {
                if (this.tickCount % 2 == 0) {
                    for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                        double motionX = 0.2D * Mth.lerp(1, vx * distance + 3, vx * distance);
                        double motionY = 0.2D * Mth.lerp(1.5, vy * 0.1, vy * 0.1);
                        double motionZ = 0.2D * Mth.lerp(1, vz * distance + 3, vz * distance);
                        double spreads = 10 + this.getRandom().nextDouble() * 2.5;
                        double velocity = 0.5 + this.getRandom().nextDouble() * 0.15;

                        // spread flame
                        motionX += this.getRandom().nextGaussian() * 0.007499999832361937D * spreads;
                        motionZ += this.getRandom().nextGaussian() * 0.007499999832361937D * spreads;
                        motionX *= velocity;
                        motionZ *= velocity;
                        ParticleOptions type = this.getBossPhase() > 0 ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
                        this.level().addParticle(type, px, this.getY() + 1.3f, pz, motionX, motionY, motionZ);

                    }
                }
            }
        }
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_IGNIS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        if (living != null) {
            CMWorldData worldData = CMWorldData.get(level(),Level.NETHER);
            if (worldData != null) {
                boolean prev = worldData.isIgnisDefeatedOnce();
                if (!prev) {
                    worldData.setIgnisDefeatedOnce(true);
                    if (level() instanceof ServerLevel serverLevel) {
                        serverLevel.getPlayers(EntitySelector.NO_SPECTATORS).forEach(serverPlayer -> serverPlayer.displayClientMessage(Component.translatable("entity.cataclysm.ignis.defeat_message").withStyle(ChatFormatting.GOLD), true));
                    }
                }
            }
        }
    }

    private void Sphereparticle(float height, float vec, float size) {
        if (this.level().isClientSide) {
            if (this.tickCount % 2 == 0) {
                double d0 = this.getX();
                double d1 = this.getY() + height;
                double d2 = this.getZ();
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                for (float i = -size; i <= size; ++i) {
                    for (float j = -size; j <= size; ++j) {
                        for (float k = -size; k <= size; ++k) {
                            double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;

                            ParticleOptions type = this.getBossPhase() > 0 ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
                            this.level().addParticle(type, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private void PatternParticle(float height, float vec, float size, boolean blue) {
        if (this.level().isClientSide) {
            if (this.tickCount % 2 == 0) {
                double d0 = this.getX();
                double d1 = this.getY() + height;
                double d2 = this.getZ();
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                for (float i = -size; i <= size; ++i) {
                    for (float j = -size; j <= size; ++j) {
                        for (float k = -size; k <= size; ++k) {
                            double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;

                            ParticleOptions type = blue ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME;
                            this.level().addParticle(type, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private void Phase_Transition(int dist, float damage, float hpdamage, int firetime, int brandticks) {
        if (this.getAnimationTick() % 2 == 0) {
            int distance = this.getAnimationTick() / 2 - dist;
            List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(distance, distance, distance, distance);
            for (LivingEntity entityHit : entitiesHit) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ignis_Entity) && entityHit != this) {
                    boolean flag = entityHit.hurt(this.damageSources().indirectMagic(this, this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + entityHit.getMaxHealth() * hpdamage));
                    if (flag) {
                        entityHit.setSecondsOnFire(firetime);
                        if (brandticks > 0) {
                            MobEffectInstance effectinstance1 = entityHit.getEffect(ModEffect.EFFECTBLAZING_BRAND.get());
                            int i = 1;
                            if (effectinstance1 != null) {
                                i += effectinstance1.getAmplifier();
                                entityHit.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND.get());
                            } else {
                                --i;
                            }

                            i = Mth.clamp(i, 0, 4);
                            MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), brandticks, i, false, true, true);
                            entityHit.addEffect(effectinstance);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_, @Nullable CompoundTag p_29682_) {
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }


    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.IGNIS_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.IGNIS_DEATH.get();
    }


    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.IGNIS_MUSIC.get();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }


    public enum Crackiness {
        NONE(1.0F),
        LOW(0.3F),
        MEDIUM(0.2F),
        HIGH(0.1F);

        private static final List<Crackiness> BY_DAMAGE = Stream.of(values()).sorted(Comparator.comparingDouble((p_28904_) -> {
            return (double) p_28904_.fraction;
        })).collect(ImmutableList.toImmutableList());
        private final float fraction;

        private Crackiness(float p_28900_) {
            this.fraction = p_28900_;
        }

        public static Crackiness byFraction(float p_28902_) {
            for (Crackiness ignis$crackiness : BY_DAMAGE) {
                if (p_28902_ < ignis$crackiness.fraction) {
                    return ignis$crackiness;
                }
            }

            return NONE;
        }
    }


    private boolean shouldFollowUp(float Range) {
        LivingEntity target = this.getTarget();
        if (target != null && target.isAlive()) {
            Vec3 targetMoveVec = target.getDeltaMovement();
            Vec3 betweenEntitiesVec = this.position().subtract(target.position());
            boolean targetComingCloser = targetMoveVec.dot(betweenEntitiesVec) > 0;
            return this.distanceTo(target) < Range || (this.distanceTo(target) < 5 + Range && targetComingCloser);
        }
        return false;
    }

    private void shootAbyssFireball(Vec3 shotAt, int timer) {
        shotAt = shotAt.yRot(-this.getYRot() * ((float) Math.PI / 180F));
        Ignis_Abyss_Fireball_Entity shot = new Ignis_Abyss_Fireball_Entity(this.level(), this);
        shot.setPos(this.getX() - (double) (this.getBbWidth() + 1.0F) * 0.15D * (double) Mth.sin(this.yBodyRot * ((float) Math.PI / 180F)), this.getY() + (double) 1F, this.getZ() + (double) (this.getBbWidth() + 1.0F) * 0.15D * (double) Mth.cos(this.yBodyRot * ((float) Math.PI / 180F)));
        double d0 = shotAt.x;
        double d1 = shotAt.y;
        double d2 = shotAt.z;
        float f = Mth.sqrt((float) (d0 * d0 + d2 * d2)) * 0.35F;

        shot.shoot(d0, d1 + (double) f, d2, 0.25F, 3.0F);
        shot.setUp(timer);
        this.level().addFreshEntity(shot);

    }

    private void shootFireball(Vec3 shotAt, int timer) {
        shotAt = shotAt.yRot(-this.getYRot() * ((float) Math.PI / 180F));
        Ignis_Fireball_Entity shot = new Ignis_Fireball_Entity(this.level(), this);
        shot.setPos(this.getX() - (double) (this.getBbWidth() + 1.0F) * 0.15D * (double) Mth.sin(this.yBodyRot * ((float) Math.PI / 180F)), this.getY() + (double) 1F, this.getZ() + (double) (this.getBbWidth() + 1.0F) * 0.15D * (double) Mth.cos(this.yBodyRot * ((float) Math.PI / 180F)));
        double d0 = shotAt.x;
        double d1 = shotAt.y;
        double d2 = shotAt.z;
        float f = Mth.sqrt((float) (d0 * d0 + d2 * d2)) * 0.35F;
        shot.shoot(d0, d1 + (double) f, d2, 0.25F, 3.0F);
        shot.setUp(timer);
        if (this.getBossPhase() > 0) {
            shot.setSoul(true);
        }
        this.level().addFreshEntity(shot);
    }

    private void bladeFireball(float radius, float math, float Y, int timer) {
        Ignis_Fireball_Entity shot = new Ignis_Fireball_Entity(this.level(), this);
        // float radius = 4F;
        // float math = 0.5f;
        float angle = (0.01745329251F * this.yBodyRot);
        float f = Mth.cos(this.getYRot() * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F));
        double extraX = radius * Mth.sin((float) (Math.PI + angle));
        double extraZ = radius * Mth.cos(angle);
        shot.setPos(this.getX() + f * math + extraX, this.getY() + Y, this.getZ() + f1 * math + extraZ);
        shot.setUp(timer);
        if (this.getBossPhase() > 0) {
            shot.setSoul(true);
        }
        this.level().addFreshEntity(shot);
    }

    private void spawnFlameStrike(double x, double z, double minY, double maxY, float rotation, int duration, int wait, int delay, float radius, boolean soul) {
        BlockPos blockpos = BlockPos.containing(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
                if (!this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            this.level().addFreshEntity(new Flame_Strike_Entity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, duration, wait, delay, radius, soul, this));
        }
    }

    class Hornzontal_SwingGoal extends SimpleAnimationGoal<Ignis_Entity> {
        private final int look1;
        private final int look2;
        private final int charge;
        private final int bodycheck;


        public Hornzontal_SwingGoal(Ignis_Entity entity, Animation animation, int look1, int look2, int charge, int bodycheck) {
            super(entity, animation);
            this.look1 = look1;
            this.look2 = look2;
            this.charge = charge;
            this.bodycheck = bodycheck;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < look1 && target != null || Ignis_Entity.this.getAnimationTick() > look2 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            if (Ignis_Entity.this.getAnimationTick() == charge) {
                float f1 = (float) Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
                if (target != null) {
                    float r = Ignis_Entity.this.distanceTo(target);
                    r = Mth.clamp(r, 0, 10);
                    Ignis_Entity.this.push(f1 * 0.3 * r, 0, f2 * 0.3 * r);
                }

            }
            if (Ignis_Entity.this.getAnimationTick() == bodycheck && shouldFollowUp(3.5f) && Ignis_Entity.this.random.nextInt(3) == 0 && body_check_cooldown <= 0) {
                body_check_cooldown = BODY_CHECK_COOLDOWN;
                Animation bodycheck = Ignis_Entity.this.getBossPhase() > 0 ? BODY_CHECK_ATTACK_SOUL2 : BODY_CHECK_ATTACK2;
                AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, bodycheck);
            }
        }
    }

    class Hornzontal_Small_SwingGoal extends AnimationGoal<Ignis_Entity> {
        private final int look1;
        private final int look2;
        private final int look3;
        private final int follow_through_tick;


        public Hornzontal_Small_SwingGoal(Ignis_Entity entity, int look1, int look2, int look3, int follow_through_tick) {
            super(entity);
            this.look1 = look1;
            this.look2 = look2;
            this.look3 = look3;
            this.follow_through_tick = follow_through_tick;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == HORIZONTAL_SMALL_SWING_ALT_ATTACK2
                    || animation == HORIZONTAL_SMALL_SWING_ATTACK
                    || animation == SPIN_ATTACK;
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            float f1 = (float) Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
            float f2 = (float) Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
            if (Ignis_Entity.this.getAnimation() == HORIZONTAL_SMALL_SWING_ATTACK) {
                if (Ignis_Entity.this.getAnimationTick() < look1 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 14) {
                    if (target != null) {
                        if (Ignis_Entity.this.distanceTo(target) > 3.5F) {
                            Ignis_Entity.this.push(f1 * 1.5, 0, f2 * 1.5);
                        }
                    } else {
                        Ignis_Entity.this.push(f1 * 1.5, 0, f2 * 1.5);
                    }
                }
                if (Combo) {
                    if (Ignis_Entity.this.getAnimationTick() == follow_through_tick) {
                        Combo = false;
                        AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, HORIZONTAL_SMALL_SWING_ALT_ATTACK2);
                    }
                }
            }
            if (Ignis_Entity.this.getAnimation() == HORIZONTAL_SMALL_SWING_ALT_ATTACK2) {
                if (Ignis_Entity.this.getAnimationTick() < look2 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 10) {
                    if (target != null) {
                        if (Ignis_Entity.this.distanceTo(target) > 3.5F) {
                            Ignis_Entity.this.push(f1 * 1.5, 0, f2 * 1.5);
                        }
                    } else {
                        Ignis_Entity.this.push(f1 * 1.5, 0, f2 * 1.5);
                    }
                }
                if (Ignis_Entity.this.getAnimationTick() == follow_through_tick && Ignis_Entity.this.CanSpin >= 2) {
                    Ignis_Entity.this.CanSpin = 0;
                    AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, SPIN_ATTACK);
                }
            }
            if (Ignis_Entity.this.getAnimation() == SPIN_ATTACK) {
                if (Ignis_Entity.this.getAnimationTick() < look3 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 10) {
                    Ignis_Entity.this.push(f1 * 1.5, 0, f2 * 1.5);

                }
            }
        }
    }

    class Body_Check_Attack extends AnimationGoal<Ignis_Entity> {

        public Body_Check_Attack(Ignis_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));

        }

        @Override
        protected boolean test(Animation animation) {
            return animation == BODY_CHECK_ATTACK1
                    || animation == BODY_CHECK_ATTACK2
                    || animation == BODY_CHECK_ATTACK3
                    || animation == BODY_CHECK_ATTACK4
                    || animation == BODY_CHECK_ATTACK_SOUL1
                    || animation == BODY_CHECK_ATTACK_SOUL2
                    || animation == BODY_CHECK_ATTACK_SOUL3
                    || animation == BODY_CHECK_ATTACK_SOUL4;
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK_SOUL1
                    || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK_SOUL2
                    || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK_SOUL3
                    || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK_SOUL4) {
                if (Ignis_Entity.this.getAnimationTick() < 21 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    setYRot(yBodyRot);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 16 && target != null) {
                    Ignis_Entity.this.setDeltaMovement((target.getX() - Ignis_Entity.this.getX()) * 0.4F, 0, (target.getZ() - Ignis_Entity.this.getZ()) * 0.4F);
                }
            }
            if (Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK1
                    || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK2
                    || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK3
                    || Ignis_Entity.this.getAnimation() == BODY_CHECK_ATTACK4) {
                if (Ignis_Entity.this.getAnimationTick() < 25 && target != null) {
                    Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    setYRot(yBodyRot);
                } else {
                    Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
                }
                if (Ignis_Entity.this.getAnimationTick() == 20 && target != null) {
                    Ignis_Entity.this.setDeltaMovement((target.getX() - Ignis_Entity.this.getX()) * 0.25F, 0, (target.getZ() - Ignis_Entity.this.getZ()) * 0.25F);
                }
            }
        }
    }


    class PokeGoal extends SimpleAnimationGoal<Ignis_Entity> {
        private final int look1;
        private final int look2;
        private final int charge;
        private final int bodycheck;
        private final int motion1;
        private final int motion2;

        public PokeGoal(Ignis_Entity entity, Animation animation, int look1, int look2, int charge, int bodycheck, int motion1, int motion2) {
            super(entity, animation);
            this.look1 = look1;
            this.look2 = look2;
            this.charge = charge;
            this.bodycheck = bodycheck;
            this.motion1 = motion1;
            this.motion2 = motion2;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            float f1 = (float) Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
            float f2 = (float) Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
            if (Ignis_Entity.this.getAnimationTick() < look1 && target != null || Ignis_Entity.this.getAnimationTick() > look2 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                setYRot(yBodyRot);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            if (Ignis_Entity.this.getAnimationTick() == charge) {
                if (target != null) {
                    float r = Ignis_Entity.this.distanceTo(target);
                    r = Mth.clamp(r, 0, 15);
                    Ignis_Entity.this.push(f1 * 0.3 * r, 0, f2 * 0.3 * r);
                } else {
                    Ignis_Entity.this.push(f1, 0, f2);
                }
            }

            if (Ignis_Entity.this.getAnimationTick() == bodycheck && shouldFollowUp(3.0f) && Ignis_Entity.this.random.nextInt(2) == 0 && body_check_cooldown <= 0) {
                body_check_cooldown = BODY_CHECK_COOLDOWN;
                Animation bodycheck = Ignis_Entity.this.getBossPhase() > 0 ? BODY_CHECK_ATTACK_SOUL4 : BODY_CHECK_ATTACK4;
                AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, bodycheck);
            }
            if (Ignis_Entity.this.getAnimationTick() < motion1 || Ignis_Entity.this.getAnimationTick() > motion2) {
                Ignis_Entity.this.setDeltaMovement(0, Ignis_Entity.this.getDeltaMovement().y, 0);
            }
        }
    }

    class Poked extends SimpleAnimationGoal<Ignis_Entity> {

        public Poked(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (target != null) {
                Ignis_Entity.this.getLookControl().setLookAt(target, 20.0F, 20.0F);
                Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
            }
            Ignis_Entity.this.setDeltaMovement(0, Ignis_Entity.this.getDeltaMovement().y, 0);
        }
    }

    class Shield_Smash extends SimpleAnimationGoal<Ignis_Entity> {

        public Shield_Smash(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < 34 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            Ignis_Entity.this.setDeltaMovement(0, Ignis_Entity.this.getDeltaMovement().y, 0);

            if (Ignis_Entity.this.getAnimationTick() == 45 && shouldFollowUp(4.0f) && Ignis_Entity.this.random.nextInt(3) == 0 && body_check_cooldown <= 0) {
                body_check_cooldown = BODY_CHECK_COOLDOWN;
                Animation bodycheck = Ignis_Entity.this.getBossPhase() > 0 ? BODY_CHECK_ATTACK_SOUL3 : BODY_CHECK_ATTACK3;
                AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, bodycheck);

            }
        }
    }

    class Air_Smash extends SimpleAnimationGoal<Ignis_Entity> {

        public Air_Smash(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (target != null) {
                Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
            }
            if (Ignis_Entity.this.getAnimationTick() == 19) {
                if (target != null) {
                    Ignis_Entity.this.setDeltaMovement((target.getX() - Ignis_Entity.this.getX()) * 0.15D, 1.3D, (target.getZ() - Ignis_Entity.this.getZ()) * 0.15D);
                } else {
                    Ignis_Entity.this.setDeltaMovement(0, 1.4D, 0);
                }
            }

            if (Ignis_Entity.this.getAnimationTick() > 19 && Ignis_Entity.this.onGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, SMASH);
            }

        }
    }

    class Reinforced_Air_Smash extends AnimationGoal<Ignis_Entity> {

        public Reinforced_Air_Smash(Ignis_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == REINFORCED_SMASH_IN_AIR_SOUL
                    || animation == REINFORCED_SMASH_IN_AIR;
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < 25 && target != null
                    || Ignis_Entity.this.getAnimationTick() < 55 && Ignis_Entity.this.getAnimationTick() > 36 && target != null
                    || Ignis_Entity.this.getAnimationTick() < 85 && Ignis_Entity.this.getAnimationTick() > 66 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
            } else if (Ignis_Entity.this.getAnimationTick() >= 83 && target != null) {
                Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }

            if (Ignis_Entity.this.getAnimationTick() == 84) {
                if (target != null) {
                    Ignis_Entity.this.setDeltaMovement((target.getX() - Ignis_Entity.this.getX()) * 0.15D, 1.3D, (target.getZ() - Ignis_Entity.this.getZ()) * 0.15D);
                } else {
                    Ignis_Entity.this.setDeltaMovement(0, 1.8D, 0);
                }
            }

            if (Ignis_Entity.this.getAnimation() == REINFORCED_SMASH_IN_AIR) {
                if (Ignis_Entity.this.getAnimationTick() > 84 && Ignis_Entity.this.onGround()) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, REINFORCED_SMASH);
                }
            }
            if (Ignis_Entity.this.getAnimation() == REINFORCED_SMASH_IN_AIR_SOUL) {
                if (Ignis_Entity.this.getAnimationTick() > 84 && Ignis_Entity.this.onGround()) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, REINFORCED_SMASH_SOUL);
                }
            }
        }
    }

    class Swing_Attack_Goal extends SimpleAnimationGoal<Ignis_Entity> {
        private final int look1;
        private final int follow_through_tick;

        public Swing_Attack_Goal(Ignis_Entity entity, Animation animation, int look1, int follow_through_tick) {
            super(entity, animation);
            this.look1 = look1;
            this.follow_through_tick = follow_through_tick;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));

        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < look1 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }

            if (Ignis_Entity.this.getAnimationTick() == follow_through_tick && Ignis_Entity.this.random.nextInt(2) == 0 && target != null) {
                if (Ignis_Entity.this.distanceTo(target) <= 6) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, SWING_UPPERSLASH);
                } else {
                    AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, SWING_UPPERCUT);
                }
            }
            Ignis_Entity.this.setDeltaMovement(0, Ignis_Entity.this.getDeltaMovement().y, 0);
        }

    }

    class Earth_Shudders extends SimpleAnimationGoal<Ignis_Entity> {

        public Earth_Shudders(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            Ignis_Entity.this.setDeltaMovement(0, Ignis_Entity.this.getDeltaMovement().y, 0);
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < 31 && target != null
                    || Ignis_Entity.this.getAnimationTick() < 73 && Ignis_Entity.this.getAnimationTick() > 45 && target != null
                    || Ignis_Entity.this.getAnimationTick() < 117 && Ignis_Entity.this.getAnimationTick() > 89 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
        }
    }

    class Combo1 extends SimpleAnimationGoal<Ignis_Entity> {

        public Combo1(Ignis_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            float f1 = (float) Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
            float f2 = (float) Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < 20 && target != null
                    || Ignis_Entity.this.getAnimationTick() < 62 && Ignis_Entity.this.getAnimationTick() > 44 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                Ignis_Entity.this.lookAt(target, 30.0F, 30.0F);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            if (Ignis_Entity.this.getAnimationTick() == 15 || Ignis_Entity.this.getAnimationTick() == 36 || Ignis_Entity.this.getAnimationTick() == 71) {
                if (target != null) {
                    float r = Ignis_Entity.this.distanceTo(target);
                    r = Mth.clamp(r, 0, 5);
                    Ignis_Entity.this.push(f1 * 0.35 * r, 0, f2 * 0.35 * r);
                } else {
                    Ignis_Entity.this.push(f1, 0, f2);
                }

            }

            if (Ignis_Entity.this.getAnimationTick() == 84 && target != null) {
                AnimationHandler.INSTANCE.sendAnimationMessage(Ignis_Entity.this, COMBO2);
            }
        }

    }


    class Combo2 extends SimpleAnimationGoal<Ignis_Entity> {
        private final int look1;


        private final float sensing;
        private final int charge;
        private final float motionx;
        private final float motionz;

        public double prevX;
        public double prevZ;
        private int newX;
        private int newZ;

        public Combo2(Ignis_Entity entity, Animation animation, int look1, float sensing, int charge, float motionx, float motionz) {
            super(entity, animation);
            this.look1 = look1;
            this.sensing = sensing;
            this.charge = charge;
            this.motionx = motionx;
            this.motionz = motionz;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        @Override
        public void start() {
            super.start();
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (target != null) {
                prevX = target.getX();
                prevZ = target.getZ();
            }
        }

        public void tick() {
            LivingEntity target = Ignis_Entity.this.getTarget();
            if (Ignis_Entity.this.getAnimationTick() < look1 && target != null
                    || Ignis_Entity.this.getAnimationTick() < 59 && Ignis_Entity.this.getAnimationTick() > 43 && target != null
                    || Ignis_Entity.this.getAnimationTick() < 74 && Ignis_Entity.this.getAnimationTick() > 61 && target != null) {
                Ignis_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                setYRot(yBodyRot);
            } else {
                Ignis_Entity.this.setYRot(Ignis_Entity.this.yRotO);
            }
            if (Ignis_Entity.this.getAnimationTick() == (charge - 1) && target != null) {
                double x = target.getX();
                double z = target.getZ();
                double vx = (x - prevX) / charge;
                double vz = (z - prevZ) / charge;
                newX = Mth.floor(x + vx * sensing);
                newZ = Mth.floor(z + vz * sensing);
            }

            if (Ignis_Entity.this.getAnimationTick() == charge && target != null) {
                Ignis_Entity.this.setDeltaMovement((newX - Ignis_Entity.this.getX()) * motionx, 0, (newZ - Ignis_Entity.this.getZ()) * motionz);

            }

            float f1 = (float) Math.cos(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
            float f2 = (float) Math.sin(Math.toRadians(Ignis_Entity.this.getYRot() + 90));
            if (Ignis_Entity.this.getAnimationTick() == 55 || Ignis_Entity.this.getAnimationTick() == 70) {
                if (target != null) {
                    if (Ignis_Entity.this.distanceTo(target) > 3.5F) {
                        Ignis_Entity.this.push(f1 * 1.5, 0, f2 * 1.5);
                    }
                } else {
                    Ignis_Entity.this.push(f1 * 1.5, 0, f2 * 1.5);
                }
            }
        }

    }
}
