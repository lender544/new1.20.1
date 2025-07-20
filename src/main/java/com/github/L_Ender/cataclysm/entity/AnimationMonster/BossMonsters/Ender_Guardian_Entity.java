package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.*;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Void_Vortex_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Ender_Guardian_Bullet_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.*;

public class Ender_Guardian_Entity extends LLibrary_Boss_Monster {

    private final CMBossInfoServer bossInfo = new CMBossInfoServer(this.getDisplayName(),BossEvent.BossBarColor.PURPLE,false,1);
    private static final EntityDataAccessor<Boolean> IS_HELMETLESS = SynchedEntityData.defineId(Ender_Guardian_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> USED_MASS_DESTRUCTION = SynchedEntityData.defineId(Ender_Guardian_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Optional<BlockPos>> TELEPORT_POS = SynchedEntityData.defineId(Ender_Guardian_Entity.class, EntityDataSerializers.OPTIONAL_BLOCK_POS);
    public static final Animation GUARDIAN_RIGHT_STRONG_ATTACK = Animation.create(60);
    public static final Animation GUARDIAN_LEFT_STRONG_ATTACK = Animation.create(60);
    public static final Animation GUARDIAN_RIGHT_ATTACK = Animation.create(40);
    public static final Animation GUARDIAN_LEFT_ATTACK = Animation.create(40);
    public static final Animation GUARDIAN_BURST_ATTACK = Animation.create(53);
    public static final Animation GUARDIAN_UPPERCUT_AND_BULLET = Animation.create(100);
    public static final Animation GUARDIAN_RAGE_UPPERCUT = Animation.create(120);
    public static final Animation GUARDIAN_STOMP = Animation.create(48);
    public static final Animation GUARDIAN_RAGE_STOMP = Animation.create(83);
    public static final Animation GUARDIAN_MASS_DESTRUCTION = Animation.create(75);
    public static final Animation GUARDIAN_FALLEN = Animation.create(196);
    public static final Animation GUARDIAN_HUG_ME = Animation.create(76);
    public static final Animation GUARDIAN_AIR_STRIKE1 = Animation.create(123);
    public static final Animation GUARDIAN_AIR_STRIKE2 = Animation.create(39);
    public static final Animation GUARDIAN_RIGHT_SWING = Animation.create(42);
    public static final Animation GUARDIAN_LEFT_SWING = Animation.create(42);
    public static final Animation GUARDIAN_BLACKHOLE = Animation.create(62);
    public static final Animation GUARDIAN_ROCKETPUNCH = Animation.create(58);
    public static final int STOMP_COOLDOWN = 400;
    public static final int UPPERCUT_COOLDOWN = 200;
    public static final int TELEPORT_COOLDOWN = 280;
    public static final int TELEPORT_SMASH_COOLDOWN = 600;
    public static final int VORTEX_COOLDOWN = 280;
    public boolean Breaking = CMConfig.EnderguardianBlockBreaking;

    private int stomp_cooldown = 0;
    private int teleport_cooldown = 0;
    private int teleport_smash_cooldown = 0;
    private int uppercut_cooldown = 0;
    private int vortexcooldown = 0;

    public Ender_Guardian_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 300;
        this.setMaxUpStep(1.75F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
        setConfigattribute(this, CMConfig.EnderguardianHealthMultiplier, CMConfig.EnderguardianDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{
                NO_ANIMATION,
                GUARDIAN_RIGHT_STRONG_ATTACK,
                GUARDIAN_LEFT_STRONG_ATTACK,
                GUARDIAN_BURST_ATTACK,
                GUARDIAN_UPPERCUT_AND_BULLET,
                GUARDIAN_STOMP,
                GUARDIAN_RIGHT_ATTACK,
                GUARDIAN_LEFT_ATTACK,
                GUARDIAN_MASS_DESTRUCTION,
                GUARDIAN_RAGE_STOMP,
                GUARDIAN_RAGE_UPPERCUT,
                GUARDIAN_FALLEN,
                GUARDIAN_HUG_ME,
                GUARDIAN_AIR_STRIKE1,
                GUARDIAN_AIR_STRIKE2,
                GUARDIAN_LEFT_SWING,
                GUARDIAN_RIGHT_SWING,
                GUARDIAN_BLACKHOLE,
                GUARDIAN_ROCKETPUNCH};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new AttackMoveGoal(this,true,1.0));
        this.goalSelector.addGoal(1, new PunchAttackGoal(this));
        this.goalSelector.addGoal(1, new AttackAnimationGoal2<>(this, GUARDIAN_MASS_DESTRUCTION, 39, 50){
            @Override
            public void start() {
                super.start();
                entity.setUsedMassDestruction(true);
            }
        });
        this.goalSelector.addGoal(1, new AttackAnimationGoal2<>(this, GUARDIAN_BURST_ATTACK, 27, 47));
        this.goalSelector.addGoal(1, new VoidVortexGoal(this, GUARDIAN_BLACKHOLE));
        this.goalSelector.addGoal(1, new RocketPunchGoal(this, GUARDIAN_ROCKETPUNCH));
        this.goalSelector.addGoal(1, new SimpleAnimationGoal<>(this, GUARDIAN_AIR_STRIKE2));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, GUARDIAN_RIGHT_SWING, 26, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, GUARDIAN_LEFT_SWING, 26, true));
        this.goalSelector.addGoal(1, new HugmeGoal(this, GUARDIAN_HUG_ME,30,20));
        this.goalSelector.addGoal(1, new TeleportStrikeGoal(this, GUARDIAN_AIR_STRIKE1));
        this.goalSelector.addGoal(1, new StompAttackGoal(this));
        this.goalSelector.addGoal(1, new UppercutAndBulletGoal(this,GUARDIAN_UPPERCUT_AND_BULLET));
        this.goalSelector.addGoal(1, new RageUppercut(this,GUARDIAN_RAGE_UPPERCUT));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByNearestTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

    }

