package com.github.L_Ender.cataclysm.blocks;


import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.github.L_Ender.cataclysm.blockentities.TileEntityAltarOfFire;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class Altar_Of_Fire_Block extends BaseEntityBlock {

    public Altar_Of_Fire_Block() {
        super(Properties.of()
                .noOcclusion()
                .lightLevel((block) -> 7)
                .emissiveRendering((block, world, pos) -> true)
                .strength(-1.0F, 3600000.0F)
                .noLootTable()
                .sound(SoundType.METAL));

    }


    public void animateTick(BlockState p_220918_, Level p_220919_, BlockPos p_220920_, RandomSource p_220921_) {
        if ( p_220921_.nextInt(5) == 0) {
            for(int i = 0; i < p_220921_.nextInt(1) + 1; ++i) {
                p_220919_.addParticle(ParticleTypes.LAVA, (double)p_220920_.getX() + 0.5D, (double)p_220920_.getY() + 1.5D, (double)p_220920_.getZ() + 0.5D, (double)(p_220921_.nextFloat() / 2.0F), 5.0E-5D, (double)(p_220921_.nextFloat() / 2.0F));
            }
        }
    }

    public void entityInside(BlockState p_51269_, Level p_51270_, BlockPos p_51271_, Entity p_51272_) {
        if ( p_51272_ instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)p_51272_)) {
            p_51272_.hurt(p_51270_.damageSources().inFire(), 3);
        }

        super.entityInside(p_51269_, p_51270_, p_51271_, p_51272_);
    }

    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(handIn);
        if (worldIn.getBlockEntity(pos) instanceof TileEntityAltarOfFire && (!player.isShiftKeyDown() && heldItem.getItem() != this.asItem())) {
            TileEntityAltarOfFire aof = (TileEntityAltarOfFire)worldIn.getBlockEntity(pos);
            ItemStack copy = heldItem.copy();
            copy.setCount(1);
            if(aof.getItem(0).isEmpty()){
                aof.setItem(0, copy);
                if(!player.isCreative()){
                    heldItem.shrink(1);
                }
            }else{
                popResource(worldIn, pos, aof.getItem(0).copy());
                aof.setItem(0, ItemStack.EMPTY);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileEntityAltarOfFire(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return createTickerHelper(p_152182_, ModTileentites.ALTAR_OF_FIRE.get(), TileEntityAltarOfFire::commonTick);
    }

}