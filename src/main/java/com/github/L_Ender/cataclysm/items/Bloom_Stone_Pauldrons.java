package com.github.L_Ender.cataclysm.items;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.projectile.Amethyst_Cluster_Projectile_Entity;
import com.github.L_Ender.cataclysm.init.ModEntities;
import com.github.L_Ender.cataclysm.init.ModItems;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import com.github.L_Ender.cataclysm.message.MessageArmorKey;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.Nullable;
import java.util.List;

public class Bloom_Stone_Pauldrons extends ArmorItem implements KeybindUsingArmor {

    public Bloom_Stone_Pauldrons(Armortier material, ArmorItem.Type slot, Properties properties) {
        super(material, slot, properties);

    }

    @Override
    public void initializeClient(java.util.function.Consumer<IClientItemExtensions> consumer) {
        consumer.accept((IClientItemExtensions) Cataclysm.PROXY.getArmorRenderProperties());
    }


    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return Cataclysm.MODID + ":textures/armor/bloom_stone_pauldrons.png";
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.cataclysm.bloom_stone_pauldrons.desc",ModKeybind.CHESTPLATE_KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
    }

    public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean held) {
        super.inventoryTick(stack, level, entity, i, held);
        if (entity instanceof Player living) {
            if (living.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.BLOOM_STONE_PAULDRONS.get()) {
                if (level.isClientSide) {
                    if (Cataclysm.PROXY.getClientSidePlayer() == entity && Cataclysm.PROXY.isKeyDown(6)) {
                        Cataclysm.sendMSGToServer(new MessageArmorKey(EquipmentSlot.CHEST.ordinal(), living.getId(), 6));
                        onKeyPacket(living, stack,6);
                    }
                }

            }

        }
    }


    @Override
    public void onKeyPacket(Player player, ItemStack itemStack,int Type) {
        if (player !=null && !player.getCooldowns().isOnCooldown(this) ) {
            for (int i = 0; i < 8; i++) {
                float throwAngle = i * Mth.PI / 4F;
                double sx = player.getX() + (Mth.cos(throwAngle) * 1);
                double sy = player.getY() + (player.getBbHeight() * 0.5D);
                double sz = player.getZ() + (Mth.sin(throwAngle) * 1);

                double vx = Mth.cos(throwAngle);
                double vy = 0 + player.getRandom().nextFloat() * 0.3F;
                double vz = Mth.sin(throwAngle);
                double v3 = Mth.sqrt((float) (vx * vx + vz * vz));
                Amethyst_Cluster_Projectile_Entity projectile = new Amethyst_Cluster_Projectile_Entity(ModEntities.AMETHYST_CLUSTER_PROJECTILE.get(), player.level(), player);

                projectile.moveTo(sx, sy, sz, i * 11.25F, player.getXRot());
                float speed = 0.8F;
                projectile.shoot(vx, vy + v3 * 0.20000000298023224D, vz, speed, 1.0F);
                player.level().addFreshEntity(projectile);
            }
            player.getCooldowns().addCooldown(ModItems.BLOOM_STONE_PAULDRONS.get(), 240);
        }
    }
}