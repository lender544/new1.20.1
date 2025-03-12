package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.particle.Lightning_Zap_Particle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Lightning_Area_Effect_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Wither_Smoke_Effect_Entity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;


public class Wither_Howitzer_Entity extends ThrowableProjectile {

    private static final EntityDataAccessor<Float> RADIUS = SynchedEntityData.defineId(Wither_Howitzer_Entity.class, EntityDataSerializers.FLOAT);

    public Wither_Howitzer_Entity(EntityType<Wither_Howitzer_Entity> type, Level world) {
        super(type, world);
    }

    public Wither_Howitzer_Entity(EntityType<Wither_Howitzer_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(RADIUS,0.5F);
    }


    public void setRadius(float p_19713_) {
        if (!this.level().isClientSide) {
            this.getEntityData().set(RADIUS, Mth.clamp(p_19713_, 0.0F, 32.0F));
        }
    }

    public float getRadius() {
        return this.getEntityData().get(RADIUS);
    }

    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        if (this.level() instanceof ServerLevel serverlevel) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag;
            if (entity1 instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity) entity1;
                DamageSource damagesource = this.damageSources().mobProjectile(this, livingentity);
                flag = entity.hurt(damagesource, (float) CMConfig.WitherHowizterdamage);
                if (flag) {
                    if (entity.isAlive()) {
                        EnchantmentHelper.doPostAttackEffects(serverlevel, entity, damagesource);
                    } else {
                        if (entity1 instanceof The_Harbinger_Entity) {
                            livingentity.heal(5.0F * (float) CMConfig.HarbingerHealingMultiplier);
                        } else {
                            livingentity.heal(5.0F);
                        }
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().magic(), 5.0F);
            }

            if (flag && entity instanceof LivingEntity) {
                int i = 10;
                if (this.level().getDifficulty() == Difficulty.NORMAL) {
                    i = 20;
                } else if (this.level().getDifficulty() == Difficulty.HARD) {
                    i = 30;
                }

                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, 20 * i, 1), this.getEffectSource());
            }

        }
    }

    protected void onHit(HitResult p_37628_) {
        super.onHit(p_37628_);
        if (!this.level().isClientSide) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, false, Level.ExplosionInteraction.NONE);
            Lightning_Area_Effect_Entity areaeffectcloud = new Lightning_Area_Effect_Entity(this.level(), this.getX(), this.getY(), this.getZ());
            areaeffectcloud.setRadius(this.getRadius());
            LivingEntity entity1 = (LivingEntity) this.getOwner();
            areaeffectcloud.setOwner(entity1);
            areaeffectcloud.setRadiusOnUse(-0.5F);
            areaeffectcloud.setWaitTime(5);
            areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
            areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
            this.level().addFreshEntity(areaeffectcloud);
            ScreenShake_Entity.ScreenShake(level(), this.position(), 40, 0.05f, 0, 20);
            this.discard();
        }
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("radius", getRadius());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setRadius(compound.getFloat("radius"));
    }


    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide) {
            Vec3 vec3 = this.getDeltaMovement();
            level().addParticle(ParticleTypes.FLAME, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0, 0, 0);
            level().addParticle(ParticleTypes.SMOKE, this.getX() - vec3.x, this.getY() - vec3.y, this.getZ() - vec3.z, 0, 0, 0);
        }

    }


    @Override
    protected double getDefaultGravity() {
        return 0.03F;
    }

}
