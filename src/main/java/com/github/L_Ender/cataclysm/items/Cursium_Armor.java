package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;

import com.github.L_Ender.cataclysm.config.CommonConfig;
import com.github.L_Ender.cataclysm.config.ConfigHolder;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import com.github.L_Ender.cataclysm.message.MessageArmorKey;
import net.minecraft.ChatFormatting;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class Cursium_Armor extends Cataclysm_Armor implements KeybindUsingArmor {


    public Cursium_Armor(CataclysmArmorMaterial material, Type slot, Properties properties) {
        super(material, slot, properties);

    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getArmorRenderProperties());
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Cataclysm.MODID + ":textures/armor/cursium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png");
    }

    @Override
    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is(ModItems.CURSIUM_INGOT.get());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (!(entity instanceof Player player) || !level.isClientSide) {
            return;
        }

        if (this.type == Type.HELMET && player.getItemBySlot(EquipmentSlot.HEAD) == stack) {
            if (ModKeybind.HELMET_KEY_ABILITY.consumeClick()) {
                Cataclysm.sendMSGToServer(new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), player.getId(), 5));
                onKeyPacket(player, stack, 5);
            }
        } else if (this.type == Type.BOOTS && player.getItemBySlot(EquipmentSlot.FEET) == stack) {
            if (ModKeybind.BOOTS_KEY_ABILITY.consumeClick()) {
                Cataclysm.sendMSGToServer(new MessageArmorKey(EquipmentSlot.FEET.ordinal(), player.getId(), 7));
                onKeyPacket(player, stack, 7);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.type == Type.HELMET) {
            tooltip.add(Component.translatable("item.cataclysm.cursium_helmet.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_helmet.desc2", ModKeybind.HELMET_KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type == Type.CHESTPLATE) {
            tooltip.add(Component.translatable("item.cataclysm.cursium_chestplate.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_chestplate.desc2").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_chestplate.desc3").withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type == Type.LEGGINGS) {
            tooltip.add(Component.translatable("item.cataclysm.cursium_leggings.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_leggings.desc2").withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type ==  Type.BOOTS) {
            tooltip.add(Component.translatable("item.cataclysm.cursium_boots.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.cursium_boots.desc2",ModKeybind.BOOTS_KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
        }
    }

    @Override
    public void onKeyPacket(Player player, ItemStack itemStack, int type) {
        if (player == null) return;

        if (type == 5) {
            if (!player.getCooldowns().isOnCooldown(ModItems.CURSIUM_HELMET.get())) {
                boolean targetFound = false;
                List<Entity> list = player.level().getEntities(player, player.getBoundingBox().inflate(24.0D));

                for (Entity entity : list) {
                    if (entity instanceof LivingEntity living && entity != player) {
                        targetFound = true;
                        living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 160));
                    }
                }

                if (targetFound) {
                    player.getCooldowns().addCooldown(ModItems.CURSIUM_HELMET.get(), 200);
                }
            }
        }
        if (type == 7) {
            if (player.onGround() && !player.getCooldowns().isOnCooldown(ModItems.CURSIUM_BOOTS.get())) {
                float speed = -1.8f;
                float dodgeYaw = (float) Math.toRadians(player.getYRot() + 90);

                double velX = speed * Math.cos(dodgeYaw);
                double velZ = speed * Math.sin(dodgeYaw);

                Vec3 currentVel = player.getDeltaMovement();
                player.setDeltaMovement(currentVel.x + velX, 0.4, currentVel.z + velZ);
                player.hurtMarked = true;
                player.getCooldowns().addCooldown(ModItems.CURSIUM_BOOTS.get(), 200);
            }
        }
    }

}