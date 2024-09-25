package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Ancient_Remnant_Rework_Model;
import com.github.L_Ender.cataclysm.client.render.layer.Ancient_Remnant_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Ancient_Remnant_Rework_Renderer extends MobRenderer<Ancient_Remnant_Entity, Ancient_Remnant_Rework_Model> {
    private static final ResourceLocation REMNANT_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/ancient_remnant/ancient_remnant.png");
    private final RandomSource rnd = RandomSource.create();

    public Ancient_Remnant_Rework_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Ancient_Remnant_Rework_Model(), 1.5F);
        this.addLayer(new Ancient_Remnant_Layer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Ancient_Remnant_Entity entity) {
        return REMNANT_TEXTURES;
    }


    @Override
    protected float getFlipDegrees(Ancient_Remnant_Entity entity) {
        return 0;
    }

}

