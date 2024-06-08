package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.*;
import com.mojang.serialization.Codec;
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

    public static final RegistryObject<ParticleType<MaledictusRingParticle.MaledictusRingData>> MALEDICTUSRING = PARTICLE.register("maledictus_ring", () -> new ParticleType<MaledictusRingParticle.MaledictusRingData>(false, MaledictusRingParticle.MaledictusRingData.DESERIALIZER) {
        @Override
        public Codec<MaledictusRingParticle.MaledictusRingData> codec() {
            return MaledictusRingParticle.MaledictusRingData.CODEC(MALEDICTUSRING.get());
        }
    });


    public static final RegistryObject<SimpleParticleType> CURSED_FLAME = PARTICLE.register("cursed_flame", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SMALL_CURSED_FLAME = PARTICLE.register("small_cursed_flame", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> PHANTOM_WING_FLAME = PARTICLE.register("phantom_wing_flame", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> EM_PULSE = PARTICLE.register("em_pulse", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SHOCK_WAVE = PARTICLE.register("shock_wave", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> TRAP_FLAME = PARTICLE.register("trap_flame", () -> new SimpleParticleType(false));

}
