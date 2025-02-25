package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.entity.projectile.Void_Rune_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class PurpurVoidRuneTrapBlock extends TrapBlock {
    //The code and texture were brought from savage and ravage. Thx abnormal
    public PurpurVoidRuneTrapBlock(Properties properties) {
        super(properties);
    }

    /**
     * Called when the given entity walks on this Block
     */

    public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.stepOn(worldIn, pos, state, entityIn);
    }

    private static void activate(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (!state.getValue(LIT) && shouldTrigger(entity)) {
            Void_Rune_Entity voidrune = ModEntities.VOID_RUNE.get().create(world);
            if (voidrune != null) {
                voidrune.moveTo(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0.0F, 0.0F);
                voidrune.setDamage(7F);
                world.addFreshEntity(voidrune);
            }
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50,3));
            world.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3);
        }
    }
}
