package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus;

import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Netherite_Monstrosity_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.FlightMoveController;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.path.DirectPathNavigator;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;


public class Maledictus_Entity extends IABoss_monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState swingAnimationState = new AnimationState();
    public AnimationState shotAnimationState = new AnimationState();
    public AnimationState flyingshotAnimationState = new AnimationState();
    public AnimationState fallloopAnimationState = new AnimationState();
    public AnimationState falllendAnimationState = new AnimationState();
    public AnimationState masseffectAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();

    private boolean isflyingNavigator;

    private Vec3 prevRightHandPos = new Vec3(0, 0, 0);
    private Vec3 prevLeftHandPos = new Vec3(0, 0, 0);
    private int masseffect_cooldown = 0;
    private int flyattack_cooldown = 0;
    public static final int MASSEFFECT_COOLDOWN = 150;
    public static final int FLYATTACK_COOLDOWN = 100;
    private static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> LANDING = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.BOOLEAN);

    public static final EntityDataAccessor<Boolean> BOW = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.BOOLEAN);

    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;

    public Maledictus_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        switchNavigator(true);
        this.setMaxUpStep(1.25F);
        if (world.isClientSide)
            socketPosArray = new Vec3[] {new Vec3(0, 0, 0), new Vec3(0, 0, 0)};
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        setConfigattribute(this, CMConfig.MaledictusHealthMultiplier, CMConfig.MaledictusDamageMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<>(this, EnderDragon.class, true));
        this.goalSelector.addGoal(3, new InternalMoveGoal(this,false,1.0D));

        //swing
        this.goalSelector.addGoal(1, new Maledictus_Swing(this, 0, 1, 0, 44, 25, 0.5F, 30f, 16F));

        //bow
        this.goalSelector.addGoal(1, new Maledictus_Bow(this, 0, 2, 0, 45, 29, 8F, 40f, 29, 34F));

        //flying bow
        this.goalSelector.addGoal(1, new Maledictus_Flying_Bow(this, 0, 3, 4, 68, 50, 1F, 40f, 50,34F));

        //fall_loop
        this.goalSelector.addGoal(1, new MaledictusfallingState(this, 4, 4,5,100, 100,true,false));


        //fall_end
        this.goalSelector.addGoal(0, new MaledictusfallingState(this, 5, 5, 0, 27,0,false,false));

        //mass_effect
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,7,0,66,28,4.5F){
            @Override
            public boolean canUse() {
                return super.canUse() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 34f && Maledictus_Entity.this.masseffect_cooldown <= 0;
            }
            @Override
            public void tick() {
                super.tick();
                entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            }
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.masseffect_cooldown = MASSEFFECT_COOLDOWN;
            }
        });

        // this.goalSelector.addGoal(0, new LandingGoal(this, 4, 5, 0, 100,27));
    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl(this);
            this.navigation = new CMPathNavigateGround(this, level());
            this.isflyingNavigator = false;
        } else {
            this.moveControl = new FlightMoveController(this, 1.0F, false);
            this.navigation = new DirectPathNavigator(this, level());
            this.isflyingNavigator = true;
        }
    }

    public static AttributeSupplier.Builder maledictus() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.33F)
                .add(Attributes.ATTACK_DAMAGE, 18)
                .add(Attributes.MAX_HEALTH, 420)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }



    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        return super.hurt(source, damage);
    }

    public float DamageCap() {
        return (float) CMConfig.MaledictusDamageCap;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
        return false;
    }

    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        super.checkFallDamage(y, onGroundIn, state, pos);
    }

    protected void playBlockFallSound() {
        super.playBlockFallSound();
    }

    public AnimationState getAnimationState(String input) {
        if (input == "swing") {
            return this.swingAnimationState;
        } else if (input == "shoot") {
            return this.shotAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "flying_shoot") {
            return this.flyingshotAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "fall_loop") {
            return this.fallloopAnimationState;
        } else if (input == "fall_end") {
            return this.falllendAnimationState;
        } else if (input == "mass_effect") {
            return this.masseffectAnimationState;
        }else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BOW, false);
        this.entityData.define(FLYING, false);
        this.entityData.define(LANDING, false);
    }

    public void setBow(boolean bow) {
        this.entityData.set(BOW, bow);
    }

    public boolean getBow() {
        return this.entityData.get(BOW);
    }
    public boolean isFlying() {
        return this.entityData.get(FLYING);
    }

    public void setFlying(boolean flying) {
        this.entityData.set(FLYING, flying);
    }

    public boolean isLanding() {
        return this.entityData.get(LANDING);
    }

    public void setLanding(boolean landing) {
        this.entityData.set(LANDING, landing);
    }

    public void travel(Vec3 travelVector) {
        super.travel(travelVector);
    }


    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.swingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.shotAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.flyingshotAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.fallloopAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.falllendAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.masseffectAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.swingAnimationState.stop();
        this.shotAnimationState.stop();
        this.deathAnimationState.stop();
        this.flyingshotAnimationState.stop();
        this.fallloopAnimationState.stop();
        this.falllendAnimationState.stop();
        this.masseffectAnimationState.stop();
    }

    private void SwingParticles() {
        if (level().isClientSide) {
            Vec3 bladePos1 = socketPosArray[0];
            Vec3 bladePos2 = socketPosArray[1];
            if(this.getAttackState() == 1) {
                if (this.attackTicks > 1 && this.attackTicks < 8) {
                    Warningparticle(0.95f,0.5215f,0.1333F);
                }
            }
            if(this.getAttackState() == 2) {
                if (this.attackTicks > 1 && this.attackTicks <15) {
                    Warningparticle(0.09f,0.42f,0.35F);
                }
            }
            if(this.getAttackState() == 3) {
                if (this.attackTicks > 21 && this.attackTicks < 45) {
                    Warningparticle(0.09f,0.42f,0.35F);
                }
            }

            if(this.getAttackState() == 7) {
                if (this.attackTicks > 1 && this.attackTicks < 28) {
                    Warningparticle(0.423f,0.062f,0.019F);
                }
            }

            prevLeftHandPos = bladePos1;
            prevRightHandPos = bladePos2;
        }
    }

    private void Warningparticle(float r,float g,float b) {

        double x = prevLeftHandPos.x ;
        double y = prevLeftHandPos.y;
        double z = prevLeftHandPos.z;

        this.level().addParticle(new RingParticle.RingData(0f, 0f, 5, r, g,  b, 1.0f, 4f, true, RingParticle.EnumRingBehavior.CONSTANT), x, y , z, 0, 0, 0);
        double x2 = prevRightHandPos.x ;
        double y2 = prevRightHandPos.y;
        double z2 = prevRightHandPos.z;
        this.level().addParticle(new RingParticle.RingData(0f, 0f, 5, r, g,  b, 1.0f, 4f, true, RingParticle.EnumRingBehavior.CONSTANT), x2, y2 , z2, 0, 0, 0);


    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(6);
    }

    public int deathtimer(){
        return 60;
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
        if (masseffect_cooldown > 0) masseffect_cooldown--;
        if (flyattack_cooldown > 0) flyattack_cooldown--;
        if (charge_cooldown > 0) charge_cooldown--;
        if (!this.level().isClientSide) {
            if (this.isFlying() && !this.isflyingNavigator) {
                switchNavigator(false);
            }
            if (!this.isFlying() && this.isflyingNavigator) {
                switchNavigator(true);
            }
            if (this.isFlying()) {
                this.setNoGravity(!this.onGround());
            }else{
                this.setNoGravity(false);
            }
        }
    }

    public void aiStep() {
        super.aiStep();
        SwingParticles();
        if(this.getAttackState() == 1) {
            if (this.attackTicks == 25) {
                AreaAttack(5.5f,5.5f,270,1,200);
                this.playSound(ModSounds.STRONGSWING.get(), 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
                MakeRingparticle(2.5f, 0.2f, 40, 0.337f, 0.925f,  0.8f, 1.0f, 30f);
            }
        }
        if(this.getAttackState()== 4){
            if (this.onGround() || !this.getFeetBlockState().getFluidState().isEmpty()) {
                this.setAttackState(5);
            }
        }
        if(this.getAttackState() == 6) {
            if (this.attackTicks == 30) {
                if (this.level().isClientSide) {
                    for(int i = 0; i < 20 + random.nextInt(2); ++i) {
                        float f2 = this.random.nextFloat() * ((float)Math.PI * 2F);
                        float f3 = Mth.sqrt(this.random.nextFloat()) * this.getBbWidth() * 0.5F;
                        double d0 = this.getX() + (double)(Mth.cos(f2) * f3);
                        double d4 = this.getZ() + (double)(Mth.sin(f2) * f3);
                        this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), d0, this.getY() + (double) this.getBbHeight() * 0.6 + i * 0.05D, d4, 0.0D, 0.1D, 0.0D);
                    }
                }
            }
        }
        if(this.getAttackState() == 7) {
            if(this.attackTicks == 10){
                masseffectParticle(5.0f);
            }
            if(this.attackTicks == 15){
                masseffectParticle(7.5f);
            }

            if(this.attackTicks == 20){
                masseffectParticle(10.0f);
            }
            if (this.attackTicks == 30) {
                this.playSound(ModSounds.MALEDICTUS_BATTLE_CRY.get(), 1F, 1.0f);
            }

            if (this.attackTicks == 34) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 40);
                if (this.level().isClientSide) {
                    float vec = 1.0f;
                    float math = 0;
                    float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    this.level().addParticle(new RingParticle.RingData(0f, (float)Math.PI/2f, 30, 0.337f, 0.925f,  0.8f, 1.0f, 85, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
                }

                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(8.0D))) {
                    if (!isAlliedTo(entity) && entity != this) {
                        entity.hurt(CMDamageTypes.causeMaledictioDamage(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
                    }
                }
            }
            if (this.attackTicks > 34 && this.attackTicks < 44) {
                Sphereparticle(0.3f,1.0f,4F);
            }
        }
    }


    private void MakeRingparticle(float vec, float math,int duration,float r,float g,float b,float a, float scale) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            this.level().addParticle(new RingParticle.RingData(0f, (float)Math.PI/2f, duration, r, g,  b, a, scale, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
        }
    }

    private void Sphereparticle(float height, float vec, float size) {
        if (this.level().isClientSide) {
            if (this.tickCount % 2 == 0) {
                double d0 = this.getX();
                double d1 = this.getY() + height;
                double d2 = this.getZ();
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                for (float i = -size; i <= size; ++i) {
                    for (float j = -size; j <= size; ++j) {
                        for (float k = -size; k <= size; ++k) {
                            double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;
                            this.level().addParticle(ModParticle.CURSED_FLAME.get(), d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
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
            if (blockstate != Blocks.AIR.defaultBlockState() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.REMNANT_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
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


    private void masseffectParticle(float radius) {

        for (int j = 0; j < 70; ++j) {
            float angle = (float) (Math.random() * 2 * Math.PI);
            double distance = Math.sqrt(Math.random()) * radius;
            double extraX = this.getX() + distance * Mth.cos(angle);
            double extraY = this.getY() + 0.3F;
            double extraZ = this.getZ() + distance * Mth.sin(angle);

            this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), extraX, extraY, extraZ, 0.0D, this.random.nextGaussian() * 0.04D, 0.0D);
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Maledictus_Entity) && entityHit != this) {
                    entityHit.hurt(this.damageSources().mobAttack(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
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
        } else if (entityIn.getType().is(ModTag.TEAM_MALEDICTUS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.KOBOLEDIATOR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.KOBOLEDIATOR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.KOBOLEDIATOR_AMBIENT.get();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    class Maledictus_Swing extends InternalAttackGoal {
        private final float attackminrange;
        private final float random;


        public Maledictus_Swing(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, float random) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.attackminrange = attackminrange;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random;
        }
        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == 5) {
                if (target != null) {
                    double d0 = target.getX() - this.entity.getX();
                    double d1 = target.getY() - this.entity.getY();
                    double d2 = target.getZ() - this.entity.getZ();
                    Vec3 vec3 = (new Vec3(d0, 0.7 + Mth.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(0.2D,1.0D,0.2D);
                    this.entity.setDeltaMovement(vec3);
                }else{

                    Vec3 vec3 = (new Vec3(0, 0.7, 0));
                    this.entity.setDeltaMovement(vec3);
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }


    static class Maledictus_Bow extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final float attackminrange;
        private final int attackshot;
        private final float random;


        public Maledictus_Bow(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate,int attackMaxtick, int attackseetick, float attackminrange, float attackrange,int attackshot, float random) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.entity = entity;
            this.attackminrange = attackminrange;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random;
        }

        @Override
        public void start() {
            super.start();
            this.entity.setBow(true);
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.setBow(false);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == attackshot) {
                if (target != null) {
                    double arrowcount = 4;
                    double offsetangle = Math.toRadians(6);

                    //update target pos
                    double d1 = target.getX() - this.entity.getX();
                    double d2 = target.getY(0.3333333333333333D) - this.entity.getY();
                    double d3 = target.getZ() - this.entity.getZ();

                    for (int i = 0; i <= (arrowcount - 1); ++i) {
                        double angle = (i - ((arrowcount - 1) / 2)) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + d2 * d2 + z * z);

                        Phantom_Arrow_Entity throwntrident = new Phantom_Arrow_Entity(this.entity.level(), this.entity,target);
                        throwntrident.setBaseDamage(4);
                        throwntrident.shoot(x, d2 + distance * (double)0.2F, z, 2.0F, 1);
                        this.entity.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.0F / (this.entity.getRandom().nextFloat() * 0.4F + 0.8F));
                        this.entity.level().addFreshEntity(throwntrident);

                    }

                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class Maledictus_Flying_Bow extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final float attackminrange;
        private final int attackshot;
        private final float random;

        public Maledictus_Flying_Bow(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, int attackshot, float random) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.entity = entity;
            this.attackminrange = attackminrange;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.flyattack_cooldown <=0;
        }

        @Override
        public void start() {
            super.start();
            entity.setBow(true);
        }

        @Override
        public void stop() {
            super.stop();
            entity.setFlying(false);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackshot && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 90.0F);
                entity.lookAt(target, 30.0F, 90.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }

            if (this.entity.attackTicks == 8) {
                this.entity.setDeltaMovement(0, 0.9, 0);
                entity.setFlying(true);
            }
            if (this.entity.attackTicks == 20) {
                this.entity.setDeltaMovement(0, 0, 0);
            }
            if (this.entity.attackTicks == 60) {
                this.entity.setFlying(false);
            }
            if (this.entity.attackTicks == attackshot) {
                if (target != null) {
                    double arrowcount = 4;
                    double offsetangle = Math.toRadians(9);

                    //update target pos
                    double d1 = target.getX() - this.entity.getX();
                    double d2 = target.getY(0.3333333333333333D) - this.entity.getY();
                    double d3 = target.getZ() - this.entity.getZ();

                    for (int i = 0; i <= (arrowcount - 1); ++i) {
                        double angle = (i - ((arrowcount - 1) / 2)) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + d2 * d2 + z * z);

                        Phantom_Arrow_Entity throwntrident = new Phantom_Arrow_Entity(this.entity.level(), this.entity, target);
                        throwntrident.setBaseDamage(4);
                        throwntrident.shoot(x, d2 + distance * (double) 0.2F, z, 1.7F, 1);
                        this.entity.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.0F / (this.entity.getRandom().nextFloat() * 0.4F + 0.8F));
                        this.entity.level().addFreshEntity(throwntrident);

                    }
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class MaledictusfallingState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final boolean startbow;
        private final boolean stopbow;
        private final int attackseetick;

        public MaledictusfallingState(Maledictus_Entity entity,int getAttackState, int attackstate, int attackendstate, int attackMaxtick,int attackseetick, boolean startbow, boolean stopbow) {
            super(entity,getAttackState,attackstate,attackendstate,attackMaxtick,attackseetick);
            this.entity = entity;
            this.attackseetick = attackseetick;
            this.startbow = startbow;
            this.stopbow = stopbow;
        }


        @Override
        public void start() {
            super.start();
            entity.setBow(startbow);
            if(entity.isFlying()) {
                entity.setFlying(false);
            }
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }

        @Override
        public void stop() {
            super.stop();
            entity.flyattack_cooldown = FLYATTACK_COOLDOWN;
            entity.setBow(stopbow);
        }


        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}





