package com.github.L_Ender.cataclysm.mixin.Client;

import com.github.L_Ender.cataclysm.client.event.EventPosePlayerHand;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Function;

@Mixin(HumanoidModel.class)
public abstract class HumanoidModelMixin extends Model {

    public HumanoidModelMixin(Function<ResourceLocation, RenderType> p_103110_) {
        super(p_103110_);
    }

    @Inject(at = @At("HEAD"), remap = true, method = "Lnet/minecraft/client/model/HumanoidModel;poseRightArm(Lnet/minecraft/world/entity/LivingEntity;)V", cancellable = true)
    private void custom_poseRightArm(LivingEntity entity, CallbackInfo ci) {
        EventPosePlayerHand event = new EventPosePlayerHand(entity, (HumanoidModel) ((Model) this), false);
        NeoForge.EVENT_BUS.post(event);
        if (event.getResult() == EventPosePlayerHand.Result.ALLOW) {
            ci.cancel();
        }
    }


    @Inject(at = @At("HEAD"), remap = true, method = "Lnet/minecraft/client/model/HumanoidModel;poseLeftArm(Lnet/minecraft/world/entity/LivingEntity;)V", cancellable = true)
    private void custom_poseLeftArm(LivingEntity entity, CallbackInfo ci) {
        EventPosePlayerHand event = new EventPosePlayerHand(entity, (HumanoidModel) ((Model) this), true);
        NeoForge.EVENT_BUS.post(event);
        if (event.getResult() == EventPosePlayerHand.Result.ALLOW) {
            ci.cancel();
        }
    }


}
