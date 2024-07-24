package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AttackAniamtionGoal3;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AttackAnimationGoal1;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Wither_Homing_Missile_Entity;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;
import java.util.List;


public class The_Prowler_Entity extends LLibrary_Boss_Monster {

    public static final Animation PROWLER_MISSILE = Animation.create(55);
    public static final Animation PROWLER_ATTACK = Animation.create(84);
    public static final Animation PROWLER_SPIN_ATTACK = Animation.create(43);
    public static final Animation PROWLER_STUN = Animation.create(60);

    private static final EntityDataAccessor<Boolean> IS_AWAKEN = SynchedEntityData.defineId(The_Prowler_Entity.class, EntityDataSerializers.BOOLEAN);
    private int timeWithoutTarget;
    public float deactivateProgress;
    public float prevdeactivateProgress;

    public The_Prowler_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 20;
        this.setMaxUpStep(1.25F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        setConfigattribute(this, CMConfig.ProwlerHealthMultiplier, CMConfig.ProwlerDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, PROWLER_MISSILE,PROWLER_ATTACK,PROWLER_SPIN_ATTACK,PROWLER_STUN};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new WatcherMoveGoal(this, false,1.0D));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, PROWLER_MISSILE, 33, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, PROWLER_ATTACK, 19, true));
        this.goalSelector.addGoal(1, new AttackAnimationGoal1<>(this, PROWLER_SPIN_ATTACK, 14, true));
        this.goalSelector.addGoal(1, new AttackAniamtionGoal3<>(this, PROWLER_STUN));
        this.goalSelector.addGoal(0, new AwakenGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

    }

    public static AttributeSupplier.Builder the_prowler() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 14)
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.9);
    }

    public boolean canBeSeenAsEnemy() {
        return this.getIsAwaken() && super.canBeSeenAsEnemy();
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {

        if (source.is(CMDamageTypes.EMP) && this.getIsAwaken()) {
            AnimationHandler.INSTANCE.sendAnimationMessage(this, PROWLER_STUN);
        }
        double range = calculateRange(source);
        if (range > CMConfig.ProwlerLongRangelimit * CMConfig.ProwlerLongRangelimit) {
            return false;
        }
        if (this.deactivateProgress > 0) {
            if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                return false;
            }
        }

        return super.hurt(source, damage);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }


    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_AWAKEN, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Awaken", getIsAwaken());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setIsAwaken(compound.getBoolean("is_Awaken"));
    }

    public void setIsAwaken(boolean isAwaken) {
        this.entityData.set(IS_AWAKEN, isAwaken);
    }

    public boolean getIsAwaken() {
        return this.entityData.get(IS_AWAKEN);
    }


    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();

        prevdeactivateProgress = deactivateProgress;
        if (!this.getIsAwaken() && deactivateProgress < 15F) {
            deactivateProgress++;
        }
        if (this.getIsAwaken() && deactivateProgress > 0F) {
            deactivateProgress--;

        }

        if(!this.getIsAwaken()) {
            if (this.tickCount % 5 == 0) {
                this.heal(this.getMaxHealth() * 0.1F);
            }
        }

        if (!level().isClientSide) {
            timeWithoutTarget++;
            if (target != null) {
                timeWithoutTarget = 0;
                if(!this.getIsAwaken()) {
                    this.setIsAwaken(true);
                }
            }

            if (timeWithoutTarget > 400 && this.getIsAwaken() && target == null) {
                timeWithoutTarget = 0;
                this.setIsAwaken(false);
            }
        }
    }

    public void aiStep() {
        super.aiStep();
        LivingEntity target = this.getTarget();
        if(this.getAnimation() == PROWLER_MISSILE){
            if (target != null && target.isAlive()) {
                if(this.getAnimationTick() == 19) {
                    Missilelaunch(1.75f,1.0f,target);
                }
                if(this.getAnimationTick() == 23) {
                    Missilelaunch(2.1f,1.0f,target);
                }
                if(this.getAnimationTick() == 27) {
                    Missilelaunch(2.6f,1.0f,target);
                }
            }
        }
        if(this.getAnimation() == PROWLER_SPIN_ATTACK){
            if(this.getAnimationTick() == 8) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_SPIN_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if(this.getAnimationTick() == 19) {
                AreaAttack(4f,4f,270,1.5F);
            }
        }
        if(this.getAnimation() == PROWLER_ATTACK){
            if(this.getAnimationTick()== 1) {
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.PROWLER_SAW_ATTACK.get(), SoundSource.HOSTILE, 1.5f, 1F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
            }
            if(this.getAnimationTick() >= 18 && this.getAnimationTick() <= 64) {
                if (this.tickCount % 4 ==0) {
                    AreaAttack(4f, 4f, 270, 0.75F);
                }
            }
            if(this.getAnimationTick() == 59){
                AreaAttack(4f,4f,120,1.5F);
            }
        }

        if (this.getAnimation() == PROWLER_STUN)
            if (this.level().isClientSide) {
                for (int i = 0; i < 2; ++i) {
                    this.level().addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
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
                    entityHit.hurt(this.damageSources().mobAttack(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));

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
        return this.getIsAwaken() ? ModSounds.PROWLER_IDLE.get() : super.getAmbientSound();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    class AwakenGoal extends Goal {
        private final The_Prowler_Entity prowler;

        public AwakenGoal(The_Prowler_Entity boss) {
            this.prowler = boss;
            this.setFlags(EnumSet.of(Flag.JUMP, Flag.LOOK, Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return deactivateProgress > 0F;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
         this.prowler.setDeltaMovement(0, this.prowler.getDeltaMovement().y, 0);
        }
    }

    static class WatcherMoveGoal extends Goal {
        private final The_Prowler_Entity prowler;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private int delayCounter;
        protected final double moveSpeed;


        public WatcherMoveGoal(The_Prowler_Entity boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
            this.prowler = boss;
            this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
            this.moveSpeed = moveSpeed;
            this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
        }


        public boolean canUse() {
            LivingEntity target = this.prowler.getTarget();
            return target != null && target.isAlive();
        }


        public void stop() {
            prowler.getNavigation().stop();
            LivingEntity livingentity = this.prowler.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
                this.prowler.setTarget((LivingEntity) null);
            }
            this.prowler.setAggressive(false);
            this.prowler.getNavigation().stop();
        }

        public boolean canContinueToUse() {
            LivingEntity target = this.prowler.getTarget();
            if (target == null) {
                return false;
            } else if (!target.isAlive()) {
                return false;
            } else if (!this.followingTargetEvenIfNotSeen) {
                return !this.prowler.getNavigation().isDone();
            } else if (!this.prowler.isWithinRestriction(target.blockPosition())) {
                return false;
            } else {
                return !(target instanceof Player) || !target.isSpectator() && !((Player) target).isCreative();
            }
        }

        public void start() {
            this.prowler.getNavigation().moveTo(this.path, this.moveSpeed);
            this.prowler.setAggressive(true);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.prowler.getTarget();
            if (target != null) {
                prowler.getLookControl().setLookAt(target, 30.0F, 30.0F);
                double distSq = this.prowler.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
                if (--this.delayCounter <= 0) {
                    this.delayCounter = 4 + this.prowler.getRandom().nextInt(7);
                    if (distSq > Math.pow(this.prowler.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0D)) {
                        if (!this.prowler.isPathFinding()) {
                            if (!this.prowler.getNavigation().moveTo(target, 1.0D)) {
                                this.delayCounter += 5;
                            }
                        }
                    } else {
                        this.prowler.getNavigation().moveTo(target, this.moveSpeed);
                    }
                }
                if (target.isAlive()) {
                    if (this.prowler.getAnimation() == NO_ANIMATION) {
                        if (this.prowler.distanceTo(target) < 3.5F) {
                            if(this.prowler.random.nextInt(2) == 0) {
                                this.prowler.setAnimation(PROWLER_ATTACK);
                            }else{
                                this.prowler.setAnimation(PROWLER_SPIN_ATTACK);
                            }
                        } else if (this.prowler.getRandom().nextFloat() * 100.0F < 4f && this.prowler.distanceTo(target) <= 6D && this.prowler.distanceTo(target) >= 3.5F) {
                            this.prowler.setAnimation(PROWLER_MISSILE);
                        } else if (this.prowler.getRandom().nextFloat() * 100.0F < 12f && this.prowler.distanceTo(target) >= 6D) {
                            this.prowler.setAnimation(PROWLER_MISSILE);
                        }
                    }
                }
            }
        }
    }
}





