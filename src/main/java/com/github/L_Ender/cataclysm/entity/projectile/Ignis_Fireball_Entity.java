package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;

import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Ignis_Fireball_Entity extends CMAbstractHurtingProjectile {
    private static final EntityDataAccessor<Boolean> SOUL = SynchedEntityData.defineId(Ignis_Fireball_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> FIRED = SynchedEntityData.defineId(Ignis_Fireball_Entity.class, EntityDataSerializers.BOOLEAN);
    private int timer;


    public Ignis_Fireball_Entity(EntityType<? extends Ignis_Fireball_Entity> type, Level level) {
        super(type, level);
    }

    public Ignis_Fireball_Entity(Level level, LivingEntity entity, double x, double y, double z) {
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
    }

    public void setUp(int delay) {
        setFired(false);
        timer = delay;

    }

    @Override
    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        Entity entity = p_37626_.getEntity();
        Entity shooter = this.getOwner();

        if (this.level() instanceof ServerLevel serverlevel && getFired() && !(entity instanceof Ignis_Fireball_Entity || entity instanceof Ignis_Abyss_Fireball_Entity || entity instanceof Cm_Falling_Block_Entity || entity instanceof Ignis_Entity && shooter instanceof Ignis_Entity)) {
            boolean flag;
            if (shooter instanceof LivingEntity owner) {
                DamageSource damagesource = this.damageSources().mobProjectile(this, owner);
                float damage = this.isSoul() ? 8.0F : 6.0F;
                if (entity instanceof LivingEntity) {
                    flag = entity.hurt(damageSources().mobProjectile(this, owner), damage + ((LivingEntity) entity).getMaxHealth() * 0.07f);
                }else{
                    flag = entity.hurt(damageSources().mobProjectile(this, owner), damage);
                }

                if (flag) {
                    if (entity.isAlive()) {
                        EnchantmentHelper.doPostAttackEffects(serverlevel, entity, damagesource);
                    }
                    if(owner instanceof Ignis_Entity) {
                        owner.heal(5.0F * (float) CMConfig.IgnisHealingMultiplier);
                    }else{
                        owner.heal(5.0F);
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().magic(), 5.0F);
            }
            if (flag && entity instanceof LivingEntity) {
                MobEffectInstance effectinstance1 = ((LivingEntity)entity).getEffect(ModEffect.EFFECTBLAZING_BRAND);
                int i = 2;
                if (effectinstance1 != null) {
                    i += effectinstance1.getAmplifier();
                    ((LivingEntity)entity).removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                } else {
                    --i;
                }

                i = Mth.clamp(i, 0, 4);
                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 200, i, false, false, true);
                ((LivingEntity)entity).addEffect(effectinstance);

            }
        }
    }


    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide && getFired()) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 1.0F, true, Level.ExplosionInteraction.NONE);
            this.discard();
        }
    }

    @Override
    protected void onHit(HitResult result) {
        HitResult.Type hitresult$type = result.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            EntityHitResult entityhitresult = (EntityHitResult)result;
            Entity entity = entityhitresult.getEntity();
            if (entity.getType().is(EntityTypeTags.REDIRECTABLE_PROJECTILE) && entity instanceof Projectile) {
                Projectile projectile = (Projectile)entity;
                projectile.deflect(ProjectileDeflection.AIM_DEFLECT, this.getOwner(), this.getOwner(), true);
            }

            this.onHitEntity(entityhitresult);
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, result.getLocation(), GameEvent.Context.of(this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)result;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }

    }


    public boolean isPickable() {
        return false;
    }

    public boolean hurt(DamageSource p_37616_, float p_37617_) {
        return false;
    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(SOUL, false);
        p_326229_.define(FIRED, false);
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


