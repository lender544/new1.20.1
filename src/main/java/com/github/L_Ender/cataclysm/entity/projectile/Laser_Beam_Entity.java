package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class Laser_Beam_Entity extends Projectile {
    public double accelerationPower;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Laser_Beam_Entity.class, EntityDataSerializers.FLOAT);


    public Laser_Beam_Entity(EntityType<? extends Laser_Beam_Entity> type, Level level) {
        super(type, level);
        this.accelerationPower = 0.1;
    }

    public Laser_Beam_Entity(EntityType<? extends Laser_Beam_Entity> type, double getX, double gety, double getz, Vec3 vec3, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }

    public Laser_Beam_Entity(LivingEntity p_36827_, Vec3 vec3, Level p_36831_, float damage) {
        this(ModEntities.LASER_BEAM.get(), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), vec3, p_36831_);
        this.setOwner(p_36827_);
        this.setDamage(damage);
    }

    public Laser_Beam_Entity(EntityType<? extends Laser_Beam_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, Vec3 vec3, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE,0f);
    }


    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }


    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
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
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.rotateTowardsMovement(this, 1.0F);
            float f = this.getInertia();
            this.setDeltaMovement(vec3.add(vec3.normalize().scale(this.accelerationPower)).scale((double)f));
            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
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
            if (!this.level().isClientSide) {
                this.discard();
            }
        }
    }


    protected boolean canHitEntity(Entity p_36842_) {
        return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
    }


    protected float getInertia() {
        return 1.0F;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDouble("acceleration_power");
        }

    }


    public boolean isPickable() {
        return false;
    }

    public float getPickRadius() {
        return 1.0F;
    }

    public boolean hurt(DamageSource p_37616_, float p_37617_) {
        return false;
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    


    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();

    }

    private void assignDirectionalMovement(Vec3 movement, double accelerationPower) {
        this.setDeltaMovement(movement.normalize().scale(accelerationPower));
        this.hasImpulse = true;
    }

    protected void onDeflection(@Nullable Entity entity, boolean deflectedByPlayer) {
        super.onDeflection(entity, deflectedByPlayer);
        if (deflectedByPlayer) {
            this.accelerationPower = 0.1;
        } else {
            this.accelerationPower *= (double)0.5F;
        }

    }
}


