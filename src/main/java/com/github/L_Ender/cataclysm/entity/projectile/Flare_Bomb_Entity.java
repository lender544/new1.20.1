package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.render.etc.TrailSettings;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Flare_Bomb_Entity extends ThrowableProjectile {
    public double prevDeltaMovementX, prevDeltaMovementY, prevDeltaMovementZ;


    public final Deque<Vec3> trailPoints = new java.util.ArrayDeque<>();

    private static final int MAX_TRAIL_LENGTH = 15;

    private static final Vector3f TRAIL_COLOR = new Vector3f(255 / 255F, 255 / 255F, 61 / 255F);
    private static final TrailSettings TRAIL_SETTINGS = new TrailSettings(
            MAX_TRAIL_LENGTH, TRAIL_COLOR, 1.0f, 0.4f, TRAIL_COLOR, 1.0f, 0.0f
    );




    public Flare_Bomb_Entity(EntityType<Flare_Bomb_Entity> type, Level world) {
        super(type, world);
    }

    public Flare_Bomb_Entity(EntityType<Flare_Bomb_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder p_326229_) {

    }



    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        if (this.level() instanceof ServerLevel serverlevel) {
            if (!(result.getEntity() instanceof Flare_Bomb_Entity || shooter instanceof Netherite_Monstrosity_Entity && (result.getEntity() instanceof Netherite_Monstrosity_Part || result.getEntity() instanceof Netherite_Monstrosity_Entity))) {
            Entity entity = result.getEntity();
            boolean flag;
            if (this.getOwner() instanceof LivingEntity livingentity) {

                DamageSource damagesource = this.damageSources().mobProjectile(this, livingentity);
                flag = entity.hurt(damagesource, 7);
                if (flag) {
                    if (entity.isAlive()) {
                        entity.igniteForSeconds(5);
                        EnchantmentHelper.doPostAttackEffects(serverlevel, entity, damagesource);
                    }
                }
            } else {

                entity.hurt(this.damageSources().magic(), 7);
            }

        }
        }
    }


    protected void onHit(HitResult p_37628_) {
        super.onHit(p_37628_);
        if (!this.level().isClientSide) {
            this.playSound(SoundEvents.GENERIC_BURN, 1.5f, 0.75f);
            this.level().broadcastEntityEvent(this, (byte)4);
            if(random.nextBoolean()){
                XStrikeRune(10,2);
            }else{
                PlusStrikeRune(10,2);
            }
            discard();
        }

    }




    protected void PlusStrikeRune(int rune, double time) {
        float yawRadians = (float) (Math.toRadians(90 + this.getYRot()));
        for (int i = 0; i < 4; i++) {

            float throwAngle = yawRadians + i * Mth.PI / 2;

            for (int k = 0; k < rune; ++k) {
                double d2 = 0.8D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnJet(this.getX() + (double) Mth.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) Mth.sin(throwAngle) * 1.25D * d2, this.getY() -2, this.getY() + 2, throwAngle, d3);
            }

        }

    }

    protected void XStrikeRune(int rune, double time) {
        float yawRadians = (float) (Math.toRadians(45 + this.getYRot()));
        for (int i = 0; i < 4; i++) {

            float throwAngle = yawRadians + i * Mth.PI / 2;

            for (int k = 0; k < rune; ++k) {
                double d2 = 0.8D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnJet(this.getX() + (double) Mth.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) Mth.sin(throwAngle) * 1.25D * d2, this.getY() - 2, this.getY() + 2, throwAngle, d3);
            }

        }

    }


    protected void spawnJet(double x, double z, double minY, double maxY, float rotation, int delay) {
        BlockPos blockpos = BlockPos.containing(x, maxY, z);
        boolean flag = false;
        double d0 = 0.0D;

        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
                if (!this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }

                flag = true;
                break;
            }

            blockpos = blockpos.below();
        } while(blockpos.getY() >= Mth.floor(minY) - 1);

        if (flag) {
            if (this.getOwner() != null && this.getOwner() instanceof LivingEntity living) {
                this.level().addFreshEntity(new Flame_Jet_Entity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, 7, living));
            }else{
                this.level().addFreshEntity(new Flame_Jet_Entity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, 7, null));

            }
        }
    }

    @Override
    public void tick() {

        this.trailPoints.addFirst(this.position());

        super.tick();

        prevDeltaMovementX = getDeltaMovement().x;
        prevDeltaMovementY = getDeltaMovement().y;
        prevDeltaMovementZ = getDeltaMovement().z;
        setYRot(-((float) Mth.atan2(getDeltaMovement().x, getDeltaMovement().z)) * (180F / (float)Math.PI)) ;
        while (this.trailPoints.size() > MAX_TRAIL_LENGTH) {
            this.trailPoints.removeLast();
        }

     //   makeTrail();


    }


    public TrailSettings getTrailSettings() {

        return TRAIL_SETTINGS;

    }
    public List<Vec3> getTrailPoints() {
        return new ArrayList<>(this.trailPoints);
    }

    public boolean shouldTrailRender() {
        return this.isAlive();
    }

    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), ModSounds.EXPLOSION.get(), SoundSource.BLOCKS, 4.0F, (1.0F + (this.level().random.nextFloat() - this.level().random.nextFloat()) * 0.2F) * 0.7F, false);

            this.level().addParticle(ModParticle.FLARE_EXPLODE.get(), this.getX(), this.getY(), this.getZ(), 0.1D, 0, 0);
        }

    }


    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    @Override
    protected double getDefaultGravity() {
        return 0.025D;
    }
}