package com.github.L_Ender.cataclysm.client.gui;

import com.github.L_Ender.cataclysm.config.CMConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.resources.ResourceLocation;


import java.util.Locale;
import java.util.regex.Pattern;

public class PartnerStarClient {
    private static final ResourceLocation PARTNER_STAR = new ResourceLocation("cataclysm:textures/gui/partner_star.png");

    public static void renderExtra(ServerSelectionList.OnlineServerEntry onlineServerEntry, ServerData serverData, GuiGraphics guiGraphics, int pIndex, int pTop, int pLeft, int pWidth, int pHeight,
                                   int pMouseX, int pMouseY, boolean pHovering, float pPartialTick) {
        String serverip = serverData.ip;
        if (matches(serverip)) {
            guiGraphics.blit(PARTNER_STAR, pLeft - 34, pTop, 32, 32, 0, 0, 16, 16, 16, 16);
        }
    }

    static boolean matches(String name) {
        String lower = name.toLowerCase(Locale.ROOT);
        return lower.equals("ender.purpleprison.net");
    }


    /**
     * Blits a portion of the texture specified by the atlas location onto the screen at the given position and
     * dimensions with texture coordinates.
     * @param pAtlasLocation the location of the texture atlas.
     * @param pX the x-coordinate of the top-left corner of the blit position.
     * @param pY the y-coordinate of the top-left corner of the blit position.
     * @param pUOffset the horizontal texture coordinate offset.
     * @param pVOffset the vertical texture coordinate offset.
     * @param pWidth the width of the blitted portion.
     * @param pHeight the height of the blitted portion.
     * @param pTextureWidth the width of the texture.
     * @param pTextureHeight the height of the texture.
     */
    public void blit(ResourceLocation pAtlasLocation, int pX, int pY, float pUOffset, float pVOffset, int pWidth, int pHeight, int pTextureWidth, int pTextureHeight) {
    //    this.blit(pAtlasLocation, pX, pY, pWidth, pHeight, pUOffset, pVOffset, pWidth, pHeight, pTextureWidth, pTextureHeight);
    }

}
