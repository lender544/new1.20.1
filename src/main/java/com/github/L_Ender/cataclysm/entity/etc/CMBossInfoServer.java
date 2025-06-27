package com.github.L_Ender.cataclysm.entity.etc;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.message.MessageUpdateBossBar;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.Mob;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CMBossInfoServer extends ServerBossEvent {

    private int renderType;

    public CMBossInfoServer(Component component, BossEvent.BossBarColor bossBarColor, boolean dark, int renderType) {
        super(component, bossBarColor, BossBarOverlay.PROGRESS);
        this.setDarkenScreen(dark);
        this.renderType = renderType;
    }


    public void setRenderType(int renderType) {
        if (renderType != this.renderType) {
            this.renderType = renderType;
            Cataclysm.sendMSGToAll(new MessageUpdateBossBar(this.getId(), renderType));
        }
    }

    public int getRenderType() {
        return this.renderType;
    }


    public void addPlayer(ServerPlayer serverPlayer) {
        Cataclysm.sendNonLocal(new MessageUpdateBossBar(this.getId(), renderType), serverPlayer);
        super.addPlayer(serverPlayer);
    }

    public void removePlayer(ServerPlayer serverPlayer) {
        Cataclysm.sendNonLocal(new MessageUpdateBossBar(this.getId(), -1), serverPlayer);
        super.removePlayer(serverPlayer);
    }

}
