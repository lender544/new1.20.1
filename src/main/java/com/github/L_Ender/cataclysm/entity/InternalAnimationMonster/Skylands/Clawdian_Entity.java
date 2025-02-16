package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands;

import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.lionfishapi.server.animation.LegSolverQuadruped;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
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
import net.minecraft.world.level.pathfinder.PathType;

import java.util.List;


public class Clawdian_Entity extends Internal_Animation_Monster {

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState verticalswingAnimationState = new AnimationState();
    public AnimationState horizontalswingState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public LegSolverQuadruped legSolver = new LegSolverQuadruped(-0.1F, 0.45F, 1.4F, 1.4F, 1);
    private int magic_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 100;



    public Clawdian_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.WadjetHealthMultiplier, CMConfig.WadjetDamageMultiplier);
    }


    protected void registerGoals() {

        this.goalSelector.addGoal(1, new FloatGoal(this));
      //  this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(3, new InternalMoveGoal(this, false, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,2,0,75,49,4.75f){
            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0F < 22f;
            }
        });
        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,1,0,46,19,4.75f){
            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0F < 15;
            }
        });

    }



    public static AttributeSupplier.Builder clawdian() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 18)
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.ARMOR, 12)
                .add(Attributes.ARMOR_TOUGHNESS, 3)
                .add(Attributes.STEP_HEIGHT, 1.75F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
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
        if (input == "idle") {
            return this.idleAnimationState;
        }else if (input == "vertical_swing") {
            return this.verticalswingAnimationState;
        }else if (input == "horizontal_swing") {
            return this.horizontalswingState;
        }else if (input == "death") {
            return this.deathAnimationState;
        } else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }


    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                case 0 -> this.stopAllAnimationStates();
                case 1 -> {
                    this.stopAllAnimationStates();
                    this.verticalswingAnimationState.startIfStopped(this.tickCount);
                }
                case 2 -> {
                    this.stopAllAnimationStates();
                    this.horizontalswingState.startIfStopped(this.tickCount);
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
        this.verticalswingAnimationState.stop();
        this.horizontalswingState.stop();
        this.deathAnimationState.stop();
    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(3);
    }

    public int deathtimer() {
        return 45;
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
            this.idleAnimationState.animateWhen(this.getAttackState() != 7 , this.tickCount);
        }
        this.legSolver.update(this, this.yBodyRot, this.getScale());
    }

    public void aiStep() {
        super.aiStep();


        if(this.getAttackState() == 1) {
            if (this.attackTicks == 22) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 20);
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                this.playSound(ModSounds.EXPLOSION.get(), 2.0f, 0.95F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(8.5f,8.5f,50,1,140,false,false);
                Makeparticle(0.75f, 7.3f, 0.35f);
            }
        }

        if(this.getAttackState() == 2) {
            if (this.attackTicks == 22) {
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(7.5f,7.5f,200,0.9F,100,true,false);
            }

            if (this.attackTicks == 50) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 20);
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                this.playSound(ModSounds.EXPLOSION.get(), 2.0f, 0.95F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(8.5f,8.5f,50,1.15F,160,false,false);
                Makeparticle(0.75f, 7.3f, 0.35f);
            }
        }

    }

    private void Makeparticle(float size,float vec, float math) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = size * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = size * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX + extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = this.level().getBlockState(hit.below());
                if (block.getRenderShape() != RenderShape.INVISIBLE) {
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
            this.level().addParticle(new RingParticleOptions(0f, (float)Math.PI/2f, 30, 255, 255,  255, 1.0f, 20f, false, 2), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }


    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks,boolean knockback, boolean penetrate) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Clawdian_Entity) && entityHit != this) {
                    DamageSource damagesource = penetrate ? CMDamageTypes.causePenetrateDamage(this) :this.damageSources().mobAttack(this);
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
        return p_34192_.getEffect() != ModEffect.EFFECTSTUN && p_34192_.getEffect() != ModEffect.EFFECTABYSSAL_CURSE.get() && super.canBeAffected(p_34192_);
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





