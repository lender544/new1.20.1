package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus;

import com.github.L_Ender.cataclysm.client.particle.MaledictusRingParticle;
import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Golem_Entity;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.The_Leviathan_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.FlightMoveController;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.path.DirectPathNavigator;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;


public class Maledictus_Entity extends IABoss_monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState swingAnimationState = new AnimationState();
    public AnimationState shotAnimationState = new AnimationState();
    public AnimationState flyingshotAnimationState = new AnimationState();
    public AnimationState fallloopAnimationState = new AnimationState();
    public AnimationState falllendAnimationState = new AnimationState();
    public AnimationState masseffectAnimationState = new AnimationState();
    public AnimationState flyingsmash1AnimationState = new AnimationState();
    public AnimationState flyingsmash2AnimationState = new AnimationState();
    public AnimationState BackstepAnimationState = new AnimationState();
    public AnimationState BackstepchargeAnimationState = new AnimationState();
    public AnimationState chargeAnmationState = new AnimationState();
    public AnimationState dash2AnmationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();

    private boolean isflyingNavigator;

    private int reducedDamageTicks;
    private int masseffect_cooldown = 0;
    private int flyattack_cooldown = 0;
    public static final int MASSEFFECT_COOLDOWN = 150;
    public static final int FLYATTACK_COOLDOWN = 100;

    private static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> CHARGE = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.INT);

    public static final EntityDataAccessor<Integer> WEAPON = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.INT);

    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 80;

    public Maledictus_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        switchNavigator(true);
        this.setMaxUpStep(1.25F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        setConfigattribute(this, CMConfig.MaledictusHealthMultiplier, CMConfig.MaledictusDamageMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<>(this, Player.class, true));
        this.goalSelector.addGoal(3, new InternalMoveGoal(this,false,1.0D));


        //swing
        this.goalSelector.addGoal(1, new Maledictus_Swing(this, 0, 1, 0, 44, 25, 0.5F, 35f, 20F));

        //bow
        this.goalSelector.addGoal(1, new Maledictus_Bow(this, 0, 2, 0, 45, 29, 8F, 35f, 29, 34F));

        //flying bow
        this.goalSelector.addGoal(1, new Maledictus_Flying_Bow(this, 0, 3, 4, 68, 50, 1F, 40f, 50,34F));

        //fall_loop
        this.goalSelector.addGoal(1, new MaledictusfallingState(this, 4, 4,5,100, 100,1,0));


        //fall_end
        this.goalSelector.addGoal(0, new MaledictusfallingState(this, 5, 5, 0, 27,0,0,0));

        //mass_effect
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,7,0,66,28,4.5F){
            @Override
            public boolean canUse() {
                return super.canUse() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 28f && Maledictus_Entity.this.masseffect_cooldown <= 0;
            }
            @Override
            public void tick() {
                super.tick();
                entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            }
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.masseffect_cooldown = MASSEFFECT_COOLDOWN;
            }
        });

        //flying strike
        this.goalSelector.addGoal(1, new Maledictus_Flying_Smash(this, 0, 8, 9, 100, 100, 30f, 56,34F));

        this.goalSelector.addGoal(0, new MaledictusfallingState(this, 9, 9, 0, 27,0,0,0));

        //backstep
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,10,11,15,15,4.5F){
            @Override
            public boolean canUse() {
                return super.canUse() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 34f && Maledictus_Entity.this.charge_cooldown <= 0;
            }
            @Override
            public void start() {
                super.start();
                Maledictus_Entity.this.masseffect_cooldown = MASSEFFECT_COOLDOWN;
                float speed = -1.7f;
                float dodgeYaw = (float) Math.toRadians(Maledictus_Entity.this.getYRot() + 90);
                Vec3 m = Maledictus_Entity.this.getDeltaMovement().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                Maledictus_Entity.this.setDeltaMovement(m.x, 0.4, m.z);
            }
        });



        //backstep and charge
        this.goalSelector.addGoal(0, new MaledictusChargeState(this, 11, 11, 0, 55, 13, 24, 16,27,2,0,1));

        //dash 2
        this.goalSelector.addGoal(0, new MaledictusChargeState(this, 13, 13, 0, 70, 19, 24, 24,37,2,0,2));

        //only charge
        this.goalSelector.addGoal(1, new MaledictusChargeGoal(this, 0, 12, 0, 55, 13, 24, 16,4.5F,16f,2,0,34,1));


    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl(this);
            this.navigation = new CMPathNavigateGround(this, level());
            this.isflyingNavigator = false;
        } else {
            this.moveControl = new FlightMoveController(this, 1.0F, false);
            this.navigation = new DirectPathNavigator(this, level());
            this.isflyingNavigator = true;
        }
    }

    public static AttributeSupplier.Builder maledictus() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.33F)
                .add(Attributes.ATTACK_DAMAGE, 20)
                .add(Attributes.MAX_HEALTH, 400)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }



    public MobType getMobType() {
        return MobType.UNDEAD;

    }

    @Override
    public boolean hurt(DamageSource source, float damage) {

        if (reducedDamageTicks > 0) {
            float reductionFactor = 1.0f - (reducedDamageTicks / 30.0f);
            damage *= reductionFactor;
        }
        boolean flag = super.hurt(source, damage);
        if (flag) {
            reducedDamageTicks = 30;
        }
        return flag;
    }

    public float DamageCap() {
        return (float) CMConfig.MaledictusDamageCap;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
        return false;
    }

    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        super.checkFallDamage(y, onGroundIn, state, pos);
    }

    protected void playBlockFallSound() {
        super.playBlockFallSound();
    }

    public AnimationState getAnimationState(String input) {
        if (input == "swing") {
            return this.swingAnimationState;
        } else if (input == "shoot") {
            return this.shotAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "flying_shoot") {
            return this.flyingshotAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "fall_loop") {
            return this.fallloopAnimationState;
        } else if (input == "fall_end") {
            return this.falllendAnimationState;
        } else if (input == "mass_effect") {
            return this.masseffectAnimationState;
        } else if (input == "flying_smash_1") {
            return this.flyingsmash1AnimationState;
        } else if (input == "flying_smash_2") {
            return this.flyingsmash2AnimationState;
        } else if (input == "back_step") {
            return this.BackstepAnimationState;
        } else if (input == "back_step_charge") {
            return this.BackstepchargeAnimationState;
        } else if (input == "charge") {
            return this.chargeAnmationState;
        } else if (input == "dash2") {
            return this.dash2AnmationState;
        }else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WEAPON, 0);
        this.entityData.define(FLYING, false);
        this.entityData.define(CHARGE, 0);
    }

    public int getWeapon() {
        return this.entityData.get(WEAPON);
    }

    public void setWeapon(int weapon) {
        this.entityData.set(WEAPON, weapon);
    }


    public boolean isFlying() {
        return this.entityData.get(FLYING);
    }

    public void setFlying(boolean flying) {
        this.entityData.set(FLYING, flying);
    }

    public int isCharge() {
        return this.entityData.get(CHARGE);
    }

    public void setCharge(int charge) {
        this.entityData.set(CHARGE, charge);
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
                        this.swingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.shotAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.flyingshotAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.fallloopAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.falllendAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.masseffectAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.flyingsmash1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.flyingsmash2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.BackstepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.BackstepchargeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.chargeAnmationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.dash2AnmationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.swingAnimationState.stop();
        this.shotAnimationState.stop();
        this.deathAnimationState.stop();
        this.flyingshotAnimationState.stop();
        this.fallloopAnimationState.stop();
        this.falllendAnimationState.stop();
        this.masseffectAnimationState.stop();
        this.flyingsmash1AnimationState.stop();
        this.flyingsmash2AnimationState.stop();
        this.BackstepAnimationState.stop();
        this.BackstepchargeAnimationState.stop();
        this.chargeAnmationState.stop();
        this.dash2AnmationState.stop();
    }

    private void SwingParticles() {
        if (level().isClientSide) {
            if(this.getAttackState() == 1) {
                if (this.attackTicks == 1) {
                    Warningparticle(0.95f,0.5215f,0.1333F);
                }
            }
            if(this.getAttackState() == 2) {
                if (this.attackTicks == 1) {
                    Warningparticle(0.09f,0.42f,0.35F);
                }
            }
            if(this.getAttackState() == 3) {
                if (this.attackTicks == 15) {
                    Warningparticle(0.09f,0.42f,0.35F);
                }
            }

            if(this.getAttackState() == 7) {
                if (this.attackTicks == 1) {
                    Warningparticle(0.423f,0.062f,0.019F);
                }
            }
            if(this.getAttackState() == 8) {
                if (this.attackTicks == 1) {
                    Warningparticle(0.423f,0.062f,0.019F);
                }
            }
            if(this.getAttackState() == 11) {
                if (this.attackTicks == 1) {
                    Warningparticle(0.423f,0.062f,0.019F);
                }
            }
            if(this.getAttackState() == 12) {
                if (this.attackTicks == 1) {
                    Warningparticle(0.423f,0.062f,0.019F);
                }
            }
            if(this.getAttackState() == 13) {
                if (this.attackTicks == 1) {
                    Warningparticle(0.423f,0.062f,0.019F);
                }
            }
        }
    }

    private void Warningparticle(float r,float g,float b) {


        this.level().addParticle(new MaledictusRingParticle.MaledictusRingData(0f, 0f, 50, r, g,  b, 1.0f, 4f, true,false, this.getId(),MaledictusRingParticle.EnumRingBehavior.CONSTANT), this.getX(), this.getY() , this.getZ() , 0, 0, 0);
        this.level().addParticle(new MaledictusRingParticle.MaledictusRingData(0f, 0f, 50, r, g,  b, 1.0f, 4f, true,true, this.getId(),MaledictusRingParticle.EnumRingBehavior.CONSTANT), this.getX(), this.getY() , this.getZ() , 0, 0, 0);


    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(6);
        this.setFlying(false);
    }

    public int deathtimer(){
        return 60;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }


    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        }else{
            if (reducedDamageTicks > 0) reducedDamageTicks--;
        }
        if (masseffect_cooldown > 0) masseffect_cooldown--;
        if (flyattack_cooldown > 0) flyattack_cooldown--;
        if (charge_cooldown > 0) charge_cooldown--;
        if (!this.level().isClientSide) {
            if (this.isFlying() && !this.isflyingNavigator) {
                switchNavigator(false);
            }
            if (!this.isFlying() && this.isflyingNavigator) {
                switchNavigator(true);
            }
            if (this.isFlying()) {
                this.setNoGravity(!this.onGround());
            }else{
                this.setNoGravity(false);
            }
        }
    }

    public boolean isHalfHealth() {
        float healthAmount = this.getHealth() / this.getMaxHealth();
        return healthAmount <= 0.5F;
    }

    public boolean isQuarterHealth() {
        float healthAmount = this.getHealth() / this.getMaxHealth();
        return healthAmount <= 0.25F;
    }

    public void aiStep() {
        super.aiStep();
        SwingParticles();
        if(this.getAttackState() == 1) {
            if (this.attackTicks == 25) {
                AreaAttack(5.5f,5.5f,270,1,(float) CMConfig.MaledictusSmashHpDamage,200,false);
                this.playSound(ModSounds.STRONGSWING.get(), 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
                MakeRingparticle(2.5f, 0.2f, 40, 0.337f, 0.925f,  0.8f, 1.0f, 30f);
            }
        }
        if(this.getAttackState()== 4){
            if (this.onGround() || !this.getFeetBlockState().getFluidState().isEmpty()) {
                this.setAttackState(5);
            }
        }

        if(this.getAttackState() == 6) {
            if (this.attackTicks == 30) {
                if (this.level().isClientSide) {
                    for(int i = 0; i < 20 + random.nextInt(2); ++i) {
                        float f2 = this.random.nextFloat() * ((float)Math.PI * 2F);
                        float f3 = Mth.sqrt(this.random.nextFloat()) * this.getBbWidth() * 0.5F;
                        double d0 = this.getX() + (double)(Mth.cos(f2) * f3);
                        double d4 = this.getZ() + (double)(Mth.sin(f2) * f3);
                        this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), d0, this.getY() + (double) this.getBbHeight() * 0.6 + i * 0.05D, d4, 0.0D, 0.1D, 0.0D);
                    }
                }
            }
        }
        if(this.getAttackState() == 7) {
            if(this.attackTicks == 10){
                masseffectParticle(5.0f);
            }
            if(this.attackTicks == 15){
                masseffectParticle(7.0f);
            }

            if(this.attackTicks == 20){
                masseffectParticle(9.0f);
            }
            if (this.attackTicks == 30) {
                this.playSound(ModSounds.MALEDICTUS_BATTLE_CRY.get(), 1F, 1.0f);
            }

            if (this.attackTicks == 34) {
                this.playSound(SoundEvents.GENERIC_EXPLODE, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 40);
                if (this.level().isClientSide) {
                    float vec = 1.0f;
                    float math = 0;
                    float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    this.level().addParticle(new RingParticle.RingData(0f, (float)Math.PI/2f, 30, 0.337f, 0.925f,  0.8f, 1.0f, 85, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
                }

                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0D))) {
                    if (!isAlliedTo(entity) && entity != this) {
                        entity.hurt(CMDamageTypes.causeMaledictioDamage(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.6F + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.MaledictusAOEHpDamage) * 1.6F));
                    }
                }
            }
            if (this.attackTicks > 34 && this.attackTicks < 44) {
                Sphereparticle(0.3f,1.0f,4F);
            }
        }
        if(this.getAttackState()== 8){
            if (this.attackTicks >= 65) {
                if (this.onGround() || !this.getFeetBlockState().getFluidState().isEmpty()) {
                    this.setAttackState(9);
                }
            }
        }

        if(this.getAttackState() == 9) {
            if (this.attackTicks == 4) {
                this.playSound(SoundEvents.GENERIC_EXPLODE, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.3f, 0, 40);
                MakeRingparticle(2.5f, 0.2f, 40, 0.337f, 0.925f,  0.8f, 1.0f, 50f);
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3.5D))) {
                    if (!isAlliedTo(entity) && entity != this) {
                        entity.hurt(CMDamageTypes.causeMaledictioDamage(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.25F + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.MaledictusFlyingSmashHpDamage) * 1.25F));
                    }
                }
            }
            for (int i = 8, j = 2; i <= 16; i = i + 2, j++) {
                if (this.attackTicks == i) {
                    ShieldSmashDamage(2, j, 4f, 2.5f, 1, (float) CMConfig.MaledictusShockWaveHpDamage,0.05F);
                }
            }
        }

        if(this.getAttackState() == 11 || this.getAttackState() == 12) {
            if (this.attackTicks >= 16 && this.attackTicks <= 22) {
                AreaAttack(5.25f, 5.25f, 45, 1.35F, (float) CMConfig.MaledictusHpDamage, 0,true);
               // RushDamage(5.25f, 0, 1.35F, (float) CMConfig.MaledictusHpDamage,true);
                if (this.level().isClientSide) {
                    double x = this.getX();
                    double y = this.getY() + this.getBbHeight() / 2;
                    double z = this.getZ();
                    float yaw = (float) Math.toRadians(-this.getYRot());
                    float pitch = (float) Math.toRadians(-this.getXRot());
                    this.level().addParticle(new RingParticle.RingData(yaw, pitch, 40, 0.337f, 0.925f,  0.8f, 1.0f, 50f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), x, y, z, 0, 0, 0);
                }
            }
        }
        if(this.getAttackState() != 13) {
            setAttackState(13);
        }

        if(this.getAttackState() == 13) {
            if (this.attackTicks >= 24 && this.attackTicks <= 30) {
                AreaAttack(5.25f, 5.25f, 45, 1.35F, (float) CMConfig.MaledictusHpDamage, 0,true);
                // RushDamage(5.25f, 0, 1.35F, (float) CMConfig.MaledictusHpDamage,true);
                if (this.level().isClientSide) {
                    double x = this.getX();
                    double y = this.getY() + this.getBbHeight() / 2;
                    double z = this.getZ();
                    float yaw = (float) Math.toRadians(-this.getYRot());
                    float pitch = (float) Math.toRadians(-this.getXRot());
                    this.level().addParticle(new RingParticle.RingData(yaw, pitch, 40, 0.337f, 0.925f,  0.8f, 1.0f, 50f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), x, y, z, 0, 0, 0);
                }
            }
            if (this.attackTicks >= 40 && this.attackTicks <= 50) {
                AreaAttack(5.5f, 5.5f, 300, 1.35F, (float) CMConfig.MaledictusHpDamage, 0,true);
            }
        }
    }


    private void RushDamage(float vec, int shieldbreakticks, float damage, float hpdamage,boolean maledictio) {

        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        List<LivingEntity> possibleList = level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().expandTowards(vecX * vec, 0, vecZ * vec).deflate(0.95,0,0.95));

        for (LivingEntity entity : possibleList) {
            if (!isAlliedTo(entity) && !(entity instanceof Maledictus_Entity) && entity != this) {
                DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + entity.getMaxHealth() * hpdamage));
                if (entity instanceof Player && entity.isDamageSourceBlocked(damagesource) && shieldbreakticks > 0) {
                    disableShield(entity, shieldbreakticks);
                }

            }

        }
    }

    private void ShieldSmashDamage(float spreadarc, int distance, float mxy, float vec, float damage, float hpdamage, float airborne) {
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
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = level().getBlockState(pos);

            while(block.getRenderShape() != RenderShape.MODEL) {
                pos = pos.below();
                block = level().getBlockState(pos);
            }
            Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
            fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
            level().addFreshEntity(fallingBlockEntity);
            AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isAlliedTo(entity)  && entity != this) {
                    boolean flag = entity.hurt(CMDamageTypes.causeMaledictioDamage(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entity.getMaxHealth() * hpdamage)));
                    if (flag) {
                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne * distance + level().random.nextDouble() * 0.15, 0.0D));

                    }
                }
            }
        }
    }

    private void MakeRingparticle(float vec, float math,int duration,float r,float g,float b,float a, float scale) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            this.level().addParticle(new RingParticle.RingData(0f, (float)Math.PI/2f, duration, r, g,  b, a, scale, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
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
                            this.level().addParticle(ModParticle.CURSED_FLAME.get(), d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private void masseffectParticle(float radius) {
        if (this.level().isClientSide) {
            for (int j = 0; j < 70; ++j) {
                float angle = (float) (Math.random() * 2 * Math.PI);
                double distance = Math.sqrt(Math.random()) * radius;
                double extraX = this.getX() + distance * Mth.cos(angle);
                double extraY = this.getY() + 0.3F;
                double extraZ = this.getZ() + distance * Mth.sin(angle);

                this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), extraX, extraY, extraZ, 0.0D, this.random.nextGaussian() * 0.04D, 0.0D);
            }
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage,float hpdamage, int shieldbreakticks,boolean maledictio) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Maledictus_Entity) && entityHit != this) {
                    DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.damageSources().mobAttack(this);
                    entityHit.hurt(damagesource, (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entityHit.getMaxHealth() * hpdamage) * damage));
                    if (entityHit instanceof Player && entityHit.isDamageSourceBlocked(damagesource) && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
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
        } else if (entityIn.getType().is(ModTag.TEAM_MALEDICTUS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.KOBOLEDIATOR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.KOBOLEDIATOR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.KOBOLEDIATOR_AMBIENT.get();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    class Maledictus_Swing extends InternalAttackGoal {
        private final float attackminrange;
        private final float random;


        public Maledictus_Swing(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, float random) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.attackminrange = attackminrange;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random;
        }
        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == 5) {
                if (target != null) {
                    double d0 = target.getX() - this.entity.getX();
                    double d1 = target.getY() - this.entity.getY();
                    double d2 = target.getZ() - this.entity.getZ();
                    Vec3 vec3 = (new Vec3(d0, 0.7 + Mth.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(0.2D,1.0D,0.2D);
                    this.entity.setDeltaMovement(vec3);
                }else{

                    Vec3 vec3 = (new Vec3(0, 0.7, 0));
                    this.entity.setDeltaMovement(vec3);
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }


    static class Maledictus_Bow extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final float attackminrange;
        private final int attackshot;
        private final float random;


        public Maledictus_Bow(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate,int attackMaxtick, int attackseetick, float attackminrange, float attackrange,int attackshot, float random) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.entity = entity;
            this.attackminrange = attackminrange;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random;
        }

        @Override
        public void start() {
            super.start();
            this.entity.setWeapon(1);
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.setWeapon(0);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == attackshot) {
                if (target != null) {
                    double arrowcount = 4;
                    double offsetangle = Math.toRadians(6);

                    //update target pos
                    double d1 = target.getX() - this.entity.getX();
                    double d2 = target.getY(0.3333333333333333D) - this.entity.getY();
                    double d3 = target.getZ() - this.entity.getZ();

                    for (int i = 0; i <= (arrowcount - 1); ++i) {
                        double angle = (i - ((arrowcount - 1) / 2)) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);

                        Phantom_Arrow_Entity throwntrident = new Phantom_Arrow_Entity(this.entity.level(), this.entity,target);
                        throwntrident.setBaseDamage(CMConfig.PhantomArrowbasedamage);
                        throwntrident.shoot(x, d2 + distance * (double)0.15F, z, 1.8F, 1);
                        this.entity.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.0F / (this.entity.getRandom().nextFloat() * 0.4F + 0.8F));
                        this.entity.level().addFreshEntity(throwntrident);

                    }

                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class Maledictus_Flying_Bow extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final float attackminrange;
        private final int attackshot;
        private final float random;

        public Maledictus_Flying_Bow(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, int attackshot, float random) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.entity = entity;
            this.attackminrange = attackminrange;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.flyattack_cooldown <=0;
        }

        @Override
        public void start() {
            super.start();
            entity.setWeapon(1);
        }

        @Override
        public void stop() {
            super.stop();
            entity.setWeapon(0);
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

            if (this.entity.attackTicks == 8) {
                this.entity.setDeltaMovement(0, 0.9, 0);
                entity.setFlying(true);
            }
            if (this.entity.attackTicks == 20) {
                this.entity.setDeltaMovement(0, 0, 0);
            }
            if (this.entity.attackTicks == 60) {
                this.entity.setFlying(false);
            }
            if (this.entity.attackTicks == attackshot) {
                if (target != null) {
                    double arrowcount = 4;
                    double offsetangle = Math.toRadians(9);

                    //update target pos
                    double d1 = target.getX() - this.entity.getX();
                    double d2 = target.getY(0.3333333333333333D) - this.entity.getY();
                    double d3 = target.getZ() - this.entity.getZ();

                    for (int i = 0; i <= (arrowcount - 1); ++i) {
                        double angle = (i - ((arrowcount - 1) / 2)) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);

                        Phantom_Arrow_Entity throwntrident = new Phantom_Arrow_Entity(this.entity.level(), this.entity, target);
                        throwntrident.setBaseDamage(CMConfig.PhantomArrowbasedamage);
                        throwntrident.shoot(x, d2 + distance * (double) 0.15F, z, 1.5F, 1);
                        this.entity.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.0F / (this.entity.getRandom().nextFloat() * 0.4F + 0.8F));
                        this.entity.level().addFreshEntity(throwntrident);

                    }
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class MaledictusfallingState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startbow;
        private final int stopbow;
        private final int attackseetick;

        public MaledictusfallingState(Maledictus_Entity entity,int getAttackState, int attackstate, int attackendstate, int attackMaxtick,int attackseetick, int startbow, int stopbow) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick);
            this.entity = entity;
            this.attackseetick = attackseetick;
            this.startbow = startbow;
            this.stopbow = stopbow;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startbow);
            if(entity.isFlying()) {
                entity.setFlying(false);
            }
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }

        @Override
        public void stop() {
            super.stop();
            entity.flyattack_cooldown = FLYATTACK_COOLDOWN;
            entity.setWeapon(stopbow);
        }
    }

    static class Maledictus_Flying_Smash extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final int attackstrike;
        private final float random;

        public Maledictus_Flying_Smash(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.entity = entity;
            this.attackstrike = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.flyattack_cooldown <=0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            entity.setFlying(false);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackstrike && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 0F);
                entity.lookAt(target, 30.0F, 0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if (this.entity.attackTicks == 25) {
                this.entity.setDeltaMovement(0, 0.9, 0);
                entity.setFlying(true);
            }
            if (this.entity.attackTicks == attackstrike) {
                this.entity.setFlying(false);
                if (target != null) {
                    double Y = 0.12f * (float) Math.abs(this.entity.getY() - target.getY());

                    double Z = 0.1f * (target.getZ() - this.entity.getZ());
                    double X = 0.1F * (target.getX() - this.entity.getX());
                    entity.setDeltaMovement(entity.getDeltaMovement().add(X, -1.0d * Y, Z));

                }
            }

        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }



    static class MaledictusChargeGoal extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final float attackminrange;
        private final int startweapon;
        private final int stopweapon;
        private final int attackseetick;
        private final int attackseetick2;
        private final int attackchargetick;
        private final int count;
        private final float random;


        public MaledictusChargeGoal(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick,int attackseetick2,int attackchargetick, float attackminrange, float attackrange, int startbow, int stopbow, float random,int count) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.entity = entity;
            this.attackminrange = attackminrange;
            this.attackseetick = attackseetick;
            this.attackseetick2 = attackseetick2;
            this.attackchargetick = attackchargetick;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.random = random;
            this.count = count;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.charge_cooldown <=0;
        }

        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null || entity.attackTicks > attackseetick2 && target !=null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30F);
                entity.lookAt(target, 30.0F, 30F);
            } else {
                entity.setYRot(entity.yRotO);
            }

            if (entity.attackTicks == attackchargetick) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYRot() + 90));
                if(target != null) {
                    float r = entity.distanceTo(target);
                    r = Mth.clamp(r, 0, 7);
                    entity.push(f1 * 0.9 * r, 0, f2 * 0.9 * r);
                }else{
                    entity.push(f1 * 3.0, 0, f2 * 3.0);
                }
            }

            if (entity.attackTicks == 27 && (entity.onGround() || entity.isInLava() || entity.isInWater())) {
                float speed = -1.7f;
                float dodgeYaw = (float) Math.toRadians(entity.getYRot() + 90);
                Vec3 m = entity.getDeltaMovement().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                entity.setDeltaMovement(m.x, 0.4, m.z);
            }

        }

        @Override
        public void stop() {
            if(this.count == 1 && entity.isHalfHealth()){
                this.entity.setAttackState(13);
            }else if (this.count == 2 && entity.isQuarterHealth()){
                this.entity.setAttackState(14);
            }else{
                super.stop();
                entity.charge_cooldown = CHARGE_COOLDOWN;
                entity.setWeapon(stopweapon);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class MaledictusChargeState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startweapon;
        private final int stopweapon;
        private final int attackseetick;
        private final int attackseetick2;
        private final int attackchargetick;
        private final int backsteptick;
        private final int count;


        public MaledictusChargeState(Maledictus_Entity entity,int getAttackState, int attackstate, int attackendstate, int attackMaxtick,int attackseetick,int attackseetick2,int attackchargetick, int backsteptick,int startbow, int stopbow,int count) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick);
            this.entity = entity;
            this.attackseetick = attackseetick;
            this.attackseetick2 = attackseetick2;
            this.attackchargetick = attackchargetick;
            this.backsteptick = backsteptick;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.count = count;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null || entity.attackTicks > attackseetick2 && target !=null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30F);
                entity.lookAt(target, 30.0F, 30F);
            } else {
                entity.setYRot(entity.yRotO);
            }

            if (entity.attackTicks == attackchargetick) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYRot() + 90));
                if(target != null) {
                    float r = entity.distanceTo(target);
                    r = Mth.clamp(r, 0, 7);
                    entity.push(f1 * 0.9 * r, 0, f2 * 0.9 * r);
                }else{
                    entity.push(f1 * 3.0, 0, f2 * 3.0);
                }
            }

            if (entity.attackTicks == backsteptick && (entity.onGround() || entity.isInLava() || entity.isInWater())) {
                float speed = -1.7f;
                float dodgeYaw = (float) Math.toRadians(entity.getYRot() + 90);
                Vec3 m = entity.getDeltaMovement().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                entity.setDeltaMovement(m.x, 0.4, m.z);
            }
        }

        @Override
        public void stop() {
            if(this.count == 1 && entity.isHalfHealth()){
                this.entity.setAttackState(13);
            }else if (this.count == 2 && entity.isQuarterHealth()){
                this.entity.setAttackState(14);
            }else{
                super.stop();
                entity.charge_cooldown = CHARGE_COOLDOWN;
                entity.setWeapon(stopweapon);
            }
        }
    }


}





