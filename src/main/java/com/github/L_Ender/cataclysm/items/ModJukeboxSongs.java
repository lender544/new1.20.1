package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModSounds;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;

public interface ModJukeboxSongs {
    ResourceKey<JukeboxSong> IGNIS_THEME = registerKey("ignis_theme");
    ResourceKey<JukeboxSong> ENDERGUARDIAN_THEME = registerKey("enderguardian_theme");
    ResourceKey<JukeboxSong> HARBINGER_THEME = registerKey("harbinger_theme");
    ResourceKey<JukeboxSong> MONSTROSITY_THEME = registerKey("monstrosity_theme");
    ResourceKey<JukeboxSong> REMNANT_THEME = registerKey("remnant_theme");
    ResourceKey<JukeboxSong> LEVIATHAN_THEME = registerKey("leviathan_theme");
    ResourceKey<JukeboxSong> MALEDICTUS_THEME = registerKey("maledictus_theme");
    ResourceKey<JukeboxSong> SCYLLA_THEME = registerKey("scylla_theme");
    ResourceKey<JukeboxSong> THE_CATACLYSM_FARER = registerKey("the_cataclysmfarer");

    private static ResourceKey<JukeboxSong> registerKey(String p_350505_) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,p_350505_));
    }


    public static void bootstrap(BootstrapContext<JukeboxSong> p_350269_) {
        register(p_350269_, IGNIS_THEME,  ModSounds.IGNIS_MUSIC_DISC, 153, 15);
        register(p_350269_, ENDERGUARDIAN_THEME,  ModSounds.ENDERGUARDIAN_MUSIC_DISC, 196, 15);
        register(p_350269_, HARBINGER_THEME,  ModSounds.HARBINGER_MUSIC, 189, 15);
        register(p_350269_, MONSTROSITY_THEME,  ModSounds.MONSTROSITY_MUSIC, 289, 15);
        register(p_350269_, REMNANT_THEME,  ModSounds.REMNANT_MUSIC, 212, 15);
        register(p_350269_, LEVIATHAN_THEME,  ModSounds.LEVIATHAN_MUSIC, 291, 15);
        register(p_350269_, MALEDICTUS_THEME,  ModSounds.MALEDICTUS_MUSIC_DISC, 201, 15);

    }
    private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, Holder<SoundEvent> sound, float length, int output) {
        context.register(key, new JukeboxSong(sound, Component.translatable(Util.makeDescriptionId("jukebox_song", key.location())), length, output));
    }

}
