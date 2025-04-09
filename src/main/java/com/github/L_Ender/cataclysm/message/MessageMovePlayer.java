package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;


public record MessageMovePlayer(double motionX, double motionY, double motionZ) implements CustomPacketPayload {

	public static final Type<MessageMovePlayer> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"move_player"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MessageMovePlayer> STREAM_CODEC = CustomPacketPayload.codec(MessageMovePlayer::write, MessageMovePlayer::new);

	public MessageMovePlayer(FriendlyByteBuf buf) {
		this(buf.readDouble(), buf.readDouble(), buf.readDouble());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeDouble(this.motionX());
		buf.writeDouble(this.motionY());
		buf.writeDouble(this.motionZ());
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public static void handle(MessageMovePlayer message, IPayloadContext ctx) {
		ctx.enqueueWork(() -> ctx.player().push(message.motionX(), message.motionY(), message.motionZ()));
	}
}