package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.The_Prowler_Model;
import com.github.L_Ender.cataclysm.client.model.entity.Urchinkin_Model;
import com.github.L_Ender.cataclysm.client.render.layer.The_Prowler_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Coralssus_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Urchinkin_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.The_Prowler_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.WalkAnimationState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Urchinkin_Renderer extends MobRenderer<Urchinkin_Entity, Urchinkin_Model> {
    private static final ResourceLocation URCHIN_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/urchinkin.png");
    private static final ResourceLocation MEAT_BOY = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/sea/meat_boy.png");


    public Urchinkin_Renderer(Context renderManagerIn) {
        super(renderManagerIn, new Urchinkin_Model(renderManagerIn.bakeLayer(CMModelLayers.URCHINKIN_MODEL)), 0.25F);
       // this.addLayer(new LayerGenericGlowing(this, PROWLER_LAYER_TEXTURES));

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