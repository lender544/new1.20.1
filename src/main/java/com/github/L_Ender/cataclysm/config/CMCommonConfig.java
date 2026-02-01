package com.github.L_Ender.cataclysm.config;

import com.github.L_Ender.cataclysm.Cataclysm;


public class CMCommonConfig {

    public static class EnderGuardian {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 22.0D;
        public static double dpsCap = 13.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 12.0D;
        public static double natureHeal = 25.0D;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;

        public static double GravityPunchHpdamage = 0.05D;
        public static double TeleportAttackHpdamage = 0.05D;
        public static double KnockbackHpdamage = 0.06D;
        public static double UppercutHpdamage = 0.1D;
        public static double RocketPunchHpdamage = 0.1D;
        public static double AreaAttackHpdamage = 0.08D;
        public static int BlockBreakingX = 15;
        public static int BlockBreakingY = 2;
        public static int BlockBreakingZ = 15;
        public static double VoidRuneDamage = 9.0D;
        public static boolean SeparatePhaseMusic = true;
    }

    public static class EnderGolem {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 999999.0D;
        public static double dpsCap = 999999.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 8.0D;
        public static double natureHeal = 25.0D;
        public static boolean ignoreMobGriefing = false;
        public static double VoidRuneDamage = 7.0D;
    }

    public static class NetheriteMonstrosity {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 25.0D;
        public static double dpsCap = 20.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 18.0D;
        public static double natureHeal = 25.0D;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;

        public static int Lavabombmagazine = 15;
        public static int Lavabombamount = 3;
        public static int LavabombDuration = 350;
        public static int LavabombRandomDuration = 150;
        public static boolean BodyCollided = true;
        public static double SmashHpdamage = 0.08D;
        public static double FlameJetDamage = 7.0D;
        public static double FlareBombDamage = 10.0D;
    }

    public static class NetheriteMinistrosity {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
    }

    public static class Ignis {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 20.0D;
        public static double dpsCap = 14.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 15.0D;
        public static double natureHeal = 25.0D;
        public static boolean ignoreMobGriefing = true;

        public static double HealingMultiplier = 1.0D;
        public static boolean SeparatePhaseMusic = true;
    }

    public static class IgnitedRevenant {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double AshenbreathDamage = 4.0D;
        public static double BlazingBoneDamage = 5.0D;
    }

    public static class Harbinger {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 22.0D;
        public static double dpsCap = 14.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 35.0D;
        public static double natureHeal = 25.0D;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;

        public static double AutoHeal = 2.0D;
        public static double LifeSteal = 5.0D;
        public static double WitherMissiledamage = 8.0D;
        public static double Laserdamage = 5.0D;
        public static double DeathLaserdamage = 5.0D;
        public static double DeathLaserHpdamage = 0.05D;
        public static double ChargeHpDamage = 0.06D;
    }

    public static class Prowler {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double rangeCap = 15.0D;
        public static double HomingMissiledamage = 5.0D;
        public static double DeathLaserdamage = 5.0D;
        public static double DeathLaserHpdamage = 0.05D;
    }

    public static class Leviathan {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 20.0D;
        public static double dpsCap = 15.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 38.0D;
        public static double natureHeal = 25.0D;
        public static boolean ignoreMobGriefing = true;

        public static double BiteHpDamage = 0.1D;
        public static double RushHpDamage = 0.05D;
        public static double TailSwingHpDamage = 0.06D;
        public static double TentacleHpDamage = 0.06D;
        public static double DimensionalRiftDamage = 10.0D;
        public static double AbyssBlastDamage = 10.0D;
        public static double AbyssBlastHpDamage = 0.1D;
        public static double AbyssOrbdamage = 4.0D;
        public static boolean ImmuneOutofWater = true;
        public static boolean SeparatePhaseMusic = true;
    }

    public static class BabyLeviathan {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
    }

    public static class AmethystCrab {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double EarthQuakeDamage = 5.0D;
        public static double AmethystClusterDamage = 12.0D;
    }

    public static class AncientRemnant {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 21.0D;
        public static double dpsCap = 14.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 14.0D;
        public static double natureHeal = 25.0D;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;

        public static double ChargeHpDamage = 0.1D;
        public static double HpDamage = 0.05D;
        public static double StompHpDamage = 0.03D;
        public static double EarthQuakeDamage = 11.0D;
        public static double AncientDesertSteledamage = 11.0D;
    }

    public static class ModernRemnant {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
    }

    public static class Koboleton {
        public static double CauseKoboletontoDropItemInHandPercent = 5.0D;
    }

    public static class Kobolediator {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static boolean ignoreMobGriefing = false;
    }

    public static class Wadjet {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double Sandstorm_damage = 6.0D;
        public static double AncientDesertSteledamage = 11.0D;
    }

    public static class Scylla {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 21.0D;
        public static double dpsCap = 13.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 12.0D;
        public static double natureHeal = 25.0D;
        public static boolean respawner = true;
        public static boolean ignoreMobGriefing = true;

        public static double SpearDamage = 14.0D;
        public static double LightningStormDamage = 10.0D;
        public static double LightningAreaDamage = 4.0D;
        public static double SnakeDamage = 16.0D;
        public static double AnchorDamage = 16.0D;
        public static boolean WeatherChange = true;
        public static double HpDamage = 0.05D;
        public static double SpinHpDamage = 0.07D;
        public static double StormHpDamage = 0.04D;
    }

    public static class Clawdian {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 21.0D;
        public static double dpsCap = 12.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 12.0D;
        public static double natureHeal = 25.0D;
        public static boolean ignoreMobGriefing = false;
    }

    public static class Maledictus {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double damageCap = 20.0D;
        public static double dpsCap = 13.0D;
        public static int dpsLimitTime = 20;
        public static double rangeCap = 14.0D;
        public static double natureHeal = 25.0D;
        public static boolean ignoreMobGriefing = true;

