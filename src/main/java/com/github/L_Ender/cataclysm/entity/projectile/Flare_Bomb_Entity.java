package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.LightTrailParticle;
import com.github.L_Ender.cataclysm.client.particle.StormParticle;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Old_Netherite_Monstrosity_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import com.github.L_Ender.cataclysm.entity.partentity.Old_Netherite_Monstrosity_Part;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.message.MessageParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PacketDistributor;

public class Flare_Bomb_Entity extends ThrowableProjectile {


    public double prevDeltaMovementX, prevDeltaMovementY, prevDeltaMovementZ;

    public Flare_Bomb_Entity(EntityType<Flare_Bomb_Entity> type, Level world) {
        super(type, world);
    }

    public Flare_Bomb_Entity(EntityType<Flare_Bomb_Entity> type, Level world, LivingEntity thrower) {
        super(type, thrower, world);
    }


    @Override
    protected void defineSynchedData() {

    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity shooter = this.getOwner();
        if (!this.level().isClientSide&& !(result.getEntity() instanceof Flare_Bomb_Entity || shooter instanceof Netherite_Monstrosity_Entity && (result.getEntity() instanceof Netherite_Monstrosity_Part || result.getEntity() instanceof Netherite_Monstrosity_Entity)||
                shooter instanceof Old_Netherite_Monstrosity_Entity && (result.getEntity() instanceof Old_Netherite_Monstrosity_Part || result.getEntity() instanceof Old_Netherite_Monstrosity_Entity))) {
            Entity entity = result.getEntity();
            Entity entity1 = this.getOwner();
            boolean flag;
            if (entity1 instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)entity1;
                flag = entity.hurt(this.damageSources().mobProjectile(this, livingentity), (float) CMConfig.FlareBombDamage);
                if (flag) {
                    if (entity.isAlive()) {
                        entity.setSecondsOnFire(5);
                        this.doEnchantDamageEffects(livingentity, entity);
                    }
                }
            } else {
                entity.hurt(this.damageSources().magic(), 7);
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




    private void PlusStrikeRune(int rune, double time) {
        for (int i = 0; i < 4; i++) {

            float yawRadians = (float) (Math.toRadians(90 + this.getYRot()));
            float throwAngle = yawRadians + i * Mth.PI / 2;

            for (int k = 0; k < rune; ++k) {
                double d2 = 0.8D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnFangs(this.getX() + (double) Mth.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) Mth.sin(throwAngle) * 1.25D * d2, this.getY() -2, this.getY() + 2, throwAngle, d3);
            }

        }

    }

    private void XStrikeRune(int rune, double time) {
        for (int i = 0; i < 4; i++) {

            float yawRadians = (float) (Math.toRadians(45 + this.getYRot()));
            float throwAngle = yawRadians + i * Mth.PI / 2;

            for (int k = 0; k < rune; ++k) {
                double d2 = 0.8D * (double) (k + 1);
                int d3 = (int) (time * (k + 1));
                this.spawnFangs(this.getX() + (double) Mth.cos(throwAngle) * 1.25D * d2, this.getZ() + (double) Mth.sin(throwAngle) * 1.25D * d2, this.getY() - 2, this.getY() + 2, throwAngle, d3);
            }

        }

    }


    private void spawnFangs(double x, double z, double minY, double maxY, float rotation, int delay) {
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
                this.level().addFreshEntity(new Flame_Jet_Entity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float) CMConfig.FlareBombDamage, living));
            }else{
                this.level().addFreshEntity(new Flame_Jet_Entity(this.level(), x, (double) blockpos.getY() + d0, z, rotation, delay, (float) CMConfig.FlareBombDamage, null));

            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        prevDeltaMovementX = getDeltaMovement().x;
        prevDeltaMovementY = getDeltaMovement().y;
        prevDeltaMovementZ = getDeltaMovement().z;

        setYRot(-((float) Mth.atan2(getDeltaMovement().x, getDeltaMovement().z)) * (180F / (float)Math.PI)) ;

        if (this.level().isClientSide){
            double dx = getX() + 1.5F * (random.nextFloat() - 0.5F);
            double dy = getY() + 1.5F * (random.nextFloat() - 0.5F);
            double dz = getZ() + 1.5F * (random.nextFloat() - 0.5F);
            float ran = 0.04f;
            float r = 195/255F + random.nextFloat() * ran * 1.5F;
            float g = 95/255F + random.nextFloat() * ran;
            float b = 3/255F + random.nextFloat() * ran;
            this.level().addParticle((new LightTrailParticle.OrbData(r, g, b,0.1F,this.getBbHeight()/2,this.getId())),  dx, dy, dz, 0, 0, 0);

        }



     //   makeTrail();


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

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);
        if (id == 4) {
            this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS, 4.0F, (1.0F + (this.level().random.nextFloat() - this.level().random.nextFloat()) * 0.2F) * 0.7F, false);

            this.level().addParticle(ModParticle.FLARE_EXPLODE.get(), this.getX(), this.getY(), this.getZ(), this.random.nextGaussian() * 0.05D, 0.005D, this.random.nextGaussian() * 0.05D);

        }

    }


    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    @Override
    protected float getGravity() {
        return 0.025F;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}