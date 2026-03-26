package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.particle.Options.Cursed_MarkParticleOption;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class CursedMarkParticle extends TextureSheetParticle {


    private final SpriteSet sprites;
    private float rotSpeed;
    private final float spinAcceleration;

    protected CursedMarkParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites,float size) {
        super(world, x, y, z, 0, 0, 0);
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.setSize(0.5F, 0.5F);
        this.quadSize = size;
        this.lifetime = 5;
        this.sprites = sprites;
        this.rotSpeed = (float)Math.toRadians(20.0);
        this.spinAcceleration = (float)Math.toRadians(5.0);
        this.setSpriteFromAge(this.sprites);

    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;

        if (this.age++ >= this.lifetime) {
            this.remove();
        }else{
            this.setSpriteFromAge(this.sprites);
            this.rotSpeed = this.rotSpeed + this.spinAcceleration / 20.0F;
            this.oRoll = this.roll;
            this.roll = this.roll + this.rotSpeed / 20.0F;
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


    public static class MarkFactory implements ParticleProvider<Cursed_MarkParticleOption> {
        private final SpriteSet spriteSet;

        public MarkFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(Cursed_MarkParticleOption data, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {

            return new CursedMarkParticle(worldIn, x, y, z,xSpeed,ySpeed,zSpeed,spriteSet, data.size());
        }
    }


}
