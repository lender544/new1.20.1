package com.github.L_Ender.cataclysm.entity.projectile;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public abstract class AbstractElemental_Spear extends Projectile {
    public static final double INITAL_ACCELERATION_POWER = 0.1;
    public static final double DEFLECTION_SCALE = 0.5;
    public double accelerationPower = 0.1;

    private int lSteps;
    private double lx;
    private double ly;
    private double lz;
    private double lyr;
    private double lxr;
    private double lxd;
    private double lyd;
    private double lzd;

    protected AbstractElemental_Spear(EntityType<? extends AbstractElemental_Spear> entityType, Level level) {
        super(entityType, level);
    }

    protected AbstractElemental_Spear(
            EntityType<? extends AbstractElemental_Spear> entityType, double x, double y, double z, Level level
    ) {
        this(entityType, level);
        this.setPos(x, y, z);
    }

    public AbstractElemental_Spear(
            EntityType<? extends AbstractElemental_Spear> entityType, double x, double y, double z, Vec3 movement, Level level
    ) {
        this(entityType, level);
        this.moveTo(x, y, z, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        this.assignDirectionalMovement(movement, this.accelerationPower);
    }


    public AbstractElemental_Spear(EntityType<? extends AbstractElemental_Spear> entityType, LivingEntity owner, Vec3 movement, Level level) {
        this(entityType, owner.getX(), owner.getY(), owner.getZ(), movement, level);
        this.setOwner(owner);
        this.setRot(owner.getYRot(), owner.getXRot());
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326181_) {
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0;
        if (Double.isNaN(d0)) {
            d0 = 4.0;
        }

        d0 *= 64.0;
        return p_36837_ < d0 * d0;
    }

    protected ClipContext.Block getClipType() {
        return ClipContext.Block.COLLIDER;
    }

    @Override
    public void tick() {
        Entity entity = this.getOwner();
        super.tick();
        Vec3 vec3 = this.getDeltaMovement();
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        ProjectileUtil.rotateTowardsMovement(this, 1.0F);
        this.checkInsideBlocks();
        if ((entity == null || !entity.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity, this.getClipType());
            if (hitresult.getType() != HitResult.Type.MISS && !net.neoforged.neoforge.event.EventHooks.onProjectileImpact(this, hitresult)) {
                this.hitTargetOrDeflectSelf(hitresult);
            }
            this.setDeltaMovement(vec3.add(vec3.normalize().scale(this.accelerationPower)).scale((double)this.getInertia()));
            if (this.level().isClientSide) {
                if (this.lSteps > 0) {
                    double d5 = this.getX() + (this.lx - this.getX()) / (double) this.lSteps;
                    double d6 = this.getY() + (this.ly - this.getY()) / (double) this.lSteps;
                    double d7 = this.getZ() + (this.lz - this.getZ()) / (double) this.lSteps;
                    this.setYRot(Mth.wrapDegrees((float) this.lyr));
                    this.setXRot(this.getXRot() + (float) (this.lxr - (double) this.getXRot()) / (float) this.lSteps);
                    --this.lSteps;
                    this.setPos(d5, d6, d7);
                } else {
                    this.reapplyPosition();
                }
            } else {
                this.setPos(d0, d1, d2);
            }


        }else{
            this.discard();
        }
    }

    @Override
    public boolean hurt(DamageSource p_341896_, float p_341906_) {
        return !this.isInvulnerableTo(p_341896_);
    }

    @Override
    public void checkDespawn() {
        if (this.level().getDifficulty() == Difficulty.PEACEFUL) {
            this.discard();
        } else {
            Entity entity = this.level().getNearestPlayer(this, -1.0);
            if (entity != null) {
                double d0 = entity.distanceToSqr(this);
                int i = this.getType().getCategory().getDespawnDistance();
                int j = i * i;
                if (d0 > (double)j && this.removeWhenFarAway(d0)) {
                    this.discard();
                }
            }
        }
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return true;
    }

    @Override
    protected boolean canHitEntity(Entity p_36842_) {
        return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
    }


    protected float getInertia() {
        return 0.95F;
    }

    protected float getLiquidInertia() {
        return 0.95F;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDouble("acceleration_power");
        }
    }


    @Override
    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity p_entity) {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        Vec3 vec3 = p_entity.getPositionBase();
        return new ClientboundAddEntityPacket(
                this.getId(),
                this.getUUID(),
                vec3.x(),
                vec3.y(),
                vec3.z(),
                p_entity.getLastSentXRot(),
                p_entity.getLastSentYRot(),
                this.getType(),
                i,
                p_entity.getLastSentMovement(),
                0.0
        );
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        Vec3 vec3 = new Vec3(packet.getXa(), packet.getYa(), packet.getZa());
        this.setDeltaMovement(vec3);
    }

    protected void assignDirectionalMovement(Vec3 movement, double accelerationPower) {
        this.setDeltaMovement(movement.normalize().scale(accelerationPower));
        this.hasImpulse = true;
    }

    @Override
    public void lerpTo(double x, double y, double z, float yr, float xr, int steps) {
        this.lx = x;
        this.ly = y;
        this.lz = z;
        this.lyr = yr;
        this.lxr = xr;
        this.lSteps = steps;
        this.setDeltaMovement(this.lxd, this.lyd, this.lzd);
    }

    @Override
    public void lerpMotion(double lerpX, double lerpY, double lerpZ) {
        this.lxd = lerpX;
        this.lyd = lerpY;
        this.lzd = lerpZ;
        this.setDeltaMovement(this.lxd, this.lyd, this.lzd);
    }

    @Override
    protected void onDeflection(@Nullable Entity entity, boolean deflectedByPlayer) {
        super.onDeflection(entity, deflectedByPlayer);
        if (deflectedByPlayer) {
            this.accelerationPower = 0.1;
        } else {
            this.accelerationPower *= 0.5;
        }
    }
}