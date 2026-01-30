package com.github.L_Ender.cataclysm.client.event;

import net.minecraft.util.Mth;

public class CameraZoomManager {

    private static boolean active = false;
    private static int tickCounter = 0;
    private static int totalDuration = 0;
    private static float maxDistance = 0.0F;
    private static float startWeight = 1.0F;
    private static float midWeight = 0.0F;
    private static float endWeight = 1.0F;

    public static void startZoom(int duration, float distance, float n, float u, float m) {
        active = true;
        tickCounter = 0;
        totalDuration = duration;
        maxDistance = distance;
        startWeight = n;
        midWeight = u;
        endWeight = m;
    }

    public static void tick() {
        if (!active) return;

        tickCounter++;
        if (tickCounter >= totalDuration) {
            active = false;
            tickCounter = 0;
        }
    }

    public static float getZoomOffset(float partialTick) {
        if (!active) return 0.0F;

        float progress = (tickCounter + partialTick) / (float) totalDuration;

        progress = Mth.clamp(progress, 0.0F, 1.0F);

        float curve = calculateCustomCurve(progress, startWeight, midWeight, endWeight);

        return maxDistance * curve;
    }

    private static float calculateCustomCurve(float progress, float N, float U, float M) {
        float total = N + U + M;

        float start = progress * (total / N);

        float end = (1.0F - progress) * (total / M);

        float tri = Math.min(start, end);

        float trapezoid = Math.min(1.0F, tri);

        trapezoid = Math.max(0.0F, trapezoid);

        return Mth.sin(trapezoid * Mth.PI / 2.0F);
    }


    public static boolean isActive() {
        return active;
    }
}