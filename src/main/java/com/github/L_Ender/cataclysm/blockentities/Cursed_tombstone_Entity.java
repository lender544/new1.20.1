package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.blocks.Cursed_Tombstone_Block;
import com.github.L_Ender.cataclysm.blocks.Door_of_Seal_Block;
import com.github.L_Ender.cataclysm.blocks.Sandstone_Ignite_Trap;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class Cursed_tombstone_Entity extends BlockEntity {

    public int tickCount;
    public int summonCooldownProgress = 0;
    private final RandomSource rnd = RandomSource.create();


    public Cursed_tombstone_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.CURSED_TOMBSTONE.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState blockState, Cursed_tombstone_Entity entity) {
        if(blockState.getBlock() instanceof Cursed_Tombstone_Block) {
            if (!blockState.getValue(Cursed_Tombstone_Block.POWERED)) {
                if(entity.summonCooldownProgress < CMConfig.Cursed_tombstone_summon_cooldown * 120){
                    entity.summonCooldownProgress++;
                }else{
                    if (!level.isClientSide) {
                        level.setBlock(pos, blockState.setValue(Cursed_Tombstone_Block.POWERED, Boolean.valueOf(true)), 2);
                    }
                }
            }else{
                if (blockState.getValue(Cursed_Tombstone_Block.LIT)) {
                    entity.tickCount++;
                    if(entity.tickCount == 1) {
                        ScreenShake_Entity.ScreenShake(level, Vec3.atCenterOf(pos), 20, 0.05f, 0, 80);
                        //   this.level.addFreshEntity(new Flame_Strike_Entity(this.level, this.getBlockPos().getX() + 0.5F, this.getBlockPos().getY(), this.getBlockPos().getZ() + 0.5F, 0, 0, 100, 0, 2.5F, false, null));
                    }
                    if(entity.tickCount > 60 && entity.tickCount < 63) {
                        double d0 = pos.getX() + 0.5F;
                        double d1 = pos.getY() + 2;
                        double d2 = pos.getZ() + 0.5F;
                        float size = 3;

                        for (float i = -size; i <= size; ++i) {
                            for (float j = -size; j <= size; ++j) {
                                for (float k = -size; k <= size; ++k) {
                                    double d3 = (double) j + (entity.rnd.nextDouble() - entity.rnd.nextDouble()) * 0.5D;
                                    double d4 = (double) i + (entity.rnd.nextDouble() - entity.rnd.nextDouble()) * 0.5D;
                                    double d5 = (double) k + (entity.rnd.nextDouble() - entity.rnd.nextDouble()) * 0.5D;
                                    double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + entity.rnd.nextGaussian() * 0.05D;

                                    level.addParticle(ModParticle.PHANTOM_WING_FLAME.get(), d0, d1, d2, d3 / d6, d4 / d6, d5 / d6);

                                    if (i != -size && i != size && j != -size && j != size) {
                                        k += size * 2 - 1;

                                    }
                                }
                            }
                        }
                    }
                    if(entity.tickCount > 63) {
                        Maledictus_Entity maledictus = ModEntities.MALEDICTUS.get().create(level);
                        if (maledictus != null) {
                            maledictus.setPos(pos.getX(), pos.getY() + 2, pos.getZ());
                            maledictus.setTombstonePos(pos);
                            maledictus.setTombstoneDirection(blockState.getValue(Cursed_Tombstone_Block.FACING));
                            if (!level.isClientSide) {
                                int MthX = Mth.floor(pos.getX());
                                int MthY = Mth.floor(pos.getY());
                                int MthZ = Mth.floor(pos.getZ());
                                for (int k2 = -3; k2 <= 3; ++k2) {
                                    for (int l2 = -3; l2 <= 3; ++l2) {
                                        for (int j = 0; j <= 3; ++j) {
                                            int i3 = MthX + k2;
                                            int k = MthY + j;
                                            int l = MthZ + l2;
                                            BlockPos blockpos = new BlockPos(i3, k, l);
                                            BlockState block = level.getBlockState(blockpos);
                                            if (block != Blocks.AIR.defaultBlockState() && !block.is(ModTag.ALTAR_DESTROY_IMMUNE)) {
                                                level.destroyBlock(blockpos, false);
                                            }

                                        }
                                    }
                                }
                                level.addFreshEntity(maledictus);
                                level.destroyBlock(pos, false);
                            }
                        }
                    }

                }else{
                    entity.tickCount = 0;
                }
            }
        }

    }

    public void load(CompoundTag p_155312_) {
        super.load(p_155312_);
        if (p_155312_.contains("summonCooldownProgress", 11)) {
            this.summonCooldownProgress = p_155312_.getInt("summonCooldownProgress");
        }

    }

    protected void saveAdditional(CompoundTag p_187486_) {
        super.saveAdditional(p_187486_);
        p_187486_.putInt("summonCooldownProgress", this.summonCooldownProgress);
    }

}


