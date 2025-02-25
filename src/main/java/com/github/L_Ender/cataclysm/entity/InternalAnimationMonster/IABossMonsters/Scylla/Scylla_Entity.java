package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Scylla;

import com.github.L_Ender.cataclysm.client.particle.Options.CircleLightningParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.GatheringWaterParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Storm_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Wave_Entity;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.projectile.Lightning_Spear_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Water_Spear_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.EnumSet;
import java.util.List;


public class Scylla_Entity extends IABoss_monster {

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState CrossSwingAnimationState = new AnimationState();
    public AnimationState CrossSwing2AnimationState = new AnimationState();
    public AnimationState SmashAnimationState = new AnimationState();
    public AnimationState backstepanimationState = new AnimationState();
    public AnimationState spinAnimationState = new AnimationState();
    public AnimationState waveAnimationState = new AnimationState();
    public AnimationState lightningexplosionAnimationState = new AnimationState();
    public AnimationState WaterSpearAnimationState = new AnimationState();
    public AnimationState LightningSpearAnimationState = new AnimationState();

    public static final EntityDataAccessor<Boolean> EYE = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> CHAIN_ANCHOR = SynchedEntityData.defineId(Scylla_Entity.class, EntityDataSerializers.BOOLEAN);

    private int magic_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 100;

