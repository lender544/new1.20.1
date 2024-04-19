package com.github.L_Ender.cataclysm.entity.Deepling;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.CmAttackGoal;
import com.github.L_Ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.L_Ender.cataclysm.entity.AI.MobAILeaveWater;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AttackAnimationGoal1;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Boss_monster;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.*;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.world.data.CMWorldData;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
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
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.util.EnumSet;


public class Coral_Golem_Entity extends Boss_monster implements ISemiAquatic {
    private boolean isLandNavigator;
    boolean searchingForLand;
    public static final Animation CORAL_GOLEM_LEAP = Animation.create(100);
    public static final Animation CORAL_GOLEM_SMASH = Animation.create(23);
    public static final Animation CORAL_GOLEM_LEFT_SMASH = Animation.create(36);
    public static final Animation CORAL_GOLEM_RIGHT_SMASH = Animation.create(36);
    public static final int LEAP_ATTACK_COOLDOWN = 160;
    private int leap_attack_cooldown = 0;

    private static final EntityDataAccessor<Boolean> GOLEMSWIM = SynchedEntityData.defineId(Coral_Golem_Entity.class, EntityDataSerializers.BOOLEAN);


    public Coral_Golem_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 15;
        this.setMaxUpStep(1.5F);
        this.moveControl = new GolemMoveControl(this,2.0f);
        switchNavigator(false);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION,CORAL_GOLEM_SMASH,CORAL_GOLEM_LEFT_SMASH,CORAL_GOLEM_RIGHT_SMASH,CORAL_GOLEM_LEAP};
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new GolemGoToBeachGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new GolemSwimUpGoal(this, 1.0D, this.level().getSeaLevel()));
        this.goalSelector.addGoal(4, new MobAIFindWater(this,1.0D));
        this.goalSelector.addGoal(4, new MobAILeaveWater(this));
        this.goalSelector.addGoal(0, new AttackAnimationGoal1<>(this, CORAL_GOLEM_LEFT_SMASH, 16, true));
        this.goalSelector.addGoal(0, new AttackAnimationGoal1<>(this, CORAL_GOLEM_RIGHT_SMASH, 16, true));
        this.goalSelector.addGoal(0, new Leap(this, CORAL_GOLEM_LEAP));
        this.goalSelector.addGoal(0, new SimpleAnimationGoal<>(this, CORAL_GOLEM_SMASH));
        this.goalSelector.addGoal(2, new CmAttackGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder coralgolem() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 11)
                .add(Attributes.MAX_HEALTH, 110)
                .add(Attributes.ARMOR, 5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8);
    }


    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    @Override
    public boolean hurt(DamageSource source, float damage) {
        return super.hurt(source, damage);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(GOLEMSWIM, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);


    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

    }

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        if (ModEntities.rollSpawn(CMConfig.CoralgolemSpawnRolls, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerLevel serverLevel) {
            CMWorldData data = CMWorldData.get(serverLevel,Level.OVERWORLD);
            return data != null && data.isLeviathanDefeatedOnce();
        }
        return false;
    }

    public boolean checkSpawnObstruction(LevelReader p_32829_) {
        return p_32829_.isUnobstructed(this);
    }

    public static boolean cangolemSpawn(EntityType<Coral_Golem_Entity> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource p_223364_4_) {
        return p_223364_1_.getDifficulty() != Difficulty.PEACEFUL && (reason == MobSpawnType.SPAWNER || p_223364_1_.getFluidState(p_223364_3_).is(FluidTags.WATER));
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


        if (leap_attack_cooldown > 0) leap_attack_cooldown--;
        LivingEntity target = this.getTarget();
        if (this.isAlive()) {
            if (target != null && target.isAlive()) {
                if (!this.getSwim() &&leap_attack_cooldown <= 0 && !isNoAi() && this.getAnimation() == NO_ANIMATION && target.onGround() && (this.random.nextInt(25) == 0 && this.distanceTo(target) <= 15)) {
                    leap_attack_cooldown = LEAP_ATTACK_COOLDOWN;
                    this.setAnimation(CORAL_GOLEM_LEAP);
                }else if (this.distanceTo(target) < 3.75f && !isNoAi() && this.getAnimation() == NO_ANIMATION) {
                    Animation animation = getRandomAttack(random);
                    this.setAnimation(animation);
                }
            }
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAnimation() == CORAL_GOLEM_RIGHT_SMASH) {
            if (this.getAnimationTick() == 16) {
                EarthQuake(3.0f,2);
                Makeparticle(2.0f,-0.5f);
            }
        }
        if(this.getAnimation() == CORAL_GOLEM_LEFT_SMASH){
            if (this.getAnimationTick() == 16) {
                EarthQuake(3.0f,2);
                Makeparticle(2.0f,0.5f);
            }
        }
        if(this.getAnimation() == CORAL_GOLEM_SMASH){
            if (this.getAnimationTick() == 2) {
                EarthQuake(4.0f,4);
                Makeparticle(2.25f,1.25f);
                Makeparticle(2.25f,-1.25f);
            }
        }

    }


    private void Makeparticle(float vec, float math) {
        if (this.level().isClientSide) {
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float f = Mth.cos( this.yBodyRot * ((float)Math.PI / 180F)) ;
                float f1 = Mth.sin( this.yBodyRot * ((float)Math.PI / 180F)) ;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = 0.75F * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 0.75F * Mth.cos(angle);
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int hitX = Mth.floor(getX() + vec * vecX+ extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
        }
    }


    protected void positionRider(Entity p_289537_, Entity.MoveFunction p_289541_) {
        super.positionRider(p_289537_, p_289541_);
        float radius = 0.5F;
        float angle = (0.01745329251F * this.yBodyRot);
        double extraX = radius * Mth.sin((float) (Math.PI + angle));
        double extraZ = radius * Mth.cos(angle);
        p_289541_.accept(p_289537_, this.getX() + extraX, this.getY(0.65D) + p_289537_.getMyRidingOffset() + 0.0D, this.getZ()+ extraZ);

    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }


    private void EarthQuake(float grow, int damage) {
        ScreenShake_Entity.ScreenShake(level(), this.position(), 10, 0.15f, 0, 20);
        this.playSound(SoundEvents.GENERIC_EXPLODE, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(grow))) {
            if (!isAlliedTo(entity) && !(entity instanceof Coral_Golem_Entity) && entity != this) {
                entity.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + this.random.nextInt(damage));
                launch(entity, true);

            }
        }
    }


    private static Animation getRandomAttack(RandomSource rand) {
        switch (rand.nextInt(2)) {
            case 0:
                return CORAL_GOLEM_RIGHT_SMASH;
            case 1:
                return CORAL_GOLEM_LEFT_SMASH;
        }
        return CORAL_GOLEM_RIGHT_SMASH;
    }



    private void launch(LivingEntity e, boolean huge) {

        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.push(d0 / d2 * f, huge ? 0.5D : 0.2F, d1 / d2 * f);
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



    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 1.0F, 1.0F);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.CORAL_GOLEM_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.CORAL_GOLEM_DEATH.get();
    }

    private boolean canInFluidType(FluidType type) {
        ForgeMod.WATER_TYPE.get();
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
        return this.entityData.get(GOLEMSWIM);
    }

    public void setSwim(boolean swim) {
        this.entityData.set(GOLEMSWIM, swim);
    }


    public MobType getMobType() {
        return MobType.WATER;
    }


    public boolean isPushedByFluid() {
        return !this.isSwimming();
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean shouldEnterWater() {
        return false;
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

    static class GolemGoToBeachGoal extends MoveToBlockGoal {
        private final Coral_Golem_Entity drowned;

        public GolemGoToBeachGoal(Coral_Golem_Entity p_32409_, double p_32410_) {
            super(p_32409_, p_32410_, 8, 2);
            this.drowned = p_32409_;
        }

        public boolean canUse() {
            return super.canUse() && this.drowned.level().isRaining() && this.drowned.isInWater() && this.drowned.getY() >= (double)(this.drowned.level().getSeaLevel() - 3);
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse();
        }

        protected boolean isValidTarget(LevelReader p_32413_, BlockPos p_32414_) {
            BlockPos blockpos = p_32414_.above();
            return p_32413_.isEmptyBlock(blockpos) && p_32413_.isEmptyBlock(blockpos.above()) ? p_32413_.getBlockState(p_32414_).entityCanStandOn(p_32413_, p_32414_, this.drowned) : false;
        }

        public void start() {
            this.drowned.setSearchingForLand(false);
            // this.drowned.switchNavigator(true);
            super.start();
        }

        public void stop() {
            super.stop();
        }
    }

    static class GolemSwimUpGoal extends Goal {
        private final Coral_Golem_Entity drowned;
        private final double speedModifier;
        private final int seaLevel;
        private boolean stuck;

        public GolemSwimUpGoal(Coral_Golem_Entity p_32440_, double p_32441_, int p_32442_) {
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

    static class Leap extends SimpleAnimationGoal<Coral_Golem_Entity> {
        private final Coral_Golem_Entity drowned;

        public Leap(Coral_Golem_Entity entity, Animation animation) {
            super(entity, animation);
            this.drowned = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = this.drowned.getTarget();;
            if (target != null) {
                this.drowned.lookAt(target, 30.0F, 30.0F);
                this.drowned.getLookControl().setLookAt(target, 30.0F, 30.0F);
                if(this.drowned.getAnimationTick() == 22) {
                    double d0 = target.getX() - this.drowned.getX();
                    double d1 = target.getY() - this.drowned.getY();
                    double d2 = target.getZ() - this.drowned.getZ();
                    this.drowned.setDeltaMovement(d0 * 0.15D, 0.75 + Mth.clamp(d1 * 0.05D, 0, 10), d2 * 0.15D);
                }
            }else{
                if(this.drowned.getAnimationTick() == 22) {
                    this.drowned.setDeltaMovement(0, 0.75, 0);
                }
            }

            if (this.drowned.getAnimationTick() > 22 && this.drowned.onGround()) {
                AnimationHandler.INSTANCE.sendAnimationMessage(this.drowned, CORAL_GOLEM_SMASH);
            }

        }
    }

    static class GolemMoveControl extends MoveControl {
        private final Coral_Golem_Entity drowned;
        private final float speedMulti;

        public GolemMoveControl(Coral_Golem_Entity p_32433_, float speedMulti) {
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





