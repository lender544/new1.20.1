package com.github.L_Ender.cataclysm.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.Optional;

public class CMMathUtil {
    public static float approachSmooth(float current, float previous, float desired, float desiredSpeed, float deltaSpeed) {
        float prevSpeed = current - previous;
        desiredSpeed = Mth.abs(desiredSpeed);
        desiredSpeed = current < desired ? desiredSpeed : -desiredSpeed;
        float speed = Mth.approach(prevSpeed, desiredSpeed, deltaSpeed);
        float speedApproachReduction = (float) (1.0f - Math.pow(Mth.clamp(-Mth.abs(current - desired)/Mth.abs(2 * desiredSpeed/deltaSpeed) + 1.0f, 0, 1), 4)); // Extra math to make speed smaller when current is close to desired
        speed *= speedApproachReduction;
        return current < desired ? Mth.clamp(current + speed, current, desired) : Mth.clamp(current + speed, desired, current);
    }

    public static float approachDegreesSmooth(float current, float previous, float desired, float desiredSpeed, float deltaSpeed) {
        float desiredDifference = Mth.degreesDifference(current, desired);
        float previousDifference = Mth.degreesDifference(current, previous);
        return approachSmooth(current, current + previousDifference, current + desiredDifference, desiredSpeed, deltaSpeed);
    }

    public static Quaternionf quatFromRotationXYZ(float x, float y, float z, boolean degrees) {
        if (degrees) {
            x *= ((float)Math.PI / 180F);
            y *= ((float)Math.PI / 180F);
            z *= ((float)Math.PI / 180F);
        }
        return (new Quaternionf()).rotationXYZ(x, y, z);
    }

    public static Vec3 getOffsetPos(Entity entity, double offsetX, double offsetY, double offsetZ, float rotationX, float rotationY) {
        Vec3 Vec3 = (new Vec3(offsetZ, offsetY, offsetX)).zRot(rotationX * 0.017453292F).yRot(-rotationY * 0.017453292F - 1.5707964F);
        return entity.position().add(Vec3.x, Vec3.y, Vec3.z);
    }

    public static Vec3 getOffsetMotion(Entity entity, double offsetX, double offsetY, double offsetZ, float rotationX, float rotationY) {
        Vec3 Vec3 = (new Vec3(offsetZ, offsetY, offsetX)).zRot(rotationX * 0.017453292F).yRot(-rotationY * 0.017453292F - 1.5707964F);
        return Vec3;
    }


    public static float smin(float a, float b, float k) {
        float h = Math.max(k - Math.abs(a - b), 0.0F) / k;
        return Math.min(a, b) - h * h * k * (1.0F / 4.0F);
    }

    public static float getAngle(Vec2 a, Vec2 b) {
        return getAngle(a.x, a.y, b.x, b.y);
    }

    public static float getAngle(double ax, double ay, double bx, double by) {
        return (float) (Math.atan2(by - ay, bx - ax)) + (float)Math.PI;// + (a.x > b.x ? Math.PI : 0));
    }


    public static float cullAnimationTick(int tick, float amplitude, float partialTick, int startOffset, int endAt) {
        float i = Mth.clamp(tick + partialTick - startOffset, 0, endAt);
        float f = (float) Math.sin((i / (float) (endAt)) * Math.PI) * amplitude;
        return CMMathUtil.smin(f, 1.0F, 0.1F);
    }




    public static Optional<Vec3> readVec3(CompoundTag tag, String key) {
        ListTag listTag = tag.getList(key, Tag.TAG_DOUBLE);

        if (listTag.size() == 3) {
            double x = listTag.getDouble(0);
            double y = listTag.getDouble(1);
            double z = listTag.getDouble(2);
            return Optional.of(new Vec3(x, y, z));
        } else {
            return Optional.empty();
        }
    }
    public static ListTag writeVec3(Vec3 pos) {
        ListTag listTag = new ListTag();
        listTag.add(DoubleTag.valueOf(pos.x));
        listTag.add(DoubleTag.valueOf(pos.y));
        listTag.add(DoubleTag.valueOf(pos.z));
        return listTag;
    }


    public static Vec3 readVec3(ByteBuf buf) {
        return new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
    }

    public static void writeVec3(ByteBuf buf, Vec3 vec3) {
        buf.writeDouble(vec3.x());
        buf.writeDouble(vec3.y());
        buf.writeDouble(vec3.z());
    }



}
