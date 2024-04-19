package com.github.L_Ender.cataclysm.util;

import net.minecraft.client.multiplayer.ServerData;

import java.util.List;

public class ClientUtil {

    public static boolean set(ServerData p_233840_, List<ServerData> p_233841_) {
        for(int i = 0; i < p_233841_.size(); ++i) {
            ServerData serverdata = p_233841_.get(i);
            if (serverdata.name.equals(p_233840_.name) && serverdata.ip.equals(p_233840_.ip)) {
                p_233841_.set(i, p_233840_);
                return true;
            }
        }

        return false;
    }
}
