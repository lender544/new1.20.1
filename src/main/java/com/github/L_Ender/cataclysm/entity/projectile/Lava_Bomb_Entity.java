package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
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


public class Lava_Bomb_Entity extends ThrowableProjectile {


    public double prevDeltaMovementX, prevDeltaMovementY, prevDeltaMovementZ;

    public Lava_Bomb_Entity(EntityType<Lava_Bomb_Entity> type, Level world) {
        super(type, world);
    }

    public Lava_Bomb_Entity(EntityType<Lava_Bomb_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {

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

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        if (!this.level().isClientSide && !(result.getEntity() instanceof Lava_Bomb_Entity || result.getEntity() instanceof Netherite_Monstrosity_Part || result.getEntity() instanceof Netherite_Monstrosity_Entity)) {
            this.playSound(SoundEvents.GENERIC_BURN, 1.5f, 0.75f);
            this.level().explode(shooter, this.getX(), this.getY(), this.getZ(), CMConfig.Lavabombradius, Level.ExplosionInteraction.NONE);
            this.doTerrainEffects();
            discard();

        }
    }

    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide()) {
            this.playSound(SoundEvents.GENERIC_BURN, 1.5f, 0.75f);
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), CMConfig.Lavabombradius, Level.ExplosionInteraction.NONE);
            this.doTerrainEffects();
            discard();
        }
    }


    private void doTerrainEffects() {

        final int range = 0;

        int ix = Mth.floor(this.xOld);
        int iy = Mth.floor(this.yOld);
        int iz = Mth.floor(this.zOld);

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    BlockPos pos = new BlockPos(ix + x, iy + y, iz + z);
                    this.doTerrainEffect(pos);
                }
            }
        }
    }

    private void doTerrainEffect(BlockPos pos) {
        BlockState state = level().getBlockState(pos);
        if (state == Blocks.WATER.defaultBlockState()) {
            this.level().setBlockAndUpdate(pos, Blocks.STONE.defaultBlockState());
        }
        if (this.level().isEmptyBlock(pos) && Blocks.LAVA.defaultBlockState().canSurvive(this.level(), pos)) {
            this.level().setBlockAndUpdate(pos, Blocks.LAVA.defaultBlockState());
        }
    }

    @Override
    public void tick() {
        super.tick();
        prevDeltaMovementX = getDeltaMovement().x;
        prevDeltaMovementY = getDeltaMovement().y;
        prevDeltaMovementZ = getDeltaMovement().z;

        setYRot(-((float) Mth.atan2(getDeltaMovement().x, getDeltaMovement().z)) * (180F / (float)Math.PI)) ;


        makeTrail();

    }

    public void makeTrail() {
        if (this.level().isClientSide){
            for (int i = 0; i < 5; i++) {
                double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
                double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
                double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);

                level().addParticle(ParticleTypes.FLAME, dx, dy, dz, -getDeltaMovement().x(), -getDeltaMovement().y(), -getDeltaMovement().z());
            }
        }
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    @Override
    protected double getDefaultGravity() {
        return 0.025F;
    }
}