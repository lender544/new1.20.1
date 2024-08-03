package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AnimationState;
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

public class Phantom_Halberd_Entity extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    public int lifeTicks;
    private boolean clientSideAttackStarted;
    private LivingEntity caster;
    private UUID casterUuid;
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Phantom_Halberd_Entity.class, EntityDataSerializers.INT);

    public AnimationState OneAnimationState = new AnimationState();
    public AnimationState TwospawnAnimationState = new AnimationState();

    public AnimationState ThreespawnAnimationState = new AnimationState();

    public AnimationState FourspawnAnimationState = new AnimationState();

    public Phantom_Halberd_Entity(EntityType<? extends Phantom_Halberd_Entity> p_i50170_1_, Level p_i50170_2_) {
        super(p_i50170_1_, p_i50170_2_);
    }


    public Phantom_Halberd_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, LivingEntity casterIn) {
        this(ModEntities.PHANTOM_HALBERD.get(), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setYRot(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPos(x, y, z);
    }


    protected void defineSynchedData() {
        this.entityData.define(STATE,0);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "one") {
            return this.OneAnimationState;
        } else if (input == "two") {
            return this.TwospawnAnimationState;
        } else if (input == "three") {
            return this.ThreespawnAnimationState;
        } else if (input == "four") {
            return this.FourspawnAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        stopAllAnimationStates();
                        this.OneAnimationState.startIfStopped(this.tickCount);
                    }
                    case 2 -> {
                        stopAllAnimationStates();
                        this.TwospawnAnimationState.startIfStopped(this.tickCount);
                    }
                    case 3 -> {
                        stopAllAnimationStates();
                        this.ThreespawnAnimationState.startIfStopped(this.tickCount);
                    }
                    case 4 -> {
                        stopAllAnimationStates();
                        this.FourspawnAnimationState.startIfStopped(this.tickCount);
                    }

                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.OneAnimationState.stop();
        this.TwospawnAnimationState.stop();
        this.ThreespawnAnimationState.stop();
        this.FourspawnAnimationState.stop();

    }

    public int getState() {
        return entityData.get(STATE);
    }

    public void setState(int state) {
        entityData.set(STATE, state);
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

    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Warmup", this.warmupDelayTicks);
        if (this.casterUuid != null) {
            compound.putUUID("Owner", this.casterUuid);
        }

    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        super.tick();

        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                ++this.lifeTicks;
                if (this.lifeTicks < 70 && this.lifeTicks > 22) {
                    if(this.tickCount % 6 == 0) {
                        double d0 = this.getX();
                        double d1 = this.getY() + 0.5D + this.random.nextDouble();
                        double d2 = this.getZ();
                        double d3 = (this.random.nextDouble() * 2.0D - 1.0D) * 0.15D;
                        double d4 = 0.15D + this.random.nextDouble() * 0.15D;
                        double d5 = (this.random.nextDouble() * 2.0D - 1.0D) * 0.15D;
                        this.level().addParticle(ModParticle.CURSED_FLAME.get(), d0, d1 + 0.35D, d2, d3, d4, d5);

                    }
                }

            }
        } else if (--this.warmupDelayTicks < 0) {
            if (this.warmupDelayTicks == -10) {
                if(getState() == 0) {
                    this.setState(1 + random.nextInt(3));
                }
            }
            if (this.warmupDelayTicks < -12 && this.warmupDelayTicks > -34) {
                for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox())) {
                    this.damage(livingentity);
                }
            }


            if (!this.sentSpikeEvent) {
                this.level().broadcastEntityEvent(this, (byte)4);
                this.sentSpikeEvent = true;
            }

            if (++this.lifeTicks > 70) {
                this.discard();
            }
        }

    }


    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            if (this.tickCount % 5 == 0) {
                if (livingentity == null) {
                    Hitentity.hurt(this.damageSources().magic(), 12);
                } else {
                    if (livingentity.isAlliedTo(Hitentity)) {
                        return;
                    }
                    Hitentity.hurt(CMDamageTypes.causeMaledictioMagicaeDamage(this,livingentity), 12);
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
               // this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.VOID_RUNE_RISING.get(), this.getSoundSource(), 0.5F, this.random.nextFloat() * 0.2F + 0.85F, false);
            }
        }

    }


    public float getAnimationProgress(float p_36937_) {
        if (!this.clientSideAttackStarted) {
            return 0.0F;
        } else {
            int i = this.lifeTicks - 2;
            return i <= 0 ? 1.0F : 1.0F - ((float)i - p_36937_) / 20.0F;
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
