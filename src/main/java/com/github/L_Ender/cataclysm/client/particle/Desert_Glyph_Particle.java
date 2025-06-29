package com.github.L_Ender.cataclysm.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class Desert_Glyph_Particle extends TextureSheetParticle {


    private final SpriteSet sprites;


    protected Desert_Glyph_Particle(ClientLevel world, double x, double y, double z, double xSpeed, SpriteSet sprites) {
        super(world, x, y, z, 0, 0, 0);
        this.quadSize = 2.0F * (1.0F - (float)xSpeed * 0.5F);
        this.lifetime = 6;
        this.sprites = sprites;

    }



    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        }else{
            this.setSpriteFromAge(this.sprites);
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public float getQuadSize(float scaleFactor) {
        return super.getQuadSize(scaleFactor);
    }

    public int getLightColor(float partialTicks) {
        return 240;
    }


    public static class GlyphFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public GlyphFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            Desert_Glyph_Particle particle = new Desert_Glyph_Particle(worldIn, x, y, z, xSpeed, spriteSet);
            particle.setSpriteFromAge(spriteSet);
            particle.scale(1.0F);
            return particle;
        }
    }




}
