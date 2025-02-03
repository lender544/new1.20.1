package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster;

import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.L_Ender.cataclysm.entity.AI.MobAILeaveWater;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.*;
import com.github.L_Ender.cataclysm.entity.etc.path.GroundPathNavigatorWide;
import com.github.L_Ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.IntFunction;


public class Coralssus_Entity extends Internal_Animation_Monster implements VariantHolder<Coralssus_Entity.Variant>, ISemiAquatic {
    private static final EntityDataAccessor<Integer> MOISTNESS = SynchedEntityData.defineId(Coralssus_Entity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Coralssus_Entity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> RIGHT = SynchedEntityData.defineId(Coralssus_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CORALSSUS_SWIM = SynchedEntityData.defineId(Coralssus_Entity.class, EntityDataSerializers.BOOLEAN);
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
    private int moistureAttackTime = 0;
    private int jump_cooldown = 0;
    public static final int JUMP_COOLDOWN = 160;
    private boolean isLandNavigator;
    boolean searchingForLand;


    public Coralssus_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;

        this.moveControl = new CoralssusMoveControl(this,2.5f);
        switchNavigator(false);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(6, new CoralssusswimUpGoal(this, 1.0D, this.level().getSeaLevel()));
        this.goalSelector.addGoal(4, new MobAIFindWater(this,1.0D));
        this.goalSelector.addGoal(4, new MobAILeaveWater(this));
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
                return super.canUse() && Coralssus_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Coralssus_Entity.this.nanta_cooldown <= 0 && !Coralssus_Entity.this.getSwim();
            }
            @Override
            public void start() {
                super.start();
                Coralssus_Entity.this.playSound(ModSounds.CORALSSUS_ROAR.get(), 1.0f, 1F + Coralssus_Entity.this.getRandom().nextFloat() * 0.1F);
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
        this.goalSelector.addGoal(1, new Coralssus_JumpPrepareAttackGoal(this, 0,5, 6, 20, 10, 6.5F, 10f, 16F){

            @Override
            public boolean canUse() {
                return super.canUse() && !Coralssus_Entity.this.getSwim();
            }
        });

        //jump idle
        this.goalSelector.addGoal(1, new InternalStateGoal(this, 6,6,7, 100, 100));

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
                .add(Attributes.STEP_HEIGHT, 1.25F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }


    protected int decreaseAirSupply(int air) {
        return air;
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
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(MOISTNESS, 40000);
        p_326229_.define(VARIANT, Variant.FIRE.id);
        p_326229_.define(RIGHT, false);
        p_326229_.define(CORALSSUS_SWIM, false);
    }

    public boolean isSponge() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return s != null && (s.toLowerCase().contains("squarepants")) && this.getVariant() == Variant.HORN;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_) {
        this.setVariant(Variant.byId(random.nextInt(3)));
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_);
    }


    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
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
        compound.putInt("Moisture", this.getMoistness());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(Variant.byId(compound.getInt("Variant")));
        this.setMoistness(compound.getInt("Moisture"));
    }

    public int getMoistness() {
        return this.entityData.get(MOISTNESS);
    }

    public void setMoistness(int p_211137_1_) {
        this.entityData.set(MOISTNESS, p_211137_1_);
    }

    public Variant getVariant() {
        return Variant.byId(this.entityData.get(VARIANT));
    }

    public void setVariant(Variant p_262578_) {
        this.entityData.set(VARIANT, p_262578_.id);
    }


    public void setRight(boolean right) {
        this.entityData.set(RIGHT, right);
    }

    public boolean getIsRight() {
        return this.entityData.get(RIGHT);
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

    public void tick() {
        super.tick();
        if (isInWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!isInWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }

        if (this.isNoAi()) {
            this.setAirSupply(this.getMaxAirSupply());
        } else {
            if (this.isInWaterRainOrBubble()) {
                this.setMoistness(6000);
            } else {
                int dry = this.level().isDay() ? 2 : 1;
                this.setMoistness(this.getMoistness() - dry);
                if (this.getMoistness() <= 0 && moistureAttackTime-- <= 0) {
                    this.hurt(damageSources().dryOut(), random.nextInt(2) == 0 ? 1.0F : 0F);
                    moistureAttackTime = 20;
                }
            }
        }

        boolean flag1 = this.canInFluidType(this.getEyeInFluidType());

        if(flag1){
            if(this.level().noCollision(this, this.getBoundingBox())) {
                if (!this.getSwim()) {
                    setSwim(true);
                }
            }
        }else{
            if(this.level().noCollision(this, this.getBoundingBox())) {
                if (this.getSwim()) {
                    setSwim(false);
                }
            }
        }

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
                EarthQuake(3.5f,2,60);
                Makeparticle(0.5f, 3.15f, 0.2f);
            }
            if (this.attackTicks == 17) {
                EarthQuake(3.5f,2,60);
                Makeparticle(0.5f, 3.15f, -0.2f);
            }
            if (this.attackTicks == 42) {
                EarthQuake(3.5f,2,60);
                Makeparticle(0.5f, 3.15f, -0.2f);
                BlockBreaking();
            }

        }
        if(this.getAttackState() == 3) {
            if (this.attackTicks == 12) {
                EarthQuake(3.5f,2,0);
                Makeparticle(0.5f, 2.8f, 0.2f);
            }
        }
        if(this.getAttackState() == 4) {
            if (this.attackTicks == 12) {
                EarthQuake(3.5f,2,0);
                Makeparticle(0.5f,2.8f,-0.2f);
            }
        }
        if(this.getAttackState()== 6){
            if (this.onGround() || !this.getInBlockState().getFluidState().isEmpty()) {
                this.setAttackState(7);
            }
        }
        if(this.getAttackState()== 7){
            if (this.attackTicks == 3) {
                EarthQuake(4.5f,5,120);
                Makeparticle(0.5f,3.1f,-0.4f);
                Makeparticle(0.5f, 3.1f, 0.4f);
            }
        }


    }

    private void EarthQuake(float grow, int damage, int shieldbreakticks) {
        ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.15f, 0, 20);
        this.playSound(ModSounds.EXPLOSION.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(grow))) {
            if (!isAlliedTo(entity) && !(entity instanceof Coralssus_Entity) && entity != this) {
                launch(entity, true);
                DamageSource damagesource = this.damageSources().mobAttack(this);
                entity.hurt(damagesource, (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + this.random.nextInt(damage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
            }
        }
    }

    private void BlockBreaking() {
        boolean flag = false;
        if (!this.level().isClientSide) {
            if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
            AABB aabb = this.getBoundingBox().inflate(1.5D, 1.5D, 1.5D);
            for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && blockstate.is(ModTag.CORALSSUS_BREAK) && net.neoforged.neoforge.event.EventHooks.onEntityDestroyBlock(this, blockpos, blockstate)) {
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
        }
    }

    private void launch(LivingEntity e, boolean huge) {

        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.push(d0 / d2 * f, huge ? 0.5D : 0.2F, d1 / d2 * f);
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

    protected void positionRider(Entity p_289537_, MoveFunction p_289541_) {
        super.positionRider(p_289537_, p_289541_);
        float f = 0.5F;

        Vec3 vec3 = this.getPassengerRidingPosition(p_289537_);
        Vec3 vec31 = p_289537_.getVehicleAttachmentPoint(this);

        Vec3 vec32 = (new Vec3(0.0D, 0.0D, (double)f)).yRot(-this.yBodyRot * ((float)Math.PI / 180F));
        p_289541_.accept(p_289537_, vec3.x - vec31.x  + vec32.x, this.getY(0.75D) , vec3.z - vec31.z + vec32.z);
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
        return ModSounds.CORALSSUS_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.CORALSSUS_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return  ModSounds.CORALSSUS_AMBIENT.get();
    }


    private boolean canInFluidType(FluidType type) {
        NeoForgeMod.WATER_TYPE.value();
        return type.canSwim(self());
    }

    public boolean isVisuallySwimming() {
        return this.getSwim();
    }

    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.navigation = new GroundPathNavigatorWide(this, level());
            this.isLandNavigator = true;
        } else {
            this.navigation = new SemiAquaticPathNavigator(this, level());
            this.isLandNavigator = false;
        }
    }

    public boolean getSwim() {
        return this.entityData.get(CORALSSUS_SWIM);
    }

    public void setSwim(boolean swim) {
        this.entityData.set(CORALSSUS_SWIM, swim);
    }


    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }

    @Override
    public boolean shouldEnterWater() {
        return getMoistness() < 300;
    }

    @Override
    public boolean shouldLeaveWater() {
        return this.getTarget() != null && !this.getTarget().isInWater();
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 32;

    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
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

    protected boolean closeToNextPos() {
        Path path = this.getNavigation().getPath();
        if (path != null) {
            BlockPos blockpos = path.getTarget();
            if (blockpos != null) {
                double d0 = this.distanceToSqr((double)blockpos.getX(), (double)blockpos.getY(), (double)blockpos.getZ());
                if (d0 < 4.0D) {
                    return true;
                }
            }
        }
        return false;
    }


    public void setSearchingForLand(boolean p_32399_) {
        this.searchingForLand = p_32399_;
    }

    public static enum Variant implements StringRepresentable {
        FIRE(0, "fire"),
        HORN(1, "horn"),
        TUBE(2, "tube");

        private static final IntFunction<Variant> BY_ID = ByIdMap.sparse(Variant::id, values(), FIRE);
        public static final Codec<Variant> CODEC = StringRepresentable.fromEnum(Variant::values);
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

        public static Variant byId(int p_262665_) {
            return BY_ID.apply(p_262665_);
        }
    }


    class Coralssus_JumpPrepareAttackGoal extends InternalAttackGoal {
        private final float attackminrange;
        private final float random;

        public Coralssus_JumpPrepareAttackGoal(Coralssus_Entity entity, int attackstate, int attackendstate,int animationendstate,int attackMaxtick,int attackseetick,float attackminrange,float attackrange,float random) {
            super(entity,attackstate,attackendstate,animationendstate,attackMaxtick,attackseetick,attackrange);
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

    static class CoralssusswimUpGoal extends Goal {
        private final Coralssus_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public CoralssusswimUpGoal(Coralssus_Entity p_32440_, double p_32441_, int p_32442_) {
            this.drowned = p_32440_;
            this.speedModifier = p_32441_;
            this.seaLevel = p_32442_;
        }

        public boolean canUse() {
            return (this.drowned.level().isRaining() || this.drowned.isInWater())&& this.drowned.getY() < (double)(this.seaLevel - 2);
        }

        public boolean canContinueToUse() {
            return this.canUse() && !this.stuck;
        }

        public void tick() {
            if (this.drowned.getY() < (double)(this.seaLevel - 1) && (this.drowned.getNavigation().isDone() || this.drowned.closeToNextPos())) {
                Vec3 vec3 = DefaultRandomPos.getPosTowards(this.drowned, 4, 8, new Vec3(this.drowned.getX(), (double)(this.seaLevel - 1), this.drowned.getZ()), (double)((float)Math.PI / 2F));
                if (vec3 == null) {
                    this.stuck = true;
                    return;
                }

                this.drowned.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
            }

        }

        public void start() {
            this.drowned.setSearchingForLand(true);
            this.stuck = false;
        }

        public void stop() {
            this.drowned.setSearchingForLand(false);
        }
    }


    static class CoralssusMoveControl extends MoveControl {
        private final Coralssus_Entity drowned;
        private final float speedMulti;

        public CoralssusMoveControl(Coralssus_Entity p_32433_, float speedMulti) {
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





