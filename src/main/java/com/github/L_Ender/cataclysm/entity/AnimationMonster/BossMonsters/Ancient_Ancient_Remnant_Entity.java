package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Ancient_Desert_Stele_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.EarthQuake_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import com.github.L_Ender.lionfishapi.server.animation.LegSolver;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;


public class Ancient_Ancient_Remnant_Entity extends LLibrary_Boss_Monster {

    public static final Animation REMNANT_BITE1 = Animation.create(61);
    public static final Animation REMNANT_BITE2 = Animation.create(67);
    public static final Animation REMNANT_CHARGE_PREPARE = Animation.create(125);
    public static final Animation REMNANT_TAIL_ATTACK1 = Animation.create(57);
    public static final Animation REMNANT_TAIL_ATTACK2 = Animation.create(55);
    public static final Animation REMNANT_LEFT_STOMP = Animation.create(47);
    public static final Animation REMNANT_RIGHT_STOMP = Animation.create(47);
    public static final Animation REMNANT_LEFT_STOMP_EXTRA = Animation.create(38);
    public static final Animation REMNANT_RIGHT_STOMP_EXTRA = Animation.create(38);
    public static final Animation REMNANT_ROAR = Animation.create(70);
    public static final Animation REMNANT_ROAR2 = Animation.create(100);
    public static final Animation REMNANT_PHASE_ROAR = Animation.create(100);
    public static final Animation REMNANT_TAIL_THREE = Animation.create(104);
    public static final Animation REMNANT_DEATH = Animation.create(158);
    private static final EntityDataAccessor<Boolean> CHARGE = SynchedEntityData.defineId(Ancient_Ancient_Remnant_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_ACT = SynchedEntityData.defineId(Ancient_Ancient_Remnant_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> POWER = SynchedEntityData.defineId(Ancient_Ancient_Remnant_Entity.class, EntityDataSerializers.BOOLEAN);
    public final LegSolver legSolver = new LegSolver(new LegSolver.Leg(0F, 0.75F, 4.0F, false), new LegSolver.Leg(0F, -0.75F, 4.0F, false));
    private AttackMode mode = AttackMode.CIRCLE;
    public float chargeProgress;
    public float prevchargeProgress;
    public float activeProgress;
    public float prevactiveProgress;
    private int hunting_cooldown = 160;
    private int charge_cooldown = 0;
    private int roar_cooldown = 0;
    private int roar2_cooldown = 0;
    private int earthquake_cooldown = 0;
    private int stomp_cooldown = 0;
    public static final int CHARGE_COOLDOWN = 250;
    public static final int ROAR_COOLDOWN = 500;
    public static final int ROAR2_COOLDOWN = 200;
    public static final int EARTHQUAKE_COOLDOWN = 160;
    public static final int STOMP_COOLDOWN = 200;
    private final CMBossInfoServer bossEvent = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.WHITE,false,7);
    public static final int NATURE_HEAL_COOLDOWN = 200;
    private int timeWithoutTarget;
    public int frame;
    public static final int MINE_COOLDOWN = 100;
    public Ancient_Ancient_Remnant_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.setMaxUpStep(1.5F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        setConfigattribute(this, CMConfig.AncientRemnantHealthMultiplier, CMConfig.AncientRemnantDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{
                NO_ANIMATION,
                REMNANT_BITE1,
                REMNANT_CHARGE_PREPARE,
                REMNANT_BITE2,
                REMNANT_TAIL_ATTACK1,
                REMNANT_TAIL_ATTACK2,
                REMNANT_LEFT_STOMP,
                REMNANT_RIGHT_STOMP,
                REMNANT_ROAR,
                REMNANT_TAIL_THREE,
                REMNANT_ROAR2,REMNANT_LEFT_STOMP_EXTRA,REMNANT_RIGHT_STOMP_EXTRA,REMNANT_PHASE_ROAR,REMNANT_DEATH};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new RemnantAttackGoal(this));
        this.goalSelector.addGoal(0, new AwakenGoal());
        this.goalSelector.addGoal(1, new RemnantChargeAttackGoal(this, REMNANT_CHARGE_PREPARE));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_BITE1,29));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_BITE2,25));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_LEFT_STOMP,24));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_RIGHT_STOMP,24));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_LEFT_STOMP_EXTRA,19));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_RIGHT_STOMP_EXTRA,19));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_TAIL_ATTACK1,13));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_TAIL_ATTACK2,11));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_ROAR,11));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_TAIL_THREE,20));
        this.goalSelector.addGoal(1, new RemnantSteleAttackGoal(this, REMNANT_ROAR2,29));
        this.goalSelector.addGoal(1, new RemnantAnimationAttackGoal(this, REMNANT_PHASE_ROAR,29));
        this.goalSelector.addGoal(1, new SimpleAnimationGoal<>(this, REMNANT_DEATH));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 120, true, true, ModEntities.buildPredicateFromTag(ModTag.ANCIENT_REMNANT_TARGET)));
    }

    public static AttributeSupplier.Builder ancient_remnant() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 70.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.33F)
                .add(Attributes.ATTACK_DAMAGE, 25)
                .add(Attributes.MAX_HEALTH, 400)
                .add(Attributes.ARMOR, 10)
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

    public boolean canBeSeenAsEnemy() {
        return this.getIsAct() && super.canBeSeenAsEnemy();
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
        double range = calculateRange(source);
        if (this.getAnimation() == REMNANT_PHASE_ROAR && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (range > CMConfig.AncientRemnantLongRangelimit * CMConfig.AncientRemnantLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getDirectEntity();
        if (entity instanceof AbstractArrow) {
            return false;
        }
        if (this.activeProgress > 0) {
            if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                return false;
            }
        }

        return super.hurt(source, damage);
    }

    @Override
    public float DamageCap() {
        return (float) CMConfig.AncientRemnantDamageCap;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CHARGE, false);
        this.entityData.define(IS_ACT, true);
        this.entityData.define(POWER, false);
    }

    public void setIsAct(boolean isAct) {
        this.entityData.set(IS_ACT, isAct);
    }

    public boolean getIsAct() {
        return this.entityData.get(IS_ACT);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Is_Act", this.getIsAct());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setIsAct(compound.getBoolean("Is_Act"));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void setIsCharge(boolean isAnger) {
        this.entityData.set(CHARGE, isAnger);
    }

    public boolean getIsCharge() {
        return this.entityData.get(CHARGE);
    }

    public void setIsPower(boolean isPower) {
        this.entityData.set(POWER, isPower);
    }

    public boolean getIsPower() {
        return this.entityData.get(POWER);
    }

    public boolean canStandOnFluid(FluidState p_204067_) {
        return p_204067_.is(FluidTags.WATER);
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    private void floatRemnant() {
        if (this.isInWater()) {
            CollisionContext collisioncontext = CollisionContext.of(this);
            if (collisioncontext.isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.WATER)) {
                this.setOnGround(true);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5D).add(0.0D, 0.05D, 0.0D));
            }
        }

    }

    public void tick() {
        super.tick();
       // setYRot(yBodyRot);
        prevchargeProgress = chargeProgress;
        prevactiveProgress = activeProgress;
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        if (this.getIsCharge() && chargeProgress < 3F) {
            chargeProgress++;
        }
        if (!this.getIsCharge() && chargeProgress > 0F) {
            chargeProgress--;
        }
        if (!this.getIsAct() && activeProgress < 20F) {
            activeProgress++;
        }
        if (this.getIsAct() && activeProgress > 0F) {
            activeProgress--;
        }

        this.legSolver.update(this, this.yBodyRot, this.getScale() );

        if (hunting_cooldown > 0) {
            hunting_cooldown--;
        }

        if (charge_cooldown > 0) charge_cooldown--;
        if (roar_cooldown > 0) roar_cooldown--;
        if (roar2_cooldown > 0) roar2_cooldown--;
        if (earthquake_cooldown > 0) earthquake_cooldown--;
        if (stomp_cooldown > 0) stomp_cooldown--;
        LivingEntity target = this.getTarget();
        if (!this.level().isClientSide) {
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAnimation() == NO_ANIMATION && timeWithoutTarget <= 0) {
                if (!isNoAi() && CMConfig.AncientRemnantNatureHealing > 0) {
                    if (this.tickCount % 20 == 0) {
                        this.heal((float) CMConfig.AncientRemnantNatureHealing);
                    }
                }
            }
        }

        if(this.getIsPower()) {
            if (this.tickCount % 20 == 0) {
                this.heal(2.0F);
            }
        }
        floatRemnant();
        Charge();
        frame++;
        float moveX = (float) (getX() - xo);
        float moveZ = (float) (getZ() - zo);
        float speed = Mth.sqrt(moveX * moveX + moveZ * moveZ);
        if (!this.isSilent() && frame % 8 == 1 && speed > 0.05 && this.getIsCharge() && this.onGround()) {
            this.playSound(ModSounds.REMNANT_CHARGE_STEP.get(), 1F, 1.0f);
            ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
        }

       if(this.isAlive() && this.getIsAct()) {
           if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.isPower() && !this.getIsPower()) {
               this.setAnimation(REMNANT_PHASE_ROAR);
           }
       }

       // if (!this.isSilent() && frame % 16 == 1 && speed > 0.05 && !this.getIsCharge()) {
       //     this.playSound(ModSounds.REMNANT_CHARGE_STEP.get(), 1F, 1.0f);
        //    ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.02f, 0, 10);
       // }
    }

    public boolean isPower() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    private void Charge() {
        if (getIsCharge()) {
            if (!this.level().isClientSide) {
                if(CMConfig.AncientRemnantBlockBreaking) {
                    ChargeBlockBreaking();
                }else{
                    if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                        ChargeBlockBreaking();
                    }
                }
            }
            if (this.tickCount % 4 == 0) {
                for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.5D))) {
                    if (!isAlliedTo(Lentity) && !(Lentity instanceof Ancient_Ancient_Remnant_Entity) && Lentity != this) {
                        boolean flag = Lentity.hurt(this.damageSources().mobAttack(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5f + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5f, Lentity.getMaxHealth() * CMConfig.RemnantChargeHpDamage)));
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
    }


    private void ChargeBlockBreaking(){
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.5D, 0.2D, 0.5D);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.REMNANT_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
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

    public void aiStep() {
        super.aiStep();

        if(this.getAnimation() == REMNANT_BITE1){
            if(this.getAnimationTick() == 5){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_BITE.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            if(this.getAnimationTick() == 28){
                AreaAttack(8,8,70,1.35f,(float) CMConfig.RemnantHpDamage,160,0);
            }
        }

        if(this.getAnimation() == REMNANT_BITE2){
            if(this.getAnimationTick() == 1){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_BITE.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            if(this.getAnimationTick() == 24){
                AreaAttack(8,8,70,1.35f,(float) CMConfig.RemnantHpDamage,160,0);
            }
        }


        if(this.getAnimation() == REMNANT_TAIL_ATTACK1){
            if(this.getAnimationTick() == 3) {
                this.level().playSound((Player) null, this, ModSounds.REMNANT_TAIL_SWING.get(), SoundSource.HOSTILE, 2.0f, 1.0f);
            }
            if(this.getAnimationTick() == 16){
                TailAreaAttack(8,8,1.05F,120,1.0f,(float) CMConfig.RemnantHpDamage,200,100);
            }
        }

        if(this.getAnimation() == REMNANT_TAIL_ATTACK2){
            if(this.getAnimationTick() == 1) {
                this.level().playSound((Player) null, this, ModSounds.REMNANT_TAIL_SWING.get(), SoundSource.HOSTILE, 2.0f, 1.0f);
            }
            if(this.getAnimationTick() == 14){
                TailAreaAttack(8,8,1.05F,120,1.0f,(float) CMConfig.RemnantHpDamage,200,100);
            }
        }

        if(this.getAnimation() == REMNANT_CHARGE_PREPARE){
            if(this.getAnimationTick() == 1){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_CHARGE_PREPARE.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
            }

            if(this.getAnimationTick() == 15){
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                StompParticle(-0.1f,-0.75f);
            }

            if(this.getAnimationTick() == 41){
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                StompParticle(-0.1f,0.75f);
            }

            if(this.getAnimationTick() == 62){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_CHARGE_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
            }
            if(this.getAnimationTick() == 132) {
                this.level().playSound((Player) null, this, ModSounds.REMNANT_BREATHING.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
        }

        if(this.getAnimation() == REMNANT_ROAR){
            if(this.getAnimationTick() == 14){
                this.level().playSound((Player) null, this, ModSounds.REMNANT_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 60);
            }
            if(this.getAnimationTick() == 55) {
                for (int i = 0; i < 4; i++) {
                    float angle = i * Mth.PI / 2F;
                    double sx = this.getX() + (Mth.cos(angle) * 8);
                    double sy = this.getY();
                    double sz = this.getZ() + (Mth.sin(angle) * 8);
                    Sandstorm_Entity projectile = new Sandstorm_Entity(this.level(), sx,sy,sz,300,angle,this.getUUID());
                    this.level().addFreshEntity(projectile);
                }
            }
        }
        if(this.getAnimation() == REMNANT_ROAR2){
            if(this.getAnimationTick() == 23){
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 60);
                this.level().playSound((Player) null, this, ModSounds.REMNANT_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
            }
        }

        if(this.getAnimation() == REMNANT_PHASE_ROAR){
            if(this.getAnimationTick() == 23){
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 60);
                this.level().playSound((Player) null, this, ModSounds.REMNANT_ROAR.get(), SoundSource.HOSTILE, 3.0f, 1.0f);
                setIsPower(true);
            }
        }

        if(this.getAnimation() == REMNANT_TAIL_THREE){
            if(this.getAnimationTick() == 1) {
                this.level().playSound((Player) null, this, ModSounds.REMNANT_TAIL_SLAM.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            if(this.getAnimationTick() == 37) {
                AreaAttack(10,10,50,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 20 + random.nextInt(10), -0.75f);
            }
            if(this.getAnimationTick() == 55) {
                AreaAttack(10,10,50,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 20 + random.nextInt(10), -0.75f);
            }
            if(this.getAnimationTick() == 73) {
                AreaAttack(10,10,50,1.0f,(float) CMConfig.RemnantHpDamage,160,0);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                EarthQuakeSummon(5.5f, 20 + random.nextInt(10), -0.75f);
            }

        }
        if(this.getAnimation() == REMNANT_LEFT_STOMP){
            if(this.getAnimationTick() == 28) {
                StompParticle(0.9f,1.3f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
                if(this.getIsPower()){
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, REMNANT_LEFT_STOMP_EXTRA);
                }
            }

            for (int l = 28; l <= 45; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.3f);
                }
            }
        }
        if(this.getAnimation() == REMNANT_LEFT_STOMP_EXTRA){
            for (int l = 2; l <= 19; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d2 = l + 1;
                    float ds = (float) (l + d2) / 2;
                    StompDamage(0.4f, l, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.3f);
                }
            }
            if(this.getAnimationTick() == 19) {
                StompParticle(0.9f, 1.3f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
            }
            for (int l = 19; l <= 36; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d = l - 17;
                    int d2 = l - 16;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, 1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,1.3f);
                }
            }
        }

        if(this.getAnimation() == REMNANT_RIGHT_STOMP){
            if(this.getAnimationTick() == 28) {
                StompParticle(0.9f,-1.3f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
                if(this.getIsPower()){
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, REMNANT_RIGHT_STOMP_EXTRA);
                }
            }
            for (int l = 28; l <= 45; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d = l - 26;
                    int d2 = l - 25;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.3f);
                }
            }
        }
        if(this.getAnimation() == REMNANT_RIGHT_STOMP_EXTRA){
            for (int l = 2; l <= 19; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d2 = l + 1;
                    float ds = (float) (l + d2) / 2;
                    StompDamage(0.4f, l, 6,0.9F, 0, -1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.3f,80, 0.85f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.3f);
                }
            }
            if(this.getAnimationTick() == 19) {
                StompParticle(0.9f, -1.3f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1F, 1.0f);
            }
            for (int l = 19; l <= 36; l = l + 2) {
                if (this.getAnimationTick() == l) {
                    int d = l - 17;
                    int d2 = l - 16;
                    float ds = (d + d2) / 2;
                    StompDamage(0.4f, d, 6,0.9F, 0, -1.3f,80, 1.0f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    StompDamage(0.4f, d2, 6,0.9F, 0, -1.3f,80, 1.0f, (float) CMConfig.RemnantStompHpDamage, 0.1f);
                    Stompsound(ds,-1.3f);
                }
            }
        }
        if(this.getAnimation() == REMNANT_DEATH){
            if(this.getAnimationTick() == 52 || this.getAnimationTick() == 62 || this.getAnimationTick() == 77) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.05f, 0, 8);
            }
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (item == ModItems.NECKLACE_OF_THE_DESERT.get() && !this.getIsAct()) {
            if (!player.isCreative()) {
                itemstack.shrink(1);
            }
            this.setIsAct(true);
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks) {
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ancient_Ancient_Remnant_Entity) && entityHit != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }


                    if (flag) {
                        if (stunticks > 0) {
                            entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), stunticks));
                        }
                    }

                }
            }
        }
    }


    private void TailAreaAttack(float range, float height, float height2 , float arc, float damage, float hpdamage, int shieldbreakticks, int stunticks) {
        List<LivingEntity> entitiesHit = this.getTailEntityLivingBaseNearby(range, height,height2, range, range);
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
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Ancient_Ancient_Remnant_Entity) && entityHit != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage, entityHit.getMaxHealth() * hpdamage) ));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }


                    if (flag) {
                        if (stunticks > 0) {
                            entityHit.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), stunticks));
                        }
                        double d0 = entityHit.getX() - this.getX();
                        double d1 = entityHit.getZ() - this.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        entityHit.push(d0 / d2 * 4.0D, 0.2D, d1 / d2 * 4.0D);
                    }

                }
            }
        }
    }

    private void StompDamage(float spreadarc, int distance, int height, float mxy, float vec,float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
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
            spawnBlocks(hitX,hitY + height ,hitZ, (int) (this.getY() - height),block, px, pz, mxy, vx, vz, factor, shieldbreakticks, damage, hpdamage);

        }
    }


    private void spawnBlocks(int hitX, int hitY, int hitZ, int lowestYCheck,BlockState blockState,double px,double pz,float mxy,double vx,double vz,float factor, int shieldbreakticks,float damage, float hpdamage) {
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
            if (!isAlliedTo(entity) && !(entity instanceof Ancient_Ancient_Remnant_Entity) && entity != this) {
                DamageSource damagesource = this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage + entity.getMaxHealth() * hpdamage));
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


    private void Stompsound(float distance,float math) {
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        this.level().playLocalSound(this.getX() + distance * vecX + f * math, this.getY(), this.getZ() + distance * vecZ + f1 * math, ModSounds.REMNANT_SHOCKWAVE.get(), this.getSoundSource(), 1.5f, 0.8F + this.getRandom().nextFloat() * 0.1F, false);
    }

    public  List<LivingEntity> getTailEntityLivingBaseNearby(double distanceX, double distanceMinY, double distanceMaxY,double distanceZ, double radius) {
        return getTailEntitiesNearby(LivingEntity.class, distanceX, distanceMinY,distanceMaxY, distanceZ, radius);
    }

    public <T extends Entity> List<T> getTailEntitiesNearby(Class<T> entityClass, double dX, double dY, double pY,double dZ, double r) {
        return level().getEntitiesOfClass(entityClass, new AABB(this.getX() - dX, this.getY() - dY, this.getZ() - dZ, this.getX() + dX, this.getY() + pY, this.getZ() + dZ), e -> e != this && distanceTo(e) <= r + e.getBbWidth() / 2f && e.getY() <= getY() + dY);
    }

    private void StompParticle(float vec, float math) {
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
                double extraX = 0.5 * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 0.5 * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX+ extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);

            }
            this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 20, 1f, 1f, 1f, 1f, 25f, false, RingParticle.EnumRingBehavior.GROW_THEN_SHRINK), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);

        }
    }


    private void EarthQuakeSummon(float vec, int quake,float math) {
        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float angle = 360.0F / quake;
        for (int i = 0; i < quake; i++) {
            EarthQuake_Entity peq = new EarthQuake_Entity(this.level(), this);
            peq.setDamage((float) CMConfig.AncientRemnantEarthQuakeDamage);
            peq.shootFromRotation(this, 0, angle * i, 0.0F, 0.45F, 0.0F);
            peq.setPos(this.getX() + vec * vecX + f * math, this.getY(), getZ() + vec * vecZ + f1 * math);
            this.level().addFreshEntity(peq);

        }
    }


    protected SoundEvent getAmbientSound() {
        return this.getIsAct() ? ModSounds.REMNANT_IDLE.get() : super.getAmbientSound();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.REMNANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.REMNANT_DEATH.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.REMNANT_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && getIsAct();
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return REMNANT_DEATH;
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();

    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    private enum AttackMode {
        CIRCLE,
        MELEE
    }

    class AwakenGoal extends Goal {

        public AwakenGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public boolean canUse() {
            return activeProgress > 0F;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            Ancient_Ancient_Remnant_Entity.this.setDeltaMovement(0, Ancient_Ancient_Remnant_Entity.this.getDeltaMovement().y, 0);
        }
    }

    static class RemnantChargeAttackGoal extends SimpleAnimationGoal<Ancient_Ancient_Remnant_Entity> {

        public RemnantChargeAttackGoal(Ancient_Ancient_Remnant_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAt(target, 30.0F, 30.0F);
                entity.getLookControl().setLookAt(target, 30, 30);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = MINE_COOLDOWN;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAt(target, 30.0F, 30.0F);
                entity.getLookControl().setLookAt(target, 30, 30);
            }
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if(this.entity.getAnimationTick() < 62 && target !=null){
                this.entity.lookAt(target, 30.0F, 30.0F);
                this.entity.getLookControl().setLookAt(target, 30f, 30f);
            }else{
                entity.setYRot(entity.yRotO);
            }
            if(this.entity.getAnimationTick() < 122 && this.entity.getAnimationTick() > 62 && this.entity.onGround()){
                Vec3 vector3d = entity.getDeltaMovement();
                float f = entity.getYRot() * ((float)Math.PI / 180F);
                Vec3 vector3d1 = new Vec3(-Mth.sin(f), entity.getDeltaMovement().y, Mth.cos(f)).scale(1.0D).add(vector3d.scale(0.5D));
                entity.setDeltaMovement(vector3d1.x, entity.getDeltaMovement().y, vector3d1.z);
            }


            if(this.entity.getAnimationTick() == 62){
                this.entity.setIsCharge(true);
            }

            if(this.entity.getAnimationTick() == 122){
                this.entity.setIsCharge(false);
            }

        }
    }


    static class RemnantAnimationAttackGoal extends SimpleAnimationGoal<Ancient_Ancient_Remnant_Entity> {
        private final int look;

        public RemnantAnimationAttackGoal(Ancient_Ancient_Remnant_Entity entity, Animation animation, int look) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.look =look;
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                this.entity.lookAt(target, 30.0F, 30.0F);
                entity.getLookControl().setLookAt(target, 30, 30);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if(this.entity.getAnimationTick() < look && target !=null){
                this.entity.lookAt(target, 30.0F, 30.0F);
                this.entity.getLookControl().setLookAt(target, 30f, 30f);
            }else{
                entity.setYRot(entity.yRotO);
            }
        }
    }

    static class RemnantSteleAttackGoal extends SimpleAnimationGoal<Ancient_Ancient_Remnant_Entity> {
        private final int look;

        public RemnantSteleAttackGoal(Ancient_Ancient_Remnant_Entity entity, Animation animation, int look) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.look =look;
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 30);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if(this.entity.getAnimationTick() < look && target !=null){
                this.entity.getLookControl().setLookAt(target, 30f, 30f);
            }else{
                entity.setYRot(entity.yRotO);
            }
            if(this.entity.getAnimationTick() == look && target !=null) {
                double d1 = target.getY();
                float f = (float) Mth.atan2(target.getZ() - this.entity.getZ(), target.getX() - this.entity.getX());
                int l;
                for (int k = 0; k < 10; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 10.0F + ((float) Math.PI * 2F / 15F);
                    this.spawnSpikeLine(this.entity.getX() + (double) Mth.cos(f4) * 4.5D, this.entity.getZ() + (double) Mth.sin(f4) * 4.5D, d1, f4, 10);
                }

                for (int k = 0; k < 12; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 12.0F + ((float) Math.PI * 2F / 20f);
                    this.spawnSpikeLine(this.entity.getX() + (double) Mth.cos(f4) * 7.5D, this.entity.getZ() + (double) Mth.sin(f4) * 7.5D, d1, f4, 15);
                }

                for (int k = 0; k < 14; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 17.0F + ((float) Math.PI * 2F / 30F);
                    this.spawnSpikeLine(this.entity.getX() + (double) Mth.cos(f4) * 10.5D, this.entity.getZ() + (double) Mth.sin(f4) * 10.5D, d1, f4, 20);
                }

                for (int k = 0; k < 16; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 16.0F + ((float) Math.PI * 2F / 40f);
                    this.spawnSpikeLine(this.entity.getX() + (double) Mth.cos(f4) * 13.5D, this.entity.getZ() + (double) Mth.sin(f4) * 13.5D, d1, f4, 25);
                }

                for (int k = 0; k < 18; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 18.0F + ((float) Math.PI * 2F / 60f);
                    this.spawnSpikeLine(this.entity.getX() + (double) Mth.cos(f4) * 16.5D, this.entity.getZ() + (double) Mth.sin(f4) * 16.5D, d1, f4, 30);
                }

                for (int k = 0; k < 20; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 20.0F + ((float) Math.PI * 2F / 80f);
                    this.spawnSpikeLine(this.entity.getX() + (double) Mth.cos(f4) * 19.5D, this.entity.getZ() + (double) Mth.sin(f4) * 19.5D, d1, f4, 35);
                }

                for (int k = 0; k < 22; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 22 + ((float) Math.PI * 2F / 120f);
                    this.spawnSpikeLine(this.entity.getX() + (double) Mth.cos(f4) * 22.5D, this.entity.getZ() + (double) Mth.sin(f4) * 22.5D, d1, f4, 40);
                }


                for (l = 0; l < 16; ++l) {
                    double d2 = 1.25 * (double) (l + 1);
                    int j = (int) ( 5 + 1.5f * l);
                    this.spawnSpikeLine(this.entity.getX() + (double) Mth.cos(f) * d2, this.entity.getZ() + (double) Mth.sin(f) * d2, d1, f, j);
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
            } while (blockpos.getY() < Math.min(entity.level().getMaxBuildHeight(), entity.getBlockY() + 20));
            this.entity.level().addFreshEntity(new Ancient_Desert_Stele_Entity(this.entity.level(), posX, (double)blockpos.getY() + d0 -3, posZ, rotation, delay,(float) CMConfig.AncientDesertSteledamage, this.entity));

        }

    }



    class RemnantAttackGoal extends Goal {
        private final Ancient_Ancient_Remnant_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private final float huntingTime = 0;
        private float circleDistance = 9;
        private boolean clockwise = false;

        public RemnantAttackGoal(Ancient_Ancient_Remnant_Entity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive() && this.mob.getAnimation() == NO_ANIMATION;
        }

        public boolean canContinueToUse() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public void start() {
            this.mob.mode = Ancient_Ancient_Remnant_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            circleDistance = 18 + this.mob.random.nextInt(10);
            clockwise = this.mob.random.nextBoolean();
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = Ancient_Ancient_Remnant_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            circleDistance = 18 + this.mob.random.nextInt(10);
            clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
                this.mob.setTarget(null);
            }

            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAggressive(false);
                this.mob.getNavigation().stop();
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == Ancient_Ancient_Remnant_Entity.AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);
                    if (huntingTime >= this.mob.hunting_cooldown) {
                        this.mob.mode = Ancient_Ancient_Remnant_Entity.AttackMode.MELEE;
                    }else{
                        if(this.mob.distanceTo(target) < 4D){
                            this.mob.mode = Ancient_Ancient_Remnant_Entity.AttackMode.MELEE;
                        }
                    }
                } else if (this.mob.mode == Ancient_Ancient_Remnant_Entity.AttackMode.MELEE) {
                    this.mob.getNavigation().moveTo(target, 1.0D);
                    this.mob.getLookControl().setLookAt(target, 30, 30);
                    if (this.mob.roar2_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 12f && target.getY() >= this.mob.getY() + 8
                    ||this.mob.roar2_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 3f && this.mob.distanceTo(target) > 12.0D) {
                        this.mob.setAnimation(REMNANT_ROAR2);
                        this.mob.roar2_cooldown = ROAR2_COOLDOWN;
                    }else if (this.mob.roar_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 3f) {
                        this.mob.setAnimation(REMNANT_ROAR);
                        this.mob.roar_cooldown = ROAR_COOLDOWN;
                    }else if (this.mob.earthquake_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 7f && this.mob.distanceTo(target) < 12.0D && target.onGround()) {
                        this.mob.setAnimation(REMNANT_TAIL_THREE);
                        this.mob.earthquake_cooldown = EARTHQUAKE_COOLDOWN;
                    }else if (this.mob.charge_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 9f && this.mob.distanceTo(target) > 7.0D && this.mob.distanceTo(target) < 20D && target.getY() <= this.mob.getY() + 1) {
                        if (this.mob.random.nextBoolean()) {
                            this.mob.setAnimation(REMNANT_RIGHT_STOMP);
                        } else {
                            this.mob.setAnimation(REMNANT_LEFT_STOMP);
                        }
                    }else if (this.mob.charge_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 3f && this.mob.distanceTo(target) > 12.0D) {
                        this.mob.setAnimation(REMNANT_CHARGE_PREPARE);
                        this.mob.charge_cooldown = CHARGE_COOLDOWN;
                    }else if (this.mob.charge_cooldown <= 0 && this.mob.getRandom().nextFloat() * 100.0F < 9f && this.mob.distanceTo(target) > 7.0D && this.mob.distanceTo(target) < 20D && target.getY() <= this.mob.getY() + 4.5F) {
                        if (this.mob.random.nextBoolean()) {
                            this.mob.setAnimation(REMNANT_RIGHT_STOMP);
                        } else {
                            this.mob.setAnimation(REMNANT_LEFT_STOMP);
                        }
                        this.mob.stomp_cooldown = STOMP_COOLDOWN;
                    }else if(this.mob.getRandom().nextFloat() * 100.0F < 10f && this.mob.distanceTo(target) < 7.0D && target.getY() < this.mob.getY() + 1) {
                            this.mob.setAnimation(REMNANT_TAIL_ATTACK1);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 10f && this.mob.distanceTo(target) < 6.0D) {
                        if (this.mob.random.nextBoolean()) {
                            this.mob.setAnimation(REMNANT_BITE1);
                        } else {
                            this.mob.setAnimation(REMNANT_BITE2);
                        }

                    }
                }
            }
        }
    }
}





