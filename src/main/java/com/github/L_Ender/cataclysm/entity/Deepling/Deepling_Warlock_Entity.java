package com.github.L_Ender.cataclysm.entity.Deepling;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.effect.Abyss_Mark_Entity;
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
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Deepling_Warlock_Entity extends AbstractDeepling {
    public static final Animation DEEPLING_MELEE = Animation.create(20);
    public static final Animation DEEPLING_MAGIC = Animation.create(90);
    boolean searchingForLand;
    private int lightcooldown = 200;
    public static final int LIGHT_COOLDOWN = 400;
    private static final EntityDimensions SWIMMING_SIZE = EntityDimensions.fixed(1.15f, 0.6F);

    public Deepling_Warlock_Entity(EntityType entity, Level world) {
        super(entity, world);
        switchNavigator(false);
        this.xpReward = 10;

    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MagicTrackingGoal(this,DEEPLING_MAGIC));
        this.goalSelector.addGoal(2, new DeeplingMagicGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.goalSelector.addGoal(3, new AnimationMeleeAttackGoal(this, 1.0f, false));
    }

    public static AttributeSupplier.Builder deeplingwarlock() {
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
        if (ModEntities.rollSpawn(CMConfig.DeeplingWarlockSpawnRolls, this.getRandom(), spawnReasonIn) && worldIn instanceof ServerLevel serverLevel) {
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


    public static boolean candeeplingSpawn(EntityType<? extends Deepling_Warlock_Entity> guardian, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.getDifficulty() != Difficulty.PEACEFUL && (MobSpawnType.isSpawner(spawnType) || level.getFluidState(pos).is(FluidTags.WATER));
    }


    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, DEEPLING_MELEE,DEEPLING_MAGIC};
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
        }
    }



    public EntityDimensions getSwimmingSize() {
        return SWIMMING_SIZE;
    }

    boolean wantsToSwim() {
        if (this.searchingForLand) {
            return true;
        } else {
            LivingEntity livingentity = this.getTarget();
            return livingentity != null && livingentity.isInWater();
        }
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
    static class DeeplingMagicGoal extends Goal {
        private final Deepling_Warlock_Entity angler;

        public DeeplingMagicGoal(Deepling_Warlock_Entity angler) {
            this.angler = angler;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity target = this.angler.getTarget();
            return this.angler.lightcooldown <= 0 && this.angler.getAnimation() == NO_ANIMATION && target != null && this.angler.distanceToSqr(target) >= 25.0D && target.isAlive() && this.angler.getRandom().nextFloat() * 100.0F < 12f;
        }

        public void start() {
            super.start();
            this.angler.setAnimation(DEEPLING_MAGIC);
            this.angler.lightcooldown = LIGHT_COOLDOWN;
            this.angler.navigation.stop();
        }

        public void stop() {
            super.stop();
        }
    }

    static class MagicTrackingGoal extends SimpleAnimationGoal<Deepling_Warlock_Entity> {
        private final Deepling_Warlock_Entity warlock;

        public MagicTrackingGoal(Deepling_Warlock_Entity entity, Animation animation) {
            super(entity, animation);
            this.warlock = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));

        }

        public void start() {
            LivingEntity target = this.warlock.getTarget();
            if (target != null) {
                this.warlock.getLookControl().setLookAt(target, 30, 30);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = this.warlock.getTarget();
            if (target != null) {
                this.warlock.getLookControl().setLookAt(target, 30, 30);

                if(this.warlock.getAnimationTick() == 18) {
                    double sx = this.warlock.getX();
                    double sy = this.warlock.getY();
                    double sz = this.warlock.getZ();
                    Abyss_Mark_Entity fireball = new Abyss_Mark_Entity(this.warlock.level(), sx,sy,sz,80,(float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage,this.warlock.getUUID(),target);
                    this.warlock.level().addFreshEntity(fireball);
                }

            }
        }
    }


    static class AnimationMeleeAttackGoal extends MeleeAttackGoal {
        protected final Deepling_Warlock_Entity mob;


        public AnimationMeleeAttackGoal(Deepling_Warlock_Entity p_25552_, double p_25553_, boolean p_25554_) {
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
