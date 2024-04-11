package com.github.L_Ender.cataclysm.entity.Pet;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.L_Ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.L_Ender.cataclysm.entity.AI.MobAILeaveWater;
import com.github.L_Ender.cataclysm.entity.AI.SemiAquaticAIRandomSwimming;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Entity;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Portal_Abyss_Blast_Entity;
import com.github.L_Ender.cataclysm.entity.Pet.AI.PetSimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.Pet.AI.TameableAIFollowOwnerWater;
import com.github.L_Ender.cataclysm.entity.etc.GroundPathNavigatorWide;
import com.github.L_Ender.cataclysm.entity.etc.ISemiAquatic;
import com.github.L_Ender.cataclysm.entity.etc.SemiAquaticPathNavigator;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Mini_Abyss_Blast_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

public class The_Baby_Leviathan_Entity extends AnimationPet implements ISemiAquatic, Bucketable {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(The_Baby_Leviathan_Entity.class, EntityDataSerializers.BOOLEAN);

    public static final Animation BABY_LEVIATHAN_BITE = Animation.create(14);
    public static final Animation BABY_LEVIATHAN_ABYSS_BLAST = Animation.create(157);
    public float sitProgress;
    public float prevSitProgress;
    public float SwimProgress;
    public float prevSwimProgress;
    private int fishFeedings;
    private boolean isLandNavigator;
    private AttackMode mode = AttackMode.CIRCLE;
    private int blast_cooldown = 0;
    public static final int BLAST_HUNTING_COOLDOWN = 100;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;

    public The_Baby_Leviathan_Entity(EntityType type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 0.0F);
        switchNavigator(false);
        setConfigattribute(this, CMConfig.BabyLeviathanHealthMultiplier, CMConfig.BabyLeviathanDamageMultiplier);
        this.setMaxUpStep(1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.LEVIATHAN_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.LEVIATHAN_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.LEVIATHAN_DEFEAT.get();
    }

