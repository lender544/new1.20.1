package com.github.L_Ender.cataclysm.entity.effect;

import com.github.L_Ender.cataclysm.client.particle.StormParticle;
import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.UUID;

public class Void_Vortex_Entity extends Entity {

    protected static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Void_Vortex_Entity.class, EntityDataSerializers.INT);
    private boolean madeOpenNoise = false;
    private boolean madeCloseNoise = false;
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;


    public Void_Vortex_Entity(EntityType<?> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Void_Vortex_Entity(Level worldIn, double x, double y, double z, float p_i47276_8_, LivingEntity casterIn) {
        this(ModEntities.VOID_VORTEX.get(), worldIn);
        this.setOwner(casterIn);
        this.setLifespan(300);
        this.setYRot(p_i47276_8_ * (180F / (float)Math.PI));
        this.setPos(x, y, z);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    public void tick() {
        super.tick();
        if (this.tickCount == 1) {
            if(this.getLifespan() == 0){
                this.setLifespan(60);
            }
        }
        if(!madeOpenNoise){
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.playSound(SoundEvents.END_PORTAL_SPAWN, 1.0F, 1 + random.nextFloat() * 0.2F);
            madeOpenNoise = true;
        }

        if(Math.min(tickCount, this.getLifespan()) >= 16){
            if(level().isClientSide) {
                float r = 0.4F;
                float g = 0.1f;
                float b = 0.8f;
                this.level().addParticle((new StormParticle.OrbData(r, g, b,2.5F + random.nextFloat() * 0.9f,5 + random.nextFloat() * 0.9f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.level().addParticle((new StormParticle.OrbData(r, g, b,2.25f + random.nextFloat() * 0.6f,4.25F + random.nextFloat() * 0.6f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.level().addParticle((new StormParticle.OrbData(r, g, b,2f + random.nextFloat() * 0.45f,3.5F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.level().addParticle((new StormParticle.OrbData(r, g, b,1.5f + random.nextFloat() * 0.25f,2.75F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.level().addParticle((new StormParticle.OrbData(r, g, b,1.25f + random.nextFloat() * 0.25f,2.0F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.level().addParticle((new StormParticle.OrbData(r, g, b,1.0f + random.nextFloat() * 0.25f,1.25F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
                this.level().addParticle((new StormParticle.OrbData(r, g, b,0.75f + random.nextFloat() * 0.25f,0.5F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            }
            AABB screamBox = new AABB(this.getX() - 3f, this.getY(), this.getZ() - 3, this.getX() + 3, this.getY() + 15F, this.getZ() + 3F);

            for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, screamBox)) {
                if (entity instanceof Player && ((Player) entity).getAbilities().invulnerable) continue;
                if(entity != owner) {
                    Vec3 diff = entity.position().subtract(position().add(0, 0, 0));
                    diff = diff.normalize().scale(0.075);
                    entity.setDeltaMovement(entity.getDeltaMovement().add(0, -2, 0).subtract(diff));
                }
            }
        }

        this.setLifespan(this.getLifespan() - 1);
        if(this.getLifespan() <= 16){
            if(!madeCloseNoise){
                this.gameEvent(GameEvent.ENTITY_PLACE);
             //   this.playSound(AMSoundRegistry.VOID_PORTAL_CLOSE.get(), 1.0F, 1 + random.nextFloat() * 0.2F);
                madeCloseNoise = true;
            }


        }
        if (this.getLifespan() <= 0) {
            this.level().explode(this.owner, this.getX(), this.getY(), this.getZ(), 2.0F, false, Level.ExplosionInteraction.NONE);
            this.remove(RemovalReason.DISCARDED);
        }
    }


    public int getLifespan() {
        return this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.entityData.set(LIFESPAN, i);
    }

    public void setOwner(@Nullable LivingEntity p_19719_) {
        this.owner = p_19719_;
        this.ownerUUID = p_19719_ == null ? null : p_19719_.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUUID != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel)this.level()).getEntity(this.ownerUUID);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity)entity;
            }
        }

        return this.owner;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(LIFESPAN, 300);

    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setLifespan(compound.getInt("Lifespan"));
        if (compound.hasUUID("Owner")) {
            this.ownerUUID = compound.getUUID("Owner");
        }

    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Lifespan", getLifespan());
        if (this.ownerUUID != null) {
            compound.putUUID("Owner", this.ownerUUID);
        }

    }


}
