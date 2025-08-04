package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.blockentities.Cataclysm_Skull_BlockEntity;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;


public class Cataclysm_Skull_Block extends SkullBlock {

    public Cataclysm_Skull_Block(Type p_56318_, BlockBehaviour.Properties p_56319_) {
        super(p_56318_, p_56319_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Cataclysm_Skull_BlockEntity(pos, state);
    }


    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_151992_, BlockState p_151993_, BlockEntityType<T> p_151994_) {
        if (p_151992_.isClientSide) {
            boolean flag = p_151993_.is(ModBlocks.APTRGANGR_HEAD.get()) || p_151993_.is(ModBlocks.APTRGANGR_WALL_HEAD.get()) || p_151993_.is(ModBlocks.KOBOLEDIATOR_SKULL.get()) || p_151993_.is(ModBlocks.KOBOLEDIATOR_WALL_SKULL.get());
            if (flag) {
                return createTickerHelper(p_151994_, ModTileentites.CATACLYSM_SKULL.get(), Cataclysm_Skull_BlockEntity::animation);
            }
        }

        return null;
    }

    public enum Types implements SkullBlock.Type {
        KOBOLEDIATOR("kobolediator"),
        APTRGANGR("aptrgangr"),
        DRAUGR("draugr");
        private final String name;

        private Types(String pName) {
            this.name = pName;
            TYPES.put(pName, this);
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

}
