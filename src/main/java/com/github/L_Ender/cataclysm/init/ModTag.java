package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.util.LazyTagLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.registries.ForgeRegistries;


public class ModTag {

    public static final TagKey<Block> NETHERITE_MONSTROSITY_IMMUNE = registerBlockTag("netherite_monstrosity_immune");

    public static final TagKey<EntityType<?>> TRAP_BLOCK_NOT_DETECTED = registerEntityTag("trap_block_not_detected");


    public static final TagKey<EntityType<?>> SANDSTONE_TRAP_NOT_DETECTED = registerEntityTag("sandstone_trap_not_detected");

    public static final TagKey<EntityType<?>> IGNIS_CANT_POKE = registerEntityTag("ignis_cant_poke");

    public static final TagKey<EntityType<?>> LAVA_MONSTER = registerEntityTag("lava_monster");


    public static final TagKey<EntityType<?>> LEVIATHAN_TARGET = registerEntityTag("leviathan_target");

    public static final TagKey<EntityType<?>> BABY_LEVIATHAN_TARGET = registerEntityTag("baby_leviathan_target");

    public static final TagKey<EntityType<?>> ANCIENT_REMNANT_TARGET = registerEntityTag("ancient_remnant_target");

    public static final TagKey<EntityType<?>> MODERN_REMNANT_TARGET = registerEntityTag("modern_remnant_target");

    public static final TagKey<EntityType<?>> TEAM_ANCIENT_REMNANT = registerEntityTag("team_ancient_remnant");

    public static final TagKey<EntityType<?>> TEAM_ENDER_GUARDIAN = registerEntityTag("team_ender_guardian");

    public static final TagKey<EntityType<?>> TEAM_IGNIS = registerEntityTag("team_ignis");

    public static final TagKey<EntityType<?>> TEAM_MONSTROSITY = registerEntityTag("team_monstrosity");

    public static final TagKey<EntityType<?>> TEAM_THE_HARBINGER = registerEntityTag("team_the_harbinger");

    public static final TagKey<EntityType<?>> TEAM_THE_LEVIATHAN = registerEntityTag("team_the_leviathan");

    public static final TagKey<EntityType<?>> TEAM_SCYLLA = registerEntityTag("team_scylla");

    public static final TagKey<DamageType> BYPASSES_HURT_TIME = registerDamageTypeTag("bypasses_hurt_time");

    public static final TagKey<EntityType<?>> DIMENSIONAL_LIFT_IMMUNE = registerEntityTag("dimensional_lift_immune");

    public static final TagKey<EntityType<?>> TEAM_MALEDICTUS = registerEntityTag("team_maledictus");

    public static final TagKey<Block> ENDER_GOLEM_CAN_DESTROY = registerBlockTag("ender_golem_can_destroy");

    public static final TagKey<Block> CM_GLASS = registerBlockTag("cm_glass");

    public static final TagKey<Block> ENDER_GUARDIAN_CAN_DESTROY = registerBlockTag("ender_guardian_can_destroy");

    public static final TagKey<Block> ALTAR_DESTROY_IMMUNE = registerBlockTag("altar_destroy_immune");

    public static final TagKey<Block> IGNIS_CAN_DESTROY_CRACKED_BLOCK = registerBlockTag("ignis_can_destroy_cracked_block");

    public static final TagKey<Block> IGNIS_IMMUNE = registerBlockTag("ignis_immune");

    public static final TagKey<Block> HARBINGER_IMMUNE = registerBlockTag("harbinger_immune");

    public static final TagKey<Block> LEVIATHAN_IMMUNE = registerBlockTag("leviathan_immune");

    public static final TagKey<Block> REMNANT_IMMUNE = registerBlockTag("remnant_immune");

    public static final TagKey<Block> MALEDICTUS_IMMUNE = registerBlockTag("maledictus_immune");

    public static final TagKey<Block> SCYLLA_IMMUNE = registerBlockTag("scylla_immune");

    public static final TagKey<Block> FROSTED_PRISON_CHANDELIER = registerBlockTag("frosted_prison_chandelier");

    public static final TagKey<Block> CORALSSUS_BREAK = registerBlockTag("coralssus_break");