    public static AttributeSupplier.Builder ender_guardian() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.27F)
                .add(Attributes.ATTACK_DAMAGE, 16)
                .add(Attributes.MAX_HEALTH, 333)
                .add(Attributes.ARMOR, 20)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_HELMETLESS, false);
        this.entityData.define(TELEPORT_POS, Optional.empty());
        this.entityData.define(USED_MASS_DESTRUCTION, false);
    }

    private static Animation getRandomAttack(RandomSource rand) {
        switch (rand.nextInt(4)) {
            case 0:
                return GUARDIAN_RIGHT_STRONG_ATTACK;
            case 1:
                return GUARDIAN_LEFT_STRONG_ATTACK;
            case 2:
                return GUARDIAN_RIGHT_ATTACK;
            case 3:
                return GUARDIAN_LEFT_ATTACK;
        }
        return GUARDIAN_RIGHT_STRONG_ATTACK;
    }


    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        Optional<BlockPos> restPos = getTeleportPos();
        if (restPos.isPresent()) {
            compound.put("TeleportPos", NbtUtils.writeBlockPos(getTeleportPos().get()));
        }

        compound.putBoolean("is_Helmetless", getIsHelmetless());
        compound.putBoolean("used_mass_destruction", getUsedMassDestruction());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("TeleportPos")) {
            setTeleportPos(NbtUtils.readBlockPos(compound.getCompound("TeleportPos")));
        }
        setIsHelmetless(compound.getBoolean("is_Helmetless"));
        setUsedMassDestruction(compound.getBoolean("used_mass_destruction"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void setIsHelmetless(boolean isHelmetless) {
        if (isHelmetless) {
            this.getAttribute(Attributes.ARMOR).setBaseValue(15F);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.29F);
        }else{
            this.getAttribute(Attributes.ARMOR).setBaseValue(20F);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.27F);
        }
        this.entityData.set(IS_HELMETLESS, isHelmetless);
    }

    public boolean getIsHelmetless() {
        return this.entityData.get(IS_HELMETLESS);

    }

    public void setUsedMassDestruction(boolean usedMassDestruction) {
        this.entityData.set(USED_MASS_DESTRUCTION, usedMassDestruction);
    }

    public boolean getUsedMassDestruction() {
        return this.entityData.get(USED_MASS_DESTRUCTION);
    }

    public void setTeleportPos(BlockPos p_30220_) {
        this.entityData.set(TELEPORT_POS, Optional.of(p_30220_));
    }

    public Optional<BlockPos> getTeleportPos() {
        return this.entityData.get(TELEPORT_POS);
    }


    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (this.getAnimation() == GUARDIAN_MASS_DESTRUCTION && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        double range = calculateRange(source);

        if (range > CMConfig.EnderguardianLongRangelimit * CMConfig.EnderguardianLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getDirectEntity();
        if (!this.getIsHelmetless()) {
            if (entity instanceof AbstractArrow) {
                return false;
            }
        }
        if (entity instanceof ShulkerBullet || entity instanceof Ender_Guardian_Bullet_Entity) {
            return false;
        }
        if (entity instanceof AbstractGolem) {
            damage *= 0.5F;
        }

        boolean attack = super.hurt(source, damage);
        if(attack) {
            if (this.getIsHelmetless()) {
                this.playSound(SoundEvents.SHULKER_HURT, 1.0f, 0.8f);
            }
        }
        return attack;
    }

    
    public float DamageCap() {
        return (float) CMConfig.EnderguardianDamageCap;
    }

    public float NatureRegen() {
        return (float) CMConfig.EnderguardianNatureHealing;
    }

    public int DamageTime() {
        return CMConfig.EnderguardianDamageTime;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL)  || super.isInvulnerableTo(source);
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    public void tick() {
        super.tick();
        //prevgetYRot() = getYRot();
        repelEntities(1.8F, 4.0f, 1.8F, 1.8F);
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());

        LivingEntity target = this.getTarget();

        Animation animation = getRandomAttack(random);
        Animation animation2 = this.getIsHelmetless() ? GUARDIAN_RAGE_UPPERCUT : GUARDIAN_UPPERCUT_AND_BULLET;
        if (this.isAlive()) {
            if (!this.getIsHelmetless() && this.isHelmetless()) {
                this.setIsHelmetless(true);
                BrokenHelmet();
            }
            if (!isNoAi() && this.getAnimation() == NO_ANIMATION && !this.getUsedMassDestruction() && this.isHelmetless()) {
                this.setAnimation(GUARDIAN_MASS_DESTRUCTION);
            }
            else if (target != null && target.isAlive()) {
                if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr(target) >= 256 && this.distanceToSqr(target) <= 1024.0D && target.onGround() && this.getIsHelmetless() && this.getRandom().nextFloat() * 100.0F < 20f  && teleport_smash_cooldown <= 0) {
                    teleport_smash_cooldown = TELEPORT_SMASH_COOLDOWN;
                    this.setAnimation(GUARDIAN_AIR_STRIKE1);
                }else if (vortexcooldown <= 0 && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceToSqr(target) <= 1024.0D && (this.distanceToSqr(target) >= 35.0D &&this.getRandom().nextFloat() * 100.0F < 2f || this.getRandom().nextFloat() * 100.0F < 60f && this.getY() + 3 <= target.getY())) {
                    vortexcooldown = VORTEX_COOLDOWN;
                    this.setAnimation(GUARDIAN_BLACKHOLE);
                } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) >= 4.3 && this.distanceTo(target) <= 16D && target.onGround() && this.getRandom().nextFloat() * 100.0F < 4f && teleport_cooldown <= 0) {
                    teleport_cooldown = TELEPORT_COOLDOWN;
                    this.setAnimation(GUARDIAN_HUG_ME);
                } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 4.3 && target.onGround() && this.getRandom().nextFloat() * 100.0F < 0.7f && teleport_cooldown <= 0) {
                    teleport_cooldown = TELEPORT_COOLDOWN;
                    this.setAnimation(GUARDIAN_HUG_ME);
                } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 2.75F) {
                    if (this.random.nextInt(6) == 0) {
                        this.setAnimation(GUARDIAN_BURST_ATTACK);
                    } else {
                        this.setAnimation(animation);
                    }
                } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) > 2.75F && this.distanceTo(target) < 4.3F && (target.hasEffect(MobEffects.LEVITATION) || target.hasEffect(ModEffect.EFFECTSTUN.get()))) {
                    uppercut_cooldown = UPPERCUT_COOLDOWN;
                    this.setAnimation(animation2);
                } else if (stomp_cooldown <= 0 && !isNoAi() && this.getAnimation() == NO_ANIMATION && target.onGround() && (this.distanceTo(target) > 6F && this.distanceTo(target) < 13F && this.getRandom().nextFloat() * 100.0F < 10f || this.distanceTo(target) > 2.75F && this.distanceTo(target) < 4.3F && this.getRandom().nextFloat() * 100.0F < 2f)) {
                    stomp_cooldown = STOMP_COOLDOWN;
                    Animation animation3 = this.getIsHelmetless() ? GUARDIAN_RAGE_STOMP : GUARDIAN_STOMP;
                    this.setAnimation(animation3);
                } else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) > 2.75F && this.distanceTo(target) < 4.3F) {
                    if (this.random.nextInt(4) == 0) {
                        uppercut_cooldown = UPPERCUT_COOLDOWN;
                        this.setAnimation(animation2);
                    } else {
                        this.setAnimation(animation);
                    }
                }
            }
        }


        if (stomp_cooldown > 0) stomp_cooldown--;
        if (teleport_cooldown > 0) teleport_cooldown--;
        if (teleport_smash_cooldown > 0) teleport_smash_cooldown--;
        if (uppercut_cooldown > 0) uppercut_cooldown--;
        if (vortexcooldown > 0) vortexcooldown--;
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAnimation() == GUARDIAN_LEFT_STRONG_ATTACK) {
            if (this.getAnimationTick() < 2) {
                GravityPullparticle();
            }
            if (this.getAnimationTick() < 29) {
                GravityPull();
            }
            if (this.getAnimationTick() == 34) {
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.15f,5,70,1.0f,(float) CMConfig.EnderguardianGravityPunchHpdamage,100,0,0,false);
                Attackparticle(2.2f,0);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.2f, 0, 10);
            }

        }
        if (this.getAnimation() == GUARDIAN_RIGHT_STRONG_ATTACK) {
            if (this.getAnimationTick() < 2) {
                GravityPullparticle();
            }
            if (this.getAnimationTick() < 24) {
                GravityPull();
            }
            if (this.getAnimationTick() == 29) {
                AreaAttack(5.15f,5,70,1.0f,(float) CMConfig.EnderguardianGravityPunchHpdamage,100,0,0,false);
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.2f,0);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.2f, 0, 10);
            }

        }

        if (this.getAnimation() == GUARDIAN_RIGHT_ATTACK) {
            if (this.getAnimationTick() == 22) {
                AreaAttack(5.85f,5,80,1, 0,80,0,0,false);
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.75f,0.5f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 10);
            }
        }

        if (this.getAnimation() == GUARDIAN_LEFT_ATTACK) {
            if (this.getAnimationTick() == 19) {
                AreaAttack(5.85f,5,80,1,0,80,0,0,false);
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.75f,-0.5f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 10);
            }
        }

        if (this.getAnimation() == GUARDIAN_BURST_ATTACK) {
            if (this.getAnimationTick() == 15) {
                Burstparticle();
            }
            if (this.getAnimationTick() == 27) {
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(7.5f,6,100,1,(float) CMConfig.EnderguardianKnockbackHpdamage,0,0,0,true);
            }
        }
        if (this.getAnimation() == GUARDIAN_UPPERCUT_AND_BULLET || this.getAnimation() == GUARDIAN_RAGE_UPPERCUT) {
            if (this.getAnimationTick() == 27) {
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.25f,7,60,1.4f,(float) CMConfig.EnderguardianUppercutHpdamage,150,60,0.5F,false);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.3f, 0, 10);
            }
        }
        if (this.getAnimation() == GUARDIAN_STOMP) {
            if (this.getAnimationTick() == 32) {
                StompAttack();
                Attackparticle(0.4f,0.8f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.1f, 0, 5);
            }
        }
        if (this.getAnimation() == GUARDIAN_RAGE_STOMP) {
            if (this.getAnimationTick() == 32 || this.getAnimationTick() == 53 || this.getAnimationTick() == 62) {
                StompAttack();
                Attackparticle(0.4f,0.8f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.1f, 0, 5);
            }
        }
        if (this.getAnimation() == GUARDIAN_RAGE_UPPERCUT) {
            if (this.getAnimationTick() == 84) {
                RageAttack();
                AreaAttack(5.5f,5,120,1.2f,(float) CMConfig.EnderguardianAreaAttackHpdamage,100,0,0.0F,false);

                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 10);
            }
        }

        if (this.getAnimation() == GUARDIAN_MASS_DESTRUCTION) {
            if (this.getAnimationTick() == 39) {
                Attackparticle(2.75f,2.25f);
                Attackparticle(2.75f,-2.25f);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.3f, 0, 10);
                MassDestruction(5.0f, 1.1f,150);
                if (!this.level().isClientSide) {
                    if (Breaking) {
                        BlockBreaking(CMConfig.EnderguardianBlockBreakingX, CMConfig.EnderguardianBlockBreakingY, CMConfig.EnderguardianBlockBreakingZ);
                    } else {
                        if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                            BlockBreaking(CMConfig.EnderguardianBlockBreakingX, CMConfig.EnderguardianBlockBreakingY, CMConfig.EnderguardianBlockBreakingZ);
                        }
                    }
                }
            }
        }

        if (this.getAnimation() == GUARDIAN_HUG_ME) {
            if (this.getAnimationTick() == 15) {
                Teleportparticle();
            }

            if (this.getAnimationTick() == 38) {
                AreaAttack(6.0f,6.0f,120,1.0f,(float) CMConfig.EnderguardianTeleportAttackHpdamage,80,60,0.6F,false);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 10);

            }
        }

        if (this.getAnimation() == GUARDIAN_AIR_STRIKE1) {
            if (this.getAnimationTick() == 20) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.15f, 0, 20);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
            }

            if (this.getAnimationTick() == 40) {
                this.playSound(SoundEvents.SHULKER_TELEPORT, 1.0F, 1.0F);
            }
        }


        if (this.getAnimation() == GUARDIAN_AIR_STRIKE2) {
            if (this.getAnimationTick() == 3) {
                MassDestruction(3.0F,1.5F,200);
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.5f,1.25f);
                Attackparticle(2.5f,-0.5f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                switch (random.nextInt(3)) {
                    case 0 -> StrikeRune(8,0.5);
                    case 1 -> StrikeRune(10,0.75);
                    case 2 -> StrikeRune(12,1);
                    default -> {
                    }
                }
            }
        }

        if (this.getAnimation() == GUARDIAN_RIGHT_SWING || this.getAnimation() == GUARDIAN_LEFT_SWING) {
            if (this.getAnimationTick() == 24) {
                this.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 2.0f, 0.5F);
                AreaAttack(4.25f,4.25f,80,1.0f, 0,40,40,0.0F,true);
            }
        }
        if (this.getAnimation() == GUARDIAN_BLACKHOLE) {
            if (this.getAnimationTick() == 26) {
                this.playSound(ModSounds.ENDER_GUARDIAN_FIST.get(), 0.3f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(1.0f,0.2f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.1f, 0, 5);
            }
        }
        if (this.getAnimation() == GUARDIAN_ROCKETPUNCH) {
            if (this.getAnimationTick() == 24) {
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.getAnimationTick() == 28) {
                AreaAttack(7f,7f,120,1.25f, (float) CMConfig.EnderguardianRocketPunchHpdamage,200,0,0.0F,true);
            }
        }


    }


    private void StrikeRune(int rune, double time) {
        for (int i = 0; i < rune; i++) {
            float throwAngle = i * Mth.PI / (rune/2);
            for (int k = 0; k < 8; ++k) {
                double d2 = 1.15D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnFangs(this.getX() + (double) Mth.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) Mth.sin(throwAngle) * 1.25D * d2, this.getY(), this.getY() + 2, throwAngle, d3);
            }

        }
    }


    public boolean isHelmetless() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        setDeltaMovement(0, Ender_Guardian_Entity.this.getDeltaMovement().y, 0);
        if (this.deathTime == 50) {
            this.playSound(ModSounds.MONSTROSITYLAND.get(), 1, 1);
        }
        if (this.deathTime == 100) {
            this.playSound(SoundEvents.SHULKER_TELEPORT, 1, 1);
        }

    }


    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        if(CMConfig.EnderGuardianRespawner) {
            if (!this.level().isClientSide) {
                if (this.getHomePos() != BlockPos.ZERO) {
                    int newX = Mth.floor(this.getHomePos().getX());
                    int newY = Mth.floor(this.getHomePos().getY());
                    int newZ = Mth.floor(this.getHomePos().getZ());
                    Respawner(newX, newZ, newY - 10, newY);
                }
            }
        }
    }


    private void Respawner(int x, int z, int minY, int maxY) {
        //  BlockPos blockpos = BlockPos.containing(x, maxY, z);
        BlockPos blockpos = new BlockPos(x,maxY,z);
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
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        BlockState block = ModBlocks.BOSS_RESPAWNER.get().defaultBlockState();
        int newY = Mth.floor((double)blockpos.getY() + d0);
        BlockPos pos = new BlockPos(x,flag ?newY :maxY,z);
        this.level().setBlock(pos, block, 2);
        if (level().getBlockEntity(pos) instanceof Boss_Respawn_Spawner_Block_Entity spawnerblockentity) {
            spawnerblockentity.setEntityId(ModEntities.ENDER_GUARDIAN.get());
            spawnerblockentity.setItem(0,ModItems.VOID_EYE.get().getDefaultInstance());
        }

    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return GUARDIAN_FALLEN;
    }


    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks, float airborne, boolean knockback) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        if (!this.level().isClientSide) {
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
                if (!(entityHit instanceof Ender_Guardian_Entity)) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    if (airborne > 0) {
                        entityHit.setDeltaMovement(entityHit.getDeltaMovement().add(0.0D, airborne, 0.0D));

                    }
                    if (flag) {
                        if (stunticks > 0) {
                            entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), stunticks));
                        }
                    }

                    if(knockback){
                        launch(entityHit);
                    }
                }
            }
            }
        }
    }


    private void MassDestruction(float grow, float damage, int ticks) {
        if (!this.level().isClientSide) {
            for (LivingEntity entityHit : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(grow))) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ender_Guardian_Entity) && entityHit != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    entityHit.hurt(damagesource, (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage);
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && ticks > 0) {
                        disableShield(player, ticks);
                    }

                    launch(entityHit);
                }
            }
        }
    }

    private void BlockBreaking(int x, int y, int z) {
        int MthX = Mth.floor(this.getX());
        int MthY = Mth.floor(this.getY());
        int MthZ = Mth.floor(this.getZ());
        boolean flag = false;
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = -y; j <= -1; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState block = this.level().getBlockState(blockpos);
                    if (block != Blocks.AIR.defaultBlockState() && block.is(ModTag.ENDER_GUARDIAN_CAN_DESTROY)) {
                        if (block.canEntityDestroy(this.level(), blockpos, this) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, block)) {
                            flag = this.level().destroyBlock(blockpos, false, this) || flag;
                        }
                    }
                }
            }
        }
    }


    private void Burstparticle() {
        if (this.level().isClientSide) {
            double d0 = this.getX();
            double d1 = this.getY() + 2.0;
            double d2 = this.getZ();
            int size = (int) 5f;
            for (int i = -size; i <= size; ++i) {
                for (int j = -size; j <= size; ++j) {
                    for (int k = -size; k <= size; ++k) {
                        double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                        double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                        double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                        double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;
                        this.level().addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, d3 / d6, d4 / d6, d5 / d6);
                        if (i != -size && i != size && j != -size && j != size) {
                            k += size * 2 - 1;
                        }
                    }
                }
            }
        }
    }

    private void Teleportparticle() {
        if (this.level().isClientSide) {
            if (getTeleportPos().isPresent()) {
                double d0 = this.getTeleportPos().get().getX();
                double d1 = this.getY();
                double d2 = this.getTeleportPos().get().getZ();
                if (this.level().isClientSide) {
                    for (int i1 = 0; i1 < 40 + random.nextInt(12); i1++) {
                        double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                        float angle = (0.01745329251F * this.yBodyRot) + i1;
                        double extraX = 2F * Mth.sin((float) (Math.PI + angle));
                        double extraY = 0.3F;
                        double extraZ = 2F * Mth.cos(angle);
                        this.level().addParticle(ParticleTypes.END_ROD, d0 + extraX, d1 + extraY, d2 + extraZ, 0, DeltaMovementY, 0);
                    }
                }
            }
        }
    }


    private void launch(Entity entityHit) {
        double d0 = entityHit.getX() - this.getX();
        double d1 = entityHit.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        entityHit.push(d0 / d2 * 4.0D, 0.2D, d1 / d2 * 4.0D);
    }

    private void GravityPull() {
        List<LivingEntity> entities = getEntityLivingBaseNearby(12, 12, 12, 12);
        for (LivingEntity inRange : entities) {
            if (inRange instanceof Player && ((Player) inRange).getAbilities().invulnerable) continue;
            if (isAlliedTo(inRange)) continue;
            float angle = (0.01745329251F * this.yBodyRot);
            double extraX = Mth.sin((float) (Math.PI + angle));
            double extraZ = Mth.cos(angle);
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            Vec3 diff = inRange.position().subtract(position().add(2.0 * vecX + extraX * 0.25, 0, 2.0 * vecZ + extraZ * 0.25));
            diff = diff.normalize().scale(0.085);
            inRange.setDeltaMovement(inRange.getDeltaMovement().subtract(diff));

        }
    }

    private void GravityPullparticle() {
        if (this.level().isClientSide) {
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = Mth.cos(angle);
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                this.level().addParticle(ParticleTypes.PORTAL, getX() + 2.2 * vecX + extraX * 0.75, this.getY() + extraY, getZ() + 2.2 * vecZ + extraZ * 0.75, (this.random.nextDouble() - 0.5D) * 12.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 12.0D);
            }
        }
    }

    private void Attackparticle(float vec, float math) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
            float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = 1.2 * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 1.2 * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX+ extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());
                if (block.getRenderShape() != RenderShape.INVISIBLE) {
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }

            }
            this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 25, 1f, 1f, 1f, 1f, 25f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.3f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
        }
    }

    private void StompAttack() {
        this.playSound(ModSounds.ENDER_GUARDIAN_FIST.get(), 0.3f, 1F + this.getRandom().nextFloat() * 0.1F);
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0D;
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());

            float angle2 = (0.01745329251F * this.yBodyRot);

            for (int k = 0; k < 6; ++k) {
                float f2 = angle2 + (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 5F);
                this.spawnFangs(this.getX() + (double) Mth.cos(f2) * 2.5D, this.getZ() + (double) Mth.sin(f2) * 2.5D, d0, d1, f2, 3);
            }
            for (int k = 0; k < 11; ++k) {
                float f3 = angle2 + (float) k * (float) Math.PI * 2.0F / 11.0F + ((float) Math.PI * 2F / 10F);
                this.spawnFangs(this.getX() + (double) Mth.cos(f3) * 3.5D, this.getZ() + (double) Mth.sin(f3) * 3.5D, d0, d1, f3, 10);
            }
            for (int k = 0; k < 14; ++k) {
                float f4 = angle2 + (float) k * (float) Math.PI * 2.0F / 14.0F + ((float) Math.PI * 2F / 20F);
                this.spawnFangs(this.getX() + (double) Mth.cos(f4) * 4.5D, this.getZ() + (double) Mth.sin(f4) * 4.5D, d0, d1, f4, 15);
            }

            float[] all = { f - 0.4f, f, f + 0.4f };


            float[] all2 = { f - 0.1f, f + 0.1f };

            switch (random.nextInt(3)) {
                case 0:
                    for (float angle : all) {
                        for (int l = 0; l < 13; ++l) {
                            double d2 = 1.25D * (double) (l + 1);
                            int j = (int) (0.75f * l);
                            this.spawnFangs(this.getX() + (double) Mth.cos(angle) * d2, this.getZ() + (double) Mth.sin(angle) * d2, d0, d1, angle, j);
                        }
                    }
                    break;
                case 1:
                    for (float angle : all2) {
                        for (int l = 0; l < 13; ++l) {
                            double d2 = 1.25D * (double) (l + 1);
                            int j = (int) (0.25f * l);
                            this.spawnFangs(this.getX() + (double) Mth.cos(angle) * d2, this.getZ() + (double) Mth.sin(angle) * d2, d0, d1, angle, j);
                        }
                    }
                    break;
                case 2:
                    for (int l = 0; l < 13; ++l) {
                        double d2 = 1.25D * (double) (l + 1);
                        int j = (int) (0.5f * l);
                        this.spawnFangs(this.getX() + (double) Mth.cos(f) * d2, this.getZ() + (double) Mth.sin(f) * d2, d0, d1, f, j);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void RageAttack() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0D;

            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());

            float[] all = { f - 0.3f,f - 0.6f,f - 0.9f, f, f + 0.3f, f + 0.6f, f + 0.9f };

            for (float angle : all) {
                for (int l = 0; l < 10; ++l) {
                    double d2 = 1.25D * (double) (l + 1);
                    int j = (int) (0.75f * l);
                    this.spawnFangs(this.getX() + (double) Mth.cos(angle) * d2, this.getZ() + (double) Mth.sin(angle) * d2, d0, d1, angle, j);
                }
            }
        }
    }


    private void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
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
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            this.level().addFreshEntity(new Void_Rune_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay,(float) CMConfig.Voidrunedamage, this));
        }
    }

    private void spawnVortex(double x, double z, double minY, double maxY, float rotation) {
        BlockPos blockpos =  BlockPos.containing(x, maxY, z);
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
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            this.level().addFreshEntity(new Void_Vortex_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, this,300));
        }
    }

    private void BrokenHelmet() {
        if (!this.level().isClientSide) {
            double xx = Mth.cos(this.getYRot() % 360.0F / 180.0F * 3.1415927F) * 0.75F;
            double zz = Mth.sin(this.getYRot() % 360.0F / 180.0F * 3.1415927F) * 0.75F;
            this.level().explode(this, this.getX() + xx, this.getY() + (double) this.getEyeHeight(), getZ() + zz, 2.0F, Level.ExplosionInteraction.NONE);
        }
    }

    private void Bulletpattern() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            BlockPos tgt = target.blockPosition();
            double tx = tgt.getX();
            double tz = tgt.getZ();
            double ty = target.getY() + 0.1;
            if (this.getAnimationTick() == 54) {
                if (!target.onGround() && !target.isInWater() && !this.level().getBlockState(tgt.below()).blocksMotion())
                    ty -= 1;
                {
                    BlockPos Pos = this.blockPosition();
                    double sx = Pos.getX();
                    double sz = Pos.getZ();
                    Direction dir = Direction.getNearest(tx - sx, 0, tz - sz);
                    double cx = dir.getStepX();
                    double cz = dir.getStepZ();
                    double offsetangle = toRadians(6.0);

                    for (int i = -4; i <= 4; i++) {
                        double angle = (i - (4 / 2)) * offsetangle;
                        double x = cx * cos(angle) + cz * sin(angle);
                        double z = -cx * sin(angle) + cz * cos(angle);
                        Ender_Guardian_Bullet_Entity bullet = new Ender_Guardian_Bullet_Entity(level(), this, x, this.getY() + 2, z);
                        bullet.setOwner(this);
                        bullet.setPos(getX(), getY() - 2 + random.nextDouble() * 4, getZ());
                        bullet.setUp(30, cx, 0, cz, tx - 7 * cx + i * cz, ty, tz - 7 * cz + i * cx);
                       this.level().addFreshEntity(bullet);
                    }
                }
            }
        }
    }


    private boolean teleport(double p_32544_, double p_32545_, double p_32546_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(p_32544_, p_32545_, p_32546_);

        while(blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        if (flag) {
            net.minecraftforge.event.entity.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, p_32544_, p_32545_, p_32546_);
            if (event.isCanceled()) return false;
            Vec3 vec3 = this.position();
            boolean flag2 = this.ProperTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2) {
                this.level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
                if (!this.isSilent()) {
                    this.playSound(SoundEvents.SHULKER_TELEPORT, 1.0F, 1.0F);
                }
            }
            return flag2;
        } else {
            return false;
        }
    }


    public boolean ProperTeleport(double p_20985_, double p_20986_, double p_20987_, boolean p_20988_) {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        double d3 = p_20986_;
        boolean flag = false;
        BlockPos blockpos = BlockPos.containing(p_20985_, p_20986_, p_20987_);
        Level level = this.level();
        if (level.hasChunkAt(blockpos)) {
            boolean flag1 = false;

            while(!flag1 && blockpos.getY() > level.getMinBuildHeight()) {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = level.getBlockState(blockpos1);
                if (blockstate.blocksMotion()) {
                    flag1 = true;
                } else {
                    --d3;
                    blockpos = blockpos1;
                }
            }

            if (flag1) {
                this.teleportTo(p_20985_, d3, p_20987_);
                if (level.noCollision(this) && !level.containsAnyLiquid(this.getBoundingBox())) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            this.teleportTo(d0, d1, d2);
            return false;
        } else {
            if (p_20988_) {
                level.broadcastEntityEvent(this, (byte)46);
            }
            this.getNavigation().stop();

            return true;
        }
    }


    @Override
    protected boolean isAffectedByFluids() {
        return false;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }
    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {
            itementity.setDeltaMovement(itementity.getDeltaMovement().multiply(0.0, 3.5, 0.0));
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_ENDER_GUARDIAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.ENDERGUARDIANHURT.get();
    }

    protected SoundEvent getAmbientSound() {
        return this.getIsHelmetless() ? SoundEvents.SHULKER_AMBIENT : super.getAmbientSound();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.ENDERGUARDIANDEATH.get();

    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.ENDERGUARDIAN_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic();
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

    class PunchAttackGoal extends AnimationGoal<Ender_Guardian_Entity> {

        public PunchAttackGoal(Ender_Guardian_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == GUARDIAN_LEFT_ATTACK
                    || animation == GUARDIAN_RIGHT_ATTACK
                    || animation == GUARDIAN_LEFT_STRONG_ATTACK
                    || animation == GUARDIAN_RIGHT_STRONG_ATTACK;
        }

        public void tick() {
            Ender_Guardian_Entity.this.setDeltaMovement(0, Ender_Guardian_Entity.this.getDeltaMovement().y, 0);
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_LEFT_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 17 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 27 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                   // Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
                if (Ender_Guardian_Entity.this.getAnimationTick() == 24 && target != null && Ender_Guardian_Entity.this.random.nextInt(2) == 0 && Ender_Guardian_Entity.this.distanceTo(target) <= 4) {
                    AnimationHandler.INSTANCE.sendAnimationMessage(Ender_Guardian_Entity.this, GUARDIAN_LEFT_SWING);
               }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_RIGHT_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 22 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 32 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                  //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
                if (Ender_Guardian_Entity.this.getAnimationTick() == 26 && target != null && Ender_Guardian_Entity.this.random.nextInt(2) == 0 && Ender_Guardian_Entity.this.distanceTo(target) <= 4) {
                   AnimationHandler.INSTANCE.sendAnimationMessage(Ender_Guardian_Entity.this, GUARDIAN_RIGHT_SWING);
//
                }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_LEFT_STRONG_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 34 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 44 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                 //   Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
            }
            if (Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_RIGHT_STRONG_ATTACK) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 29 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 39 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                  //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
            }
        }
    }

    class StompAttackGoal extends AnimationGoal<Ender_Guardian_Entity> {

        public StompAttackGoal(Ender_Guardian_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == GUARDIAN_STOMP
                    || animation == GUARDIAN_RAGE_STOMP;
        }

        public void tick() {
            Ender_Guardian_Entity.this.setDeltaMovement(0, Ender_Guardian_Entity.this.getDeltaMovement().y, 0);
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if(Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_STOMP) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 32 && target != null || Ender_Guardian_Entity.this.getAnimationTick() > 42 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                   // Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
            }
            if(Ender_Guardian_Entity.this.getAnimation() == GUARDIAN_RAGE_STOMP) {
                if (Ender_Guardian_Entity.this.getAnimationTick() < 32 && target != null
                        || Ender_Guardian_Entity.this.getAnimationTick() > 42 && Ender_Guardian_Entity.this.getAnimationTick() < 53 && target != null
                        || Ender_Guardian_Entity.this.getAnimationTick() > 58 && target != null) {
                    Ender_Guardian_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                   // Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
                }
            }
        }
    }


    class UppercutAndBulletGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {

        public UppercutAndBulletGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimationTick() < 29 && target != null
                    || Ender_Guardian_Entity.this.getAnimationTick() > 54 && target !=null) {
                Ender_Guardian_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                setYRot(yBodyRot);
            } else {
                Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
              //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }
            if (Ender_Guardian_Entity.this.getAnimationTick() == 26) {
                float f1 = (float) Math.cos(Math.toRadians(Ender_Guardian_Entity.this.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(Ender_Guardian_Entity.this.getYRot() + 90));
                if(target != null) {
                    float r = Ender_Guardian_Entity.this.distanceTo(target);
                    r = Mth.clamp(r, 0, 7);
                    Ender_Guardian_Entity.this.push(f1 * 0.3 * r, 0, f2 * 0.3 * r);
                }else{
                    Ender_Guardian_Entity.this.push(f1 * 2.0, 0, f2 * 2.0);
                }
            }
            if(Ender_Guardian_Entity.this.getAnimationTick() > 32 || Ender_Guardian_Entity.this.getAnimationTick() < 26){
                Ender_Guardian_Entity.this.setDeltaMovement(0, Ender_Guardian_Entity.this.getDeltaMovement().y, 0);
            }

            Bulletpattern();

        }
    }

    class RageUppercut extends SimpleAnimationGoal<Ender_Guardian_Entity> {

        public RageUppercut(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Ender_Guardian_Entity.this.getTarget();
            if (Ender_Guardian_Entity.this.getAnimationTick() < 29 && target != null
                    || Ender_Guardian_Entity.this.getAnimationTick() > 54 && Ender_Guardian_Entity.this.getAnimationTick() < 84 && target != null
                    ||Ender_Guardian_Entity.this.getAnimationTick() > 104 && target !=null) {
                Ender_Guardian_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                setYRot(yBodyRot);
            } else {
                Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }
            if (Ender_Guardian_Entity.this.getAnimationTick() == 26) {
                float f1 = (float) Math.cos(Math.toRadians(Ender_Guardian_Entity.this.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(Ender_Guardian_Entity.this.getYRot() + 90));
                if(target != null) {
                    float r = Ender_Guardian_Entity.this.distanceTo(target);
                    r = Mth.clamp(r, 0, 7);
                    Ender_Guardian_Entity.this.push(f1 * 0.3 * r, 0, f2 * 0.3 * r);
                }else{
                    Ender_Guardian_Entity.this.push(f1 * 2.0, 0, f2 * 2.0);
                }
            }
            if(Ender_Guardian_Entity.this.getAnimationTick() > 32 || Ender_Guardian_Entity.this.getAnimationTick() < 26){
                Ender_Guardian_Entity.this.setDeltaMovement(0, Ender_Guardian_Entity.this.getDeltaMovement().y, 0);
            }

            Bulletpattern();

        }
    }


    static class TeleportStrikeGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {

        public TeleportStrikeGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if(entity.getAnimationTick() < 40) {
                entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            }
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
                if(entity.getAnimationTick() == 40){
                    float y = entity.getIsHelmetless() ? 8.0f : 4.0f;
                    entity.teleportTo(target.getX(), target.getY() + y, target.getZ());
                }
            }


            if (entity.getAnimationTick() > 48 && entity.onGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage(entity, GUARDIAN_AIR_STRIKE2);
            }

        }
    }


    class HugmeGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {

        private final float sensing;
        private final int teleport;
        public  double prevX;
        public double prevZ;
        private int newX;
        private int newZ;

        public HugmeGoal(Ender_Guardian_Entity entity, Animation animation, float sensing, int teleport) {
            super(entity, animation);
            this.sensing = sensing;
            this.teleport = teleport;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }



        @Override
        public void start() {
            super.start();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                prevX = target.getX();
                prevZ = target.getZ();
            }
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (Ender_Guardian_Entity.this.getAnimationTick() < 40 && target != null) {
                Ender_Guardian_Entity.this.lookAt(target, 30.0F, 30.0F);
                Ender_Guardian_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
            }else {
                Ender_Guardian_Entity.this.setYRot(Ender_Guardian_Entity.this.yRotO);
                //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }
            if (entity.getAnimationTick() == (teleport - 6) && target != null) {
                double x = target.getX();
                double z = target.getZ();
                double vx = (x - prevX) / teleport;
                double vz = (z - prevZ) / teleport;
                newX = Mth.floor(x + vx * sensing);
                newZ = Mth.floor(z + vz * sensing);
                entity.setTeleportPos(BlockPos.containing(newX, target.getY(), newZ));
            }

            if (entity.getAnimationTick() == teleport && target != null) {
                if (entity.getTeleportPos().isPresent()) {
                    entity.teleport(entity.getTeleportPos().get().getX(), target.getY(), entity.getTeleportPos().get().getZ());
                }
            }
        }
    }

    static class VoidVortexGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {


        public VoidVortexGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);

            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 26 && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);

            }else {
                entity.setYRot(entity.yRotO);
                //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }

            if (entity.getAnimationTick() == 26 && target != null){
                double tx = target.getX();
                double ty = target.getY();
                double tz = target.getZ();
                double minY = Math.min(ty, entity.getY());
                double maxY = Math.max(ty, entity.getY()) + 1;
                float angle = (float) Mth.atan2(tz - entity.getZ(), tx - entity.getX());
                entity.spawnVortex(tx, tz, minY, maxY, angle);
            }

            if (entity.getAnimationTick() == 37 && target != null && entity.distanceToSqr(target) >= 25.0D){
                AnimationHandler.INSTANCE.sendAnimationMessage(entity, GUARDIAN_ROCKETPUNCH);
            }
        }
    }


    static class RocketPunchGoal extends SimpleAnimationGoal<Ender_Guardian_Entity> {


        public RocketPunchGoal(Ender_Guardian_Entity entity, Animation animation) {
            super(entity, animation);

            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 24 && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            }else {
                entity.setYRot(entity.yRotO);
                //  Ender_Guardian_Entity.this.yBodyRot = Ender_Guardian_Entity.this.yBodyRotO;
            }

            if (entity.getAnimationTick() == 24 && target != null){
                entity.setDeltaMovement((target.getX() - entity.getX()) * 0.3f, 0, (target.getZ() - entity.getZ()) * 0.3f);

            }


        }
    }

}





