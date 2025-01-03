package com.github.L_Ender.cataclysm.world.structures.terrainadaptation;

import com.mojang.serialization.Codec;

public class NoneAdaptation extends EnhancedTerrainAdaptation {
    private static final NoneAdaptation INSTANCE = new NoneAdaptation();
    public static final Codec<NoneAdaptation> CODEC = Codec.unit(() -> INSTANCE);

    public NoneAdaptation() {
        super(0, 0, false, false);
    }

    @Override
    public EnhancedTerrainAdaptationType<?> type() {
        return EnhancedTerrainAdaptationType.NONE;
    }

    @Override
    public double computeDensityFactor(int xDistance, int yDistance, int zDistance, int yDistanceToBeardBase) {
        return 0;
    }
}
