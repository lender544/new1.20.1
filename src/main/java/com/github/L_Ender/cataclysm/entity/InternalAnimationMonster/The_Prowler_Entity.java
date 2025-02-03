package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Death_Laser_Beam_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Wither_Homing_Missile_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;

import java.util.EnumSet;
import java.util.List;


public class The_Prowler_Entity extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState stunAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState laserAnimationState = new AnimationState();
    public AnimationState spinAnimationState = new AnimationState();
    public AnimationState meleeAnimationState = new AnimationState();
    public AnimationState strongAttackAnimationState = new AnimationState();
    public AnimationState pierceAnimationState = new AnimationState();
    public static final int SPIN_COOLDOWN = 80;
    public static final int LASER_COOLDOWN = 200;
    private int spin_cooldown = 0;
    private int laser_cooldown = 100;
    public static final int NATURE_HEAL_COOLDOWN = 60;
    private int timeWithoutTarget;
    public The_Prowler_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 20;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.ProwlerHealthMultiplier, CMConfig.ProwlerDamageMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new InternalMoveGoal(this, false, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));

        this.goalSelector.addGoal(0, new InternalStateGoal(this, 1, 1, 0, 60, 0));

        //laser
        this.goalSelector.addGoal(1, new Lasershoot(this, 0, 2, 0, 90, 20, 8F, 20, 100F));
        //spin
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,4,0,50,22,4.75F){
            @Override
            public boolean canUse() {
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < 26 && The_Prowler_Entity.this.spin_cooldown <= 0;

            }

            @Override
            public void stop() {
                super.stop();
                The_Prowler_Entity.this.spin_cooldown = SPIN_COOLDOWN;
            }
        });

        //melee
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,5,0,50,38,5F){
            @Override
            public boolean canUse() {
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < 20 ;
            }
        });
        //strong
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,6,0,55,45,6F){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < 20 && target !=null && this.entity.distanceTo(target) >= 2.75D;


            }
        });
        //pierce
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,7,0,80,38,4.25F){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < 24 && target !=null;


            }
        });
    }

    public static AttributeSupplier.Builder the_prowler() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 14)
                .add(Attributes.MAX_HEALTH, 160)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.STEP_HEIGHT, 1.5F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.95);
    }


    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (source.is(CMDamageTypes.EMP) && this.getAttackState() != 1) {
            this.setAttackState(1);
        }
        double range = calculateRange(source);
        if (range > CMConfig.ProwlerLongRangelimit * CMConfig.ProwlerLongRangelimit) {
            return false;
        }

        return super.hurt(source, damage);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "stun") {
            return this.stunAnimationState;
        } else if (input == "laser") {
            return this.laserAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "spin") {
            return this.spinAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "melee") {
            return this.meleeAnimationState;
        } else if (input == "strong_attack") {
            return this.strongAttackAnimationState;
        } else if (input == "pierce") {
            return this.pierceAnimationState;
        } else {
            return new AnimationState();
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.stunAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.laserAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.spinAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.meleeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.strongAttackAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.pierceAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.laserAnimationState.stop();
        this.stunAnimationState.stop();
        this.spinAnimationState.stop();
        this.meleeAnimationState.stop();
        this.strongAttackAnimationState.stop();
        this.deathAnimationState.stop();
        this.pierceAnimationState.stop();
    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(3);
    }

    public int deathtimer() {
        return 40;
    }


    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() != 1, this.tickCount);
        }else{
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            LivingEntity target = this.getTarget();
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (timeWithoutTarget <= 0) {
                if (!isNoAi() ) {
                    if (this.tickCount % 20 == 0) {
                        this.heal(this.getMaxHealth()/ 10);
                    }
                }
            }
        }
        if (laser_cooldown > 0) laser_cooldown--;
        if (spin_cooldown > 0) spin_cooldown--;

    }

    public void aiStep() {
        super.aiStep();
        LivingEntity target = this.getTarget();
        if (this.getAttackState() == 2) {
            if (this.attackTicks == 38) {
                this.level().playSound((Player) null, this, ModSounds.DEATH_LASER.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.2f, 0, 10);
            }
        }


        if (this.getAttackState() == 1) {
            if (this.level().isClientSide) {
                for (int i = 0; i < 2; ++i) {
                    this.level().addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
                }
            }
        }
        if (this.getAttackState() == 4) {
            if (this.attackTicks == 23 || this.attackTicks == 32) {
                AreaAttack(6.0f, 6.0F, 180, 1.0F);
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_SPIN_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if (this.attackTicks == 23) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_SPIN_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
        }

        if (this.getAttackState() == 5) {
            if (this.attackTicks == 27){
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_SPIN_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if (this.attackTicks == 20 || this.attackTicks == 26 || this.attackTicks == 32 || this.attackTicks == 38 || this.attackTicks == 44) {
                AreaAttack(5.4f, 5.5F, 110, 0.5F);

            }
        }
        float f1 = (float) Math.cos(Math.toRadians(this.getYRot() + 90));
        float f2 = (float) Math.sin(Math.toRadians(this.getYRot() + 90));
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 18) {
                this.push(f1 * 1.5, 0, f2 * 1.5);
            }
            if (this.attackTicks == 17){
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_SPIN_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if (this.attackTicks ==25) {
                AreaAttack(5.5f, 5.5f, 70, 1.5F);

            }
        }
        if (this.getAttackState() == 7) {
            if(target !=null) {
                if (this.attackTicks == 12) {
                    Missilelaunch(2.0f, 0.5F, target);
                }
                if (this.attackTicks == 15) {
                    Missilelaunch(2.3f, 0.5F, target);
                }
                if (this.attackTicks == 18) {
                    Missilelaunch(2.6f, 0.5F, target);
                }
            }
            if (this.attackTicks == 18) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if (this.attackTicks == 25 || this.attackTicks == 32 || this.attackTicks == 40) {
                AreaAttack(5.5F, 5.5F, 60, 0.5F);


            }

            if (this.attackTicks == 64) {
                AreaAttack(5.5F, 5.5F, 140, 1.0F);

            }
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof The_Prowler_Entity) && entityHit != this) {
                    entityHit.hurt(CMDamageTypes.causeShredderDamage(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));

                }
            }
        }
    }


    private void Missilelaunch(float y, float math, LivingEntity target) {
        if (!this.isSilent()) {
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.ROCKET_LAUNCH.get(), SoundSource.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        }
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;

        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);


        double d0 = this.getX() + 0.5f * vecX + f * math;
        double d1 = this.getY() + y;
        double d2 = this.getZ() + 0.5f * vecZ + f1 * math;



        Wither_Homing_Missile_Entity laserBeam = new Wither_Homing_Missile_Entity(this.level(),this,target);
        laserBeam.setPosRaw(d0, d1, d2);
        this.level().addFreshEntity(laserBeam);
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

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.PROWLER_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.PROWLER_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.PROWLER_IDLE.get();
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect() != ModEffect.EFFECTSTUN && p_34192_.getEffect() != ModEffect.EFFECTABYSSAL_CURSE.get() && super.canBeAffected(p_34192_);
    }


    public boolean removeWhenFarAway(double p_21542_) {
        return false;
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    static class Lasershoot extends InternalAttackGoal {
        private final The_Prowler_Entity entity;
        private final int attackshot;
        private final float random;


        public Lasershoot(The_Prowler_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getSensing().hasLineOfSight(target) && this.entity.laser_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            entity.laser_cooldown = LASER_COOLDOWN;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == attackshot) {
                Death_Laser_Beam_Entity DeathBeam = new Death_Laser_Beam_Entity(ModEntities.DEATH_LASER_BEAM.get(), entity.level(), entity, entity.getX(), entity.getY() + 1.8, entity.getZ(), (float) ((entity.yHeadRot + 90) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 28,(float) CMConfig.DeathLaserdamage,(float) CMConfig.DeathLaserHpdamage);
                entity.level().addFreshEntity(DeathBeam);
            }
            if (this.entity.attackTicks >= attackshot) {
                if (target != null) {
                    entity.getLookControl().setLookAt(target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ(), 2, 90);
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

}





