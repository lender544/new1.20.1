package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.particle.Options.CustomPoofParticleOptions;
import com.github.L_Ender.cataclysm.client.particle.Options.LightningZapParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Lightning_Zap_Particle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private int getR;
    private int getG;
    private int getB;

    protected Lightning_Zap_Particle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites, int r, int g, int b, float gravity) {
        super(level, x, y, z);
        this.gravity = gravity;
        this.friction = 0.1F;
        this.sprites = sprites;
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.rCol = r/255F;
        this.gCol = g/255F;
        this.bCol = b/255F;
        this.getR = r ;
        this.getG = g;
        this.getB = b;
        this.quadSize = 0.25F + level.random.nextFloat() * 0.15F;
        this.lifetime = 8;
        this.setSpriteFromAge(sprites);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public int getLightColor(float p_106821_) {
        return 240;
    }


    public void tick() {
        super.tick();
        if(this.age == 3){
            this.rCol = 1f;
            this.gCol = 1f;
            this.bCol = 1f;
        }else{
            this.rCol = this.getR /255F;
            this.gCol = this.getG /255F;
            this.bCol = this.getB /255F;
        }

        this.setSpriteFromAge(this.sprites);
    }


    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<LightningZapParticleOptions> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(LightningZapParticleOptions type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new Lightning_Zap_Particle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites,type.r(), type.g(), type.b(),type.gravity());
        }
    }
}
