package com.github.L_Ender.cataclysm.entity.etc;

import com.github.L_Ender.cataclysm.message.MessageBossBar;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;

public class CMBossInfoServer extends ServerBossEvent {

    private int renderType;

    private int remainlife;

    public CMBossInfoServer(Component component, BossBarColor bossBarColor, boolean dark, int renderType) {
        super(component, bossBarColor, BossBarOverlay.PROGRESS);
        this.setDarkenScreen(dark);
        this.renderType = renderType;
    }

    public CMBossInfoServer(Component component, BossBarColor bossBarColor, boolean dark,boolean fog, int renderType) {
        super(component, bossBarColor, BossBarOverlay.PROGRESS);

        this.setDarkenScreen(dark);
        this.setCreateWorldFog(fog);
        this.renderType = renderType;
    }


    public void setRenderType(int renderType) {
        if (renderType != this.renderType) {
            this.renderType = renderType;
            PacketDistributor.sendToAllPlayers(new MessageBossBar.Display(this.getId(), renderType,remainlife));
        }
    }

    public int getRenderType() {
        return this.renderType;
    }

    public void setLife(int life) {
        if (life != this.remainlife) {
            this.remainlife = life;
            PacketDistributor.sendToAllPlayers(new MessageBossBar.Display(this.getId(), renderType,life));
        }
    }

    public int getLife() {
        return this.remainlife;
    }


    public void addPlayer(ServerPlayer serverPlayer) {
        PacketDistributor.sendToPlayer(serverPlayer, new MessageBossBar.Display(this.getId(), renderType,remainlife));
        super.addPlayer(serverPlayer);
    }

    public void removePlayer(ServerPlayer serverPlayer) {
        PacketDistributor.sendToPlayer(serverPlayer, new MessageBossBar.Remove(this.getId(), renderType,remainlife));
        super.removePlayer(serverPlayer);
    }

}
