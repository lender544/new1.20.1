package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.Cataclysm;
import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.Ancient_Remnant_Rework_Model;
import com.github.L_Ender.cataclysm.client.model.entity.The_Prowler_Model;
import com.github.L_Ender.cataclysm.client.render.layer.The_Prowler_Layer;
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
public class The_Prowler_Renderer extends MobRenderer<The_Prowler_Entity, The_Prowler_Model> {
    private final RandomSource rnd = RandomSource.create();
    private static final ResourceLocation PROWLER_TEXTURES = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/factory/the_prowler.png");

    private static final ResourceLocation[] TEXTURE_PROGRESS  = new ResourceLocation[4];

    public The_Prowler_Renderer(Context renderManagerIn) {
        super(renderManagerIn, new The_Prowler_Model(renderManagerIn.bakeLayer(CMModelLayers.PROWLER_MODEL)), 0.7F);
       // this.addLayer(new LayerGenericGlowing(this, PROWLER_LAYER_TEXTURES));
        this.addLayer(new The_Prowler_Layer(this));
        for(int i = 0; i < 4; i++){
            TEXTURE_PROGRESS[i] = ResourceLocation.fromNamespaceAndPath(Cataclysm.MODID,"textures/entity/factory/the_prowler_" + i + ".png");
        }

    }

    @Override
    protected float getFlipDegrees(The_Prowler_Entity entity) {
        return 0;
    }

    @Override
    public ResourceLocation getTextureLocation(The_Prowler_Entity entity) {
        WalkAnimationState walkanimationstate = entity.walkAnimation;
        int f3 = (int) walkanimationstate.position(entity.tickCount);
        return getGrowingTexture(entity, (int) ((f3 * 0.5F) % 4));
    }

    public ResourceLocation getGrowingTexture(The_Prowler_Entity entity, int age) {
        return TEXTURE_PROGRESS[Mth.clamp(age, 0, 4)];
    }

    public Vec3 getRenderOffset(The_Prowler_Entity entityIn, float partialTicks) {
        if (entityIn.getAttackState() == 1) {
            double d0 = 0.05D;
            return new Vec3(this.rnd.nextGaussian() * d0, 0.0D, this.rnd.nextGaussian() * d0);
        } else {
            return super.getRenderOffset(entityIn, partialTicks);
        }
    }

    @Override
    protected void scale(The_Prowler_Entity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}