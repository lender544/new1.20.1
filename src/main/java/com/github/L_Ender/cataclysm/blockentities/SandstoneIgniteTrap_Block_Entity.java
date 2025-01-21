package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.blocks.Sandstone_Ignite_Trap;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class SandstoneIgniteTrap_Block_Entity extends BlockEntity {

    public int tickCount;
    private final RandomSource random = RandomSource.create();

    public SandstoneIgniteTrap_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.SANDSTONE_IGNITE_TRAP.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, SandstoneIgniteTrap_Block_Entity entity) {
        entity.tick(level, pos);
    }

    public void tick(Level level, BlockPos pos) {
        boolean LIT = false;
        if(getBlockState().getBlock() instanceof Sandstone_Ignite_Trap){
            LIT = getBlockState().getValue(Sandstone_Ignite_Trap.LIT);
        }
        if(LIT){
            tickCount++;
            double x = pos.getX();
            double y = pos.above().getY();
            double z = pos.getZ();
            if (level.isClientSide()) {
                level.addParticle(ModParticle.TRAP_FLAME.get(), x + 0.5F, y , z + 0.5F, 0.0D, 0.5D, 0.0D);

            }else {
                if (tickCount % 5 == 0) {

                    List<LivingEntity> entitiesInRange = level.getEntitiesOfClass(LivingEntity.class, new AABB(pos.offset(-1, 0, -1).getCenter(), pos.offset(1, 6, 1).getCenter()));

                    for (LivingEntity entity : entitiesInRange) {
                        if (!entity.getType().is(ModTag.TEAM_ANCIENT_REMNANT)) {
                            if (!entity.fireImmune()) {
                                entity.hurt(entity.level().damageSources().inFire(), 5);
                                entity.igniteForSeconds(5);
                            }
                        }
                    }
                }

            }
        }else{
            tickCount=0;
        }
    }
}


