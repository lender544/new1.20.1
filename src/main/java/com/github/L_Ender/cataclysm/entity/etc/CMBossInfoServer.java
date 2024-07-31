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
    private final Mob entity;

    private final Set<ServerPlayer> unseen = new HashSet<>();
    private int renderType;
    private boolean visible = true;

    public CMBossInfoServer(Component component, Mob entity, BossEvent.BossBarColor bossBarColor, boolean dark, int renderType) {
        super(component, bossBarColor, BossBarOverlay.PROGRESS);
        this.setDarkenScreen(dark);
        this.entity = entity;
        this.renderType = renderType;
    }

    public void update(float numerator,float denominator) {
        this.setProgress(numerator / denominator);
        Iterator<ServerPlayer> it = this.unseen.iterator();
        while (it.hasNext()) {
            ServerPlayer player = it.next();
            if (this.entity.getSensing().hasLineOfSight(player)) {
                super.addPlayer(player);
                it.remove();
            }
        }
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


    @Override
    public void addPlayer(ServerPlayer player) {
        Cataclysm.sendNonLocal(new MessageUpdateBossBar(this.getId(), renderType), player);
        if (this.entity.getSensing().hasLineOfSight(player)) {
            super.addPlayer(player);
        } else {
            this.unseen.add(player);
        }
    }

    @Override
    public void removePlayer(ServerPlayer player) {
        super.removePlayer(player);
        this.unseen.remove(player);
        Cataclysm.sendNonLocal(new MessageUpdateBossBar(this.getId(), -1), player);
    }

}
