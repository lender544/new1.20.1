package com.github.L_Ender.cataclysm.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.Nullable;
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

    public static float lerp(float v1, float v2, float p) {
        return v1 + (v2 - v1) * p;
    }

    public static double lerp(double v1, double v2, double p) {
        return v1 + (v2 - v1) * p;
    }

    public static Vector3f interpolateVectors(Vector3f v1, Vector3f v2, float p) {
        return new Vector3f(lerp(v1.x, v2.x, p), lerp(v1.y, v2.y, p), lerp(v1.z, v2.z, p));
    }

    public static Vec3 interpolateVectors(Vec3 v1, Vec3 v2, float p) {
        return new Vec3(lerp(v1.x, v2.x, (double)p), lerp(v1.y, v2.y, (double)p), lerp(v1.z, v2.z, (double)p));
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

    public static ItemStack readItemStack(RegistryFriendlyByteBuf from) {
        try {
            return ItemStack.OPTIONAL_STREAM_CODEC.decode(from);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeItemStack(RegistryFriendlyByteBuf to, ItemStack stack) {
        ItemStack.OPTIONAL_STREAM_CODEC.encode(to, stack);
    }

    public static void writeOptionalVec3(RegistryFriendlyByteBuf buffer, @Nullable Vec3 vec3) {
        buffer.writeBoolean(vec3 != null);
        if (vec3 != null) {
            buffer.writeDouble(vec3.x);
            buffer.writeDouble(vec3.y);
            buffer.writeDouble(vec3.z);
        }
    }

    @Nullable
    public static Vec3 readOptionalVec3(RegistryFriendlyByteBuf buffer) {
        Vec3 result = null;
        if (buffer.readBoolean()) {
            result = new Vec3(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
        }
        return result;
    }


    public static Vec2 applyHorizontalHitAngleScale(float horizontalAngleScale, Vec2 originalAngle, Vec3 attackerPosition, Vec3 attackerAimDirection, Vec3 targetCenter) {
        Vec3 attackerToTarget = targetCenter.subtract(attackerPosition).normalize();
        float angleDiff = (float)Math.atan2(attackerAimDirection.x * attackerToTarget.z - attackerAimDirection.z * attackerToTarget.x, attackerAimDirection.x * attackerToTarget.x + attackerAimDirection.z * attackerToTarget.z);
        return rotateVec2(originalAngle, angleDiff * horizontalAngleScale);
    }

    public static Vec2 applyVerticalHitAnglePowerTransfer(float verticalHitAngleScale, float horizontalPower, float verticalPower, Vec3 attackerPosition, Vec3 attackerAimDirection, Vec3 targetCenteredPosition, float targetHeight) {
        float targetHalfHeight = 0.5F * targetHeight;
        Vec3 targetTopPos = targetCenteredPosition.add(0.0D, targetHalfHeight, 0.0D);
        Vec3 targetBottomPos = targetCenteredPosition.add(0.0D, -targetHalfHeight, 0.0D);

        Vec3 attackerToTargetTop = targetTopPos.subtract(attackerPosition).normalize();
        Vec3 attackerToTargetBottom = targetBottomPos.subtract(attackerPosition).normalize();

        float verticalHitAngleFactor = (float)Mth.clampedMap(attackerAimDirection.y, attackerToTargetTop.y, attackerToTargetBottom.y, -1.0D, 1.0D);
        float transferredPowerRatio = Math.abs(verticalHitAngleFactor * verticalHitAngleScale);

        if (verticalHitAngleFactor < 0.0F) transferredPowerRatio = -transferredPowerRatio;

        return new Vec2(horizontalPower * (1.0F - transferredPowerRatio), verticalPower * (1.0F + transferredPowerRatio));
    }

    public static Vec2 applyVerticalPositionAnglePowerRotation(float verticalPositionAngleScale, float horizontalPower, float verticalPower, Vec3 attackerFeetPosition, Vec3 targetFeetPosition) {
        Vec3 attackerFeetToTargetFeet = targetFeetPosition.subtract(attackerFeetPosition);
        float verticalPositionAngle = (float)Math.atan2(-attackerFeetToTargetFeet.y, attackerFeetToTargetFeet.horizontalDistance());
        Vec2 powerBeforeRotation = new Vec2(horizontalPower, verticalPower);
        return rotateVec2(powerBeforeRotation, -verticalPositionAngle * verticalPositionAngleScale);
    }

    public static Vec2 rotateVec2(Vec2 vec, double angleRadians) {
        double cos = Math.cos(angleRadians);
        double sin = Math.sin(angleRadians);
        return new Vec2((float)(vec.x * cos - vec.y * sin), (float)(vec.x * sin + vec.y * cos));
    }

}
