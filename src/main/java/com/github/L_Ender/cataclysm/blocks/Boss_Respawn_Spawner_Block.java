package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.blockentities.AltarOfAmethyst_Block_Entity;
import com.github.L_Ender.cataclysm.blockentities.Boss_Respawn_Spawner_Block_Entity;
import com.github.L_Ender.cataclysm.blockentities.Cursed_tombstone_Entity;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.JukeboxPlayable;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Spawner;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.List;

public class Boss_Respawn_Spawner_Block extends BaseEntityBlock {
    public static final MapCodec<Boss_Respawn_Spawner_Block> CODEC = simpleCodec(Boss_Respawn_Spawner_Block::new);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    @Override
    public MapCodec<Boss_Respawn_Spawner_Block> codec() {
        return CODEC;
    }

    public Boss_Respawn_Spawner_Block(BlockBehaviour.Properties properties) {
        super(properties);
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
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!state.getValue(LIT)) {
            if (!level.isClientSide) {
                if (level.getBlockEntity(pos) instanceof Boss_Respawn_Spawner_Block_Entity spawnerBlockEntitylockentity) {
                    ItemStack itemstack = spawnerBlockEntitylockentity.getTheItem();
                    if (stack.is(itemstack.getItem())) {
                        stack.consume(1, player);
                        spawnerBlockEntitylockentity.onHit(level);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
                    }
                }
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_48814_) {
        p_48814_.add(LIT);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }


}
