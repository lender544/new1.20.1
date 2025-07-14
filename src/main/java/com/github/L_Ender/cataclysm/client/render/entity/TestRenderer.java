package com.github.L_Ender.cataclysm.client.render.entity;

import com.github.L_Ender.cataclysm.client.model.CMModelLayers;
import com.github.L_Ender.cataclysm.client.model.entity.TestModel;
import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Test.Test_Entity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.IronGolemModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.IronGolemCrackinessLayer;
import net.minecraft.client.renderer.entity.layers.IronGolemFlowerLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.IronGolem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class TestRenderer extends MobRenderer<Test_Entity, TestModel<Test_Entity>> {
    private static final ResourceLocation GOLEM_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/iron_golem/iron_golem.png");

    public TestRenderer(EntityRendererProvider.Context p_174188_) {
        super(p_174188_, new TestModel<>(p_174188_.bakeLayer(CMModelLayers.TEST_MODEL)), 0.7F);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(Test_Entity entity) {
        return GOLEM_LOCATION;
    }

    protected void setupRotations(Test_Entity entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations(entity, poseStack, bob, yBodyRot, partialTick, scale);
        if (!((double)entity.walkAnimation.speed() < 0.01)) {
            float f = 13.0F;
            float f1 = entity.walkAnimation.position(partialTick) + 6.0F;
            float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            poseStack.mulPose(Axis.ZP.rotationDegrees(6.5F * f2));
        }
    }
}
