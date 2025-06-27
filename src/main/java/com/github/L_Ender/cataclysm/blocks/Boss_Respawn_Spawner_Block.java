package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.github.L_Ender.cataclysm.blockentities.Door_Of_Seal_BlockEntity;
import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class Boss_Respawn_Spawner_Block extends BaseEntityBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public Boss_Respawn_Spawner_Block() {

        super(Properties.of()
                .mapColor(MapColor.METAL)
                .noOcclusion()
                .strength(-1.0F, 3600000.0F)
                .noLootTable()
                .sound(SoundType.STONE));
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)));

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new Boss_Respawn_Spawner_Block_Entity(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return createTickerHelper(p_152182_, ModTileentites.BOSS_RESPAWNER.get(), Boss_Respawn_Spawner_Block_Entity::tick);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!state.getValue(LIT)) {
            if (!level.isClientSide) {
                if (level.getBlockEntity(pos) instanceof Boss_Respawn_Spawner_Block_Entity spawnerBlockEntitylockentity ) {
                    ItemStack itemstack = spawnerBlockEntitylockentity.getItem(0);
                    ItemStack stack = player.getItemInHand(hand);
                    if (stack.is(itemstack.getItem())) {
                        if (!player.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                        spawnerBlockEntitylockentity.onHit(level);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
                    }
                }

            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(LIT);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_51567_) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

}
