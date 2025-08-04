package com.github.L_Ender.cataclysm.blockentities;

import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ender_Guardian_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModTileentites;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;


public class AltarOfVoid_Block_Entity extends BlockEntity {

    protected static final int SHORT_RANGE = 6;

    protected boolean spawnedBoss = false;

    public AltarOfVoid_Block_Entity(BlockPos pos, BlockState state) {
        super(ModTileentites.ALTAR_OF_VOID.get(), pos, state);
    }

    public static void commonTick(Level level, BlockPos pos, BlockState state, AltarOfVoid_Block_Entity entity) {
        entity.tick(level,pos,state,entity);
    }

    public boolean anyPlayerInRange(Level level,BlockPos pos) {
        return level.hasNearbyAlivePlayer(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, getRange());
    }

    public void tick(Level level, BlockPos pos, BlockState state, AltarOfVoid_Block_Entity te) {
        if (spawnedBoss || !anyPlayerInRange(level,pos)) {
            return;
        }

        if (level.getDifficulty() != Difficulty.PEACEFUL) {
            if (spawnMyBoss((ServerLevel)level,pos)) {
                level.destroyBlock(pos, false);
                spawnedBoss = true;
            }
        }

    }

    protected boolean spawnMyBoss(ServerLevel serverLevel, BlockPos pos) {
        Vec3 vec3 = Vec3.atLowerCornerWithOffset(pos, 0.5, 0, 0.5);
        Ender_Guardian_Entity entity = ModEntities.ENDER_GUARDIAN.get().create(serverLevel);


        if (entity != null) {
            entity.setPos(vec3);
            entity.setUsedMassDestruction(false);
            entity.setHomePos(pos);
            entity.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(worldPosition), MobSpawnType.SPAWNER, null, null);
            ResourceLocation dimLoc = serverLevel.dimension().location();
            entity.setDimensionType(dimLoc.toString());

            return serverLevel.addFreshEntity(entity);
        }
        return false;
    }

    protected int getRange() {
        return SHORT_RANGE;
    }

}
