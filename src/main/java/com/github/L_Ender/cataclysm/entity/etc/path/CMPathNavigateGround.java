package com.github.L_Ender.cataclysm.entity.etc.path;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

public class CMPathNavigateGround extends GroundPathNavigation {
    public CMPathNavigateGround(Mob mob, Level world) {
        super(mob, world);
    }

    @Override
    protected PathFinder createPathFinder(int maxVisitedNodes) {
        this.nodeEvaluator = new WalkNodeEvaluator();
        this.nodeEvaluator.setCanPassDoors(true);
        return new CMPathFinder(this.nodeEvaluator, maxVisitedNodes);
    }

    @Override
    protected void followThePath() {
        Path path = Objects.requireNonNull(this.path);
        Vec3 entityPos = this.getTempMobPos();
        int pathLength = path.getNodeCount();
        for (int i = path.getNextNodeIndex(); i < path.getNodeCount(); i++) {
            if (path.getNode(i).y != Math.floor(entityPos.y)) {
                pathLength = i;
                break;
            }
        }
        final Vec3 base = entityPos.add(-this.mob.getBbWidth() * 0.5F, 0.0F, -this.mob.getBbWidth() * 0.5F);
        final Vec3 max = base.add(this.mob.getBbWidth(), this.mob.getBbHeight(), this.mob.getBbWidth());
        if (this.tryShortcut(path, new Vec3(this.mob.getX(), this.mob.getY(), this.mob.getZ()), pathLength, base, max)) {
            if (this.isAt(path, 0.5F) || this.atElevationChange(path) && this.isAt(path, this.mob.getBbWidth() * 0.5F)) {
                path.setNextNodeIndex(path.getNextNodeIndex() + 1);
            }
        }
        this.doStuckDetection(entityPos);
    }

    private boolean isAt(Path path, float threshold) {
        final Vec3 pathPos = path.getNextEntityPos(this.mob);
        return Mth.abs((float) (this.mob.getX() - pathPos.x)) < threshold &&
                Mth.abs((float) (this.mob.getZ() - pathPos.z)) < threshold &&
                Math.abs(this.mob.getY() - pathPos.y) < 1.0D;
    }

    private boolean atElevationChange(Path path) {
        final int curr = path.getNextNodeIndex();
        final int end = Math.min(path.getNodeCount(), curr + Mth.ceil(this.mob.getBbWidth() * 0.5F) + 1);
        final int currY = path.getNode(curr).y;
        for (int i = curr + 1; i < end; i++) {
            if (path.getNode(i).y != currY) {
                return true;
            }
        }
        return false;
    }

    private boolean tryShortcut(Path path, Vec3 entityPos, int pathLength, Vec3 base, Vec3 max) {
        for (int i = pathLength - 1; i > path.getNextNodeIndex(); i--) {
            Vec3 target = path.getEntityPosAtNode(this.mob, i);
            if (sweep(target.subtract(entityPos), base, max)) {
                continue;
            }
            path.setNextNodeIndex(i);
            return false;
        }
        return true;
    }

    static final float EPSILON = 1.0E-8F;

    private boolean sweep(Vec3 vec, Vec3 base, Vec3 max) {
        float length = (float) vec.length();
        if (length < EPSILON) return true;

        float[] normed = {(float) vec.x / length, (float) vec.y / length, (float) vec.z / length};
        int[] step = new int[3];
        float[] tDelta = new float[3];
        float[] tNext = new float[3];
        float[] lead = { (float) base.x, (float) base.y, (float) base.z };
        float[] trail = { (float) max.x, (float) max.y, (float) max.z };
        int[] ldi = new int[3];

        for (int i = 0; i < 3; i++) {
            float v = normed[i] * length;
            step[i] = v >= 0 ? 1 : -1;
            float leadCoord = step[i] > 0 ? trail[i] : lead[i];
            float trailCoord = step[i] > 0 ? lead[i] : trail[i];
            ldi[i] = leadEdgeToInt(leadCoord, step[i]);
            tDelta[i] = v != 0.0F ? Mth.abs(length / v) : Float.POSITIVE_INFINITY;
            float dist = step[i] > 0 ? (ldi[i] + 1 - leadCoord) : (leadCoord - ldi[i]);
            tNext[i] = tDelta[i] < Float.POSITIVE_INFINITY ? tDelta[i] * dist : Float.POSITIVE_INFINITY;
        }

        return true;
    }


    protected boolean hasValidPathType(PathType p_26467_) {
        if (p_26467_ == PathType.WATER) {
            return false;
        } else if (p_26467_ == PathType.LAVA) {
            return false;
        } else {
            return p_26467_ != PathType.OPEN;
        }
    }

    static int leadEdgeToInt(float coord, int step) {
        return Mth.floor(coord - step * EPSILON);
    }

    static int trailEdgeToInt(float coord, int step) {
        return Mth.floor(coord + step * EPSILON);
    }

    static float element(Vec3 v, int i) {
        switch (i) {
            case 0: return (float) v.x;
            case 1: return (float) v.y;
            case 2: return (float) v.z;
            default: return 0.0F;
        }
    }
}
