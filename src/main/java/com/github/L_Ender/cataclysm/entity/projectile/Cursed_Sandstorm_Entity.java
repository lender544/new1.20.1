package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.cataclysm.util.CMMathUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;

import javax.annotation.Nullable;
import java.util.UUID;

public class Cursed_Sandstorm_Entity extends CustomAbstractHurtingProjectile implements IEntityWithComplexSpawn {

    private float damage;

    private static final EntityDataAccessor<Boolean> TRACKING = SynchedEntityData.defineId(Cursed_Sandstorm_Entity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Cursed_Sandstorm_Entity.class, EntityDataSerializers.INT);

    private static final AnimationState EMPTY_ANIMATION_STATE = new AnimationState();
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState DespawnAnimationState = new AnimationState();


    private Vec3 power = Vec3.ZERO;

    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;
    private int animationTicks;
    private int lifeTicks = LIFE_TICKS;
    private static final int LIFE_TICKS = 290;

    private static final int SPAWN_ANIM_TICKS = 5;
    private static final int DESPAWN_ANIM_TICKS = 10;
    private static final double LAUNCH_POWER = 0.1D;
    private static final double HOMING_STRENGTH = 3.0D;
    private static final double POWER_LIMIT = 0.075D;
    private int timer;

    private int hit = 2;

    public Cursed_Sandstorm_Entity(EntityType<? extends Cursed_Sandstorm_Entity> type, Level level) {
        super(type, level);
    }

    public Cursed_Sandstorm_Entity(Level worldIn, LivingEntity entity) {
        this(ModEntities.CURSED_SANDSTORM.get(), worldIn);
        this.setOwner(entity);
    }

    public Cursed_Sandstorm_Entity(Level worldIn, LivingEntity entity, LivingEntity finalTarget) {
        this(ModEntities.CURSED_SANDSTORM.get(), worldIn);
        this.setOwner(entity);
        this.finalTarget = finalTarget;
    }

    public Cursed_Sandstorm_Entity(EntityType<? extends Cursed_Sandstorm_Entity> type,
                                   double x, double y, double z,
                                   double px, double py, double pz, Level level) {
        this(type, level);
        this.moveTo(x, y, z, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        this.setDeltaMovement(Vec3.ZERO);
        this.setPowerFromDirection(px, py, pz);
    }

    public Cursed_Sandstorm_Entity(LivingEntity shooter, double px, double py, double pz, Level level,
                                   float damage, LivingEntity finalTarget) {
        this(ModEntities.CURSED_SANDSTORM.get(), shooter.getX(), shooter.getY(), shooter.getZ(), px, py, pz, level);
        this.setOwner(shooter);
        this.setDamage(damage);
        this.finalTarget = finalTarget;
        this.setRot(shooter.getYRot(), shooter.getXRot());
    }




    @Override
    public void writeSpawnData(RegistryFriendlyByteBuf buffer) {



        CMMathUtil.writeOptionalVec3(buffer, this.power);
    }

    @Override
    public void readSpawnData(RegistryFriendlyByteBuf buffer) {

        this.power = CMMathUtil.readOptionalVec3(buffer);
    }



    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(TRACKING, false);
        p_326229_.define(STATE,0);
    }

    private void setPowerFromDirection(double x, double y, double z) {
        double length = Math.sqrt(x * x + y * y + z * z);
        if (length != 0.0D) {
            this.power = new Vec3(x / length * LAUNCH_POWER, y / length * LAUNCH_POWER, z / length * LAUNCH_POWER);
        }
    }

    public Vec3 getPower() {
        return this.power;
    }

    public void setPower(Vec3 power) {
        this.power = power;
    }

    @Override
    protected Vec3 computeAcceleration(Vec3 velocity) {
        return this.power;
    }

    public AnimationState getAnimationState(String input) {
        return switch (input) {
            case "spawn" -> this.SpawnAnimationState;
            case "despawn" -> this.DespawnAnimationState;
            default -> EMPTY_ANIMATION_STATE;
        };
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (STATE.equals(p_21104_)) {
            this.animationTicks = 0;
            switch (this.getState()) {
                case 0 -> this.stopAllAnimationStates();
                case 1 -> {
                    stopAllAnimationStates();
                    this.SpawnAnimationState.startIfStopped(this.tickCount);
                }
                case 2 -> {
                    stopAllAnimationStates();
                    this.DespawnAnimationState.startIfStopped(this.tickCount);
                }
            }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.DespawnAnimationState.stop();
        this.SpawnAnimationState.stop();
    }

    public int getState() {
        return entityData.get(STATE);
    }

    public void setState(int state) {
        this.animationTicks = 0;
        entityData.set(STATE, state);
    }

    public float getDamage() {
        return this.damage;
    }

    public void setDamage(float damage) {
       this.damage = damage;
    }

    public int getHit() {
        return this.hit;
    }

    public void setHit(int damage) {
        this.hit = damage;
    }


    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }



    public void addAdditionalSaveData(CompoundTag p_37357_) {
        super.addAdditionalSaveData(p_37357_);
        if (this.finalTarget != null) {
            p_37357_.putUUID("Target", this.finalTarget.getUUID());
        }
        p_37357_.putInt("timer", timer);
        p_37357_.putInt("hit", this.hit);
        p_37357_.putFloat("damage", this.getDamage());
        p_37357_.putBoolean("tracking", getTracking());
        p_37357_.putInt("state", this.getState());
    }

