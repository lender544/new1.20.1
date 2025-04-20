package com.github.L_Ender.cataclysm.message;

import com.github.L_Ender.cataclysm.Cataclysm;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class MessageUpdateBossBar {

    private UUID bossBar;
    private int renderType;

    public MessageUpdateBossBar(UUID bossBar, int renderType) {
        this.bossBar = bossBar;
        this.renderType = renderType;
    }


    public static MessageUpdateBossBar read(FriendlyByteBuf buf) {
        return new MessageUpdateBossBar(buf.readUUID(), buf.readInt());
    }

    public static void write(MessageUpdateBossBar message, FriendlyByteBuf buf) {
        buf.writeUUID(message.bossBar);
        buf.writeInt(message.renderType);
    }


    public static void handle(MessageUpdateBossBar message, Supplier<NetworkEvent.Context> context) {
        context.get().setPacketHandled(true);
        Player playerSided = context.get().getSender();
        if (context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
            playerSided = Cataclysm.PROXY.getClientSidePlayer();
        }
        if(message.renderType == -1){
            Cataclysm.PROXY.removeBossBarRender(message.bossBar);
        }else{
            Cataclysm.PROXY.setBossBarRender(message.bossBar, message.renderType);
        }
    }
}
