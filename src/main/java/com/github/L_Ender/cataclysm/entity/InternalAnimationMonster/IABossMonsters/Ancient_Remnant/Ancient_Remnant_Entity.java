package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant;

import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.projectile.Ancient_Desert_Stele_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.EarthQuake_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.lionfishapi.server.animation.LegSolver;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
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
import java.util.EnumSet;
import java.util.List;


public class Ancient_Remnant_Entity extends IABoss_monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sandstormroarAnimationState = new AnimationState();
    public AnimationState phaseroarAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakenAnimationState = new AnimationState();
    public AnimationState threetailhitAnimationState = new AnimationState();
    public AnimationState rightstompAnimationState = new AnimationState();
    public AnimationState leftstompAnimationState = new AnimationState();
    public AnimationState rightDoubleStompAnimationState = new AnimationState();
    public AnimationState leftDoubleStompAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState rightbiteAnimationState = new AnimationState();
    public AnimationState chargeprepareAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargestunAnimationState = new AnimationState();
    public AnimationState groundtailAnimationState = new AnimationState();
    public AnimationState tailswingAnimationState = new AnimationState();
    public AnimationState monolithAnimationState = new AnimationState();
    private static final EntityDataAccessor<Integer> RAGE = SynchedEntityData.defineId(Ancient_Remnant_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> NECKLACE = SynchedEntityData.defineId(Ancient_Remnant_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> POWER = SynchedEntityData.defineId(Ancient_Remnant_Entity.class, EntityDataSerializers.BOOLEAN);

    public final LegSolver legSolver = new LegSolver(new LegSolver.Leg(0F, 0.75F, 4.0F, false), new LegSolver.Leg(0F, -0.75F, 4.0F, false));
    private Ancient_Remnant_Entity.AttackMode mode = Ancient_Remnant_Entity.AttackMode.CIRCLE;
    private int hunting_cooldown = 160;
    private int roar_cooldown = 0;
    private int monoltih_cooldown = 0;
    private int earthquake_cooldown = 0;
    private int stomp_cooldown = 0;
    private boolean hit = false;
    public static final int ROAR_COOLDOWN = 500;
    public static final int MONOLITH2_COOLDOWN = 200;
    public static final int EARTHQUAKE_COOLDOWN = 160;
    public static final int STOMP_COOLDOWN = 110;
    private final CMBossInfoServer bossEvent = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.WHITE,false,7);
    private final CMBossInfoServer bossEvent2 = new CMBossInfoServer(Component.translatable("entity.cataclysm.rage_meter"), BossEvent.BossBarColor.WHITE,false,8);
    public static final int NATURE_HEAL_COOLDOWN = 200;
    private int timeWithoutTarget;
    public int frame;

    
    public Ancient_Remnant_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.setMaxUpStep(1.5F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        setConfigattribute(this, CMConfig.AncientRemnantHealthMultiplier, CMConfig.AncientRemnantDamageMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 120, true, true, ModEntities.buildPredicateFromTag(ModTag.ANCIENT_REMNANT_TARGET)));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new RemnantAttackModeGoal(this));
        //right bite
        this.goalSelector.addGoal(3, new RemnantAttackGoal(this, 0, 4, 0, 70, 29, 6, 10));

        //sleep
        this.goalSelector.addGoal(1, new InternalStateGoal(this,1,1,0,0,0){
            @Override
            public void tick() {
                entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            }
        });

        //awaken
        this.goalSelector.addGoal(0, new RemnantAwakenGoal(this,1,2,0,80));
        //change roar
        this.goalSelector.addGoal(0, new RemnantPhaseChangeGoal(this,0,7,0,60));


        //stomp
        this.goalSelector.addGoal(3, new RemnantStompGoal(this,0, 8,9, 13, 14,0,50,66, 26, 20, 36));

        //sandstorm_roar
        this.goalSelector.addGoal(3, new RemnantStormAttackGoal(this,0, 6, 0, 60, 11, 32D, 18){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && target !=null  && this.entity.roar_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                this.entity.roar_cooldown = ROAR_COOLDOWN;
            }

        });

        //monolith
        this.goalSelector.addGoal(3, new RemnantMonolithAttackGoal(this,0, 17, 0, 70, 20));

        //charge_prepare
        this.goalSelector.addGoal(3, new RemnantChargeGoal(this,0, 10, 11, 70, 66, 32D, 60));

        //charge
        this.goalSelector.addGoal(2, new InternalStateGoal(this,11,11,12,60,0){
            @Override
            public void tick() {
                if(this.entity.onGround()){
                    Vec3 vector3d = entity.getDeltaMovement();
                    float f = entity.getYRot() * ((float)Math.PI / 180F);
                    Vec3 vector3d1 = new Vec3(-Mth.sin(f), entity.getDeltaMovement().y, Mth.cos(f)).scale(1.0D).add(vector3d.scale(0.5D));
                    entity.setDeltaMovement(vector3d1.x, entity.getDeltaMovement().y, vector3d1.z);
                }
            }
        });

        //charge stun
        this.goalSelector.addGoal(1, new InternalStateGoal(this,12,12,0,120,0));

        //ground_tail
        this.goalSelector.addGoal(1, new RemnantAttackGoal(this,0, 15, 0, 110, 85, 12, 10){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && target !=null && target.onGround() && this.entity.earthquake_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                this.entity.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
            }
        });

        //tail_swing
        this.goalSelector.addGoal(1, new RemnantAttackGoal(this,0, 16, 0, 58, 13, 7.5D, 10){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && target !=null && target.getY() < this.entity.getY() + 1.0D;
            }
        });

    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public static AttributeSupplier.Builder maledictus() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 70.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.33F)
                .add(Attributes.ATTACK_DAMAGE, 25)
                .add(Attributes.MAX_HEALTH, 450)
                .add(Attributes.ARMOR, 12)
                .add(Attributes.ARMOR_TOUGHNESS, 4)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }


    protected int decreaseAirSupply(int air) {
        return air;
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_, @Nullable CompoundTag p_29682_) {
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }


    @Override
    public boolean hurt(DamageSource source, float damage) {
        double range = calculateRange(source);
        if (this.getAttackState() == 7 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (range > CMConfig.AncientRemnantLongRangelimit * CMConfig.AncientRemnantLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getDirectEntity();
        if (this.getAttackState() != 12){
            if (entity instanceof AbstractArrow) {
                return false;
            }
        }
        if (this.isSleep()) {
            if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                return false;
            }
        }

        return super.hurt(source, damage);
    }


    @Override
    public float DamageCap() {
        return (float) CMConfig.AncientRemnantDamageCap;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RAGE, 0);
        this.entityData.define(NECKLACE, true);
        this.entityData.define(POWER, false);
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public void setNecklace(boolean necklace) {
        this.entityData.set(NECKLACE, necklace);
        this.bossEvent.setVisible(necklace);
        this.bossEvent2.setVisible(necklace);
        if(!necklace){
            this.setAttackState(1);
        }
    }

    public boolean getNecklace() {
        return this.entityData.get(NECKLACE);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("has_necklace", this.getNecklace());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setNecklace(compound.getBoolean("has_necklace"));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void setRage(int isAnger) {
        this.entityData.set(RAGE, isAnger);
    }

    public int getRage() {
        return this.entityData.get(RAGE);
    }

    public void setIsPower(boolean isPower) {
        this.entityData.set(POWER, isPower);
    }

    public boolean getIsPower() {
        return this.entityData.get(POWER);
    }

    public boolean canStandOnFluid(FluidState p_204067_) {
        return p_204067_.is(FluidTags.WATER);
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    private void floatRemnant() {
        if (this.isInWater()) {
            CollisionContext collisioncontext = CollisionContext.of(this);
            if (collisioncontext.isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.WATER)) {
                this.setOnGround(true);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5D).add(0.0D, 0.05D, 0.0D));
            }
        }

    }

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awaken") {
            return this.awakenAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "three_tail_hit") {
            return this.threetailhitAnimationState;
        } else if (input == "right_bite") {
            return this.rightbiteAnimationState;
        } else if (input == "sandstorm_roar") {
            return this.sandstormroarAnimationState;
        } else if (input == "charge") {
            return this.chargeAnimationState;
        } else if (input == "charge_prepare") {
            return this.chargeprepareAnimationState;
        } else if (input == "phase_roar") {
            return this.phaseroarAnimationState;
        } else if (input == "right_stomp") {
            return this.rightstompAnimationState;
        } else if (input == "left_stomp") {
            return this.leftstompAnimationState;
        } else if (input == "charge_stun") {
            return this.chargestunAnimationState;
        } else if (input == "right_double_stomp") {
            return this.rightDoubleStompAnimationState;
        } else if (input == "left_double_stomp") {
            return this.leftDoubleStompAnimationState;
        } else if (input == "ground_tail") {
            return this.groundtailAnimationState;
        } else if (input == "tail_swing") {
            return this.tailswingAnimationState;
        } else if (input == "monolith") {
            return this.monolithAnimationState;
        } else {
            return new AnimationState();
        }
    }


    public void travel(Vec3 travelVector) {
        super.travel(travelVector);
    }


    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.sleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.awakenAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.rightbiteAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.threetailhitAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.sandstormroarAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.phaseroarAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.rightstompAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.leftstompAnimationState.startIfStopped(this.tickCount);
                    }

                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.chargeprepareAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.chargeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.chargestunAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.rightDoubleStompAnimationState.startIfStopped(this.tickCount);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.leftDoubleStompAnimationState.startIfStopped(this.tickCount);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.groundtailAnimationState.startIfStopped(this.tickCount);
                    }
                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.tailswingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.monolithAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.deathAnimationState.stop();
        this.sleepAnimationState.stop();
        this.awakenAnimationState.stop();
        this.rightbiteAnimationState.stop();
        this.threetailhitAnimationState.stop();
        this.sandstormroarAnimationState.stop();
        this.chargeAnimationState.stop();
        this.chargestunAnimationState.stop();
        this.phaseroarAnimationState.stop();
        this.rightstompAnimationState.stop();
        this.leftstompAnimationState.stop();
        this.chargeprepareAnimationState.stop();
        this.rightDoubleStompAnimationState.stop();
        this.leftDoubleStompAnimationState.stop();
        this.groundtailAnimationState.stop();
        this.monolithAnimationState.stop();
        this.tailswingAnimationState.stop();
    }

    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(3);
    }

    public int deathtimer() {
        return 70;
    }
    
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(getAttackState() != 3, this.tickCount);
        }
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        this.bossEvent2.setProgress((float) this.getRage() / 5);
        this.legSolver.update(this, this.yBodyRot, this.getScale());


        if (hunting_cooldown > 0) hunting_cooldown--;

        if (roar_cooldown > 0) roar_cooldown--;
        if (monoltih_cooldown > 0) monoltih_cooldown--;
        if (earthquake_cooldown > 0) earthquake_cooldown--;
        if (stomp_cooldown > 0) stomp_cooldown--;
        LivingEntity target = this.getTarget();
        if (!this.level().isClientSide) {
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAttackState() == 0 && timeWithoutTarget <= 0) {
                if (!isNoAi() && CMConfig.AncientRemnantNatureHealing > 0) {
                    if (this.tickCount % 20 == 0) {
                        this.heal((float) CMConfig.AncientRemnantNatureHealing);
                    }
                }
            }
        }
        if (!this.level().isClientSide) {
            if(CMConfig.AncientRemnantBlockBreaking) {
                ChargeBlockBreaking(0.5D);
            }else{
                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    ChargeBlockBreaking(0.5D);
                }
            }
        }
        if(this.getIsPower()) {
            if (this.tickCount % 20 == 0) {
                this.heal(1.0F);
            }
        }
        floatRemnant();
        frame++;
        float moveX = (float) (getX() - xo);
        float moveZ = (float) (getZ() - zo);
        float speed = Mth.sqrt(moveX * moveX + moveZ * moveZ);
        if (!this.isSilent() && frame % 8 == 1 && speed > 0.05 && this.getAttackState() == 11 && this.onGround()) {
            this.playSound(ModSounds.REMNANT_CHARGE_STEP.get(), 1F, 1.0f);
            ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
        }

    }


    public boolean isPower() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    private void Charge() {
        if (!this.level().isClientSide) {
            if(CMConfig.AncientRemnantBlockBreaking) {
                ChargeBlockBreaking(1.5D);
            }else{
                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    ChargeBlockBreaking(1.5D);
                }
            }
        }
        if (this.tickCount % 4 == 0) {
            for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                if (!isAlliedTo(Lentity) && !(Lentity instanceof Ancient_Remnant_Entity) && Lentity != this) {
                    boolean flag = Lentity.hurt(this.damageSources().mobAttack(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 2.0f + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 2.0f, Lentity.getMaxHealth() * CMConfig.RemnantChargeHpDamage)));
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

    private void ChargeBlockBreaking(double inflate){
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(inflate, 0.2D, inflate);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.REMNANT_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                if (random.nextInt(6) == 0 && !blockstate.hasBlockEntity()) {
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

    public void aiStep() {
        super.aiStep();

        if(this.getAttackState() == 4) {
            if(this.attackTicks == 8){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_BITE.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            if(this.attackTicks == 31){
                AreaAttack(7,7,70,1.35f,(float) CMConfig.RemnantHpDamage,160,0);
            }
        }

        if(this.getAttackState() == 6) {
            if(this.attackTicks == 14){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 60);
            }
            if(this.attackTicks == 55) {
                for (int i = 0; i < 3; i++) {
                    float angle = i * Mth.PI / 1.5F;
                    double sx = this.getX() + (Mth.cos(angle) * 8);
                    double sy = this.getY();
                    double sz = this.getZ() + (Mth.sin(angle) * 8);
                    Sandstorm_Entity projectile = new Sandstorm_Entity(this.level(), sx,sy,sz,300,angle,this.getUUID());
                    this.level().addFreshEntity(projectile);
                }
            }
        }

        if(this.getAttackState() == 7) {
            if (this.attackTicks == 14) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.15f, 0, 80);
                this.level().playSound((Player) null, this, ModSounds.REMNANT_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
                setIsPower(true);
            }
        }

        if(this.getAttackState() == 8){
            if(this.attackTicks == 28) {
                StompParticle(0.9f,1.4f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
            }

            for (int l = 28; l <= 45; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.4f);
                }
            }
        }
        if(this.getAttackState() == 9){
            if(this.attackTicks == 28) {
                StompParticle(0.9f,-1.4f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
            }
            for (int l = 28; l <= 45; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.4f);
                }
            }
        }

        if(this.getAttackState() == 10){
            if(this.attackTicks == 1){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_CHARGE_PREPARE.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
            }

            if(this.attackTicks == 14){
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                StompParticle(-0.1f,-0.75f);
            }

            if(this.attackTicks == 43){
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                StompParticle(-0.1f,0.75f);
            }

            if(this.attackTicks == 66){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_CHARGE_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
            }
        }

        if(this.getAttackState() == 11) {
            Charge();
            if (this.horizontalCollision) {
                this.setAttackState(12);
            }
        }
        if(this.getAttackState() == 12) {
            if(this.attackTicks == 1){
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.25f, 0, 60);
            }
            if(this.attackTicks == 1 || this.attackTicks == 3  || this.attackTicks == 5 ){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_CHARGE_STEP.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
            }
        }

        if(this.getAttackState() == 13) {
            if(this.attackTicks == 28) {
                StompParticle(0.9f,1.4f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
            }

            for (int l = 28; l <= 45; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.4f);
                }
            }

            if(this.attackTicks == 50) {
                StompParticle(0.9f,1.4f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
            }

            for (int l = 50; l <= 67; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 48;
                    int d2 = l - 47;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.4f);
                }
            }
        }

        if(this.getAttackState() == 14) {
            if(this.attackTicks == 28) {
                StompParticle(0.9f,-1.4f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
            }
            for (int l = 28; l <= 45; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.4f);
                }
            }
            if(this.attackTicks == 50) {
                StompParticle(0.9f,-1.4f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
            }
            for (int l = 50; l <= 67; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 48;
                    int d2 = l - 47;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.4f,80, 0.9f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.4f);
                }
            }
        }
        if(this.getAttackState() == 15) {
            if(this.attackTicks == 1) {
                this.level().playSound((Player) null, this, ModSounds.REMNANT_TAIL_SLAM_1.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            if(this.attackTicks == 26) {
                AreaAttack(10,10,70,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 22 + random.nextInt(8), 0.8f);
                StompParticle(5.5f,0.8f);
            }
            if(this.attackTicks == 55) {
                AreaAttack(10,10,70,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                this.level().playSound((Player) null, this, ModSounds.REMNANT_TAIL_SLAM_2.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.25f, 22 + random.nextInt(8), 1.5f);
                StompParticle(5.25f,1.5f);
            }
            if(this.attackTicks == 85) {
                AreaAttack(10,10,70,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                this.level().playSound((Player) null, this, ModSounds.REMNANT_TAIL_SLAM_3.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 22 + random.nextInt(8), 0.8f);
                StompParticle(5.5f,0.8f);
            }

        }

        if(this.getAttackState() == 16) {
            if(this.attackTicks == 12) {
                this.level().playSound((Player) null, this, ModSounds.REMNANT_TAIL_SWING.get(), SoundSource.HOSTILE, 2.0f, 1.0f);
            }
            if(this.attackTicks == 25){
                TailAreaAttack(8,8,1.05F,120,1.0f,(float) CMConfig.RemnantHpDamage,200,100);
            }
        }
        if(this.getAttackState() == 17) {
            if(this.attackTicks == 16) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.15f, 0, 80);
               this.level().playSound((Player) null, this, ModSounds.REMNANT_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.1f);
            }
        }
    }


    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (item == ModItems.NECKLACE_OF_THE_DESERT.get() && !this.getNecklace()) {
            if (!player.isCreative()) {
                itemstack.shrink(1);
            }
            this.setNecklace(true);
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ancient_Remnant_Entity) && entityHit != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }


                    if (flag) {
                        hit = true;
                        if (stunticks > 0) {
                            entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), stunticks));
                        }
                    }

                }
            }
        }
    }


    private void TailAreaAttack(float range, float height, float height2 , float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks) {
        List<LivingEntity> entitiesHit = this.getTailEntityLivingBaseNearby(range, height,height2, range, range);
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ancient_Remnant_Entity) && entityHit != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    if (flag) {
                        hit = true;
                        if (stunticks > 0) {
                            entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), stunticks));
                        }
                        double d0 = entityHit.getX() - this.getX();
                        double d1 = entityHit.getZ() - this.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        entityHit.push(d0 / d2 * 4.0D, 0.2D, d1 / d2 * 4.0D);
                    }

                }
            }
        }
    }

    private void StompDamage(float spreadarc, int distance, int height, float mxy, float vec,float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180) + f * math;
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180) + f1 * math;
            float factor = 1 - distance / (float) 12;
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY + height, hitZ);
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
            spawnBlocks(hitX,hitY + height ,hitZ, (int) (this.getY() - height),block, px, pz, mxy, vx, vz, factor, shieldbreakticks, damage, hpdamage);

        }
    }


    private void spawnBlocks(int hitX, int hitY, int hitZ, int lowestYCheck,BlockState blockState,double px,double pz,float mxy,double vx,double vz,float factor, int shieldbreakticks,float damage, float hpdamage) {
        BlockPos blockpos = new BlockPos(hitX, hitY, hitZ);
        BlockState block = level().getBlockState(blockpos);
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

                break;
            }

            blockpos = blockpos.below();
        } while(blockpos.getY() >= Mth.floor(lowestYCheck) - 1);


        Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), hitX + 0.5D, (double)blockpos.getY() + d0 + 0.5D, hitZ + 0.5D, blockState, 10);
        fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.04D, 0);
        level().addFreshEntity(fallingBlockEntity);



        AABB selection = new AABB(px - 0.5, (double)blockpos.getY() + d0 -1, pz - 0.5, px + 0.5, (double)blockpos.getY() + d0 + mxy, pz + 0.5);
        List<LivingEntity> hitbox = level().getEntitiesOfClass(LivingEntity.class, selection);
        for (LivingEntity entity : hitbox) {
            if (!isAlliedTo(entity) && !(entity instanceof Ancient_Remnant_Entity) && entity != this) {
                DamageSource damagesource = this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + entity.getMaxHealth() * hpdamage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
                if (flag) {
                    hit = true;
                    double magnitude = -4;
                    double x = vx * (1 - factor) * magnitude;
                    double y = 0;
                    if (entity.onGround()) {
                        y += 0.15;
                    }
                    double z = vz * (1 - factor) * magnitude;
                    entity.setDeltaMovement(entity.getDeltaMovement().add(x, y, z));
                }
            }
        }
    }


    private void Stompsound(float distance,float math) {
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        this.level().playLocalSound(this.getX() + distance * vecX + f * math, this.getY(), this.getZ() + distance * vecZ + f1 * math, ModSounds.REMNANT_SHOCKWAVE.get(), this.getSoundSource(), 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F, false);
    }

    public  List<LivingEntity> getTailEntityLivingBaseNearby(double distanceX, double distanceMinY, double distanceMaxY,double distanceZ, double radius) {
        return getTailEntitiesNearby(LivingEntity.class, distanceX, distanceMinY,distanceMaxY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getTailEntitiesNearby(Class<T> entityClass, double dX, double dY, double pY,double dZ, double r) {
        return level().getEntitiesOfClass(entityClass, new AABB(this.getX() - dX, this.getY() - dY, this.getZ() - dZ, this.getX() + dX, this.getY() + pY, this.getZ() + dZ), e -> e != this && distanceTo(e) <= r + e.getBbWidth() / 2f && e.getY() <= getY() + dY);
    }

    private void StompParticle(float vec, float math) {
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
                double extraX = 0.5 * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.1F;
                double extraZ = 0.5 * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX+ extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());
                if (block.getRenderShape() != RenderShape.INVISIBLE) {
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
            this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 20, 1f, 1f, 1f, 1f, 25f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }


    private void EarthQuakeSummon(float vec, int quake,float math) {
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float angle = 360.0F / quake;
        for (int i = 0; i < quake; i++) {
            EarthQuake_Entity peq = new EarthQuake_Entity(this.level(), this);
            peq.setDamage((float) CMConfig.AncientRemnantEarthQuakeDamage);
            peq.shootFromRotation(this, 0, angle * i, 0.0F, 0.45F, 0.0F);
            peq.setPos(this.getX() + vec * vecX + f * math, this.getY() + 0.3D, getZ() + vec * vecZ + f1 * math);
            this.level().addFreshEntity(peq);

        }
    }


    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_ANCIENT_REMNANT)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }



    protected SoundEvent getAmbientSound() {
        return !this.isSleep() ? ModSounds.REMNANT_IDLE.get() : super.getAmbientSound();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.REMNANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.REMNANT_DEATH.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.REMNANT_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && !isSleep();
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();

    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
        this.bossEvent2.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
        this.bossEvent2.removePlayer(player);
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }


    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }


    private enum AttackMode {
        CIRCLE,
        MELEE
    }

    static class RemnantStompGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate1;
        private final int attackstate2;
        private final int attackstate3;
        private final int attackstate4;
        private final int attackendstate;
        private final int attackMaxtick1;
        private final int attackMaxtick2;
        private final int attackseetick;
        private final double attackrange;
        private final float random;


        public RemnantStompGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate1, int attackstate2, int attackstate3, int attackstate4, int attackendstate, int attackMaxtick1, int attackMaxtick2, int attackseetick, double attackrange, float random) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate1 = attackstate1;
            this.attackstate2 = attackstate2;
            this.attackstate3 = attackstate3;
            this.attackstate4 = attackstate4;
            this.attackendstate = attackendstate;
            this.attackMaxtick1 = attackMaxtick1;
            this.attackMaxtick2 = attackMaxtick2;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;

        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.stomp_cooldown <= 0 && target.isAlive() && this.entity.distanceTo(target) < attackrange
                    && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random
                    && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE
                    && target.getY() <= this.entity.getY() + 4.5F && this.entity.distanceTo(target) > 5.5D ;
        }


        @Override
        public void start() {
            if(this.entity.getIsPower()) {
                if (this.entity.random.nextBoolean()) {
                    this.entity.setAttackState(attackstate3);
                } else {
                    this.entity.setAttackState(attackstate4);
                }
            }else {
                if (this.entity.random.nextBoolean()) {
                    this.entity.setAttackState(attackstate1);
                }else{
                    this.entity.setAttackState(attackstate2);
                }
            }
            this.entity.hit = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAt(target, 30.0F, 30.0F);
                entity.getLookControl().setLookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.stomp_cooldown = STOMP_COOLDOWN;
            if(this.entity.hit) {
                if (this.entity.getRage() > 0) {
                    this.entity.setRage(this.entity.getRage() - 1);
                    this.entity.hit = false;
                }
            }else{
                if (this.entity.getRage() < 5) {
                    this.entity.setRage(this.entity.getRage() + 1);
                    this.entity.hit = false;
                }
            }
        }

        @Override
        public boolean canContinueToUse() {
            if (this.entity.getAttackState() == attackstate1 || this.entity.getAttackState() == attackstate2){
                return this.entity.attackTicks <= attackMaxtick1;
            }else if (this.entity.getAttackState() == attackstate3 || this.entity.getAttackState() == attackstate4){
                return this.entity.attackTicks <= attackMaxtick2;
            }
            return false;
        }
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }
    }

    static class RemnantAwakenGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;

        public RemnantAwakenGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;


        }

        @Override
        public boolean canUse() {
            return this.entity.getNecklace() && this.entity.getAttackState() == getattackstate;
        }

        @Override
        public void start() {
            if(getattackstate != attackstate) {
                this.entity.setAttackState(attackstate);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean canContinueToUse() {
            return attackMaxtick > 0 ? this.entity.attackTicks <= attackMaxtick : canUse();
        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }

    static class RemnantPhaseChangeGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;

        public RemnantPhaseChangeGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
        }

        @Override
        public boolean canUse() {
            return !this.entity.getIsPower() && this.entity.getAttackState() == getattackstate && this.entity.isPower();
        }

        @Override
        public void start() {
            if(getattackstate != attackstate) {
                this.entity.setAttackState(attackstate);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean canContinueToUse() {
            return attackMaxtick > 0 ? this.entity.attackTicks <= attackMaxtick : canUse();
        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }

    static class RemnantStormAttackGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final double attackrange;
        private final float random;


        public RemnantStormAttackGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, double attackrange, float random) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;

        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            this.entity.hit = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAt(target, 30.0F, 30.0F);
                entity.getLookControl().setLookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }
    }

    static class RemnantMonolithAttackGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;


        public RemnantMonolithAttackGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;

        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();

            return target !=null && target.isAlive() && (this.entity.monoltih_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0F < 12f && target.getY() >= this.entity.getY() + 8
                    ||this.entity.monoltih_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0F < 12f && this.entity.distanceTo(target) > 12.0D ||this.entity.monoltih_cooldown <= 0 && this.entity.getRandom().nextFloat() * 100.0F < 12f && this.entity.distanceTo(target) < 10.0D) && this.entity.getAttackState() == getattackstate && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE;

        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            this.entity.hit = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAt(target, 30.0F, 30.0F);
                entity.getLookControl().setLookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.monoltih_cooldown = MONOLITH2_COOLDOWN;
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if(this.entity.attackTicks == attackseetick && target !=null) {
                double d1 = target.getY();
                float f = (float) Mth.atan2(target.getZ() - this.entity.getZ(), target.getX() - this.entity.getX());
                int l;


                StrikeWindmillMonolith(8, 16, 2.0, 0.75, 0.6, d1,1);


                for (l = 0; l < 16; ++l) {
                    double d2 = 1.25 * (double) (l + 1);
                    int j = (int) ( 5 + 1.5f * l);
                    this.spawnSpikeLine(this.entity.getX() + (double) Mth.cos(f) * d2, this.entity.getZ() + (double) Mth.sin(f) * d2, d1, f, j);
                }
            }

        }

        private void StrikeWindmillMonolith(int numberOfBranches, int particlesPerBranch, double initialRadius, double radiusIncrement, double curveFactor,double spawnY, int delay) {
            float angleIncrement = (float) (2 * Math.PI / numberOfBranches);
            for (int branch = 0; branch < numberOfBranches; ++branch) {
                float baseAngle = angleIncrement * branch;

                for (int i = 0; i < particlesPerBranch; ++i) {
                    double currentRadius = initialRadius + i * radiusIncrement;
                    float currentAngle = (float) (baseAngle + i * angleIncrement / initialRadius + (float) (i * curveFactor));

                    double xOffset = currentRadius * Math.cos(currentAngle);
                    double zOffset = currentRadius * Math.sin(currentAngle);

                    double spawnX = this.entity.getX() + xOffset;
                    double spawnZ = this.entity.getZ() + zOffset;
                    int d3 = delay * (i + 1);
                    this.spawnSpikeLine(spawnX, spawnZ, spawnY,  currentAngle, d3);
                }
            }
        }

        private void spawnSpikeLine(double posX, double posZ, double posY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.containing(posX, posY, posZ);
            double d0 = 0.0D;

            do {
                BlockPos blockpos1 = blockpos.above();
                BlockState blockstate = entity.level().getBlockState(blockpos1);
                if (blockstate.isFaceSturdy(entity.level(), blockpos1, Direction.DOWN)) {
                    if (!entity.level().isEmptyBlock(blockpos)) {
                        BlockState blockstate1 = entity.level().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(entity.level(), blockpos);
                        if (!voxelshape.isEmpty()) {
                            d0 = voxelshape.max(Direction.Axis.Y);
                        }
                    }

                    break;
                }

                blockpos = blockpos.above();
            } while (blockpos.getY() < Math.min(entity.level().getMaxBuildHeight(), entity.getBlockY() + 20));
            this.entity.level().addFreshEntity(new Ancient_Desert_Stele_Entity(this.entity.level(), posX, (double)blockpos.getY() + d0 -3, posZ, rotation, delay,(float) CMConfig.AncientDesertSteledamage, this.entity));

        }
    }

    static class RemnantAttackGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final double attackrange;
        private final float random;


        public RemnantAttackGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, double attackrange, float random) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;

        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            this.entity.hit = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAt(target, 30.0F, 30.0F);
                entity.getLookControl().setLookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            if(this.entity.hit) {
                if (this.entity.getRage() > 0) {
                    this.entity.setRage(this.entity.getRage() - 1);
                    this.entity.hit = false;
                }
            }else{
                if (this.entity.getRage() < 5) {
                    this.entity.setRage(this.entity.getRage() + 1);
                    this.entity.hit = false;
                }
            }
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }
    }

    static class RemnantChargeGoal extends Goal {
        protected final Ancient_Remnant_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final double attackrange;
        private final float random;


        public RemnantChargeGoal(Ancient_Remnant_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, double attackrange, float random) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;

        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.getRage() >= 5 && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.mode == Ancient_Remnant_Entity.AttackMode.MELEE;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            entity.setRage(0);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAt(target, 30.0F, 30.0F);
                entity.getLookControl().setLookAt(target, 30, 30);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            if(this.entity.hit) {
                if (this.entity.getRage() > 0) {
                    this.entity.setRage(this.entity.getRage() - 1);
                    this.entity.hit = false;
                }
            }else{
                if (this.entity.getRage() < 5) {
                    this.entity.setRage(this.entity.getRage() + 1);
                }
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }
    }

    class RemnantAttackModeGoal extends Goal {
        private final Ancient_Remnant_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private final float huntingTime = 0;
        private float circleDistance = 9;
        private boolean clockwise = false;

        public RemnantAttackModeGoal(Ancient_Remnant_Entity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive() && this.mob.getAttackState() == 0;
        }

        public boolean canContinueToUse() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public void start() {
            this.mob.mode = Ancient_Remnant_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            circleDistance = 18 + this.mob.random.nextInt(10);
            clockwise = this.mob.random.nextBoolean();
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = Ancient_Remnant_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            circleDistance = 18 + this.mob.random.nextInt(10);
            clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
                this.mob.setTarget(null);
            }

            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAggressive(false);
                this.mob.getNavigation().stop();
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == Ancient_Remnant_Entity.AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);
                    if (huntingTime >= this.mob.hunting_cooldown) {
                        this.mob.mode = Ancient_Remnant_Entity.AttackMode.MELEE;
                    }else{
                        if(this.mob.distanceTo(target) < 4D){
                            this.mob.mode = Ancient_Remnant_Entity.AttackMode.MELEE;
                        }
                    }
                } else if (this.mob.mode == Ancient_Remnant_Entity.AttackMode.MELEE) {
                    this.mob.getNavigation().moveTo(target, 1.0D);
                    this.mob.getLookControl().setLookAt(target, 30, 30);
                }
            }
        }
    }
}





