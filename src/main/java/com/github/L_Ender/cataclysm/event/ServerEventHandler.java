package com.github.L_Ender.cataclysm.event;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.capabilities.ChargeCapability;
import com.github.L_Ender.cataclysm.capabilities.HookCapability;
import com.github.L_Ender.cataclysm.capabilities.ParryCapability;
import com.github.L_Ender.cataclysm.capabilities.RenderRushCapability;
import com.github.L_Ender.cataclysm.config.CMCommonConfig;
import com.github.L_Ender.cataclysm.config.ConfigHolder;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Royal_Draugr_Entity;

import com.github.L_Ender.cataclysm.init.*;
import com.github.L_Ender.cataclysm.items.Cataclysm_Weapon_Item;
import com.github.L_Ender.cataclysm.items.ILeftClick;
import com.github.L_Ender.cataclysm.message.MessageSwingArm;
import com.github.L_Ender.cataclysm.util.AttributeUtils;
import com.github.L_Ender.cataclysm.util.CMDamageTypes;
import com.github.L_Ender.lionfishapi.server.event.StandOnFluidEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Mod.EventBusSubscriber(modid = Cataclysm.MODID)
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
    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getEffect(ModEffect.EFFECTSTUN.get()) != null){
            entity.setDeltaMovement(entity.getDeltaMovement().x(), 0.0D, entity.getDeltaMovement().z());
        }
    }



    @SubscribeEvent
    public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
        LivingEntity living = event.getEntity();
        ItemStack itemStack = event.getItem();
        if (living.hasEffect(ModEffect.EFFECTSTUN.get())) {
            event.setCanceled(true);
        }
        if (living.hasEffect(ModEffect.EFFECTGHOST_FORM.get())) {
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
        if (living instanceof Royal_Draugr_Entity royalDraugr) {
            if (royalDraugr.isDraugrBlocking()) {
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
        if (!event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
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
        DamageSource source = event.getSource();
        float damage = event.getAmount();

        if (source.is(DamageTypeTags.IS_LIGHTNING)) {
            if (entity.hasEffect(ModEffect.EFFECTWETNESS.get())) {
                MobEffectInstance effectinstance1 = entity.getEffect(ModEffect.EFFECTWETNESS.get());
                if (effectinstance1 != null) {
                    float i = (effectinstance1.getAmplifier() + 1) * 0.2F;
                    float f = damage + damage * i;
                    damage = Math.min(Float.MAX_VALUE, f);
                    event.setAmount(damage);
                }
            }
        }
        if (entity.getHealth() <= event.getAmount() && entity.hasEffect(ModEffect.EFFECTSTUN.get())) {
            entity.removeEffect(ModEffect.EFFECTSTUN.get());
        }
        if (!event.getEntity().getItemBySlot(EquipmentSlot.LEGS).isEmpty() && event.getSource() != null && event.getSource().getEntity() != null) {
            if (event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.IGNITIUM_LEGGINGS.get()) {
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

        if (item == ModItems.BULWARK_OF_THE_FLAME.get()) {
            if (ParryCapability != null) {
                if (ParryCapability.getParryFrame() < 13) {
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
        if (item == ModItems.AZURE_SEA_SHIELD.get()) {
            if (ParryCapability != null) {
                if (ParryCapability.getParryFrame() < 10) {
                    if (directEntity instanceof LivingEntity livingEntity) {
                        livingEntity.playSound(ModSounds.PARRY.get(), 0.4f, 1.0F);
                        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 1));
                        MobEffectInstance effectinstance = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1);
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
            if (tryCursiumPlateRebirth(event.getEntity())) {
                event.setCanceled(true);
            }

        }
    }

    private boolean tryCursiumPlateRebirth(LivingEntity living) {
        ItemStack chestplate = living.getItemBySlot(EquipmentSlot.CHEST);
        if ((living.level() instanceof ServerLevel serverLevel)&& chestplate.getItem() == ModItems.CURSIUM_CHESTPLATE.get() && !living.hasEffect(ModEffect.EFFECTGHOST_SICKNESS.get()) && !living.hasEffect(ModEffect.EFFECTGHOST_FORM.get())) {
            living.setHealth(5.0F);
            serverLevel.playSound(
                    null,
                    living.getX(), living.getY(), living.getZ(),
                    SoundEvents.TOTEM_USE,
                    living.getSoundSource(),
                    1.25f,
                    1.0F
            );
            living.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0));
            living.addEffect(new MobEffectInstance(ModEffect.EFFECTGHOST_FORM.get(), 100, 0, false, true, true));
            double d0 = living.getX();
            double d1 = living.getY() + 3F;
            double d2 = living.getZ();
            serverLevel.sendParticles(ModParticle.CURSED_ALGIZ.get(), d0, d1, d2, 1, 0.0, 0, 0.0, 0);
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
    public void onCriticalAttack(CriticalHitEvent event) {
        Player player = event.getEntity();
        ItemStack weapon = player.getMainHandItem();

        if (!weapon.isEmpty() && event.getTarget() instanceof LivingEntity livingEntity) {
            if (weapon.getItem() == ModItems.THE_IMMOLATOR.get()) {
                if(livingEntity.hasEffect(ModEffect.EFFECTBLAZING_BRAND.get())){
                    event.setResult(Event.Result.ALLOW);
                }
            }
            if (weapon.getItem() == ModItems.THE_ANNIHILATOR.get() || weapon.getItem() == ModItems.CERAUNUS.get() || weapon.getItem() == ModItems.THE_IMMOLATOR.get() ) {
                if(event.isVanillaCritical()){
                    livingEntity.playSound(ModSounds.PARRY.get(), 0.5f, 1.1F);
                }
            }
        }

        AttributeInstance attackDamageAttr = player.getAttribute(ModAttribute.ADDITIONAL_CRITICAL_DAMAGE.get());
        if (attackDamageAttr != null) {

            double extraCritPercent = attackDamageAttr.getValue();

            float vanillaCrit = event.getDamageModifier();

            float finalMultiplier = (float)(vanillaCrit + (extraCritPercent / 100.0));

            if (finalMultiplier < 1.0f) {
                finalMultiplier = 1.0f;
            }
            event.setDamageModifier(finalMultiplier);

        }
    }


    @SubscribeEvent
    public void preventEffectRemoval(MobEffectEvent.Remove event) {
        MobEffectInstance effectInstance = event.getEffectInstance();

        if (effectInstance != null && effectInstance.getEffect() == ModEffect.EFFECTGHOST_SICKNESS.get()) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void onLivingFall(LivingFallEvent event) {
        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).isEmpty() && event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.CURSIUM_BOOTS.get()) {
            event.setDistance(event.getDistance() * 0.3F);
        }
    }




    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.RightClickItem event) {
        if ( event.getEntity().hasEffect(ModEffect.EFFECTSTUN.get())) {
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
        if ((item == ModItems.AZURE_SEA_SHIELD.get() || item == ModItems.BULWARK_OF_THE_FLAME.get()) && event.getEntity() instanceof Player player) {
            ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);
            if (ParryCapability != null) {
                ParryCapability.setParryFrame(ParryCapability.getParryFrame() + 1);
            }

        }
    }

    @SubscribeEvent
    public void onAdvancementEarned(net.minecraftforge.event.entity.player.AdvancementEvent.AdvancementEarnEvent event) {
        Player player = event.getEntity();
        ResourceLocation advId = event.getAdvancement().getId();

        if (advId.equals(new ResourceLocation(Cataclysm.MODID, "kill_all_bosses"))) {

            ItemStack reward = new ItemStack(ModItems.MUSIC_DISC_THE_CATACLYSMFARER.get());
            if (!player.getInventory().add(reward)) {
                player.drop(reward, false);
            }
            player.playNotifySound(
                    ModSounds.THE_CATACLYSMFARER.get(),
                    SoundSource.RECORDS,
                    1.0F,
                    1.0F
            );
        }
    }

    @SubscribeEvent
    public void onStopUsing(LivingEntityUseItemEvent.Stop event) {
        Item item = event.getItem().getItem();
        if ((item == ModItems.AZURE_SEA_SHIELD.get()||item == ModItems.BULWARK_OF_THE_FLAME.get()) && event.getEntity() instanceof Player player) {
            ParryCapability.IParryCapability ParryCapability = ModCapabilities.getCapability(event.getEntity(), ModCapabilities.PARRY_CAPABILITY);
            if (ParryCapability != null) {
                ParryCapability.setParryFrame(0);
            }
        }
    }

    @SubscribeEvent
    public void onEntityKnockback(LivingKnockBackEvent event) {
        LivingEntity entity = event.getEntity();

        DamageSource damagesource = entity.getLastDamageSource();
        if (damagesource != null) {
            if (damagesource.is(CMDamageTypes.SHREDDER)) {
                event.setCanceled(true);
            }
        }
    }


    @SubscribeEvent
    public void ItemAttributeModifier(ItemAttributeModifierEvent event) {
        if (!ConfigHolder.COMMON_SPEC.isLoaded()) {
            Cataclysm.LOGGER.error("Could not modify default components due to config not being loaded yet");
        } else {

                Item item = event.getItemStack().getItem();
                if (item == ModItems.THE_INCINERATOR.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.Incinerator.attackDamage, CMCommonConfig.Incinerator.attackSpeed);
                } else if (item == ModItems.GAUNTLET_OF_BULWARK.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.GauntletOfBulwark.attackDamage, CMCommonConfig.GauntletOfBulwark.attackSpeed);
                } else if (item == ModItems.GAUNTLET_OF_MAELSTROM.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.GauntletOfMaelstrom.attackDamage, CMCommonConfig.GauntletOfMaelstrom.attackSpeed);
                } else if (item == ModItems.GAUNTLET_OF_GUARD.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.GauntletOfGuard.attackDamage, CMCommonConfig.GauntletOfGuard.attackSpeed);
                } else if (item == ModItems.MEAT_SHREDDER.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.MeatShredder.attackDamage, CMCommonConfig.MeatShredder.attackSpeed);
                } else if (item == ModItems.SOUL_RENDER.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.SoulRender.attackDamage, CMCommonConfig.SoulRender.attackSpeed);
                } else if (item == ModItems.CERAUNUS.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.Ceraunus.attackDamage, CMCommonConfig.Ceraunus.attackSpeed);
                } else if (item == ModItems.THE_ANNIHILATOR.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.Annihilator.attackDamage, CMCommonConfig.Annihilator.attackSpeed);
                } else if (item == ModItems.THE_IMMOLATOR.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.Immolator.attackDamage, CMCommonConfig.Immolator.attackSpeed);
                } else if (item == ModItems.ASTRAPE.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.Astrape.attackDamage, CMCommonConfig.Astrape.attackSpeed);
                } else if (item == ModItems.INFERNAL_FORGE.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.InfernalForge.attackDamage, CMCommonConfig.InfernalForge.attackSpeed);
                } else if (item == ModItems.VOID_FORGE.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.VoidForge.attackDamage, CMCommonConfig.VoidForge.attackSpeed);
                } else if (item == ModItems.TIDAL_CLAWS.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.TidalClaws.attackDamage, CMCommonConfig.TidalClaws.attackSpeed);
                } else if (item == ModItems.BRONTES.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.Brontes.attackDamage, CMCommonConfig.Brontes.attackSpeed);
                } else if (item == ModItems.ANCIENT_SPEAR.get()) {
                    AttributeUtils.replaceWeaponAttributes(event, CMCommonConfig.AncientSpear.attackDamage, CMCommonConfig.AncientSpear.attackSpeed);

                } else if (item == ModItems.IGNITIUM_HELMET.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.IgnitiumArmor.armorMultiplier,
                            CMCommonConfig.IgnitiumArmor.toughness,
                            CMCommonConfig.IgnitiumArmor.knockbackResistance);
                } else if (item == ModItems.IGNITIUM_CHESTPLATE.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.IgnitiumArmor.armorMultiplier,
                            CMCommonConfig.IgnitiumArmor.toughness,
                            CMCommonConfig.IgnitiumArmor.knockbackResistance);
                } else if (item == ModItems.IGNITIUM_ELYTRA_CHESTPLATE.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.IgnitiumArmor.armorMultiplier,
                            CMCommonConfig.IgnitiumArmor.toughness,
                            CMCommonConfig.IgnitiumArmor.knockbackResistance);
                } else if (item == ModItems.IGNITIUM_LEGGINGS.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.IgnitiumArmor.armorMultiplier,
                            CMCommonConfig.IgnitiumArmor.toughness,
                            CMCommonConfig.IgnitiumArmor.knockbackResistance);
                } else if (item == ModItems.IGNITIUM_BOOTS.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.IgnitiumArmor.armorMultiplier,
                            CMCommonConfig.IgnitiumArmor.toughness,
                            CMCommonConfig.IgnitiumArmor.knockbackResistance);
                } else if (item == ModItems.CURSIUM_HELMET.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.CursiumArmor.armorMultiplier,
                            CMCommonConfig.CursiumArmor.toughness,
                            CMCommonConfig.CursiumArmor.knockbackResistance);
                } else if (item == ModItems.CURSIUM_CHESTPLATE.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.CursiumArmor.armorMultiplier,
                            CMCommonConfig.CursiumArmor.toughness,
                            CMCommonConfig.CursiumArmor.knockbackResistance);
                } else if (item == ModItems.CURSIUM_LEGGINGS.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.CursiumArmor.armorMultiplier,
                            CMCommonConfig.CursiumArmor.toughness,
                            CMCommonConfig.CursiumArmor.knockbackResistance);
                } else if (item == ModItems.CURSIUM_BOOTS.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.CursiumArmor.armorMultiplier,
                            CMCommonConfig.CursiumArmor.toughness,
                            CMCommonConfig.CursiumArmor.knockbackResistance);
                } else if (item == ModItems.BLOOM_STONE_PAULDRONS.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.BloomStoneArmor.armorMultiplier,
                            CMCommonConfig.BloomStoneArmor.toughness,
                            CMCommonConfig.BloomStoneArmor.knockbackResistance);
                } else if (item == ModItems.BONE_REPTILE_HELMET.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.BoneReptileArmor.armorMultiplier,
                            CMCommonConfig.BoneReptileArmor.toughness,
                            CMCommonConfig.BoneReptileArmor.knockbackResistance);
                } else if (item == ModItems.BONE_REPTILE_CHESTPLATE.get()) {
                    AttributeUtils.replaceArmorAttributes(event,
                            CMCommonConfig.BoneReptileArmor.armorMultiplier,
                            CMCommonConfig.BoneReptileArmor.toughness,
                            CMCommonConfig.BoneReptileArmor.knockbackResistance);
                }
            }

    }

}


