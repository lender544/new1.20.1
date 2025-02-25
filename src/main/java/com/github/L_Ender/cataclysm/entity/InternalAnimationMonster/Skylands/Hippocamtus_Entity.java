package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Internal_Animation_Monster;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.DamageTypeTags;
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
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;


public class Hippocamtus_Entity extends Internal_Animation_Monster {

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState swing1AnimationState = new AnimationState();
    public AnimationState swing2AnimationState = new AnimationState();
    public AnimationState stabAnimationState = new AnimationState();

    public AnimationState guardAnimationState = new AnimationState();
    public AnimationState guardcounterAnimationState = new AnimationState();
    public AnimationState parryingAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();

    public static final EntityDataAccessor<Boolean> STAB = SynchedEntityData.defineId(Hippocamtus_Entity.class, EntityDataSerializers.BOOLEAN);

    private int block_stage = 0;

    private int charge_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 100;
    private int guard_cooldown = 0;
    public static final int GUARD_COOLDOWN = 160;

    public Hippocamtus_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 35;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(3, new InternalMoveGoal(this, false, 1.0D));
        this.goalSelector.addGoal(2, new ChargeAttackGoal(this,0,3,0,41,13,4.5F,16));
        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,4,0,50,50,4.0f){

            @Override
            public boolean canUse() {
                return super.canUse() && Hippocamtus_Entity.this.getRandom().nextFloat() * 100.0F < 48f  && Hippocamtus_Entity.this.guard_cooldown <= 0;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && Hippocamtus_Entity.this.block_stage ==0;
            }

            @Override
            public void stop() {
                Hippocamtus_Entity.this.guard_cooldown = GUARD_COOLDOWN;
                if(Hippocamtus_Entity.this.block_stage == 1){
                    this.entity.setAttackState(5);
                }else if (Hippocamtus_Entity.this.block_stage == 2){
                    this.entity.setAttackState(6);
                }else {
                    super.stop();
                }

            }
        });
        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,1,0,45,8,4.0f){
            @Override
            public boolean canUse() {
                return super.canUse() && Hippocamtus_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Hippocamtus_Entity.this.setStab(Hippocamtus_Entity.this.random.nextBoolean());
            }
        });

        this.goalSelector.addGoal(2, new InternalAttackGoal(this,0,2,0,39,8,4.0f){
            @Override
            public boolean canUse() {
                return super.canUse() && !Hippocamtus_Entity.this.getStab();
            }

            @Override
            public void stop() {
                super.stop();
                Hippocamtus_Entity.this.setStab(Hippocamtus_Entity.this.random.nextBoolean());
            }
        });



        this.goalSelector.addGoal(1, new InternalStateGoal(this,5,5,0,64,64){

            @Override
            public void stop() {
                super.stop();
                Hippocamtus_Entity.this.block_stage = 0;
            }
        });

        this.goalSelector.addGoal(1, new InternalStateGoal(this,6,6,0,51,51){

            @Override
            public void stop() {
                super.stop();
                Hippocamtus_Entity.this.block_stage = 0;
            }
        });
    }


    public static AttributeSupplier.Builder Hippocamtus_Entity() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 10)
                .add(Attributes.MAX_HEALTH, 85)
                .add(Attributes.ARMOR, 15)
                .add(Attributes.STEP_HEIGHT, 1.75F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7);
    }





    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();

        if (!source.is(DamageTypeTags.BYPASSES_SHIELD) &&!this.isNoAi() && this.getAttackState() == 4) {
            Vec3 vector3d2 = source.getSourcePosition();
            if (vector3d2 != null) {
                Vec3 vector3d = this.getViewVector(1.0F);
                Vec3 vector3d1 = vector3d2.vectorTo(this.position()).normalize();
                vector3d1 = new Vec3(vector3d1.x, 0.0D, vector3d1.z);
                if(vector3d1.dot(vector3d) < 0.0D){
                    if (this.attackTicks >= 7 && this.attackTicks <= 17) {
                        if(entity instanceof LivingEntity living) {
                            this.block_stage = 1;
                            if (!this.level().isClientSide ) {
                                living.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, 50));
                            }
                            this.playSound(ModSounds.PARRY.get(),2.0F,1.0F);
                        }
                        return false;

                    }else if (this.attackTicks > 17 && this.attackTicks <= 43){
                        if(entity instanceof LivingEntity living) {
                            this.block_stage =2;
                            living.knockback(0.5F, this.getX() - living.getX(), this.getZ() - living.getZ());
                        }
                        return false;
                    } else{
                        return super.hurt(source, damage);
                    }
                }
            }
        }


        return super.hurt(source, damage);
    }



    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        boolean flag = false;
        if (!this.isNoAi() && !flag && this.getAttackState() == 4) {
            Vec3 vector3d2 = damageSourceIn.getSourcePosition();
            if (vector3d2 != null) {
                Vec3 vector3d = this.getViewVector(1.0F);
                Vec3 vector3d1 = vector3d2.vectorTo(this.position()).normalize();
                vector3d1 = new Vec3(vector3d1.x, 0.0D, vector3d1.z);
                //막기 가능
                return vector3d1.dot(vector3d) < 0.0D && this.attackTicks >= 7 && this.attackTicks <= 43;
            }
        }
        return false;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }



    public AnimationState getAnimationState(String input) {
        if (input == "swing1") {
            return this.swing1AnimationState;
        } else if (input == "swing2") {
            return this.swing2AnimationState;
        } else if (input == "stab") {
            return this.stabAnimationState;
        } else if (input == "guard") {
            return this.guardAnimationState;
        } else if (input == "guardcounter") {
            return this.guardcounterAnimationState;
        } else if (input == "parry") {
            return this.parryingAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(STAB, false);
    }

    public void setStab(boolean stab) {
        this.entityData.set(STAB, stab);
    }

    public boolean getStab() {
        return this.entityData.get(STAB);
    }



    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.swing1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.swing2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.stabAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.guardAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.parryingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.guardcounterAnimationState.startIfStopped(this.tickCount);
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
        this.swing1AnimationState.stop();
        this.swing2AnimationState.stop();
        this.stabAnimationState.stop();
        this.guardAnimationState.stop();
        this.guardcounterAnimationState.stop();
        this.parryingAnimationState.stop();
        this.deathAnimationState.stop();
    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(7);
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
            this.idleAnimationState.animateWhen(this.getAttackState() != 7 , this.tickCount);
        }

        if (charge_cooldown > 0) charge_cooldown--;
        if (guard_cooldown > 0) guard_cooldown--;
    }

    public void aiStep() {
        super.aiStep();

        if(this.getAttackState() == 3) {
            if (this.attackTicks == 16) {
                this.playSound(ModSounds.IGNIS_POKE.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 18) {
                AreaAttack(8.5f,6.0F,45,1,90,false,false);
            }
        }

        if(this.getAttackState() == 1) {
            if (this.attackTicks == 11) {
                this.playSound(ModSounds.SWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.0f,5.0F,200,1,70,false,false);
            }
        }

        if(this.getAttackState() == 2) {
            if (this.attackTicks == 11) {
                this.playSound(ModSounds.SWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(5.0f,5.0F,200,1,60,false,false);
            }
        }
        if(this.getAttackState() == 5) {
            if(this.attackTicks == 1){
                parryParticle(1.5f,0.9f,-0.1f);
            }

            if (this.attackTicks == 35 || this.attackTicks == 42 || this.attackTicks == 48) {
                this.playSound(ModSounds.SWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(7.0f,6.0F,45,0.9f,90,false,true);
            }
        }
        if(this.getAttackState() == 6) {
            if (this.attackTicks == 10 || this.attackTicks == 17 || this.attackTicks == 24) {
                this.playSound(ModSounds.SWING.get(), 1.0f, 1.25F + this.getRandom().nextFloat() * 0.1F);
                AreaAttack(7.0f,6.0F,45,0.9f,90,false,true);
            }
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Hippocamtus_Entity) && entityHit != this) {
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


    private void parryParticle(float height, float vec,float math) {
        if (this.level().isClientSide) {
            double d0 = this.getX();
            double d1 = this.getY() + height;
            double d2 = this.getZ();

            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));

            double theta = (yBodyRot) * (Math.PI / 180);  // 엔티티의 Y축 회전
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);

            double theta2 = theta + Math.PI / 2;
            double X = Math.cos(theta2);
            double Z = Math.sin(theta2);

            for (int i = 0; i < 12; i++) {
                float throwAngle = i * Mth.PI / 6F;
                double y = 2 * Math.sin(throwAngle);
                double xz = 2 * Math.cos(throwAngle);
                double d3 = xz * vecX + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                double d4 = y + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                double d5 = xz * vecZ + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                double speed = 0.35;
                this.level().addParticle(ModParticle.SPARK.get(), d0 + vec * X + f * math, d1, d2 + vec * Z  + f1 * math, d3 * speed, d4 * speed, d5 * speed);
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
        return p_34192_.getEffect() != ModEffect.EFFECTABYSSAL_CURSE.get() && super.canBeAffected(p_34192_);
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
        protected final Hippocamtus_Entity entity;

        private final int getAttackState;

        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackminrange;
        private final float attackrange;

        public ChargeAttackGoal(Hippocamtus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE,Flag.LOOK,Flag.JUMP));
            this.getAttackState = getAttackState;
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
            return target != null && this.entity.distanceTo(target) > attackminrange && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getAttackState && this.entity.getRandom().nextFloat() * 100.0F < 16f && this.entity.charge_cooldown <= 0;
        }

        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
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
                    r = Mth.clamp(r, 0, 5);
                    entity.push(f1 * 0.4 * r, 0, f2 * 0.4 * r);
                }else{
                    entity.push(f1 * 2.0, 0, f2 * 2.0);
                }
            }
        }
    }
}





