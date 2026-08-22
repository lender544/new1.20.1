package com.github.L_Ender.cataclysm.client.render.etc;

import com.github.L_Ender.cataclysm.client.render.CMRenderTypes;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.List;

//https://github.com/Violunae/arrowtrails/blob/d94f3866bbf33241e57e1166f7bd5351dbded68f/common/src/main/java/com/biverom/arrowtrails/TrailRenderer.java
public final class TrailRenderer {

    private TrailRenderer() {
    }

    private static final int MAX_SUB_STEPS = 8;

    private static final double LOD_SUB_8_SQ = 16.0 * 16.0;
    private static final double LOD_SUB_4_SQ = 32.0 * 32.0;
    private static final double LOD_SUB_2_SQ = 64.0 * 64.0;

    private static final double CROSS_RIBBON_SQ = 24.0 * 24.0;

    private static final double CULL_SQ = 128.0 * 128.0;

    // ------------------------------------------------------------------

    private static final float[][] CR_WEIGHTS = buildCatmullRomWeights();

    private static float[][] buildCatmullRomWeights() {
        float[][] table = new float[MAX_SUB_STEPS + 1][];
        for (int subSteps = 1; subSteps <= MAX_SUB_STEPS; subSteps++) {
            float[] w = new float[subSteps * 4];
            for (int step = 1; step <= subSteps; step++) {
                double t = step / (double) subSteps;
                double t2 = t * t;
                double t3 = t2 * t;
                int base = (step - 1) * 4;
                w[base]     = (float) (0.5 * (-t + 2.0 * t2 - t3));
                w[base + 1] = (float) (0.5 * (2.0 - 5.0 * t2 + 3.0 * t3));
                w[base + 2] = (float) (0.5 * (t + 4.0 * t2 - 3.0 * t3));
                w[base + 3] = (float) (0.5 * (-t2 + t3));
            }
            table[subSteps] = w;
        }
        return table;
    }

    private static final int STRIDE = 12;

    private static float[] smoothX = new float[0];
    private static float[] smoothY = new float[0];
    private static float[] smoothZ = new float[0];
    private static float[] ribbon = new float[0];

    private static float m00, m01, m02, m10, m11, m12, m20, m21, m22, m30, m31, m32;

    private static final Vector3f TEMP_NORMAL = new Vector3f();

    public static void drawTrail(
            Vec3 anchor,
            List<Vec3> points,
            PoseStack.Pose pose,
            int packedLight,
            float partialTicks,
            TrailSettings settings,
            MultiBufferSource bufferSource
    ) {
        drawTrailRaw(anchor, points, pose, packedLight, partialTicks, settings, bufferSource);
    }

    public static void drawTrailRaw(
            Vec3 anchor,
            List<Vec3> points,
            PoseStack.Pose pose,
            int packedLight,
            float partialTicks,
            TrailSettings settings,
            MultiBufferSource bufferSource
    ) {
        int pointCount = points.size();
        if (pointCount < 2) {
            return;
        }

        float startWidth = settings.startWidth();
        float endWidth = settings.endWidth();
        float startAlpha = settings.startAlpha();
        float endAlpha = settings.endAlpha();
        if ((startWidth <= 0.0F && endWidth <= 0.0F) || (startAlpha <= 0.0F && endAlpha <= 0.0F)) {
            return;
        }

        Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();
        if (camera == null) {
            return;
        }
        Vec3 cameraPos = camera.getPosition(); // stored vector, no allocation

        double dx = anchor.x - cameraPos.x;
        double dy = anchor.y - cameraPos.y;
        double dz = anchor.z - cameraPos.z;
        double distSq = dx * dx + dy * dy + dz * dz;
        if (distSq > CULL_SQ) {
            return;
        }

        int subSteps;
        if (distSq < LOD_SUB_8_SQ) {
            subSteps = MAX_SUB_STEPS;
        } else if (distSq < LOD_SUB_4_SQ) {
            subSteps = 4;
        } else if (distSq < LOD_SUB_2_SQ) {
            subSteps = 2;
        } else {
            subSteps = 1;
        }
        boolean crossRibbon = distSq < CROSS_RIBBON_SQ;

        int capacity = (pointCount - 1) * subSteps + 1;
        ensureCapacity(capacity);

        int newSize = buildSmoothedPath(points, pointCount, anchor, subSteps);
        if (newSize < 2) {
            return;
        }

        float total = settings.length() + 1.0F;

        float tStart = partialTicks / total;
        float tStep = 1.0F / (subSteps * total);

        Matrix4f matrix = pose.pose();
        m00 = matrix.m00(); m01 = matrix.m01(); m02 = matrix.m02();
        m10 = matrix.m10(); m11 = matrix.m11(); m12 = matrix.m12();
        m20 = matrix.m20(); m21 = matrix.m21(); m22 = matrix.m22();
        m30 = matrix.m30(); m31 = matrix.m31(); m32 = matrix.m32();

        buildRibbon(newSize,
                (float) (cameraPos.x - anchor.x),
                (float) (cameraPos.y - anchor.y),
                (float) (cameraPos.z - anchor.z),
                tStart, tStep, startWidth, endWidth, crossRibbon);

        TEMP_NORMAL.set(0.0F, 0.0F, 1.0F);
        pose.normal().transform(TEMP_NORMAL);

        emitQuads(bufferSource, packedLight, newSize, tStart, tStep, crossRibbon, settings,
                startAlpha, endAlpha);
    }

