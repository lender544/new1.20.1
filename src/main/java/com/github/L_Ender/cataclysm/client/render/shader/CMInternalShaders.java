package com.github.L_Ender.cataclysm.client.render.shader;

import net.minecraft.client.renderer.ShaderInstance;

import javax.annotation.Nullable;

public class CMInternalShaders {


    private static ShaderInstance renderTypeHologramShader;
    
    public static void setRenderTypeHologramShader(ShaderInstance instance) {
        renderTypeHologramShader = instance;
    }

    @Nullable
    public static ShaderInstance getRenderTypeHologramShader() {
        return renderTypeHologramShader;
    }

}
