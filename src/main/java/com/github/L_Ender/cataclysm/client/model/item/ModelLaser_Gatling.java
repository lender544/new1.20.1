package com.github.L_Ender.cataclysm.client.model.item;

import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelLaser_Gatling extends AdvancedEntityModel<Entity> {
    private final AdvancedModelBox root;
    private final AdvancedModelBox core_root;
    private final AdvancedModelBox core;
    private final AdvancedModelBox core2;
    private final AdvancedModelBox handle;
    private final AdvancedModelBox gatling;

    public ModelLaser_Gatling() {
        texWidth = 128;
        texHeight = 128;

        root = new AdvancedModelBox(this);
        root.setRotationPoint(0.0F, 24.0F, 0.0F);
        root.setTextureOffset(0, 0).addBox(-2.5F, -9.0F, 6.0F, 5.0F, 9.0F, 5.0F, 0.0F, false);
        root.setTextureOffset(41, 30).addBox(-1.0F, -12.0F, 11.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
        root.setTextureOffset(62, 0).addBox(-2.5F, -4.0F, -2.0F, 5.0F, 4.0F, 8.0F, 0.0F, false);
        root.setTextureOffset(0, 0).addBox(-4.0F, -6.0F, -17.0F, 8.0F, 4.0F, 25.0F, 0.1F, false);
        root.setTextureOffset(0, 30).addBox(-4.0F, -10.2F, -17.0F, 8.0F, 4.0F, 24.0F, 0.1F, false);

        core_root = new AdvancedModelBox(this);
        core_root.setRotationPoint(-1.5F, 0.0F, 4.0F);
        root.addChild(core_root);
        setRotationAngle(core_root, 0.0F, 0.0F, 0.7418F);
        core_root.setTextureOffset(0, 41).addBox(-4.0F, -10.0F, -1.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);

        core = new AdvancedModelBox(this);
        core.setRotationPoint(-1.0F, -10.0F, 2.0F);
        core_root.addChild(core);
        core.setTextureOffset(16, 0).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        core.setTextureOffset(0, 21).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 1.0F, 2.0F, 0.1F, false);

        core2 = new AdvancedModelBox(this);
        core2.setRotationPoint(-4.0F, -8.0F, -8.0F);
        core_root.addChild(core2);
        core2.setTextureOffset(16, 15).addBox(-1.0F, -4.0F, 8.5F, 2.0F, 1.0F, 2.0F, 0.1F, false);
        core2.setTextureOffset(42, 0).addBox(-1.0F, -4.0F, 8.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        handle = new AdvancedModelBox(this);
        handle.setRotationPoint(1.5F, 0.0F, -4.0F);
        root.addChild(handle);
        setRotationAngle(handle, 0.0F, 0.0F, -0.7418F);
        handle.setTextureOffset(0, 30).addBox(-1.0F, -10.0F, 7.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
        handle.setTextureOffset(10, 16).addBox(1.5F, -13.0F, 7.0F, 0.0F, 3.0F, 5.0F, 0.0F, false);
        handle.setTextureOffset(0, 15).addBox(-0.5F, -13.0F, 7.0F, 2.0F, 0.0F, 5.0F, 0.0F, false);

        gatling = new AdvancedModelBox(this);
        gatling.setRotationPoint(0.0F, -6.0F, 6.0F);
        root.addChild(gatling);
        gatling.setTextureOffset(0, 59).addBox(-2.0F, -2.0F, -9.0F, 4.0F, 4.0F, 9.0F, 0.0F, false);
        gatling.setTextureOffset(48, 49).addBox(-0.5F, -4.0F, -22.0F, 1.0F, 3.0F, 17.0F, 0.0F, false);
        gatling.setTextureOffset(42, 0).addBox(-0.5F, 1.0F, -22.0F, 1.0F, 3.0F, 17.0F, 0.0F, false);
        gatling.setTextureOffset(41, 30).addBox(1.0F, -0.5F, -22.0F, 3.0F, 1.0F, 17.0F, 0.0F, false);
        gatling.setTextureOffset(41, 30).addBox(-4.0F, -0.5F, -22.0F, 3.0F, 1.0F, 17.0F, 0.0F, false);
        this.updateDefaultPose();
    }

    @Override
    public void setupAnim(Entity entity, float openAmount, float switchProgress, float ageInTicks, float netHeadYaw, float headPitch){
        this.resetToDefaultPose();

        this.core.rotationPointY += Mth.cos(ageInTicks) * 1F + 1F;
        this.core2.rotationPointY += Mth.cos(ageInTicks + (float) Math.PI) * 1F + 1F;


        gatling.rotateAngleZ -= openAmount * 0.75f;
        root.rotationPointZ += Mth.cos(openAmount * 2F) * 1F + 1F;

    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        root.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
        AdvancedModelBox.rotateAngleX = x;
        AdvancedModelBox.rotateAngleY = y;
        AdvancedModelBox.rotateAngleZ = z;
    }

    @Override
    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(
                root,
                core_root,
                handle,
                core,
                core2,
                gatling

        );
    }

    @Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(root);
    }


}