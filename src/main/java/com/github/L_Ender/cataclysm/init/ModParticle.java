package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.Options.*;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModParticle {

    public static final DeferredRegister<ParticleType<?>> PARTICLE = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Cataclysm.MODID);

    public static final RegistryObject<SimpleParticleType> SPARK = PARTICLE.register("spark", ()-> new SimpleParticleType(false));


    public static final RegistryObject<SimpleParticleType> SOUL_LAVA = PARTICLE.register("soul_lava", ()-> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> RAIN_CLOUD = PARTICLE.register("rain_cloud", ()-> new SimpleParticleType(false));

    public static final RegistryObject<ParticleType<LightningParticleOptions>> LIGHTNING = PARTICLE.register("lightning", () -> new ParticleType<>(false,LightningParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<LightningParticleOptions> codec() {
            return LightningParticleOptions.CODEC;
        }

    });

    public static final RegistryObject<ParticleType<SparkTrailParticleOptions>> SPARK_TRAIL = PARTICLE.register("spark_trail", () -> new ParticleType<>(false,SparkTrailParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<SparkTrailParticleOptions> codec() {
            return SparkTrailParticleOptions.CODEC;
        }
    });


    public static final RegistryObject<ParticleType<StormParticleOptions>> STORM = PARTICLE.register("storm", () -> new ParticleType<>(false,StormParticleOptions.DESERIALIZER) {
        @Override
        public Codec<StormParticleOptions> codec() {
            return StormParticleOptions.CODEC;
        }
    });

    public static final RegistryObject<ParticleType<Rising_Trail_Options>> RISING_TRAIL = PARTICLE.register("rising_trail", () -> new ParticleType<>(false,Rising_Trail_Options.DESERIALIZER) {
        @Override
        public Codec<Rising_Trail_Options> codec() {
            return Rising_Trail_Options.CODEC;
        }
    });


    public static final RegistryObject<ParticleType<LightTrailParticleOptions>> LIGHT_TRAIL = PARTICLE.register("light_trail", () -> new ParticleType<>(false,LightTrailParticleOptions.DESERIALIZER) {
        @Override
        public Codec<LightTrailParticleOptions> codec() {
            return LightTrailParticleOptions.CODEC;
        }
    });


    public static final RegistryObject<ParticleType<TrackLightningParticleOptions>> TRACK_LIGHTNING = PARTICLE.register("track_lightning", () -> new ParticleType<>(false,TrackLightningParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<TrackLightningParticleOptions> codec() {
            return TrackLightningParticleOptions.CODEC;
        }
    });


    public static final RegistryObject<ParticleType<CircleLightningParticleOptions>> CIRCLE_LIGHTNING = PARTICLE.register("circle_lightning", () -> new ParticleType<>(false,CircleLightningParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<CircleLightningParticleOptions> codec() {
            return CircleLightningParticleOptions.CODEC;
        }
    });

    public static final RegistryObject<ParticleType<RingParticleOptions>> RING = PARTICLE.register("ring_0", () -> new ParticleType<>(false,RingParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<RingParticleOptions> codec() {
            return RingParticleOptions.CODEC;
        }
    });

    public static final RegistryObject<ParticleType<RoarParticleOptions>> ROAR = PARTICLE.register("roar", () -> new ParticleType<>(false,RoarParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<RoarParticleOptions> codec() {
            return RoarParticleOptions.CODEC;
        }
    });


    public static final RegistryObject<ParticleType<ParryParticleOptions>> PARRY = PARTICLE.register("parry", () -> new ParticleType<>(false,ParryParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<ParryParticleOptions> codec() {
            return ParryParticleOptions.CODEC;
        }
    });




    public static final RegistryObject<ParticleType<ScyllaSwingParticleOptions>> SCYLLA_SWING = PARTICLE.register("scylla_swing", () -> new ParticleType<>(false,ScyllaSwingParticleOptions.DESERIALIZER) {
        @Override
        public Codec<ScyllaSwingParticleOptions> codec() {
            return ScyllaSwingParticleOptions.CODEC;
        }
    });

    public static final RegistryObject<ParticleType<CustomPoofParticleOptions>> CUSTOM_POOF = PARTICLE.register("custom_poof", () -> new ParticleType<>(false,CustomPoofParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<CustomPoofParticleOptions> codec() {
            return CustomPoofParticleOptions.CODEC;
        }
    });

    public static final RegistryObject<ParticleType<LightningZapParticleOptions>> LIGHTNING_ZAP = PARTICLE.register("lightning_zap", () -> new ParticleType<>(false,LightningZapParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<LightningZapParticleOptions> codec() {
            return LightningZapParticleOptions.CODEC;
        }
    });


    public static final RegistryObject<ParticleType<LightningStormParticleOptions>> LIGHTNING_STORM = PARTICLE.register("lightning_storm", () -> new ParticleType<>(false,LightningStormParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<LightningStormParticleOptions> codec() {
            return LightningStormParticleOptions.CODEC;
        }
    });


    public static final RegistryObject<ParticleType<RainFogParticleOptions>> RAIN_FOG = PARTICLE.register("rain_fog", () -> new ParticleType<>(false,RainFogParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<RainFogParticleOptions> codec() {
            return RainFogParticleOptions.CODEC;
        }
    });

    public static final RegistryObject<ParticleType<GatheringWaterParticleOptions>> GATHERING_WATER = PARTICLE.register("gathering_water", () -> new ParticleType<>(false,GatheringWaterParticleOptions.DESERIALIZER) {
        @Override
        public Codec<GatheringWaterParticleOptions> codec() {
            return GatheringWaterParticleOptions.CODEC;
        }
    });

    public static final RegistryObject<ParticleType<SpinTrailParticleOptions>> SPIN_TRAIL_PARTICLE = PARTICLE.register("spin_trail", () -> new ParticleType<>(false,SpinTrailParticleOptions.DESERIALIZER) {
        @Override
        public Codec<SpinTrailParticleOptions> codec() {
            return SpinTrailParticleOptions.CODEC;
        }
    });

    public static final RegistryObject<ParticleType<NotSpinTrailParticleOptions>> NOT_SPIN_PARTICLE = PARTICLE.register("not_spin_particle", () -> new ParticleType<>(false,NotSpinTrailParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<NotSpinTrailParticleOptions> codec() {
            return NotSpinTrailParticleOptions.CODEC;
        }
    });


    public static final RegistryObject<SimpleParticleType> CURSED_FLAME = PARTICLE.register("cursed_flame", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SMALL_CURSED_FLAME = PARTICLE.register("small_cursed_flame", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> PHANTOM_WING_FLAME = PARTICLE.register("phantom_wing_flame", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> EM_PULSE = PARTICLE.register("em_pulse", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SHOCK_WAVE = PARTICLE.register("shock_wave", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> TRAP_FLAME = PARTICLE.register("trap_flame", () -> new SimpleParticleType(false));


    public static final RegistryObject<SimpleParticleType> FLAME_JET = PARTICLE.register("flame_jet", () -> new SimpleParticleType(false));


    public static final RegistryObject<SimpleParticleType> FLARE_EXPLODE = PARTICLE.register("flare_explode", () -> new SimpleParticleType(false));


    public static final RegistryObject<SimpleParticleType> LIGHTNING_EXPLODE = PARTICLE.register("lightning_explode", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> IGNIS_EXPLODE = PARTICLE.register("ignis_explode", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> IGNIS_ABYSS_EXPLODE = PARTICLE.register("ignis_abyss_explode", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> IGNIS_SOUL_EXPLODE = PARTICLE.register("ignis_soul_explode", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DESERT_GLYPH = PARTICLE.register("desert_glyph", () -> new SimpleParticleType(false));


    public static final RegistryObject<SimpleParticleType> DUST_BLAST = PARTICLE.register("dust_blast", ()-> new SimpleParticleType(false));

    public static final RegistryObject<ParticleType<BlockParticleOption>> DUST_PILLAR = PARTICLE.register("dust_pillar", () -> new ParticleType<BlockParticleOption>(false, BlockParticleOption.DESERIALIZER) {
        @Override
        public Codec<BlockParticleOption> codec() {
            return BlockParticleOption.codec(DUST_PILLAR.get());
        }
    });


    public static final RegistryObject<SimpleParticleType> PHANTOM_EMITTER = PARTICLE.register("phantom_emitter", () -> new SimpleParticleType(false));


    public static final RegistryObject<SimpleParticleType> AMETHYST_CRASH = PARTICLE.register("amethyst_crash", () -> new SimpleParticleType(false));

    public static final RegistryObject<ParticleType<Cursed_MarkParticleOption>> CURSED_MARK = PARTICLE.register("cursed_mark", () -> new ParticleType<>(false,Cursed_MarkParticleOption.DESERIALIZER)  {
        @Override
        public Codec<Cursed_MarkParticleOption> codec() {
            return Cursed_MarkParticleOption.CODEC;
        }

    });

    public static final RegistryObject<SimpleParticleType> CURSED_ALGIZ = PARTICLE.register("cursed_algiz", () -> new SimpleParticleType(false));


    public static final RegistryObject<ParticleType<AfterImageParticleOptions>> AFTER_IMAGE = PARTICLE.register("after_image", () -> new ParticleType<>(false,AfterImageParticleOptions.DESERIALIZER)  {
        @Override
        public Codec<AfterImageParticleOptions> codec() {
            return AfterImageParticleOptions.CODEC;
        }

    });

}
