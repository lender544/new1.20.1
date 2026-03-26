package com.github.L_Ender.cataclysm.entity.etc;

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
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FowardMoveController extends MoveControl {
    protected FowardOperation operation = FowardOperation.WAIT;

    public FowardMoveController(Mob mob) {
        super(mob);
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
        if (this.operation != FowardOperation.JUMPING) {
            this.operation = FowardOperation.MOVE_TO;
        }
    }

    public void strafe(float forward, float strafe) {
        this.operation = FowardOperation.STRAFE;
        this.strafeForwards = forward;
        this.strafeRight = strafe;
        this.speedModifier = 0.15f;
    }


    public void forward(float forward, float speed) {
        this.operation = FowardOperation.FORWARD;
        this.strafeForwards = forward;
        this.speedModifier = speed;
    }

    public void tick() {
        if (this.operation == FowardOperation.STRAFE) {
            float f = (float)this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED);
            float f1 = (float)this.speedModifier * f;
            float f2 = this.strafeForwards;
            float f3 = this.strafeRight;
            float f4 = Mth.sqrt(f2 * f2 + f3 * f3);
            if (f4 < 1.0F) {
                f4 = 1.0F;
            }

            f4 = f1 / f4;
            f2 *= f4;
            f3 *= f4;
            float f5 = Mth.sin(this.mob.getYRot() * (float) (Math.PI / 180.0));
            float f6 = Mth.cos(this.mob.getYRot() * (float) (Math.PI / 180.0));
            float f7 = f2 * f6 - f3 * f5;
            float f8 = f3 * f6 + f2 * f5;
            if (!this.isWalkable(f7, f8)) {
                this.strafeForwards = 1.0F;
                this.strafeRight = 0.0F;
            }

            this.mob.setSpeed(f1);
            this.mob.setZza(this.strafeForwards);
            this.mob.setXxa(this.strafeRight);
            this.operation = FowardOperation.WAIT;
        } else if (this.operation == FowardOperation.FORWARD) {
            this.strafeRight = 0.0F;
            ForwardMoveControl();
            this.operation = FowardOperation.WAIT;
        } else if (this.operation == FowardOperation.MOVE_TO) {
            this.operation = FowardOperation.WAIT;
            double d0 = this.wantedX - this.mob.getX();
            double d1 = this.wantedZ - this.mob.getZ();
            double d2 = this.wantedY - this.mob.getY();
            double d3 = d0 * d0 + d2 * d2 + d1 * d1;
            if (d3 < 2.5000003E-7F) {
                this.mob.setZza(0.0F);
                return;
            }

            float f9 = (float) (Mth.atan2(d1, d0) * 180.0F / (float) Math.PI) - 90.0F;
            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), f9, 90.0F));
            this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            BlockPos blockpos = this.mob.blockPosition();
            BlockState blockstate = this.mob.level().getBlockState(blockpos);
            VoxelShape voxelshape = blockstate.getCollisionShape(this.mob.level(), blockpos);
            if (d2 > (double) this.mob.maxUpStep() && d0 * d0 + d1 * d1 < (double) Math.max(1.0F, this.mob.getBbWidth())
                    || !voxelshape.isEmpty()
                    && this.mob.getY() < voxelshape.max(Direction.Axis.Y) + (double) blockpos.getY()
                    && !blockstate.is(BlockTags.DOORS)
                    && !blockstate.is(BlockTags.FENCES)) {
                this.mob.getJumpControl().jump();
                this.operation = FowardOperation.JUMPING;
            }
        } else if (this.operation == FowardOperation.JUMPING) {
            this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            if (this.mob.onGround()) {
                this.operation = FowardOperation.WAIT;
            }
        } else {
            this.mob.setZza(0.0F);
        }
    }

    private void ForwardMoveControl() {
        float speedAttr = (float)this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED);
        float finalSpeed = (float)this.speedModifier * speedAttr;

        float fForward = this.strafeForwards;
        float fStrafe = this.strafeRight;

        float dist = Mth.sqrt(fForward * fForward + fStrafe * fStrafe);
        if (dist < 1.0F) dist = 1.0F;

        fForward = fForward / dist;
        fStrafe = fStrafe / dist;

        float sin = Mth.sin(this.mob.getYRot() * ((float)Math.PI / 180F));
        float cos = Mth.cos(this.mob.getYRot() * ((float)Math.PI / 180F));

        float worldRelX = fStrafe * cos - fForward * sin;
        float worldRelZ = fForward * cos + fStrafe * sin;

        if (!this.isWalkableForward(worldRelX, worldRelZ)) {
            this.strafeForwards = 0.0F;
            this.strafeRight = 0.0F;
            this.mob.setZza(0.0F);
            this.mob.setXxa(0.0F);
            this.mob.setSpeed(0.0F);
            return;
        }
        fForward *= finalSpeed;
        fStrafe *= finalSpeed;

        this.mob.setSpeed(finalSpeed);
        this.mob.setZza(fForward);
        this.mob.setXxa(fStrafe);
    }

    /**
     * @return true if the mob can walk successfully to a given X and Z
     */
    private boolean isWalkableForward(float worldRelX, float worldRelZ) {
        float lenSq = worldRelX * worldRelX + worldRelZ * worldRelZ;
        if (lenSq < 1.0E-5F) return true;

        float lookAheadDist = (this.mob.getBbWidth() / 2.0F) + 1.2F;

        float len = Mth.sqrt(lenSq);

        float checkX = (worldRelX / len) * lookAheadDist;
        float checkZ = (worldRelZ / len) * lookAheadDist;

        BlockPos targetPos = BlockPos.containing(
                this.mob.getX() + checkX,
                this.mob.getY(),
                this.mob.getZ() + checkZ
        );

        int maxFallDist = 4;

        for (int i = 0; i <= maxFallDist; i++) {
            BlockPos checkPos = targetPos.below(i);
            BlockState state = this.mob.level().getBlockState(checkPos);
            boolean isSolid = !state.isAir()
                    && state.getFluidState().isEmpty()
                    && !state.getCollisionShape(this.mob.level(), checkPos).isEmpty();

            if (isSolid) {
                if (i == 0) return true;

                return true;
            }
        }

        return false;
    }

    /**
     * @return true if the mob can walk successfully to a given X and Z
     */
    private boolean isWalkable(float relativeX, float p_24998_) {
        PathNavigation pathnavigation = this.mob.getNavigation();
        if (pathnavigation != null) {
            NodeEvaluator nodeevaluator = pathnavigation.getNodeEvaluator();
            if (nodeevaluator != null && nodeevaluator.getBlockPathType(this.mob.level(), Mth.floor(this.mob.getX() + (double)relativeX), Mth.floor(this.mob.getBlockY()), Mth.floor(this.mob.getZ() + (double)p_24998_)) != BlockPathTypes.WALKABLE) {
                return false;
            }
        }

        return true;
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

    protected static enum FowardOperation {
        WAIT,
        MOVE_TO,
        FORWARD,
        STRAFE,
        JUMPING;
    }

}

