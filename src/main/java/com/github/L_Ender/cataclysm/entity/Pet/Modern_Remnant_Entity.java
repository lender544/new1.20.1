package com.github.L_Ender.cataclysm.entity.Pet;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.Pet.AI.TameableAIFollowOwner;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Optional;

public class Modern_Remnant_Entity extends LLibraryAnimationPet implements Bucketable {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(Modern_Remnant_Entity.class, EntityDataSerializers.BOOLEAN);
    public float sitProgress;
    public float prevSitProgress;
    private AttackMode mode = AttackMode.CIRCLE;
    public static final Animation MODERN_REMNANT_BITE = Animation.create(11);

    public Modern_Remnant_Entity(EntityType type, Level world) {
        super(type, world);
        this.xpReward = 0;
        setConfigattribute(this, CMConfig.ModernRemnantHealthMultiplier, CMConfig.ModernRemnantDamageMultiplier);
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.REMNANT_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.REMNANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.MODERN_REMNANT_DEATH.get();
    }

    @Override
    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 2.0F;
    }

    public static AttributeSupplier.Builder modernremnant() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 150.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .add(Attributes.ARMOR, 5D)
                .add(Attributes.FOLLOW_RANGE, 32.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.STEP_HEIGHT, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4F);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }




    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new ModernRemnantAIMelee(this));
        this.goalSelector.addGoal(6, new TameableAIFollowOwner(this, 1.3D, 6.0F, 2.0F, true));
        this.goalSelector.addGoal(6, new TemptGoal(this, 1.0D, Ingredient.of(Items.SNIFFER_EGG), false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D, 60));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(5, new NonTameRandomTargetGoal<>(this, LivingEntity.class, false,  ModEntities.buildPredicateFromTag(ModTag.MODERN_REMNANT_TARGET)));


    }


    public void travel(Vec3 vec3d) {
        if (this.isSitting()) {
            if (this.getNavigation().getPath() != null) {
                this.getNavigation().stop();
            }
            vec3d = Vec3.ZERO;
        }
        super.travel(vec3d);
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL) || source.is(DamageTypes.FALLING_BLOCK) || super.isInvulnerableTo(source);
    }


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(FROM_BUCKET, false);
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
    public boolean isFood(ItemStack p_27600_) {
        return p_27600_.is(ModTag.BONE_ITEM);
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
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, bucket, this::addAdditionalSaveData);
        Bucketable.saveDefaultDataToBucketTag(this, bucket);


    }

    @Override
    public void loadFromBucketTag(CompoundTag p_148832_) {
        readAdditionalSaveData(p_148832_);
        Bucketable.loadDefaultDataFromBucketTag(this, p_148832_);

    }

    @Override
    @Nonnull
    public ItemStack getBucketItemStack() {
        ItemStack stack = new ItemStack(ModItems.MODERN_REMNANT_BUCKET.get());
        return stack;
    }

    @Override
    public SoundEvent getPickupSound() {
        return ModSounds.MODERN_REMNANT_FILL_BUCKET.get();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        InteractionResult type = super.mobInteract(player, hand);
        if (!isTame() && item == Items.SNIFFER_EGG) {
            this.usePlayerItem(player, hand, itemstack);
            this.gameEvent(GameEvent.EAT);
            if (!net.neoforged.neoforge.event.EventHooks.onAnimalTame(this, player)) {
                this.tame(player);
                this.level().broadcastEntityEvent(this, (byte) 7);
            } else {
                this.level().broadcastEntityEvent(this, (byte) 6);
            }
            return InteractionResult.SUCCESS;
        }
        if (isTame() && this.isFood(itemstack)) {
            if (this.getHealth() < this.getMaxHealth()) {
                this.usePlayerItem(player, hand, itemstack);
                this.gameEvent(GameEvent.EAT);
                this.heal(5);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;

        }

        if (isTame()) {
            Optional<InteractionResult> result = emptybucketMobPickup(player, hand, this);
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

    private static <T extends LivingEntity & Bucketable> Optional<InteractionResult> emptybucketMobPickup(Player p_148829_, InteractionHand p_148830_, T p_148831_) {
        ItemStack itemstack = p_148829_.getItemInHand(p_148830_);
        if (itemstack.getItem() == Items.BUCKET && p_148831_.isAlive()) {
            p_148831_.playSound(p_148831_.getPickupSound(), 1.0F, 1.0F);
            ItemStack itemstack1 = p_148831_.getBucketItemStack();
            p_148831_.saveToBucketTag(itemstack1);
            ItemStack itemstack2 = ItemUtils.createFilledResult(itemstack, p_148829_, itemstack1, false);
            p_148829_.setItemInHand(p_148830_, itemstack2);
            Level level = p_148831_.level();
            if (!level.isClientSide) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer)p_148829_, itemstack1);
            }

            p_148831_.discard();
            return Optional.of(InteractionResult.sidedSuccess(level.isClientSide));
        } else {
            return Optional.empty();
        }
    }

    public void aiStep() {
        super.aiStep();
        if (this.isSitting() && this.getNavigation().isDone()) {
            this.getNavigation().stop();
        }
        this.prevSitProgress = sitProgress;
        if (this.isSitting() && sitProgress < 10) {
            this.sitProgress ++;
        }
        if (!this.isSitting() && sitProgress > 0) {
            this.sitProgress --;
        }

        if (this.getAnimation() == MODERN_REMNANT_BITE) {
            if (this.getAnimationTick() == 3) {
                this.playSound(ModSounds.MODERN_REMNANT_BITE.get(), 0.5f, 2.0f);
            }
        }

        AnimationHandler.INSTANCE.updateAnimations(this);
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

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageableEntity) {
        return null;
    }

    @Override
    public boolean shouldFollow() {
        return this.getCommand() == 1;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION,MODERN_REMNANT_BITE};
    }

    private enum AttackMode {
        CIRCLE,
        MELEE
    }
    class ModernRemnantAIMelee extends Goal {
        private final Modern_Remnant_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private int maxcirclingTime = 0;
        private float circleDistance = 13;
        private boolean clockwise = false;
        private float MeleeModeTime = 0;
        private static final int MELEE_MODE_TIME = 120;


        public ModernRemnantAIMelee(Modern_Remnant_Entity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive();
        }

        public boolean canContinueToUse() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public void start() {
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            maxcirclingTime = 120 + this.mob.random.nextInt(40);
            circleDistance = 8 + this.mob.random.nextInt(4);
            clockwise = this.mob.random.nextBoolean();
            MeleeModeTime = 0;
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            maxcirclingTime = 120 + this.mob.random.nextInt(40);
            circleDistance = 8 + this.mob.random.nextInt(4);
            clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
                this.mob.setTarget(null);
            }
            MeleeModeTime = 0;
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
                if (this.mob.mode == AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);
                    if (circlingTime >= maxcirclingTime) {
                        this.mob.mode = AttackMode.MELEE;
                    }
                    if (target.distanceTo(this.mob) < 5) {
                        this.mob.mode = AttackMode.MELEE;
                    }
                } else if (this.mob.mode == AttackMode.MELEE) {
                    MeleeModeTime++;
                    this.mob.getNavigation().moveTo(target, 1.0D);
                    this.mob.getLookControl().setLookAt(target, 30, 30);
                    if(MeleeModeTime >= MELEE_MODE_TIME) {
                        start();
                    }else if (this.mob.distanceToSqr(target) <= 4D && this.mob.getAnimation() == NO_ANIMATION) {
                        this.mob.setAnimation(MODERN_REMNANT_BITE);
                    }
                }

                if (this.mob.getAnimation() == MODERN_REMNANT_BITE) {
                    if (this.mob.getAnimationTick() == 5) {
                        if (this.mob.distanceTo(target) < this.mob.getBbWidth() * 2.5F * this.mob.getBbWidth() * 2.5F + target.getBbWidth()) {
                            float damage = (float) this.mob.getAttributeValue(Attributes.ATTACK_DAMAGE);
                            target.hurt(damageSources().mobAttack(this.mob), damage);
                        }
                    }
                }

            }

        }
    }

}
