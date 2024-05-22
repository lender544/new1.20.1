package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.cataclysm.world.data.CMWorldData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import java.util.List;


public class Ignited_Berserker_Entity extends Internal_Animation_Monster {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState xslashAnimationState = new AnimationState();
    public AnimationState mixerstartAnimationState = new AnimationState();
    public AnimationState mixeridleAnimationState = new AnimationState();
    public AnimationState mixerfinishAnimationState = new AnimationState();
    public AnimationState sworddanceleftAnimationState = new AnimationState();
    public AnimationState sworddancerightAnimationState = new AnimationState();
    private int sword_dance_cooldown = 0;
    public static final int SWORD_DANCE_COOLDOWN = 40;

    private int spin_cooldown = 0;
    public static final int SPIN_COOLDOWN = 80;

    public Ignited_Berserker_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 20;
        this.setMaxUpStep(1.25F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(2, new InternalMoveGoal(this,false,1.0D));

        //x slash
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,1,0,50,15,3.6F){
            @Override
            public boolean canUse() {
                return super.canUse() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0F < 12f;
            }

        });

        //sword dance left
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,5,0,50,50,4.5F) {
            @Override
            public boolean canUse() {
                return super.canUse() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Ignited_Berserker_Entity.this.sword_dance_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Ignited_Berserker_Entity.this.sword_dance_cooldown = SWORD_DANCE_COOLDOWN;
            }

        });
        //sword dance right
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,6,0,55,55,4.5F){
            @Override
            public boolean canUse() {
                return super.canUse() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0F < 16f && Ignited_Berserker_Entity.this.sword_dance_cooldown <= 0;
            }
            @Override
            public void stop() {
                super.stop();
                Ignited_Berserker_Entity.this.sword_dance_cooldown = SWORD_DANCE_COOLDOWN;
            }
        });

        //mixer start
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,2,3,30,25,8F){
            @Override
            public boolean canUse() {
                return super.canUse() && Ignited_Berserker_Entity.this.getRandom().nextFloat() * 100.0F < 12f && Ignited_Berserker_Entity.this.spin_cooldown <= 0;
            }

        });
        //mixer idle
        this.goalSelector.addGoal(1, new InternalStateGoal(this,3,3,4,90,0, false));

        //mixer stop
        this.goalSelector.addGoal(1, new InternalStateGoal(this,4,4,0,40,0){

            @Override
            public void stop() {
                super.stop();
                Ignited_Berserker_Entity.this.spin_cooldown = SPIN_COOLDOWN;
            }
        });


    }

    public static AttributeSupplier.Builder ignited_berserker() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.32F)
                .add(Attributes.ATTACK_DAMAGE, 7.5F)
                .add(Attributes.MAX_HEALTH, 65)
                .add(Attributes.ARMOR, 8)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "x_slash") {
            return this.xslashAnimationState;
        } else if (input == "mixer_start") {
            return this.mixerstartAnimationState;
        } else if (input == "mixer_idle") {
            return this.mixeridleAnimationState;
        } else if (input == "mixer_finish") {
            return this.mixerfinishAnimationState;
        } else if (input == "idle") {
                return this.idleAnimationState;
        } else if (input == "sword_dance_left") {
            return this.sworddanceleftAnimationState;
        } else if (input == "sword_dance_right") {
            return this.sworddancerightAnimationState;
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
                        this.xslashAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.mixerstartAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.mixeridleAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.mixerfinishAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.sworddanceleftAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.sworddancerightAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.xslashAnimationState.stop();
        this.mixerstartAnimationState.stop();
        this.mixeridleAnimationState.stop();
        this.mixerfinishAnimationState.stop();
        this.sworddanceleftAnimationState.stop();
        this.sworddancerightAnimationState.stop();
    }

    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(0);
    }

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        if (ModEntities.rollSpawn(CMConfig.IgnitedBerserkerSpawnRolls, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerLevel serverLevel) {
            CMWorldData data = CMWorldData.get(serverLevel,Level.NETHER);
            return data != null && data.isIgnisDefeatedOnce();
        }
        return false;

    }

    public int deathtimer(){
        return 20;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }


    public void tick() {
        super.tick();
        if (!this.onGround() && this.getDeltaMovement().y < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        }
        if (sword_dance_cooldown > 0) sword_dance_cooldown--;
        if (spin_cooldown > 0) spin_cooldown--;

        float dis = this.getBbWidth() * 0.75F;
        repelEntities(dis, this.getBbHeight(), dis, dis);

    }

    public void aiStep() {
        super.aiStep();
        float dis = this.getBbWidth();

        float f1 = (float) Math.cos(Math.toRadians(this.getYRot() + 90));
        float f2 = (float) Math.sin(Math.toRadians(this.getYRot() + 90));

        if(this.getAttackState() == 1) {
            if (this.attackTicks == 17) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 4.35f,dis * 4.35f,45,1.25F,60);
            }
            if (this.attackTicks == 35) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 3.6f,dis * 3.6f,200,1.25F,0);
            }
        }
        if(this.getAttackState() == 3) {
            if (this.tickCount % 4 == 0) {
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.0D))) {
                    if (!isAlliedTo(entity) && !(entity instanceof Ignited_Berserker_Entity) && entity != this) {
                        boolean flag = entity.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
                        if (flag) {
                            double d0 = entity.getX() - this.getX();
                            double d1 = entity.getZ() - this.getZ();
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                            entity.push(d0 / d2 * 0.5D, 0.1D, d1 / d2 * 0.5D);
                        }
                    }
                }
            }
        }

        if(this.getAttackState() == 5) {
            if (this.attackTicks == 11 || this.attackTicks == 18 || this.attackTicks == 23 || this.attackTicks == 28  ) {
                this.push(f1 * 0.45, 0, f2 * 0.45);
            }
            if (this.attackTicks == 13) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 4.5f,dis * 4.5f,50,1,0);
            }
            if (this.attackTicks == 20) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 3.5f,dis * 3.5f,60,1,0);
            }
            if (this.attackTicks == 25) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 4.5f,dis * 4.5f,60,1,0);
            }
            if (this.attackTicks == 30) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 3.25f,dis * 3.25f,60,1,0);
            }
        }
        if(this.getAttackState() == 6) {
            if (this.attackTicks == 15 || this.attackTicks == 123 || this.attackTicks == 26 || this.attackTicks == 33) {
                this.push(f1 * 0.45, 0, f2 * 0.45);
            }
            if (this.attackTicks == 17) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 4.5f,dis * 4.5f,40,1,0);
            }
            if (this.attackTicks == 25) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 3.25f,dis * 3.25f,55,1,0);
            }
            if (this.attackTicks == 28) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 5f,dis * 5f,60,1,0);
            }
            if (this.attackTicks == 35) {
                this.playSound(ModSounds.SWING.get(), 1F, 1.2f);
                AreaAttack(dis * 3.5f,dis * 3.5f,40,1,0);
            }
        }

    }


    private void AreaSwordAttack(float range, float height,float degree, float arc, float damage) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - degree) % 360);
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
                if (!isAlliedTo(entityHit) && entityHit != this) {
                    boolean flag = entityHit.hurt(CMDamageTypes.causeSwordDanceDamage(this), (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                    if (flag) {
                        MobEffectInstance effectinstance1 = entityHit.getEffect(ModEffect.EFFECTBLAZING_BRAND.get());
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            entityHit.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND.get());
                        } else {
                            --i;
                        }
                        i = Mth.clamp(i, 0, 1);
                        MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 120, i, false, true, true);
                        entityHit.addEffect(effectinstance);
                        this.heal(3 * (i + 1));
                    }
                }
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ignited_Berserker_Entity) && entityHit != this) {
                    DamageSource damagesource = CMDamageTypes.causeSwordDanceDamage(this);
                    boolean flag = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                    if (entityHit instanceof Player && entityHit.isDamageSourceBlocked(damagesource) && shieldbreakticks > 0) {
                        disableShield(entityHit, shieldbreakticks);
                    }


                    if (flag) {
                        MobEffectInstance effectinstance1 = entityHit.getEffect(ModEffect.EFFECTBLAZING_BRAND.get());
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            entityHit.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND.get());
                        } else {
                            --i;
                        }
                        i = Mth.clamp(i, 0, 1);
                        MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 100, i, false, true, true);
                        entityHit.addEffect(effectinstance);
                        this.heal(2F * (i + 1));
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
        } else if (entityIn.getType().is(ModTag.TEAM_IGNIS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.REVENANT_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.REVENANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.REVENANT_DEATH.get();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }

}





