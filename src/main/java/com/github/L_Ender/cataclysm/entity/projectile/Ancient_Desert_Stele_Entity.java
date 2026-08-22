package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModParticle;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Ancient_Desert_Stele_Entity extends Entity implements IEntityWithComplexSpawn {

    private static final EntityDataAccessor<Boolean> ACTIVATE = SynchedEntityData.defineId(Ancient_Desert_Stele_Entity.class, EntityDataSerializers.BOOLEAN);

    private static final double GRAVITY = 0.05D;
    private static final double DRAG = 0.99D;
    private static final double TERMINAL_SPEED = 1.75D;
    private static final double PIERCE_INFLATE = 0.2D;

    private boolean sentSpikeEvent;
    private int lifeTicks = 70;
    private int warmup;
    private float damage;
    private float impactDamage = -1.0F;
    private float impactRadius = 2.5F;
    @Nullable
    private LivingEntity caster;
    @Nullable
    private UUID casterUuid;

    private final Set<Integer> alreadyHit = new HashSet<>();

    public Ancient_Desert_Stele_Entity(EntityType<? extends Ancient_Desert_Stele_Entity> type, Level level) {
        super(type, level);
        this.blocksBuilding = false;
    }

    public Ancient_Desert_Stele_Entity(Level level, double x, double y, double z, float yawRadians,
                                       int warmup, float damage, LivingEntity casterIn) {
        this(ModEntities.ANCIENT_DESERT_STELE.get(), level);
        this.setWarmUp(warmup);
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setYRot(yawRadians * (180F / (float) Math.PI));
        this.setPos(x, y, z);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(ACTIVATE, false);
    }

    @Override
    public void writeSpawnData(RegistryFriendlyByteBuf buf) {
        buf.writeVarInt(this.warmup);
        buf.writeFloat(this.impactRadius);
    }

    @Override
    public void readSpawnData(RegistryFriendlyByteBuf buf) {
        this.warmup = buf.readVarInt();
        this.impactRadius = buf.readFloat();
    }

    public boolean isActivate() {
        return this.entityData.get(ACTIVATE);
    }

    public void setActivate(boolean activate) {
        this.entityData.set(ACTIVATE, activate);
    }

    public int getWarmUp() {
        return this.warmup;
    }

    public void setWarmUp(int warmup) {
        this.warmup = warmup;
    }

    public float getDamage() {
        return this.damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getImpactDamage() {
        return this.impactDamage < 0.0F ? this.damage * 0.6F : this.impactDamage;
    }

    public void setImpactDamage(float impactDamage) {
        this.impactDamage = impactDamage;
    }

    public float getImpactRadius() {
        return this.impactRadius;
    }

    public void setImpactRadius(float impactRadius) {
        this.impactRadius = impactRadius;
    }

    public void setCaster(@Nullable LivingEntity casterIn) {
        this.caster = casterIn;
        this.casterUuid = casterIn == null ? null : casterIn.getUUID();
    }

    @Nullable
    public LivingEntity getCaster() {
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel serverLevel) {
            if (serverLevel.getEntity(this.casterUuid) instanceof LivingEntity living) {
                this.caster = living;
            }
        }
        return this.caster;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.warmup > 0) {
            this.tickWarmup();
        } else {
            this.tickFall();
        }
    }

    private void tickWarmup() {
        this.setDeltaMovement(Vec3.ZERO);
        this.warmup--;

        if (this.level() instanceof ServerLevel serverLevel) {
            if (!this.sentSpikeEvent && this.warmup < 10) {
                this.level().broadcastEntityEvent(this, (byte) 4);
                this.sentSpikeEvent = true;
            }

            if (this.warmup <= 0) {
                this.setActivate(true);
            }
        }
    }

    private void tickFall() {
        Vec3 delta = this.getDeltaMovement();
        this.move(MoverType.SELF, delta);

        this.hitEntitiesInPath();

        if (this.verticalCollision || this.onGround()) {
            this.impact();
        } else {
            double vy = Math.max((delta.y - GRAVITY) * DRAG, -TERMINAL_SPEED);
            this.setDeltaMovement(delta.x * DRAG, vy, delta.z * DRAG);

            if (!this.level().isClientSide && --this.lifeTicks < 0) {
                this.impact();
            }
        }
    }

    private void hitEntitiesInPath() {
        if (this.level() instanceof ServerLevel serverLevel) {
            LivingEntity shooter = this.getCaster();
            AABB sweep = this.getBoundingBox().inflate(PIERCE_INFLATE);

            for (Entity target : serverLevel.getEntities(this, sweep, this::canPierce)) {
                this.alreadyHit.add(target.getId());
                this.hurtTarget(serverLevel, shooter, target, this.getDamage());
            }
        }
    }

    private boolean canPierce(Entity target) {
        return target.isAlive()
                && target instanceof LivingEntity
                && target != this.getCaster()
                && !target.noPhysics
                && !target.isSpectator()
                && !this.alreadyHit.contains(target.getId());
    }

    private void impact() {
        if (this.level() instanceof ServerLevel serverLevel) {
            this.dealImpactDamage(serverLevel);
            this.spawnBreakEffects(serverLevel);
        }
        this.discard();
    }

    private void dealImpactDamage(ServerLevel serverLevel) {
        float radius = this.getImpactRadius();

        if (radius > 0.0F) {
            LivingEntity shooter = this.getCaster();
            AABB box = new AABB(this.getX() - radius, this.getY() - 1.0D, this.getZ() - radius,
                    this.getX() + radius, this.getY() + this.getBbHeight() + 1.0D, this.getZ() + radius);

            List<LivingEntity> victims = serverLevel.getEntitiesOfClass(LivingEntity.class, box,
                    EntitySelector.NO_CREATIVE_OR_SPECTATOR);

            for (LivingEntity victim : victims) {
                if (!this.alreadyHit.contains(victim.getId())) {
                    double dx = victim.getX() - this.getX();
                    double dz = victim.getZ() - this.getZ();
                    double reach = radius + victim.getBbWidth() * 0.5D;

                    if (dx * dx + dz * dz <= reach * reach) {
                        this.hurtTarget(serverLevel, shooter, victim, this.getImpactDamage());
                    }
                }
            }
        }
    }

    private void hurtTarget(ServerLevel serverLevel, @Nullable LivingEntity shooter, Entity target, float amount) {
        boolean flag = false;

        if (shooter != null) {
            if (shooter != target && !shooter.isAlliedTo(target)) {
                DamageSource damagesource = this.damageSources().mobProjectile(this, shooter);
                flag = target.hurt(damagesource, amount);

                if (flag && target.isAlive()) {
                    EnchantmentHelper.doPostAttackEffects(serverLevel, target, damagesource);
                }
            }
        } else {
            flag = target.hurt(this.damageSources().magic(), amount);
        }

        if (flag && target instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 200, 0));
        }
    }

    private void spawnBreakEffects(ServerLevel serverLevel) {
        BlockState state = Blocks.SANDSTONE.defaultBlockState();
        SoundType soundtype = state.getSoundType(this.level(), this.blockPosition(), null);

        this.playSound(soundtype.getBreakSound(), (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

        serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, state),
                this.getX(), this.getY() + this.getBbHeight() / 2.0D, this.getZ(),
                64, this.getBbWidth() / 2.0D, this.getBbHeight() / 2.0D, this.getBbWidth() / 2.0D, 1);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.level().addParticle(ModParticle.DESERT_GLYPH.get(),
                    this.getX(), this.getY() + 2, this.getZ(), 0.5D, 0, 0);
        }
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distSqr) {
        double d0 = this.getBoundingBox().getSize() * 4.0D;

        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return distSqr < d0 * d0;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }

    @Override
    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Warmup", this.warmup);
        compound.putInt("LifeTicks", this.lifeTicks);
        compound.putFloat("Damage", this.damage);
        compound.putFloat("ImpactDamage", this.impactDamage);
        compound.putFloat("ImpactRadius", this.impactRadius);
        compound.putBoolean("Activate", this.isActivate());

        if (this.casterUuid != null) {
            compound.putUUID("Caster", this.casterUuid);
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        this.warmup = compound.getInt("Warmup");
        this.lifeTicks = compound.contains("LifeTicks") ? compound.getInt("LifeTicks") : 70;
        this.damage = compound.getFloat("Damage");
        this.impactDamage = compound.contains("ImpactDamage") ? compound.getFloat("ImpactDamage") : -1.0F;
        this.impactRadius = compound.contains("ImpactRadius") ? compound.getFloat("ImpactRadius") : 2.5F;
        this.setActivate(compound.getBoolean("Activate"));

        if (compound.hasUUID("Caster")) {
            this.casterUuid = compound.getUUID("Caster");
        }
    }
}