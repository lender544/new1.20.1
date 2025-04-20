package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Netherite_Ministrosity_Model;
import com.github.L_Ender.cataclysm.client.model.entity.Netherite_Monstrosity_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Netherite_Ministrosity_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Netherite_Monstrosity_Flare;
import com.github.L_Ender.cataclysm.client.render.layer.Netherite_Monstrosity_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Netherite_Monstrosity_Layer2;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.NewNetherite_Monstrosity.Netherite_Monstrosity_Part;
import com.github.L_Ender.cataclysm.entity.Pet.Netherite_Ministrosity_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Netherite_Ministrosity_Renderer extends MobRenderer<Netherite_Ministrosity_Entity, Netherite_Ministrosity_Model> {

    private static final ResourceLocation NETHER_MONSTROSITY_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/monstrosity/netherite_ministrosity.png");

    public Netherite_Ministrosity_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Netherite_Ministrosity_Model(renderManagerIn.bakeLayer(CMModelLayers.NETHERITE_MINISTROSITY_MODEL)), 0.5F);
        this.addLayer(new Netherite_Ministrosity_Layer(this));

    }
    @Override
    public ResourceLocation getTextureLocation(Netherite_Ministrosity_Entity entity) {
        return NETHER_MONSTROSITY_TEXTURES;
    }


    @Override
    protected void scale(Netherite_Ministrosity_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1F, 1F, 1F);
    }


}
