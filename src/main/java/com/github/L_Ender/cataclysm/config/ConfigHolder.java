package com.github.L_Ender.cataclysm.config;

import net.minecraftforge.common.ForgeConfigSpec;


import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

public final class ConfigHolder {

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final ClientConfig CLIENT;

    static {
        {
            final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
            COMMON = specPair.getLeft();
            COMMON_SPEC = specPair.getRight();

            final Pair<ClientConfig, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
            CLIENT = clientSpecPair.getLeft();
            CLIENT_SPEC = clientSpecPair.getRight();
        }
    }

    public static void onModConfigLoadingEvent(ModConfigEvent.Loading event) {
        // Rebake the configs when they change
        if (event.getConfig().getSpec() == ConfigHolder.CLIENT_SPEC) {
            CMClientConfig.Clientbake(CLIENT);
        }

        if (event.getConfig().getSpec() == ConfigHolder.COMMON_SPEC) {
            CMCommonConfig.Commonbake(COMMON);
        }

    }

    public static void onModConfigReloadEvent(ModConfigEvent.Reloading event) {

        if (event.getConfig().getSpec() == ConfigHolder.CLIENT_SPEC) {
            CMClientConfig.Clientbake(CLIENT);
        }
        if (event.getConfig().getSpec() == ConfigHolder.COMMON_SPEC) {
            CMCommonConfig.Commonbake(COMMON);
        }
    }

}