        public static double PhantomHalberdDamage = 11.0D;
        public static double HpDamage = 0.05D;
        public static double ShockWaveHpDamage = 0.03D;
        public static double AOEHpDamage = 0.15D;
        public static double FlyingSmashHpDamage = 0.1D;
        public static double SmashHpDamage = 0.08D;
        public static double PhantomArrowDamage = 5.0D;
    }

    public static class Aptrgangr {
        public static double healthMultiplier = 1.0D;
        public static double attackMultiplier = 1.0D;
        public static double natureHeal = 25.0D;
        public static double AxeBladeDamage = 8.0D;
    }


    public static class ETC {
        public static int ReturnHome = 20;
    }

    // ==========================================
    // Block Configurations
    // ==========================================

    public static class Blocks {
        public static int CursedTombstoneCooldown = 1;
    }

    // ==========================================
    // Spawning Configurations
    // ==========================================

    public static class Spawning {
        public static int DeeplingSpawnWeight = 2;
        public static int DeeplingSpawnRolls = 30;
        public static int DeeplingBruteSpawnWeight = 1;
        public static int DeeplingBruteSpawnRolls = 50;
        public static int DeeplingAnglerSpawnWeight = 2;
        public static int DeeplingAnglerSpawnRolls = 30;
        public static int DeeplingPriestSpawnWeight = 1;
        public static int DeeplingPriestSpawnRolls = 70;
        public static int DeeplingWarlockSpawnWeight = 1;
        public static int DeeplingWarlockSpawnRolls = 70;
        public static int CoralgolemSpawnWeight = 1;
        public static int CoralgolemSpawnRolls = 70;
        public static int AmethystCrabSpawnWeight = 1;
        public static int AmethystCrabSpawnRolls = 20;
        public static int KoboletonSpawnWeight = 15;
        public static int KoboletonSpawnRolls = 1;
        public static int IgnitedBerserkerSpawnWeight = 7;
        public static int IgnitedBerserkerSpawnRolls = 2;
    }

    // ==========================================
    // Tools & Abilities Configurations
    // ==========================================

    public static class IgnitiumArmor {
        public static double armorMultiplier = 1.0D;
        public static double toughness = 4.0D;
        public static double knockbackResistance = 0.15D;
    }

    public static class CursiumArmor {
        public static double armorMultiplier = 1.0D;
        public static double toughness = 4.0D;
        public static double knockbackResistance = 0.05D;
    }

    public static class BoneReptileArmor {
        public static double armorMultiplier = 1.0D;
        public static double toughness = 2.5D;
        public static double knockbackResistance = 0.15D;
    }

    public static class BloomStoneArmor {
        public static double armorMultiplier = 1.0D;
        public static double toughness = 2.0D;
        public static double knockbackResistance = 0.1D;
    }

    public static class Incinerator {
        public static double attackDamage = 14.0D;
        public static double attackSpeed = 1.4D;
        public static int cooldown = 400;
    }

    public static class BulwarkOfTheFlame {
        public static int cooldown = 80;
    }

    public static class GauntletOfGuard {
        public static double attackDamage = 11.0D;
        public static double attackSpeed = 1.6D;
    }

    public static class GauntletOfBulwark {
        public static double attackDamage = 11.0D;
        public static double attackSpeed = 1.6D;
        public static int cooldown = 80;
    }

    public static class GauntletOfMaelstrom {
        public static double attackDamage = 11.0D;
        public static double attackSpeed = 1.6D;
        public static int cooldown = 180;
    }

    public static class InfernalForge {
        public static double attackDamage = 13.0D;
        public static double attackSpeed = 1.0D;
        public static int cooldown = 80;
    }

    public static class VoidForge {
        public static double attackDamage = 13.0D;
        public static double attackSpeed = 1.0D;
        public static int cooldown = 100;
        public static double runeDamage = 7.0D;
    }

    public static class Brontes {
        public static double attackDamage = 13.0D;
        public static double attackSpeed = 1.0D;
        public static double stormareadamage = 1.0D;
        public static double stormdamage = 10.0D;
    }


    public static class MeatShredder {
        public static double attackDamage = 8.5D;
        public static double attackSpeed = 1.4D;
    }

    public static class Annihilator {
        public static double attackDamage = 8.5D;
        public static double attackSpeed = 1.6D;
    }

    public static class WASW {
        public static int missileCooldown = 40;
        public static double missileDamage = 16.0D;
        public static int howitzerCooldown = 100;
    }

    public static class VASW {
        public static int howitzerCooldown = 160;
        public static double runeDamage = 7.0D;
    }

    public static class VoidCore {
        public static int cooldown = 160;
        public static double runeDamage = 7.0D;
    }

    public static class SandstormInABottle {
        public static int cooldown = 300;
    }

    public static class SoulRender {
        public static double attackDamage = 15.0D;
        public static double attackSpeed = 1.05D;
        public static int cooldown = 100;
        public static double phantomHalberdDamage = 12.0D;
    }

    public static class Immolator {
        public static double attackDamage = 8.5D;
        public static double attackSpeed = 1.6D;
        public static int cooldown = 250;
    }

    public static class Ceraunus {
        public static double attackDamage = 16.0D;
        public static double attackSpeed = 0.7D;
        public static int cooldown = 150;
        public static double waveDamage = 6.0D;
    }

    public static class TidalClaws {
        public static double attackDamage = 8.0D;
        public static double attackSpeed = 1.6D;
    }

    public static class Astrape {
        public static double attackDamage = 10.5D;
        public static double attackSpeed = 1.4D;
        public static double damage = 11.0D;
        public static double areaDamage = 2.0D;
        public static int cooldown = 60;
    }

    public static class CursedBow {
        public static double damage = 8.0D;
    }

    public static class WrathOfTheDesert {
        public static double damage = 7.5D;
    }

