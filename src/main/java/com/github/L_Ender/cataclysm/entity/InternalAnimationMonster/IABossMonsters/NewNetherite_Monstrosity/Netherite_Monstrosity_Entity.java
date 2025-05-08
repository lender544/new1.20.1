package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity;

import com.github.L_Ender.cataclysm.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AdvancedHurtByTargetGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.HurtByNearestTargetGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.partentity.Cm_Part_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Flame_Jet_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Flare_Bomb_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Lava_Bomb_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.util.CMMathUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
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


public class Netherite_Monstrosity_Entity extends IABoss_monster {
    private final CMBossInfoServer bossInfo = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.RED, false, 0);
    public int frame;
    public float LayerBrightness, oLayerBrightness;
    public int LayerTicks;
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sleepAnimationState = new AnimationState();
    public AnimationState awakeAnimationState = new AnimationState();
    public AnimationState smashsAnimationState = new AnimationState();
    public AnimationState phaseAnimationState = new AnimationState();
    public AnimationState fireAnimationState = new AnimationState();
    public AnimationState drainAnimationState = new AnimationState();
    public AnimationState shouldercheckAnimationState = new AnimationState();
    public AnimationState overpowerAnimationState = new AnimationState();
    public AnimationState flareshotAnimationState = new AnimationState();
    public AnimationState deathAnimationState = new AnimationState();
    public final Netherite_Monstrosity_Part headPart;
    public final Netherite_Monstrosity_Part[] monstrosityParts;
    private static final EntityDataAccessor<Boolean> IS_BERSERK = SynchedEntityData.defineId(Netherite_Monstrosity_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_AWAKEN = SynchedEntityData.defineId(Netherite_Monstrosity_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> MAGAZINE = SynchedEntityData.defineId(Netherite_Monstrosity_Entity.class, EntityDataSerializers.INT);

    public boolean Blocking = CMConfig.NetheritemonstrosityBodyBloking;
    private int blockBreakCounter;



    private int shoot_cooldown = 0;
    public static final int SHOOT_COOLDOWN = 240;
    private boolean onLava = false;
    private int check_cooldown = 0;
    public static final int CHECK_COOLDOWN = 80;

    private int overpower_cooldown = 0;
    public static final int OVERPOWER_COOLDOWN = 160;

    private int flare_shoot_cooldown = 0;
    public static final int FLARE_SHOOT_COOLDOWN = 120;

    public Netherite_Monstrosity_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.setMaxUpStep(4.5F);
        this.headPart = new Netherite_Monstrosity_Part(this, 1.6F, 2.5F);
        this.monstrosityParts = new Netherite_Monstrosity_Part[]{this.headPart};
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
        setConfigattribute(this, CMConfig.MonstrosityHealthMultiplier, CMConfig.MonstrosityDamageMultiplier);
    }



    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByNearestTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.goalSelector.addGoal(4, new InternalMoveGoal(this, false, 1.0D) {

            @Override
            public boolean canUse() {
                return super.canUse() && Netherite_Monstrosity_Entity.this.getAttackState() == 0;
            }
        });

        this.goalSelector.addGoal(3, new InternalAttackGoal(this, 0, 3, 0, 58, 12, 6) {
            @Override
            public boolean canUse() {
                return super.canUse() && Netherite_Monstrosity_Entity.this.getRandom().nextFloat() * 100.0F < 32f;
            }
        });

        //sleep
        this.goalSelector.addGoal(2, new InternalStateGoal(this, 1, 1, 2, 0, 0) {

            @Override
            public boolean canUse() {
                return super.canUse() && !Netherite_Monstrosity_Entity.this.getIsAwaken();
            }

            @Override
            public void tick() {
                entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            }

            @Override
            public void stop() {
                super.stop();
                Netherite_Monstrosity_Entity.this.setIsAwaken(true);
            }

        });

        //awake
        this.goalSelector.addGoal(1, new InternalStateGoal(this, 2, 2, 0, 40, 0) {

            @Override
            public boolean canUse() {
                return super.canUse() && Netherite_Monstrosity_Entity.this.getIsAwaken();
            }

            @Override
            public void tick() {
                entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            }
        });
        this.goalSelector.addGoal(0, new InternalAttackGoal(this, 1, 2, 0, 40, 0, 15) {

            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && target != null && this.entity.getSensing().hasLineOfSight(target);
            }


            @Override
            public void start() {
                super.start();
                Netherite_Monstrosity_Entity.this.setIsAwaken(true);
            }
        });


        //change roar
        this.goalSelector.addGoal(0, new MonstrosityPhaseChangeGoal(this, 0, 4, 0, 54));

        //shoot
        this.goalSelector.addGoal(3, new Magmashoot(this, 0, 6, 0, 44, 20, 40F, 19, 16F));

        //flare shoot
        this.goalSelector.addGoal(3, new Flareshoot(this, 0, 10, 0, 60, 35, 26F, 35, 18F));


        //drain
        this.goalSelector.addGoal(3, new InternalAttackGoal(this, 0, 7, 0, 60, 25, 1) {

            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return target != null && target.isAlive() && this.entity.getAttackState() == 0 && this.entity.isInLava() && Netherite_Monstrosity_Entity.this.getMagazine() >= CMConfig.Lavabombmagazine;
            }
        });
        //check
        this.goalSelector.addGoal(3, new ShoulderCheck(this, 0, 8, 0, 70, 19, 16, 19, 49, 12));


        //overpower
        this.goalSelector.addGoal(3, new InternalAttackGoal(this, 0, 9, 0, 75, 7, 10) {
            @Override
            public boolean canUse() {
                return super.canUse() && Netherite_Monstrosity_Entity.this.getRandom().nextFloat() * 100.0F < 40f && Netherite_Monstrosity_Entity.this.overpower_cooldown <= 0;
            }

            @Override
            public void stop() {
                super.stop();
                Netherite_Monstrosity_Entity.this.overpower_cooldown = OVERPOWER_COOLDOWN;
            }


        });

    }

    public static AttributeSupplier.Builder netherite_monstrosity() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.ATTACK_DAMAGE, 25)
                .add(Attributes.MAX_HEALTH, 600)
                .add(Attributes.ARMOR, 12)
                .add(Attributes.ARMOR_TOUGHNESS, 5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }


    public boolean attackEntityFromPart(Netherite_Monstrosity_Part netherite_monstrosity_part, DamageSource source, float amount) {
        return this.hurt(source, amount);
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (this.getAttackState() == 4 && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        double range = calculateRange(source);

        if (range > CMConfig.MonstrosityLongRangelimit * CMConfig.MonstrosityLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getDirectEntity();
        if (entity instanceof AbstractGolem) {
            damage *= 0.5F;
        }

        boolean attack = super.hurt(source, damage);

        if (attack && !this.getIsAwaken() && this.isAlive()) {
            this.setIsAwaken(true);
        }
        return attack;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public float DamageCap() {
        return (float) CMConfig.MonstrosityDamageCap;
    }

    public int DamageTime() {
        return CMConfig.MonstrosityDamageTime;
    }


    public boolean canBeCollidedWith() {
        return this.isAlive() && Blocking && this.getAttackState() != 8;
    }

    public boolean isPushable() {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "sleep") {
            return this.sleepAnimationState;
        } else if (input == "awake") {
            return this.awakeAnimationState;
        } else if (input == "smash") {
            return this.smashsAnimationState;
        } else if (input == "phase_two") {
            return this.phaseAnimationState;
        } else if (input == "fire") {
            return this.fireAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "drain") {
            return this.drainAnimationState;
        } else if (input == "shoulder_check") {
            return this.shouldercheckAnimationState;
        } else if (input == "overpower") {
            return this.overpowerAnimationState;
        } else if (input == "flare_shot") {
            return this.flareshotAnimationState;
        } else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_BERSERK, false);
        this.entityData.define(IS_AWAKEN, false);
        this.entityData.define(MAGAZINE, 0);
    }

    public boolean isSleep() {
        return this.getAttackState() == 1 || this.getAttackState() == 2;
    }


    public boolean canStandOnFluid(FluidState p_230285_1_) {
        return p_230285_1_.is(FluidTags.LAVA);
    }

    public void setIsBerserk(boolean isBerserk) {
        this.entityData.set(IS_BERSERK, isBerserk);
    }

    public boolean getIsBerserk() {
        return this.entityData.get(IS_BERSERK);
    }

    public void setOnLava(boolean lava) {
        onLava = lava;
    }

    public boolean getOnLava() {
        return onLava;
    }

    public void setIsAwaken(boolean isAwaken) {
        this.entityData.set(IS_AWAKEN, isAwaken);
        this.bossInfo.setVisible(isAwaken);
        if (!isAwaken) {
            this.setAttackState(1);
        }
        this.setHomePos(this.blockPosition());
    }

    public boolean getIsAwaken() {
        return this.entityData.get(IS_AWAKEN);
    }

    public void setMagazine(int isAwaken) {
        this.entityData.set(MAGAZINE, isAwaken);
    }

    public int getMagazine() {
        return this.entityData.get(MAGAZINE);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }


    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_29678_, DifficultyInstance p_29679_, MobSpawnType p_29680_, @Nullable SpawnGroupData p_29681_, @Nullable CompoundTag p_29682_) {
        this.setIsAwaken(true);
        return super.finalizeSpawn(p_29678_, p_29679_, p_29680_, p_29681_, p_29682_);
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
                        this.smashsAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.phaseAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.fireAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.drainAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.shouldercheckAnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.overpowerAnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.flareshotAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.sleepAnimationState.stop();
        this.awakeAnimationState.stop();
        this.smashsAnimationState.stop();
        this.phaseAnimationState.stop();
        this.deathAnimationState.stop();
        this.fireAnimationState.stop();
        this.drainAnimationState.stop();
        this.overpowerAnimationState.stop();
        this.shouldercheckAnimationState.stop();
        this.flareshotAnimationState.stop();
    }


    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(5);
    }

    public int deathtimer() {
        return 60;
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
                    spawnerblockentity.setEntityId(ModEntities.NETHERITE_MONSTROSITY.get());
                    spawnerblockentity.setItem(0,ModItems.MONSTROUS_EYE.get().getDefaultInstance());
                }
            }
        }
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Berserk", getIsBerserk());
        compound.putBoolean("is_Awaken", getIsAwaken());
        compound.putInt("Magazine", getMagazine());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setIsBerserk(compound.getBoolean("is_Berserk"));
        setIsAwaken(compound.getBoolean("is_Awaken"));
        setMagazine(compound.getInt("Magazine"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }


    private void floatStrider() {
        if (this.isInLava()) {
            CollisionContext lvt_1_1_ = CollisionContext.of(this);
            if (lvt_1_1_.isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition().below(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.LAVA)) {
                this.setOnLava(true);
            }

        }

    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_MONSTROSITY)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    public void tick() {
        super.tick();

        this.floatStrider();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0, this.tickCount);
        }
        frame++;
        float moveX = (float) (getX() - xo);
        float moveZ = (float) (getZ() - zo);
        float speed = Mth.sqrt(moveX * moveX + moveZ * moveZ);
        if (!this.isSilent() && frame % 25 == 1 && speed > 0.05 && this.getIsAwaken() && this.getAttackState() != 8) {
            playSound(ModSounds.MONSTROSITYSTEP.get(), 1F, 1.0f);
            ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.08f, 0, 5);
        }
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        BlockBreaking();
        if (this.blockBreakCounter > 0) this.blockBreakCounter--;
        if (shoot_cooldown > 0) shoot_cooldown--;
        if (overpower_cooldown > 0) overpower_cooldown--;
        if (check_cooldown > 0) check_cooldown--;
        if (flare_shoot_cooldown > 0) flare_shoot_cooldown--;
        if (!isNoAi() && !getIsAwaken()) {
            if (this.tickCount % 4 == 0) {
                this.heal((float) CMConfig.MonstrosityNatureHealing);
            }
        }


        setHeadPart();

        if (this.level().isClientSide) {
            ++LayerTicks;
            this.LayerBrightness += (0.0F - this.LayerBrightness) * 0.8F;
        }

    }

    private void setHeadPart() {

        if (!this.isNoAi()) {


            float f17 = (yBodyRot) * ((float) Math.PI / 180F);
            float pitch = this.getXRot() * ((float) Math.PI / 180F);
            float f3 = Mth.sin(f17) * (1 - Math.abs(this.getXRot() / 90F));
            float f18 = Mth.cos(f17) * (1 - Math.abs(this.getXRot() / 90F));

            Vec3[] avector3d = new Vec3[this.monstrosityParts.length];
            for (int j = 0; j < this.monstrosityParts.length; ++j) {
                avector3d[j] = new Vec3(this.monstrosityParts[j].getX(), this.monstrosityParts[j].getY(), this.monstrosityParts[j].getZ());
            }

            float headY = 0F;
            float headxz = 0F;
            if (this.getAttackState() == 3) {
                int end = 40;
                float f = 0F;
                if (this.attackTicks > end) {
                    f = CMMathUtil.cullAnimationTick(this.attackTicks, 1.2F, 1.0F, 13, end);
                } else {
                    f = CMMathUtil.cullAnimationTick(this.attackTicks, 2.0F, 1.0F, 13, end);
                }
                headxz = -1.6F * f;
                headY = -2.2F * f;
            }

            if (this.getAttackState() == 6) {
                float f = CMMathUtil.cullAnimationTick(this.attackTicks, 0.5F, 1.0F, 0, 40);
                headxz = 4 * f;
                headY = 1.2F * f;
            }

            if (this.getAttackState() == 8) {
                float f = CMMathUtil.cullAnimationTick(this.attackTicks, 2, 1.0F, 0, 30);
                headxz = -4 * f;
            }


            this.setPartPosition(this.headPart, f3 * -1.65F + f3 * headxz, pitch + 2.4F + headY, -f18 * -1.65F - f18 * headxz);

            for (int l = 0; l < this.monstrosityParts.length; ++l) {
                this.monstrosityParts[l].xo = avector3d[l].x;
                this.monstrosityParts[l].yo = avector3d[l].y;
                this.monstrosityParts[l].zo = avector3d[l].z;
                this.monstrosityParts[l].xOld = avector3d[l].x;
                this.monstrosityParts[l].yOld = avector3d[l].y;
                this.monstrosityParts[l].zOld = avector3d[l].z;
            }
        }

    }


    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 2) {
            if (this.attackTicks == 2) {
                this.playSound(ModSounds.MONSTROSITYAWAKEN.get(), 10, 1);
            }
        }


        if (this.getAttackState() == 3) {
            if (this.attackTicks == 19) {
                EarthQuake(6.25D);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                Makeparticle(4.75f, 2.5f);
                Makeparticle(4.75f, -2.5f);
            }
        }

        if (this.getAttackState() == 4) {
            if (this.attackTicks == 10) {
                this.playSound(ModSounds.MONSTROSITYGROWL.get(), 3, 1);
            }
            if (this.attackTicks == 17) {
                berserkBlockBreaking(8, 8, 8);
                EarthQuake(6.25D);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                Makeparticle(4.4f, 2.0f);
                Makeparticle(4.4f, -2.0f);
            }
        }
        if (this.getAttackState() == 5) {
            if (this.attackTicks == 26) {
                this.playSound(ModSounds.MONSTROSITYLAND.get(), 1, 1);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
            }
        }
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 19) {
                this.playSound(ModSounds.MONSTROSITYSHOOT.get(), 3, 0.75f);
            }
        }

        if (this.getAttackState() == 7) {
            if (this.attackTicks == 24) {
                this.setMagazine(0);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                this.doAbsorptionEffects(4, 1, 4);
                this.playSound(SoundEvents.BUCKET_FILL_LAVA, 6f, 0.5F);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);
            }
            if (this.attackTicks == 26) {
                this.doAbsorptionEffects(8, 2, 8);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);
            }
            if (this.attackTicks == 28) {
                this.doAbsorptionEffects(16, 4, 16);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);
            }
        }

        if (this.getAttackState() == 8) {
            if (this.attackTicks == 22
                    || this.attackTicks == 27
                    || this.attackTicks == 32
                    || this.attackTicks == 37
                    || this.attackTicks == 42
                    || this.attackTicks == 47) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.15f, 0, 6);
                playSound(ModSounds.MONSTROSITYSTEP.get(), 1F, 1.0f);
            }

            if (this.attackTicks > 19 && this.attackTicks < 49) {
                if (!this.level().isClientSide) {
                    if(CMConfig.MonstrosityBlockBreaking) {
                        ChargeBlockBreaking();
                    }else{
                        if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                            ChargeBlockBreaking();
                        }
                    }
                }

                double yaw = Math.toRadians(this.getYRot() + 90);
                double xExpand = 2.0F * Math.cos(yaw);
                double zExpand = 2.0F * Math.sin(yaw);
                AABB attackRange = this.getBoundingBox().inflate(0.75D, 0.75D, 0.75D).expandTowards(xExpand, 0, zExpand);
                for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
                    if (!isAlliedTo(Lentity) && !(Lentity instanceof Netherite_Monstrosity_Entity) && Lentity != this) {
                        boolean flag = Lentity.hurt(this.damageSources().mobAttack(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.4F));
                        if (flag) {
                            double theta = (yBodyRot) * (Math.PI / 180);
                            theta += Math.PI / 2;
                            double vec = -2.5D;
                            double vecX = Math.cos(theta);
                            double vecZ = Math.sin(theta);

                            double d0 = Lentity.getX() - (this.getX() + vec * vecX);
                            double d1 = Lentity.getZ() - (this.getZ() + vec * vecZ);
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.05D);
                            double vel = 4.0D;
                            Lentity.push(d0 / d2 * vel, 0.3D, d1 / d2 * vel);
                            Lentity.addEffect(new MobEffectInstance(ModEffect.EFFECTBONE_FRACTURE.get(), 100));
                        }
                    }
                }

            }
        }

        if (this.getAttackState() == 9) {
            if (this.attackTicks == 9) {
                OverPowerKnockBack(7D);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                Makeparticle(-0.3f, 3.4f);
                Makeparticle(-0.3F, -3.4f);
                CircleFlameJet(-0.3f, 3.4f,this.getIsBerserk() ? 14 : 7,this.getIsBerserk() ? 8 : 4,3);
                CircleFlameJet(-0.3F, -3.4f,this.getIsBerserk() ? 14 : 7,this.getIsBerserk() ? 8 : 4,3);
                this.playSound(ModSounds.REMNANT_STOMP.get(), 1, 0.7F);
            }
            if (this.attackTicks == 26) {
                this.playSound(ModSounds.MONSTROSITYGROWL.get(), 3, 1);

            }

            for (int l = 31; l <= 41; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 27;
                    int d2 = l - 26;
                    float ds = (d + d2) / 2;
                    StompDamage(0.6f, d, 5, 1.05F, -2.0f, 0, 0, 0.7f);
                    StompDamage(0.6f, d2, 5, 1.05F, -2.0f, 0, 0, 0.7f);
                    Stompsound(ds, 0F);
                }
            }
        }

        if (this.getAttackState() == 10) {
            if (this.attackTicks == 35) {
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.08f, 0, 10);
                this.playSound(ModSounds.MONSTROSITYSHOOT.get(), 3, 0.75f);
            }
        }

    }


    private void CircleFlameJet(float vec, float math,int vertexrune, int rune,double time) {

        float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);



        for (int i = 0; i < vertexrune; i++) {
            float throwAngle = i * Mth.PI / (vertexrune/2);
            for (int k = 0; k < rune; ++k) {
                double d2 = 1.1D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnJet(this.getX() + vec * vecX  + f * math + (double) Mth.cos(throwAngle) * 1.25D * d2, this.getZ() + vec * vecZ  + f1 * math + (double) Mth.sin(throwAngle) * 1.25D * d2, this.getY() -2, this.getY() + 2, throwAngle, d3);
            }

        }

    }

    private void spawnJet(double x, double z, double minY, double maxY, float rotation, int delay) {
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
            this.level().addFreshEntity(new Flame_Jet_Entity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float)CMConfig.FlameJetDamage,this));
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



    private boolean notLavaCliff(double distance) {

        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);

        double px = this.getX() + vecX * distance;
        double pz = this.getZ() + vecZ * distance;


        double checkHeight = -2.5D;
        Vec3 forwardPosition = new Vec3(
                px,
                this.getY() + checkHeight,
                pz
        );

        BlockState blockStateBelow = this.level().getBlockState(BlockPos.containing(forwardPosition));

        return !blockStateBelow.isAir();
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

        double b0 = hitX - this.getX();
        double b1 = hitZ - this.getZ();
        double b2 = Math.max(b0 * b0 + b1 * b1, 0.001);
        fallingBlockEntity.push(b0 / b2 * 1.5d, 0.2D + getRandom().nextGaussian() * 0.04D, b1 / b2 * 1.5d);
        level().addFreshEntity(fallingBlockEntity);



        AABB selection = new AABB(px - 0.5, (double)blockpos.getY() + d0 -1, pz - 0.5, px + 0.5, (double)blockpos.getY() + d0 + mxy, pz + 0.5);
        List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
        for (LivingEntity entity : hit) {
            if (!isAlliedTo(entity) && !(entity instanceof Netherite_Monstrosity_Entity) && entity != this) {
                DamageSource damagesource = this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }

                if (flag) {
                    double magnitude = 10;
                    double x = vx * Math.max(factor, 0.2) * magnitude;
                    double y = 0;
                    if (entity.onGround()) {
                        y += 0.15;
                    }
                    double z = vz * Math.max(factor, 0.2) * magnitude;
                    entity.setDeltaMovement(entity.getDeltaMovement().add(x, y, z));
                }
            }
        }
    }

    private void doAbsorptionEffects(int x, int y, int z) {

        int MthX = Mth.floor(this.getX());
        int MthY = Mth.floor(this.getY());
        int MthZ = Mth.floor(this.getZ());

        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = 0; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    this.doAbsorptionEffect(blockpos);
                }
            }
        }
    }

    private void doAbsorptionEffect(BlockPos pos) {
        BlockState state = level().getBlockState(pos);
        // if (state.getFluidState().isTagged(FluidTags.LAVA) && state.getFluidState().isSource()) {
        //      this.world.setBlockState(pos, Blocks.AIR.getDefaultState());
        //  }
        if (!this.level().isClientSide) {
            if (state.is(Blocks.LAVA)) {
                this.level().setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            }
        }
    }


    private void EarthQuake(double area) {
        this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(area))) {
            if (!isAlliedTo(entity) && !(entity instanceof Netherite_Monstrosity_Entity) && entity != this) {
                DamageSource damagesource = this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.MonstrositysHpdamage)));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player) {
                    disableShield(player, 120);
                }

                if (flag) {
                    launch(entity, 2D,0.6D);
                    if (getIsBerserk()) {
                        entity.setSecondsOnFire(6);
                    }
                }
            }
        }
    }

    private void OverPowerKnockBack(double area) {
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(area))) {
            if (!isAlliedTo(entity) && !(entity instanceof Netherite_Monstrosity_Entity) && entity != this) {
                launch(entity, 3D,0.35D);
            }
        }
    }


    private void Makeparticle(float vec, float math) {
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
                double extraX = 2F * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 2F * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX+ extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());
                if (getIsBerserk()) {
                    this.level().addParticle(ParticleTypes.FLAME, getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                } else {
                    if (block.getRenderShape() != RenderShape.INVISIBLE) {
                        this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                    }
                }
            }
            if (getIsBerserk()) {
                this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 35, 0.8f, 0.305f, 0.02f, 1f, 30f, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
            }else{
                this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 35, 1f, 1f, 1f, 1f, 30f, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
            }
        }
    }


    private void launch(Entity e, double XZpower,double Ypower) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        e.push(d0 / d2 * XZpower, Ypower, d1 / d2 * XZpower);
    }


    private void ChargeBlockBreaking(){
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.5D, 0.2D, 0.5D);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.NETHERITE_MONSTROSITY_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
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

    private void berserkBlockBreaking(int x, int y, int z) {
        int MthX = Mth.floor(this.getX());
        int MthY = Mth.floor(this.getY());
        int MthZ = Mth.floor(this.getZ());
        if (!this.level().isClientSide) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                for (int k2 = -x; k2 <= x; ++k2) {
                    for (int l2 = -z; l2 <= z; ++l2) {
                        for (int j = 0; j <= y; ++j) {
                            int i3 = MthX + k2;
                            int k = MthY + j;
                            int l = MthZ + l2;
                            BlockPos blockpos = new BlockPos(i3, k, l);
                            BlockState block = level().getBlockState(blockpos);
                            BlockEntity tileEntity = level().getBlockEntity(blockpos);
                            if (!block.isAir() && !block.is(ModTag.NETHERITE_MONSTROSITY_IMMUNE)) {
                                if (tileEntity == null && random.nextInt(4) + 1 == 4) {
                                    this.level().removeBlock(blockpos, true);
                                    Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), i3 + 0.5D, k + 0.5D, l + 0.5D, block,5);
                                    level().setBlock(blockpos, block.getFluidState().createLegacyBlock(), 3);
                                    fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2D + random.nextDouble()) / 3, (-1.1D + random.nextDouble()) / 3, (-1.2D + random.nextDouble()) / 3)));
                                    level().addFreshEntity(fallingBlockEntity);
                                } else {
                                    level().destroyBlock(new BlockPos(i3, k, l), shouldDropItem(tileEntity));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void BlockBreaking() {
        if(!this.isNoAi()) {
            if (!this.level().isClientSide && this.blockBreakCounter == 0) {
                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    for (int a = (int) Math.round(this.getBoundingBox().minX); a <= (int) Math.round(this.getBoundingBox().maxX); a++) {
                        for (int b = (int) Math.round(this.getBoundingBox().minY); (b <= (int) Math.round(this.getBoundingBox().maxY) + 1) && (b <= 127); b++) {
                            for (int c = (int) Math.round(this.getBoundingBox().minZ); c <= (int) Math.round(this.getBoundingBox().maxZ); c++) {
                                BlockPos blockpos = new BlockPos(a, b, c);
                                BlockState block = level().getBlockState(blockpos);
                                BlockEntity tileEntity = level().getBlockEntity(blockpos);
                                if (!block.isAir() && !block.is(ModTag.NETHERITE_MONSTROSITY_IMMUNE)) {
                                    boolean flag = level().destroyBlock(new BlockPos(a, b, c), shouldDropItem(tileEntity));
                                    if (flag) {
                                        blockBreakCounter = 10;
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }


    private Vec3 rotateOffsetVec(Vec3 offset, float xRot, float yRot) {
        return offset.xRot(-xRot * ((float) Math.PI / 180F)).yRot(-yRot * ((float) Math.PI / 180F));
    }

    private boolean shouldDropItem(BlockEntity tileEntity) {
        if (tileEntity == null) {
            return random.nextInt(3) + 1 == 3;
        }
        return true;
    }

    public boolean isBerserk() {
        return this.getHealth() <= this.getMaxHealth() * 0.4F;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {
            itementity.setDeltaMovement(itementity.getDeltaMovement().multiply(0.0, 3.5, 0.0));
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }


    private void setPartPosition(Netherite_Monstrosity_Part part, double offsetX, double offsetY, double offsetZ) {
        part.setPos(this.getX() + offsetX * part.scale, this.getY() + offsetY * part.scale, this.getZ() + offsetZ * part.scale);
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.monstrosityParts;
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        Cm_Part_Entity.assignPartIDs(this);
    }



    public void travel(Vec3 travelVector) {
        this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED) * (isInLava() ? 0.2F : 1F));
        if (this.isEffectiveAi() && this.isInLava()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
        } else {
            super.travel(travelVector);
        }
    }



    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.MONSTROSITYHURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.MONSTROSITYDEATH.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.MONSTROSITY_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && !isSleep();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }


    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
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


    static class MonstrosityPhaseChangeGoal extends Goal {
        protected final Netherite_Monstrosity_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;

        public MonstrosityPhaseChangeGoal(Netherite_Monstrosity_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
        }

        @Override
        public boolean canUse() {
            return !this.entity.getIsBerserk() && this.entity.getAttackState() == getattackstate && this.entity.isBerserk();
        }

        @Override
        public void start() {
            this.entity.setIsBerserk(true);
            if(getattackstate != attackstate) {
                this.entity.setAttackState(attackstate);
            }
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean canContinueToUse() {
            return attackMaxtick > 0 ? this.entity.attackTicks <= attackMaxtick : canUse();
        }


    }

    static class Magmashoot extends InternalAttackGoal {
        private final Netherite_Monstrosity_Entity entity;
        private final int attackshot;
        private final float random;


        public Magmashoot(Netherite_Monstrosity_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) >= 14F && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getSensing().hasLineOfSight(target) && this.entity.getMagazine() < CMConfig.Lavabombmagazine && this.entity.shoot_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.shoot_cooldown = SHOOT_COOLDOWN;
            this.entity.setMagazine(this.entity.getMagazine() + 1);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            int lavabombcount = CMConfig.Lavabombamount;

            if(target !=null) {
                if (this.entity.attackTicks == attackshot) {
                    for (int i = 0; i < lavabombcount; ++i) {
                        Lava_Bomb_Entity lava = new Lava_Bomb_Entity(ModEntities.LAVA_BOMB.get(), this.entity.level(), this.entity);
                        double d0 = target.getX() - this.entity.headPart.getX();
                        double d1 = target.getBoundingBox().minY + target.getBbHeight() / 3.0F - lava.getY();
                        double d2 = target.getZ() - this.entity.headPart.getZ();
                        double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
                        lava.setMaxLavaTime(CMConfig.LavabombDuration + this.entity.getRandom().nextInt(CMConfig.LavabombDurationRand));
                        lava.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.0F, 24 - this.entity.level().getDifficulty().getId() * 4);
                        this.entity.level().addFreshEntity(lava);
                    }
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class Flareshoot extends InternalAttackGoal {
        private final Netherite_Monstrosity_Entity entity;
        private final int attackshot;
        private final float random;


        public Flareshoot(Netherite_Monstrosity_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) >= 10F && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getSensing().hasLineOfSight(target) && this.entity.flare_shoot_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.flare_shoot_cooldown = FLARE_SHOOT_COOLDOWN;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            int lavabombcount = 5;

            if(target !=null) {
                if (this.entity.attackTicks == attackshot) {
                    for (int i = 0; i < lavabombcount; ++i) {
                        float f = Mth.cos( this.entity.yBodyRot * ((float)Math.PI / 180F)) ;
                        float f1 = Mth.sin( this.entity.yBodyRot * ((float)Math.PI / 180F)) ;
                        double theta = (this.entity.yBodyRot) * (Math.PI / 180);
                        theta += Math.PI / 2;
                        double vecX = Math.cos(theta);
                        double vecZ = Math.sin(theta);
                        double vec = 2.2;
                        double math = 3.4D;
                        Flare_Bomb_Entity lava = new Flare_Bomb_Entity(ModEntities.FLARE_BOMB.get(), this.entity.level(), this.entity);
                        lava.setPosRaw(this.entity.getX() + vec * vecX + f * math, this.entity.getY(0.65), this.entity.getZ() + vec * vecZ + f1 * math);

                        double d0 = target.getX() - lava.getX() ;
                        double d1 = target.getBoundingBox().minY + target.getBbHeight() / 3.0F - lava.getY();
                        double d2 = target.getZ() - lava.getZ();
                        double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
                        lava.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.0F, 1 + i * 8);
                        this.entity.level().addFreshEntity(lava);
                    }
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class ShoulderCheck extends InternalAttackGoal {
        private final Netherite_Monstrosity_Entity entity;
        private final int attackshot;
        private final int attackendshot;
        private final float random;


        public ShoulderCheck(Netherite_Monstrosity_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot,int attackendshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.attackendshot = attackendshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }
        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) >= 5.75F && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getSensing().hasLineOfSight(target) && this.entity.check_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.check_cooldown = CHECK_COOLDOWN;
        }

        @Override
        public void tick() {
            super.tick();

            if (this.entity.attackTicks > attackshot && this.entity.attackTicks < attackendshot) {
                if (this.entity.onGround() || this.entity.getOnLava()) {

                    Vec3 vector3d = entity.getDeltaMovement();
                    float f = entity.getYRot() * ((float) Math.PI / 180F);
                    Vec3 vector3d1 = new Vec3(-Mth.sin(f), entity.getDeltaMovement().y, Mth.cos(f)).scale(0.5D).add(vector3d.scale(0.5D));
                    entity.setDeltaMovement(vector3d1.x, entity.getDeltaMovement().y, vector3d1.z);

                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

}





