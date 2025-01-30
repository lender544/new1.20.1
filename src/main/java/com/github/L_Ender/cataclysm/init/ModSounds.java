package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, Cataclysm.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> GOLEMDEATH = SOUNDS.register("golemdeath",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"golemdeath")));

    public static final DeferredHolder<SoundEvent, SoundEvent> GOLEMHURT = SOUNDS.register("golemhurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"golemhurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERGUARDIANDEATH = SOUNDS.register("enderguardiandeath",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"enderguardiandeath")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERGUARDIANHURT = SOUNDS.register("enderguardianhurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"enderguardianhurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> GOLEMATTACK = SOUNDS.register("golemattack",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"golemattack")));

    public static final DeferredHolder<SoundEvent, SoundEvent> FLAMETHROWER = SOUNDS.register("flamethrower",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"flamethrower")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HAMMERTIME = SOUNDS.register("hammertime",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"hammertime")));

    public static final DeferredHolder<SoundEvent, SoundEvent> STRONGSWING = SOUNDS.register("strongswing",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"strongswingattack")));

    public static final DeferredHolder<SoundEvent, SoundEvent> SWING = SOUNDS.register("swing",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"swingattack")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MONSTROSITYSTEP = SOUNDS.register("monstrositystep",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrositystep")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MONSTROSITYGROWL = SOUNDS.register("monstrositygrowl",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrositygrowl")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MONSTROSITYDEATH = SOUNDS.register("monstrositydeath",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrositydeath")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MONSTROSITYAWAKEN = SOUNDS.register("monstrosityawaken",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrosityawaken")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MONSTROSITYHURT = SOUNDS.register("monstrosityhurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrosityhurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MONSTROSITYSHOOT = SOUNDS.register("monstrosityshoot",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrosityshoot")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MONSTROSITYLAND = SOUNDS.register("monstrosityland",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrosityland")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MINISTROSITY_HURT = SOUNDS.register("ministrosity_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ministrosity_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MINISTROSITY_FILL_BUCKET = SOUNDS.register("ministrosity_fill_bucket",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ministrosity_fill_bucket")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MONSTROSITY_MUSIC = SOUNDS.register("monstrosity_music",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"monstrosity_music")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERGUARDIAN_MUSIC = SOUNDS.register("enderguardian_music",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"enderguardian_music")));


    public static final DeferredHolder<SoundEvent, SoundEvent> IGNIS_MUSIC = SOUNDS.register("ignis_music",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignis_music")));


    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAPTERA_HURT = SOUNDS.register("endermaptera_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"endermaptera_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAPTERA_AMBIENT = SOUNDS.register("endermaptera_ambient",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"endermaptera_ambient")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAPTERA_STEP = SOUNDS.register("endermaptera_step",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"endermaptera_step")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ENDERMAPTERA_DEATH = SOUNDS.register("endermaptera_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"endermaptera_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ENDER_GUARDIAN_FIST = SOUNDS.register("enderguardianattack",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"enderguardianattack")));

    public static final DeferredHolder<SoundEvent, SoundEvent> VOID_RUNE_RISING = SOUNDS.register("voidrunerising",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"voidrunerising")));

    public static final DeferredHolder<SoundEvent, SoundEvent> FLAME_BURST = SOUNDS.register("flame_burst",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"flame_burst")));

    public static final DeferredHolder<SoundEvent, SoundEvent> IGNIS_AMBIENT = SOUNDS.register("ignis_ambient",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignis_ambient")));

    public static final DeferredHolder<SoundEvent, SoundEvent> IGNIS_SHIELD_BREAK = SOUNDS.register("ignisshieldbreak",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignisshieldbreak")));

    public static final DeferredHolder<SoundEvent, SoundEvent> SWORD_STOMP = SOUNDS.register("sword_stomp",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"sword_stomp")));

    public static final DeferredHolder<SoundEvent, SoundEvent> IGNIS_HURT = SOUNDS.register("ignis_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignis_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> IGNIS_IMPACT = SOUNDS.register("ignis_impact",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignis_impact")));

    public static final DeferredHolder<SoundEvent, SoundEvent> IGNIS_ARMOR_BREAK = SOUNDS.register("ignis_armor_break",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignis_armor_break")));

    public static final DeferredHolder<SoundEvent, SoundEvent> IGNIS_POKE = SOUNDS.register("ignis_poke",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignis_poke")));

    public static final DeferredHolder<SoundEvent, SoundEvent> IGNIS_DEATH = SOUNDS.register("ignis_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignis_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> IGNIS_EARTHQUAKE = SOUNDS.register("ignis_earthquake",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"ignis_earthquake")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REVENANT_BREATH = SOUNDS.register("revenant_breath",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"revenant_breath")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REVENANT_HURT = SOUNDS.register("revenant_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"revenant_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REVENANT_DEATH = SOUNDS.register("revenant_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"revenant_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REVENANT_IDLE = SOUNDS.register("revenant_idle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"revenant_idle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_LASER = SOUNDS.register("harbinger_laser",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_laser")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_MODE_CHANGE = SOUNDS.register("harbinger_mode_change",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_mode_change")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_PREPARE = SOUNDS.register("harbinger_prepare",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_prepare")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_STUN = SOUNDS.register("harbinger_stun",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_stun")));

    public static final DeferredHolder<SoundEvent, SoundEvent> EMP_ACTIVATED = SOUNDS.register("emp_activated",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"emp_activated")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DEATH_LASER = SOUNDS.register("death_laser",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"death_laser")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_CHARGE_PREPARE = SOUNDS.register("harbinger_charge_prepare",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_charge_prepare")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_CHARGE = SOUNDS.register("harbinger_charge",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_charge")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_DEATHLASER_PREPARE = SOUNDS.register("harbinger_deathlaser_prepare",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_deathlaser_prepare")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_MUSIC = SOUNDS.register("harbinger_music",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_music")));


    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_HURT = SOUNDS.register("harbinger_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> HARBINGER_IDLE = SOUNDS.register("harbinger_idle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"harbinger_idle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ABYSS_BLAST = SOUNDS.register("abyss_blast",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"abyss_blast")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ABYSS_BLAST_ONLY_CHARGE = SOUNDS.register("abyss_blast_only_charge",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"abyss_blast_only_charge")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ABYSS_BLAST_ONLY_SHOOT = SOUNDS.register("abyss_blast_only_shoot",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"abyss_blast_only_shoot")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_DEFEAT = SOUNDS.register("leviathan_defeat",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_defeat")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_HURT = SOUNDS.register("leviathan_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_IDLE = SOUNDS.register("leviathan_idle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_idle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_ROAR = SOUNDS.register("leviathan_roar",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_roar")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_STUN_ROAR = SOUNDS.register("leviathan_stun_roar",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_stun_roar")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_BITE = SOUNDS.register("leviathan_bite",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_bite")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_TENTACLE_STRIKE = SOUNDS.register("leviathan_tentacle_strike",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_tentacle_strike")));

    public static final DeferredHolder<SoundEvent, SoundEvent> PORTAL_ABYSS_BLAST = SOUNDS.register("portal_abyss_blast",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"portal_abyss_blast")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DEEPLING_IDLE = SOUNDS.register("deepling_idle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"deepling_idle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DEEPLING_HURT = SOUNDS.register("deepling_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"deepling_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DEEPLING_DEATH = SOUNDS.register("deepling_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"deepling_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DEEPLING_SWING = SOUNDS.register("deepling_swing",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"deepling_swing")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DEEPLING_LIGHT = SOUNDS.register("deepling_light",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"deepling_light")));

    public static final DeferredHolder<SoundEvent, SoundEvent> BLACK_HOLE_OPENING = SOUNDS.register("black_hole_opening",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"black_hole_opening")));

    public static final DeferredHolder<SoundEvent, SoundEvent> BLACK_HOLE_CLOSING = SOUNDS.register("black_hole_closing",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"black_hole_closing")));

    public static final DeferredHolder<SoundEvent, SoundEvent> BLACK_HOLE_LOOP = SOUNDS.register("black_hole_loop",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"black_hole_loop")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_MUSIC = SOUNDS.register("leviathan_music",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_music")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_MUSIC_1 = SOUNDS.register("leviathan_music_1",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_music_1")));

    public static final DeferredHolder<SoundEvent, SoundEvent> LEVIATHAN_MUSIC_2 = SOUNDS.register("leviathan_music_2",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"leviathan_music_2")));

    public static final DeferredHolder<SoundEvent, SoundEvent> TIDAL_TENTACLE = SOUNDS.register("tidal_tentacle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"tidal_tentacle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> TIDAL_HOOK_HIT = SOUNDS.register("tidal_hook_hit",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"tidal_hook_hit")));

    public static final DeferredHolder<SoundEvent, SoundEvent> TIDAL_HOOK_LOOP = SOUNDS.register("tidal_hook_loop",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"tidal_hook_loop")));

    public static final DeferredHolder<SoundEvent, SoundEvent> CORAL_GOLEM_HURT = SOUNDS.register("coral_golem_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"coral_golem_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> CORAL_GOLEM_DEATH = SOUNDS.register("coral_golem_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"coral_golem_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> CRAB_DEATH = SOUNDS.register("crab_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"crab_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> CRAB_HURT = SOUNDS.register("crab_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"crab_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> CRAB_BITE = SOUNDS.register("crab_bite",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"crab_bite")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_BITE = SOUNDS.register("remnant_bite",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_bite")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_BREATHING = SOUNDS.register("remnant_breathing",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_breathing")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_CHARGE_PREPARE = SOUNDS.register("remnant_charge_prepare",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_charge_prepare")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_CHARGE_ROAR = SOUNDS.register("remnant_charge_roar",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_charge_roar")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_CHARGE_STEP = SOUNDS.register("remnant_charge_step",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_charge_step")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_STOMP = SOUNDS.register("remnant_stomp",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_stomp")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_HURT = SOUNDS.register("remnant_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_DEATH = SOUNDS.register("remnant_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_IDLE = SOUNDS.register("remnant_idle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_idle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_ROAR = SOUNDS.register("remnant_roar",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_roar")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_SHOCKWAVE = SOUNDS.register("remnant_shockwave",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_shockwave")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_TAIL_SLAM = SOUNDS.register("remnant_tail_slam",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_tail_slam")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_TAIL_SLAM_1 = SOUNDS.register("remnant_tail_slam_1",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_tail_slam_1")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_TAIL_SLAM_2 = SOUNDS.register("remnant_tail_slam_2",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_tail_slam_2")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_TAIL_SLAM_3 = SOUNDS.register("remnant_tail_slam_3",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_tail_slam_3")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_TAIL_SWING = SOUNDS.register("remnant_tail_swing",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_tail_swing")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MODERN_REMNANT_BITE = SOUNDS.register("modern_remnant_bite",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"modern_remnant_bite")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MODERN_REMNANT_DEATH = SOUNDS.register("modern_remnant_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"modern_remnant_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MODERN_REMNANT_FILL_BUCKET = SOUNDS.register("modern_remnant_fill_bucket",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"modern_remnant_fill_bucket")));

    public static final DeferredHolder<SoundEvent, SoundEvent> SANDSTORM = SOUNDS.register("sandstorm",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"sandstorm")));

    public static final DeferredHolder<SoundEvent, SoundEvent> REMNANT_MUSIC = SOUNDS.register("remnant_music",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"remnant_music")));

    public static final DeferredHolder<SoundEvent, SoundEvent> WATCHER_HURT = SOUNDS.register("watcher_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"watcher_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> WATCHER_DEATH = SOUNDS.register("watcher_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"watcher_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> PROWLER_HURT = SOUNDS.register("prowler_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"prowler_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> PROWLER_DEATH = SOUNDS.register("prowler_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"prowler_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> PROWLER_IDLE = SOUNDS.register("prowler_idle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"prowler_idle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> KOBOLETON_AMBIENT = SOUNDS.register("koboleton_ambient",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"koboleton_ambient")));

    public static final DeferredHolder<SoundEvent, SoundEvent> KOBOLETON_HURT = SOUNDS.register("koboleton_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"koboleton_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> KOBOLETON_DEATH = SOUNDS.register("koboleton_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"koboleton_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> KOBOLETON_STEP = SOUNDS.register("koboleton_step",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"koboleton_step")));

    public static final DeferredHolder<SoundEvent, SoundEvent> FLAME_TRAP = SOUNDS.register("flame_trap",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"flame_trap")));

    public static final DeferredHolder<SoundEvent, SoundEvent> SHREDDER_START = SOUNDS.register("shredder_start",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"shredder_start")));

    public static final DeferredHolder<SoundEvent, SoundEvent> SHREDDER_LOOP = SOUNDS.register("shredder_loop",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"shredder_loop")));

    public static final DeferredHolder<SoundEvent, SoundEvent> SHREDDER_END = SOUNDS.register("shredder_end",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"shredder_end")));

    public static final DeferredHolder<SoundEvent, SoundEvent> ROCKET_LAUNCH = SOUNDS.register("rocket_launch",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"rocket_launch")));

    public static final DeferredHolder<SoundEvent, SoundEvent> PROWLER_SAW_ATTACK = SOUNDS.register("prowler_saw_attack",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"prowler_saw_attack")));

    public static final DeferredHolder<SoundEvent, SoundEvent> PROWLER_SAW_SPIN_ATTACK = SOUNDS.register("prowler_saw_spin_attack",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"prowler_saw_spin_attack")));

    public static final DeferredHolder<SoundEvent, SoundEvent> CORALSSUS_AMBIENT = SOUNDS.register("coralssus_ambient",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"coralssus_ambient")));

    public static final DeferredHolder<SoundEvent, SoundEvent> CORALSSUS_HURT = SOUNDS.register("coralssus_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"coralssus_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> CORALSSUS_DEATH = SOUNDS.register("coralssus_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"coralssus_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> CORALSSUS_ROAR = SOUNDS.register("coralssus_roar",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"coralssus_roar")));


    public static final DeferredHolder<SoundEvent, SoundEvent> WADJET_AMBIENT = SOUNDS.register("wadjet_ambient",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"wadjet_ambient")));

    public static final DeferredHolder<SoundEvent, SoundEvent> WADJET_HURT = SOUNDS.register("wadjet_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"wadjet_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> WADJET_DEATH = SOUNDS.register("wadjet_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"wadjet_death")));


    public static final DeferredHolder<SoundEvent, SoundEvent> KOBOLEDIATOR_AMBIENT = SOUNDS.register("kobolediator_ambient",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"kobolediator_ambient")));

    public static final DeferredHolder<SoundEvent, SoundEvent> KOBOLEDIATOR_HURT = SOUNDS.register("kobolediator_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"kobolediator_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> KOBOLEDIATOR_DEATH = SOUNDS.register("kobolediator_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"kobolediator_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_BATTLE_CRY = SOUNDS.register("maledictus_battle_cry",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_battle_cry")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_HURT = SOUNDS.register("maledictus_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_LEAP = SOUNDS.register("maledictus_leap",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_leap")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_MACE_SWING = SOUNDS.register("maledictus_mace_swing",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_mace_swing")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_BOW_PULL = SOUNDS.register("maledictus_bow_pull",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_bow_pull")));


    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_IDLE = SOUNDS.register("maledictus_idle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_idle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_JUMP = SOUNDS.register("maledictus_jump",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_jump")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_SHORT_ROAR = SOUNDS.register("maledictus_short_roar",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_short_roar")));

    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_DEATH = SOUNDS.register("maledictus_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_death")));


    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_MUSIC = SOUNDS.register("maledictus_music",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_music")));


    public static final DeferredHolder<SoundEvent, SoundEvent> MALEDICTUS_MUSIC_DISC = SOUNDS.register("maledictus_music_disc",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_music_disc")));

    public static final DeferredHolder<SoundEvent, SoundEvent> PHANTOM_SPEAR = SOUNDS.register("maledictus_spear",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictus_spear")));

    public static final DeferredHolder<SoundEvent, SoundEvent> AXE_SWING = SOUNDS.register("axe_swing",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"axe_swing")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DRAUGR_IDLE = SOUNDS.register("draugr_idle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"draugr_idle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DRAUGR_HURT = SOUNDS.register("draugr_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"draugr_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DRAUGR_DEATH = SOUNDS.register("draugr_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"draugr_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> APTRGANGR_IDLE = SOUNDS.register("aptrgangr_idle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"aptrgangr_idle")));

    public static final DeferredHolder<SoundEvent, SoundEvent> APTRGANGR_HURT = SOUNDS.register("aptrgangr_hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"aptrgangr_hurt")));

    public static final DeferredHolder<SoundEvent, SoundEvent> APTRGANGR_DEATH = SOUNDS.register("aptrgangr_death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"aptrgangr_death")));

    public static final DeferredHolder<SoundEvent, SoundEvent> DOOR_OF_SEAL_OPEN = SOUNDS.register("door_of_seal_open",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"door_of_seal_open")));

    public static final DeferredHolder<SoundEvent, SoundEvent> EXPLOSION = SOUNDS.register("explosion",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"explosion")));

    public static final DeferredHolder<SoundEvent, SoundEvent> PARRY = SOUNDS.register("parry",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"parry")));
}
