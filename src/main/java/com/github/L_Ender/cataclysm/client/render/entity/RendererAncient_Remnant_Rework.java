package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelAncient_Remnant_Rework;
import com.github.L_Ender.cataclysm.client.render.layer.Ancient_Ancient_Remnant_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.Ancient_Remnant_Layer;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Ancient_Remnant.Ancient_Remnant_Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererAncient_Remnant_Rework extends MobRenderer<Ancient_Remnant_Entity, ModelAncient_Remnant_Rework> {
    private static final ResourceLocation REMNANT_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/ancient_remnant/ancient_remnant.png");
    private final RandomSource rnd = RandomSource.create();

    public RendererAncient_Remnant_Rework(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelAncient_Remnant_Rework(), 1.5F);
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

