package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.capabilities.HookCapability;
import com.github.L_Ender.cataclysm.capabilities.TidalTentacleCapability;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class MessageTidalTentacle {
	private final int entityID;
	private final boolean hasTentacle;

	public MessageTidalTentacle(int id, TidalTentacleCapability.ITentacleCapability cap) {
		this.entityID = id;
		this.hasTentacle = cap.hasTentacle();
	}


	public MessageTidalTentacle(FriendlyByteBuf buf) {
		this.entityID = buf.readInt();
		this.hasTentacle = buf.readBoolean();
	}

	public void encode(FriendlyByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeBoolean(this.hasTentacle);
	}

	public static class Handler {

		public static boolean onMessage(MessageTidalTentacle message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
				if (entity instanceof LivingEntity) {
					entity.getCapability(ModCapabilities.TENTACLE_CAPABILITY).ifPresent(cap -> {
						cap.setHasTentacle(message.hasTentacle);
					});
				}
			});

			ctx.get().setPacketHandled(true);
			return true;
		}
	}
}
