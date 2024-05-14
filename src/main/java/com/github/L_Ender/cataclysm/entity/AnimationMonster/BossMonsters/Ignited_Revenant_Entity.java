package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AttackMoveGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.projectile.Ashen_Breath_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Blazing_Bone_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;


public class Ignited_Revenant_Entity extends Boss_monster {

    public static final Animation ASH_BREATH_ATTACK = Animation.create(53);
    public static final Animation BONE_STORM_ATTACK = Animation.create(49);
    public static final int BREATH_COOLDOWN = 200;
    public static final int STORM_COOLDOWN = 200;
    private float allowedHeightOffset = 0.5F;
    private int nextHeightOffsetChangeTick;
    private static final EntityDataAccessor<Boolean> ANGER = SynchedEntityData.defineId(Ignited_Revenant_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> SHIELD_DURABILITY = SynchedEntityData.defineId(Ignited_Revenant_Entity.class, EntityDataSerializers.INT);

    public float angerProgress;
    public float prevangerProgress;
    private int breath_cooldown = 0;
    private int storm_cooldown = 0;


    public Ignited_Revenant_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 25;
        this.setMaxUpStep(1.5F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        setConfigattribute(this, CMConfig.RevenantHealthMultiplier, CMConfig.RevenantDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{
                NO_ANIMATION,
                ASH_BREATH_ATTACK,
                BONE_STORM_ATTACK};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new Ignited_Revenant_Goal());
        this.goalSelector.addGoal(0, new BoneStormGoal(this, BONE_STORM_ATTACK));
        this.goalSelector.addGoal(0, new ShootGoal(this, ASH_BREATH_ATTACK));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder ignited_revenant() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.28F)
                .add(Attributes.ATTACK_DAMAGE, 6)
                .add(Attributes.MAX_HEALTH, 80)
                .add(Attributes.ARMOR, 12)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }


    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }


    @Override
    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (!this.level().isClientSide) {
            if(this.getIsAnger()) {
                if (entity instanceof LivingEntity) {
                    // Shield disabling on critical axe hit
                    if (((LivingEntity) entity).getMainHandItem().getItem() instanceof AxeItem) {
                        double itemDamage = ((AxeItem) ((LivingEntity) entity).getMainHandItem().getItem()).getAttackDamage()+ 1;
                        if (damage >= itemDamage + (itemDamage / 2)) {
                            if (this.getShieldDurability() < 4) {
                                this.playSound(SoundEvents.WITHER_BREAK_BLOCK, 1.0F, 1.5F);

                                this.setShieldDurability(this.getShieldDurability() + 1);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        if (damage > 0.0F && canBlockDamageSource(source)) {
            this.hurtCurrentlyUsedShield(damage);
            if (!source.is(DamageTypeTags.IS_PROJECTILE)) {
                if (entity instanceof LivingEntity) {
                    this.blockUsingShield((LivingEntity) entity);
                }
            }
            this.playSound(SoundEvents.ANVIL_PLACE, 0.3F, 0.5F);
            return false;
        }
        return super.hurt(source, damage);
    }

    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        Entity entity = damageSourceIn.getDirectEntity();
        boolean flag = false;
        if (entity instanceof AbstractArrow) {
           AbstractArrow abstractarrowentity = (AbstractArrow) entity;
           if (abstractarrowentity.getPierceLevel() > 0) {
               flag = true;
          }
        }
        if (!damageSourceIn.is(DamageTypeTags.BYPASSES_SHIELD)&& !flag && this.getIsAnger() && this.getShieldDurability() < 4) {
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

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ANGER, false);
        this.entityData.define(SHIELD_DURABILITY, 0);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    public void setIsAnger(boolean isAnger) {
        this.entityData.set(ANGER, isAnger);
    }

    public boolean getIsAnger() {
        return this.entityData.get(ANGER);
    }

    public void setShieldDurability(int ShieldDurability) {
        this.entityData.set(SHIELD_DURABILITY, ShieldDurability);
    }

    public int getShieldDurability() {
        return this.entityData.get(SHIELD_DURABILITY);
    }

    public void tick() {
        super.tick();
       // setYRot(yBodyRot);
        LivingEntity target = this.getTarget();
        if (!this.onGround() && this.getDeltaMovement().y < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }
        prevangerProgress = angerProgress;
        if (this.getIsAnger() && angerProgress < 5F) {
            angerProgress++;
        }
        if (!this.getIsAnger() && angerProgress > 0F) {
            angerProgress--;
        }
        if (breath_cooldown > 0) breath_cooldown--;
        if (storm_cooldown > 0) storm_cooldown--;
        if (this.isAlive()) {
            if (target != null && target.isAlive()) {
                if (breath_cooldown <= 0 && !isNoAi() && this.getAnimation() == NO_ANIMATION && (this.random.nextInt(35) == 0 && this.distanceTo(target) < 4.5F) && this.getShieldDurability() < 4) {
                    breath_cooldown = BREATH_COOLDOWN;
                    this.setAnimation(ASH_BREATH_ATTACK);
                } else if (storm_cooldown <= 0 && this.distanceTo(target) < 6 && !isNoAi() && this.getAnimation() == NO_ANIMATION && this.random.nextInt(15) == 0) {
                    storm_cooldown = STORM_COOLDOWN;
                    this.setAnimation(BONE_STORM_ATTACK);
                }else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && (this.random.nextInt(12) == 0 && this.distanceTo(target) < 4.5F) && this.getShieldDurability() > 3) {
                    this.setAnimation(ASH_BREATH_ATTACK);
                }
            }
            if(this.getAnimation() == NO_ANIMATION && this.getIsAnger() && this.getShieldDurability() < 4){
                if(this.tickCount % (6 + this.getShieldDurability() * 2) == 0){
                    for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1.25D))) {
                        if (!isAlliedTo(entity) && !(entity instanceof Ignited_Revenant_Entity) && entity != this) {
                            boolean flag = entity.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
                            if (flag) {
                                double d0 = entity.getX() - this.getX();
                                double d1 = entity.getZ() - this.getZ();
                                double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                                entity.push(d0 / d2 * 1.5D, 0.2D, d1 / d2 * 1.5D);
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn.getType().is(ModTag.TEAM_IGNIS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.REVENANT_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.REVENANT_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.REVENANT_DEATH.get();
    }


    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();

    }


    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    @Override
    protected void repelEntities(float x, float y, float z, float radius) {
        super.repelEntities(x, y, z, radius);
    }

    @Override
    public boolean canBePushedByEntity(Entity entity) {
        return false;
    }

    class Ignited_Revenant_Goal extends AttackMoveGoal {

        public Ignited_Revenant_Goal() {
            super(Ignited_Revenant_Entity.this, true, 1.1);
        }

        @Override
        public void start() {
            super.start();
            Ignited_Revenant_Entity.this.setIsAnger(true);

        }

        @Override
        public void stop() {
            super.stop();
            Ignited_Revenant_Entity.this.setIsAnger(false);
        }
    }

    class ShootGoal extends SimpleAnimationGoal<Ignited_Revenant_Entity> {

        public ShootGoal(Ignited_Revenant_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        @Override
        public void start() {
            super.start();
            Ignited_Revenant_Entity.this.setIsAnger(true);

        }

        @Override
        public void stop() {
            super.stop();
            Ignited_Revenant_Entity.this.setIsAnger(false);
        }

        public void tick() {
            LivingEntity target = Ignited_Revenant_Entity.this.getTarget();

            if (target != null) {
                if (Ignited_Revenant_Entity.this.getAnimationTick() < 27) {
                    Ignited_Revenant_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                }else{
                    Ignited_Revenant_Entity.this.getLookControl().setLookAt(target, 3.0F, 30.0F);
                }
            }

            if (Ignited_Revenant_Entity.this.getAnimationTick() == 21) {
                Ignited_Revenant_Entity.this.playSound(ModSounds.REVENANT_BREATH.get(), 1.0f, 1.0f);

            }

            Vec3 mouthPos = new Vec3(0, 2.3, 0);
            mouthPos = mouthPos.yRot((float) Math.toRadians(-getYRot() - 90));
            mouthPos = mouthPos.add(position());
            mouthPos = mouthPos.add(new Vec3(0, 0, 0).xRot((float) Math.toRadians(-getXRot())).yRot((float) Math.toRadians(-yHeadRot)));
            Ashen_Breath_Entity breath = new Ashen_Breath_Entity(ModEntities.ASHEN_BREATH.get(), Ignited_Revenant_Entity.this.level(), Ignited_Revenant_Entity.this);
            if (Ignited_Revenant_Entity.this.getAnimationTick() == 27) {
                breath.absMoveTo(mouthPos.x, mouthPos.y, mouthPos.z, Ignited_Revenant_Entity.this.yHeadRot, Ignited_Revenant_Entity.this.getXRot());
                Ignited_Revenant_Entity.this.level().addFreshEntity(breath);
            }
        }
    }

    class BoneStormGoal extends SimpleAnimationGoal<Ignited_Revenant_Entity> {

        public BoneStormGoal(Ignited_Revenant_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = entity.getTarget();

            if (target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            }
            if (entity.getAnimationTick() == 5) {
                switch (random.nextInt(3)) {
                    case 0 -> launchbone1();
                    case 1 -> launchbone2();
                    case 2 -> launchbone3();
                    default -> {
                    }
                }

            }
            if(entity.getAnimationTick() == 10){
                    switch (random.nextInt(3)) {
                        case 0 -> launchbone1();
                        case 1 -> launchbone2();
                        case 2 -> launchbone3();
                        default -> {
                        }
                    }
                }
            if(entity.getAnimationTick() == 15){
                switch (random.nextInt(3)) {
                    case 0 -> launchbone1();
                    case 1 -> launchbone2();
                    case 2 -> launchbone3();
                    default -> {
                    }
                }
            }
            if(entity.getAnimationTick() == 20){
                switch (random.nextInt(3)) {
                    case 0 -> launchbone1();
                    case 1 -> launchbone2();
                    case 2 -> launchbone3();
                    default -> {
                    }
                }
            }
            --entity.nextHeightOffsetChangeTick;
            if (entity.nextHeightOffsetChangeTick <= 0) {
                entity.nextHeightOffsetChangeTick = 100;
                entity.allowedHeightOffset = (float)entity.random.triangle(0.5D, 6.891D);
            }

            if (target != null && target.getEyeY() > entity.getEyeY() + (double)entity.allowedHeightOffset && entity.canAttack(target)) {
                Vec3 vec3 = entity.getDeltaMovement();
                entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, ((double)0.3F - vec3.y) * (double)0.3F, 0.0D));
                entity.hasImpulse = true;
            }

        }
    }

    private void launchbone1() {
        this.playSound(SoundEvents.TRIDENT_THROW, 1F, 0.75f);
        for (int i = 0; i < 8; i++) {
            float yawRadians = (float) (Math.toRadians(90 + this.getYRot()));
            float throwAngle = yawRadians + i * Mth.PI / 4F;

            double sx = this.getX() + (Mth.cos(throwAngle) * 1);
            double sy = this.getY() + (this.getBbHeight() * 0.62D);
            double sz = this.getZ() + (Mth.sin(throwAngle) * 1);

            double vx = Mth.cos(throwAngle);
            double vy = 0;
            double vz = Mth.sin(throwAngle);

            Blazing_Bone_Entity projectile = new Blazing_Bone_Entity(this.level(), this);

            projectile.moveTo(sx, sy, sz, i * 45F, this.getXRot());
            float speed = 0.5F;
            projectile.shoot(vx, vy, vz, speed, 1.0F);
            this.level().addFreshEntity(projectile);
        }

    }

    private void launchbone2() {
        this.playSound(SoundEvents.TRIDENT_THROW, 1F, 0.75f);
        for (int i = 0; i < 6; i++) {
            float yawRadians = (float) (Math.toRadians(90 + this.getYRot()));
            float throwAngle = yawRadians +  i * Mth.PI / 3F;

            double sx = this.getX() + (Mth.cos(throwAngle) * 1);
            double sy = this.getY() + (this.getBbHeight() * 0.62D);
            double sz = this.getZ() + (Mth.sin(throwAngle) * 1);

            double vx = Mth.cos(throwAngle);
            double vy = 0;
            double vz = Mth.sin(throwAngle);

            Blazing_Bone_Entity projectile = new Blazing_Bone_Entity(this.level(), this);

            projectile.moveTo(sx, sy, sz, i * 60F, this.getXRot());
            float speed = 0.6F;
            projectile.shoot(vx, vy, vz, speed, 1.0F);
            this.level().addFreshEntity(projectile);
        }

    }

    private void launchbone3() {
        this.playSound(SoundEvents.TRIDENT_THROW, 1F, 0.75f);
        for (int i = 0; i < 10; i++) {
            float yawRadians = (float) (Math.toRadians(90 + this.getYRot()));
            float throwAngle = yawRadians + i * Mth.PI / 5F;

            double sx = this.getX() + (Mth.cos(throwAngle) * 1);
            double sy = this.getY() + (this.getBbHeight() * 0.62D);
            double sz = this.getZ() + (Mth.sin(throwAngle) * 1);

            double vx = Mth.cos(throwAngle);
            double vy = 0;
            double vz = Mth.sin(throwAngle);

            Blazing_Bone_Entity projectile = new Blazing_Bone_Entity(this.level(), this);

            projectile.moveTo(sx, sy, sz, i * 36F, this.getXRot());
            float speed = 0.4F;
            projectile.shoot(vx, vy, vz, speed, 1.0F);
            this.level().addFreshEntity(projectile);
        }

    }


}





