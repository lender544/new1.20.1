package com.github.L_Ender.cataclysm.entity.projectile;

import com.github.L_Ender.cataclysm.client.particle.LightningParticle;
import com.github.L_Ender.cataclysm.client.particle.TrackLightningParticle;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Phantom_Arrow_Entity extends AbstractArrow {
    private static final EntityDataAccessor<Integer> TRANSPARENCY  = SynchedEntityData.defineId(Phantom_Arrow_Entity.class, EntityDataSerializers.INT);
    @Nullable
    private Entity finalTarget;
    @Nullable
    private UUID targetId;

    private boolean stopSeeking;
    public Phantom_Arrow_Entity(EntityType type, Level worldIn) {
        super(type, worldIn);
    }

    public Phantom_Arrow_Entity(EntityType type, double x, double y, double z, Level worldIn) {
        this(type, worldIn);
        this.setPos(x, y, z);
    }

    public Phantom_Arrow_Entity(Level worldIn, LivingEntity shooter,LivingEntity finalTarget) {
        this(ModEntities.PHANTOM_ARROW.get(), shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
        this.setOwner(shooter);
        this.finalTarget = finalTarget;
        if (shooter instanceof Player) {
            this.pickup = Pickup.ALLOWED;
        }
    }

    public Phantom_Arrow_Entity(Level worldIn, LivingEntity shooter) {
        this(ModEntities.PHANTOM_ARROW.get(), shooter.getX(), shooter.getEyeY() - (double)0.1F, shooter.getZ(), worldIn);
        this.setOwner(shooter);
        if (shooter instanceof Player) {
            this.pickup = Pickup.ALLOWED;
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TRANSPARENCY, 0);
    }

    public Phantom_Arrow_Entity(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(ModEntities.PHANTOM_ARROW.get(), world);
    }

    public int getTransparency() {
        return this.entityData.get(TRANSPARENCY);
    }

    public void setTransparency(int trans) {
        this.entityData.set(TRANSPARENCY, trans);
    }


    public void addAdditionalSaveData(CompoundTag p_37357_) {
        super.addAdditionalSaveData(p_37357_);
        if (this.finalTarget != null) {
            p_37357_.putUUID("Target", this.finalTarget.getUUID());
        }
    }

    public void readAdditionalSaveData(CompoundTag p_37353_) {
        super.readAdditionalSaveData(p_37353_);
        if (p_37353_.hasUUID("Target")) {
            this.targetId = p_37353_.getUUID("Target");
        }
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            if (this.finalTarget == null && this.targetId != null) {
                this.finalTarget = ((ServerLevel) this.level()).getEntity(this.targetId);
                if (this.finalTarget == null) {
                    this.targetId = null;
                }
            }
            setTransparency(this.life);
            if (!inGround && !stopSeeking) {
                if (this.finalTarget != null && this.finalTarget.isAlive() || (this.finalTarget instanceof Player && !this.finalTarget.isSpectator())) {
                    float sqrt = (float) this.getDeltaMovement().length();
                    if (sqrt > 1.25F) {
                        if(this.tickCount > 2){
                            if (finalTarget != null) {
                                Vec3 arcVec = finalTarget.position().add(0, 0.65F * finalTarget.getBbHeight(), 0).subtract(this.position());
                                if (arcVec.length() > finalTarget.getBbWidth()) {
                                    this.setDeltaMovement(this.getDeltaMovement().scale(0.625F).add(arcVec.normalize().scale(0.4775F)));

                                }
                            }

                        }

                    }
                }
            }
        }else{
            Vec3 center = this.position().add(this.getDeltaMovement());
            Vec3 vec3 = center.add(new Vec3(random.nextFloat() - 0.5F, random.nextFloat() - 0.5F, random.nextFloat() - 0.5F));
            this.level().addParticle((new TrackLightningParticle.OrbData(0.1f, 0.42f,  0.35f)), center.x, center.y, center.z, vec3.x, vec3.y, vec3.z);
            Vec3 vec31 = this.getDeltaMovement();
            double d5 = vec31.x;
            double d6 = vec31.y;
            double d1 = vec31.z;
            for(int i = 0; i < 2; ++i) {
                this.level().addParticle(ModParticle.CURSED_FLAME.get(), this.getX() + d5 * (double)i / 4.0D, this.getY() + d6 * (double)i / 4.0D, this.getZ() + d1 * (double)i / 4.0D, 0, 0, 0);
            }
        }
    }


    protected void tickDespawn() {
        ++this.life;
        if (this.life >= 200) {
            this.discard();
        }

    }

    protected void onHitEntity(EntityHitResult p_37573_) {
        Entity entity = p_37573_.getEntity();
        float f = (float)this.getDeltaMovement().length();
        int i = Mth.ceil(Mth.clamp((double)f * this.getBaseDamage(), 0.0D, (double)Integer.MAX_VALUE));
        Entity entity1 = this.getOwner();
        DamageSource damagesource = CMDamageTypes.causeMaledictioSagittaDamage(this, (Entity)(entity1 == null ? this : entity1));

        boolean flag = entity.getType() == EntityType.ENDERMAN;
        this.stopSeeking = true;
        if (this.isOnFire() && !flag) {
            entity.setSecondsOnFire(5);
        }
        if (entity.hurt(damagesource, i)) {
            if (flag) {
                return;
            }

            if (entity instanceof LivingEntity) {
                LivingEntity livingentity1 = (LivingEntity)entity;
                if (entity1 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingentity1, entity1);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)entity1, livingentity1);
                }

                this.doPostHurtEffects(livingentity1);
            }
        } else {
            this.setDeltaMovement(this.getDeltaMovement().scale(-0.1D));
            this.setYRot(this.getYRot() + 180.0F);
            this.yRotO += 180.0F;
            if (!this.level().isClientSide && this.getDeltaMovement().lengthSqr() < 1.0E-7D) {
                if (this.pickup == AbstractArrow.Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }
            }
            this.discard();
        }

        this.playSound(SoundEvents.ARROW_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
    }

    protected void doPostHurtEffects(LivingEntity entity) {
        //stopSeeking = true;
    }

    protected void onHitBlock(BlockHitResult result) {
        /*
        BlockHitResult traceResult = result;
        BlockState blockstate = this.level().getBlockState(traceResult.getBlockPos());
        if (!blockstate.getCollisionShape(this.level(), traceResult.getBlockPos()).isEmpty()) {
            if (this.getTotalBounces() > 5) {
                super.onHitBlock(result);
            } else {
                this.setTotalBounces(this.getTotalBounces() + 1);
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
                this.shoot(motionX, motionY, motionZ, 2.5F, 1.0F);
                this.playSound(this.getHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
            }
        }

         */
        super.onHitBlock(result);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(Items.ARROW);
    }


    @Override
    protected void onHit(HitResult hit) {
        super.onHit(hit);
    }


}
