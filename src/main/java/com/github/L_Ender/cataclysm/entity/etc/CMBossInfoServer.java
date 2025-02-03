package com.github.L_Ender.cataclysm.entity.etc;

import com.github.L_Ender.cataclysm.message.MessageBossBar;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;

public class CMBossInfoServer extends ServerBossEvent {

    private int renderType;

    public CMBossInfoServer(Component component, BossBarColor bossBarColor, boolean dark, int renderType) {
        super(component, bossBarColor, BossBarOverlay.PROGRESS);
        this.setDarkenScreen(dark);
        this.renderType = renderType;
    }


    public void setRenderType(int renderType) {
        if (renderType != this.renderType) {
            this.renderType = renderType;
            PacketDistributor.sendToAllPlayers(new MessageBossBar.Display(this.getId(), renderType));
        }
    }

    public int getRenderType() {
        return this.renderType;
    }


    public void addPlayer(ServerPlayer serverPlayer) {
        PacketDistributor.sendToPlayer(serverPlayer, new MessageBossBar.Display(this.getId(), renderType));
        super.addPlayer(serverPlayer);
    }

    public void removePlayer(ServerPlayer serverPlayer) {
        PacketDistributor.sendToPlayer(serverPlayer, new MessageBossBar.Remove(this.getId(), renderType));
        super.removePlayer(serverPlayer);
    }

}
