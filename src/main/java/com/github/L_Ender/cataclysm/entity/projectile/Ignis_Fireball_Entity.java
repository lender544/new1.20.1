package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;

import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.util.CustomExplosion.IgnisExplosion;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class Ignis_Fireball_Entity extends AbstractHurtingProjectile {
    private static final EntityDataAccessor<Boolean> SOUL = SynchedEntityData.defineId(Ignis_Fireball_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> FIRED = SynchedEntityData.defineId(Ignis_Fireball_Entity.class, EntityDataSerializers.BOOLEAN);
    private int timer;
    private Vec3[] trailPositions = new Vec3[64];
    private int trailPointer = -1;

    public Ignis_Fireball_Entity(EntityType<? extends Ignis_Fireball_Entity> type, Level level) {
        super(type, level);
    }

    public Ignis_Fireball_Entity(Level level, LivingEntity  entity, double x, double y, double z) {
        super(ModEntities.IGNIS_FIREBALL.get(), entity, x, y, z, level);
    }

    public Ignis_Fireball_Entity(Level worldIn, LivingEntity entity) {
        this(ModEntities.IGNIS_FIREBALL.get(), worldIn);
        this.setOwner(entity);
    }


    public boolean isOnFire() {
        return false;
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            timer--;
            if (timer <= 0) {
                if (!getFired()){
                    setFired(true);
                }
            }
        }
        if(timer < -160){
            this.discard();
        }
        if (timer == 0 || timer == -40) {
            Entity entity = this.getOwner();
            if (entity instanceof Mob && ((Mob) entity).getTarget() != null) {
                LivingEntity target = ((Mob) entity).getTarget();
                if(target == null){
                    this.discard();
                }

                float speed = this.isSoul() ? 0.25F : 0.2F;

                double dx = target.getX() - this.getX();
                double dy = target.getY() + target.getBbHeight() * 0.5F - this.getY();
                double dz = target.getZ() - this.getZ();

                double d = Math.sqrt(dx * dx + dy * dy + dz * dz);

                dx /= d;
                dy /= d;
                dz /= d;
                this.xPower = dx * speed;
                this.yPower = dy * speed;
                this.zPower = dz * speed;
            }
        }
        Vec3 trailAt = this.position().add(0, this.getBbHeight() / 2F, 0);
        if (trailPointer == -1) {
            Vec3 backAt = trailAt;
            for (int i = 0; i < trailPositions.length; i++) {
                trailPositions[i] = backAt;
            }
        }
        if (++this.trailPointer == this.trailPositions.length) {
            this.trailPointer = 0;
        }
        this.trailPositions[this.trailPointer] = trailAt;

    }

    public void setUp(int delay) {
        setFired(false);
        timer = delay;

    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        if (!this.level().isClientSide && getFired() && !(result.getEntity() instanceof Ignis_Fireball_Entity || result.getEntity() instanceof Ignis_Abyss_Fireball_Entity || result.getEntity() instanceof Cm_Falling_Block_Entity || result.getEntity() instanceof Ignis_Entity && shooter instanceof Ignis_Entity)) {
            Entity entity = result.getEntity();
            boolean flag;
            if (shooter instanceof LivingEntity) {
                LivingEntity owner = (LivingEntity)shooter;
                float damage = this.isSoul() ? 8.0F : 6.0F;
                if (entity instanceof LivingEntity) {
                    flag = entity.hurt(damageSources().mobProjectile(this, owner), damage + ((LivingEntity) entity).getMaxHealth() * 0.07f);
                }else{
                    flag = entity.hurt(damageSources().mobProjectile(this, owner), damage);
                }

                if (flag) {
                    this.doEnchantDamageEffects(owner, entity);
                    if(owner instanceof Ignis_Entity) {
                        owner.heal(5.0F * (float) CMConfig.IgnisHealingMultiplier);
                    }else{
                        owner.heal(5.0F);
                    }

                }
            } else {
                flag = entity.hurt(this.damageSources().magic(), 6.0F);
            }
            IgnisExplosion explosion = new IgnisExplosion(level(), this,null,null, this.getX(), this.getY(), this.getZ(), 1f, true, Explosion.BlockInteraction.KEEP);
            explosion.explode();
            explosion.finalizeExplosion(this.isSoul() ?2 :1,0.35D);

            this.discard();

            if (flag && entity instanceof LivingEntity) {
                MobEffectInstance effectinstance1 = ((LivingEntity)entity).getEffect(ModEffect.EFFECTBLAZING_BRAND.get());
                int i = 1;
                if (effectinstance1 != null) {
                    i += effectinstance1.getAmplifier();
                    ((LivingEntity)entity).removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND.get());
                } else {
                    --i;
                }

                i = Mth.clamp(i, 0, 4);
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 200, i, false, false, true);
                ((LivingEntity)entity).addEffect(effectinstance);

            }

        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide && getFired()) {
            IgnisExplosion explosion = new IgnisExplosion(level(), this,null,null, this.getX(), this.getY(), this.getZ(), 1f, true, Explosion.BlockInteraction.KEEP);
            explosion.explode();
            explosion.finalizeExplosion(this.isSoul() ?2 :1,0.35D);
            this.discard();
        }
    }

    public Vec3 getTrailPosition(int pointer, float partialTick) {
        if (this.isRemoved()) {
            partialTick = 1.0F;
        }
        int i = this.trailPointer - pointer & 63;
        int j = this.trailPointer - pointer - 1 & 63;
        Vec3 d0 = this.trailPositions[j];
        Vec3 d1 = this.trailPositions[i].subtract(d0);
        return d0.add(d1.scale(partialTick));
    }

    public boolean hasTrail() {
        return trailPointer != -1;
    }

    @Override
    protected void onHit(HitResult ray) {
        HitResult.Type raytraceresult$type = ray.getType();
        if (raytraceresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult) ray);
        } else if (raytraceresult$type == HitResult.Type.BLOCK) {
            this.onHitBlock((BlockHitResult) ray);
        }
    }

    public boolean isPickable() {
        return false;
    }

    public boolean hurt(DamageSource p_37616_, float p_37617_) {
        return false;
    }

    protected void defineSynchedData() {
        this.entityData.define(SOUL, false);
        this.entityData.define(FIRED, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("is_soul", isSoul());
        compound.putInt("timer", timer);
        compound.putBoolean("fired", getFired());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setSoul(compound.getBoolean("is_soul"));
        timer = compound.getInt("timer");
        this.setFired(compound.getBoolean("fired"));
    }

    public boolean isSoul() {
        return this.entityData.get(SOUL);
    }

    public void setSoul(boolean IsSoul) {
        this.entityData.set(SOUL, IsSoul);
    }

    public void setFired(boolean fired) {
        this.entityData.set(FIRED, fired);
    }

    public boolean getFired() {
        return this.entityData.get(FIRED);
    }

}


