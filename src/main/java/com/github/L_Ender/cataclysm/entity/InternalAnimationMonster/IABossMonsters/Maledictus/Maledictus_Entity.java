package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus;

import com.github.L_Ender.cataclysm.blocks.Cursed_Tombstone_Block;
import com.github.L_Ender.cataclysm.client.particle.Options.RingParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AI.EntityAINearestTarget3D;
import com.github.L_Ender.cataclysm.entity.AI.HurtByNearestTargetGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalAttackGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalMoveGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AI.InternalStateGoal;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.IABoss_monster;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.etc.CMBossInfoServer;
import com.github.L_Ender.cataclysm.entity.etc.IHoldEntity;
import com.github.L_Ender.cataclysm.entity.etc.SmartBodyHelper2;
import com.github.L_Ender.cataclysm.entity.etc.path.CMPathNavigateGround;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Arrow_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Phantom_Halberd_Entity;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;


public class Maledictus_Entity extends IABoss_monster implements IHoldEntity {
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState swingAnimationState = new AnimationState();
    public AnimationState shotAnimationState = new AnimationState();
    public AnimationState flyingshotAnimationState = new AnimationState();
    public AnimationState fallloopAnimationState = new AnimationState();
    public AnimationState falllendAnimationState = new AnimationState();
    public AnimationState masseffectAnimationState = new AnimationState();
    public AnimationState flyingsmash1AnimationState = new AnimationState();
    public AnimationState flyingsmash2AnimationState = new AnimationState();
    public AnimationState BackstepAnimationState = new AnimationState();
    public AnimationState BackstepRushAnimationState = new AnimationState();
    public AnimationState BackstepRushNobackstepAnimationState = new AnimationState();
    public AnimationState dash1AnimationState = new AnimationState();
    public AnimationState dash1NobackstepAnmationState = new AnimationState();
    public AnimationState dash2AnmationState = new AnimationState();
    public AnimationState dash2NobackstepAnmationState = new AnimationState();
    public AnimationState dash3AnimationState = new AnimationState();
    public AnimationState spinslashesAnimationState = new AnimationState();
    public AnimationState combofirstAnimationState = new AnimationState();
    public AnimationState combofirstendAnimationState = new AnimationState();
    public AnimationState combosecondAnimationState = new AnimationState();
    public AnimationState uppercutleftAnimationState = new AnimationState();
    public AnimationState uppercutrightAnimationState = new AnimationState();
    public AnimationState flyinghalberdsmash1AnimationState = new AnimationState();
    public AnimationState flyinghalberdsmash2AnimationState = new AnimationState();
    public AnimationState radagonAnimationState = new AnimationState();
    public AnimationState halberdswingAnimationState = new AnimationState();
    public AnimationState grab_startAnimationState = new AnimationState();
    public AnimationState grab_loopAnimationState = new AnimationState();
    public AnimationState grab_failAnimationState = new AnimationState();
    public AnimationState grab_successAnimationState = new AnimationState();
    public AnimationState grab_success_loopAnimationState = new AnimationState();
    public AnimationState grab_success_endAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();


