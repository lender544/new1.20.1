package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;


import com.github.L_Ender.cataclysm.client.particle.LightningParticle;
import com.github.L_Ender.cataclysm.client.tool.ControlledAnimation;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Death_Laser_Beam_Entity;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Abyss_Blast_Entity extends Entity {
    public static final double RADIUS = 50;
    public LivingEntity caster;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    public double prevCollidePosX, prevCollidePosY, prevCollidePosZ;
    public float renderYaw, renderPitch;
    public ControlledAnimation appear = new ControlledAnimation(3);

    public boolean on = true;

    public Direction blockSide = null;

    private static final EntityDataAccessor<Float> YAW = SynchedEntityData.defineId(Abyss_Blast_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> PITCH = SynchedEntityData.defineId(Abyss_Blast_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(Abyss_Blast_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> CASTER = SynchedEntityData.defineId(Abyss_Blast_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> BEAMDIRECTION = SynchedEntityData.defineId(Abyss_Blast_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Abyss_Blast_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Abyss_Blast_Entity.class, EntityDataSerializers.FLOAT);


    public float prevYaw;
    public float prevPitch;

    @OnlyIn(Dist.CLIENT)
    private Vec3[] attractorPos;

    public Abyss_Blast_Entity(EntityType<? extends Abyss_Blast_Entity> type, Level world) {
        super(type, world);
        noCulling = true;
        if (world.isClientSide) {
            attractorPos = new Vec3[] {new Vec3(0, 0, 0)};
        }
    }

    public Abyss_Blast_Entity(EntityType<? extends Abyss_Blast_Entity> type, Level world, LivingEntity caster, double x, double y, double z, float yaw, float pitch, int duration, float direction,float damage,float Hpdamage) {
        this(type, world);
        this.caster = caster;
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setBeamDirection(direction);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
        this.setPos(x, y, z);
        this.calculateEndPos();
        if (!world.isClientSide) {
            this.setCasterID(caster.getId());
        }
    }

    @Override
    public PushReaction getPistonPushReaction() {
        return PushReaction.IGNORE;
    }

    @Override
    public void tick() {
        super.tick();
        prevCollidePosX = collidePosX;
        prevCollidePosY = collidePosY;
        prevCollidePosZ = collidePosZ;
        prevYaw = renderYaw;
        prevPitch = renderPitch;
        xo = getX();
        yo = getY();
        zo = getZ();
        if (tickCount == 1 && level().isClientSide) {
            caster = (LivingEntity) level().getEntity(getCasterID());
        }

        if (!level().isClientSide) {
            if (caster instanceof The_Leviathan_Entity) {
                this.updateWithHarbinger();
            }
        }

        if (caster != null) {
            renderYaw = (float) ((caster.yHeadRot + this.getBeamDirection()) * Math.PI / 180.0d);
            renderPitch = (float) (-caster.getXRot() * Math.PI / 180.0d);
        }

        if (!on && appear.getTimer() == 0) {
            this.discard();
        }
        if (on && tickCount > 20) {
            appear.increaseTimer();
        } else {
            appear.decreaseTimer();
        }

        if (caster != null && !caster.isAlive()) discard();

        if (tickCount > 20) {
            this.calculateEndPos();
            List<LivingEntity> hit = raytraceEntities(level(), new Vec3(getX(), getY(), getZ()), new Vec3(endPosX, endPosY, endPosZ)).entities;
            if (blockSide != null) {
                spawnExplosionParticles(3);
                if (!this.level().isClientSide) {
                    for (BlockPos pos : BlockPos.betweenClosed(Mth.floor(collidePosX - 0.5F), Mth.floor(collidePosY - 0.5F), Mth.floor(collidePosZ - 0.5F), Mth.floor(collidePosX + 0.5F), Mth.floor(collidePosY + 0.5F), Mth.floor(collidePosZ + 0.5F))) {
                        BlockState block = level().getBlockState(pos);
                        if (!block.isAir() && !block.is(ModTag.LEVIATHAN_IMMUNE) && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                            level().destroyBlock(pos, false);
                        }
                    }
                }
            }
            if (!level().isClientSide) {
                for (LivingEntity target : hit) {
                    if (caster != null) {
                        if (!this.caster.isAlliedTo(target) && target != caster) {
                            boolean flag = target.hurt(CMDamageTypes.causeDeathLaserDamage(this, caster), (float) (this.getDamage() + Math.min(this.getDamage(), target.getMaxHealth() * this.getHpDamage() * 0.01)));
                            if (flag) {
                                MobEffectInstance effectinstance1 = target.getEffect(ModEffect.EFFECTABYSSAL_BURN.get());
                                int i = 1;
                                if (effectinstance1 != null) {
                                    i += effectinstance1.getAmplifier();
                                    target.removeEffectNoUpdate(ModEffect.EFFECTABYSSAL_BURN.get());
                                } else {
                                    --i;
                                }

                                i = Mth.clamp(i, 0, 3);
                                MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTABYSSAL_BURN.get(), 160, i, false, true, true);
                                target.addEffect(effectinstance);
                            }
                        }
                    }
                }
            }
        }
        if (tickCount - 20 > getDuration()) {
            on = false;
        }
    }

    private void spawnExplosionParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            final float velocity = 1.0F;
            float yaw = (float) (random.nextFloat() * 2 * Math.PI);
            float motionY = random.nextFloat() * 0.08F;
            float motionX = velocity * Mth.cos(yaw);
            float motionZ = velocity * Mth.sin(yaw);
            level().addParticle((new LightningParticle.OrbData(102, 26, 204)), collidePosX, collidePosY + 0.1, collidePosZ, motionX, motionY, motionZ);
        }

    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(YAW, 0F);
        this.entityData.define(PITCH, 0F);
        this.entityData.define(DURATION, 0);
        this.entityData.define(CASTER, -1);
        this.entityData.define(BEAMDIRECTION, 90f);
        this.entityData.define(DAMAGE, 0F);
        this.entityData.define(HPDAMAGE, 0F);
    }

    public float getDamage() {
        return entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    public float getHpDamage() {
        return entityData.get(HPDAMAGE);
    }

    public void setHpDamage(float damage) {
        entityData.set(HPDAMAGE, damage);
    }


    public float getYaw() {
        return entityData.get(YAW);
    }

    public void setYaw(float yaw) {
        entityData.set(YAW, yaw);
    }

    public float getPitch() {
        return entityData.get(PITCH);
    }

    public void setPitch(float pitch) {
        entityData.set(PITCH, pitch);
    }

    public int getDuration() {
        return entityData.get(DURATION);
    }

    public void setDuration(int duration) {
        entityData.set(DURATION, duration);
    }

    public float getBeamDirection() {
        return entityData.get(BEAMDIRECTION);
    }

    public void setBeamDirection(float beamDirection) {
        entityData.set(BEAMDIRECTION, beamDirection);
    }


    public int getCasterID() {
        return entityData.get(CASTER);
    }

    public void setCasterID(int id) {
        entityData.set(CASTER, id);
    }


    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setYaw(compound.getFloat("Yaw"));
        this.setPitch(compound.getFloat("Pitch"));
        this.setDuration(compound.getInt("Duration"));
        this.setBeamDirection(compound.getFloat("BeamDirection"));
        this.setDamage(compound.getFloat("damage"));
        this.setHpDamage(compound.getFloat("Hpdamage"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putFloat("Yaw", this.getYaw());
        compound.putFloat("Pitch", this.getPitch());
        compound.putInt("Duration", this.getDuration());
        compound.putFloat("BeamDirection", this.getBeamDirection());
        compound.putFloat("damage", this.getDamage());
        compound.putFloat("Hpdamage", this.getHpDamage());
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    private void calculateEndPos() {
        if (level().isClientSide()) {
            endPosX = getX() + RADIUS * Math.cos(renderYaw) * Math.cos(renderPitch);
            endPosZ = getZ() + RADIUS * Math.sin(renderYaw) * Math.cos(renderPitch);
            endPosY = getY() + RADIUS * Math.sin(renderPitch);
        } else {
            endPosX = getX() + RADIUS * Math.cos(getYaw()) * Math.cos(getPitch());
            endPosZ = getZ() + RADIUS * Math.sin(getYaw()) * Math.cos(getPitch());
            endPosY = getY() + RADIUS * Math.sin(getPitch());
        }
    }

    public LaserbeamHitResult raytraceEntities(Level world, Vec3 from, Vec3 to) {
        LaserbeamHitResult result = new LaserbeamHitResult();
        result.setBlockHit(world.clip(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)));
        if (result.blockHit != null) {
            Vec3 hitVec = result.blockHit.getLocation();
            collidePosX = hitVec.x;
            collidePosY = hitVec.y;
            collidePosZ = hitVec.z;
            blockSide = result.blockHit.getDirection();
        } else {
            collidePosX = endPosX;
            collidePosY = endPosY;
            collidePosZ = endPosZ;
            blockSide = null;
        }
        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).inflate(2, 2, 2));
        for (LivingEntity entity : entities) {
            if (entity == caster) {
                continue;
            }
            float pad = entity.getPickRadius() + 0.5f;
            AABB aabb = entity.getBoundingBox().inflate(pad, pad, pad);
            Optional<Vec3> hit = aabb.clip(from, to);
            if (aabb.contains(from)) {
                result.addEntityHit(entity);
            } else if (hit.isPresent()) {
                result.addEntityHit(entity);
            }
        }
        return result;
    }

    @Override
    public void push(Entity entityIn) {
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
        return true;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 10.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }


    private void updateWithHarbinger() {
        this.setYaw((float) ((caster.yHeadRot + this.getBeamDirection()) * Math.PI / 180.0d));
        this.setPitch((float) (-caster.getXRot() * Math.PI / 180.0d));

        float f = -Mth.sin(caster.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(caster.getXRot() * ((float)Math.PI / 180F));
        float f2 = Mth.cos(caster.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(caster.getXRot() * ((float)Math.PI / 180F));
        this.setPos(caster.getX(),caster.getY() +  1.15f , caster.getZ());
    }

    public static class LaserbeamHitResult {
        private BlockHitResult blockHit;

        private final List<LivingEntity> entities = new ArrayList<>();

        public BlockHitResult getBlockHit() {
            return blockHit;
        }

        public void setBlockHit(HitResult rayTraceResult) {
            if (rayTraceResult.getType() == HitResult.Type.BLOCK)
                this.blockHit = (BlockHitResult) rayTraceResult;
        }

        public void addEntityHit(LivingEntity entity) {
            entities.add(entity);
        }
    }
}
