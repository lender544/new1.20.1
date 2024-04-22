package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.etc.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMMathUtil;
import com.github.L_Ender.lionfishapi.client.model.tools.DynamicChain;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class Wadjet_Entity extends Internal_Animation_Monster {
    @OnlyIn(Dist.CLIENT)
    public DynamicChain dc;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState stabnswingAnimationState = new AnimationState();
    public AnimationState doublswingAnimationState = new AnimationState();
    public AnimationState spearchargeAnimationState = new AnimationState();
    public AnimationState magicAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();

    private float prevAttackProgress;
    private float AttackProgress;

    private int nanta_cooldown = 0;
    public static final int NANTA_COOLDOWN = 160;
    private int jump_cooldown = 0;
    public static final int JUMP_COOLDOWN = 160;

    public Wadjet_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
        if (world.isClientSide) {
            dc = new DynamicChain(this);
        }
        this.setMaxUpStep(1.25F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new InternalMoveGoal(this, false, 1.0D));

    }

    public static AttributeSupplier.Builder wadjet() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.MAX_HEALTH, 75)
                .add(Attributes.ARMOR, 5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "charge") {
            return this.spearchargeAnimationState;
        } else if (input == "magic") {
            return this.magicAnimationState;
        } else if (input == "stabnswing") {
            return this.stabnswingAnimationState;
        } else if (input == "doubleswing") {
            return this.doublswingAnimationState;
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
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.spearchargeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.magicAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.stabnswingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.doublswingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.spearchargeAnimationState.stop();
        this.magicAnimationState.stop();
        this.stabnswingAnimationState.stop();
        this.doublswingAnimationState.stop();
        this.deathAnimationState.stop();
        this.deathAnimationState.stop();
    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(5);
    }

    public int deathtimer() {
        return 30;
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
        }
        prevAttackProgress = AttackProgress;
        if (isAggressive() && AttackProgress < 10F) {
            AttackProgress++;
        }
        if (!isAggressive() && AttackProgress > 0F) {
            AttackProgress--;
        }
        if (nanta_cooldown > 0) nanta_cooldown--;
        if (jump_cooldown > 0) jump_cooldown--;
    }

    public void aiStep() {
        super.aiStep();

    }


    public float getAttackProgress(float partialTicks) {
        return (prevAttackProgress + (AttackProgress - prevAttackProgress) * partialTicks);
    }

    private void Makeparticle(float size, float vec, float math) {
        if (!this.level().isClientSide) {
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = size * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = size * Mth.cos(angle);
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int hitX = Mth.floor(getX() + vec * vecX + extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (block.getRenderShape() != RenderShape.INVISIBLE) {
                    ((ServerLevel) this.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, 1, DeltaMovementX, DeltaMovementY, DeltaMovementZ, 0);
                }
            }
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

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.WADJET_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.WADJET_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return  ModSounds.WADJET_AMBIENT.get();
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

}





