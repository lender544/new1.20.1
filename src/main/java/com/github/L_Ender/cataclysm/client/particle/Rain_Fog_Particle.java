package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.init.ModParticle;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.math.Axis;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
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
import java.util.function.Consumer;

public class Rain_Fog_Particle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private static final Vector3f ROTATION_VECTOR = Util.make(new Vector3f(0.5F, 0.5F, 0.5F), Vector3f::normalize);
    private static final Vector3f TRANSFORM_VECTOR = new Vector3f(-1.0F, -1.0F, 0.0F);
    private static final float DEGREES_90 = Mth.PI / 2f;


    protected Rain_Fog_Particle(ClientLevel level, double xCoord, double yCoord, double zCoord, double xd, double yd, double zd, float size, SpriteSet spriteSet) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);
        this.sprites = spriteSet;
        this.setSpriteFromAge(this.sprites);
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.alpha = 0.6F;
        this.quadSize = size;
        this.gravity = 0.0F;
        this.lifetime = (int)(Math.random() * 2.0D) + 60;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public float getQuadSize(float p_107608_) {
        float f = 1.0F - ((float)this.age + p_107608_) / ((float)this.lifetime * 1.5F);
        return this.quadSize * f;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
            this.move(this.xd, this.yd, this.zd);
            this.xd *= (double) this.friction;
            this.yd *= (double) this.friction;
            this.zd *= (double) this.friction;
        }
    }
    private float noise(float offset) {

        return 10 * Mth.sin(offset * 0.01f);
    }
    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialticks) {

        this.alpha = 1.0F - Mth.clamp(((float) this.age + partialticks - 20) / (float) this.lifetime, 0.2F, 0.7F);

//        this.renderBillboard(buffer, camera, partialticks);
        this.renderRotatedParticle(buffer, camera, partialticks, (p_234005_) -> {
            p_234005_.mul(Axis.YP.rotation(0));
            p_234005_.mul(Axis.XP.rotation(-DEGREES_90));
        });
        this.renderRotatedParticle(buffer, camera, partialticks, (p_234000_) -> {
            p_234000_.mul(Axis.YP.rotation(-(float) Math.PI));
            p_234000_.mul(Axis.XP.rotation(DEGREES_90));
        });
    }


    private void renderRotatedParticle(VertexConsumer pConsumer, Camera camera, float partialTick, Consumer<Quaternionf> pQuaternion) {
        Vec3 vec3 = camera.getPosition();
        float f = (float) (Mth.lerp(partialTick, this.xo, this.x) - vec3.x());
        float f1 = (float) (Mth.lerp(partialTick, this.yo, this.y) - vec3.y());
        float f2 = (float) (Mth.lerp(partialTick, this.zo, this.z) - vec3.z());
        Quaternionf quaternion = (new Quaternionf()).setAngleAxis(0.0F, ROTATION_VECTOR.x(), ROTATION_VECTOR.y(), ROTATION_VECTOR.z());

        pQuaternion.accept(quaternion);
        quaternion.transform(TRANSFORM_VECTOR);

        Vector3f[] avector3f = new Vector3f[]{new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)};
        float f3 = this.getQuadSize(partialTick);

        for (int i = 0; i < 4; ++i) {
            Vector3f vector3f = avector3f[i];
            vector3f.rotate(quaternion);
            vector3f.mul(f3);
            vector3f.add(f, f1, f2);
        }

        int j = this.getLightColor(partialTick);
        this.makeCornerVertex(pConsumer, avector3f[0], this.getU1(), this.getV1(), j);
        this.makeCornerVertex(pConsumer, avector3f[1], this.getU1(), this.getV0(), j);
        this.makeCornerVertex(pConsumer, avector3f[2], this.getU0(), this.getV0(), j);
        this.makeCornerVertex(pConsumer, avector3f[3], this.getU0(), this.getV1(), j);
    }

    private void makeCornerVertex(VertexConsumer pConsumer, Vector3f pVec3f, float p_233996_, float p_233997_, int p_233998_) {
        Vec3 wiggle = new Vec3(noise((float) (age + this.x)), noise((float) (age - this.x)), noise((float) (age + this.z))).scale(0.02f);
        pConsumer.vertex(pVec3f.x() + wiggle.x, pVec3f.y(), pVec3f.z() + wiggle.z).uv(p_233996_, p_233997_).color(this.rCol, this.gCol, this.bCol, this.alpha).uv2(p_233998_).endVertex();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<Rain_Fog_Particle.FogData> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(Rain_Fog_Particle.FogData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            Rain_Fog_Particle particle = new Rain_Fog_Particle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed,typeIn.getSize(), spriteSet);
            return particle;
        }
    }


    public static class FogData implements ParticleOptions {
        public static final Deserializer<Rain_Fog_Particle.FogData> DESERIALIZER = new Deserializer<Rain_Fog_Particle.FogData>() {
            public Rain_Fog_Particle.FogData fromCommand(ParticleType<Rain_Fog_Particle.FogData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float size = reader.readFloat();

                return new Rain_Fog_Particle.FogData(size);
            }

            public Rain_Fog_Particle.FogData fromNetwork(ParticleType<Rain_Fog_Particle.FogData> particleTypeIn, FriendlyByteBuf buffer) {
                return new Rain_Fog_Particle.FogData(buffer.readFloat());
            }
        };

        private final float size;


        public FogData(float size) {
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
        public ParticleType<Rain_Fog_Particle.FogData> getType() {
            return ModParticle.RAIN_FOG.get();
        }

        @OnlyIn(Dist.CLIENT)
        public float getSize() {
            return this.size;
        }



        public static Codec<Rain_Fog_Particle.FogData> CODEC(ParticleType<Rain_Fog_Particle.FogData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.FLOAT.fieldOf("size").forGetter(Rain_Fog_Particle.FogData::getSize)
                    ).apply(codecBuilder, (size) ->
                            new Rain_Fog_Particle.FogData(size))
            );
        }
    }

}
