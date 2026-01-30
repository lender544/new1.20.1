package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.event.CameraZoomManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * Packets to help sync the server's Aether boss bars with the client's.
 */
public record MessageCameraZoom(int entityID,int duration, float distance,float N,float U,float M) implements CustomPacketPayload {

    public static final Type<MessageCameraZoom> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"camera_zoom"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MessageCameraZoom> STREAM_CODEC = CustomPacketPayload.codec(MessageCameraZoom::write, MessageCameraZoom::new);

    public MessageCameraZoom(FriendlyByteBuf buf) {
        this(buf.readInt(),buf.readInt(),buf.readFloat(),buf.readFloat(),buf.readFloat(),buf.readFloat());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.entityID);
        buf.writeInt(this.duration);
        buf.writeFloat(this.distance);
        buf.writeFloat(this.N);
        buf.writeFloat(this.U);
        buf.writeFloat(this.M);
    }


    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void execute(MessageCameraZoom payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            Entity entity = context.player().level().getEntity(payload.entityID);
            if (entity instanceof Player player) {
                if (player == Minecraft.getInstance().player && Minecraft.getInstance().getCameraEntity() == Minecraft.getInstance().player) {
                    CameraZoomManager.startZoom(payload.duration,payload.distance,payload.N,payload.U,payload.M);
                }

            }

        });
    }
}
