package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.capabilities.RenderRushCapability;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageRenderRush {
	private final int entityID;
	private final boolean hasRush;

	public MessageRenderRush(int id, RenderRushCapability.IRenderRushCapability cap) {
		this.entityID = id;
		this.hasRush = cap.isRush();
	}

	public MessageRenderRush(Entity entity, RenderRushCapability.IRenderRushCapability cap) {
		this(entity.getId(), cap);
	}

	public MessageRenderRush(FriendlyByteBuf buf) {
		this.entityID = buf.readInt();
		this.hasRush = buf.readBoolean();
	}

	public void encode(FriendlyByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeBoolean(this.hasRush);
	}

	public static class Handler {

		public static boolean onMessage(MessageRenderRush message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
				if (entity instanceof LivingEntity) {
					entity.getCapability(ModCapabilities.RENDER_RUSH_CAPABILITY).ifPresent(cap -> {
						cap.setRush(message.hasRush);
					});
				}
			});

			ctx.get().setPacketHandled(true);
			return true;
		}
	}
}
