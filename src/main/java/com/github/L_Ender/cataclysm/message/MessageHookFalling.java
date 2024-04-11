package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.capabilities.HookCapability;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageHookFalling {
	private final int entityID;
	private final boolean hashook;

	public MessageHookFalling(int id, HookCapability.IHookCapability cap) {
		this.entityID = id;
		this.hashook = cap.hasHook();
	}

	public MessageHookFalling(Entity entity, HookCapability.IHookCapability cap) {
		this(entity.getId(), cap);
	}

	public MessageHookFalling(FriendlyByteBuf buf) {
		this.entityID = buf.readInt();
		this.hashook = buf.readBoolean();
	}

	public void encode(FriendlyByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeBoolean(this.hashook);
	}

	public static class Handler {

		public static boolean onMessage(MessageHookFalling message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
				if (entity instanceof LivingEntity) {
					entity.getCapability(ModCapabilities.HOOK_CAPABILITY).ifPresent(cap -> {
						cap.setHasHook(message.hashook);
					});
				}
			});

			ctx.get().setPacketHandled(true);
			return true;
		}
	}
}
