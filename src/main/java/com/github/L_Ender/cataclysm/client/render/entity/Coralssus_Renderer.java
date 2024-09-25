package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.Coralssus_Model;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Coralssus_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Coralssus_Renderer extends MobRenderer<Coralssus_Entity, Coralssus_Model> {

    private static final ResourceLocation FIRE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/coralssus_fire.png");
    private static final ResourceLocation HORN_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/coralssus_horn.png");
    private static final ResourceLocation TUBE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/coralssus_tube.png");
    private static final ResourceLocation SPONGE_TEXTURE = new ResourceLocation(Cataclysm.MODID,"textures/entity/deepling/coralssus_sponge_horn.png");


    public Coralssus_Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new Coralssus_Model(), 1.7F);

    }
    @Override
    public ResourceLocation getTextureLocation(Coralssus_Entity entity) {
        if (entity.isSponge()) {
            return SPONGE_TEXTURE;
        } else {
            ResourceLocation resourcelocation;
            switch (entity.getVariant()) {
                case FIRE:
                    resourcelocation = FIRE_TEXTURE;
                    break;
                case HORN:
                    resourcelocation = HORN_TEXTURE;
                    break;
                case TUBE:
                    resourcelocation = TUBE_TEXTURE;
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }

            return resourcelocation;
        }
    }

    @Override
    protected float getFlipDegrees(Coralssus_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Coralssus_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.35F, 1.35F, 1.35F);
    }
}