    private boolean combo;
    private boolean grab;
    private int rageTicks;
    private int masseffect_cooldown = 0;
    private int flyattack_cooldown = 0;
    private int charge_cooldown = 0;
    private int uppercut_cooldown = 0;
    private int spin_cooldown = 0;
    private int radagon_cooldown = 0;
    private int spear_swing_cooldown = 0;
    private int grab_cooldown = 0;
    public static final int MASSEFFECT_COOLDOWN = 150;
    public static final int FLYATTACK_COOLDOWN = 100;
    public static final int CHARGE_COOLDOWN = 80;
    public static final int UPPERCUT_COOLDOWN = 80;
    public static final int SPIN_COOLDOWN = 100;
    public static final int NATURE_HEAL_COOLDOWN = 200;
    public static final int RADAGON_COOLDOWN = 250;
    public static final int SPEAR_SWING_COOLDOWN = 100;
    public static final int GRAB_COOLDOWN = 300;
    private int timeWithoutTarget;
    private int destroyBlocksTick;
    private static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.BOOLEAN);

    public static final EntityDataAccessor<Integer> RAGE = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.INT);

    public static final EntityDataAccessor<Integer> WEAPON = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<BlockPos> TOMBSTONE_POS = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.BLOCK_POS);
    private static final EntityDataAccessor<Direction> TOMBSTONE_DIRECTION = SynchedEntityData.defineId(Maledictus_Entity.class, EntityDataSerializers.DIRECTION);

    private final CMBossInfoServer bossEvent1 = new CMBossInfoServer(this.getDisplayName(), BossEvent.BossBarColor.GREEN,true,9);
    private final CMBossInfoServer bossEvent2 = new CMBossInfoServer(Component.translatable("entity.cataclysm.rage_meter"), BossEvent.BossBarColor.GREEN,false,10);

    public Maledictus_Entity(EntityType entity, Level world) {
        super(entity, world);
        this.xpReward = 500;
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        setConfigattribute(this, CMConfig.MaledictusHealthMultiplier, CMConfig.MaledictusDamageMultiplier);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByNearestTargetGoal(this));
        this.targetSelector.addGoal(2, new EntityAINearestTarget3D<>(this, Player.class, true));
        this.goalSelector.addGoal(3, new InternalMoveGoal(this, false, 1.0D));

        //spin slashes
        this.goalSelector.addGoal(1, new MaledictusSpinSlashes(this, 0, 18, 0, 68, 15, 23, 29,15,29,6.5F,0,0,24));

        //halberd_swing
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,27,0,50,22,3.5F){
            @Override
            public boolean canUse() {
                return super.canUse() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 32f && Maledictus_Entity.this.spear_swing_cooldown <= 0;

            }
            @Override
            public void start() {
                super.start();
                Maledictus_Entity.this.setWeapon(2);
            }
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.spear_swing_cooldown = SPEAR_SWING_COOLDOWN;
                Maledictus_Entity.this.setWeapon(0);
            }
        });
        //grab start
        this.goalSelector.addGoal(1, new MaledictusGrabGoal(this, 0, 28, 29, 26, 24, 9F, 3,3,25F));

        //grab_loop
        this.goalSelector.addGoal(1, new MaledictusGrabState(this,29,29,30,15,0,3,3));

        //grab_fail
        this.goalSelector.addGoal(0, new InternalStateGoal(this,30,30,0,30,0){
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.setWeapon(0);
            }
        });

        //grab_success_start
        this.goalSelector.addGoal(0, new MaledictusSuccessState(this, 31, 31, 32, 60, 0, 30,3,3,2));

        //grab_success_loop
        this.goalSelector.addGoal(1, new MaledictusfallingState(this, 32, 32,33,100, 0,3,3));

        //grab_success_end
        this.goalSelector.addGoal(0, new MaledictusfallingState(this, 33, 33, 0, 35,0,3,0));



        //combo first
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,19,20,27,10,6F){
            @Override
            public boolean canUse() {
                LivingEntity target = entity.getTarget();
                return super.canUse() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 24 && target !=null && this.entity.distanceTo(target) >= 1.75D ;
            }

            @Override
            public boolean canContinueToUse() {
                return super.canContinueToUse() && !combo;
            }

            @Override
            public void tick() {
                super.tick();
                if (entity.attackTicks == 8) {
                    float f1 = (float) Math.cos(Math.toRadians(entity.getYRot() + 90));
                    float f2 = (float) Math.sin(Math.toRadians(entity.getYRot() + 90));
                    entity.push(f1 * 1.35, 0, f2 * 1.35);
                }
            }
            @Override
            public void stop() {
                if (combo) {
                    entity.setAttackState(21);
                    combo = false;
                } else {
                    super.stop();
                }
            }
        });


        //uppercut
        this.goalSelector.addGoal(1, new Uppercut(this, 0, 22, 0, 60, 16, 3.0F,32f));

        this.goalSelector.addGoal(1, new Uppercut(this, 0, 23, 0, 60, 16, 3.0F,32F));


        //combo first end
        this.goalSelector.addGoal(0, new InternalStateGoal(this,20,20,0,13,0));

        //combo second end
        this.goalSelector.addGoal(0, new InternalStateGoal(this,21,21,0,45,8){
            @Override
            public void tick() {
                super.tick();
                if (entity.attackTicks == 8) {
                    float f1 = (float) Math.cos(Math.toRadians(entity.getYRot() + 90));
                    float f2 = (float) Math.sin(Math.toRadians(entity.getYRot() + 90));
                    entity.push(f1 * 1.5, 0, f2 * 1.5);
                }
            }
        });

        //swing
        this.goalSelector.addGoal(1, new Maledictus_Swing(this, 0, 1, 0, 44, 25, 6.5F, 35f, 20F));


        //bow
        this.goalSelector.addGoal(1, new Maledictus_Bow(this, 0, 2, 0, 45, 29, 8F, 35f, 29, 16F));

        //flying bow
        this.goalSelector.addGoal(1, new Maledictus_Flying_Bow(this, 0, 3, 4, 68, 50, 40f, 50,35F));

        //fall_loop
        this.goalSelector.addGoal(1, new MaledictusfallingState(this, 4, 4,5,100, 100,1,0));

        //fall_end
        this.goalSelector.addGoal(0, new MaledictusfallingState(this, 5, 5, 0, 27,0,0,0));

        //mass_effect
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,7,0,66,28,4.5F){
            @Override
            public boolean canUse() {
                return super.canUse() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 7f * Maledictus_Entity.this.getRageMeter() && Maledictus_Entity.this.masseffect_cooldown <= 0;
            }
            @Override
            public void tick() {
                super.tick();
                entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            }
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.masseffect_cooldown = MASSEFFECT_COOLDOWN;
            }
        });


        //flying strike
        this.goalSelector.addGoal(1, new Maledictus_Flying_Smash(this, 0, 8, 9, 100, 100, 30f, 56,0,0,17F,0.125));

        this.goalSelector.addGoal(0, new MaledictusfallingState(this, 9, 9, 0, 27,0,0,0));


        //halberd flying strike
        this.goalSelector.addGoal(1, new Maledictus_Flying_Smash(this, 0, 24, 25, 100, 100, 30f, 51,2,2,17F,0.145));

        this.goalSelector.addGoal(0, new MaledictusfallingState(this, 25, 25, 0, 75,0,2,0));



        //radagon
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,26,0,73,43,13F){
            @Override
            public boolean canUse() {
                if(Maledictus_Entity.this.isQuarterHealth()){
                    return super.canUse() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 35f && Maledictus_Entity.this.radagon_cooldown <= 0;
                }else if(Maledictus_Entity.this.isHalfHealth()){
                    return super.canUse() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 25f && Maledictus_Entity.this.radagon_cooldown <= 0;
                }
                return false;
            }
            @Override
            public void start() {
                super.start();
                Maledictus_Entity.this.setWeapon(2);
            }
            @Override
            public void stop() {
                super.stop();
                Maledictus_Entity.this.radagon_cooldown = RADAGON_COOLDOWN;
                Maledictus_Entity.this.setWeapon(0);
            }
        });


        //backstep
        this.goalSelector.addGoal(1, new InternalAttackGoal(this,0,10,0,15,15,4.5F){
            @Override
            public boolean canUse() {
                return super.canUse() && Maledictus_Entity.this.getRandom().nextFloat() * 100.0F < 18f && Maledictus_Entity.this.charge_cooldown <= 0;
            }
            @Override
            public void start() {
                super.start();
                float speed = -1.7f;
                float dodgeYaw = (float) Math.toRadians(Maledictus_Entity.this.getYRot() + 90);
                Vec3 m = Maledictus_Entity.this.getDeltaMovement().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                Maledictus_Entity.this.playSound(ModSounds.MALEDICTUS_JUMP.get(), 1F, 1.0f);
                Maledictus_Entity.this.setDeltaMovement(m.x, 0.4, m.z);
            }

            @Override
            public void stop() {
                if(Maledictus_Entity.this.isHalfHealth()) {
                    this.entity.setAttackState(12);
                }else{
                    this.entity.setAttackState(11);
                }
            }
        });


        //backstep-charge-backstep
        this.goalSelector.addGoal(0, new MaledictusChargeState(this, 11, 11, 0, 65, 18, 31, 24,33,2,0,0));

        //backstep-charge-nobackstep
        this.goalSelector.addGoal(0, new MaledictusChargeState(this, 12, 12, 0, 55, 18, 31, 24,0,2,0,1));

        //only charge
        this.goalSelector.addGoal(1, new MaledictusChargeGoal(this, 0, 19, 30, 24, 4.5F, 13F, 2,0,18f));

        //dash 2-backstep
        this.goalSelector.addGoal(0, new MaledictusChargeState(this, 15, 15, 0, 55, 10, 25, 16,27,2,0,2));

        //dash 2-nobackstep
        this.goalSelector.addGoal(0, new MaledictusChargeState(this, 16, 16, 0, 40, 10, 25, 16,0,2,0,2));

        //dash 3
        this.goalSelector.addGoal(0, new MaledictusChargeState(this, 17, 17, 0, 58, 10, 28, 16,30,2,0,3));

    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new CMPathNavigateGround(this, worldIn);
    }

    public static AttributeSupplier.Builder maledictus() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.33F)
                .add(Attributes.ATTACK_DAMAGE, 13)
                .add(Attributes.MAX_HEALTH, 420)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.STEP_HEIGHT, 1.25F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
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
        double range = calculateRange(source);
        if (range > CMConfig.MaledictusLongRangelimit * CMConfig.MaledictusLongRangelimit && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if ((this.getAttackState() == 31 || this.getAttackState() == 32 || this.getAttackState() == 33) && !source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }
        if (this.destroyBlocksTick <= 0) {
            this.destroyBlocksTick = 20;
        }

        return super.hurt(source, damage);
    }

    public float DamageCap() {
        return (float) CMConfig.MaledictusDamageCap;
    }

    public int DamageTime() {
        return CMConfig.MaledictusDamageTime;
    }


    protected int decreaseAirSupply(int air) {
        return air;
    }

    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
        return false;
    }

    public AnimationState getAnimationState(String input) {
        if (input == "swing") {
            return this.swingAnimationState;
        } else if (input == "shoot") {
            return this.shotAnimationState;
        } else if (input == "death") {
            return this.deathAnimationState;
        } else if (input == "flying_shoot") {
            return this.flyingshotAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else if (input == "fall_loop") {
            return this.fallloopAnimationState;
        } else if (input == "fall_end") {
            return this.falllendAnimationState;
        } else if (input == "mass_effect") {
            return this.masseffectAnimationState;
        } else if (input == "flying_smash_1") {
            return this.flyingsmash1AnimationState;
        } else if (input == "flying_smash_2") {
            return this.flyingsmash2AnimationState;
        } else if (input == "back_step") {
            return this.BackstepAnimationState;
        } else if (input == "back_step_dash") {
            return this.BackstepRushAnimationState;
        } else if (input == "back_step_dash_no_back_step") {
            return this.BackstepRushNobackstepAnimationState;
        } else if (input == "dash") {
            return this.dash1AnimationState;
        } else if (input == "dash_no_back_step") {
            return this.dash1NobackstepAnmationState;
        } else if (input == "dash2") {
            return this.dash2AnmationState;
        } else if (input == "dash2_no_back_step") {
            return this.dash2NobackstepAnmationState;
        } else if (input == "dash3") {
            return this.dash3AnimationState;
        } else if (input == "spin_slashes") {
            return this.spinslashesAnimationState;
        } else if (input == "combo_first") {
            return this.combofirstAnimationState;
        } else if (input == "combo_first_end") {
            return this.combofirstendAnimationState;
        } else if (input == "combo_second") {
            return this.combosecondAnimationState;
        } else if (input == "uppercut_right") {
            return this.uppercutrightAnimationState;
        } else if (input == "uppercut_left") {
            return this.uppercutleftAnimationState;
        } else if (input == "flying_halberd_smash_1") {
            return this.flyinghalberdsmash1AnimationState;
        } else if (input == "flying_halberd_smash_2") {
            return this.flyinghalberdsmash2AnimationState;
        } else if (input == "radagon") {
            return this.radagonAnimationState;
        } else if (input == "halberd_swing") {
            return this.halberdswingAnimationState;
        } else if (input == "grab_start") {
            return this.grab_startAnimationState;
        } else if (input == "grab_loop") {
            return this.grab_loopAnimationState;
        } else if (input == "grab_fail") {
            return this.grab_failAnimationState;
        } else if (input == "grab_success") {
            return this.grab_successAnimationState;
        } else if (input == "grab_success_loop") {
            return this.grab_success_loopAnimationState;
        } else if (input == "grab_success_end") {
            return this.grab_success_endAnimationState;
        } else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(TOMBSTONE_POS, BlockPos.ZERO);
        p_326229_.define(TOMBSTONE_DIRECTION, Direction.NORTH);
        p_326229_.define(WEAPON, 0);
        p_326229_.define(FLYING, false);
        p_326229_.define(RAGE, 0);
    }

    public int getWeapon() {
        return this.entityData.get(WEAPON);
    }

    public void setWeapon(int weapon) {
        this.entityData.set(WEAPON, weapon);
    }


    public boolean isFlying() {
        return this.entityData.get(FLYING);
    }

    public void setFlying(boolean flying) {
        this.entityData.set(FLYING, flying);
    }


    BlockPos getTombstonePos() {
        return this.entityData.get(TOMBSTONE_POS);
    }

    public void setTombstonePos(BlockPos p_30220_) {
        this.entityData.set(TOMBSTONE_POS, p_30220_);
    }

    public Direction getTombstoneDirection() {
        return this.entityData.get(TOMBSTONE_DIRECTION);
    }


    public void setTombstoneDirection(Direction p_30220_) {
        this.entityData.set(TOMBSTONE_DIRECTION, p_30220_);
    }


    public int getRageMeter() {
        return this.entityData.get(RAGE);
    }

    public void setRageMeter(int Rage) {
        this.entityData.set(RAGE, Rage);
    }

    public void travel(Vec3 travelVector) {
        super.travel(travelVector);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        return null;
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    public void positionRider(Entity passenger, MoveFunction moveFunc) {
        float f1 = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F)) ;
        float f2 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F)) ;
        double theta = (yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        Vec3 vec3 = this.getPassengerRidingPosition(passenger);
        Vec3 vec31 = passenger.getVehicleAttachmentPoint(this);

        double px = vec3.x - vec31.x + 0.5F * vecX + f1 * -0.6;
        double pz = vec3.z - vec31.z + 0.5F * vecZ + f2 * -0.6;

        double y = this.getY()  + 2.0D;
        if (hasPassenger(passenger)) {
            if(this.getAttackState() == 33){
                y = this.getY() - 0.2F * Mth.clamp(0, 0, 23);
                if(this.attackTicks == 23) {
                    passenger.stopRiding();
                }
            }

        }
        moveFunc.accept(passenger, px, y, pz);
    }


    public boolean shouldRiderSit() {
        return false;
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.swingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        this.stopAllAnimationStates();
                        this.shotAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.flyingshotAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        this.stopAllAnimationStates();
                        this.fallloopAnimationState.startIfStopped(this.tickCount);
                    }
                    case 5 -> {
                        this.stopAllAnimationStates();
                        this.falllendAnimationState.startIfStopped(this.tickCount);
                    }
                    case 6 -> {
                        this.stopAllAnimationStates();
                        this.deathAnimationState.startIfStopped(this.tickCount);
                    }
                    case 7 -> {
                        this.stopAllAnimationStates();
                        this.masseffectAnimationState.startIfStopped(this.tickCount);
                    }
                    case 8 -> {
                        this.stopAllAnimationStates();
                        this.flyingsmash1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 9 -> {
                        this.stopAllAnimationStates();
                        this.flyingsmash2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 10 -> {
                        this.stopAllAnimationStates();
                        this.BackstepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 11 -> {
                        this.stopAllAnimationStates();
                        this.BackstepRushAnimationState.startIfStopped(this.tickCount);
                    }
                    case 12 -> {
                        this.stopAllAnimationStates();
                        this.BackstepRushNobackstepAnimationState.startIfStopped(this.tickCount);
                    }
                    case 13 -> {
                        this.stopAllAnimationStates();
                        this.dash1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 14 -> {
                        this.stopAllAnimationStates();
                        this.dash1NobackstepAnmationState.startIfStopped(this.tickCount);
                    }
                    case 15 -> {
                        this.stopAllAnimationStates();
                        this.dash2AnmationState.startIfStopped(this.tickCount);
                    }
                    case 16 -> {
                        this.stopAllAnimationStates();
                        this.dash2NobackstepAnmationState.startIfStopped(this.tickCount);
                    }
                    case 17 -> {
                        this.stopAllAnimationStates();
                        this.dash3AnimationState.startIfStopped(this.tickCount);
                    }
                    case 18 -> {
                        this.stopAllAnimationStates();
                        this.spinslashesAnimationState.startIfStopped(this.tickCount);
                    }
                    case 19 -> {
                        this.stopAllAnimationStates();
                        this.combofirstAnimationState.startIfStopped(this.tickCount);
                    }
                    case 20 -> {
                        this.stopAllAnimationStates();
                        this.combofirstendAnimationState.startIfStopped(this.tickCount);
                    }
                    case 21 -> {
                        this.stopAllAnimationStates();
                        this.combosecondAnimationState.startIfStopped(this.tickCount);
                    }
                    case 22 -> {
                        this.stopAllAnimationStates();
                        this.uppercutrightAnimationState.startIfStopped(this.tickCount);
                    }
                    case 23 -> {
                        this.stopAllAnimationStates();
                        this.uppercutleftAnimationState.startIfStopped(this.tickCount);
                    }
                    case 24 -> {
                        this.stopAllAnimationStates();
                        this.flyinghalberdsmash1AnimationState.startIfStopped(this.tickCount);
                    }
                    case 25 -> {
                        this.stopAllAnimationStates();
                        this.flyinghalberdsmash2AnimationState.startIfStopped(this.tickCount);
                    }
                    case 26 -> {
                        this.stopAllAnimationStates();
                        this.radagonAnimationState.startIfStopped(this.tickCount);
                    }
                    case 27 -> {
                        this.stopAllAnimationStates();
                        this.halberdswingAnimationState.startIfStopped(this.tickCount);
                    }
                    case 28 -> {
                        this.stopAllAnimationStates();
                        this.grab_startAnimationState.startIfStopped(this.tickCount);
                    }
                    case 29 -> {
                        this.stopAllAnimationStates();
                        this.grab_loopAnimationState.startIfStopped(this.tickCount);
                    }
                    case 30 -> {
                        this.stopAllAnimationStates();
                        this.grab_failAnimationState.startIfStopped(this.tickCount);
                    }
                    case 31 -> {
                        this.stopAllAnimationStates();
                        this.grab_successAnimationState.startIfStopped(this.tickCount);
                    }
                    case 32 -> {
                        this.stopAllAnimationStates();
                        this.grab_success_loopAnimationState.startIfStopped(this.tickCount);
                    }

                    case 33 -> {
                        this.stopAllAnimationStates();
                        this.grab_success_endAnimationState.startIfStopped(this.tickCount);
                    }

                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.swingAnimationState.stop();
        this.shotAnimationState.stop();
        this.deathAnimationState.stop();
        this.flyingshotAnimationState.stop();
        this.fallloopAnimationState.stop();
        this.falllendAnimationState.stop();
        this.masseffectAnimationState.stop();
        this.flyingsmash1AnimationState.stop();
        this.flyingsmash2AnimationState.stop();
        this.BackstepAnimationState.stop();
        this.BackstepRushAnimationState.stop();
        this.BackstepRushNobackstepAnimationState.stop();
        this.dash1AnimationState.stop();
        this.dash1NobackstepAnmationState.stop();
        this.dash2AnmationState.stop();
        this.dash2NobackstepAnmationState.stop();
        this.dash3AnimationState.stop();
        this.spinslashesAnimationState.stop();
        this.combofirstAnimationState.stop();
        this.combofirstendAnimationState.stop();
        this.combosecondAnimationState.stop();
        this.uppercutrightAnimationState.stop();
        this.uppercutleftAnimationState.stop();
        this.flyinghalberdsmash1AnimationState.stop();
        this.flyinghalberdsmash2AnimationState.stop();
        this.radagonAnimationState.stop();
        this.halberdswingAnimationState.stop();

        this.grab_startAnimationState.stop();

        this.grab_loopAnimationState.stop();

        this.grab_failAnimationState.stop();

        this.grab_successAnimationState.stop();


        this.grab_success_loopAnimationState.stop();

        this.grab_success_endAnimationState.stop();


    }

    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
        this.setAttackState(6);
        this.setFlying(false);
    }

    public int deathtimer() {
        return 60;
    }

    @Override
    protected void AfterDefeatBoss(@Nullable LivingEntity living) {
        if (!this.level().isClientSide) {
            if(this.getTombstonePos() != BlockPos.ZERO) {
                BlockState block = ModBlocks.CURSED_TOMBSTONE.get().defaultBlockState();
                if (this.getTombstoneDirection() == Direction.UP || this.getTombstoneDirection() == Direction.DOWN) {
                    this.level().setBlockAndUpdate(this.getTombstonePos(), block.setValue(Cursed_Tombstone_Block.FACING, Direction.NORTH));
                } else {
                    this.level().setBlockAndUpdate(this.getTombstonePos(), block.setValue(Cursed_Tombstone_Block.FACING, this.getTombstoneDirection()));
                }
            }
        }
    }


    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("TombstonePosX", this.getTombstonePos().getX());
        compound.putInt("TombstonePosY", this.getTombstonePos().getY());
        compound.putInt("TombstonePosZ", this.getTombstonePos().getZ());
        compound.putByte("Tombstone_Direction", (byte)this.getTombstoneDirection().get3DDataValue());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        int i = compound.getInt("TombstonePosX");
        int j = compound.getInt("TombstonePosY");
        int k = compound.getInt("TombstonePosZ");
        this.setTombstoneDirection(Direction.from3DDataValue(compound.getByte("Tombstone_Direction")));
        this.setTombstonePos(new BlockPos(i, j, k));
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_30153_, DifficultyInstance p_30154_, MobSpawnType p_30155_, @Nullable SpawnGroupData p_30156_) {
        this.setTombstonePos(this.blockPosition());
        this.setTombstoneDirection(Direction.SOUTH);
        return super.finalizeSpawn(p_30153_, p_30154_, p_30155_, p_30156_);
    }


    public void tick() {
        super.tick();

        if (!this.getPassengers().isEmpty() && this.getPassengers().get(0).isShiftKeyDown() && (this.getAttackState() == 31 || this.getAttackState() == 32 || this.getAttackState() == 33 ) ) {
            this.getPassengers().get(0).setShiftKeyDown(false);
        }

        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.getAttackState() == 0, this.tickCount);
        } else {
            if (rageTicks > 0) {
                rageTicks--;
            } else {
                if (this.getRageMeter() > 0) {
                    setRageMeter(this.getRageMeter() - 1);
                    rageTicks = 200;
                }
            }
        }
        this.bossEvent1.setProgress(this.getHealth() / this.getMaxHealth());
        this.bossEvent2.setProgress((float) this.getRageMeter() / 5);
        if (masseffect_cooldown > 0) masseffect_cooldown--;
        if (flyattack_cooldown > 0) flyattack_cooldown--;
        if (charge_cooldown > 0) charge_cooldown--;
        if (uppercut_cooldown > 0) uppercut_cooldown--;
        if (spin_cooldown > 0) spin_cooldown--;
        if (radagon_cooldown > 0) radagon_cooldown--;
        if (spear_swing_cooldown > 0) spear_swing_cooldown--;

        if (grab_cooldown > 0) grab_cooldown--;



        LivingEntity target = this.getTarget();
        if (!this.level().isClientSide) {
            if (this.isFlying()) {
                this.setNoGravity(!this.onGround());
            } else {
                this.setNoGravity(false);
            }

            if (timeWithoutTarget > 0) timeWithoutTarget--;
            if (target != null) {
                timeWithoutTarget = NATURE_HEAL_COOLDOWN;
            }

            if (this.getAttackState() == 0 && timeWithoutTarget <= 0) {
                if (!isNoAi() && CMConfig.MaledictusNatureHealing > 0) {
                    if (this.tickCount % 20 == 0) {
                        this.heal((float) CMConfig.MaledictusNatureHealing);
                    }
                }
            }
        }
        blockbreak();
    }

    public boolean isHalfHealth() {
        float healthAmount = this.getHealth() / this.getMaxHealth();
        return healthAmount <= 0.5F;
    }

    public boolean isQuarterHealth() {
        float healthAmount = this.getHealth() / this.getMaxHealth();
        return healthAmount <= 0.25F;
    }

    private float DMG() {
        return (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) + this.getAttributeValue(Attributes.ATTACK_DAMAGE) * this.getRageMeter() * 0.2f);
    }

    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() == 1) {
            flyingdestroy();
            if (this.attackTicks == 23) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 25) {
                AreaAttack(5.5f, 5.5f, 270, 1, (float) CMConfig.MaledictusSmashHpDamage, 200, false,false);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
                MakeRingparticle(2.5f, 0.2f, 40, 86, 236, 204, 1.0f, 30f);
            }
        }

        if (this.getAttackState() == 2) {
            if (this.attackTicks == 8) {
                this.playSound(ModSounds.MALEDICTUS_BOW_PULL.get(), 1F, 1.0f);
            }
        }

        if (this.getAttackState() == 3) {
            flyingdestroy();
            if (this.attackTicks == 6) {
                this.playSound(ModSounds.MALEDICTUS_LEAP.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 28) {
                this.playSound(ModSounds.MALEDICTUS_BOW_PULL.get(), 1F, 1.0f);
            }
        }

        if (this.getAttackState() == 4) {
            if (this.onGround() || !this.getInBlockState().getFluidState().isEmpty()) {
                this.setAttackState(5);
            }
        }
        if (this.getAttackState() == 6) {
            if (this.attackTicks == 30) {
                if (this.level().isClientSide) {
                    for (int i = 0; i < 20 + random.nextInt(2); ++i) {
                        float f2 = this.random.nextFloat() * ((float) Math.PI * 2F);
                        float f3 = Mth.sqrt(this.random.nextFloat()) * this.getBbWidth() * 0.5F;
                        double d0 = this.getX() + (double) (Mth.cos(f2) * f3);
                        double d4 = this.getZ() + (double) (Mth.sin(f2) * f3);
                        this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), d0, this.getY() + (double) this.getBbHeight() * 0.6 + i * 0.05D, d4, 0.0D, 0.1D, 0.0D);
                    }
                }
            }
        }
        if (this.getAttackState() == 7) {
            if (this.attackTicks == 10) {
                masseffectParticle(5.0f);
            }
            if (this.attackTicks == 15) {
                masseffectParticle(7.0f);
            }

            if (this.attackTicks == 20) {
                masseffectParticle(9.0f);
            }
            if (this.attackTicks == 30) {
                this.playSound(ModSounds.MALEDICTUS_BATTLE_CRY.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 32) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 34) {
                this.playSound(ModSounds.EXPLOSION.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 40);
                this.setRageMeter(0);
                if (this.level().isClientSide) {
                    float vec = 1.0f;
                    float math = 0;
                    float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    this.level().addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, 30, 86, 236, 204, 1.0f, 85, false, 0), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
                }

                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0D))) {
                    if (!isAlliedTo(entity) && entity != this) {
                        entity.hurt(CMDamageTypes.causeMaledictioSoulDamage(this), (float) (DMG() * 1.5F + Math.min(DMG() * 1.5F, entity.getMaxHealth() * CMConfig.MaledictusAOEHpDamage)));
                    }
                }
            }
            if (this.attackTicks > 34 && this.attackTicks < 44) {
                Sphereparticle(0.3f, 1.0f, 4F);
            }
        }
        if (this.getAttackState() == 8) {
            flyingdestroy();
            if (this.attackTicks == 23) {
                this.playSound(ModSounds.MALEDICTUS_LEAP.get(), 1F, 1.0f);
            }
            if (this.attackTicks >= 65) {
                if (this.onGround() || !this.getInBlockState().getFluidState().isEmpty()) {
                    this.setAttackState(9);
                }
            }
        }

        if (this.getAttackState() == 9) {
            flyingdestroy();
            if (this.attackTicks == 2) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 4) {
                this.playSound(ModSounds.EXPLOSION.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.3f, 0, 40);
                MakeRingparticle(2.5f, 0.2f, 40, 86, 236, 204, 1.0f, 50f);
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3.5D))) {
                    if (!isAlliedTo(entity) && entity != this) {
                        boolean flag = entity.hurt(CMDamageTypes.causeMaledictioDamage(this), (float) (DMG() * 1.25F + Math.min(DMG() * 1.25F, entity.getMaxHealth() * CMConfig.MaledictusFlyingSmashHpDamage)));
                        if (flag) {
                            rageTicks = 200;
                            if (this.getRageMeter() < 5) {
                                setRageMeter(this.getRageMeter() + 1);
                            }
                        }

                    }
                }
            }
            for (int i = 8, j = 2; i <= 16; i = i + 2, j++) {
                if (this.attackTicks == i) {
                    ShieldSmashDamage(2, j, 4f, 2.5f, 1, (float) CMConfig.MaledictusShockWaveHpDamage, 0.05F);
                }
            }
        }

        if (this.getAttackState() == 11 || this.getAttackState() == 12 || this.getAttackState() == 13 || this.getAttackState() == 14) {
            if (this.attackTicks == 21) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 24) {
                this.playSound(ModSounds.PHANTOM_SPEAR.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks >= 24 && this.attackTicks <= 33) {
                Rushattack(-0.05D, 0.5D,3.25, 1.1F, (float) CMConfig.MaledictusHpDamage, 0, true);
                if (this.level().isClientSide) {
                    double x = this.getX();
                    double y = this.getY() + this.getBbHeight() / 2;
                    double z = this.getZ();
                    float yaw = (float) Math.toRadians(-this.getYRot());
                    float yaw2 = (float) Math.toRadians(-this.getYRot() + 180);
                    float pitch = (float) Math.toRadians(-this.getXRot());
                    this.level().addParticle(new RingParticleOptions(yaw, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);
                    this.level().addParticle(new RingParticleOptions(yaw2, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);

                }
            }
        }


        if (this.getAttackState() == 15 || this.getAttackState() == 16) {
            if (this.attackTicks == 13) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 16) {
                this.playSound(ModSounds.PHANTOM_SPEAR.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks >= 16 && this.attackTicks <= 25) {
                Rushattack(-0.035D, 0.5D,3.25, 1.2F, (float) CMConfig.MaledictusHpDamage, 0, true);
                if (this.level().isClientSide) {
                    double x = this.getX();
                    double y = this.getY() + this.getBbHeight() / 2;
                    double z = this.getZ();
                    float yaw = (float) Math.toRadians(-this.getYRot());
                    float yaw2 = (float) Math.toRadians(-this.getYRot() + 180);
                    float pitch = (float) Math.toRadians(-this.getXRot());
                    this.level().addParticle(new RingParticleOptions(yaw, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);
                    this.level().addParticle(new RingParticleOptions(yaw2, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);

                }
            }
        }
        if (this.getAttackState() == 17) {
            if (this.attackTicks == 13) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks == 16) {
                this.playSound(ModSounds.PHANTOM_SPEAR.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
            }
            if (this.attackTicks >= 16 && this.attackTicks <= 24) {
                Rushattack(0, 0.5D,3.25, 1.3F, (float) CMConfig.MaledictusHpDamage, 0, true);
                if (this.level().isClientSide) {
                    double x = this.getX();
                    double y = this.getY() + this.getBbHeight() / 2;
                    double z = this.getZ();
                    float yaw = (float) Math.toRadians(-this.getYRot());
                    float yaw2 = (float) Math.toRadians(-this.getYRot() + 180);
                    float pitch = (float) Math.toRadians(-this.getXRot());
                    this.level().addParticle(new RingParticleOptions(yaw, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);
                    this.level().addParticle(new RingParticleOptions(yaw2, pitch, 40, 86, 236, 204, 1.0f, 50f, false, 2), x, y, z, 0, 0, 0);

                }
            }

        }
        if (this.getAttackState() == 18) {
            if (this.attackTicks == 18) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 20) {
                AreaAttack(3.25f, 3.25f, 220, 1, (float) CMConfig.MaledictusHpDamage, 0, false,false);
            }
            if (this.attackTicks == 32) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 34) {
                AreaAttack(3.25f, 3.25f, 220, 1, (float) CMConfig.MaledictusHpDamage, 160, false,false);
            }
        }
        if (this.getAttackState() == 19) {
            if (this.attackTicks == 10) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 12) {
                AreaAttack(4.0f, 4.0f, 180, 1, (float) CMConfig.MaledictusHpDamage, 0, false,false);
            }

            if (this.attackTicks == 22) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 24) {
                MakeRingparticle(2.5f, 0.2f, 40, 86, 236, 204, 1.0f, 30f);
                ComboAreaAttack(5f, 5f, 70, 1.2F, (float) CMConfig.MaledictusHpDamage, 200, false);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
            }
        }
        if (this.getAttackState() == 21) {
            if (this.attackTicks == 10) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 12) {
                AreaAttack(4.25f, 4.25f, 180, 1, (float) CMConfig.MaledictusHpDamage, 0, true,false);
            }

            if (this.attackTicks == 22) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 24) {
                AreaAttack(5f, 5f, 70, 1.2F, (float) CMConfig.MaledictusHpDamage, 0, true,false);
                MakeRingparticle(2.5f, 0.2f, 40, 86, 236, 204, 1.0f, 30f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
            }
        }

        if (this.getAttackState() == 22) {
            if (this.attackTicks == 21) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 23) {
                uppercut(0.2D, 3.25, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, true);

            }
            if (this.attackTicks == 31) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 0.5F, 1.0f);
            }
            if (this.attackTicks == 33) {
                uppercut(0.25D, 3.8, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, false);
                MakeRingparticle(3.5f, -0.3f, 40, 86, 236, 204, 1.0f, 20f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
            }
        }

        if (this.getAttackState() == 23) {
            if (this.attackTicks == 21) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 1F, 1.0f);
            }
            if (this.attackTicks == 23) {
                uppercut(0.2D, 3.25, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, true);

            }
            if (this.attackTicks == 31) {
                this.playSound(ModSounds.MALEDICTUS_MACE_SWING.get(), 0.5F, 1.0f);
            }
            if (this.attackTicks == 33) {
                uppercut(0.25D, 3.8, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, false);
                MakeRingparticle(3.5f, 0.7f, 40, 86, 236, 204, 1.0f, 20f);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
            }
        }

        if (this.getAttackState() == 24) {
            flyingdestroy();
            if (this.attackTicks == 23) {
                this.playSound(ModSounds.MALEDICTUS_LEAP.get(), 1F, 1.0f);
            }
            if (this.attackTicks >= 60) {
                if (this.onGround() || !this.getInBlockState().getFluidState().isEmpty()) {
                    this.setAttackState(25);
                }
            }
        }

        if (this.getAttackState() == 25) {
            flyingdestroy();
            if (this.attackTicks == 4) {
                this.playSound(ModSounds.PHANTOM_SPEAR.get(), 1.0f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.3f, 0, 40);
                MakeRingparticle(2.25f, 0.3f, 40, 86, 236, 204, 1.0f, 30f);
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2.0D))) {
                    if (!isAlliedTo(entity) && entity != this) {
                        boolean flag = entity.hurt(CMDamageTypes.causeMaledictioDamage(this), (float) (DMG() * 1.25F + Math.min(DMG() * 1.25F, entity.getMaxHealth() * CMConfig.MaledictusFlyingSmashHpDamage)));
                        if (flag) {
                            rageTicks = 200;
                            if (this.getRageMeter() < 5) {
                                setRageMeter(this.getRageMeter() + 1);
                            }
                        }
                    }
                }
                StrikeWindmillHalberd(6, 10, 1.0, 0.75, 0.2, 1);

                StrikeWindmillHalberd(4, 10, 1.0, 1.2, 0.15, 1);
            }
            if (this.attackTicks == 37) {
                MakeRingparticle(2.25f, 0.3f, 40, 86, 236, 204, 1.0f, 30f);
                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(2.0D))) {
                    if (!isAlliedTo(entity) && entity != this) {
                        boolean flag = entity.hurt(CMDamageTypes.causeMaledictioDamage(this), (float) (DMG() * 1.25F + Math.min(DMG() * 1.25F, entity.getMaxHealth() * CMConfig.MaledictusFlyingSmashHpDamage)));
                        if (flag) {
                            rageTicks = 200;
                            if (this.getRageMeter() < 5) {
                                setRageMeter(this.getRageMeter() + 1);
                            }
                        }
                    }
                }
               // StrikeHalberd(12,12F,5 + random.nextInt(1),2.5D,1);
            }
            if (this.attackTicks == 39) {
                StrikeHalberd(14,14F,7 + random.nextInt(3),4D,1);
            }
            if (this.attackTicks == 40) {
                StrikeHalberd(16,16F,10 + random.nextInt(5),5.5D,1);
            }
            if (this.attackTicks == 42 && isHalfHealth()) {
                StrikeHalberd(18,18F,13 + random.nextInt(8),6.5D,1);
            }
            if(this.attackTicks == 43 && this.isQuarterHealth()){
                StrikeHalberd(20,20F,16 + random.nextInt(10),7.5D,1);
            }

        }

        if(this.getAttackState() == 26){
            if(this.attackTicks == 13) {
                this.playSound(ModSounds.PHANTOM_SPEAR.get(), 1.0F, 1.0f);
            }
            if(this.attackTicks == 15) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR.get(), 1.0F, 1.0f);
                AreaAttack(4.5f, 4.5f, 80, 1.2F, (float) CMConfig.MaledictusSmashHpDamage, 0, true,false);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
            }
            if(this.attackTicks == 44) {
                AreaAttack(5.5f, 5.5f, 110, 1.0F, (float) CMConfig.MaledictusSmashHpDamage, 0, true,false);
              //  ScreenShake_Entity.ScreenShake(level(), this.position(), 30, 0.1f, 0, 10);
            }

            for (int l = 44; l <= 58; l = l + 2) {
                if (this.attackTicks == l) {
                    int d = l - 42;
                    radagonskill(0.7f, d, 1,2);
                }
            }
        }
        if(this.getAttackState() == 27){
            if(this.attackTicks == 20) {
                AreaAttack(5.25f, 5.25f, 110, 1.0F, (float) CMConfig.MaledictusHpDamage, 120, false,true);
                this.playSound(ModSounds.AXE_SWING.get(), 1.0F, 1.3f);
            }
        }

        if(this.getAttackState() == 29){
            if(this.attackTicks == 1) {
                this.playSound(ModSounds.MALEDICTUS_SHORT_ROAR.get(), 1.0F, 1.0f);
            }
            Grab(-0.025D, 0.5D,1.5, 0.2F, 0, 0, true);
            if (this.level().isClientSide) {
                for (int i = 0; i < 2; ++i) {
                    this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), this.getRandomX(1.5D), this.getRandomY(), this.getRandomZ(1.5D), 0.0D, 0.0D, 0.0D);
                }
            }
        }
        if(this.getAttackState() == 31){
            if (this.level().isClientSide) {
                for (int i = 0; i < 2; ++i) {
                    this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), this.getRandomX(1.5D), this.getRandomY(), this.getRandomZ(1.5D), 0.0D, 0.0D, 0.0D);
                }
            }
            if (this.attackTicks == 17) {
                this.playSound(ModSounds.MALEDICTUS_LEAP.get(), 1F, 1.0f);
            }

        }


        if(this.getAttackState() == 32){
            if (this.onGround() || !this.getInBlockState().getFluidState().isEmpty()) {
                this.setAttackState(33);
            }
            if (this.level().isClientSide) {
                for (int i = 0; i < 2; ++i) {
                    this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), this.getRandomX(1.5D), this.getRandomY(), this.getRandomZ(1.5D), 0.0D, 0.0D, 0.0D);
                }
            }
        }
        if(this.getAttackState() == 33) {
            if (this.attackTicks == 2) {
                this.playSound(ModSounds.EXPLOSION.get(), 0.5f, 1F + this.getRandom().nextFloat() * 0.1F);
                ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.2f, 0, 40);
                if (this.level().isClientSide) {
                    float vec = 1.0f;
                    float math = 0;
                    float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
                    float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
                    double theta = (yBodyRot) * (Math.PI / 180);
                    theta += Math.PI / 2;
                    double vecX = Math.cos(theta);
                    double vecZ = Math.sin(theta);
                    this.level().addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, 30, 86, 236, 204, 1.0f, 85, false, 0), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
                }

                for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(7.0D))) {
                    if (!isAlliedTo(entity) && entity != this) {
                        entity.hurt(CMDamageTypes.causeMaledictioSoulDamage(this), (float) (DMG() * 1.75F + Math.min(DMG() * 1.75F, entity.getMaxHealth() * CMConfig.MaledictusAOEHpDamage)));
                    }
                }
            }
            if (this.attackTicks > 1 && this.attackTicks < 11) {
                Sphereparticle(0.3f, 1.0f, 4F);
            }
        }

    }


    private void blockbreak() {
        if (!this.isNoAi()) {
            if (!this.level().isClientSide) {
                if (CMConfig.MaledictusBlockBreaking) {
                    blockdestroy();
                } else {
                    if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
                        blockdestroy();
                    }
                }
            }
        }
    }

    private void flyingdestroy(){
        if (!this.level().isClientSide) {
            if (CMConfig.MaledictusBlockBreaking) {
                blockdestroy2(0.35D,2.0D);
            } else {
                if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
                    blockdestroy2(0.35D,2.0D);
                }
            }
        }
    }

    private void blockdestroy() {
        if (this.destroyBlocksTick > 0) {
            --this.destroyBlocksTick;
            if (this.destroyBlocksTick == 0) {
                AABB aabb = this.getBoundingBox().inflate(0.5D);
                for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                    BlockState blockstate = this.level().getBlockState(blockpos);
                    if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.MALEDICTUS_IMMUNE) && net.neoforged.neoforge.event.EventHooks.onEntityDestroyBlock(this, blockpos, blockstate)) {
                        this.level().destroyBlock(blockpos, true, this);
                    }
                }

            }
        }
        AABB aabb = this.getBoundingBox().inflate(0.2D, 0.5D, 0.2D);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && blockstate.is(ModTag.FROSTED_PRISON_CHANDELIER) && net.neoforged.neoforge.event.EventHooks.onEntityDestroyBlock(this, blockpos, blockstate)) {
                this.level().destroyBlock(blockpos, true, this);
            }
        }

    }

    private void blockdestroy2(double xz,double y) {
        AABB aabb = this.getBoundingBox().inflate(xz, y, xz);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(this.getY()), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (!blockstate.isAir() && blockstate.canEntityDestroy(this.level(), blockpos, this) && !blockstate.is(ModTag.MALEDICTUS_IMMUNE) && net.neoforged.neoforge.event.EventHooks.onEntityDestroyBlock(this, blockpos, blockstate)) {
                this.level().destroyBlock(blockpos, true, this);
            }
        }

    }


    private void StrikeHalberd(int rune, float close,float radius,double range,int delay) {
        float angle2 = (0.01745329251F * this.yBodyRot);
        for (int k = 0; k < rune; ++k) {
            float f2 = angle2 + (float) k * (float) Math.PI * 2.0F / close + ((float) Math.PI * 2F / radius);
            this.spawnHalberd(this.getX() + (double) Mth.cos(f2) * range, this.getZ() + (double) Mth.sin(f2) * range, this.getY() -5, this.getY() + 3, f2, delay);
        }


        if (this.level().isClientSide) {
            for (int k = 0; k < rune; ++k) {
                float f2 = angle2 + (float) k * (float) Math.PI * 2.0F / close + ((float) Math.PI * 2F / radius);
                for (int i1 = 0; i1 < 6 + random.nextInt(2); i1++) {
                    double DeltaMovementX = getRandom().nextGaussian() * 0.007D;
                    double DeltaMovementY = getRandom().nextGaussian() * 0.007D;
                    double DeltaMovementZ = getRandom().nextGaussian() * 0.007D;
                    float angle = (0.01745329251F * this.yBodyRot) + i1;
                    double extraX = 0.5F * Mth.sin((float) (Math.PI + angle));
                    double extraY = 0.3F;
                    double extraZ = 0.5F * Mth.cos(angle);

                    this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), getX() + (double) Mth.cos(f2) * range + extraX, this.getY() + extraY, getZ() + (double) Mth.sin(f2) * range + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
        }
    }


    private void StrikeWindmillHalberd(int numberOfBranches, int particlesPerBranch, double initialRadius, double radiusIncrement, double curveFactor, int delay) {
        float angleIncrement = (float) (2 * Math.PI / numberOfBranches);
        for (int branch = 0; branch < numberOfBranches; ++branch) {
            float baseAngle = angleIncrement * branch;

            for (int i = 0; i < particlesPerBranch; ++i) {
                double currentRadius = initialRadius + i * radiusIncrement;
                float currentAngle = (float) (baseAngle + i * angleIncrement / initialRadius + (float) (i * curveFactor));

                double xOffset = currentRadius * Math.cos(currentAngle);
                double zOffset = currentRadius * Math.sin(currentAngle);

                double spawnX = this.getX() + xOffset;
                double spawnY = this.getY() + 0.3D;
                double spawnZ = this.getZ() + zOffset;
                int d3 = delay * (i + 1);
                this.spawnHalberd(spawnX, spawnZ, this.getY() -5, this.getY() + 3, currentAngle, d3);

                double deltaX = getRandom().nextGaussian() * 0.007D;
                double deltaY = getRandom().nextGaussian() * 0.007D;
                double deltaZ = getRandom().nextGaussian() * 0.007D;
                if (this.level().isClientSide) {
                    this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), spawnX, spawnY, spawnZ, deltaX, deltaY, deltaZ);
                }
            }
        }
    }

    private void radagonskill(float spreadarc, int distance, float vec, int delay) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);

        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);

            this.spawnHalberd(hitX + 0.5D, hitZ + 0.5D, this.getY() -5, this.getY() + 3, (float) theta, delay);
            this.radagonparticle(hitX + 0.5D, hitZ + 0.5D, this.getY() -5, this.getY() + 3);
        }
    }

    private void radagonparticle(double x, double z, double minY, double maxY) {
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
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            if (this.level().isClientSide) {
                for (int i1 = 0; i1 < 4 ; i1++) {
                    double DeltaMovementX = getRandom().nextGaussian() * 0.007D;
                    double DeltaMovementY = getRandom().nextGaussian() * 0.007D;
                    double DeltaMovementZ = getRandom().nextGaussian() * 0.007D;
                    float angle = (0.01745329251F * this.yBodyRot) + i1;
                    double extraX = 0.35F * Mth.sin((float) (Math.PI + angle));
                    double extraY = 0.3F;
                    double extraZ = 0.35F * Mth.cos(angle);

                    this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), x + extraX, (double)blockpos.getY() + d0 + extraY, z + extraZ, DeltaMovementX, DeltaMovementY, DeltaMovementZ);
                }
            }
        }
    }

    private void spawnHalberd(double x, double z, double minY, double maxY, float rotation, int delay) {
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
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            this.level().addFreshEntity(new Phantom_Halberd_Entity(this.level(), x, (double)blockpos.getY() + d0, z, rotation, delay, this,(float)CMConfig.MaledictusPhantomHalberddamage + (float) CMConfig.MaledictusPhantomHalberddamage * this.getRageMeter() * 0.1F));
        }
    }


    private void ComboAreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, boolean maledictio) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.yBodyRot % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }
            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Maledictus_Entity) && entityHit != this) {
                    DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, DMG() * damage + Math.min(DMG() * damage, entityHit.getMaxHealth() * hpdamage));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    if (flag) {
                        combo = true;
                        rageTicks = 200;
                        if (this.getRageMeter() < 5) {
                            setRageMeter(this.getRageMeter() + 1);
                        }
                    }
                }
            }
        }
    }

    private void Grab(double inflateXZ,double inflateY,  double range, float damage, float hpdamage, int shieldbreakticks, boolean maledictio) {
        double yaw = (yBodyRot) * (Math.PI / 180);
        yaw += Math.PI / 2;

        double xExpand = range * Math.cos(yaw);
        double zExpand = range * Math.sin(yaw);
        AABB attackRange = this.getBoundingBox().inflate(inflateXZ,inflateY,inflateXZ).expandTowards(xExpand, 0, zExpand);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entity) && entity != this) {
                DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, DMG() * damage + Math.min(DMG() * damage, entity.getMaxHealth() * hpdamage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
                if (flag) {
                    grab = true;
                    if (!entity.getType().is(ModTag.IGNIS_CANT_POKE) && entity.isAlive()) {
                        if (entity.isShiftKeyDown()) {
                            entity.setShiftKeyDown(false);
                        }
                        if(this.getPassengers().isEmpty()) {
                            if (!this.level().isClientSide) {
                                entity.startRiding(this, true);
                            }
                        }
                    }

                }

            }
        }
    }


    private void ShieldSmashDamage(float spreadarc, int distance, float mxy, float vec, float damage, float hpdamage, float airborne) {
        double perpFacing = this.yBodyRot * (Math.PI / 180);
        double facingAngle = perpFacing + Math.PI / 2;
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double spread = Math.PI * spreadarc;
        int arcLen = Mth.ceil(distance * spread);
        double minY = this.getY() - 1;
        double maxY = this.getY() + mxy;
        for (int i = 0; i < arcLen; i++) {
            double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
            double vx = Math.cos(theta);
            double vz = Math.sin(theta);
            double px = this.getX() + vx * distance + vec * Math.cos((yBodyRot + 90) * Math.PI / 180);
            double pz = this.getZ() + vz * distance + vec * Math.sin((yBodyRot + 90) * Math.PI / 180);
            int hitX = Mth.floor(px);
            int hitZ = Mth.floor(pz);
            BlockPos pos = new BlockPos(hitX, hitY, hitZ);
            BlockState block = level().getBlockState(pos);
            int maxDepth = 30;
            for (int depthCount = 0; depthCount < maxDepth; depthCount++) {
                if (block.getRenderShape() == RenderShape.MODEL) {
                    break;
                }
                pos = pos.below();
                block = level().getBlockState(pos);
            }
            if (block.getRenderShape() != RenderShape.MODEL) {
                block = Blocks.AIR.defaultBlockState();
            }
            Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), hitX + 0.5D, hitY + 1.0D, hitZ + 0.5D, block, 10);
            fallingBlockEntity.push(0, 0.2D + getRandom().nextGaussian() * 0.15D, 0);
            level().addFreshEntity(fallingBlockEntity);
            AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
            List<LivingEntity> hit = level().getEntitiesOfClass(LivingEntity.class, selection);
            for (LivingEntity entity : hit) {
                if (!isAlliedTo(entity) && entity != this) {
                    boolean flag = entity.hurt(CMDamageTypes.causeMaledictioDamage(this), DMG() * damage + Math.min(DMG() * damage, entity.getMaxHealth() * hpdamage));
                    if (flag) {
                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, airborne * distance + level().random.nextDouble() * 0.15, 0.0D));

                    }
                }
            }
        }
    }

    private void MakeRingparticle(float vec, float math, int duration, int r, int g, int b, float a, float scale) {
        if (this.level().isClientSide) {
            float f = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
            float f1 = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
            double theta = (yBodyRot) * (Math.PI / 180);
            theta += Math.PI / 2;
            double vecX = Math.cos(theta);
            double vecZ = Math.sin(theta);
            this.level().addParticle(new RingParticleOptions(0f, (float) Math.PI / 2f, duration, r, g, b, a, scale, false, 2), getX() + vec * vecX + f * math, getY() + 0.02f, getZ() + vec * vecZ + f1 * math, 0, 0, 0);
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
                            this.level().addParticle(ModParticle.CURSED_FLAME.get(), d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private void masseffectParticle(float radius) {
        if (this.level().isClientSide) {
            for (int j = 0; j < 70; ++j) {
                float angle = (float) (Math.random() * 2 * Math.PI);
                double distance = Math.sqrt(Math.random()) * radius;
                double extraX = this.getX() + distance * Mth.cos(angle);
                double extraY = this.getY() + 0.3F;
                double extraZ = this.getZ() + distance * Mth.sin(angle);

                this.level().addParticle(ModParticle.PHANTOM_WING_FLAME.get(), extraX, extraY, extraZ, 0.0D, this.random.nextGaussian() * 0.04D, 0.0D);
            }
        }
    }

    private void Rushattack(double inflateXZ,double inflateY,  double range, float damage, float hpdamage, int shieldbreakticks, boolean maledictio) {
        double yaw = (yBodyRot) * (Math.PI / 180);
        yaw += Math.PI / 2;

        double xExpand = range * Math.cos(yaw);
        double zExpand = range * Math.sin(yaw);
        AABB attackRange = this.getBoundingBox().inflate(inflateXZ,inflateY,inflateXZ).expandTowards(xExpand, 0, zExpand);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entity) && entity != this) {
                DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, DMG() * damage + Math.min(DMG() * damage, entity.getMaxHealth() * hpdamage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
                if (flag) {
                    rageTicks = 200;
                    if (this.getRageMeter() < 5) {
                        setRageMeter(this.getRageMeter() + 1);
                    }
                }

            }
        }
    }

    private void uppercut(double inflate, double range, float damage, float hpdamage, int shieldbreakticks, boolean airborne) {
        double yaw = (yBodyRot) * (Math.PI / 180);
        yaw += Math.PI / 2;
        double xExpand = range * Math.cos(yaw);
        double zExpand = range * Math.sin(yaw);
        AABB attackRange = this.getBoundingBox().inflate(inflate).expandTowards(xExpand, 0, zExpand);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, attackRange)) {
            if (!isAlliedTo(entity) && entity != this) {
                DamageSource damagesource = this.damageSources().mobAttack(this);
                boolean flag = entity.hurt(damagesource, DMG() * damage + Math.min(DMG() * damage, entity.getMaxHealth() * hpdamage));
                if (entity.isDamageSourceBlocked(damagesource) && entity instanceof Player player  && shieldbreakticks > 0) {
                    disableShield(player, shieldbreakticks);
                }
                if (flag) {
                    rageTicks = 200;
                    if (this.getRageMeter() < 5) {
                        setRageMeter(this.getRageMeter() + 1);
                    }
                    if (airborne) {
                        double d0 = entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
                        double d1 = Math.max(0.0D, 1.0D - d0);
                        entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, (double) 0.4F * d1, 0.0D));
                    }
                }

            }
        }
    }


    private void AreaAttack(float range, float height, float arc, float damage, float hpdamage, int shieldbreakticks, boolean maledictio,boolean knockback) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.yBodyRot % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }
            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof Maledictus_Entity) && entityHit != this) {
                    DamageSource damagesource = maledictio ? CMDamageTypes.causeMaledictioDamage(this) : this.damageSources().mobAttack(this);
                    boolean flag = entityHit.hurt(damagesource, DMG() * damage + Math.min(DMG() * damage, entityHit.getMaxHealth() * hpdamage));
                    if (entityHit.isDamageSourceBlocked(damagesource) && entityHit instanceof Player player && shieldbreakticks > 0) {
                        disableShield(player, shieldbreakticks);
                    }
                    if (flag) {
                        rageTicks = 200;
                        if (this.getRageMeter() < 5) {
                            setRageMeter(this.getRageMeter() + 1);
                        }
                        double d0 = entityHit.getX() - this.getX();
                        double d1 = entityHit.getZ() - this.getZ();
                        double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                        if (knockback) {
                            entityHit.push(d0 / d2 * 2.5D, 0.18D, d1 / d2 * 2.2D);
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
        } else if (entityIn.getType().is(ModTag.TEAM_MALEDICTUS)) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.MALEDICTUS_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ModSounds.MALEDICTUS_DEATH.get();
    }

    protected SoundEvent getAmbientSound() {
        return ModSounds.MALEDICTUS_IDLE.get();
    }

    @Override
    public SoundEvent getBossMusic() {
        return ModSounds.MALEDICTUS_MUSIC.get();
    }

    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent1.addPlayer(player);
        this.bossEvent2.addPlayer(player);
    }

    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent1.removePlayer(player);
        this.bossEvent2.removePlayer(player);
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new SmartBodyHelper2(this);
    }

    static class Maledictus_Swing extends InternalAttackGoal {
        private final float attackminrange;
        private final float random;


        public Maledictus_Swing(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.attackminrange = attackminrange;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == 5) {
                if (target != null) {
                    double d0 = target.getX() - this.entity.getX();
                    double d1 = target.getY() - this.entity.getY();
                    double d2 = target.getZ() - this.entity.getZ();
                    Vec3 vec3 = (new Vec3(d0, 0.7 + Mth.clamp(d1 * 0.075, 0.0, 10.0), d2)).multiply(0.2D, 1.0D, 0.2D);
                    this.entity.setDeltaMovement(vec3);
                } else {

                    Vec3 vec3 = (new Vec3(0, 0.7, 0));
                    this.entity.setDeltaMovement(vec3);
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }


    static class Maledictus_Bow extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final float attackminrange;
        private final int attackshot;
        private final float random;


        public Maledictus_Bow(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackminrange, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackminrange = attackminrange;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.getSensing().hasLineOfSight(target);
        }

        @Override
        public void start() {
            super.start();
            this.entity.setWeapon(1);
        }

        @Override
        public void stop() {
            super.stop();
            this.entity.setWeapon(0);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            super.tick();
            if (this.entity.attackTicks == attackshot) {
                if (target != null) {
                    double arrowcount = 4;
                    double offsetangle = Math.toRadians(6);

                    //update target pos
                    double d1 = target.getX() - this.entity.getX();
                    double d2 = target.getY(0.3333333333333333D) - this.entity.getY();
                    double d3 = target.getZ() - this.entity.getZ();

                    for (int i = 0; i <= (arrowcount - 1); ++i) {
                        double angle = (i - ((arrowcount - 1) / 2)) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);

                        Phantom_Arrow_Entity throwntrident = new Phantom_Arrow_Entity(this.entity.level(), this.entity, target);
                        throwntrident.setBaseDamage(CMConfig.MaledictusPhantomArrowbasedamage + CMConfig.MaledictusPhantomArrowbasedamage * this.entity.getRageMeter() * 0.05f);
                        throwntrident.shoot(x, d2 + distance * (double) 0.15F, z, 1.8F, 1);
                        this.entity.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.0F / (this.entity.getRandom().nextFloat() * 0.4F + 0.8F));
                        this.entity.level().addFreshEntity(throwntrident);

                    }

                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class Maledictus_Flying_Bow extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final int attackshot;
        private final float random;

        public Maledictus_Flying_Bow(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackshot = attackshot;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.flyattack_cooldown <= 0;
        }

        @Override
        public void start() {
            super.start();
            entity.setWeapon(1);
        }

        @Override
        public void stop() {
            super.stop();
            entity.setWeapon(0);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackshot && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 90.0F);
                entity.lookAt(target, 30.0F, 90.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }

            if (this.entity.attackTicks == 8) {
                if (target != null) {
                    double x = 0;
                    double z = 0;
                    double r = 0;
                    double maxR = 3.0;
                    if (entity.distanceToSqr(target) < 36D) {
                        float dodgeYaw = (float) Math.toRadians(entity.getYRot() + 90);
                        double dis = entity.distanceToSqr(target);
                        r = Mth.clamp(8 / (dis + 0.1), 0, maxR);
                        x = Math.cos(dodgeYaw);
                        z = Math.sin(dodgeYaw);
                    }

                    double d1 = target.getY() - this.entity.getY();
                    this.entity.setDeltaMovement(x * -r, 0.9 + Mth.clamp(d1 * 0.075, 0.0, 7.0), z * -r);
                } else {
                    this.entity.setDeltaMovement(0, 0.9, 0);
                }
                entity.setFlying(true);
            }
            if (this.entity.attackTicks == 20) {
                this.entity.setDeltaMovement(0, 0, 0);
            }
            if (this.entity.attackTicks == 60) {
                this.entity.setFlying(false);
            }
            if (this.entity.attackTicks == attackshot) {
                if (target != null) {
                    double arrowcount = 4;
                    double offsetangle = Math.toRadians(9);

                    //update target pos
                    double d1 = target.getX() - this.entity.getX();
                    double d2 = target.getY(0.3333333333333333D) - this.entity.getY();
                    double d3 = target.getZ() - this.entity.getZ();


                    for (int i = 0; i <= (arrowcount - 1); ++i) {
                        double angle = (i - ((arrowcount - 1) / 2)) * offsetangle;
                        double x = d1 * Math.cos(angle) + d3 * Math.sin(angle);
                        double z = -d1 * Math.sin(angle) + d3 * Math.cos(angle);
                        double distance = Math.sqrt(x * x + z * z);

                        Phantom_Arrow_Entity throwntrident = new Phantom_Arrow_Entity(this.entity.level(), this.entity, target);
                        throwntrident.setBaseDamage(CMConfig.MaledictusPhantomArrowbasedamage + CMConfig.MaledictusPhantomArrowbasedamage * this.entity.getRageMeter() * 0.05f);
                        throwntrident.shoot(x, d2 + distance * (double) 0.15F, z, 1.5F, 1);
                        this.entity.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.0F / (this.entity.getRandom().nextFloat() * 0.4F + 0.8F));
                        this.entity.level().addFreshEntity(throwntrident);

                    }
                }
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class MaledictusfallingState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startbow;
        private final int stopbow;
        private final int attackseetick;

        public MaledictusfallingState(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int startbow, int stopbow) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.attackseetick = attackseetick;
            this.startbow = startbow;
            this.stopbow = stopbow;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startbow);
            if (entity.isFlying()) {
                entity.setFlying(false);
            }
        }

        @Override
        public void tick() {
            entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 0F);
                entity.lookAt(target, 30.0F, 0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }

        @Override
        public void stop() {
            super.stop();
            entity.flyattack_cooldown = FLYATTACK_COOLDOWN;
            entity.setWeapon(stopbow);
        }
    }

    static class Maledictus_Flying_Smash extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final int attackstrike;
        private final float random;
        private final double dropspeed;
        private final int startweapon;
        private final int stopweapon;

        public Maledictus_Flying_Smash(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, int attackshot, int startweapon, int stopweapon, float random,double dropspeed) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackstrike = attackshot;
            this.random = random;
            this.dropspeed = dropspeed;
            this.startweapon = startweapon;
            this.stopweapon = stopweapon;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return super.canUse() && target != null && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.flyattack_cooldown <= 0 ;
        }

        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void stop() {
            super.stop();
            entity.setFlying(false);
            entity.setWeapon(stopweapon);
            entity.flyattack_cooldown = FLYATTACK_COOLDOWN;
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackstrike && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 0F);
                entity.lookAt(target, 30.0F, 0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
            if (this.entity.attackTicks == 25) {
                this.entity.setDeltaMovement(0, 0.9, 0);

                if(target !=null) {
                    double d1 = target.getY() - this.entity.getY();
                    this.entity.setDeltaMovement(0, 0.9 + Mth.clamp(d1 * 0.075, 0.0, 7.0), 0);
                }else{
                    this.entity.setDeltaMovement(0, 0.9, 0);
                }
                entity.setFlying(true);
            }
            if (this.entity.attackTicks == attackstrike) {
                this.entity.setFlying(false);
                if (target != null) {
                    double Y = dropspeed * Math.abs(this.entity.getY() - target.getY());

                    double Z = 0.1f * (target.getZ() - this.entity.getZ());
                    double X = 0.1F * (target.getX() - this.entity.getX());
                    entity.setDeltaMovement(entity.getDeltaMovement().add(X, -1.0d * Y, Z));

                }
            }

        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }


    static class MaledictusSpinSlashes extends InternalAttackGoal {
        private final Maledictus_Entity entity;
        private final int startweapon;
        private final int stopweapon;
        private final int attackseetick;
        private final int attackseetick2;
        private final int attackseetick3;
        private final int attackchargetick1;
        private final int attackchargetick2;
        private final float random;

        public MaledictusSpinSlashes(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int attackseetick2, int attackseetick3, int attackchargetick1, int attackchargetick2, float attackrange, int startbow, int stopbow, float random) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick, attackrange);
            this.entity = entity;
            this.attackseetick = attackseetick;
            this.attackseetick2 = attackseetick2;
            this.attackseetick3 = attackseetick3;
            this.attackchargetick1 = attackchargetick1;
            this.attackchargetick2 = attackchargetick2;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));

        }

        @Override
        public boolean canUse() {
            return super.canUse() && this.entity.getRandom().nextFloat() * 100.0F < random && entity.spin_cooldown  <= 0;
        }

        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null ||
                    entity.attackTicks > attackseetick2 && target != null && entity.attackTicks < attackseetick3) {
                entity.getLookControl().setLookAt(target, 60.0F, 30F);
                entity.lookAt(target, 60.0F, 30F);
            } else {
                entity.setYRot(entity.yRotO);
            }

            if (entity.attackTicks == attackchargetick1 || entity.attackTicks == attackchargetick2) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYRot() + 90));
                if (target != null) {
                    float r = entity.distanceTo(target);
                    r = Mth.clamp(r, 2.5F, 6.5F);
                    entity.push(f1 * 0.35f * r, 0, f2 * 0.35f * r);
                } else {
                    entity.push(f1 * 2.25, 0, f2 * 2.25);
                }

            }


        }

        @Override
        public void stop() {
            super.stop();
            entity.setWeapon(stopweapon);
            entity.spin_cooldown = SPIN_COOLDOWN;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class MaledictusChargeGoal extends Goal {
        private final Maledictus_Entity entity;
        private final int getattackstate;
        private final float attackrange;
        private final float attackminrange;
        private final int startweapon;
        private final int stopweapon;
        private final int attackseetick;
        private final int attackseetick2;
        private final int attackchargetick;
        private final float random;


        public MaledictusChargeGoal(Maledictus_Entity entity, int getattackstate, int attackseetick, int attackseetick2, int attackchargetick, float attackminrange, float attackrange, int startbow, int stopbow, float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.attackrange = attackrange;
            this.attackminrange = attackminrange;
            this.attackseetick = attackseetick;
            this.attackseetick2 = attackseetick2;
            this.attackchargetick = attackchargetick;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) > attackminrange && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.charge_cooldown <= 0 && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getSensing().hasLineOfSight(target);
        }

        @Override
        public void start() {
            if (this.entity.isHalfHealth()) {
                this.entity.setAttackState(14);
            } else {
                this.entity.setAttackState(13);
            }
            entity.setWeapon(startweapon);
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.getAttackState() == 13 ? this.entity.attackTicks <= 65 : this.entity.attackTicks <= 55;
        }


        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null || entity.attackTicks > attackseetick2 && target != null) {
                entity.getLookControl().setLookAt(target, 60.0F, 30F);
                entity.lookAt(target, 60.0F, 30F);
            } else {
                entity.setYRot(entity.yRotO);
            }

            if (entity.attackTicks == attackchargetick) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYRot() + 90));
                if (target != null) {
                    float r = entity.distanceTo(target);
                    r = Mth.clamp(r, 0, 7);
                    entity.push(f1 * 0.9 * r, 0, f2 * 0.9 * r);
                } else {
                    entity.push(f1 * 3.0, 0, f2 * 3.0);
                }
            }

            if (this.entity.getAttackState() == 13) {
                if (entity.attackTicks == 34 && (entity.onGround() || entity.isInLava() || entity.isInWater())) {
                    float speed = -1.7f;
                    float dodgeYaw = (float) Math.toRadians(entity.getYRot() + 90);
                    Vec3 m = entity.getDeltaMovement().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                    entity.setDeltaMovement(m.x, 0.4, m.z);
                }
            }


        }

        @Override
        public void stop() {
            if (this.entity.getAttackState() == 14) {
                if (this.entity.isQuarterHealth()) {
                    this.entity.setAttackState(16);
                } else {
                    this.entity.setAttackState(15);
                }
            } else {
                this.entity.setAttackState(0);
                entity.charge_cooldown = CHARGE_COOLDOWN;
                entity.setWeapon(stopweapon);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }


    static class MaledictusChargeState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startweapon;
        private final int stopweapon;
        private final int attackseetick;
        private final int attackseetick2;
        private final int attackchargetick;
        private final int backsteptick;
        private final int count;


        public MaledictusChargeState(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int attackseetick2, int attackchargetick, int backsteptick, int startbow, int stopbow, int count) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.attackseetick = attackseetick;
            this.attackseetick2 = attackseetick2;
            this.attackchargetick = attackchargetick;
            this.backsteptick = backsteptick;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.count = count;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null || entity.attackTicks > attackseetick2 && target != null) {
                entity.getLookControl().setLookAt(target, 60.0F, 30F);
                entity.lookAt(target, 60.0F, 30F);
            } else {
                entity.setYRot(entity.yRotO);
            }

            if (entity.attackTicks == attackchargetick) {
                float f1 = (float) Math.cos(Math.toRadians(entity.getYRot() + 90));
                float f2 = (float) Math.sin(Math.toRadians(entity.getYRot() + 90));
                if (target != null) {
                    float r = entity.distanceTo(target);
                    r = Mth.clamp(r, 0, 7);
                    entity.push(f1 * 0.9f * r, 0, f2 * 0.9f * r);
                } else {
                    entity.push(f1 * 3.0, 0, f2 * 3.0);
                }
            }

            if (backsteptick > 0 && entity.attackTicks == backsteptick && (entity.onGround() || entity.isInLava() || entity.isInWater())) {
                float speed = -1.7f;
                float dodgeYaw = (float) Math.toRadians(entity.getYRot() + 90);
                Vec3 m = entity.getDeltaMovement().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                entity.playSound(ModSounds.MALEDICTUS_JUMP.get(), 1F, 1.0f);
                entity.setDeltaMovement(m.x, 0.4, m.z);
            }
        }

        @Override
        public void stop() {
            if (this.count == 1) {
                if (this.entity.isQuarterHealth()) {
                    this.entity.setAttackState(16);
                } else {
                    this.entity.setAttackState(15);
                }
            } else if (this.count == 2 && this.entity.getAttackState() == 16) {
                this.entity.setAttackState(17);
            } else {
                super.stop();
                entity.charge_cooldown = CHARGE_COOLDOWN;
                entity.setWeapon(stopweapon);
            }
        }
    }


    static class Uppercut extends Goal {
        protected final Maledictus_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;
        private final float random;

        public Uppercut(Maledictus_Entity entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange,float random) {
            this.entity = entity;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
            this.random = random;
        }


        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getSensing().hasLineOfSight(target) && this.entity.getRandom().nextFloat() * 100.0F < random && this.entity.uppercut_cooldown <= 0;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
        }

        @Override
        public void stop() {
            entity.uppercut_cooldown = UPPERCUT_COOLDOWN;
            this.entity.setAttackState(attackendstate);
        }

        @Override
        public boolean canContinueToUse() {
            return this.entity.attackTicks <= attackMaxtick && this.entity.getAttackState() == attackstate;
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 60.0F, 30.0F);
                entity.lookAt(target, 60.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }


    static class MaledictusGrabGoal extends Goal {

        protected final Maledictus_Entity entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;
        private final float random;
        private final int startweapon;
        private final int stopweapon;

        public MaledictusGrabGoal(Maledictus_Entity entity, int getattackstate, int attackstate, int attackendstate,int attackMaxtick, int attackseetick, float attackrange, int startbow, int stopbow, float random) {
            this.entity = entity;
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackrange = attackrange;
            this.attackseetick = attackseetick;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.random = random;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.JUMP));
        }

        @Override
        public boolean canUse() {
            LivingEntity target = entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < attackrange && this.entity.getAttackState() == getattackstate && this.entity.getRandom().nextFloat() * 100.0F < random  && this.entity.grab_cooldown <= 0 ;
        }


        @Override
        public void start() {
            this.entity.setAttackState(attackstate);
            entity.setWeapon(startweapon);
        }

        @Override
        public void stop() {
            this.entity.setAttackState(attackendstate);
            entity.grab_cooldown = GRAB_COOLDOWN;
            entity.setWeapon(stopweapon);
        }

        @Override
        public boolean canContinueToUse() {
            return  this.entity.getAttackState() == attackstate && this.entity.attackTicks <= attackMaxtick;
        }


        public void tick() {
            LivingEntity target = entity.getTarget();
            if (entity.attackTicks < attackseetick && target != null) {
                entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                entity.lookAt(target, 30.0F, 30.0F);
            } else {
                entity.setYRot(entity.yRotO);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    static class MaledictusGrabState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startweapon;
        private final int stopweapon;

        public MaledictusGrabState(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int startbow, int stopbow) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }


        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse() && !entity.grab;
        }

        @Override
        public void tick() {
            if(this.entity.onGround()){
                Vec3 vector3d = entity.getDeltaMovement();
                float f = entity.getYRot() * ((float)Math.PI / 180F);
                Vec3 vector3d1 = new Vec3(-Mth.sin(f), entity.getDeltaMovement().y, Mth.cos(f)).scale(0.8D).add(vector3d.scale(0.8D));
                entity.setDeltaMovement(vector3d1.x, entity.getDeltaMovement().y, vector3d1.z);
            }
        }


        @Override
        public void stop() {
            if (entity.grab) {
                entity.setAttackState(31);
                entity.grab = false;
            } else {
                super.stop();
            }
            entity.setWeapon(stopweapon);
        }


    }


    static class MaledictusSuccessState extends InternalStateGoal {
        private final Maledictus_Entity entity;
        private final int startweapon;
        private final int stopweapon;
        private final int attackstrike;
        private final double dropspeed;

        public MaledictusSuccessState(Maledictus_Entity entity, int getAttackState, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, int attackstrike, int startbow, int stopbow,double dropspeed) {
            super(entity, getAttackState, attackstate, attackendstate, attackMaxtick, attackseetick);
            this.entity = entity;
            this.attackstrike = attackstrike;
            this.startweapon = startbow;
            this.stopweapon = stopbow;
            this.dropspeed = dropspeed;
        }


        @Override
        public void start() {
            super.start();
            entity.setWeapon(startweapon);
        }

        @Override
        public void tick() {
            if (this.entity.attackTicks == 19) {
                this.entity.setDeltaMovement(0, 1.2, 0);
                entity.setFlying(true);
            }
            entity.setDeltaMovement(0, entity.getDeltaMovement().y, 0);
            if (this.entity.attackTicks == attackstrike) {
                this.entity.setFlying(false);
            }
        }

        @Override
        public void stop() {
            super.stop();
            entity.setWeapon(stopweapon);

        }
    }

}





