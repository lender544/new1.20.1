package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.blocks.PointedIcicleBlock;
import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.IHoldEntity;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.projectile.*;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.message.MessageEntityCamera;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.List;

import static java.lang.Math.toRadians;


public class Aptrgangr_Entity extends Internal_Animation_Monster implements IHoldEntity {
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
    public static final int NATURE_HEAL_COOLDOWN = 60;
    private int timeWithoutTarget;
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
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SnowGolem.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.goalSelector.addGoal(4, new InternalMoveGoal(this,false,1.0D));
        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,1,0,40,15,4.5F){
            @Override
            public boolean canUse() {
                return super.canUse() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 22f;
            }
        });


        this.goalSelector.addGoal(3, new InternalAttackGoal(this,0,2,0,40,10,6){
            @Override
            public boolean canUse() {
                return super.canUse() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Aptrgangr_Entity.this.earthquake_cooldown <= 0;
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
               return super.canUse() && target !=null && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 22f && this.entity.distanceTo(target) > 6 && Aptrgangr_Entity.this.earthquake_cooldown <= 0;
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
                return super.canUse() && Aptrgangr_Entity.this.getRandom().nextFloat() * 100.0F < 8f && Aptrgangr_Entity.this.charge_cooldown <= 0;
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
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
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


    protected void dropCustomDeathLoot(DamageSource p_33574_, int p_33575_, boolean p_33576_) {
        super.dropCustomDeathLoot(p_33574_, p_33575_, p_33576_);
        Entity entity = p_33574_.getEntity();
        if (entity instanceof Creeper creeper) {
            if (creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(ModItems.APTRGANGR_HEAD.get());
            }
        }

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
        }else{
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            LivingEntity target = this.getTarget();
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (timeWithoutTarget <= 0) {
                if (!isNoAi() ) {
                    if (this.tickCount % 20 == 0) {
                        this.heal(this.getMaxHealth()/ 10);
                    }
                }
            }
        }

        if (earthquake_cooldown > 0) earthquake_cooldown--;
        if (charge_cooldown > 0) charge_cooldown--;

        if (!this.getPassengers().isEmpty() && this.getPassengers().get(0).isShiftKeyDown() && this.getAttackState() == 4) {
            this.getPassengers().get(0).setShiftKeyDown(false);
        }

    }

    public void aiStep() {
        super.aiStep();
        if(this.getAttackState() == 1) {
            if (this.attackTicks == 15) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0F, 0.7f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.06f, 0, 20);
                AreaAttack(5.75f, 5.75f, 120, 1, 120,true);
            }
        }
        if(this.getAttackState() == 2) {
            if (this.attackTicks == 11) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0F, 0.7f);
            }
            if (this.attackTicks == 15) {
                AreaAttack(6.5f, 6.5f, 60, 1, 120,false);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.15f, 0, 20);
                this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.8f);
                Makeparticle(0.6f, 5.0f, 0f);

                double theta = (yBodyRot) * (Math.PI / 180);

                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                int numberOfSkulls = 5;
                float angleStep = 30.0f;

                for (int i = 0; i < numberOfSkulls; i++) {
                    float angle = yBodyRot + (i - (numberOfSkulls / 2)) * angleStep;

                    float rad = (float) Math.toRadians(angle);
                    double dx = -Math.sin(rad);
                    double dz = Math.cos(rad);
                    Axe_Blade_Entity witherskull = new Axe_Blade_Entity(this, dx, 0, dz, this.level(),(float) CMConfig.AptrgangrAxeBladeDamage,angle);
                    double spawnX = this.getX() + vecX * 5;
                    double spawnY = this.getY(0.15D);
                    double spawnZ = this.getZ() + vecZ * 5;
                    witherskull.setPos(spawnX, spawnY, spawnZ);
                    this.level().addFreshEntity(witherskull);

                }
            }
        }
        if(this.getAttackState() == 4) {
            ChargeGrab(0.0D,0.0D,0.5, 0.1F, 0, true);
            if (this.horizontalCollision) {
                chubu = true;
                if (!this.level().isClientSide) {
                    Icicle_Crash();
                }
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

        if(this.getAttackState() == 5) {
            if (this.attackTicks == 4) {
                this.playSound(ModSounds.STRONGSWING.get(), 1.0F, 0.7f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.06f, 0, 20);
                UpperAreaAttack(6.5f, 6.5f, 60, 1, 120,true);
            }
        }

        if(this.getAttackState() == 6) {
            if (this.attackTicks == 1) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.1f, 0, 20);
                this.playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 0.9f);
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

    private void UpperAreaAttack(float range, float height, float arc, float damage, int shieldbreakticks,boolean knockback) {
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
                        entityHit.setDeltaMovement(entityHit.getDeltaMovement().add(0.0D, (double)0.4F * 2, 0.0D));
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
                            if (!this.level().isClientSide) {
                                entity.startRiding(this, true);
                                Cataclysm.NETWORK_WRAPPER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new MessageEntityCamera(entity.getId(),true));
                            }
                        }

                    }
                }

            }
        }
    }


    private void Icicle_Crash() {

        if (this.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
            BlockPos ceil = this.blockPosition().offset(0, 5, 0);
            while ((!level().getBlockState(ceil).isSolid() || level().getBlockState(ceil).getBlock() == ModBlocks.POINTED_ICICLE.get()) && ceil.getY() < level().getMaxBuildHeight()) {
                ceil = ceil.above();
            }
            final int i = 8;
            final int j = 8;
            final int k = 8;

            for (BlockPos blockpos1 : BlockPos.betweenClosed(ceil.offset(-i, -j, -k), ceil.offset(i, j, k))) {
                if (level().getBlockState(blockpos1).getBlock() instanceof Fallable) {
                    if (isHangingIcicle(blockpos1)) {
                        while (isHangingIcicle(blockpos1.above()) && blockpos1.getY() < level().getMaxBuildHeight()) {
                            blockpos1 = blockpos1.above();
                        }
                        if (isHangingIcicle(blockpos1)) {
                            Vec3 vec3 = Vec3.atBottomCenterOf(blockpos1);
                            FallingBlockEntity.fall(level(), BlockPos.containing(vec3.x, vec3.y, vec3.z), level().getBlockState(blockpos1));
                        }
                    } else {
                        this.level().scheduleTick(blockpos1, level().getBlockState(blockpos1).getBlock(), 2);
                    }
                }
            }
        }

    }

    private boolean isHangingIcicle(BlockPos pos) {
        return level().getBlockState(pos).getBlock() instanceof PointedIcicleBlock && level().getBlockState(pos).getValue(PointedIcicleBlock.TIP_DIRECTION) == Direction.DOWN;
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
        double px = this.getX() + 0.7F * vecX;
        double pz = this.getZ() + 0.7F * vecZ;

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
                    if (!this.level().isClientSide) {
                        passenger.stopRiding();
                        Cataclysm.NETWORK_WRAPPER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> passenger), new MessageEntityCamera(passenger.getId(),false));
                    }
                }
            }else if(this.getAttackState() == 5){
                if(this.attackTicks == 1) {
                    if (!this.level().isClientSide) {
                        passenger.stopRiding();
                        Cataclysm.NETWORK_WRAPPER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> passenger), new MessageEntityCamera(passenger.getId(),false));
                    }
                }
            }else if (this.getAttackState() != 4){
                if (!this.level().isClientSide) {
                    passenger.stopRiding();
                    Cataclysm.NETWORK_WRAPPER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> passenger), new MessageEntityCamera(passenger.getId(),false));
                }
            }
            moveFunc.accept(passenger, px, y, pz);
        }
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
        return ModSounds.APTRGANGR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.APTRGANGR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.APTRGANGR_IDLE.get();
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





