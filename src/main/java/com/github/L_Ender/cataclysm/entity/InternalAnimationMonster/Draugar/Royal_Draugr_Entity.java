package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Goals.Royal_DraugrAttackGoal;
import com.github.L_Ender.cataclysm.entity.etc.IShieldEntity;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;


public class Royal_Draugr_Entity extends Monster implements IShieldEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState attack2AnimationState = new AnimationState();
    private int shieldCooldownTime = 0;


    public Royal_Draugr_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 7;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new Royal_DraugrAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SnowGolem.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }

    public static AttributeSupplier.Builder royal_draugr() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.27F)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.ARMOR, 5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.1);
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }


    public AnimationState getAnimationState(String input) {
        if (input == "attack") {
            return this.attackAnimationState;
        } else if (input == "attack2") {
            return this.attack2AnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        }else {
            return new AnimationState();
        }
    }


    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (damage > 0.0F && canBlockDamageSource(source)) {
            this.hurtCurrentlyUsedShield(damage);
            if (!source.is(DamageTypeTags.IS_PROJECTILE)) {
                if (entity instanceof LivingEntity) {
                    this.blockUsingShield((LivingEntity) entity);
                }
            }
            this.playSound(SoundEvents.SHIELD_BLOCK, 1.0F, 0.8F + this.level().random.nextFloat() * 0.4F);
            return false;
        }
        return super.hurt(source, damage);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    public int getShieldCooldownTime() {
        return this.shieldCooldownTime;
    }

    @Override
    public void setShieldCooldownTime(int shieldCooldownTime) {
        this.shieldCooldownTime = shieldCooldownTime;
    }

    @Override
    public boolean isShieldDisabled() {
        return this.shieldCooldownTime > 0;
    }

    @Override
    public void disableShield(boolean guaranteeDisable) {
        float f = 0.25F + (float) EnchantmentHelper.getBlockEfficiency(this) * 0.05F;
        if (guaranteeDisable) {
            f += 0.75F;
        }
        if (this.random.nextFloat() < f) {
            this.shieldCooldownTime = 100;
            this.stopUsingItem();
            this.level().broadcastEntityEvent(this, (byte) 30);
            this.playSound(SoundEvents.SHIELD_BREAK, 0.8F, 0.8F + this.level().random.nextFloat() * 0.4F);
        }
    }

    protected void hurtCurrentlyUsedShield(float p_36383_) {
        if (this.useItem.canPerformAction(net.minecraftforge.common.ToolActions.SHIELD_BLOCK)) {
            if (p_36383_ >= 3.0F) {
                int i = 1 + Mth.floor(p_36383_);
                InteractionHand interactionhand = this.getUsedItemHand();
                this.useItem.hurtAndBreak(i, this, (p_219739_) -> {
                    p_219739_.broadcastBreakEvent(interactionhand);
                });
                if (this.useItem.isEmpty()) {
                    this.stopUsingItem();
                    if (interactionhand == InteractionHand.MAIN_HAND) {
                        this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                    } else {
                        this.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                    }

                    this.useItem = ItemStack.EMPTY;
                    this.playSound(SoundEvents.SHIELD_BREAK, 0.8F, 0.8F + this.level().random.nextFloat() * 0.4F);
                }
            }

        }
    }

    public boolean isBlocking() {
        return false;
    }

    protected void blockUsingShield(LivingEntity p_36295_) {
        super.blockUsingShield(p_36295_);
        if (p_36295_.getMainHandItem().canDisableShield(this.useItem, this, p_36295_)) {
            this.disableShield(true);
        }

    }

    public boolean isDraugrBlocking() {
        if (this.isUsingItem() && !this.useItem.isEmpty()) {
            Item item = this.useItem.getItem();
            if (!this.useItem.canPerformAction(net.minecraftforge.common.ToolActions.SHIELD_BLOCK)) {
                return false;
            } else {
                return item.getUseDuration(this.useItem) - this.useItemRemaining >= 5;
            }
        } else {
            return false;
        }
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Entity entity = damageSourceIn.getDirectEntity();
        boolean flag = false;
        if (entity instanceof AbstractArrow abstractarrow) {
            if (abstractarrow.getPierceLevel() > 0) {
                flag = true;
            }
        }
        if (!damageSourceIn.is(DamageTypeTags.BYPASSES_SHIELD) && this.isDraugrBlocking() && !flag) {
            Vec3 vector3d2 = damageSourceIn.getSourcePosition();
            if (vector3d2 != null) {
                Vec3 vector3d = this.getViewVector(1.0F);
                Vec3 vector3d1 = vector3d2.vectorTo(this.position()).normalize();
                vector3d1 = new Vec3(vector3d1.x, 0.0D, vector3d1.z);
                return vector3d1.dot(vector3d) < 0.0D;
            }
        }
        return false;
    }

    public void stopAllAnimationStates() {
        this.attackAnimationState.stop();
        this.attack2AnimationState.stop();
    }


    public HumanoidArm getMainArm() {
        return HumanoidArm.LEFT;
    }

    public void handleEntityEvent(byte p_219360_) {
        if (p_219360_ == 4) {
            if(random.nextBoolean()) {
                this.attackAnimationState.start(this.tickCount);
            }else{
                this.attack2AnimationState.start(this.tickCount);
            }
        } else {
            super.handleEntityEvent(p_219360_);
        }
    }

    public boolean doHurtTarget(Entity p_219472_) {
        this.level().broadcastEntityEvent(this, (byte)4);
        if(this.isDraugrBlocking()){
            this.stopUsingItem();
            this.setShieldCooldownTime(30);
        }
        return super.doHurtTarget(p_219472_);
    }

    protected void dropCustomDeathLoot(DamageSource p_33574_, int p_33575_, boolean p_33576_) {
        super.dropCustomDeathLoot(p_33574_, p_33575_, p_33576_);
        Entity entity = p_33574_.getEntity();
        if (entity instanceof Creeper creeper) {
            if (creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(ModItems.DRAUGR_HEAD.get());
            }
        }

    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, MobSpawnType p_34090_, @Nullable SpawnGroupData p_34091_, @Nullable CompoundTag p_34092_) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_, p_34092_);
        RandomSource randomsource = p_34088_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_34089_);
        this.populateDefaultEquipmentEnchantments(randomsource, p_34089_);
        this.setItemSlot(EquipmentSlot.OFFHAND, this.createSpawnShiled());
        return spawngroupdata;
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        this.setItemSlot(EquipmentSlot.MAINHAND, this.createSpawnWeapon());
    }

    private ItemStack createSpawnWeapon() {
        return this.random.nextBoolean() ? new ItemStack(ModItems.BLACK_STEEL_AXE.get()) : new ItemStack(ModItems.BLACK_STEEL_SWORD.get());
    }

    private ItemStack createSpawnShiled() {
        return new ItemStack(ModItems.BLACK_STEEL_TARGE.get());
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
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }
        if (this.shieldCooldownTime > 0) {
            --this.shieldCooldownTime;
        }
    }

    public void aiStep() {
        super.aiStep();

    }


    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_MALEDICTUS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.DRAUGR_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.DRAUGR_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.DRAUGR_IDLE.get();
    }

}





