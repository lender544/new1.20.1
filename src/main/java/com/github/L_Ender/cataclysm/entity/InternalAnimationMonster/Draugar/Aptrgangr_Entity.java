package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar;

import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.projectile.*;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.items.Cursed_bow;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.cataclysm.util.CMMathUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

import static java.lang.Math.toRadians;


public class Aptrgangr_Entity extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState swingrightAnimationState = new AnimationState();
    public AnimationState smashAnimationState = new AnimationState();
    public AnimationState chargestartAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargeendAnimationState = new AnimationState();
    public AnimationState chargehitAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int earthquake_cooldown = 0;
    public static final int EARTHQUAKE_COOLDOWN = 80;
    private boolean chubu = false;
    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;

    public Aptrgangr_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
        this.setMaxUpStep(1.25F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        setConfigattribute(this, CMConfig.AptrgangrHealthMultiplier, CMConfig.AptrgangrDamageMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(4, new InternalMoveGoal(this,false,1.0D));
        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,1,0,40,15,4.5F){
            @Override
            public boolean canUse() {
           //     return super.canUse() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 22f;
                return false;
            }
        });


        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,2,0,40,10,6){
            @Override
            public boolean canUse() {
               // return super.canUse() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Aptrgangr_Entity.this.earthquake_cooldown <= 0;
                return true;
            }
            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
            }
        });

        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,2,0,40,10,12){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
               // return super.canUse() && target !=null && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 22f && this.entity.distanceTo(target) > 6 && Aptrgangr_Entity.this.earthquake_cooldown <= 0;
                return true;
            }
            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
            }
        });


        //chargePrepare
        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,3,4,24,24,15) {
            @Override
            public boolean canUse() {
              //  return super.canUse() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 8f && Aptrgangr_Entity.this.charge_cooldown <= 0;
                return false;
            }
        });

        this.goalSelector.addGoal(2, new InternalStateGoal(this,4,4,5,40,0){
            @Override
            public void tick() {
                if(this.entity.onGround()){
                    Vec3 vector3d = entity.getDeltaMovement();
                    float f = entity.getYRot() * ((float)Math.PI / 180F);
                    Vec3 vector3d1 = new Vec3(-Mth.sin(f), entity.getDeltaMovement().y, Mth.cos(f)).scale(1.0D).add(vector3d.scale(0.5D));
                    entity.setDeltaMovement(vector3d1.x, entity.getDeltaMovement().y, vector3d1.z);
                }
            }
            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && !chubu;
            }
            @Override
            public void stop() {
                if(chubu) {
                    entity.setAttackState(6);
                    chubu = false;
                }else{
                    super.stop();
                }
            }
        });
        this.goalSelector.addGoal(1, new InternalStateGoal(this,5,5,0,23,0) {
            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.charge_cooldown = CHARGE_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(0, new InternalStateGoal(this,6,6,0,18,0) {
            @Override
            public void stop() {
                super.stop();
                Aptrgangr_Entity.this.charge_cooldown = CHARGE_COOLDOWN;
            }
        });
    }

    public static AttributeSupplier.Builder aptrgangr() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 18)
                .add(Attributes.MAX_HEALTH, 160)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if(!this.getPassengers().isEmpty() && this.getAttackState() == 4 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        return super.hurt(source, damage);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }


    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "swing_right") {
            return this.swingrightAnimationState;
        } else if (input == "smash") {
            return this.smashAnimationState;
        } else if (input == "idle") {
                return this.idleAnimationState;
        } else if (input == "charge_start") {
            return this.chargestartAnimationState;
        } else if (input == "charge") {
            return this.chargeAnimationState;
        } else if (input == "charge_end") {
            return this.chargeendAnimationState;
        } else if (input == "charge_hit") {
            return this.chargehitAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        }else {
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
                        this.swingrightAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.smashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.chargestartAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.chargeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.chargeendAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.chargehitAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.swingrightAnimationState.stop();
        this.smashAnimationState.stop();
        this.chargestartAnimationState.stop();
        this.chargeAnimationState.stop();
        this.chargeendAnimationState.stop();
        this.chargehitAnimationState.stop();
        this.deathAnimationState.stop();
    }



    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(7);
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
        if (earthquake_cooldown > 0) earthquake_cooldown--;
        if (charge_cooldown > 0) charge_cooldown--;

        if (!this.getPassengers().isEmpty() && this.getPassengers().get(0).isShiftKeyDown()) {
            this.getPassengers().get(0).setShiftKeyDown(false);
        }

    }

    public void aiStep() {
        super.aiStep();
        if(this.getAttackState() == 1) {
            if (this.attackTicks == 15) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0F, 0.7f);
                AreaAttack(5.75f, 5.75f, 120, 1, 120,true);
            }
        }
        if(this.getAttackState() == 2) {
            if (this.attackTicks == 11) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0F, 0.7f);
            }
            if (this.attackTicks == 15) {
                AreaAttack(6.5f, 6.5f, 60, 1, 120,false);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
                this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.8f);
                Makeparticle(0.6f, 5.0f, 0f);

                double theta = (yBodyRot) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);

                int skullCount = 5;
                float angleBetween = 10f;
                double distanceInFront = 5.0;

                for (int i = 0; i <= (skullCount - 1); i++) {

                    float offsetYaw = (float) ((yBodyRot +90) + (i - (skullCount - 1) / 2) * angleBetween);
                    float radYaw1 = offsetYaw * ((float) Math.PI / 180F);


                    double xDir = -Mth.sin(radYaw1)  + vecX * distanceInFront;
                    double zDir = Mth.cos(radYaw1) + vecZ * distanceInFront;
                    Axe_Blade_Entity witherskull = new Axe_Blade_Entity(this, xDir, 0, zDir, this.level(),(float) CMConfig.HarbingerWitherMissiledamage,radYaw1);

                    double spawnX = this.getX() + vecX * distanceInFront;
                    double spawnY = this.getY(0.15D);
                    double spawnZ = this.getZ() + vecZ * distanceInFront;
                    witherskull.setPos(spawnX, spawnY, spawnZ);


                    this.level().addFreshEntity(witherskull);


                    this.spawnFangs(this.getX() + (double) Mth.cos(radYaw1) * 5, this.getZ() + (double) Mth.sin(radYaw1) * 5D, this.getY(), this.getY() + 3, radYaw1, 1);


                }


            }
        }
        if(this.getAttackState() == 4) {
            ChargeGrab(0.0D,0.0D,0.5, 0.1F, 0, true);
            if (this.horizontalCollision) {
                chubu = true;
            }
            if (this.level().isClientSide) {
                double x = this.getX();
                double y = this.getY() + this.getBbHeight() / 2;
                double z = this.getZ();
                float yaw = (float) Math.toRadians(-this.getYRot());
                float yaw2 = (float) Math.toRadians(-this.getYRot() + 180);
                float pitch = (float) Math.toRadians(-this.getXRot());
                this.level().addParticle(new RingParticle.RingData(yaw, pitch, 40, 0.337f, 0.925f, 0.8f, 1.0f, 50f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), x, y, z, 0, 0, 0);
                this.level().addParticle(new RingParticle.RingData(yaw2, pitch, 40, 0.337f, 0.925f, 0.8f, 1.0f, 50f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), x, y, z, 0, 0, 0);

            }
        }

        if(this.getAttackState() == 6) {
            if (this.attackTicks == 1) {
                this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.9f);
            }
        }

    }


    private void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.containing(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
                if (!this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            this.level().addFreshEntity(new Void_Rune_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, this));
        }
    }

    private void doSpawnBlade(int count, float offset) {
        Vec3 looking = this.getLookAngle();
        for (int i = -count; i < count; i++) {
            SpawnBlade(looking.yRot(i * offset));
        }
    }

    private void SpawnBlade(Vec3 vec3) {
        float f0 = (float) Mth.atan2(vec3.z, vec3.x);
        double x = this.getX() + Mth.cos(f0) * 2.5D;
        double y = this.getY() + 0.5D;
        double z = this.getZ() + Mth.sin(f0) * 2.5D;

        Wither_Missile_Entity witherskull = new Wither_Missile_Entity(this, x, y, z, this.level(),(float) CMConfig.HarbingerWitherMissiledamage);
        this.level().addFreshEntity(witherskull);

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
            this.level().addParticle(new RingParticle.RingData(0f, (float)Math.PI/2f, 30, 1.0f, 1.0F,  1.0F, 1.0f, 20f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }

    private void AreaAttack(float range, float height, float arc, float damage, int shieldbreakticks,boolean knockback) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Aptrgangr_Entity) && entityHit != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean hurt =  entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    double d0 = entityHit.getX() - this.getX();
                    double d1 = entityHit.getZ() - this.getZ();
                    double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                    if (hurt && knockback) {
                        entityHit.push(d0 / d2 * 2.75D, 0.15D, d1 / d2 * 2.75D);
                    }

                }
            }
        }
    }

    private void ChargeGrab(double inflateXZ,double inflateY,  double range, float damage, int shieldbreakticks, boolean maledictio) {
        double yaw = Math.toRadians(this.getYRot() + 90);
        double xExpand = range * Math.cos(yaw);
        double zExpand = range * Math.sin(yaw);
        AABB attackRange = this.getBoundingBox().inflate(inflateXZ,inflateY,inflateXZ).expandTowards(xExpand, 0, zExpand);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entity) && entity != this) {
                if(this.getPassengers().isEmpty()) {
                    DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.damageSources().mobAttack(this);
                    boolean flag = entity.hurt(damagesource, damage);
                    if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    if (flag) {
                        if (!entity.getType().is(ModTag.IGNIS_CANT_POKE) && entity.isAlive()) {
                            if (entity.isShiftKeyDown()) {
                                entity.setShiftKeyDown(false);
                            }
                            entity.startRiding(this, true);
                        }

                    }
                }

            }
        }
    }


    public void travel(Vec3 travelVector) {
        super.travel(travelVector);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    public void positionRider(Entity passenger, Entity.MoveFunction moveFunc) {
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        double px = this.getX() + 2.0F * vecX;
        double pz = this.getZ() + 2.0F * vecZ;

        double y = this.getY() + passenger.getMyRidingOffset() + 0.6D;
        if (hasPassenger(passenger)) {
            if(this.getAttackState() == 6){
                if(this.attackTicks == 1) {
                    if(passenger instanceof LivingEntity living){
                        DamageSource damagesource =  CMDamageTypes.causeMaledictioDamage(this) ;
                        boolean flag = living.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5F));
                        if(flag){
                            this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.9f);
                        }
                    }
                    passenger.stopRiding();
                }
            }else if(this.getAttackState() == 5){
                if(this.attackTicks == 1) {
                    passenger.stopRiding();
                }
            }else if (this.getAttackState() != 4){
                passenger.stopRiding();
            }

        }
        moveFunc.accept(passenger, px, y, pz);
    }


    public Vec3 getDismountLocationForPassenger(LivingEntity p_29487_) {
        Direction direction = this.getMotionDirection();
        if (direction.getAxis() == Direction.Axis.Y) {
            return super.getDismountLocationForPassenger(p_29487_);
        } else {
            int[][] aint = DismountHelper.offsetsForDirection(direction);
            BlockPos blockpos = this.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for(Pose pose : p_29487_.getDismountPoses()) {
                AABB aabb = p_29487_.getLocalBoundsForPose(pose);

                for(int[] aint1 : aint) {
                    blockpos$mutableblockpos.set(blockpos.getX() + aint1[0], blockpos.getY(), blockpos.getZ() + aint1[1]);
                    double d0 = this.level().getBlockFloorHeight(blockpos$mutableblockpos);
                    if (DismountHelper.isBlockFloorValid(d0)) {
                        Vec3 vec3 = Vec3.upFromBottomCenterOf(blockpos$mutableblockpos, d0);
                        if (DismountHelper.canDismountTo(this.level(), p_29487_, aabb.move(vec3))) {
                            p_29487_.setPose(pose);
                            return vec3;
                        }
                    }
                }
            }

            return super.getDismountLocationForPassenger(p_29487_);
        }
    }

    public boolean shouldRiderSit() {
        return false;
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
        return SoundEvents.HUSK_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.HUSK_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.HUSK_AMBIENT;
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





