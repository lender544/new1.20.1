package com.github.L_Ender.cataclysm.util;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CMDamageTypes {
    public static final ResourceKey<DamageType> LASER = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"laser"));
    public static final ResourceKey<DamageType> DEATHLASER = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"deathlaser"));
    public static final ResourceKey<DamageType> EMP = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"emp"));
    public static final ResourceKey<DamageType> ABYSSAL_BURN = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"abyssal_burn"));
    public static final ResourceKey<DamageType> SHREDDER = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"shredder"));
    public static final ResourceKey<DamageType> SWORD_DANCE = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"sword_dance"));
    public static final ResourceKey<DamageType> MALEDICTIO = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictio"));
    public static final ResourceKey<DamageType> MALEDICTIO_SAGITTA = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictio_sagitta"));
    public static final ResourceKey<DamageType> MALEDICTIO_MAGICAE = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictio_magicae"));
    public static final ResourceKey<DamageType> PENETRATE = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"penetrate"));
    public static final ResourceKey<DamageType> MALEDICTIO_ANIMA = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"maledictio_anima"));
    public static final ResourceKey<DamageType> LIGHTNING = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"lightning"));
    public static final ResourceKey<DamageType> STORM_BRINGER = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"storm_bringer"));
    public static final ResourceKey<DamageType> FLAME_STRIKE = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"flame_strike"));


    public static DamageSource causeLaserDamage(Entity attacker, Entity caster) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LASER), attacker, caster);
    }

    public static DamageSource getDamageSource(Level level, ResourceKey<DamageType> type, EntityType<?>... toIgnore) {
        return getEntityDamageSource(level, type, null, toIgnore);
    }

    public static DamageSource getEntityDamageSource(Level level, ResourceKey<DamageType> type, @Nullable Entity attacker, EntityType<?>... toIgnore) {
        return getIndirectEntityDamageSource(level, type, attacker, attacker, toIgnore);
    }

    public static DamageSource getIndirectEntityDamageSource(Level level, ResourceKey<DamageType> type, @Nullable Entity attacker, @Nullable Entity indirectAttacker, EntityType<?>... toIgnore) {
        return toIgnore.length > 0 ? new EntityExcludedDamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type), toIgnore) : new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type), attacker, indirectAttacker);
    }

    public static DamageSource causeDeathLaserDamage(Entity attacker, LivingEntity caster) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(DEATHLASER), attacker, caster);
    }

    public static DamageSource causeShredderDamage(LivingEntity attacker) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(SHREDDER), attacker);
    }

    public static DamageSource causeSwordDanceDamage(LivingEntity attacker) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(SWORD_DANCE), attacker);
    }

    public static DamageSource causeMaledictioDamage(LivingEntity attacker) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(MALEDICTIO), attacker);
    }

    public static DamageSource causeMaledictioSoulDamage(LivingEntity attacker) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(MALEDICTIO_ANIMA), attacker);
    }

    public static DamageSource causeMaledictioSagittaDamage(Entity attacker, Entity caster) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(MALEDICTIO_SAGITTA), attacker,caster);
    }

    public static DamageSource causeMaledictioMagicaeDamage(Entity attacker, Entity caster) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(MALEDICTIO_MAGICAE), attacker,caster);
    }

    public static DamageSource causePenetrateDamage(LivingEntity attacker) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(PENETRATE), attacker);
    }

    public static DamageSource causeLightningDamage(Entity attacker, Entity caster) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LIGHTNING), attacker,caster);
    }

    public static DamageSource causeLightningMobDamage(LivingEntity attacker) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(LIGHTNING), attacker);
    }


    public static DamageSource causeStormBringerDamage(Entity attacker, Entity caster) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(STORM_BRINGER), attacker,caster);
    }
    public static DamageSource causeFlameStrikeDamage(Entity attacker, Entity caster) {
        return new DamageSource(attacker.level().registryAccess().registry(Registries.DAMAGE_TYPE).get().getHolderOrThrow(FLAME_STRIKE), attacker,caster);
    }
}
