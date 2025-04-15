package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster;

import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.HurtByNearestTargetGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Poison_Dart_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
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
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;


import javax.annotation.Nullable;
import java.util.List;


public class Kobolediator_Entity extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState sword1AnimationState = new AnimationState();
    public AnimationState sword2AnimationState = new AnimationState();
    public AnimationState chargeprepareAnimationState = new AnimationState();
    public AnimationState chargeAnimationState = new AnimationState();
    public AnimationState chargeendAnimationState = new AnimationState();
    public AnimationState blockAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    private int earthquake_cooldown = 0;
    public static final int EARTHQUAKE_COOLDOWN = 80;

    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;


    public Kobolediator_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.KobolediatorHealthMultiplier, CMConfig.KobolediatorDamageMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByNearestTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new InternalMoveGoal(this,false,1.0D));


        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,3,0,50,15,12){
            @Override
            public boolean canUse() {
                return super.canUse() && Kobolediator_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Kobolediator_Entity.this.earthquake_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Kobolediator_Entity.this.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,4,0,100,64,8));

        //chargePrepare
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,5,6,40,30,15) {
            @Override
            public boolean canUse() {
                return super.canUse() && Kobolediator_Entity.this.getRandom().nextFloat() * 100.0F < 9f && Kobolediator_Entity.this.charge_cooldown <= 0;
            }
        });

        this.goalSelector.addGoal(1, new InternalStateGoal(this,6,6,7,30,0){
            @Override
            public void tick() {
                if(this.entity.onGround()){
                    Vec3 vector3d = entity.getDeltaMovement();
                    float f = entity.getYRot() * ((float)Math.PI / 180F);
                    Vec3 vector3d1 = new Vec3(-Mth.sin(f), entity.getDeltaMovement().y, Mth.cos(f)).scale(0.7D).add(vector3d.scale(0.5D));
                    entity.setDeltaMovement(vector3d1.x, entity.getDeltaMovement().y, vector3d1.z);
                }
            }
        });
        this.goalSelector.addGoal(0, new InternalAttackGoal(this,6,7,0,40,40,5) {

            @Override
            public void stop() {
                super.stop();
                Kobolediator_Entity.this.charge_cooldown = CHARGE_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(0, new InternalStateGoal(this,7,7,0,40,40) {
            @Override
            public void stop() {
                super.stop();
                Kobolediator_Entity.this.charge_cooldown = CHARGE_COOLDOWN;
            }
        });
        this.goalSelector.addGoal(1, new InternalStateGoal(this,1,1,0,0,0){
            @Override
            public void tick() {
                entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            }
        });

        this.goalSelector.addGoal(0, new InternalAttackGoal(this,1,2,0,70,0,18));
        this.goalSelector.addGoal(0, new InternalStateGoal(this,9,9,0,18,0,false));
    }

    public static AttributeSupplier.Builder kobolediator() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 14)
                .add(Attributes.MAX_HEALTH, 180)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.STEP_HEIGHT, 1.25F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }


    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof Poison_Dart_Entity) {
            return false;
        }
        if (this.canBlockDamageSource(source)) {
            if(entity instanceof AbstractArrow) {
                float f = 170.0F + this.random.nextFloat() * 80.0F;
                entity.setDeltaMovement(entity.getDeltaMovement().scale(1.5));
                entity.setYRot(entity.getYRot() + f);
                entity.hurtMarked = true;
            }
            if(this.getAttackState() == 0) {
                this.setAttackState(9);
                this.playSound(SoundEvents.ANVIL_LAND, 1.0F, 2);
            }
            return false;
        }
        if (this.isSleep() && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        return super.hurt(source, damage);
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        boolean flag = false;
        if (!this.isNoAi() && damageSourceIn.is(DamageTypeTags.IS_PROJECTILE) && !flag && (this.getAttackState() == 0 || this.getAttackState() == 9)) {
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
        if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        } else if (input == "sword1") {
            return this.sword1AnimationState;
        } else if (input == "sword2") {
            return this.sword2AnimationState;
        } else if (input == "idle") {
                return this.idleAnimationState;
        } else if (input == "charge_prepare") {
            return this.chargeprepareAnimationState;
        } else if (input == "charge") {
            return this.chargeAnimationState;
        } else if (input == "charge_end") {
            return this.chargeendAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "block") {
            return this.blockAnimationState;
        }else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }

    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }

    public boolean canBeSeenAsEnemy() {
        return !this.isSleep() && super.canBeSeenAsEnemy();
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_) {
        this.setSleep(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.sleepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.awakeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.sword1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.sword2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.chargeprepareAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.chargeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.chargeendAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.blockAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.sword1AnimationState.stop();
        this.sword2AnimationState.stop();
        this.chargeprepareAnimationState.stop();
        this.chargeAnimationState.stop();
        this.blockAnimationState.stop();
        this.chargeendAnimationState.stop();
        this.deathAnimationState.stop();
    }



    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(8);
    }

    public int deathtimer(){
        return 60;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Sleep", isSleep());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setSleep(compound.getBoolean("is_Sleep"));
    }


    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        }
        if (earthquake_cooldown > 0) earthquake_cooldown--;
        if (charge_cooldown > 0) charge_cooldown--;

    }

    public void aiStep() {
        super.aiStep();
        if(this.getAttackState() == 2) {
            if (this.attackTicks == 12) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.06f, 0, 20);
            }
        }

        if(this.getAttackState() == 3) {
            if (this.attackTicks == 20) {
                AreaAttack(10.0f,6.0F,60,1,120);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
                Makeparticle(0.5f, 9.0f, 1.2f);
            }
            for (int l = 19; l <= 28; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 17;
                    int d2 = l - 16;
                    float ds = (d + d2) / 2;
                   StompDamage(0.25f, d, 5,1.05F, 2.0f, -0.2f, 0, 1.0f);
                   StompDamage(0.25f, d2, 5,1.05F, 2.0f, -0.2f, 0, 1.0f);
                   Stompsound(ds,-0.2F);
                }
            }
        }

        if(this.getAttackState() == 4) {
            if (this.attackTicks == 18) {
                AreaAttack(9.0f,6.0F,270,1,0);
                this.playSound(ModSounds.STRONGSWING.get(), 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 10);
            }
            if (this.attackTicks == 36) {
                AreaAttack(9.0f,6.0F,270,1,0);
                this.playSound(ModSounds.STRONGSWING.get(), 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 10);
            }
            if (this.attackTicks == 65) {
                AreaAttack(10.0f,6.0F,45,1.25F,120);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
                Makeparticle(0.5f, 9.0f, 1.8f);
            }
        }
        if(this.getAttackState() == 6) {
            if (!this.level().isClientSide) {
                if(CMConfig.KobolediatorBlockBreaking) {
                    ChargeBlockBreaking();
                }else{
                    if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
                        ChargeBlockBreaking();
                    }
                }
            }
            if (this.tickCount % 4 == 0) {
                for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.5D))) {
                    if (!isAlliedTo(Lentity) && !(Lentity instanceof Kobolediator_Entity) && Lentity != this) {
                        boolean flag = Lentity.hurt(this.damageSources().mobAttack(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.4F));
                        if (flag) {
                            if (Lentity.onGround()) {
                                double d0 = Lentity.getX() - this.getX();
                                double d1 = Lentity.getZ() - this.getZ();
                                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                                float f = 1.5F;
                                Lentity.push(d0 / d2 * f, 0.5F, d1 / d2 * f);
                            }
                        }
                    }
                }
            }
        }
        if(this.getAttackState() == 7) {
            if (this.attackTicks == 5) {
                AreaAttack(9.0f,6.0F,200,1.25F,120);
                this.playSound(ModSounds.STRONGSWING.get(), 1F, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 10);
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


    private void Stompsound(float distance,float math) {
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        this.level().playSound((Player)null, this.getX() + distance * vecX + f * math, this.getY(), this.getZ() + distance * vecZ + f1 * math, ModSounds.REMNANT_STOMP.get(), this.getSoundSource(), 0.6f, 1.0f);
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Kobolediator_Entity) && entityHit != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                }
            }
        }
    }

    private void StompDamage(float spreadarc, int distance, int height, float mxy, float vec,float math, int shieldbreakticks, float damage) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180) + f * math;
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180  + f1 * math);
            float factor = 1 - distance / (float) 12;
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY + height, hitZ);
            BlockState block = level().getBlockState(pos);

            int maxDepth = 30;
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
            spawnBlocks(hitX,hitY + height ,hitZ, (int) (this.getY() - height),block, px, pz, mxy, vx, vz, factor, shieldbreakticks, damage);

        }
    }


    private void spawnBlocks(int hitX, int hitY, int hitZ, int lowestYCheck,BlockState blockState,double px,double pz,float mxy,double vx,double vz,float factor, int shieldbreakticks,float damage) {
        BlockPos blockpos = new BlockPos(hitX, hitY, hitZ);
        BlockState block = level().getBlockState(blockpos);
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

                break;
            }

            blockpos = blockpos.below();
        } while(blockpos.getY() >= Mth.floor(lowestYCheck) - 1);


        Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), hitX + 0.5D, (double)blockpos.getY() + d0 + 0.5D, hitZ + 0.5D, blockState, 10);
        fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.04D, 0);
        level().addFreshEntity(fallingBlockEntity);



        AABB selection = new AABB(px - 0.5, (double)blockpos.getY() + d0 -1, pz - 0.5, px + 0.5, (double)blockpos.getY() + d0 + mxy, pz + 0.5);
        List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
        for (LivingEntity entity : hit) {
            if (!isAlliedTo(entity) && !(entity instanceof Kobolediator_Entity) && entity != this) {
                DamageSource damagesource = this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }

                if (flag) {
                    double magnitude = -4;
                    double x = vx * (1 - factor) * magnitude;
                    double y = 0;
                    if (entity.onGround()) {
                        y += 0.15;
                    }
                    double z = vz * (1 - factor) * magnitude;
                    entity.setDeltaMovement(entity.getDeltaMovement().add(x, y, z));
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
        return ModSounds.KOBOLEDIATOR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.KOBOLEDIATOR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return this.isSleep() ? super.getAmbientSound() : ModSounds.KOBOLEDIATOR_AMBIENT.get();
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





