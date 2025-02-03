package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;


public class TrapFlameParticle extends TextureSheetParticle {

    private final SpriteSet sprites;

    private float prevAlpha = 0.0F;


    protected TrapFlameParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet spriteSet) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.sprites = spriteSet;
        this.setSpriteFromAge(this.sprites);
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.quadSize = 0.4F + world.random.nextFloat() * 0.25F;
        this.lifetime = 10 + world.random.nextInt(20);
        this.friction = 0.99F;
    }

    public void tick() {
        this.setSpriteFromAge(this.sprites);
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        float ageProgress = this.age / (float) lifetime;
        float f = ageProgress - 0.5F;
        float scale = 1.0F + ageProgress * 0.5F;
        float f1 = 1.0F - f * 2F;
        if (ageProgress > 0.5F) {
            prevAlpha = alpha;
            this.setAlpha(prevAlpha + (f1 - prevAlpha) * Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(false));
        }
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.scale(scale);
            this.move(this.xd, this.yd, this.zd);
            this.xd *= (double) this.friction;
            this.yd *= (double) this.friction;
            this.zd *= (double) this.friction;
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public int getLightColor(float partialTicks) {
        return 240;
    }

    public Particle scale(float p_107683_) {
        this.quadSize = p_107683_;
        return this;
    }


    
    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TrapFlameParticle particle = new TrapFlameParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
            return particle;
        }
    }

}