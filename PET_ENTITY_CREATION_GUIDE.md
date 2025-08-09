# Pet Entity Creation Guide for L_Ender's Cataclysm

This guide provides a comprehensive template for creating new pet entities that extend the `AnimationPet` class with proper wolf-like behaviors, sitting/standing mechanics, and taming systems.

## Overview

This template is based on the successful implementation of the Teddy Bear pet and addresses common pitfalls encountered during development. Following this guide ensures consistent behavior across all pet entities.

## File Structure

For each new pet, you'll need to create these files:
```
src/main/java/com/github/L_Ender/cataclysm/entity/Pet/[PetName]_Entity.java
src/main/java/com/github/L_Ender/cataclysm/client/model/entity/[PetName]_Model.java  
src/main/java/com/github/L_Ender/cataclysm/client/animation/[PetName]_Animation.java
bbmodels/[pet_name].bbmodel
src/main/resources/assets/cataclysm/textures/entity/[pet_name].png
```

## Step 1: Create Blockbench Model (.bbmodel)

### Model Requirements:
- **Texture Size**: 64x64 pixels (standard for most pets)
- **Hierarchical Structure**: Use groups for proper animation
- **Root Structure**:
  ```
  root
    └── body_group
        ├── head_group
        ├── left_arm_group  
        ├── right_arm_group
        ├── left_leg_group
        └── right_leg_group
  ```

### Key Points:
- Use descriptive group names matching your model parts
- Set proper pivot points for each group (crucial for animation)
- Keep model proportions reasonable for gameplay (similar to wolf size)
- Export texture as PNG to `src/main/resources/assets/cataclysm/textures/entity/`

## Step 2: Animation Definition Class

Create `[PetName]_Animation.java`:

```java
package com.github.L_Ender.cataclysm.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class [PetName]_Animation {
    
    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(2.0F).looping()
            .addAnimation("head_group", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .build();

    public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(1.0F).looping()
            .addAnimation("left_leg_group", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg_group", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .build();

    public static final AnimationDefinition SIT = AnimationDefinition.Builder.withLength(0.5F)
            .addAnimation("body_group", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg_group", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg_group", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)))
            .build();
}
```

## Step 3: Model Class

Create `[PetName]_Model.java`:

```java
package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.animation.[PetName]_Animation;
import com.github.L_Ender.cataclysm.entity.Pet.[PetName]_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class [PetName]_Model extends HierarchicalModel<[PetName]_Entity> {

    public static final ModelLayerLocation LAYER_LOCATION = CMModelLayers.[PET_NAME]_MODEL;
    private final ModelPart root;
    private final ModelPart body_group;
    private final ModelPart head_group;
    // Add other model parts as needed

    public [PetName]_Model(ModelPart root) {
        this.root = root.getChild("root");
        this.body_group = this.root.getChild("body_group");
        this.head_group = this.body_group.getChild("head_group");
        // Initialize other parts
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // Copy structure from your .bbmodel file
        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        
        // Add all your model parts here based on the .bbmodel export
        // [Copy the createBodyLayer content from Blockbench Java export]
        
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim([PetName]_Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animate(entity.idleAnimationState, [PetName]_Animation.IDLE, ageInTicks, 1.0F);
        this.animateWalk([PetName]_Animation.WALK, limbSwing, limbSwingAmount, 2.0F, 2.0F);
        this.animate(entity.sitAnimationState, [PetName]_Animation.SIT, ageInTicks, 1.0F);
    }

    private void animateHeadLookTarget(float yRot, float xRot) {
        this.head_group.xRot += xRot * ((float) Math.PI / 180F);
        this.head_group.yRot += yRot * ((float) Math.PI / 180F);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
```

## Step 4: Entity Class Template

Create `[PetName]_Entity.java`:

