package com.github.L_Ender.cataclysm.event;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.capabilities.*;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Wadjet_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.items.ILeftClick;
import com.github.L_Ender.cataclysm.message.MessageParticle;
import com.github.L_Ender.cataclysm.message.MessageSwingArm;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.cataclysm.util.SandstormUtils;
import com.github.L_Ender.lionfishapi.server.event.StandOnFluidEvent;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.List;

@Mod.EventBusSubscriber(modid = Cataclysm.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEventHandler {


    @SubscribeEvent
    public void onLivingUpdateEvent(LivingEvent.LivingTickEvent event) {
        HookCapability.IHookCapability hookCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.HOOK_CAPABILITY);
        if (hookCapability != null) {
            hookCapability.tick(event.getEntity());
        }

        ChargeCapability.IChargeCapability chargeCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.CHARGE_CAPABILITY);
        if (chargeCapability != null) {
            chargeCapability.tick(event.getEntity());
        }
        RenderRushCapability.IRenderRushCapability RushCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.RENDER_RUSH_CAPABILITY);
        if (RushCapability != null) {
            RushCapability.tick(event.getEntity());
        }
    }

    @SubscribeEvent
    public void StandOnFluidEventEvent(StandOnFluidEvent event) {
        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.IGNITIUM_BOOTS.get()) {
            if (!event.getEntity().isShiftKeyDown() && (event.getFluidState().is(Fluids.LAVA) || event.getFluidState().is(Fluids.FLOWING_LAVA))) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onLivingDamage(LivingHurtEvent event) {
        LivingEntity target = event.getEntity();
        if (!target.level().isClientSide() && event.getSource().getDirectEntity() instanceof LivingEntity living) {
            ItemStack weapon = living.getMainHandItem();

            if (!weapon.isEmpty()) {
                if ((weapon.is(ModItems.ZWEIENDER.get()))) {
                    Vec3 lookDir = new Vec3(target.getLookAngle().x, 0, target.getLookAngle().z).normalize();
                    Vec3 vecBetween = new Vec3(target.getX() - living.getX(), 0, target.getZ() - living.getZ()).normalize();
                    double dot = lookDir.dot(vecBetween);
                    if (dot > 0.05) {
                        event.setAmount(event.getAmount() * 2);
                        target.playSound(SoundEvents.ENDERMAN_TELEPORT, 0.75F, 0.5F);
                    }
                    // enchantment attack sparkles
                }

                if ((weapon.is(ModItems.FINAL_FRACTAL.get()))) {
                    event.setAmount(event.getAmount() + target.getMaxHealth() * 0.03f);
                }

            }
        }

        if (event.getSource().getDirectEntity() instanceof LivingEntity living) {
            List<SlotResult> slot = CuriosApi.getCuriosHelper().findCurios(living, stack -> stack.is(ModItems.BLAZING_GRIPS.get()));
            if (!slot.isEmpty()) {
                if (event.getEntity().getRandom().nextFloat() < 0.15F * slot.size()) {
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 60, 0);
                    target.addEffect(effectinstance);
                }
            }
        }

    }


    @SubscribeEvent
    public void onPlayerAttack(AttackEntityEvent event) {
        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void BlockHeal(LivingHealEvent event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTABYSSAL_FEAR.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getEffect(ModEffect.EFFECTSTUN.get()) != null){
            entity.setDeltaMovement(entity.getDeltaMovement().x(), 0.0D, entity.getDeltaMovement().z());
        }
    }

    @SubscribeEvent
    public void onPlayerLeftClick(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        if (event.isCancelable() && player.hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onUseItem(LivingEntityUseItemEvent event) {
        LivingEntity living = event.getEntity();
        if (event.isCancelable() && living.hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
        if (event.isCancelable() && living.hasEffect(ModEffect.EFFECTGHOST_FORM.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlaceBlock(BlockEvent.EntityPlaceEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entity;
            if (event.isCancelable() && living.hasEffect(ModEffect.EFFECTSTUN.get())) {
                event.setCanceled(true);
            }
        }
    }


    @SubscribeEvent
    public void KnockbackEvent(LivingKnockBackEvent event) {
        LivingEntity living = event.getEntity();
        if(living instanceof Royal_Draugr_Entity royalDraugr){
            if(royalDraugr.isDraugrBlocking()){
                event.setCanceled(true);
            }
        }
    }


    @SubscribeEvent
    public void onFillBucket(FillBucketEvent event) {
        LivingEntity living = event.getEntity();
        if (living != null) {
            if (event.isCancelable() && living.hasEffect(ModEffect.EFFECTSTUN.get())) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent event) {
        if (event.isCancelable() && event.getPlayer().hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.RightClickEmpty event) {
        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.LeftClickEmpty event) {
        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
        boolean flag = false;
        ItemStack leftItem = event.getEntity().getOffhandItem();
        ItemStack rightItem = event.getEntity().getMainHandItem();
        if(!event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())){
            if (leftItem.getItem() instanceof ILeftClick) {
                ((ILeftClick) leftItem.getItem()).onLeftClick(leftItem, event.getEntity());
                flag = true;
            }
            if (rightItem.getItem() instanceof ILeftClick) {
                ((ILeftClick) rightItem.getItem()).onLeftClick(rightItem, event.getEntity());
                flag = true;
            }
            if (event.getLevel().isClientSide && flag) {
                Cataclysm.sendMSGToServer(MessageSwingArm.INSTANCE);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.LeftClickBlock event) {
        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onLivingSetTargetEvent(LivingChangeTargetEvent event) {
        if (event.getNewTarget() != null && event.getEntity() instanceof Mob mob) {
            if (mob.getType().is(ModTag.LAVA_MONSTER) && event.getEntity().getLastHurtByMob() != event.getNewTarget()) {
                if (event.getNewTarget().getItemBySlot(EquipmentSlot.HEAD).is(ModItems.IGNITIUM_HELMET.get())) {
                    event.setCanceled(true);
                    return;
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getHealth() <= event.getAmount() && entity.hasEffect(ModEffect.EFFECTSTUN.get())) {
            entity.removeEffect(ModEffect.EFFECTSTUN.get());
        }
        if (!event.getEntity().getItemBySlot(EquipmentSlot.LEGS).isEmpty() && event.getSource() != null && event.getSource().getEntity() != null) {
            if(event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.IGNITIUM_LEGGINGS.get()){
                Entity attacker = event.getSource().getEntity();
                if (attacker instanceof LivingEntity && attacker != event.getEntity()) {
                    if (event.getEntity().getRandom().nextFloat() < 0.5F) {
                        MobEffectInstance effectinstance1 = ((LivingEntity) attacker).getEffect(ModEffect.EFFECTBLAZING_BRAND.get());
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            ((LivingEntity) attacker).removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND.get());
                        } else {
                            --i;
                        }

                        i = Mth.clamp(i, 0, 4);
                        MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 100, i, false, false, true);
                        ((LivingEntity) attacker).addEffect(effectinstance);

                        if (!attacker.isOnFire()) {
                            attacker.setSecondsOnFire(5);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onShieldDamage(ShieldBlockEvent event) {
        DamageSource source = event.getDamageSource();

        LivingEntity entity = event.getEntity();
        Item item = entity.getUseItem().getItem();
        Entity directEntity = source.getDirectEntity();
        if (source.is(CMDamageTypes.MALEDICTIO_SAGITTA)) {
            event.setShieldTakesDamage(false);
        }


        ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);

        if(item == ModItems.BULWARK_OF_THE_FLAME.get()) {
            if (ParryCapability != null) {
                if (ParryCapability.getParryFrame() < 15) {
                    if (directEntity instanceof LivingEntity livingEntity) {
                        livingEntity.setSecondsOnFire(3);
                        livingEntity.playSound(SoundEvents.ANVIL_LAND, 0.8f, 1.3F);
                        MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 100, 0);
                        livingEntity.knockback(0.5F, entity.getX() - livingEntity.getX(), entity.getZ() - livingEntity.getZ());
                        livingEntity.addEffect(effectinstance);
                    }
                }
            }
        }

    }
    @SubscribeEvent
    public void DeathEvent(LivingDeathEvent event) {
        DamageSource source = event.getSource();

            if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                if(tryCursiumPlateRebirth(event.getEntity())){
                    event.setCanceled(true);
                }

        }
    }

    private boolean tryCursiumPlateRebirth(LivingEntity living) {
        ItemStack chestplate = living.getItemBySlot(EquipmentSlot.CHEST);
        if (!living.level().isClientSide &&chestplate.getItem() == ModItems.CURSIUM_CHESTPLATE.get() && !living.hasEffect(ModEffect.EFFECTGHOST_SICKNESS.get()) && !living.hasEffect(ModEffect.EFFECTGHOST_FORM.get())) {
            living.setHealth(5.0F);
            living.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0));
            living.addEffect(new MobEffectInstance(ModEffect.EFFECTGHOST_FORM.get(), 100, 0));
            double d0 = living.getX();
            double d1 = living.getY() + 0.3F;
            double d2 = living.getZ();
            float size = 3.0F;
            for (ServerPlayer serverplayer : ((ServerLevel) living.level()).players()) {
                if (serverplayer.distanceToSqr(Vec3.atCenterOf(living.blockPosition())) < 1024.0D) {
                    MessageParticle particlePacket = new MessageParticle();
                    for (float i = -size; i <= size; ++i) {
                        for (float j = -size; j <= size; ++j) {
                            for (float k = -size; k <= size; ++k) {
                                double d3 = (double) j + (living.getRandom().nextDouble() - living.getRandom().nextDouble()) * 0.5D;
                                double d4 = (double) i + (living.getRandom().nextDouble() - living.getRandom().nextDouble()) * 0.5D;
                                double d5 = (double) k + (living.getRandom().nextDouble() - living.getRandom().nextDouble()) * 0.5D;
                                double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + living.getRandom().nextGaussian() * 0.05D;
                                particlePacket.queueParticle(ModParticle.CURSED_FLAME.get(),false, d0 , d1, d2, d3 / d6, d4 / d6, d5 / d6);
                                if (i != -size && i != size && j != -size && j != size) {
                                    k += size * 2 - 1;
                                }
                            }
                        }
                    }
                    Cataclysm.NETWORK_WRAPPER.send(PacketDistributor.PLAYER.with(() -> serverplayer), particlePacket);
                }
            }
            return true;
        }
        return false;
    }


    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM.get())) {
            if (!event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                event.setCanceled(true);
            }
        }
        if (!event.getEntity().getItemBySlot(EquipmentSlot.LEGS).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.CURSIUM_LEGGINGS.get()) {
            if (event.getSource().is(DamageTypeTags.IS_PROJECTILE)) {
                if (event.getEntity().getRandom().nextFloat() < 0.15F) {
                    event.setCanceled(true);
                }
            } else if (!event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                if (event.getEntity().getRandom().nextFloat() < 0.08F) {
                    event.setCanceled(true);
                }
            }
        }
    }



    @SubscribeEvent
    public void onLivingAttack(CriticalHitEvent event) {
        ItemStack weapon = event.getEntity().getMainHandItem();
        if (!weapon.isEmpty() && event.getTarget() instanceof LivingEntity livingEntity) {
            if (weapon.getItem() == ModItems.THE_ANNIHILATOR.get()) {
                //if(event.isVanillaCritical()){
                    event.setDamageModifier(2.25F);
               // }

            }
            if (weapon.getItem() == ModItems.THE_IMMOLATOR.get()) {
                if(livingEntity.hasEffect(ModEffect.EFFECTBLAZING_BRAND.get())){
                    event.setResult(Event.Result.ALLOW);
                }
                event.setDamageModifier(2.0F);
            }
        }
    }

    @SubscribeEvent
    public void onLivingFall(LivingFallEvent event) {
        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.CURSIUM_BOOTS.get()) {
            event.setDistance(event.getDistance() * 0.3F);
        }
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent.RightClickItem event) {
        if (event.isCancelable() && event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
    }


    @SubscribeEvent
    public void onStartUsing(LivingEntityUseItemEvent.Start event) {
        Item item = event.getItem().getItem();
        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof Player player && player.attackAnim == 0 && !player.getCooldowns().isOnCooldown(item)) {
            ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);
            if (ParryCapability != null) {
                ParryCapability.setParryFrame(0);
            }
        }
    }


    @SubscribeEvent
    public void onUseTick(LivingEntityUseItemEvent.Tick event) {
        Item item = event.getItem().getItem();
        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof Player player) {
            ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);
            if (ParryCapability != null) {
                ParryCapability.setParryFrame(ParryCapability.getParryFrame() + 1);
            }

        }
    }

    @SubscribeEvent
    public void onStopUsing(LivingEntityUseItemEvent.Stop event) {
        Item item = event.getItem().getItem();
        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof Player) {
            ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);
            if (ParryCapability != null) {
                ParryCapability.setParryFrame(0);
            }
        }
    }

}


