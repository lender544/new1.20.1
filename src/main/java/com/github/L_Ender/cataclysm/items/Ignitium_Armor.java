package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.Nullable;
import java.util.List;

public class Ignitium_Armor extends ArmorItem implements KeybindUsingArmor {

    public Ignitium_Armor(Armortier material, ArmorItem.Type slot, Properties properties) {
        super(material, slot, properties);

    }
    
    @Override
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getArmorRenderProperties());
    }


    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Cataclysm.MODID + ":textures/armor/ignitium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png");
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        if(CMConfig.Armor_Infinity_Durability) {
            super.setDamage(stack, 0);
        }else{
            super.setDamage(stack, damage);
        }
    }


    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is(ModItems.IGNITIUM_INGOT.get());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.type == Type.HELMET) {
            tooltip.add(Component.translatable("item.cataclysm.ignitium_helmet.desc").withStyle(ChatFormatting.DARK_GREEN));
            tooltip.add(Component.translatable("item.cataclysm.ignitium_helmet.desc2", ModKeybind.HELMET_KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));

        }
        if (this.type == Type.CHESTPLATE) {
            tooltip.add(Component.translatable("item.cataclysm.ignitium_chestplate.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type == Type.LEGGINGS) {
            tooltip.add(Component.translatable("item.cataclysm.ignitium_leggings.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
        if (this.type ==  Type.BOOTS) {
            tooltip.add(Component.translatable("item.cataclysm.ignitium_boots.desc").withStyle(ChatFormatting.DARK_GREEN));
        }
    }

    @Override
    public void onKeyPacket(Player player, ItemStack itemStack, int Type) {
        if (Type == 5) {
            if (player != null && !player.getCooldowns().isOnCooldown(ModItems.IGNITIUM_HELMET.get())) {
                boolean flag = false;
                List<Entity> list = player.level().getEntities(player, player.getBoundingBox().inflate(16.0D));
                for (Entity entity : list) {
                    if (entity instanceof LivingEntity living) {
                        MobEffectInstance effectinstance1 = living.getEffect(ModEffect.EFFECTBLAZING_BRAND.get());
                        int i = 1;
                        if (effectinstance1 != null) {
                            i += effectinstance1.getAmplifier();
                            living.removeEffectNoUpdate(ModEffect.EFFECTBLAZING_BRAND.get());
                        } else {
                            --i;
                        }

                        i = Mth.clamp(i, 0, 2);
                        MobEffectInstance effectinstance = new MobEffectInstance(ModEffect.EFFECTBLAZING_BRAND.get(), 160, i, false, false, true);
                        flag = living.addEffect(effectinstance);
                    }

                    if (flag) {
                        player.getCooldowns().addCooldown(ModItems.IGNITIUM_HELMET.get(), 300);
                    }
                }
            }
        }
    }

}