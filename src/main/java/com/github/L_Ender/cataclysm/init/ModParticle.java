package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.Options.*;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModParticle {

    public static final DeferredRegister<ParticleType<?>> PARTICLE = DeferredRegister.create(Registries.PARTICLE_TYPE, Cataclysm.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPARK = PARTICLE.register("spark", ()-> new SimpleParticleType(false));


    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SOUL_LAVA = PARTICLE.register("soul_lava", ()-> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RAIN_CLOUD = PARTICLE.register("rain_cloud", ()-> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, ParticleType<LightningParticleOptions>> LIGHTNING = PARTICLE.register("lightning", () -> new ParticleType<>(false)  {
        @Override
        public MapCodec<LightningParticleOptions> codec() {
            return LightningParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, LightningParticleOptions> streamCodec() {
            return LightningParticleOptions.STREAM_CODEC;
        }
    });

    public static final DeferredHolder<ParticleType<?>, ParticleType<SparkTrailParticleOptions>> SPARK_TRAIL = PARTICLE.register("spark_trail", () -> new ParticleType<>(false)  {
        @Override
        public MapCodec<SparkTrailParticleOptions> codec() {
            return SparkTrailParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, SparkTrailParticleOptions> streamCodec() {
            return SparkTrailParticleOptions.STREAM_CODEC;
        }
    });


    public static final DeferredHolder<ParticleType<?>, ParticleType<StormParticleOptions>> STORM = PARTICLE.register("storm", () -> new ParticleType<>(false) {
        @Override
        public MapCodec<StormParticleOptions> codec() {
            return StormParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, StormParticleOptions> streamCodec() {
            return StormParticleOptions.STREAM_CODEC;
        }
    });


    public static final DeferredHolder<ParticleType<?>, ParticleType<LightTrailParticleOptions>> LIGHT_TRAIL = PARTICLE.register("light_trail", () -> new ParticleType<>(false) {
        @Override
        public MapCodec<LightTrailParticleOptions> codec() {
            return LightTrailParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, LightTrailParticleOptions> streamCodec() {
            return LightTrailParticleOptions.STREAM_CODEC;
        }
    });


    public static final DeferredHolder<ParticleType<?>, ParticleType<TrackLightningParticleOptions>> TRACK_LIGHTNING = PARTICLE.register("track_lightning", () -> new ParticleType<>(false)  {
        @Override
        public MapCodec<TrackLightningParticleOptions> codec() {
            return TrackLightningParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, TrackLightningParticleOptions> streamCodec() {
            return TrackLightningParticleOptions.STREAM_CODEC;
        }
    });

    public static final DeferredHolder<ParticleType<?>, ParticleType<CircleLightningParticleOptions>> CIRCLE_LIGHTNING = PARTICLE.register("circle_lightning", () -> new ParticleType<>(false)  {
        @Override
        public MapCodec<CircleLightningParticleOptions> codec() {
            return CircleLightningParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, CircleLightningParticleOptions> streamCodec() {
            return CircleLightningParticleOptions.STREAM_CODEC;
        }
    });

    public static final DeferredHolder<ParticleType<?>, ParticleType<RingParticleOptions>> RING = PARTICLE.register("ring_0", () -> new ParticleType<>(false)  {
        @Override
        public MapCodec<RingParticleOptions> codec() {
            return RingParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, RingParticleOptions> streamCodec() {
            return RingParticleOptions.STREAM_CODEC;
        }
    });


    public static final DeferredHolder<ParticleType<?>, ParticleType<ScyllaSwingParticleOptions>> SCYLLA_SWING = PARTICLE.register("scylla_swing", () -> new ParticleType<>(false) {
        @Override
        public MapCodec<ScyllaSwingParticleOptions> codec() {
            return ScyllaSwingParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, ScyllaSwingParticleOptions> streamCodec() {
            return ScyllaSwingParticleOptions.STREAM_CODEC;
        }
    });

    public static final DeferredHolder<ParticleType<?>, ParticleType<CustomPoofParticleOptions>> CUSTOM_POOF = PARTICLE.register("custom_poof", () -> new ParticleType<>(false)  {
        @Override
        public MapCodec<CustomPoofParticleOptions> codec() {
            return CustomPoofParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, CustomPoofParticleOptions> streamCodec() {
            return CustomPoofParticleOptions.STREAM_CODEC;
        }
    });

    public static final DeferredHolder<ParticleType<?>, ParticleType<LightningZapParticleOptions>> LIGHTNING_ZAP = PARTICLE.register("lightning_zap", () -> new ParticleType<>(false)  {
        @Override
        public MapCodec<LightningZapParticleOptions> codec() {
            return LightningZapParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, LightningZapParticleOptions> streamCodec() {
            return LightningZapParticleOptions.STREAM_CODEC;
        }
    });


    public static final DeferredHolder<ParticleType<?>, ParticleType<LightningStormParticleOptions>> LIGHTNING_STORM = PARTICLE.register("lightning_storm", () -> new ParticleType<>(false)  {
        @Override
        public MapCodec<LightningStormParticleOptions> codec() {
            return LightningStormParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, LightningStormParticleOptions> streamCodec() {
            return LightningStormParticleOptions.STREAM_CODEC;
        }
    });

    public static final DeferredHolder<ParticleType<?>, ParticleType<GatheringWaterParticleOptions>> GATHERING_WATER = PARTICLE.register("gathering_water", () -> new ParticleType<>(false) {
        @Override
        public MapCodec<GatheringWaterParticleOptions> codec() {
            return GatheringWaterParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, GatheringWaterParticleOptions> streamCodec() {
            return GatheringWaterParticleOptions.STREAM_CODEC;
        }
    });

    public static final DeferredHolder<ParticleType<?>, ParticleType<SpinTrailParticleOptions>> SPIN_TRAIL_PARTICLE = PARTICLE.register("spin_trail", () -> new ParticleType<>(false) {
        @Override
        public MapCodec<SpinTrailParticleOptions> codec() {
            return SpinTrailParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, SpinTrailParticleOptions> streamCodec() {
            return SpinTrailParticleOptions.STREAM_CODEC;
        }
    });

    public static final DeferredHolder<ParticleType<?>, ParticleType<NotSpinTrailParticleOptions>> NOT_SPIN_PARTICLE = PARTICLE.register("not_spin_particle", () -> new ParticleType<>(false)  {
        @Override
        public MapCodec<NotSpinTrailParticleOptions> codec() {
            return NotSpinTrailParticleOptions.MAP_CODEC;
        }
        public StreamCodec<? super RegistryFriendlyByteBuf, NotSpinTrailParticleOptions> streamCodec() {
            return NotSpinTrailParticleOptions.STREAM_CODEC;
        }
    });

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CURSED_FLAME = PARTICLE.register("cursed_flame", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SMALL_CURSED_FLAME = PARTICLE.register("small_cursed_flame", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PHANTOM_WING_FLAME = PARTICLE.register("phantom_wing_flame", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EM_PULSE = PARTICLE.register("em_pulse", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SHOCK_WAVE = PARTICLE.register("shock_wave", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TRAP_FLAME = PARTICLE.register("trap_flame", () -> new SimpleParticleType(false));


    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAME_JET = PARTICLE.register("flame_jet", () -> new SimpleParticleType(false));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLARE_EXPLODE = PARTICLE.register("flare_explode", () -> new SimpleParticleType(false));

}
