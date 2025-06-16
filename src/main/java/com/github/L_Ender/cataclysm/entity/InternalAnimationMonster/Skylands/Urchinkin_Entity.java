package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands;

import com.github.L_Ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.L_Ender.cataclysm.entity.projectile.Urchin_Spike_Entity;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;


public class Urchinkin_Entity extends Monster {
    private boolean isLandNavigator;
    boolean searchingForLand;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState rollAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();

    public static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(Urchinkin_Entity.class, EntityDataSerializers.INT);

    private int roll_cooldown = 0;
    public static final int ROLL_COOLDOWN = 80;
    public int attackTicks;
    
    public Urchinkin_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 4;
        switchNavigator(true);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
    }

    protected void registerGoals() {

        this.goalSelector.addGoal(2, new Roll(this,0,1,0,40,12,5,13,30,50));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, (double)1.0F, true));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder urchin() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.37F)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.MAX_HEALTH, 12);
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new GroundPathNavigation(this, level());
            this.moveControl = new MoveControl(this);
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator(this, level());
            this.moveControl = new UrchinkinSwimControl(this, 2.0f);
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
        if (input == "roll") {
            return this.rollAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "attack") {
                return this.attackAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public boolean isMeatBoy() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return s != null && (s.toLowerCase().contains("meatboy"));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK_STATE, 0);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.rollAnimationState.startIfStopped(this.tickCount);
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

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return sizeIn.height * 0.5F;
    }

    public void stopAllAnimationStates() {
        this.rollAnimationState.stop();
    }

    public boolean doHurtTarget(Entity p_219472_) {
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(p_219472_);
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

    @Override
    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 2.0F;
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
        if (roll_cooldown > 0) roll_cooldown--;
    }

    public void aiStep() {
        super.aiStep();

        if(this.getAttackState() == 1) {
            if (this.attackTicks >13 && this.attackTicks <30 ) {
                for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                    if (!isAlliedTo(livingentity) && !(livingentity instanceof Urchinkin_Entity) && livingentity != this) {
                      boolean flag =  livingentity.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
                      if(flag) {
                          if (!this.level().isClientSide) {
                              livingentity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0), this);
                          }
                      }
                    }
                }
            }
            if (this.attackTicks == 13 || this.attackTicks == 16 || this.attackTicks == 19 ||this.attackTicks == 22 ||this.attackTicks == 25 ||this.attackTicks == 28) {
                SpikeNansa(3);
            }
        }
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        SpikeNansa(6);

    }

    private void SpikeNansa(int spike){
        int shardCount = spike + random.nextInt(2);
        if (!this.level().isClientSide) {
            for (int i = 0; i < shardCount; i++) {
                float f = ((i + 1) / (float) shardCount) * 360F;
                Urchin_Spike_Entity shard = new Urchin_Spike_Entity(this.level(), this);
                if(isMeatBoy()){
                    ItemStack itemstack = new ItemStack(ModItems.BLOOD_CLOT.get());
                    shard.setItem(itemstack);
                }
                shard.shoot(this.random.nextFloat() * 0.4F * 2.0F - 0.4F, this.random.nextFloat() * 0.25F + 0.1F,this.random.nextFloat() * 0.4F * 2.0F - 0.4F, 0.35F, 1F);
                level().addFreshEntity(shard);
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

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.DRAUGR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.DRAUGR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.DRAUGR_IDLE.get();
    }


    static class Roll extends Goal {
        private final Urchinkin_Entity entity;
        private final int attackrollstart;
        private final int attackrollend;
        private final float random;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;

        public Roll(Urchinkin_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackroll, int attackrollend, float random) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
            this.getattackstate = getAttackState;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.attackrollstart = attackroll;
            this.attackrollend = attackrollend;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }
        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getSensing().hasLineOfSight(target) && this.entity.roll_cooldown <= 0;
        }

        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.roll_cooldown = ROLL_COOLDOWN;
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if (this.attackrollstart < entity.attackTicks && this.attackrollend > entity.attackTicks ) {
                Vec3 vector3d = entity.getDeltaMovement();
                float f = entity.getYRot() * ((float) Math.PI / 180F);
                Vec3 vector3d1 = new Vec3(-Mth.sin(f), entity.getDeltaMovement().y, Mth.cos(f)).scale(0.35D).add(vector3d.scale(0.35D));
                entity.setDeltaMovement(vector3d1.x, entity.getDeltaMovement().y, vector3d1.z);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
    static class UrchinkinSwimControl extends MoveControl {
        private final Urchinkin_Entity drowned;
        private final float speedMulti;

        public UrchinkinSwimControl(Urchinkin_Entity p_32433_, float speedMulti) {
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





