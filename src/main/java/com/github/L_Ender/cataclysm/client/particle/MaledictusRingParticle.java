package com.github.L_Ender.cataclysm.client.particle;

import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;
import com.github.L_Ender.cataclysm.client.render.entity.RendererMaledictus;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Maledictus.Maledictus_Entity;
import com.github.L_Ender.cataclysm.init.ModParticle;
import com.github.L_Ender.cataclysm.util.CMMathUtil;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.math.Axis;
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

/**
 * Created by BobMowzie on 6/2/2017.
 */
public class MaledictusRingParticle extends TextureSheetParticle {
    public float r, g, b;
    public float opacity;
    public boolean facesCamera;
    public float yaw, pitch;
    public float size;
    private final SpriteSet sprites;
    private final EnumRingBehavior behavior;
    public boolean right;
    private final int EntityId;

    public enum EnumRingBehavior {
        SHRINK,
        GROW,
        CONSTANT,
        GROW_THEN_SHRINK
    }

    public MaledictusRingParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ, float yaw, float pitch, int duration, float r, float g, float b, float opacity, float size, boolean facesCamera, boolean right, EnumRingBehavior behavior, int EntityId, SpriteSet sprites) {
        super(world,0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        this.setInHandPos();
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.sprites = sprites;
        setSize(1, 1);
        this.setSpriteFromAge(this.sprites);
        this.size = size * 0.1f;
        lifetime = duration;
        alpha = 1;
        this.r = r;
        this.g = g;
        this.b = b;
        this.opacity = opacity;
        this.yaw = yaw;
        this.pitch = pitch;
        this.facesCamera = facesCamera;
        this.right = right;
        this.xd = motionX;
        this.yd = motionY;
        this.zd = motionZ;
        this.behavior = behavior;
        this.EntityId = EntityId;
    }

    @Override
    public int getLightColor(float delta) {
        return 240 | super.getLightColor(delta) & 0xFF0000;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.setInHandPos();
        this.setSpriteFromAge(this.sprites);
        if (age >= lifetime) {
            remove();
        }
        age++;

    }


    @Override
    public void render(VertexConsumer buffer, Camera renderInfo, float partialTicks) {
        float var = (age + partialTicks)/lifetime;
        if (behavior == EnumRingBehavior.GROW) {
            quadSize = size * var;
        }
        else if (behavior == EnumRingBehavior.SHRINK) {
            quadSize = size * (1 - var);
        }
        else if (behavior == EnumRingBehavior.GROW_THEN_SHRINK) {
            quadSize = (float) (size * (1 - var - Math.pow(2000, -var)));
        }
        else {
            quadSize = size;
        }
        alpha = opacity * 0.95f * (1 - (age + partialTicks)/lifetime) + 0.05f;
        rCol = r;
        gCol = g;
        bCol = b;

        Vec3 Vector3d = renderInfo.getPosition();
        float f = (float)(Mth.lerp(partialTicks, this.xo, this.x) - Vector3d.x());
        float f1 = (float)(Mth.lerp(partialTicks, this.yo, this.y) - Vector3d.y());
        float f2 = (float)(Mth.lerp(partialTicks, this.zo, this.z) - Vector3d.z());
        Quaternionf quaternionf = new Quaternionf(0.0F, 0.0F, 0.0F, 1.0F);
        if (facesCamera) {
            if (this.roll == 0.0F) {
                quaternionf = renderInfo.rotation();
            } else {
                quaternionf = new Quaternionf(renderInfo.rotation());
                float f3 = Mth.lerp(partialTicks, this.oRoll, this.roll);
                quaternionf.mul(Axis.ZP.rotation(f3));
            }
        }
        else {
            Quaternionf quatX = CMMathUtil.quatFromRotationXYZ(pitch, 0, 0, false);
            Quaternionf quatY = CMMathUtil.quatFromRotationXYZ(0, yaw, 0, false);
            quaternionf.mul(quatY);
            quaternionf.mul(quatX);
        }

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
    }

    public void setInHandPos() {
        if (EntityId != -1 && level.getEntity(EntityId) instanceof Maledictus_Entity entity) {
            Vec3 mouthPos = right ? RendererMaledictus.getRightHandPositionFor(EntityId) : RendererMaledictus.getLeftHandPositionFor(EntityId);
            if (mouthPos != null) {
                Vec3 translate = mouthPos.add(new Vec3(0, 0F, 0F)).yRot((float) (Math.PI - entity.yBodyRot * ((float) Math.PI / 180F)));
                this.setPos(entity.getX() + translate.x, entity.getY() + translate.y, entity.getZ() + translate.z);
            }
        }
    }


    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static final class RingFactory implements ParticleProvider<MaledictusRingData> {
        private final SpriteSet spriteSet;

        public RingFactory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }


        @Override
        public Particle createParticle(MaledictusRingData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            MaledictusRingParticle particle = new MaledictusRingParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, typeIn.getYaw(), typeIn.getPitch(), typeIn.getDuration(), typeIn.getR(), typeIn.getG(), typeIn.getB(), typeIn.getA(), typeIn.getScale(), typeIn.getFacesCamera(), typeIn.getRight(), typeIn.getBehavior(),typeIn.getEntity(),spriteSet);
            return particle;
        }

    }

    public static class MaledictusRingData implements ParticleOptions {
        public static final Deserializer<MaledictusRingData> DESERIALIZER = new Deserializer<MaledictusRingData>() {
            public MaledictusRingData fromCommand(ParticleType<MaledictusRingData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float yaw = (float) reader.readDouble();
                reader.expect(' ');
                float pitch = (float) reader.readDouble();
                reader.expect(' ');
                float r = (float) reader.readDouble();
                reader.expect(' ');
                float g = (float) reader.readDouble();
                reader.expect(' ');
                float b = (float) reader.readDouble();
                reader.expect(' ');
                float a = (float) reader.readDouble();
                reader.expect(' ');
                float scale = (float) reader.readDouble();
                reader.expect(' ');
                int duration = reader.readInt();
                reader.expect(' ');
                int entity = reader.readInt();
                reader.expect(' ');
                boolean facesCamera = reader.readBoolean();
                boolean right = reader.readBoolean();
                return new MaledictusRingData(yaw, pitch, duration, r, g, b, a, scale, facesCamera,right,entity, EnumRingBehavior.GROW);
            }

            public MaledictusRingData fromNetwork(ParticleType<MaledictusRingData> particleTypeIn, FriendlyByteBuf buffer) {
                return new MaledictusRingData(buffer.readFloat(), buffer.readFloat(), buffer.readInt(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readBoolean(),buffer.readBoolean(), buffer.readInt(), EnumRingBehavior.GROW);
            }
        };

        private final float yaw;
        private final float pitch;
        private final float r;
        private final float g;
        private final float b;
        private final float a;
        private final float scale;
        private final int duration;
        private final boolean facesCamera;
        private final boolean right;
        private final int EntityId;
        private final EnumRingBehavior behavior;

        public MaledictusRingData(float yaw, float pitch, int duration, float r, float g, float b, float a, float scale, boolean facesCamera,boolean right,int entityId, EnumRingBehavior behavior) {
            this.yaw = yaw;
            this.pitch = pitch;
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
            this.scale = scale;
            this.duration = duration;
            this.facesCamera = facesCamera;
            this.right = right;
            this.EntityId = entityId;
            this.behavior = behavior;
        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeFloat(this.r);
            buffer.writeFloat(this.g);
            buffer.writeFloat(this.b);
            buffer.writeFloat(this.scale);
            buffer.writeInt(this.duration);
            buffer.writeInt(this.EntityId);
        }

        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f %.2f %.2f %.2f %d %d %b b", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                    this.yaw, this.pitch, this.r, this.g, this.b, this.scale, this.a, this.duration,this.EntityId, this.facesCamera,this.right);
        }

        @Override
        public ParticleType<MaledictusRingParticle.MaledictusRingData> getType() {
            return ModParticle.MALEDICTUSRING.get();
        }

        @OnlyIn(Dist.CLIENT)
        public float getYaw() {
            return this.yaw;
        }

        @OnlyIn(Dist.CLIENT)
        public float getPitch() {
            return this.pitch;
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
        public float getA() {
            return this.a;
        }

        @OnlyIn(Dist.CLIENT)
        public float getScale() {
            return this.scale;
        }

        @OnlyIn(Dist.CLIENT)
        public int getDuration() {
            return this.duration;
        }

        @OnlyIn(Dist.CLIENT)
        public int getEntity() {
            return this.EntityId;
        }

        @OnlyIn(Dist.CLIENT)
        public boolean getFacesCamera() {
            return this.facesCamera;
        }

        @OnlyIn(Dist.CLIENT)
        public boolean getRight() {
            return this.right;
        }

        @OnlyIn(Dist.CLIENT)
        public EnumRingBehavior getBehavior() {
            return this.behavior;
        }

        public static Codec<MaledictusRingData> CODEC(ParticleType<MaledictusRingData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                    Codec.FLOAT.fieldOf("yaw").forGetter(MaledictusRingData::getYaw),
                    Codec.FLOAT.fieldOf("pitch").forGetter(MaledictusRingData::getPitch),
                    Codec.FLOAT.fieldOf("r").forGetter(MaledictusRingData::getR),
                    Codec.FLOAT.fieldOf("g").forGetter(MaledictusRingData::getG),
                    Codec.FLOAT.fieldOf("b").forGetter(MaledictusRingData::getB),
                    Codec.FLOAT.fieldOf("a").forGetter(MaledictusRingData::getA),
                    Codec.FLOAT.fieldOf("scale").forGetter(MaledictusRingData::getScale),
                    Codec.INT.fieldOf("duration").forGetter(MaledictusRingData::getDuration),
                    Codec.BOOL.fieldOf("facesCamera").forGetter(MaledictusRingData::getFacesCamera),
                    Codec.BOOL.fieldOf("right").forGetter(MaledictusRingData::getRight),
                    Codec.INT.fieldOf("entityid").forGetter(MaledictusRingData::getEntity),
                    Codec.STRING.fieldOf("behavior").forGetter((ringData) -> ringData.getBehavior().toString())
                    ).apply(codecBuilder, (yaw, pitch, r, g, b, a, scale, duration, facesCamera,right,enitityid, behavior) ->
                            new MaledictusRingData(yaw, pitch, duration, r, g, b, a, scale, facesCamera,right,enitityid, EnumRingBehavior.valueOf(behavior)))
            );
        }
    }
}
