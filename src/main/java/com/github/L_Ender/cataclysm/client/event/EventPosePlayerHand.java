package com.github.L_Ender.cataclysm.client.event;

import com.github.L_Ender.lionfishapi.client.event.EventGetFluidRenderType;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.Event;



@OnlyIn(Dist.CLIENT)
public class EventPosePlayerHand extends Event {
    private LivingEntity entityIn;
    private HumanoidModel model;
    private boolean left;
    private Result result = Result.DEFAULT;

    public EventPosePlayerHand(LivingEntity entityIn, HumanoidModel model, boolean left) {
        this.entityIn = entityIn;
        this.model = model;
        this.left = left;
    }

    public Entity getEntityIn() {
        return entityIn;
    }

    public HumanoidModel getModel() {
        return model;
    }

    public boolean isLeftHand() {
        return left;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return result;
    }
    public static enum Result {
        /**
         * A spawn attempt will always be made, bypassing all rules described in {@link #DEFAULT}.
         */
        ALLOW,

        /**
         * A spawn attempt will only be made if the dimension does not have skylight
         * <b>or</b> the player's Y-level is above sea level and they can see the sky.
         * <p>
         * Additionally, the local difficulty must be higher than a random threshold in [0, 3)
         * and a random number check based on the player's {@link Stats#TIME_SINCE_REST} must succeed.
         */
        DEFAULT,

        /**
         * A spawn attempt will never be made.
         */
        DENY;
    }
}