```java
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

public class [PetName]_Entity extends AnimationPet {

    // Custom data accessors (avoid duplicating parent class ones)
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId([PetName]_Entity.class, EntityDataSerializers.INT);

    // Animation states
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState sitAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public [PetName]_Entity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder bakeAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8.0D)  // Wild health (will scale to 40 when tamed)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.ATTACK_SPEED, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));  // Combat maneuver like wolves
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));  // Primary combat behavior
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(6, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(9, new WaterAvoidingRandomStrollGoal(this, 1.0D));

        // Defensive targeting AI (matches wolf priorities)
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Variant", this.getVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setVariant(compoundTag.getInt("Variant"));
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        } else {
            // Wolf-like teleportation behavior
            if (this.isTame() && this.getOwner() != null && !this.isOrderedToSit() && !this.isSitting()) {
                LivingEntity owner = this.getOwner();
                double distance = this.distanceToSqr(owner);
                
                if (distance > 144.0D) { // 12 blocks squared
                    this.teleportToOwner();
                }
            }
            
            // CRITICAL: Force gravity/physics check - prevent floating when blocks are broken
            if (!this.onGround() && this.getDeltaMovement().y >= 0) {
                // Check if there's solid ground below within reasonable distance
                boolean hasGroundSupport = false;
                for (int i = 1; i <= 3; i++) {
                    BlockPos below = this.blockPosition().below(i);
                    if (this.level().getBlockState(below).isSolidRender(this.level(), below)) {
                        hasGroundSupport = true;
                        break;
                    }
                }
                
                // If floating without ground support, apply gravity
                if (!hasGroundSupport) {
                    this.setDeltaMovement(this.getDeltaMovement().add(0, -0.08, 0)); // Apply gravity
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

        if (this.level().isClientSide) {
            // Client side - report if interaction should work
            if (this.isTame() && this.isOwnedBy(player)) {
                boolean shouldToggleSit = itemstack.isEmpty() || !this.isFood(itemstack) || this.getHealth() >= this.getMaxHealth();
                if (shouldToggleSit || (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth())) {
                    return InteractionResult.SUCCESS;
                }
            } else if (!this.isTame() && this.isFood(itemstack)) {
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }

        // Server side logic
        if (this.isTame()) {
            // Priority 1: Healing with food when hurt
            if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                float healAmount = 2.0F;
                FoodProperties foodProperties = itemstack.getFoodProperties(this);
                if (foodProperties != null) {
                    healAmount = Math.max(healAmount, foodProperties.getNutrition());
                }
                this.heal(healAmount);
                return InteractionResult.SUCCESS;
            }
            
            // Priority 2: Sit/stand toggle
            if (this.isOwnedBy(player)) {
                boolean shouldToggleSit = itemstack.isEmpty() || !this.isFood(itemstack) || this.getHealth() >= this.getMaxHealth();
                
                if (shouldToggleSit) {
                    boolean newSitState = !this.isOrderedToSit();
                    this.setOrderedToSit(newSitState);
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget(null);
                    
                    // Show status message to player
                    if (newSitState) {
                        player.displayClientMessage(net.minecraft.network.chat.Component.literal("[PetName] is now sitting"), true);
                    } else {
                        player.displayClientMessage(net.minecraft.network.chat.Component.literal("[PetName] is now standing"), true);
                    }
                    
                    return InteractionResult.SUCCESS;
                }
            }
        } else if (this.isFood(itemstack)) {
            // Taming logic
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            
            if (this.random.nextInt(3) == 0) { // 1/3 chance like wolves
                this.tame(player);
                this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0D);
                this.setHealth(40.0F);
                this.navigation.stop();
                this.setTarget(null);
                this.level().broadcastEntityEvent(this, (byte)7);
            } else {
                this.level().broadcastEntityEvent(this, (byte)6);
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        // Define what items can tame/heal this pet
        return itemStack.is(Items.BONE) || itemStack.is(Items.COOKED_BEEF);
    }

    @Override
    public boolean isOrderedToSit() {
        return this.isSitting(); // CRITICAL: Use parent class's sitting system
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 7) {
            // Successful taming - show hearts
            this.showEmoteParticle(true);
        } else if (id == 6) {
            // Failed taming - show smoke
            this.showEmoteParticle(false);
        } else {
            super.handleEntityEvent(id);
        }
    }

    private void showEmoteParticle(boolean success) {
        for(int i = 0; i < 7; ++i) {
            double d0 = this.random.nextGaussian() * 0.02D;
            double d1 = this.random.nextGaussian() * 0.02D;
            double d2 = this.random.nextGaussian() * 0.02D;
            if (success) {
                this.level().addParticle(net.minecraft.core.particles.ParticleTypes.HEART, 
                    this.getX() + (double)(this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double)this.getBbWidth(), 
                    this.getY() + 0.5D + (double)(this.random.nextFloat() * this.getBbHeight()), 
                    this.getZ() + (double)(this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double)this.getBbWidth(), 
                    d0, d1, d2);
            } else {
                this.level().addParticle(net.minecraft.core.particles.ParticleTypes.SMOKE, 
                    this.getX() + (double)(this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double)this.getBbWidth(), 
                    this.getY() + 0.5D + (double)(this.random.nextFloat() * this.getBbHeight()), 
                    this.getZ() + (double)(this.random.nextFloat() * this.getBbWidth() * 2.0F) - (double)this.getBbWidth(), 
                    d0, d1, d2);
            }
        }
    }

    @Override
    public void travel(net.minecraft.world.phys.Vec3 pTravelVector) {
        // CRITICAL: Prevent movement when sitting
        if (this.isSitting()) {
            if (this.isControlledByLocalInstance()) {
                this.lerpSteps = 0;
                this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
            }
            
            if (this.lerpSteps > 0) {
                double x = this.getX() + (this.lerpX - this.getX()) / (double)this.lerpSteps;
                double y = this.getY() + (this.lerpY - this.getY()) / (double)this.lerpSteps;
                double z = this.getZ() + (this.lerpZ - this.getZ()) / (double)this.lerpSteps;
                this.setYRot(this.getYRot() + (float)net.minecraft.util.Mth.wrapDegrees(this.lerpYRot - (double)this.getYRot()) / (float)this.lerpSteps);
                this.setXRot(this.getXRot() + (float)(this.lerpXRot - (double)this.getXRot()) / (float)this.lerpSteps);
                --this.lerpSteps;
                this.setPos(x, y, z);
            } else {
                this.reapplyPosition();
            }
            
            this.calculateEntityAnimation(false);
            return;
        }
        
        super.travel(pTravelVector);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        [PetName]_Entity baby = ModEntities.[PET_NAME].get().create(serverLevel);
        if (baby != null) {
            // Baby inherits variant from parents
            if (ageableMob instanceof [PetName]_Entity otherParent) {
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

    // Variant system
    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    // Sound overrides
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ITEM_PICKUP; // Choose appropriate sound
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
        this.setVariant(this.random.nextInt(3)); // Number of variants
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "idle" -> this.idleAnimationState;
            case "sit" -> this.sitAnimationState;
            default -> null;
        };
    }

    public static boolean canSpawn(EntityType<[PetName]_Entity> entityType, LevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return Animal.checkAnimalSpawnRules(entityType, levelAccessor, spawnType, pos, random) && random.nextInt(8) == 0;
    }

    // Teleportation utility methods
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
```

