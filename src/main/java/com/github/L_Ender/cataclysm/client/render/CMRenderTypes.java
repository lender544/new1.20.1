package com.github.L_Ender.cataclysm.client.render;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


import java.util.function.BiFunction;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class CMRenderTypes extends RenderType {
    public CMRenderTypes(String p_173178_, VertexFormat p_173179_, VertexFormat.Mode p_173180_, int p_173181_, boolean p_173182_, boolean p_173183_, Runnable p_173184_, Runnable p_173185_) {
        super(p_173178_, p_173179_, p_173180_, p_173181_, p_173182_, p_173183_, p_173184_, p_173185_);
    }

    public static RenderType getBright(ResourceLocation location) {
        return BRIGHT.apply(location);
    }

    public static RenderType getFlickering(ResourceLocation location) {
        return FLICKERING.apply(location);
    }

    public static RenderType getfullBright(ResourceLocation location) {
        return FULL_BRIGHT.apply(location);
    }

    public static RenderType getGlowingEffect(ResourceLocation location) {
        return GLOWING_EFFECT.apply(location);
    }

    public static RenderType getGhost(ResourceLocation p_110455_, boolean p_110456_) {
        return GHOST.apply(p_110455_, p_110456_);
    }

    public static RenderType getGhost(ResourceLocation p_110474_) {
        return getGhost(p_110474_, true);
    }


    public static RenderType CMEyes(ResourceLocation location) {
        return CMEYE.apply(location);
    }

    public static RenderType jelly(ResourceLocation location) {
        return JELLY.apply(location);
    }

    public static RenderType getTrailEffect(ResourceLocation location) {
        return NEW_TRAIL_EFFECT.apply(location);
    }

    public static RenderType getLightTrailEffect(ResourceLocation location) {
        return LIGHT_TRAIL_EFFECT.apply(location);
    }

    public static RenderType DragonDeath(ResourceLocation location) {
        return DRAGON_DEATH.apply(location);
    }

    public static final Function<ResourceLocation, RenderType> BRIGHT = Util.memoize(
            p_286169_ -> {
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setTextureState(new TextureStateShard(p_286169_, false, false))
                        .setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER)
                        .setTransparencyState(NO_TRANSPARENCY)
                        .setCullState(NO_CULL)
                        .setLightmapState(LIGHTMAP)
                        .setOverlayState(OVERLAY)
                        .createCompositeState(false);


                return create("bright", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256,false,true, rendertype$compositestate);
            }
    );

    public static final Function<ResourceLocation, RenderType> FLICKERING = Util.memoize(
            p_286169_ -> {
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setTextureState(new TextureStateShard(p_286169_, false, false))
                        .setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER)
                        .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                        .setCullState(NO_CULL)
                        .setLightmapState(LIGHTMAP)
                        .setOverlayState(OVERLAY)
                        .createCompositeState(false);


                return create("flickering", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256,false,true, rendertype$compositestate);
            }
    );




    public static final Function<ResourceLocation, RenderType> FULL_BRIGHT = Util.memoize(
            p_286169_ -> {
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setTextureState(new TextureStateShard(p_286169_, false, false))
                        .setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER)
                        .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                        .setCullState(NO_CULL)
                        .setLightmapState(LIGHTMAP)
                        .setOverlayState(OVERLAY)
                        .createCompositeState(false);


                return create("full_bright", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256,false,true, rendertype$compositestate);
            }
    );



    public static final Function<ResourceLocation, RenderType> GLOWING_EFFECT = Util.memoize(
            p_286169_ -> {
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setTextureState(new TextureStateShard(p_286169_, false, false))
                        .setShaderState(RENDERTYPE_BEACON_BEAM_SHADER)
                        .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                        .setCullState(NO_CULL)
                        .setOverlayState(OVERLAY)
                        .setWriteMaskState(COLOR_WRITE)
                        .createCompositeState(false);


                return create("glow_effect", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256,true,true, rendertype$compositestate);
            }
    );


    public static final Function<ResourceLocation, RenderType> NEW_TRAIL_EFFECT = Util.memoize(
            p_286155_ -> {
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setShaderState(RENDERTYPE_ITEM_ENTITY_TRANSLUCENT_CULL_SHADER)
                        .setTextureState(new TextureStateShard(p_286155_, false, false))
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
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setShaderState(RENDERTYPE_EYES_SHADER)
                        .setTextureState(new TextureStateShard(p_286155_, false, false))
                        .setTransparencyState(ADDITIVE_TRANSPARENCY)
                        .setOutputState(ITEM_ENTITY_TARGET)
                        .setLightmapState(LIGHTMAP)
                        .setCullState(NO_CULL)
                        .setOverlayState(OVERLAY)
                        .setWriteMaskState(COLOR_WRITE)
                        .createCompositeState(true);
                return create("light_trail_effect", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 1536, true, true, rendertype$compositestate);
            }
    );



    public static final Function<ResourceLocation, RenderType> CMEYE = Util.memoize(
            p_286169_ -> {
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setShaderState(RENDERTYPE_EYES_SHADER)
                        .setTextureState(new TextureStateShard(p_286169_, false, false))
                        .setTransparencyState(ADDITIVE_TRANSPARENCY)
                        .setCullState(NO_CULL)
                        .setWriteMaskState(COLOR_WRITE)
                        .setOverlayState(OVERLAY).
                        createCompositeState(false);


                return create("cm_eyes", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 1536,false,true, rendertype$compositestate);
            }
    );


    public static final Function<ResourceLocation, RenderType> JELLY = Util.memoize(
            p_286169_ -> {
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER)
                        .setTextureState(new TextureStateShard(p_286169_, false, false))
                        .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                        .setCullState(NO_CULL)
                        .setWriteMaskState(COLOR_DEPTH_WRITE)
                        .setOverlayState(OVERLAY).
                        createCompositeState(true);

                return create("jelly", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 1536,true,true, rendertype$compositestate);
            }
    );



    private static final BiFunction<ResourceLocation, Boolean, RenderType> GHOST = Util.memoize((p_286156_, p_286157_) -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder()
                .setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_SHADER)
                .setTextureState(new RenderStateShard.TextureStateShard(p_286156_, false, false))
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setCullState(NO_CULL)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .setWriteMaskState(COLOR_DEPTH_WRITE)
                .setDepthTestState(LEQUAL_DEPTH_TEST)
                .setLayeringState(NO_LAYERING)
                .createCompositeState(p_286157_);
        return create("ghost", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, rendertype$compositestate);
    });


    public static final Function<ResourceLocation, RenderType> DRAGON_DEATH = Util.memoize(
            p_286169_ -> {
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setShaderState(RENDERTYPE_ENTITY_ALPHA_SHADER)
                        .setCullState(NO_CULL)
                        .setTextureState(new TextureStateShard(p_286169_, false, false))
                        .createCompositeState(true);

                return create("dragon_death", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256,false,false, rendertype$compositestate);
            }
    );


    public static final Function<ResourceLocation, RenderType> SHOCK_WAVE = Util.memoize(
            p_286169_ -> {
                CompositeState rendertype$compositestate = CompositeState.builder()
                        .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER)
                        .setCullState(NO_CULL)
                        .setTextureState(new TextureStateShard(new ResourceLocation(Cataclysm.MODID,"textures/particle/shock_wave.png"), true, true))
                        .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                        .setLightmapState(LIGHTMAP)
                        .setOverlayState(OVERLAY)
                        .setWriteMaskState(COLOR_WRITE)
                        .setDepthTestState(LEQUAL_DEPTH_TEST)
                        .setLayeringState(VIEW_OFFSET_Z_LAYERING)
                        .createCompositeState(false);
                return create("shock_wave", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, rendertype$compositestate);
            }
    );


    public static RenderType getShockWave() {
        CompositeState renderState = CompositeState.builder()
                .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER)
                .setCullState(NO_CULL)
                .setTextureState(new TextureStateShard(new ResourceLocation(Cataclysm.MODID,"textures/particle/shock_wave.png"), true, true))
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .setWriteMaskState(COLOR_WRITE)
                .setDepthTestState(LEQUAL_DEPTH_TEST)
                .setLayeringState(VIEW_OFFSET_Z_LAYERING)
                .createCompositeState(false);
        return create("shock_wave", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, renderState);
    }

    public static RenderType getPulse() {
        CompositeState renderState = CompositeState.builder()
                .setShaderState(RENDERTYPE_ENERGY_SWIRL_SHADER)
                .setCullState(NO_CULL)
                .setTextureState(new TextureStateShard(new ResourceLocation(Cataclysm.MODID,"textures/particle/em_pulse.png"), true, true))
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setLightmapState(LIGHTMAP)
                .setOverlayState(OVERLAY)
                .setWriteMaskState(COLOR_WRITE)
                .setDepthTestState(LEQUAL_DEPTH_TEST)
                .setLayeringState(VIEW_OFFSET_Z_LAYERING)
                .createCompositeState(false);
        return create("em_pulse", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, renderState);
    }
}
