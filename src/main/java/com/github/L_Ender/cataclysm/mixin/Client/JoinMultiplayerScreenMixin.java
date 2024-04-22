package com.github.L_Ender.cataclysm.mixin.Client;

import com.github.L_Ender.cataclysm.client.gui.PartnerStarClient;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList;
import net.minecraft.client.multiplayer.ServerData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerSelectionList.OnlineServerEntry.class)
public class JoinMultiplayerScreenMixin {

    @Shadow @Final private ServerData serverData;

    @Inject(at = @At("HEAD"), method = "render")
    private void onRender(GuiGraphics guiGraphics, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pHovering, float pPartialTick, CallbackInfo ci) {
        PartnerStarClient.renderExtra((ServerSelectionList.OnlineServerEntry)(Object)this,this.serverData,guiGraphics, pIndex, pTop, pLeft, pWidth, pHeight, pMouseX, pMouseY, pHovering, pPartialTick);
    }
}