package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import com.github.L_Ender.cataclysm.message.MessageArmorKey;
import com.github.L_Ender.cataclysm.message.MessageSwingArm;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;


import javax.annotation.Nonnull;
import java.util.List;

public class Cursium_Armor extends ArmorItem implements KeybindUsingArmor {

    public Cursium_Armor(Holder<ArmorMaterial> material, Type slot, Properties properties) {
        super(material, slot, properties);

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

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof Player living) {
            if (living.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.CURSIUM_HELMET.get()) {
                if (level.isClientSide) {
                    if (ModKeybind.HELMET_KEY_ABILITY.isDown()) {
                        PacketDistributor.sendToServer(new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), living.getId(), 5));
                        onKeyPacket(living, stack,5);
                    }
                }

            }
            if (living.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.CURSIUM_BOOTS.get()) {
                if (level.isClientSide) {
                    if (ModKeybind.BOOTS_KEY_ABILITY.isDown()) {
                        PacketDistributor.sendToServer(new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), living.getId(), 7));
                        onKeyPacket(living, stack,7);
                    }
                }

            }

        }
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
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
    public void onKeyPacket(Player player, ItemStack itemStack, int Type) {
        if (Type == 5) {
            if (player != null && !player.getCooldowns().isOnCooldown(ModItems.CURSIUM_HELMET.get())) {
                boolean flag = false;
                List<Entity> list = player.level().getEntities(player, player.getBoundingBox().inflate(24.0D));
                for (Entity entity : list) {
                    if (entity instanceof LivingEntity living) {
                        flag = true;
                        living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 160));

                    }

                    if (flag) {
                        player.getCooldowns().addCooldown(ModItems.CURSIUM_HELMET.get(), 200);
                    }
                }
            }
        }
        if (Type == 7) {
            if (player != null && player.onGround() && !player.getCooldowns().isOnCooldown(ModItems.CURSIUM_BOOTS.get())) {
                float speed = -1.8f;
                float dodgeYaw = (float) Math.toRadians(player.getYRot() + 90);
                Vec3 m = player.getDeltaMovement().add(speed * Math.cos(dodgeYaw), 0, speed * Math.sin(dodgeYaw));
                player.setDeltaMovement(m.x, 0.4, m.z);
                player.getCooldowns().addCooldown(ModItems.CURSIUM_BOOTS.get(), 200);
            }
        }
    }

    @Override
    public ResourceLocation getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
        return ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID , "textures/armor/cursium_armor" + (slot == EquipmentSlot.LEGS ? "_legs.png" : ".png"));
    }


    public static final class ArmorRender implements IClientItemExtensions {
        public static final Cursium_Armor.ArmorRender INSTANCE = new Cursium_Armor.ArmorRender();

        @Override
        public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> model) {
            EntityModelSet models = Minecraft.getInstance().getEntityModels();
            ModelPart root = slot == EquipmentSlot.LEGS ? models.bakeLayer(CMModelLayers.CURSIUM_ARMOR_MODEL_LEGS) : models.bakeLayer(CMModelLayers.CURSIUM_ARMOR_MODEL);
            return new HumanoidModel(root);
        }
    }

}