package com.github.L_Ender.cataclysm.init;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.LightningParticle;
import com.github.L_Ender.cataclysm.client.particle.StormParticle;
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

    public static final RegistryObject<SimpleParticleType> EM_PULSE = PARTICLE.register("em_pulse", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SHOCK_WAVE = PARTICLE.register("shock_wave", () -> new SimpleParticleType(false));
}
