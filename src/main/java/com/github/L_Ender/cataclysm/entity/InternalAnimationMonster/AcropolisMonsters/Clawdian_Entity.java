package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AcropolisMonsters;

import com.github.L_Ender.cataclysm.client.particle.Options.NotSpinTrailParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.HurtByNearestTargetGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Wave_Entity;
import com.github.L_Ender.cataclysm.entity.etc.IHoldEntity;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.L_Ender.cataclysm.entity.projectile.Accretion_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.message.MessageEntityCameraSwitch;
import com.github.L_Ender.lionfishapi.server.animation.LegSolverQuadruped;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;


public class Clawdian_Entity extends Internal_Animation_Monster implements IHoldEntity {
    boolean searchingForLand;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState verticalswingAnimationState = new AnimationState();
    public AnimationState horizontalswingAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState chargeReadyAnimationState = new AnimationState();
    public AnimationState chargeLoopAnimationState = new AnimationState();
    public AnimationState chargeEndAnimationState = new AnimationState();
    public AnimationState waveStompAnimationState = new AnimationState();
    public AnimationState ClawPunchAnimationState = new AnimationState();
    public AnimationState GrabAndThrowAnimationState = new AnimationState();
    public AnimationState BackstepAnimationState = new AnimationState();
    public LegSolverQuadruped legSolver = new LegSolverQuadruped(-0.1F, 0.45F, 1.4F, 1.4F, 1);
    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 200;
    private int wave_cooldown = 0;
    public static final int WAVE_COOLDOWN = 250;
    private int accretion_cooldown = 0;
    public static final int ACCRETION_COOLDOWN = 120;
    private int backstep_cooldown = 0;
    public static final int BACKSTEP_COOLDOWN = 200;
    protected final int NATURE_HEAL_COOLDOWN = 80;
    private int self_regen;
    private static final EntityDataAccessor<Optional<BlockState>> HOLD_STATE = SynchedEntityData.defineId(Clawdian_Entity.class, EntityDataSerializers.OPTIONAL_BLOCK_STATE);
    private static final EntityDataAccessor<Integer> BACKSTEP_METER = SynchedEntityData.defineId(Clawdian_Entity.class, EntityDataSerializers.INT);
    protected final SemiAquaticPathNavigator waterNavigation;
    protected final CMPathNavigateGround groundNavigation;


