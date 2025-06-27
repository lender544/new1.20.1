package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.capabilities.ChargeCapability;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageCharge {
	private final int entityID;
	private final boolean hasCharge;

	public MessageCharge(int id, ChargeCapability.IChargeCapability cap) {
		this.entityID = id;
		this.hasCharge = cap.isCharge();
	}

	public MessageCharge(Entity entity, ChargeCapability.IChargeCapability cap) {
		this(entity.getId(), cap);
	}

	public MessageCharge(FriendlyByteBuf buf) {
		this.entityID = buf.readInt();
		this.hasCharge = buf.readBoolean();
	}

	public void encode(FriendlyByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeBoolean(this.hasCharge);
	}

	public static class Handler {

		public static boolean onMessage(MessageCharge message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
				if (entity instanceof LivingEntity) {
					entity.getCapability(ModCapabilities.CHARGE_CAPABILITY).ifPresent(cap -> {
						cap.setCharge(message.hasCharge);
					});
				}
			});

			ctx.get().setPacketHandled(true);
			return true;
		}
	}
}
