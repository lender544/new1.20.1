package com.github.L_Ender.cataclysm.blocks;

import com.github.L_Ender.cataclysm.init.ModTag;

import com.github.L_Ender.cataclysm.init.ModTileentites;
import com.github.L_Ender.cataclysm.blockentities.TileEntityObsidianExplosionTrapBricks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;

public class ObsidianExplosionTrapBricks extends BaseEntityBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public ObsidianExplosionTrapBricks(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.valueOf(false)));
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(LIT);
    }

    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT)) {
            worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3);
        }

    }

    public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        activate(worldIn.getBlockState(pos), worldIn, pos, entityIn);
        super.stepOn(worldIn, pos, state, entityIn);
    }

    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
        if (stateIn.getValue(LIT)) {
            spawnParticles(worldIn, pos);
        }

    }

    public RenderShape getRenderShape(BlockState p_149645_1_) {
        return RenderShape.MODEL;
    }

    private static void spawnParticles(Level world, BlockPos worldIn) {
        double d0 = 0.5625D;
        RandomSource random = world.random;

        for(Direction direction : Direction.values()) {
            BlockPos blockpos = worldIn.relative(direction);
            if (!world.getBlockState(blockpos).isSolidRender(world, blockpos)) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + d0 * (double)direction.getStepX() : (double)random.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? 0.5D + d0 * (double)direction.getStepY() : (double)random.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + d0 * (double)direction.getStepZ() : (double)random.nextFloat();
                world.addParticle(ParticleTypes.REVERSE_PORTAL, (double)worldIn.getX() + d1, (double)worldIn.getY() + d2, (double)worldIn.getZ() + d3, 0.0D, 0.0D, 0.0D);
            }
        }


    }

    public static boolean shouldTrigger(Entity entity) {
        if(entity instanceof LivingEntity) {
            if (!entity.getType().is(ModTag.TRAP_BLOCK_NOT_DETECTED)) {
                if (entity instanceof Player) {
                    return !((Player) entity).isCreative() && !entity.isSpectator();
                } else return !(entity instanceof ArmorStand);
            }
        }
        return false;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    private static void activate(BlockState state, Level world, BlockPos pos, Entity entity) {
        if (!state.getValue(LIT) && shouldTrigger(entity)) {
            world.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileEntityObsidianExplosionTrapBricks(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
        return createTickerHelper(p_152182_, ModTileentites.OBSIDIAN_EXPLOSION_TRAP_BRICKS.get(), TileEntityObsidianExplosionTrapBricks::commonTick);
    }

}