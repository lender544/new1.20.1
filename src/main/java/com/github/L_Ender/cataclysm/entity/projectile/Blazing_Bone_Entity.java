package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;


public class Blazing_Bone_Entity extends ThrowableItemProjectile {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Blazing_Bone_Entity.class, EntityDataSerializers.FLOAT);


    public Blazing_Bone_Entity(EntityType<? extends Blazing_Bone_Entity> type, Level world) {
        super(type, world);
    }

    public Blazing_Bone_Entity(Level worldIn,float damage, LivingEntity throwerIn) {
        super(ModEntities.BLAZING_BONE.get(), throwerIn, worldIn);
        this.setDamage(damage);
    }

    @Override
    protected void defineSynchedData() {
        this.getEntityData().define(DAMAGE, 0F);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage", this.getDamage());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setDamage(tag.getFloat("damage"));
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BLAZING_BONE.get();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        Entity entity = result.getEntity();
        if (shooter instanceof LivingEntity) {
            if (!((entity == shooter) || (shooter.isAlliedTo(entity)))) {
                entity.hurt(this.damageSources().mobProjectile(this, (LivingEntity) shooter), this.getDamage());
            }
        }else{
            entity.hurt(this.damageSources().magic(),this.getDamage());
        }
    }

    @Override
    public boolean isNoGravity() {
        return false;
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(ModItems.BLAZING_BONE.get())), this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D);
            }
        }
    }
}
