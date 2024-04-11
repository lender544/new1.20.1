package com.github.L_Ender.cataclysm.jei;
import com.github.L_Ender.cataclysm.Cataclysm;
import mezz.jei.api.gui.drawable.IDrawable;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class AltarOfAmethystDrawable implements IDrawable {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Cataclysm.MODID, "textures/gui/altar_of_amethyst_jei.png");
    @Override
    public int getWidth() {
        return 125;
    }

    @Override
    public int getHeight() {
        return 59;
    }

    @Override
    public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
        int i = xOffset;
        int j = yOffset;
        guiGraphics.blit(TEXTURE, i, j, 0, 0, 125, 59, 256, 256);
    }
}
