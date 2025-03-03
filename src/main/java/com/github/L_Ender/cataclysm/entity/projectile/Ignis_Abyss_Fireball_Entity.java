package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Ignis_Abyss_Fireball_Entity extends CMAbstractHurtingProjectile {
    private static final EntityDataAccessor<Integer> BOUNCES = SynchedEntityData.defineId(Ignis_Abyss_Fireball_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> FIRED = SynchedEntityData.defineId(Ignis_Abyss_Fireball_Entity.class, EntityDataSerializers.BOOLEAN);
    private int timer;

    public Ignis_Abyss_Fireball_Entity(EntityType<? extends Ignis_Abyss_Fireball_Entity> type, Level level) {
        super(type, level);
    }

    public Ignis_Abyss_Fireball_Entity(Level level, LivingEntity entity, double x, double y, double z) {
        super(ModEntities.IGNIS_ABYSS_FIREBALL.get(), entity, x, y, z, level);
    }

    public Ignis_Abyss_Fireball_Entity(Level worldIn, LivingEntity entity) {
        this(ModEntities.IGNIS_ABYSS_FIREBALL.get(), worldIn);
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
            if(this.getTotalBounces() == 0) {
                Entity entity = this.getOwner();
                if (entity instanceof Mob && ((Mob) entity).getTarget() != null) {
                    LivingEntity target = ((Mob) entity).getTarget();
                    if(target == null){
                        this.discard();
                    }

                    float speed =  0.2F;

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
                if (entity instanceof LivingEntity) {
                    flag = entity.hurt(damageSources().mobProjectile(this, owner), 10.0F + ((LivingEntity) entity).getMaxHealth() * 0.2f);
                }else{
                    flag = entity.hurt(damageSources().mobProjectile(this, owner), 10.0F);
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
        BlockHitResult traceResult = result;
        BlockState blockstate = this.level().getBlockState(traceResult.getBlockPos());
        if (!blockstate.getCollisionShape(this.level(), traceResult.getBlockPos()).isEmpty() && getFired()) {
            Direction face = traceResult.getDirection();
            blockstate.onProjectileHit(this.level(), blockstate, traceResult, this);

            Vec3 motion = this.getDeltaMovement();

            double motionX = motion.x();
            double motionY = motion.y();
            double motionZ = motion.z();

            if (face == Direction.EAST)
                motionX = -motionX;
            else if (face == Direction.SOUTH)
                motionZ = -motionZ;
            else if (face == Direction.WEST)
                motionX = -motionX;
            else if (face == Direction.NORTH)
                motionZ = -motionZ;
            else if (face == Direction.UP)
                motionY = -motionY;
            else if (face == Direction.DOWN)
                motionY = -motionY;

            this.setDeltaMovement(motionX, motionY, motionZ);
            this.xPower = motionX * 0.05D;
            this.yPower = motionY * 0.05D;
            this.zPower = motionZ * 0.05D;

            if (this.tickCount > 500 || this.getTotalBounces() > 5) {
                if (!this.level().isClientSide) {
                    this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, true, Level.ExplosionInteraction.NONE);
                    this.discard();
                }
            } else {
                this.setTotalBounces(this.getTotalBounces() + 1);
            }
        }

    }

    @Override
    protected void onHit(HitResult ray) {
        HitResult.Type hitresult$type = ray.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)ray);
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, ray.getLocation(), GameEvent.Context.of(this, (BlockState)null));
            if (!this.level().isClientSide) {
                this.level().explode(this, this.getX(), this.getY(), this.getZ(), 1.0F, false, Level.ExplosionInteraction.MOB);
                this.discard();
            }
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)ray;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }
    }


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(BOUNCES, 0);
        p_326229_.define(FIRED, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("totalBounces", this.getTotalBounces());
        compound.putInt("timer", timer);
        compound.putBoolean("fired", getFired());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setTotalBounces(compound.getInt("totalBounces"));
        timer = compound.getInt("timer");
        this.setFired(compound.getBoolean("fired"));
    }

    public int getTotalBounces()
    {
        return this.entityData.get(BOUNCES);
    }

    public void setTotalBounces(int bounces)
    {
        this.entityData.set(BOUNCES, bounces);
    }

    public void setFired(boolean fired) {
        this.entityData.set(FIRED, fired);
    }

    public boolean getFired() {
        return this.entityData.get(FIRED);
    }

    public boolean isPickable() {
        return true;
    }

    public float getPickRadius() {
        return 1.0F;
    }

    @Override
    public boolean hurt(DamageSource p_36839_, float p_36840_) {
        if (this.isInvulnerableTo(p_36839_)) {
            return false;
        } else {
            this.markHurt();
            Entity entity = p_36839_.getEntity();
            if (entity != null && this.getFired()) {
                if (!this.level().isClientSide) {
                    Vec3 vec3 = entity.getLookAngle();
                    this.setDeltaMovement(vec3);
                    this.xPower = vec3.x * 0.1D;
                    this.yPower = vec3.y * 0.1D;
                    this.zPower = vec3.z * 0.1D;
                    this.setOwner(entity);
                }

                return true;
            } else {
                return false;
            }
        }
    }
}


