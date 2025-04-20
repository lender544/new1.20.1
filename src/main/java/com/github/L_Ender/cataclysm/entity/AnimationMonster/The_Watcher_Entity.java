package com.github.L_Ender.cataclysm.entity.AnimationMonster;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.projectile.Laser_Beam_Entity;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;


public class The_Watcher_Entity extends LLibrary_Monster {

    public static final Animation WATCHER_BITE = Animation.create(22);
    public static final Animation WATCHER_SHOT = Animation.create(55);
    public static final Animation WATCHER_EXTRA_SHOT = Animation.create(17);

    public The_Watcher_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 8;
        this.setMaxUpStep(1.25F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, WATCHER_BITE,WATCHER_EXTRA_SHOT,WATCHER_SHOT};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new WatcherMoveGoal(this, false,1.0D));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(0, new ShotPrepare(this,WATCHER_SHOT));
        this.goalSelector.addGoal(0, new Shot(this,WATCHER_EXTRA_SHOT));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

    }

    public static AttributeSupplier.Builder the_watcher() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.MAX_HEALTH, 25)
                .add(Attributes.ARMOR, 5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
    }


    @Override
    public boolean hurt(DamageSource source, float damage) {

        if (source.is(CMDamageTypes.EMP)) {
            super.hurt(source, 1000);
            return true;
        }

        return super.hurt(source, damage);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }


    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
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


    public void tick() {
        super.tick();

        setYRot(yBodyRot);
        LivingEntity target = this.getTarget();
        if (this.getAnimation() == WATCHER_BITE) {
            if (this.getAnimationTick() == 13) {
                if (target != null) {
                    if (distanceTo(target) < 3 && this.hasLineOfSight(target)) {
                        float damage = (float) ((int) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
                        target.hurt(this.damageSources().mobAttack(this), damage);
                    }
                }
            }
        }
        if (this.getAnimation() == WATCHER_EXTRA_SHOT) {
            if (this.getAnimationTick() == 9) {
                if (!this.isSilent()) {
                    this.playSound(ModSounds.HARBINGER_LASER.get(),1,1.0F);
                }
                if (target != null && target.isAlive()) {
                    double d0 = this.getX();
                    double d1 = this.getY() + this.getBbHeight() * 1 / 2;
                    double d2 = this.getZ();
                    double d3 = target.getX() - d0;
                    double d4 = target.getY() + target.getBbHeight() * 1 / 2 - d1;
                    double d5 = target.getZ() - d2;

                    Vec3 vec3 = new Vec3(d3, d4, d5);
                    Laser_Beam_Entity laserBeam = new Laser_Beam_Entity(this, d3,d4,d5,this.level(),(float) CMConfig.HarbingerLaserdamage);
                    float yRot = (float) (Mth.atan2(vec3.z, vec3.x) * (180F / Math.PI)) + 90F;
                    float xRot = (float) -(Mth.atan2(vec3.y, Math.sqrt(vec3.x * vec3.x + vec3.z * vec3.z)) * (180F / Math.PI));
                    laserBeam.setYRot(yRot);
                    laserBeam.setXRot(xRot);
                    laserBeam.setPosRaw(d0, d1, d2);

                    this.level().addFreshEntity(laserBeam);
                }
            }

        }
    }


    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_THE_HARBINGER)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.WATCHER_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.WATCHER_DEATH.get();
    }


    static class ShotPrepare extends SimpleAnimationGoal<The_Watcher_Entity> {


        public ShotPrepare(The_Watcher_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE,Goal.Flag.JUMP, Goal.Flag.LOOK));

        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 30);
            }
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 30);
            }
            super.stop();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 30);
                if(entity.getAnimationTick() == 45){
                    AnimationHandler.INSTANCE.sendAnimationMessage(entity, WATCHER_EXTRA_SHOT);
                }
            }
        }
    }


    static class Shot extends SimpleAnimationGoal<The_Watcher_Entity> {

        public Shot(The_Watcher_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE,Goal.Flag.JUMP, Goal.Flag.LOOK));

        }

        public void start() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 7 && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if(target != null){
                if(entity.getAnimationTick() == 11) {
                    if (this.entity.getRandom().nextFloat() * 100.0F < 60f) {
                        AnimationHandler.INSTANCE.sendAnimationMessage(entity, WATCHER_EXTRA_SHOT);
                    }
                }
            }
        }
    }

    static class WatcherMoveGoal extends Goal {
        private final The_Watcher_Entity watcher;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private int delayCounter;
        protected final double moveSpeed;


        public WatcherMoveGoal(The_Watcher_Entity boss, boolean followingTargetEvenIfNotSeen, double moveSpeed) {
            this.watcher = boss;
            this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
            this.moveSpeed = moveSpeed;
            this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
        }


        public boolean canUse() {
            LivingEntity target = this.watcher.getTarget();
            return target != null && target.isAlive();
        }


        public void stop() {
            watcher.getNavigation().stop();
            LivingEntity livingentity = this.watcher.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
                this.watcher.setTarget((LivingEntity) null);
            }
            this.watcher.setAggressive(false);
            this.watcher.getNavigation().stop();
        }

        public boolean canContinueToUse() {
            LivingEntity target = this.watcher.getTarget();
            if (target == null) {
                return false;
            } else if (!target.isAlive()) {
                return false;
            } else if (!this.followingTargetEvenIfNotSeen) {
                return !this.watcher.getNavigation().isDone();
            } else if (!this.watcher.isWithinRestriction(target.blockPosition())) {
                return false;
            } else {
                return !(target instanceof Player) || !target.isSpectator() && !((Player) target).isCreative();
            }
        }

        public void start() {
            this.watcher.getNavigation().moveTo(this.path, this.moveSpeed);
            this.watcher.setAggressive(true);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.watcher.getTarget();
            if (target != null) {
                watcher.getLookControl().setLookAt(target, 30.0F, 30.0F);
                double distSq = this.watcher.distanceToSqr(target.getX(), target.getBoundingBox().minY, target.getZ());
                if (--this.delayCounter <= 0) {
                    this.delayCounter = 4 + this.watcher.getRandom().nextInt(7);
                    if (distSq > Math.pow(this.watcher.getAttribute(Attributes.FOLLOW_RANGE).getValue(), 2.0D)) {
                        if (!this.watcher.isPathFinding()) {
                            if (!this.watcher.getNavigation().moveTo(target, 1.0D)) {
                                this.delayCounter += 5;
                            }
                        }
                    } else {
                        this.watcher.getNavigation().moveTo(target, this.moveSpeed);
                    }
                }
                if (target.isAlive()) {
                    if (this.watcher.getAnimation() == NO_ANIMATION) {
                        if (this.watcher.distanceTo(target) < 1.5F) {
                            this.watcher.setAnimation(WATCHER_BITE);
                        } else if (this.watcher.getRandom().nextFloat() * 100.0F < 24f && this.watcher.distanceTo(target) >= 6D) {
                            this.watcher.setAnimation(WATCHER_SHOT);
                        }
                    }
                }
            }
        }
    }
}





