package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;

import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import com.github.L_Ender.cataclysm.message.MessageArmorKey;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

import javax.annotation.Nonnull;
import java.util.List;

public class Ignitium_Armor extends Cataclysm_Armor implements KeybindUsingArmor  {

    public Ignitium_Armor(Holder<ArmorMaterial> material, Type slot, Properties properties) {
        super(material, slot, properties);

    }




    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is(ModItems.IGNITIUM_INGOT.get());
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (!(entity instanceof Player player) || !level.isClientSide) {
            return;
        }

        if (this.type == Type.HELMET && player.getItemBySlot(EquipmentSlot.HEAD) == stack) {
            if (ModKeybind.HELMET_KEY_ABILITY.consumeClick()) {
                PacketDistributor.sendToServer(new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), player.getId(), 5));
                onKeyPacket(player, stack, 5);
            }
        }

    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        if (this.type == Type.HELMET) {
            tooltips.add(Component.translatable("item.cataclysm.ignitium_helmet.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltips.add(Component.translatable("item.cataclysm.ignitium_helmet.desc2", ModKeybind.HELMET_KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type == Type.CHESTPLATE) {
            tooltips.add(Component.translatable("item.cataclysm.ignitium_chestplate.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type == Type.LEGGINGS) {
            tooltips.add(Component.translatable("item.cataclysm.ignitium_leggings.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type ==  Type.BOOTS) {
            tooltips.add(Component.translatable("item.cataclysm.ignitium_boots.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
    }

    @Override
    public void onKeyPacket(Player player, ItemStack itemStack, int Type) {
        if (player == null) return;
        if (Type == 5) {
            if ( !player.getCooldowns().isOnCooldown(ModItems.IGNITIUM_HELMET.get())) {
                boolean flag = false;
                List<Entity> list = player.level().getEntities(player, player.getBoundingBox().inflate(16.0D));
                for (Entity entity : list) {
                    if (entity instanceof LivingEntity living) {
                        MobEffectInstance effectinstance1 = living.getEffect(ModEffect.EFFECTBLAZING_BRAND);
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            living.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND);
                        } else {
                            --i;
                        }

                        i = Mth.clamp(i, 0, 2);
                        MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND, 160, i, true, true, true);
                        flag = living.addEffect(effectinstance);
                    }

                    if (flag) {
                        player.getCooldowns().addCooldown(ModItems.IGNITIUM_HELMET.get(), 300);
                    }
                }
            }
        }
    }

    @Override
    public ResourceLocation getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
        return ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID , "textures/armor/ignitium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png"));
    }


}