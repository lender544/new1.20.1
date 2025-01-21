package com.github.L_Ender.cataclysm.entity.Deepling;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.world.data.CMWorldData;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Deepling_Priest_Entity extends AbstractDeepling {
    boolean searchingForLand;
    public static final Animation DEEPLING_MELEE = Animation.create(20);
    public static final Animation DEEPLING_BLIND = Animation.create(57);

    private int lightcooldown = 200;
    public static final int LIGHT_COOLDOWN = 200;
    private static final EntityDimensions SWIMMING_SIZE = EntityDimensions.fixed(1.15f, 0.6F);

    public Deepling_Priest_Entity(EntityType entity, Level world) {
        super(entity, world);
        switchNavigator(false);
        this.xpReward = 10;

    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new DeeplingLightGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(3, new AnimationMeleeAttackGoal(this, 1.0f, false));
    }

    public static AttributeSupplier.Builder deeplingpriest() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.27F)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.MAX_HEALTH, 45)
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
    }


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WaterBoundPathNavigation(this, worldIn);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219154_, DifficultyInstance p_219155_) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ATHAME.get()));
        this.setDropChance(EquipmentSlot.MAINHAND, 0.0F);
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.DEEPLING_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.DEEPLING_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.DEEPLING_DEATH.get();
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(ModSounds.DEEPLING_IDLE.get(), 0.15F, 0.6F);
    }

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        if (ModEntities.rollSpawn(CMConfig.DeeplingPriestSpawnRolls, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerLevel serverLevel ) {
            CMWorldData data = CMWorldData.get(serverLevel,Level.OVERWORLD);
            return data != null && data.isLeviathanDefeatedOnce();
        }
        return false;

    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34088_, DifficultyInstance p_34089_, MobSpawnType p_34090_, @Nullable SpawnGroupData p_34091_) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(p_34088_, p_34089_, p_34090_, p_34091_);
        RandomSource randomsource = p_34088_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_34089_);
        return spawngroupdata;
    }

    public boolean checkSpawnObstruction(LevelReader p_32829_) {
        return p_32829_.isUnobstructed(this);
    }


    public static boolean candeeplingSpawn(EntityType<? extends Deepling_Priest_Entity> guardian, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (MobSpawnType.isSpawner(spawnType) || level.getFluidState(pos).is(FluidTags.WATER));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEEPLING_MELEE,DEEPLING_BLIND};
    }

    private boolean isEntityLookingAt(LivingEntity looker, LivingEntity seen, double degree) {
        degree *= 1 + (looker.distanceTo(seen) * 0.1);
        Vec3 Vector3d = looker.getViewVector(1.0F).normalize();
        Vec3 Vector3d1 = new Vec3(seen.getX() - looker.getX(), seen.getBoundingBox().minY + (double) seen.getEyeHeight() - (looker.getY() + (double) looker.getEyeHeight()), seen.getZ() - looker.getZ());
        double d0 = Vector3d1.length();
        Vector3d1 = Vector3d1.normalize();
        double d1 = Vector3d.dot(Vector3d1);
        return d1 > 1.0D - degree / d0 && (looker.hasLineOfSight(seen));
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if (lightcooldown > 0) {
            lightcooldown--;
        }
        if(this.isAlive()) {
            if (this.getAnimation() == DEEPLING_MELEE) {
                if (this.getAnimationTick() == 5) {
                    this.playSound(ModSounds.DEEPLING_SWING.get(), 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                    if (target != null) {
                        if (this.distanceTo(target) < 3.0F) {
                            float damage = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                            target.hurt(damageSources().mobAttack(this), damage);
                        }
                    }
                }
            }
            if (this.getAnimation() == DEEPLING_BLIND) {
                if (this.getAnimationTick() == 18){
                    this.playSound(ModSounds.DEEPLING_LIGHT.get(), 0.2F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                }
                if (this.getAnimationTick() >18 && this.getAnimationTick() <47) {
                    for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0D))) {
                        if (!isAlliedTo(entity) && entity != this && isEntityLookingAt(entity, this, 0.6)) {
                            boolean flag = entity.hurt(damageSources().indirectMagic(this,this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.7F);

                            if(flag){
                                entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80));
                            }
                        }
                    }


                }
            }

        }
    }


    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        } else {
            LivingEntity livingentity = this.getTarget();
            return livingentity != null && livingentity.isInWater();
        }
    }

    public EntityDimensions getSwimmingSize() {
        return SWIMMING_SIZE;
    }

    public void travel(Vec3 p_32394_) {
        if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
            this.moveRelative(0.01F, p_32394_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
        } else {
            super.travel(p_32394_);
        }

    }

    static class DeeplingLightGoal extends Goal {
        private final Deepling_Priest_Entity angler;

        public DeeplingLightGoal(Deepling_Priest_Entity angler) {
            this.angler = angler;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity target = this.angler.getTarget();
            return this.angler.lightcooldown <= 0 && this.angler.getAnimation() == NO_ANIMATION && target != null && this.angler.distanceToSqr(target) <= 64.0D && target.isAlive() && this.angler.getRandom().nextFloat() * 100.0F < 12f;
        }

        public void start() {
            super.start();
            this.angler.setAnimation(DEEPLING_BLIND);
            this.angler.lightcooldown = LIGHT_COOLDOWN;
            this.angler.navigation.stop();
        }

        public void stop() {
            super.stop();
        }
    }

    static class AnimationMeleeAttackGoal extends MeleeAttackGoal {
        protected final Deepling_Priest_Entity mob;


        public AnimationMeleeAttackGoal(Deepling_Priest_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_,p_25553_,p_25554_);
            this.mob = p_25552_;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }


        protected void checkAndPerformAttack(LivingEntity p_25557_) {
            if (this.canPerformAttack(p_25557_)) {
                if (this.mob.getAnimation() == NO_ANIMATION) {
                    this.mob.setAnimation(DEEPLING_MELEE);
                }
            }

        }
    }

}
