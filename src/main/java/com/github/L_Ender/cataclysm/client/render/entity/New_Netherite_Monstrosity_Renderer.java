package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Netherite_Monstrosity_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Netherite_Monstrosity_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Netherite_Monstrosity_Layer2;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class New_Netherite_Monstrosity_Renderer extends MobRenderer<Netherite_Monstrosity_Entity, Netherite_Monstrosity_Model> {

    private static final ResourceLocation NETHER_MONSTROSITY_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/monstrosity/netherite_monstrosity.png");

    public New_Netherite_Monstrosity_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Netherite_Monstrosity_Model(renderManagerIn.bakeLayer(CMModelLayers.NETHERITE_MOMSTROSITY_MODEL)), 2.5F);
        this.addLayer(new Netherite_Monstrosity_Layer(this));
        this.addLayer(new Netherite_Monstrosity_Layer2(this));
    }
    @Override
    public ResourceLocation getTextureLocation(Netherite_Monstrosity_Entity entity) {
        return NETHER_MONSTROSITY_TEXTURES;
    }

    public boolean shouldRender(Netherite_Monstrosity_Entity livingEntityIn, Frustum camera, double camX, double camY, double camZ) {
        if (super.shouldRender(livingEntityIn, camera, camX, camY, camZ)) {
            return true;
        } else {
            for(Netherite_Monstrosity_Part part : livingEntityIn.monstrosityParts){
                if(camera.isVisible(part.getBoundingBox())){
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    protected void scale(Netherite_Monstrosity_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }

    @Override
    protected float getFlipDegrees(Netherite_Monstrosity_Entity entity) {
        return 0;
    }

}
