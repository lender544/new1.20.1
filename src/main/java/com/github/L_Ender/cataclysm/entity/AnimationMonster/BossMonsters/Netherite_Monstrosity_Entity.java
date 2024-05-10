package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters;

import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AnimationGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AttackMoveGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.etc.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.partentity.Cm_Part_Entity;
import com.github.L_Ender.cataclysm.entity.partentity.Netherite_Monstrosity_Part;
import com.github.L_Ender.cataclysm.entity.projectile.Lava_Bomb_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class Netherite_Monstrosity_Entity extends Boss_monster implements Enemy {

   // private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(false);
    private final CMBossInfoServer bossInfo = new CMBossInfoServer(this.getDisplayName(), this, BossEvent.BossBarColor.RED, false,0);
    public int frame;
    public static final Animation MONSTROSITY_EARTHQUAKE = Animation.create(75);
    public static final Animation MONSTROSITY_CHARGE = Animation.create(82);
    public static final Animation MONSTROSITY_ERUPTIONATTACK = Animation.create(55);
    public static final Animation MONSTROSITY_EARTHQUAKE2 = Animation.create(65);
    public static final Animation MONSTROSITY_EARTHQUAKE3 = Animation.create(70);
    public static final Animation MONSTROSITY_BERSERK = Animation.create(80);
    public static final Animation MONSTROSITY_DEATH = Animation.create(185);
    public final Netherite_Monstrosity_Part headPart;
    public final Netherite_Monstrosity_Part[] monstrosityParts;
    private static final EntityDataAccessor<Boolean> IS_BERSERK = SynchedEntityData.defineId(Netherite_Monstrosity_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_AWAKEN = SynchedEntityData.defineId(Netherite_Monstrosity_Entity.class, EntityDataSerializers.BOOLEAN);
    private int lavabombmagazine = CMConfig.Lavabombmagazine;
    public boolean Blocking = CMConfig.NetheritemonstrosityBodyBloking;
    public float deactivateProgress;
    private int blockBreakCounter;
    public float prevdeactivateProgress;
    public static final int NATURE_HEAL_COOLDOWN = 200;
    private int timeWithoutTarget;

    public Netherite_Monstrosity_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 300;
        this.setMaxUpStep(1.75F);
        this.headPart = new Netherite_Monstrosity_Part(this, 1.6F, 2.5F);
        this.monstrosityParts = new Netherite_Monstrosity_Part[]{this.headPart};
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0.0F);
        setConfigattribute(this, CMConfig.MonstrosityHealthMultiplier, CMConfig.MonstrosityDamageMultiplier);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{MONSTROSITY_BERSERK, MONSTROSITY_EARTHQUAKE, MONSTROSITY_CHARGE, MONSTROSITY_EARTHQUAKE2, MONSTROSITY_EARTHQUAKE3, MONSTROSITY_ERUPTIONATTACK, MONSTROSITY_DEATH};
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new BerserkGoal(this,MONSTROSITY_BERSERK));
        this.goalSelector.addGoal(0, new AwakenGoal());
        this.goalSelector.addGoal(1, new HealGoal(this, MONSTROSITY_CHARGE));
        this.goalSelector.addGoal(1, new ShootGoal(this, MONSTROSITY_ERUPTIONATTACK));
        this.goalSelector.addGoal(1, new EarthQuakeGoal(this));
        this.goalSelector.addGoal(2, new AttackMoveGoal(this, true,1.0D));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));

    }

    public static AttributeSupplier.Builder netherite_monstrosity() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.ATTACK_DAMAGE, 21)
                .add(Attributes.MAX_HEALTH, 500)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_BERSERK, false);
        this.entityData.define(IS_AWAKEN, false);
    }

    private static Animation getRandomAttack(RandomSource rand) {
        switch (rand.nextInt(3)) {

            case 0:
                return MONSTROSITY_EARTHQUAKE;
            case 1:
                return MONSTROSITY_EARTHQUAKE2;
            case 2:
                return MONSTROSITY_EARTHQUAKE3;
        }
        return MONSTROSITY_EARTHQUAKE;
    }

    public boolean canStandOnFluid(FluidState p_230285_1_) {
        return p_230285_1_.is(FluidTags.LAVA);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_Berserk", getIsBerserk());
        compound.putBoolean("is_Awaken", getIsAwaken());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setIsBerserk(compound.getBoolean("is_Berserk"));
        setIsAwaken(compound.getBoolean("is_Awaken"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void setIsBerserk(boolean isBerserk) {
        this.entityData.set(IS_BERSERK, isBerserk);
    }

    public boolean getIsBerserk() {
        return this.entityData.get(IS_BERSERK);
    }

    public void setIsAwaken(boolean isAwaken) {
        this.entityData.set(IS_AWAKEN, isAwaken);
    }

    public boolean getIsAwaken() {
        return this.entityData.get(IS_AWAKEN);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected int decreaseAirSupply(int air) {
        return air;
    }

    public boolean attackEntityFromPart(Netherite_Monstrosity_Part netherite_monstrosity_part, DamageSource source, float amount) {
        return this.hurt(source, amount);
    }

    @Override
    public boolean hurt(DamageSource source, float damage) {
        if (this.getAnimation() == MONSTROSITY_BERSERK && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        double range = calculateRange(source);

        if (range > CMConfig.MonstrosityLongRangelimit * CMConfig.MonstrosityLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        Entity entity = source.getDirectEntity();
        if (entity instanceof AbstractGolem) {
            damage *= 0.5;
        }

        boolean attack = super.hurt(source, damage);

        if(attack &&!this.getIsAwaken() ){
            this.setIsAwaken(true);
        }
        return attack;
    }

    @Override
    public float DamageCap() {
        return (float) CMConfig.MonstrosityDamageCap;
    }

    public boolean canBeCollidedWith() {
        return this.isAlive() && Blocking;
    }

    public boolean isPushable() {
        return false;
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    private void floatStrider() {
        if (this.isInLava()) {
            CollisionContext lvt_1_1_ = CollisionContext.of(this);
            if (lvt_1_1_.isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition().below(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.LAVA)) {
                this.setOnGround(true);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5D).add(0.0D, random.nextFloat() * 0.5, 0.0D));
            }
        }

    }

    public void tick() {
        super.tick();
        this.floatStrider();
        if (tickCount % 4 == 0) bossInfo.update();

        //prevgetYRot() = getYRot();
        if (tickCount % 4 == 0) bossInfo.update();
        frame++;
        float moveX = (float) (getX() - xo);
        float moveZ = (float) (getZ() - zo);
        float speed = Mth.sqrt(moveX * moveX + moveZ * moveZ);
        if (!this.isSilent() && frame % 25 == 1 && speed > 0.05 && this.getIsAwaken()) {
            playSound(ModSounds.MONSTROSITYSTEP.get(), 1F, 1.0f);
        }
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
        BlockBreaking();
        prevdeactivateProgress = deactivateProgress;
        if (!this.getIsAwaken() && deactivateProgress < 40F) {
            deactivateProgress = 40;
        }
        if (this.getIsAwaken() && deactivateProgress > 0F) {
            deactivateProgress--;
            if(deactivateProgress == 20 && this.getHealth() > 0){
                this.playSound(ModSounds.MONSTROSITYAWAKEN.get(), 10, 1);
            }
        }
        LivingEntity target = this.getTarget();
        if (!this.level().isClientSide) {
            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAnimation() == NO_ANIMATION && timeWithoutTarget <= 0) {
                if (!isNoAi() && CMConfig.MonstrosityNatureHealing > 0) {
                    if (this.tickCount % 20 == 0) {
                        this.heal((float) CMConfig.MonstrosityNatureHealing);
                    }
                }
            }
        }
        
        if (this.getAnimation() == MONSTROSITY_EARTHQUAKE && this.getAnimationTick() == 34
                || this.getAnimation() == MONSTROSITY_EARTHQUAKE2 && this.getAnimationTick() == 24
                || this.getAnimation() == MONSTROSITY_EARTHQUAKE3 && this.getAnimationTick() == 29 ){
            EarthQuake();
            ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
            Makeparticle(4.75f,2.5f);
            Makeparticle(4.75f,-2.5f);
        }

        if(deactivateProgress == 0 && this.isAlive()) {
            if(!isNoAi() && this.getAnimation() == NO_ANIMATION && this.isBerserk() && !this.getIsBerserk()){
                this.setAnimation(MONSTROSITY_BERSERK);
            }else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && target != null && target.isAlive()) {
                if (this.isInLava() && this.lavabombmagazine == 0) {
                    this.setAnimation(MONSTROSITY_CHARGE);
                }
                else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) >= 18F && this.distanceTo(target) < 40F && this.lavabombmagazine > 0 && this.random.nextInt(48) == 0 || this.distanceTo(target) > 4.75F && random.nextFloat() * 100.0F < 0.3F && this.distanceTo(target) < 18F && this.lavabombmagazine > 0) {
                    this.setAnimation(MONSTROSITY_ERUPTIONATTACK);

                }
                else if (!isNoAi() && this.getAnimation() == NO_ANIMATION && this.distanceTo(target) < 6) {
                    Animation animation = getRandomAttack(random);
                    if (this.isBerserk()) {
                        this.setAnimation(MONSTROSITY_EARTHQUAKE2);
                    } else {
                        this.setAnimation(animation);
                    }
                }
            }
        }

        if (this.getAnimation() == MONSTROSITY_CHARGE) {
            if (this.getAnimationTick() == 34) {
                this.lavabombmagazine = CMConfig.Lavabombmagazine;
                this.doAbsorptionEffects(4,1,4);
                this.playSound(SoundEvents.BUCKET_FILL_LAVA, 6f, 0.5F);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);
            }
            if (this.getAnimationTick() == 44) {
                this.doAbsorptionEffects(8,2,8);
                this.playSound(SoundEvents.BUCKET_FILL_LAVA, 6f, 0.5F);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier );
            }
            if (this.getAnimationTick() == 54) {
                this.doAbsorptionEffects(16, 4, 16);
                this.playSound(SoundEvents.BUCKET_FILL_LAVA, 6f, 0.5F);
                this.heal(15F * (float) CMConfig.MonstrosityHealingMultiplier);

            }
        }
        if (this.getAnimation() == MONSTROSITY_BERSERK) {
            Netherite_Monstrosity_Entity.this.setIsBerserk(true);
            if (this.getAnimationTick() == 20) {
                this.playSound(ModSounds.MONSTROSITYGROWL.get(), 3, 1);
            }
            if (this.getAnimationTick() == 29) {
                berserkBlockBreaking(8,8,8);
                EarthQuake();
                ScreenShake_Entity.ScreenShake(level(), this.position(), 20, 0.3f, 0, 20);
                Makeparticle(4.0f,3.5f);
                Makeparticle(4.0f,-3.5f);
            }
        }
        if (!level().isClientSide) {
            if (!this.getIsAwaken() && target != null) {
                this.setIsAwaken(true);
            }
        }

        if (!this.isNoAi()) {
            float f17 = this.getYRot() * ((float) Math.PI / 180F);
            float pitch = this.getXRot() * ((float) Math.PI / 180F);
            float f3 = Mth.sin(f17) * (1 - Math.abs(this.getXRot() / 90F));
            float f18 = Mth.cos(f17) * (1 - Math.abs(this.getXRot() / 90F));

            Vec3[] avector3d = new Vec3[this.monstrosityParts.length];
            for (int j = 0; j < this.monstrosityParts.length; ++j) {
                avector3d[j] = new Vec3(this.monstrosityParts[j].getX(), this.monstrosityParts[j].getY(), this.monstrosityParts[j].getZ());
            }
            this.setPartPosition(this.headPart, f3 * -1.65F, pitch + 3F, -f18 * -1.65F);

            for (int l = 0; l < this.monstrosityParts.length; ++l) {
                this.monstrosityParts[l].xo = avector3d[l].x;
                this.monstrosityParts[l].yo = avector3d[l].y;
                this.monstrosityParts[l].zo = avector3d[l].z;
                this.monstrosityParts[l].xOld = avector3d[l].x;
                this.monstrosityParts[l].yOld = avector3d[l].y;
                this.monstrosityParts[l].zOld = avector3d[l].z;
            }
        }
    }

    public boolean isAlliedTo(Entity entityIn) {
        if (entityIn == this) {
            return true;
        } else if (super.isAlliedTo(entityIn)) {
            return true;
        } else if (entityIn instanceof Netherite_Monstrosity_Entity) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    @Override
    protected void onDeathAIUpdate() {
        super.onDeathAIUpdate();
        setDeltaMovement(0, Netherite_Monstrosity_Entity.this.getDeltaMovement().y, 0);
        if (this.deathTime == 68) {
            this.playSound(ModSounds.MONSTROSITYLAND.get(), 1, 1);
        }

    }

    private void doAbsorptionEffects(int x, int y, int z) {

        int MthX = Mth.floor(this.getX());
        int MthY = Mth.floor(this.getY());
        int MthZ = Mth.floor(this.getZ());

        for (int k2 = -x; k2 <= x; ++k2) {
            for (int l2 = -z; l2 <= z; ++l2) {
                for (int j = -y; j <= y; ++j) {
                    int i3 = MthX + k2;
                    int k = MthY + j;
                    int l = MthZ + l2;
                    BlockPos blockpos = new BlockPos(i3, k, l);
                    this.doAbsorptionEffect(blockpos);
                }
            }
        }
    }

    private void doAbsorptionEffect(BlockPos pos) {
        BlockState state = level().getBlockState(pos);
       // if (state.getFluidState().isTagged(FluidTags.LAVA) && state.getFluidState().isSource()) {
      //      this.world.setBlockState(pos, Blocks.AIR.getDefaultState());
      //  }
        if (!this.level().isClientSide) {
            if (state.is(Blocks.LAVA)) {
                this.level().setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            }
        }
    }

    private void EarthQuake() {
        this.playSound(SoundEvents.GENERIC_EXPLODE, 1.5f, 1F + this.getRandom().nextFloat() * 0.1F);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0D))) {
            if (!isAlliedTo(entity) && !(entity instanceof Netherite_Monstrosity_Entity) && entity != this) {
                boolean flag = entity.hurt(this.damageSources().mobAttack(this), (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.MonstrositysHpdamage)));
                if (entity instanceof Player && entity.isBlocking()) {
                    disableShield(entity, 120);
                }
                if (flag) {
                    launch(entity, true);
                    if (getIsBerserk()) {
                        entity.setSecondsOnFire(6);
                    }
                }
            }
        }
    }

    private void Makeparticle(float vec, float math) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
            float f1 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            for (int i1 = 0; i1 < 80 + random.nextInt(12); i1++) {
                double DeltaMovementX = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementY = getRandom().nextGaussian() * 0.07D;
                double DeltaMovementZ = getRandom().nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.yBodyRot) + i1;
                double extraX = 2F * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 2F * Mth.cos(angle);
                int hitX = Mth.floor(getX() + vec * vecX+ extraX);
                int hitY = Mth.floor(getY());
                int hitZ = Mth.floor(getZ() + vec * vecZ + extraZ);
                BlockPos hit = new BlockPos(hitX, hitY, hitZ);
                BlockState block = level().getBlockState(hit.below());
                if (getIsBerserk()) {
                    this.level().addParticle(ParticleTypes.FLAME, getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                } else {
                    this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), getX() + vec * vecX + extraX + f * math, this.getY() + extraY, getZ() + vec * vecZ + extraZ + f1 * math, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
            if (getIsBerserk()) {
                this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 35, 0.8f, 0.305f, 0.02f, 1f, 30f, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
            }else{
                this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 35, 1f, 1f, 1f, 1f, 30f, false, RingParticle.EnumRingBehavior.GROW), getX() + vec * vecX + f * math, getY() + 0.2f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
            }
        }
    }


    private void launch(Entity e, boolean huge) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 2F : 0.5F;
        e.push(d0 / d2 * f, huge ? 0.75D : 0.2F, d1 / d2 * f);
    }


    private void berserkBlockBreaking(int x, int y, int z) {
        int MthX = Mth.floor(this.getX());
        int MthY = Mth.floor(this.getY());
        int MthZ = Mth.floor(this.getZ());
        if (!this.level().isClientSide) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                for (int k2 = -x; k2 <= x; ++k2) {
                    for (int l2 = -z; l2 <= z; ++l2) {
                        for (int j = 0; j <= y; ++j) {
                            int i3 = MthX + k2;
                            int k = MthY + j;
                            int l = MthZ + l2;
                            BlockPos blockpos = new BlockPos(i3, k, l);
                            BlockState block = level().getBlockState(blockpos);
                            BlockEntity tileEntity = level().getBlockEntity(blockpos);
                            if (block != Blocks.AIR.defaultBlockState() & !block.is(ModTag.NETHERITE_MONSTROSITY_IMMUNE)) {
                                if (tileEntity == null && random.nextInt(4) + 1 == 4) {
                                    this.level().removeBlock(blockpos, true);
                                    Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), i3 + 0.5D, k + 0.5D, l + 0.5D, block,5);
                                    level().setBlock(blockpos, block.getFluidState().createLegacyBlock(), 3);
                                    fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2D + random.nextDouble()) / 3, (-1.1D + random.nextDouble()) / 3, (-1.2D + random.nextDouble()) / 3)));
                                    level().addFreshEntity(fallingBlockEntity);
                                } else {
                                    level().destroyBlock(new BlockPos(i3, k, l), shouldDropItem(tileEntity));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void BlockBreaking() {
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
            return;
        }
        if(!this.isNoAi()) {
            if (!this.level().isClientSide && this.blockBreakCounter == 0) {
                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    for (int a = (int) Math.round(this.getBoundingBox().minX); a <= (int) Math.round(this.getBoundingBox().maxX); a++) {
                        for (int b = (int) Math.round(this.getBoundingBox().minY); (b <= (int) Math.round(this.getBoundingBox().maxY) + 1) && (b <= 127); b++) {
                            for (int c = (int) Math.round(this.getBoundingBox().minZ); c <= (int) Math.round(this.getBoundingBox().maxZ); c++) {
                                BlockPos blockpos = new BlockPos(a, b, c);
                                BlockState block = level().getBlockState(blockpos);
                                BlockEntity tileEntity = level().getBlockEntity(blockpos);
                                if (block != Blocks.AIR.defaultBlockState() && block.is(ModTag.NETHERITE_MONSTROSITY_BREAK)) {
                                    boolean flag = level().destroyBlock(new BlockPos(a, b, c), shouldDropItem(tileEntity));
                                    if (flag) {
                                        blockBreakCounter = 10;
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    private boolean shouldDropItem(BlockEntity tileEntity) {
        if (tileEntity == null) {
            return random.nextInt(3) + 1 == 3;
        }
        return true;
    }

    public boolean isBerserk() {
        return this.getHealth() <= this.getMaxHealth() / 3.0F;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {
            itementity.setDeltaMovement(itementity.getDeltaMovement().multiply(0.0, 3.5, 0.0));
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    private void setPartPosition(Netherite_Monstrosity_Part part, double offsetX, double offsetY, double offsetZ) {
        part.setPos(this.getX() + offsetX * part.scale, this.getY() + offsetY * part.scale, this.getZ() + offsetZ * part.scale);
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.monstrosityParts;
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        Cm_Part_Entity.assignPartIDs(this);
    }

    public void travel(Vec3 travelVector) {
        this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED) * (isInLava() ? 0.2F : 1F));
        if (this.isEffectiveAi() && this.isInLava()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
        } else {

            super.travel(travelVector);
        }
    }



    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.MONSTROSITYHURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.MONSTROSITYDEATH.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.MONSTROSITY_MUSIC.get();
    }

    @Override
    protected boolean canPlayMusic() {
        return super.canPlayMusic() && getIsAwaken();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }


    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public BossEvent.BossBarColor bossBarColor() {
        return BossEvent.BossBarColor.RED;
    }


    @Nullable
    public Animation getDeathAnimation()
    {
        return MONSTROSITY_DEATH;
    }


    class EarthQuakeGoal extends AnimationGoal<Netherite_Monstrosity_Entity> {

        public EarthQuakeGoal(Netherite_Monstrosity_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == MONSTROSITY_EARTHQUAKE
                    || animation == MONSTROSITY_EARTHQUAKE2
                    || animation == MONSTROSITY_EARTHQUAKE3;
        }

        public void tick() {
            LivingEntity target = Netherite_Monstrosity_Entity.this.getTarget();
            Netherite_Monstrosity_Entity.this.setDeltaMovement(0, Netherite_Monstrosity_Entity.this.getDeltaMovement().y, 0);
                //I wanted to clear this code, but I didn't because I was too lazy.
            if (Netherite_Monstrosity_Entity.this.getAnimation() == MONSTROSITY_EARTHQUAKE) {
                if (Netherite_Monstrosity_Entity.this.getAnimationTick() < 34 && target !=null || Netherite_Monstrosity_Entity.this.getAnimationTick() > 54 && target !=null) {
                    Netherite_Monstrosity_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30, 30);
                } else {
                    Netherite_Monstrosity_Entity.this.setYRot(Netherite_Monstrosity_Entity.this.yRotO);
                  //  Netherite_Monstrosity_Entity.this.yBodyRot = Netherite_Monstrosity_Entity.this.yBodyRotO;
                }

            }
            if (Netherite_Monstrosity_Entity.this.getAnimation() == MONSTROSITY_EARTHQUAKE2) {
                if (Netherite_Monstrosity_Entity.this.getAnimationTick() < 24  && target !=null || Netherite_Monstrosity_Entity.this.getAnimationTick() > 44  && target !=null) {
                    Netherite_Monstrosity_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30, 30);
                } else {
                    Netherite_Monstrosity_Entity.this.setYRot(Netherite_Monstrosity_Entity.this.yRotO);
                    //Netherite_Monstrosity_Entity.this.yBodyRot = Netherite_Monstrosity_Entity.this.yBodyRotO;
                }

            }

            if (Netherite_Monstrosity_Entity.this.getAnimation() == MONSTROSITY_EARTHQUAKE3) {
                if (Netherite_Monstrosity_Entity.this.getAnimationTick() < 29 && target !=null || Netherite_Monstrosity_Entity.this.getAnimationTick() > 49 && target !=null) {
                    Netherite_Monstrosity_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30, 30);
                } else {
                    Netherite_Monstrosity_Entity.this.setYRot(Netherite_Monstrosity_Entity.this.yRotO);
                    //Netherite_Monstrosity_Entity.this.yBodyRot = Netherite_Monstrosity_Entity.this.yBodyRotO;
                }
            }
        }
    }



    class ShootGoal extends SimpleAnimationGoal<Netherite_Monstrosity_Entity> {

        public ShootGoal(Netherite_Monstrosity_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Netherite_Monstrosity_Entity.this.getTarget();
            Netherite_Monstrosity_Entity.this.setDeltaMovement(0, Netherite_Monstrosity_Entity.this.getDeltaMovement().y, 0);
            int lavabombcount = CMConfig.Lavabombamount;


            if(target !=null) {
                Netherite_Monstrosity_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30, 30);
                if (Netherite_Monstrosity_Entity.this.getAnimationTick() == 30) {
                    Netherite_Monstrosity_Entity.this.playSound(ModSounds.MONSTROSITYSHOOT.get(), 3, 0.75f);
                    Netherite_Monstrosity_Entity.this.lavabombmagazine--;
                    for (int i = 0; i < lavabombcount; ++i) {
                        Lava_Bomb_Entity lava = new Lava_Bomb_Entity(ModEntities.LAVA_BOMB.get(), Netherite_Monstrosity_Entity.this.level(), Netherite_Monstrosity_Entity.this);
                        double d0 = target.getX() - Netherite_Monstrosity_Entity.this.headPart.getX();
                        double d1 = target.getBoundingBox().minY + target.getBbHeight() / 3.0F - lava.getY();
                        double d2 = target.getZ() - Netherite_Monstrosity_Entity.this.headPart.getZ();
                        double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
                        lava.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.0F, 24 - Netherite_Monstrosity_Entity.this.level().getDifficulty().getId() * 4);
                        Netherite_Monstrosity_Entity.this.level().addFreshEntity(lava);
                    }
                }
            }
        }
    }

    class BerserkGoal extends SimpleAnimationGoal<Netherite_Monstrosity_Entity> {

        public BerserkGoal(Netherite_Monstrosity_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            Netherite_Monstrosity_Entity.this.setDeltaMovement(0, Netherite_Monstrosity_Entity.this.getDeltaMovement().y, 0);
            LivingEntity target = Netherite_Monstrosity_Entity.this.getTarget();
            if (target!= null) {
                Netherite_Monstrosity_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30, 30);
            }
        }
    }

    class HealGoal extends SimpleAnimationGoal<Netherite_Monstrosity_Entity> {

        public HealGoal(Netherite_Monstrosity_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public void tick() {
            LivingEntity target = Netherite_Monstrosity_Entity.this.getTarget();
            Netherite_Monstrosity_Entity.this.setDeltaMovement(0, Netherite_Monstrosity_Entity.this.getDeltaMovement().y, 0);
            if (Netherite_Monstrosity_Entity.this.getAnimation() == MONSTROSITY_CHARGE && target!=null){
                if (Netherite_Monstrosity_Entity.this.getAnimationTick() < 34 || Netherite_Monstrosity_Entity.this.getAnimationTick() > 72) {
                    Netherite_Monstrosity_Entity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
                    entity.lookAt(target, 30, 30);
                } else {
                    Netherite_Monstrosity_Entity.this.setYRot(Netherite_Monstrosity_Entity.this.yRotO);
                  //  Netherite_Monstrosity_Entity.this.yBodyRot = Netherite_Monstrosity_Entity.this.yBodyRotO;
                }
            }

        }
    }

    class AwakenGoal extends Goal {

        public AwakenGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public boolean canUse() {
            return deactivateProgress > 0F;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            Netherite_Monstrosity_Entity.this.setDeltaMovement(0, Netherite_Monstrosity_Entity.this.getDeltaMovement().y, 0);
        }
    }

}





