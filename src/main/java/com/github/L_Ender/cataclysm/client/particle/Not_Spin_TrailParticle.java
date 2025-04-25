package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.Options.NotSpinTrailParticleOptions;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class Not_Spin_TrailParticle extends AbstractTrailParticle {

    private static final ResourceLocation TRAIL_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/particle/gathering_lightning.png");

    private boolean arrive = false;
    private final double xTarget;
    private final double yTarget;
    private final double zTarget;
    private final float reduction;
    private final float acceleration;
    private final double direction;
    protected Not_Spin_TrailParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float r, float g, float b,float gravity,float reduction,float acceleration,double direction,int life) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed,r,g,b);
        this.alpha = 1;
        this.hasPhysics =false;
        this.gravity = gravity;
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.xTarget = xSpeed;
        this.yTarget = ySpeed;
        this.zTarget = zSpeed;
        this.reduction = reduction;
        this.acceleration = acceleration;
        this.direction = direction;
        this.lifetime = life;
    }

    public int getLightColor(float partialTicks) {
        return 240;
    }

    public void render(VertexConsumer vertexConsumer, Camera camera, float partialTick) {
        super.render(vertexConsumer, camera, partialTick);

    }


    public float getAlpha() {
        return Mth.clamp( 1F - age / (float) this.lifetime, 0.0F, 1.0F);
    }



    public void tick() {
        super.tick();
        Vec3 travelVec = new Vec3(xTarget - this.x, yTarget - this.y, zTarget - this.z);

        if (!this.arrive) {
            if (travelVec.length() > 1.0F) {
                travelVec = travelVec.normalize();
                this.xd = this.xd * reduction + travelVec.x * acceleration + direction;
                this.yd = this.yd * reduction + travelVec.y * acceleration + direction;
                this.zd = this.zd * reduction + travelVec.z * acceleration + direction;
            } else {
                this.arrive = true;
            }
        } else {
            this.age = Math.min(this.age + 3, this.lifetime);
            this.yd = this.yd - (double) this.gravity;

          // this.age = Math.min(this.age + 3, this.lifetime);
        }
        float fadeIn =  Mth.clamp(age / (float) this.lifetime * 32.0F, 0.0F, 1.0F);
        float fadeOut = Mth.clamp( 1F - age / (float) this.lifetime, 0.0F, 1.0F);
        this.trailA = fadeIn * fadeOut;
    }

    @Override
    public float getTrailHeight() {
        return 0.4F;
    }

    @Override
    public ResourceLocation getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    @Override
    public int sampleCount() {
        return Math.min(10, lifetime - age);
    }

    public static class Factory implements ParticleProvider<NotSpinTrailParticleOptions> {

        public Particle createParticle(NotSpinTrailParticleOptions data, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {


            Not_Spin_TrailParticle particle;
            particle = new Not_Spin_TrailParticle(worldIn, x, y, z,xSpeed,ySpeed,zSpeed, data.r(),data.g(),data.b(),data.gravity(),data.reduction(),data.acceleration(),data.direction(),data.life());

            return particle;
        }
    }
}
