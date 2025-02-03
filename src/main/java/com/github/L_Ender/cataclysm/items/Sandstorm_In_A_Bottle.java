package com.github.L_Ender.cataclysm.items;


import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.entity.effect.Sandstorm_Entity;
import com.github.L_Ender.cataclysm.init.ModKeybind;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class Sandstorm_In_A_Bottle extends Item {

	public Sandstorm_In_A_Bottle(Properties properties) {
		super(properties);
	}

	@Nonnull
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, @Nonnull InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if (!level.isClientSide()) {
			for (int i = 0; i < 2; i++) {
				float angle = i * Mth.PI;
				double sx = player.getX() + (Mth.cos(angle) * 6);
				double sy = player.getY();
				double sz = player.getZ() + (Mth.sin(angle) * 6);
				Sandstorm_Entity projectile = new Sandstorm_Entity(player.level(), sx,sy,sz,200,angle,player);
				player.level().addFreshEntity(projectile);
			}

		}

		if (!level.isClientSide) {
			player.getCooldowns().addCooldown(this,  CMConfig.SandstormInABottleCOOLDOWN);

		}

		return InteractionResultHolder.success(stack);
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {
		return false;
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}


	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flags) {
		tooltip.add(Component.translatable("item.cataclysm.sandstorm_in_a_bottle.desc", ModKeybind.KEY_ABILITY.getTranslatedKeyMessage()).withStyle(ChatFormatting.DARK_GREEN));
	}
}