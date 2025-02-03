package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Laser_Beam_Entity extends Projectile {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Laser_Beam_Entity.class, EntityDataSerializers.FLOAT);


    public Laser_Beam_Entity(EntityType type, Level worldIn) {
        super(type, worldIn);
    }

    public Laser_Beam_Entity(EntityType type, double x, double y, double z, Level worldIn) {
        this(type, worldIn);
        this.setPos(x, y, z);
    }

    public Laser_Beam_Entity(Level worldIn, LivingEntity shooter) {
        this(ModEntities.LASER_BEAM.get(), shooter.getX(), shooter.getEyeY(), shooter.getZ(), worldIn);
        this.setOwner(shooter);
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE, 0f);
    }

    public boolean isOnFire() {
        return false;
    }

    @Override
    protected void onHitEntity(EntityHitResult p_37386_) {
        super.onHitEntity(p_37386_);
        if (this.level() instanceof ServerLevel serverlevel) {
            Entity entity1 = p_37386_.getEntity();
            Entity $$4 = this.getOwner();
            int $$5 = entity1.getRemainingFireTicks();
            entity1.igniteForSeconds(5.0F);
            DamageSource $$6 = CMDamageTypes.causeLaserDamage(this, $$4);
            if (!entity1.hurt($$6, getDamage())) {
                entity1.setRemainingFireTicks($$5);
            } else {
                EnchantmentHelper.doPostAttackEffects(serverlevel, entity1, $$6);
            }
        }
    }


    protected void onHitBlock(BlockHitResult p_37384_) {
        super.onHitBlock(p_37384_);
        if (!this.level().isClientSide) {
            Entity entity = this.getOwner();
            if(CMConfig.HarbingerLightFire) {
                BlockPos blockpos = p_37384_.getBlockPos().relative(p_37384_.getDirection());
                if (this.level().isEmptyBlock(blockpos)) {
                    this.level().setBlockAndUpdate(blockpos, BaseFireBlock.getState(this.level(), blockpos));
                }
            } else{
                if (!(entity instanceof Mob) || net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), entity)) {
                    BlockPos blockpos = p_37384_.getBlockPos().relative(p_37384_.getDirection());
                    if (this.level().isEmptyBlock(blockpos)) {
                        this.level().setBlockAndUpdate(blockpos, BaseFireBlock.getState(this.level(), blockpos));
                    }
                }
            }

        }
    }

    @Override
    protected void onHit(HitResult p_37628_) {
        super.onHit(p_37628_);
        if (!this.level().isClientSide) {
          //  this.level.explode(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, Explosion.BlockInteraction.NONE);
            this.discard();
        }

    }

    protected ClipContext.Block getClipType() {
        return ClipContext.Block.COLLIDER;
    }

    public void tick() {
        Entity entity = this.getOwner();
        if (this.level().isClientSide || (entity == null || !entity.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            super.tick();

            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity, this.getClipType());
            if (hitresult.getType() != HitResult.Type.MISS && !net.neoforged.neoforge.event.EventHooks.onProjectileImpact(this, hitresult)) {
                this.hitTargetOrDeflectSelf(hitresult);
            }

            this.checkInsideBlocks();
            Vec3 vec3 = this.getDeltaMovement();
            double k0 = this.getX() + vec3.x;
            double k1 = this.getY() + vec3.y;
            double k2 = this.getZ() + vec3.z;
            if (this.isInWater()) {
                for(int i = 0; i < 4; ++i) {
                    float f1 = 0.25F;
                    this.level().addParticle(ParticleTypes.BUBBLE, k0 - vec3.x * 0.25D, k1 - vec3.y * 0.25D, k2 - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
                }
            }

            if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
                double d0 = vec3.horizontalDistance();
                this.setYRot((float) (Mth.atan2(vec3.x, vec3.z) * (double) (180F / (float) Math.PI)));
                this.setXRot((float) (Mth.atan2(vec3.y, d0) * (double) (180F / (float) Math.PI)));
                this.yRotO = this.getYRot();
                this.xRotO = this.getXRot();
            }
            double d5 = vec3.x;
            double d6 = vec3.y;
            double d1 = vec3.z;

            double d7 = this.getX() + d5;
            double d2 = this.getY() + d6;
            double d3 = this.getZ() + d1;
            double d4 = vec3.horizontalDistance();

            this.setYRot((float) (Mth.atan2(d5, d1) * (double) (180F / (float) Math.PI)));
            this.setXRot((float) (Mth.atan2(d6, d4) * (double) (180F / (float) Math.PI)));
            this.setXRot(lerpRotation(this.xRotO, this.getXRot()));
            this.setYRot(lerpRotation(this.yRotO, this.getYRot()));
            float f = 0.99F;
            float f1 = 0.05F;
            float sqrt = (float)this.getDeltaMovement().length();
            if (sqrt < 0.1F) {
                this.discard();
            }
            this.setDeltaMovement(vec3.scale((double) f));

            this.setPos(d7, d2, d3);
        } else {
            this.discard();
        }
    }


    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public boolean isPickable() {
        return false;
    }

    public boolean hurt(DamageSource p_37616_, float p_37617_) {
        return false;
    }

}



