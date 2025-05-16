package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.particle.Options.RoarParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * Created by BobMowzie on 6/2/2017.
 */
public class RoarParticle extends TextureSheetParticle {
    public int r, g, b;
    public float endsize;
    public float startsize;
    public float increase;
    private final SpriteSet sprites;


    public RoarParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ, int duration, int r, int g, int b, float opacity, float startsize, float increase, float endsize, SpriteSet sprites) {
        super(world, x, y, z);
        this.sprites = sprites;
        setSize(1, 1);
        this.setSpriteFromAge(this.sprites);
        this.quadSize = startsize;
        this.startsize = startsize;
        this.increase = increase;
        this.endsize = endsize;
        this.lifetime = duration;
        this.rCol = r/255F;
        this.gCol = g/255F;
        this.bCol = b/255F;
        this.alpha = opacity;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
    }

    @Override
    public int getLightColor(float delta) {
        return 240 | super.getLightColor(delta) & 0xFF0000;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age++ >= this.lifetime) {
            this.remove();
        }else{
            this.setSpriteFromAge(this.sprites);
            this.quadSize += this.increase;
            if (this.increase > 0) {
                this.quadSize = Math.min(this.quadSize, this.endsize);
            } else if (this.increase < 0) {
                this.quadSize = Math.max(this.quadSize, this.endsize);
            }
            this.alpha = Math.max(0f, 1f - ((float) this.age / this.lifetime));
        }
    }



    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }


    @OnlyIn(Dist.CLIENT)
    public static class RoarFactory implements ParticleProvider<RoarParticleOptions> {
        private final SpriteSet spriteSet;

        public RoarFactory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        public Particle createParticle(RoarParticleOptions typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            RoarParticle particle = new RoarParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn.duration(), typeIn.r(), typeIn.g(), typeIn.b(), typeIn.a(), typeIn.startsize(),typeIn.increase(),typeIn.endsize(),spriteSet);
            return particle;
        }
    }

}
