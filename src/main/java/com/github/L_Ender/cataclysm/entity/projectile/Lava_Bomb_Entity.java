package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.entity.IEntityWithComplexSpawn;


public class Lava_Bomb_Entity extends ThrowableProjectile implements IEntityWithComplexSpawn {

    private static final EntityDataAccessor<Boolean> ON_GROUND = SynchedEntityData.defineId(Lava_Bomb_Entity.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<BlockPos> LAVA_POS = SynchedEntityData.defineId(Lava_Bomb_Entity.class, EntityDataSerializers.BLOCK_POS);

    public int LavaTime;
    public int maxLavaTime = 200;

    public Lava_Bomb_Entity(EntityType<Lava_Bomb_Entity> type, Level world) {
        super(type, world);
    }

    public Lava_Bomb_Entity(EntityType<Lava_Bomb_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {
        p_326229_.define(ON_GROUND, false);
        p_326229_.define(LAVA_POS, BlockPos.ZERO);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
        if (ON_GROUND.equals(accessor) && this.getGround()) {
            this.setDeltaMovement(Vec3.ZERO);
        }

        super.onSyncedDataUpdated(accessor);
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

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Level level = this.level();
        Entity hitEntity = result.getEntity();

        if (!this.getGround()
                && !level.isClientSide
                && !(hitEntity instanceof Lava_Bomb_Entity
                || hitEntity instanceof Netherite_Monstrosity_Part
                || hitEntity instanceof Netherite_Monstrosity_Entity)) {
            Entity shooter = this.getOwner();
            this.playSound(SoundEvents.GENERIC_BURN, 1.5f, 0.75f);
            level.explode(shooter, this.getX(), this.getY(), this.getZ(), 2, Level.ExplosionInteraction.NONE);
            this.doTerrainEffects();
            this.setGround(true);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        Level level = this.level();

        if (!level.isClientSide && !this.getGround()) {
            this.playSound(SoundEvents.GENERIC_BURN, 1.5f, 0.75f);
            level.explode(this, this.getX(), this.getY(), this.getZ(), 2, Level.ExplosionInteraction.NONE);
            this.doTerrainEffects();
            this.setGround(true);
        }

    }


    protected void doTerrainEffects() {
        Level level = this.level();
        BlockPos landed = this.blockPosition();
        int maxBuildHeight = level.getMaxBuildHeight();
        BlockState state = level.getBlockState(landed);

        while (landed.getY() < maxBuildHeight && !state.isAir()) {
            landed = landed.above();

            if (landed.getY() < maxBuildHeight) {
                state = level.getBlockState(landed);
            }
        }

        if (landed.getY() < maxBuildHeight && state.isAir()) {
            if (level.setBlockAndUpdate(landed, Blocks.LAVA.defaultBlockState())) {
                this.setLavaPos(landed);
            }
        }

    }


    @Override
    public void tick() {
        super.tick();
        Level level = this.level();

        if (this.getGround()) {
            this.LavaTime++;

            if (!level.isClientSide) {
                BlockPos lavaPos = this.getLavaPos();

                if (this.LavaTime >= this.maxLavaTime && !BlockPos.ZERO.equals(lavaPos)) {
                    this.discard();
                }
            }

        } else {
            this.makeTrail();
        }

    }

    @Override
    public void remove(RemovalReason reason) {
        super.remove(reason);
        Level level = this.level();

        if (!level.isClientSide) {
            BlockPos lavaPos = this.getLavaPos();

            if (!BlockPos.ZERO.equals(lavaPos)
                    && level.getFluidState(lavaPos).getFluidType() == net.neoforged.neoforge.common.NeoForgeMod.LAVA_TYPE.value()) {
                level.setBlockAndUpdate(lavaPos, Blocks.AIR.defaultBlockState());
            }
        }

    }




    @Override
    protected void applyGravity() {
        if (!this.getGround()) {
            double gravity = this.getGravity();

            if (gravity != 0.0D) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -gravity, 0.0D));
            }
        }
    }

    protected void makeTrail() {
        Level level = this.level();

        if (level.isClientSide) {
            double x = this.getX();
            double y = this.getY();
            double z = this.getZ();
            Vec3 movement = this.getDeltaMovement();
            double motionX = -movement.x;
            double motionY = -movement.y;
            double motionZ = -movement.z;

            for (int i = 0; i < 5; i++) {
                double dx = x + 1.5F * (this.random.nextFloat() - 0.5F);
                double dy = y + 1.5F * (this.random.nextFloat() - 0.5F);
                double dz = z + 1.5F * (this.random.nextFloat() - 0.5F);

                level.addParticle(ParticleTypes.FLAME, dx, dy, dz, motionX, motionY, motionZ);
            }
        }
    }


    public void setLavaPos(BlockPos p_31960_) {
        if (!this.getLavaPos().equals(p_31960_)) {
            this.entityData.set(LAVA_POS, p_31960_);
        }
    }

    public BlockPos getLavaPos() {
        return this.entityData.get(LAVA_POS);
    }

    public boolean getGround() {
        return this.entityData.get(ON_GROUND);
    }

    public void setGround(boolean weapon) {
        if (this.getGround() != weapon) {
            this.entityData.set(ON_GROUND, weapon);

            if (weapon) {
                this.setDeltaMovement(Vec3.ZERO);
            }
        }
    }


    public int getLavaTime() {
        return this.LavaTime;
    }

    public void setLavaTime(int time) {
        this.LavaTime = time;
    }

    public int getMaxLavaTime() {
        return this.maxLavaTime;
    }

    public void setMaxLavaTime(int time) {
        this.maxLavaTime = time;
    }


    @Override
    public void writeSpawnData(RegistryFriendlyByteBuf buffer) {
        buffer.writeVarInt(this.LavaTime);
        buffer.writeVarInt(this.maxLavaTime);
    }

    @Override
    public void readSpawnData(RegistryFriendlyByteBuf buffer) {
        this.LavaTime = buffer.readVarInt();
        this.maxLavaTime = buffer.readVarInt();
    }


    protected void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setGround(compound.getBoolean("bomb_ground"));
        this.setLavaTime(compound.getInt("lava_time"));
        this.setMaxLavaTime(compound.contains("max_lava_time") ? compound.getInt("max_lava_time") : 200);
        int i = compound.getInt("LavaPosX");
        int j = compound.getInt("LavaPosY");
        int k = compound.getInt("LavaPosZ");
        this.setLavaPos(new BlockPos(i, j, k));
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        compound.putInt("LavaPosX", this.getLavaPos().getX());
        compound.putInt("LavaPosY", this.getLavaPos().getY());
        compound.putInt("LavaPosZ", this.getLavaPos().getZ());
        compound.putInt("lava_time", this.getLavaTime());
        compound.putInt("max_lava_time", this.getMaxLavaTime());
        compound.putBoolean("bomb_ground", this.getGround());
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    @Override
    protected double getDefaultGravity() {
        return 0.025F;
    }
}