    public Clawdian_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 100;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0F);
        this.waterNavigation = new SemiAquaticPathNavigator(this, world);
        this.groundNavigation = new CMPathNavigateGround(this, world);
        setConfigattribute(this, CMConfig.ClawdianHealthMultiplier, CMConfig.ClawdianDamageMultiplier);
    }


    protected void registerGoals() {

        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByNearestTargetGoal(this));
        this.goalSelector.addGoal(3, new InternalMoveGoal(this, false, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,8,0,47,19,3.3f){
            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0F < 35;
            }
        });
        //chargePrepare
        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,4,5,30,30,18) {
            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0F < 17f && Clawdian_Entity.this.charge_cooldown <= 0 && this.entity.onGround() && !this.entity.isSwimming();
            }
        });

        this.goalSelector.addGoal(2, new InternalStateGoal(this,5,5,6,45,45){
            @Override
            public void tick() {
                LivingEntity target = entity.getTarget();
                if (entity.attackTicks < attackseetick && target != null) {
                    entity.getLookControl().setLookAt(target, 2.0F, 30.0F);
                    entity.lookAt(target, 2.0F, 30.0F);
                } else {
                    entity.setYRot(entity.yRotO);
                }

                BlockPos currentPos = entity.blockPosition();
                float yaw = entity.getYRot() * ((float) Math.PI / 180F);
                float dx = -Mth.sin(yaw) * 2;
                float dz = Mth.cos(yaw) * 2;

                BlockPos targetPos = currentPos.offset((int) dx, 0, (int) dz);
                if(this.entity.onGround()) {
                    if (!isDangerousFallZone(entity, targetPos)) {
                        Vec3 motion = entity.getDeltaMovement();
                        Vec3 push = new Vec3(-Mth.sin(yaw), motion.y, Mth.cos(yaw)).scale(0.5D).add(motion.scale(0.5D));
                        entity.setDeltaMovement(push.x, motion.y, push.z);
                    }
                }
            }

            private boolean isDangerousFallZone(PathfinderMob mob, BlockPos pos) {
                PathNavigation navigation = mob.getNavigation();
                NodeEvaluator evaluator = navigation.getNodeEvaluator();

                if (evaluator == null) return false;

                PathType type = evaluator.getPathType(mob, pos.mutable());

                int safeDrop = 2;
                BlockPos.MutableBlockPos checkPos = pos.mutable();

                for (int i = 1; i <= safeDrop; i++) {
                    checkPos.move(Direction.DOWN);
                    if (!mob.level().getBlockState(checkPos).isAir()) {
                        return false;
                    }
                }

                return type == PathType.DAMAGE_OTHER
                        || type == PathType.OPEN
                        || type == PathType.DANGER_OTHER;
            }
        });



        this.goalSelector.addGoal(1, new InternalStateGoal(this,6,6,0,10,0) {
            @Override
            public void stop() {
                super.stop();
                Clawdian_Entity.this.charge_cooldown = CHARGE_COOLDOWN;
            }
        });

        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,2,0,75,48,5.5f){
            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0F < 27f;
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
            }

        });
        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,1,0,46,19,5.5f){
            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0F < 30 ;
            }
        });

        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,7,0,53,25,10f){
            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0F < 20 && Clawdian_Entity.this.wave_cooldown <= 0;

            }
            @Override
            public void stop() {
                super.stop();
                Clawdian_Entity.this.wave_cooldown = WAVE_COOLDOWN;
            }

        });
        this.goalSelector.addGoal(2, new Clawdian_Accretion(this,0,9,0,70,30,4.0F,8.5f,46,14));



        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,10,0,34,33,6f){
            @Override
            public boolean canUse() {
                return super.canUse() && Clawdian_Entity.this.getRandom().nextFloat() * 100.0F < 7 * Clawdian_Entity.this.getBackstep() && Clawdian_Entity.this.backstep_cooldown <= 0;
            }

            @Override
            public void tick() {

                LivingEntity target = entity.getTarget();
                if (entity.attackTicks < attackseetick && target != null) {
                    entity.getLookControl().setLookAt(target, 2.0F, 30.0F);
                    entity.lookAt(target, 2.0F, 30.0F);
                } else {
                    entity.setYRot(entity.yRotO);
                }
                if(entity.attackTicks < 24){
                    entity.getMoveControl().strafe(-2.0F, 0.0F);
                }
            }

            @Override
            public void stop() {
                super.stop();
                Clawdian_Entity.this.backstep_cooldown = BACKSTEP_COOLDOWN;
                Clawdian_Entity.this.setBackstep(0);
            }

        });

    }



    public static AttributeSupplier.Builder clawdian() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 16)
                .add(Attributes.MAX_HEALTH, 225)
                .add(Attributes.ARMOR, 12)
                .add(Attributes.ARMOR_TOUGHNESS, 3)
                .add(Attributes.STEP_HEIGHT, 2.5F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }



    protected void blockedByShield(LivingEntity entity) {
        if (this.getAttackState() == 8) {
            double d0 = entity.getX() - this.getX();
            double d1 = entity.getZ() - this.getZ();
            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001);
            entity.push(d0 / d2 * (double)9.0F, 0.2, d1 / d2 * (double)9.0F);

            entity.hurtMarked = true;
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

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isControlledByLocalInstance() && this.isInWater() && this.wantsToSwim()) {
            this.moveRelative(0.01F, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
        } else {
            super.travel(travelVector);
        }
    }

    @Override
    public void updateSwimming() {
        if (!this.level().isClientSide) {
            if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
                this.navigation = this.waterNavigation;
                this.moveControl = new ClawdianSwimControl(this, 6.0f);
                this.setSwimming(true);
            } else {
                this.navigation = this.groundNavigation;
                this.moveControl = new ClawdianMoveController(this);
                this.setSwimming(false);
            }
        }
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (this.canBlockDamageSource(source)) {
            this.playSound(ModSounds.PARRY.get(),0.2F,1.4F);
            return false;
        }
        if (!this.getPassengers().isEmpty()) {
            Entity rider = this.getPassengers().get(0);
            if (rider.equals(entity)) {
                return false;
            }
        }
        if (source.is(ModTag.BLOCK_SELF_REGEN)) {
            self_regen = NATURE_HEAL_COOLDOWN;
        }
        boolean flag = super.hurt(source, damage);
        if(flag) {
            if (this.getBackstep() < 10) {
                this.setBackstep(this.getBackstep() + 1);
            }
        }

        return flag;
    }


    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        boolean flag = false;

        if (!damageSourceIn.is(DamageTypeTags.BYPASSES_SHIELD) && !flag && this.getAttackState() == 5) {
            Vec3 vector3d2 = damageSourceIn.getSourcePosition();
            if (vector3d2 != null) {
                Vec3 vector3d = this.getViewVector(1.0F);
                Vec3 vector3d1 = vector3d2.vectorTo(this.position()).normalize();
                vector3d1 = new Vec3(vector3d1.x, 0.0D, vector3d1.z);
                return vector3d1.dot(vector3d) < 0.0D;
            }
        }
        return false;
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
            return this.horizontalswingAnimationState;
        }else if (input == "charge_ready") {
            return this.chargeReadyAnimationState;
        }else if (input == "charge_loop") {
            return this.chargeLoopAnimationState;
        }else if (input == "charge_end") {
            return this.chargeEndAnimationState;
        }else if (input == "death") {
            return this.deathAnimationState;
        }else if (input == "wave_stomp") {
            return this.waveStompAnimationState;
        }else if (input == "claw_punch") {
            return this.ClawPunchAnimationState;
        }else if (input == "grab_and_throw") {
            return this.GrabAndThrowAnimationState;
        }else if (input == "backstep") {
            return this.BackstepAnimationState;
        } else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(HOLD_STATE, Optional.empty());
        p_326229_.define(BACKSTEP_METER, 0);
    }


    public void setHoldBlock(@Nullable BlockState state) {
        this.entityData.set(HOLD_STATE, Optional.ofNullable(state));
    }

    @Nullable
    public BlockState getHoldBlock() {
        return (BlockState)((Optional)this.entityData.get(HOLD_STATE)).orElse((Object)null);
    }

    public int getBackstep() {
        return this.entityData.get(BACKSTEP_METER);
    }

    public void setBackstep(int hurt) {
        this.entityData.set(BACKSTEP_METER, hurt);
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
                    this.horizontalswingAnimationState.startIfStopped(this.tickCount);
                }
                case 3 -> {
                    this.stopAllAnimationStates();
                    this.deathAnimationState.startIfStopped(this.tickCount);
                }
                case 4 -> {
                    this.stopAllAnimationStates();
                    this.chargeReadyAnimationState.startIfStopped(this.tickCount);
                }
                case 5 -> {
                    this.stopAllAnimationStates();
                    this.chargeLoopAnimationState.startIfStopped(this.tickCount);
                }
                case 6 -> {
                    this.stopAllAnimationStates();
                    this.chargeEndAnimationState.startIfStopped(this.tickCount);
                }
                case 7 -> {
                    this.stopAllAnimationStates();
                    this.waveStompAnimationState.startIfStopped(this.tickCount);
                }
                case 8 -> {
                    this.stopAllAnimationStates();
                    this.ClawPunchAnimationState.startIfStopped(this.tickCount);
                }
                case 9 -> {
                    this.stopAllAnimationStates();
                    this.GrabAndThrowAnimationState.startIfStopped(this.tickCount);
                }
                case 10 -> {
                    this.stopAllAnimationStates();
                    this.BackstepAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.verticalswingAnimationState.stop();
        this.horizontalswingAnimationState.stop();
        this.deathAnimationState.stop();
        this.chargeReadyAnimationState.stop();
        this.chargeLoopAnimationState.stop();
        this.chargeEndAnimationState.stop();
        this.waveStompAnimationState.stop();
        this.ClawPunchAnimationState.stop();
        this.GrabAndThrowAnimationState.stop();
        this.BackstepAnimationState.stop();
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
        BlockState blockstate = this.getHoldBlock();
        if (blockstate != null) {
            compound.put("holdBlockState", NbtUtils.writeBlockState(blockstate));
        }
        compound.putInt("backstep", getBackstep());
    }


    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        BlockState blockstate = null;
        if (compound.contains("holdBlockState", 10)) {
            blockstate = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), compound.getCompound("holdBlockState"));
            if (blockstate.isAir()) {
                blockstate = null;
            }
        }

        this.setHoldBlock(blockstate);
        this.setBackstep(compound.getInt("backstep"));
    }

    public float NatureRegen() {
        return (float) (25F * CMConfig.ClawdianHealthMultiplier);
    }

    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }else {
            LivingEntity target = this.getTarget();
            if (!isNoAi()) {
                if (self_regen <= 0) {
                    if (!isNoAi() && this.NatureRegen() > 0 && target == null) {
                        if (this.tickCount % 20 == 0) {
                            this.heal(this.NatureRegen());
                        }
                    }
                }
            }
        }
        if (self_regen > 0) self_regen--;

        if (charge_cooldown > 0) charge_cooldown--;
        if (wave_cooldown > 0) wave_cooldown--;
        if (accretion_cooldown > 0) accretion_cooldown--;
        if (backstep_cooldown > 0) backstep_cooldown--;
        this.legSolver.update(this, this.yBodyRot, this.getScale());
        float dis = this.getBbWidth() * 0.75F;
        if(this.getAttackState() != 5) {
            repelEntities(dis, this.getBbHeight(), dis, dis);
        }
    }

    public void aiStep() {
        super.aiStep();

        if(this.getAttackState() == 1) {
            if (this.attackTicks == 22) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 20);
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                this.playSound(ModSounds.EXPLOSION.get(), 2.0f, 0.95F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(8.5f,8.5f,50,1,140,false,2.25);
                Makeparticle(2f, 7.3f, 0.35f);
            }

            if (this.attackTicks == 22) {
                BlockSmashDamage(2.0F, 1, 2.5F, 7.3f, 160, 1.0F, 0.15f);

            }
            if (this.attackTicks == 25) {
                BlockSmashDamage(2.0F, 2, 2.5F, 7.3f, 160, 1.0F, 0.15f);
            }

        }

        if(this.getAttackState() == 2) {
            if (this.attackTicks == 22) {
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(7.5f,7.5f,200,0.9F,100,true,2.25);
            }
            if (this.attackTicks == 50) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 20);
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                this.playSound(ModSounds.EXPLOSION.get(), 2.0f, 0.95F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(8.5f,8.5f,50,1.15F,160,false,2.25);
                Makeparticle(2f, 7.3f, 0.35f);
            }
            if (this.attackTicks == 50) {
                BlockSmashDamage(2.0F, 1, 2.5F, 7.3f, 160, 1.0F, 0.15f);
            }
            if (this.attackTicks == 53) {
                BlockSmashDamage(2.0F, 2, 2.5F, 7.3f, 160, 1.0F, 0.15f);
            }
        }
        if(this.getAttackState() == 5) {
            if (!this.level().isClientSide) {
                if (CMConfig.KobolediatorBlockBreaking) {
                    ChargeBlockBreaking();
                } else {
                    if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
                        ChargeBlockBreaking();
                    }
                }

                if (this.tickCount % 2 == 0) {
                    for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D))) {
                        if (!isAlliedTo(Lentity) && !(Lentity instanceof Clawdian_Entity) && Lentity != this) {
                            boolean flag = Lentity.hurt(this.damageSources().mobAttack(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.6F));
                            if (flag) {
                                if (Lentity.onGround()) {
                                    double d0 = Lentity.getX() - this.getX();
                                    double d1 = Lentity.getZ() - this.getZ();
                                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                                    float f = 1.5F;
                                    Lentity.push(d0 / d2 * f, 0.4F, d1 / d2 * f);
                                }
                            }
                        }
                    }
                }
            }

        }

        if(this.getAttackState() == 7) {
            if (this.attackTicks == 27) {
                AreaAttack(3.5f, 3.5f, 120, 1.35F, 200, false,2.25);
                Makeparticle(2f, 0.9f, 0.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.25f, 0, 20);
                this.playSound(ModSounds.EXPLOSION.get(), 2.0f, 0.95F + this.getRandom().nextFloat() * 0.1F);

                double theta = (yBodyRot) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                double vec = 2.0D;
                if (!this.level().isClientSide()) {
                    int numberOfWaves = 6;
                    float angleStep = 35.0f;

                    double firstAngleOffset = (numberOfWaves - 1) / 2.0 * angleStep;
                    for (int i = 0; i < numberOfWaves; i++) {
                        double angle = yBodyRot - firstAngleOffset + (i * angleStep);
                        double rad = Math.toRadians(angle);
                        double dx = -Math.sin(rad);
                        double dz = Math.cos(rad);
                        double spawnX = this.getX() + vecX * vec;
                        double spawnY = this.getY();
                        double spawnZ = this.getZ() + vecZ * vec;
                        Wave_Entity WaveEntity = new Wave_Entity(this.level(), this, 80, 9);
                        WaveEntity.setPos(spawnX, spawnY, spawnZ);
                        WaveEntity.setState(1);
                        WaveEntity.setYRot(-(float) (Mth.atan2(dx, dz) * (180F / Math.PI)));
                        this.level().addFreshEntity(WaveEntity);
                    }
                }else{
                    int numberOfWaves = 14;
                    float angleStep = 15.0f;

                    double firstAngleOffset = (numberOfWaves - 1) / 2.0 * angleStep;
                    for (int i = 0; i < numberOfWaves; i++) {
                        double angle = yBodyRot - firstAngleOffset + (i * angleStep);
                        double rad = Math.toRadians(angle);
                        double dx = -Math.sin(rad);
                        double dz = Math.cos(rad);
                        double spawnX = this.getX() + vecX * vec;
                        double spawnY = this.getY();
                        double spawnZ = this.getZ() + vecZ * vec;
                        double extraX = spawnX + dx * (1 + random.nextDouble() /2);
                        double extraY = spawnY + 0.9d + random.nextDouble() * 0.5;
                        double extraZ = spawnZ + dz * (1 + random.nextDouble()/2);
                        this.level().addParticle(new NotSpinTrailParticleOptions(113 / 255F, 194 / 255F, 240 / 255F, 0.05F, 0.5F + random.nextFloat() * 0.3F, 0.4F + random.nextFloat() * 0.2F, 0, 120), spawnX, spawnY, spawnZ, extraX, extraY, extraZ);

                    }
                }

            }

            for (int l = 26; l <= 28; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 24;
                    int d2 = l - 25;
                    BlockSmashDamage(0.6F, d, 2.5F, 2F, 160, 1.0F, 0.15f);
                    BlockSmashDamage(0.6F, d2, 2.5F, 2F, 160, 1.0F, 0.15f);
                }
            }

            if (this.attackTicks == 31) {
                if (!this.level().isClientSide()) {
                    double theta = (yBodyRot) * (Math.PI / 180);

                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    int numberOfSkulls = 5;
                    float angleStep = 35.0f;

                    double firstAngleOffset = (numberOfSkulls - 1) / 2.0 * angleStep;
                    for (int i = 0; i < numberOfSkulls; i++) {
                        double angle = yBodyRot - firstAngleOffset + (i * angleStep);
                        double rad = Math.toRadians(angle);
                        double dx = -Math.sin(rad);
                        double dz = Math.cos(rad);
                        double spawnX = this.getX() + vecX * 2;
                        double spawnY = this.getY();
                        double spawnZ = this.getZ() + vecZ * 2;
                        Wave_Entity WaveEntity = new Wave_Entity(this.level(), this, 80, 9);
                        WaveEntity.setPos(spawnX, spawnY, spawnZ);
                        WaveEntity.setState(1);
                        WaveEntity.setYRot(-(float) (Mth.atan2(dx, dz) * (180F / Math.PI)));
                        this.level().addFreshEntity(WaveEntity);
                    }
                }
            }
        }
        if(this.getAttackState() == 8) {
            if (this.attackTicks == 18) {
                this.playSound(ModSounds.CRAB_BITE.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 21) {
                AreaAttack(4.5f, 4.5f, 140, 1.0F, 200, true,2.25);
            }
        }

        if(this.getAttackState() == 9) {
            if (this.attackTicks == 16) {
                this.playSound(SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR, 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                Makeparticle(0.6f, 2.5F, -0.5f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.25f, 0, 20);
                HoldAttack(4.5F,4.5F,60,1,120);
            }
            if (!this.getPassengers().isEmpty() && this.getPassengers().get(0).isShiftKeyDown()) {
                this.getPassengers().get(0).setShiftKeyDown(false);
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
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.DUST_PILLAR, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
            this.level().addParticle(new RingParticleOptions(0f, (float)Math.PI/2f, 30, 255, 255,  255, 1.0f, 20f, false, 2), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }

    private void BlockSmashDamage(float spreadarc, int distance, float mxy, float vec, int shieldbreakticks, float damage, float airborne) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        double minY = this.getY() - 1;
        double maxY = this.getY() + mxy;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = level().getBlockState(pos);

            int maxDepth = 256;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderShape() == RenderShape.MODEL) {
                    break;
                }
                pos = pos.below();
                block = level().getBlockState(pos);
            }

            if (block.getRenderShape() != RenderShape.MODEL) {
                block = Blocks.AIR.defaultBlockState();
            }
            if (!this.level().isClientSide) {
                Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
                fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
                level().addFreshEntity(fallingBlockEntity);

                AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
                List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
                for (LivingEntity entity : hit) {
                    if (!isAlliedTo(entity) && !(entity instanceof Clawdian_Entity) && entity != this) {
                        DamageSource damagesource = this.damageSources().mobAttack(this);
                        boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                        if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player && shieldbreakticks > 0) {
                            disableShield(player, shieldbreakticks);
                        }

                        if (flag) {
                            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne + level().random.nextDouble() * 0.15, 0.0D));
                        }

                    }
                }
            }
        }
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks,boolean knockback,double xz) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        if (!this.level().isClientSide) {
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
                        DamageSource damagesource = this.damageSources().mobAttack(this);
                        boolean hurt = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                        if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                            disableShield(player, shieldbreakticks);
                        }

                        double d0 = entityHit.getX() - this.getX();
                        double d1 = entityHit.getZ() - this.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        if (hurt && knockback) {
                            entityHit.push(d0 / d2 * xz, 0.15D, d1 / d2 * xz);
                        }
                    }
                }
            }
        }
    }


    private void HoldAttack(float range, float height, float arc, float damage, int shieldbreakticks) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        if (!this.level().isClientSide) {
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
                    if (!(entityHit instanceof Clawdian_Entity) && entityHit != this) {
                        DamageSource damagesource = this.damageSources().mobAttack(this);
                        if (!entityHit.getType().is(ModTag.IGNIS_CANT_POKE) && entityHit.isAlive() && this.getPassengers().isEmpty()) {
                            if (entityHit.isShiftKeyDown()) {
                                entityHit.setShiftKeyDown(false);
                            }

                            if (entityHit.hurt(damagesource, 1)) {

                                    entityHit.startRiding(this, true);
                                    PacketDistributor.sendToPlayersTrackingEntityAndSelf(entityHit, new MessageEntityCameraSwitch.ThridPerson(entityHit.getId()));

                            }
                        } else if (!isAlliedTo(entityHit)) {
                            entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                        }
                    }
                }
            }
        }
    }

    private void ChargeBlockBreaking(){
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.5D, 0.2D, 0.5D);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.REMNANT_IMMUNE) && net.neoforged.neoforge.event.EventHooks.onEntityDestroyBlock(this, blockpos, blockstate)) {
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

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    public void positionRider(Entity passenger, MoveFunction moveFunc) {
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        Vec3 vec3 = this.getPassengerRidingPosition(passenger);
        Vec3 vec31 = passenger.getVehicleAttachmentPoint(this);


        double px = vec3.x - vec31.x + 2.5F * vecX;
        double pz = vec3.z - vec31.z + 2.5F * vecZ;

        double PosY = this.getY() + this.getBbHeight() * 0.8D;
        if (hasPassenger(passenger)) {
            moveFunc.accept(passenger, px, PosY, pz);
        }
    }


    public boolean shouldRiderSit() {
        return false;
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

    @Override
    protected boolean isAffectedByFluids() {
        return true;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    static class Clawdian_Accretion extends InternalAttackGoal {
        private final Clawdian_Entity entity;
        private final float meleerandom;
        private final float rangerandom;
        private final int getattackstate;
        private final int attackseetick;
        private final float Meleeattackrange;
        private final float attackrange;

        public Clawdian_Accretion(Clawdian_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float Meleeattackrange,float attackrange, float meleerandom, float rangerandom) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.meleerandom = meleerandom;
            this.rangerandom = rangerandom;
            this.getattackstate = getAttackState;
            this.attackseetick = attackseetick;
            this.Meleeattackrange = Meleeattackrange;
            this.attackrange = attackrange;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && entity.accretion_cooldown <= 0 && this.entity.getAttackState() == getattackstate  && this.entity.onGround() && !this.entity.isSwimming()  && (this.entity.distanceTo(target) < Meleeattackrange &&  this.entity.getRandom().nextFloat() * 100.0F < meleerandom||this.entity.distanceTo(target) > attackrange &&  this.entity.getRandom().nextFloat() * 100.0F < rangerandom);
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            entity.accretion_cooldown = ACCRETION_COOLDOWN;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks > attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 90.0F);
                entity.lookAt(target, 30.0F, 90.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            double theta = (entity.yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            if (this.entity.attackTicks == 29) {

                double vec = 2.0;
                int hitX = Mth.floor(entity.getX() + vec * vecX);
                int hitY = Mth.floor(entity.getY());
                int hitZ = Mth.floor(entity.getZ() + vec * vecZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = entity.level().getBlockState(hit.below());
                if (block.getRenderShape() == RenderShape.MODEL) {
                    entity.setHoldBlock(block.getBlock().defaultBlockState());
                }else{
                    entity.setHoldBlock(Blocks.STONE.defaultBlockState());
                }
            }
            this.entity.getNavigation().stop();
            if (this.entity.attackTicks == 45) {
                int count = 4;
                if (target != null) {
                    double vec = 2.5;
                    double offsetangle = Math.toRadians(4 + entity.random.nextInt(5));
                    for (int i = 0; i <= (count - 1); ++i) {
                        Accretion_Entity acc = new Accretion_Entity(ModEntities.ACCRETION.get(), entity.level(), entity);
                        double angle = (i - ((count - 1) / 2.0)) * offsetangle;
                        double d1 = target.getX() - this.entity.getX();

                        double d3 = target.getZ() - this.entity.getZ();
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);
                        double d2 = target.getY(0.2D) - acc.getY() + (entity.random.nextFloat() - 0.5) * i;
                        double PosX = entity.getX() + vecX * vec;
                        double PosY = entity.getY() + entity.getBbHeight() * 0.8D;
                        double PosZ = entity.getZ() + vecZ * vec;
                        acc.setPosRaw(PosX, PosY, PosZ);
                        acc.shoot(x, d2 + distance * (double) 0.2F, z, 1.4F, 4);
                        acc.setDamage(15);
                        acc.setBlockState(entity.getHoldBlock());
                        acc.level().addFreshEntity(acc);
                    }
                }else {
                    double tempvec = 12;
                    double vec = 2.5;
                    double d1 = entity.getX() + vecX * tempvec - this.entity.getX();
                    double d3 = entity.getZ() + vecZ * tempvec - this.entity.getZ();
                    double offsetangle = Math.toRadians(4 +entity.random.nextInt(5));
                    for (int i = 0; i <= (count - 1); ++i) {

                        Accretion_Entity acc = new Accretion_Entity(ModEntities.ACCRETION.get(), entity.level(), entity);
                        double angle = (i - ((count - 1) / 2.0)) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);
                        double d2 = entity.getY(0.2D) - acc.getY() + (entity.random.nextFloat() -0.5) * i;
                        double PosX = entity.getX() + vecX * vec;
                        double PosY = entity.getY() + entity.getBbHeight() * 0.8D;
                        double PosZ = entity.getZ() + vecZ * vec;
                        acc.setPosRaw(PosX, PosY, PosZ);
                        acc.shoot(x, d2 + distance * (double) 0.2F, z, 1.4F, 4);
                        acc.setDamage(15);
                        acc.setBlockState(entity.getHoldBlock());
                        acc.level().addFreshEntity(acc);
                    }
                }
                if (!entity.getPassengers().isEmpty()) {
                    Entity rider = entity.getPassengers().get(0);
                    double vec = 2.5;
                    if (rider.equals(target) || target == null) {
                        double tempvec = 12;
                        double d1 = entity.getX() + vecX * tempvec - this.entity.getX();
                        double d2 = entity.getY(0.2D) - rider.getY();
                        double d3 = entity.getZ() + vecZ * tempvec - this.entity.getZ();
                        double distance = Mth.sqrt((float) (d1 * d1 + d3 * d3));
                        double PosX = entity.getX() + vecX * vec;
                        double PosY = entity.getY() + entity.getBbHeight() * 0.8D;
                        double PosZ = entity.getZ() + vecZ * vec;
                        Accretion_Entity acc = new Accretion_Entity(ModEntities.ACCRETION.get(), entity.level(), entity);
                        acc.setPosRaw(PosX, PosY, PosZ);
                        acc.shoot(d1, d2 + distance * (double) 0.2F, d3, 1.4F, 4);
                        acc.setDamage(15);
                        acc.setBlockState(entity.getHoldBlock());
                        rider.startRiding(acc,true);
                        acc.level().addFreshEntity(acc);
                    } else {
                        double d1 = target.getX() - entity.getX();
                        double d3 = target.getZ() - entity.getZ();

                        double d2 = target.getY(0.2D) - rider.getY();
                        double distance = Mth.sqrt((float) (d1 * d1 + d3 * d3));
                        double PosX = entity.getX() + vecX * vec;
                        double PosY = entity.getY() + entity.getBbHeight() * 0.8D;
                        double PosZ = entity.getZ() + vecZ * vec;
                        Accretion_Entity acc = new Accretion_Entity(ModEntities.ACCRETION.get(), entity.level(), entity);
                        acc.setPosRaw(PosX, PosY, PosZ);
                        acc.shoot(d1, d2 + distance * (double) 0.2F, d3, 1.4F, 4);
                        acc.setDamage(15);
                        acc.setBlockState(entity.getHoldBlock());
                        rider.startRiding(acc,true);
                        acc.level().addFreshEntity(acc);
                    }


                }
            }
            if (this.entity.attackTicks == 46) {
                entity.setHoldBlock((BlockState)null);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class ClawdianSwimControl extends ClawdianMoveController {
        private final Clawdian_Entity drowned;
        private final float speedMulti;

        public ClawdianSwimControl(Clawdian_Entity p_32433_, float speedMulti) {
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





