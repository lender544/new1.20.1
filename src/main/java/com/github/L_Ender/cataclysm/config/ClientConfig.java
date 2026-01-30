package com.github.L_Ender.cataclysm.config;


import com.github.L_Ender.cataclysm.Cataclysm;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ClientConfig {

    private static final String LANG_PREFIX = "config." + Cataclysm.MODID + ".";

    public final ModConfigSpec.BooleanValue shadersCompat;
    public final ModConfigSpec.BooleanValue firstPerson;
    public final ModConfigSpec.BooleanValue thirdPerson;
    public final ModConfigSpec.BooleanValue ScreenShake;
    public final ModConfigSpec.BooleanValue custombossbar;
    public final ModConfigSpec.BooleanValue BossMusic;
    public final ModConfigSpec.IntValue BossMusicVolume;



    public ClientConfig(final ModConfigSpec.Builder builder) {
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

    private static ModConfigSpec.BooleanValue buildBoolean(ModConfigSpec.Builder builder, String trans, boolean defaultValue, String comment) {
        return builder.comment(comment).translation(LANG_PREFIX + trans).define(trans, defaultValue);
    }

    private static ModConfigSpec.IntValue buildInt(ModConfigSpec.Builder builder, String trans,  int defaultValue, int min, int max, String comment) {
        return builder.comment(comment).translation(LANG_PREFIX + trans).defineInRange(trans, defaultValue, min, max);
    }

    private static ModConfigSpec.DoubleValue buildDouble(ModConfigSpec.Builder builder, String trans,  double defaultValue, double min, double max, String comment) {
        return builder.comment(comment).translation(LANG_PREFIX + trans).defineInRange(trans, defaultValue, min, max);
    }
}