package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class Cataclysm_Skull_BlockEntity extends BlockEntity {
    public static final String TAG_NOTE_BLOCK_SOUND = "note_block_sound";
    @Nullable
    private ResourceLocation noteBlockSound;
    private int animationTickCount;
    private boolean isAnimating;

    public Cataclysm_Skull_BlockEntity(BlockPos p_155731_, BlockState p_155732_) {
        super(ModTileentites.CATACLYSM_SKULL.get(), p_155731_, p_155732_);
    }


    protected void saveAdditional(CompoundTag p_187518_) {
        super.saveAdditional(p_187518_);
        if (this.noteBlockSound != null) {
            p_187518_.putString("note_block_sound", this.noteBlockSound.toString());
        }

    }

    public void load(CompoundTag p_155745_) {
        super.load(p_155745_);
        if (p_155745_.contains("note_block_sound", 8)) {
            this.noteBlockSound = ResourceLocation.tryParse(p_155745_.getString("note_block_sound"));
        }

    }

    public static void animation(Level p_261710_, BlockPos p_262153_, BlockState p_262021_, Cataclysm_Skull_BlockEntity p_261594_) {
        if (p_261710_.hasNeighborSignal(p_262153_)) {
            p_261594_.isAnimating = true;
            ++p_261594_.animationTickCount;
        } else {
            p_261594_.isAnimating = false;
        }

    }

    public float getAnimation(float p_262053_) {
        return this.isAnimating ? (float)this.animationTickCount + p_262053_ : (float)this.animationTickCount;
    }

    @Nullable
    public ResourceLocation getNoteBlockSound() {
        return this.noteBlockSound;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
