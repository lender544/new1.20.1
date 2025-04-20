package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.util.CMMathUtil;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.Locale;

public class Scylla_Swing_Particle extends TextureSheetParticle {
    private final SpriteSet sprites;

    public float yaw;
    public float pitch;
    public Scylla_Swing_Particle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double xd, double yd, double zd, float scale, float yaw, float pitch) {
        super(pLevel, pX, pY, pZ, 0, 0, 0);

        this.xd = xd;
        this.yd = yd;
        this.zd = zd;

        this.lifetime = 7;
        this.gravity = 0;
        sprites = spriteSet;

        this.quadSize = scale * 3.25f;
        this.yaw = yaw;
        this.pitch = pitch;

        this.friction = 1;
    }

    private Vec3 vec3Copy(Vector3f vector3f) {
        return new Vec3(vector3f.x, vector3f.y, vector3f.z);
    }

    @Override
    public void tick() {
        if (this.age++ > this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(sprites);
        }
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
        Vec3 Vector3d = camera.getPosition();
        float f = (float)(Mth.lerp(partialTicks, this.xo, this.x) - Vector3d.x());
        float f1 = (float)(Mth.lerp(partialTicks, this.yo, this.y) - Vector3d.y());
        float f2 = (float)(Mth.lerp(partialTicks, this.zo, this.z) - Vector3d.z());
        Quaternionf quaternionf = new Quaternionf(0.0F, 0.0F, 0.0F, 1.0F);
        Quaternionf quatX = CMMathUtil.quatFromRotationXYZ(pitch, 0, 0, false);
        Quaternionf quatY = CMMathUtil.quatFromRotationXYZ(0, yaw, 0, false);
        quaternionf.mul(quatY);
        quaternionf.mul(quatX);

        Vector3f vector3f1 = new Vector3f(-1.0F, -1.0F, 0.0F);
        quaternionf.transform(vector3f1);
        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float f4 = this.getQuadSize(partialTicks);

        for(int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            quaternionf.transform(vector3f);
            vector3f.mul(f4);
            vector3f.add(f, f1, f2);
        }

        float f7 = this.getU0();
        float f8 = this.getU1();
        float f5 = this.getV0();
        float f6 = this.getV1();
        int j = this.getLightColor(partialTicks);
        buffer.vertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).uv(f8, f6).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).uv(f8, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).uv(f7, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).uv(f7, f6).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();

        buffer.vertex(avector3f[3].x(), avector3f[3].y(), avector3f[3].z()).uv(f7, f6).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(avector3f[2].x(), avector3f[2].y(), avector3f[2].z()).uv(f7, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(avector3f[1].x(), avector3f[1].y(), avector3f[1].z()).uv(f8, f5).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
        buffer.vertex(avector3f[0].x(), avector3f[0].y(), avector3f[0].z()).uv(f8, f6).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(j).endVertex();
    }
    
    @NotNull
    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    protected int getLightColor(float pPartialTick) {
        return LightTexture.FULL_BRIGHT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<Scylla_Swing_Particle.SwingData> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprite) {
            this.sprite = pSprite;
        }

        public Particle createParticle(Scylla_Swing_Particle.SwingData options, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            Scylla_Swing_Particle shriekparticle = new Scylla_Swing_Particle(worldIn, x, y, z, sprite, xSpeed, ySpeed, zSpeed, options.getScale(), options.getYaw(), options.getPitch());
            shriekparticle.setSpriteFromAge(this.sprite);
            shriekparticle.setAlpha(1.0F);
            return shriekparticle;
        }
    }

    public static class SwingData implements ParticleOptions {
        public static final Deserializer<Scylla_Swing_Particle.SwingData> DESERIALIZER = new Deserializer<Scylla_Swing_Particle.SwingData>() {
            public Scylla_Swing_Particle.SwingData fromCommand(ParticleType<Scylla_Swing_Particle.SwingData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float scale = reader.readFloat();
                reader.expect(' ');
                float yaw = reader.readFloat();
                reader.expect(' ');
                float pitch = reader.readFloat();


                return new Scylla_Swing_Particle.SwingData(scale, yaw, pitch);
            }

            public Scylla_Swing_Particle.SwingData fromNetwork(ParticleType<Scylla_Swing_Particle.SwingData> particleTypeIn, FriendlyByteBuf buffer) {
                return new Scylla_Swing_Particle.SwingData(buffer.readFloat(), buffer.readFloat(),buffer.readFloat());
            }
        };

        private final float scale;
        private final float yaw;
        private final float pitch;

        public SwingData(float scale, float yaw, float pitch) {
            this.scale = scale;
            this.yaw = yaw;
            this.pitch = pitch;
        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeFloat(this.scale);
            buffer.writeFloat(this.yaw);
            buffer.writeFloat(this.pitch);
        }

        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %.2f %.2f %.2f", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                    this.scale, this.yaw, this.pitch);
        }

        @Override
        public ParticleType<Scylla_Swing_Particle.SwingData> getType() {
            return ModParticle.SCYLLA_SWING.get();
        }

        @OnlyIn(Dist.CLIENT)
        public float getScale() {
            return this.scale;
        }

        @OnlyIn(Dist.CLIENT)
        public float getYaw() {
            return this.yaw;
        }

        @OnlyIn(Dist.CLIENT)
        public float getPitch() {
            return this.pitch;
        }


        public static Codec<Scylla_Swing_Particle.SwingData> CODEC(ParticleType<Scylla_Swing_Particle.SwingData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.FLOAT.fieldOf("scale").forGetter(Scylla_Swing_Particle.SwingData::getScale),
                            Codec.FLOAT.fieldOf("yaw").forGetter(Scylla_Swing_Particle.SwingData::getYaw),
                            Codec.FLOAT.fieldOf("pitch").forGetter(Scylla_Swing_Particle.SwingData::getPitch)
                    ).apply(codecBuilder, Scylla_Swing_Particle.SwingData::new)
            );
        }
    }

}
