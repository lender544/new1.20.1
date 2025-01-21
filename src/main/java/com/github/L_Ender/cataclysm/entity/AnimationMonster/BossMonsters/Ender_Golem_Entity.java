package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.CmAttackGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.LLibrary_Monster;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.EnumSet;



public class Ender_Golem_Entity extends LLibrary_Boss_Monster {

    public static final Animation ANIMATION_ATTACK1 = Animation.create(25);
    public static final Animation ANIMATION_ATTACK2 = Animation.create(25);
    public static final Animation ANIMATION_EARTHQUAKE = Animation.create(35);
    public static final Animation VOID_RUNE_ATTACK = Animation.create(83);
    public static final Animation ENDER_GOLEM_DEATH = Animation.create(95);
    public static final int VOID_RUNE_ATTACK_COOLDOWN = 250;
    private static final EntityDataAccessor<Boolean> IS_AWAKEN = SynchedEntityData.defineId(Ender_Golem_Entity.class, EntityDataSerializers.BOOLEAN);
    private int void_rune_attack_cooldown = 0;
    private int timeWithoutTarget;
    public float deactivateProgress;
    public float prevdeactivateProgress;
    public boolean Breaking = CMConfig.EndergolemBlockBreaking;

    public Ender_Golem_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 15;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.EnderGolemHealthMultiplier, CMConfig.EnderGolemDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{NO_ANIMATION, ANIMATION_ATTACK1, ANIMATION_ATTACK2, ANIMATION_EARTHQUAKE,VOID_RUNE_ATTACK,ENDER_GOLEM_DEATH};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new CmAttackGoal(this, 1.0D));
        this.goalSelector.addGoal(1, new AttackGoal());
        this.goalSelector.addGoal(0, new AwakenGoal());
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

    }

    public static AttributeSupplier.Builder ender_golem() {
        return createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 10)
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.ARMOR, 12)
                .add(Attributes.STEP_HEIGHT, 1.5F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }


    protected int decreaseAirSupply(int air) {
        return air;
    }




    private static Animation getRandomAttack(RandomSource rand) {
        switch (rand.nextInt(3)) {
            case 0:
                return ANIMATION_ATTACK1;
            case 1:
                return ANIMATION_ATTACK2;
            case 2:
                return ANIMATION_EARTHQUAKE;
        }
        return ANIMATION_EARTHQUAKE;
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (this.getAnimation() == VOID_RUNE_ATTACK
                || !this.getIsAwaken()) {
            if(source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)|| !source.is(DamageTypes.MAGIC)) {
                damage *= 0.5;
            }
        }
        double range = calculateRange(source);

        if (range > CMConfig.EndergolemLongRangelimit * CMConfig.EndergolemLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        Entity entity = source.getDirectEntity();
        if (entity instanceof AbstractGolem) {
            damage *= 0.5;
        }

        return super.hurt(source, damage);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(IS_AWAKEN, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Awaken", getIsAwaken());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setIsAwaken(compound.getBoolean("is_Awaken"));
    }

    public void setIsAwaken(boolean isAwaken) {
        this.entityData.set(IS_AWAKEN, isAwaken);
    }

    public boolean getIsAwaken() {
        return this.entityData.get(IS_AWAKEN);
    }

    public void tick() {
        super.tick();
        repelEntities(1.7F, 3.7f, 1.7F, 1.7F);
        LivingEntity target = this.getTarget();
        prevdeactivateProgress = deactivateProgress;
        if (!this.getIsAwaken() && deactivateProgress < 30F) {
            deactivateProgress++;
        }
        if (this.getIsAwaken() && deactivateProgress > 0F) {
            deactivateProgress--;

        }

        if(!this.getIsAwaken()) {
            if (this.tickCount % 20 == 0) {
                this.heal(2.0F);
            }
        }

        if (deactivateProgress == 0 && this.isAlive()) {
            if (target != null && target.isAlive()) {
                if (void_rune_attack_cooldown <= 0 && !isNoAi() && this.getAnimation() == NO_ANIMATION && target.onGround() && (this.random.nextInt(45) == 0 && this.distanceTo(target) < 4 || this.random.nextInt(24) == 0 && this.distanceTo(target) < 10)) {
                    void_rune_attack_cooldown = VOID_RUNE_ATTACK_COOLDOWN;
                    this.setAnimation(VOID_RUNE_ATTACK);

                } else if (this.distanceTo(target) < 4 && !isNoAi() && this.getAnimation() == NO_ANIMATION) {
                    Animation animation = getRandomAttack(random);
                    this.setAnimation(animation);
                }
            }

            if (this.getAnimation() == ANIMATION_EARTHQUAKE) {
                if (this.getAnimationTick() == 19) {
                    EarthQuake(5,6);
                    EarthQuakeParticle();
                    if (!this.level().isClientSide) {
                        if (Breaking) {
                            BlockBreaking(4, 4, 4);
                        } else {
                            if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
                                BlockBreaking(4, 4, 4);
                            }
                        }
                    }
                }
            }
            if ((this.getAnimation() == ANIMATION_ATTACK1 || this.getAnimation() == ANIMATION_ATTACK2) && this.getAnimationTick() == 13) {
                this.playSound(ModSounds.GOLEMATTACK.get(), 1, 1);
                if (target != null && target.isAlive()) {
                    if (this.distanceTo(target) < 4.75F) {
                        target.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + this.random.nextInt(4));
                        target.knockback(1.25F, this.getX() - target.getX(), this.getZ() - target.getZ());
                    }
                }
            }
            if (this.getAnimation() == VOID_RUNE_ATTACK) {
                if (this.getAnimationTick() == 22) {
                    EarthQuake(4.25f,4);
                    EarthQuakeParticle();
                    if (!this.level().isClientSide) {
                        if (Breaking) {
                            BlockBreaking(4, 4, 4);
                        } else {
                            if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
                                BlockBreaking(4, 4, 4);
                            }
                        }
                    }
                }
                if (this.getAnimationTick() == 28) {
                    VoidRuneAttack();
                }
            }
        }
        if (void_rune_attack_cooldown > 0) void_rune_attack_cooldown--;
        if (!level().isClientSide) {
            timeWithoutTarget++;
            if (target != null) {
                timeWithoutTarget = 0;
                if(!this.getIsAwaken()) {
                    this.setIsAwaken(true);
                }
            }

            if (timeWithoutTarget > 400 && this.getIsAwaken() && target == null) {
                timeWithoutTarget = 0;
                this.setIsAwaken(false);
            }
        }

    }

    private void BlockBreaking(int x, int y, int z) {
        int MthX = Mth.floor(this.getX());
        int MthY = Mth.floor(this.getY());
        int MthZ = Mth.floor(this.getZ());
        boolean flag = false;
        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = 0; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    BlockState block = this.level().getBlockState(blockpos);
                    if (block != Blocks.AIR.defaultBlockState() && block.is(ModTag.ENDER_GOLEM_CAN_DESTROY)) {
                        if (block.canEntityDestroy(this.level(), blockpos, this) && net.neoforged.neoforge.event.EventHooks.onEntityDestroyBlock(this, blockpos, block)) {
                            flag = this.level().destroyBlock(blockpos, true, this) || flag;
                        }
                    }
                }
            }
        }
    }

    private void EarthQuakeParticle() {
        if (this.level().isClientSide) {
            BlockState block = level().getBlockState(blockPosition().below());
            for (int i1 = 0; i1 < 20 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = 4F * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 4F * Mth.cos(angle);
                if (block.getRenderShape() != RenderShape.INVISIBLE) {
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
        }
    }

    private void EarthQuake(float grow, int damage) {
        this.playSound(ModSounds.EXPLOSION.get(), 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(grow))) {
            if (!isAlliedTo(entity) && !(entity instanceof Ender_Golem_Entity) && entity != this) {
                entity.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + this.random.nextInt(damage));
                launch(entity, true);

            }
        }
    }


    private void VoidRuneAttack() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double d0 = Math.min(target.getY(), this.getY());
            double d1 = Math.max(target.getY(), this.getY()) + 1.0D;
            float f = (float) Mth.atan2(target.getZ() - this.getZ(), target.getX() - this.getX());
            float f2 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * (2.0F);
            float f3 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * (2.0F);
            for(int l = 0; l < 10; ++l) {
                double d2 = 1.5D * (double)(l + 1);
                int j = (int) (1.25f * l);
                this.spawnFangs(this.getX() + f2 + (double)Mth.cos(f) * d2, this.getZ() + f3 + (double)Mth.sin(f) * d2, d0, d1, f, j);
                this.spawnFangs(this.getX() - f2 + (double)Mth.cos(f) * d2, this.getZ() - f3 + (double)Mth.sin(f) * d2, d0, d1, f, j);
            }
            for (int k = 0; k < 6; ++k) {
                float f4 = f + (float) k * (float) Math.PI * 2.0F / 6.0F + ((float) Math.PI * 2F / 7.5F);
                this.spawnFangs(this.getX() + (double) Mth.cos(f4) * 2.5D, this.getZ() + (double) Mth.sin(f4) * 2.5D, d0, d1, f2, 5);
            }
            for (int k = 0; k < 8; ++k) {
                this.spawnFangs(this.getX() + this.random.nextGaussian() * 4.5D, this.getZ() + this.random.nextGaussian() * 4.5D, d0, d1, f3, 15);
            }

        }
    }


    private void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.containing(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
                if (!this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while (blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            this.level().addFreshEntity(new Void_Rune_Entity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay,(float) CMConfig.Voidrunedamage, this));
        }
    }

    private void launch(LivingEntity e, boolean huge) {

        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.push(d0 / d2 * f, huge ? 0.5D : 0.2F, d1 / d2 * f);
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_ENDER_GUARDIAN)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        setDeltaMovement(0, this.getDeltaMovement().y, 0);
        if (this.deathTime == 40) {
            this.playSound(ModSounds.MONSTROSITYLAND.get(), 1, 1);
        }

    }


    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return ENDER_GOLEM_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 1.0F, 1.0F);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.GOLEMHURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.GOLEMDEATH.get();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    class AttackGoal extends Goal {


        public AttackGoal() {
            this.setFlags(EnumSet.of(Flag.JUMP, Flag.LOOK, Flag.MOVE));
        }

        public boolean canUse() {
            return Ender_Golem_Entity.this.getAnimation() == ANIMATION_EARTHQUAKE || Ender_Golem_Entity.this.getAnimation() == VOID_RUNE_ATTACK;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void stop() {
            super.stop();
        }

        public void tick() {
            Ender_Golem_Entity.this.setDeltaMovement(0, Ender_Golem_Entity.this.getDeltaMovement().y, 0);
            LivingEntity target = Ender_Golem_Entity.this.getTarget();

            if(Ender_Golem_Entity.this.getAnimation() == ANIMATION_EARTHQUAKE) {
                if (Ender_Golem_Entity.this.getAnimationTick() < 19 && target != null) {
                    Ender_Golem_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    Ender_Golem_Entity.this.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ender_Golem_Entity.this.setYRot(Ender_Golem_Entity.this.yRotO);
                    //Ender_Golem_Entity.this.yBodyRot = Ender_Golem_Entity.this.yBodyRotO;
                }
            }
            if(Ender_Golem_Entity.this.getAnimation() == VOID_RUNE_ATTACK) {
                if (Ender_Golem_Entity.this.getAnimationTick() < 22 && target != null) {
                    Ender_Golem_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    Ender_Golem_Entity.this.lookAt(target, 30.0F, 30.0F);
                } else {
                    Ender_Golem_Entity.this.setYRot(Ender_Golem_Entity.this.yRotO);
                    //Ender_Golem_Entity.this.yBodyRot = Ender_Golem_Entity.this.yBodyRotO;
                }
            }
        }
    }

    class AwakenGoal extends Goal {

        public AwakenGoal() {
            this.setFlags(EnumSet.of(Flag.JUMP, Flag.LOOK, Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return deactivateProgress > 0F;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            Ender_Golem_Entity.this.setDeltaMovement(0, Ender_Golem_Entity.this.getDeltaMovement().y, 0);
        }
    }

}





