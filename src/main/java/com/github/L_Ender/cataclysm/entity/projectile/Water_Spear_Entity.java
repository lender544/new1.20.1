package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class Water_Spear_Entity extends Elemental_Spear_Entity {
    private int Bounces;

    public Water_Spear_Entity(EntityType<? extends Water_Spear_Entity> type, Level level) {
        super(type, level);
        this.accelerationPower = 0.1;
    }



    public Water_Spear_Entity(EntityType<? extends Water_Spear_Entity> type, double getX, double gety, double getz, Vec3 vec3, Level level,double accel) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        this.setOldPosAndRot();
        this.setState(1);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, accel);

    }

    public Water_Spear_Entity(LivingEntity p_36827_, Vec3 vec3, Level p_36831_, float damage,double accel) {
        this(ModEntities.WATER_SPEAR.get(), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), vec3, p_36831_, accel);
        this.setOwner(p_36827_);
        this.setDamage(damage);
    }

    public Water_Spear_Entity(EntityType<? extends Water_Spear_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, Vec3 vec3, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3,  this.accelerationPower);

    }


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);

    }


    public int getTotalBounces() {
        return this.Bounces;
    }

    public void setTotalBounces(int bounces)
    {
        this.Bounces = bounces;
    }



    @Override
    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        if (this.level() instanceof ServerLevel serverlevel) {
            Entity entity = p_37626_.getEntity();
            boolean flag = false;
            if (this.getOwner() instanceof LivingEntity livingentity) {
                if (!entity.isAlliedTo(livingentity) && !livingentity.equals(entity) && !livingentity.isAlliedTo(entity)) {
                    DamageSource damagesource = this.damageSources().mobProjectile(this, livingentity);
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

            if (flag && entity instanceof LivingEntity livingentity1) {
                MobEffectInstance effectinstance1 = livingentity1.getEffect(ModEffect.EFFECTWETNESS);
                int i = 1;
                if (effectinstance1 != null) {
                    i += effectinstance1.getAmplifier();
                    livingentity1.removeEffectNoUpdate(ModEffect.EFFECTWETNESS);
                } else {
                    --i;
                }

                i = Mth.clamp(i, 0, 4);
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTWETNESS, 200, i, false, true, true);
                livingentity1.addEffect(effectinstance);

            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.hurtMarked = true;

        Direction face = result.getDirection();
        Vec3 motion = this.getDeltaMovement();

        Vec3 normal = Vec3.atLowerCornerOf(face.getNormal());

        double dot = motion.dot(normal);

        Vec3 reflected = motion.subtract(
                normal.scale(2.0D * dot)
        );

        Vec3 hitPos = result.getLocation();

        this.setPos(
                hitPos.x + normal.x * 0.05D,
                hitPos.y + normal.y * 0.05D,
                hitPos.z + normal.z * 0.05D
        );

        this.assignDirectionalMovement(
                reflected,
                this.accelerationPower
        );

        if (this.getTotalBounces() <= 0) {
            if (!this.level().isClientSide) {
                this.discard();
            }
        } else {
            this.setTotalBounces(
                    this.getTotalBounces() - 1
            );
        }
    }


    protected void TrailParticle() {
        if (this.level().isClientSide) {
            double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
            double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
            double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);

            float r = (89 + random.nextInt(35)) / 255F;
            float g = (180 + random.nextInt(35)) / 255F;
            float b = (180 + random.nextInt(35)) / 255F;
            this.level().addParticle((new StormParticleOptions(r, g, b, 0.1F, this.getBbHeight() / 2, this.getId())), dx, dy, dz, 0, 0, 0);
        }
    }


    protected float getInertia() {
        return 0.95F;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("totalBounces", this.getTotalBounces());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setTotalBounces(compound.getInt("totalBounces"));
    }

}


