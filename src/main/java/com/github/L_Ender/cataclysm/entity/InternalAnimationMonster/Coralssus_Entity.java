package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.IntFunction;


public class Coralssus_Entity extends Internal_Animation_Monster implements VariantHolder<Coralssus_Entity.Variant> {
    public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Coralssus_Entity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> RIGHT = SynchedEntityData.defineId(Coralssus_Entity.class, EntityDataSerializers.BOOLEAN);
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState angryAnimationState = new AnimationState();
    public AnimationState nantaAnimationState = new AnimationState();
    public AnimationState rightfistAnimationState = new AnimationState();
    public AnimationState leftfistAnimationState = new AnimationState();
    public AnimationState jumpingprepareAnimationState = new AnimationState();
    public AnimationState jumpingAnimationState = new AnimationState();
    public AnimationState jumpingendAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int nanta_cooldown = 0;
    public static final int NANTA_COOLDOWN = 160;

    private int jump_cooldown = 0;
    public static final int JUMP_COOLDOWN = 160;


    public Coralssus_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
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
        this.goalSelector.addGoal(2, new InternalMoveGoal(this,false,1.0D));

        //angry
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,1,2,40,17,6){
            @Override
            public boolean canUse() {
                return super.canUse() && Coralssus_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Coralssus_Entity.this.nanta_cooldown <= 0;
            }
        });

        //nanta
        this.goalSelector.addGoal(1, new InternalStateGoal(this,2,2,0,60,60){
            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.nanta_cooldown = NANTA_COOLDOWN;
            }
        });

        //right fist
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,3,0,30,8,4.5F){
            @Override
            public boolean canUse() {
                return super.canUse() && Coralssus_Entity.this.getIsRight();
            }

            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.setRight(!Coralssus_Entity.this.getIsRight());
            }
        });
        //left fist
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,4,0,30,8,4.5F){

            @Override
            public boolean canUse() {
                return super.canUse() && !Coralssus_Entity.this.getIsRight();
            }

            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.setRight(!Coralssus_Entity.this.getIsRight());
            }
        });
        //jump
        this.goalSelector.addGoal(1, new Coralssus_JumpPrepareAttackGoal(this, 0, 5, 6, 20, 10, 6.5F, 10f, 16F));

        //jump idle
        this.goalSelector.addGoal(1, new InternalStateGoal(this, 6, 6, 7, 100, 100));

        //jump End
        this.goalSelector.addGoal(0, new InternalStateGoal(this, 7, 7, 0, 20, 0){
            @Override
            public void stop() {
                super.stop();
                Coralssus_Entity.this.jump_cooldown = JUMP_COOLDOWN;
            }
        });
    }

    public static AttributeSupplier.Builder coralssus() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 10)
                .add(Attributes.MAX_HEALTH, 160)
                .add(Attributes.ARMOR, 5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "nanta") {
            return this.nantaAnimationState;
        } else if (input == "angry") {
            return this.angryAnimationState;
        } else if (input == "right_fist") {
            return this.rightfistAnimationState;
        } else if (input == "left_fist") {
            return this.leftfistAnimationState;
        } else if (input == "idle") {
                return this.idleAnimationState;
        } else if (input == "jumping_prepare") {
            return this.jumpingprepareAnimationState;
        } else if (input == "jumping") {
            return this.jumpingAnimationState;
        } else if (input == "jumping_end") {
            return this.jumpingendAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        }else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, Coralssus_Entity.Variant.FIRE.id);
        this.entityData.define(RIGHT, false);
    }

    public boolean isSponge() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return s != null && (s.toLowerCase().contains("squarepants")) && this.getVariant() == Variant.HORN;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_, @Nullable CompoundTag p_29682_) {
        this.setVariant(Variant.byId(random.nextInt(3)));
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.angryAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.nantaAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.rightfistAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.leftfistAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.jumpingprepareAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.jumpingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.jumpingendAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.angryAnimationState.stop();
        this.nantaAnimationState.stop();
        this.rightfistAnimationState.stop();
        this.leftfistAnimationState.stop();
        this.jumpingprepareAnimationState.stop();
        this.jumpingAnimationState.stop();
        this.jumpingendAnimationState.stop();
        this.deathAnimationState.stop();
    }



    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(8);
    }

    public int deathtimer(){
        return 30;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getVariant().id);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(Coralssus_Entity.Variant.byId(compound.getInt("Variant")));
    }

    public Coralssus_Entity.Variant getVariant() {
        return Coralssus_Entity.Variant.byId(this.entityData.get(VARIANT));
    }

    public void setVariant(Coralssus_Entity.Variant p_262578_) {
        this.entityData.set(VARIANT, p_262578_.id);
    }


    public void setRight(boolean right) {
        this.entityData.set(RIGHT, right);
    }

    public boolean getIsRight() {
        return this.entityData.get(RIGHT);
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        }
        if (nanta_cooldown > 0) nanta_cooldown--;
        if (jump_cooldown > 0) jump_cooldown--;
    }

    public void aiStep() {
        super.aiStep();

        float f1 = (float) Math.cos(Math.toRadians(this.getYRot() + 90));
        float f2 = (float) Math.sin(Math.toRadians(this.getYRot() + 90));
        if(this.getAttackState() == 2) {
            if (this.attackTicks == 6
                    || this.attackTicks == 16
                    || this.attackTicks == 26
                    || this.attackTicks == 36
                    || this.attackTicks == 46) {
                this.push(f1 * 0.5, 0, f2 * 0.5);
            }
            if (this.attackTicks == 5
                    || this.attackTicks == 30) {
                EarthQuake(3.5f,2);
                Makeparticle(0.5f, 2.5f, 0.2f);
            }
            if ( this.attackTicks == 17 || this.attackTicks == 42) {
                EarthQuake(3.5f,2);
                Makeparticle(0.5f, 2.5f, -0.2f);
            }

        }
        if(this.getAttackState() == 3) {
            if (this.attackTicks == 12) {
                EarthQuake(3.5f,2);
                Makeparticle(0.5f, 2.5f, 0.2f);
            }
        }
        if(this.getAttackState() == 4) {
            if (this.attackTicks == 12) {
                EarthQuake(3.5f,2);
                Makeparticle(0.5f,2.5f,-0.2f);
            }
        }
        if(this.getAttackState()== 6){
            if (this.onGround() || !this.getFeetBlockState().getFluidState().isEmpty()) {
                this.setAttackState(7);
            }
        }
        if(this.getAttackState()== 7){
            if (this.attackTicks == 3) {
                EarthQuake(4.5f,5);
                Makeparticle(0.5f,2.8f,-0.4f);
                Makeparticle(0.5f, 2.8f, 0.4f);
            }
        }


    }

    private void EarthQuake(float grow, int damage) {
        ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.15f, 0, 20);
        this.playSound(SoundEvents.GENERIC_EXPLODE, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(grow))) {
            if (!isAlliedTo(entity) && !(entity instanceof Coralssus_Entity) && entity != this) {
                entity.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + this.random.nextInt(damage));
                launch(entity, true);

            }
        }
    }

    private void launch(LivingEntity e, boolean huge) {

        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.push(d0 / d2 * f, huge ? 0.5D : 0.2F, d1 / d2 * f);
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Coralssus_Entity) && entityHit != this) {
                    entityHit.hurt(this.damageSources().mobAttack(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
                }
            }
        }
    }

    private void Makeparticle(float size,float vec, float math) {
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
                    ((ServerLevel) this.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math,1, DeltaMovementX, DeltaMovementY, DeltaMovementZ,0);
                }
            }
        }
    }

    protected void positionRider(Entity p_289537_, Entity.MoveFunction p_289541_) {
        super.positionRider(p_289537_, p_289541_);
        float f = 0.5F;
        Vec3 vec3 = (new Vec3(0.0D, 0.0D, (double)f)).yRot(-this.yBodyRot * ((float)Math.PI / 180F));
        p_289541_.accept(p_289537_, this.getX() + vec3.x, this.getY(0.65D) + p_289537_.getMyRidingOffset() + 0.0D, this.getZ() + vec3.z);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_THE_LEVIATHAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return super.getHurtSound(damageSourceIn);
    }

    protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }

    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
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

    public static enum Variant implements StringRepresentable {
        FIRE(0, "fire"),
        HORN(1, "horn"),
        TUBE(2, "tube");

        private static final IntFunction<Coralssus_Entity.Variant> BY_ID = ByIdMap.sparse(Coralssus_Entity.Variant::id, values(), FIRE);
        public static final Codec<Coralssus_Entity.Variant> CODEC = StringRepresentable.fromEnum(Coralssus_Entity.Variant::values);
        final int id;
        private final String name;

        private Variant(int p_262657_, String p_262679_) {
            this.id = p_262657_;
            this.name = p_262679_;
        }

        public String getSerializedName() {
            return this.name;
        }

        public int id() {
            return this.id;
        }

        public static Coralssus_Entity.Variant byId(int p_262665_) {
            return BY_ID.apply(p_262665_);
        }
    }


    class Coralssus_JumpPrepareAttackGoal extends InternalAttackGoal {
        private final float attackminrange;
        private final float random;

        public Coralssus_JumpPrepareAttackGoal(Coralssus_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackminrange,float attackrange,float random) {
            super(entity,getattackstate,attackstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.attackminrange = attackminrange;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random && Coralssus_Entity.this.jump_cooldown <= 0;
        }
        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (this.entity.attackTicks == 13) {
                if (target != null) {
                    this.entity.getLookControl().setLookAt(target, 60.0F, 30.0F);
                    Vec3 vec3 = (new Vec3(target.getX() - this.entity.getX(), target.getY() - this.entity.getY(), target.getZ() - this.entity.getZ())).normalize();
                    this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(vec3.x * 0.8D, 1.0D, vec3.z * 0.8D));
                }else{
                    this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0F, 1.0D, 0.0F));
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}





