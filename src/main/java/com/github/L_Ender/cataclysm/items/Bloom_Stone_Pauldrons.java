package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;

import com.github.L_Ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import com.github.L_Ender.cataclysm.items.CuriosItem.AttributeContainer;
import com.github.L_Ender.cataclysm.message.MessageArmorKey;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;


import javax.annotation.Nonnull;
import java.util.List;

public class Bloom_Stone_Pauldrons extends Cataclysm_Armor implements KeybindUsingArmor {

    public Bloom_Stone_Pauldrons(Holder<ArmorMaterial> material, Type slot, Properties properties, AttributeContainer... attributes) {
        super(material, slot, properties,attributes);

    }

    

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add(Component.translatable("item.cataclysm.bloom_stone_pauldrons.desc",ModKeybind.CHESTPLATE_KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (!(entity instanceof Player player) || !level.isClientSide) {
            return;
        }

        if (this.type == Type.CHESTPLATE && player.getItemBySlot(EquipmentSlot.CHEST) == stack) {
            if (ModKeybind.CHESTPLATE_KEY_ABILITY.consumeClick()) {
                PacketDistributor.sendToServer(new MessageArmorKey(EquipmentSlot.CHEST.ordinal(), player.getId(), 6));
                onKeyPacket(player, stack, 6);
            }
        }

    }


    @Override
    public void onKeyPacket(Player player, ItemStack itemStack,int Type) {
        if (player == null) return;
        if (Type == 6) {
            if (!player.getCooldowns().isOnCooldown(ModItems.BLOOM_STONE_PAULDRONS.get())) {
                for (int i = 0; i < 8; i++) {
                    float throwAngle = i * Mth.PI / 4F;
                    double sx = player.getX() + (Mth.cos(throwAngle) * 1);
                    double sy = player.getY() + (player.getBbHeight() * 0.5D);
                    double sz = player.getZ() + (Mth.sin(throwAngle) * 1);

                    double vx = Mth.cos(throwAngle);
                    double vy = 0 + player.getRandom().nextFloat() * 0.3F;
                    double vz = Mth.sin(throwAngle);
                    double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                    Amethyst_Cluster_Projectile_Entity projectile = new Amethyst_Cluster_Projectile_Entity(ModEntities.AMETHYST_CLUSTER_PROJECTILE.get(), player.level(), player, 11);

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