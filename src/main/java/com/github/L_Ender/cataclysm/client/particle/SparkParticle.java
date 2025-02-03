package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.particle.Options.LightningParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.SparkTrailParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;


public class SparkParticle extends TextureSheetParticle {

    protected SparkParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.gravity = 0.95F;
        this.friction = 0.999F;
        this.xd += (double)xSpeed;
        this.yd += (double)ySpeed;
        this.zd += (double)zSpeed;
        this.yd = (double)(this.random.nextFloat() * 0.4F + 0.05F);
        this.quadSize *= this.random.nextFloat() * 2.0F + 0.2F;
        this.lifetime = 6 + level.random.nextInt(3);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public int getLightColor(float p_107086_) {
        int i = super.getLightColor(p_107086_);
        int j = 240;
        int k = i >> 16 & 255;
        return 240 | k << 16;
    }

    public float getQuadSize(float p_107089_) {
        float f = ((float)this.age + p_107089_) / (float)this.lifetime;
        return this.quadSize * (1.0F - f * f);
    }

    public void tick() {
        super.tick();
        if (!this.removed) {
            float f = (float)this.age / (float)this.lifetime;
            if (this.random.nextFloat() > f) {
                //this.level.addParticle(ParticleTypes.SMOKE, this.x, this.y, this.z, this.xd, this.yd, this.zd);

                this.level.addParticle(new SparkTrailParticleOptions(255, 106,  0), this.x, this.y, this.z, this.xd, this.yd, this.zd);

            }
            if (this.onGround) {
                this.remove();
            }
        }

    }


    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Factory(SpriteSet p_107092_) {
            this.sprite = p_107092_;
        }

        public Particle createParticle(SimpleParticleType p_107103_, ClientLevel p_107104_, double p_107105_, double p_107106_, double p_107107_, double p_107108_, double p_107109_, double p_107110_) {
            SparkParticle lavaparticle = new SparkParticle(p_107104_, p_107105_, p_107106_, p_107107_, p_107108_, p_107109_, p_107110_);
            lavaparticle.pickSprite(this.sprite);
            return lavaparticle;
        }
    }
}