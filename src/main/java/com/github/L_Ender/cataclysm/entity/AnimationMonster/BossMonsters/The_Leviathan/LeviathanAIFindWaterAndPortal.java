package com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Leviathan;

import com.github.L_Ender.cataclysm.entity.etc.ISemiAquatic;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class LeviathanAIFindWaterAndPortal extends Goal {
    private final The_Leviathan_Entity creature;
    private BlockPos targetPos;
    private final int executionChance = 30;

    public LeviathanAIFindWaterAndPortal(The_Leviathan_Entity creature) {
        this.creature = creature;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    public boolean canUse() {
        if (this.creature.onGround() && !this.creature.level().getFluidState(this.creature.blockPosition()).is(FluidTags.WATER)) {
            if (((ISemiAquatic) this.creature).shouldEnterWater() && (this.creature.getTarget() != null || this.creature.getRandom().nextInt(executionChance) == 0)) {
                targetPos = generateTarget();
                return targetPos != null;
            }
        }
        return false;
    }

    public void start() {
        if (targetPos != null) {
            this.creature.getNavigation().moveTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), 1D);
        }
    }

    public void tick() {
        if (targetPos != null) {
            this.creature.getNavigation().moveTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), 1D);
        }
    }

    public boolean canContinueToUse() {
        if (this.creature instanceof ISemiAquatic && !((ISemiAquatic) this.creature).shouldEnterWater()) {
            this.creature.getNavigation().stop();
            return false;
        }
        return !this.creature.getNavigation().isDone() && targetPos != null && !this.creature.level().getFluidState(this.creature.blockPosition()).is(FluidTags.WATER);
    }

    public BlockPos generateTarget() {
        BlockPos blockpos = null;
        final RandomSource random = this.creature.getRandom();
        final int range = this.creature.getWaterSearchRange();
        for(int i = 0; i < 15; i++) {
            BlockPos blockPos = this.creature.blockPosition().offset(random.nextInt(range) - range/2, 3, random.nextInt(range) - range/2);
            while (this.creature.level().isEmptyBlock(blockPos) && blockPos.getY() > 1) {
                blockPos = blockPos.below();
            }

            if (this.creature.level().getFluidState(blockPos).is(FluidTags.WATER)) {
                blockpos = blockPos;
            }
        }
        return blockpos;
    }
}
