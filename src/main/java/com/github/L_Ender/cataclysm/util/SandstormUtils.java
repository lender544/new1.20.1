package com.github.L_Ender.cataclysm.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public final class SandstormUtils {

	public static void toggleFlight(LivingEntity living, boolean flight) {
		if (!living.level().isClientSide && living instanceof ServerPlayer player) {
			boolean prevFlying = player.getAbilities().flying;
			boolean trueFlight = isCreativePlayer(living) || flight;
			player.getAbilities().mayfly = trueFlight;
			player.getAbilities().flying = trueFlight;
			float defaultFlightSpeed = 0.05F;
			if (flight) {
				player.getAbilities().setFlyingSpeed(defaultFlightSpeed * 0.5F);
			} else {
				player.getAbilities().setFlyingSpeed(defaultFlightSpeed);
				if (!player.isSpectator()) {
					player.getAbilities().flying = false;
					if(!player.isCreative()){
						player.getAbilities().mayfly = false;
					}
				}
			}
			if (prevFlying != flight) {
				player.onUpdateAbilities();
			}
		}
	}

	private static boolean isCreativePlayer(LivingEntity living) {
		return living instanceof Player player && player.isCreative();
	}
}
