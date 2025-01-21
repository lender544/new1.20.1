package com.github.L_Ender.cataclysm.mixin;


import com.github.L_Ender.cataclysm.init.ModEffect;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow public abstract boolean hasEffect(Holder<MobEffect> effect);

    public LivingEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }


    @Inject(
            method = {"Lnet/minecraft/world/entity/LivingEntity;canAttack*"},
            remap = true,
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true)

    public void CMcanAttack(LivingEntity p_21171_,CallbackInfoReturnable<Boolean> cir) {
        if (this.hasEffect(ModEffect.EFFECTSTUN)) {
            cir.setReturnValue(false);
        }

    }

}


