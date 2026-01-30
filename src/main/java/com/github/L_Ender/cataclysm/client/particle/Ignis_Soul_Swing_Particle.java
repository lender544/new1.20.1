package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.particle.Options.IgnisSoulSwingParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class Ignis_Soul_Swing_Particle extends Abstract_Ignis_Swing_Particle {

    public Ignis_Soul_Swing_Particle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double xd, double yd, double zd,int lifetime, float scale, float yaw, float pitch, float roll) {
        super(pLevel, pX, pY, pZ, spriteSet,xd, yd, zd,lifetime,scale,yaw,pitch,roll);

    }

    @Nullable
    public ParticleOptions TrailParticle() {
        return ParticleTypes.SOUL_FIRE_FLAME;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<IgnisSoulSwingParticleOptions> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprite) {
            this.sprite = pSprite;
        }

        public Particle createParticle(IgnisSoulSwingParticleOptions options, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            Ignis_Soul_Swing_Particle shriekparticle = new Ignis_Soul_Swing_Particle(worldIn, x, y, z, sprite, xSpeed, ySpeed, zSpeed, options.lifetime(), options.scale(), options.yaw(), options.pitch(), options.roll());
            shriekparticle.setSpriteFromAge(this.sprite);
            shriekparticle.setAlpha(1.0F);
            return shriekparticle;
        }
    }

}
