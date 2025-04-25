package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;

public class Not_Spin_TrailParticle extends AbstractTrailParticle {

    private static final ResourceLocation TRAIL_TEXTURE = new ResourceLocation(Cataclysm.MODID, "textures/particle/gathering_lightning.png");

    private boolean arrive = false;
    private final double xTarget;
    private final double yTarget;
    private final double zTarget;
    private final float reduction;
    private final float acceleration;
    private final double direction;
    protected Not_Spin_TrailParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float r, float g, float b, float gravity, float reduction, float acceleration, double direction, int life) {
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

    public static class Factory implements ParticleProvider<Not_Spin_TrailParticle.NSTData> {

        public Particle createParticle(Not_Spin_TrailParticle.NSTData data, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {


            Not_Spin_TrailParticle particle;
            particle = new Not_Spin_TrailParticle(worldIn, x, y, z,xSpeed,ySpeed,zSpeed, data.getR(),data.getG(),data.getB(),data.getGravity(),data.getReduction(),data.getAcceleration(),data.getDirection(),data.getLife());

            return particle;
        }
    }

    public static class NSTData implements ParticleOptions {
        public static final Deserializer<Not_Spin_TrailParticle.NSTData> DESERIALIZER = new Deserializer<Not_Spin_TrailParticle.NSTData>() {
            public Not_Spin_TrailParticle.NSTData fromCommand(ParticleType<Not_Spin_TrailParticle.NSTData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float r = reader.readFloat();
                reader.expect(' ');
                float g = reader.readFloat();
                reader.expect(' ');
                float b = reader.readFloat();
                reader.expect(' ');
                float gravity = reader.readFloat();

                reader.expect(' ');
                float reduction = reader.readFloat();

                reader.expect(' ');
                float acceleration = reader.readFloat();

                reader.expect(' ');
                double direction = reader.readDouble();
                reader.expect(' ');
                int life = reader.readInt();

                return new Not_Spin_TrailParticle.NSTData(r, g, b,gravity,reduction,acceleration,direction,life);
            }

            public Not_Spin_TrailParticle.NSTData fromNetwork(ParticleType<Not_Spin_TrailParticle.NSTData> particleTypeIn, FriendlyByteBuf buffer) {
                return new Not_Spin_TrailParticle.NSTData(buffer.readFloat(), buffer.readFloat(),buffer.readFloat(),buffer.readFloat(),buffer.readFloat(),buffer.readFloat(),buffer.readDouble(),buffer.readInt());
            }
        };

        private final float r;
        private final float g;
        private final float b;
        private final float gravity;

        private final float reduction;
        private final float acceleration;
        private final double direction;
        private final int life;

        public NSTData(float r, float g, float b,float gravity,float reduction,float acceleration,double direction,int life) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.gravity = gravity;
            this.reduction = reduction;
            this.acceleration = acceleration;
            this.direction = direction;
            this.life = life;
        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeFloat(this.r);
            buffer.writeFloat(this.g);
            buffer.writeFloat(this.b);
            buffer.writeFloat(this.gravity);
            buffer.writeFloat(this.reduction);
            buffer.writeFloat(this.acceleration);
            buffer.writeDouble(this.direction);
            buffer.writeInt(this.life);
        }

        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f %.2f %.2f %.2f %d", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                    this.r, this.g, this.b,this.gravity,this.reduction,this.acceleration,this.direction,this.life);
        }

        @Override
        public ParticleType<Not_Spin_TrailParticle.NSTData> getType() {
            return ModParticle.NOT_SPIN_PARTICLE.get();
        }

        @OnlyIn(Dist.CLIENT)
        public float getR() {
            return this.r;
        }

        @OnlyIn(Dist.CLIENT)
        public float getG() {
            return this.g;
        }

        @OnlyIn(Dist.CLIENT)
        public float getB() {
            return this.b;
        }

        @OnlyIn(Dist.CLIENT)
        public float getGravity() {
            return this.gravity;
        }

        @OnlyIn(Dist.CLIENT)
        public float getReduction() {
            return this.reduction;
        }

        @OnlyIn(Dist.CLIENT)
        public float getAcceleration() {
            return this.acceleration;
        }

        @OnlyIn(Dist.CLIENT)
        public double getDirection() {
            return this.direction;
        }

        @OnlyIn(Dist.CLIENT)
        public int getLife() {
            return this.life;
        }

        public static Codec<Not_Spin_TrailParticle.NSTData> CODEC(ParticleType<Not_Spin_TrailParticle.NSTData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.FLOAT.fieldOf("r").forGetter(Not_Spin_TrailParticle.NSTData::getR),
                            Codec.FLOAT.fieldOf("g").forGetter(Not_Spin_TrailParticle.NSTData::getG),
                            Codec.FLOAT.fieldOf("b").forGetter(Not_Spin_TrailParticle.NSTData::getB),
                            Codec.FLOAT.fieldOf("gravity").forGetter(Not_Spin_TrailParticle.NSTData::getGravity),
                    Codec.FLOAT.fieldOf("reduction").forGetter(Not_Spin_TrailParticle.NSTData::getReduction),
                    Codec.FLOAT.fieldOf("acceleration").forGetter(Not_Spin_TrailParticle.NSTData::getAcceleration),
                    Codec.DOUBLE.fieldOf("direction").forGetter(Not_Spin_TrailParticle.NSTData::getDirection),
                    Codec.INT.fieldOf("life").forGetter(Not_Spin_TrailParticle.NSTData::getLife)
                    ).apply(codecBuilder, Not_Spin_TrailParticle.NSTData::new)
            );
        }
    }
}
