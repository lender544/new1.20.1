package com.github.L_Ender.cataclysm.entity.effect;

import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ancient_Ancient_Remnant_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import com.github.L_Ender.cataclysm.entity.projectile.Death_Laser_Beam_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class Sandstorm_Entity extends Entity {

    protected static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Sandstorm_Entity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Float> OFFSET = SynchedEntityData.defineId(Sandstorm_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> CASTER = SynchedEntityData.defineId(Sandstorm_Entity.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Sandstorm_Entity.class, EntityDataSerializers.INT);
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState DespawnAnimationState = new AnimationState();
    @Nullable
    private LivingEntity owner;

    public Sandstorm_Entity(EntityType<?> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Sandstorm_Entity(Level worldIn, double x, double y, double z, int lifespan, float offset, LivingEntity casterIn) {
        this(ModEntities.SANDSTORM.get(), worldIn);
        this.setOwner(casterIn);
        this.setLifespan(lifespan);
        this.setPos(x, y, z);
        this.setState(1);
        this.setOffset(offset);
        if (!worldIn.isClientSide) {
            this.setCasterID(casterIn.getId());
        }
    }

    

    public void tick() {
        super.tick();
        updateMotion();
        Entity owner = getOwner();
        if (owner != null && !owner.isAlive()) discard();
        if(level().isClientSide) {
            float ran = 0.04f;
            float r = 0.89F + random.nextFloat() * ran;
            float g = 0.85f + random.nextFloat() * ran;
            float b = 0.69f + random.nextFloat() * ran * 1.5F;
            this.level().addParticle((new StormParticleOptions(r, g, b,2.75f + random.nextFloat() * 0.6f,3.75F + random.nextFloat() * 0.6f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            this.level().addParticle((new StormParticleOptions(r, g, b,2.5f + random.nextFloat() * 0.45f,3.0F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            this.level().addParticle((new StormParticleOptions(r, g, b,2.25f + random.nextFloat() * 0.45f,2.25F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            //this.level().addParticle((new StormParticleOptions(r, g, b,2.0f + random.nextFloat() * 0.45f,2.0f + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
           // this.level().addParticle((new StormParticleOptions(r, g, b,1.75f + random.nextFloat() * 0.45f,1.75F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            this.level().addParticle((new StormParticleOptions(r, g, b,1.25f + random.nextFloat() * 0.45f,1.25f + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);


        }
        if(this.getState() == 1) {
            if (this.getLifespan() < 295) {
                this.setState(0);
            }
        }
        if(this.getState() == 0) {
            if(this.getLifespan() < 10) {
                this.setState(2);
            }
        }

        if (!this.isSilent() && level().isClientSide) {
         //   Cataclysm.PROXY.playWorldSound(this, (byte) 2);
        }

        for(LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D, 0.0D, 0.2D))) {
            if (entity instanceof Player && ((Player) entity).getAbilities().invulnerable) continue;
            if(entity != owner) {
                if (entity.isAlive() && !entity.isInvulnerable() ) {
                    if (this.tickCount % 3 == 0) {
                        if (owner == null) {
                           boolean flag =  entity.hurt(this.damageSources().magic(), (float) CMConfig.Sandstormdamage);
                           if(flag) {
                               MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 200, 0);
                               entity.addEffect(effectinstance);
                           }
                        } else {
                            if (owner.isAlliedTo(entity)) {
                                return;
                            }
                            boolean flag = entity.hurt(this.damageSources().indirectMagic(this, owner), (float) CMConfig.Sandstormdamage);
                            if(flag) {
                                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 200, 0);
                                entity.addEffect(effectinstance);
                            }
                        }
                    }
                }
            }

        }

        this.setLifespan(this.getLifespan() - 1);

        if (this.getLifespan() <= 0) {
            //Cataclysm.PROXY.clearSoundCacheFor(this);
            this.remove(RemovalReason.DISCARDED);
        }
    }

    public int getLifespan() {
        return this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.entityData.set(LIFESPAN, i);
    }

    public float getOffset() {
        return this.entityData.get(OFFSET);
    }

    public void setOffset(float i) {
        this.entityData.set(OFFSET, i);
    }

    public int getCasterID() {
        return entityData.get(CASTER);
    }

    public void setCasterID(int id) {
        entityData.set(CASTER, id);
    }

    public void setOwner(@Nullable LivingEntity p_19719_) {
        this.owner = p_19719_;
        setCasterID(p_19719_ == null ? 0 : p_19719_.getId());
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && getCasterID() != 0 && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel)this.level()).getEntity(getCasterID());
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity)entity;
            }
        }


        return this.owner;
    }


    private void updateMotion() {
        Entity owner = getOwner();
        if(owner !=null) {
            if (owner instanceof Ancient_Ancient_Remnant_Entity || owner instanceof Ancient_Remnant_Entity) {
                Vec3 center = owner.position().add(0.0, 0, 0.0);
                float radius = 8;
                float speed = this.tickCount * 0.04f;
                float offset = this.getOffset();
                Vec3 orbit = new Vec3(center.x + Math.cos((double) (speed + offset)) * (double) radius, center.y, center.z + Math.sin((double) (speed + offset)) * (double) radius);
                this.moveTo(orbit);
            }
            if (owner instanceof Player) {
                Vec3 center = owner.position().add(0.0, 0, 0.0);
                float radius = 6;
                float speed = this.tickCount * 0.04f;
                float offset = this.getOffset();
                Vec3 orbit = new Vec3(center.x + Math.cos((double) (speed + offset)) * (double) radius, center.y, center.z + Math.sin((double) (speed + offset)) * (double) radius);
                this.moveTo(orbit);
            }

        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(CASTER, -1);
        p_326229_.define(LIFESPAN, 300);
        p_326229_.define(OFFSET,0f);
        p_326229_.define(STATE,0);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "spawn") {
            return this.SpawnAnimationState;
        } else if (input == "despawn") {
            return this.DespawnAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (STATE.equals(p_21104_)) {
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
        entityData.set(STATE, state);
    }


    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setLifespan(compound.getInt("Lifespan"));
        this.setCasterID(compound.getInt("CasterId"));
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Lifespan", getLifespan());
        compound.putInt("CasterId", getCasterID());
    }
}
