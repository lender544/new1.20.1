package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public class Ender_Guardian_Bullet_Entity extends AbstractHurtingProjectile {
    //Projectile goes to a point over a set duration, then activates and accelerates in a given straight line
    private double dirX, dirY, dirZ;
    private double startX, startY, startZ;
    private int timer;
    private boolean fired;

    public Ender_Guardian_Bullet_Entity(EntityType<? extends Ender_Guardian_Bullet_Entity> type, Level world) {
        super(type, world);
    }

    public Ender_Guardian_Bullet_Entity(Level worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(ModEntities.ENDER_GUARDIAN_BULLET.get(), shooter, accelX, accelY, accelZ, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!level().isClientSide && fired) {
            Entity entity = result.getEntity();
            Entity Shooter = this.getOwner();
            LivingEntity livingentity = Shooter instanceof LivingEntity ? (LivingEntity)Shooter : null;
            boolean flag = entity.hurt(damageSources().mobProjectile(this, livingentity), 6.0F);
            if (flag) {
                this.doEnchantDamageEffects(livingentity, entity);
                if (entity instanceof LivingEntity) {
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100));
                }
            }
        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if(fired) {
            ((ServerLevel) this.level()).sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 2, 0.2D, 0.2D, 0.2D, 0.0D);
            this.playSound(SoundEvents.SHULKER_BULLET_HIT, 1.0F, 1.0F);
        }
    }


    protected void onHit(HitResult result) {
        super.onHit(result);
        if(fired) {
            this.discard();
        }
    }

    public void setUp(int delay, double dirX, double dirY, double dirZ, double startX, double startY, double startZ) {
        fired = false;
        timer = delay;
        this.dirX = dirX;
        this.dirY = dirY;
        this.dirZ = dirZ;
        this.startX = startX;
        this.startY = startY;
        this.startZ = startZ;
    }

    public void setUpTowards(int delay, double startX, double startY, double startZ, double endX, double endY, double endZ, double speed) {
        Vec3 vec = new Vec3(endX - startX, endY - startY, endZ - startZ).normalize().scale(speed);
        setUp(delay, vec.x, vec.y, vec.z, startX, startY, startZ);
    }

    public void tick() {
        if (!this.level().isClientSide) {
            timer--;
            if (timer <= 0) {
                if (fired) discard();
                else {
                    fired = true;
                    setDeltaMovement(new Vec3(0, 0, 0));
                    timer = 30;
                }
            }
            Vec3 DeltaMovement = getDeltaMovement();
            double d0 = getX();
            double d1 = getY();
            double d2 = getZ();

            if (fired) {
                if (DeltaMovement.lengthSqr() <= 16) setDeltaMovement(DeltaMovement.add(dirX * 0.1, dirY * 0.1, dirZ * 0.1));
            } else {
                setDeltaMovement(new Vec3(startX - d0, startY - d1, startZ - d2).scale(1.0 / timer));
            }
        }

        // Started from copy of the above tick
        Entity shooter = this.getOwner();
        if (level().isClientSide || (shooter == null || !shooter.isRemoved()) && level().hasChunkAt(this.blockPosition())) {
            HitResult HitResult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
            if (HitResult.getType() != net.minecraft.world.phys.HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, HitResult)) {
                onHit(HitResult);
            }

            checkInsideBlocks();
            Vec3 Vec3 = getDeltaMovement();
            double d0 = getX() + Vec3.x;
            double d1 = getY() + Vec3.y;
            double d2 = getZ() + Vec3.z;
            ProjectileUtil.rotateTowardsMovement(this, 0.2F);
            this.level().addParticle(ParticleTypes.END_ROD, this.getX() - Vec3.x, this.getY() - Vec3.y + 0.15D, this.getZ() - Vec3.z, 0.0D, 0.0D, 0.0D);
            setPos(d0, d1, d2);
        } else {
            discard();
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("DX", dirX);
        compound.putDouble("DY", dirY);
        compound.putDouble("DZ", dirZ);
        compound.putDouble("SX", startX);
        compound.putDouble("SY", startY);
        compound.putDouble("SZ", startZ);
        compound.putInt("Timer", timer);
        compound.putBoolean("Fired", fired);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        dirX = compound.getDouble("DX");
        dirY = compound.getDouble("DY");
        dirZ = compound.getDouble("DZ");
        startX = compound.getDouble("SX");
        startY = compound.getDouble("SY");
        startZ = compound.getDouble("SZ");
        timer = compound.getInt("Timer");
        fired = compound.getBoolean("Fired");
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean hurt(DamageSource source, float amount)
    {
        if(!this.level().isClientSide && fired)
        {
            this.playSound(SoundEvents.SHULKER_BULLET_HURT, 1.0F, 1.0F);
            ((ServerLevel)this.level()).sendParticles(ParticleTypes.CRIT, this.getX(), this.getY(), this.getZ(), 15, 0.2D, 0.2D, 0.2D, 0.0D);
            this.discard();
        }

        return true;
    }


    @Nonnull
    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
