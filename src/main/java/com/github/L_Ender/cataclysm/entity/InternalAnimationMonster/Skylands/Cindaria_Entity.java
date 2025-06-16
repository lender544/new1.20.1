package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.L_Ender.cataclysm.entity.projectile.Water_Spear_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;


public class Cindaria_Entity extends Internal_Animation_Monster {
    private boolean isLandNavigator;
    boolean searchingForLand;

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState magic1AnimationState = new AnimationState();
    public AnimationState meleeAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int magic_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 100;

    public Cindaria_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 15;
        this.setMaxUpStep(1.75F);
        switchNavigator(true);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(3, new CindariaMoveGoal(this, 1.0D,8.0F));
        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,2,0,39,13,3.75F));
        this.goalSelector.addGoal(2, new MagicAttackGoal(this,0,1,0,50,15,4.5F,16));

    }


    public static AttributeSupplier.Builder cindaria() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 7)
                .add(Attributes.MAX_HEALTH, 60);
    }


    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return sizeIn.height * 0.75F;
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new CMPathNavigateGround(this, level());
            this.moveControl = new MoveControl(this);
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator(this, level());
            this.moveControl = new CindariaSwimControl(this, 2.0f);
            this.isLandNavigator = false;
        }
    }



    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        } else {
            LivingEntity livingentity = this.getTarget();
            return livingentity != null && livingentity.isInWater();
        }
    }

    public void travel(Vec3 p_32394_) {
        if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
            this.moveRelative(0.01F, p_32394_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
        } else {
            super.travel(p_32394_);
        }

    }
    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();



        return super.hurt(source, damage);
    }


    protected int decreaseAirSupply(int air) {
        return air;
    }



    public AnimationState getAnimationState(String input) {
        if (input == "magic1") {
            return this.magic1AnimationState;
        } else if (input == "melee") {
            return this.meleeAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }


    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.magic1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.meleeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.magic1AnimationState.stop();
        this.meleeAnimationState.stop();
        this.deathAnimationState.stop();
    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(3);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.CINDARIA_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.CINDARIA_DEATH.get();
    }

    public MobType getMobType() {
        return MobType.WATER;

    }


    public int deathtimer() {
        return 40;
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
            this.idleAnimationState.animateWhen(true , this.tickCount);
        }
        if (isInWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!isInWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }
    }

    public void aiStep() {
        super.aiStep();


        if(this.getAttackState() == 2) {
            if (this.attackTicks == 14) {
                AreaAttack(4.75f, 4.75f, 100, 1.0F, 0, true);
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Cindaria_Entity) && entityHit != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean hurt = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    double d0 = entityHit.getX() - this.getX();
                    double d1 = entityHit.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                    if (hurt && knockback) {
                        entityHit.push(d0 / d2 * 2.25D, 0.15D, d1 / d2 * 2.25D);
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
        } else if (entityIn.getType().is(ModTag.TEAM_SCYLLA)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }


    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public boolean canBeAffected(MobEffectInstance p_34192_) {
        return p_34192_.getEffect() != ModEffect.EFFECTSTUN.get() && p_34192_.getEffect() != ModEffect.EFFECTABYSSAL_CURSE.get() && super.canBeAffected(p_34192_);
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


    public static class CindariaMoveGoal extends Goal {
        private final Cindaria_Entity mob;
        private final double speedModifier;
        private final float attackRadiusSqr;
        private int seeTime;
        private boolean strafingBackwards;
        private int strafingTime = -1;


    public CindariaMoveGoal(Cindaria_Entity p_25792_, double p_25793_, float p_25795_) {
            this.mob = p_25792_;
            this.speedModifier = p_25793_;
            this.attackRadiusSqr = p_25795_ * p_25795_;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }


        @Override
        public boolean canUse() {
            return this.mob.getTarget() != null && this.mob.getTarget().isAlive();
        }

        @Override
        public boolean canContinueToUse() {
            return (this.canUse() || !this.mob.getNavigation().isDone());
        }

        @Override
        public void start() {
            super.start();
            this.mob.setAggressive(true);
        }

        @Override
        public void stop() {
            super.stop();
            this.mob.setAggressive(false);
            this.mob.getNavigation().stop();
            this.seeTime = 0;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }



        @Override
        public void tick() {
            LivingEntity livingentity = this.mob.getTarget();
            if (livingentity != null) {
                double d0 = this.mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                boolean flag = this.mob.getSensing().hasLineOfSight(livingentity);
                boolean flag1 = this.seeTime > 0;
                if (flag != flag1) {
                    this.seeTime = 0;
                }

                if (flag) {
                    this.seeTime++;
                } else {
                    this.seeTime--;
                }

                if (!(d0 > (double)this.attackRadiusSqr) && this.seeTime >= 20) {
                    this.mob.getNavigation().stop();
                    this.strafingTime++;
                } else {
                    this.mob.getNavigation().moveTo(livingentity, this.speedModifier);
                    this.strafingTime = -1;
                }

                if (this.strafingTime >= 20) {
                    this.strafingTime = 0;
                }

                if (this.strafingTime > -1) {
                    if (d0 > (double)(this.attackRadiusSqr * 0.75F)) {
                        this.strafingBackwards = false;
                    } else if (d0 < (double)(this.attackRadiusSqr * 0.25F)) {
                        this.strafingBackwards = true;
                    }

                    this.mob.getMoveControl().strafe(this.strafingBackwards ? -0.8F : 0.8F,0F);
                    if (this.mob.getControlledVehicle() instanceof Mob mob) {
                        mob.lookAt(livingentity, 30.0F, 30.0F);
                    }

                    this.mob.lookAt(livingentity, 30.0F, 30.0F);
                } else {
                    this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
                }
            }
        }
    }


    static class MagicAttackGoal extends Goal {
        protected final Cindaria_Entity entity;

        private final int getAttackState;

        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackminrange;
        private final float attackrange;

        public MagicAttackGoal(Cindaria_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getAttackState = getAttackState;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackminrange = attackminrange;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.distanceTo(target) > attackminrange && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getAttackState && this.entity.magic_cooldown <= 0;
        }

        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
          //  this.entity.magic_cooldown = CHARGE_COOLDOWN;
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.attackTicks < attackMaxtick;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if (entity.attackTicks == attackseetick) {
                if (target != null) {
                    double d0 = entity.getX();
                    double d1 = entity.getY() + entity.getBbHeight() * 0.5F;
                    double d2 = entity.getZ();
                    double d3 = target.getX() - d0;
                    double d4 = target.getY() - d1;
                    double d5 = target.getZ() - d2;
                    Vec3 vec3 = new Vec3(d3, d4, d5).normalize();
                    Water_Spear_Entity waterSpear = new Water_Spear_Entity(entity, vec3,entity.level(),(float) CMConfig.HarbingerWitherMissiledamage);

                    float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;

                    float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));

                    waterSpear.setYRot(yRot);
                    waterSpear.setXRot(xRot);
                    waterSpear.setPosRaw(d0, d1, d2);
                    waterSpear.setTotalBounces(10);

                    entity.level().addFreshEntity(waterSpear);
                }
            }
        }
    }
    static class CindariaSwimControl extends MoveControl {
        private final Cindaria_Entity drowned;
        private final float speedMulti;

        public CindariaSwimControl(Cindaria_Entity p_32433_, float speedMulti) {
            super(p_32433_);
            this.drowned = p_32433_;
            this.speedMulti = speedMulti;
        }

        public void tick() {
            LivingEntity livingentity = this.drowned.getTarget();
            if (this.drowned.wantsToSwim() && this.drowned.isInWater()) {
                if (livingentity != null && livingentity.getY() > this.drowned.getY() || this.drowned.searchingForLand) {
                    this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(0.0D, 0.002D, 0.0D));
                }

                if (this.operation != Operation.MOVE_TO || this.drowned.getNavigation().isDone()) {
                    this.drowned.setSpeed(0.0F);
                    return;
                }

                double d0 = this.wantedX - this.drowned.getX();
                double d1 = this.wantedY - this.drowned.getY();
                double d2 = this.wantedZ - this.drowned.getZ();
                double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 /= d3;
                float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                this.drowned.setYRot(this.rotlerp(this.drowned.getYRot(), f, 90.0F));
                this.drowned.yBodyRot = this.drowned.getYRot();
                float f1 = (float)(this.speedModifier * speedMulti * this.drowned.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float f2 = Mth.lerp(0.125F, this.drowned.getSpeed(), f1);
                this.drowned.setSpeed(f2);
                this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add((double)f2 * d0 * 0.005D, (double)f2 * d1 * 0.1D, (double)f2 * d2 * 0.005D));
            } else {
                if (!this.drowned.onGround()) {
                    this.drowned.setDeltaMovement(this.drowned.getDeltaMovement().add(0.0D, -0.008D, 0.0D));
                }

                super.tick();
            }

        }
    }
}





