package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.particle.CircleLightningParticle;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Area_Effect_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Storm_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class Lightning_Spear_Entity extends Elemental_Spear_Entity {
    private static final EntityDataAccessor<Float> AREA_RADIUS = SynchedEntityData.defineId(Lightning_Spear_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> AREA_DAMAGE = SynchedEntityData.defineId(Lightning_Spear_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HP_DAMAGE = SynchedEntityData.defineId(Lightning_Spear_Entity.class, EntityDataSerializers.FLOAT);

    public Lightning_Spear_Entity(EntityType<? extends Lightning_Spear_Entity> type, Level level) {
        super(type, level);
        this.accelerationPower = 0.1;
    }

    public Lightning_Spear_Entity(EntityType<? extends Lightning_Spear_Entity> type, double getX, double gety, double getz, Vec3 vec3, Level level) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        this.setState(1);
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


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(AREA_RADIUS,0f);
        this.entityData.define(AREA_DAMAGE,0f);
        this.entityData.define(HP_DAMAGE,0f);
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

    public float getHpDamage() {
        return entityData.get(HP_DAMAGE);
    }

    public void setHpDamage(float damage) {
        entityData.set(HP_DAMAGE, damage);
    }



    protected void SpawnParticle() {
        Vec3 vec3 = this.getDeltaMovement();
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        int r = (89 + random.nextInt(5)) ;
        int g = (180 + random.nextInt(5));
        int b = (180 + random.nextInt(5));
        this.level().addParticle((new CircleLightningParticle.CircleData(r, g,  b)), this.getX(), this.getY(0.5), this.getZ(), d0, d1, d2);
    }

    @Override
    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        if (!this.level().isClientSide) {
            Entity entity = p_37626_.getEntity();
            boolean flag;
            if (this.getOwner() instanceof LivingEntity livingentity) {
                if (!isAlliedTo(entity) && !livingentity.equals(entity) && !livingentity.isAlliedTo(entity)) {
                    DamageSource damagesource = CMDamageTypes.causeLightningDamage(this, livingentity);
                    flag = entity.hurt(damagesource, this.getDamage());
                    if (flag) {
                        if (entity.isAlive()) {
                            this.doEnchantDamageEffects(livingentity, entity);
                        }
                    }
                }
            } else {
                entity.hurt(this.damageSources().magic(), 5.0F);
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
            areaeffectcloud.setRadiusOnUse(-1.0F);
            areaeffectcloud.setDamage(this.getAreaDamage());
            areaeffectcloud.setWaitTime(12);
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
            this.level().addFreshEntity(areaeffectcloud);

            this.level().addFreshEntity(new Lightning_Storm_Entity(this.level(), this.getX(), this.getY(), this.getZ(), this.getYRot(), -5, this.getAreaDamage(), this.getHpDamage(), entity1,2.0F));

            this.discard();
        }
    }



    protected float getInertia() {
        return 0.98F;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
        compound.putFloat("area_damage", this.getAreaDamage());
        compound.putFloat("hp_damage", this.getAreaRadius());
        compound.putFloat("area_radius", this.getAreaRadius());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDouble("acceleration_power");
        }
        this.setAreaDamage(compound.getFloat("area_damage"));
        this.setHpDamage(compound.getFloat("hp_damage"));
        this.setAreaRadius(compound.getFloat("area_radius"));
    }
}


