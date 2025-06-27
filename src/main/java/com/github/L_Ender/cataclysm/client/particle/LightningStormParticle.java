package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.Locale;

public class LightningStormParticle extends TextureSheetParticle {

    private final SpriteSet sprites;


    protected LightningStormParticle(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float size, SpriteSet spriteSet) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
        this.sprites = spriteSet;
        this.setSpriteFromAge(this.sprites);
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.quadSize = size;

        this.lifetime = 8;
        this.setSize(size * 1.5F, size * 1.5F);
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;


        if (this.age++ >= this.lifetime) {
            this.remove();
        }else{
            this.setSpriteFromAge(this.sprites);
        }

    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
        Vec3 vec3 = camera.getPosition();
        float f = (float)(Mth.lerp((double)partialTicks, this.xo, this.x) - vec3.x());
        float f1 = (float)(Mth.lerp((double)partialTicks, this.yo, this.y) - vec3.y());
        float f2 = (float)(Mth.lerp((double)partialTicks, this.zo, this.z) - vec3.z());
        Quaternionf quaternionf = new Quaternionf();
        quaternionf.rotateY((float) Math.toRadians(-camera.getYRot()));

        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float f3 = this.getQuadSize(partialTicks);

        for(int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            vector3f.rotate(quaternionf);
            vector3f.mul(f3);
            vector3f.add(f, f1, f2);
        }

        float f6 = this.getU0();
        float f7 = this.getU1();
        float f4 = this.getV0();
        float f5 = this.getV1();
        int j = this.getLightColor(partialTicks);
        buffer.vertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).uv(f7, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).uv(f7, f4).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).uv(f6, f4).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).uv(f6, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();


    }


    public int getLightColor(float p_106821_) {
        float f = ((float)this.age + p_106821_) / (float)this.lifetime;
        f = Mth.clamp(f, 0.0F, 1.0F);
        int i = super.getLightColor(p_106821_);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return 240;
    }


    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<LightningStormParticle.StormData> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(LightningStormParticle.StormData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            LightningStormParticle particle = new LightningStormParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed,typeIn.getSize(), spriteSet);
            return particle;
        }
    }

    public static class StormData implements ParticleOptions {
        public static final Deserializer<LightningStormParticle.StormData> DESERIALIZER = new Deserializer<LightningStormParticle.StormData>() {
            public LightningStormParticle.StormData fromCommand(ParticleType<LightningStormParticle.StormData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float size = reader.readFloat();

                return new LightningStormParticle.StormData(size);
            }

            public LightningStormParticle.StormData fromNetwork(ParticleType<LightningStormParticle.StormData> particleTypeIn, FriendlyByteBuf buffer) {
                return new LightningStormParticle.StormData(buffer.readFloat());
            }
        };

        private final float size;

        public StormData(float size) {
            this.size = size;
        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeFloat(this.size);
        }

        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %.2f", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                    this.size);
        }

        @Override
        public ParticleType<LightningStormParticle.StormData> getType() {
            return ModParticle.LIGHTNING_STORM.get();
        }



        @OnlyIn(Dist.CLIENT)
        public float getSize() {
            return this.size;
        }


        public static Codec<LightningStormParticle.StormData> CODEC(ParticleType<LightningStormParticle.StormData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.FLOAT.fieldOf("size").forGetter(LightningStormParticle.StormData::getSize)
                    ).apply(codecBuilder, LightningStormParticle.StormData::new)
            );
        }
    }
}