## Step 5: Registration

### Add to ModEntities.java:
```java
public static final RegistryObject<EntityType<[PetName]_Entity>> [PET_NAME] = ENTITY_TYPE.register("[pet_name]", () -> EntityType.Builder.of([PetName]_Entity::new, MobCategory.CREATURE)
        .sized(0.6F, 0.8F)  // Adjust width and height as needed
        .clientTrackingRange(10)
        .build(Cataclysm.MODID + ":[pet_name]"));
```

### Add to entity registration method:
```java
event.getRegistry().register([PetName]_Entity.bakeAttributes().build(), ModEntities.[PET_NAME].get());
```

### Add model layer to CMModelLayers.java:
```java
public static final ModelLayerLocation [PET_NAME]_MODEL = new ModelLayerLocation(new ResourceLocation(Cataclysm.MODID, "[pet_name]"), "main");
```

## Step 6: Client Registration

Add to your client-side registration:
- Model layer definition
- Entity renderer
- Spawn egg (if needed)

## Common Pitfalls to Avoid

### 1. Sitting System Conflicts
❌ **Wrong**: Creating your own sitting data accessor
✅ **Correct**: Use `isOrderedToSit()` override to delegate to parent's `isSitting()`

### 2. Client/Server Synchronization  
❌ **Wrong**: Mixed client/server logic in `mobInteract`
✅ **Correct**: Clear separation with proper return values

### 3. Animation Syntax
❌ **Wrong**: `AnimationChannel.Builder.create()` (doesn't exist in 1.20.1)
✅ **Correct**: `new AnimationChannel()` constructor

### 4. Movement While Sitting
❌ **Wrong**: Allowing normal movement when sitting
✅ **Correct**: Override `travel()` to prevent movement when sitting

### 5. Missing Combat Goals
❌ **Wrong**: Only having targeting goals without combat actions
✅ **Correct**: Include `LeapAtTargetGoal` and `MeleeAttackGoal` for proper defense

### 6. Physics Issues
❌ **Wrong**: Entity floating when blocks are broken beneath it
✅ **Correct**: Add gravity checks in `tick()` method to prevent floating

### 7. Particle Events
❌ **Wrong**: Calling `broadcastEntityEvent` in wrong places  
✅ **Correct**: Use with proper `handleEntityEvent` override

### 8. Entity Inheritance
❌ **Wrong**: Extending `Animation_Monster` or wrong base class
✅ **Correct**: Extend `AnimationPet` for proper pet behaviors

## Testing Checklist

Before considering a pet complete, test these behaviors:

- [ ] **Spawning**: Entity appears in creative mode and spawns naturally
- [ ] **Taming**: Hearts appear on successful taming, smoke on failure
- [ ] **Sitting**: Right-click toggles sit/stand, prevents movement when sitting
- [ ] **Following**: Follows owner when not sitting, teleports when far
- [ ] **Healing**: Eating food heals when hurt
- [ ] **Breeding**: Two tamed pets can breed with appropriate food
- [ ] **Persistence**: Sits/stands state saves correctly
- [ ] **Owner Defense**: Attacks entities that hurt owner
- [ ] **Animation**: Idle, walk, and sit animations work properly

## User Experience Features

### Status Messages
Show helpful messages to players using:
```java
player.displayClientMessage(net.minecraft.network.chat.Component.literal("Pet is now sitting"), true);
```

The `true` parameter shows the message in the action bar (above hotbar) rather than chat.

### Debug Tips
For troubleshooting during development, temporarily add console output:
```java
System.out.println("Debug: Pet sit state changed");
```

Remember to remove debug output before final release.

## Performance Notes

- Animation states are client-side only
- Server-side logic in `tick()` should be minimal
- Use `level().isClientSide()` checks appropriately
- Teleportation has attempt limits to prevent infinite loops

Following this template ensures consistent, well-behaved pet entities with all the expected wolf-like behaviors while avoiding the common pitfalls encountered during development.