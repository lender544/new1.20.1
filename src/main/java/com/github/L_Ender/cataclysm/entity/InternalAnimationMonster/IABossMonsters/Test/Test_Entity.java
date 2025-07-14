package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Test;

import com.github.L_Ender.cataclysm.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.RoarParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.HurtByNearestTargetGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.projectile.Ancient_Desert_Stele_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.EarthQuake_Entity;
import com.github.L_Ender.cataclysm.init.*;
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
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;


public class Test_Entity extends IABoss_monster {
    private AttackMode mode = AttackMode.CIRCLE;

    public Test_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByNearestTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 120, true, true, ModEntities.buildPredicateFromTag(ModTag.ANCIENT_REMNANT_TARGET)));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(5, new RemnantAttackModeGoal(this));

    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public static AttributeSupplier.Builder test() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 70.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.33F)
                .add(Attributes.ATTACK_DAMAGE, 25)
                .add(Attributes.MAX_HEALTH, 450)
                .add(Attributes.ARMOR, 12)
                .add(Attributes.ARMOR_TOUGHNESS, 4)
                .add(Attributes.STEP_HEIGHT, 1.5F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }


    protected int decreaseAirSupply(int air) {
        return air;
    }


    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_) {
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_);
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
        if (this.getAttackState() == 7 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (range > CMConfig.AncientRemnantLongRangelimit * CMConfig.AncientRemnantLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getDirectEntity();
        if (this.getAttackState() != 12){
            if (entity instanceof AbstractArrow) {
                return false;
            }
        }

        return super.hurt(source, damage);
    }


    
    public float DamageCap() {
        return (float) CMConfig.AncientRemnantDamageCap;
    }

    public float NatureRegen() {
        return (float) CMConfig.AncientRemnantNatureHealing;
    }

    public int DamageTime() {
        return CMConfig.AncientRemnantDamageTime;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
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



    public void travel(Vec3 travelVector) {
        super.travel(travelVector);
    }

    public void stopAllAnimationStates() {

    }

    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(3);
    }

    public int deathtimer() {
        return 70;
    }
    
    public void tick() {
        super.tick();
        float targetRot = this.getYHeadRot();
        float currentBodyRot = this.yBodyRot;
        float maxTurn = 90.0F;

        float newBodyRot = this.rotlerp(currentBodyRot, targetRot, maxTurn);

        this.setYBodyRot(newBodyRot);
    }


    protected float rotlerp(float sourceAngle, float targetAngle, float maximumChange) {
        float f = Mth.wrapDegrees(targetAngle - sourceAngle);
        if (f > maximumChange) {
            f = maximumChange;
        }

        if (f < -maximumChange) {
            f = -maximumChange;
        }

        float f1 = sourceAngle + f;
        if (f1 < 0.0F) {
            f1 += 360.0F;
        } else if (f1 > 360.0F) {
            f1 -= 360.0F;
        }

        return f1;
    }

    @Override
    public void setYBodyRot(float offset) {
        this.setYRot(offset);
        super.setYBodyRot(offset);
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();

    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        if (!this.level().isClientSide) {
            if (this.getHomePos() != BlockPos.ZERO) {
                int newX = Mth.floor(this.getHomePos().getX());
                int newY = Mth.floor(this.getHomePos().getY());
                int newZ = Mth.floor(this.getHomePos().getZ());
                BlockPos pos = new BlockPos(newX,newY,newZ);
                BlockState block = ModBlocks.BOSS_RESPAWNER.get().defaultBlockState();
                this.level().setBlock(pos, block, 2);
                if (level().getBlockEntity(pos) instanceof Boss_Respawn_Spawner_Block_Entity spawnerblockentity) {
                    spawnerblockentity.setEntityId(ModEntities.ANCIENT_REMNANT.get());
                    spawnerblockentity.setTheItem(ModItems.DESERT_EYE.get().getDefaultInstance());
                }
            }
        }
    }


    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
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
    class RemnantAttackModeGoal extends Goal {
        private final Test_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private final float huntingTime = 0;
        private float circleDistance = 9;
        private boolean clockwise = false;

        public RemnantAttackModeGoal(Test_Entity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive() && this.mob.getAttackState() == 0;
        }

        public boolean canContinueToUse() {
            LivingEntity target = this.mob.getTarget();
            if (target == null) {
                return false;
            } else if (!target.isAlive()) {
                return false;
            } else if (!this.mob.isWithinRestriction(target.blockPosition())) {
                return false;
            } else {
                return !(target instanceof Player) || !target.isSpectator() && !((Player) target).isCreative();
            }
        }

        public void start() {
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            circleDistance = 18 + this.mob.random.nextInt(10);
            clockwise = this.mob.random.nextBoolean();
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
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
                this.mob.lookAt(target, 30.0F, 30.0F);
                this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);

                if (this.mob.mode == AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);
                } else if (this.mob.mode == AttackMode.MELEE) {
                    this.mob.getNavigation().moveTo(target, 1.0D);
                }
            }
        }
    }
}





