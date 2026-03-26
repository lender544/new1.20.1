package com.github.L_Ender.cataclysm.config;

import com.github.L_Ender.cataclysm.Cataclysm;


public class CMClientConfig {
    public static boolean shadersCompat = false;
    public static boolean firstPerson = true;
    public static boolean thirdPerson = true;
    public static boolean ScreenShake = true;
    public static boolean BossMusic = true;
    public static int BossMusicVolume = 1;
    public static boolean customBossBars = true;


    public static void Clientbake(ClientConfig config) {
        try {
            shadersCompat = config.shadersCompat.get();
            firstPerson = config.firstPerson.get();
            thirdPerson = config.thirdPerson.get();
            ScreenShake = config.ScreenShake.get();
            BossMusic = config.BossMusic.get();

            BossMusicVolume = config.BossMusicVolume.get();
            customBossBars = config.custombossbar.get();


        } catch (Exception e) {
            Cataclysm.LOGGER.warn("An exception was caused trying to load the config for CM");
            e.printStackTrace();
        }
    }
}