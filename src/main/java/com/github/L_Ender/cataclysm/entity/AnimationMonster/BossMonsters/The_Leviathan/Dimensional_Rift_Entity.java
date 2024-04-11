package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.effect.Cm_Falling_Block_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTag;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.UUID;

public class Dimensional_Rift_Entity extends Entity {

    protected static final EntityDataAccessor<Integer> LIFESPAN = SynchedEntityData.defineId(Dimensional_Rift_Entity.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> STAGE = SynchedEntityData.defineId(Dimensional_Rift_Entity.class, EntityDataSerializers.INT);

    private boolean madeOpenNoise = false;
    private boolean madeCloseNoise = false;
    private boolean madeParticle = false;
    @Nullable
    private LivingEntity owner;
    @Nullable
    private UUID ownerUUID;
    public int ambientSoundTime;
    private final ObjectArrayList<BlockPos> toBlow = new ObjectArrayList<>();
    public Dimensional_Rift_Entity(EntityType<?> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public Dimensional_Rift_Entity(Level worldIn, double x, double y, double z, LivingEntity casterIn) {
        this(ModEntities.DIMENSIONAL_RIFT.get(), worldIn);
        this.setOwner(casterIn);
        this.setLifespan(300);
        this.setPos(x, y, z);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    public void tick() {
        super.tick();
        if(!madeOpenNoise){
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.playSound(ModSounds.BLACK_HOLE_OPENING.get(), 0.7F, 1 + random.nextFloat() * 0.2F);
            madeOpenNoise = true;
        }


        for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(30))) {
            if (entity != owner) {
                if (entity instanceof Player && ((Player) entity).getAbilities().invulnerable) continue;
                if (isAlliedTo(entity)) continue;
                if (entity instanceof The_Leviathan_Entity) continue;
                if (entity instanceof The_Leviathan_Tongue_Entity) continue;
                Vec3 diff = entity.position().subtract(this.position().add(0, 0, 0));
                if (entity instanceof LivingEntity) {
                    diff = diff.normalize().scale( getStage() * 0.015);
                    entity.setDeltaMovement(entity.getDeltaMovement().subtract(diff));
                } else {
                    diff = diff.normalize().scale(getStage() * 0.045);
                    entity.setDeltaMovement(entity.getDeltaMovement().subtract(diff));
                }
            }
        }
            berserkBlockBreaking(15, 15, 15);

            for (LivingEntity livingentity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(0.2D, 0.0D, 0.2D))) {
                this.damage(livingentity);
            }

            for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(0.5))) {
                if (entity instanceof Cm_Falling_Block_Entity) {
                    entity.remove(RemovalReason.DISCARDED);
                }
            }


            if (this.random.nextInt(3000) < this.ambientSoundTime++) {
                this.resetAmbientSoundTime();
                this.playSound(ModSounds.BLACK_HOLE_LOOP.get(), 0.7F, 1 + random.nextFloat() * 0.2F);
            }



        this.setLifespan(this.getLifespan() - 1);
        if(this.getLifespan() <= 100){
            if(!madeCloseNoise){
                this.gameEvent(GameEvent.ENTITY_PLACE);
                this.playSound(ModSounds.BLACK_HOLE_CLOSING.get(), 0.7F, 1 + random.nextFloat() * 0.2F);
                madeCloseNoise = true;
            }
            if(this.tickCount % 40 == 0){
                this.setStage(this.getStage() - 1);
            }

            if (this.getStage() <= 0) {
                if(!madeParticle){
                    if (this.level().isClientSide) {
                        this.level().addParticle(ModParticle.SHOCK_WAVE.get(), this.getX(), this.getY(), this.getZ(), 0, 0, 0);
                    }else{
                        this.level().explode(this.owner, this.getX(), this.getY(), this.getZ(), 4.0F, false, Level.ExplosionInteraction.NONE);
                    }
                    madeParticle = true;
                }else{
                    this.discard();
                }
            }
        }
    }

    private void damage(LivingEntity Hitentity) {
        LivingEntity livingentity = this.getOwner();
        if (Hitentity.isAlive() && !Hitentity.isInvulnerable() && Hitentity != livingentity && !(Hitentity instanceof The_Leviathan_Entity)) {
            if (this.tickCount % 5 == 0) {
                if (livingentity == null) {
                    Hitentity.hurt(damageSources().magic(), (float) CMConfig.DimensionalRiftdamage);
                } else {
                    if (livingentity.isAlliedTo(Hitentity)) {
                        return;
                    }
                    Hitentity.hurt(damageSources().indirectMagic(this, livingentity), (float) CMConfig.DimensionalRiftdamage);
                }
            }
        }
    }


    private void berserkBlockBreaking(int x, int y, int z) {
        int MthX = Mth.floor(this.getX());
        int MthY = Mth.floor(this.getY());
        int MthZ = Mth.floor(this.getZ());
        if (!this.level().isClientSide) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                for (int k2 = -x; k2 <= x; ++k2) {
                    for (int l2 = -z; l2 <= z; ++l2) {
                        for (int j = -y; j <= y; ++j) {
                            int i3 = MthX + k2;
                            int k = MthY + j;
                            int l = MthZ + l2;
                            BlockPos blockpos = new BlockPos(i3, k, l);

                            BlockPos blockonpos = new BlockPos(i3, k+1, l);

                            BlockState block = level().getBlockState(blockpos);
                            BlockState blockon = level().getBlockState(blockonpos);
                            BlockEntity tileEntity = level().getBlockEntity(blockpos);
                            if ((blockon == Blocks.AIR.defaultBlockState() || blockon == Blocks.WATER.defaultBlockState()) && block != Blocks.AIR.defaultBlockState() && !block.is(ModTag.LEVIATHAN_IMMUNE)) {
                                if (tileEntity == null && random.nextInt(2000) == 0) {
                                    this.level().removeBlock(blockpos, true);
                                    Cm_Falling_Block_Entity fallingBlockEntity = new Cm_Falling_Block_Entity(level(), i3 + 0.5D, k + 0.5D, l + 0.5D, block, 5);
                                    level().setBlock(blockpos, block.getFluidState().createLegacyBlock(), 3);
                                    level().addFreshEntity(fallingBlockEntity);

                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public int getAmbientSoundInterval() {
        return 80;
    }

    private void resetAmbientSoundTime() {
        this.ambientSoundTime = -this.getAmbientSoundInterval();
    }

    public int getLifespan() {
        return this.entityData.get(LIFESPAN);
    }

    public void setLifespan(int i) {
        this.entityData.set(LIFESPAN, i);
    }

    public int getStage() {
        return this.entityData.get(STAGE);
    }

    public void setStage(int i) {
        this.entityData.set(STAGE, i);
    }


    public void setOwner(@Nullable LivingEntity p_19719_) {
        this.owner = p_19719_;
        this.ownerUUID = p_19719_ == null ? null : p_19719_.getUUID();
    }

    @Nullable
    public LivingEntity getOwner() {
        if (this.owner == null && this.ownerUUID != null && this.level() instanceof ServerLevel) {
            Entity entity = ((ServerLevel)this.level()).getEntity(this.ownerUUID);
            if (entity instanceof LivingEntity) {
                this.owner = (LivingEntity)entity;
            }
        }

        return this.owner;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(LIFESPAN, 300);
        this.entityData.define(STAGE, 0);
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        this.setLifespan(compound.getInt("Lifespan"));
        this.setStage(compound.getInt("Stage"));
        if (compound.hasUUID("Owner")) {
            this.ownerUUID = compound.getUUID("Owner");
        }

    }

    public boolean shouldRenderAtSqrDistance(double p_36837_) {
        double d0 = this.getBoundingBox().getSize() * 4.0D;
        if (Double.isNaN(d0)) {
            d0 = 4.0D;
        }

        d0 *= 64.0D;
        return p_36837_ < d0 * d0;
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("Lifespan", getLifespan());
        compound.putInt("Stage", getStage());
        if (this.ownerUUID != null) {
            compound.putUUID("Owner", this.ownerUUID);
        }

    }


}
