package com.github.L_Ender.cataclysm.entity.AnimationMonster;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Optional;


public class Koboleton_Entity extends Animation_Monster {

    public static final Animation COBOLETON_ATTACK = Animation.create(19);

    public float angryProgress;
    public float prevangryProgress;

    public Koboleton_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 8;
        this.setMaxUpStep(1.25F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, COBOLETON_ATTACK};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new AnimationMeleeAttackGoal(this,1.0D,false));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }

    public static AttributeSupplier.Builder koboleton() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 15.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.4F)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.MAX_HEALTH, 25)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
    }


    @Override
    public boolean hurt(DamageSource source, float damage) {
        return super.hurt(source, damage);
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }


    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.KOBOLETON_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.KOBOLETON_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.KOBOLETON_DEATH.get();
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ModSounds.KOBOLETON_STEP.get(), 0.15F, 0.6F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }


    protected void populateDefaultEquipmentSlots(RandomSource p_219154_, DifficultyInstance p_219155_) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.KHOPESH.get()));
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, MobSpawnType p_34090_, @Nullable SpawnGroupData p_34091_, @Nullable CompoundTag p_34092_) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_, p_34092_);
        RandomSource randomsource = p_34088_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_34089_);
        return spawngroupdata;
    }


    public void tick() {
        super.tick();
        AnimationHandler.INSTANCE.updateAnimations(this);
        prevangryProgress = angryProgress;
        if (this.isAggressive() && angryProgress < 10F) {
            angryProgress++;
        }
        if (!this.isAggressive() && angryProgress > 0F) {
            angryProgress--;
        }
        LivingEntity target = this.getTarget();
        if(this.isAlive()) {
            if (this.getAnimation() == COBOLETON_ATTACK) {
                if (this.getAnimationTick() == 11) {
                    this.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                    if (target != null) {
                        if (this.distanceTo(target) < this.getBbWidth() * 2.5F * this.getBbWidth() * 2.5F + target.getBbWidth()) {
                            float damage = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                            target.hurt(damageSources().mobAttack(this), damage);

                            ItemStack offhand = target.getOffhandItem();
                            ItemStack mainhand = target.getMainHandItem();
                            Optional<SlotResult> slot = CuriosApi.getCuriosHelper().findFirstCurio(target, stack -> stack.is(ModItems.STICKY_GLOVES.get()));
                            if(this.random.nextFloat() * 100.0F <= CMConfig.CauseKoboletontoDropItemInHandPercent) {
                                if (slot.isEmpty()) {
                                    if (!offhand.isEmpty()) {
                                        if (!offhand.is(ModTag.STICKY_ITEM)) {
                                            int i = offhand.getCount();
                                            this.koboletonstealdrop(offhand.copyWithCount(1), target);
                                            target.setItemSlot(EquipmentSlot.OFFHAND, offhand.split(i - 1));
                                        }
                                    } else {
                                        if (!mainhand.isEmpty()) {
                                            if (!mainhand.is(ModTag.STICKY_ITEM)) {
                                                int i = mainhand.getCount();
                                                this.koboletonstealdrop(mainhand.copyWithCount(1), target);
                                                target.setItemSlot(EquipmentSlot.MAINHAND, mainhand.split(i - 1));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ItemEntity koboletonstealdrop(ItemStack p_36179_, LivingEntity target) {
        if (p_36179_.isEmpty()) {
            return null;
        } else if (this.level().isClientSide) {
            return null;
        } else {
            double d0 = target.getEyeY() - (double)0.3F;
            ItemEntity itementity = new ItemEntity(target.level(), target.getX(), d0, target.getZ(), p_36179_);
            itementity.setDefaultPickUpDelay();
            itementity.setExtendedLifetime();
            float f8 = Mth.sin(target.getXRot() * ((float)Math.PI / 180F));
            float f2 = Mth.cos(target.getXRot() * ((float)Math.PI / 180F));
            float f3 = Mth.sin(target.getYRot() * ((float)Math.PI / 180F));
            float f4 = Mth.cos(target.getYRot() * ((float)Math.PI / 180F));
            float f5 = target.getRandom().nextFloat() * ((float)Math.PI * 2F);
            float f6 = 0.02F * target.getRandom().nextFloat();
            itementity.setDeltaMovement((double)(-f3 * f2 * 0.3F) + Math.cos((double)f5) * (double)f6, (double)(-f8 * 0.3F + 0.1F + (target.getRandom().nextFloat() - target.getRandom().nextFloat()) * 0.1F), (double)(f4 * f2 * 0.3F) + Math.sin((double)f5) * (double)f6);
            this.level().addFreshEntity(itementity);
            return itementity;
        }

    }

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        return ModEntities.rollSpawn(CMConfig.KoboletonSpawnRolls, this.getRandom(), spawnReasonIn);
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_ANCIENT_REMNANT)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }


    static class AnimationMeleeAttackGoal extends MeleeAttackGoal {
        protected final Koboleton_Entity mob;


        public AnimationMeleeAttackGoal(Koboleton_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_,p_25553_,p_25554_);
            this.mob = p_25552_;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }


        protected double getAttackReachSqr(LivingEntity p_25556_) {
            return (double)(this.mob.getBbWidth() * 2.5F * this.mob.getBbWidth() * 2.5F + p_25556_.getBbWidth());
        }

        protected void checkAndPerformAttack(LivingEntity p_25557_, double p_25558_) {
            double d0 = this.getAttackReachSqr(p_25557_);
            if (p_25558_ <= d0 && this.mob.getAnimation() == NO_ANIMATION) {
                this.mob.setAnimation(COBOLETON_ATTACK);
            }

        }
    }
}





