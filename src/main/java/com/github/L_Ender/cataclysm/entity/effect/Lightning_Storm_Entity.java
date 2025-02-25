package com.github.L_Ender.cataclysm.entity.effect;


import com.github.L_Ender.cataclysm.client.particle.Options.LightningParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.LightningStormParticleOptions;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.projectile.EvokerFangs;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class Lightning_Storm_Entity extends Entity {
    private int warmupDelayTicks;
    private boolean sentSpikeEvent;
    public int lifeTicks;
    private boolean clientSideAttackStarted;


    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Integer> R = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> G = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> B = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.INT);


    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;

    public Lightning_Storm_Entity(EntityType<? extends Lightning_Storm_Entity> entityType, Level level) {
        super(entityType, level);
        this.warmupDelayTicks = 34;
    }

    public Lightning_Storm_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, float damage,float Hpdamage, LivingEntity casterIn,int r, int g, int b) {
        this(ModEntities.LIGHTNING_STORM.get(), worldIn);
        this.warmupDelayTicks = p_i47276_9_;
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.setYRot(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPos(x, y, z);
        this.setR(r);
        this.setG(g);
        this.setB(b);
    }




    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE, 0F);
        p_326229_.define(HPDAMAGE, 0F);
        p_326229_.define(R, 0);
        p_326229_.define(G, 0);
        p_326229_.define(B, 0);
    }


    public int getR()
    {
        return this.entityData.get(R);
    }

    public void setR(int r)
    {
        this.entityData.set(R, r);
    }

    public int getG()
    {
        return this.entityData.get(G);
    }

    public void setG(int g)
    {
        this.entityData.set(G, g);
    }


    public int getB()
    {
        return this.entityData.get(B);
    }

    public void setB(int b)
    {
        this.entityData.set(B, b);
    }

    public void setCaster(@Nullable LivingEntity p_190549_1_) {
        this.owner = p_190549_1_;
        this.ownerUUID = p_190549_1_ == null ? null : p_190549_1_.getUUID();
    }

    @Nullable
    public LivingEntity getCaster() {
        if (this.owner == null && this.ownerUUID != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel)this.level()).getEntity(this.ownerUUID);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity)entity;
            }
        }

        return this.owner;
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public float getHpDamage() {
        return entityData.get(HPDAMAGE);
    }

    public void setHpDamage(float damage) {
        entityData.set(HPDAMAGE, damage);
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        double d0 = (double)64.0F * getViewScale();
        return distance < d0 * d0;
    }


    public void tick() {
        super.tick();


        if (this.level().isClientSide) {
            if (this.clientSideAttackStarted) {
                ++this.lifeTicks;
                if (this.lifeTicks < 12 && this.lifeTicks > 1) {
                    smolder(3);
                }
                if (this.lifeTicks == 1){
                    if (!this.isSilent()) {
                        this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.EMP_ACTIVATED.get(), this.getSoundSource(), 1.0F, this.random.nextFloat() * 0.2F + 0.85F, false);
                    }
                    double d0 = this.getX();
                    double d1 = this.getY() + 2.0D;
                    double d2 = this.getZ();
                    this.level().addAlwaysVisibleParticle(new LightningStormParticleOptions(this.getR(),this.getG(),this.getB()), d0, d1, d2, 0, 0, 0);
                }

            }
        } else {
            if (--this.warmupDelayTicks < 0) {
                if (this.warmupDelayTicks == -1 || this.warmupDelayTicks == -2 || this.warmupDelayTicks == -3 || this.warmupDelayTicks == -4) {
                    this.damageEntityLivingBaseNearby(0.1D);
                    ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 10);
                }

                if (!this.sentSpikeEvent) {
                    this.level().broadcastEntityEvent(this, (byte)4);
                    this.sentSpikeEvent = true;
                }

                if (++this.lifeTicks > 22) {
                    this.discard();
                }
            }
        }
    }


    public void damageEntityLivingBaseNearby(double radius) {
        AABB aabb = this.getBoundingBox().inflate(radius);
        AABB selection = new AABB(aabb.minX, this.getY() - 0.1D, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);

        for(LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, selection)) {
            damage(livingentity);
        }
    }


    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getCaster();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity) {
            if (livingentity == null) {
                Hitentity.hurt(this.damageSources().magic(), this.getDamage());
            } else {
                if (livingentity.isAlliedTo(Hitentity)) {
                    return;
                }
                Hitentity.hurt(CMDamageTypes.causeLightningDamage(this, livingentity), this.getDamage() + Hitentity.getMaxHealth() * this.getHpDamage() * 0.01F);
            }
        }
    }


    public void handleEntityEvent(byte p_36935_) {
        super.handleEntityEvent(p_36935_);
        if (p_36935_ == 4) {
            this.clientSideAttackStarted = true;
        }

    }


    private void smolder(int amount) {
        for (int i = 0; i < amount; i++) {
            final float velocity = 0.5F;
            float yaw = (float) (random.nextFloat() * 2 * Math.PI);

            float r = random.nextFloat() * 0.7F;
            float x = r * Mth.cos(yaw);
            float z = r * Mth.sin(yaw);

            float motionY = random.nextFloat() * 0.8F;
            float motionX = velocity * Mth.cos(yaw);
            float motionZ = velocity * Mth.sin(yaw);
            level().addParticle((new LightningParticleOptions(this.getR(), this.getG(), this.getB())), this.getX() + x, this.getY() + 0.1, this.getZ() + z, motionX, motionY, motionZ);
        }

    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.ownerUUID != null) {
            compound.putUUID("Owner", this.ownerUUID);
        }
        compound.putFloat("damage", this.getDamage());
        compound.putInt("r", this.getR());
        compound.putInt("g", this.getG());
        compound.putInt("b", this.getB());
        compound.putFloat("Hpdamage", this.getHpDamage());
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.hasUUID("Owner")) {
            this.ownerUUID = compound.getUUID("Owner");
        }
        this.setDamage(compound.getFloat("damage"));
        this.setHpDamage(compound.getFloat("Hpdamage"));
        this.setR(compound.getInt("r"));
        this.setG(compound.getInt("g"));
        this.setB(compound.getInt("b"));
    }


}
