package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
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
import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.Nullable;

public class Water_Spear_Entity extends Elemental_Spear_Entity {
    private static final EntityDataAccessor<Integer> BOUNCES = SynchedEntityData.defineId(Water_Spear_Entity.class, EntityDataSerializers.INT);


    public Water_Spear_Entity(EntityType<? extends Water_Spear_Entity> type, Level level) {
        super(type, level);
        this.accelerationPower = 0.1;
    }



    public Water_Spear_Entity(EntityType<? extends Water_Spear_Entity> type, double getX, double gety, double getz, Vec3 vec3, Level level) {
        this(type, level);
        this.setPosRaw(getX, gety, getz);
        this.setOldPosAndRot();
        this.setState(1);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }

    public Water_Spear_Entity(LivingEntity p_36827_, Vec3 vec3, Level p_36831_, float damage) {
        this(ModEntities.WATER_SPEAR.get(), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), vec3, p_36831_);
        this.setOwner(p_36827_);
        this.setDamage(damage);
    }

    public Water_Spear_Entity(EntityType<? extends Water_Spear_Entity> type, LivingEntity p_36827_, double getX, double gety, double getz, Vec3 vec3, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        this.assignDirectionalMovement(vec3, this.accelerationPower);

    }


    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        super.defineSynchedData(p_326229_);
        p_326229_.define(BOUNCES,0);
    }


    public int getTotalBounces()
    {
        return this.entityData.get(BOUNCES);
    }

    public void setTotalBounces(int bounces)
    {
        this.entityData.set(BOUNCES, bounces);
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

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        BlockHitResult traceResult = result;
        BlockState blockstate = this.level().getBlockState(traceResult.getBlockPos());
        if (!blockstate.getCollisionShape(this.level(), traceResult.getBlockPos()).isEmpty()) {
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
            Vec3 motion2 = new Vec3(motionX,motionY,motionZ);

            this.assignDirectionalMovement(motion2, this.accelerationPower);
            if ( this.getTotalBounces() <= 0) {
                if (!this.level().isClientSide) {
                    this.discard();
                }
            } else {
                this.setTotalBounces(this.getTotalBounces() - 1);
            }
        }

    }


    protected void SpawnParticle() {
        double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
        double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
        double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);

        float r = (89 + random.nextInt(35)) /255F ;
        float g = (180 + random.nextInt(35)) /255F ;
        float b = (180 + random.nextInt(35)) /255F ;
        this.level().addParticle((new StormParticleOptions(r, g, b,0.1F,this.getBbHeight()/2,this.getId())),  dx, dy, dz, 0, 0, 0);
    }


    protected float getInertia() {
        return 0.95F;
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putDouble("acceleration_power", this.accelerationPower);
        compound.putInt("totalBounces", this.getTotalBounces());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("acceleration_power", 6)) {
            this.accelerationPower = compound.getDouble("acceleration_power");
        }
        this.setTotalBounces(compound.getInt("totalBounces"));
    }

}


