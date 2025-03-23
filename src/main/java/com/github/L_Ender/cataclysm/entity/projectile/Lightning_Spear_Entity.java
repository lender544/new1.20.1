package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.particle.Options.CircleLightningParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.LightningParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.TrackLightningParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Area_Effect_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Storm_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class Lightning_Spear_Entity extends Projectile {
    public double accelerationPower;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Lightning_Spear_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> AREA_RADIUS = SynchedEntityData.defineId(Lightning_Spear_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> AREA_DAMAGE = SynchedEntityData.defineId(Lightning_Spear_Entity.class, EntityDataSerializers.FLOAT);
    public Lightning_Spear_Entity(EntityType<? extends Lightning_Spear_Entity> type, Level level) {
        super(type, level);
        this.accelerationPower = 0.1;
    }

    public Lightning_Spear_Entity(EntityType<? extends Lightning_Spear_Entity> type, double getX, double gety, double getz, Vec3 vec3, Level level) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        this.setOldPosAndRot();
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }

    public Lightning_Spear_Entity(LivingEntity p_36827_, Vec3 vec3, Level p_36831_, float damage) {
        this(ModEntities.LIGHTNING_SPEAR.get(), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), vec3, p_36831_);
        this.setOwner(p_36827_);
        this.setDamage(damage);
    }

    public Lightning_Spear_Entity(EntityType<? extends Lightning_Spear_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, Vec3 vec3, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE,0f);
        p_326229_.define(AREA_RADIUS,0f);
        p_326229_.define(AREA_DAMAGE,0f);
    }


    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public float getAreaRadius() {
        return entityData.get(AREA_RADIUS);
    }

    public void setAreaRadius(float radius) {
        entityData.set(AREA_RADIUS, radius);
    }

    public float getAreaDamage() {
        return entityData.get(AREA_DAMAGE);
    }

    public void setAreaDamage(float damage) {
        entityData.set(AREA_DAMAGE, damage);
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

            int r = (89 + random.nextInt(5)) ;
            int g = (180 + random.nextInt(5));
            int b = (180 + random.nextInt(5));
            this.level().addParticle((new CircleLightningParticleOptions(r, g,  b)), this.getX(), this.getY(0.5), this.getZ(), d0, d1, d2);
            this.setDeltaMovement(vec3.add(vec3.normalize().scale(this.accelerationPower)).scale((double)f));
            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        if (this.level() instanceof ServerLevel serverlevel) {
            Entity entity = p_37626_.getEntity();
            boolean flag;
            if (this.getOwner() instanceof LivingEntity livingentity) {
                if (!isAlliedTo(entity) && !livingentity.equals(entity) && !livingentity.isAlliedTo(entity)) {
                    DamageSource damagesource = CMDamageTypes.causeLightningDamage(this, livingentity);
                    flag = entity.hurt(damagesource, this.getDamage());
                    if (flag) {
                        if (entity.isAlive()) {
                            EnchantmentHelper.doPostAttackEffects(serverlevel, entity, damagesource);
                        }
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().magic(), 5.0F);
            }

        }
    }


    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        if (!this.level().isClientSide) {
            Lightning_Area_Effect_Entity areaeffectcloud = new Lightning_Area_Effect_Entity(this.level(), this.getX(), this.getY(), this.getZ());
            areaeffectcloud.setRadius(this.getAreaRadius());
            LivingEntity entity1 = (LivingEntity) this.getOwner();
            areaeffectcloud.setOwner(entity1);
            areaeffectcloud.setRadiusOnUse(-0.5F);
            areaeffectcloud.setDamage(this.getAreaDamage());
            areaeffectcloud.setWaitTime(12);
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
            this.level().addFreshEntity(areaeffectcloud);

            this.level().addFreshEntity(new Lightning_Storm_Entity(this.level(), this.getX(), this.getY(), this.getZ(), this.getYRot(), -5, this.getAreaDamage(), 5f, entity1, 99, 194, 201,2.0F));

            this.discard();
        }
    }


    protected boolean canHitEntity(Entity p_36842_) {
        return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
    }


    protected float getInertia() {
        return 0.98F;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
        compound.putFloat("damage", this.getDamage());
        compound.putFloat("area_damage", this.getAreaDamage());
        compound.putFloat("area_radius", this.getAreaRadius());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDouble("acceleration_power");
        }
        this.setDamage(compound.getInt("damage"));
        this.setAreaDamage(compound.getInt("area_damage"));
        this.setAreaRadius(compound.getInt("area_radius"));
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


