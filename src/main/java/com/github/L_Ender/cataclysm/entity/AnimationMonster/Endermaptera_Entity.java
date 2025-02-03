package com.github.L_Ender.cataclysm.entity.AnimationMonster;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.etc.path.DirectPathNavigator;
import com.github.L_Ender.cataclysm.entity.etc.FlightMoveController;
import com.github.L_Ender.cataclysm.entity.projectile.Void_Shard_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class Endermaptera_Entity extends Monster implements IAnimatedEntity {
    @Nullable
    private ResourceKey<LootTable> HAS_JAWS_LOOT = ResourceKey.create(Registries.LOOT_TABLE,ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "entities/endermaptera_has_jaws"));
    private int animationTick;
    private Animation currentAnimation;
    public static final Animation JAW_ATTACK = Animation.create(13);
    public static final Animation HEADBUTT_ATTACK = Animation.create(13);
    public float attachChangeProgress = 0F;
    public float prevAttachChangeProgress = 0F;
    private static final EntityDataAccessor<Direction> ATTACHED_FACE = SynchedEntityData.defineId(Endermaptera_Entity.class, EntityDataSerializers.DIRECTION);
    private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Endermaptera_Entity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> HAS_JAWS = SynchedEntityData.defineId(Endermaptera_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final Direction[] HORIZONTALS = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    private Direction prevAttachDir = Direction.DOWN;
    private boolean isUpsideDownNavigator;

    public Endermaptera_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        this.xpReward = 6;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0f, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    


    private void switchNavigator(boolean rightsideUp) {
        if (rightsideUp) {
            this.moveControl = new MoveControl(this);
            this.navigation = new WallClimberNavigation(this, level());
            this.isUpsideDownNavigator = false;
        } else {
            this.moveControl = new FlightMoveController(this, 0.6F, false);
            this.navigation = new DirectPathNavigator(this, level());
            this.isUpsideDownNavigator = true;
        }
    }

    public static AttributeSupplier.Builder endermaptera() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.27F)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.MAX_HEALTH, 16)
                .add(Attributes.ARMOR, 6)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
    }


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(CLIMBING, (byte) 0);
        p_326229_.define(ATTACHED_FACE, Direction.DOWN);
        p_326229_.define(HAS_JAWS, true);
    }

    public Direction getAttachmentFacing() {
        return this.entityData.get(ATTACHED_FACE);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WallClimberNavigation(this, worldIn);
    }

    @Nullable
    protected ResourceKey<LootTable> getDefaultLootTable() {
        return this.getHasJaws() ? HAS_JAWS_LOOT : super.getDefaultLootTable();
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Has_Jaws", getHasJaws());

    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(ATTACHED_FACE, Direction.from3DDataValue(compound.getByte("AttachFace")));
        setHasJaw(compound.getBoolean("Has_Jaws"));
    }

    public void setHasJaw(boolean HasJaws) {
        this.entityData.set(HAS_JAWS, HasJaws);

    }

    public boolean getHasJaws() {
        return this.entityData.get(HAS_JAWS);

    }

    public boolean causeFallDamage(float p_149683_, float p_149684_, DamageSource p_149685_) {
        return false;
    }

    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.ENDERMAPTERA_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.ENDERMAPTERA_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.ENDERMAPTERA_DEATH.get();
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ModSounds.ENDERMAPTERA_STEP.get(), 0.15F, 0.6F);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, JAW_ATTACK, HEADBUTT_ATTACK};
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_ENDER_GUARDIAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }


    public boolean doHurtTarget(Entity entityIn) {
        if (this.getHasJaws()) {
            this.setAnimation(JAW_ATTACK);
        } else {
            this.setAnimation(HEADBUTT_ATTACK);
        }
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        this.prevAttachChangeProgress = this.attachChangeProgress;
        AnimationHandler.INSTANCE.updateAnimations(this);
        if (attachChangeProgress > 0F) {
            attachChangeProgress -= 0.25F;
        }
        Vec3 Vec3 = this.getDeltaMovement();
        if (!this.level().isClientSide) {
            this.setBesideClimbableBlock(this.horizontalCollision || this.verticalCollision && !this.onGround());
            if (this.onGround() || this.isInWaterOrBubble() || this.isInLava()) {
                this.entityData.set(ATTACHED_FACE, Direction.DOWN);
            } else if (this.verticalCollision) {
                this.entityData.set(ATTACHED_FACE, Direction.UP);
            } else {
                Direction closestDirection = Direction.DOWN;
                double closestDistance = 100;
                for (Direction dir : HORIZONTALS) {
                    BlockPos antPos = new BlockPos(Mth.floor(this.getX()), Mth.floor(this.getY()), Mth.floor(this.getZ()));
                    BlockPos offsetPos = antPos.relative(dir);
                    Vec3 offset = Vec3.atCenterOf(offsetPos);
                    if (closestDistance > this.position().distanceTo(offset) && level().loadedAndEntityCanStandOnFace(offsetPos, this, dir.getOpposite())) {
                        closestDistance = this.position().distanceTo(offset);
                        closestDirection = dir;
                    }
                }
                this.entityData.set(ATTACHED_FACE, closestDirection);
            }
        }
        boolean flag = false;
        if (this.getAttachmentFacing() != Direction.DOWN) {
            if (this.getAttachmentFacing() == Direction.UP) {
                this.setDeltaMovement(this.getDeltaMovement().add(0, 1, 0));
            } else {
                if (!this.horizontalCollision && this.getAttachmentFacing() != Direction.UP) {
                    Vec3 vec = Vec3.atLowerCornerOf(this.getAttachmentFacing().getNormal());
                    this.setDeltaMovement(this.getDeltaMovement().add(vec.normalize().multiply(0.1F, 0.1F, 0.1F)));
                }
                if (!this.onGround() && Vec3.y < 0.0D) {
                    this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.5D, 1.0D));
                    flag = true;
                }
            }
        }
        if (this.getAttachmentFacing() == Direction.UP) {
            this.setNoGravity(true);
            this.setDeltaMovement(Vec3.multiply(0.7D, 1D, 0.7D));
        } else {
            this.setNoGravity(false);
        }
        if (!flag) {
            if (this.onClimbable()) {
                this.setDeltaMovement(Vec3.multiply(1.0D, 0.4D, 1.0D));
            }
        }
        if (prevAttachDir != this.getAttachmentFacing()) {
            attachChangeProgress = 1F;
        }
        this.prevAttachDir = this.getAttachmentFacing();
        if (!this.level().isClientSide) {
            if (this.getAttachmentFacing() == Direction.UP && !this.isUpsideDownNavigator) {
                switchNavigator(false);
            }
            if (this.getAttachmentFacing() != Direction.UP && this.isUpsideDownNavigator) {
                switchNavigator(true);
            }
            LivingEntity target = this.getTarget();
            if (target != null && distanceTo(target) < target.getBbWidth() + this.getBbWidth() && this.hasLineOfSight(target)) {
                float damage = (float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
                if (this.getAnimation() == JAW_ATTACK && this.getAnimationTick() == 11) {
                    target.hurt(this.damageSources().mobAttack(this), damage);
                    if (this.random.nextInt(6) == 0) {
                        BrokenJaws();
                    }
                }
                if (this.getAnimation() == HEADBUTT_ATTACK && this.getAnimationTick() == 6) {
                    target.hurt(this.damageSources().mobAttack(this), damage * 0.75f);
                }
            }
        } else {
            for (int i = 0; i < 2; ++i) {
                this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
            }
        }

    }

    private void BrokenJaws() {
        this.playSound(SoundEvents.ITEM_BREAK, 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        this.setHasJaw(false);
        int shardCount = 8 + random.nextInt(4);
        if (!this.level().isClientSide) {
            for (int i = 0; i < shardCount; i++) {
                float f = ((i + 1) / (float) shardCount) * 360F;
                Void_Shard_Entity shard = new Void_Shard_Entity(ModEntities.VOID_SHARD.get(), this.level(), this);
                shard.shootFromRotation(this, this.getXRot() - random.nextInt(40), f, 0.0F, 0.15F + random.nextFloat() * 0.2F, 1.0F);
                level().addFreshEntity(shard);
            }
        }
    }

    protected void onInsideBlock(BlockState state) {

    }

    public boolean onClimbable() {
        return this.isBesideClimbableBlock();
    }

    public boolean isBesideClimbableBlock() {
        return (this.entityData.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = this.entityData.get(CLIMBING);
        if (climbing) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        this.entityData.set(CLIMBING, b0);
    }


    public static boolean canSpawn(EntityType<Endermaptera_Entity> entity, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return !worldIn.getBlockState(pos.below()).is(ModTag.ENDERMAPTERA_CAN_NOT_SPAWN) && checkMonsterSpawnRules(entity,worldIn,reason,pos,randomIn);
    }


    @Override
    public int getAnimationTick() {
        return animationTick;
    }

    @Override
    public void setAnimationTick(int tick) {
        animationTick = tick;
    }

    @Override
    public Animation getAnimation() {
        return currentAnimation;
    }

    @Override
    public void setAnimation(Animation animation) {
        currentAnimation = animation;
    }

}
