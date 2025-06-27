package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.LookControl;

public class LeviathanSwimmingLookControl extends LookControl {
    private final int maxYRotFromCenter;
    private static final int HEAD_TILT_X = 10;
    private static final int HEAD_TILT_Y = 20;

    public LeviathanSwimmingLookControl(Mob p_148061_, int p_148062_) {
        super(p_148061_);
        this.maxYRotFromCenter = p_148062_;
    }

    public void tick() {
        if (this.lookAtCooldown > 0) {
            --this.lookAtCooldown;
            this.getYRotD().ifPresent((p_181130_) -> {
                this.mob.yHeadRot = this.rotateTowards(this.mob.yHeadRot, p_181130_, this.yMaxRotSpeed);
            });
            this.getXRotD().ifPresent((p_181128_) -> {
                this.mob.setXRot(this.rotateTowards(this.mob.getXRot(), p_181128_, this.xMaxRotAngle));
            });
        } else {
            this.mob.yHeadRot = this.rotateTowards(this.mob.yHeadRot, this.mob.yBodyRot, 10.0F);
        }

        float f = Mth.wrapDegrees(this.mob.yHeadRot - this.mob.yBodyRot);
        if (f < (float)(-this.maxYRotFromCenter)) {
            this.mob.yBodyRot -= 4.0F;
        } else if (f > (float)this.maxYRotFromCenter) {
            this.mob.yBodyRot += 4.0F;
        }

    }
}
