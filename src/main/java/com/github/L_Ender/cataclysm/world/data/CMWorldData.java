package com.github.L_Ender.cataclysm.world.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raids;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.maps.MapIndex;
import net.minecraft.world.level.storage.DimensionDataStorage;

public class CMWorldData extends SavedData {

    private static final String IDENTIFIER = "cataclysm_world_data";
    private boolean LeviathanBossDefeatedOnce = false;
    private boolean IgnisBossDefeatedOnce = false;

    private CMWorldData() {
        super();
    }

    public static SavedData.Factory<CMWorldData> factory() {
        return new SavedData.Factory<>(CMWorldData::new, CMWorldData::load);
    }


    public static CMWorldData get(Level world, ResourceKey<Level> dim) {
        if (world instanceof ServerLevel) {
            ServerLevel overworld = world.getServer().getLevel(dim);
            DimensionDataStorage storage = overworld.getDataStorage();
            CMWorldData data = storage.computeIfAbsent(CMWorldData.factory(), IDENTIFIER);
            if (data != null) {
                data.setDirty();
            }
            return data;
        }
        return null;
    }


    public static CMWorldData load(CompoundTag nbt, HolderLookup.Provider p_323806_) {
        CMWorldData data = new CMWorldData();
        data.LeviathanBossDefeatedOnce = nbt.getBoolean("LeviathanDefeatedOnce");
        data.IgnisBossDefeatedOnce = nbt.getBoolean("IgnisDefeatedOnce");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag compound, HolderLookup.Provider p_323890_) {
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
