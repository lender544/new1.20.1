package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.blocks.ObsidianExplosionTrapBricks;
import com.github.L_Ender.cataclysm.init.ModTag;

import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TileEntityObsidianExplosionTrapBricks extends BlockEntity {

    public int tickCount;


    public TileEntityObsidianExplosionTrapBricks(BlockPos pos, BlockState state) {
        super(ModTileentites.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, TileEntityObsidianExplosionTrapBricks entity) {
        entity.tick();
    }

    public void tick() {
        boolean LIT = false;
        if(getBlockState().getBlock() instanceof ObsidianExplosionTrapBricks){
            LIT = getBlockState().getValue(ObsidianExplosionTrapBricks.LIT);
        }
        if(LIT){
            tickCount++;
            float x = this.getBlockPos().getX() + 0.5F;
            float y = this.getBlockPos().getY();
            float z = this.getBlockPos().getZ() + 0.5F;
            float f = 5F;
            if (tickCount < 80) {
                for (LivingEntity inRange : level.getEntitiesOfClass(LivingEntity.class, new AABB((double) x - f, (double) y - f, (double) z - f, (double) x + f, (double) y + f, (double) z + f))) {
                    if (inRange instanceof Player && ((Player) inRange).getAbilities().invulnerable) continue;
                    if (inRange.getType().is(ModTag.TRAP_BLOCK_NOT_DETECTED)) continue;
                    Vec3 diff = inRange.position().subtract(Vec3.atCenterOf(getBlockPos().offset(0, 0, 0)));
                    diff = diff.normalize().scale(0.06);
                    inRange.setDeltaMovement(inRange.getDeltaMovement().subtract(diff));
                }
                if (level.isClientSide) {
                    for (int i = 0; i < 3; ++i) {
                        int j = level.random.nextInt(2) * 2 - 1;
                        int k = level.random.nextInt(2) * 2 - 1;
                        double d0 = (double) worldPosition.getX() + 0.5D + 0.25D * (double) j;
                        double d1 = (float) worldPosition.getY() + level.random.nextFloat();
                        double d2 = (double) worldPosition.getZ() + 0.5D + 0.25D * (double) k;
                        double d3 = level.random.nextFloat() * (float) j;
                        double d4 = ((double) level.random.nextFloat() - 0.5D) * 0.125D;
                        double d5 = level.random.nextFloat() * (float) k;
                        level.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
                    }
                }
            }
            if(tickCount == 80) {
                if (!level.isClientSide) {
                    level.explode(null, x, y + 1, z, 3.0F, Level.ExplosionInteraction.NONE);
                }
            }

        }else{
            tickCount=0;
        }
    }
}