    public static class LaserGatling {
        public static double damage = 7.0D;
    }

    public static class AncientSpear {
        public static double attackDamage = 9.5D;
        public static double attackSpeed = 1.4D;
        public static double sandstormdamage = 6D;
    }


    public static void Commonbake(CommonConfig config) {
        try {
            // Mobs - EnderGuardian
            EnderGuardian.healthMultiplier = config.MOBS.ENDERGUARDIAN.combatConfig.healthMultiplier.get();
            EnderGuardian.attackMultiplier = config.MOBS.ENDERGUARDIAN.combatConfig.attackMultiplier.get();
            EnderGuardian.damageCap = config.MOBS.ENDERGUARDIAN.capConfig.damageCap.get();
            EnderGuardian.dpsCap = config.MOBS.ENDERGUARDIAN.capConfig.dpsCap.get();
            EnderGuardian.dpsLimitTime = config.MOBS.ENDERGUARDIAN.capConfig.dpslimittime.get();
            EnderGuardian.rangeCap = config.MOBS.ENDERGUARDIAN.capConfig.rangeCap.get();
            EnderGuardian.natureHeal = config.MOBS.ENDERGUARDIAN.healConfig.heal.get();
            EnderGuardian.respawner = config.MOBS.ENDERGUARDIAN.respawnerConfig.Respawner.get();
            EnderGuardian.ignoreMobGriefing = config.MOBS.ENDERGUARDIAN.mobGriefingConfig.Ignore.get();
            EnderGuardian.GravityPunchHpdamage = config.MOBS.ENDERGUARDIAN.GravityPunchHpdamage.get();
            EnderGuardian.TeleportAttackHpdamage = config.MOBS.ENDERGUARDIAN.TeleportAttackHpdamage.get();
            EnderGuardian.KnockbackHpdamage = config.MOBS.ENDERGUARDIAN.KnockbackHpdamage.get();
            EnderGuardian.UppercutHpdamage = config.MOBS.ENDERGUARDIAN.UppercutHpdamage.get();
            EnderGuardian.RocketPunchHpdamage = config.MOBS.ENDERGUARDIAN.RocketPunchHpdamage.get();
            EnderGuardian.AreaAttackHpdamage = config.MOBS.ENDERGUARDIAN.AreaAttackHpdamage.get();
            EnderGuardian.BlockBreakingX = config.MOBS.ENDERGUARDIAN.BlockBreakingX.get();
            EnderGuardian.BlockBreakingY = config.MOBS.ENDERGUARDIAN.BlockBreakingY.get();
            EnderGuardian.BlockBreakingZ = config.MOBS.ENDERGUARDIAN.BlockBreakingZ.get();
            EnderGuardian.VoidRuneDamage = config.MOBS.ENDERGUARDIAN.VoidRuneDamage.get();
            EnderGuardian.SeparatePhaseMusic = config.MOBS.ENDERGUARDIAN.SeparatePhaseMusic.get();

            // Mobs - EnderGolem
            EnderGolem.healthMultiplier = config.MOBS.ENDERGOLEM.combatConfig.healthMultiplier.get();
            EnderGolem.attackMultiplier = config.MOBS.ENDERGOLEM.combatConfig.attackMultiplier.get();
            EnderGolem.damageCap = config.MOBS.ENDERGOLEM.capConfig.damageCap.get();
            EnderGolem.dpsCap = config.MOBS.ENDERGOLEM.capConfig.dpsCap.get();
            EnderGolem.dpsLimitTime = config.MOBS.ENDERGOLEM.capConfig.dpslimittime.get();
            EnderGolem.rangeCap = config.MOBS.ENDERGOLEM.capConfig.rangeCap.get();
            EnderGolem.natureHeal = config.MOBS.ENDERGOLEM.healConfig.heal.get();
            EnderGolem.ignoreMobGriefing = config.MOBS.ENDERGOLEM.mobGriefingConfig.Ignore.get();
            EnderGolem.VoidRuneDamage = config.MOBS.ENDERGOLEM.VoidRuneDamage.get();

            // Mobs - Netherite Monstrosity
            NetheriteMonstrosity.healthMultiplier = config.MOBS.NETHERITE_MONSTROSITY.combatConfig.healthMultiplier.get();
            NetheriteMonstrosity.attackMultiplier = config.MOBS.NETHERITE_MONSTROSITY.combatConfig.attackMultiplier.get();
            NetheriteMonstrosity.damageCap = config.MOBS.NETHERITE_MONSTROSITY.capConfig.damageCap.get();
            NetheriteMonstrosity.dpsCap = config.MOBS.NETHERITE_MONSTROSITY.capConfig.dpsCap.get();
            NetheriteMonstrosity.dpsLimitTime = config.MOBS.NETHERITE_MONSTROSITY.capConfig.dpslimittime.get();
            NetheriteMonstrosity.rangeCap = config.MOBS.NETHERITE_MONSTROSITY.capConfig.rangeCap.get();
            NetheriteMonstrosity.natureHeal = config.MOBS.NETHERITE_MONSTROSITY.healConfig.heal.get();
            NetheriteMonstrosity.respawner = config.MOBS.NETHERITE_MONSTROSITY.respawnerConfig.Respawner.get();
            NetheriteMonstrosity.ignoreMobGriefing = config.MOBS.NETHERITE_MONSTROSITY.mobGriefingConfig.Ignore.get();
            NetheriteMonstrosity.Lavabombmagazine = config.MOBS.NETHERITE_MONSTROSITY.Lavabombmagazine.get();
            NetheriteMonstrosity.Lavabombamount = config.MOBS.NETHERITE_MONSTROSITY.Lavabombamount.get();
            NetheriteMonstrosity.LavabombDuration = config.MOBS.NETHERITE_MONSTROSITY.LavabombDuration.get();
            NetheriteMonstrosity.LavabombRandomDuration = config.MOBS.NETHERITE_MONSTROSITY.LavabombRandomDuration.get();
            NetheriteMonstrosity.BodyCollided = config.MOBS.NETHERITE_MONSTROSITY.BodyCollided.get();
            NetheriteMonstrosity.SmashHpdamage = config.MOBS.NETHERITE_MONSTROSITY.SmashHpdamage.get();
            NetheriteMonstrosity.FlameJetDamage = config.MOBS.NETHERITE_MONSTROSITY.FlameJetDamage.get();
            NetheriteMonstrosity.FlareBombDamage = config.MOBS.NETHERITE_MONSTROSITY.FlareBombDamage.get();

            // Mobs - Netherite Ministrosity
            NetheriteMinistrosity.healthMultiplier = config.MOBS.NETHERITE_MINISTROSITY.combatConfig.healthMultiplier.get();
            NetheriteMinistrosity.attackMultiplier = config.MOBS.NETHERITE_MINISTROSITY.combatConfig.attackMultiplier.get();

            // Mobs - Ignis
            Ignis.healthMultiplier = config.MOBS.IGNIS.combatConfig.healthMultiplier.get();
            Ignis.attackMultiplier = config.MOBS.IGNIS.combatConfig.attackMultiplier.get();
            Ignis.damageCap = config.MOBS.IGNIS.capConfig.damageCap.get();
            Ignis.dpsCap = config.MOBS.IGNIS.capConfig.dpsCap.get();
            Ignis.dpsLimitTime = config.MOBS.IGNIS.capConfig.dpslimittime.get();
            Ignis.rangeCap = config.MOBS.IGNIS.capConfig.rangeCap.get();
            Ignis.natureHeal = config.MOBS.IGNIS.healConfig.heal.get();
            Ignis.ignoreMobGriefing = config.MOBS.IGNIS.mobGriefingConfig.Ignore.get();
            Ignis.HealingMultiplier = config.MOBS.IGNIS.HealingMultiplier.get();
            Ignis.SeparatePhaseMusic = config.MOBS.IGNIS.SeparatePhaseMusic.get();

            // Mobs - Ignited Revenant
            IgnitedRevenant.healthMultiplier = config.MOBS.REVENANT.combatConfig.healthMultiplier.get();
            IgnitedRevenant.attackMultiplier = config.MOBS.REVENANT.combatConfig.attackMultiplier.get();
            IgnitedRevenant.AshenbreathDamage = config.MOBS.REVENANT.AshenbreathDamage.get();
            IgnitedRevenant.BlazingBoneDamage = config.MOBS.REVENANT.BlazingBoneDamage.get();

            // Mobs - Harbinger
            Harbinger.healthMultiplier = config.MOBS.HARBINGER.combatConfig.healthMultiplier.get();
            Harbinger.attackMultiplier = config.MOBS.HARBINGER.combatConfig.attackMultiplier.get();
            Harbinger.damageCap = config.MOBS.HARBINGER.capConfig.damageCap.get();
            Harbinger.dpsCap = config.MOBS.HARBINGER.capConfig.dpsCap.get();
            Harbinger.dpsLimitTime = config.MOBS.HARBINGER.capConfig.dpslimittime.get();
            Harbinger.rangeCap = config.MOBS.HARBINGER.capConfig.rangeCap.get();
            Harbinger.natureHeal = config.MOBS.HARBINGER.healConfig.heal.get();
            Harbinger.respawner = config.MOBS.HARBINGER.respawnerConfig.Respawner.get();
            Harbinger.ignoreMobGriefing = config.MOBS.HARBINGER.mobGriefingConfig.Ignore.get();
            Harbinger.AutoHeal = config.MOBS.HARBINGER.AutoHeal.get();
            Harbinger.LifeSteal = config.MOBS.HARBINGER.LifeSteal.get();
            Harbinger.WitherMissiledamage = config.MOBS.HARBINGER.WitherMissiledamage.get();
            Harbinger.Laserdamage = config.MOBS.HARBINGER.Laserdamage.get();
            Harbinger.DeathLaserdamage = config.MOBS.HARBINGER.DeathLaserdamage.get();
            Harbinger.DeathLaserHpdamage = config.MOBS.HARBINGER.DeathLaserHpdamage.get();
            Harbinger.ChargeHpDamage = config.MOBS.HARBINGER.ChargeHpDamage.get();

            // Mobs - Prowler
            Prowler.healthMultiplier = config.MOBS.PROWLER.combatConfig.healthMultiplier.get();
            Prowler.attackMultiplier = config.MOBS.PROWLER.combatConfig.attackMultiplier.get();
            Prowler.rangeCap = config.MOBS.PROWLER.rangeCap.get();
            Prowler.HomingMissiledamage = config.MOBS.PROWLER.HomingMissiledamage.get();
            Prowler.DeathLaserdamage = config.MOBS.PROWLER.DeathLaserdamage.get();
            Prowler.DeathLaserHpdamage = config.MOBS.PROWLER.DeathLaserHpdamage.get();

            // Mobs - Leviathan
            Leviathan.healthMultiplier = config.MOBS.LEVIATHAN.combatConfig.healthMultiplier.get();
            Leviathan.attackMultiplier = config.MOBS.LEVIATHAN.combatConfig.attackMultiplier.get();
            Leviathan.damageCap = config.MOBS.LEVIATHAN.capConfig.damageCap.get();
            Leviathan.dpsCap = config.MOBS.LEVIATHAN.capConfig.dpsCap.get();
            Leviathan.dpsLimitTime = config.MOBS.LEVIATHAN.capConfig.dpslimittime.get();
            Leviathan.rangeCap = config.MOBS.LEVIATHAN.capConfig.rangeCap.get();
            Leviathan.natureHeal = config.MOBS.LEVIATHAN.healConfig.heal.get();
            Leviathan.ignoreMobGriefing = config.MOBS.LEVIATHAN.mobGriefingConfig.Ignore.get();
            Leviathan.BiteHpDamage = config.MOBS.LEVIATHAN.BiteHpDamage.get();
            Leviathan.RushHpDamage = config.MOBS.LEVIATHAN.RushHpDamage.get();
            Leviathan.TailSwingHpDamage = config.MOBS.LEVIATHAN.TailSwingHpDamage.get();
            Leviathan.TentacleHpDamage = config.MOBS.LEVIATHAN.TentacleHpDamage.get();
            Leviathan.DimensionalRiftDamage = config.MOBS.LEVIATHAN.DimensionalRiftDamage.get();
            Leviathan.AbyssBlastDamage = config.MOBS.LEVIATHAN.AbyssBlastDamage.get();
            Leviathan.AbyssBlastHpDamage = config.MOBS.LEVIATHAN.AbyssBlastHpDamage.get();
            Leviathan.AbyssOrbdamage = config.MOBS.LEVIATHAN.AbyssOrbdamage.get();
            Leviathan.ImmuneOutofWater = config.MOBS.LEVIATHAN.ImmuneOutofWater.get();
            Leviathan.SeparatePhaseMusic = config.MOBS.LEVIATHAN.SeparatePhaseMusic.get();

            // Mobs - Baby Leviathan
            BabyLeviathan.healthMultiplier = config.MOBS.BABY_LEVIATHAN.combatConfig.healthMultiplier.get();
            BabyLeviathan.attackMultiplier = config.MOBS.BABY_LEVIATHAN.combatConfig.attackMultiplier.get();

            // Mobs - Amethyst Crab
            AmethystCrab.healthMultiplier = config.MOBS.CRAB.combatConfig.healthMultiplier.get();
            AmethystCrab.attackMultiplier = config.MOBS.CRAB.combatConfig.attackMultiplier.get();
            AmethystCrab.EarthQuakeDamage = config.MOBS.CRAB.EarthQuakeDamage.get();
            AmethystCrab.AmethystClusterDamage = config.MOBS.CRAB.AmethystClusterDamage.get();

            // Mobs - Ancient Remnant
            AncientRemnant.healthMultiplier = config.MOBS.ANCIENT_REMNANT.combatConfig.healthMultiplier.get();
            AncientRemnant.attackMultiplier = config.MOBS.ANCIENT_REMNANT.combatConfig.attackMultiplier.get();
            AncientRemnant.damageCap = config.MOBS.ANCIENT_REMNANT.capConfig.damageCap.get();
            AncientRemnant.dpsCap = config.MOBS.ANCIENT_REMNANT.capConfig.dpsCap.get();
            AncientRemnant.dpsLimitTime = config.MOBS.ANCIENT_REMNANT.capConfig.dpslimittime.get();
            AncientRemnant.rangeCap = config.MOBS.ANCIENT_REMNANT.capConfig.rangeCap.get();
            AncientRemnant.natureHeal = config.MOBS.ANCIENT_REMNANT.healConfig.heal.get();
            AncientRemnant.respawner = config.MOBS.ANCIENT_REMNANT.respawnerConfig.Respawner.get();
            AncientRemnant.ignoreMobGriefing = config.MOBS.ANCIENT_REMNANT.mobGriefingConfig.Ignore.get();
            AncientRemnant.ChargeHpDamage = config.MOBS.ANCIENT_REMNANT.ChargeHpDamage.get();
            AncientRemnant.HpDamage = config.MOBS.ANCIENT_REMNANT.HpDamage.get();
            AncientRemnant.StompHpDamage = config.MOBS.ANCIENT_REMNANT.StompHpDamage.get();
            AncientRemnant.EarthQuakeDamage = config.MOBS.ANCIENT_REMNANT.EarthQuakeDamage.get();
            AncientRemnant.AncientDesertSteledamage = config.MOBS.ANCIENT_REMNANT.AncientDesertSteledamage.get();

            // Mobs - Modern Remnant
            ModernRemnant.healthMultiplier = config.MOBS.MODERN_REMNANT.combatConfig.healthMultiplier.get();
            ModernRemnant.attackMultiplier = config.MOBS.MODERN_REMNANT.combatConfig.attackMultiplier.get();

            // Mobs - Koboleton
            Koboleton.CauseKoboletontoDropItemInHandPercent = config.MOBS.KOBOLETON.CauseKoboletontoDropItemInHandPercent.get();

            // Mobs - Kobolediator
            Kobolediator.healthMultiplier = config.MOBS.KOBOLEDIATOR.combatConfig.healthMultiplier.get();
            Kobolediator.attackMultiplier = config.MOBS.KOBOLEDIATOR.combatConfig.attackMultiplier.get();
            Kobolediator.ignoreMobGriefing = config.MOBS.KOBOLEDIATOR.mobGriefingConfig.Ignore.get();

            // Mobs - Wadjet
            Wadjet.healthMultiplier = config.MOBS.WADJET.combatConfig.healthMultiplier.get();
            Wadjet.attackMultiplier = config.MOBS.WADJET.combatConfig.attackMultiplier.get();
            Wadjet.Sandstorm_damage = config.MOBS.WADJET.Sandstorm_damage.get();
            Wadjet.AncientDesertSteledamage = config.MOBS.WADJET.AncientDesertSteledamage.get();

            // Mobs - Scylla
            Scylla.healthMultiplier = config.MOBS.SCYLLA.combatConfig.healthMultiplier.get();
            Scylla.attackMultiplier = config.MOBS.SCYLLA.combatConfig.attackMultiplier.get();
            Scylla.damageCap = config.MOBS.SCYLLA.capConfig.damageCap.get();
            Scylla.dpsCap = config.MOBS.SCYLLA.capConfig.dpsCap.get();
            Scylla.dpsLimitTime = config.MOBS.SCYLLA.capConfig.dpslimittime.get();
            Scylla.rangeCap = config.MOBS.SCYLLA.capConfig.rangeCap.get();
            Scylla.natureHeal = config.MOBS.SCYLLA.healConfig.heal.get();
            Scylla.respawner = config.MOBS.SCYLLA.respawnerConfig.Respawner.get();
            Scylla.ignoreMobGriefing = config.MOBS.SCYLLA.mobGriefingConfig.Ignore.get();
            Scylla.SpearDamage = config.MOBS.SCYLLA.SpearDamage.get();
            Scylla.LightningStormDamage = config.MOBS.SCYLLA.LightningStormDamage.get();
            Scylla.LightningAreaDamage = config.MOBS.SCYLLA.LightningAreaDamage.get();
            Scylla.SnakeDamage = config.MOBS.SCYLLA.SnakeDamage.get();
            Scylla.AnchorDamage = config.MOBS.SCYLLA.AnchorDamage.get();
            Scylla.WeatherChange = config.MOBS.SCYLLA.WeatherChange.get();
            Scylla.HpDamage = config.MOBS.SCYLLA.HpDamage.get();
            Scylla.SpinHpDamage = config.MOBS.SCYLLA.SpinHpDamage.get();
            Scylla.StormHpDamage = config.MOBS.SCYLLA.StormHpDamage.get();

            // Mobs - Clawdian
            Clawdian.healthMultiplier = config.MOBS.CLAWDIAN.combatConfig.healthMultiplier.get();
            Clawdian.attackMultiplier = config.MOBS.CLAWDIAN.combatConfig.attackMultiplier.get();
            Clawdian.damageCap = config.MOBS.CLAWDIAN.capConfig.damageCap.get();
            Clawdian.dpsCap = config.MOBS.CLAWDIAN.capConfig.dpsCap.get();
            Clawdian.dpsLimitTime = config.MOBS.CLAWDIAN.capConfig.dpslimittime.get();
            Clawdian.rangeCap = config.MOBS.CLAWDIAN.capConfig.rangeCap.get();
            Clawdian.natureHeal = config.MOBS.CLAWDIAN.healConfig.heal.get();
            Clawdian.ignoreMobGriefing = config.MOBS.CLAWDIAN.mobGriefingConfig.Ignore.get();

            // Mobs - Maledictus
            Maledictus.healthMultiplier = config.MOBS.MALEDICTUS.combatConfig.healthMultiplier.get();
            Maledictus.attackMultiplier = config.MOBS.MALEDICTUS.combatConfig.attackMultiplier.get();
            Maledictus.damageCap = config.MOBS.MALEDICTUS.capConfig.damageCap.get();
            Maledictus.dpsCap = config.MOBS.MALEDICTUS.capConfig.dpsCap.get();
            Maledictus.dpsLimitTime = config.MOBS.MALEDICTUS.capConfig.dpslimittime.get();
            Maledictus.rangeCap = config.MOBS.MALEDICTUS.capConfig.rangeCap.get();
            Maledictus.natureHeal = config.MOBS.MALEDICTUS.healConfig.heal.get();
            Maledictus.ignoreMobGriefing = config.MOBS.MALEDICTUS.mobGriefingConfig.Ignore.get();
            Maledictus.PhantomHalberdDamage = config.MOBS.MALEDICTUS.PhantomHalberdDamage.get();
            Maledictus.HpDamage = config.MOBS.MALEDICTUS.HpDamage.get();
            Maledictus.ShockWaveHpDamage = config.MOBS.MALEDICTUS.ShockWaveHpDamage.get();
            Maledictus.AOEHpDamage = config.MOBS.MALEDICTUS.AOEHpDamage.get();
            Maledictus.FlyingSmashHpDamage = config.MOBS.MALEDICTUS.FlyingSmashHpDamage.get();
            Maledictus.SmashHpDamage = config.MOBS.MALEDICTUS.SmashHpDamage.get();
            Maledictus.PhantomArrowDamage = config.MOBS.MALEDICTUS.PhantomArrowDamage.get();

            // Mobs - Aptrgangr
            Aptrgangr.healthMultiplier = config.MOBS.APTRGANGR.combatConfig.healthMultiplier.get();
            Aptrgangr.attackMultiplier = config.MOBS.APTRGANGR.combatConfig.attackMultiplier.get();
            Aptrgangr.natureHeal = config.MOBS.APTRGANGR.healConfig.heal.get();
            Aptrgangr.AxeBladeDamage = config.MOBS.APTRGANGR.AxeBladeDamage.get();


            // Mobs - ETC
            ETC.ReturnHome = config.MOBS.ETC.ReturnHome.get();


            // Spawning
            Spawning.DeeplingSpawnWeight = config.SPAWNING.DeeplingSpawnWeight.get();
            Spawning.DeeplingSpawnRolls = config.SPAWNING.DeeplingSpawnRolls.get();
            Spawning.DeeplingBruteSpawnWeight = config.SPAWNING.DeeplingBruteSpawnWeight.get();
            Spawning.DeeplingBruteSpawnRolls = config.SPAWNING.DeeplingBruteSpawnRolls.get();
            Spawning.DeeplingAnglerSpawnWeight = config.SPAWNING.DeeplingAnglerSpawnWeight.get();
            Spawning.DeeplingAnglerSpawnRolls = config.SPAWNING.DeeplingAnglerSpawnRolls.get();
            Spawning.DeeplingPriestSpawnWeight = config.SPAWNING.DeeplingPriestSpawnWeight.get();
            Spawning.DeeplingPriestSpawnRolls = config.SPAWNING.DeeplingPriestSpawnRolls.get();
            Spawning.DeeplingWarlockSpawnWeight = config.SPAWNING.DeeplingWarlockSpawnWeight.get();
            Spawning.DeeplingWarlockSpawnRolls = config.SPAWNING.DeeplingWarlockSpawnRolls.get();
            Spawning.CoralgolemSpawnWeight = config.SPAWNING.CoralgolemSpawnWeight.get();
            Spawning.CoralgolemSpawnRolls = config.SPAWNING.CoralgolemSpawnRolls.get();
            Spawning.AmethystCrabSpawnWeight = config.SPAWNING.AmethystCrabSpawnWeight.get();
            Spawning.AmethystCrabSpawnRolls = config.SPAWNING.AmethystCrabSpawnRolls.get();
            Spawning.KoboletonSpawnWeight = config.SPAWNING.KoboletonSpawnWeight.get();
            Spawning.KoboletonSpawnRolls = config.SPAWNING.KoboletonSpawnRolls.get();
            Spawning.IgnitedBerserkerSpawnWeight = config.SPAWNING.IgnitedBerserkerSpawnWeight.get();
            Spawning.IgnitedBerserkerSpawnRolls = config.SPAWNING.IgnitedBerserkerSpawnRolls.get();


            // Tools - Armor
            IgnitiumArmor.armorMultiplier = config.TOOLS_AND_ABILITIES.IGNITIUM_ARMOR.armorConfig.armormultiplier.get();
            IgnitiumArmor.toughness = config.TOOLS_AND_ABILITIES.IGNITIUM_ARMOR.armorConfig.toughness.get();
            IgnitiumArmor.knockbackResistance = config.TOOLS_AND_ABILITIES.IGNITIUM_ARMOR.armorConfig.knockbackRes.get();

            CursiumArmor.armorMultiplier = config.TOOLS_AND_ABILITIES.CURSIUM_ARMOR.armorConfig.armormultiplier.get();
            CursiumArmor.toughness = config.TOOLS_AND_ABILITIES.CURSIUM_ARMOR.armorConfig.toughness.get();
            CursiumArmor.knockbackResistance = config.TOOLS_AND_ABILITIES.CURSIUM_ARMOR.armorConfig.knockbackRes.get();

            BoneReptileArmor.armorMultiplier = config.TOOLS_AND_ABILITIES.BONE_REPTILE_ARMOR.armorConfig.armormultiplier.get();
            BoneReptileArmor.toughness = config.TOOLS_AND_ABILITIES.BONE_REPTILE_ARMOR.armorConfig.toughness.get();
            BoneReptileArmor.knockbackResistance = config.TOOLS_AND_ABILITIES.BONE_REPTILE_ARMOR.armorConfig.knockbackRes.get();

            BloomStoneArmor.armorMultiplier = config.TOOLS_AND_ABILITIES.BLOOM_STONE_ARMOR.armorConfig.armormultiplier.get();
            BloomStoneArmor.toughness = config.TOOLS_AND_ABILITIES.BLOOM_STONE_ARMOR.armorConfig.toughness.get();
            BloomStoneArmor.knockbackResistance = config.TOOLS_AND_ABILITIES.BLOOM_STONE_ARMOR.armorConfig.knockbackRes.get();


            // Tools - Weapons & Abilities
            Incinerator.attackDamage = config.TOOLS_AND_ABILITIES.INCINERATOR.toolConfig.attackDamage.get();
            Incinerator.attackSpeed = config.TOOLS_AND_ABILITIES.INCINERATOR.toolConfig.attackSpeed.get();
            Incinerator.cooldown = config.TOOLS_AND_ABILITIES.INCINERATOR.IncineratorCooldown.get();

            BulwarkOfTheFlame.cooldown = config.TOOLS_AND_ABILITIES.BULWARK_OF_THE_FLAME.BulwarkOfTheFlameCooldown.get();

            GauntletOfGuard.attackDamage = config.TOOLS_AND_ABILITIES.GAUNTLER_OF_GUARD.toolConfig.attackDamage.get();
            GauntletOfGuard.attackSpeed = config.TOOLS_AND_ABILITIES.GAUNTLER_OF_GUARD.toolConfig.attackSpeed.get();

            GauntletOfBulwark.attackDamage = config.TOOLS_AND_ABILITIES.GAUNTLET_OF_BULWARK.toolConfig.attackDamage.get();
            GauntletOfBulwark.attackSpeed = config.TOOLS_AND_ABILITIES.GAUNTLET_OF_BULWARK.toolConfig.attackSpeed.get();
            GauntletOfBulwark.cooldown = config.TOOLS_AND_ABILITIES.GAUNTLET_OF_BULWARK.GauntletOfBulwarkCooldown.get();

            GauntletOfMaelstrom.attackDamage = config.TOOLS_AND_ABILITIES.GAUNTLER_OF_MAELSTROM.toolConfig.attackDamage.get();
            GauntletOfMaelstrom.attackSpeed = config.TOOLS_AND_ABILITIES.GAUNTLER_OF_MAELSTROM.toolConfig.attackSpeed.get();
            GauntletOfMaelstrom.cooldown = config.TOOLS_AND_ABILITIES.GAUNTLER_OF_MAELSTROM.GauntletOfMaelstromCooldown.get();

            InfernalForge.attackDamage = config.TOOLS_AND_ABILITIES.INFERNAL_FORGE.toolConfig.attackDamage.get();
            InfernalForge.attackSpeed = config.TOOLS_AND_ABILITIES.INFERNAL_FORGE.toolConfig.attackSpeed.get();
            InfernalForge.cooldown = config.TOOLS_AND_ABILITIES.INFERNAL_FORGE.InfernalForgeCooldown.get();

            VoidForge.attackDamage = config.TOOLS_AND_ABILITIES.VOID_FORGE.toolConfig.attackDamage.get();
            VoidForge.attackSpeed = config.TOOLS_AND_ABILITIES.VOID_FORGE.toolConfig.attackSpeed.get();
            VoidForge.cooldown = config.TOOLS_AND_ABILITIES.VOID_FORGE.VoidForgeCooldown.get();
            VoidForge.runeDamage = config.TOOLS_AND_ABILITIES.VOID_FORGE.VoidRuneDamage.get();


            Brontes.attackDamage = config.TOOLS_AND_ABILITIES.BRONTES.toolConfig.attackDamage.get();
            Brontes.attackSpeed = config.TOOLS_AND_ABILITIES.BRONTES.toolConfig.attackSpeed.get();
            Brontes.stormareadamage = config.TOOLS_AND_ABILITIES.BRONTES.StormAreaDamage.get();
            Brontes.stormdamage = config.TOOLS_AND_ABILITIES.BRONTES.StormDamage.get();

            MeatShredder.attackDamage = config.TOOLS_AND_ABILITIES.MEATH_SHREDDER.toolConfig.attackDamage.get();
            MeatShredder.attackSpeed = config.TOOLS_AND_ABILITIES.MEATH_SHREDDER.toolConfig.attackSpeed.get();

            Annihilator.attackDamage = config.TOOLS_AND_ABILITIES.ANNIHILATOR.toolConfig.attackDamage.get();
            Annihilator.attackSpeed = config.TOOLS_AND_ABILITIES.ANNIHILATOR.toolConfig.attackSpeed.get();

            WASW.missileCooldown = config.TOOLS_AND_ABILITIES.WASW.MissileCooldown.get();
            WASW.missileDamage = config.TOOLS_AND_ABILITIES.WASW.MissileDamage.get();
            WASW.howitzerCooldown = config.TOOLS_AND_ABILITIES.WASW.HowitzerCooldown.get();

            VASW.howitzerCooldown = config.TOOLS_AND_ABILITIES.VASW.HowitzerCooldown.get();
            VASW.runeDamage = config.TOOLS_AND_ABILITIES.VASW.VoidRuneDamage.get();

            VoidCore.cooldown = config.TOOLS_AND_ABILITIES.VOID_CORE.VoidCoreCooldown.get();
            VoidCore.runeDamage = config.TOOLS_AND_ABILITIES.VOID_CORE.VoidRuneDamage.get();

            SandstormInABottle.cooldown = config.TOOLS_AND_ABILITIES.SANDSTORM_IN_A_BOTTLE.SandStormCooldown.get();

            SoulRender.attackDamage = config.TOOLS_AND_ABILITIES.SOUL_RENDER.toolConfig.attackDamage.get();
            SoulRender.attackSpeed = config.TOOLS_AND_ABILITIES.SOUL_RENDER.toolConfig.attackSpeed.get();
            SoulRender.cooldown = config.TOOLS_AND_ABILITIES.SOUL_RENDER.SoulRenderCooldown.get();
            SoulRender.phantomHalberdDamage = config.TOOLS_AND_ABILITIES.SOUL_RENDER.PhantomHalberddamage.get();

            Immolator.attackDamage = config.TOOLS_AND_ABILITIES.IMMOLATOR.toolConfig.attackDamage.get();
            Immolator.attackSpeed = config.TOOLS_AND_ABILITIES.IMMOLATOR.toolConfig.attackSpeed.get();
            Immolator.cooldown = config.TOOLS_AND_ABILITIES.IMMOLATOR.ImmolatorCooldown.get();

            Ceraunus.attackDamage = config.TOOLS_AND_ABILITIES.CERAUNUS.toolConfig.attackDamage.get();
            Ceraunus.attackSpeed = config.TOOLS_AND_ABILITIES.CERAUNUS.toolConfig.attackSpeed.get();
            Ceraunus.cooldown = config.TOOLS_AND_ABILITIES.CERAUNUS.CeraunusCooldown.get();
            Ceraunus.waveDamage = config.TOOLS_AND_ABILITIES.CERAUNUS.CeraunusWaveDamage.get();

            TidalClaws.attackDamage = config.TOOLS_AND_ABILITIES.TIDAL_CLAW.toolConfig.attackDamage.get();
            TidalClaws.attackSpeed = config.TOOLS_AND_ABILITIES.TIDAL_CLAW.toolConfig.attackSpeed.get();

            Astrape.attackDamage = config.TOOLS_AND_ABILITIES.ASTRAPE.toolConfig.attackDamage.get();
            Astrape.attackSpeed = config.TOOLS_AND_ABILITIES.ASTRAPE.toolConfig.attackSpeed.get();
            Astrape.damage = config.TOOLS_AND_ABILITIES.ASTRAPE.AstrapeDamage.get();
            Astrape.areaDamage = config.TOOLS_AND_ABILITIES.ASTRAPE.AstrapeAreaDamage.get();
            Astrape.cooldown = config.TOOLS_AND_ABILITIES.ASTRAPE.AstrapeCooldown.get();

            CursedBow.damage = config.TOOLS_AND_ABILITIES.CURSED_BOW.CursedBowDamage.get();

            WrathOfTheDesert.damage = config.TOOLS_AND_ABILITIES.WRATH_OF_THE_DESERT.WrathOfTheDesertDamage.get();

            LaserGatling.damage = config.TOOLS_AND_ABILITIES.LASER_GATLING.LaserDamage.get();

            AncientSpear.attackDamage = config.TOOLS_AND_ABILITIES.ANCIENTSPEAR.toolConfig.attackDamage.get();
            AncientSpear.attackSpeed = config.TOOLS_AND_ABILITIES.ANCIENTSPEAR.toolConfig.attackSpeed.get();
            AncientSpear.sandstormdamage = config.TOOLS_AND_ABILITIES.ANCIENTSPEAR.SandstormDamage.get();

            // Blocks
            Blocks.CursedTombstoneCooldown = config.BLOCKS.CURSEDTOMBSTONE.CursedTombstoneCooldown.get();


        } catch (Exception e) {
            Cataclysm.LOGGER.warn("An exception was caused trying to load the Common config for CM");
            e.printStackTrace();
        }
    }
}