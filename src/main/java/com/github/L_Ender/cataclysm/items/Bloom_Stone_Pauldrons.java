package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import com.github.L_Ender.cataclysm.message.MessageArmorKey;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
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

public class Bloom_Stone_Pauldrons extends ArmorItem implements KeybindUsingArmor {

    public Bloom_Stone_Pauldrons(Holder<ArmorMaterial> material, Type slot, Properties properties) {
        super(material, slot, properties);

    }

    

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add(Component.translatable("item.cataclysm.bloom_stone_pauldrons.desc",ModKeybind.CHESTPLATE_KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof Player living) {
            if (living.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.BLOOM_STONE_PAULDRONS.get()) {
                if (level.isClientSide) {
                    if (ModKeybind.CHESTPLATE_KEY_ABILITY.isDown()) {
                        PacketDistributor.sendToServer(new MessageArmorKey(EquipmentSlot.CHEST.ordinal(), living.getId(), 6));
                        onKeyPacket(living, stack,6);
                    }
                }

            }

        }
    }


    @Override
    public void onKeyPacket(Player player, ItemStack itemStack,int Type) {
        if (Type == 6) {
            if (player != null && !player.getCooldowns().isOnCooldown(ModItems.BLOOM_STONE_PAULDRONS.get())) {
                for (int i = 0; i < 8; i++) {
                    float throwAngle = i * Mth.PI / 4F;
                    double sx = player.getX() + (Mth.cos(throwAngle) * 1);
                    double sy = player.getY() + (player.getBbHeight() * 0.5D);
                    double sz = player.getZ() + (Mth.sin(throwAngle) * 1);

                    double vx = Mth.cos(throwAngle);
                    double vy = 0 + player.getRandom().nextFloat() * 0.3F;
                    double vz = Mth.sin(throwAngle);
                    double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                    Amethyst_Cluster_Projectile_Entity projectile = new Amethyst_Cluster_Projectile_Entity(ModEntities.AMETHYST_CLUSTER_PROJECTILE.get(), player.level(), player, (float)CMConfig.AmethystClusterdamage);

                    projectile.moveTo(sx, sy, sz, i * 11.25F, player.getXRot());
                    float speed = 0.8F;
                    projectile.shoot(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                    player.level().addFreshEntity(projectile);
                }
                player.getCooldowns().addCooldown(ModItems.BLOOM_STONE_PAULDRONS.get(), 240);
            }
        }

    }

    @Override
    public ResourceLocation getArmorTexture(@Nonnull ItemStack stack, @Nonnull Entity entity, @Nonnull EquipmentSlot slot, @Nonnull ArmorMaterial.Layer layer, boolean isInnerModel) {
        return ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "textures/armor/bloom_stone_pauldrons.png");
    }

}