    @Override
    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 2.0F;
    }

    public boolean hurt(DamageSource source, float amount) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof Mini_Abyss_Blast_Entity || entity instanceof Abyss_Blast_Entity || entity instanceof Portal_Abyss_Blast_Entity) {
            return false;
        }
        return super.hurt(source, amount);
    }


    public static AttributeSupplier.Builder babyleviathan() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .add(Attributes.ARMOR, 5D)
                .add(Attributes.FOLLOW_RANGE, 32.0D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new TameableAIFollowOwnerWater(this, 1.3D, 4.0F, 2.0F, true));
        this.goalSelector.addGoal(3, new BabyLeviathanAttackGoal(this));
        this.goalSelector.addGoal(0, new BabyLeviathanBiteAttackGoal(this, BABY_LEVIATHAN_BITE));
        this.goalSelector.addGoal(0, new BabyLeviathanBlastAttackGoal(this, BABY_LEVIATHAN_ABYSS_BLAST));
        this.goalSelector.addGoal(4, new MobAIFindWater(this, 1.0f));
        this.goalSelector.addGoal(4, new MobAILeaveWater(this));
        this.goalSelector.addGoal(6, new TemptGoal(this, 1.0D, Ingredient.of(Items.TROPICAL_FISH), false));
        this.goalSelector.addGoal(7, new SemiAquaticAIRandomSwimming(this, 1.0D, 30));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new EntityAINearestTarget3D(this, LivingEntity.class, 120, false, true, ModEntities.buildPredicateFromTag(ModTag.BABY_LEVIATHAN_TARGET)) {
            public boolean canUse() {
                return The_Baby_Leviathan_Entity.this.getCommand() != 2 && !The_Baby_Leviathan_Entity.this.isSitting() && super.canUse();
            }
        });
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl(this);
            this.navigation = new GroundPathNavigatorWide(this, level());
            this.isLandNavigator = true;
        } else {
            this.moveControl = new BabyLeviathanMoveController(this, 3F, 1F, 10f);
            this.navigation = new SemiAquaticPathNavigator(this, level());
            this.isLandNavigator = false;
        }
    }

    public void travel(Vec3 travelVector) {
        if (this.isSitting()) {
            if (this.getNavigation().getPath() != null) {
                this.getNavigation().stop();
            }
            travelVector = Vec3.ZERO;
            super.travel(travelVector);
            return;
        }
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null && this.getAnimation() == NO_ANIMATION) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL) || source.is(DamageTypes.FALLING_BLOCK) || super.isInvulnerableTo(source);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromBucket", this.fromBucket());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean sit) {
        this.entityData.set(FROM_BUCKET, sit);
    }

    @Override
    public void saveToBucketTag(@Nonnull ItemStack bucket) {
        if (this.hasCustomName()) {
            bucket.setHoverName(this.getCustomName());
        }
        CompoundTag platTag = new CompoundTag();
        this.addAdditionalSaveData(platTag);
        CompoundTag compound = bucket.getOrCreateTag();
        compound.put("BabyLeviathanData", platTag);
    }

    @Override
    public void loadFromBucketTag(CompoundTag p_148832_) {
        if (p_148832_.contains("BabyLeviathanData")) {
            this.readAdditionalSaveData(p_148832_.getCompound("BabyLeviathanData"));
        }
    }

    @Override
    @Nonnull
    public ItemStack getBucketItemStack() {
        ItemStack stack = new ItemStack(ModItems.THE_BABY_LEVIATHAN_BUCKET.get());
        if (this.hasCustomName()) {
            stack.setHoverName(this.getCustomName());
        }
        return stack;
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_FISH;
    }


    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        InteractionResult type = super.mobInteract(player, hand);
        if (!isTame() && item == Items.TROPICAL_FISH) {
            this.usePlayerItem(player, hand, itemstack);
            this.gameEvent(GameEvent.EAT);
            fishFeedings++;
            if ((fishFeedings > 10 && getRandom().nextInt(6) == 0 || fishFeedings > 30) && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                this.tame(player);
                this.level().broadcastEntityEvent(this, (byte) 7);
            } else {
                this.level().broadcastEntityEvent(this, (byte) 6);
            }
            return InteractionResult.SUCCESS;
        }
        if (isTame() && itemstack.is(ItemTags.FISHES)) {
            if (this.getHealth() < this.getMaxHealth()) {
                this.usePlayerItem(player, hand, itemstack);
                this.gameEvent(GameEvent.EAT);
                this.heal(5);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;

        }
        if (isTame()) {
            Optional<InteractionResult> result = Bucketable.bucketMobPickup(player, hand, this);
            if (result.isPresent()) {
                return result.get();
            }
        }
        InteractionResult interactionresult = itemstack.interactLivingEntity(player, this, hand);
        if (interactionresult != InteractionResult.SUCCESS && type != InteractionResult.SUCCESS && isTame() && isOwnedBy(player)) {
            if (!player.isShiftKeyDown()) {
                this.setCommand(this.getCommand() + 1);
                if (this.getCommand() == 3) {
                    this.setCommand(0);
                }
                player.displayClientMessage(Component.translatable("entity.cataclysm.all.command_" + this.getCommand(), this.getName()), true);
                boolean sit = this.getCommand() == 2;
                if (sit) {
                    this.setOrderedToSit(true);
                    return InteractionResult.SUCCESS;
                } else {
                    this.setOrderedToSit(false);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return type;
    }

    public void aiStep() {
        super.aiStep();
        if (this.isSitting() && this.getNavigation().isDone()) {
            this.getNavigation().stop();
        }
        boolean swim = this.isInWater();
        this.prevSwimProgress = SwimProgress;
        this.prevSitProgress = sitProgress;
        if(SwimProgress < 5F && swim){
            SwimProgress++;
        }
        if(SwimProgress > 0 && !swim){
            SwimProgress--;
        }
        if (this.isSitting() && sitProgress < 5) {
            this.sitProgress ++;
        }
        if (!this.isSitting() && sitProgress > 0) {
            this.sitProgress --;
        }

        if (this.isInWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!this.isInWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }

        if (blast_cooldown > 0) {
            blast_cooldown--;
        }

        AnimationHandler.INSTANCE.updateAnimations(this);
        if (this.getAnimation() == BABY_LEVIATHAN_BITE) {
            if (this.getAnimationTick() == 7) {
                this.playSound(ModSounds.LEVIATHAN_BITE.get(), 0.5f, 2.0f);
            }
            if (this.getAnimationTick() == 9) {
                biteattack(1.5f, 0.5, 0.5, 0.5);
            }
        }
    }

    private void biteattack(float radius, double inflateX, double inflateY, double inflateZ) {
        double renderYaw = (this.yHeadRot + 90) * Math.PI / 180.0d;
        double renderPitch = (float) (-this.getXRot() * Math.PI / 180.0d);

        endPosX = getX() + radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        endPosZ = getZ() + radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        endPosY = getY() + radius * Math.sin(renderPitch);
        if (!level().isClientSide) {
            List<LivingEntity> hit = raytraceEntities(level(), inflateX, inflateY, inflateZ, new Vec3(getX(), getY(), getZ()), new Vec3(endPosX, endPosY, endPosZ)).entities;
            for (LivingEntity target : hit) {
                if (!isAlliedTo(target) && !(target instanceof The_Baby_Leviathan_Entity) && target != this) {
                    target.hurt(damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
                }
            }
        }
    }

    private BiteHitResult raytraceEntities(Level world, double inflateX, double inflateY, double inflateZ, Vec3 from, Vec3 to) {
        BiteHitResult result = new BiteHitResult();
        collidePosX = endPosX;
        collidePosY = endPosY;
        collidePosZ = endPosZ;

        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).inflate(inflateX, inflateY, inflateZ));
        for (LivingEntity entity : entities) {
            float pad = 2.5f;
            AABB aabb = entity.getBoundingBox().inflate(pad, pad, pad);
            Optional<Vec3> hit = aabb.clip(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
            } else if (hit.isPresent()) {
                result.addEntityHit(entity);
            }
        }
        return result;
    }

    public static class BiteHitResult {
        private final List<LivingEntity> entities = new ArrayList<>();


        public void addEntityHit(LivingEntity entity) {
            entities.add(entity);
        }
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (this.isTame()) {
            LivingEntity livingentity = this.getOwner();
            if (entityIn == livingentity) {
                return true;
            }
            if (entityIn instanceof TamableAnimal) {
                return ((TamableAnimal) entityIn).isOwnedBy(livingentity);
            }
            if (livingentity != null) {
                return livingentity.isAlliedTo(entityIn);
            }
        }

        return super.isAlliedTo(entityIn);
    }


    public boolean isPushedByFluid() {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageableEntity) {
        return null;
    }

    @Override
    public boolean shouldEnterWater() {
        return !this.isSitting();
    }

    @Override
    public boolean shouldLeaveWater() {
        return false;
    }

    @Override
    public boolean shouldStopMoving() {
        return isSitting();
    }

    @Override
    public int getWaterSearchRange() {
        return 32;
    }

    @Override
    public boolean shouldFollow() {
        return this.getCommand() == 1;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, BABY_LEVIATHAN_ABYSS_BLAST, BABY_LEVIATHAN_BITE};
    }

    private enum AttackMode {
        CIRCLE,
        MELEE,
        RANGE
    }


    static class BabyLeviathanBiteAttackGoal extends PetSimpleAnimationGoal<The_Baby_Leviathan_Entity> {

        public BabyLeviathanBiteAttackGoal(The_Baby_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 9 && target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
        }

        public void stop() {
            super.stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 30);
            }

        }
    }

    static class BabyLeviathanBlastAttackGoal extends PetSimpleAnimationGoal<The_Baby_Leviathan_Entity> {

        public BabyLeviathanBlastAttackGoal(The_Baby_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.level().playSound((Player) null, entity, ModSounds.ABYSS_BLAST.get(), SoundSource.NEUTRAL, 1.0f, 2.0f);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
                entity.lookAt(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.blast_cooldown = BLAST_HUNTING_COOLDOWN;
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
                entity.lookAt(target, 30, 90);
            }
            float dir = 90.0f;
            if (this.entity.getAnimationTick() == 37) {
                if (!entity.level().isClientSide) {
                    Mini_Abyss_Blast_Entity DeathBeam = new Mini_Abyss_Blast_Entity(ModEntities.MINI_ABYSS_BLAST.get(), entity.level(), entity, entity.getX(), entity.getY(), entity.getZ(), (float) ((entity.yHeadRot + dir) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 80, dir);
                    entity.level().addFreshEntity(DeathBeam);
                }
            }
        }
    }

    class BabyLeviathanAttackGoal extends Goal {
        private final The_Baby_Leviathan_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private float circleDistance = 4;
        private boolean clockwise = false;
        private float MeleeModeTime = 0;
        private static final int MELEE_MODE_TIME = 100;


        public BabyLeviathanAttackGoal(The_Baby_Leviathan_Entity mob) {
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

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void start() {
            this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            MeleeModeTime = 0;
            circleDistance = 8 + this.mob.random.nextInt(2);
            clockwise = this.mob.random.nextBoolean();
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.CIRCLE;
            circlingTime = 0;
            MeleeModeTime = 0;
            circleDistance = 8 + this.mob.random.nextInt(2);
            clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
                this.mob.setTarget((LivingEntity) null);
            }

            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAggressive(false);
                this.mob.getNavigation().stop();
            }
        }


        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == The_Baby_Leviathan_Entity.AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);
                    if (0 >= this.mob.blast_cooldown) {
                        this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.RANGE;
                    } else {
                        this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.MELEE;
                    }
                } else if (this.mob.mode == The_Baby_Leviathan_Entity.AttackMode.RANGE) {
                    if (this.mob.getRandom().nextFloat() * 100.0F < 3f) {
                        this.mob.setAnimation(BABY_LEVIATHAN_ABYSS_BLAST);
                    }
                } else if (this.mob.mode == The_Baby_Leviathan_Entity.AttackMode.MELEE) {
                    MeleeModeTime++;
                    this.mob.getNavigation().moveTo(target, 1.0D);
                    this.mob.getLookControl().setLookAt(target, 30, 90);
                    if(MeleeModeTime >= MELEE_MODE_TIME) {
                        this.mob.mode = The_Baby_Leviathan_Entity.AttackMode.RANGE;
                    }else if (this.mob.distanceToSqr(target) <= 4D) {
                        this.mob.setAnimation(BABY_LEVIATHAN_BITE);
                    }
                }

            }
        }
    }
    static class BabyLeviathanMoveController extends MoveControl {
        private final The_Baby_Leviathan_Entity entity;
        private final float speedMulti;
        private final float ySpeedMod;
        private final float yawLimit;
        private  int stillTicks = 0;
        public BabyLeviathanMoveController(The_Baby_Leviathan_Entity entity, float speedMulti, float ySpeedMod, float yawLimit) {
            super(entity);
            this.entity = entity;
            this.speedMulti = speedMulti;
            this.ySpeedMod = ySpeedMod;
            this.yawLimit = yawLimit;
        }

        public void tick() {
            if (this.entity.isInWater() && this.entity.getAnimation() == NO_ANIMATION) {
                if (Math.abs(this.entity.xo - this.entity.getX()) < 0.01F && Math.abs(this.entity.yo - this.entity.getY()) < 0.01F && Math.abs(this.entity.zo - this.entity.getZ()) < 0.01F) {
                    stillTicks++;
                } else {
                    stillTicks = 0;
                }
                if (stillTicks > 40){
                    this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
                }
            }
            if (((ISemiAquatic) entity).shouldStopMoving()) {
                this.entity.setSpeed(0.0F);
                return;
            }
            if (this.operation == Operation.MOVE_TO && !this.entity.getNavigation().isDone()) {
                double lvt_1_1_ = this.wantedX - this.entity.getX();
                double lvt_3_1_ = this.wantedY - this.entity.getY();
                double lvt_5_1_ = this.wantedZ - this.entity.getZ();
                double lvt_7_1_ = lvt_1_1_ * lvt_1_1_ + lvt_3_1_ * lvt_3_1_ + lvt_5_1_ * lvt_5_1_;
                if (lvt_7_1_ < 2.500000277905201E-7D) {
                    this.mob.setZza(0.0F);
                } else {
                    float lvt_9_1_ = (float) (Mth.atan2(lvt_5_1_, lvt_1_1_) * 57.2957763671875D) - 90.0F;
                    this.entity.setYRot(this.rotlerp(this.entity.getYRot(), lvt_9_1_, yawLimit));
                    this.entity.yBodyRot = this.entity.getYRot();
                    this.entity.yHeadRot = this.entity.getYRot();
                    float lvt_10_1_ = (float) (this.speedModifier * speedMulti * 3 * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    if (this.entity.isInWater()) {
                        if(lvt_3_1_ > 0 && entity.horizontalCollision){
                            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, 0.08F, 0.0D));
                        }else{
                            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, (double) this.entity.getSpeed() * lvt_3_1_ * 0.6D * ySpeedMod, 0.0D));
                        }
                        this.entity.setSpeed(lvt_10_1_ * 0.02F);
                        float lvt_11_1_ = -((float) (Mth.atan2(lvt_3_1_, Mth.sqrt((float) (lvt_1_1_ * lvt_1_1_ + lvt_5_1_ * lvt_5_1_))) * 57.2957763671875D));
                        lvt_11_1_ = Mth.clamp(Mth.wrapDegrees(lvt_11_1_), -85.0F, 85.0F);
                        this.entity.setXRot(this.rotlerp(this.entity.getXRot(), lvt_11_1_, 5.0F));
                        float lvt_12_1_ = Mth.cos(this.entity.getXRot() * 0.017453292F);
                        float lvt_13_1_ = Mth.sin(this.entity.getXRot() * 0.017453292F);
                        this.entity.zza = lvt_12_1_ * lvt_10_1_;
                        this.entity.yya = -lvt_13_1_ * lvt_10_1_;
                    } else {
                        this.entity.setSpeed(lvt_10_1_ * 0.1F);
                    }

                }
            } else {
                this.entity.setSpeed(0.0F);
                this.entity.setXxa(0.0F);
                this.entity.setYya(0.0F);
                this.entity.setZza(0.0F);
            }
        }
    }
}
