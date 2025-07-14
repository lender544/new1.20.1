package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.capabilities.HookCapability;
import com.github.L_Ender.cataclysm.config.CMConfig;
import com.github.L_Ender.cataclysm.init.ModCapabilities;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageEntityCamera {
	private final int entityID;
	private final boolean firstperson;

	public MessageEntityCamera(int id, boolean firstperson) {
		this.entityID = id;
		this.firstperson = firstperson;
	}
	public MessageEntityCamera(Entity entity, boolean firstperson) {
		this(entity.getId(), firstperson);
	}

	public MessageEntityCamera(FriendlyByteBuf buf) {
		this.entityID = buf.readInt();
		this.firstperson = buf.readBoolean();
	}

	public void encode(FriendlyByteBuf buf) {
		buf.writeInt(this.entityID);
		buf.writeBoolean(this.firstperson);
	}

	public static class Handler {

		public static boolean onMessage(MessageEntityCamera message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Entity entity = Minecraft.getInstance().level.getEntity(message.entityID);
				if (entity instanceof Player player) {
					if (message.firstperson) {
						if (CMConfig.setFirstPerson) {
							if (player == Minecraft.getInstance().player && Minecraft.getInstance().getCameraEntity() == Minecraft.getInstance().player) {
								Minecraft.getInstance().setCameraEntity(entity);
								Minecraft.getInstance().options.setCameraType(CameraType.FIRST_PERSON);
							}
						}
					}else {
						if (CMConfig.setThirdPerson) {
							if (player == Minecraft.getInstance().player && Minecraft.getInstance().getCameraEntity() == Minecraft.getInstance().player) {
								Minecraft.getInstance().setCameraEntity(entity);
								Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_BACK);
							}
						}
					}
				}
			});

			ctx.get().setPacketHandled(true);
			return true;
		}
	}
}
