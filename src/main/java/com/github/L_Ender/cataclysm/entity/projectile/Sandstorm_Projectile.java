package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModTag;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;


public class Sandstorm_Projectile extends Projectile {
    public double xPower;
    public double yPower;
    public double zPower;
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Sandstorm_Projectile.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(Sandstorm_Projectile.class, EntityDataSerializers.INT);
    public AnimationState SpawnAnimationState = new AnimationState();
    public AnimationState DespawnAnimationState = new AnimationState();
    private int lifetick;
    private int discardtick;

    public Sandstorm_Projectile(EntityType<? extends Sandstorm_Projectile> type, Level level) {
        super(type, level);
    }

    public Sandstorm_Projectile(EntityType<? extends Sandstorm_Projectile> type, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.1D;
            this.yPower = p_36822_ / d0 * 0.1D;
            this.zPower = p_36823_ / d0 * 0.1D;
        }

    }

    public Sandstorm_Projectile(LivingEntity p_36827_, double p_36828_, double p_36829_, double p_36830_, Level p_36831_, float damage) {
        this(ModEntities.SANDSTORM_PROJECTILE.get(), p_36827_.getX(), p_36827_.getY(), p_36827_.getZ(), p_36828_, p_36829_, p_36830_, p_36831_);
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.setRot(p_36827_.getYRot(), p_36827_.getXRot());
    }

    public Sandstorm_Projectile(EntityType<? extends Sandstorm_Projectile> type, LivingEntity p_36827_, double getX, double gety, double getz, double p_36821_, double p_36822_, double p_36823_, float damage, Level level) {
        this(type, level);
        this.moveTo(getX, gety, getz, this.getYRot(), this.getXRot());
        this.setOwner(p_36827_);
        this.setDamage(damage);
        this.reapplyPosition();
        double d0 = Math.sqrt(p_36821_ * p_36821_ + p_36822_ * p_36822_ + p_36823_ * p_36823_);
        if (d0 != 0.0D) {
            this.xPower = p_36821_ / d0 * 0.1D;
            this.yPower = p_36822_ / d0 * 0.1D;
            this.zPower = p_36823_ / d0 * 0.1D;
        }

    }

    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(DAMAGE,0f);
        p_326229_.define(STATE,0);
    }

    public AnimationState getAnimationState(String input) {
        if (input == "spawn") {
            return this.SpawnAnimationState;
        } else if (input == "despawn") {
            return this.DespawnAnimationState;
        }else {
            return new AnimationState();
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getState()) {
                case 0 -> this.stopAllAnimationStates();
                case 1 -> {
                    stopAllAnimationStates();
                    this.SpawnAnimationState.startIfStopped(this.tickCount);
                }
                case 2 -> {
                    stopAllAnimationStates();
                    this.DespawnAnimationState.startIfStopped(this.tickCount);
                }
            }
        }

        super.onSyncedDataUpdated(p_21104_);
    }

    public void stopAllAnimationStates() {
        this.DespawnAnimationState.stop();
        this.SpawnAnimationState.stop();
    }

    public int getState() {
        return entityData.get(STATE);
    }

    public void setState(int state) {
        entityData.set(STATE, state);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }


    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }

    public void tick() {
        Entity entity = this.getOwner();

        if (this.level().isClientSide || (entity == null || !entity.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            super.tick();
            lifetick++;
            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
            if (hitresult.getType() != HitResult.Type.MISS && !net.neoforged.neoforge.event.EventHooks.onProjectileImpact(this, hitresult)) {
                this.hitTargetOrDeflectSelf(hitresult);
            }
            if(this.getState() == 1) {
                if (this.lifetick > 5) {
                    this.setState(0);
                }
            }
            if(lifetick > 290){
                if(this.getState() == 0) {
                    this.setState(2);
                }
            }

            if(this.getState() == 2){
                discardtick++;
                if(discardtick > 10){
                    this.discard();
                }
            }

            this.checkInsideBlocks();
            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;
            ProjectileUtil.rotateTowardsMovement(this, 0.2F);
            float f = this.getInertia();

            float ran = 0.04f;
            float r = 0.89F + random.nextFloat() * ran;
            float g = 0.85f + random.nextFloat() * ran;
            float b = 0.69f + random.nextFloat() * ran * 1.5F;
            this.level().addParticle((new StormParticleOptions(r, g, b,0.25f + random.nextFloat() * 0.45f,0.35F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            //this.level().addParticle((new StormParticleOptions(r, g, b,2.0f + random.nextFloat() * 0.45f,2.0f + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            // this.level().addParticle((new StormParticleOptions(r, g, b,1.75f + random.nextFloat() * 0.45f,1.75F + random.nextFloat() * 0.45f,this.getId())), this.getX(), this.getY(), this.getZ() , 0, 0, 0);

            if (!this.isSilent()) {
          //      Cataclysm.PROXY.playWorldSound(this, (byte) 2);
            }
            this.setDeltaMovement(vec3.add(this.xPower, this.yPower, this.zPower).scale((double)f));
            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
    }


    protected void onHitEntity(EntityHitResult p_37626_) {
        super.onHitEntity(p_37626_);
        if (!this.level().isClientSide) {
            Entity entity = p_37626_.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag = false;
            if (entity1 instanceof LivingEntity) {
                if (!(entity.getType().is(ModTag.TEAM_ANCIENT_REMNANT) && entity1.getType().is(ModTag.TEAM_ANCIENT_REMNANT))) {
                    LivingEntity livingentity = (LivingEntity) entity1;
                    flag = entity.hurt(this.damageSources().mobProjectile(this, livingentity), this.getDamage());
                    if (flag) {
                        if (entity.isAlive()) {
                         //   this.doEnchantDamageEffects(livingentity, entity);
                        }
                    }
                }
            } else {
                flag = entity.hurt(this.damageSources().magic(), this.getDamage());
            }

            if (flag && entity instanceof LivingEntity) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(ModEffect.EFFECTCURSE_OF_DESERT, 100, 1), this.getEffectSource());
            }
            this.setState(2);

        }
    }

    protected void onHit(HitResult p_37260_) {
        HitResult.Type hitresult$type = p_37260_.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            EntityHitResult entityhitresult = (EntityHitResult)p_37260_;
            Entity entity = entityhitresult.getEntity();
            if (entity.getType().is(EntityTypeTags.REDIRECTABLE_PROJECTILE) && entity instanceof Projectile projectile) {
                projectile.deflect(ProjectileDeflection.AIM_DEFLECT, this.getOwner(), this.getOwner(), true);
            }

            this.onHitEntity(entityhitresult);
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, p_37260_.getLocation(), GameEvent.Context.of(this, null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)p_37260_;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }

    }

    protected boolean canHitEntity(Entity p_36842_) {
        return super.canHitEntity(p_36842_) && !p_36842_.noPhysics;
    }

    protected float getInertia() {
        return 0.9F;
    }

    public void addAdditionalSaveData(CompoundTag p_36848_) {
        super.addAdditionalSaveData(p_36848_);
        p_36848_.put("power", this.newDoubleList(new double[]{this.xPower, this.yPower, this.zPower}));
        p_36848_.putInt("state", this.getState());
        p_36848_.putFloat("damage", this.getDamage());
    }

    public void readAdditionalSaveData(CompoundTag p_36844_) {
        super.readAdditionalSaveData(p_36844_);
        if (p_36844_.contains("power", 9)) {
            ListTag listtag = p_36844_.getList("power", 6);
            if (listtag.size() == 3) {
                this.xPower = listtag.getDouble(0);
                this.yPower = listtag.getDouble(1);
                this.zPower = listtag.getDouble(2);
            }
        }
        this.setState(p_36844_.getInt("state"));
        this.setDamage(p_36844_.getFloat("damage"));
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

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        Entity entity = this.getOwner();
        int i = entity == null ? 0 : entity.getId();
        return new ClientboundAddEntityPacket(this.getId(), this.getUUID(), this.getX(), this.getY(), this.getZ(), this.getXRot(), this.getYRot(), this.getType(), i, new Vec3(this.xPower, this.yPower, this.zPower), 0.0D);
    }

    public void recreateFromPacket(ClientboundAddEntityPacket p_150128_) {
        super.recreateFromPacket(p_150128_);
        double d0 = p_150128_.getXa();
        double d1 = p_150128_.getYa();
        double d2 = p_150128_.getZa();
        double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
        if (d3 != 0.0D) {
            this.xPower = d0 / d3 * 0.1D;
            this.yPower = d1 / d3 * 0.1D;
            this.zPower = d2 / d3 * 0.1D;
        }

    }
}


