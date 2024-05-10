package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMEntityMoveHelper;
import com.github.L_Ender.cataclysm.entity.etc.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.EarthQuake_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;


public class Amethyst_Crab_Entity extends Boss_monster implements NeutralMob {
    public static final Animation CRAB_SMASH = Animation.create(53);
    public static final Animation CRAB_SMASH_THREE = Animation.create(77);
    public static final Animation CRAB_DEATH = Animation.create(114);
    public static final Animation CRAB_BURROW = Animation.create(65);
    public static final Animation CRAB_BITE = Animation.create(48);
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private int remainingPersistentAngerTime;

    public static final int BURROW_ATTACK_COOLDOWN = 240;
    private int burrow_cooldown = 0;

    @Nullable
    private UUID persistentAngerTarget;

    public Amethyst_Crab_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 50;
        this.setMaxUpStep(1.5F);
        moveControl = new CMEntityMoveHelper(this, 45);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        setConfigattribute(this, CMConfig.AmethystCrabHealthMultiplier, CMConfig.AmethystCrabDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, CRAB_SMASH,CRAB_SMASH_THREE,CRAB_DEATH,CRAB_BURROW,CRAB_BITE};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new CrabMoveGoal(this, false, 1.0D));
        this.goalSelector.addGoal(0, new CrabSmashGoal(this, CRAB_SMASH));
        this.goalSelector.addGoal(0, new CrabAttack(this, CRAB_SMASH_THREE,10));
        this.goalSelector.addGoal(0, new CrabBurrow(this, CRAB_BURROW));
        this.goalSelector.addGoal(0, new CrabAttack(this, CRAB_BITE,17));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

    }

    public static AttributeSupplier.Builder amethyst_crab() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 13)
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }


    protected int decreaseAirSupply(int air) {
        return air;
    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }


    public boolean isKrusty() {
        String s = ChatFormatting.stripFormatting(this.getName().getString());
        return s != null && (s.toLowerCase().contains("eugene harold krabs") || s.toLowerCase().contains("mr.krabs"));
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (this.getAnimation() == CRAB_BURROW) {
            if(this.getAnimationTick() > 9 && this.getAnimationTick() < 52) {
                if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                    this.playSound(SoundEvents.ANVIL_LAND, 0.4F, 2.0F);
                    return false;
                }
            }
        }


        return super.hurt(source, damage);
    }

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        return ModEntities.rollSpawn(CMConfig.AmethystCrabSpawnRolls, this.getRandom(), spawnReasonIn);
    }

    public static boolean canCrabSpawnSpawnRules(EntityType<? extends Amethyst_Crab_Entity> p_219020_, LevelAccessor p_219021_, MobSpawnType p_219022_, BlockPos p_219023_, RandomSource p_219024_) {
        return checkMobSpawnRules(p_219020_, p_219021_, p_219022_, p_219023_, p_219024_);
    }

    public void tick() {
        super.tick();
        repelEntities(1.7F, 3.7f, 1.7F, 1.7F);
        if (burrow_cooldown > 0) burrow_cooldown--;
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAnimation() == CRAB_SMASH) {
            if(this.getAnimationTick() == 22){
                AreaAttack(4.0f,4.0f,70,1.25f,120);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                Attackparticle(2.4f,-0.4f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
            }
        }
        if (this.getAnimation() == CRAB_SMASH_THREE) {
            if(this.getAnimationTick() == 16){
                Attackparticle(2.2f,-0.2f);
                EarthQuakeSummon(2.2f,-0.2f);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
            }
            if(this.getAnimationTick() == 36){
                Attackparticle(1.8f,-1.5f);
                EarthQuakeSummon(1.8f,-1.5f);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
            }
            if(this.getAnimationTick() == 56){
                Attackparticle(1.7f,1.3f);
                EarthQuakeSummon(1.7f,1.3f);
                this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
            }
        }
        if (this.getAnimation() == CRAB_BURROW) {
            for (int l = 1; l <= 10; l = l + 3) {
                if (this.getAnimationTick() == l) {
                    BurrowSound();
                    BurrowParticle(0.6f,0.0f,2.0f);
                }
            }
            for (int l = 39; l <= 48; l = l + 3) {
                if (this.getAnimationTick() == l) {
                    BurrowParticle(0.6f, 0.0f, 2.0f);
                    BurrowSound();
                }
            }
        }
        if (this.getAnimation() == CRAB_BITE) {
            if (this.getAnimationTick() == 14) {
                this.playSound(ModSounds.CRAB_BITE.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.getAnimationTick() == 17) {
                AreaAttack(4.5f,4.5f,110,1.25f,120);
            }
        }

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
                if (!(entityHit instanceof Amethyst_Crab_Entity)) {
                 entityHit.hurt(this.damageSources().mobAttack(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage ));
                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
                }
            }
        }
    }

    private void Attackparticle(float vec, float math) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
            float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = 1.0 * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 1.0 * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX+ extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);

            }
            this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 25, 1f, 1f, 1f, 1f, 25f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.3f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
        }
    }

    private void BurrowParticle(float vec, float math, float size) {
        if (this.level().isClientSide) {
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.1D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
                float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
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
                BlockState block = level().getBlockState(hit.below());
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
            }
        }
    }

    private void BurrowSound(){
        float angle = (0.01745329251F * this.yBodyRot);
        double extraX = 1.0 * Mth.sin((float) (Math.PI + angle));
        double extraZ = 1.0 * Mth.cos(angle);
        int hitX = Mth.floor(getX() + extraX);
        int hitY = Mth.floor(getY());
        int hitZ = Mth.floor(getZ() + extraZ);
        BlockPos hit = new BlockPos(hitX, hitY, hitZ);
        BlockState block = level().getBlockState(hit.below());
        SoundType soundtype = block.getSoundType(level(), hit, this);
        this.level().playSound((Player) null, this, soundtype.getBreakSound(), SoundSource.HOSTILE, 3.0f, 0.8F + this.getRandom().nextFloat() * 0.1F);
    }

    private void EarthQuakeSummon(float vec, float math) {
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        final int quakeCount = 16;
        float angle = 360.0F / quakeCount;
        for (int i = 0; i < quakeCount; i++) {
            EarthQuake_Entity peq = new EarthQuake_Entity(this.level(), this);
            peq.setDamage((float) CMConfig.AmethystCrabEarthQuakeDamage);
            peq.shootFromRotation(this, 0, angle * i, 0.0F, 0.25F, 0.0F);
            peq.setPos(this.getX() + vec * vecX + f * math, this.getY(), getZ() + vec * vecZ + f1 * math);
            this.level().addFreshEntity(peq);

        }
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return CRAB_DEATH;
    }


    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.CRAB_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.CRAB_DEATH.get();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public void setRemainingPersistentAngerTime(int p_32515_) {
        this.remainingPersistentAngerTime = p_32515_;
    }

    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    public void setPersistentAngerTarget(@javax.annotation.Nullable UUID p_32509_) {
        this.persistentAngerTarget = p_32509_;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }


    static class CrabMoveGoal extends Goal {
        private final Amethyst_Crab_Entity crab;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private int delayCounter;
        protected final double moveSpeed;


        public CrabMoveGoal(Amethyst_Crab_Entity boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
            this.crab = boss;
            this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
            this.moveSpeed = moveSpeed;
            this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
        }


        public boolean canUse() {
            LivingEntity target = this.crab.getTarget();
            return target != null && target.isAlive() && this.crab.getAnimation() == IAnimatedEntity.NO_ANIMATION;
        }


        public void stop() {
            crab.getNavigation().stop();
            LivingEntity livingentity = this.crab.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
                this.crab.setTarget((LivingEntity)null);
            }
            this.crab.setAggressive(false);
            this.crab.getNavigation().stop();
        }

        public boolean canContinueToUse() {
            LivingEntity target = this.crab.getTarget();
            if (target == null) {
                return false;
            } else if (!target.isAlive()) {
                return false;
            } else if (!this.followingTargetEvenIfNotSeen) {
                return !this.crab.getNavigation().isDone();
            } else if (!this.crab.isWithinRestriction(target.blockPosition())) {
                return false;
            } else {
                return !(target instanceof Player) || !target.isSpectator() && !((Player)target).isCreative();
            }
        }

        public void start() {
            this.crab.getNavigation().moveTo(this.path, this.moveSpeed);
            this.crab.setAggressive(true);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.crab.getTarget();
            if(target != null){
                crab.getLookControl().setLookAt(target, 30.0F, 30.0F);
                double distSq = this.crab.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
                if (--this.delayCounter <= 0) {
                    this.delayCounter = 4 + this.crab.getRandom().nextInt(7);
                    if (distSq > Math.pow(this.crab.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0D)) {
                        if (!this.crab.isPathFinding()) {
                            if (!this.crab.getNavigation().moveTo(target, 1.0D)) {
                                this.delayCounter += 5;
                            }
                        }
                    } else {
                        this.crab.getNavigation().moveTo(target, this.moveSpeed);
                    }
                }
                if(target.isAlive()) {
                    if (this.crab.getAnimation() == NO_ANIMATION) {
                        if (this.crab.burrow_cooldown <= 0 && this.crab.getRandom().nextFloat() * 100.0F < 6f && this.crab.distanceTo(target) <= 8.0D) {
                            this.crab.setAnimation(CRAB_BURROW);
                        } else if (this.crab.getRandom().nextFloat() * 100.0F < 24f && this.crab.distanceTo(target) <= 3.75D) {
                            if(this.crab.random.nextInt(2) == 0) {
                                this.crab.setAnimation(CRAB_BITE);
                            }else{
                                this.crab.setAnimation(CRAB_SMASH);
                            }
                        } else if (this.crab.getRandom().nextFloat() * 100.0F < 16f && this.crab.distanceTo(target) <= 3.75D && target.onGround()) {
                            this.crab.setAnimation(CRAB_SMASH_THREE);
                        }
                    }
                }
            }
        }
    }

    static class CrabSmashGoal extends SimpleAnimationGoal<Amethyst_Crab_Entity> {


        public CrabSmashGoal(Amethyst_Crab_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE,Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 19 && target != null) {
                entity.lookAt(target, 30, 30);
                entity.getNavigation().moveTo(target, 1.0f);
                entity.getLookControl().setLookAt(target, 30, 30);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if (entity.getAnimationTick() == 19){
                entity.getNavigation().stop();
            }

        }
    }

    static class CrabAttack extends SimpleAnimationGoal<Amethyst_Crab_Entity> {
        private final int look;

        public CrabAttack(Amethyst_Crab_Entity entity, Animation animation , int look) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE,Goal.Flag.JUMP, Goal.Flag.LOOK));
            this.look = look;
        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < look && target != null) {
                entity.lookAt(target, 30, 30);
                entity.getLookControl().setLookAt(target, 30, 30);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }
    }

    static class CrabBurrow extends SimpleAnimationGoal<Amethyst_Crab_Entity> {


        public CrabBurrow(Amethyst_Crab_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE,Goal.Flag.JUMP, Goal.Flag.LOOK));
        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            entity.burrow_cooldown = BURROW_ATTACK_COOLDOWN;
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 48 && target != null) {
                entity.lookAt(target, 30, 30);
                entity.getLookControl().setLookAt(target, 30, 30);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if (entity.getAnimationTick() == 50){
                for (int i = 0; i < 32; i++) {
                    float throwAngle = i * Mth.PI / 16F;

                    double sx = entity.getX() + (Mth.cos(throwAngle) * 1);
                    double sy = entity.getY() + (entity.getBbHeight() * 0.2D);
                    double sz = entity.getZ() + (Mth.sin(throwAngle) * 1);

                    double vx = Mth.cos(throwAngle);
                    double vy = 0 + entity.random.nextFloat() * 0.3F;
                    double vz = Mth.sin(throwAngle);
                    double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                    Amethyst_Cluster_Projectile_Entity projectile = new Amethyst_Cluster_Projectile_Entity(ModEntities.AMETHYST_CLUSTER_PROJECTILE.get(), entity.level(), entity);

                    projectile.moveTo(sx, sy, sz, i * 11.25F, entity.getXRot());
                    float speed = 0.8F;
                    projectile.shoot(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                    entity.level().addFreshEntity(projectile);
                }
            }
        }
    }
}





