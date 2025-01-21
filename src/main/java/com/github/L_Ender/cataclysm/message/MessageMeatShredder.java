package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.sound.BossMusicPlayer;
import com.github.L_Ender.cataclysm.client.sound.MeatShredderSound;
import com.github.L_Ender.cataclysm.entity.etc.Animation_Monsters;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageMeatShredder(int entityID, boolean play) implements CustomPacketPayload {

	public static final Type<MessageMeatShredder> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"meatshredder_sound"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MessageMeatShredder> STREAM_CODEC = CustomPacketPayload.codec(MessageMeatShredder::write, MessageMeatShredder::new);

	public MessageMeatShredder(FriendlyByteBuf buf) {
		this(buf.readInt(), buf.readBoolean());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(this.entityID());
		buf.writeBoolean(this.play());
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
	@SuppressWarnings("Convert2Lambda")
	public static void handle(MessageMeatShredder message, IPayloadContext ctx) {
		if (ctx.flow().isClientbound()) {
			ctx.enqueueWork(new Runnable() {
				@Override
				public void run() {
					Entity entity = ctx.player().level().getEntity(message.entityID());
					if (entity instanceof LivingEntity living) {
						Minecraft.getInstance().getSoundManager().queueTickingSound(new MeatShredderSound(living));
					}
				}
			});
		}
	}
}