    public void readAdditionalSaveData(CompoundTag p_37353_) {
        super.readAdditionalSaveData(p_37353_);
        if (p_37353_.hasUUID("Target")) {
            this.targetId = p_37353_.getUUID("Target");
        }
        timer = p_37353_.getInt("timer");
        this.setTracking(p_37353_.getBoolean("fired"));
        this.setDamage(p_37353_.getFloat("damage"));
        this.setState(p_37353_.getInt("state"));
        this.setHit(p_37353_.getInt("hit"));
    }

    public void setTracking(boolean tracking) {
        this.entityData.set(TRACKING, tracking);
    }

    public boolean getTracking() {
        return this.entityData.get(TRACKING);
    }


    public void tick() {
        super.tick();

        if (!this.isRemoved()) {
            int state = this.getState();
            if (state > 0) {
                this.animationTicks++;
            }
            if (!this.level().isClientSide) {
                this.timer--;

                if (this.timer <= 0 && !this.getTracking()) {
                    this.setTracking(true);
                }

                if (state == 1 && this.animationTicks > SPAWN_ANIM_TICKS) {
                    this.setState(0);
                }

                if (this.lifeTicks > 0) {
                    this.lifeTicks--;
                } else if (state == 0) {
                    this.setState(2);
                }

                if (state == 2 && this.animationTicks > DESPAWN_ANIM_TICKS) {
                    this.discard();
                }
                if (this.finalTarget == null && this.targetId != null) {
                    this.finalTarget = ((ServerLevel) this.level()).getEntity(this.targetId);
                    if (this.finalTarget == null) {
                        this.targetId = null;
                    }
                }

                if (this.getTracking()) {
                    this.tickHoming();
                }
            }
        }


    }

    private void tickHoming() {
        Entity target = this.finalTarget;

        if (target != null && target.isAlive() && !(target instanceof Player && target.isSpectator())) {


            double distSqr = this.distanceToSqr(target);
            double dx = target.getX() - this.getX();
            double dy = target.getY() + target.getBbHeight() * 0.3F - this.getY();
            double dz = target.getZ() - this.getZ();

            double px = this.power.x + (dx / distSqr) * HOMING_STRENGTH;
            double py = this.power.y + (dy / distSqr) * HOMING_STRENGTH;
            double pz = this.power.z + (dz / distSqr) * HOMING_STRENGTH;

            this.power = new Vec3(
                    Mth.clamp((float) px, -POWER_LIMIT, POWER_LIMIT),
                    Mth.clamp((float) py, -POWER_LIMIT, POWER_LIMIT),
                    Mth.clamp((float) pz, -POWER_LIMIT, POWER_LIMIT)
            );
        }
    }

    public void setUp(int delay) {
        setTracking(false);
        timer = delay;
    }

    @Override
    protected void TrailParticle() {
        if (this.level().isClientSide) {
            RandomSource rand = this.random;
            float ran = 0.04F;
            float r = 0.09F + rand.nextFloat() * ran;
            float g = 0.42F + rand.nextFloat() * ran;
            float b = 0.35F + rand.nextFloat() * ran * 1.5F;

            this.level().addParticle(
                    new StormParticleOptions(r, g, b,
                            0.25F + rand.nextFloat() * 0.45F,
                            0.35F + rand.nextFloat() * 0.45F,
                            this.getId()),
                    this.getX(), this.getY(), this.getZ(), 0, 0, 0);
        }
    }


    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (this.level() instanceof ServerLevel serverlevel && this.getState() ==0) {
            Entity entity = result.getEntity();
            Entity owner = this.getOwner();
            boolean flag = false;

            if (owner instanceof LivingEntity livingOwner) {
                if (!(entity.getType().is(ModTag.TEAM_ANCIENT_REMNANT) && owner.getType().is(ModTag.TEAM_ANCIENT_REMNANT))) {
                    DamageSource damagesource = CMDamageTypes.causeMaledictioSagittaDamage(this,livingOwner);

                    flag = entity.hurt(damagesource, this.getDamage());
                    if (flag) {
                        if (entity.isAlive()) {
                            EnchantmentHelper.doPostAttackEffects(serverlevel, entity, damagesource);
                        }
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().magic(), this.getDamage());
            }

            if (flag) {
                if(getHit() <=1){
                    this.setState(2);
                }else{
                    this.setHit(this.getHit()-1);
                }

                if (entity instanceof LivingEntity living) {
                    living.addEffect(new MobEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 100, 1), this.getEffectSource());
                }
            }
        }
    }


    protected boolean canHitEntity(Entity p_36842_) {
        return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
    }

    protected float getInertia() {
        return 0.9F;
    }

    public boolean isPickable() {
        return false;
    }

    public float getPickRadius() {
        return 1.0F;
    }

    public boolean hurt(DamageSource p_37616_, float p_37617_) {
        return false;
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }


    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        this.setPowerFromDirection(packet.getXa(), packet.getYa(), packet.getZa());
    }
}


