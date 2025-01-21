package com.github.L_Ender.cataclysm.client.render.item;


import com.github.L_Ender.cataclysm.client.render.CMItemstackRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;


public class CMItemRenderProperties implements IClientItemExtensions {

    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        return new CMItemstackRenderer();
    }
}
