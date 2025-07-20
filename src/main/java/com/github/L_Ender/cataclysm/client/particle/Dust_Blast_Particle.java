package com.github.L_Ender.cataclysm.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;


public class Dust_Blast_Particle extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected Dust_Blast_Particle(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);
        this.sprites = spriteSet;
        this.setSpriteFromAge(this.sprites);
        this.alpha = 0.9F;
        this.quadSize *= 4F;
        this.gravity = 0F;
        this.lifetime = 8;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public float getQuadSize(float scaleFactor) {
        float f = ((float)this.age + scaleFactor) / (float)this.lifetime;
        return this.quadSize * (1.0F - f * f * 0.5F);
    }

    public void tick() {
        super.tick();
        if (this.age++ >= this.lifetime) {
            this.remove();
        }else{
            this.setSpriteFromAge(this.sprites);
        }
    }


    
    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Factory(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
            return new Dust_Blast_Particle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}