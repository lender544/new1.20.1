package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Drowned_Host_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Drowned_Host_Outer_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Skylands.Drowned_Host_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Zombie;

public class Drowned_Host_Renderer extends AbstractZombieRenderer<Drowned_Host_Entity, Drowned_Host_Model<Drowned_Host_Entity>> {
    private static final ResourceLocation DROWNED_LOCATION = new ResourceLocation(Cataclysm.MODID,"textures/entity/sea/drowned_host.png");

    public Drowned_Host_Renderer(EntityRendererProvider.Context p_173964_) {
        super(
                p_173964_,
                new Drowned_Host_Model<>(p_173964_.bakeLayer(CMModelLayers.DROWNED_HOST)),
                new Drowned_Host_Model<>(p_173964_.bakeLayer(CMModelLayers.DROWNED_HOST_INNER_ARMOR)),
                new Drowned_Host_Model<>(p_173964_.bakeLayer(CMModelLayers.DROWNED_HOST_OUTER_ARMOR))
        );
        this.addLayer(new Drowned_Host_Outer_Layer<>(this, p_173964_.getModelSet()));
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Override
    public ResourceLocation getTextureLocation(Zombie entity) {
        return DROWNED_LOCATION;
    }

    protected void setupRotations(Drowned_Host_Entity p_114109_, PoseStack p_114110_, float p_114111_, float p_114112_, float p_114113_) {
        super.setupRotations(p_114109_, p_114110_, p_114111_, p_114112_, p_114113_);
        float f = p_114109_.getSwimAmount(p_114113_);
        if (f > 0.0F) {
            float f1 = -10.0F - p_114109_.getXRot();
            float f2 = Mth.lerp(f, 0.0F, f1);
            p_114110_.rotateAround(Axis.XP.rotationDegrees(f2), 0.0F, p_114109_.getBbHeight() / 2.0F, 0.0F);
        }

    }
}
