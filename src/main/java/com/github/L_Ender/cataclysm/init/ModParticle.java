package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.*;
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

    public static final RegistryObject<SimpleParticleType> SOUL_LAVA = PARTICLE.register("soul_lava", ()-> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SANDSTORM = PARTICLE.register("sandstorm", ()-> new SimpleParticleType(false));

    public static final RegistryObject<ParticleType<LightningParticle.OrbData>> LIGHTNING = PARTICLE.register("lightning", () -> new ParticleType<LightningParticle.OrbData>(false, LightningParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<LightningParticle.OrbData> codec() {
            return LightningParticle.OrbData.CODEC(LIGHTNING.get());
        }
    });

    public static final RegistryObject<ParticleType<StormParticle.OrbData>> STORM = PARTICLE.register("storm", () -> new ParticleType<StormParticle.OrbData>(false, StormParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<StormParticle.OrbData> codec() {
            return StormParticle.OrbData.CODEC(STORM.get());
        }
    });

    public static final RegistryObject<ParticleType<LightTrailParticle.OrbData>> LIGHT_TRAIL = PARTICLE.register("light_trail", () -> new ParticleType<LightTrailParticle.OrbData>(false, LightTrailParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<LightTrailParticle.OrbData> codec() {
            return LightTrailParticle.OrbData.CODEC(LIGHT_TRAIL.get());
        }
    });

    public static final RegistryObject<ParticleType<TrackLightningParticle.OrbData>> TRACK_LIGHTNING = PARTICLE.register("track_lightning", () -> new ParticleType<TrackLightningParticle.OrbData>(false, TrackLightningParticle.OrbData.DESERIALIZER) {
        @Override
        public Codec<TrackLightningParticle.OrbData> codec() {
            return TrackLightningParticle.OrbData.CODEC(TRACK_LIGHTNING.get());
        }
    });
    public static final RegistryObject<ParticleType<RingParticle.RingData>> RING = PARTICLE.register("ring_0", () -> new ParticleType<RingParticle.RingData>(false, RingParticle.RingData.DESERIALIZER) {
        @Override
        public Codec<RingParticle.RingData> codec() {
            return RingParticle.RingData.CODEC(RING.get());
        }
    });

    public static final RegistryObject<ParticleType<RoarParticle.RoarData>> ROAR = PARTICLE.register("roar", () -> new ParticleType<RoarParticle.RoarData>(false, RoarParticle.RoarData.DESERIALIZER) {
        @Override
        public Codec<RoarParticle.RoarData> codec() {
            return RoarParticle.RoarData.CODEC(ROAR.get());
        }
    });


    public static final RegistryObject<ParticleType<CircleLightningParticle.CircleData>> CIRCLE_LIGHTNING = PARTICLE.register("circle_lightning", () -> new ParticleType<CircleLightningParticle.CircleData>(false, CircleLightningParticle.CircleData.DESERIALIZER) {
        @Override
        public Codec<CircleLightningParticle.CircleData> codec() {
            return CircleLightningParticle.CircleData.CODEC(CIRCLE_LIGHTNING.get());
        }
    });


    public static final RegistryObject<ParticleType<Custom_Poof_Particle.PoofData>> CUSTOM_POOF = PARTICLE.register("custom_poof", () -> new ParticleType<Custom_Poof_Particle.PoofData>(false, Custom_Poof_Particle.PoofData.DESERIALIZER) {
        @Override
        public Codec<Custom_Poof_Particle.PoofData> codec() {
            return Custom_Poof_Particle.PoofData.CODEC(CUSTOM_POOF.get());
        }
    });

    public static final RegistryObject<ParticleType<Rain_Fog_Particle.FogData>> RAIN_FOG = PARTICLE.register("rain_fog", () -> new ParticleType<>(false, Rain_Fog_Particle.FogData.DESERIALIZER) {
        @Override
        public Codec<Rain_Fog_Particle.FogData> codec() {
            return Rain_Fog_Particle.FogData.CODEC(RAIN_FOG.get());
        }
    });

    public static final RegistryObject<ParticleType<Gathering_Water_Particle.GatheringData>> GATHERING_WATER = PARTICLE.register("gathering_water", () -> new ParticleType<Gathering_Water_Particle.GatheringData>(false, Gathering_Water_Particle.GatheringData.DESERIALIZER) {
        @Override
        public Codec<Gathering_Water_Particle.GatheringData> codec() {
            return Gathering_Water_Particle.GatheringData.CODEC(GATHERING_WATER.get());
        }
    });

    public static final RegistryObject<ParticleType<Lightning_Zap_Particle.ZapData>> LIGHTNING_ZAP = PARTICLE.register("lightning_zap", () -> new ParticleType<Lightning_Zap_Particle.ZapData>(false, Lightning_Zap_Particle.ZapData.DESERIALIZER) {
        @Override
        public Codec<Lightning_Zap_Particle.ZapData> codec() {
            return Lightning_Zap_Particle.ZapData.CODEC(LIGHTNING_ZAP.get());
        }
    });

    public static final RegistryObject<ParticleType<LightningStormParticle.StormData>> LIGHTNING_STORM = PARTICLE.register("lightning_storm", () -> new ParticleType<LightningStormParticle.StormData>(false, LightningStormParticle.StormData.DESERIALIZER) {
        @Override
        public Codec<LightningStormParticle.StormData> codec() {
            return LightningStormParticle.StormData.CODEC(LIGHTNING_STORM.get());
        }
    });


    public static final RegistryObject<ParticleType<Scylla_Swing_Particle.SwingData>> SCYLLA_SWING = PARTICLE.register("scylla_swing", () -> new ParticleType<Scylla_Swing_Particle.SwingData>(false, Scylla_Swing_Particle.SwingData.DESERIALIZER) {
        @Override
        public Codec<Scylla_Swing_Particle.SwingData> codec() {
            return Scylla_Swing_Particle.SwingData.CODEC(SCYLLA_SWING.get());
        }
    });


    public static final RegistryObject<ParticleType<SpinTrailParticle.SpinData>> SPIN_TRAIL_PARTICLE = PARTICLE.register("spin_trail", () -> new ParticleType<SpinTrailParticle.SpinData>(false, SpinTrailParticle.SpinData.DESERIALIZER) {
        @Override
        public Codec<SpinTrailParticle.SpinData> codec() {
            return SpinTrailParticle.SpinData.CODEC(SPIN_TRAIL_PARTICLE.get());
        }
    });


    public static final RegistryObject<ParticleType<SparkTrailParticle.SparkData>> SPARK_TRAIL = PARTICLE.register("spark_trail", () -> new ParticleType<SparkTrailParticle.SparkData>(false, SparkTrailParticle.SparkData.DESERIALIZER) {
        @Override
        public Codec<SparkTrailParticle.SparkData> codec() {
            return SparkTrailParticle.SparkData.CODEC(SPARK_TRAIL.get());
        }
    });


    public static final RegistryObject<ParticleType<BlockParticleOption>> DUST_PILLAR = PARTICLE.register("dust_pillar", () -> new ParticleType<BlockParticleOption>(false, BlockParticleOption.DESERIALIZER) {
        @Override
        public Codec<BlockParticleOption> codec() {
            return BlockParticleOption.codec(DUST_PILLAR.get());
        }
    });

    public static final RegistryObject<ParticleType<Not_Spin_TrailParticle.NSTData>> NOT_SPIN_PARTICLE = PARTICLE.register("not_spin_particle", () -> new ParticleType<Not_Spin_TrailParticle.NSTData>(false, Not_Spin_TrailParticle.NSTData.DESERIALIZER) {
        @Override
        public Codec<Not_Spin_TrailParticle.NSTData> codec() {
            return Not_Spin_TrailParticle.NSTData.CODEC(NOT_SPIN_PARTICLE.get());
        }
    });

    public static final RegistryObject<SimpleParticleType> SPARK = PARTICLE.register("spark", () -> new SimpleParticleType(false));



    public static final RegistryObject<SimpleParticleType> RAIN_CLOUD = PARTICLE.register("rain_cloud", () -> new SimpleParticleType(false));


    public static final RegistryObject<SimpleParticleType> CURSED_FLAME = PARTICLE.register("cursed_flame", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SMALL_CURSED_FLAME = PARTICLE.register("small_cursed_flame", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> PHANTOM_WING_FLAME = PARTICLE.register("phantom_wing_flame", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> EM_PULSE = PARTICLE.register("em_pulse", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SHOCK_WAVE = PARTICLE.register("shock_wave", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> TRAP_FLAME = PARTICLE.register("trap_flame", () -> new SimpleParticleType(false));


    public static final RegistryObject<SimpleParticleType> FLAME_JET = PARTICLE.register("flame_jet", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> FLARE_EXPLODE = PARTICLE.register("flare_explode", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> LIGHTNING_EXPLODE = PARTICLE.register("lightning_explode", () -> new SimpleParticleType(false));

}
