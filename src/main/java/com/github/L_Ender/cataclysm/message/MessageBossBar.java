package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;

import com.github.L_Ender.cataclysm.ClientProxy;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.UUID;

/**
 * Packets to help sync the server's Aether boss bars with the client's.
 */
public abstract class MessageBossBar implements CustomPacketPayload {
    protected final UUID bossEvent;
    protected final int rendertype;

    public MessageBossBar(UUID bossEvent, int rendertype) {
        this.bossEvent = bossEvent;
        this.rendertype = rendertype;
    }

    /**
     * Adds a boss bar for the client.
     */
    public static class Display extends MessageBossBar {
        public static final Type<Display> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "add_custom_bossbar"));

        public static final StreamCodec<RegistryFriendlyByteBuf, Display> STREAM_CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC,
            Display::getBossEvent,
            ByteBufCodecs.INT,
            Display::getRendertype,
            Display::new);

        public Display(UUID bossEvent, int rendertype) {
            super(bossEvent, rendertype);
        }

        @Override
        public Type<Display> type() {
            return TYPE;
        }

        public static void execute(Display payload, IPayloadContext context) {
            ClientProxy.bossBarRenderTypes.put(payload.bossEvent, payload.rendertype);
        }
    }

    /**
     * Removes a boss bar for the client.
     */
    public static class Remove extends MessageBossBar {
        public static final Type<Remove> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID, "remove_custom_bossbar"));

        public static final StreamCodec<RegistryFriendlyByteBuf, Remove> STREAM_CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC,
            Remove::getBossEvent,
            ByteBufCodecs.INT,
            Remove::getRendertype,
            Remove::new);

        public Remove(UUID bossEvent, int entityID) {
            super(bossEvent, entityID);
        }

        @Override
        public Type<Remove> type() {
            return TYPE;
        }

        public static void execute(Remove payload, IPayloadContext context) {
            ClientProxy.bossBarRenderTypes.remove(payload.bossEvent);
        }
    }

    public UUID getBossEvent() {
        return this.bossEvent;
    }

    public int getRendertype() {
        return this.rendertype;
    }
}
