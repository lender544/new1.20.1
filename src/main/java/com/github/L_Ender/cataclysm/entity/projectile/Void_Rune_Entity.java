package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.UUID;

public class Void_Rune_Entity extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    private int lifeTicks = 34;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final EntityDataAccessor<Boolean> ACTIVATE = SynchedEntityData.defineId(Void_Rune_Entity.class, EntityDataSerializers.BOOLEAN);

    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Void_Rune_Entity.class, EntityDataSerializers.FLOAT);

    public float activateProgress;
    public float prevactivateProgress;

    public Void_Rune_Entity(EntityType<? extends Void_Rune_Entity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }


    public Void_Rune_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_,float damage, LivingEntity casterIn) {
        this(ModEntities.VOID_RUNE.get(), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setYRot(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPos(x, y, z);
    }

    protected void defineSynchedData() {
        this.entityData.define(ACTIVATE, Boolean.valueOf(false));
        this.entityData.define(DAMAGE, 0F);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }


    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.caster = p_190549_1_;
        this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getCaster() {
        if (this.caster == null && this.casterUuid != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel)this.level()).getEntity(this.casterUuid);
            if (entity instanceof LivingEntity) {
                this.caster = (LivingEntity)entity;
            }
        }

        return this.caster;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readAdditionalSaveData(CompoundTag compound) {
        this.warmupDelayTicks = compound.getInt("Warmup");
        if (compound.hasUUID("Owner")) {
            this.casterUuid = compound.getUUID("Owner");
        }
        this.setDamage(compound.getFloat("damage"));
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }
        compound.putFloat("damage", this.getDamage());
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();
        prevactivateProgress = activateProgress;

        if (isActivate() && this.activateProgress > 0F) {
            this.activateProgress--;
        }

        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                --this.lifeTicks;
                if (!isActivate() && this.activateProgress < 10F) {
                    this.activateProgress++;
                }
                if (this.lifeTicks == 33) {
                    for(int i = 0; i < 80; ++i) {
                        BlockState block = level().getBlockState(blockPosition().below());
                        double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                        double d1 = this.getY() + 0.03D;
                        double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double) this.getBbWidth() * 0.5D;
                        double d3 = (this.random.nextGaussian() * 0.07D);
                        double d4 = (this.random.nextGaussian() * 0.07D);
                        double d5 = (this.random.nextGaussian() * 0.07D);
                        this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), d0, d1, d2, d3, d4, d5);
                    }
                }

                if (this.lifeTicks == 14) {
                    this.setActivate(true);
                    for(int i = 0; i < 12; ++i) {
                        double d0 = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * (double)this.getBbWidth() * 0.5D;
                        double d1 = this.getY() + 0.05D + this.random.nextDouble();
                        double d2 = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * (double)this.getBbWidth() * 0.5D;
                        double d3 = (this.random.nextDouble() * 2.0D - 1.0D) * 0.3D;
                        double d4 = 0.3D + this.random.nextDouble() * 0.3D;
                        double d5 = (this.random.nextDouble() * 2.0D - 1.0D) * 0.3D;
                        this.level().addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, d3, d4, d5);
                    }
                }
            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -10) {
                if(isActivate()) {
                    this.setActivate(false);
                }
            }
            if (this.warmupDelayTicks < -10 && this.warmupDelayTicks > -30) {
                for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D, 0.0D, 0.2D))) {
                    this.damage(livingentity);
                }
            }


            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent(this, (byte)4);
                this.sentSpikeEvent = true;
            }

            if (--this.lifeTicks < 0) {
                this.discard();
            }
        }

    }

    public boolean isActivate() {
        return this.entityData.get(ACTIVATE);
    }

    public void setActivate(boolean Activate) {
        this.entityData.set(ACTIVATE, Activate);
    }

    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            if (this.tickCount % 5 == 0) {
                if (livingentity == null) {
                    Hitentity.hurt(this.damageSources().magic(), this.getDamage());
                } else {
                    if (livingentity.isAlliedTo(Hitentity)) {
                        return;
                    }
                    Hitentity.hurt(this.damageSources().indirectMagic(this, livingentity), this.getDamage());
                }
            }
        }
    }


    /**
     * Handler for
     */
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.clientSideAttackStarted = true;
            if (!this.isSilent()) {
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.VOID_RUNE_RISING.get(), this.getSoundSource(), 0.5F, this.random.nextFloat() * 0.2F + 0.85F, false);
            }
        }

    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }



    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
