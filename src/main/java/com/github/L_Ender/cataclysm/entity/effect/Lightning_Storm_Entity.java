package com.github.L_Ender.cataclysm.entity.effect;



import com.github.L_Ender.cataclysm.client.particle.LightningParticle;
import com.github.L_Ender.cataclysm.client.particle.LightningStormParticle;
import com.github.L_Ender.cataclysm.client.particle.RingParticle;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.UUID;

public class Lightning_Storm_Entity extends Entity {
    public static final int STRIKE = 10;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Integer> R = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> G = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> B = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> SIZE = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DELAY = SynchedEntityData.defineId(Lightning_Storm_Entity.class, EntityDataSerializers.INT);



    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;

    public Lightning_Storm_Entity(EntityType<? extends Lightning_Storm_Entity> entityType, Level level) {
        super(entityType, level);
    }

    public Lightning_Storm_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_, float damage,float Hpdamage, LivingEntity casterIn,int r, int g, int b,float size) {
        this(ModEntities.LIGHTNING_STORM.get(), worldIn);
        this.setDelay(p_i47276_9_);
        this.setCaster(casterIn);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.setYRot(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPos(x, y, z);
        this.setR(r);
        this.setG(g);
        this.setB(b);
        this.setSize(size);
    }


    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DAMAGE, 0F);
        this.entityData.define(HPDAMAGE, 0F);
        this.entityData.define(SIZE, 0F);
        this.entityData.define(LIFESPAN, 0);
        this.entityData.define(DELAY, 0);
        this.entityData.define(R, 0);
        this.entityData.define(G, 0);
        this.entityData.define(B, 0);
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


    public int getLifespan()
    {
        return this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int lifespan)
    {
        this.entityData.set(LIFESPAN, lifespan);
    }

    public int getDelay()
    {
        return this.entityData.get(DELAY);
    }

    public void setDelay(int delay)
    {
        this.entityData.set(DELAY, delay);
    }

    public int getB()
    {
        return this.entityData.get(B);
    }

    public void setB(int b)
    {
        this.entityData.set(B, b);
    }

    public float getSize()
    {
        return this.entityData.get(SIZE);
    }

    public void setSize(float size) {
        if (!this.level().isClientSide) {
            this.getEntityData().set(SIZE, Mth.clamp(size, 1.0F, 5.0F));
        }
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


    public void onSyncedDataUpdated(EntityDataAccessor<?> p_19729_) {
        if (SIZE.equals(p_19729_)) {
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(p_19729_);
    }

    public void refreshDimensions() {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        super.refreshDimensions();
        this.setPos(d0, d1, d2);
    }

    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }


    public EntityDimensions getDimensions(Pose p_19721_) {
        return EntityDimensions.scalable(this.getSize() * 0.5F, this.getSize() * 1.75F);
    }

    public void tick() {
        super.tick();

        setLifespan(this.getLifespan()+ 1);
        int adjustedLifespan = this.getLifespan() - this.getDelay();

        if (this.level().isClientSide) {
            if (adjustedLifespan == 2){
                this.level().addParticle(new RingParticle.RingData(0f, (float) Math.PI / 2f, 20, this.getR()/255F,this.getG()/255F,this.getB()/255F, 1f, this.getSize() * 6, false, RingParticle.EnumRingBehavior.SHRINK), getX(), getY() + 0.3f, getZ(), 0, 0, 0);
            }
            for (int i = STRIKE +1; i < 30; i = i + 2) {
                if (adjustedLifespan == i) {
                    smolder(1);
                }
            }
            if (adjustedLifespan == STRIKE){
                if (!this.isSilent()) {
                    this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.EMP_ACTIVATED.get(), this.getSoundSource(), 1.0F, this.random.nextFloat() * 0.2F + 0.85F, false);
                }
                double d0 = this.getX();
                double d1 = this.getY() + this.getSize() + 0.03D;
                double d2 = this.getZ();
                this.level().addAlwaysVisibleParticle(new LightningStormParticle.StormData(this.getR(),this.getG(),this.getB(),this.getSize()), d0, d1, d2, 0, 0, 0);
            }


        } else {
            if (adjustedLifespan == 11 || adjustedLifespan == 12 || adjustedLifespan == 13 || adjustedLifespan == 14){
                this.damageEntityLivingBaseNearby(0.1D);
            }
            if (adjustedLifespan > 20) {
                this.discard();
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
                Hitentity.hurt(CMDamageTypes.causeLightningDamage(this, livingentity), this.getDamage() + Hitentity.getMaxHealth() * this.getHpDamage());
            }
        }
    }


    public void handleEntityEvent(byte p_36935_) {
        super.handleEntityEvent(p_36935_);
    }


    private void smolder(int amount) {
        for (int i = 0; i < amount; i++) {
            final float velocity = 0.25F * this.getSize();
            float yaw = (float) (random.nextFloat() * 2 * Math.PI);

            float r = random.nextFloat() * 0.7F;
            float x = r * Mth.cos(yaw);
            float z = r * Mth.sin(yaw);

            float motionY = random.nextFloat() * 0.8F;
            float motionX = velocity * Mth.cos(yaw);
            float motionZ = velocity * Mth.sin(yaw);
            level().addParticle((new LightningParticle.OrbData(this.getR(), this.getG(), this.getB())), this.getX() + x, this.getY() + 0.1, this.getZ() + z, motionX, motionY, motionZ);
        }

    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("lifespan", this.getLifespan());
        compound.putInt("delay", this.getDelay());
        if (this.ownerUUID != null) {
            compound.putUUID("Owner", this.ownerUUID);
        }
        compound.putFloat("damage", this.getDamage());
        compound.putInt("r", this.getR());
        compound.putInt("g", this.getG());
        compound.putInt("b", this.getB());
        compound.putFloat("Hpdamage", this.getHpDamage());
        compound.putFloat("size", this.getSize());
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setLifespan(compound.getInt("lifespan"));
        this.setDelay(compound.getInt("delay"));
        if (compound.hasUUID("Owner")) {
            this.ownerUUID = compound.getUUID("Owner");
        }
        this.setDamage(compound.getFloat("damage"));
        this.setHpDamage(compound.getFloat("Hpdamage"));
        this.setR(compound.getInt("r"));
        this.setG(compound.getInt("g"));
        this.setB(compound.getInt("b"));
        this.setSize(compound.getFloat("size"));
    }


}
