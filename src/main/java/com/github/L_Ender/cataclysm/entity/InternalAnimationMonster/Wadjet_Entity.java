package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ancient_Remnant_Entity;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Nameless_Sorcerer_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.*;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMMathUtil;
import com.github.L_Ender.lionfishapi.client.model.tools.DynamicChain;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.EnumSet;
import java.util.List;


public class Wadjet_Entity extends Internal_Animation_Monster {
    @OnlyIn(Dist.CLIENT)
    public DynamicChain dc;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState stabnswingAnimationState = new AnimationState();
    public AnimationState doublswingAnimationState = new AnimationState();
    public AnimationState spearchargeAnimationState = new AnimationState();
    public AnimationState magicAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public static final EntityDataAccessor<Boolean> STAB = SynchedEntityData.defineId(Wadjet_Entity.class, EntityDataSerializers.BOOLEAN);
    private float prevAttackProgress;
    private float AttackProgress;

    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 160;
    private int magic_cooldown = 0;
    public static final int MAGIC_COOLDOWN = 160;

    public Wadjet_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
        if (world.isClientSide) {
            dc = new DynamicChain(this);
        }
        this.setMaxUpStep(1.25F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        setConfigattribute(this, CMConfig.WadjetHealthMultiplier, CMConfig.WadjetDamageMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new InternalMoveGoal(this, false, 1.0D));
        this.goalSelector.addGoal(1, new ChargeAttackGoal(this,0,1,0,45,15,20,5.5F,16));
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,3,0,60,60,5){
            @Override
            public boolean canUse() {
                return super.canUse() && Wadjet_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Wadjet_Entity.this.setStab(Wadjet_Entity.this.random.nextBoolean());
            }
        });

        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,4,0,55,55,5){
            @Override
            public boolean canUse() {
                return super.canUse() && !Wadjet_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Wadjet_Entity.this.setStab(Wadjet_Entity.this.random.nextBoolean());
            }
        });

        this.goalSelector.addGoal(1, new MagicAttackGoal(this,0,2,0,35,15,3.5F,12));

    }

    public static AttributeSupplier.Builder wadjet() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 9)
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.ARMOR, 5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7);
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof Poison_Dart_Entity) {
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
        if (input == "charge") {
            return this.spearchargeAnimationState;
        } else if (input == "magic") {
            return this.magicAnimationState;
        } else if (input == "stabnswing") {
            return this.stabnswingAnimationState;
        } else if (input == "doubleswing") {
            return this.doublswingAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STAB, false);
    }

    public void setStab(boolean stab) {
        this.entityData.set(STAB, stab);
    }

    public boolean getStab() {
        return this.entityData.get(STAB);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.spearchargeAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.magicAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.stabnswingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.doublswingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }
        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.spearchargeAnimationState.stop();
        this.magicAnimationState.stop();
        this.stabnswingAnimationState.stop();
        this.doublswingAnimationState.stop();
        this.deathAnimationState.stop();
    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(5);
    }

    public int deathtimer() {
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
        prevAttackProgress = AttackProgress;
        if (isAggressive() && AttackProgress < 10F) {
            AttackProgress++;
        }
        if (!isAggressive() && AttackProgress > 0F) {
            AttackProgress--;
        }
        if (charge_cooldown > 0) charge_cooldown--;
        if (magic_cooldown > 0) magic_cooldown--;
    }

    public void aiStep() {
        super.aiStep();
        if(this.getAttackState() == 1) {
            if (this.attackTicks == 18) {
                this.playSound(ModSounds.IGNIS_POKE.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 20) {
                AreaAttack(9.0f,6.0F,45,1,120);
            }
        }
        if(this.getAttackState() == 2) {
            if (this.attackTicks == 15) {
                this.playSound(SoundEvents.EVOKER_PREPARE_ATTACK, 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
            }
        }
        if(this.getAttackState() == 3) {
            if (this.attackTicks == 14) {
                this.playSound(ModSounds.IGNIS_POKE.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(8.0f,6.0F,45,1,120);
            }
            if (this.attackTicks == 37) {
                this.playSound(ModSounds.SWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.0f,4.0F,220,1,70);
            }
        }

        if(this.getAttackState() == 4) {
            if (this.attackTicks == 14) {
                this.playSound(ModSounds.SWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.0f,4.0F,220,1,70);
            }
            if (this.attackTicks == 28) {
                this.playSound(ModSounds.SWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(6.0f,4.0F,220,1,70);
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Kobolediator_Entity) && entityHit != this) {
                    entityHit.hurt(this.damageSources().mobAttack(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                    if (entityHit instanceof Player && entityHit.isBlocking() && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }
                }
            }
        }
    }

    public float getAttackProgress(float partialTicks) {
        return (prevAttackProgress + (AttackProgress - prevAttackProgress) * partialTicks);
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
        return ModSounds.WADJET_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.WADJET_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return  ModSounds.WADJET_AMBIENT.get();
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

    static class ChargeAttackGoal extends Goal {
        protected final Wadjet_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final int attackshottick;
        private final float attackminrange;
        private final float attackrange;

        public ChargeAttackGoal(Wadjet_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,int attackshottick,float attackminrange,float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackshottick = attackshottick;
            this.attackminrange = attackminrange;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.distanceTo(target) > attackminrange && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < 16f && this.entity.charge_cooldown <= 0;
        }

        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.attackCooldown = 0;
            this.entity.charge_cooldown = CHARGE_COOLDOWN;
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.attackTicks < attackMaxtick;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.setYRot(entity.yBodyRot);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if (entity.attackTicks == attackseetick) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYRot() + 90));
                if(target != null) {
                    float r = entity.distanceTo(target);
                    r = Mth.clamp(r, 0, 4);
                    entity.push(f1 * 0.3 * r, 0, f2 * 0.3 * r);
                }else{
                    entity.push(f1 * 2.0, 0, f2 * 2.0);
                }
            }
            if (entity.attackTicks == attackshottick) {
                if (target != null) {
                    double d1 = 5.0D;
                    Vec3 vec3 = entity.getViewVector(1.0F);
                    double d2 = target.getX() - (entity.getX() + vec3.x * d1);
                    double d3 = target.getY(0.5D) - entity.getY(0.15D);
                    double d4 = target.getZ() - (entity.getZ() + vec3.z * d1);
                    Sandstorm_Projectile largefireball = new Sandstorm_Projectile(entity, d2, d3, d4, entity.level(),6);
                    largefireball.setPos(entity.getX() + vec3.x * d1, entity.getY(0.15D), largefireball.getZ() + vec3.z * d1);
                    entity.level().addFreshEntity(largefireball);
                }
            }
        }
    }

    static class MagicAttackGoal extends Goal {
        protected final Wadjet_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackminrange;
        private final float attackrange;

        public MagicAttackGoal(Wadjet_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick,int attackseetick,float attackminrange,float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackminrange = attackminrange;
            this.attackrange = attackrange;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && this.entity.distanceTo(target) > attackminrange && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < 24f && this.entity.magic_cooldown <= 0;
        }

        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            this.entity.attackCooldown = 0;
            this.entity.magic_cooldown = MAGIC_COOLDOWN;
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.attackTicks < attackMaxtick;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                if (entity.attackTicks == attackseetick) {
                    double d1 = target.getY();
                    float f = (float) Mth.atan2(target.getZ() - this.entity.getZ(), target.getX() - this.entity.getX());

                    for(int k = 0; k < 8; ++k) {
                        float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + ((float) Math.PI * 2F / 5F);
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos(f2) * 4.5D, this.entity.getZ() + (double)Mth.sin(f2) * 4.5D, d1, f2, 3);
                    }
                    for (int k = 0; k < 13; ++k) {
                        float f3 = f + (float) k * (float) Math.PI * 2.0F / 13.0F + ((float) Math.PI * 2F / 10F);
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos(f3) * 6.5D, this.entity.getZ() + (double)Mth.sin(f3) * 6.5D, d1, f3, 10);
                    }
                    for (int k = 0; k < 16; ++k) {
                        float f4 = f + (float) k * (float) Math.PI * 2.0F / 16.0F + ((float) Math.PI * 2F / 20F);
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos(f4) * 8.5D, this.entity.getZ() + (double)Mth.sin(f4) * 8.5D, d1, f4, 15);
                    }
                    for (int k = 0; k < 19; ++k) {
                        float f5 = f + (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 40F);
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos(f5) * 10.5D, this.entity.getZ() + (double)Mth.sin(f5) * 10.5D, d1, f5, 20);
                    }
                    for (int k = 0; k < 24; ++k) {
                        float f6 = f + (float) k * (float) Math.PI * 2.0F / 24.0F + ((float) Math.PI * 2F / 80F);
                        this.spawnSpikeLine(this.entity.getX() + (double)Mth.cos(f6) * 12.5D, this.entity.getZ() + (double)Mth.sin(f6) * 12.5D, d1, f6, 30);
                    }
                }
            }

        }

        private void spawnSpikeLine(double posX, double posZ, double posY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.containing(posX, posY, posZ);
            double d0 = 0.0D;
            do {
                BlockPos blockpos1 = blockpos.above();
                BlockState blockstate = entity.level().getBlockState(blockpos1);
                if (blockstate.isFaceSturdy(entity.level(), blockpos1, Direction.DOWN)) {
                    if (!entity.level().isEmptyBlock(blockpos)) {
                        BlockState blockstate1 = entity.level().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(entity.level(), blockpos);
                        if (!voxelshape.isEmpty()) {
                            d0 = voxelshape.max(Direction.Axis.Y);
                        }
                    }

                    break;
                }

                blockpos = blockpos.above();
            } while (blockpos.getY() < Math.min(entity.level().getMaxBuildHeight(), entity.getBlockY() + 12));
            this.entity.level().addFreshEntity(new Ancient_Desert_Stele_Entity(this.entity.level(), posX, (double)blockpos.getY() + d0 -3, posZ, rotation, delay, this.entity));

        }

    }


}





