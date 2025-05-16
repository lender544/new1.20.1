package com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ClawdianMoveController extends MoveControl {


    public ClawdianMoveController(Mob mob) {
        super(mob);
    }

    public boolean hasWanted() {
        return this.operation == MoveControl.Operation.MOVE_TO;
    }

    public double getSpeedModifier() {
        return super.getSpeedModifier();
    }

    /**
     * Sets the speed and location to move to
     */
    public void setWantedPosition(double x, double y, double z, double speed) {
        this.wantedX = x;
        this.wantedY = y;
        this.wantedZ = z;
        this.speedModifier = speed;
        if (this.operation != MoveControl.Operation.JUMPING) {
            this.operation = MoveControl.Operation.MOVE_TO;
        }
    }

    public void strafe(float forward, float strafe) {
        this.operation = MoveControl.Operation.STRAFE;
        this.strafeForwards = forward;
        this.strafeRight = strafe;
        this.speedModifier = 1.15;
    }

    public void tick() {
        if (this.operation == MoveControl.Operation.STRAFE) {
            float baseSpeed = (float)this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED);
            float adjustedSpeed = (float)this.speedModifier * baseSpeed;

            float forward = this.strafeForwards;
            float right = this.strafeRight;
            float mag = Mth.sqrt(forward * forward + right * right);
            if (mag < 1.0F) {
                mag = 1.0F;
            }

            forward *= adjustedSpeed / mag;
            right *= adjustedSpeed / mag;

            float yawRad = this.mob.getYRot() * (float)(Math.PI / 180.0);
            float sin = Mth.sin(yawRad);
            float cos = Mth.cos(yawRad);

            float dx = forward * cos - right * sin;
            float dz = right * cos + forward * sin;

            if (isWalkable(dx, dz)) {
                this.mob.setSpeed(adjustedSpeed);
                this.mob.setZza(this.strafeForwards);
                this.mob.setXxa(this.strafeRight);
            } else {
                this.mob.setZza(0.0F);
                this.mob.setXxa(0.0F);
            }

            this.operation = MoveControl.Operation.WAIT;
        } else if (this.operation == MoveControl.Operation.MOVE_TO) {
            this.operation = MoveControl.Operation.WAIT;
            double d0 = this.wantedX - this.mob.getX();
            double d1 = this.wantedZ - this.mob.getZ();
            double d2 = this.wantedY - this.mob.getY();
            double d3 = d0 * d0 + d2 * d2 + d1 * d1;
            if (d3 < 2.5000003E-7F) {
                this.mob.setZza(0.0F);
                return;
            }

            float f9 = (float)(Mth.atan2(d1, d0) * 180.0F / (float)Math.PI) - 90.0F;
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f9, 90.0F));
            this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            BlockPos blockpos = this.mob.blockPosition();
            BlockState blockstate = this.mob.level().getBlockState(blockpos);
            VoxelShape voxelshape = blockstate.getCollisionShape(this.mob.level(), blockpos);
            if (d2 > (double)this.mob.maxUpStep() && d0 * d0 + d1 * d1 < (double)Math.max(1.0F, this.mob.getBbWidth())
                    || !voxelshape.isEmpty()
                    && this.mob.getY() < voxelshape.max(Direction.Axis.Y) + (double)blockpos.getY()
                    && !blockstate.is(BlockTags.DOORS)
                    && !blockstate.is(BlockTags.FENCES)) {
                this.mob.getJumpControl().jump();
                this.operation = MoveControl.Operation.JUMPING;
            }
        } else if (this.operation == MoveControl.Operation.JUMPING) {
            this.mob.setSpeed((float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            if (this.mob.onGround()) {
                this.operation = MoveControl.Operation.WAIT;
            }
        } else {
            this.mob.setZza(0.0F);
        }
    }

    private boolean isWalkable(float relativeX, float relativeZ) {
        double targetX = this.mob.getX() + relativeX;
        double targetZ = this.mob.getZ() + relativeZ;
        double currentY = this.mob.getBlockY();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(targetX, currentY, targetZ);

        PathNavigation nav = this.mob.getNavigation();
        NodeEvaluator eval = nav != null ? nav.getNodeEvaluator() : null;
        if (eval != null) {
            PathType type = eval.getPathType(this.mob, pos);
            if (type != PathType.WALKABLE && type != PathType.OPEN) return false;
        }

        int maxFall = (int) this.mob.getBbHeight();
        for (int i = 0; i <= maxFall; i++) {
            BlockPos below = pos.below(i);
            VoxelShape shape = this.mob.level().getBlockState(below).getCollisionShape(this.mob.level(), below);
            if (!shape.isEmpty()) {
                double groundY = below.getY() + shape.max(Direction.Axis.Y);
                double dy = groundY - currentY;
                return dy <= this.mob.maxUpStep() && dy >= -this.mob.getMaxFallDistance();
            }
        }

        return false;
    }

    /**
     * Attempt to rotate the first angle to become the second angle, but only allow overall direction change to at max be third parameter
     */
    protected float rotlerp(float sourceAngle, float targetAngle, float maximumChange) {
        float f = Mth.wrapDegrees(targetAngle - sourceAngle);
        if (f > maximumChange) {
            f = maximumChange;
        }

        if (f < -maximumChange) {
            f = -maximumChange;
        }

        float f1 = sourceAngle + f;
        if (f1 < 0.0F) {
            f1 += 360.0F;
        } else if (f1 > 360.0F) {
            f1 -= 360.0F;
        }

        return f1;
    }

    public double getWantedX() {
        return this.wantedX;
    }

    public double getWantedY() {
        return this.wantedY;
    }

    public double getWantedZ() {
        return this.wantedZ;
    }
}
