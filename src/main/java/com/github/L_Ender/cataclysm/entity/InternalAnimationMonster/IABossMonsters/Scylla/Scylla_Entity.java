package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla;

import com.github.L_Ender.cataclysm.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.github.L_Ender.cataclysm.client.particle.*;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.HurtByNearestTargetGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Area_Effect_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Storm_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Wave_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.projectile.Lightning_Spear_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Spark_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Storm_Serpent_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Water_Spear_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
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
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.Math.*;


public class Scylla_Entity extends IABoss_monster {

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState CrossSwingAnimationState = new AnimationState();
    public AnimationState CrossSwing2AnimationState = new AnimationState();
    public AnimationState DoubleSwingAnimationState = new AnimationState();
    public AnimationState SwingSmashAnimationState = new AnimationState();
    public AnimationState SmashAnimationState = new AnimationState();
    public AnimationState backstepanimationState = new AnimationState();
    public AnimationState spinAnimationState = new AnimationState();
    public AnimationState waveAnimationState = new AnimationState();
    public AnimationState lightningexplosionAnimationState = new AnimationState();
    public AnimationState WaterSpearAnimationState = new AnimationState();
    public AnimationState LightningSpearAnimationState = new AnimationState();
    public AnimationState AnchorShotAnimationState = new AnimationState();
    public AnimationState AnchorShotPullAnimationState = new AnimationState();
    public AnimationState AnchorExplosionAnimationState = new AnimationState();
    public AnimationState ChainJump1AnimationState = new AnimationState();
    public AnimationState ChainJump2AnimationState = new AnimationState();
    public AnimationState ChainJump3AnimationState = new AnimationState();
    public AnimationState ParryAnimationState = new AnimationState();
    public AnimationState Enchant1AnimationState = new AnimationState();
    public AnimationState Enchant2AnimationState = new AnimationState();
    public AnimationState ElectricWhipAnimationState = new AnimationState();
    public AnimationState WhipAndSpearAnimationState = new AnimationState();
    public AnimationState SpawnIdleAnimationState = new AnimationState();
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState SummonSnakeAnimationState = new AnimationState();
    public AnimationState GrabSmashAnimationState = new AnimationState();
    public AnimationState DeathAnimationState = new AnimationState();
    public static final EntityDataAccessor<Boolean> EYE = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> CHAIN_ANCHOR = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Optional<UUID>> ANCHOR_UUID = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> ANCHOR_ID = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> PARRY_COUNT = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> PHASE = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> ACT = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.BOOLEAN);
    private int spin_cooldown = 0;
    public static final int SPIN_COOLDOWN = 160;
    public static final int ATTACK_DELAY = 3;
    private int anchor_pull_cooldown = 0;
    public static final int ANCHOR_COOLDOWN = 140;
    private int wave_cooldown = 0;
    public static final int WAVE_COOLDOWN = 200;
    private int flying_cooldown = 160;
    public static final int FLYING_COOLDOWN = 400;

    private int spear_cooldown = 0;
    public static final int SPEAR_COOLDOWN = 80;
    private int thundercloud_cooldown = 0;
    public static final int THUNDER_CLOUD_COOLDOWN = 350;

    private int summon_snake_cooldown = 0;
    public static final int SUMMON_SNAKE_COOLDOWN = 350;

    private int back_step_cooldown = 0;
    public static final int BACK_STEP_COOLDOWN = 150;
    private int explosion_cooldown = 0;
    public static final int EXPLOSION_COOLDOWN = 300;
    private int whip_cooldown = 0;
    public static final int WHIP_COOLDOWN = 400;
    private int parry_cooldown = 0;
    public static final int PARRY_COOLDOWN = 100;
    public static final int MAX_PARRY_COUNT = 18;
    public static final int CAN_PARRY = 25;
    private int destroyBlocksTick;
    private final CMBossInfoServer bossEvent = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.BLUE,true,12);

    public Scylla_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.setMaxUpStep(1.75F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        setConfigattribute(this, CMConfig.ScyllaHealthMultiplier, CMConfig.ScyllaDamageMultiplier);
    }


    protected void registerGoals() {

        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByNearestTargetGoal(this));
        this.goalSelector.addGoal(4, new InternalMoveGoal(this, false, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

        this.goalSelector.addGoal(0, new Scylla_EntityPhaseChangeGoal(this,0,21,0,55,1,2/3F));
        this.goalSelector.addGoal(0, new Scylla_EntityPhaseChangeGoal(this,0,22,0,68,2,1/3F));


        this.goalSelector.addGoal(3, new HorizontalSwingGoal(this,0,6.75F,38));

        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,5,0,44,14,3.75F){
            @Override
            public boolean canUse() {
                return super.canUse() && Scylla_Entity.this.getRandom().nextFloat() * 100.0F < 14f;
            }
        });

        // snake
        this.goalSelector.addGoal(3, new SummonSnake(this,0,26,0,75,5,6.0F,45F));

        this.goalSelector.addGoal(3, new SpearThrowGoal(this,0,7F,25F,28,16));

        this.goalSelector.addGoal(3, new AnchorThrowGoal(this,0,13,6F,22,25,12));

        this.goalSelector.addGoal(1, new InternalStateGoal(this,23,23,24,0,0){
            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && !Scylla_Entity.this.getAct();
            }

            @Override
            public void tick() {
                entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            }
        });

        this.goalSelector.addGoal(0, new InternalStateGoal(this,24,24,0,40,0){
            @Override
            public void start() {
                super.start();
                Scylla_Entity.this.setEye(true);
            }

            @Override
            public void stop() {
                super.stop();
                Scylla_Entity.this.setEye(false);
            }
        });

        this.goalSelector.addGoal(2, new InternalStateGoal(this,14,14,0,23,10){
            @Override
            public void stop() {
                Entity weapon = getAnchor();
                if(weapon !=null){
                    weapon.discard();
                }
                LivingEntity target = entity.getTarget();
                if(target != null && target.isAlive() && this.entity.distanceTo(target) < 4.0F){
                    this.entity.setAttackState(27);
                }else{
                    super.stop();
                }
            }

        });

        this.goalSelector.addGoal(2, new InternalStateGoal(this, 27, 27, 0, 35,7));

        this.goalSelector.addGoal(3, new Back_StepGoal(this,0,6,0,16,16,3.0F,28F));

        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,7,0,87,56,4.4f){
            @Override
            public boolean canUse() {
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < 22 && Scylla_Entity.this.spin_cooldown <= 0;
            }
            @Override
            public void start() {
                super.start();
                Scylla_Entity.this.setChainAnchor(true);
            }

            @Override
            public void tick() {
                LivingEntity target = entity.getTarget();
                if(target !=null && this.entity.attackTicks < 56 && this.entity.attackTicks >= 12) {
                    this.entity.getNavigation().moveTo(target, 1.2F);
                }else{
                    this.entity.getNavigation().stop();
                }
                if (entity.attackTicks < attackseetick && target != null) {
                    entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30.0F, 30.0F);
                } else {
                    entity.setYRot(entity.yRotO);
                }
            }


            @Override
            public void stop() {
                super.stop();
                Scylla_Entity.this.setChainAnchor(false);
                Scylla_Entity.this.spin_cooldown = SPIN_COOLDOWN;
            }

        });


        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,8,0,65,35,15f){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < 24 && target !=null && this.entity.distanceTo(target) >= 6.5D & Scylla_Entity.this.wave_cooldown <= 0 ;
            }

            @Override
            public void start() {
                super.start();
                Scylla_Entity.this.setEye(true);
            }

            @Override
            public void stop() {
                super.stop();
                Scylla_Entity.this.setEye(false);
                Scylla_Entity.this.wave_cooldown = WAVE_COOLDOWN;
            }

        });

        //whip
        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,20,0,50,17,15f){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < 30 && target !=null && this.entity.distanceTo(target) <= 8.0F && Scylla_Entity.this.whip_cooldown <= 0 && Scylla_Entity.this.isPhase() < 2 && Scylla_Entity.this.isPhase() >0;
            }

            @Override
            public void start() {
                super.start();
                Scylla_Entity.this.setEye(true);
                Scylla_Entity.this.setChainAnchor(true);
            }

            @Override
            public void stop() {
                super.stop();
                Scylla_Entity.this.setEye(false);
                Scylla_Entity.this.setChainAnchor(false);
                Scylla_Entity.this.whip_cooldown = WHIP_COOLDOWN;
            }

        });

        this.goalSelector.addGoal(3, new WhipAndSpearGoal(this,0,25,8.0F,15F,30f));

        this.goalSelector.addGoal(3, new ThunderCloud(this,0,9,0,150,55,15f,16));

        this.goalSelector.addGoal(3, new Scylla_Flying(this, 0, 15, 16, 70, 70, 40f, 47,27F));

        //fall_loop
        this.goalSelector.addGoal(3, new ScyllafallingState(this, 16, 16,17,44, 43));

        //fall_end
        this.goalSelector.addGoal(2, new InternalStateGoal(this, 17, 17, 0, 23,0));


        this.goalSelector.addGoal(3, new Scylla_Lightning_Explosion(this,0,18,0,85,16,16F,26,54,13,20));



        // parry
        this.goalSelector.addGoal(2, new InternalStateGoal(this, 19, 19, 0, 15,15){
            @Override
            public void stop() {
                LivingEntity target = entity.getTarget();
                if(Scylla_Entity.this.back_step_cooldown <= 0 && target !=null){
                    this.entity.setAttackState(6);
                }else{
                    super.stop();
                }
                Scylla_Entity.this.setParryCount(0);
                Scylla_Entity.this.parry_cooldown = PARRY_COOLDOWN;
            }
        });
    }




    public static AttributeSupplier.Builder scylla() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.31F)
                .add(Attributes.ATTACK_DAMAGE, 18)
                .add(Attributes.MAX_HEALTH, 390)
                .add(Attributes.ARMOR, 12)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }




    @Override
    public boolean hurt(DamageSource source, float damage) {
        double range = calculateRange(source);
        if (range > CMConfig.ScyllaLongRangelimit * CMConfig.ScyllaLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            if(canBlockFaceSource(source)) {
                if (!this.level().isClientSide) {
                    if (CanParryState()) {
                        if (this.getParryCount() >= MAX_PARRY_COUNT) {
                            this.setParryCount(CAN_PARRY);
                            this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.8f);
                            this.level().broadcastEntityEvent(this, (byte) 11);
                            return false;
                        } else {
                            if (this.random.nextFloat() * 100.0F < (this.getParryCount() + 1) * 5 && Scylla_Entity.this.parry_cooldown <= 0) {
                                this.setParryCount(CAN_PARRY);
                                this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.8f);
                                this.level().broadcastEntityEvent(this, (byte) 11);
                                return false;
                            }
                        }
                    }
                    if (this.getAttackState() == 19 && this.attackTicks < 11 && this.attackTicks > 1) {
                        this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.8f);
                        this.level().broadcastEntityEvent(this, (byte) 11);
                        return false;
                    }
                }
            }
            if (this.getAttackState() == 21 || this.getAttackState() == 22) {
                return false;
            }

            if (this.isSleep()) {
                return false;
            }
        }
        if (this.destroyBlocksTick <= 0) {
            this.destroyBlocksTick = 20;
        }
        boolean flag = super.hurt(source, damage);
        if(flag) {
            if(canBlockFaceSource(source)) {
                if (this.getParryCount() < MAX_PARRY_COUNT) {
                    this.setParryCount(this.getParryCount() + (source.is(DamageTypeTags.IS_PROJECTILE) ? 2 : 1));
                }
            }
        }

        return flag;
    }

    private boolean CanParryState(){
        return this.attackTicks > 35 && this.getAttackState() == 1
                || this.attackTicks > 35  && this.getAttackState() == 2
                || this.attackTicks > 51 && this.getAttackState() == 3
                || this.attackTicks > 50 && this.getAttackState() == 4;
    }

    @Override
    public void handleDamageEvent(DamageSource damageSource) {
        if(this.getAttackState()==0) {
            this.walkAnimation.setSpeed(1.5F);
        }
        this.invulnerableTime = 20;
        this.hurtDuration = 10;
        this.hurtTime = this.hurtDuration;
        SoundEvent soundevent = this.getHurtSound(damageSource);
        if (soundevent != null) {
            this.playSound(soundevent, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
        }

        this.hurt(this.damageSources().generic(), 0.0F);
        this.lastDamageSource = damageSource;
        this.lastDamageStamp = this.level().getGameTime();
    }

    private boolean canBlockFaceSource(DamageSource damageSource) {
        if (!this.isNoAi()) {
            Vec3 vec32 = damageSource.getSourcePosition();
            if (vec32 != null) {
                Vec3 vec3 = this.calculateViewVector(0.0F, this.getYHeadRot());
                Vec3 vec31 = vec32.vectorTo(this.position());
                vec31 = new Vec3(vec31.x, 0.0, vec31.z).normalize();
                return vec31.dot(vec3) < 0.0;
            }
        }

        return false;
    }

    public float DamageCap() {
        return (float) CMConfig.ScyllaDamageCap;
    }

    public float NatureRegen() {
        return (float) CMConfig.ScyllaNatureHealing;
    }


    public int DamageTime() {
        return CMConfig.ScyllaDamageTime;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType spawnType, @Nullable SpawnGroupData p_29681_, @Nullable CompoundTag p_29682_) {
        if (spawnType == MobSpawnType.COMMAND || spawnType == MobSpawnType.SPAWN_EGG || spawnType == MobSpawnType.SPAWNER || spawnType == MobSpawnType.DISPENSER) {
            this.setAct(true);
        }
        return super.finalizeSpawn(p_29678_, p_29679_, spawnType, p_29681_, p_29682_);
    }


    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        }else if (input == "cross_swing") {
            return this.CrossSwingAnimationState;
        }else if (input == "cross_swing2") {
            return this.CrossSwing2AnimationState;
        }else if (input == "double_swing") {
            return this.DoubleSwingAnimationState;
        }else if (input == "swing_smash") {
            return this.SwingSmashAnimationState;
        }else if (input == "smash") {
            return this.SmashAnimationState;
        }else if (input == "back_step") {
            return this.backstepanimationState;
        }else if (input == "spin") {
            return this.spinAnimationState;
        }else if (input == "wave") {
            return this.waveAnimationState;
        }else if (input == "lightning_explosion") {
            return this.lightningexplosionAnimationState;
        }else if (input == "lightning_spear_throw") {
            return this.LightningSpearAnimationState;
        }else if (input == "water_spear_throw") {
            return this.WaterSpearAnimationState;
        }else if (input == "death") {
            return this.DeathAnimationState;
        }else if (input == "anchor_shot") {
            return this.AnchorShotAnimationState;
        }else if (input == "anchor_shot_pull") {
            return this.AnchorShotPullAnimationState;
        }else if (input == "chain_jump_1") {
            return this.ChainJump1AnimationState;
        }else if (input == "chain_jump_2") {
            return this.ChainJump2AnimationState;
        }else if (input == "chain_jump_3") {
            return this.ChainJump3AnimationState;
        }else if (input == "anchor_explosion") {
            return this.AnchorExplosionAnimationState;
        }else if (input == "parry") {
            return this.ParryAnimationState;
        }else if (input == "electric_whip") {
            return this.ElectricWhipAnimationState;
        }else if (input == "whip_and_spear") {
            return this.WhipAndSpearAnimationState;
        }else if (input == "enchant_1") {
            return this.Enchant1AnimationState;
        }else if (input == "enchant_2") {
            return this.Enchant2AnimationState;
        }else if (input == "spawn_idle") {
            return this.SpawnIdleAnimationState;
        }else if (input == "spawn") {
            return this.SpawnAnimationState;
        }else if (input == "summon_snake") {
            return this.SummonSnakeAnimationState;
        }else if (input == "grab_smash") {
            return this.GrabSmashAnimationState;
        } else {
            return new AnimationState();
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(EYE, false);
        this.entityData.define(CHAIN_ANCHOR, false);
        this.entityData.define(ANCHOR_UUID, Optional.empty());
        this.entityData.define(ANCHOR_ID, -1);
        this.entityData.define(FLYING, false);
        this.entityData.define(PARRY_COUNT, 0);
        this.entityData.define(PHASE, 0);
        this.entityData.define(ACT, false);
    }


    public boolean getEye() {
        return this.entityData.get(EYE);
    }

    public void setEye(boolean weapon) {
        this.entityData.set(EYE, weapon);
    }

    public boolean isFlying() {
        return this.entityData.get(FLYING);
    }

    public void setFlying(boolean flying) {
        this.entityData.set(FLYING, flying);
    }

    public int isPhase() {
        return this.entityData.get(PHASE);
    }

    public void setPhase(int phase) {
        this.entityData.set(PHASE, phase);
    }

    public int getParryCount() {
        return this.entityData.get(PARRY_COUNT);
    }

    public void setParryCount(int parry) {
        this.entityData.set(PARRY_COUNT, parry);
    }

    public boolean getChainAnchor() {
        return this.entityData.get(CHAIN_ANCHOR);
    }

    public void setChainAnchor(boolean weapon) {
        this.entityData.set(CHAIN_ANCHOR, weapon);
    }


    public boolean isSleep() {
        return this.getAttackState() == 23 || this.getAttackState() == 24;
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 23 : 0);
    }

    public void setAct(boolean necklace) {
        this.entityData.set(ACT, necklace);
        this.bossEvent.setVisible(necklace);
        if(!necklace){
            this.setAttackState(23);
        }
    }


    public boolean getAct() {
        return this.entityData.get(ACT);
    }

    @Nullable
    public UUID getAnchorUUID() {
        return this.entityData.get(ANCHOR_UUID).orElse(null);
    }

    public void setAnchorUUID(@Nullable UUID uniqueId) {
        this.entityData.set(ANCHOR_UUID, Optional.ofNullable(uniqueId));
    }

    public Entity getAnchor() {
        if (!level().isClientSide) {
            UUID id = getAnchorUUID();
            return id == null ? null : ((ServerLevel) level()).getEntity(id);
        } else {
            int id = this.entityData.get(ANCHOR_ID);
            return id == -1 ? null : level().getEntity(id);
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                case 0 -> this.stopAllAnimationStates();

                case 1 -> {
                    this.stopAllAnimationStates();
                    this.CrossSwingAnimationState.startIfStopped(this.tickCount);
                }
                case 2 -> {
                    this.stopAllAnimationStates();
                    this.CrossSwing2AnimationState.startIfStopped(this.tickCount);
                }
                case 3 -> {
                    this.stopAllAnimationStates();
                    this.DoubleSwingAnimationState.startIfStopped(this.tickCount);
                }
                case 4 -> {
                    this.stopAllAnimationStates();
                    this.SwingSmashAnimationState.startIfStopped(this.tickCount);
                }
                case 5 -> {
                    this.stopAllAnimationStates();
                    this.SmashAnimationState.startIfStopped(this.tickCount);
                }
                case 6 -> {
                    this.stopAllAnimationStates();
                    this.backstepanimationState.startIfStopped(this.tickCount);
                }
                case 7 -> {
                    this.stopAllAnimationStates();
                    this.spinAnimationState.startIfStopped(this.tickCount);
                }
                case 8 -> {
                    this.stopAllAnimationStates();
                    this.waveAnimationState.startIfStopped(this.tickCount);
                }
                case 9 -> {
                    this.stopAllAnimationStates();
                    this.lightningexplosionAnimationState.startIfStopped(this.tickCount);
                }
                case 10 -> {
                    this.stopAllAnimationStates();
                    this.LightningSpearAnimationState.startIfStopped(this.tickCount);
                }
                case 11 -> {
                    this.stopAllAnimationStates();
                    this.WaterSpearAnimationState.startIfStopped(this.tickCount);
                }
                case 12 -> {
                    this.stopAllAnimationStates();
                    this.DeathAnimationState.startIfStopped(this.tickCount);
                }
                case 13 -> {
                    this.stopAllAnimationStates();
                    this.AnchorShotAnimationState.startIfStopped(this.tickCount);
                }
                case 14 -> {
                    this.stopAllAnimationStates();
                    this.AnchorShotPullAnimationState.startIfStopped(this.tickCount);
                }
                case 15 -> {
                    this.stopAllAnimationStates();
                    this.ChainJump1AnimationState.startIfStopped(this.tickCount);
                }
                case 16 -> {
                    this.stopAllAnimationStates();
                    this.ChainJump2AnimationState.startIfStopped(this.tickCount);
                }
                case 17 -> {
                    this.stopAllAnimationStates();
                    this.ChainJump3AnimationState.startIfStopped(this.tickCount);
                }
                case 18 -> {
                    this.stopAllAnimationStates();
                    this.AnchorExplosionAnimationState.startIfStopped(this.tickCount);
                }
                case 19 -> {
                    this.stopAllAnimationStates();
                    this.ParryAnimationState.startIfStopped(this.tickCount);
                }
                case 20 -> {
                    this.stopAllAnimationStates();
                    this.ElectricWhipAnimationState.startIfStopped(this.tickCount);
                }
                case 21 -> {
                    this.stopAllAnimationStates();
                    this.Enchant1AnimationState.startIfStopped(this.tickCount);
                }
                case 22 -> {
                    this.stopAllAnimationStates();
                    this.Enchant2AnimationState.startIfStopped(this.tickCount);
                }
                case 23 -> {
                    this.stopAllAnimationStates();
                    this.SpawnIdleAnimationState.startIfStopped(this.tickCount);
                }
                case 24 -> {
                    this.stopAllAnimationStates();
                    this.SpawnAnimationState.startIfStopped(this.tickCount);
                }
                case 25 -> {
                    this.stopAllAnimationStates();
                    this.WhipAndSpearAnimationState.startIfStopped(this.tickCount);
                }
                case 26 -> {
                    this.stopAllAnimationStates();
                    this.SummonSnakeAnimationState.startIfStopped(this.tickCount);
                }
                case 27 -> {
                    this.stopAllAnimationStates();
                    this.GrabSmashAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 11) {
            parryParticle(1.5f, 0.9f, 0.0f);
        } else {
            super.handleEntityEvent(id);
        }
    }

    public void stopAllAnimationStates() {
        this.CrossSwingAnimationState.stop();

        this.CrossSwing2AnimationState.stop();

        this.SmashAnimationState.stop();
        this.backstepanimationState.stop();
        this.spinAnimationState.stop();
        this.waveAnimationState.stop();
        this.lightningexplosionAnimationState.stop();
        this.LightningSpearAnimationState.stop();
        this.WaterSpearAnimationState.stop();
        this.DeathAnimationState.stop();
        this.AnchorShotAnimationState.stop();
        this.AnchorShotPullAnimationState.stop();
        this.ChainJump1AnimationState.stop();
        this.ChainJump2AnimationState.stop();
        this.ChainJump3AnimationState.stop();
        this.AnchorExplosionAnimationState.stop();
        this.DoubleSwingAnimationState.stop();
        this.SwingSmashAnimationState.stop();
        this.ParryAnimationState.stop();
        this.ElectricWhipAnimationState.stop();
        this.Enchant1AnimationState.stop();
        this.Enchant2AnimationState.stop();
        this.SpawnIdleAnimationState.stop();
        this.SpawnAnimationState.stop();
        this.WhipAndSpearAnimationState.stop();
        this.SummonSnakeAnimationState.stop();
        this.GrabSmashAnimationState.stop();
    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setEye(true);
        this.setAttackState(12);
    }

    public int deathtimer() {
        return 160;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        if (compound.hasUUID("AnchorUUID")) {
            this.setAnchorUUID(compound.getUUID("AnchorUUID"));
        }
        compound.putInt("Phase", isPhase());
        compound.putBoolean("Act", getAct());
        compound.putBoolean("Sleep", isSleep());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (this.getAnchorUUID() != null) {
            compound.putUUID("AnchorUUID", this.getAnchorUUID());
        }
        setPhase(compound.getInt("Phase"));
        setAct(compound.getBoolean("Act"));
    }




    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0 , this.tickCount);
        }
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        Entity weapon = getAnchor();
        if (weapon instanceof Scylla_Ceraunus_Entity anchor) {
            this.entityData.set(ANCHOR_ID, anchor.getId());
            anchor.setControllerUUID(this.getUUID());
        }


        if (this.isFlying()) {
            this.setNoGravity(!this.verticalCollisionBelow);
        } else {
            this.setNoGravity(false);
        }

        if (spin_cooldown > 0) spin_cooldown--;

        if (anchor_pull_cooldown > 0) anchor_pull_cooldown--;

        if (flying_cooldown > 0) flying_cooldown--;
        if (thundercloud_cooldown > 0) thundercloud_cooldown--;
        if (back_step_cooldown > 0) back_step_cooldown--;
        if (explosion_cooldown > 0) explosion_cooldown--;
        if (whip_cooldown > 0) whip_cooldown--;
        if (wave_cooldown > 0) wave_cooldown--;
        if (spear_cooldown > 0) spear_cooldown--;
        if (parry_cooldown > 0) parry_cooldown--;
        if (summon_snake_cooldown > 0) summon_snake_cooldown--;
        blockbreak();
        floatScylla();
        float dis = this.getBbWidth() * 0.75F;
        repelEntities(dis, this.getBbHeight(), dis, dis);
    }

    private void blockbreak() {
        if (!this.isNoAi()) {
            if(!this.isSleep()) {
                if (!this.level().isClientSide) {
                    if (this.destroyBlocksTick > 0) {
                        --this.destroyBlocksTick;
                        if (this.destroyBlocksTick == 0 &&  net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                            boolean flag = false;
                            AABB aabb = this.getBoundingBox().inflate(0.2D);
                            for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX),  this.getBlockY(), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                                BlockState blockstate = this.level().getBlockState(blockpos);
                                if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.SCYLLA_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
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
    }

    public void aiStep() {
        super.aiStep();
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        if(this.getAttackState() == 1) {
            if (this.attackTicks == 15) {
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(3.25f,6.0f,100,1.0F,80,true);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.1f, 0, 20);
                SwingParticle(vecX,-5,vecZ,1.5,false,0.95F);
            }
        }


        if(this.getAttackState() == 2) {
            if (this.attackTicks == 15) {
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(3.25f,6.0f,100,1.0F,80,true);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.07F, 0, 20);
                SwingParticle(vecX,-5,vecZ,1.5,true,0.95F);

            }

        }
        if(this.getAttackState() == 3) {
            if (this.attackTicks == 16) {
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(3.25f,6.0f,100,0.9F,20,true);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.07f, 0, 20);
                SwingParticle(vecX,-5,vecZ,1.5,false,0.95F);
            }
            if (this.attackTicks == 30) {
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(3.25f,6.0f,100,0.9F,80,true);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.07f, 0, 20);
                SwingParticle(vecX,-5,vecZ,1.5,true,0.95F);
            }
        }

        if(this.getAttackState() == 4) {
            if (this.attackTicks == 16) {
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(3.25f,6.0f,100,1.0F,0,true);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.07f, 0, 20);
                SwingParticle(vecX,-5,vecZ,1.5,false,0.95F);
            }
            if (this.attackTicks == 28) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
                this.playSound(ModSounds.HEAVY_SMASH.get(), 0.8f, 1.0F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.0f,6.75f,65,1.1F,120,false);
                if (!this.level().isClientSide) {
                    spawnLightning(this.getX() + vecX * 3.25F, this.getZ() + vecZ * 3.25F, this.getY() -2, this.getY() + 5, (float) theta, -9,2.0F);
                }else{
                    double vec = 1.5;

                    double d0 = this.getX() + vecX * vec;
                    double d1 = this.getY() + this.getBbHeight()/2 + 0.3;
                    double d2 = this.getZ() + vecZ * vec;

                    float yaw = (float) Math.toRadians(-yBodyRot -90);
                    this.level().addParticle(new Scylla_Swing_Particle.SwingData(this.getScale() * 0.95F,yaw, 0), d0, d1, d2, 0, 0, 0);
                }

            }
        }

        if(this.getAttackState() == 5) {
            if (this.attackTicks == 17) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
                this.playSound(ModSounds.HEAVY_SMASH.get(), 0.8f, 1.0F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.0f,6.75f,65,1.1F,120,false);
                if (!this.level().isClientSide) {
                    spawnLightning(this.getX() + vecX * 3.25F, this.getZ() + vecZ * 3.25F, this.getY() -2, this.getY() + 5, (float) theta, -9,2.0F);
                }else{
                    double vec = 1.5;
                    double d0 = this.getX() + vecX * vec;
                    double d1 = this.getX() + this.getBbHeight()/2 + 0.3;
                    double d2 = this.getZ() + vecZ * vec;
                    float yaw = (float) Math.toRadians(-yBodyRot -90);
                    this.level().addParticle(new Scylla_Swing_Particle.SwingData(this.getScale() * 0.95F,yaw, 0), d0, d1, d2, 0, 0, 0);

                }
            }
        }
        if(this.getAttackState() == 7) {
            if(this.attackTicks < 40 && this.attackTicks >= 12) {
                if (this.level().isClientSide) {
                    float r = 143 / 255F;
                    float g = 241 / 255F;
                    float b = 215 / 255F;

                    this.level().addParticle((new StormParticle.OrbData(99/255F, 194/255F, 224/255F, 6f + random.nextFloat() * 0.25f, 1.5F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    this.level().addParticle((new StormParticle.OrbData(r, g, b, 4f + random.nextFloat() * 1.2f, 1.0F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    this.level().addParticle((new StormParticle.OrbData(r, g, b, 2f + random.nextFloat() * 0.7f, 0.35F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);
                }
            }

            if(this.attackTicks == 29 || this.attackTicks == 40 || this.attackTicks == 51) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.1f, 0, 20);
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 1.1F);
                if (this.level().isClientSide) {
                    double d0 = this.getX();
                    double d1 = this.getY() + this.getBbHeight() / 2 + 0.5;
                    double d2 = this.getZ();
                    float yaw = (float) Math.toRadians(-yBodyRot);
                    double lookX = -Math.cos(yaw);
                    double lookZ = -Math.sin(yaw);
                    float pitch = (float) Math.atan2(-5, Math.sqrt(lookX * lookX + lookZ * lookZ)) ;
                    this.level().addParticle(new Scylla_Swing_Particle.SwingData(this.getScale() * 2.0F, yaw , pitch), d0, d1, d2, 0, 0, 0);
                }else{
                    SpinDamage(2.0f,5.5D,3,1.5,1.0F,(float)CMConfig.ScyllaSpinHpDamage,0,120);
                }


            }
            if(this.attackTicks < 26 && this.attackTicks >= 12) {
                Stormknockback(0.5F, 5.5D);
            }

            if(this.attackTicks < 53 && this.attackTicks >= 26) {
                Stormknockback(0.6F, 5.5D);
            }
        }

        if(this.getAttackState() == 8) {
            if (this.attackTicks == 35) {
                AreaAttack(3.5f, 3.5f, 120, 1.2F, 200, false);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.15f, 0, 20);
                this.playSound(ModSounds.HEAVY_SMASH.get(), 0.8f, 0.95F + this.getRandom().nextFloat() * 0.1F);
                SummonWave(5,25F,2.4D);
                if (this.level().isClientSide()) {
                    double vec = 1.5;

                    double d0 = this.getX() + vecX * vec;
                    double d1 = this.getX() + this.getBbHeight()/2 + 0.3;
                    double d2 = this.getZ() + vecZ * vec;

                    float yaw = (float) Math.toRadians(-yBodyRot -90);
                    this.level().addParticle(new Scylla_Swing_Particle.SwingData(this.getScale() * 0.95F,yaw, 0), d0, d1, d2, 0, 0, 0);
                }

            }
            if (this.attackTicks == 41) {
                if (!this.level().isClientSide()) {
                    SummonWave(4,25F,2.4D);
                }
            }
        }
        if(this.getAttackState() == 9) {

            if (this.attackTicks < 115 && this.attackTicks > 55) {

                CircleLighning(0.2F,0.2F,(random.nextFloat() - 0.5F) * 12, 9 ,3,1);
                Stormknockback(0.7F, 5.5D);

                //Nimbo(0.2F,0.2F,5,9.5D,5,2);

                if (this.level().isClientSide) {
                    float r = 143 / 255F;
                    float g = 241 / 255F;
                    float b = 215 / 255F;

                    this.level().addParticle((new StormParticle.OrbData(99/255F, 194/255F, 224/255F, 6f + random.nextFloat() * 0.25f, 1.5F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    this.level().addParticle((new StormParticle.OrbData(r, g, b, 4f + random.nextFloat() * 1.2f, 1.0F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    this.level().addParticle((new StormParticle.OrbData(r, g, b, 2f + random.nextFloat() * 0.7f, 0.35F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                }

            }
            if (this.attackTicks < 140 && this.attackTicks > 55) {
                Nimbo(0.2F,0.2F,5,9.5D,5,2);

            }
            if (this.attackTicks == 55) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.02f, 20, 10);
            }
            if (this.attackTicks == 75) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.03f, 20, 10);
            }
            if (this.attackTicks == 95) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 25, 0.04f, 20, 10);
            }
            if (this.attackTicks == 114) {
                this.playSound(ModSounds.SUPER_LIGHTNING.get(), 0.4f, 1.0F + this.getRandom().nextFloat() * 0.1F);
                if (this.level().isClientSide) {
                    double d0 = this.getX() + vecX * 0.2F + f * 0.2F;
                    double d1 = this.getY() + 9;
                    double d2 = this.getZ() + vecZ * 0.2F + f1 * 0.2F;
                    this.level().addParticle(ModParticle.LIGHTNING_EXPLODE.get(), d0,d1,d2, 0, 0, 0);
                }
            }
        }

        if(this.getAttackState() == 10) {
            if (this.attackTicks < 24 && this.attackTicks > 7) {
                PullLighning(7,-0.5,-0.5F,this.getBbHeight());
            }
            if (this.attackTicks== 27) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 10);

            }
        }
        if(this.getAttackState() == 11) {
            if (this.attackTicks < 17) {
                if (this.level().isClientSide) {
                    float r = 143 / 255F;
                    float g = 241 / 255F;
                    float b = 215 / 255F;
                    double vec = -0.5;
                    float math = -0.5F;
                    double d0 = this.getX() + vecX * vec + f * math;
                    double d1 = this.getY() + this.getBbHeight();
                    double d2 = this.getZ() + vecZ * vec + f1 * math;
                    this.level().addParticle(new Gathering_Water_Particle.GatheringData(r, g, b), d0 + (random.nextFloat() - 0.5F) * 7, d1 + random.nextFloat() -0.25F, d2 + (random.nextFloat() - 0.5F) * 7, d0, d1, d2);

                }
            }
            if (this.attackTicks== 27) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 10);

            }
        }
        if(this.getAttackState() == 12) {
            if (this.attackTicks < 67 && this.attackTicks > 42) {
                PullLighning(7,0.45,-0.5F,this.getBbHeight() - 0.2D);
            }
            if (this.attackTicks == 42) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.01f, 25, 10);
            }
            if (this.attackTicks == 67) {
                if (!this.level().isClientSide) {
                    double d0 = this.getX() + vecX * 0.5 + f * -0.5;
                    double d1 = this.getY() + this.getBbHeight() /2 ;
                    double d2 = this.getZ() + vecZ * 0.5 + f1 * -0.5;


                    this.level().addFreshEntity(new Lightning_Storm_Entity(this.level(), d0, d1, d2, (float)theta, -9, (float)CMConfig.ScyllaLightningStormDamage,(float)CMConfig.ScyllaLightningStormHpDamage,this,2.0F));

                }
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
            }
            if (this.attackTicks > 100) {
                if (level().isClientSide) {
                    for (int i = 0; i < 4; i++) {
                        double d0 = Math.cos(Math.toRadians((double)(this.getYRot() - this.random.nextFloat() * 80.0F))) * 0.3D ;
                        double d1 = Math.sin(Math.toRadians((double)(this.getYRot() - this.random.nextFloat() * 80.0F))) * 0.3D ;

                        level().addAlwaysVisibleParticle(ParticleTypes.POOF,this.getRandomX(0.5), this.getRandomY() - this.getBbHeight()/2 , this.getRandomZ(0.5), d0 , this.random.nextGaussian() * 0.035, d1);


                    }
                }
            }
        }

        if(this.getAttackState() == 15) {
            if (this.attackTicks == 25) {
                this.setFlying(true);
                this.setDeltaMovement(Vec3.ZERO);
            }
        }


        if(this.getAttackState() == 17) {
            if (this.attackTicks == 1) {
                this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 25, 0.06f, 15, 10);
                if (!level().isClientSide) {
                    for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.5D))) {
                        if (!isAlliedTo(entity) && entity != this) {
                            entity.hurt(CMDamageTypes.causeLightningMobDamage(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.ScyllaHpDamage)));
                        }
                    }
                    int rune = 7;
                    int time = 4;

                    for (int i = 0; i < rune; i++) {
                        float throwAngle = i * Mth.PI / (rune/2);
                        for (int k = 0; k < 5; ++k) {
                            double d2 = 1.75D * (double) (k + 1);
                            int d3 = (int) (time * (k + 1) -9);
                            this.spawnLightning(this.getX() + (double) Mth.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) Mth.sin(throwAngle) * 1.25D * d2, this.getY(), this.getY() + 2, throwAngle, d3,2.0F);
                        }
                    }
                    int sparkAmount = 2;
                    if(this.isPhase() > 0 && this.isPhase() <2) {
                        sparkAmount = 4;
                    }else if (this.isPhase() >1){
                        sparkAmount = 6;
                    }
                    for (int i = 0; i < sparkAmount; i++) {
                        Spark_Entity peq = new Spark_Entity(this.level(), this);
                        peq.setDamage((float) CMConfig.ScyllaLightningStormDamage);
                        peq.setAreaDamage((float) CMConfig.ScyllaLightningAreaDamage);
                        peq.setAreaRadius(1.0F);
                        peq.setHpDamage((float) CMConfig.ScyllaLightningStormHpDamage);
                        peq.shoot((this.random.nextFloat() - 0.5) * 0.5F, this.random.nextFloat() * 0.4F + 0.01F, (this.random.nextFloat() - 0.5) * 0.5F, 1.0F, 1F);
                        peq.setPos(this.getX(), this.getY() + 0.03, this.getZ());
                        this.level().addFreshEntity(peq);
                    }
                }else{
                    this.level().addParticle(ModParticle.LIGHTNING_EXPLODE.get(), this.getX(), this.getY() + 0.03, this.getZ(), 0, 0, 0);
                    for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                        double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                        float angle = (0.01745329251F * this.yBodyRot) + i1;
                        double extraX = 1 * Mth.sin((float) (Math.PI + angle));
                        double extraY = 0.3F;
                        double extraZ = 1 * Mth.cos(angle);
                        int hitX = Mth.floor(getX() + extraX);
                        int hitY = Mth.floor(getY());
                        int hitZ = Mth.floor(getZ() + extraZ);
                        BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                        BlockState block = this.level().getBlockState(hit.below());
                        if (block.getRenderShape() != RenderShape.INVISIBLE) {
                            this.level().addParticle(new BlockParticleOption(ModParticle.DUST_PILLAR.get(), block), getX() + extraX , this.getY() + extraY, getZ() + extraZ , DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                        }
                    }
                }
            }
            if (this.attackTicks >= 1  && this.attackTicks <12) {
                if (level().isClientSide) {
                    double d0 = this.getX();
                    double d1 = this.getY() + 0.03;
                    double d2 = this.getZ();
                    for (int i = 0; i < 2; i++) {
                        this.level().addParticle(new CircleLightningParticle.CircleData(143, 241, 215), d0, d1, d2, d0 + (random.nextFloat() - 0.5F) * 6, d1 + random.nextFloat() - 0.25F, d2 + (random.nextFloat() - 0.5F) * 6);
                    }

                }

            }

        }
        if(this.getAttackState() == 18) {
            double d0 = this.getX() + vecX * 1.1 + f * 0.4;
            double d1 = this.getY() + 0.1;
            double d2 = this.getZ() + vecZ * 1.1 + f1 * 0.4;
            if (this.attackTicks >= 24 && this.attackTicks < 54) {
                if (level().isClientSide) {

                    for (int i = 0; i < 2; i++) {
                        this.level().addParticle(new CircleLightningParticle.CircleData(143, 241, 215), d0, d1, d2, d0 + (random.nextFloat() - 0.5F) * 12, d1, d2 + (random.nextFloat() - 0.5F) * 12);
                    }
                }

            }

            if (this.attackTicks == 25) {
                this.playSound(ModSounds.HEAVY_SMASH.get(), 0.5f, 1.0F + this.getRandom().nextFloat() * 0.1F);
                this.playSound(ModSounds.SUPER_LIGHTNING.get(), 0.2f, 1.0F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 25, 10);

                if (this.level().isClientSide) {
                    float vec = 1.0f;
                    this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 30, 143/255F, 241/255F, 215/255F, 1.0f, 65, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX, getY() + 0.02f, getZ() + vec * vecZ, 0, 0, 0);
                    this.level().addParticle(ModParticle.LIGHTNING_EXPLODE.get(), d0, d1, d2, 0, 0, 0);
                }else {

                    for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(4.0))) {
                        if (!isAlliedTo(entity) && !(entity instanceof Scylla_Entity) && entity != this) {
                            entity.hurt(CMDamageTypes.causeLightningMobDamage(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.ScyllaHpDamage)));

                        }
                    }
                }

            }
            if (this.attackTicks == 53) {
                this.playSound(ModSounds.HEAVY_SMASH.get(), 0.5f, 1.0F + this.getRandom().nextFloat() * 0.1F);
                this.playSound(ModSounds.SUPER_LIGHTNING.get(), 0.2f, 1.0F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 25, 10);
                if (this.level().isClientSide) {
                    float vec = 1.0f;
                    this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 30, 143/255F, 241/255F, 215/255F, 1.0f, 65, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX, getY() + 0.02f, getZ() + vec * vecZ, 0, 0, 0);
                    this.level().addParticle(ModParticle.LIGHTNING_EXPLODE.get(), d0, d1, d2, 0, 0, 0);
                }else {

                    for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(4.0))) {
                        if (!isAlliedTo(entity) && !(entity instanceof Scylla_Entity) && entity != this) {
                            entity.hurt(CMDamageTypes.causeLightningMobDamage(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.ScyllaHpDamage)));

                        }
                    }
                }
            }
        }
        if(this.getAttackState() == 19) {
           // if (this.attackTicks == 1) {
             //   parryParticle(1.5f, 0.9f, 0.0f);
           // }
        }
        if(this.getAttackState() == 20) {
            double d0 = this.getX() + vecX * 6.0;
            double d1 = this.getY() + 0.1;
            double d2 = this.getZ() + vecZ * 6.0;
            if (this.attackTicks == 21) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 35, 0.1f, 0, 50);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.75f, 6.75f, 40, 1.2F, 150, false);
                if (level().isClientSide) {
                    this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 30, 143/255F, 241/255F, 215/255F, 1.0f, 30, false, RingParticle.EnumRingBehavior.GROW), d0, d1, d2, 0, 0, 0);
                    this.level().addParticle(ModParticle.LIGHTNING_EXPLODE.get(), d0, d1, d2, 0, 0, 0);
                    for (int i1 = 0; i1 < 40 + random.nextInt(8); i1++) {
                        double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                        float angle = (0.01745329251F * this.yBodyRot) + i1;
                        double extraX = 1.5F * Mth.sin((float) (Math.PI + angle));
                        double extraY = 0.3F;
                        double extraZ = 1.5F * Mth.cos(angle);
                        double hitX = d0+ extraX;
                        double hitY = this.getY();
                        double hitZ = d2 + extraZ;
                        BlockPos hit = BlockPos.containing(hitX, hitY, hitZ);
                        BlockState block = level().getBlockState(hit.below());

                        BlockParticleOption blockparticleoption = new BlockParticleOption(ModParticle.DUST_PILLAR.get(), block);
                        this.level().addParticle(blockparticleoption, d0 + extraX, this.getY() + extraY, d2 + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                    }
                }else{
                    for (int i = 0; i < 16; i++) {
                        Spark_Entity peq = new Spark_Entity(this.level(), this);
                        peq.setDamage((float) CMConfig.ScyllaLightningStormDamage);
                        peq.setAreaDamage((float) CMConfig.ScyllaLightningAreaDamage);
                        peq.setAreaRadius(2.0F);
                        peq.setHpDamage((float) CMConfig.ScyllaLightningStormHpDamage);
                        peq.shoot((this.random.nextFloat() -0.5) * 0.5F, this.random.nextFloat() * 0.4F + 0.01F,(this.random.nextFloat()  -0.5)  * 0.5F, 1.0F, 1F);
                        peq.setPos(d0, d1, d2);
                        this.level().addFreshEntity(peq);
                    }
                }
            }
            if (this.attackTicks >= 21 && this.attackTicks < 30) {
                if (level().isClientSide) {
                    for (int i = 0; i < 5; i++) {
                        this.level().addParticle(new CircleLightningParticle.CircleData(143, 241, 215), d0, d1, d2, d0 + (random.nextFloat() - 0.5F) * 12, d1, d2 + (random.nextFloat() - 0.5F) * 12);
                    }

                }
            }

        }
        if(this.getAttackState() == 21) {
            if (this.level().isClientSide) {
                if (this.attackTicks > 1 && this.attackTicks <15) {
                    float r = 143 / 255F;
                    float g = 241 / 255F;
                    float b = 215 / 255F;
                    double vec = 1.1;
                    double math = 0.0;
                    double d0 = this.getX() + vecX * vec + f * math;
                    double d1 = this.getY() + this.getBbHeight() * 0.5D;
                    double d2 = this.getZ() + vecZ * vec + f1 * math;
                    for (int i = 0; i < 2; i++) {
                        this.level().addParticle(new Gathering_Water_Particle.GatheringData(r, g, b), d0 + (random.nextFloat() - 0.5F) * 7, d1 + random.nextFloat() - 0.25F, d2 + (random.nextFloat() - 0.5F) * 7, d0, d1, d2);
                    }

                    this.level().addParticle((new StormParticle.OrbData(99/255F, 194/255F, 224/255F, 4f + random.nextFloat() * 0.25f, 0.75F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    this.level().addParticle((new StormParticle.OrbData(r, g, b, 2f + random.nextFloat() * 0.7f, 0.25F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                }

                if(this.attackTicks < 30 && this.attackTicks >= 15) {
                    if (this.level().isClientSide) {
                        float r = 143 / 255F;
                        float g = 241 / 255F;
                        float b = 215 / 255F;

                        this.level().addParticle((new StormParticle.OrbData(99/255F, 194/255F, 224/255F, 8f + random.nextFloat() * 0.25f, 0.75F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                        this.level().addParticle((new StormParticle.OrbData(r, g, b, 6f + random.nextFloat() * 1.2f, 0.25F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    }
                }
            }

            if(this.attackTicks < 15 && this.attackTicks > 1) {
                Stormknockback(0.5F, 4.5D);
            }
            if(this.attackTicks < 30 && this.attackTicks >= 15) {
                Stormknockback(0.9F, 8.5D);
            }
        }
        if(this.getAttackState() == 22) {
            if (level().isClientSide) {
                float vec = -0.6F;
                float math =  0.5F;
                double d0 = this.getX() + vecX * vec + f * math;
                double d1 = this.getY() + this.getBbHeight() * 2 ;
                double d2 = this.getZ() + vecZ * vec + f1 * math;
                if (this.attackTicks == 48) {
                    this.level().addParticle(new LightningStormParticle.StormData(3), d0, d1 + 2.0, d2, 0, 0, 0);
                }
                if (this.attackTicks < 48 && this.attackTicks > 39 ) {
                    CircleLighning(vec,math,(random.nextFloat() - 0.5F) * 7,this.getBbHeight() * 2 -1,2,0);
                }
                if (this.attackTicks > 1 && this.attackTicks <15) {
                    float r = 143 / 255F;
                    float g = 241 / 255F;
                    float b = 215 / 255F;
                    double vec1 = 1.1;

                    double d0w = this.getX() + vecX * vec1;
                    double d1w = this.getY() + this.getBbHeight() * 0.5D;
                    double d2w = this.getZ() + vecZ * vec1;
                    for (int i = 0; i < 2; i++) {
                        this.level().addParticle(new Gathering_Water_Particle.GatheringData(r, g, b), d0w + (random.nextFloat() - 0.5F) * 7, d1w + random.nextFloat() - 0.25F, d2w + (random.nextFloat() - 0.5F) * 7, d0w, d1w, d2w);
                    }
                    this.level().addParticle((new StormParticle.OrbData(99/255F, 194/255F, 224/255F, 4f + random.nextFloat() * 0.25f, 0.75F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    this.level().addParticle((new StormParticle.OrbData(r, g, b, 2f + random.nextFloat() * 0.7f, 0.25F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                }

                if(this.attackTicks < 30 && this.attackTicks >= 15) {
                    if (this.level().isClientSide) {
                        float r = 143 / 255F;
                        float g = 241 / 255F;
                        float b = 215 / 255F;

                        this.level().addParticle((new StormParticle.OrbData(99/255F, 194/255F, 224/255F, 8f + random.nextFloat() * 0.25f, 0.75F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                        this.level().addParticle((new StormParticle.OrbData(r, g, b, 6f + random.nextFloat() * 1.2f, 0.25F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    }
                }
            }
            if(this.attackTicks < 15 && this.attackTicks > 1) {
                Stormknockback(0.5F, 4.5D);
            }
            if(this.attackTicks < 30 && this.attackTicks >= 15) {
                Stormknockback(0.9F, 8.5D);
            }
        }

        if(this.getAttackState() == 24) {
            if (this.attackTicks == 1) {
                if (!this.level().isClientSide) {
                    double d0 = this.getX() + vecX * 1.2 + f * 0.65;
                    double d1 = this.getY() + 0.03;
                    double d2 = this.getZ() + vecZ * 1.2 + f1 * 0.65;
                    this.level().addFreshEntity(new Lightning_Storm_Entity(this.level(), d0, d1, d2, (float) theta, -9, (float) CMConfig.ScyllaLightningStormDamage, (float)CMConfig.ScyllaLightningStormHpDamage, this, 3.0F));
                }
            }
            if (this.attackTicks == 11) {
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(4.0))) {
                    if (!isAlliedTo(entity) && !(entity instanceof Scylla_Entity) && entity != this) {
                        launch(entity, 2.5D,0.3D);
                    }
                }
                this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 25, 0.1f, 25, 10);
                if (!level().isClientSide) {
                    int rune = 7;
                    int time = 4;

                    for (int i = 0; i < rune; i++) {
                        float throwAngle = i * Mth.PI / (rune / 2);
                        for (int k = 0; k < 5; ++k) {
                            double d2 = 1.75D * (double) (k + 1);
                            int d3 = (int) (time * (k + 1) - 9);
                            this.spawnLightning(this.getX() + (double) Mth.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) Mth.sin(throwAngle) * 1.25D * d2, this.getY(), this.getY() + 2, throwAngle, d3, 2.0F);
                        }
                    }
                }


            }
            if (this.attackTicks >= 11  && this.attackTicks <22) {
                if (this.level().isClientSide) {
                    double d0 = this.getX();
                    double d1 = this.getY() + 0.03;
                    double d2 = this.getZ();
                    for (int i = 0; i < 2; i++) {
                        this.level().addParticle(new CircleLightningParticle.CircleData(143, 241, 215), d0, d1, d2, d0 + (random.nextFloat() - 0.5F) * 6, d1 + random.nextFloat() - 0.25F, d2 + (random.nextFloat() - 0.5F) * 6);
                    }
                    for (int i1 = 0; i1 < 20 + random.nextInt(8); i1++) {
                        double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                        float angle = (0.01745329251F * this.yBodyRot) + i1;
                        double extraX = 3F * Mth.sin((float) (Math.PI + angle));
                        double extraY = 0.3F;
                        double extraZ = 3F * Mth.cos(angle);
                        double hitX = d0+ extraX;
                        double hitY = this.getY();
                        double hitZ = d2 + extraZ;
                        BlockPos hit = BlockPos.containing(hitX, hitY, hitZ);
                        BlockState block = level().getBlockState(hit.below());

                        BlockParticleOption blockparticleoption = new BlockParticleOption(ModParticle.DUST_PILLAR.get(), block);
                        this.level().addParticle(blockparticleoption, d0 + extraX, this.getY() + extraY, d2 + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                    }
                }
            }
        }
        if(this.getAttackState() == 25) {
            double d0 = this.getX() + vecX * 6.0;
            double d1 = this.getY() + 0.1;
            double d2 = this.getZ() + vecZ * 6.0;
            if (this.attackTicks == 21) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 35, 0.3f, 0, 50);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.75f, 6.75f, 40, 1.2F, 150, false);
                if (level().isClientSide) {
                    this.level().addParticle(ModParticle.LIGHTNING_EXPLODE.get(), d0, d1, d2, 0, 0, 0);
                    this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 30, 143/255F, 241/255F, 215/255F, 1.0f, 30, false, RingParticle.EnumRingBehavior.GROW), d0, d1, d2, 0, 0, 0);
                    for (int i1 = 0; i1 < 40 + random.nextInt(8); i1++) {
                        double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                        float angle = (0.01745329251F * this.yBodyRot) + i1;
                        double extraX = 1.5F * Mth.sin((float) (Math.PI + angle));
                        double extraY = 0.3F;
                        double extraZ = 1.5F * Mth.cos(angle);
                        double hitX = d0+ extraX;
                        double hitY = this.getY();
                        double hitZ = d2 + extraZ;
                        BlockPos hit = BlockPos.containing(hitX, hitY, hitZ);
                        BlockState block = level().getBlockState(hit.below());

                        BlockParticleOption blockparticleoption = new BlockParticleOption(ModParticle.DUST_PILLAR.get(), block);
                        this.level().addParticle(blockparticleoption, d0 + extraX, this.getY() + extraY, d2 + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                    }
                }else{
                    for (int i = 0; i < 16; i++) {
                        Spark_Entity peq = new Spark_Entity(this.level(), this);
                        peq.setDamage((float) CMConfig.ScyllaLightningStormDamage);
                        peq.setAreaDamage((float) CMConfig.ScyllaLightningAreaDamage);
                        peq.setHpDamage((float) CMConfig.ScyllaLightningStormHpDamage);
                        peq.setAreaRadius(2.0F);
                        peq.shoot((this.random.nextFloat() -0.5) * 0.5F, this.random.nextFloat() * 0.4F + 0.01F,(this.random.nextFloat()  -0.5)  * 0.5F, 1.0F, 1F);
                        peq.setPos(d0, d1, d2);
                        this.level().addFreshEntity(peq);
                    }
                }
            }
            if (this.attackTicks >= 21 && this.attackTicks < 30) {
                if (level().isClientSide) {
                    for (int i = 0; i < 5; i++) {
                        this.level().addParticle(new CircleLightningParticle.CircleData(143, 241, 215), d0, d1, d2, d0 + (random.nextFloat() - 0.5F) * 12, d1, d2 + (random.nextFloat() - 0.5F) * 12);
                    }

                }
            }
            if (this.attackTicks == 104) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 35, 0.3f, 0, 50);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.75f, 6.75f, 40, 1.2F, 150, false);
                if (level().isClientSide) {
                    this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 30, 143/255F, 241/255F, 215/255F, 1.0f, 30, false, RingParticle.EnumRingBehavior.GROW), d0, d1, d2, 0, 0, 0);
                    this.level().addParticle(ModParticle.LIGHTNING_EXPLODE.get(), d0, d1, d2, 0, 0, 0);
                    for (int i1 = 0; i1 < 40 + random.nextInt(8); i1++) {
                        double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                        double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                        float angle = (0.01745329251F * this.yBodyRot) + i1;
                        double extraX = 1.5F * Mth.sin((float) (Math.PI + angle));
                        double extraY = 0.3F;
                        double extraZ = 1.5F * Mth.cos(angle);
                        double hitX = d0+ extraX;
                        double hitY = this.getY();
                        double hitZ = d2 + extraZ;
                        BlockPos hit = BlockPos.containing(hitX, hitY, hitZ);
                        BlockState block = level().getBlockState(hit.below());

                        BlockParticleOption blockparticleoption = new BlockParticleOption(ModParticle.DUST_PILLAR.get(), block);
                        this.level().addParticle(blockparticleoption, d0 + extraX, this.getY() + extraY, d2 + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                    }
                }else{
                    for (int i = 0; i < 16; i++) {
                        Spark_Entity peq = new Spark_Entity(this.level(), this);
                        peq.setDamage((float) CMConfig.ScyllaLightningStormDamage);
                        peq.setAreaDamage((float) CMConfig.ScyllaLightningAreaDamage);
                        peq.setHpDamage((float) CMConfig.ScyllaLightningStormHpDamage);
                        peq.setAreaRadius(2.0F);
                        peq.shoot((this.random.nextFloat() -0.5) * 0.5F, this.random.nextFloat() * 0.4F + 0.01F,(this.random.nextFloat()  -0.5)  * 0.5F, 1.0F, 1F);
                        peq.setPos(d0, d1, d2);
                        this.level().addFreshEntity(peq);
                    }
                }
            }
            if (this.attackTicks >= 104 && this.attackTicks < 113) {
                if (level().isClientSide) {
                    for (int i = 0; i < 5; i++) {
                        this.level().addParticle(new CircleLightningParticle.CircleData(143, 241, 215), d0, d1, d2, d0 + (random.nextFloat() - 0.5F) * 12, d1, d2 + (random.nextFloat() - 0.5F) * 12);
                    }

                }
            }

            if (this.attackTicks < 58 && this.attackTicks >= 41) {
                if (this.level().isClientSide) {
                    float r = 143 / 255F;
                    float g = 241 / 255F;
                    float b = 215 / 255F;
                    double vec = -0.5;
                    float math = -0.5F;
                    double p0 = this.getX() + vecX * vec + f * math;
                    double p1 = this.getY() + this.getBbHeight();
                    double p2 = this.getZ() + vecZ * vec + f1 * math;
                    this.level().addParticle(new Gathering_Water_Particle.GatheringData(r, g, b), p0 + (random.nextFloat() - 0.5F) * 7, p1 + random.nextFloat() -0.25F, p2 + (random.nextFloat() - 0.5F) * 7, p0, p1, p2);

                }
            }
        }
        if(this.getAttackState() == 26) {
            if (level().isClientSide) {
                if (this.attackTicks < 20 && this.attackTicks > 1) {
                    for (int i = 0; i < 2; i++) {
                        float r = 94 / 255F;
                        float g = 150 / 255F;
                        float b = 226 / 255F;
                        double p0 = this.getX();
                        double p1 = this.getY() + 0.1;
                        double p2 = this.getZ();
                        this.level().addParticle(new Gathering_Water_Particle.GatheringData(r, g, b), p0 + (random.nextFloat() - 0.5F) * 12, p1 + (random.nextFloat() - 0.5F) * 2, p2 + (random.nextFloat() - 0.5F) * 12, p0, p1, p2);
                    }

                }
                if (this.attackTicks == 30) {

                    this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 30, 94/255F, 150/255F, 226/255F, 1.0f, 65, false, RingParticle.EnumRingBehavior.GROW), getX(), getY() + 0.02f, getZ(), 0, 0, 0);

                }

                if (this.attackTicks < 40 && this.attackTicks > 30) {
                    float r = 143 / 255F;
                    float g = 241 / 255F;
                    float b = 215 / 255F;

                    this.level().addParticle((new StormParticle.OrbData(99/255F, 194/255F, 224/255F, 6f + random.nextFloat() * 0.25f, 1.5F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    this.level().addParticle((new StormParticle.OrbData(r, g, b, 4f + random.nextFloat() * 1.2f, 1.0F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);

                    this.level().addParticle((new StormParticle.OrbData(r, g, b, 2f + random.nextFloat() * 0.7f, 0.35F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);



                }

            }
            if (this.attackTicks == 1) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 35, 0.1f, 0, 120);
            }
            if (this.attackTicks == 30) {
                this.playSound(ModSounds.SCYLLA_ROAR.get(), 0.6F, 1.0f);
                Roarparticle(-0.4f, 0,2.4F, 20,99,194,224, 0.4F, 0.4f,0.5F,2.5F);
            }

            if (this.attackTicks == 33 || this.attackTicks == 36 || this.attackTicks == 39 ) {
                Roarparticle(-0.4f, 0,2.4F, 20,99,194,224, 0.4F, 0.4f,0.5F,2.5F);
            }
        }
        if(this.getAttackState() == 27) {
            if (this.attackTicks == 11) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
                this.playSound(ModSounds.HEAVY_SMASH.get(), 0.8f, 1.0F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(4.5f,6.75f,65,1.1F,120,false);
                if (!this.level().isClientSide) {
                    spawnLightning(this.getX() + vecX * 3.25F, this.getZ() + vecZ * 3.25F, this.getY() -2, this.getY() + 5, (float) theta, -9,2.0F);
                }else{
                    double vec = 1.5;
                    double d0 = this.getX() + vecX * vec;
                    double d1 = this.getX() + this.getBbHeight()/2 + 0.3;
                    double d2 = this.getZ() + vecZ * vec;
                    float yaw = (float) Math.toRadians(-yBodyRot -90);
                    this.level().addParticle(new Scylla_Swing_Particle.SwingData(this.getScale() * 2.0F,yaw, 0), d0, d1, d2, 0, 0, 0);
                }
            }
        }
    }



    private void SwingParticle(double x,double y,double z,double vec,boolean reverse,float scale) {
        if (this.level().isClientSide) {
            double d0 = this.getX() + x * vec;
            double d1 = this.getY() + this.getBbHeight() / 2 + 0.4;
            double d2 = this.getZ() + z * vec;
            float yaw = (float) Math.toRadians(-yBodyRot + (reverse ? 180 : 0));
            double lookX = -Math.cos(yaw);
            double lookZ = -Math.sin(yaw);
            float pitch = (reverse ? -1 : 1) *(float) Math.atan2(y, Math.sqrt(lookX * lookX + lookZ * lookZ)) ;
            this.level().addParticle(new Scylla_Swing_Particle.SwingData(this.getScale() * scale, yaw , pitch), d0, d1, d2, 0, 0, 0);

        }
    }

    private void Roarparticle(float vec,float math, float y,int duration, int r, int g, int b, float a,float start,float inc,float end) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
            float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);

            this.level().addParticle(new RoarParticle.RoarData(duration, r, g, b, a, start,inc,end), this.getX() + vec * vecX + f * math, this.getY() + y, this.getZ() + vec * vecZ + f1 * math, 0, 0, 0);
        }
    }

    private void Whip(double startdistance,double range,double inflateXZ,double inflateY,int number, float anglestep,float damage, float hpdamage){
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = startdistance * Math.cos(theta);
        double vecZ = startdistance * Math.sin(theta);

        double px = this.getX() + vecX ;
        double pz = this.getZ() + vecZ;
        double firstAngleOffset = (number - 1) / 2.0 * anglestep;
        for (int i = 0; i < number; i++) {
            double angle = yBodyRot + 90 - firstAngleOffset + (i * anglestep);
            float f1 = (float) Math.cos(Math.toRadians(angle));
            float f2 = (float) Math.sin(Math.toRadians(angle));

            AABB attackRange = new AABB(
                    px - inflateXZ, this.getY() - inflateY, pz - inflateXZ,
                    px + inflateXZ, this.getY() + inflateY, pz + inflateXZ
            ).expandTowards(f1 * range * 0.75, 0, f2 * range * 0.75);

            if (this.level().isClientSide) {
                double d0 = px + f1 * range;
                double d1 = this.getY() + 0.3;
                double d2 = pz + f2 * range;
                this.level().addParticle(new CircleLightningParticle.CircleData(143, 241, 215), px, this.getY(), pz, d0+ (random.nextFloat() - 0.5F) * 2, d1, d2+ (random.nextFloat() - 0.5F) * 2);

            }else{
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
                    if (!isAlliedTo(entity) && entity != this) {
                        DamageSource damagesource = CMDamageTypes.causeLightningMobDamage(this);
                        entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min((float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage), entity.getMaxHealth() * hpdamage)));

                    }
                }
            }

        }
    }

    private void LightningAttack(double startdistance,double range,int number, float anglestep){
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = startdistance * Math.cos(theta);
        double vecZ = startdistance * Math.sin(theta);

        double px = this.getX() + vecX ;
        double pz = this.getZ() + vecZ;
        float firstAngleOffset = (number - 1) / 2.0f * anglestep;
        for (int i = 0; i < number; i++) {
            float angle = yBodyRot + 90 - firstAngleOffset + (i * anglestep);
            float f1 = (float) Math.cos(Math.toRadians(angle));
            float f2 = (float) Math.sin(Math.toRadians(angle));

            if (!this.level().isClientSide) {
                Lightning_Area_Effect_Entity areaeffectcloud = new Lightning_Area_Effect_Entity(this.level(), px +f1 * range, this.getY(), pz +f2 * range);
                areaeffectcloud.setRadius(3.5F);
                areaeffectcloud.setOwner(this);
                areaeffectcloud.setRadiusOnUse(-1.5F);
                areaeffectcloud.setDamage(5);
                areaeffectcloud.setWaitTime(20);
                areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
                areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
                //this.level().addFreshEntity(areaeffectcloud);
                this.spawnLightning(px +f1 * range, pz +f2 * range, this.getY() - 5, this.getY() + 3, angle, 0,3.5F);


                StrikeWindmillLightning(px +f1 * range, pz +f2 * range,2, 12, 1.0, 0.7, 0.4, 4);

            }
        }
    }

    private void StrikeWindmillLightning(double x,double z,int numberOfBranches, int particlesPerBranch, double initialRadius, double radiusIncrement, double curveFactor, int delay) {
        float angleIncrement = (float) (2 * Math.PI / numberOfBranches);
        for (int branch = 0; branch < numberOfBranches; ++branch) {
            float baseAngle = angleIncrement * branch;

            for (int i = 0; i < particlesPerBranch; ++i) {
                double currentRadius = initialRadius + i * radiusIncrement;
                float currentAngle = (float) (baseAngle + i * angleIncrement / initialRadius + (float) (i * curveFactor));

                double xOffset = currentRadius * Math.cos(currentAngle);
                double zOffset = currentRadius * Math.sin(currentAngle);

                double spawnX = x + xOffset;
                double spawnZ = z + zOffset;
                int d3 = delay * (i + 1);
                this.spawnLightning(spawnX, spawnZ, this.getY() -5, this.getY() + 3, currentAngle, d3,1.0F);

            }
        }
    }

    private void SpinDamage(float spreadarc, double distance, float mxy, double ab, float damage, float hpdamage, float airborne,int shieldbreakticks) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        double minY = this.getY() - 1;
        double maxY = this.getY() + mxy;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance;
            double pz = this.getZ() + vz * distance;

            AABB selection = new AABB(px - ab, minY, pz - ab, px + ab, maxY, pz + ab);
            List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isAlliedTo(entity) && entity != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage, entity.getMaxHealth() * hpdamage)));
                    if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    if (flag) {
                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne * distance + level().random.nextDouble() * 0.15, 0.0D));

                    }
                }
            }
        }
    }


    private void Stormknockback(float scale, double distance) {

        List<Entity> hit = this.getEntitiesNearby(Entity.class, distance, distance, distance, distance);
        for (Entity target : hit) {
            double d0 = target.getX() - this.getX();
            double d1 = target.getZ() - this.getZ();
            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
            double power = target.isShiftKeyDown() ? scale/3: scale;
            target.push(d0 / d2 * (double)power, 0.0, d1 / d2 * (double)power);
        }

    }

    private void WhipLightningAttack(float distance, float mxy, float math,int lifeticks) {
        double minY = this.getY() - 5;
        double maxY = this.getY() + mxy;
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));

        float f0 = (float) Mth.atan2(f, f1);
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = distance * Math.cos(theta);
        double vecZ = distance * Math.sin(theta);

        double px = this.getX() + vecX + f * math;
        double pz = this.getZ() + vecZ + f1 * math;
        this.spawnLightning(px, pz, minY, maxY, f0, lifeticks,2.0F);

    }



    protected void spawnLightning(double x, double z, double minY, double maxY, float rotation, int delay,float size) {
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
            this.level().addFreshEntity(new Lightning_Storm_Entity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float)CMConfig.ScyllaLightningStormDamage,(float)CMConfig.ScyllaLightningStormHpDamage,this,size));
        }
    }

    private void SummonWave(int number, float anglestep,double vec) {
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        if (!this.level().isClientSide()) {
            double firstAngleOffset = (number - 1) / 2.0 * anglestep;
            for (int i = 0; i < number; i++) {
                double angle = yBodyRot - firstAngleOffset + (i * anglestep);
                double rad = Math.toRadians(angle);
                double dx = -Math.sin(rad);
                double dz = Math.cos(rad);
                double spawnX = this.getX() + vecX * vec;
                double spawnY = this.getY();
                double spawnZ = this.getZ() + vecZ * vec;
                Wave_Entity WaveEntity = new Wave_Entity(this.level(), this, 80, 9);
                WaveEntity.setPos(spawnX, spawnY, spawnZ);
                WaveEntity.setState(1);
                WaveEntity.setYRot(-(float) (Mth.atan2(dx, dz) * (180F / Math.PI)));
                this.level().addFreshEntity(WaveEntity);
            }
        }else{
            int numberOfWaves = number * 3;
            float angleStep = anglestep/3F;

            double firstAngleOffset = (numberOfWaves - 1) / 2.0 * angleStep;
            for (int i = 0; i < numberOfWaves; i++) {
                double angle = yBodyRot - firstAngleOffset + (i * angleStep);
                double rad = Math.toRadians(angle);
                double dx = -Math.sin(rad);
                double dz = Math.cos(rad);
                double spawnX = this.getX() + vecX * vec;
                double spawnY = this.getY();
                double spawnZ = this.getZ() + vecZ * vec;
                double extraX = spawnX + dx * (2 + random.nextDouble() /2);
                double extraY = spawnY + 0.9d + random.nextDouble() * 0.5;
                double extraZ = spawnZ + dz * (2 + random.nextDouble()/2);
                this.level().addParticle(new Not_Spin_TrailParticle.NSTData(113 / 255F, 194 / 255F, 240 / 255F, 0.05F, 0.5F + random.nextFloat() * 0.3F, 0.4F + random.nextFloat() * 0.2F, 0, 80), spawnX, spawnY, spawnZ, extraX, extraY, extraZ);

            }
        }
    }


    private void parryParticle(float height, float vec,float math) {
        if (this.level().isClientSide) {
            double d0 = this.getX();
            double d1 = this.getY() + height;
            double d2 = this.getZ();

            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));

            double theta = (yBodyRot) * (Math.PI / 180);  // 엔티티의 Y축 회전
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);

            double theta2 = theta + Math.PI / 2;
            double X = Math.cos(theta2);
            double Z = Math.sin(theta2);

            for (int i = 0; i < 12; i++) {
                float throwAngle = i * Mth.PI / 6F;
                double y = 2 * Math.sin(throwAngle);
                double xz = 2 * Math.cos(throwAngle);
                double d3 = xz * vecX + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                double d4 = y + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                double d5 = xz * vecZ + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                double speed = 0.35;
                this.level().addParticle(ModParticle.SPARK.get(), d0 + vec * X + f * math, d1, d2 + vec * Z  + f1 * math, d3 * speed, d4 * speed, d5 * speed);
            }
        }
    }


    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks,boolean knockback) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Scylla_Entity) && entityHit != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean hurt = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * CMConfig.ScyllaHpDamage)));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    double d0 = entityHit.getX() - this.getX();
                    double d1 = entityHit.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                    if (hurt && knockback) {
                        entityHit.push(d0 / d2 * 1.5D, 0.15D, d1 / d2 * 1.5D);
                    }
                }
            }
        }
    }
    private void PullLighning(double radius, double vec, float math, double height) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            double d0 = this.getX() + vecX * vec + f * math;
            double d1 = this.getY() + height;
            double d2 = this.getZ() + vecZ * vec + f1 * math;
            this.level().addParticle(new CircleLightningParticle.CircleData(143, 241, 215), d0 + (random.nextFloat() - 0.5F) * radius, d1 + random.nextFloat() - 0.25F, d2 + (random.nextFloat() - 0.5F) * radius, d0, d1, d2);

        }

    }


    private void CircleLighning(float vec, float math,float radius,double EndHeight,int amount, int randamount) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
            float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            double d0 = this.getX() + vecX * vec + f * math;
            double d1 = this.getY() + EndHeight;
            double d2 = this.getZ() + vecZ * vec + f1 * math;

            for (int i = 0; i < amount + random.nextInt(randamount +1); i++) {
                double theta2 = this.random.nextDouble() * 2 * Math.PI;
                double phi = this.random.nextDouble() * Math.PI;

                double posX = radius * Math.sin(phi) * Math.cos(theta2);
                double posY = radius * Math.cos(phi);
                double posZ = radius * Math.sin(phi) * Math.sin(theta2);

                this.level().addParticle(new CircleLightningParticle.CircleData(143, 241, 215), d0 + posX, d1 + posY, d2 + posZ, d0, d1, d2);

            }

        }
    }

    private void launch(Entity e, double XZpower,double Ypower) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        e.push(d0 / d2 * XZpower, Ypower, d1 / d2 * XZpower);
    }

    private void Nimbo(float vec, float math,float radius,double EndHeight,int amount, int randamount) {
        if (this.level().isClientSide) {
            for(int j = 0; j < amount + random.nextInt(randamount); ++j) {
                float f2 = this.random.nextFloat() * ((float)Math.PI * 2F);
                float f3 = Mth.sqrt(this.random.nextFloat()) * radius;


                float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
                float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                double d0 = this.getX() + vecX * vec + f * math  + (double)(Mth.cos(f2) * f3);
                double d2 = this.getY() + EndHeight;
                double d4 = this.getZ() + vecZ * vec + f1 * math + (double)(Mth.sin(f2) * f3);



                this.level().addAlwaysVisibleParticle(ModParticle.RAIN_CLOUD.get(), d0, d2, d4, this.random.nextGaussian() * 0.03D, this.random.nextGaussian() * 0.01D, this.random.nextGaussian() * 0.03D);
            }

        }

    }


    public InteractionResult mobInteract(Player player, InteractionHand hand) {

        if (!this.getAct()) {
            this.setHomePos(this.blockPosition());
            this.setAct(true);
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }


    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_SCYLLA)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.SCYLLA_MUSIC.get();
    }

    protected boolean canPlayMusic() {
        return super.canPlayMusic() && !this.isSleep();
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
                    spawnerblockentity.setEntityId(ModEntities.SCYLLA.get());
                    spawnerblockentity.setItem(0,ModItems.STORM_EYE.get().getDefaultInstance());
                }
            }
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.SCYLLA_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.SCYLLA_DEATH.get();
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);

    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public boolean removeWhenFarAway(double p_21542_) {
        return false;
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    protected boolean isAffectedByFluids() {
        return false;
    }

    public boolean canStandOnFluid(FluidState p_204067_) {
        return p_204067_.is(FluidTags.WATER);
    }


    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    private void floatScylla() {
        if (this.isInWater()) {
            CollisionContext collisioncontext = CollisionContext.of(this);
            if (collisioncontext.isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.WATER)) {
                this.setOnGround(true);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5D).add(0.0D, 0.05D, 0.0D));
            }
        }

    }

    static class HorizontalSwingGoal extends Goal {
        private final Scylla_Entity entity;
        private final int getattackstate;
        private final float attackrange;
        private final float random;


        public HorizontalSwingGoal(Scylla_Entity entity, int getattackstate ,float attackrange,float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.attackrange = attackrange;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
          return target != null && target.isAlive()  && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate;

        }

        @Override
        public void start() {
            this.entity.setAttackState(1 + this.entity.getRandom().nextInt(4));
            entity.setEye(true);
        }


        @Override
        public boolean canContinueToUse() {
            if(this.entity.getAttackState() == 1){
                return this.entity.attackTicks <= 35 + ATTACK_DELAY && this.entity.getAttackState() == 1;
            }else if (this.entity.getAttackState() == 2){
                return this.entity.attackTicks <= 35 + ATTACK_DELAY && this.entity.getAttackState() == 2;
            }else if (this.entity.getAttackState() == 3) {
                return this.entity.attackTicks <= 51 + ATTACK_DELAY && this.entity.getAttackState() == 3;
            }else if (this.entity.getAttackState() == 4) {
                return this.entity.attackTicks <= 50 + ATTACK_DELAY && this.entity.getAttackState() == 4;
            }
            return super.canContinueToUse();
        }


        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            double theta = (this.entity.yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            this.entity.getNavigation().stop();
            if(this.entity.getAttackState() == 1) {
                if (entity.attackTicks < 14 && target != null) {
                    entity.getLookControl().setLookAt(target, 30.0F, 30F);
                    entity.lookAt(target, 30.0F, 30F);
                } else {
                    entity.setYRot(entity.yRotO);
                }

                if (entity.attackTicks == 13) {
                    if (target != null) {
                        float r = entity.distanceTo(target);
                        r = Mth.clamp(r, 1.5F, 4F);
                        entity.push(vecX * 0.45f * r, 0, vecZ * 0.45f * r);
                    } else {
                        entity.push(vecX * 1.8, 0, vecZ * 1.8);
                    }
                }

            } else if (this.entity.getAttackState() == 2) {
                if (entity.attackTicks < 14 && target != null) {
                    entity.getLookControl().setLookAt(target, 30.0F, 30F);
                    entity.lookAt(target, 30.0F, 30F);
                } else {
                    entity.setYRot(entity.yRotO);
                }

                if (entity.attackTicks == 11) {
                    if (target != null) {
                        float r = entity.distanceTo(target);
                        r = Mth.clamp(r, 1.5F, 4F);
                        entity.push(vecX * 0.45f * r, 0, vecZ * 0.45f * r);
                    } else {
                        entity.push(vecX * 1.8, 0, vecZ * 1.8);
                    }
                }
            }else if (this.entity.getAttackState() == 3) {
                if (entity.attackTicks < 16 && target != null || entity.attackTicks > 20 && entity.attackTicks < 30 && target != null) {
                    entity.getLookControl().setLookAt(target, 30.0F, 30F);
                    entity.lookAt(target, 30.0F, 30F);
                } else {
                    entity.setYRot(entity.yRotO);
                }

                if (entity.attackTicks == 12) {
                    if (target != null) {
                        float r = entity.distanceTo(target);
                        r = Mth.clamp(r, 1.5F, 4F);
                        entity.push(vecX * 0.45f * r, 0, vecZ * 0.45f * r);
                    } else {
                        entity.push(vecX * 1.8, 0, vecZ * 1.8);
                    }
                }
                if (entity.attackTicks == 26) {
                    entity.push(vecX * 1.8, 0, vecZ * 1.8);
                }
            }else if (this.entity.getAttackState() == 4) {
                if (entity.attackTicks < 16 && target != null || entity.attackTicks > 20 && entity.attackTicks < 26 && target != null) {
                    entity.getLookControl().setLookAt(target, 30.0F, 30F);
                    entity.lookAt(target, 30.0F, 30F);
                } else {
                    entity.setYRot(entity.yRotO);
                }

                if (entity.attackTicks == 12) {
                    if (target != null) {
                        float r = entity.distanceTo(target);
                        r = Mth.clamp(r, 1.5F, 4F);
                        entity.push(vecX * 0.45f * r, 0, vecZ * 0.45f * r);
                    } else {
                        entity.push(vecX * 1.8, 0, vecZ * 1.8);
                    }
                }
            }
            if(entity.CanParryState() && entity.getParryCount() >= CAN_PARRY){
                stop();
            }
        }

        @Override
        public void stop() {
            if(entity.getParryCount() >= CAN_PARRY){
                this.entity.setAttackState(19);
            }else{
                this.entity.setAttackState(0);
            }
            entity.setEye(false);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class SpearThrowGoal extends Goal {
        private final Scylla_Entity entity;
        private final int getattackstate;
        private final float attackMinrange;
        private final float attackMaxrange;
        private final int attackseetick;
        private final float random;


        public SpearThrowGoal(Scylla_Entity entity, int getattackstate ,float attackMinrange,float attackMaxrange,int attackseetick,float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.attackMinrange = attackMinrange;
            this.attackMaxrange = attackMaxrange;
            this.attackseetick = attackseetick;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive()  && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.distanceTo(target) > attackMinrange && this.entity.distanceTo(target) < attackMaxrange && this.entity.getAttackState() == getattackstate && this.entity.spear_cooldown <= 0;
        }

        @Override
        public void start() {
            if (this.entity.random.nextBoolean()) {
                this.entity.setAttackState(10);
            } else {
                this.entity.setAttackState(11);
            }
            entity.setEye(true);
        }

        @Override
        public boolean canContinueToUse() {
            return (this.entity.getAttackState() == 10 || this.entity.getAttackState() == 11) && this.entity.attackTicks <= 49;
        }


        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            this.entity.getNavigation().stop();
            if (target != null) {
                float f = Mth.cos(entity.yBodyRot * ((float)Math.PI / 180F)) ;
                float f1 = Mth.sin(entity.yBodyRot * ((float)Math.PI / 180F)) ;
                if (entity.attackTicks == 27) {
                    double math = -0.5;
                    double d0 = entity.getX() + f * math;
                    double d1 = entity.getY() + entity.getBbHeight() * 0.8F;
                    double d2 = entity.getZ()+ f1 * math;
                    double d3 = target.getX() - d0;
                    double d4 = target.getY(0.35) - d1;
                    double d5 = target.getZ() - d2;
                    Vec3 vec3 = new Vec3(d3, d4, d5).normalize();
                    float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;
                    float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));
                    if (entity.getAttackState() == 11) {
                        Water_Spear_Entity water = new Water_Spear_Entity(entity, vec3, entity.level(), (float) CMConfig.ScyllaSpearDamage);
                        water.accelerationPower = 0.2D;
                        water.setYRot(yRot);
                        water.setXRot(xRot);
                        water.setPosRaw(d0, d1, d2);
                        water.setTotalBounces(8);
                        entity.level().addFreshEntity(water);
                    }
                    if (entity.getAttackState() == 10) {
                        Lightning_Spear_Entity lightning = new Lightning_Spear_Entity(entity, vec3, entity.level(), (float) CMConfig.ScyllaSpearDamage);
                        lightning.accelerationPower = 0.2D;
                        lightning.setYRot(yRot);
                        lightning.setXRot(xRot);
                        lightning.setPosRaw(d0, d1, d2);
                        lightning.setAreaDamage((float) CMConfig.ScyllaLightningAreaDamage);
                        lightning.setHpDamage((float) CMConfig.ScyllaLightningStormHpDamage);
                        lightning.setAreaRadius(2);
                        entity.level().addFreshEntity(lightning);
                    }
                }
                if (entity.isPhase() > 0) {
                    if (entity.attackTicks == 32) {
                        for (int i = 0; i < 2; ++i) {
                            double dis = 2;
                            double firstAngleOffset = (2 - 1) / 2.0 * dis;
                            double math = -0.5 - firstAngleOffset + (i * dis);
                            double d0 = entity.getX() + f * math;
                            double d1 = entity.getY() + entity.getBbHeight() * 0.7F;
                            double d2 = entity.getZ() + f1 * math;
                            double d3 = target.getX() - d0;
                            double d4 = target.getY(0.35) - d1;
                            double d5 = target.getZ() - d2;
                            Vec3 vec3 = new Vec3(d3, d4, d5).normalize();
                            float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;
                            float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));
                            if (entity.getAttackState() == 11) {
                                Water_Spear_Entity water = new Water_Spear_Entity(entity, vec3, entity.level(), (float) CMConfig.ScyllaSpearDamage);
                                water.accelerationPower = entity.isPhase() < 2 ? 0.15D : 0.2D;
                                water.setYRot(yRot);
                                water.setXRot(xRot);
                                water.setPosRaw(d0, d1, d2);
                                water.setTotalBounces(8);
                                entity.level().addFreshEntity(water);
                            }
                            if (entity.getAttackState() == 10) {
                                Lightning_Spear_Entity lightning = new Lightning_Spear_Entity(entity, vec3, entity.level(), (float) CMConfig.ScyllaSpearDamage);
                                lightning.accelerationPower = entity.isPhase() < 2 ? 0.15D : 0.2D;
                                lightning.setYRot(yRot);
                                lightning.setXRot(xRot);
                                lightning.setPosRaw(d0, d1, d2);
                                lightning.setAreaDamage((float) CMConfig.ScyllaLightningAreaDamage);
                                lightning.setHpDamage((float) CMConfig.ScyllaLightningStormHpDamage);
                                lightning.setAreaRadius(2);

                                entity.level().addFreshEntity(lightning);
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(0);
            entity.setEye(false);
            this.entity.spear_cooldown = SPEAR_COOLDOWN;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }


    static class AnchorThrowGoal extends Goal {
        private final Scylla_Entity entity;
        private final int getattackstate;
        private final int startattackstate;
        private final float attackMinrange;
        private final float attackMaxrange;
        private final int attackseetick;
        private final float random;
        private boolean anchorrecall;

        public AnchorThrowGoal(Scylla_Entity entity, int getattackstate,int startattackstate ,float attackMinrange,float attackMaxrange,int attackseetick,float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.startattackstate = startattackstate;
            this.attackMinrange = attackMinrange;
            this.attackMaxrange = attackMaxrange;
            this.attackseetick = attackseetick;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();

            return target != null && target.isAlive() && this.entity.anchor_pull_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.distanceTo(target) > attackMinrange && this.entity.distanceTo(target) < attackMaxrange && this.entity.getAttackState() == getattackstate;

        }

        @Override
        public void start() {
            this.entity.setAttackState(startattackstate);
            anchorrecall = false;
            entity.setEye(true);
        }

        @Override
        public boolean canContinueToUse() {

            return this.entity.getAttackState() == startattackstate && this.entity.attackTicks <= 90;

        }


        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            this.entity.getNavigation().stop();
            if (entity.attackTicks == 20) {
                if (entity.getAnchor() == null) {
                    Scylla_Ceraunus_Entity throwntrident = new Scylla_Ceraunus_Entity(entity.level(), entity);
                    double theta = (entity.yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    double p0 = entity.getX() + vecX * 3;
                    double p1 = entity.getY() + (entity.getBbHeight() * 0.62D);
                    double p2 = entity.getZ() + vecZ * 3;
                    double p3 = Math.sqrt(p0 * p0 + p2 * p2);
                    if (target != null) {
                        p0 = target.getX() - entity.getX();
                        p1 = target.getY(0.3333333333333333D) - throwntrident.getY();
                        p2 = target.getZ() - entity.getZ();
                        p3 = Math.sqrt(p0 * p0 + p2 * p2);
                    }
                    throwntrident.setBaseDamage(CMConfig.ScyllaAnchordamage);
                    throwntrident.setPhase(entity.isPhase());
                    throwntrident.shoot(p0, p1 + p3 * (double) 0.2F, p2, 2F, 0);
                    throwntrident.setControllerUUID(entity.getUUID());
                    entity.setAnchorUUID(throwntrident.getUUID());
                    entity.level().addFreshEntity(throwntrident);
                }
            }
            if (entity.attackTicks > 20) {
                Entity weapon = entity.getAnchor();
                if (weapon instanceof Scylla_Ceraunus_Entity anchor) {
                    if(anchor.getGrab()){
                        anchorrecall =true;
                        stop();
                    }
                }else if (weapon == null){
                    anchorrecall =true;
                    stop();
                }
            }
        }

        @Override
        public void stop() {
            if(anchorrecall) {
                this.entity.setAttackState(14);
            }else{
                this.entity.setAttackState(0);
            }
            entity.setEye(false);
            this.entity.anchor_pull_cooldown = ANCHOR_COOLDOWN;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class Back_StepGoal extends InternalAttackGoal {
        private final float random;
        private final Scylla_Entity entity;
        private final int getattackstate;

        public Back_StepGoal(Scylla_Entity entity, int attackstate, int attackgetstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float random) {
            super(entity,attackstate,attackgetstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.random = random;
            this.entity = entity;
            this.getattackstate = attackgetstate;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.back_step_cooldown <= 0 || this.entity.getAttackState() == getattackstate;
        }


        @Override
        public void start() {
            super.start();
            float speed = -1.5f;
            float dodgeYaw = (float) Math.toRadians(this.entity.getYRot() + 90 + this.entity.getRandom().nextFloat() * 120 - 60);
            Vec3 m = this.entity.getDeltaMovement().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
            this.entity.setDeltaMovement(m.x, 0.3, m.z);

        }

        @Override
        public void stop() {
            super.stop();
            this.entity.back_step_cooldown = BACK_STEP_COOLDOWN;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class ThunderCloud extends InternalAttackGoal {
        private final float random;
        private final Scylla_Entity entity;

        public ThunderCloud(Scylla_Entity entity, int attackstate, int attackgetstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float random) {
            super(entity,attackstate,attackgetstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.random = random;
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.thundercloud_cooldown <= 0 && this.entity.isPhase() >0;
        }

        @Override
        public void start() {
            super.start();
            entity.setEye(true);
            entity.setChainAnchor(true);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();

            for (int l = 115; l <= 145; l = l + 2) {
            if (entity.attackTicks == l) {
                if (target != null) {
                    float f = Mth.cos(entity.yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(entity.yBodyRot * ((float) Math.PI / 180F));
                    float f2 = entity.random.nextFloat() * ((float) Math.PI * 2F);
                    float f3 = Mth.sqrt(entity.random.nextFloat()) * 5;
                    float math = 0.2F;
                    double d0 = entity.getX() + f * math + (double) (Mth.cos(f2) * f3);
                    double d1 = entity.getY() + entity.getBbHeight() * 2.8F;
                    double d2 = entity.getZ() + f1 * math + (double) (Mth.sin(f2) * f3);
                    double d3 = (target.getX() - ((entity.random.nextDouble() - 0.5F) * 6)) - d0;
                    double d4 = (target.getY(0.35) - entity.random.nextDouble()) - d1;
                    double d5 = (target.getZ() - ((entity.random.nextDouble() - 0.5F) * 6)) - d2;
                    Vec3 vec3 = new Vec3(d3, d4, d5).normalize();
                    float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;

                    float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));

                    Water_Spear_Entity water = new Water_Spear_Entity(entity, vec3, entity.level(), (float) CMConfig.ScyllaSpearDamage);
                    water.setYRot(yRot);
                    water.setXRot(xRot);
                    water.setPosRaw(d0, d1, d2);
                    water.setTotalBounces(3);

                    entity.level().addFreshEntity(water);


                    Lightning_Spear_Entity lightning = new Lightning_Spear_Entity(entity, vec3, entity.level(), (float) CMConfig.ScyllaSpearDamage);
                    lightning.setYRot(yRot);
                    lightning.setXRot(xRot);
                    lightning.setPosRaw(d0, d1, d2);
                    lightning.setAreaDamage((float) CMConfig.ScyllaLightningAreaDamage);
                    lightning.setHpDamage((float) CMConfig.ScyllaLightningStormHpDamage);
                    lightning.setAreaRadius(2);

                    entity.level().addFreshEntity(lightning);
                }
            }
            }
        }

        @Override
        public void stop() {
            super.stop();
            entity.setEye(false);
            entity.setChainAnchor(false);
            this.entity.thundercloud_cooldown = THUNDER_CLOUD_COOLDOWN;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class Scylla_Flying extends InternalAttackGoal {
        private final Scylla_Entity entity;
        private final int attackshot;
        private final float random;

        public Scylla_Flying(Scylla_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.flying_cooldown <= 0;

        }

        @Override
        public void start() {
            super.start();
            entity.setEye(true);
        }

        @Override
        public void stop() {
            super.stop();
            if (entity.isFlying()) {
                entity.setFlying(false);
            }
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackshot && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 90.0F);
                entity.lookAt(target, 30.0F, 90.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }

            if (this.entity.attackTicks == 9) {
                //entity.setFlying(true);
                if (target != null) {
                    double d1 = target.getY() - this.entity.getY();
                    this.entity.setDeltaMovement(0, 1.7 + Mth.clamp(d1 * 0.075, 0.0, 7.0), 0);
                } else {
                    this.entity.setDeltaMovement(0, 1.7, 0);
                }
            }

            if (this.entity.attackTicks == attackshot) {
                if (entity.getAnchor() == null) {
                    if (target != null) {
                        Scylla_Ceraunus_Entity throwntrident = new Scylla_Ceraunus_Entity(entity.level(), entity);

                        double p0 = target.getX() - entity.getX();
                        double p1 = target.getY(0.3333333333333333D) - throwntrident.getY();
                        double p2 = target.getZ() - entity.getZ();
                        double p3 = Math.sqrt(p0 * p0 + p2 * p2);
                        throwntrident.setBaseDamage(CMConfig.ScyllaAnchordamage);
                        throwntrident.setPhase(entity.isPhase());
                        throwntrident.shoot(p0, p1 + p3 * (double) 0.2F, p2, 2F, 0);
                        throwntrident.setControllerUUID(entity.getUUID());
                        throwntrident.setHookMode(true);
                        entity.setAnchorUUID(throwntrident.getUUID());
                        entity.level().addFreshEntity(throwntrident);
                    }
                }
            }
            if (entity.attackTicks > attackshot) {
                Entity weapon = entity.getAnchor();
                if (weapon instanceof Scylla_Ceraunus_Entity anchor) {
                    if(anchor.getGrab()){
                        stop();
                    }
                }else if (weapon == null){
                    stop();
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class ScyllafallingState extends InternalStateGoal {
        private final Scylla_Entity entity;
        private final int attackseetick;

        public ScyllafallingState(Scylla_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.attackseetick = attackseetick;
        }

        @Override
        public void start() {
            super.start();
            if (entity.isFlying()) {
                entity.setFlying(false);
            }
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 0F);
                entity.lookAt(target, 30.0F, 0F);
            } else {
                entity.setYRot(entity.yRotO);
            }

            Entity weapon = entity.getAnchor();
            if (weapon instanceof Scylla_Ceraunus_Entity anchor) {
                double maxSpeed = 18;
                double pullSpeed = maxSpeed / 6D;
                Vec3 distance = anchor.position().subtract(entity.position().add(0, entity.getBbHeight() / 2, 0));
                Vec3 motion = distance.normalize().scale( pullSpeed);

                if (Math.abs(distance.y) < 0.1D)
                    motion = new Vec3(motion.x, 0, motion.z);
                if (new Vec3(distance.x, 0, distance.z).length() < new Vec3(entity.getBbWidth() / 2, 0, entity.getBbWidth() / 2).length() / 1.4)
                    motion = new Vec3(0, motion.y, 0);

                entity.setDeltaMovement(motion);
                entity.hurtMarked = true;
            }
            if(entity.attackTicks > 5 && entity.verticalCollisionBelow){
                stop();
            }
        }

        @Override
        public void stop() {
            super.stop();
            Entity weapon = entity.getAnchor();
            if(weapon !=null){
                weapon.discard();
            }
            this.entity.flying_cooldown = FLYING_COOLDOWN;
        }
    }


    static class Scylla_Lightning_Explosion extends InternalAttackGoal {
        private final Scylla_Entity entity;
        private final int attackshot;
        private final int attackshot2;
        private final float random;
        private final int lifeticks;
        private double prevX;
        private double prevZ;
        private double newX;
        private double newZ;

        public Scylla_Lightning_Explosion(Scylla_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, int attackshot2,int lifeticks, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.attackshot2 = attackshot2;
            this.lifeticks = lifeticks;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.explosion_cooldown <= 0&& this.entity.isPhase() >= 1;
        }

        @Override
        public void start() {
            super.start();
            entity.setEye(true);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                prevX = target.getX();
                prevZ = target.getZ();
            }
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.explosion_cooldown = EXPLOSION_COOLDOWN;
        }

        @Override
        public void tick() {
            super.tick();
            LivingEntity target = entity.getTarget();

            if (this.entity.attackTicks == attackshot && target != null) {
                double x = target.getX();
                double z = target.getZ();

                double vx = (x - prevX) / attackshot;
                double vz = (z - prevZ) / attackshot;

                newX = x + vx * lifeticks;
                newZ = z + vz * lifeticks;
                for (int k = -4; k <= 4; ++k) {
                    double d2 = 1.25D * (double) (k);
                    float yaw = target.getYRot() * (float) Math.PI / 180F;
                    this.entity.spawnLightning(newX + Mth.cos(yaw) * d2, newZ + Mth.sin(yaw) * d2, entity.getY() - 2, entity.getY() + 5, yaw, 0,3.0F);
                }
            }

            if (this.entity.attackTicks == attackshot2 && target != null) {
                double x = target.getX();
                double z = target.getZ();

                double vx = (x - prevX) / attackshot2;
                double vz = (z - prevZ) / attackshot2;

                newX = x + vx * lifeticks;
                newZ = z + vz * lifeticks;
                for (int k = -4; k <= 4; ++k) {
                    double d2 = 1.25D * (double) (k);
                    float yaw = target.getYRot() * (float) Math.PI / 180F;
                    this.entity.spawnLightning(newX + Mth.cos(yaw) * d2, newZ + Mth.sin(yaw) * d2, entity.getY() - 2, entity.getY() + 5, yaw, 0,3.0F);
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }


    static class Scylla_EntityPhaseChangeGoal extends Goal {
        protected final Scylla_Entity entity;
        private final int phasestate;
        private final float health;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;

        public Scylla_EntityPhaseChangeGoal(Scylla_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int phasestate,float health) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.phasestate = phasestate;
            this.health = health;
        }

        @Override
        public boolean canUse() {
            return this.entity.isPhase() < phasestate && this.entity.getAttackState() == getattackstate && this.entity.getHealth() <= this.entity.getMaxHealth() * health;
        }

        @Override
        public void start() {
            if(getattackstate != attackstate) {
                this.entity.setAttackState(attackstate);
            }
            this.entity.setEye(true);
            this.entity.setPhase(phasestate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.setEye(false);
        }

        @Override
        public boolean canContinueToUse() {
            return attackMaxtick > 0 ? this.entity.attackTicks <= attackMaxtick : canUse();
        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }


    static class WhipAndSpearGoal extends Goal {
        private final Scylla_Entity entity;
        private final int getattackstate;
        private final int setattackstate;
        private final float attackMinrange;
        private final float attackMaxrange;
        private final float random;


        public WhipAndSpearGoal(Scylla_Entity entity, int getattackstate, int setattackstate ,float attackMinrange,float attackMaxrange,float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.setattackstate = setattackstate;
            this.attackMinrange = attackMinrange;
            this.attackMaxrange = attackMaxrange;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
           return target != null && target.isAlive()  && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.distanceTo(target) >= attackMinrange && this.entity.isPhase() >=2 && this.entity.distanceTo(target) <= attackMaxrange && this.entity.getAttackState() == getattackstate && this.entity.whip_cooldown <= 0;
        }

        @Override
        public void start() {
            this.entity.setAttackState(setattackstate);
            entity.setEye(true);
            entity.setChainAnchor(true);
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.getAttackState() == setattackstate && this.entity.attackTicks <= 130;
        }


        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < 17 && target != null ||
                    entity.attackTicks > 45 && target != null && entity.attackTicks < 66 ||
                    entity.attackTicks > 80 && target != null && entity.attackTicks < 95) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            this.entity.getNavigation().stop();
            if (target != null) {
                float f = Mth.cos(entity.yBodyRot * ((float)Math.PI / 180F)) ;
                float f1 = Mth.sin(entity.yBodyRot * ((float)Math.PI / 180F)) ;
                if (entity.attackTicks == 68) {
                    float math = -0.5F;
                    int spearAmount = 5;
                    double offsetangle = toRadians(15);
                    double d0 = entity.getX() + f * math;
                    double d1 = entity.getY() + entity.getBbHeight() * 0.7F;
                    double d2 = entity.getZ() + f1 * math ;

                    double d3 = target.getX() - d0;
                    double d4 = target.getY(0.2D) - d1;
                    double d5 = target.getZ() - d2;

                    for (int i = 0; i <= (spearAmount - 1); ++i) {
                        double angle = (i - ((spearAmount - 1) / 2.0)) * offsetangle;
                        double x = d3 * cos(angle) + d5 * sin(angle);
                        double y = d4;
                        double z = -d3 * sin(angle) + d5 * cos(angle);

                        Vec3 vec3 = new Vec3(x, y, z).normalize();
                        float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;
                        float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));

                        Water_Spear_Entity water = new Water_Spear_Entity(entity, vec3, entity.level(), (float) CMConfig.ScyllaSpearDamage);
                        water.accelerationPower = 0.2D;
                        water.setYRot(yRot);
                        water.setXRot(xRot);
                        water.setPosRaw(d0, d1, d2);
                        water.setTotalBounces(8);
                        entity.level().addFreshEntity(water);
                    }

                }

            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(0);
            entity.setEye(false);
            entity.setChainAnchor(false);
            this.entity.whip_cooldown = WHIP_COOLDOWN;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class SummonSnake extends InternalAttackGoal {
        private final float random;
        private final Scylla_Entity entity;

        public SummonSnake(Scylla_Entity entity, int attackstate, int attackgetstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float random) {
            super(entity,attackstate,attackgetstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.random = random;
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.summon_snake_cooldown <= 0 && this.entity.isPhase() >0;
        }

        @Override
        public void start() {
            super.start();
            entity.setEye(true);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();

            if (target != null) {
                if (entity.attackTicks == 28) {
                    for (int i = 0; i < 2; ++i) {
                        float f = Mth.cos(entity.yBodyRot * ((float) Math.PI / 180F));
                        float f1 = Mth.sin(entity.yBodyRot * ((float) Math.PI / 180F));
                        double dis = 8;
                        double firstAngleOffset = (2 - 1) / 2.0 * dis;
                        double math = 0 - firstAngleOffset + (i * dis);
                        double d0 = entity.getX() + f * math;
                        double d1 = entity.getY() + entity.getBbHeight() * 0.7F;
                        double d2 = entity.getZ() + f1 * math;
                        double d3 = target.getX() - d0;
                        double d4 = target.getY(0.35) - d1;
                        double d5 = target.getZ() - d2;
                        Vec3 vec3 = new Vec3(d3, d4, d5).normalize();

                        entity.level().addFreshEntity(new Storm_Serpent_Entity(entity.level(), d0, entity.getY(), d2, (float) (Mth.atan2(vec3.z, vec3.x)), i * 8, entity, (float) CMConfig.ScyllaSnakeDamage, target, i == 0));

                    }
                }
                if (this.entity.isPhase() > 1) {
                    if (entity.attackTicks == 40) {
                        for (int i = 0; i < 2; ++i) {
                            float f = Mth.cos(entity.yBodyRot * ((float) Math.PI / 180F));
                            float f1 = Mth.sin(entity.yBodyRot * ((float) Math.PI / 180F));
                            double dis = 12;
                            double firstAngleOffset = (2 - 1) / 2.0 * dis;
                            double math = 0 - firstAngleOffset + (i * dis);
                            double d0 = entity.getX() + f * math;
                            double d1 = entity.getY() + entity.getBbHeight() * 0.7F;
                            double d2 = entity.getZ() + f1 * math;
                            double d3 = target.getX() - d0;
                            double d4 = target.getY(0.35) - d1;
                            double d5 = target.getZ() - d2;
                            Vec3 vec3 = new Vec3(d3, d4, d5).normalize();


                            entity.level().addFreshEntity(new Storm_Serpent_Entity(entity.level(), d0, entity.getY(), d2, (float) (Mth.atan2(vec3.z, vec3.x)), i * 8, entity, (float) CMConfig.ScyllaSnakeDamage, target, i == 0));


                        }
                    }
                }
            }

        }

        @Override
        public void stop() {
            super.stop();
            entity.setEye(false);
            this.entity.summon_snake_cooldown = SUMMON_SNAKE_COOLDOWN;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}





