package com.github.L_Ender.cataclysm.entity.effect;

import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class Cm_Falling_Block_Entity extends Entity {
    public int duration;
    protected static final EntityDataAccessor<BlockPos> DATA_START_POS = SynchedEntityData.defineId(Cm_Falling_Block_Entity.class, EntityDataSerializers.BLOCK_POS);
    private static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(Cm_Falling_Block_Entity.class, EntityDataSerializers.BLOCK_STATE);

    public Cm_Falling_Block_Entity(EntityType<Cm_Falling_Block_Entity> type, Level level) {
        super(type, level);
        this.duration = 20;
    }

    public Cm_Falling_Block_Entity(Level p_31953_, double p_31954_, double p_31955_, double p_31956_, BlockState p_31957_, int duration) {
        this(ModEntities.CM_FALLING_BLOCK.get(), p_31953_);
        this.setBlockState(p_31957_);
        this.setPos(p_31954_, p_31955_ + (double)((1.0F - this.getBbHeight()) / 2.0F), p_31956_);
        this.setDeltaMovement(Vec3.ZERO);
        this.duration = duration;
        this.xo = p_31954_;
        this.yo = p_31955_;
        this.zo = p_31956_;
        this.setStartPos(this.blockPosition());
    }


    public void setStartPos(BlockPos p_31960_) {
        this.entityData.set(DATA_START_POS, p_31960_);
    }

    public BlockPos getStartPos() {
        return this.entityData.get(DATA_START_POS);
    }

    protected void defineSynchedData() {
        this.entityData.define(DATA_START_POS, BlockPos.ZERO);
        this.entityData.define(BLOCK_STATE, Blocks.AIR.defaultBlockState());
    }

    public BlockState getBlockState() {
        return this.entityData.get(BLOCK_STATE);
    }

    public void setBlockState(BlockState p_270267_) {
        this.entityData.set(BLOCK_STATE, p_270267_);
    }

    public void tick() {
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.04D, 0.0D));
        }
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale(0.98D));

        if (this.onGround() && tickCount > duration) {
            discard();
        }
        if (tickCount > 300) {
            discard();
        }

    }

    protected void addAdditionalSaveData(CompoundTag p_31973_) {
        BlockState blockState = getBlockState();
        p_31973_.put("block_state", NbtUtils.writeBlockState(blockState));
        p_31973_.putInt("Time", this.duration);

    }

    protected void readAdditionalSaveData(CompoundTag p_31964_) {
        this.setBlockState(NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), p_31964_.getCompound("block_state")));
        this.duration = p_31964_.getInt("Time");

    }

    public boolean displayFireAnimation() {
        return false;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
