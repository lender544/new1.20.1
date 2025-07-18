package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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


public class Urchin_Spike_Entity extends ThrowableItemProjectile {


    public Urchin_Spike_Entity(EntityType<? extends Urchin_Spike_Entity> type, Level world) {
        super(type, world);
    }

    public Urchin_Spike_Entity(Level worldIn, LivingEntity throwerIn) {
        super(ModEntities.URCHIN_SPIKE.get(), throwerIn, worldIn);
    }


    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.URCHIN_SPIKE.get();
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
        float i = (float) CMConfig.BlazingBonedamage;
        if (shooter instanceof LivingEntity) {
            if (!((entity == shooter) || (shooter.isAlliedTo(entity)))) {
                if(entity.hurt(this.damageSources().mobProjectile(this, (LivingEntity) shooter), i)) {
                    if (entity instanceof LivingEntity) {
                        ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0), this);
                    }
                }
            }
        }else{
            entity.hurt(this.damageSources().mobProjectile(this, null), i);
        }
    }

    @Override
    public boolean isNoGravity() {
        return false;
    }
    public boolean isInWater() {
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
                ItemStack itemstack = this.getItem();
                if (!itemstack.isEmpty()) {
                    this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemstack), this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D, random.nextGaussian() * 0.2D);
                }
            }
        }

    }

}