    public Scylla_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.ScyllaHealthMultiplier, CMConfig.ScyllaDamageMultiplier);
    }



    protected void registerGoals() {

        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(3, new InternalMoveGoal(this, false, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

        this.goalSelector.addGoal(2, new HorizontalSwingGoal(this,0,6,32));

        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,3,0,40,12,3.75F){
            @Override
            public boolean canUse() {
                return super.canUse() && Scylla_Entity.this.getRandom().nextFloat() * 100.0F < 14f;
            }
        });

        this.goalSelector.addGoal(1, new SpearThrowGoal(this,0,5F,25F,28,25));


        this.goalSelector.addGoal(1, new Back_StepGoal(this,0,4,0,20,20,3.0F,25F));

        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,5,0,87,56,6f){
            @Override
            public boolean canUse() {
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < 90 ;
            }

            @Override
            public void start() {
                super.start();
                Scylla_Entity.this.setChainAnchor(true);
            }

            @Override
            public void tick() {
                LivingEntity target = entity.getTarget();
                if(target !=null && this.entity.attackTicks < 56 && this.entity.attackTicks >= 12) {
                    this.entity.getNavigation().moveTo(target, 1.2F);
                }else{
                    this.entity.getNavigation().stop();
                }
                super.tick();
            }


            @Override
            public void stop() {
                super.stop();
                Scylla_Entity.this.setChainAnchor(false);
            }

        });


        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,6,0,65,35,15f){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < 24 && target !=null && this.entity.distanceTo(target) >= 6.5D ;
            }

            @Override
            public void start() {
                super.start();
                Scylla_Entity.this.setEye(true);
            }

            @Override
            public void stop() {
                super.stop();
                Scylla_Entity.this.setEye(false);
            }

        });
        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,7,0,150,55,15f){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return true;
            }

            @Override
            public void start() {
                super.start();
                Scylla_Entity.this.setEye(true);
                Scylla_Entity.this.setChainAnchor(true);
            }

            @Override
            public void stop() {
                super.stop();
                Scylla_Entity.this.setEye(false);
                Scylla_Entity.this.setChainAnchor(false);
            }

        });
    }


    public static AttributeSupplier.Builder scylla() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 16)
                .add(Attributes.MAX_HEALTH, 400)
                .add(Attributes.ARMOR, 20)
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
        }else if (input == "cross_swing") {
            return this.CrossSwingAnimationState;
        }else if (input == "cross_swing2") {
            return this.CrossSwing2AnimationState;
        }else if (input == "smash") {
            return this.SmashAnimationState;
        }else if (input == "back_step") {
            return this.backstepanimationState;
        }else if (input == "spin") {
            return this.spinAnimationState;
        }else if (input == "wave") {
            return this.waveAnimationState;
        }else if (input == "lightning_explosion") {
            return this.lightningexplosionAnimationState;
        }else if (input == "lightning_spear_throw") {
            return this.LightningSpearAnimationState;
        }else if (input == "water_spear_throw") {
            return this.WaterSpearAnimationState;
        } else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(EYE, false);
        p_326229_.define(CHAIN_ANCHOR, false);
    }


    public boolean getEye() {
        return this.entityData.get(EYE);
    }

    public void setEye(boolean weapon) {
        this.entityData.set(EYE, weapon);
    }

    public boolean getChainAnchor() {
        return this.entityData.get(CHAIN_ANCHOR);
    }

    public void setChainAnchor(boolean weapon) {
        this.entityData.set(CHAIN_ANCHOR, weapon);
    }


    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                case 0 -> this.stopAllAnimationStates();

                case 1 -> {
                    this.stopAllAnimationStates();
                    this.CrossSwingAnimationState.startIfStopped(this.tickCount);
                }
                case 2 -> {
                    this.stopAllAnimationStates();
                    this.CrossSwing2AnimationState.startIfStopped(this.tickCount);
                }
                case 3 -> {
                    this.stopAllAnimationStates();
                    this.SmashAnimationState.startIfStopped(this.tickCount);
                }
                case 4 -> {
                    this.stopAllAnimationStates();
                    this.backstepanimationState.startIfStopped(this.tickCount);
                }
                case 5 -> {
                    this.stopAllAnimationStates();
                    this.spinAnimationState.startIfStopped(this.tickCount);
                }
                case 6 -> {
                    this.stopAllAnimationStates();
                    this.waveAnimationState.startIfStopped(this.tickCount);
                }
                case 7 -> {
                    this.stopAllAnimationStates();
                    this.lightningexplosionAnimationState.startIfStopped(this.tickCount);
                }
                case 8 -> {
                    this.stopAllAnimationStates();
                    this.LightningSpearAnimationState.startIfStopped(this.tickCount);
                }
                case 9 -> {
                    this.stopAllAnimationStates();
                    this.WaterSpearAnimationState.startIfStopped(this.tickCount);
                }
            }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();

        this.CrossSwingAnimationState.stop();

        this.CrossSwing2AnimationState.stop();

        this.SmashAnimationState.stop();
        this.backstepanimationState.stop();
        this.spinAnimationState.stop();
        this.waveAnimationState.stop();
        this.lightningexplosionAnimationState.stop();
        this.LightningSpearAnimationState.stop();
        this.WaterSpearAnimationState.stop();
    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(10);
    }

    public int deathtimer() {
        return 40;
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
            this.idleAnimationState.animateWhen(this.getAttackState() == 0 , this.tickCount);
        }

    }

    public void aiStep() {
        super.aiStep();

        if(this.getAttackState() == 3) {
            if (this.attackTicks == 13) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 20);
                this.playSound(ModSounds.STRONGSWING.get(), 2.0f, 0.75F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(4.75f,4.75f,65,1.15F,150,true,false);
                if (!this.level().isClientSide) {

                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    spawnLightning(this.getX() + vecX * 3.25F, this.getZ() + vecZ * 3.25F, this.getY() -2, this.getY() + 5, (float) theta, 0);
                }
            }
        }
        if(this.getAttackState() == 5) {
            if(this.attackTicks < 40 && this.attackTicks >= 12) {
                if (this.level().isClientSide) {
                    float r = 143 / 255F;
                    float g = 241 / 255F;
                    float b = 215 / 255F;
                    this.level().addParticle((new StormParticleOptions(r, g, b, 6f + random.nextFloat() * 0.25f, 1.5F + random.nextFloat() * 0.45f, this.getId())), this.getX(), this.getY(), this.getZ(), 0, 0, 0);
                }
            }

        }

        if(this.getAttackState() == 6) {
            if (this.attackTicks == 35) {
                AreaAttack(3.5f, 3.5f, 120, 1.35F, 200, false,false);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.25f, 0, 20);
                this.playSound(ModSounds.EXPLOSION.get(), 2.0f, 0.95F + this.getRandom().nextFloat() * 0.1F);
                if (!this.level().isClientSide()) {
                    SummonWave(5,25F,2.4D);
                   // SummonWave(4,22.5F,2.4D);
                   // SummonWave(2,67.5F,1.4D);
                }
            }
            if (this.attackTicks == 40) {
                if (!this.level().isClientSide()) {
                    SummonWave(4,25F,2.4D);
                }
            }
        }
        if(this.getAttackState() == 7) {
            if (this.attackTicks < 115 && this.attackTicks > 55) {

                CircleLighning(0.2F,0.2F,(random.nextFloat() - 0.5F) * 12,9 + random.nextFloat() * 4 - 0.5F, 9 ,3,1);

            }
            if (this.attackTicks == 55) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.02f, 20, 10);
            }
            if (this.attackTicks == 75) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.03f, 20, 10);
            }
            if (this.attackTicks == 95) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 25, 0.04f, 20, 10);
            }
        }

        if(this.getAttackState() == 8 ) {
            if (this.attackTicks < 24 && this.attackTicks > 7) {

                    PullLighning(7,-0.5,-0.5F,this.getBbHeight());

            }
            if (this.attackTicks== 27) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 10);

            }
        }
        if(this.getAttackState() == 9) {
            if (this.attackTicks < 17) {
                if (this.level().isClientSide) {
                    float r = 143 / 255F;
                    float g = 241 / 255F;
                    float b = 215 / 255F;
                    float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    double vec = -0.5;
                    float math = -0.5F;
                    double d0 = this.getX() + vecX * vec + f * math;
                    double d1 = this.getY() + this.getBbHeight();
                    double d2 = this.getZ() + vecZ * vec + f1 * math;
                    this.level().addParticle(new GatheringWaterParticleOptions(r, g, b), d0 + (random.nextFloat() - 0.5F) * 7, d1 + random.nextFloat() -0.25F, d2 + (random.nextFloat() - 0.5F) * 7, d0, d1, d2);

                }
            }
            if (this.attackTicks== 27) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 10);

            }
        }
    }

    private void spawnLightning(double x, double z, double minY, double maxY, float rotation, int delay) {
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
        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            this.level().addFreshEntity(new Lightning_Storm_Entity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float)CMConfig.FlameJetDamage,5f,this,99,194,201));
        }
    }

    private void SummonWave(int number, float anglestep,double vec){
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        double firstAngleOffset = (number - 1) / 2.0 * anglestep;
        for (int i = 0; i < number; i++) {
            double angle = yBodyRot - firstAngleOffset + (i * anglestep);
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Scylla_Entity) && entityHit != this) {
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
    private void PullLighning(double radius, double vec, float math, double height) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            double d0 = this.getX() + vecX * vec + f * math;
            double d1 = this.getY() + height;
            double d2 = this.getZ() + vecZ * vec + f1 * math;
            this.level().addParticle(new CircleLightningParticleOptions(143, 241, 215), d0 + (random.nextFloat() - 0.5F) * radius, d1 + random.nextFloat() - 0.25F, d2 + (random.nextFloat() - 0.5F) * radius, d0, d1, d2);

        }

    }


    private void CircleLighning(float vec, float math,float radius,double StartHeight,double EndHeight,int amount, int randamount) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
            float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            double d0 = this.getX() + vecX * vec + f * math;
            double d1 = this.getY() + EndHeight;
            double d2 = this.getZ() + vecZ * vec + f1 * math;


                for (int i = 0; i < amount + random.nextInt(randamount); i++) {

                    double theta2 = this.random.nextDouble() * 2 * Math.PI; // 0 ~ 360도
                    double phi = this.random.nextDouble() * Math.PI; // 0 ~ 180도

                    double posX = radius * Math.sin(phi) * Math.cos(theta2);
                    double posY = radius * Math.cos(phi);
                    double posZ = radius * Math.sin(phi) * Math.sin(theta2);

                    this.level().addParticle(new CircleLightningParticleOptions(143, 241, 215), d0 + posX, d1 + posY, d2 + posZ, d0, d1, d2);


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



    static class HorizontalSwingGoal extends Goal {
        private final Scylla_Entity entity;
        private final int getattackstate;
        private final float attackrange;
        private final float random;


        public HorizontalSwingGoal(Scylla_Entity entity, int getattackstate ,float attackrange,float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.attackrange = attackrange;



            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive()  && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate;
        }

        @Override
        public void start() {
            if (this.entity.random.nextBoolean()) {
                this.entity.setAttackState(1);
            } else {
                this.entity.setAttackState(2);
            }
            entity.setEye(true);
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.getAttackState() == 1 ? this.entity.attackTicks <= 35 && this.entity.getAttackState() == 1 : this.entity.attackTicks <= 29 && this.entity.getAttackState() == 2;
        }


        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            double theta = (this.entity.yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);

            if(this.entity.getAttackState() == 1) {
                if (entity.attackTicks < 12 && target != null) {
                    entity.getLookControl().setLookAt(target, 30.0F, 30F);
                    entity.lookAt(target, 30.0F, 30F);
                } else {
                    entity.setYRot(entity.yRotO);
                }

                if (entity.attackTicks == 8) {
                    if (target != null) {
                        float r = entity.distanceTo(target);
                        r = Mth.clamp(r, 1F, 4F);
                        entity.push(vecX * 0.45f * r, 0, vecZ * 0.45f * r);
                    } else {
                        entity.push(vecX * 1.8, 0, vecZ * 1.8);
                    }
                }

            } else if (this.entity.getAttackState() == 2) {
                if (entity.attackTicks < 9 && target != null) {
                    entity.getLookControl().setLookAt(target, 30.0F, 30F);
                    entity.lookAt(target, 30.0F, 30F);
                } else {
                    entity.setYRot(entity.yRotO);
                }

                if (entity.attackTicks == 5) {
                    if (target != null) {
                        float r = entity.distanceTo(target);
                        r = Mth.clamp(r, 1F, 4F);
                        entity.push(vecX * 0.45f * r, 0, vecZ * 0.45f * r);
                    } else {
                        entity.push(vecX * 1.8, 0, vecZ * 1.8);
                    }
                }
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(0);
            entity.setEye(false);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class SpearThrowGoal extends Goal {
        private final Scylla_Entity entity;
        private final int getattackstate;
        private final float attackMinrange;
        private final float attackMaxrange;
        private final int attackseetick;
        private final float random;


        public SpearThrowGoal(Scylla_Entity entity, int getattackstate ,float attackMinrange,float attackMaxrange,int attackseetick,float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.attackMinrange = attackMinrange;
            this.attackMaxrange = attackMaxrange;
            this.attackseetick = attackseetick;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive()  && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.distanceTo(target) > attackMinrange && this.entity.distanceTo(target) < attackMaxrange && this.entity.getAttackState() == getattackstate;
        }

        @Override
        public void start() {
            if (this.entity.random.nextBoolean()) {
                this.entity.setAttackState(8);
            } else {
                this.entity.setAttackState(9);
            }
            entity.setEye(true);
        }

        @Override
        public boolean canContinueToUse() {
            return (this.entity.getAttackState() == 8 || this.entity.getAttackState() == 9) && this.entity.attackTicks <= 53;
        }


        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if (entity.attackTicks == 27) {
                if (target != null) {
                    float f = Mth.cos(entity.yBodyRot * ((float)Math.PI / 180F)) ;
                    float f1 = Mth.sin(entity.yBodyRot * ((float)Math.PI / 180F)) ;
                    float math = -0.5F;
                    double d0 = entity.getX() + f * math;
                    double d1 = entity.getY() + entity.getBbHeight() * 0.8F;
                    double d2 = entity.getZ()+ f1 * math;
                    double d3 = target.getX() - d0;
                    double d4 = target.getY() + entity.getBbHeight() * 0.5F - d1;
                    double d5 = target.getZ() - d2;
                    Vec3 vec3 = new Vec3(d3, d4, d5).normalize();
                    float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;

                    float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));
                    if (entity.getAttackState() == 9) {
                        Water_Spear_Entity water = new Water_Spear_Entity(entity, vec3, entity.level(), (float) CMConfig.HarbingerWitherMissiledamage);

                        water.setYRot(yRot);
                        water.setXRot(xRot);
                        water.setPosRaw(d0, d1, d2);


                        entity.level().addFreshEntity(water);
                    }
                    if (entity.getAttackState() == 8) {
                        Lightning_Spear_Entity lightning = new Lightning_Spear_Entity(entity, vec3, entity.level(), (float) CMConfig.HarbingerWitherMissiledamage);

                        lightning.setYRot(yRot);
                        lightning.setXRot(xRot);
                        lightning.setPosRaw(d0, d1, d2);


                        entity.level().addFreshEntity(lightning);
                    }
                }
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(0);
            entity.setEye(false);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }


    static class Back_StepGoal extends InternalAttackGoal {
        private final float random;


        public Back_StepGoal(Scylla_Entity entity, int attackstate, int attackgetstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, float random) {
            super(entity,attackstate,attackgetstate,attackendstate,attackMaxtick,attackseetick,attackrange);
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random;
        }


        @Override
        public void start() {
            super.start();
            float speed = -1.5f;
            float dodgeYaw = (float) Math.toRadians(this.entity.getYRot() + 90 + this.entity.getRandom().nextFloat() * 120 - 60);
            Vec3 m = this.entity.getDeltaMovement().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
            this.entity.setDeltaMovement(m.x, 0.3, m.z);

        }

        @Override
        public void stop() {
            super.stop();
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

}





