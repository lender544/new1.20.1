package com.github.L_Ender.cataclysm.config;


import com.github.L_Ender.cataclysm.Cataclysm;
import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfig {

    private static final String LANG_PREFIX = "config." + Cataclysm.MODID + ".";

    public final ToolsAndAbilities TOOLS_AND_ABILITIES;
    public final Mobs MOBS;
    public final Blocks BLOCKS;
    public final Spawning SPAWNING;

    public CommonConfig(final ModConfigSpec.Builder builder) {
        TOOLS_AND_ABILITIES = new ToolsAndAbilities(builder);
        MOBS = new Mobs(builder);
        BLOCKS = new Blocks(builder);
        SPAWNING = new Spawning(builder);
    }

    // ==========================================
    // Utility & Shared Config Classes
    // ==========================================

    public static class CombatConfig {
        CombatConfig(final ModConfigSpec.Builder builder, double healthMultiplier, double attackMultiplier) {
            builder.push("combat_config");
            this.healthMultiplier = builder.comment("Scale mob health by this value")
                    .translation(LANG_PREFIX + "health_multiplier")
                    .defineInRange("health_multiplier", healthMultiplier, 0.1D, 1000000.0D);
            this.attackMultiplier = builder.comment("Scale mob attack damage by this value")
                    .translation(LANG_PREFIX + "attack_multiplier")
                    .defineInRange("attack_multiplier", attackMultiplier, 0.1D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.DoubleValue healthMultiplier;
        public final ModConfigSpec.DoubleValue attackMultiplier;
    }

    public static class IgnoreMobGriefing {
        IgnoreMobGriefing(final ModConfigSpec.Builder builder, boolean ignore) {
            builder.push("ignore_mobgriefing_config");
            Ignore = builder.comment("Ignore MobGriefing")
                    .translation(LANG_PREFIX + "ignore_mobgriefing")
                    .define("ignore_mobgriefing", ignore);
            builder.pop();
        }
        public final ModConfigSpec.BooleanValue Ignore;
    }

    public static class CapConfig {
        CapConfig(final ModConfigSpec.Builder builder, double DamageCap, double DpsCap, int dpslimittime, double RangeCap) {
            builder.push("cap_config");
            this.damageCap = builder.comment("Damage Cap")
                    .translation(LANG_PREFIX + "damage_cap")
                    .defineInRange("damage_cap", DamageCap, 0.0D, 1000000.0D);
            this.dpsCap = builder.comment("Dps Cap")
                    .translation(LANG_PREFIX + "dps_cap")
                    .defineInRange("dps_cap", DpsCap, 1.0D, 1000000.0D);
            this.dpslimittime = builder.comment("DPS Limit Time")
                    .translation(LANG_PREFIX + "dps_limit_time")
                    .defineInRange("dps_limit_time", dpslimittime, 1, 100);
            this.rangeCap = builder.comment("Range Cap")
                    .translation(LANG_PREFIX + "range_cap")
                    .defineInRange("range_cap", RangeCap, 1.0D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.DoubleValue damageCap;
        public final ModConfigSpec.DoubleValue dpsCap;
        public final ModConfigSpec.IntValue dpslimittime;
        public final ModConfigSpec.DoubleValue rangeCap;
    }

    public static class NatureHealConfig {
        NatureHealConfig(final ModConfigSpec.Builder builder, double Heal) {
            builder.push("nature_heal_config");
            this.heal = builder.comment("Nature Heal")
                    .translation(LANG_PREFIX + "nature_heal")
                    .defineInRange("nature_heal", Heal, 0.0D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.DoubleValue heal;
    }

    public static class ToolConfig {
        ToolConfig(final ModConfigSpec.Builder builder, double attackDamage, double attackSpeed) {
            builder.push("tool_config");
            this.attackDamage = builder.comment("Tool attack damage")
                    .translation(LANG_PREFIX + "attack_damage")
                    .defineInRange("attack_damage", attackDamage, 0.0D, 1000000.0D);
            this.attackSpeed = builder.comment("Tool attack speed")
                    .translation(LANG_PREFIX + "attack_speed")
                    .defineInRange("attack_speed", attackSpeed, 0.0D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.DoubleValue attackDamage;
        public final ModConfigSpec.DoubleValue attackSpeed;

        public float attackDamageValue = 9;
        public float attackSpeedValue = 0.9F;
    }

    public static class ArmorConfig {
        ArmorConfig(final ModConfigSpec.Builder builder, double armorMulti, double toughness, double knockbackResistanceValue) {
            builder.push("armor_config");
            this.armormultiplier = builder.comment("Armor_Multiplier")
                    .translation(LANG_PREFIX + "armor_multiplier")
                    .defineInRange("armor_multiplier", armorMulti, 0.0D, 1000000.0D);
            this.toughness = builder.comment("Toughness")
                    .translation(LANG_PREFIX + "toughness")
                    .defineInRange("toughness", toughness, 0.0D, 1000000.0D);
            this.knockbackRes = builder.comment("Knockback Resistance")
                    .translation(LANG_PREFIX + "knockback_resistance")
                    .defineInRange("knockback_resistance", knockbackResistanceValue, 0.0D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.DoubleValue armormultiplier;
        public final ModConfigSpec.DoubleValue toughness;
        public final ModConfigSpec.DoubleValue knockbackRes;

        public float ArmorMultiplierValue = 1.0F;
        public float toughnessValue = 1.0f;
        public float KnockbackResistanceValue = 0.01f;
    }

    public static class RespawnerConfig {
        RespawnerConfig(final ModConfigSpec.Builder builder, boolean spawner) {
            builder.push("respawner_config");
            this.Respawner = builder.comment("Respawner")
                    .translation(LANG_PREFIX + "respawner")
                    .define("respawner", spawner);
            builder.pop();
        }
        public final ModConfigSpec.BooleanValue Respawner;
    }

    // ==========================================
    // Block Configs
    // ==========================================

    public static class CursedTombstone {
        CursedTombstone(final ModConfigSpec.Builder builder) {
            builder.push("cursed_tombstone");
            CursedTombstoneCooldown = builder.comment("Cursed Tombstone Cooldown")
                    .translation(LANG_PREFIX + "cursed_tombstone_cooldown")
                    .defineInRange("cursed_tombstone_cooldown",  1, 0, 30);
            builder.pop();
        }
        public final ModConfigSpec.IntValue CursedTombstoneCooldown;
    }

    // ==========================================
    // Mob Configs
    // ==========================================

    public static class ETC {
        ETC(final ModConfigSpec.Builder builder) {
            builder.push("etc");
            ReturnHome = builder.comment("Return Home")
                    .translation(LANG_PREFIX + "return_home")
                    .defineInRange("return_home",20, 0, 200);
            builder.pop();
        }
        public final ModConfigSpec.IntValue ReturnHome;
    }

    public static class EnderGuardian {
        EnderGuardian(final ModConfigSpec.Builder builder) {
            builder.push("ender_guardian");
            GravityPunchHpdamage = builder.comment("Gravity Punch Hp Damage")
                    .translation(LANG_PREFIX + "gravity_punch_hp_damage")
                    .defineInRange("gravity_punch_hp_damage", CMCommonConfig.EnderGuardian.GravityPunchHpdamage, 0.0D, 1.0D);
            TeleportAttackHpdamage = builder.comment("Teleport Attack Hp Damage")
                    .translation(LANG_PREFIX + "teleport_attack_hp_damage")
                    .defineInRange("teleport_attack_hp_damage", CMCommonConfig.EnderGuardian.TeleportAttackHpdamage, 0.0D, 1.0D);
            KnockbackHpdamage = builder.comment("Knockback Hp Damage")
                    .translation(LANG_PREFIX + "knockback_hp_damage")
                    .defineInRange("knockback_hp_damage", CMCommonConfig.EnderGuardian.KnockbackHpdamage, 0.0D, 1.0D);
            UppercutHpdamage = builder.comment("Uppercut Hp Damage")
                    .translation(LANG_PREFIX + "uppercut_hp_damage")
                    .defineInRange("uppercut_hp_damage",  CMCommonConfig.EnderGuardian.UppercutHpdamage, 0.0D, 1.0D);
            RocketPunchHpdamage = builder.comment("Rocket Punch Hp Damage")
                    .translation(LANG_PREFIX + "rocket_punch_hp_damage")
                    .defineInRange("rocket_punch_hp_damage", CMCommonConfig.EnderGuardian.RocketPunchHpdamage, 0.0D, 1.0D);
            AreaAttackHpdamage = builder.comment("Area Attack Hp Damage")
                    .translation(LANG_PREFIX + "area_attack_hp_damage")
                    .defineInRange("area_attack_hp_damage", CMCommonConfig.EnderGuardian.AreaAttackHpdamage, 0.0D, 1.0D);
            BlockBreakingX = builder.comment("Block Breaking X")
                    .translation(LANG_PREFIX + "block_break_x")
                    .defineInRange("block_break_x",  CMCommonConfig.EnderGuardian.BlockBreakingX, 0, 20);
            BlockBreakingY = builder.comment("Block Breaking Y")
                    .translation(LANG_PREFIX + "block_break_y")
                    .defineInRange("block_break_y",  CMCommonConfig.EnderGuardian.BlockBreakingY, 0, 10);
            BlockBreakingZ = builder.comment("Block Breaking Z")
                    .translation(LANG_PREFIX + "block_break_z")
                    .defineInRange("block_break_z",  CMCommonConfig.EnderGuardian.BlockBreakingZ, 0, 20);
            VoidRuneDamage = builder.comment("Void Rune Damage")
                    .translation(LANG_PREFIX + "void_rune_damage")
                    .defineInRange("void_rune_damage", CMCommonConfig.EnderGuardian.VoidRuneDamage, 0.0D, 1000000.0D);
            SeparatePhaseMusic = builder.comment("Enable separate music per boss phase")
                    .translation(LANG_PREFIX + "separate_phase_music")
                    .define("separate_phase_music",CMCommonConfig.EnderGuardian.SeparatePhaseMusic);
            combatConfig = new CombatConfig(builder, CMCommonConfig.EnderGuardian.healthMultiplier, CMCommonConfig.EnderGuardian.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.EnderGuardian.damageCap, CMCommonConfig.EnderGuardian.dpsCap,CMCommonConfig.EnderGuardian.dpsLimitTime,CMCommonConfig.EnderGuardian.rangeCap);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.EnderGuardian.natureHeal);
            respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.EnderGuardian.respawner);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.EnderGuardian.ignoreMobGriefing);
            builder.pop();
        }

        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue GravityPunchHpdamage;
        public final ModConfigSpec.DoubleValue TeleportAttackHpdamage;
        public final ModConfigSpec.DoubleValue KnockbackHpdamage;
        public final ModConfigSpec.DoubleValue UppercutHpdamage;
        public final ModConfigSpec.DoubleValue RocketPunchHpdamage;
        public final ModConfigSpec.DoubleValue AreaAttackHpdamage;
        public final ModConfigSpec.IntValue BlockBreakingX;
        public final ModConfigSpec.IntValue BlockBreakingY;
        public final ModConfigSpec.IntValue BlockBreakingZ;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;
        public final ModConfigSpec.BooleanValue SeparatePhaseMusic;
    }

    public static class EnderGolem {
        EnderGolem(final ModConfigSpec.Builder builder) {
            builder.push("ender_golem");
            VoidRuneDamage = builder.comment("Void Rune Damage")
                    .translation(LANG_PREFIX + "void_rune_damage")
                    .defineInRange("void_rune_damage", CMCommonConfig.EnderGolem.VoidRuneDamage, 0.0D, 1000000.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.EnderGolem.healthMultiplier, CMCommonConfig.EnderGolem.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.EnderGolem.damageCap, CMCommonConfig.EnderGolem.dpsCap,CMCommonConfig.EnderGolem.dpsLimitTime,CMCommonConfig.EnderGolem.rangeCap);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.EnderGolem.natureHeal);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.EnderGolem.ignoreMobGriefing);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;
    }

    public static class Netherite_Monstrosity {
        Netherite_Monstrosity(final ModConfigSpec.Builder builder) {
            builder.push("netherite_monstrosity");
            Lavabombmagazine = builder.comment("Lava bomb Magazine")
                    .translation(LANG_PREFIX + "lava_bomb_magazine")
                    .defineInRange("lava_bomb_magazine",CMCommonConfig.NetheriteMonstrosity.Lavabombmagazine, 0, 20);
            Lavabombamount = builder.comment("Lava bomb Amount")
                    .translation(LANG_PREFIX + "lava_bomb_amount")
                    .defineInRange("lava_bomb_amount",CMCommonConfig.NetheriteMonstrosity.Lavabombamount, 1, 1000);
            LavabombDuration = builder.comment("Lava bomb Duration")
                    .translation(LANG_PREFIX + "lava_bomb_duration")
                    .defineInRange("lava_bomb_duration",CMCommonConfig.NetheriteMonstrosity.LavabombDuration, 1, 10000);
            LavabombRandomDuration = builder.comment("Lava bomb Random Duration")
                    .translation(LANG_PREFIX + "lava_bomb_random_duration")
                    .defineInRange("lava_bomb_random_duration", CMCommonConfig.NetheriteMonstrosity.LavabombRandomDuration, 1, 10000);
            BodyCollided = builder.comment("Body collide like shulker")
                    .translation(LANG_PREFIX + "body_collided")
                    .define("body_collided",CMCommonConfig.NetheriteMonstrosity.BodyCollided);
            SmashHpdamage = builder.comment("Smash Hp Damage")
                    .translation(LANG_PREFIX + "smash_hp_damage")
                    .defineInRange("smash_hp_damage", CMCommonConfig.NetheriteMonstrosity.SmashHpdamage, 0.0D, 1.0D);
            FlameJetDamage = builder.comment("Flame Jet Damage")
                    .translation(LANG_PREFIX + "flame_jet_damage")
                    .defineInRange("flame_jet_damage", CMCommonConfig.NetheriteMonstrosity.FlameJetDamage, 0.0D, 1000000.0D);
            FlareBombDamage = builder.comment("Flare Bomb Damage")
                    .translation(LANG_PREFIX + "flare_bomb_damage")
                    .defineInRange("flare_bomb_damage", CMCommonConfig.NetheriteMonstrosity.FlareBombDamage, 0.0D, 1000000.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.NetheriteMonstrosity.healthMultiplier, CMCommonConfig.NetheriteMonstrosity.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.NetheriteMonstrosity.damageCap, CMCommonConfig.NetheriteMonstrosity.dpsCap,CMCommonConfig.NetheriteMonstrosity.dpsLimitTime,CMCommonConfig.NetheriteMonstrosity.rangeCap);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.NetheriteMonstrosity.natureHeal);
            respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.NetheriteMonstrosity.respawner);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.NetheriteMonstrosity.ignoreMobGriefing);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.IntValue Lavabombmagazine;
        public final ModConfigSpec.IntValue Lavabombamount;
        public final ModConfigSpec.IntValue LavabombDuration;
        public final ModConfigSpec.IntValue LavabombRandomDuration;
        public final ModConfigSpec.BooleanValue BodyCollided;
        public final ModConfigSpec.DoubleValue SmashHpdamage;
        public final ModConfigSpec.DoubleValue FlameJetDamage;
        public final ModConfigSpec.DoubleValue FlareBombDamage;
    }

    public static class Netherite_Ministrosity {
        Netherite_Ministrosity(final ModConfigSpec.Builder builder) {
            builder.push("netherite_ministrosity");
            combatConfig = new CombatConfig(builder, CMCommonConfig.NetheriteMinistrosity.healthMultiplier, CMCommonConfig.NetheriteMinistrosity.attackMultiplier);
            builder.pop();
        }
        public final CombatConfig combatConfig;
    }

    public static class Ignis {
        Ignis(final ModConfigSpec.Builder builder) {
            builder.push("ignis");
            HealingMultiplier = builder.comment("Ignis's Life steal Multiplier")
                    .translation(LANG_PREFIX + "healing_multiplier")
                    .defineInRange("healing_multiplier",CMCommonConfig.Ignis.HealingMultiplier, 0.0D, 1000000.0D);
            SeparatePhaseMusic = builder.comment("Enable separate music per boss phase")
                    .translation(LANG_PREFIX + "separate_phase_music")
                    .define("separate_phase_music",CMCommonConfig.Ignis.SeparatePhaseMusic);
            combatConfig = new CombatConfig(builder, CMCommonConfig.Ignis.healthMultiplier, CMCommonConfig.Ignis.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.Ignis.damageCap, CMCommonConfig.Ignis.dpsCap,CMCommonConfig.Ignis.dpsLimitTime,CMCommonConfig.Ignis.rangeCap);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.Ignis.natureHeal);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Ignis.ignoreMobGriefing);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue HealingMultiplier;
        public final ModConfigSpec.BooleanValue SeparatePhaseMusic;
    }

    public static class Ignited_Revenant {
        Ignited_Revenant(final ModConfigSpec.Builder builder) {
            builder.push("ignited_revenant");
            AshenbreathDamage = builder.comment("Ashen Breath Damage")
                    .translation(LANG_PREFIX + "ashen_breath_damage")
                    .defineInRange("ashen_breath_damage",CMCommonConfig.IgnitedRevenant.AshenbreathDamage, 0.0D, 1000000.0D);
            BlazingBoneDamage = builder.comment("Blazing Bone Damage")
                    .translation(LANG_PREFIX + "blazing_bone_damage")
                    .defineInRange("blazing_bone_damage",CMCommonConfig.IgnitedRevenant.BlazingBoneDamage, 0.0D, 1000000.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.IgnitedRevenant.healthMultiplier, CMCommonConfig.IgnitedRevenant.attackMultiplier);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final ModConfigSpec.DoubleValue AshenbreathDamage;
        public final ModConfigSpec.DoubleValue BlazingBoneDamage;
    }

    public static class Harbinger {
        Harbinger(final ModConfigSpec.Builder builder) {
            builder.push("harbinger");
            AutoHeal = builder.comment("Harbinger Auto Heal")
                    .translation(LANG_PREFIX + "harbinger_auto_heal")
                    .defineInRange("harbinger_auto_heal",CMCommonConfig.Harbinger.AutoHeal, 0.0D, 1000000.0D);
            LifeSteal = builder.comment("Harbinger Life Steal")
                    .translation(LANG_PREFIX + "harbinger_life_steal")
                    .defineInRange("harbinger_life_steal",CMCommonConfig.Harbinger.LifeSteal, 0.0D, 1000000.0D);
            WitherMissiledamage = builder.comment("Wither Missile Damage")
                    .translation(LANG_PREFIX + "wither_missile_damage")
                    .defineInRange("wither_missile_damage",CMCommonConfig.Harbinger.WitherMissiledamage, 0.0D, 1000000.0D);
            Laserdamage = builder.comment("Laser Damage")
                    .translation(LANG_PREFIX + "laser_damage")
                    .defineInRange("laser_damage",CMCommonConfig.Harbinger.Laserdamage, 0.0D, 1000000.0D);
            DeathLaserdamage = builder.comment("Death Laser Damage")
                    .translation(LANG_PREFIX + "death_laser_damage")
                    .defineInRange("death_laser_damage",CMCommonConfig.Harbinger.DeathLaserdamage, 0.0D, 1000000.0D);
            DeathLaserHpdamage = builder.comment("Death Laser HP Damage")
                    .translation(LANG_PREFIX + "death_laser_hp_damage")
                    .defineInRange("death_laser_hp_damage",CMCommonConfig.Harbinger.DeathLaserHpdamage, 0.0D, 1.0D);
            ChargeHpDamage = builder.comment("Charge Attack Hp Damage")
                    .translation(LANG_PREFIX + "charge_hp_damage")
                    .defineInRange("charge_hp_damage",CMCommonConfig.Harbinger.ChargeHpDamage, 0.0D, 1.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.Harbinger.healthMultiplier, CMCommonConfig.Harbinger.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.Harbinger.damageCap, CMCommonConfig.Harbinger.dpsCap,CMCommonConfig.Harbinger.dpsLimitTime,CMCommonConfig.Harbinger.rangeCap);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.Harbinger.natureHeal);
            respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.Harbinger.respawner);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Harbinger.ignoreMobGriefing);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue AutoHeal;
        public final ModConfigSpec.DoubleValue LifeSteal;
        public final ModConfigSpec.DoubleValue WitherMissiledamage;
        public final ModConfigSpec.DoubleValue Laserdamage;
        public final ModConfigSpec.DoubleValue DeathLaserdamage;
        public final ModConfigSpec.DoubleValue DeathLaserHpdamage;
        public final ModConfigSpec.DoubleValue ChargeHpDamage;
    }

    public static class Prowler {
        Prowler(final ModConfigSpec.Builder builder) {
            builder.push("prowler");
            rangeCap = builder.comment("Range Cap")
                    .translation(LANG_PREFIX + "range_cap")
                    .defineInRange("range_cap", CMCommonConfig.Prowler.rangeCap, 1.0D,1000000.0D);
            HomingMissiledamage = builder.comment("Wither Homing Missile")
                    .translation(LANG_PREFIX + "homing_missile")
                    .defineInRange("homing_missile",CMCommonConfig.Prowler.HomingMissiledamage, 0.0D, 1000000.0D);
            DeathLaserdamage = builder.comment("Death Laser Damage")
                    .translation(LANG_PREFIX + "death_laser_damage")
                    .defineInRange("death_laser_damage",CMCommonConfig.Prowler.DeathLaserdamage, 0.0D, 1000000.0D);
            DeathLaserHpdamage = builder.comment("Death Laser HP Damage")
                    .translation(LANG_PREFIX + "death_laser_hp_damage")
                    .defineInRange("death_laser_hp_damage",CMCommonConfig.Prowler.DeathLaserHpdamage, 0.0D, 1.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.Prowler.healthMultiplier, CMCommonConfig.Prowler.attackMultiplier);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final ModConfigSpec.DoubleValue rangeCap;
        public final ModConfigSpec.DoubleValue HomingMissiledamage;
        public final ModConfigSpec.DoubleValue DeathLaserdamage;
        public final ModConfigSpec.DoubleValue DeathLaserHpdamage;
    }

    public static class Leviathan {
        Leviathan(final ModConfigSpec.Builder builder) {
            builder.push("leviathan");
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Leviathan.ignoreMobGriefing);
            BiteHpDamage = builder.comment("Bite Hp Damage")
                    .translation(LANG_PREFIX + "bite_hp_damage")
                    .defineInRange("bite_hp_damage",CMCommonConfig.Leviathan.BiteHpDamage, 0.0D, 1.0D);
            RushHpDamage = builder.comment("Rush Hp Damge")
                    .translation(LANG_PREFIX + "rush_hp_damage")
                    .defineInRange("rush_hp_damage",CMCommonConfig.Leviathan.RushHpDamage, 0.0D, 1.0D);
            TailSwingHpDamage = builder.comment("Tail Swing Hp Damage")
                    .translation(LANG_PREFIX + "tail_swing_hp_damage")
                    .defineInRange("tail_swing_hp_damage",CMCommonConfig.Leviathan.TailSwingHpDamage, 0.0D, 1.0D);
            TentacleHpDamage = builder.comment("Tentacle Hp Damage")
                    .translation(LANG_PREFIX + "tentacle_hp_damage")
                    .defineInRange("tentacle_hp_damage",CMCommonConfig.Leviathan.TentacleHpDamage, 0.0D, 1.0D);
            DimensionalRiftDamage = builder.comment("Dimensional Rift Damage")
                    .translation(LANG_PREFIX + "dimensional_rift_damage")
                    .defineInRange("dimensional_rift_damage",CMCommonConfig.Leviathan.DimensionalRiftDamage, 0.0D, 1000000.0D);
            AbyssBlastDamage = builder.comment("Abyss Blast Damage")
                    .translation(LANG_PREFIX + "abyss_blast_damage")
                    .defineInRange("abyss_blast_damage",CMCommonConfig.Leviathan.AbyssBlastDamage, 0.0D, 1000000.0D);
            AbyssBlastHpDamage = builder.comment("Abyss Blast HP Damage")
                    .translation(LANG_PREFIX + "abyss_blast_hp_damage")
                    .defineInRange("abyss_blast_hp_damage",CMCommonConfig.Leviathan.AbyssBlastHpDamage, 0.0D, 1.0D);
            AbyssOrbdamage = builder.comment("Abyss Orb Damage")
                    .translation(LANG_PREFIX + "abyss_orb_damage")
                    .defineInRange("abyss_orb_damage",CMCommonConfig.Leviathan.AbyssOrbdamage, 0.0D, 1000000.0D);
            ImmuneOutofWater = builder.comment("Leviathan Immune Out of Water.")
                    .translation(LANG_PREFIX + "immune_out_of_water")
                    .define("immune_out_of_water",CMCommonConfig.Leviathan.ImmuneOutofWater);
            SeparatePhaseMusic = builder.comment("Enable separate music per boss phase")
                    .translation(LANG_PREFIX + "separate_phase_music")
                    .define("separate_phase_music",CMCommonConfig.Leviathan.SeparatePhaseMusic);
            combatConfig = new CombatConfig(builder, CMCommonConfig.Leviathan.healthMultiplier, CMCommonConfig.Leviathan.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.Leviathan.damageCap, CMCommonConfig.Leviathan.dpsCap,CMCommonConfig.Leviathan.dpsLimitTime,CMCommonConfig.Leviathan.rangeCap);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.Leviathan.natureHeal);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue BiteHpDamage;
        public final ModConfigSpec.DoubleValue RushHpDamage;
        public final ModConfigSpec.DoubleValue TailSwingHpDamage;
        public final ModConfigSpec.DoubleValue TentacleHpDamage;
        public final ModConfigSpec.DoubleValue DimensionalRiftDamage;
        public final ModConfigSpec.DoubleValue AbyssBlastDamage;
        public final ModConfigSpec.DoubleValue AbyssBlastHpDamage;
        public final ModConfigSpec.DoubleValue AbyssOrbdamage;
        public final ModConfigSpec.BooleanValue ImmuneOutofWater;
        public final ModConfigSpec.BooleanValue SeparatePhaseMusic;
    }

    public static class BabyLeviathan {
        BabyLeviathan(final ModConfigSpec.Builder builder) {
            builder.push("baby_leviathan");
            combatConfig = new CombatConfig(builder, CMCommonConfig.BabyLeviathan.healthMultiplier, CMCommonConfig.BabyLeviathan.attackMultiplier);
            builder.pop();
        }
        public final CombatConfig combatConfig;
    }

    public static class Amethyst_Crab {
        Amethyst_Crab(final ModConfigSpec.Builder builder) {
            builder.push("amethyst_crab");
            EarthQuakeDamage = builder.comment("Earth Quake Damage")
                    .translation(LANG_PREFIX + "earth_quake_damage")
                    .defineInRange("earth_quake_damage",CMCommonConfig.AmethystCrab.EarthQuakeDamage, 0.0D, 1000000.0D);
            AmethystClusterDamage = builder.comment("Amethyst Cluster Damage")
                    .translation(LANG_PREFIX + "amethyst_cluster_damage")
                    .defineInRange("amethyst_cluster_damage",CMCommonConfig.AmethystCrab.AmethystClusterDamage, 0.0D, 1000000.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.AmethystCrab.healthMultiplier, CMCommonConfig.AmethystCrab.attackMultiplier);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final ModConfigSpec.DoubleValue EarthQuakeDamage;
        public final ModConfigSpec.DoubleValue AmethystClusterDamage;
    }

    public static class Ancient_Remnant {
        Ancient_Remnant(final ModConfigSpec.Builder builder) {
            builder.push("ancient_remnant");
            ChargeHpDamage = builder.comment("Charge Hp Damage")
                    .translation(LANG_PREFIX + "charge_hp_damage")
                    .defineInRange("charge_hp_damage",CMCommonConfig.AncientRemnant.ChargeHpDamage, 0.0D, 1.0D);
            HpDamage = builder.comment("Hp Damage")
                    .translation(LANG_PREFIX + "hp_damage")
                    .defineInRange("hp_damage", CMCommonConfig.AncientRemnant.HpDamage, 0.0D, 1.0D);
            StompHpDamage = builder.comment("Stomp Hp Damage")
                    .translation(LANG_PREFIX + "stomp_hp_damage")
                    .defineInRange("stomp_hp_damage",CMCommonConfig.AncientRemnant.StompHpDamage, 0.0D, 1.0D);
            EarthQuakeDamage = builder.comment("EarthQuake Damage")
                    .translation(LANG_PREFIX + "earthquake_damage")
                    .defineInRange("earthquake_damage", CMCommonConfig.AncientRemnant.EarthQuakeDamage, 0.0D, 1000000.0D);
            AncientDesertSteledamage = builder.comment("Ancient Desert Stele Damage")
                    .translation(LANG_PREFIX + "ancient_desert_stele_damage")
                    .defineInRange("ancient_desert_stele_damage", CMCommonConfig.AncientRemnant.AncientDesertSteledamage, 0.0D, 1000000.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.AncientRemnant.healthMultiplier, CMCommonConfig.AncientRemnant.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.AncientRemnant.damageCap, CMCommonConfig.AncientRemnant.dpsCap,CMCommonConfig.AncientRemnant.dpsLimitTime,CMCommonConfig.AncientRemnant.rangeCap);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.AncientRemnant.natureHeal);
            respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.AncientRemnant.respawner);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.AncientRemnant.ignoreMobGriefing);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue ChargeHpDamage;
        public final ModConfigSpec.DoubleValue HpDamage;
        public final ModConfigSpec.DoubleValue StompHpDamage;
        public final ModConfigSpec.DoubleValue EarthQuakeDamage;
        public final ModConfigSpec.DoubleValue AncientDesertSteledamage;
    }

    public static class ModernRemnant {
        ModernRemnant(final ModConfigSpec.Builder builder) {
            builder.push("modern_remnant");
            combatConfig = new CombatConfig(builder, CMCommonConfig.ModernRemnant.healthMultiplier, CMCommonConfig.ModernRemnant.attackMultiplier);
            builder.pop();
        }
        public final CombatConfig combatConfig;
    }

    public static class Koboleton {
        Koboleton(final ModConfigSpec.Builder builder) {
            builder.push("koboleton");
            CauseKoboletontoDropItemInHandPercent = builder.comment("CauseKoboletontoDropItemInHandPercent")
                    .translation(LANG_PREFIX + "drop_hand")
                    .defineInRange("drop_hand",CMCommonConfig.Koboleton.CauseKoboletontoDropItemInHandPercent, 0.0D, 100.0D);
            builder.pop();
        }
        public final ModConfigSpec.DoubleValue CauseKoboletontoDropItemInHandPercent;
    }

    public static class Kobolediator {
        Kobolediator(final ModConfigSpec.Builder builder) {
            builder.push("kobolediator");
            combatConfig = new CombatConfig(builder, CMCommonConfig.Kobolediator.healthMultiplier, CMCommonConfig.Kobolediator.attackMultiplier);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Kobolediator.ignoreMobGriefing);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
    }

    public static class Wadjet {
        Wadjet(final ModConfigSpec.Builder builder) {
            builder.push("wadjet");
            Sandstorm_damage = builder.comment("Sandstorm Damage")
                    .translation(LANG_PREFIX + "sandstorm_damage")
                    .defineInRange("sandstorm_damage",  CMCommonConfig.Wadjet.Sandstorm_damage, 0.0D, 1000000.0D);
            AncientDesertSteledamage = builder.comment("Ancient Desert Stele Damage")
                    .translation(LANG_PREFIX + "ancient_desert_stele_damage")
                    .defineInRange("ancient_desert_stele_damage", CMCommonConfig.Wadjet.AncientDesertSteledamage, 0.0D, 1000000.0D);
            combatConfig = new CombatConfig(builder,  CMCommonConfig.Wadjet.healthMultiplier, CMCommonConfig.Wadjet.attackMultiplier);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final ModConfigSpec.DoubleValue Sandstorm_damage;
        public final ModConfigSpec.DoubleValue AncientDesertSteledamage;
    }

    public static class Scylla {
        Scylla(final ModConfigSpec.Builder builder) {
            builder.push("scylla");
            SpearDamage = builder.comment("Spear Damage")
                    .translation(LANG_PREFIX + "spear_damage")
                    .defineInRange("spear_damage",CMCommonConfig.Scylla.SpearDamage, 0.0D, 1000000.0D);
            LightningStormDamage = builder.comment("Lightning Storm Damage")
                    .translation(LANG_PREFIX + "lightning_storm_damage")
                    .defineInRange("lightning_storm_damage",CMCommonConfig.Scylla.LightningStormDamage, 0.0D, 1000000.0D);
            LightningAreaDamage = builder.comment("Lightning Area Damage")
                    .translation(LANG_PREFIX + "lightning_area_damage")
                    .defineInRange("lightning_area_damage",CMCommonConfig.Scylla.LightningAreaDamage, 0.0D, 1000000.0D);
            SnakeDamage = builder.comment("Snake Damage")
                    .translation(LANG_PREFIX + "snake_damage")
                    .defineInRange("snake_damage",CMCommonConfig.Scylla.SnakeDamage, 0.0D, 1000000.0D);
            AnchorDamage = builder.comment("Anchor Damage")
                    .translation(LANG_PREFIX + "anchor_damage")
                    .defineInRange("anchor_damage",CMCommonConfig.Scylla.AnchorDamage, 0.0D, 1000000.0D);
            WeatherChange = builder.comment("Weather Change")
                    .translation(LANG_PREFIX + "weather_change")
                    .define("weather_change",CMCommonConfig.Scylla.WeatherChange);
            HpDamage = builder.comment("Hp Damage")
                    .translation(LANG_PREFIX + "hp_damage")
                    .defineInRange("hp_damage", CMCommonConfig.Scylla.HpDamage, 0.0D, 1.0D);
            SpinHpDamage = builder.comment("Spin Hp Damage")
                    .translation(LANG_PREFIX + "spin_hp_damage")
                    .defineInRange("spin_hp_damage", CMCommonConfig.Scylla.SpinHpDamage, 0.0D, 1.0D);
            StormHpDamage = builder.comment("Lightning Storm Hp Damage")
                    .translation(LANG_PREFIX + "lightning_storm_hp_damage")
                    .defineInRange("lightning_storm_hp_damage",CMCommonConfig.Scylla.StormHpDamage, 0.0D, 1.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.Scylla.healthMultiplier, CMCommonConfig.Scylla.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.Scylla.damageCap, CMCommonConfig.Scylla.dpsCap,CMCommonConfig.Scylla.dpsLimitTime,CMCommonConfig.Scylla.rangeCap);
            respawnerConfig = new RespawnerConfig(builder, CMCommonConfig.Scylla.respawner);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.Scylla.natureHeal);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Scylla.ignoreMobGriefing);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final RespawnerConfig respawnerConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue SpearDamage;
        public final ModConfigSpec.DoubleValue LightningStormDamage;
        public final ModConfigSpec.DoubleValue HpDamage;
        public final ModConfigSpec.DoubleValue LightningAreaDamage;
        public final ModConfigSpec.DoubleValue SnakeDamage;
        public final ModConfigSpec.DoubleValue AnchorDamage;
        public final ModConfigSpec.BooleanValue WeatherChange;
        public final ModConfigSpec.DoubleValue SpinHpDamage;
        public final ModConfigSpec.DoubleValue StormHpDamage;
    }

    public static class Clawdian {
        Clawdian(final ModConfigSpec.Builder builder) {
            builder.push("clawdian");
            combatConfig = new CombatConfig(builder, CMCommonConfig.Clawdian.healthMultiplier, CMCommonConfig.Clawdian.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.Clawdian.damageCap, CMCommonConfig.Clawdian.dpsCap,CMCommonConfig.Clawdian.dpsLimitTime,CMCommonConfig.Clawdian.rangeCap);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Clawdian.ignoreMobGriefing);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.Clawdian.natureHeal);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
    }

    public static class Maledictus {
        Maledictus(final ModConfigSpec.Builder builder) {
            builder.push("maledictus");
            PhantomHalberdDamage = builder.comment("Phantom Halberd Damage")
                    .translation(LANG_PREFIX + "phantom_halberd_damage")
                    .defineInRange("phantom_halberd_damage",CMCommonConfig.Maledictus.PhantomHalberdDamage, 0.0D, 1000000.0D);
            HpDamage = builder.comment("Hp Damage")
                    .translation(LANG_PREFIX + "hp_damage")
                    .defineInRange("hp_damage", CMCommonConfig.Maledictus.HpDamage, 0.0D, 1.0D);
            ShockWaveHpDamage = builder.comment("Shock Wave Hp Damage")
                    .translation(LANG_PREFIX + "shock_wave_hp_damage")
                    .defineInRange("shock_wave_hp_damage", CMCommonConfig.Maledictus.ShockWaveHpDamage, 0.0D, 1.0D);
            AOEHpDamage = builder.comment("AOE Hp Damage")
                    .translation(LANG_PREFIX + "aoe_hp_damage")
                    .defineInRange("aoe_hp_damage", CMCommonConfig.Maledictus.AOEHpDamage, 0.0D, 1.0D);
            FlyingSmashHpDamage = builder.comment("Flying Smash Hp Damage")
                    .translation(LANG_PREFIX + "flying_smash_hp_damage")
                    .defineInRange("flying_smash_hp_damage",CMCommonConfig.Maledictus.FlyingSmashHpDamage, 0.0D, 1.0D);
            SmashHpDamage = builder.comment("Smash Hp Damage")
                    .translation(LANG_PREFIX + "smash_hp_damage")
                    .defineInRange("smash_hp_damage", CMCommonConfig.Maledictus.SmashHpDamage, 0.0D, 1.0D);
            PhantomArrowDamage = builder.comment("Phantom Arrow Damage")
                    .translation(LANG_PREFIX + "phantom_arrow_damage")
                    .defineInRange("phantom_arrow_damage", CMCommonConfig.Maledictus.PhantomArrowDamage, 0.0D, 1000000.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.Maledictus.healthMultiplier, CMCommonConfig.Maledictus.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.Maledictus.damageCap, CMCommonConfig.Maledictus.dpsCap,CMCommonConfig.Maledictus.dpsLimitTime, CMCommonConfig.Maledictus.rangeCap);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.Maledictus.natureHeal);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Maledictus.ignoreMobGriefing);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
        public final ModConfigSpec.DoubleValue PhantomHalberdDamage;
        public final ModConfigSpec.DoubleValue HpDamage;
        public final ModConfigSpec.DoubleValue ShockWaveHpDamage;
        public final ModConfigSpec.DoubleValue AOEHpDamage;
        public final ModConfigSpec.DoubleValue FlyingSmashHpDamage;
        public final ModConfigSpec.DoubleValue SmashHpDamage;
        public final ModConfigSpec.DoubleValue PhantomArrowDamage;
    }

    public static class Aptrgangr {
        Aptrgangr(final ModConfigSpec.Builder builder) {
            builder.push("aptrgangr");
            AxeBladeDamage = builder.comment("Axe Blade Damage")
                    .translation(LANG_PREFIX + "axe_blade_damage")
                    .defineInRange("axe_blade_damage",CMCommonConfig.Aptrgangr.AxeBladeDamage, 0.0D, 1000000.0D);
            combatConfig = new CombatConfig(builder, CMCommonConfig.Aptrgangr.healthMultiplier, CMCommonConfig.Aptrgangr.attackMultiplier);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.Aptrgangr.natureHeal);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final NatureHealConfig healConfig;
        public final ModConfigSpec.DoubleValue AxeBladeDamage;
    }

    public static class Onyx {
        Onyx(final ModConfigSpec.Builder builder) {
            builder.push("onyx");
            combatConfig = new CombatConfig(builder, CMCommonConfig.Onyx.healthMultiplier, CMCommonConfig.Onyx.attackMultiplier);
            capConfig = new CapConfig(builder, CMCommonConfig.Onyx.damageCap, CMCommonConfig.Onyx.dpsCap,CMCommonConfig.Onyx.dpsLimitTime,CMCommonConfig.Onyx.rangeCap);
            healConfig = new NatureHealConfig(builder, CMCommonConfig.Onyx.natureHeal);
            mobGriefingConfig = new IgnoreMobGriefing(builder, CMCommonConfig.Onyx.ignoreMobGriefing);
            builder.pop();
        }
        public final CombatConfig combatConfig;
        public final CapConfig capConfig;
        public final NatureHealConfig healConfig;
        public final IgnoreMobGriefing mobGriefingConfig;
    }

    // ==========================================
    // Spawning Configs
    // ==========================================

    public static class Spawning {
        Spawning(final ModConfigSpec.Builder builder) {
            builder.push("spawning");
            DeeplingSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn")
                    .translation(LANG_PREFIX + "deepling_spawn_weight")
                    .defineInRange("deepling_spawn_weight",CMCommonConfig.Spawning.DeeplingSpawnWeight, 0, 1000);
            DeeplingSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning")
                    .translation(LANG_PREFIX + "deepling_spawn_rolls")
                    .defineInRange("deepling_spawn_rolls",CMCommonConfig.Spawning.DeeplingSpawnRolls, 0, Integer.MAX_VALUE);
            DeeplingBruteSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn")
                    .translation(LANG_PREFIX + "deepling_brute_spawn_weight")
                    .defineInRange("deepling_brute_spawn_weight",CMCommonConfig.Spawning.DeeplingBruteSpawnWeight, 0, 1000);
            DeeplingBruteSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning")
                    .translation(LANG_PREFIX + "deepling_brute_spawn_rolls")
                    .defineInRange("deepling_brute_spawn_rolls",CMCommonConfig.Spawning.DeeplingBruteSpawnRolls, 0, Integer.MAX_VALUE);
            DeeplingAnglerSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn")
                    .translation(LANG_PREFIX + "deepling_angler_spawn_weight")
                    .defineInRange("deepling_angler_spawn_weight",CMCommonConfig.Spawning.DeeplingAnglerSpawnWeight, 0, 1000);
            DeeplingAnglerSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning")
                    .translation(LANG_PREFIX + "deepling_angler_spawn_rolls")
                    .defineInRange("deepling_angler_spawn_rolls",CMCommonConfig.Spawning.DeeplingAnglerSpawnRolls, 0, Integer.MAX_VALUE);
            DeeplingPriestSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn")
                    .translation(LANG_PREFIX + "deepling_priest_spawn_weight")
                    .defineInRange("deepling_priest_spawn_weight",CMCommonConfig.Spawning.DeeplingPriestSpawnWeight, 0, 1000);
            DeeplingPriestSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning")
                    .translation(LANG_PREFIX + "deepling_priest_spawn_rolls")
                    .defineInRange("deepling_priest_spawn_rolls",CMCommonConfig.Spawning.DeeplingPriestSpawnRolls, 0, Integer.MAX_VALUE);
            DeeplingWarlockSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn")
                    .translation(LANG_PREFIX + "deepling_warlock_spawn_weight")
                    .defineInRange("deepling_warlock_spawn_weight",CMCommonConfig.Spawning.DeeplingWarlockSpawnWeight, 0, 1000);
            DeeplingWarlockSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning")
                    .translation(LANG_PREFIX + "deepling_warlock_spawn_rolls")
                    .defineInRange("deepling_warlock_spawn_rolls",CMCommonConfig.Spawning.DeeplingWarlockSpawnRolls, 0, Integer.MAX_VALUE);
            CoralgolemSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn")
                    .translation(LANG_PREFIX + "coral_golem_spawn_weight")
                    .defineInRange("coral_golem_spawn_weight",CMCommonConfig.Spawning.CoralgolemSpawnWeight, 0, 1000);
            CoralgolemSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning")
                    .translation(LANG_PREFIX + "coral_golem_spawn_rolls")
                    .defineInRange("coral_golem_spawn_rolls",CMCommonConfig.Spawning.CoralgolemSpawnRolls, 0, Integer.MAX_VALUE);
            AmethystCrabSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn")
                    .translation(LANG_PREFIX + "amethyst_crab_spawn_weight")
                    .defineInRange("amethyst_crab_spawn_weight",CMCommonConfig.Spawning.AmethystCrabSpawnWeight, 0, 1000);
            AmethystCrabSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning")
                    .translation(LANG_PREFIX + "amethyst_crab_spawn_rolls")
                    .defineInRange("amethyst_crab_spawn_rolls",CMCommonConfig.Spawning.AmethystCrabSpawnRolls, 0, Integer.MAX_VALUE);
            KoboletonSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn")
                    .translation(LANG_PREFIX + "koboleton_spawn_weight")
                    .defineInRange("koboleton_spawn_weight",CMCommonConfig.Spawning.KoboletonSpawnWeight, 0, 1000);
            KoboletonSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning")
                    .translation(LANG_PREFIX + "koboleton_spawn_rolls")
                    .defineInRange("koboleton_spawn_rolls",CMCommonConfig.Spawning.KoboletonSpawnRolls, 0, Integer.MAX_VALUE);
            IgnitedBerserkerSpawnWeight = builder.comment("Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn")
                    .translation(LANG_PREFIX + "ignited_berserker_spawn_weight")
                    .defineInRange("ignited_berserker_spawn_weight",CMCommonConfig.Spawning.IgnitedBerserkerSpawnWeight, 0, 1000);
            IgnitedBerserkerSpawnRolls = builder.comment("Random roll chance to enable mob spawning. Higher number = lower chance of spawning")
                    .translation(LANG_PREFIX + "ignited_berserker_spawn_rolls")
                    .defineInRange("ignited_berserker_spawn_rolls",CMCommonConfig.Spawning.IgnitedBerserkerSpawnRolls, 0, Integer.MAX_VALUE);
            builder.pop();
        }
        public final ModConfigSpec.IntValue DeeplingSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingSpawnRolls;
        public final ModConfigSpec.IntValue DeeplingBruteSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingBruteSpawnRolls;
        public final ModConfigSpec.IntValue DeeplingAnglerSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingAnglerSpawnRolls;
        public final ModConfigSpec.IntValue DeeplingPriestSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingPriestSpawnRolls;
        public final ModConfigSpec.IntValue DeeplingWarlockSpawnWeight;
        public final ModConfigSpec.IntValue DeeplingWarlockSpawnRolls;
        public final ModConfigSpec.IntValue CoralgolemSpawnWeight;
        public final ModConfigSpec.IntValue CoralgolemSpawnRolls;
        public final ModConfigSpec.IntValue AmethystCrabSpawnWeight;
        public final ModConfigSpec.IntValue AmethystCrabSpawnRolls;
        public final ModConfigSpec.IntValue KoboletonSpawnWeight;
        public final ModConfigSpec.IntValue KoboletonSpawnRolls;
        public final ModConfigSpec.IntValue IgnitedBerserkerSpawnWeight;
        public final ModConfigSpec.IntValue IgnitedBerserkerSpawnRolls;
    }

    // ==========================================
    // Tools & Abilities Configs
    // ==========================================

    public static class IgnitiumArmor {
        IgnitiumArmor(final ModConfigSpec.Builder builder) {
            builder.push("ignitium_armor");
            armorConfig = new ArmorConfig(builder, CMCommonConfig.IgnitiumArmor.armorMultiplier,CMCommonConfig.IgnitiumArmor.toughness, CMCommonConfig.IgnitiumArmor.knockbackResistance);
            builder.pop();
        }
        public final ArmorConfig armorConfig;

    }

    public static class CursiumArmor {
        CursiumArmor(final ModConfigSpec.Builder builder) {
            builder.push("cursium_armor");
            armorConfig = new ArmorConfig(builder, CMCommonConfig.CursiumArmor.armorMultiplier,CMCommonConfig.CursiumArmor.toughness, CMCommonConfig.CursiumArmor.knockbackResistance);
            builder.pop();
        }
        public final ArmorConfig armorConfig;

    }

    public static class BoneReptileArmor {
        BoneReptileArmor(final ModConfigSpec.Builder builder) {
            builder.push("bone_reptile_armor");
            armorConfig = new ArmorConfig(builder, CMCommonConfig.BoneReptileArmor.armorMultiplier,CMCommonConfig.BoneReptileArmor.toughness, CMCommonConfig.BoneReptileArmor.knockbackResistance);
            builder.pop();
        }
        public final ArmorConfig armorConfig;
    }

    public static class BloomStoneArmor {
        BloomStoneArmor(final ModConfigSpec.Builder builder) {
            builder.push("bloom_stone_armor");
            armorConfig = new ArmorConfig(builder, CMCommonConfig.BloomStoneArmor.armorMultiplier,CMCommonConfig.BloomStoneArmor.toughness, CMCommonConfig.BloomStoneArmor.knockbackResistance);
            builder.pop();
        }
        public final ArmorConfig armorConfig;
    }

    public static class Incinerator {
        Incinerator(final ModConfigSpec.Builder builder) {
            builder.push("incinerator");
            IncineratorCooldown = builder.comment("Incinerator Cooldown")
                    .translation(LANG_PREFIX + "incinerator_cooldown")
                    .defineInRange("incinerator_cooldown",CMCommonConfig.Incinerator.cooldown, 0, 1000);
            toolConfig = new ToolConfig(builder, CMCommonConfig.Incinerator.attackDamage, CMCommonConfig.Incinerator.attackSpeed);
            builder.pop();
        }

        public final ModConfigSpec.IntValue IncineratorCooldown;

        public final ToolConfig toolConfig;
    }

    public static class BulwarkOfTheFlame {
        BulwarkOfTheFlame(final ModConfigSpec.Builder builder) {
            builder.push("bulwark_of_the_flame");
            BulwarkOfTheFlameCooldown = builder.comment("Bulwark Of The Flame Cooldown")
                    .translation(LANG_PREFIX + "bulwark_of_the_flame_cooldown")
                    .defineInRange("bulwark_of_the_flame_cooldown",CMCommonConfig.BulwarkOfTheFlame.cooldown, 0, 1000);
            builder.pop();
        }
        public final ModConfigSpec.IntValue BulwarkOfTheFlameCooldown;
    }

    public static class GauntletOfGuard {
        GauntletOfGuard(final ModConfigSpec.Builder builder) {
            builder.push("gauntlet_of_guard");
            toolConfig = new ToolConfig(builder, CMCommonConfig.GauntletOfGuard.attackDamage, CMCommonConfig.GauntletOfGuard.attackSpeed);
            builder.pop();
        }
        public final ToolConfig toolConfig;
    }

    public static class GauntletOfBulwark {
        GauntletOfBulwark(final ModConfigSpec.Builder builder) {
            builder.push("gauntlet_of_bulwark");
            GauntletOfBulwarkCooldown = builder.comment("Gauntlet Of Bulwark Cooldown")
                    .translation(LANG_PREFIX + "gauntlet_of_bulwark_cooldown")
                    .defineInRange("gauntlet_of_bulwark_cooldown",CMCommonConfig.GauntletOfBulwark.cooldown, 0, 1000);
            toolConfig = new ToolConfig(builder, CMCommonConfig.GauntletOfBulwark.attackDamage, CMCommonConfig.GauntletOfBulwark.attackSpeed);
            builder.pop();
        }

        public final ModConfigSpec.IntValue GauntletOfBulwarkCooldown;
        public final ToolConfig toolConfig;
    }

    public static class GauntletOfMaelstrom {
        GauntletOfMaelstrom(final ModConfigSpec.Builder builder) {
            builder.push("gauntlet_of_maelstrom");
            GauntletOfMaelstromCooldown = builder.comment("Maelstrom Cooldown")
                    .translation(LANG_PREFIX + "maelstrom_cooldown")
                    .defineInRange("maelstrom_cooldown",CMCommonConfig.GauntletOfMaelstrom.cooldown, 0, 1000);
            toolConfig = new ToolConfig(builder, CMCommonConfig.GauntletOfMaelstrom.attackDamage, CMCommonConfig.GauntletOfMaelstrom.attackSpeed);
            builder.pop();
        }

        public final ModConfigSpec.IntValue GauntletOfMaelstromCooldown;
        public final ToolConfig toolConfig;
    }

    public static class InfernalForge {
        InfernalForge(final ModConfigSpec.Builder builder) {
            builder.push("infernal_forge");
            InfernalForgeCooldown = builder.comment("Infernal Forge Cooldown")
                    .translation(LANG_PREFIX + "infernal_forge_cooldown")
                    .defineInRange("infernal_forge_cooldown",CMCommonConfig.InfernalForge.cooldown, 0, 1000);
            toolConfig = new ToolConfig(builder, CMCommonConfig.InfernalForge.attackDamage, CMCommonConfig.InfernalForge.attackSpeed);
            builder.pop();
        }
        public final ModConfigSpec.IntValue InfernalForgeCooldown;
        public final ToolConfig toolConfig;
    }

    public static class VoidForge {
        VoidForge(final ModConfigSpec.Builder builder) {
            builder.push("void_forge");
            VoidForgeCooldown = builder.comment("Void Forge Cooldown")
                    .translation(LANG_PREFIX + "void_forge_cooldown")
                    .defineInRange("void_forge_cooldown",CMCommonConfig.VoidForge.cooldown, 0, 1000);
            VoidRuneDamage = builder.comment("Void Forge Rune Damage")
                    .translation(LANG_PREFIX + "void_forge_rune_damage")
                    .defineInRange("void_forge_rune_damage", CMCommonConfig.VoidForge.runeDamage, 0.0D, 1000000.0D);
            toolConfig = new ToolConfig(builder, CMCommonConfig.VoidForge.attackDamage, CMCommonConfig.VoidForge.attackSpeed);
            builder.pop();
        }
        public final ModConfigSpec.IntValue VoidForgeCooldown;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;
        public final ToolConfig toolConfig;
    }

    public static class MeatShredder {
        MeatShredder(final ModConfigSpec.Builder builder) {
            builder.push("meat_shredder");
            toolConfig = new ToolConfig(builder, CMCommonConfig.MeatShredder.attackDamage, CMCommonConfig.MeatShredder.attackSpeed);
            builder.pop();
        }
        public final ToolConfig toolConfig;
    }

    public static class Annihilator {
        Annihilator(final ModConfigSpec.Builder builder) {
            builder.push("annihilator");
            toolConfig = new ToolConfig(builder, CMCommonConfig.Annihilator.attackDamage, CMCommonConfig.Annihilator.attackSpeed);
            builder.pop();
        }
        public final ToolConfig toolConfig;
    }

    public static class WitherAssaultShoulderWeapon {
        WitherAssaultShoulderWeapon(final ModConfigSpec.Builder builder) {
            builder.push("wither_assault_shoulder_weapon");
            MissileCooldown = builder.comment("Missile Cooldown")
                    .translation(LANG_PREFIX + "missile_cooldown")
                    .defineInRange("missile_cooldown",CMCommonConfig.WASW.missileCooldown, 0, 1000);
            MissileDamage = builder.comment("Missile Damage")
                    .translation(LANG_PREFIX + "missile_damage")
                    .defineInRange("missile_damage",CMCommonConfig.WASW.missileDamage, 0.0D, 100000.0D);
            HowitzerCooldown = builder.comment("Howitzer Cooldown")
                    .translation(LANG_PREFIX + "howitzer_cooldown")
                    .defineInRange("howitzer_cooldown",CMCommonConfig.WASW.howitzerCooldown, 0, 1000);
            builder.pop();
        }
        public final ModConfigSpec.IntValue MissileCooldown;
        public final ModConfigSpec.DoubleValue MissileDamage;
        public final ModConfigSpec.IntValue HowitzerCooldown;
    }

    public static class VoidAssaultShoulderWeapon {
        VoidAssaultShoulderWeapon(final ModConfigSpec.Builder builder) {
            builder.push("void_assault_shoulder_weapon");
            HowitzerCooldown = builder.comment("Howitzer Cooldown")
                    .translation(LANG_PREFIX + "howitzer_cooldown")
                    .defineInRange("howitzer_cooldown",CMCommonConfig.VASW.howitzerCooldown, 0, 1000);
            VoidRuneDamage = builder.comment("VASW Rune Damage")
                    .translation(LANG_PREFIX + "vasw_rune_damage")
                    .defineInRange("vasw_rune_damage", CMCommonConfig.VASW.runeDamage, 0.0D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.IntValue HowitzerCooldown;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;
    }

    public static class VoidCore {
        VoidCore(final ModConfigSpec.Builder builder) {
            builder.push("void_core");
            VoidCoreCooldown = builder.comment("Cooldown")
                    .translation(LANG_PREFIX + "void_core_cooldown")
                    .defineInRange("void_core_cooldown",CMCommonConfig.VoidCore.cooldown, 0, 1000);
            VoidRuneDamage = builder.comment("Void Core Rune Damage")
                    .translation(LANG_PREFIX + "void_core_rune_damage")
                    .defineInRange("void_core_rune_damage", CMCommonConfig.VoidCore.runeDamage, 0.0D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.IntValue VoidCoreCooldown;
        public final ModConfigSpec.DoubleValue VoidRuneDamage;
    }

    public static class SandstormInABottle {
        SandstormInABottle(final ModConfigSpec.Builder builder) {
            builder.push("sandstorm");
            SandStormCooldown = builder.comment("Cooldown")
                    .translation(LANG_PREFIX + "sandstorm_cooldown")
                    .defineInRange("sandstorm_cooldown",CMCommonConfig.SandstormInABottle.cooldown, 0, 1000);
            builder.pop();
        }
        public final ModConfigSpec.IntValue SandStormCooldown;
    }

    public static class SoulRender {
        SoulRender(final ModConfigSpec.Builder builder) {
            builder.push("soul_render");
            SoulRenderCooldown = builder.comment("Soul Render Cooldown")
                    .translation(LANG_PREFIX + "soul_render_cooldown")
                    .defineInRange("soul_render_cooldown",CMCommonConfig.SoulRender.cooldown, 0, 1000);
            PhantomHalberddamage = builder.comment("Phantom Halberd Damage")
                    .translation(LANG_PREFIX + "phantom_halberd_damage")
                    .defineInRange("phantom_halberd_damage", CMCommonConfig.SoulRender.phantomHalberdDamage, 0.0D, 1000000.0D);
            toolConfig = new ToolConfig(builder, CMCommonConfig.SoulRender.attackDamage, CMCommonConfig.SoulRender.attackSpeed);
            builder.pop();
        }
        public final ToolConfig toolConfig;
        public final ModConfigSpec.IntValue SoulRenderCooldown;
        public final ModConfigSpec.DoubleValue PhantomHalberddamage;
    }

    public static class Immolator {
        Immolator(final ModConfigSpec.Builder builder) {
            builder.push("immolator");
            ImmolatorCooldown = builder.comment("Immolator Cooldown")
                    .translation(LANG_PREFIX + "immolator_cooldown")
                    .defineInRange("immolator_cooldown", CMCommonConfig.Immolator.cooldown, 0, 1000);
            toolConfig = new ToolConfig(builder, CMCommonConfig.Immolator.attackDamage, CMCommonConfig.Immolator.attackSpeed);
            builder.pop();
        }
        public final ToolConfig toolConfig;
        public final ModConfigSpec.IntValue ImmolatorCooldown;
    }

    public static class Ceraunus {
        Ceraunus(final ModConfigSpec.Builder builder) {
            builder.push("ceraunus");
            CeraunusWaveDamage = builder.comment("Ceraunus Wave Damage")
                    .translation(LANG_PREFIX + "ceraunus_wave_damage")
                    .defineInRange("ceraunus_wave_damage",CMCommonConfig.Ceraunus.waveDamage, 0.0D, 1000000.0D);
            CeraunusCooldown = builder.comment("Ceraunus Cooldown")
                    .translation(LANG_PREFIX + "ceraunus_cooldown")
                    .defineInRange("ceraunus_cooldown",CMCommonConfig.Ceraunus.cooldown, 0, 1000000);
            toolConfig = new ToolConfig(builder, CMCommonConfig.Ceraunus.attackDamage, CMCommonConfig.Ceraunus.attackSpeed);
            builder.pop();
        }
        public final ToolConfig toolConfig;
        public final ModConfigSpec.IntValue CeraunusCooldown;
        public final ModConfigSpec.DoubleValue CeraunusWaveDamage;
    }

    public static class TidalClaws {
        TidalClaws(final ModConfigSpec.Builder builder) {
            builder.push("tidal_claws");
            toolConfig = new ToolConfig(builder,CMCommonConfig.TidalClaws.attackDamage, CMCommonConfig.TidalClaws.attackSpeed);
            builder.pop();
        }
        public final ToolConfig toolConfig;
    }

    public static class Astrape {
        Astrape(final ModConfigSpec.Builder builder) {
            builder.push("astrape");
            AstrapeDamage = builder.comment("Astrape Damage")
                    .translation(LANG_PREFIX + "astrape_damage")
                    .defineInRange("astrape_damage",CMCommonConfig.Astrape.damage, 0.0D, 1000000.0D);
            AstrapeAreaDamage = builder.comment("Astrape Area Damage")
                    .translation(LANG_PREFIX + "astrape_area_damage")
                    .defineInRange("astrape_area_damage",CMCommonConfig.Astrape.areaDamage, 0.0D, 1000000.0D);
            AstrapeCooldown = builder.comment("Astrape Cooldown")
                    .translation(LANG_PREFIX + "astrape_cooldown")
                    .defineInRange("astrape_cooldown",CMCommonConfig.Astrape.cooldown, 0, 1000000);
            toolConfig = new ToolConfig(builder, CMCommonConfig.Astrape.attackDamage, CMCommonConfig.Astrape.attackSpeed);
            builder.pop();
        }
        public final ToolConfig toolConfig;
        public final ModConfigSpec.DoubleValue AstrapeDamage;
        public final ModConfigSpec.DoubleValue AstrapeAreaDamage;
        public final ModConfigSpec.IntValue AstrapeCooldown;
    }

    public static class CursedBow {
        CursedBow(final ModConfigSpec.Builder builder) {
            builder.push("cursed_bow");
            CursedBowDamage = builder.comment("Cursed Bow Damage")
                    .translation(LANG_PREFIX + "cursed_bow_damage")
                    .defineInRange("cursed_bow_damage",CMCommonConfig.CursedBow.damage, 0.0D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.DoubleValue CursedBowDamage;
    }

    public static class WrathOfTheDesert {
        WrathOfTheDesert(final ModConfigSpec.Builder builder) {
            builder.push("wrath_of_the_desert");
            WrathOfTheDesertDamage = builder.comment("Wrath Of The Desert Damage")
                    .translation(LANG_PREFIX + "wrath_of_the_desert_damage")
                    .defineInRange("wrath_of_the_desert_damage",CMCommonConfig.WrathOfTheDesert.damage, 0.0D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.DoubleValue WrathOfTheDesertDamage;
    }

    public static class LaserGatling {
        LaserGatling(final ModConfigSpec.Builder builder) {
            builder.push("laser_gatling");
            LaserDamage = builder.comment("Laser Damage")
                    .translation(LANG_PREFIX + "laser_damage")
                    .defineInRange("laser_damage",CMCommonConfig.LaserGatling.damage, 0.0D, 1000000.0D);
            builder.pop();
        }
        public final ModConfigSpec.DoubleValue LaserDamage;
    }

    // ==========================================
    // Grouping Classes
    // ==========================================

    public static class Mobs {
        Mobs(final ModConfigSpec.Builder builder) {
            builder.push("mobs");
            ETC = new ETC(builder);
            ENDERGUARDIAN = new EnderGuardian(builder);
            ENDERGOLEM = new EnderGolem(builder);
            NETHERITE_MONSTROSITY = new Netherite_Monstrosity(builder);
            NETHERITE_MINISTROSITY = new Netherite_Ministrosity(builder);
            IGNIS = new Ignis(builder);
            REVENANT = new Ignited_Revenant(builder);
            HARBINGER = new Harbinger(builder);
            PROWLER = new Prowler(builder);
            CRAB = new Amethyst_Crab(builder);
            LEVIATHAN = new Leviathan(builder);
            BABY_LEVIATHAN = new BabyLeviathan(builder);
            ANCIENT_REMNANT = new Ancient_Remnant(builder);
            MODERN_REMNANT = new ModernRemnant(builder);
            KOBOLETON = new Koboleton(builder);
            KOBOLEDIATOR = new Kobolediator(builder);
            WADJET = new Wadjet(builder);
            MALEDICTUS = new Maledictus(builder);
            APTRGANGR = new Aptrgangr(builder);
            SCYLLA = new Scylla(builder);
            CLAWDIAN = new Clawdian(builder);
            ONYX = new Onyx(builder);
            builder.pop();
        }
        public final ETC ETC;
        public final EnderGuardian ENDERGUARDIAN;
        public final Netherite_Monstrosity NETHERITE_MONSTROSITY;
        public final Netherite_Ministrosity NETHERITE_MINISTROSITY;
        public final EnderGolem ENDERGOLEM;
        public final Amethyst_Crab CRAB;
        public final Ignis IGNIS;
        public final Ignited_Revenant REVENANT;
        public final Harbinger HARBINGER;
        public final Prowler PROWLER;
        public final Leviathan LEVIATHAN;
        public final BabyLeviathan BABY_LEVIATHAN;
        public final Ancient_Remnant ANCIENT_REMNANT;
        public final ModernRemnant MODERN_REMNANT;
        public final Koboleton KOBOLETON;
        public final Kobolediator KOBOLEDIATOR;
        public final Wadjet WADJET;
        public final Maledictus MALEDICTUS;
        public final Aptrgangr APTRGANGR;
        public final Scylla SCYLLA;
        public final Clawdian CLAWDIAN;
        public final Onyx ONYX;
    }

    public static class Blocks {
        Blocks(final ModConfigSpec.Builder builder) {
            builder.push("blocks");
            CURSEDTOMBSTONE = new CursedTombstone(builder);
            builder.pop();
        }
        public final CursedTombstone CURSEDTOMBSTONE;
    }

    public static class ToolsAndAbilities {
        ToolsAndAbilities(final ModConfigSpec.Builder builder) {
            builder.push("tools_and_abilities");
            IGNITIUM_ARMOR = new IgnitiumArmor(builder);
            CURSIUM_ARMOR = new CursiumArmor(builder);
            BONE_REPTILE_ARMOR = new BoneReptileArmor(builder);
            BLOOM_STONE_ARMOR = new BloomStoneArmor(builder);
            INCINERATOR = new Incinerator(builder);
            BULWARK_OF_THE_FLAME = new BulwarkOfTheFlame(builder);
            GAUNTLER_OF_GUARD = new GauntletOfGuard(builder);
            GAUNTLET_OF_BULWARK = new GauntletOfBulwark(builder);
            GAUNTLER_OF_MAELSTROM = new GauntletOfMaelstrom(builder);
            INFERNAL_FORGE = new InfernalForge(builder);
            VOID_FORGE = new VoidForge(builder);
            WASW = new WitherAssaultShoulderWeapon(builder);
            VASW = new VoidAssaultShoulderWeapon(builder);
            VOID_CORE = new VoidCore(builder);
            SANDSTORM_IN_A_BOTTLE = new SandstormInABottle(builder);
            SOUL_RENDER = new SoulRender(builder);
            IMMOLATOR = new Immolator(builder);
            TIDAL_CLAW = new TidalClaws(builder);
            CERAUNUS = new Ceraunus(builder);
            ASTRAPE = new Astrape(builder);
            MEATH_SHREDDER = new MeatShredder(builder);
            ANNIHILATOR = new Annihilator(builder);
            CURSED_BOW = new CursedBow(builder);
            WRATH_OF_THE_DESERT = new WrathOfTheDesert(builder);
            LASER_GATLING = new LaserGatling(builder);
            builder.pop();
        }

        public final IgnitiumArmor IGNITIUM_ARMOR;
        public final CursiumArmor CURSIUM_ARMOR;
        public final BoneReptileArmor BONE_REPTILE_ARMOR;
        public final BloomStoneArmor BLOOM_STONE_ARMOR;
        public final Incinerator INCINERATOR;
        public final BulwarkOfTheFlame BULWARK_OF_THE_FLAME;
        public final GauntletOfGuard GAUNTLER_OF_GUARD;
        public final GauntletOfBulwark GAUNTLET_OF_BULWARK;
        public final GauntletOfMaelstrom GAUNTLER_OF_MAELSTROM;
        public final InfernalForge INFERNAL_FORGE;
        public final VoidForge VOID_FORGE;
        public final TidalClaws TIDAL_CLAW;
        public final MeatShredder MEATH_SHREDDER;
        public final WitherAssaultShoulderWeapon WASW;
        public final VoidAssaultShoulderWeapon VASW;
        public final VoidCore VOID_CORE;
        public final SandstormInABottle SANDSTORM_IN_A_BOTTLE;
        public final Annihilator ANNIHILATOR;
        public final SoulRender SOUL_RENDER;
        public final Immolator IMMOLATOR;
        public final Ceraunus CERAUNUS;
        public final Astrape ASTRAPE;
        public final CursedBow CURSED_BOW;
        public final WrathOfTheDesert WRATH_OF_THE_DESERT;
        public final LaserGatling LASER_GATLING;
    }
}