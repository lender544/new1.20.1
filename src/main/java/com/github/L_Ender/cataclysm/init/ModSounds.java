package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Cataclysm.MODID);

    public static final RegistryObject<SoundEvent> GOLEMDEATH = SOUNDS.register("golemdeath",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"golemdeath")));

    public static final RegistryObject<SoundEvent> GOLEMHURT = SOUNDS.register("golemhurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"golemhurt")));

    public static final RegistryObject<SoundEvent> ENDERGUARDIANDEATH = SOUNDS.register("enderguardiandeath",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"enderguardiandeath")));

    public static final RegistryObject<SoundEvent> ENDERGUARDIANHURT = SOUNDS.register("enderguardianhurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"enderguardianhurt")));

    public static final RegistryObject<SoundEvent> GOLEMATTACK = SOUNDS.register("golemattack",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"golemattack")));

    public static final RegistryObject<SoundEvent> FLAMETHROWER = SOUNDS.register("flamethrower",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"flamethrower")));

    public static final RegistryObject<SoundEvent> HAMMERTIME = SOUNDS.register("hammertime",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"hammertime")));

    public static final RegistryObject<SoundEvent> STRONGSWING = SOUNDS.register("strongswing",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"strongswingattack")));

    public static final RegistryObject<SoundEvent> SWING = SOUNDS.register("swing",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"swingattack")));

    public static final RegistryObject<SoundEvent> MONSTROSITYSTEP = SOUNDS.register("monstrositystep",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"monstrositystep")));

    public static final RegistryObject<SoundEvent> MONSTROSITYGROWL = SOUNDS.register("monstrositygrowl",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"monstrositygrowl")));

    public static final RegistryObject<SoundEvent> MONSTROSITYDEATH = SOUNDS.register("monstrositydeath",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"monstrositydeath")));

    public static final RegistryObject<SoundEvent> MONSTROSITYAWAKEN = SOUNDS.register("monstrosityawaken",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"monstrosityawaken")));

    public static final RegistryObject<SoundEvent> MONSTROSITYHURT = SOUNDS.register("monstrosityhurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"monstrosityhurt")));

    public static final RegistryObject<SoundEvent> MONSTROSITYSHOOT = SOUNDS.register("monstrosityshoot",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"monstrosityshoot")));

    public static final RegistryObject<SoundEvent> MONSTROSITYLAND = SOUNDS.register("monstrosityland",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"monstrosityland")));

    public static final RegistryObject<SoundEvent> MONSTROSITY_MUSIC = SOUNDS.register("monstrosity_music",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"monstrosity_music")));

    public static final RegistryObject<SoundEvent> ENDERGUARDIAN_MUSIC = SOUNDS.register("enderguardian_music",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"enderguardian_music")));


    public static final RegistryObject<SoundEvent> IGNIS_MUSIC = SOUNDS.register("ignis_music",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"ignis_music")));


    public static final RegistryObject<SoundEvent> ENDERMAPTERA_HURT = SOUNDS.register("endermaptera_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"endermaptera_hurt")));

    public static final RegistryObject<SoundEvent> ENDERMAPTERA_AMBIENT = SOUNDS.register("endermaptera_ambient",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"endermaptera_ambient")));

    public static final RegistryObject<SoundEvent> ENDERMAPTERA_STEP = SOUNDS.register("endermaptera_step",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"endermaptera_step")));

    public static final RegistryObject<SoundEvent> ENDERMAPTERA_DEATH = SOUNDS.register("endermaptera_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"endermaptera_death")));

    public static final RegistryObject<SoundEvent> ENDER_GUARDIAN_FIST = SOUNDS.register("enderguardianattack",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"enderguardianattack")));

    public static final RegistryObject<SoundEvent> VOID_RUNE_RISING = SOUNDS.register("voidrunerising",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"voidrunerising")));

    public static final RegistryObject<SoundEvent> FLAME_BURST = SOUNDS.register("flame_burst",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"flame_burst")));

    public static final RegistryObject<SoundEvent> IGNIS_AMBIENT = SOUNDS.register("ignis_ambient",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"ignis_ambient")));

    public static final RegistryObject<SoundEvent> IGNIS_SHIELD_BREAK = SOUNDS.register("ignisshieldbreak",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"ignisshieldbreak")));

    public static final RegistryObject<SoundEvent> SWORD_STOMP = SOUNDS.register("sword_stomp",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"sword_stomp")));

    public static final RegistryObject<SoundEvent> IGNIS_HURT = SOUNDS.register("ignis_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"ignis_hurt")));

    public static final RegistryObject<SoundEvent> IGNIS_IMPACT = SOUNDS.register("ignis_impact",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"ignis_impact")));

    public static final RegistryObject<SoundEvent> IGNIS_ARMOR_BREAK = SOUNDS.register("ignis_armor_break",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"ignis_armor_break")));

    public static final RegistryObject<SoundEvent> IGNIS_POKE = SOUNDS.register("ignis_poke",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"ignis_poke")));

    public static final RegistryObject<SoundEvent> IGNIS_DEATH = SOUNDS.register("ignis_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"ignis_death")));

    public static final RegistryObject<SoundEvent> IGNIS_EARTHQUAKE = SOUNDS.register("ignis_earthquake",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"ignis_earthquake")));

    public static final RegistryObject<SoundEvent> REVENANT_BREATH = SOUNDS.register("revenant_breath",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"revenant_breath")));

    public static final RegistryObject<SoundEvent> REVENANT_HURT = SOUNDS.register("revenant_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"revenant_hurt")));

    public static final RegistryObject<SoundEvent> REVENANT_DEATH = SOUNDS.register("revenant_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"revenant_death")));

    public static final RegistryObject<SoundEvent> REVENANT_IDLE = SOUNDS.register("revenant_idle",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"revenant_idle")));

    public static final RegistryObject<SoundEvent> HARBINGER_LASER = SOUNDS.register("harbinger_laser",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_laser")));

    public static final RegistryObject<SoundEvent> HARBINGER_MODE_CHANGE = SOUNDS.register("harbinger_mode_change",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_mode_change")));

    public static final RegistryObject<SoundEvent> HARBINGER_PREPARE = SOUNDS.register("harbinger_prepare",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_prepare")));

    public static final RegistryObject<SoundEvent> HARBINGER_STUN = SOUNDS.register("harbinger_stun",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_stun")));

    public static final RegistryObject<SoundEvent> EMP_ACTIVATED = SOUNDS.register("emp_activated",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"emp_activated")));

    public static final RegistryObject<SoundEvent> DEATH_LASER = SOUNDS.register("death_laser",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"death_laser")));

    public static final RegistryObject<SoundEvent> HARBINGER_CHARGE_PREPARE = SOUNDS.register("harbinger_charge_prepare",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_charge_prepare")));

    public static final RegistryObject<SoundEvent> HARBINGER_CHARGE = SOUNDS.register("harbinger_charge",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_charge")));

    public static final RegistryObject<SoundEvent> HARBINGER_DEATHLASER_PREPARE = SOUNDS.register("harbinger_deathlaser_prepare",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_deathlaser_prepare")));

    public static final RegistryObject<SoundEvent> HARBINGER_MUSIC = SOUNDS.register("harbinger_music",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_music")));


    public static final RegistryObject<SoundEvent> HARBINGER_HURT = SOUNDS.register("harbinger_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_hurt")));

    public static final RegistryObject<SoundEvent> HARBINGER_IDLE = SOUNDS.register("harbinger_idle",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"harbinger_idle")));

    public static final RegistryObject<SoundEvent> ABYSS_BLAST = SOUNDS.register("abyss_blast",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"abyss_blast")));

    public static final RegistryObject<SoundEvent> ABYSS_BLAST_ONLY_CHARGE = SOUNDS.register("abyss_blast_only_charge",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"abyss_blast_only_charge")));

    public static final RegistryObject<SoundEvent> ABYSS_BLAST_ONLY_SHOOT = SOUNDS.register("abyss_blast_only_shoot",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"abyss_blast_only_shoot")));

    public static final RegistryObject<SoundEvent> LEVIATHAN_DEFEAT = SOUNDS.register("leviathan_defeat",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"leviathan_defeat")));

    public static final RegistryObject<SoundEvent> LEVIATHAN_HURT = SOUNDS.register("leviathan_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"leviathan_hurt")));

    public static final RegistryObject<SoundEvent> LEVIATHAN_IDLE = SOUNDS.register("leviathan_idle",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"leviathan_idle")));

    public static final RegistryObject<SoundEvent> LEVIATHAN_ROAR = SOUNDS.register("leviathan_roar",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"leviathan_roar")));

    public static final RegistryObject<SoundEvent> LEVIATHAN_STUN_ROAR = SOUNDS.register("leviathan_stun_roar",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"leviathan_stun_roar")));

    public static final RegistryObject<SoundEvent> LEVIATHAN_BITE = SOUNDS.register("leviathan_bite",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"leviathan_bite")));

    public static final RegistryObject<SoundEvent> LEVIATHAN_TENTACLE_STRIKE = SOUNDS.register("leviathan_tentacle_strike",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"leviathan_tentacle_strike")));

    public static final RegistryObject<SoundEvent> PORTAL_ABYSS_BLAST = SOUNDS.register("portal_abyss_blast",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"portal_abyss_blast")));

    public static final RegistryObject<SoundEvent> DEEPLING_IDLE = SOUNDS.register("deepling_idle",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"deepling_idle")));

    public static final RegistryObject<SoundEvent> DEEPLING_HURT = SOUNDS.register("deepling_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"deepling_hurt")));

    public static final RegistryObject<SoundEvent> DEEPLING_DEATH = SOUNDS.register("deepling_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"deepling_death")));

    public static final RegistryObject<SoundEvent> DEEPLING_SWING = SOUNDS.register("deepling_swing",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"deepling_swing")));

    public static final RegistryObject<SoundEvent> DEEPLING_LIGHT = SOUNDS.register("deepling_light",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"deepling_light")));

    public static final RegistryObject<SoundEvent> BLACK_HOLE_OPENING = SOUNDS.register("black_hole_opening",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"black_hole_opening")));

    public static final RegistryObject<SoundEvent> BLACK_HOLE_CLOSING = SOUNDS.register("black_hole_closing",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"black_hole_closing")));

    public static final RegistryObject<SoundEvent> BLACK_HOLE_LOOP = SOUNDS.register("black_hole_loop",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"black_hole_loop")));

    public static final RegistryObject<SoundEvent> LEVIATHAN_MUSIC = SOUNDS.register("leviathan_music",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"leviathan_music")));

    public static final RegistryObject<SoundEvent> TIDAL_TENTACLE = SOUNDS.register("tidal_tentacle",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"tidal_tentacle")));

    public static final RegistryObject<SoundEvent> TIDAL_HOOK_HIT = SOUNDS.register("tidal_hook_hit",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"tidal_hook_hit")));

    public static final RegistryObject<SoundEvent> TIDAL_HOOK_LOOP = SOUNDS.register("tidal_hook_loop",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"tidal_hook_loop")));

    public static final RegistryObject<SoundEvent> CORALSSUS_HURT = SOUNDS.register("coralssus_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"coralssus_hurt")));

    public static final RegistryObject<SoundEvent> CORALSSUS_DEATH = SOUNDS.register("coralssus_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"coralssus_death")));

    public static final RegistryObject<SoundEvent> CRAB_DEATH = SOUNDS.register("crab_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"crab_death")));

    public static final RegistryObject<SoundEvent> CRAB_HURT = SOUNDS.register("crab_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"crab_hurt")));

    public static final RegistryObject<SoundEvent> CRAB_BITE = SOUNDS.register("crab_bite",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"crab_bite")));

    public static final RegistryObject<SoundEvent> REMNANT_BITE = SOUNDS.register("remnant_bite",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_bite")));

    public static final RegistryObject<SoundEvent> REMNANT_BREATHING = SOUNDS.register("remnant_breathing",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_breathing")));

    public static final RegistryObject<SoundEvent> REMNANT_CHARGE_PREPARE = SOUNDS.register("remnant_charge_prepare",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_charge_prepare")));

    public static final RegistryObject<SoundEvent> REMNANT_CHARGE_ROAR = SOUNDS.register("remnant_charge_roar",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_charge_roar")));

    public static final RegistryObject<SoundEvent> REMNANT_CHARGE_STEP = SOUNDS.register("remnant_charge_step",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_charge_step")));

    public static final RegistryObject<SoundEvent> REMNANT_STOMP = SOUNDS.register("remnant_stomp",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_stomp")));

    public static final RegistryObject<SoundEvent> REMNANT_HURT = SOUNDS.register("remnant_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_hurt")));

    public static final RegistryObject<SoundEvent> REMNANT_DEATH = SOUNDS.register("remnant_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_death")));

    public static final RegistryObject<SoundEvent> REMNANT_IDLE = SOUNDS.register("remnant_idle",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_idle")));

    public static final RegistryObject<SoundEvent> REMNANT_ROAR = SOUNDS.register("remnant_roar",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_roar")));

    public static final RegistryObject<SoundEvent> REMNANT_SHOCKWAVE = SOUNDS.register("remnant_shockwave",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_shockwave")));

    public static final RegistryObject<SoundEvent> REMNANT_TAIL_SLAM = SOUNDS.register("remnant_tail_slam",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_tail_slam")));

    public static final RegistryObject<SoundEvent> REMNANT_TAIL_SWING = SOUNDS.register("remnant_tail_swing",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_tail_swing")));

    public static final RegistryObject<SoundEvent> MODERN_REMNANT_BITE = SOUNDS.register("modern_remnant_bite",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"modern_remnant_bite")));

    public static final RegistryObject<SoundEvent> MODERN_REMNANT_DEATH = SOUNDS.register("modern_remnant_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"modern_remnant_death")));

    public static final RegistryObject<SoundEvent> SANDSTORM = SOUNDS.register("sandstorm",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"sandstorm")));

    public static final RegistryObject<SoundEvent> REMNANT_MUSIC = SOUNDS.register("remnant_music",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"remnant_music")));

    public static final RegistryObject<SoundEvent> WATCHER_HURT = SOUNDS.register("watcher_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"watcher_hurt")));

    public static final RegistryObject<SoundEvent> WATCHER_DEATH = SOUNDS.register("watcher_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"watcher_death")));

    public static final RegistryObject<SoundEvent> PROWLER_HURT = SOUNDS.register("prowler_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"prowler_hurt")));

    public static final RegistryObject<SoundEvent> PROWLER_DEATH = SOUNDS.register("prowler_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"prowler_death")));

    public static final RegistryObject<SoundEvent> PROWLER_IDLE = SOUNDS.register("prowler_idle",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"prowler_idle")));

    public static final RegistryObject<SoundEvent> KOBOLETON_AMBIENT = SOUNDS.register("koboleton_ambient",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"koboleton_ambient")));

    public static final RegistryObject<SoundEvent> KOBOLETON_HURT = SOUNDS.register("koboleton_hurt",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"koboleton_hurt")));

    public static final RegistryObject<SoundEvent> KOBOLETON_DEATH = SOUNDS.register("koboleton_death",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"koboleton_death")));

    public static final RegistryObject<SoundEvent> KOBOLETON_STEP = SOUNDS.register("koboleton_step",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"koboleton_step")));

    public static final RegistryObject<SoundEvent> FLAME_TRAP = SOUNDS.register("flame_trap",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"flame_trap")));

    public static final RegistryObject<SoundEvent> SHREDDER_START = SOUNDS.register("shredder_start",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"shredder_start")));

    public static final RegistryObject<SoundEvent> SHREDDER_LOOP = SOUNDS.register("shredder_loop",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"shredder_loop")));

    public static final RegistryObject<SoundEvent> SHREDDER_END = SOUNDS.register("shredder_end",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"shredder_end")));

    public static final RegistryObject<SoundEvent> ROCKET_LAUNCH = SOUNDS.register("rocket_launch",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"rocket_launch")));

    public static final RegistryObject<SoundEvent> PROWLER_SAW_ATTACK = SOUNDS.register("prowler_saw_attack",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"prowler_saw_attack")));

    public static final RegistryObject<SoundEvent> PROWLER_SAW_SPIN_ATTACK = SOUNDS.register("prowler_saw_spin_attack",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Cataclysm.MODID,"prowler_saw_spin_attack")));
}
