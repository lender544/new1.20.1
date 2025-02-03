package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.init.ModDataAttachments;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;


import java.util.UUID;
import java.util.function.Supplier;
public record MessageTidalTentacle(int entityID, boolean tentacle) implements CustomPacketPayload {

	public static final Type<MessageTidalTentacle> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"tentacle_attachment"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MessageTidalTentacle> STREAM_CODEC = CustomPacketPayload.codec(MessageTidalTentacle::write, MessageTidalTentacle::new);

	public MessageTidalTentacle(FriendlyByteBuf buf) {
		this(buf.readInt(), buf.readBoolean());
	}

	public void write(FriendlyByteBuf buf) {
		buf.writeInt(this.entityID());
		buf.writeBoolean(this.tentacle());

	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public static void handle(MessageTidalTentacle message, IPayloadContext ctx) {
		ctx.enqueueWork(() -> {
			Level level = ctx.player().level();
			Entity entity = level.getEntity(message.entityID());
			if (entity instanceof Player player) {
				var attachment = player.getData(ModDataAttachments.TIDAL_TENTACLE_ATTACHMENT);
				attachment.setHasTentacle(message.tentacle());
			}
		});
	}
}
