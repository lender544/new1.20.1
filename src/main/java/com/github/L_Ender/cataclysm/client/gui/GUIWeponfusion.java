package com.github.L_Ender.cataclysm.client.gui;

import com.github.L_Ender.cataclysm.inventory.WeaponfusionMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GUIWeponfusion extends ItemCombinerScreen<WeaponfusionMenu> {
    private static final ResourceLocation SMITHING_LOCATION = new ResourceLocation("cataclysm:textures/gui/fusion.png");

    public GUIWeponfusion(WeaponfusionMenu p_99290_, Inventory p_99291_, Component p_99292_) {
        super(p_99290_, p_99291_, p_99292_, SMITHING_LOCATION);
        this.titleLabelX = 66;
        this.titleLabelY = 18;
    }

    protected void renderErrorIcon(GuiGraphics p_282905_, int p_283237_, int p_282237_) {
        if ((this.menu.getSlot(0).hasItem() || this.menu.getSlot(1).hasItem()) && !this.menu.getSlot(this.menu.getResultSlot()).hasItem()) {
            p_282905_.blit(SMITHING_LOCATION, p_283237_ + 99, p_282237_ + 45, this.imageWidth, 0, 28, 21);
        }

    }

}
