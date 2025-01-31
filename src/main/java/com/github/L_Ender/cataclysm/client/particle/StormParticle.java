package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.particle.Options.StormParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class StormParticle extends AbstractTrailParticle {
    private static final ResourceLocation TRAIL_TEXTURE = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/particle/amogus.png");

    private final int EntityId;
    private final float width;
    private final float height;
    private final float initialYRot;
    private final float rotateByAge;


    public StormParticle(ClientLevel world, double x, double y, double z, float r, float g, float b, float width, float height, int EntityId) {
        super(world, x, y, z, 0, 0, 0,r,g,b);
        this.EntityId = EntityId;
        this.gravity = 0;
        this.lifetime = 20 + this.random.nextInt(20);
        initialYRot = random.nextFloat() * 360F;
        rotateByAge = (10 + random.nextFloat() * 10F) * (random.nextBoolean() ? -1F : 1F);
        this.width = width;
        this.height = height;
        Vec3 vec3 = getOrbitPosition();
        this.x = this.xo = vec3.x;
        this.y = this.yo = vec3.y;
        this.z = this.zo = vec3.z;
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
    }

    public Vec3 getDinosaurPosition(){
        Entity from = this.getFromEntity();
        if(from != null){
            return from.position();
        }
        return new Vec3(this.x, this.y, this.z);
    }


    public Entity getFromEntity() {
        return EntityId == -1 ? null : level.getEntity(EntityId);
    }

    public Vec3 getOrbitPosition(){
        Vec3 dinoPos = getDinosaurPosition();
        Vec3 vec3 = new Vec3(0, height, width).yRot((float)Math.toRadians(initialYRot + rotateByAge * age));
        return dinoPos.add(vec3);
    }

    public void tick() {
        super.tick();
        float fade = 1F - age / (float) lifetime;
        this.trailA = 1F * fade;
        Vec3 vec3 = getOrbitPosition();
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;

        Entity from = this.getFromEntity();
        if(from == null){
            remove();
        }

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
    public static class Factory implements ParticleProvider<StormParticleOptions> {

        @Override
        public Particle createParticle(StormParticleOptions data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {

            StormParticle particle;
            particle = new StormParticle(level, x, y, z, data.r(),data.g(),data.b(), data.width(), data.height(),data.entityid());
            return particle;
        }
    }
}
