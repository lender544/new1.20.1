package com.github.L_Ender.cataclysm.entity.projectile;


import com.github.L_Ender.cataclysm.blocks.EMP_Block;
import com.github.L_Ender.cataclysm.client.particle.LightningParticle;
import com.github.L_Ender.cataclysm.client.particle.Options.LightningParticleOptions;
import com.github.L_Ender.cataclysm.client.tool.ControlledAnimation;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.The_Prowler_Entity;
import com.github.L_Ender.cataclysm.init.ModBlocks;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Death_Laser_Beam_Entity extends Entity {
    public static final double RADIUS = 30;
    public LivingEntity caster;
    public double endPosX, endPosY, endPosZ;
    public double collidePosX, collidePosY, collidePosZ;
    public double prevCollidePosX, prevCollidePosY, prevCollidePosZ;
    public float renderYaw, renderPitch;
    public ControlledAnimation appear = new ControlledAnimation(3);

    public boolean on = true;

    public Direction blockSide = null;

    private static final EntityDataAccessor<Float> YAW = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> PITCH = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> DURATION = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> CASTER = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> HEAD = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> FIRE = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HPDAMAGE = SynchedEntityData.defineId(Death_Laser_Beam_Entity.class, EntityDataSerializers.FLOAT);

    public float prevYaw;
    public float prevPitch;

    @OnlyIn(Dist.CLIENT)
    private Vec3[] attractorPos;

    public Death_Laser_Beam_Entity(EntityType<? extends Death_Laser_Beam_Entity> type, Level world) {
        super(type, world);
        noCulling = true;
        if (world.isClientSide) {
            attractorPos = new Vec3[] {new Vec3(0, 0, 0)};
        }
    }


    public Death_Laser_Beam_Entity(EntityType<? extends Death_Laser_Beam_Entity> type, Level world, LivingEntity caster, double x, double y, double z, float yaw, float pitch, int duration,float damage,float Hpdamage) {
        this(type, world);
        this.caster = caster;
        this.setYaw(yaw);
        this.setPitch(pitch);
        this.setDuration(duration);
        this.setPos(x, y, z);
        this.setDamage(damage);
        this.setHpDamage(Hpdamage);
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
            if (caster instanceof The_Harbinger_Entity) {
                this.updateWithHarbinger();
            }
            if (caster instanceof The_Prowler_Entity) {
                this.updateWithProwler();
            }
        }

        if (caster != null) {
            renderYaw = (float) ((caster.yHeadRot + 90.0d) * Math.PI / 180.0d);
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
            List<LivingEntity> hit = raytraceEntities(level(), new Vec3(getX(), getY(), getZ()), new Vec3(endPosX, endPosY, endPosZ), false, true, true).entities;
            if (blockSide != null) {
                spawnExplosionParticles(5);
                if (!this.level().isClientSide) {
                    for (BlockPos pos : BlockPos.betweenClosed(Mth.floor(collidePosX - 0.5F), Mth.floor(collidePosY - 0.5F), Mth.floor(collidePosZ - 0.5F), Mth.floor(collidePosX + 0.5F), Mth.floor(collidePosY + 0.5F), Mth.floor(collidePosZ + 0.5F))) {
                        BlockState block = level().getBlockState(pos);
                        if (!block.isAir() && block.is(ModTag.CM_GLASS) && net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
                            level().destroyBlock(pos, true);
                        }
                    }
                    for (BlockPos pos : BlockPos.betweenClosed(Mth.floor(collidePosX - 2.5F), Mth.floor(collidePosY - 2.5F), Mth.floor(collidePosZ - 2.5F), Mth.floor(collidePosX + 2.5F), Mth.floor(collidePosY + 2.5F), Mth.floor(collidePosZ + 2.5F))) {
                        BlockState block = level().getBlockState(pos);
                        if (block.is(ModBlocks.EMP.get())) {
                            if(!block.getValue(EMP_Block.POWERED) && block.getValue(EMP_Block.OVERLOAD)) {
                                this.level().setBlockAndUpdate(pos, block.setValue(EMP_Block.OVERLOAD, false));
                            }
                        }
                    }
                    if(this.getFire()) {
                        BlockPos blockpos1 = BlockPos.containing(collidePosX,collidePosY, collidePosZ);
                        if(CMConfig.HarbingerLightFire) {
                            if (this.level().isEmptyBlock(blockpos1)) {
                                this.level().setBlockAndUpdate(blockpos1, BaseFireBlock.getState(this.level(), blockpos1));
                            }
                        }else{
                            if (!net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
                                if (this.level().isEmptyBlock(blockpos1)) {
                                    this.level().setBlockAndUpdate(blockpos1, BaseFireBlock.getState(this.level(), blockpos1));
                                }
                            }
                        }

                    }
                }
            }
            if (!level().isClientSide) {
                for (LivingEntity target : hit) {
                    if (caster != null) {
                    if (!this.caster.isAlliedTo(target) && target != caster) {
                        boolean flag = target.hurt(CMDamageTypes.causeDeathLaserDamage(this, caster), (float) (this.getDamage() + Math.min(this.getDamage(), target.getMaxHealth() * this.getHpDamage() * 0.01)));
                        if (this.getFire()) {
                            if (flag) {

                                target.igniteForSeconds(5);
                            }
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
            final float velocity = 1.5F;
            float yaw = (float) (random.nextFloat() * 2 * Math.PI);
            float motionY = random.nextFloat() * 0.8F;
            float motionX = velocity * Mth.cos(yaw);
            float motionZ = velocity * Mth.sin(yaw);
            level().addParticle((new LightningParticleOptions(255, 26,  0)), collidePosX, collidePosY + 0.1, collidePosZ, motionX, motionY, motionZ);
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(YAW, 0F);
        p_326229_.define(PITCH, 0F);
        p_326229_.define(DURATION, 0);
        p_326229_.define(CASTER, -1);
        p_326229_.define(HEAD, 0);
        p_326229_.define(FIRE, false);
        p_326229_.define(DAMAGE, 0F);
        p_326229_.define(HPDAMAGE, 0F);
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

    public int getHead() {
        return entityData.get(HEAD);
    }

    public void setHead(int head) {
        entityData.set(HEAD, head);
    }


    public int getCasterID() {
        return entityData.get(CASTER);
    }

    public void setCasterID(int id) {
        entityData.set(CASTER, id);
    }

    public boolean getFire() {
        return this.entityData.get(FIRE);
    }

    public void setFire(boolean fire) {
        this.entityData.set(FIRE, fire);
    }


    @Override
    protected void readAdditionalSaveData(CompoundTag nbt) {}

    @Override
    protected void addAdditionalSaveData(CompoundTag nbt) {}


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

    public LaserbeamHitResult raytraceEntities(Level world, Vec3 from, Vec3 to, boolean stopOnLiquid, boolean ignoreBlockWithoutBoundingBox, boolean returnLastUncollidableBlock) {
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
        List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(Math.min(getX(), collidePosX), Math.min(getY(), collidePosY), Math.min(getZ(), collidePosZ), Math.max(getX(), collidePosX), Math.max(getY(), collidePosY), Math.max(getZ(), collidePosZ)).inflate(1, 1, 1));
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

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return distance < 1024;
    }

    private void updateWithHarbinger() {
        this.setYaw((float) ((caster.yHeadRot + 90) * Math.PI / 180.0d));
        this.setPitch((float) (-caster.getXRot() * Math.PI / 180.0d));
        this.setPos(caster.getX() ,caster.getY() + 2.7 , caster.getZ());
    }

    private void updateWithProwler() {
        this.setYaw((float) ((caster.yHeadRot + 90) * Math.PI / 180.0d));
        this.setPitch((float) (-caster.getXRot() * Math.PI / 180.0d));
        this.setPos(caster.getX() ,caster.getY() + 1.8, caster.getZ());
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