    private static int buildSmoothedPath(List<Vec3> points, int pointCount, Vec3 anchor, int subSteps) {
        final double ax = anchor.x;
        final double ay = anchor.y;
        final double az = anchor.z;
        final float[] w = CR_WEIGHTS[subSteps];

        Vec3 v1 = points.get(0);
        Vec3 v2 = points.get(1);
        Vec3 v3 = points.get(Math.min(pointCount - 1, 2));

        float p1x = (float) (v1.x - ax), p1y = (float) (v1.y - ay), p1z = (float) (v1.z - az);
        float p0x = p1x, p0y = p1y, p0z = p1z;
        float p2x = (float) (v2.x - ax), p2y = (float) (v2.y - ay), p2z = (float) (v2.z - az);
        float p3x = (float) (v3.x - ax), p3y = (float) (v3.y - ay), p3z = (float) (v3.z - az);

        int index = 0;
        smoothX[index] = p1x;
        smoothY[index] = p1y;
        smoothZ[index] = p1z;
        index++;

        for (int i = 0; i < pointCount - 1; i++) {
            for (int step = 1; step <= subSteps; step++) {
                int base = (step - 1) * 4;
                float w0 = w[base];
                float w1 = w[base + 1];
                float w2 = w[base + 2];
                float w3 = w[base + 3];

                smoothX[index] = w0 * p0x + w1 * p1x + w2 * p2x + w3 * p3x;
                smoothY[index] = w0 * p0y + w1 * p1y + w2 * p2y + w3 * p3y;
                smoothZ[index] = w0 * p0z + w1 * p1z + w2 * p2z + w3 * p3z;
                index++;
            }

            // Advance the window for the next segment.
            if (i + 1 < pointCount - 1) {
                p0x = p1x; p0y = p1y; p0z = p1z;
                p1x = p2x; p1y = p2y; p1z = p2z;
                p2x = p3x; p2y = p3y; p2z = p3z;

                Vec3 next = points.get(Math.min(pointCount - 1, i + 3));
                p3x = (float) (next.x - ax);
                p3y = (float) (next.y - ay);
                p3z = (float) (next.z - az);
            }
        }

        return index;
    }

    private static void buildRibbon(int newSize, float camX, float camY, float camZ,
                                    float tStart, float tStep,
                                    float startWidth, float endWidth, boolean crossRibbon) {
        for (int i = 0; i < newSize; i++) {
            float px = smoothX[i];
            float py = smoothY[i];
            float pz = smoothZ[i];

            float t = tStart + i * tStep;
            float w = Mth.lerp(t, startWidth, endWidth) * 0.5F;

            float dx, dy, dz;
            if (i == newSize - 1) {
                dx = px - smoothX[i - 1];
                dy = py - smoothY[i - 1];
                dz = pz - smoothZ[i - 1];
            } else {
                dx = smoothX[i + 1] - px;
                dy = smoothY[i + 1] - py;
                dz = smoothZ[i + 1] - pz;
            }

            float lenSq = dx * dx + dy * dy + dz * dz;
            if (lenSq < 1.0e-12F) {
                dx = 0.0F;
                dy = 1.0F;
                dz = 0.0F;
            } else {
                float inv = (float) (1.0 / Math.sqrt(lenSq));
                dx *= inv;
                dy *= inv;
                dz *= inv;
            }

            float vx = camX - px;
            float vy = camY - py;
            float vz = camZ - pz;
            float viewLenSq = vx * vx + vy * vy + vz * vz;

            float cx = dy * vz - dz * vy;
            float cy = dz * vx - dx * vz;
            float cz = dx * vy - dy * vx;
            float crossLenSq = cx * cx + cy * cy + cz * cz;

            if (crossLenSq < viewLenSq * 1.0e-8F || viewLenSq < 1.0e-12F) {
                // Direction is parallel to the view ray: fall back to up, then right.
                cx = -dz; cy = 0.0F; cz = dx;
                crossLenSq = cx * cx + cz * cz;
                if (crossLenSq < 1.0e-10F) {
                    cx = 0.0F; cy = dz; cz = -dy;
                    crossLenSq = cy * cy + cz * cz;
                    if (crossLenSq < 1.0e-10F) {
                        cx = 1.0F; cy = 0.0F; cz = 0.0F;
                        crossLenSq = 1.0F;
                    }
                }
            }

            float invCross = (float) (1.0 / Math.sqrt(crossLenSq));
            float s1x = cx * invCross;
            float s1y = cy * invCross;
            float s1z = cz * invCross;

            float s2x = dy * s1z - dz * s1y;
            float s2y = dz * s1x - dx * s1z;
            float s2z = dx * s1y - dy * s1x;

            s1x *= w; s1y *= w; s1z *= w;
            s2x *= w; s2y *= w; s2z *= w;

            int o = i * STRIDE;
            put(o,     px + s1x, py + s1y, pz + s1z);
            put(o + 3, px - s1x, py - s1y, pz - s1z);
            if (crossRibbon) {
                put(o + 6, px + s2x, py + s2y, pz + s2z);
                put(o + 9, px - s2x, py - s2y, pz - s2z);
            }
        }
    }

