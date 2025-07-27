package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.RoarParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.AnimalAIRandomSwimming;
import com.github.L_Ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.L_Ender.cataclysm.entity.AI.MobAIFindWater;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AdvancedHurtByTargetGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.AnimationGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.HurtByNearestTargetGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.AI.SimpleAnimationGoal;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.LLibrary_Boss_Monster;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.*;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.partentity.Cm_Part_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.message.MessageMusic;
import com.github.L_Ender.cataclysm.world.data.CMWorldData;
import com.github.L_Ender.lionfishapi.server.animation.Animation;
import com.github.L_Ender.lionfishapi.server.animation.AnimationHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.network.PacketDistributor;

import javax.annotation.Nullable;
import java.util.*;

public class The_Leviathan_Entity extends LLibrary_Boss_Monster implements ISemiAquatic,IHoldEntity {

    public static final Animation LEVIATHAN_GRAB = Animation.create(160);
    public static final Animation LEVIATHAN_GRAB_BITE = Animation.create(13);
    public static final Animation LEVIATHAN_BITE = Animation.create(24);
    public static final Animation LEVIATHAN_ABYSS_BLAST = Animation.create(184);
    public static final Animation LEVIATHAN_ABYSS_BLAST_FIRE = Animation.create(216);

    public static final Animation LEVIATHAN_RUSH = Animation.create(157);
    public static final Animation LEVIATHAN_STUN = Animation.create(90);

    public static final Animation LEVIATHAN_ABYSS_BLAST_PORTAL = Animation.create(142);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_UPPER_R = Animation.create(44);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_LOWER_R = Animation.create(44);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_UPPER_L = Animation.create(44);
    public static final Animation LEVIATHAN_TENTACLE_STRIKE_LOWER_L = Animation.create(44);

    public static final Animation LEVIATHAN_TENTACLE_HOLD = Animation.create(63);
    public static final Animation LEVIATHAN_TENTACLE_HOLD_BLAST = Animation.create(189);

    public static final Animation LEVIATHAN_TAIL_WHIPS = Animation.create(42);
    public static final Animation LEVIATHAN_BREAK_DIMENSION = Animation.create(156);
    public static final Animation LEVIATHAN_PHASE2 = Animation.create(200);
    public static final Animation LEVIATHAN_DEATH = Animation.create(210);

    public static final Animation LEVIATHAN_MINE = Animation.create(68);

    public final The_Leviathan_Part headPart;
    public final The_Leviathan_Part tailPart1;
    public final The_Leviathan_Part tailPart2;

    public final The_Leviathan_Part[] leviathanParts;
    public boolean blocksBylefttentacle = true;
    public boolean blocksByrighttentacle = true;

    public boolean CanGrab = true;
    public boolean CanAbyss_Blast = true;
    public boolean CanRush = true;
    public boolean CanTailWhips = true;
    public boolean CanBite = true;
    public boolean CanAbyss_Blast_Portal = true;
    public boolean CanCrackDimension = true;
    public boolean CanMine= true;

