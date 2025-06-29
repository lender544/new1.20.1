package com.github.L_Ender.cataclysm.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.FastColor;

public class CustomExplodeParticle extends TextureSheetParticle {


    private final SpriteSet sprites;


    protected CustomExplodeParticle(ClientLevel world, double x, double y, double z, double xSpeed, SpriteSet sprites) {
        super(world, x, y, z, 0, 0, 0);
        this.quadSize = 2.0F * (1.0F - (float)xSpeed * 0.5F);
        this.lifetime = 7 + this.random.nextInt(4);
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


    public static class FlareFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public FlareFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            CustomExplodeParticle particle = new CustomExplodeParticle(worldIn, x, y, z, xSpeed, spriteSet);
            particle.setSpriteFromAge(spriteSet);
            particle.scale(1.0F + worldIn.random.nextFloat() * 0.9F);
            return particle;
        }
    }


    public static class IgnisFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public IgnisFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            CustomExplodeParticle particle = new CustomExplodeParticle(worldIn, x, y, z, xSpeed, spriteSet);
            particle.setSpriteFromAge(spriteSet);
            particle.scale(1.0F + worldIn.random.nextFloat() * 0.9F);
            return particle;
        }
    }


}
