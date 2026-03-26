package com.github.L_Ender.cataclysm.config;


import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraftforge.common.ForgeConfigSpec;


public class ClientConfig {

    private static final String LANG_PREFIX = "config." + Cataclysm.MODID + ".";

    public final ForgeConfigSpec.BooleanValue shadersCompat;
    public final ForgeConfigSpec.BooleanValue firstPerson;
    public final ForgeConfigSpec.BooleanValue thirdPerson;
    public final ForgeConfigSpec.BooleanValue ScreenShake;
    public final ForgeConfigSpec.BooleanValue custombossbar;
    public final ForgeConfigSpec.BooleanValue BossMusic;
    public final ForgeConfigSpec.IntValue BossMusicVolume;



    public ClientConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("client");
        shadersCompat = buildBoolean(builder,"shadersCompat",CMClientConfig.shadersCompat,"Off the Custom Rendering");
        ScreenShake = buildBoolean(builder,"ScreenShake(on/off)",CMClientConfig.ScreenShake,"ScreenShake(on/off)");
        firstPerson = buildBoolean(builder,"setThirdPerson(on/off)",CMClientConfig.thirdPerson,"Forced viewpoint change when hit by a grab attack");
        thirdPerson = buildBoolean(builder,"setFirstPerson(on/off)",CMClientConfig.firstPerson,"Forced viewpoint change when hit by a grab attack");
        custombossbar = buildBoolean(builder,"custombossbar(on/off)",CMClientConfig.customBossBars,"custombossbar(on/off)");
        BossMusic = buildBoolean(builder,"BossMusic(on/off)",CMClientConfig.BossMusic,"custombossbar(on/off)");
        BossMusicVolume = buildInt(builder,"BossMusicVolume",CMClientConfig.BossMusicVolume,1,100,"BossMusicVolume");
        builder.pop();
    }

    private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String trans, boolean defaultValue, String comment) {
        return builder.comment(comment).translation(LANG_PREFIX + trans).define(trans, defaultValue);
    }

    private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String trans,  int defaultValue, int min, int max, String comment) {
        return builder.comment(comment).translation(LANG_PREFIX + trans).defineInRange(trans, defaultValue, min, max);
    }

    private static ForgeConfigSpec.DoubleValue buildDouble(ForgeConfigSpec.Builder builder, String trans,  double defaultValue, double min, double max, String comment) {
        return builder.comment(comment).translation(LANG_PREFIX + trans).defineInRange(trans, defaultValue, min, max);
    }
}