    public static final TagKey<Block> ENDERMAPTERA_CAN_NOT_SPAWN = registerBlockTag("endermaptera_can_not_spawn");

    public static final TagKey<Block> NETHERITE_MONSTROSITY_BREAK = registerBlockTag("netherite_monstrosity_break");

    public static final TagKey<Block> SUNKEN_CITY_MATERIAL = registerBlockTag("sunken_city_material");

    public static final TagKey<Structure> EYE_OF_MECH_LOCATED = registerStructureTag("eye_of_mech_located");

    public static final TagKey<Structure> EYE_OF_RUINED_LOCATED = registerStructureTag("eye_of_ruined_located");

    public static final TagKey<Structure> EYE_OF_FLAME_LOCATED = registerStructureTag("eye_of_flame_located");

    public static final TagKey<Structure> EYE_OF_CURSE_LOCATED = registerStructureTag("eye_of_curse_located");

    public static final TagKey<Structure> EYE_OF_MONSTROUS_LOCATED = registerStructureTag("eye_of_monstrous_located");

    public static final TagKey<Structure> EYE_OF_ABYSS_LOCATED = registerStructureTag("eye_of_abyss_located");

    public static final TagKey<Structure> EYE_OF_DESERT_LOCATED = registerStructureTag("eye_of_desert_located");

    public static final TagKey<Structure> BLOCKED_BASALT = registerStructureTag("blocked_basalt");

    public static final TagKey<Structure> BLOCKED_LAKE = registerStructureTag("blocked_lake");

    public static final TagKey<Structure> BLOCKED_GEODE = registerStructureTag("blocked_geode");

    public static final TagKey<Structure> BLOCKED_ORE = registerStructureTag("blocked_ore");

    public static final TagKey<Structure> BLOCKED_MULTIFACE = registerStructureTag("blocked_multiface");

    public static final TagKey<Structure> BLOCKED_MAGMA_BLOCK = registerStructureTag("blocked_magma_block");

    public static final TagKey<Structure> BERSERKER_SPAWN = registerStructureTag("berserker_spawn");

    public static final TagKey<Item> EXPLOSION_IMMUNE_ITEM = registerItemTag("explosion_immune_item");

    public static final TagKey<Item> STICKY_ITEM = registerItemTag("sticky_item");

    public static final TagKey<Item> BONE_ITEM = registerItemTag("bone_item");

    public static final TagKey<Item> MINISTROSITY_BLACKLIST = registerItemTag("ministrosity_blacklist");

    public static final TagKey<MobEffect> EFFECTIVE_FOR_BOSSES = registerEffectTag("effective_for_bosses");

    public static final LazyTagLookup<MobEffect> EFFECTIVE_FOR_BOSSES_LOOKUP = LazyTagLookup.create(ForgeRegistries.MOB_EFFECTS, EFFECTIVE_FOR_BOSSES);

    public static final TagKey<Biome> REQUIRED_SUNKEN_CITY_SURROUNDING = registerBiomeTag("required_sunken_city_surrounding");

    private static TagKey<EntityType<?>> registerEntityTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(Cataclysm.MODID, name));
    }

    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(Cataclysm.MODID, name));
    }

    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(Cataclysm.MODID, name));
    }

    private static TagKey<MobEffect> registerEffectTag(String name) {
        return TagKey.create(Registries.MOB_EFFECT, new ResourceLocation(Cataclysm.MODID, name));
    }

    private static TagKey<Structure> registerStructureTag(String name) {
        return TagKey.create(Registries.STRUCTURE, new ResourceLocation(Cataclysm.MODID, name));
    }

    private static TagKey<Biome> registerBiomeTag(String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(Cataclysm.MODID, name));
    }
    private static TagKey<DamageType> registerDamageTypeTag(String name) {
        return TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Cataclysm.MODID, name));
    }


    public static <T> boolean isInTag(T value, TagKey<T> tagKey) {
        // noinspection unchecked
        Registry<T> registry = (Registry<T>) BuiltInRegistries.REGISTRY.get(tagKey.registry().location());
        // noinspection ConstantConditions
        return registry.getOrCreateTag(tagKey).contains(registry.getHolderOrThrow(registry.getResourceKey(value).orElseThrow()));
    }
}
