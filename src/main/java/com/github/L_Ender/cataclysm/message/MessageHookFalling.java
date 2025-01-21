package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModDataAttachments;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MessageHookFalling(int entityID, boolean falling) implements CustomPacketPayload {

	public static final Type<MessageHookFalling> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"hook_falling_attachment"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MessageHookFalling> STREAM_CODEC = CustomPacketPayload.codec(MessageHookFalling::write, MessageHookFalling::new);

	public MessageHookFalling(FriendlyByteBuf buf) {
		this(buf.readInt(), buf.readBoolean());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(this.entityID());
		buf.writeBoolean(this.falling());
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public static void handle(MessageHookFalling message, IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			Entity entity = ctx.player().level().getEntity(message.entityID());
			if (entity instanceof LivingEntity) {
				entity.setData(ModDataAttachments.HOOK_FALLING, message.falling());
			}
		});
	}
}