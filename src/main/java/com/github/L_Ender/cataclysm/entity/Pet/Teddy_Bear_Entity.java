package com.github.L_Ender.cataclysm.entity.Pet;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import com.github.L_Ender.cataclysm.init.ModEntities;

import javax.annotation.Nullable;

public class Teddy_Bear_Entity extends AnimationPet {

    private static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.defineId(Teddy_Bear_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Teddy_Bear_Entity.class, EntityDataSerializers.INT);

    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sitAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;

    public Teddy_Bear_Entity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder bakeAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8.0D)  // Wild teddy bears start with lower health
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.ATTACK_SPEED, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)  // Slightly faster like wolves
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        // Removed BegGoal since it's wolf-specific - we'll implement begging behavior manually
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(5, new BreedGoal(this, 1.0D));  // Allow breeding
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));

        // Better defensive AI
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SITTING, false);
        this.entityData.define(VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("IsSitting", this.isSitting());
        compoundTag.putInt("Variant", this.getVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setSitting(compoundTag.getBoolean("IsSitting"));
        this.setVariant(compoundTag.getInt("Variant"));
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        } else {
            // Wolf-like teleportation behavior
            if (this.isTame() && this.getOwner() != null && !this.isOrderedToSit()) {
                LivingEntity owner = this.getOwner();
                double distance = this.distanceToSqr(owner);
                
                // Teleport if too far away (like wolves do)
                if (distance > 144.0D) { // 12 blocks squared
                    this.teleportToOwner();
                }
            }
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isSitting()) {
            this.sitAnimationState.startIfStopped(this.tickCount);
        } else {
            this.sitAnimationState.stop();
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (this.isTame()) {
            if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                // Wolf-like health regeneration - more healing for meat items
                float healAmount = 2.0F;
                FoodProperties foodProperties = itemstack.getFoodProperties(this);
                if (foodProperties != null) {
                    healAmount = Math.max(healAmount, foodProperties.getNutrition());
                }
                this.heal(healAmount);
                return InteractionResult.SUCCESS;
            } else if (this.isOwnedBy(player) && !this.level().isClientSide && !this.isFood(itemstack)) {
                // Toggle sit/follow behavior
                this.setOrderedToSit(!this.isOrderedToSit());
                this.jumping = false;
                this.navigation.stop();
                this.setTarget(null);
                return InteractionResult.SUCCESS;
            }
        } else if (this.isFood(itemstack)) {
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            
            // Wolf-like taming chance
            if (this.random.nextInt(3) == 0) {
                this.tame(player);
                // Scale health up when tamed (like wolves: 8 HP -> 40 HP)
                this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0D);
                this.setHealth(40.0F);
                this.navigation.stop();
                this.setTarget(null);
                this.setOrderedToSit(true);
                this.level().broadcastEntityEvent(this, (byte)7);
            } else {
                this.level().broadcastEntityEvent(this, (byte)6);
            }

            return InteractionResult.SUCCESS;
        }

        return super.mobInteract(player, hand);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.HONEY_BOTTLE) || itemStack.is(Items.SWEET_BERRIES) || itemStack.is(Items.COOKIE);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        Teddy_Bear_Entity baby = ModEntities.TEDDY_BEAR.get().create(serverLevel);
        if (baby != null) {
            // Baby inherits random variant from parents
            if (ageableMob instanceof Teddy_Bear_Entity otherParent) {
                if (this.random.nextBoolean()) {
                    baby.setVariant(this.getVariant());
                } else {
                    baby.setVariant(otherParent.getVariant());
                }
            } else {
                baby.setVariant(this.getVariant());
            }
        }
        return baby;
    }

    public boolean isSitting() {
        return this.entityData.get(SITTING);
    }

    public void setSitting(boolean sitting) {
        this.entityData.set(SITTING, sitting);
    }

    @Override
    public void setOrderedToSit(boolean orderedToSit) {
        super.setOrderedToSit(orderedToSit);
        this.setSitting(orderedToSit);
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ITEM_PICKUP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.WOOL_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOOL_BREAK;
    }

    @Override
    protected void playStepSound(BlockPos blockPos, BlockState blockState) {
        this.playSound(SoundEvents.WOOL_STEP, 0.15F, 1.0F);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        this.setVariant(this.random.nextInt(3)); // 3 variants
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public AnimationState getAnimationState(String input) {
        if (input.equals("idle")) {
            return this.idleAnimationState;
        } else if (input.equals("sit")) {
            return this.sitAnimationState;
        }
        return null;
    }

    public static boolean canSpawn(EntityType<Teddy_Bear_Entity> entityType, LevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return Animal.checkAnimalSpawnRules(entityType, levelAccessor, spawnType, pos, random) && random.nextInt(8) == 0;
    }

    private void teleportToOwner() {
        LivingEntity owner = this.getOwner();
        if (owner == null) return;

        for (int attempt = 0; attempt < 10; ++attempt) {
            int x = this.getRandomX(5) - 2;
            int z = this.getRandomZ(5) - 2;
            int y = this.getTeleportRandomY();
            
            BlockPos targetPos = new BlockPos((int) (owner.getX() + x), (int) (owner.getY() + y), (int) (owner.getZ() + z));
            
            if (this.maybeTeleportTo(targetPos.getX(), targetPos.getY(), targetPos.getZ())) {
                this.navigation.stop();
                this.setTarget(null);
                return;
            }
        }
    }

    private int getRandomX(int range) {
        return this.random.nextInt(range * 2 + 1);
    }

    private int getRandomZ(int range) {
        return this.random.nextInt(range * 2 + 1);
    }

    private int getTeleportRandomY() {
        return this.random.nextInt(3) - 1;
    }

    private boolean maybeTeleportTo(int x, int y, int z) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(x, y, z);
        
        while (pos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(pos).blocksMotion()) {
            pos.move(0, -1, 0);
        }

        BlockState blockState = this.level().getBlockState(pos);
        boolean canSpawn = blockState.blocksMotion() && 
                          !blockState.hasAnalogOutputSignal() && 
                          this.level().isEmptyBlock(pos.above()) && 
                          this.level().isEmptyBlock(pos.above(2));

        if (canSpawn) {
            this.moveTo((double)x + 0.5D, (double)y, (double)z + 0.5D, this.getYRot(), this.getXRot());
            this.navigation.stop();
            return true;
        }

        return false;
    }
}