package com.github.L_Ender.cataclysm.entity.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public abstract class CustomAbstractHurtingProjectile extends AbstractHurtingProjectile {
    protected CustomAbstractHurtingProjectile(EntityType<? extends CustomAbstractHurtingProjectile> entityType, Level level) {
        super(entityType, level);
        this.accelerationPower = 0.1;
    }
    protected CustomAbstractHurtingProjectile(EntityType<? extends CustomAbstractHurtingProjectile> entityType, double x, double y, double z, Level level) {
        this(entityType, level);
        this.setPos(x, y, z);
    }

    public CustomAbstractHurtingProjectile(EntityType<? extends CustomAbstractHurtingProjectile> entityType, double x, double y, double z, Vec3 movement, Level level) {
        this(entityType, level);
        this.moveTo(x, y, z, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        this.assignDirectionalMovement(movement, this.accelerationPower);
    }

    public CustomAbstractHurtingProjectile(EntityType<? extends CustomAbstractHurtingProjectile> entityType, LivingEntity owner, Vec3 movement, Level level) {
        this(entityType, owner.getX(), owner.getY(), owner.getZ(), movement, level);
        this.setOwner(owner);
        this.setRot(owner.getYRot(), owner.getXRot());
    }


    @Override
    public void tick() {
        Entity entity = this.getOwner();

        if (this.level().isClientSide || (entity == null || !entity.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            this.sbtick();

            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity, this.getClipType());
            if (hitresult.getType() != HitResult.Type.MISS && !net.neoforged.neoforge.event.EventHooks.onProjectileImpact(this, hitresult)) {
                this.hitTargetOrDeflectSelf(hitresult);
            }

            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;

            ProjectileUtil.rotateTowardsMovement(this, this.RotationSpeed());
            WaterParticle(d0, d1, d2, vec3);

            this.setDeltaMovement(vec3.add(this.computeAcceleration(vec3)).scale((double) this.getInertia()));

            this.TrailParticle();

            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
    }
    protected Vec3 computeAcceleration(Vec3 velocity) {
        return velocity.normalize().scale(this.accelerationPower);
    }

    protected void WaterParticle(double x,double y,double z,Vec3 vec3){

        if(this.level().isClientSide) {
            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    this.level().addParticle(ParticleTypes.BUBBLE, x - vec3.x * 0.25D, y - vec3.y * 0.25D, z - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
                }
            }
        }

    }


    protected void TrailParticle(){

    }


    protected float RotationSpeed(){
        return 0.6F;
    }

    protected void sbtick() {
        if(!this.hasBeenShot) {
            this.gameEvent(GameEvent.PROJECTILE_SHOOT, this.getOwner());
            this.hasBeenShot = true;
        }
        if(!this.leftOwner) {
            this.leftOwner = this.checkLeftOwner();
        }
        this.baseTick();
    }


    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();
    }

    protected void assignDirectionalMovement(Vec3 movement, double accelerationPower) {
        this.setDeltaMovement(movement.normalize().scale(accelerationPower));
        this.hasImpulse = true;
    }
}
