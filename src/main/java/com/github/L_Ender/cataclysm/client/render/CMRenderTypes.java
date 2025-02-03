package com.github.L_Ender.cataclysm.client.render;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.Util;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.function.BiFunction;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class CMRenderTypes extends RenderType {
    public CMRenderTypes(String p_173178_, VertexFormat p_173179_, VertexFormat.Mode p_173180_, int p_173181_, boolean p_173182_, boolean p_173183_, Runnable p_173184_, Runnable p_173185_) {
        super(p_173178_, p_173179_, p_173180_, p_173181_, p_173182_, p_173183_, p_173184_, p_173185_);
    }

    protected static final TransparencyStateShard GHOST_TRANSPARANCY = new TransparencyStateShard("translucent_ghost_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });

    public static RenderType getBright(ResourceLocation locationIn) {
        TextureStateShard renderstate$texturestate = new TextureStateShard(locationIn, false, false);
        return create("bright", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, true, CompositeState
                .builder()
                .setTextureState(renderstate$texturestate)
                .setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER)
                .setTransparencyState(NO_TRANSPARENCY)
                .setCullState(NO_CULL)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .createCompositeState(false));
    }

    public static RenderType getFlickering(ResourceLocation p_228652_0_, float lightLevel) {
        TextureStateShard renderstate$texturestate = new TextureStateShard(p_228652_0_, false, false);
        return create("flickering", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, true, CompositeState
                .builder()
                .setTextureState(renderstate$texturestate)
                .setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER)
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setCullState(NO_CULL).setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .createCompositeState(false));
    }

    public static RenderType getfullBright(ResourceLocation locationIn) {
        TextureStateShard renderstate$texturestate = new TextureStateShard(locationIn, false, false);
        return create("full_bright", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, true, CompositeState
                .builder()
                .setTextureState(renderstate$texturestate)
                .setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER)
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setCullState(NO_CULL)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .createCompositeState(false));
    }

    public static RenderType getGlowingEffect(ResourceLocation locationIn) {
        TextureStateShard renderstate$texturestate = new TextureStateShard(locationIn, false, false);
        return create("glow_effect", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, CompositeState.builder()
                .setTextureState(renderstate$texturestate)
                .setShaderState(RENDERTYPE_BEACON_BEAM_SHADER)
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setCullState(NO_CULL).setOverlayState(OVERLAY)
                .setWriteMaskState(COLOR_WRITE)
                .createCompositeState(false));
    }

    public static RenderType getghost(ResourceLocation texture) {
        CompositeState renderState = CompositeState.builder()
                .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER)
                .setCullState(NO_CULL)
                .setTextureState(new TextureStateShard(texture, false, false))
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .setWriteMaskState(COLOR_DEPTH_WRITE)
                .setDepthTestState(LEQUAL_DEPTH_TEST)
                .setLayeringState(NO_LAYERING)
                .createCompositeState(false);
        return create("ghost", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, renderState);
    }


    public static RenderType getPulse() {
        CompositeState renderState = CompositeState.builder()
                .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER)
                .setCullState(NO_CULL)
                .setTextureState(new TextureStateShard(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/particle/em_pulse.png"), true, true))
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .setWriteMaskState(COLOR_WRITE)
                .setDepthTestState(LEQUAL_DEPTH_TEST)
                .setLayeringState(VIEW_OFFSET_Z_LAYERING)
                .createCompositeState(false);
        return create("em_pulse", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, renderState);
    }


    public static RenderType getTrailEffect(ResourceLocation locationIn) {
        TextureStateShard renderstate$texturestate = new TextureStateShard(locationIn, false, false);
        return create("trail_effect", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 1536, true, true, CompositeState.builder()
                .setTextureState(renderstate$texturestate)
                .setShaderState(RENDERTYPE_ITEM_ENTITY_TRANSLUCENT_CULL_SHADER)
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setOutputState(ITEM_ENTITY_TARGET)
                .setCullState(NO_CULL)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .setWriteMaskState(RenderStateShard.COLOR_DEPTH_WRITE)
                .createCompositeState(true));
    }

    public static final Function<ResourceLocation, RenderType> NEW_TRAIL_EFFECT = Util.memoize(
            p_286155_ -> {
                RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder()
                        .setShaderState(RENDERTYPE_ITEM_ENTITY_TRANSLUCENT_CULL_SHADER)
                        .setTextureState(new RenderStateShard.TextureStateShard(p_286155_, false, false))
                        .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                        .setOutputState(ITEM_ENTITY_TARGET)
                        .setLightmapState(LIGHTMAP)
                        .setCullState(NO_CULL)
                        .setOverlayState(OVERLAY)
                        .setWriteMaskState(RenderStateShard.COLOR_DEPTH_WRITE)
                        .createCompositeState(true);
                return create("new_trail_effect", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 1536, true, true, rendertype$compositestate);
            }
    );

    public static final Function<ResourceLocation, RenderType> LIGHT_TRAIL_EFFECT = Util.memoize(
            p_286155_ -> {
                RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder()
                        .setShaderState(RENDERTYPE_EYES_SHADER)
                        .setTextureState(new RenderStateShard.TextureStateShard(p_286155_, false, false))
                        .setTransparencyState(ADDITIVE_TRANSPARENCY)
                        .setOutputState(ITEM_ENTITY_TARGET)
                        .setLightmapState(LIGHTMAP)
                        .setCullState(NO_CULL)
                        .setOverlayState(OVERLAY)
                        .setWriteMaskState(RenderStateShard.COLOR_DEPTH_WRITE)
                        .createCompositeState(true);
                return create("light_trail_effect", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 1536, true, true, rendertype$compositestate);
            }
    );


    public static RenderType CMEyes(ResourceLocation locationIn) {
        TextureStateShard renderstateshard$texturestateshard = new TextureStateShard(locationIn, false, false);
        return create("cm_eyes", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 1536, false, true, CompositeState.builder()
                .setShaderState(RENDERTYPE_EYES_SHADER)
                .setTextureState(renderstateshard$texturestateshard)
                .setTransparencyState(ADDITIVE_TRANSPARENCY)
                .setCullState(NO_CULL)
                .setWriteMaskState(COLOR_WRITE)
                .setOverlayState(OVERLAY).
                createCompositeState(false));
    }


    public static final RenderType LIGHTNING = create(
            "lightning",
            DefaultVertexFormat.POSITION_COLOR,
            VertexFormat.Mode.QUADS,
            1536,
            false,
            true,
            RenderType.CompositeState.builder()
                    .setShaderState(RENDERTYPE_LIGHTNING_SHADER)
                    .setWriteMaskState(COLOR_DEPTH_WRITE)
                    .setTransparencyState(LIGHTNING_TRANSPARENCY)
                    .setOutputState(WEATHER_TARGET)
                    .createCompositeState(false)
    );


    public static RenderType getGhost(ResourceLocation texture) {
        CompositeState renderState = CompositeState.builder()
                .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER)
                .setCullState(NO_CULL)
                .setTextureState(new TextureStateShard(texture, false, false))
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .setWriteMaskState(COLOR_DEPTH_WRITE)
                .setDepthTestState(LEQUAL_DEPTH_TEST)
                .setLayeringState(NO_LAYERING)
                .createCompositeState(false);
        return create("ghost", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, renderState);
    }

    public static RenderType DragonDeath(ResourceLocation texture) {
        CompositeState rendertype$compositestate = CompositeState.builder().setShaderState(RENDERTYPE_ENTITY_ALPHA_SHADER)
                .setTextureState(new TextureStateShard(texture, false, false))
                .setCullState(NO_CULL)
                .createCompositeState(true);
        return create("entity_alpha", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256,true,true, rendertype$compositestate);
    }

    public static RenderType getShockWave() {
        CompositeState renderState = CompositeState.builder()
                .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER)
                .setCullState(NO_CULL)
                .setTextureState(new TextureStateShard(ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/particle/shock_wave.png"), true, true))
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .setWriteMaskState(COLOR_WRITE)
                .setDepthTestState(LEQUAL_DEPTH_TEST)
                .setLayeringState(VIEW_OFFSET_Z_LAYERING)
                .createCompositeState(false);
        return create("shock_wave", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, renderState);
    }

}
