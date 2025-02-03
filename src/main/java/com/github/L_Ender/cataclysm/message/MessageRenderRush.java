package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModDataAttachments;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;


public record MessageRenderRush(int entityID, boolean falling,int timer,float damage) implements CustomPacketPayload {

	public static final Type<MessageRenderRush> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"render_attachment"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MessageRenderRush> STREAM_CODEC = CustomPacketPayload.codec(MessageRenderRush::write, MessageRenderRush::new);

	public MessageRenderRush(FriendlyByteBuf buf) {
		this(buf.readInt(), buf.readBoolean(),buf.readInt(),buf.readFloat());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(this.entityID());
		buf.writeBoolean(this.falling());
		buf.writeInt(this.timer());
		buf.writeFloat(this.damage());
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public static void handle(MessageRenderRush message, IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			Level level = ctx.player().level();
			Entity entity = level.getEntity(message.entityID());
			if (entity instanceof Player player) {
				var attachment = player.getData(ModDataAttachments.RENDER_RUSH_ATTACHMENT);
				attachment.setRush(message.falling());
				attachment.setTimer(message.timer());
				attachment.setdamage(message.damage());
			}
		});
	}
}


