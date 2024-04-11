package com.github.L_Ender.cataclysm.world.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;

public class CMWorldData extends SavedData {

    private static final String IDENTIFIER = "cataclysm_world_data";
    private boolean LeviathanBossDefeatedOnce = false;
    private boolean IgnisBossDefeatedOnce = false;

    private CMWorldData() {
        super();
    }

    public static CMWorldData get(Level world, ResourceKey<Level> dim) {
        if (world instanceof ServerLevel) {
            ServerLevel overworld = world.getServer().getLevel(dim);
            DimensionDataStorage storage = overworld.getDataStorage();
            CMWorldData data = storage.computeIfAbsent(CMWorldData::load, CMWorldData::new, IDENTIFIER);
            if (data != null) {
                data.setDirty();
            }
            return data;
        }
        return null;
    }


    public static CMWorldData load(CompoundTag nbt) {
        CMWorldData data = new CMWorldData();
        data.LeviathanBossDefeatedOnce = nbt.getBoolean("LeviathanDefeatedOnce");
        data.IgnisBossDefeatedOnce = nbt.getBoolean("IgnisDefeatedOnce");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag compound) {
        compound.putBoolean("LeviathanDefeatedOnce", LeviathanBossDefeatedOnce);
        compound.putBoolean("IgnisDefeatedOnce", IgnisBossDefeatedOnce);
        return compound;
    }


    public boolean isLeviathanDefeatedOnce(){
        return LeviathanBossDefeatedOnce;
    }

    public void setLeviathanDefeatedOnce(boolean defeatedOnce){
        this.LeviathanBossDefeatedOnce = defeatedOnce;
    }

    public boolean isIgnisDefeatedOnce(){
        return IgnisBossDefeatedOnce;
    }

    public void setIgnisDefeatedOnce(boolean defeatedOnce){
        this.IgnisBossDefeatedOnce = defeatedOnce;
    }

}
