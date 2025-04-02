package com.github.L_Ender.cataclysm.event;

import com.github.L_Ender.cataclysm.Attachment.ChargeAttachment;
import com.github.L_Ender.cataclysm.Attachment.ParryAttachment;
import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.event.ClientSetup;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;
import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.items.ILeftClick;
import com.github.L_Ender.cataclysm.message.MessageParticle;
import com.github.L_Ender.cataclysm.message.MessageSwingArm;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.lionfishapi.server.event.StandOnFluidEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.List;


@EventBusSubscriber(modid = Cataclysm.MODID)
public class ServerEventHandler {

    @SubscribeEvent
    public static void onLivingUpdateEvent(PlayerTickEvent.Post event) {
        event.getEntity().getData(ModDataAttachments.CHARGE_ATTACHMENT).tick(event.getEntity());

        event.getEntity().getData(ModDataAttachments.RENDER_RUSH_ATTACHMENT).tick(event.getEntity());


        if (event.getEntity().getData(ModDataAttachments.HOOK_FALLING)) {
            event.getEntity().setIgnoreFallDamageFromCurrentImpulse(true);
            event.getEntity().currentImpulseImpactPos = event.getEntity().position();

        }
    }


    @SubscribeEvent
    public static void StandOnFluidEventEvent(StandOnFluidEvent event) {
        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.IGNITIUM_BOOTS.get()) {
            if (!event.getEntity().isShiftKeyDown() && (event.getFluidState().is(Fluids.LAVA) || event.getFluidState().is(Fluids.FLOWING_LAVA))) {
                event.setCanceled(true);
            }
        }
    }


    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
        if (event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void BlockHeal(LivingHealEvent event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTABYSSAL_FEAR)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getEffect(ModEffect.EFFECTSTUN) != null){
            entity.setDeltaMovement(entity.getDeltaMovement().x(), 0.0D, entity.getDeltaMovement().z());
        }
    }

    @SubscribeEvent
    public static void onPlayerLeftClick(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        if ( player.hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onUseItem(LivingEntityUseItemEvent event) {
        LivingEntity living = event.getEntity();
        if (living.hasEffect(ModEffect.EFFECTSTUN)) {
            event.setDuration(0);
        }
        if (living.hasEffect(ModEffect.EFFECTGHOST_FORM)) {
            event.setDuration(0);
        }
    }

    @SubscribeEvent
    public static void onPlaceBlock(BlockEvent.EntityPlaceEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entity;
            if (living.hasEffect(ModEffect.EFFECTSTUN)) {
                event.setCanceled(true);
            }
        }
    }


    @SubscribeEvent
    public static void KnockbackEvent(LivingKnockBackEvent event) {
        LivingEntity living = event.getEntity();
        if(living instanceof Royal_Draugr_Entity royalDraugr){
            if(royalDraugr.isDraugrBlocking()){
                event.setCanceled(true);
            }
        }
    }



    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        if (event.getPlayer().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract1(PlayerInteractEvent.RightClickEmpty event) {

    }

    @SubscribeEvent
    public static void onPlayerInteract2(PlayerInteractEvent.LeftClickEmpty event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
        //    event.setCanceled(true);
        }

        boolean flag = false;
        ItemStack leftItem = event.getEntity().getOffhandItem();
        ItemStack rightItem = event.getEntity().getMainHandItem();
        if(!event.getEntity().hasEffect(ModEffect.EFFECTSTUN)){
            if (leftItem.getItem() instanceof ILeftClick) {
                ((ILeftClick) leftItem.getItem()).onLeftClick(leftItem, event.getEntity());
                flag = true;
            }
            if (rightItem.getItem() instanceof ILeftClick) {
                ((ILeftClick) rightItem.getItem()).onLeftClick(rightItem, event.getEntity());
                flag = true;
            }
            if (event.getLevel().isClientSide && flag) {

                PacketDistributor.sendToServer(new MessageSwingArm(InteractionHand.MAIN_HAND));
            }
        }

    }

    @SubscribeEvent
    public static void onPlayerInteract3(PlayerInteractEvent.EntityInteract event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract4(PlayerInteractEvent.RightClickBlock event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract5(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingSetTargetEvent(LivingChangeTargetEvent event) {
        if (event.getNewAboutToBeSetTarget() != null && event.getEntity() instanceof Mob mob) {
            if (mob.getType().is(ModTag.LAVA_MONSTER) && event.getEntity().getLastHurtByMob() != event.getNewAboutToBeSetTarget()) {
                if (event.getNewAboutToBeSetTarget().getItemBySlot(EquipmentSlot.HEAD).is(ModItems.IGNITIUM_HELMET.get())) {
                    event.setCanceled(true);
                    return;
                }
            }
        }
    }


    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();

        DamageSource source = event.getSource();
        float damage = event.getOriginalDamage();

        if (source.is(DamageTypeTags.IS_LIGHTNING)) {
            if (entity.hasEffect(ModEffect.EFFECTWETNESS)) {
                MobEffectInstance effectinstance1 = entity.getEffect(ModEffect.EFFECTWETNESS);
                if (effectinstance1 != null) {
                    float i = (effectinstance1.getAmplifier()+1) * 0.25F;
                    float f =  damage * i;
                    damage = Math.min(Float.MAX_VALUE, f);
                    event.setNewDamage(damage);
                }
            }
        }

        if (entity.getHealth() <= event.getNewDamage() && entity.hasEffect(ModEffect.EFFECTSTUN)) {
            entity.removeEffect(ModEffect.EFFECTSTUN);
        }
        if (event.getSource().getDirectEntity() instanceof LivingEntity living) {
            List<SlotResult> slot = CuriosApi.getCuriosHelper().findCurios(living, stack -> stack.is(ModItems.BLAZING_GRIPS.get()));
            if (!slot.isEmpty()) {
                if (event.getEntity().getRandom().nextFloat() < 0.15F * slot.size()) {
                    MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 60, 0);
                    entity.addEffect(effectinstance);
                }
            }
        }

        if (!event.getEntity().getItemBySlot(EquipmentSlot.LEGS).isEmpty() && event.getSource() != null && event.getSource().getEntity() != null) {
            if(event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.IGNITIUM_LEGGINGS.get()){
                Entity attacker = event.getSource().getEntity();
                if (attacker instanceof LivingEntity && attacker != event.getEntity()) {
                    if (event.getEntity().getRandom().nextFloat() < 0.5F) {
                        MobEffectInstance effectinstance1 = ((LivingEntity) attacker).getEffect(ModEffect.EFFECTBLAZING_BRAND);
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            ((LivingEntity) attacker).removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                        } else {
                            --i;
                        }

                        i = Mth.clamp(i, 0, 2);
                        MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, i, false, false, true);
                        ((LivingEntity) attacker).addEffect(effectinstance);

                        if (!attacker.isOnFire()) {
                            attacker.igniteForSeconds(5);
                        }
                    }
                }
            }
        }
    }


    @SubscribeEvent
    public static void onShieldDamage(LivingShieldBlockEvent event) {
        DamageSource source = event.getDamageSource();
        LivingEntity entity = event.getEntity();
        Item item = entity.getUseItem().getItem();
        Entity directEntity = source.getDirectEntity();
        if (source.is(CMDamageTypes.MALEDICTIO_SAGITTA)) {
            event.setShieldDamage(0);
        }
        ParryAttachment charge = entity.getData(ModDataAttachments.PARRY_ATTACHMENT);
        if(item == ModItems.BULWARK_OF_THE_FLAME.get()) {
            if(event.getBlocked()) {
                if (charge.getParryFrame() < 15) {
                    if (directEntity instanceof LivingEntity livingEntity) {
                        livingEntity.igniteForSeconds(3);
                        livingEntity.playSound(SoundEvents.ANVIL_LAND, 0.8f, 1.3F);
                        MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 100, 0);
                        livingEntity.knockback(0.5F, entity.getX() - livingEntity.getX(), entity.getZ() - livingEntity.getZ());
                        livingEntity.addEffect(effectinstance);
                    }

                }
            }
        }
    }
    @SubscribeEvent
    public static void DeathEvent(LivingDeathEvent event) {
        DamageSource source = event.getSource();

        if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            if(tryCursiumPlateRebirth(event.getEntity())){
                event.setCanceled(true);
            }

        }
    }

    private static boolean tryCursiumPlateRebirth(LivingEntity living) {
        ItemStack chestplate = living.getItemBySlot(EquipmentSlot.CHEST);
        if (!living.level().isClientSide&& chestplate.getItem() == ModItems.CURSIUM_CHESTPLATE.get() && !living.hasEffect(ModEffect.EFFECTGHOST_SICKNESS) && !living.hasEffect(ModEffect.EFFECTGHOST_FORM)) {
            living.setHealth(5.0F);
            living.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0));
            living.addEffect(new MobEffectInstance(ModEffect.EFFECTGHOST_FORM, 100, 0));
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
                    PacketDistributor.sendToPlayersTrackingEntity(serverplayer, particlePacket);
                }
            }
            return true;
        }
        return false;
    }


    @SubscribeEvent
    public static void onLivingAttack(LivingIncomingDamageEvent event) {
        if (event.getEntity().hasEffect(ModEffect.EFFECTGHOST_FORM)) {
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
    public static void onCriticalAttack(CriticalHitEvent event) {
        ItemStack weapon = event.getEntity().getMainHandItem();
        if (!weapon.isEmpty() && event.getTarget() instanceof LivingEntity livingEntity) {
            if (weapon.getItem() == ModItems.THE_ANNIHILATOR.get()) {
                //if(event.isVanillaCritical()){
                    event.setDamageMultiplier(2.25F);
               // }

            }
            if (weapon.getItem() == ModItems.THE_IMMOLATOR.get()) {
                if(livingEntity.hasEffect(ModEffect.EFFECTBLAZING_BRAND)){
                    event.setCriticalHit(true);
                }
                event.setDamageMultiplier(2.0F);
            }
        }
    }

    @SubscribeEvent
    public static void preventEffectRemoval(MobEffectEvent.Remove event) {
        MobEffectInstance effectInstance = event.getEffectInstance();

        if (effectInstance != null && effectInstance.getEffect() == ModEffect.EFFECTGHOST_SICKNESS.get()) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.CURSIUM_BOOTS.get()) {
            event.setDistance(event.getDistance() * 0.3F);
        }
    }

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.RightClickItem event) {
        if ( event.getEntity().hasEffect(ModEffect.EFFECTSTUN)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onStartUsing(LivingEntityUseItemEvent.Start event) {
        Item item = event.getItem().getItem();
        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof Player player && !player.getCooldowns().isOnCooldown(item)) {
            ParryAttachment charge = player.getData(ModDataAttachments.PARRY_ATTACHMENT);
            charge.setParryFrame(0);

        }
    }


    @SubscribeEvent
    public static void onUseTick(LivingEntityUseItemEvent.Tick event) {
        Item item = event.getItem().getItem();
        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof Player player) {
            ParryAttachment charge = player.getData(ModDataAttachments.PARRY_ATTACHMENT);
            charge.setParryFrame(charge.getParryFrame() + 1);

        }
    }

    @SubscribeEvent
    public static void onStopUsing(LivingEntityUseItemEvent.Stop event) {
        Item item = event.getItem().getItem();
        if (item == ModItems.BULWARK_OF_THE_FLAME.get() && event.getEntity() instanceof Player player) {
            ParryAttachment charge = player.getData(ModDataAttachments.PARRY_ATTACHMENT);
            charge.setParryFrame(0);
        }
    }

}


