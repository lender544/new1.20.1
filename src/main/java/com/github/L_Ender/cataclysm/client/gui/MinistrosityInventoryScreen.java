package com.github.L_Ender.cataclysm.client.gui;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.github.L_Ender.cataclysm.inventory.MinistrostiyMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.HorseInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class MinistrosityInventoryScreen extends AbstractContainerScreen<MinistrostiyMenu> {
    private static final ResourceLocation HORSE_INVENTORY_LOCATION = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/gui/ministrosity2.png");
    private final Netherite_Ministrosity_Entity mini;
    private final int inventoryColumns;
    private float xMouse;
    private float yMouse;

    public MinistrosityInventoryScreen(MinistrostiyMenu p_98817_, Inventory p_98818_, Netherite_Ministrosity_Entity p_98819_, int p_352203_) {
        super(p_98817_, p_98818_, p_98819_.getDisplayName());
        this.mini = p_98819_;
        this.inventoryColumns = p_352203_;
    }


    protected void renderBg(GuiGraphics p_282553_, float p_282998_, int p_282929_, int p_283133_) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        p_282553_.blit(HORSE_INVENTORY_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
        p_282553_.blit(HORSE_INVENTORY_LOCATION, i + 70, j + 17, 0, this.imageHeight, inventoryColumns * 18, 54);
        InventoryScreen.renderEntityInInventoryFollowsMouse(p_282553_, i - 10, j + 18, i + 78, j + 70, 34, 0.0F, this.xMouse, this.yMouse, this.mini);
    }



    public void render(GuiGraphics p_281697_, int p_282103_, int p_283529_, float p_283079_) {
        this.xMouse = (float)p_282103_;
        this.yMouse = (float)p_283529_;
        super.render(p_281697_, p_282103_, p_283529_, p_283079_);
        this.renderTooltip(p_281697_, p_282103_, p_283529_);
    }
}