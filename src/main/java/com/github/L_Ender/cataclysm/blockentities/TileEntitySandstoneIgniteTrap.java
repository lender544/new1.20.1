package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.blocks.Sandstone_Ignite_Trap;
import com.github.L_Ender.cataclysm.init.ModSounds;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class TileEntitySandstoneIgniteTrap extends BlockEntity {

    public int tickCount;
    private final RandomSource random = RandomSource.create();

    public TileEntitySandstoneIgniteTrap(BlockPos pos, BlockState state) {
        super(ModTileentites.SANDSTONE_IGNITE_TRAP.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, TileEntitySandstoneIgniteTrap entity) {
        entity.tick(level, pos);
    }

    public void tick(Level level, BlockPos pos) {
        boolean LIT = false;
        if(getBlockState().getBlock() instanceof Sandstone_Ignite_Trap){
            LIT = getBlockState().getValue(Sandstone_Ignite_Trap.LIT);
        }
        if(LIT){
            tickCount++;
            double spread = Math.PI * 2 ;
            int arcLen = Mth.ceil(2 * spread);
            if (level.isClientSide()) {
                for (int j = 0; j < arcLen; ++j) {
                        float f2 = this.random.nextFloat() * ((float) Math.PI * 2F);
                        double d0 = pos.getX() + 0.5f + (double) (Mth.cos(f2) * 0.35) * 0.9;
                        double d2 = pos.above().getY();
                        double d4 = pos.getZ() + 0.5f + (double) (Mth.sin(f2) * 0.35) * 0.9;
                        level.addParticle(ParticleTypes.FLAME, d0, d2, d4, 0, 0.5D, 0);

                }
            }else {
                if (tickCount % 5 == 0) {

                    List<LivingEntity> entitiesInRange = level.getEntitiesOfClass(LivingEntity.class,
                            new AABB(pos.offset(-1, 0, -1), pos.offset(1, 6, 1)));

                    for (LivingEntity entity : entitiesInRange) {
                        if (!entity.fireImmune()) {
                            entity.hurt(entity.level().damageSources().inFire(), 5);
                            entity.setSecondsOnFire(5);
                        }
                    }
                }

            }
        }else{
            tickCount=0;
        }
    }
}


