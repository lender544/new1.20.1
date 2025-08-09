package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Teddy_Bear_Model;
import com.github.L_Ender.cataclysm.entity.Pet.Teddy_Bear_Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Teddy_Bear_Renderer extends MobRenderer<Teddy_Bear_Entity, Teddy_Bear_Model> {

    private static final ResourceLocation TEDDY_BEAR_LOCATION = new ResourceLocation(Cataclysm.MODID, "textures/entity/teddy_bear.png");

    public Teddy_Bear_Renderer(EntityRendererProvider.Context context) {
        super(context, new Teddy_Bear_Model(context.bakeLayer(Teddy_Bear_Model.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Teddy_Bear_Entity entity) {
        return TEDDY_BEAR_LOCATION;
    }
}