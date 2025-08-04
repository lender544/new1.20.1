package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.blocks.Cursed_Tombstone_Block;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.cataclysm.entity.effect.ScreenShake_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.init.ModTag;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TurtleEggBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

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
                if(entity.summonCooldownProgress < CMConfig.Cursed_tombstone_summon_cooldown * 1200){
                    entity.summonCooldownProgress++;
                }else{

                    level.setBlock(pos, blockState.setValue(Cursed_Tombstone_Block.POWERED, Boolean.valueOf(true)), 2);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(null, blockState));

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
                            ScreenShake_Entity.ScreenShake(level, Vec3.atCenterOf(pos), 20, 0.1f, 0, 40);
                            maledictus.setPos(pos.getX() + 0.5, pos.getY() + 2, pos.getZ() + 0.5);
                            maledictus.setHomePos(pos);
                            maledictus.setTombstonePos(pos);
                            maledictus.setTombstoneDirection(blockState.getValue(Cursed_Tombstone_Block.FACING));
                            if (level instanceof ServerLevel) {
                                ResourceLocation dimLoc = level.dimension().location();
                                maledictus.setDimensionType(dimLoc.toString());
                            }

                                int MthX = Mth.floor(pos.getX());
                                int MthY = Mth.floor(pos.getY());
                                int MthZ = Mth.floor(pos.getZ());
                                for (int k2 = -1; k2 <= 1; ++k2) {
                                    for (int l2 = -1; l2 <= 1; ++l2) {
                                        for (int j = 0; j <= 5; ++j) {
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
                                if (level.addFreshEntity(maledictus)) {
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

    public void loadAdditional(CompoundTag p_155312_, HolderLookup.Provider p_324612_) {
        super.loadAdditional(p_155312_,p_324612_);
        if (p_155312_.contains("summonCooldownProgress", 11)) {
            this.summonCooldownProgress = p_155312_.getInt("summonCooldownProgress");
        }

    }

    protected void saveAdditional(CompoundTag p_187518_, HolderLookup.Provider p_324418_) {
        super.saveAdditional(p_187518_, p_324418_);
        p_187518_.putInt("summonCooldownProgress", this.summonCooldownProgress);
    }

}


