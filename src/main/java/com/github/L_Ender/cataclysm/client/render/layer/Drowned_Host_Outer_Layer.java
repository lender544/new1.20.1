package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Drowned_Host_Model;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.AcropolisMonsters.Drowned_Host_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class Drowned_Host_Outer_Layer<T extends Drowned_Host_Entity> extends RenderLayer<T, Drowned_Host_Model<T>> {
    private static final ResourceLocation DROWNED_OUTER_LAYER_LOCATION = new ResourceLocation(Cataclysm.MODID,"textures/entity/sea/drowned_host_outer_layer.png");


    private final Drowned_Host_Model<T> model;

    public Drowned_Host_Outer_Layer(RenderLayerParent<T, Drowned_Host_Model<T>> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = new Drowned_Host_Model<>(modelSet.bakeLayer(CMModelLayers.DROWNED_HOST_OUTER_LAYER));
    }



    public void render(PoseStack p_116924_, MultiBufferSource p_116925_, int p_116926_, T p_116927_, float p_116928_, float p_116929_, float p_116930_, float p_116931_, float p_116932_, float p_116933_) {
        coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, DROWNED_OUTER_LAYER_LOCATION, p_116924_, p_116925_, p_116926_, p_116927_, p_116928_, p_116929_, p_116931_, p_116932_, p_116933_, p_116930_, 1.0F, 1.0F, 1.0F);
    }
}
