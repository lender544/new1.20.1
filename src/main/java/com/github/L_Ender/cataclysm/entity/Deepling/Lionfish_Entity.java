package com.github.L_Ender.cataclysm.entity.Deepling;

import com.github.L_Ender.cataclysm.entity.AI.AnimalAIRandomSwimming;
import com.github.L_Ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.L_Ender.cataclysm.entity.etc.AquaticMoveController;
import com.github.L_Ender.cataclysm.entity.etc.path.SemiAquaticPathNavigator;
import com.github.L_Ender.cataclysm.entity.projectile.Lionfish_Spike_Entity;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class Lionfish_Entity extends Monster implements IAnimatedEntity {

    public static final Animation LIONFISH_BITE = Animation.create(19);
    private int animationTick;
    private Animation currentAnimation;
    public float prevOnLandProgress;
    public float onLandProgress;
    public float LayerBrightness, oLayerBrightness;
    public int LayerTicks;

    public Lionfish_Entity(EntityType<? extends Monster> monster, Level level) {
        super(monster, level);
        this.xpReward = 5;
        this.moveControl = new AquaticMoveController(this, 1.0F, 15F);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0F);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new SemiAquaticPathNavigator(this, worldIn);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.PUFFER_FISH_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PUFFER_FISH_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_29628_) {
        return SoundEvents.PUFFER_FISH_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.PUFFER_FISH_FLOP;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.FISH_SWIM;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(2, new AnimationMeleeAttackGoal(this, 1.0f, false));
        this.goalSelector.addGoal(3, new AnimalAIRandomSwimming(this, 1F, 12, 5));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, AbstractDeepling.class, Lionfish_Entity.class));
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<>(this, Player.class, true));

    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
    }

    public static AttributeSupplier.Builder lionfish() {
        return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.MAX_HEALTH, 12.0D);
    }



    public boolean hurt(DamageSource p_32820_, float p_32821_) {
        if (this.level().isClientSide) {
            return false;
        } else {
            if (!p_32820_.is(DamageTypeTags.AVOIDS_GUARDIAN_THORNS) && !p_32820_.is(DamageTypes.THORNS)) {
                Entity entity = p_32820_.getDirectEntity();
                if (entity instanceof LivingEntity livingentity) {
                    if (livingentity.hurt(damageSources().thorns(this), 1.0F)) {
                        livingentity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 0), this);
                    }
                }

            }

            return super.hurt(p_32820_, p_32821_);
        }
    }

    public void tick(){
        super.tick();
        this.prevOnLandProgress = onLandProgress;
        if (!this.isInWater() && onLandProgress < 5F) {
            onLandProgress++;
        }
        if (this.isInWater() && onLandProgress > 0F) {
            onLandProgress--;
        }

        if (!this.isInWater() && this.onGround() && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), (double)0.4F, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.setOnGround(false);
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }
        AnimationHandler.INSTANCE.updateAnimations(this);

        if (this.level().isClientSide){
            ++LayerTicks;
            this.LayerBrightness += (0.0F - this.LayerBrightness) * 0.8F;
        }
        if(this.isAlive()) {
            LivingEntity target = this.getTarget();
            if (this.getAnimation() == LIONFISH_BITE) {
                if (this.getAnimationTick() == 7) {
                    this.playSound(SoundEvents.PHANTOM_BITE, 0.4F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
                    if (target != null) {
                        float damage = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                        target.hurt(damageSources().mobAttack(this), damage);
                    }
                }
            }
        }
    }

    protected void handleAirSupply(int p_30344_) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(p_30344_ - 1);
            if (this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(damageSources().drown(), 0.01F);
            }
        } else {
            this.setAirSupply(1000);
        }

    }

    public void baseTick() {
        int i = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply(i);
    }


    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_THE_LEVIATHAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        int shardCount = 6 + random.nextInt(2);
        if (!this.level().isClientSide) {
            for (int i = 0; i < shardCount; i++) {
                float f = ((i + 1) / (float) shardCount) * 360F;
                Lionfish_Spike_Entity shard = new Lionfish_Spike_Entity(this.level(), this);
                shard.shoot(this.random.nextFloat() * 0.4F * 2.0F - 0.4F, this.random.nextFloat() * 0.25F + 0.1F,this.random.nextFloat() * 0.4F * 2.0F - 0.4F, 0.35F, 1F);
                level().addFreshEntity(shard);
            }
        }

    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean checkSpawnObstruction(LevelReader worldIn) {
        return worldIn.isUnobstructed(this);
    }

    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }
    }

    public boolean removeWhenFarAway(double p_219457_) {
        return !this.isLeashedToAngler();
    }

    private boolean isLeashedToAngler() {
        return this.getLeashHolder() instanceof Deepling_Angler_Entity;
    }

    @Override
    public int getAnimationTick() {
        return animationTick;
    }

    @Override
    public void setAnimationTick(int i) {
        animationTick = i;
    }

    @Override
    public Animation getAnimation() {
        return currentAnimation;
    }

    @Override
    public void setAnimation(Animation animation) {
        currentAnimation = animation;
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{LIONFISH_BITE,NO_ANIMATION};
    }

    static class AnimationMeleeAttackGoal extends MeleeAttackGoal {
        protected final Lionfish_Entity mob;

        public AnimationMeleeAttackGoal(Lionfish_Entity p_25552_, double p_25553_, boolean p_25554_) {
            super(p_25552_,p_25553_,p_25554_);
            this.mob = p_25552_;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }


        protected void checkAndPerformAttack(LivingEntity p_25557_) {
            if (this.mob.getAnimation() == NO_ANIMATION) {
                this.mob.setAnimation(LIONFISH_BITE);
            }
        }
    }
}
