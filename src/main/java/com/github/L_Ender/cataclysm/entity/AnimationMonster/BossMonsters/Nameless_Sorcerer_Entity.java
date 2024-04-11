package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.IAnimatedEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Nameless_Sorcerer_Entity extends AbstractIllager implements IAnimatedEntity {
    private static final EntityDataAccessor<Byte> SPELL = SynchedEntityData.defineId(Nameless_Sorcerer_Entity.class, EntityDataSerializers.BYTE);
    protected int spellTicks;
    private SpellType activeSpell = SpellType.NONE;
    private static final EntityDataAccessor<Boolean> IS_ILLUSION = SynchedEntityData.defineId(Nameless_Sorcerer_Entity.class, EntityDataSerializers.BOOLEAN);
    private int animationTick;
    private Animation currentAnimation;

    public Nameless_Sorcerer_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 300;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new CastingSpellGoal());
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 8.0F, 0.6D, 1.0D));
        this.goalSelector.addGoal(5, new AttackSpellGoal());
        this.goalSelector.addGoal(6, new TeleportSpellGoal());
        this.goalSelector.addGoal(7, new IllusionSpellGoal());
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
        this.targetSelector.addGoal(2, (new NearestAttackableTargetGoal<>(this, Player.class, true)).setUnseenMemoryTicks(300));
        this.targetSelector.addGoal(3, (new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false)).setUnseenMemoryTicks(300));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, false));
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION};
    }

    @Override
    public int getAnimationTick() {
        return animationTick;
    }


    @Override
    public void setAnimationTick(int tick) {
        animationTick = tick;
    }

    @Override
    public Animation getAnimation() {
        return currentAnimation;
    }


    @Override
    public void setAnimation(Animation animation) {
        currentAnimation = animation;
    }

    public static AttributeSupplier.Builder nameless_sorcerer() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.FOLLOW_RANGE, 24.0D)
                .add(Attributes.MAX_HEALTH, 50.0D);
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }

    public boolean canBeLeader() {
        return false;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SPELL, (byte)0);
        this.entityData.define(IS_ILLUSION, false);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.spellTicks = compound.getInt("SpellTicks");
        this.setIsIllusion(compound.getBoolean("is_Illusion"));
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("SpellTicks", this.spellTicks);
        compound.putBoolean("is_Illusion", getIsIllusion());
    }

    public boolean isAlliedTo(Entity p_32665_) {
        if (p_32665_ == null) {
            return false;
        } else if (p_32665_ == this) {
            return true;
        } else if (super.isAlliedTo(p_32665_)) {
            return true;
        } else if (p_32665_ instanceof Vex) {
            return this.isAlliedTo(((Vex)p_32665_).getOwner());
        } else if (p_32665_ instanceof LivingEntity && ((LivingEntity)p_32665_).getMobType() == MobType.ILLAGER) {
            return this.getTeam() == null && p_32665_.getTeam() == null;
        } else {
            return false;
        }
    }

    public void setIsIllusion(boolean isIllusion) {
        this.entityData.set(IS_ILLUSION, isIllusion);
    }

    public boolean getIsIllusion() {
        return this.entityData.get(IS_ILLUSION);
    }


    @OnlyIn(Dist.CLIENT)
    public IllagerArmPose getArmPose() {
        if (this.isSpellcasting()) {
            return IllagerArmPose.SPELLCASTING;
        } else {
            return this.isCelebrating() ? IllagerArmPose.CELEBRATING : IllagerArmPose.CROSSED;
        }
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (this.getIsIllusion()) {
            this.playSound(SoundEvents.ILLUSIONER_CAST_SPELL, 1.0f ,0.9f);
            for(int i = 0; i < 20; ++i) {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                this.level().addParticle(ParticleTypes.POOF, this.getRandomX(1.0D), this.getRandomY(), this.getRandomZ(1.0D), d0, d1, d2);
            }
            this.remove(RemovalReason.KILLED);
            return false;
        }
        return super.hurt(source, damage);
    }


    public boolean isSpellcasting() {
        if (this.level().isClientSide) {
            return this.entityData.get(SPELL) > 0;
        } else {
            return this.spellTicks > 0;
        }
    }

    public void setSpellType(SpellType spellType) {
        this.activeSpell = spellType;
        this.entityData.set(SPELL, (byte)spellType.id);
    }

    protected SpellType getSpellType() {
        return !this.level().isClientSide ? this.activeSpell : SpellType.getFromId(this.entityData.get(SPELL));
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.spellTicks > 0) {
            --this.spellTicks;
        }

    }


    protected SoundEvent getAmbientSound() {
        return SoundEvents.EVOKER_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.EVOKER_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.EVOKER_HURT;
    }

    public void applyRaidBuffs(int p_32632_, boolean p_32633_) {
    }

    public SoundEvent getCelebrateSound() {
        return SoundEvents.EVOKER_CELEBRATE;
    }

    protected SoundEvent getSpellSound() {
        return SoundEvents.EVOKER_CAST_SPELL;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();
        if (this.level().isClientSide && this.isSpellcasting()) {
            SpellType Nameless_Sorcerer_Entity$spelltype = this.getSpellType();
            double d0 = getRandom().nextGaussian() * 0.07D;
            double d1 = getRandom().nextGaussian() * 0.07D;
            double d2 = getRandom().nextGaussian() * 0.07D;
            float f = this.yBodyRot * ((float) Math.PI / 180F) + Mth.cos((float) this.tickCount * 0.6662F) * 0.25F;
            float f1 = Mth.cos(f);
            float f2 = Mth.sin(f);
            if (Nameless_Sorcerer_Entity$spelltype == SpellType.TELEPORTSPELL) {
                this.level().addParticle(ParticleTypes.PORTAL, this.getX() + (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() + (double) f2 * 0.6D, d0, d1, d2);
                this.level().addParticle(ParticleTypes.PORTAL, this.getX() - (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() - (double) f2 * 0.6D, d0, d1, d2);
            }
            if (Nameless_Sorcerer_Entity$spelltype == SpellType.FANGS) {
                this.level().addParticle(ParticleTypes.CRIT, this.getX() + (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() + (double) f2 * 0.6D, d0, d1, d2);
                this.level().addParticle(ParticleTypes.CRIT, this.getX() - (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() - (double) f2 * 0.6D, d0, d1, d2);
            }

            if (Nameless_Sorcerer_Entity$spelltype == SpellType.ILLUSION) {
                this.level().addParticle(ParticleTypes.SMOKE, this.getX() + (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() + (double) f2 * 0.6D, d0, d1, d2);
                this.level().addParticle(ParticleTypes.SMOKE, this.getX() - (double) f1 * 0.6D, this.getY() + 1.8D, this.getZ() - (double) f2 * 0.6D, d0, d1, d2);
            }
        }

    }

    protected int getSpellTicks() {
        return this.spellTicks;
    }


    public class CastingASpellGoal extends Goal {
        public CastingASpellGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            return Nameless_Sorcerer_Entity.this.getSpellTicks() > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            super.start();
            Nameless_Sorcerer_Entity.this.navigation.stop();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void stop() {
            super.stop();
            Nameless_Sorcerer_Entity.this.setSpellType(SpellType.NONE);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (Nameless_Sorcerer_Entity.this.getTarget() != null) {
                Nameless_Sorcerer_Entity.this.getLookControl().setLookAt(Nameless_Sorcerer_Entity.this.getTarget(), (float)Nameless_Sorcerer_Entity.this.getMaxHeadYRot(), (float)Nameless_Sorcerer_Entity.this.getMaxHeadXRot());
            }

        }
    }

    public enum SpellType {
        NONE(0),
        TELEPORTSPELL(1),
        FANGS(2),
        WOLOLO(3),
        ILLUSION(4);

        private final int id;


        SpellType(int idIn) {
            this.id = idIn;

        }

        public static SpellType getFromId(int idIn) {
            for(SpellType Nameless_Sorcerer_Entity$spelltype : values()) {
                if (idIn == Nameless_Sorcerer_Entity$spelltype.id) {
                    return Nameless_Sorcerer_Entity$spelltype;
                }
            }

            return NONE;
        }
    }

    public abstract class UseSpellGoal extends Goal {
        protected int spellWarmup;
        protected int spellCooldown;

        protected UseSpellGoal() {
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            LivingEntity livingentity = Nameless_Sorcerer_Entity.this.getTarget();
            if (livingentity != null && livingentity.isAlive()) {
                if (Nameless_Sorcerer_Entity.this.isSpellcasting()) {
                    return false;
                } else {
                    return Nameless_Sorcerer_Entity.this.tickCount >= this.spellCooldown;
                }
            } else {
                return false;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean canContinueToUse() {
            LivingEntity livingentity = Nameless_Sorcerer_Entity.this.getTarget();
            return livingentity != null && livingentity.isAlive() && this.spellWarmup > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            this.spellWarmup = this.getCastWarmupTime();
            Nameless_Sorcerer_Entity.this.spellTicks = this.getCastingTime();
            this.spellCooldown = Nameless_Sorcerer_Entity.this.tickCount + this.getCastingInterval();
            SoundEvent soundevent = this.getSpellPrepareSound();
            if (soundevent != null) {
                Nameless_Sorcerer_Entity.this.playSound(soundevent, 1.0F, 1.0F);
            }

            Nameless_Sorcerer_Entity.this.setSpellType(this.getSpellType());
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            --this.spellWarmup;
            if (this.spellWarmup == 0) {
                this.castSpell();
                Nameless_Sorcerer_Entity.this.playSound(Nameless_Sorcerer_Entity.this.getSpellSound(), 1.0F, 1.0F);
            }

        }

        protected abstract void castSpell();

        protected int getCastWarmupTime() {
            return 20;
        }

        protected abstract int getCastingTime();

        protected abstract int getCastingInterval();

        @Nullable
        protected abstract SoundEvent getSpellPrepareSound();

        protected abstract SpellType getSpellType();
    }

    class AttackSpellGoal extends UseSpellGoal {
        private AttackSpellGoal() {
        }

        protected int getCastingTime() {
            return 20;
        }

        protected int getCastingInterval() {
            return 45;
        }

        protected void castSpell() {
            LivingEntity target = Nameless_Sorcerer_Entity.this.getTarget();
            double d0 = Math.min(target.getY(), Nameless_Sorcerer_Entity.this.getY());
            double d1 = Math.max(target.getY(), Nameless_Sorcerer_Entity.this.getY()) + 1.0D;
            float f = (float) Mth.atan2(target.getZ() - Nameless_Sorcerer_Entity.this.getZ(), target.getX() - Nameless_Sorcerer_Entity.this.getX());
            if (Nameless_Sorcerer_Entity.this.distanceToSqr(target) < 12.0D) {
                for(int i = 0; i < 5; ++i) {
                    float f1 = f + (float)i * (float)Math.PI * 0.4F;
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)Mth.cos(f1) * 1.5D, Nameless_Sorcerer_Entity.this.getZ() + (double)Mth.sin(f1) * 1.5D, d0, d1, f1, 0);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)Mth.cos(f1) * 1.5D, Nameless_Sorcerer_Entity.this.getZ() + (double)Mth.sin(f1) * 1.5D, d0, d1, f1, 40);
                }

                for(int k = 0; k < 8; ++k) {
                    float f2 = f + (float)k * (float)Math.PI * 2.0F / 8.0F + ((float) Math.PI * 2F / 5F);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)Mth.cos(f2) * 2.5D, Nameless_Sorcerer_Entity.this.getZ() + (double)Mth.sin(f2) * 2.5D, d0, d1, f2, 3);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)Mth.cos(f2) * 2.5D, Nameless_Sorcerer_Entity.this.getZ() + (double)Mth.sin(f2) * 2.5D, d0, d1, f2, 37);
                }
                for (int k = 0; k < 13; ++k) {
                    float f3 = f + (float) k * (float) Math.PI * 2.0F / 13.0F + ((float) Math.PI * 2F / 10F);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) Mth.cos(f3) * 3.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) Mth.sin(f3) * 3.5D, d0, d1, f3, 10);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) Mth.cos(f3) * 3.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) Mth.sin(f3) * 3.5D, d0, d1, f3, 30);
                }
                for (int k = 0; k < 16; ++k) {
                    float f4 = f + (float) k * (float) Math.PI * 2.0F / 16.0F + ((float) Math.PI * 2F / 20F);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) Mth.cos(f4) * 4.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) Mth.sin(f4) * 4.5D, d0, d1, f4, 15);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) Mth.cos(f4) * 4.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) Mth.sin(f4) * 4.5D, d0, d1, f4, 25);
                }
                for (int k = 0; k < 19; ++k) {
                    float f5 = f + (float) k * (float) Math.PI * 2.0F / 19.0F + ((float) Math.PI * 2F / 40F);
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double) Mth.cos(f5) * 5.5D, Nameless_Sorcerer_Entity.this.getZ() + (double) Mth.sin(f5) * 5.5D, d0, d1, f5, 20);
                }

            } else {
                for(int l = 0; l < 16; ++l) {
                    double d2 = 1.25D * (double)(l + 1);
                    int j = 1 * l;
                    this.spawnFangs(Nameless_Sorcerer_Entity.this.getX() + (double)Mth.cos(f) * d2, Nameless_Sorcerer_Entity.this.getZ() + (double)Mth.sin(f) * d2, d0, d1, f, j);
                }
            }
        }

        private void spawnFangs(double p_190876_1_, double p_190876_3_, double p_190876_5_, double p_190876_7_, float p_190876_9_, int p_190876_10_) {
            BlockPos blockpos = BlockPos.containing(p_190876_1_, p_190876_7_, p_190876_3_);
            boolean flag = false;
            double d0 = 0.0D;

            do {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = Nameless_Sorcerer_Entity.this.level().getBlockState(blockpos1);
                if (blockstate.isFaceSturdy(Nameless_Sorcerer_Entity.this.level(), blockpos1, Direction.UP)) {
                    if (!Nameless_Sorcerer_Entity.this.level().isEmptyBlock(blockpos)) {
                        BlockState blockstate1 = Nameless_Sorcerer_Entity.this.level().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(Nameless_Sorcerer_Entity.this.level(), blockpos);
                        if (!voxelshape.isEmpty()) {
                            d0 = voxelshape.max(Direction.Axis.Y);
                        }
                    }

                    flag = true;
                    break;
                }

                blockpos = blockpos.below();
            } while(blockpos.getY() >= Mth.floor(p_190876_5_) - 1);

            if (flag) {
                Nameless_Sorcerer_Entity.this.level().addFreshEntity(new EvokerFangs(Nameless_Sorcerer_Entity.this.level(), p_190876_1_, (double)blockpos.getY() + d0, p_190876_3_, p_190876_9_, p_190876_10_, Nameless_Sorcerer_Entity.this));
            }

        }

        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.EVOKER_PREPARE_ATTACK;
        }

        protected SpellType getSpellType() {
            return SpellType.FANGS;
        }
    }

    class CastingSpellGoal extends CastingASpellGoal {
        private CastingSpellGoal() {
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (Nameless_Sorcerer_Entity.this.getTarget() != null) {
                Nameless_Sorcerer_Entity.this.getLookControl().setLookAt(Nameless_Sorcerer_Entity.this.getTarget(), (float) Nameless_Sorcerer_Entity.this.getMaxHeadYRot(), (float) Nameless_Sorcerer_Entity.this.getMaxHeadXRot());
            }
        }
    }

    class TeleportSpellGoal extends UseSpellGoal {

        private TeleportSpellGoal()
        {
            super();
        }

        public boolean canUse() {
            LivingEntity livingentity = Nameless_Sorcerer_Entity.this.getTarget();
            if (livingentity != null && livingentity.isAlive()) {
                if (Nameless_Sorcerer_Entity.this.getIsIllusion()) {
                    return false;
                }
                if (Nameless_Sorcerer_Entity.this.distanceTo(livingentity) < 6F){
                    return false;
                }
                if (Nameless_Sorcerer_Entity.this.isSpellcasting()) {
                    return false;
                } else {
                    return Nameless_Sorcerer_Entity.this.tickCount >= this.spellCooldown;
                }
            } else {
                return false;
            }
        }

        @Override
        protected int getCastingTime()
        {
            return 60;
        }

        @Override
        protected int getCastingInterval()
        {
            return 300;
        }

        @Override
        protected void castSpell() {

            LivingEntity target = Nameless_Sorcerer_Entity.this.getTarget();

            this.teleportEntity(target);


        }

        public void teleportEntity(LivingEntity target) {
            if (target.isPassenger()) {
                target.stopRiding();
            }

            double d0 = target.getX();
            double d1 = target.getY();
            double d2 = target.getZ();


            double d3 = Nameless_Sorcerer_Entity.this.getX();
            double d4 = Nameless_Sorcerer_Entity.this.getY();
            double d5 = Nameless_Sorcerer_Entity.this.getZ();
            target.teleportTo(d3, d4, d5);
            target.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
            target.yRotO = Nameless_Sorcerer_Entity.this.getYRot();
            target.xRotO = Nameless_Sorcerer_Entity.this.getXRot();

            Nameless_Sorcerer_Entity.this.teleportTo(d0, d1, d2);
            Nameless_Sorcerer_Entity.this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
            Nameless_Sorcerer_Entity.this.yRotO = target.getYRot();
            Nameless_Sorcerer_Entity.this.xRotO = target.getXRot();
            //yaw =y
            //pitch = x
        }


        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ILLUSIONER_PREPARE_MIRROR;
        }

        @Override
        protected SpellType getSpellType()
        {
            return SpellType.TELEPORTSPELL;
        }
    }

    class IllusionSpellGoal extends UseSpellGoal {

        private IllusionSpellGoal() {
            super();
        }

        public boolean canUse() {
            LivingEntity livingentity = Nameless_Sorcerer_Entity.this.getTarget();
            if (livingentity != null && livingentity.isAlive()) {
                if (Nameless_Sorcerer_Entity.this.getIsIllusion()) {
                    return false;
                }
                if (Nameless_Sorcerer_Entity.this.isSpellcasting()) {
                    return false;
                } else {
                    return Nameless_Sorcerer_Entity.this.tickCount >= this.spellCooldown;
                }
            } else {
                return false;
            }
        }

        @Override
        protected int getCastingTime()
        {
            return 80;
        }

        @Override
        protected int getCastingInterval()
        {
            return 300;
        }

        @Override
        protected void castSpell() {
            ServerLevel serverLevel = (ServerLevel)Nameless_Sorcerer_Entity.this.level();

            for (int i = 0; i < 2; ++i) {
                LivingEntity target = Nameless_Sorcerer_Entity.this.getTarget();
                BlockPos blockpos = Nameless_Sorcerer_Entity.this.blockPosition().offset(-2 + Nameless_Sorcerer_Entity.this.random.nextInt(5), 0, -2 + Nameless_Sorcerer_Entity.this.random.nextInt(5));
                Nameless_Sorcerer_Entity illusion = ModEntities.NAMELESS_SORCERER.get().create(Nameless_Sorcerer_Entity.this.level());
                illusion.moveTo(blockpos, 0.0F, 0.0F);
                if(target != null ) {
                    illusion.setTarget(target);
                }
                illusion.finalizeSpawn(serverLevel, Nameless_Sorcerer_Entity.this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData)null, (CompoundTag)null);
                illusion.setIsIllusion(true);
                serverLevel.addFreshEntityWithPassengers(illusion);

            }
        }


        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.EVOKER_PREPARE_WOLOLO;
        }

        @Override
        protected SpellType getSpellType()
        {
            return SpellType.ILLUSION;
        }
    }


}

