package com.github.L_Ender.cataclysm.client.render.layer;

import com.github.L_Ender.cataclysm.client.model.entity.Ignis_Model;
import com.github.L_Ender.cataclysm.client.render.entity.Ignis_Renderer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;


@OnlyIn(Dist.CLIENT)
public class Ignis_Armor_Crack_Layer extends RenderLayer<Ignis_Entity, Ignis_Model> {

    private static final Map<Ignis_Entity.Crackiness, ResourceLocation> resourceLocations = ImmutableMap.of(
            Ignis_Entity.Crackiness.LOW, new ResourceLocation("cataclysm:textures/entity/ignis/ignis_armor_crack1.png"),
            Ignis_Entity.Crackiness.MEDIUM, new ResourceLocation("cataclysm:textures/entity/ignis/ignis_armor_crack2.png"),
            Ignis_Entity.Crackiness.HIGH, new ResourceLocation("cataclysm:textures/entity/ignis/ignis_armor_crack3.png"));

    public Ignis_Armor_Crack_Layer(Ignis_Renderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Ignis_Entity ignis, float p_117152_, float p_117153_, float p_117154_, float p_117155_, float p_117156_, float p_117157_) {
        if (!ignis.isInvisible()) {
            if(ignis.getBossPhase() > 0){
                Ignis_Entity.Crackiness ignis$crackiness = ignis.getCrackiness();
                if (ignis$crackiness != Ignis_Entity.Crackiness.NONE) {
                    ResourceLocation resourcelocation = resourceLocations.get(ignis$crackiness);
                    renderColoredCutoutModel(this.getParentModel(), resourcelocation, matrixStackIn, bufferIn, packedLightIn, ignis, 1.0F, 1.0F, 1.0F);
                }
            }
        }

    }
}