package com.github.L_Ender.cataclysm.entity.effect;

import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan.Abyss_Blast_Portal_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public class Abyss_Mark_Entity extends Entity {

    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;

    private static final EntityDataAccessor<Optional<UUID>> CREATOR_ID = SynchedEntityData.defineId(Abyss_Mark_Entity.class, EntityDataSerializers.OPTIONAL_UUID);

    protected static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Abyss_Mark_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Abyss_Mark_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Abyss_Mark_Entity.class, EntityDataSerializers.FLOAT);



    public Abyss_Mark_Entity(EntityType<?> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Abyss_Mark_Entity(Level worldIn, double x, double y, double z, int lifespan,float damage,float hpdamage, UUID casterIn, LivingEntity finalTarget) {
        this(ModEntities.ABYSS_MARK.get(), worldIn);
        this.setCreatorEntityUUID(casterIn);
        this.setLifespan(lifespan);
        this.setDamage(damage);
        this.setHpDamage(hpdamage);
        this.finalTarget = finalTarget;
        this.setPos(x, y, z);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    public void tick() {
        super.tick();
        updateMotion();
        Entity owner = getCreatorEntity();
        if (owner != null && !owner.isAlive()) discard();

        this.setLifespan(this.getLifespan() - 1);

        if (!this.level().isClientSide) {
            if (this.finalTarget == null && this.targetId != null) {
                this.finalTarget = ((ServerLevel) this.level()).getEntity(this.targetId);
                if (this.finalTarget == null) {
                    this.targetId = null;
                }
            }
        }

        if (this.getLifespan() <= 0) {
            if (owner != null){
                this.level().addFreshEntity(new Abyss_Blast_Portal_Entity(this.level(), this.getX(),  this.getY(),  this.getZ(), this.getYRot(), 0, this.getDamage(),this.getHpDamage(), (LivingEntity) owner));
            }
            this.remove(RemovalReason.DISCARDED);
        }
    }

    public int getLifespan() {
        return this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.entityData.set(LIFESPAN, i);
    }


    public UUID getCreatorEntityUUID() {
        return this.entityData.get(CREATOR_ID).orElse(null);
    }

    public void setCreatorEntityUUID(UUID id) {
        this.entityData.set(CREATOR_ID, Optional.ofNullable(id));
    }

    public Entity getCreatorEntity() {
        UUID uuid = getCreatorEntityUUID();
        if(uuid != null && !this.level().isClientSide){
            return ((ServerLevel) level()).getEntity(uuid);
        }
        return null;
    }

    private void updateMotion() {

        Vec3 vec3 = this.getDeltaMovement();
        double h0 = this.getX() + vec3.x;
        double h1 = this.getY() + vec3.y;
        double h2 = this.getZ() + vec3.z;

        if(finalTarget !=null && this.finalTarget.isAlive() || (this.finalTarget instanceof Player && !this.finalTarget.isSpectator())) {
            double dx = finalTarget.getX() - this.getX();
            double dz = finalTarget.getZ() - this.getZ();

            double p0 = Math.min(finalTarget.getY(), this.getY() - 50);
            double p1 = Math.max(finalTarget.getY() , this.getY());
            BlockPos blockpos = BlockPos.containing(finalTarget.getX(), p1, finalTarget.getZ());
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
                    break;
                }

                blockpos = blockpos.below();
            } while (blockpos.getY() >= Mth.floor(p0) - 1);

            this.setPos(h0,(double) blockpos.getY() + d0,h2);
            this.setDeltaMovement(vec3.add(dx, 0, dz).scale((double)0.05));
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(CREATOR_ID, Optional.empty());
        this.entityData.define(LIFESPAN, 300);
        this.entityData.define(DAMAGE, 0F);
        this.entityData.define(HPDAMAGE, 0F);
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

    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setLifespan(compound.getInt("Lifespan"));
        UUID uuid;
        if (compound.hasUUID("Owner")) {
            uuid = compound.getUUID("Owner");
        } else {
            String s = compound.getString("Owner");
            uuid = OldUsersConverter.convertMobOwnerIfNecessary(this.getServer(), s);
        }
        if (compound.hasUUID("Target")) {
            this.targetId = compound.getUUID("Target");
        }
        if (uuid != null) {
            try {
                this.setCreatorEntityUUID(uuid);} catch (Throwable ignored) {

            }
        }
        this.setDamage(compound.getFloat("damage"));
        this.setHpDamage(compound.getFloat("Hpdamage"));
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Lifespan", getLifespan());
       if (this.getCreatorEntityUUID() != null) {
           compound.putUUID("Owner", this.getCreatorEntityUUID());
        }
        if (this.finalTarget != null) {
            compound.putUUID("Target", this.finalTarget.getUUID());
        }
        compound.putFloat("damage", this.getDamage());
        compound.putFloat("Hpdamage", this.getHpDamage());
    }
}
