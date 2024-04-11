package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

import javax.annotation.Nullable;


public class Void_Shard_Entity extends ThrowableItemProjectile {

    private BlockState lastState;

    private Entity ignoreEntity = null;

    public Void_Shard_Entity(EntityType<? extends Void_Shard_Entity> type, Level world) {
        super(type, world);
    }

    public Void_Shard_Entity(EntityType type, Level worldIn, LivingEntity throwerIn) {
        super(type, throwerIn, worldIn);

    }

    public Void_Shard_Entity(Level worldIn, LivingEntity throwerIn, double x, double y, double z, Vec3 movement, @Nullable Entity ignore) {
        super(ModEntities.VOID_SHARD.get(), x, y, z, worldIn);
        this.setOwner(throwerIn);
        this.setDeltaMovement(movement);
        this.ignoreEntity = ignore;
    }

    public Void_Shard_Entity(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(ModEntities.VOID_SHARD.get(), world);
    }



    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if (this.lastState != null) {
            tag.put("inBlockState", NbtUtils.writeBlockState(this.lastState));
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("inBlockState", 10)) {
            tag.put("inBlockState", NbtUtils.writeBlockState(this.lastState));
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.VOID_SHARD.get();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void onHitBlock(BlockHitResult hit) {
        this.lastState = this.level().getBlockState(hit.getBlockPos());
        super.onHitBlock(hit);
        Vec3 Vec3 = hit.getLocation().subtract(this.getX(), this.getY(), this.getZ());
        this.setDeltaMovement(Vec3);
        Vec3 Vec31 = Vec3.normalize().scale(getGravity());
        this.setPosRaw(this.getX() - Vec31.x, this.getY() - Vec31.y, this.getZ() - Vec31.z);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        Entity entity = result.getEntity();
        float i = 1.5f;
        if (shooter == null) {
            entity.hurt(this.damageSources().magic(), i);
            entity.invulnerableTime = 0;
        }else {
            if (!((entity == shooter) ||(shooter.isAlliedTo(entity)))) {
                entity.hurt(this.damageSources().indirectMagic(this, this.getOwner()), i);
                entity.invulnerableTime = 0;
            }
        }

    }

    public void shootFromRotation(Entity p_234612_1_, float p_234612_2_, float p_234612_3_, float p_234612_4_, float p_234612_5_, float p_234612_6_) {
        float f = (float) (-Math.sin(p_234612_3_ * ((float) Math.PI / 180F)) * Math.cos(p_234612_2_ * ((float) Math.PI / 180F)));
        float f1 = (float) -Math.sin((p_234612_2_ + p_234612_4_) * ((float) Math.PI / 180F));
        float f2 = (float) (Math.cos(p_234612_3_ * ((float) Math.PI / 180F)) * Math.cos(p_234612_2_ * ((float) Math.PI / 180F)));
        this.shoot(f, f1, f2, p_234612_5_, p_234612_6_);
        Vec3 Vec3 = p_234612_1_.getDeltaMovement();
        this.setDeltaMovement(this.getDeltaMovement().add(Vec3.x, p_234612_1_.onGround() ? 0.0D : Vec3.y, Vec3.z));
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        if(entity == ignoreEntity) return false;
        return super.canHitEntity(entity);
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
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(ModItems.VOID_SHARD.get())), this.getX(), this.getY(), this.getZ(), random.nextGaussian() * 0.1D, random.nextGaussian() * 0.1D, random.nextGaussian() * 0.1D);
            }
        }
    }
}
