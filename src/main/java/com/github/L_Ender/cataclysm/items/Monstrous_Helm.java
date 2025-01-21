package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;

import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class Monstrous_Helm extends ArmorItem {

    public Monstrous_Helm(Holder<ArmorMaterial> material, Type slot, Properties properties) {
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
        return p_41135_.is(Items.NETHERITE_INGOT);
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.MONSTROUS_HELM.get()) {
                boolean berserk = player.getMaxHealth() * 1 / 2 >= player.getHealth();
                double radius = 4.0D;
                List<Entity> list = level.getEntities(player, player.getBoundingBox().inflate(radius));
                if(berserk && !(player.getCooldowns().isOnCooldown(this))) {
                    for (Entity entitys : list) {
                        if (entitys instanceof LivingEntity) {
                            entitys.hurt(level.damageSources().mobAttack(player), (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE)* 1/2);
                            double d0 = entitys.getX() - player.getX();
                            double d1 = entitys.getZ() - player.getZ();
                            double d2 = Math.max(d0 * d0 + d1 * d1, 0.001D);
                            entitys.push(d0 / d2 * 1.5 , 0.15D, d1 / d2 * 1.5);
                        }
                    }
                    player.getCooldowns().addCooldown(this, 350);
                    player.addEffect(new MobEffectInstance(ModEffect.EFFECTMONSTROUS, 200, 0, false, true));
                }

            }

        }
    }

    @Override
    public ResourceLocation getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
        return ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/armor/monstrous_helm.png");
    }

    public static final class ArmorRender implements IClientItemExtensions {
        public static final Monstrous_Helm.ArmorRender INSTANCE = new Monstrous_Helm.ArmorRender();

        @Override
        public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> model) {
            EntityModelSet models = Minecraft.getInstance().getEntityModels();
            ModelPart root = models.bakeLayer(CMModelLayers.MONSTROUS_HELM);
            return new HumanoidModel(root);
        }
    }

}