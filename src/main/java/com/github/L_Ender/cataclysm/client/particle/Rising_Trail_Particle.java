package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.Options.Rising_Trail_Options;
import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import com.github.L_Ender.cataclysm.entity.effect.Void_Vortex_Entity;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class Rising_Trail_Particle extends AbstractTrailParticle {
    private static final ResourceLocation TRAIL_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/particle/amogus.png");

    private float width;
    private float indewidth;
    private final float initialYRot;
    private final float rotateByAge;


    public Rising_Trail_Particle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float r, float g, float b, float width, float indewidth) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed,r,g,b);
        this.gravity = 0;
        this.lifetime = 20 + this.random.nextInt(20);
        initialYRot = random.nextFloat() * 360F;
        rotateByAge = (10 + random.nextFloat() * 10F) * (random.nextBoolean() ? -1F : 1F);
        this.width = width;
        this.indewidth = indewidth;
        Vec3 vec3 = getOrbitPosition();
        this.x = this.xo = vec3.x;
        this.y = this.yo = vec3.y;
        this.z = this.zo = vec3.z;
    }

    public Vec3 getOrbitPosition(){
        Vec3 dinoPos = new Vec3(this.x, this.y, this.z);
        Vec3 vec3 = new Vec3(0, 0, width).yRot((float)Math.toRadians(initialYRot + rotateByAge * age));
        return dinoPos.add(vec3);
    }

    public void tick() {
        super.tick();
        float fade = 1F - age / (float) lifetime;
        this.trailA = 1F * fade;
        this.width = this.width - this.indewidth;
        Vec3 vec3 = new Vec3(this.x, this.y, this.z).add(new Vec3(0, 0, width).yRot((float)Math.toRadians(initialYRot + rotateByAge * age)));

        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;



    }

    public int sampleCount() {
        return 4;
    }

    public int sampleStep() {
        return 1;
    }

    @Override
    public float getTrailHeight() {
        return 0.5F;
    }

    public int getLightColor(float f) {
        return 240;
    }

    @Override
    public ResourceLocation getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<Rising_Trail_Options> {

        @Override
        public Particle createParticle(Rising_Trail_Options data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {

            Rising_Trail_Particle particle;
            particle = new Rising_Trail_Particle(level, x, y, z,xSpeed,ySpeed,zSpeed, data.r(),data.g(),data.b(), data.width(), data.indewidth());
            return particle;
        }
    }
}
