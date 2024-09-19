package com.github.L_Ender.cataclysm.client.render.entity;


import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.entity.ModelAptrgangr;
import com.github.L_Ender.cataclysm.client.model.entity.ModelKobolediator;
import com.github.L_Ender.cataclysm.client.render.layer.AptrgangrRiderLayer;
import com.github.L_Ender.cataclysm.client.render.layer.Kobolediator_Layer;
import com.github.L_Ender.cataclysm.client.render.layer.MaledictusRiderLayer;
import com.github.L_Ender.cataclysm.client.render.layer.Maledictus_Layer;
import com.github.L_Ender.cataclysm.entity.AnimationMonster.BossMonsters.The_Harbinger_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Draugar.Aptrgangr_Entity;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.Kobolediator_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererAptrgangr extends MobRenderer<Aptrgangr_Entity, ModelAptrgangr> {
    private final RandomSource rnd = RandomSource.create();
    private static final ResourceLocation APTRGANGR_TEXTURES = new ResourceLocation(Cataclysm.MODID,"textures/entity/draugar/aptrgangr.png");
    ;

    public RendererAptrgangr(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelAptrgangr(), 1.25F);
        this.addLayer(new AptrgangrRiderLayer(this));

    }
    public Vec3 getRenderOffset(Aptrgangr_Entity entityIn, float partialTicks) {
        if (entityIn.getAttackState() == 4) {
            double d0 = 0.01D;
            return new Vec3(this.rnd.nextGaussian() * d0, this.rnd.nextGaussian() * d0, this.rnd.nextGaussian() * d0);
        } else {
            return super.getRenderOffset(entityIn, partialTicks);
        }
    }

    @Override
    public ResourceLocation getTextureLocation(Aptrgangr_Entity entity) {
        return APTRGANGR_TEXTURES;
    }

    @Override
    protected float getFlipDegrees(Aptrgangr_Entity entity) {
        return 0;
    }

    @Override
    protected void scale(Aptrgangr_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.35F, 1.35F, 1.35F);
    }
}