    public float NoSwimProgress = 0;
    public float prevNoSwimProgress = 0;
    public float LeftTentacleProgress = 0;
    public float prevLeftTentacleProgress = 0;
    public float RightTentacleProgress = 0;
    public float prevRightTentacleProgress = 0;
    private boolean isLandNavigator;
    public Vec3 teleportPos = null;
    public Abyss_Portal_Entity portalTarget = null;
    public boolean fullyThrough = true;
    public static final int GRAB_HUNTING_COOLDOWN = 70;
    public static final int RUSH_HUNTING_COOLDOWN = 100;
    public static final int BLAST_HUNTING_COOLDOWN = 140;
    public static final int CRACK_HUNTING_COOLDOWN = 250;
    public static final int BLAST_PORTAL_HUNTING_COOLDOWN = 120;
    public static final int TAIL_WHIPS_HUNTING_COOLDOWN = 100;
    public static final int BITE_COOLDOWN = 100;
    public static final int MELEE_COOLDOWN = 40;
    public static final int MINE_COOLDOWN = 100;
    private AttackMode mode = AttackMode.CIRCLE;
    private int hunting_cooldown = 160;
    private int makePortalCooldown = 0;
    private int bite_cooldown = 0;
    private int melee_cooldown = 0;
    private int waterstillTicks = 0;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    private int destroyBlocksTick;
    private int blockBreakCounter;
    public float LayerBrightness;
    private Vec3 prevTailPos = new Vec3(0, 0, 0);
    private final CMBossInfoServer bossInfo = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.PURPLE,false,5);
    private static final EntityDataAccessor<Integer> BLAST_CHANCE = SynchedEntityData.defineId(The_Leviathan_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MODE_CHANCE = SynchedEntityData.defineId(The_Leviathan_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> MELT_DOWN = SynchedEntityData.defineId(The_Leviathan_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Optional<UUID>> TONGUE_UUID = SynchedEntityData.defineId(The_Leviathan_Entity.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<Integer> TONGUE_ID = SynchedEntityData.defineId(The_Leviathan_Entity.class, EntityDataSerializers.INT);


    public The_Leviathan_Entity(EntityType type, Level worldIn) {
        super(type, worldIn);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.xpReward = 500;
        if (worldIn.isClientSide)
            socketPosArray = new Vec3[]{new Vec3(0, 0, 0)
        };
        this.headPart = new The_Leviathan_Part(this, 2.8F, 2.8F);
        this.tailPart1 = new The_Leviathan_Part(this, 1.5F, 2.4F);
        this.tailPart2 = new The_Leviathan_Part(this, 1.3F, 2.4F);
        this.leviathanParts = new The_Leviathan_Part[]{this.headPart,this.tailPart1,this.tailPart2};
        switchNavigator(false);
        setConfigattribute(this, CMConfig.LeviathanHealthMultiplier, CMConfig.LeviathanDamageMultiplier);
    }

    public static AttributeSupplier.Builder leviathan() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 400.0D)
                .add(Attributes.FOLLOW_RANGE, 64.0D)
                .add(Attributes.ARMOR, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.15);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WaterBoundPathNavigation(this, worldIn);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BLAST_CHANCE, 0);
        this.entityData.define(MODE_CHANCE, 0);
        this.entityData.define(MELT_DOWN, false);
        this.entityData.define(TONGUE_UUID, Optional.empty());
        this.entityData.define(TONGUE_ID, -1);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(2, new MobAIFindWater(this,2.0D));
        this.goalSelector.addGoal(3, new LeviathanAttackGoal(this));
        this.goalSelector.addGoal(4, new AnimalAIRandomSwimming(this, 1F, 3, 15));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(0, new LeviathanGrabAttackGoal(this,LEVIATHAN_GRAB));
        this.goalSelector.addGoal(0, new LeviathanAbyssDimensionAttackGoal(this,LEVIATHAN_BREAK_DIMENSION));
        this.goalSelector.addGoal(0, new LeviathanStunGoal(this,LEVIATHAN_STUN));
        this.goalSelector.addGoal(0, new LeviathanGrabBiteAttackGoal(this,LEVIATHAN_GRAB_BITE));
        this.goalSelector.addGoal(0, new LeviathanBiteAttackGoal(this,LEVIATHAN_BITE));
        this.goalSelector.addGoal(0, new LeviathanPhase2Goal(this,LEVIATHAN_PHASE2));
        this.goalSelector.addGoal(0, new LeviathanTailWhipsAttackGoal(this,LEVIATHAN_TAIL_WHIPS));
        this.goalSelector.addGoal(0, new LeviathanTentacleAttackGoal(this));
        this.goalSelector.addGoal(0, new LeviathanBlastAttackGoal(this,LEVIATHAN_ABYSS_BLAST));
        this.goalSelector.addGoal(0, new LeviathanBlastFireAttackGoal(this,LEVIATHAN_ABYSS_BLAST_FIRE));
        this.goalSelector.addGoal(0, new LeviathanAbyssBlastPortalAttackGoal(this,LEVIATHAN_ABYSS_BLAST_PORTAL));
        this.goalSelector.addGoal(0, new LeviathanRushAttackGoal(this,LEVIATHAN_RUSH));
        this.goalSelector.addGoal(0, new LeviathanTentacleHoldAttackGoal(this,LEVIATHAN_TENTACLE_HOLD));
        this.goalSelector.addGoal(0, new LeviathanTentacleHoldBlastAttackGoal(this,LEVIATHAN_TENTACLE_HOLD_BLAST));
        this.goalSelector.addGoal(0, new LeviathanMineAttackGoal(this,LEVIATHAN_MINE));
        this.targetSelector.addGoal(1, new HurtByNearestTargetGoal(this));
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<>(this, Player.class, false,true));
        this.targetSelector.addGoal(3, new EntityAINearestTarget3D<>(this, LivingEntity.class, 160, false, true, ModEntities.buildPredicateFromTag(ModTag.LEVIATHAN_TARGET)));

    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl(this);
            this.navigation = new CMPathNavigateGround(this, level());
            this.isLandNavigator = true;
        } else {
            this.moveControl = new LeviathanMoveController(this, 10, 1, 6);
            this.navigation = new WaterBoundPathNavigation(this, level());
            this.isLandNavigator = false;
        }
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{LEVIATHAN_PHASE2,LEVIATHAN_BITE,LEVIATHAN_BREAK_DIMENSION,LEVIATHAN_GRAB,LEVIATHAN_TAIL_WHIPS, LEVIATHAN_ABYSS_BLAST_PORTAL,LEVIATHAN_GRAB_BITE,LEVIATHAN_ABYSS_BLAST,LEVIATHAN_RUSH,LEVIATHAN_TENTACLE_STRIKE_UPPER_R,LEVIATHAN_TENTACLE_STRIKE_UPPER_L,LEVIATHAN_TENTACLE_STRIKE_LOWER_L,LEVIATHAN_TENTACLE_STRIKE_LOWER_R,LEVIATHAN_STUN,LEVIATHAN_DEATH,
                LEVIATHAN_TENTACLE_HOLD,LEVIATHAN_TENTACLE_HOLD_BLAST,LEVIATHAN_ABYSS_BLAST_FIRE,LEVIATHAN_MINE};
    }

    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null && this.getAnimation() == NO_ANIMATION) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }

    }


    private static Animation getRandomTantalcleStrike(RandomSource rand) {
        switch (rand.nextInt(4)) {
            case 0:
                return LEVIATHAN_TENTACLE_STRIKE_LOWER_L;
            case 1:
                return LEVIATHAN_TENTACLE_STRIKE_LOWER_R;
            case 2:
                return LEVIATHAN_TENTACLE_STRIKE_UPPER_L;
            case 3:
                return LEVIATHAN_TENTACLE_STRIKE_UPPER_R;
        }
        return LEVIATHAN_TENTACLE_STRIKE_UPPER_R;
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

    public boolean hurt(DamageSource source, float damage) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof Abyss_Blast_Entity || entity instanceof Portal_Abyss_Blast_Entity) {
            return false;
        }
        if (this.destroyBlocksTick <= 0) {
            this.destroyBlocksTick = 20;
        }
        double range = calculateRange(source);

        if (range > CMConfig.LeviathanLongRangelimit * CMConfig.LeviathanLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }

        boolean flag1 = this.canInFluidType(this.getEyeInFluidType());
        if (!flag1) {
            if(!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && CMConfig.LeviathanImmuneOutofWater) {
                if (entity instanceof Player player) {
                    player.displayClientMessage(Component.translatable("entity.cataclysm.the_leviathan_immune"), true);
                }
                return false;
            }
        }

        if ((this.getAnimation() == LEVIATHAN_PHASE2) && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }


        boolean attack = super.hurt(source, damage);

        if(this.getAnimation() == LEVIATHAN_RUSH) {
            if (this.getAnimationTick() >= 38 && this.getAnimationTick() <= 54) {
                if(attack){
                    AnimationHandler.INSTANCE.sendAnimationMessage(this, LEVIATHAN_STUN);
                }
            }
        }


        return attack;
    }

    
    public float DamageCap() {
        return (float) CMConfig.LeviathanDamageCap;
    }

    public float NatureRegen() {
        return (float) CMConfig.LeviathanNatureHealing;
    }

    public int DamageTime() {
        return CMConfig.LeviathanDamageTime;
    }

    public int HealCooldown() {
        return 600;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    private boolean canInFluidType(FluidType type) {
        ForgeMod.WATER_TYPE.get();
        return type.canSwim(self());
    }

    public void onInsideBubbleColumn(boolean p_20322_) {

    }

    public void onAboveBubbleCol(boolean p_20313_) {

    }


    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.IN_WALL) || source.is(DamageTypes.FALLING_BLOCK) || super.isInvulnerableTo(source);
    }

    public boolean causeFallDamage(float p_148711_, float p_148712_, DamageSource p_148713_) {
        return false;
    }

    public boolean attackEntityFromPart(The_Leviathan_Part leviathan_part, DamageSource source, float amount) {
        return this.hurt(source, amount);
    }


    public void tick() {
        super.tick();
        this.setYRot(this.yHeadRot);
        if (isInWater() && this.isLandNavigator) {
            switchNavigator(false);
        }
        if (!isInWater() && !this.isLandNavigator) {
            switchNavigator(true);
        }
        Entity weapon = getTongue();
        if (weapon instanceof The_Leviathan_Tongue_Entity magneticWeapon) {
            this.entityData.set(TONGUE_ID, magneticWeapon.getId());
            magneticWeapon.setControllerUUID(this.getUUID());
        }

        if (!this.getPassengers().isEmpty() && this.getPassengers().get(0).isShiftKeyDown() && this.getAnimation() == LEVIATHAN_TENTACLE_HOLD_BLAST) {
            this.getPassengers().get(0).setShiftKeyDown(false);
        }


        LivingEntity target = this.getTarget();
        if (!level().isClientSide) {
            float halfHealth = this.getMaxHealth() / 2;
            if (!this.getMeltDown()) {
                this.bossInfo.setProgress((this.getHealth() - halfHealth) / (this.getMaxHealth() - halfHealth));
            }else{
                this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
                this.bossInfo.setRenderType(6);
            }
        }

        final boolean groundAnimate = !this.isInWater();
        this.prevNoSwimProgress = NoSwimProgress;
        if (groundAnimate) {
            if (this.NoSwimProgress < 10F)
                this.NoSwimProgress++;
        } else {
            if (this.NoSwimProgress > 0F)
                this.NoSwimProgress--;
        }
        this.prevLeftTentacleProgress = LeftTentacleProgress;
        this.prevRightTentacleProgress = RightTentacleProgress;
        if (blocksByrighttentacle) {
            if (this.RightTentacleProgress < 10F)
                this.RightTentacleProgress++;
        } else {
            if (this.RightTentacleProgress > 0F)
                this.RightTentacleProgress--;
        }
        if (blocksBylefttentacle) {
            if (this.LeftTentacleProgress < 10F)
                this.LeftTentacleProgress++;
        } else {
            if (this.LeftTentacleProgress > 0F)
                this.LeftTentacleProgress--;
        }

        if (tickCount % 10 == 0) {
            blocksByrighttentacle = checkBlocksByTentacle(1,-3)
                    || checkBlocksByTentacle(2,-3)
                    || checkBlocksByTentacle(3,-3)
                    || checkBlocksByTentacle(4,-3)
                    || checkBlocksByTentacle(5,-3);
            blocksBylefttentacle = checkBlocksByTentacle(1,3)
                    || checkBlocksByTentacle(2,3)
                    || checkBlocksByTentacle(3,3)
                    || checkBlocksByTentacle(4,3)
                    || checkBlocksByTentacle(5,3);

        }

        if (this.portalTarget != null && this.portalTarget.getLifespan() < 5) {
            this.portalTarget = null;
        }
        if (teleportPos != null) {
            this.setPos(teleportPos.x, teleportPos.y, teleportPos.z);
            teleportPos = null;
        }
        if (makePortalCooldown > 0) {
            makePortalCooldown--;
        }

        if (hunting_cooldown > 0) {
            hunting_cooldown--;
        }

        if (bite_cooldown > 0) {
            bite_cooldown--;
        }

        if (melee_cooldown > 0) {
            melee_cooldown--;
        }


        if (!this.isNoAi()) {
            if (this.getAnimation() == NO_ANIMATION && !this.getMeltDown() && this.isMeltDown() && this.isAlive()) {
                this.setAnimation(LEVIATHAN_PHASE2);
            }
            if(this.getAnimation() == NO_ANIMATION &&  this.getTarget() !=null) {
                if (Math.abs(xo - this.getX()) < 0.01F && Math.abs(yo - this.getY()) < 0.01F && Math.abs(zo - this.getZ()) < 0.01F) {
                    waterstillTicks++;
                } else {
                    waterstillTicks = 0;
                }
                if (waterstillTicks > 40 && makePortalCooldown == 0) {
                    createStuckPortal();
                }
            }
            if (!this.level().isClientSide) {
                if (this.destroyBlocksTick > 0) {
                    --this.destroyBlocksTick;
                    if (this.destroyBlocksTick == 0){
                        if(CMConfig.LeviathanBlockBreaking){
                            blockbreak(0.5D,0.5D,0.5D);
                        }else{
                            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                                blockbreak(0.5D,0.5D,0.5D);
                            }
                        }
                    }
                }
                if(mode ==AttackMode.MELEE) {
                    if (CMConfig.LeviathanBlockBreaking) {
                        blockbreak2();
                    } else {
                        if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                            blockbreak2();
                        }
                    }
                }
            }
            final float f17 = this.getYRot() * (float) Math.PI / 180.0F;
            final float pitch = this.getXRot() * (float) Math.PI / 180.0F;
            final float f3 = Mth.sin(f17) * (1 - Math.abs(this.getXRot() / 90F));
            final float f18 = Mth.cos(f17) * (1 - Math.abs(this.getXRot() / 90F));
            this.setPartPosition(this.headPart, f3 * -3.8F, -pitch * 3F, -f18 * -3.8F);
            this.setPartPosition(this.tailPart1, f3 * 3.3F, -pitch * -5F, -f18 * 3.3F);
            this.setPartPosition(this.tailPart2, f3 * 4.7F, -pitch * -8F, -f18 * 4.7F);
            Vec3[] avector3d = new Vec3[this.leviathanParts.length];
            for (int j = 0; j < this.leviathanParts.length; ++j) {
                avector3d[j] = new Vec3(this.leviathanParts[j].getX(), this.leviathanParts[j].getY(), this.leviathanParts[j].getZ());
            }
            for (int l = 0; l < this.leviathanParts.length; ++l) {
                this.leviathanParts[l].xo = avector3d[l].x;
                this.leviathanParts[l].yo = avector3d[l].y;
                this.leviathanParts[l].zo = avector3d[l].z;
                this.leviathanParts[l].xOld = avector3d[l].x;
                this.leviathanParts[l].yOld = avector3d[l].y;
                this.leviathanParts[l].zOld = avector3d[l].z;
            }

        }
    }

    public void aiStep() {
        super.aiStep();
        Vec3 motion;


        final float yaw = this.getYRot() * (float) Math.PI / 180.0F;
        final float pitch = this.getXRot() * (float) Math.PI / 180.0F;
        final float fx = Mth.sin(yaw) * (1 - Math.abs(this.getXRot() / 90F));
        final float fz = Mth.cos(yaw) * (1 - Math.abs(this.getXRot() / 90F));


        if(this.getAnimation() == LEVIATHAN_ABYSS_BLAST){
            if(this.getAnimationTick() < 30){
                if (this.level().isClientSide) {
                    for (int i = 0; i < 20; ++i) {
                        float f = -Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(this.getXRot() * ((float)Math.PI / 180F));
                        float f2 = -Mth.sin(this.getXRot() * ((float)Math.PI / 180F));
                        float f3 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(this.getXRot() * ((float)Math.PI / 180F));
                        this.level().addParticle(ParticleTypes.PORTAL, this.getX() + f * 4.0,this.getY() + f2 * 3.5, this.getZ() + f3 * 4.0, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
                    }
                }
            }

            if (this.getAnimationTick() >= 82) {
                this.setXRot(this.xRotO);
            }

            if(this.getAnimationTick() == 84){
                if(this.getMeltDown()){
                    for(int i = 0; i < 3; ++i) {
                        motion = new Vec3(0.5, -1.25, 0.5).yRot(-(float)(120 * i) * 0.01745329251F);

                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }

                    for(int i = 0; i < 6; ++i) {
                        motion = new Vec3(1.0, 0.0, 1.0).yRot(-(float)(60 * i) * 0.01745329251F);
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }

                    for(int i = 0; i < 3; ++i) {
                        motion = new Vec3(0.5, 1.25, 0.5).yRot(-(float)(120 * i) * 0.01745329251F);
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                }
            }

            for (int i = 44, j = 0; i <= 84; i++, j++) {
                float l = j * 0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            for (int i = 144, j = 1; i <= 184; i++, j++) {
                float l = j * -0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            if(this.getAnimationTick() == 84 ) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.1f, 90, 10);
            }
        }
        if(this.getAnimation() == LEVIATHAN_ABYSS_BLAST_FIRE){
            if(this.getAnimationTick() < 30){
                if (this.level().isClientSide) {
                    for (int i = 0; i < 20; ++i) {
                        float f = -Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(this.getXRot() * ((float)Math.PI / 180F));
                        float f2 = -Mth.sin(this.getXRot() * ((float)Math.PI / 180F));
                        float f3 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(this.getXRot() * ((float)Math.PI / 180F));
                        this.level().addParticle(ParticleTypes.PORTAL, this.getX() + f * 4.0,this.getY() + f2 * 3.5, this.getZ() + f3 * 4.0, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
                    }
                }
            }

            if (this.getAnimationTick() == 84 || this.getAnimationTick() == 129 || this.getAnimationTick() == 174) {
                this.level().playSound((Player) null, this, ModSounds.ABYSS_BLAST_ONLY_SHOOT.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
            }


            if (this.getAnimationTick() >= 80 && this.getAnimationTick() <= 118
                    || this.getAnimationTick() >= 125 && this.getAnimationTick() <= 163
                    || this.getAnimationTick() >= 170 && this.getAnimationTick() <= 198) {
                this.setXRot(this.xRotO);
            }

            for (int i = 44, j = 0; i <= 84; i++, j++) {
                float l = j * 0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            for (int i = 176, j = 1; i <= 216; i++, j++) {
                float l = j * -0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            if(this.getAnimationTick() == 84 || this.getAnimationTick() == 129 || this.getAnimationTick() == 174 ) {
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.1f, 20, 10);
            }
        }

        if(this.getAnimation() == LEVIATHAN_RUSH){
            if (this.getAnimationTick() > 54 && this.getAnimationTick() < 137) {
                chargeDamage();
                if (!this.level().isClientSide) {
                    if(CMConfig.LeviathanBlockBreaking) {
                        chargeblockbreaking();
                    }else{
                        if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                            chargeblockbreaking();
                        }
                    }
                }

            }

            if (this.getAnimationTick() == 54) {
                this.level().playSound((Player) null, this, ModSounds.LEVIATHAN_ROAR.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,13);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.1f, 60, 10);
                roarDarkness(48,48,48,48,20);
            }
            if (this.getAnimationTick() == 57) {
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,14);
            }

            if (this.getAnimationTick() == 60) {
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,15);
            }
        }
        if(this.getAnimation() == LEVIATHAN_GRAB_BITE){
            if (this.getAnimationTick() == 2) {
                // charge();
                biteattack(6.5f,1.5,1.5,1.5,100);
            }
        }

        if(this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_UPPER_R){
            Tentacleattack(24,9,2,2,2);
        }
        if(this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_LOWER_R){
            Tentacleattack(28,9,2, 2,2);

        }
        if(this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_UPPER_L){
            Tentacleattack(26,9,2, 2,2);

        }
        if(this.getAnimation() == LEVIATHAN_TENTACLE_STRIKE_LOWER_L){
            Tentacleattack(21,9,2, 2,2);
        }

        if(this.getAnimation() == LEVIATHAN_STUN){
            if (this.getAnimationTick() == 52) {
                this.level().playSound((Player) null, this, ModSounds.LEVIATHAN_STUN_ROAR.get(), SoundSource.HOSTILE, 4.0f, 0.8f);
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,8);

                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.1f, 40, 10);
                if(this.getMeltDown()) {
                    for (int i = 0; i < 3; ++i) {
                        motion = new Vec3(0.5, -1.25, 0.5).yRot(-(float) (120 * i) * 0.01745329251F);

                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                    for (int i = 0; i < 6; ++i) {
                        motion = new Vec3(1.0, 0.0, 1.0).yRot(-(float) (60 * i) * 0.01745329251F);
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                    for (int i = 0; i < 3; ++i) {
                        motion = new Vec3(0.5, 1.25, 0.5).yRot(-(float) (120 * i) * 0.01745329251F);
                        this.shootAbyssOrb(motion.x, motion.y, motion.z);
                    }
                }
            }
            if (this.getAnimationTick() == 55) {
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,9);

            }
        }

        if(this.getAnimation() == LEVIATHAN_ABYSS_BLAST_PORTAL){
            if (this.getAnimationTick() == 56) {
                this.level().playSound((Player) null, this, ModSounds.LEVIATHAN_ROAR.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.1f, 60, 10);
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,13);

                roarDarkness(48,48,48,48,80);
            }
            if (this.getAnimationTick() == 59) {
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,14);

            }
            if (this.getAnimationTick() == 62) {
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,15);
            }
            for (int i = 16, j = 0; i <= 56; i++, j++) {
                float l = j * 0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            for (int i = 102, j = 1; i <= 142; i++, j++) {
                float l = j * -0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
        }
        SwingParticles();

        if(this.getAnimation() == LEVIATHAN_TAIL_WHIPS){
            if (this.getAnimationTick() == 18) {
                TailWhips();
            }
        }

        if(this.getAnimation() == LEVIATHAN_BREAK_DIMENSION) {
            if (this.getAnimationTick() == 24) {
                this.level().playSound((Player) null, this, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.HOSTILE, 1.0f, 1.0f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.05f, 10, 10);
            }
            if (this.getAnimationTick() == 62) {
                this.level().playSound((Player) null, this, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.HOSTILE, 2.0f, 1.1f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.1f, 10, 10);
                for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(15))) {
                    if (entity instanceof Dimensional_Rift_Entity rift) {
                        if (rift.getStage() < 4) {
                            rift.setStage(rift.getStage() + 1);
                        }
                    }
                }
            }

            if (this.getAnimationTick() == 94) {
                this.level().playSound((Player) null, this, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.HOSTILE, 3.0f, 1.2f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.15f, 10, 10);
                for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(15))) {
                    if (entity instanceof Dimensional_Rift_Entity rift) {
                        if (rift.getStage() < 4) {
                            rift.setStage(rift.getStage() + 1);
                        }
                    }
                }
            }

            if (this.getAnimationTick() == 126) {
                this.level().playSound((Player) null, this, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.HOSTILE, 3.0f, 1.3f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.2f, 10, 10);
                for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(15))) {
                    if (entity instanceof Dimensional_Rift_Entity rift) {
                        if (rift.getStage() < 4) {
                            rift.setStage(rift.getStage() + 1);
                        }
                    }
                }
            }
        }
        if(this.getAnimation() == LEVIATHAN_BITE){
            if (this.getAnimationTick() == 11) {
                // charge();
                this.level().playSound((Player) null, this, ModSounds.LEVIATHAN_BITE.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            if (this.getAnimationTick() == 13) {
                // charge();
                biteattack(6.0f,1.5,1.5,1.5,100);
            }
        }

        if(this.getAnimation() == LEVIATHAN_PHASE2){
            if (this.getAnimationTick() == 1) {
                if (!level().isClientSide && getBossMusic() != null) {
                    Cataclysm.NETWORK_WRAPPER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> this), new MessageMusic(this.getId(), false));
                }
            }


            if (this.getAnimationTick() == 90) {
                if(!this.getMeltDown()) {
                    setMeltDown(true);
                }
                if (!level().isClientSide && getBossMusic() != null) {
                    Cataclysm.NETWORK_WRAPPER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> this), new MessageMusic(this.getId(), true));
                }
                for(int i = 0; i < 3; ++i) {
                    motion = new Vec3(0.5, -1.25, 0.5).yRot(-(float)(120 * i) * 0.01745329251F);

                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                for(int i = 0; i < 6; ++i) {
                    motion = new Vec3(1.0, -0.75, 1.0).yRot(-(float)(60 * i) * 0.01745329251F);
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                for(int i = 0; i < 6; ++i) {
                    motion = new Vec3(1.0, 0.0, 1.0).yRot(-(float)(60 * i) * 0.01745329251F);
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                for(int i = 0; i < 6; ++i) {
                    motion = new Vec3(1.0, 0.75, 1.0).yRot(-(float)(60 * i) * 0.01745329251F);
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                for(int i = 0; i < 3; ++i) {
                    motion = new Vec3(0.5, 1.25, 0.5).yRot(-(float)(120 * i) * 0.01745329251F);
                    this.shootAbyssOrb(motion.x, motion.y, motion.z);
                }

                this.level().playSound((Player) null, this, ModSounds.LEVIATHAN_STUN_ROAR.get(), SoundSource.HOSTILE, 3.0f, 0.8f);
                ScreenShake_Entity.ScreenShake(this.level(), this.position(), 30, 0.1f, 40, 10);
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,13);

            }
            if (this.getAnimationTick() == 93) {
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,14);
            }
            if (this.getAnimationTick() == 96) {
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,1.2F,15);
            }
        }
        if(this.getAnimation() == LEVIATHAN_TENTACLE_HOLD){
            if (this.getAnimationTick() == 32) {
                TentacleHoldattack(7,2.5, 2.5,2.5,80);
            }
        }

        if(this.getAnimation() == LEVIATHAN_TENTACLE_HOLD_BLAST) {
            for (int i = 44, j = 0; i <= 84; i++, j++) {
                float l = j * 0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
            for (int i = 149, j = 1; i <= 189; i++, j++) {
                float l = j * -0.025f;
                if (this.getAnimationTick() == i) {
                    LayerBrightness = l;
                }
            }
        }

        if(this.getAnimation() == LEVIATHAN_MINE){
            if (this.getAnimationTick() == 28) {
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,0.9F,8);
            }
            if (this.getAnimationTick() == 31) {
                // charge();
                this.level().playSound((Player) null, this, ModSounds.LEVIATHAN_STUN_ROAR.get(), SoundSource.HOSTILE, 3.0f, 0.8f);
                RoarParticle(this.getX() +fx * -4F, this.getY() -pitch * 3F, this.getZ() -fz * -4F,60, 102, 26, 204, 0.9f,1,0.9F,9);
            }
        }
    }


    private void RoarParticle(double x,double y,double z,int duration, int r, int g, int b, float a,float start,float inc,float end) {
        if (this.level().isClientSide) {
            this.level().addParticle(new RoarParticle.RoarData(duration, r, g, b, a, start,inc,end), x, y, z, 0, 0, 0);
        }
    }

    private void roarDarkness(double x, double y,double z, double radius,int time) {
        List<LivingEntity> entities = getEntityLivingBaseNearby(x, y, z, radius);
        if (!this.level().isClientSide) {
            for (LivingEntity inRange : entities) {
                if (inRange instanceof Player && ((Player) inRange).getAbilities().invulnerable) continue;
                if (isAlliedTo(inRange)) continue;
                inRange.addEffect(new MobEffectInstance(MobEffects.DARKNESS, time));
            }
        }
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        if (living != null) {
            CMWorldData worldData = CMWorldData.get(level(),Level.OVERWORLD);
            if (worldData != null) {
                boolean prev = worldData.isLeviathanDefeatedOnce();
                if (!prev) {
                    worldData.setLeviathanDefeatedOnce(true);
                    if (level() instanceof ServerLevel serverLevel) {
                        serverLevel.getPlayers(EntitySelector.NO_SPECTATORS).forEach(serverPlayer -> serverPlayer.displayClientMessage(Component.translatable("entity.cataclysm.the_leviathan.defeat_message").withStyle(ChatFormatting.DARK_PURPLE), true));
                    }
                }
            }
        }
    }

    private void TailWhips() {
        if (!this.level().isClientSide) {
            for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0D, 7.0D, 7.0D))) {
                if (!isAlliedTo(entity) && !(entity instanceof The_Leviathan_Entity) && entity != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = entity.hurt(damagesource, (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), entity.getMaxHealth() * CMConfig.LeviathanTailSwingHpdamage)));

                    if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player) {
                        disableShield(player, 120);
                    }


                    if (flag) {
                        launch(entity, true);
                        entity.addEffect(new MobEffectInstance(ModEffect.EFFECTBONE_FRACTURE.get(), 200));

                    }
                }
            }
        }
    }

    private void Sphereparticle(float height, float vec, float size) {
        if (this.level().isClientSide) {
            if (this.tickCount % 2 == 0) {
                double d0 = this.getX();
                double d1 = this.getY() + height;
                double d2 = this.getZ();
                double theta = (yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                for (float i = -size; i <= size; ++i) {
                    for (float j = -size; j <= size; ++j) {
                        for (float k = -size; k <= size; ++k) {
                            double d3 = (double) j + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d4 = (double) i + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d5 = (double) k + (this.random.nextDouble() - this.random.nextDouble()) * 0.5D;
                            double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + this.random.nextGaussian() * 0.05D;

                            this.level().addParticle(ParticleTypes.REVERSE_PORTAL, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isMeltDown() {
        return this.getHealth() <= this.getMaxHealth() / 2.0F;
    }

    public void shootAbyssOrb(double xMotion, double yMotion, double zMotion) {
        if(getTarget() != null) {
            Abyss_Orb_Entity fireball = new Abyss_Orb_Entity(this, xMotion, yMotion, zMotion, this.level(), (float) CMConfig.AbyssOrbdamage,this.getTarget());
            fireball.setPos(fireball.getX(), this.getEyeY(), fireball.getZ());
            fireball.setUp(40);
            if (!this.level().isClientSide) {
                this.level().addFreshEntity(fireball);
            }
        }else{
            Abyss_Orb_Entity fireball = new Abyss_Orb_Entity(this, xMotion, yMotion, zMotion, this.level(), (float) CMConfig.AbyssOrbdamage,null);
            fireball.setPos(fireball.getX(), this.getEyeY(), fireball.getZ());
            fireball.setUp(40);
            if (!this.level().isClientSide) {
                this.level().addFreshEntity(fireball);
            }
        }
    }

    private void launch(Entity e, boolean huge) {
        double d0 = e.getX() - this.getX();
        double d1 = e.getZ() - this.getZ();
        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
        float f = huge ? 10F : 5F;
        e.push(d0 / d2 * f, huge ? 1.0D : 0.2F, d1 / d2 * f);
    }


    private void Tailswing() {
        Vec3 bladePos = socketPosArray[0];
        double length = prevTailPos.subtract(bladePos).length();
        int numClouds = (int) Math.floor(2 * length);
        for (int i = 0; i < numClouds; i++) {
            double x = prevTailPos.x + i * (bladePos.x - prevTailPos.x) / numClouds;
            double y = prevTailPos.y + i * (bladePos.y - prevTailPos.y) / numClouds;
            double z = prevTailPos.z + i * (bladePos.z - prevTailPos.z) / numClouds;

            ParticleOptions type =  ParticleTypes.EXPLOSION;
            level().addParticle(type, x, y, z, 0, 0, 0);
        }
    }

    private void SwingParticles() {
        if (level().isClientSide) {
            Vec3 bladePos = socketPosArray[0];
            if (this.getAnimation() == LEVIATHAN_TAIL_WHIPS) {
                if (this.getAnimationTick() >= 10 && this.getAnimationTick() <= 34) {
                    Tailswing();
                }
            }
            prevTailPos = bladePos;
        }
    }



    private void blockbreak(double x, double y, double z) {
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(x, y, z);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.LEVIATHAN_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                flag = this.level().destroyBlock(blockpos, false, this) || flag;
            }
        }
    }


    private void blockbreak2() {
        if (this.blockBreakCounter > 0) {
            --this.blockBreakCounter;
            return;
        }
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(0.2D);
        for (BlockPos pos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = level().getBlockState(pos);
            if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), pos, this) && !blockstate.is(ModTag.LEVIATHAN_IMMUNE)) {
                if (random.nextInt(5) == 0 && !blockstate.hasBlockEntity()) {
                    Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, blockstate, 20);
                    flag = this.level().destroyBlock(pos, false, this) || flag;
                    fallingBlockEntity.setDeltaMovement(fallingBlockEntity.getDeltaMovement().add(this.position().subtract(fallingBlockEntity.position()).multiply((-1.2D + random.nextDouble()) / 3, 0.2D + getRandom().nextGaussian() * 0.15D, (-1.2D + random.nextDouble()) / 3)));
                    level().addFreshEntity(fallingBlockEntity);
                } else {
                    flag = this.level().destroyBlock(pos, false, this) || flag;
                    this.setDeltaMovement(this.getDeltaMovement().multiply(0.6F, 1, 0.6F));
                }

            }
        }
        if (flag) {
            blockBreakCounter = 10;
        }
    }

    private void chargeblockbreaking() {
        boolean flag = false;
        AABB aabb = this.getBoundingBox().inflate(4.5D, 0.5D, 4.5D);
        double yblockbreak = this.isInWater() ? aabb.minY : this.getY();
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(yblockbreak), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.LEVIATHAN_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                flag = this.level().destroyBlock(blockpos, false, this) || flag;
            }
        }
    }

    private void chargeDamage(){
        if (this.tickCount % 4 == 0) {
            for (LivingEntity Lentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3D))) {
                if (!isAlliedTo(Lentity) && !(Lentity instanceof The_Leviathan_Entity) && Lentity != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = Lentity.hurt(damagesource,  (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), Lentity.getMaxHealth() * CMConfig.LeviathanRushHpdamage)));
                    if (Lentity instanceof Player player && Lentity.isDamageSourceBlocked(damagesource)) {
                        disableShield(player, 120);
                    }


                    if (flag) {
                        if (Lentity.onGround()) {
                            double d0 = Lentity.getX() - this.getX();
                            double d1 = Lentity.getZ() - this.getZ();
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                            float f = 1.5F;
                            Lentity.push(d0 / d2 * f, 0.5F, d1 / d2 * f);
                        }
                    }
                }
            }
        }
    }


    private void biteattack(float radius , double inflateX, double inflateY, double inflateZ,int stuntick) {
        double renderYaw = (this.yHeadRot +90) * Math.PI / 180.0d;
        double renderPitch = (float) (-this.getXRot() * Math.PI / 180.0d);

        endPosX = getX() + radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        endPosZ = getZ() + radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        endPosY = getY() + radius * Math.sin(renderPitch);
        if (!level().isClientSide) {
            List<LivingEntity> hit = raytraceEntities(level(), inflateX, inflateY,inflateZ, new Vec3(getX(), getY(), getZ()), new Vec3(endPosX, endPosY, endPosZ) ).entities;
            for (LivingEntity target : hit) {
                if (!isAlliedTo(target) && !(target instanceof The_Leviathan_Entity) && target != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = target.hurt(damagesource, (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5 + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5, target.getMaxHealth() * CMConfig.LeviathanbiteHpdamage)));
                    if (target instanceof Player player && target.isDamageSourceBlocked(damagesource)) {
                        disableShield(player, 200);
                    }


                    if(flag){
                        if (stuntick > 0) {
                            target.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), stuntick));
                        }
                    }

                }
            }
        }
    }


    private void Tentacleattack(int anime, float radius, double inflateX, double inflateY, double inflateZ) {
        double renderYaw = (this.yHeadRot +90) * Math.PI / 180.0d;
        double renderPitch = (float) (-this.getXRot() * Math.PI / 180.0d);
        endPosX = getX() + radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        endPosZ = getZ() + radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        endPosY = getY() + radius * Math.sin(renderPitch);
        if(this.getAnimationTick() == anime){
            this.playSound(ModSounds.LEVIATHAN_TENTACLE_STRIKE.get(), 1.0F, 1.0F);

            List<LivingEntity> hit = raytraceEntities(level(), inflateX, inflateY,inflateZ, new Vec3(getX(), getY(), getZ()), new Vec3(endPosX, endPosY, endPosZ)).entities;
            if (!this.level().isClientSide) {
                for (LivingEntity target : hit) {
                    if (!isAlliedTo(target) && !(target instanceof The_Leviathan_Entity) && target != this) {
                        DamageSource damagesource = this.damageSources().mobAttack(this);
                        boolean flag = target.hurt(damagesource, (float) ((float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + Math.min(this.getAttributeValue(Attributes.ATTACK_DAMAGE), target.getMaxHealth() * CMConfig.LeviathanTentacleHpdamage)));
                        if (target instanceof Player player && target.isDamageSourceBlocked(damagesource)) {
                            disableShield(player, 90);
                        }

                        if (flag) {
                            double d0 = target.getX() - this.getX();
                            double d1 = target.getZ() - this.getZ();
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                            target.push(d0 / d2 * 7.0D, 0.2D, d1 / d2 * 7.0D);
                        }
                    }
                }
            }

        }
    }


    private void TentacleHoldattack(float radius, double inflateX, double inflateY, double inflateZ, int shieldbreakticks) {
        double renderYaw = (this.yHeadRot +90) * Math.PI / 180.0d;
        double renderPitch = (float) (-this.getXRot() * Math.PI / 180.0d);

        endPosX = getX() + radius * Math.cos(renderYaw) * Math.cos(renderPitch);
        endPosZ = getZ() + radius * Math.sin(renderYaw) * Math.cos(renderPitch);
        endPosY = getY() + radius * Math.sin(renderPitch);

        List<LivingEntity> hit = raytraceEntities(level(), inflateX, inflateY, inflateZ, new Vec3(getX(), getY(), getZ()), new Vec3(endPosX, endPosY, endPosZ)).entities;
        if (!this.level().isClientSide) {
            for (LivingEntity target : hit) {
                if (!isAlliedTo(target) && !(target instanceof The_Leviathan_Entity) && target != this) {
                    DamageSource damagesource = this.damageSources().mobAttack(this);
                    boolean flag = target.hurt(damagesource, (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) + target.getMaxHealth() * 0.1f);
                    if (target instanceof Player player && target.isDamageSourceBlocked(damagesource) && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }

                    if (flag && !target.getType().is(ModTag.IGNIS_CANT_POKE) && target.isAlive()) {
                        if (target.isShiftKeyDown()) {
                            target.setShiftKeyDown(false);
                        }

                            target.startRiding(this, true);


                        AnimationHandler.INSTANCE.sendAnimationMessage(this, LEVIATHAN_TENTACLE_HOLD_BLAST);
                    }
                }
            }

        }

    }


    public void positionRider(Entity passenger, Entity.MoveFunction moveFunc) {
        if (hasPassenger(passenger)) {
            if (this.getAnimation() == LEVIATHAN_TENTACLE_HOLD_BLAST) {
                if (this.getAnimationTick() == 169) {
                    passenger.stopRiding();
                    //passenger.push(f1 * 2.5, 0.8, f2 * 2.5);
                }
            }
            this.setXRot(this.xRotO);
            this.yBodyRot = this.getYRot();
            this.yHeadRot = this.getYRot();
            final float f17 = this.getYRot() * (float) Math.PI / 180.0F;
            final float pitch = this.getXRot() * (float) Math.PI / 180.0F;
            final float f3 = Mth.sin(f17) * (1 - Math.abs(this.getXRot() / 90F));
            final float f18 = Mth.cos(f17) * (1 - Math.abs(this.getXRot() / 90F));
            moveFunc.accept(passenger,this.getX() + f3 * -8.25F, this.getY() + -pitch * 6F, this.getZ() + -f18 * -8.25F);

        }
    }

    public boolean shouldRiderSit() {
        return false;
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    protected boolean canRide(Entity p_31508_) {
        return false;
    }

    public boolean canBeAffected(MobEffectInstance p_31495_) {
        return p_31495_.getEffect() != ModEffect.EFFECTABYSSAL_BURN.get()
                && super.canBeAffected(p_31495_);
    }

    private BiteHitResult raytraceEntities(Level world, double inflateX, double inflateY, double inflateZ,Vec3 from, Vec3 to) {
        BiteHitResult result = new BiteHitResult();
        collidePosX = endPosX;
        collidePosY = endPosY;
        collidePosZ = endPosZ;

        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).inflate(inflateX, inflateY, inflateZ));
        for (LivingEntity entity : entities) {
            float pad = 2.5f;
            AABB aabb = entity.getBoundingBox().inflate(pad, pad, pad);
            Optional<Vec3> hit = aabb.clip(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
            } else if (hit.isPresent()) {
                result.addEntityHit(entity);
            }
        }
        return result;
    }


    public static class BiteHitResult {
        private final List<LivingEntity> entities = new ArrayList<>();

        public void addEntityHit(LivingEntity entity) {
            entities.add(entity);
        }
    }

    protected int increaseAirSupply(int currentAir) {
        return this.getMaxAirSupply();
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return sizeIn.height * 0.45F;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }



    public boolean isPushedByFluid() {
        return false;
    }

    public MobType getMobType() {
        return MobType.WATER;
    }


    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("BlastChance", this.getBlastChance());
        compound.putBoolean("MeltDown", this.getMeltDown());
        compound.putInt("ModeChance", this.getModeChance());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setBlastChance(compound.getInt("BlastChance"));
        this.setModeChance(compound.getInt("ModeChance"));
        this.setMeltDown(compound.getBoolean("MeltDown"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    public boolean getMeltDown() {
        return this.entityData.get(MELT_DOWN);
    }

    public void setMeltDown(boolean chance) {
        this.entityData.set(MELT_DOWN, chance);
    }

    public int getBlastChance() {
        return this.entityData.get(BLAST_CHANCE);
    }

    public void setBlastChance(int chance) {
        this.entityData.set(BLAST_CHANCE, chance);
    }

    public int getModeChance() {
        return this.entityData.get(MODE_CHANCE);
    }

    public void setModeChance(int chance) {
        this.entityData.set(MODE_CHANCE, chance);
    }


    @Nullable
    public UUID getTongueUUID() {
        return this.entityData.get(TONGUE_UUID).orElse(null);
    }

    public void setTongueUUID(@Nullable UUID uniqueId) {
        this.entityData.set(TONGUE_UUID, Optional.ofNullable(uniqueId));
    }

    public Entity getTongue() {
        if (!level().isClientSide) {
            UUID id = getTongueUUID();
            return id == null ? null : ((ServerLevel) level()).getEntity(id);
        } else {
            int id = this.entityData.get(TONGUE_ID);
            return id == -1 ? null : level().getEntity(id);
        }
    }

    public void createStuckPortal() {
        if (this.getTarget() != null) {
            Vec3 to = new Vec3(this.getTarget().getX(), this.getTarget().getY(), this.getTarget().getZ());
            this.createPortal2(this.getX() , this.getY() + 0.1,this.getZ(), to);
        }
    }


    public void createPortal2(double x, double y, double z, Vec3 to) {
        if (!level().isClientSide && portalTarget == null) {
            Abyss_Portal_Entity portal = ModEntities.ABYSS_PORTAL.get().create(level());
            portal.setPos(x, y, z);
            portal.setLifespan(10000);
            portal.setEntrance(true);
            if (!level().isClientSide) {
                level().addFreshEntity(portal);
            }
            portalTarget = portal;
            portal.setDestination(BlockPos.containing(to.x, to.y, to.z));
            makePortalCooldown = 300;
        }
    }

    public void resetPortalLogic() {
        portalTarget = null;
    }

    public void teleportTo(Vec3 vec) {
        teleportPos = vec;
        fullyThrough = false;

    }

    private boolean checkBlocksByTentacle(float vec, float math) {
        BlockPos pos1;

        double theta = (yBodyRot) * (Math.PI / 180);
        float f = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) ;
        float f1 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) ;
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        pos1 = new BlockPos(Mth.floor(getX() + vec * vecX + f * math), Math.round((float) (getY() - 2)), Mth.floor(getZ() + vec * vecZ + f1 * math));
        return level().getBlockState(pos1).blocksMotion();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }


    @Override
    public boolean shouldEnterWater() {
        return true;
    }

    @Override
    public boolean shouldLeaveWater() {
        return false;
    }

    @Override
    public boolean shouldStopMoving() {
        return false;
    }

    @Override
    public int getWaterSearchRange() {
        return 32;
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.LEVIATHAN_IDLE.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.LEVIATHAN_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.LEVIATHAN_DEFEAT.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return this.getMeltDown() ? ModSounds.LEVIATHAN_MUSIC_2.get() : ModSounds.LEVIATHAN_MUSIC_1.get();
    }

    @Override
    protected boolean canPlayMusic() {
        if (this.getAnimation() == LEVIATHAN_PHASE2 ){
            return getAnimationTick() > 90 &&  super.canPlayMusic();
        }else{
            return super.canPlayMusic();
        }
    }

    @Nullable
    public Animation getDeathAnimation()
    {
        return LEVIATHAN_DEATH;
    }

    protected float getSoundVolume() {
        return isSilent() ? 0 : 2;
    }

    private void setPartPosition(The_Leviathan_Part part, double offsetX, double offsetY, double offsetZ) {
        part.setPos(this.getX() + offsetX * part.scale, this.getY() + offsetY * part.scale, this.getZ() + offsetZ * part.scale);
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.leviathanParts;
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        Cm_Part_Entity.assignPartIDs(this);
    }

    public Vec3 getTonguePosition() {
        float f1 = -Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(this.getXRot() * ((float)Math.PI / 180F));
        float f2 = -Mth.sin(this.getXRot() * ((float)Math.PI / 180F));
        float f3 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(this.getXRot() * ((float)Math.PI / 180F));
        return new Vec3(this.getX() + f1 * 3.0, this.getY() + f2 * 3.5, this.getZ() + f3 * 3.0);

    }

    private enum AttackMode {
        CIRCLE,
        MELEE,
        RANGE
    }

    static class LeviathanGrabAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanGrabAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = false;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanCrackDimension = true;
            entity.CanMine = true;
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = GRAB_HUNTING_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            entity.setModeChance(entity.getModeChance() +1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            Entity weapon = entity.getTongue();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            if (entity.getAnimationTick() == 25) {
                if (target != null) {
                    if (entity.getTongue() == null) {
                        if (!entity.level().isClientSide) {
                            The_Leviathan_Tongue_Entity segment = ModEntities.THE_LEVIATHAN_TONGUE.get().create(this.entity.level());
                            segment.copyPosition(this.entity);
                            segment.setPos(entity.getTonguePosition());
                            segment.setControllerUUID(entity.getUUID());
                            segment.setMaxDuration(120);
                            entity.setTongueUUID(segment.getUUID());
                            this.entity.level().addFreshEntity(segment);
                        }
                    }
                }
            }
            if (this.entity.getAnimationTick() > 25 && this.entity.getAnimationTick() <= 145) {
                if (target != null && target.isAlive()) {
                    if (this.entity.distanceTo(target) < 8.5F) {
                        if (weapon instanceof The_Leviathan_Tongue_Entity magneticWeapon) {
                            if(magneticWeapon.getComingBack()) {
                                magneticWeapon.remove(RemovalReason.DISCARDED);
                            }
                        }
                        AnimationHandler.INSTANCE.sendAnimationMessage(this.entity, LEVIATHAN_GRAB_BITE);
                    }

                }
            }

            if (this.entity.getAnimationTick() > 155) {
                if (weapon instanceof The_Leviathan_Tongue_Entity magneticWeapon) {
                    magneticWeapon.remove(RemovalReason.DISCARDED);
                }
            }

        }
    }

    static class LeviathanGrabBiteAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanGrabBiteAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            entity.level().playSound((Player) null, entity, ModSounds.LEVIATHAN_BITE.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            entity.setYRot(entity.yRotO);
        }
        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = GRAB_HUNTING_COOLDOWN;
        }
    }

    static class LeviathanBiteAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanBiteAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = false;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanCrackDimension = true;
            entity.CanMine = true;
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() < 13 && target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
        }
        public void stop() {
            super.stop();
            entity.hunting_cooldown = BITE_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 30);
            }
            entity.setModeChance(entity.getModeChance() - 1);

        }
    }

    static class LeviathanPhase2Goal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanPhase2Goal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            super.start();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.getAnimationTick() >= 90 && target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
        }
        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.stop();
        }
    }

    static class LeviathanBlastAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanBlastAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.level().playSound((Player) null, entity, ModSounds.ABYSS_BLAST.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanAbyss_Blast = false;
            entity.CanTailWhips = true;
            entity.CanCrackDimension = true;
            entity.CanMine = true;
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = BLAST_HUNTING_COOLDOWN;
            entity.setBlastChance(0);
            entity.setModeChance(entity.getModeChance() +1);
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                if (this.entity.getAnimationTick() < 82) {
                    entity.getLookControl().setLookAt(target, 30, 90);
                }
            }
            float dir = 90.0f;
            if(this.entity.getAnimationTick() == 64) {
                if(!entity.level().isClientSide) {
                    Abyss_Blast_Entity DeathBeam = new Abyss_Blast_Entity(ModEntities.ABYSS_BLAST.get(), entity.level(), entity, entity.getX(), entity.getY(), entity.getZ(), (float) ((entity.yHeadRot + dir) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 80, dir,(float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage);
                    entity.level().addFreshEntity(DeathBeam);
                }
            }
        }
    }

    static class LeviathanBlastFireAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanBlastFireAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.level().playSound((Player) null, entity, ModSounds.ABYSS_BLAST_ONLY_CHARGE.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanAbyss_Blast = false;
            entity.CanTailWhips = true;
            entity.CanCrackDimension = true;
            entity.CanMine = true;
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = BLAST_HUNTING_COOLDOWN;
            entity.setBlastChance(0);
            entity.setModeChance(entity.getModeChance() +1);
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                if (this.entity.getAnimationTick() < 80
                        || this.entity.getAnimationTick() > 118 && this.entity.getAnimationTick() < 125
                        || this.entity.getAnimationTick() > 163 &&  this.entity.getAnimationTick() < 170) {
                    entity.getLookControl().setLookAt(target, 30, 90);
                }
            }
            float dir = 90.0f;
            if(this.entity.getAnimationTick() == 64 || this.entity.getAnimationTick() == 109 || this.entity.getAnimationTick() == 154) {
                if(!entity.level().isClientSide) {
                    Abyss_Blast_Entity DeathBeam = new Abyss_Blast_Entity(ModEntities.ABYSS_BLAST.get(), entity.level(), entity, entity.getX(), entity.getY(), entity.getZ(), (float) ((entity.yHeadRot + dir) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 28, dir,(float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage);
                    entity.level().addFreshEntity(DeathBeam);
                }
            }
        }
    }

    static class LeviathanTailWhipsAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanTailWhipsAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = false;
            entity.CanBite = true;
            entity.CanMine = true;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 30);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = TAIL_WHIPS_HUNTING_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 30);
            }
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 30);
            }
            entity.setModeChance(entity.getModeChance() -1);
        }
    }


    static class LeviathanRushAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanRushAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }


        public void start() {
            entity.getNavigation().stop();
            super.start();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = false;
            entity.CanBite = true;
            entity.CanAbyss_Blast = true;
            entity.CanCrackDimension = true;
            entity.CanTailWhips = true;
            entity.CanMine = true;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = RUSH_HUNTING_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            entity.setModeChance(entity.getModeChance() +1);
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
                if (this.entity.getAnimationTick() > 53 && this.entity.getAnimationTick() < 134) {
                    final double d0 = target.getX() - entity.getX();
                    final double d1 = target.getEyeY() - entity.getEyeY();
                    final double d2 = target.getZ() - entity.getZ();
                    final double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
                    final float targetYaw = (float) (Mth.atan2(d2, d0) * 180.0F / (float) Math.PI - 90.0F);
                    final float targetPitch = (float) (-(Mth.atan2(d1, d3) * 180.0F / (float) Math.PI));
                    entity.setXRot((entity.getXRot() + Mth.clamp(targetPitch - entity.getXRot(), -2, 2)));
                    if (d0 * d0 + d2 * d2 >= 9) {
                        entity.setYRot((entity.getYRot() + Mth.clamp(targetYaw - entity.getYRot(), -2, 2)));
                        entity.yBodyRot = entity.getYRot();
                    }
                    if (Math.abs(Mth.wrapDegrees(targetYaw) - Mth.wrapDegrees(entity.getYRot())) < 4) {
                        final double distSq = d0 * d0 + d2 * d2;
                        if (distSq < 9) {
                            entity.setYRot(entity.yRotO);
                            entity.yBodyRot = entity.yRotO;
                            entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.8, 1, 0.8));
                        } else {
                            if (entity.isInWater() && target.isInWater()) {
                                final Vec3 vector3d = entity.getDeltaMovement();
                                Vec3 vector3d1 = new Vec3(target.getX() - entity.getX(), target.getY() - entity.getY(), target.getZ() - entity.getZ());
                                if (vector3d1.lengthSqr() > 1.0E-7D) {
                                    vector3d1 = vector3d1.normalize().scale(0.5D).add(vector3d.scale(0.5D));
                                }
                                entity.setDeltaMovement(vector3d1.x, vector3d1.y, vector3d1.z);
                            }
                            entity.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), 1.0D);
                            entity.getNavigation().moveTo(target, 1.0F);
                        }
                    }
                }
            }
        }
    }

    static class LeviathanTentacleAttackGoal extends AnimationGoal<The_Leviathan_Entity> {

        public LeviathanTentacleAttackGoal(The_Leviathan_Entity entity) {
            super(entity);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        protected boolean test(Animation animation) {
            return animation == LEVIATHAN_TENTACLE_STRIKE_UPPER_R
                    || animation == LEVIATHAN_TENTACLE_STRIKE_LOWER_R
                    || animation == LEVIATHAN_TENTACLE_STRIKE_UPPER_L
                    || animation == LEVIATHAN_TENTACLE_STRIKE_LOWER_L;
        }

        public void start() {
            entity.getNavigation().stop();
            super.start();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.stop();
            entity.melee_cooldown = MELEE_COOLDOWN;
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);

            }
        }
    }

    static class LeviathanAbyssBlastPortalAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanAbyssBlastPortalAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = false;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanMine = true;
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = BLAST_PORTAL_HUNTING_COOLDOWN;

            entity.setModeChance(entity.getModeChance() +1);

        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
                double d0 = Math.min(target.getY(), entity.getY()) - 50;
                double d1 = Math.max(target.getY(), entity.getY()) + 3D;
                float f = (float) Mth.atan2(target.getZ() - entity.getZ(), target.getX() - entity.getX());
                if (this.entity.getAnimationTick() == 56) {
                    for (int l = 0; l < 9; ++l) {
                        int j = (int) (5f * l);
                        double randomNearbyX = target.getX() + (entity.random.nextGaussian() * 12.0D);
                        double randomNearbyZ = target.getZ() + (entity.random.nextGaussian() * 12.0D);

                        this.spawnUnderPortal(randomNearbyX, randomNearbyZ, d0, d1, f, j);
                        //this.spawnUpperPortal(randomNearbyX, randomNearbyZ, d1, f, j);

                    }
                }
                if(this.entity.getAnimationTick() == 56 || this.entity.getAnimationTick() == 76 || this.entity.getAnimationTick() == 96) {
                    this.spawnUnderPortal(target.getX(), target.getZ(), d0, d1, f, 0);
                }
            }
        }
        private void spawnUnderPortal(double x, double z, double minY, double maxY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.containing(x, maxY, z);
            boolean flag = false;
            double d0 = 0.0D;

            do {
                BlockPos blockpos1 = blockpos.below();
                BlockState blockstate = entity.level().getBlockState(blockpos1);
                if (blockstate.isFaceSturdy(entity.level(), blockpos1, Direction.UP)) {
                    if (!entity.level().isEmptyBlock(blockpos)) {
                        BlockState blockstate1 = entity.level().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(entity.level(), blockpos);
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
                entity.level().addFreshEntity(new Abyss_Blast_Portal_Entity(entity.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage,entity));
            }
        }

        private void spawnUpperPortal(double x, double z, double maxY, float rotation, int delay) {
            BlockPos blockpos = BlockPos.containing(x, maxY, z);
            boolean flag = false;
            double d0 = 0.0D;

            do {
                BlockPos blockpos1 = blockpos.above();
                BlockState blockstate = entity.level().getBlockState(blockpos1);
                if (blockstate.isFaceSturdy(entity.level(), blockpos1, Direction.DOWN)) {
                    if (!entity.level().isEmptyBlock(blockpos)) {
                        BlockState blockstate1 = entity.level().getBlockState(blockpos);
                        VoxelShape voxelshape = blockstate1.getCollisionShape(entity.level(), blockpos);
                        if (!voxelshape.isEmpty()) {
                            d0 = voxelshape.max(Direction.Axis.Y);
                        }
                    }

                    flag = true;
                    break;
                }

                blockpos = blockpos.above();
            } while (blockpos.getY() < Math.min(entity.level().getMaxBuildHeight(), entity.getBlockY() + 100) && !entity.level().getBlockState(blockpos).isSolid());

            if (flag) {
                entity.level().addFreshEntity(new Abyss_Blast_Portal_Entity(entity.level(), x, (double) blockpos.getY() + d0 + 0.5F, z, rotation, delay,(float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage, entity));
            }
        }
    }



    static class LeviathanAbyssDimensionAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanAbyssDimensionAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanCrackDimension = false;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanBite = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanMine = true;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 0);
            }
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.stop();
            entity.hunting_cooldown = CRACK_HUNTING_COOLDOWN;
            entity.setModeChance(entity.getModeChance() - 1);
        }

        public void tick() {
            if (entity.getAnimationTick() == 24) {
                if (!entity.level().isClientSide ) {
                    double theta = (entity.yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    Dimensional_Rift_Entity portal = new Dimensional_Rift_Entity(entity.level(),
                            entity.getX() + vecX * 12F,
                            entity.getEyeY(),
                            entity.getZ() + vecZ * 12F, entity);
                    portal.setStage(1);
                    portal.setLifespan(600);
                    if (!entity.level().isClientSide) {
                        entity.level().addFreshEntity(portal);
                    }
                }

            }
            Dimensional_Rift_Entity rift = getClosestDimensionalRift();
            if(rift !=null){
                entity.getLookControl().setLookAt(rift, 30, 90);
            }
        }

        private Dimensional_Rift_Entity getClosestDimensionalRift(){
            List<Dimensional_Rift_Entity> list = entity.level().getEntitiesOfClass(Dimensional_Rift_Entity.class, entity.getBoundingBox().inflate(15, 15, 15));
            Dimensional_Rift_Entity closest = null;
            if(!list.isEmpty()){
                for(Dimensional_Rift_Entity entity : list){
                    if((closest == null || closest.distanceTo(entity) > entity.distanceTo(entity))){
                        closest = entity;
                    }
                }
            }
            return closest;
        }
    }

    static class LeviathanTentacleHoldAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanTentacleHoldAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = false;
            entity.CanRush = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanBite = true;
            entity.CanMine = true;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = GRAB_HUNTING_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            entity.setModeChance(entity.getModeChance() -1);
        }
    }

    static class LeviathanTentacleHoldBlastAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanTentacleHoldBlastAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = false;
            entity.CanTailWhips = true;
            entity.CanBite = true;
            entity.CanMine = true;
            entity.level().playSound((Player) null, entity, ModSounds.ABYSS_BLAST.get(), SoundSource.HOSTILE, 4.0f, 1.0f);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = BLAST_HUNTING_COOLDOWN;
            entity.setBlastChance(0);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
        }
        @Override
        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }

            float dir = 90.0f;
            if(this.entity.getAnimationTick() == 64) {
                if(!entity.level().isClientSide) {
                    Abyss_Blast_Entity DeathBeam = new Abyss_Blast_Entity(ModEntities.ABYSS_BLAST.get(), entity.level(), entity, entity.getX(), entity.getY(), entity.getZ(), (float) ((entity.yHeadRot + dir) * Math.PI / 180), (float) (-entity.getXRot() * Math.PI / 180), 80, dir,(float)CMConfig.AbyssBlastdamage,(float)CMConfig.AbyssBlastHpdamage);
                    entity.level().addFreshEntity(DeathBeam);
                }
            }
        }
    }


    static class LeviathanMineAttackGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanMineAttackGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            entity.CanAbyss_Blast_Portal = true;
            entity.CanGrab = true;
            entity.CanRush = true;
            entity.CanCrackDimension = true;
            entity.CanAbyss_Blast = true;
            entity.CanTailWhips = true;
            entity.CanBite = true;
            entity.CanMine = false;
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.start();
        }

        public void stop() {
            super.stop();
            entity.hunting_cooldown = MINE_COOLDOWN;
            entity.setBlastChance(entity.getBlastChance() +1);
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
        }

        public void tick() {
            entity.getNavigation().stop();
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);

                float f = (float) Mth.atan2(target.getZ() - entity.getZ(), target.getX() - entity.getX());
                if (this.entity.getAnimationTick() == 31) {
                    for (int l = 0; l < 35; ++l) {
                        int j = (int) (2f * l);
                        double randomNearbyX = target.getX() + (entity.random.nextGaussian() * 12.0D);
                        double randomNearbyY = target.getY() + (entity.random.nextGaussian() * 8.0D);
                        double randomNearbyZ = target.getZ() + (entity.random.nextGaussian() * 12.0D);

                        this.spawnMines(randomNearbyX,randomNearbyY, randomNearbyZ, f, j);
                    }
                }
            }
            entity.setModeChance(entity.getModeChance() -1);
        }

        private void spawnMines(double x, double y, double z, float rotation, int delay) {
            Abyss_Mine_Entity mine = new Abyss_Mine_Entity(entity.level(), x, y, z, rotation, delay, entity);
            if (mine.level().noCollision(mine)) {
                entity.level().addFreshEntity(mine);
            }

        }
    }

    static class LeviathanStunGoal extends SimpleAnimationGoal<The_Leviathan_Entity> {

        public LeviathanStunGoal(The_Leviathan_Entity entity, Animation animation) {
            super(entity, animation);
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        public void start() {
            entity.getNavigation().stop();
            super.start();
        }

        public void stop() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                entity.getLookControl().setLookAt(target, 30, 90);
            }
            super.stop();
        }

        public void tick() {
            LivingEntity target = entity.getTarget();
            if (target != null) {
                if (this.entity.getAnimationTick() > 28) {
                    entity.getLookControl().setLookAt(target, 30, 90);
                }
            }
        }
    }

    class LeviathanAttackGoal extends Goal {
        private final The_Leviathan_Entity mob;
        private LivingEntity target;
        private int circlingTime = 0;
        private final int huntingTime = 0;
        private float MeleeModeTime = 0;
        private static final int MELEE_MODE_TIME = 160;
        private float circleDistance = 18;
        private boolean clockwise = false;

        public LeviathanAttackGoal(The_Leviathan_Entity mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            this.target = this.mob.getTarget();
            return this.target != null && target.isAlive() && this.mob.getAnimation() == NO_ANIMATION;
        }

        public boolean canContinueToUse() {
            this.target = this.mob.getTarget();
            return this.target != null;
        }

        public void start(){
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            MeleeModeTime = 0;
            circleDistance = 36 + this.mob.random.nextInt(20);
            clockwise = this.mob.random.nextBoolean();
            this.mob.setAggressive(true);
        }

        public void stop() {
            this.mob.mode = AttackMode.CIRCLE;
            circlingTime = 0;
            MeleeModeTime = 0;
            circleDistance = 36 + this.mob.random.nextInt(20);
            clockwise = this.mob.random.nextBoolean();
            this.target = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
                this.mob.setTarget((LivingEntity)null);
            }

            this.mob.getNavigation().stop();
            if (this.mob.getTarget() == null) {
                this.mob.setAggressive(false);
                this.mob.getNavigation().stop();
            }
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                if (this.mob.mode == AttackMode.CIRCLE) {
                    circlingTime++;
                    circleEntity(target, circleDistance, 1.0f, clockwise, circlingTime, 0, 1);

                    if (huntingTime >= this.mob.hunting_cooldown) {
                        int i = Math.max(this.mob.getModeChance(), 2);
                        if(this.mob.random.nextInt(i) == 0){
                            this.mob.mode = AttackMode.RANGE;
                        }else{
                            this.mob.mode = AttackMode.MELEE;
                        }
                    }
                    if (this.mob.getRandom().nextFloat() * 100.0F < 12f && this.mob.distanceToSqr(target) <= 49.0D && this.mob.melee_cooldown <= 0) {
                        Animation animation = getRandomTantalcleStrike(this.mob.random);
                        this.mob.setAnimation(animation);
                    }

                }else if (this.mob.mode == AttackMode.RANGE) {
                    if (this.mob.getRandom().nextFloat() * 100.0F < 3f && this.mob.CanAbyss_Blast_Portal) {
                        this.mob.setAnimation(LEVIATHAN_ABYSS_BLAST_PORTAL);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < (2f * this.mob.getBlastChance()) && this.mob.CanAbyss_Blast) {
                        if(this.mob.random.nextInt(2) == 0) {
                            this.mob.setAnimation(LEVIATHAN_ABYSS_BLAST);
                        }else{
                            this.mob.setAnimation(LEVIATHAN_ABYSS_BLAST_FIRE);
                        }
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 8f && this.mob.distanceToSqr(target) >= 700.0D && this.mob.CanGrab) {
                        this.mob.setAnimation(LEVIATHAN_GRAB);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 4f && this.mob.distanceToSqr(target) < 900. && this.mob.distanceToSqr(target) >= 49.0D && this.mob.CanRush) {
                        this.mob.setAnimation(LEVIATHAN_RUSH);
                    }
                }else if (this.mob.mode == AttackMode.MELEE) {
                    this.mob.getNavigation().moveTo(target, 1.0D);
                    MeleeModeTime++;
                    this.mob.getLookControl().setLookAt(target, 30, 90);
                    if(MeleeModeTime >= MELEE_MODE_TIME) {
                        this.mob.mode = AttackMode.RANGE;
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 15f && this.mob.distanceToSqr(target) < 49.0D && this.mob.CanTailWhips) {
                        this.mob.setAnimation(LEVIATHAN_TAIL_WHIPS);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 8f && this.mob.distanceToSqr(target) < 36.0D && this.mob.CanGrab) {
                        this.mob.setAnimation(LEVIATHAN_TENTACLE_HOLD);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 20f && this.mob.distanceToSqr(target) <= 30.0D && this.mob.CanBite ) {
                        this.mob.setAnimation(LEVIATHAN_BITE);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 3f && this.mob.CanCrackDimension && this.mob.distanceToSqr(target) < 256 && this.mob.distanceToSqr(target) > 49.0D) {
                        this.mob.setAnimation(LEVIATHAN_BREAK_DIMENSION);
                    } else if (this.mob.getRandom().nextFloat() * 100.0F < 5f && this.mob.CanMine && this.mob.distanceToSqr(target) < 256 && this.mob.distanceToSqr(target) > 100.0D) {
                        this.mob.setAnimation(LEVIATHAN_MINE);
                    }
                }

            }
        }
    }

    static class LeviathanMoveController extends MoveControl {
        private final The_Leviathan_Entity entity;
        private final float speedMulti;
        private final float ySpeedMod;
        private final float yawLimit;
        private  int stillTicks = 0;
        public LeviathanMoveController(The_Leviathan_Entity entity, float speedMulti, float ySpeedMod, float yawLimit) {
            super(entity);
            this.entity = entity;
            this.speedMulti = speedMulti;
            this.ySpeedMod = ySpeedMod;
            this.yawLimit = yawLimit;
        }

        public void tick() {
            if (this.entity.isInWater() && this.entity.getAnimation() == NO_ANIMATION) {
                if (Math.abs(this.entity.xo - this.entity.getX()) < 0.01F && Math.abs(this.entity.yo - this.entity.getY()) < 0.01F && Math.abs(this.entity.zo - this.entity.getZ()) < 0.01F) {
                    stillTicks++;
                } else {
                    stillTicks = 0;
                }
                if (stillTicks > 40){
                    this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
                }
            }
            if (((ISemiAquatic) entity).shouldStopMoving()) {
                this.entity.setSpeed(0.0F);
                return;
            }
            if (this.operation == Operation.MOVE_TO && !this.entity.getNavigation().isDone()) {
                double lvt_1_1_ = this.wantedX - this.entity.getX();
                double lvt_3_1_ = this.wantedY - this.entity.getY();
                double lvt_5_1_ = this.wantedZ - this.entity.getZ();
                double lvt_7_1_ = lvt_1_1_ * lvt_1_1_ + lvt_3_1_ * lvt_3_1_ + lvt_5_1_ * lvt_5_1_;
                if (lvt_7_1_ < 2.500000277905201E-7D) {
                    this.mob.setZza(0.0F);
                } else {
                    float lvt_9_1_ = (float) (Mth.atan2(lvt_5_1_, lvt_1_1_) * 57.2957763671875D) - 90.0F;
                    this.entity.setYRot(this.rotlerp(this.entity.getYRot(), lvt_9_1_, yawLimit));
                    this.entity.yBodyRot = this.entity.getYRot();
                    this.entity.yHeadRot = this.entity.getYRot();
                    float lvt_10_1_ = (float) (this.speedModifier * speedMulti * 3 * this.entity.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    if (this.entity.isInWater()) {
                        if(lvt_3_1_ > 0 && entity.horizontalCollision){
                            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, 0.08F, 0.0D));
                        }else{
                            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, (double) this.entity.getSpeed() * lvt_3_1_ * 0.6D * ySpeedMod, 0.0D));
                        }
                        this.entity.setSpeed(lvt_10_1_ * 0.02F);
                        float lvt_11_1_ = -((float) (Mth.atan2(lvt_3_1_, Mth.sqrt((float) (lvt_1_1_ * lvt_1_1_ + lvt_5_1_ * lvt_5_1_))) * 57.2957763671875D));
                        lvt_11_1_ = Mth.clamp(Mth.wrapDegrees(lvt_11_1_), -85.0F, 85.0F);
                        this.entity.setXRot(this.rotlerp(this.entity.getXRot(), lvt_11_1_, 5.0F));
                        float lvt_12_1_ = Mth.cos(this.entity.getXRot() * 0.017453292F);
                        float lvt_13_1_ = Mth.sin(this.entity.getXRot() * 0.017453292F);
                        this.entity.zza = lvt_12_1_ * lvt_10_1_;
                        this.entity.yya = -lvt_13_1_ * lvt_10_1_;
                    } else {
                        this.entity.setSpeed(lvt_10_1_ * 0.1F);
                    }

                }
            } else {
                this.entity.setSpeed(0.0F);
                this.entity.setXxa(0.0F);
                this.entity.setYya(0.0F);
                this.entity.setZza(0.0F);
            }
        }
    }

}