    private static void put(int offset, float x, float y, float z) {
        ribbon[offset]     = m00 * x + m10 * y + m20 * z + m30;
        ribbon[offset + 1] = m01 * x + m11 * y + m21 * z + m31;
        ribbon[offset + 2] = m02 * x + m12 * y + m22 * z + m32;
    }

    private static void emitQuads(MultiBufferSource bufferSource, int packedLight, int newSize,
                                  float tStart, float tStep, boolean crossRibbon,
                                  TrailSettings settings, float startAlpha, float endAlpha) {
        VertexConsumer consumer = bufferSource.getBuffer(CMRenderTypes.Trails());

        Vector3f startColor = settings.startColor();
        Vector3f endColor = settings.endColor();
        float sr = startColor.x, sg = startColor.y, sb = startColor.z;
        float er = endColor.x, eg = endColor.y, eb = endColor.z;

        float nx = TEMP_NORMAL.x;
        float ny = TEMP_NORMAL.y;
        float nz = TEMP_NORMAL.z;

        float t1 = tStart;
        float r1 = Mth.lerp(t1, sr, er);
        float g1 = Mth.lerp(t1, sg, eg);
        float b1 = Mth.lerp(t1, sb, eb);
        float a1 = Mth.lerp(t1, startAlpha, endAlpha);

        for (int i = 0; i < newSize - 1; i++) {
            float t2 = tStart + (i + 1) * tStep;
            float r2 = Mth.lerp(t2, sr, er);
            float g2 = Mth.lerp(t2, sg, eg);
            float b2 = Mth.lerp(t2, sb, eb);
            float a2 = Mth.lerp(t2, startAlpha, endAlpha);

            int o = i * STRIDE;
            int n = o + STRIDE;

            vertex(consumer, packedLight, o,     r1, g1, b1, a1, nx, ny, nz);
            vertex(consumer, packedLight, n,     r2, g2, b2, a2, nx, ny, nz);
            vertex(consumer, packedLight, n + 3, r2, g2, b2, a2, nx, ny, nz);
            vertex(consumer, packedLight, o + 3, r1, g1, b1, a1, nx, ny, nz);

            if (crossRibbon) {
                vertex(consumer, packedLight, o + 6, r1, g1, b1, a1, nx, ny, nz);
                vertex(consumer, packedLight, n + 6, r2, g2, b2, a2, nx, ny, nz);
                vertex(consumer, packedLight, n + 9, r2, g2, b2, a2, nx, ny, nz);
                vertex(consumer, packedLight, o + 9, r1, g1, b1, a1, nx, ny, nz);
            }

            r1 = r2;
            g1 = g2;
            b1 = b2;
            a1 = a2;
        }
    }

    private static void ensureCapacity(int size) {
        if (smoothX.length < size) {
            smoothX = new float[size];
            smoothY = new float[size];
            smoothZ = new float[size];
            ribbon = new float[size * STRIDE];
        }
    }

    private static void vertex(VertexConsumer consumer, int packedLight, int offset,
                               float r, float g, float b, float a,
                               float nx, float ny, float nz) {
        consumer.addVertex(ribbon[offset], ribbon[offset + 1], ribbon[offset + 2])
                .setColor(r, g, b, a)
                .setUv(0, 0)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(packedLight)
                .setNormal(nx, ny, nz);
    }
}