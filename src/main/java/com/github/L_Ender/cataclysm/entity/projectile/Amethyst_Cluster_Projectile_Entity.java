package com.github.L_Ender.cataclysm.entity.projectile;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Amethyst_Cluster_Projectile_Entity extends ThrowableProjectile {

    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Amethyst_Cluster_Projectile_Entity.class, EntityDataSerializers.FLOAT);



    public Amethyst_Cluster_Projectile_Entity(EntityType<Amethyst_Cluster_Projectile_Entity> type, Level world) {
        super(type, world);
    }

    public Amethyst_Cluster_Projectile_Entity(EntityType<Amethyst_Cluster_Projectile_Entity> type, Level world, LivingEntity thrower,float damage) {
        super(type, thrower, world);
        this.setDamage(damage);
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

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.playSound(SoundEvents.GLASS_BREAK, 1.1F, 0.8F);
            this.discard();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE, 0F);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("damage", this.getDamage());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setDamage(compound.getFloat("damage"));
    }

    @Override
    protected double getDefaultGravity() {
        return 0.03F;
    }
    
    
    

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for(int i = 0; i < 20; ++i) {
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.AMETHYST_CLUSTER.defaultBlockState()), this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D);
            }
        }
    }
}