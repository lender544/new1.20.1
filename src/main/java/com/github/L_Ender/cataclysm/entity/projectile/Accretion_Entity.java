package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.Optional;


public class Accretion_Entity extends ThrowableProjectile {

    private static final EntityDataAccessor<Optional<BlockState>> BLOCK_STATE = SynchedEntityData.defineId(Accretion_Entity.class, EntityDataSerializers.OPTIONAL_BLOCK_STATE);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Accretion_Entity.class, EntityDataSerializers.FLOAT);


    public Accretion_Entity(EntityType<Accretion_Entity> type, Level world) {
        super(type, world);
    }

    public Accretion_Entity(EntityType<Accretion_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(BLOCK_STATE, Optional.empty());
        this.entityData.define(DAMAGE, 0F);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public void setBlockState(@Nullable BlockState state) {
        this.entityData.set(BLOCK_STATE, Optional.ofNullable(state));
    }

    @Nullable
    public BlockState getBlockState() {
        return (BlockState)((Optional)this.entityData.get(BLOCK_STATE)).orElse((Object)null);
    }


    public boolean shouldRiderSit() {
        return false;
    }
    public boolean isInWater() {
        return false;
    }

    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        if (!this.level().isClientSide) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag = false;
            if (entity1 instanceof LivingEntity) {
                if (!((entity == entity1) || (entity1.isAlliedTo(entity)))) {
                    LivingEntity livingentity = (LivingEntity) entity1;
                    DamageSource damagesource = this.damageSources().mobProjectile(this, livingentity);
                    flag = entity.hurt(damagesource, this.getDamage());
                    if (flag) {
                        if (entity.isAlive()) {
                            this.doEnchantDamageEffects(livingentity, entity);;
                        }
                        BlockState blockstate = this.getBlockState();
                        if (blockstate != null) {
                            this.level().levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, new BlockPos(this.blockPosition()), Block.getId(getBlockState()));
                        }
                        ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
                        // EarthQuakeSummon(8);
                        this.discard();
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().inWall(), 5.0F);
            }

            if (flag && entity instanceof LivingEntity) {
                int i = 2;

                ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), 20 * i, 1), this.getEffectSource());
            }

        }
    }


    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide) {
            BlockState blockstate = this.getBlockState();
            if (blockstate != null && !this.isVehicle()) {
                this.level().levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, new BlockPos(this.blockPosition()), Block.getId(getBlockState()));
            }
            ScreenShake_Entity.ScreenShake(level(), this.position(), 15, 0.05f, 0, 20);
            // EarthQuakeSummon(8);
            this.discard();
        }
    }


    protected void onHit(HitResult ray) {
        HitResult.Type hitresult$type = ray.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)ray);
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, ray.getLocation(), GameEvent.Context.of(this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)ray;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        BlockState blockstate = this.getBlockState();
        if (blockstate != null) {
            compound.put("AccretionBlockState", NbtUtils.writeBlockState(blockstate));
        }
        compound.putFloat("Damage", this.getDamage());
    }


    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        BlockState blockstate = null;
        if (compound.contains("AccretionBlockState", 10)) {
            blockstate = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), compound.getCompound("AccretionBlockState"));
            if (blockstate.isAir()) {
                blockstate = null;
            }
        }

        this.setBlockState(blockstate);
        this.setDamage(compound.getFloat("Damage"));
    }

    public double getPassengersRidingOffset() {
        return -0.49D;
    }

    @Override
    public void tick() {
        super.tick();

        BlockState block = this.getBlockState();
        if (block != null) {
            if (block.getRenderShape() != RenderShape.INVISIBLE) {
                Vec3 vec3 = this.getDeltaMovement();
                this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, block), this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0, 0, 0);
            }
        }

    }


    @Override
    protected float getGravity() {
        return 0.03F;
    }


    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
