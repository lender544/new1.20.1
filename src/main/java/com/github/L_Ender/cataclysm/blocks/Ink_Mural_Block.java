package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.init.ModBlocks;
import com.google.common.collect.Lists;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;


import java.util.List;

public class Ink_Mural_Block extends Mural_Block {


    private static final List<RegistryObject<Block>> RANDOM_INK = Util.make(Lists.newArrayList(), (list) -> {
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_URCHINKIN);
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_CINDARIA);
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_HIPPOCAMTUS);
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_CLAWDIAN);
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_THUNDER);
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_SEA);
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_UNDERWORLD);
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_HARVEST);
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_WISDOM);
        list.add(ModBlocks.AZURE_SEASTONE_MURAL_SMITHING);
    });


    public Ink_Mural_Block(Properties properties) {
        super(properties);

    }

    public InteractionResult use(BlockState state,Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stack = player.getItemInHand(hand);
        if (!stack.is(Items.INK_SAC) && !stack.is(Items.WET_SPONGE)) {
            return super.use(state, level, pos, player, hand, hitResult);
        } else if (level.isClientSide) {
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            Item item = stack.getItem();
            boolean water = state.getValue(WATERLOGGED);
            AttachFace face = state.getValue(FACE);
            Direction facing = state.getValue(FACING);
            if (stack.is(Items.INK_SAC)) {
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                BlockState mural = Util.getRandom(RANDOM_INK, level.getRandom()).get().defaultBlockState().setValue(Ink_Mural_Block.WATERLOGGED,water).setValue(Ink_Mural_Block.FACE,face).setValue(Ink_Mural_Block.FACING,facing);
                level.setBlockAndUpdate(pos, mural);
            }
            if (level.getBlockState(pos).getBlock() != ModBlocks.AZURE_SEASTONE_MURAL_EMPTY.get()) {
                if (stack.is(Items.WET_SPONGE)) {;
                    level.setBlockAndUpdate(pos, ModBlocks.AZURE_SEASTONE_MURAL_EMPTY.get().defaultBlockState().setValue(Ink_Mural_Block.WATERLOGGED,water).setValue(Ink_Mural_Block.FACE,face).setValue(Ink_Mural_Block.FACING,facing));
                }
            }
            player.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.sidedSuccess(level.isClientSide);

        }
    }

}