package com.github.L_Ender.cataclysm.message;
import java.util.function.Supplier;

import com.github.L_Ender.cataclysm.client.gui.MinistrosityInventoryScreen;
import com.github.L_Ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.github.L_Ender.cataclysm.inventory.MinistrostiyMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;


public class MessageMiniinventory {
    private final int id;
    private final int size;
    private final int entityId;

    public MessageMiniinventory(int id, int size, int entityId) {
        this.id = id;
        this.size = size;
        this.entityId = entityId;
    }
    
    public static MessageMiniinventory read(FriendlyByteBuf buf) {
        return new MessageMiniinventory(buf.readUnsignedByte(), buf.readVarInt(), buf.readInt());
    }

    public static void write(MessageMiniinventory message, FriendlyByteBuf buf) {
        buf.writeByte(message.id);
        buf.writeVarInt(message.size);
        buf.writeInt(message.entityId);
    }

    
    public int getId() {
        return this.id;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int getEntityId() {
        return this.entityId;
    }

    public static class Handler {
        public Handler() {
        }

        public static void handle(MessageMiniinventory msg, Supplier<NetworkEvent.Context> context) {
            context.get().enqueueWork(() -> {
                Player player = Minecraft.getInstance().player;
                if (player != null) {
                    Entity entity = player.level().getEntity(msg.getEntityId());
                    if (entity instanceof Netherite_Ministrosity_Entity guard) {
                        LocalPlayer clientplayerentity = Minecraft.getInstance().player;
                        MinistrostiyMenu container = new MinistrostiyMenu(msg.getId(), player.getInventory(), guard.miniInventory, guard);
                        clientplayerentity.containerMenu = container;
                        Minecraft.getInstance().setScreen(new MinistrosityInventoryScreen(container, player.getInventory(), guard));
                    }
                }
            });
            context.get().setPacketHandled(true);
        }
    }
}