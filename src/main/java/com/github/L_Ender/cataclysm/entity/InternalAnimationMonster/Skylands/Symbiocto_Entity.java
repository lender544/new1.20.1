package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands;

import com.github.L_Ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.L_Ender.cataclysm.entity.projectile.Octo_Ink_Entity;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LlamaSpit;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;


public class Symbiocto_Entity extends Monster implements RangedAttackMob {
    private boolean isLandNavigator;
    boolean searchingForLand;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState spitAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(Symbiocto_Entity.class, EntityDataSerializers.INT);

    public int attackTicks;

    public Symbiocto_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 5;
        switchNavigator(true);
    }

    protected void registerGoals() {

        this.goalSelector.addGoal(2, new CrossBowShootGoal(this,0,1,0,34,19,16F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, (double)1.0F, true));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder octo() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.MAX_HEALTH, 16);
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new GroundPathNavigation(this, level());
            this.moveControl = new MoveControl(this);
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator(this, level());
            this.moveControl = new SymbioctoSwimControl(this, 2.0f);
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

    public AnimationState getAnimationState(String input) {
        if (input == "spit") {
            return this.spitAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "attack") {
                return this.attackAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public boolean isCloseEye() {
        return this.getVehicle() instanceof Drowned_Host_Entity;
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ATTACK_STATE, 0);
    }



    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.spitAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public int getAttackState() {
        return this.entityData.get(ATTACK_STATE);
    }

    public void setAttackState(int input) {
        this.attackTicks = 0;
        this.entityData.set(ATTACK_STATE, input);
        this.level().broadcastEntityEvent(this, (byte) -input);
    }
    public double getMyRidingOffset() {
        return 0.15D;
    }

    public void stopAllAnimationStates() {
        this.spitAnimationState.stop();
    }

    public boolean doHurtTarget(Entity p_219472_) {
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(p_219472_);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return  source.is(DamageTypes.IN_WALL)  || super.isInvulnerableTo(source);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }


    @Override
    public void handleEntityEvent(byte id) {
        if (id <= 0) {
            this.attackTicks = 0;
        }else if (id == 4) {
            this.attackAnimationState.start(this.tickCount);
        }else {
            super.handleEntityEvent(id);
        }
    }
    
    public void tick() {
        super.tick();
        if (this.getAttackState() > 0) {
            ++this.attackTicks;
        }
        if (isInWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!isInWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }
    }

    public void aiStep() {
        super.aiStep();



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

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SQUID_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SQUID_DEATH;
    }

    public MobType getMobType() {
        return MobType.WATER;

    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SQUID_AMBIENT;
    }
    private void spit(LivingEntity target) {
        Octo_Ink_Entity llamaspit = new Octo_Ink_Entity(this.level(), this);
        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333) - llamaspit.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2) * 0.2F;
        llamaspit.shoot(d0, d1 + d3, d2, 1.5F, 10.0F);
        if (!this.isSilent()) {
            this.level()
                    .playSound(
                            null,
                            this.getX(),
                            this.getY(),
                            this.getZ(),
                            SoundEvents.SQUID_SQUIRT,
                            this.getSoundSource(),
                            0.5F,
                            1f
                    );
        }

        this.level().addFreshEntity(llamaspit);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float velocity) {
        this.spit(target);
    }

    static class CrossBowShootGoal extends Goal {
        protected final Symbiocto_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;


        public CrossBowShootGoal(Symbiocto_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null &&  target.isAlive() && this.entity.distanceTo(target) < attackrange && !this.entity.isWithinMeleeAttackRange(target) && this.entity.getAttackState() == getattackstate ;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            LivingEntity target = entity.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
                this.entity.setTarget((LivingEntity)null);
            }
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if(target != null && entity.attackTicks == 19) {
                this.entity.performRangedAttack(target, 1.0F);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class SymbioctoSwimControl extends MoveControl {
        private final Symbiocto_Entity drowned;
        private final float speedMulti;

        public SymbioctoSwimControl(Symbiocto_Entity p_32433_, float speedMulti) {
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





