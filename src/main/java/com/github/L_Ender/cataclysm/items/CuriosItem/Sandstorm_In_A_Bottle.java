package com.github.L_Ender.cataclysm.items.CuriosItem;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.capabilities.Gone_With_SandstormCapability;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import com.github.L_Ender.cataclysm.message.MessageToggleSandstorm;
import com.github.L_Ender.cataclysm.util.SandstormUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

import javax.annotation.Nullable;
import java.util.List;

public class Sandstorm_In_A_Bottle extends CuriosItem {

    public Sandstorm_In_A_Bottle(Properties group) {
        super(group);

    }

    @Override
    public ICurio.SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack) {
        return new ICurio.SoundInfo(SoundEvents.BOTTLE_FILL_DRAGONBREATH, 1.0F, 1.0F);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        Gone_With_SandstormCapability.IGone_With_SandstormCapability SandstormCapability = ModCapabilities.getCapability(livingEntity, ModCapabilities.GONE_WITH_SANDSTORM_CAPABILITY);
        if (livingEntity instanceof Player) {
            if (SandstormCapability != null) {
                if (livingEntity.level().isClientSide()) {
                    if (!SandstormCapability.isSandstorm() && SandstormCapability.getSandstormTimer() <= 0) {
                        if (ModKeybind.KEY_ABILITY.consumeClick()) {
                            Cataclysm.sendMSGToServer(new MessageToggleSandstorm(true));
                        }
                    } else {
                        if (ModKeybind.KEY_ABILITY.consumeClick()) {
                            Cataclysm.sendMSGToServer(new MessageToggleSandstorm(false));
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        Gone_With_SandstormCapability.IGone_With_SandstormCapability SandstormCapability = ModCapabilities.getCapability(livingEntity, ModCapabilities.GONE_WITH_SANDSTORM_CAPABILITY);
        if (livingEntity instanceof Player) {
            if (SandstormCapability != null) {
                SandstormCapability.setSandstorm(false);
                SandstormUtils.toggleFlight(livingEntity,false);
            }

        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.cataclysm.sandstorm_in_a_bottle.desc",ModKeybind.KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
    }

}
