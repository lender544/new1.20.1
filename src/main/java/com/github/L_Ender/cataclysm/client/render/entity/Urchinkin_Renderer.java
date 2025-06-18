package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Urchinkin_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Urchinkin_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AcropolisMonsters.Urchinkin_Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Urchinkin_Renderer extends MobRenderer<Urchinkin_Entity, Urchinkin_Model> {
    private static final ResourceLocation URCHIN_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/urchinkin.png");
    private static final ResourceLocation MEAT_BOY = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/meat_boy.png");


    public Urchinkin_Renderer(Context renderManagerIn) {
        super(renderManagerIn, new Urchinkin_Model(renderManagerIn.bakeLayer(CMModelLayers.URCHINKIN_MODEL)), 0.25F);
        this.addLayer(new Urchinkin_Layer(this));

    }


    @Override
    public ResourceLocation getTextureLocation(Urchinkin_Entity entity) {
        if (entity.isMeatBoy()) {
            return MEAT_BOY;
        } else {
            return URCHIN_TEXTURES;
        }
    }


}