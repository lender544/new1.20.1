package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.entity.projectile.Tidal_Hook_Entity;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedEntityModel;
import com.github.L_Ender.lionfishapi.client.model.tools.AdvancedModelBox;
import com.github.L_Ender.lionfishapi.client.model.tools.BasicModelPart;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector4f;

public class Tidal_Hook_Model extends AdvancedEntityModel<Tidal_Hook_Entity> {
    private final AdvancedModelBox body;
    private final AdvancedModelBox claw2;
    private final AdvancedModelBox claw4;
    private final AdvancedModelBox claw;
    private final AdvancedModelBox claw3;

    public Tidal_Hook_Model() {
        texWidth = 64;
        texHeight = 64;

        body = new AdvancedModelBox(this);
        body.setRotationPoint(0.0F, -3.0F, 0.0F);
        body.setTextureOffset(0, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(14, 0).addBox(-2.5F, 1.0F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
        body.setTextureOffset(0, 2).addBox(-2.75F, 1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(2.75F, 1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        body.setTextureOffset(4, 0).addBox(-1.0F, 1.0F, 2.75F, 2.0F, 2.0F, 0.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-1.0F, 1.0F, -2.75F, 2.0F, 2.0F, 0.0F, 0.0F, false);

        claw2 = new AdvancedModelBox(this);
        claw2.setRotationPoint(1.5F, 0.0F, 0.0F);
        body.addChild(claw2);
        setRotationAngle(claw2, 0.0F, 0.0F, -0.7418F);
        claw2.setTextureOffset(19, 17).addBox(0.0F, -2.0F, -1.5F, 8.0F, 2.0F, 3.0F, 0.0F, false);

        claw4 = new AdvancedModelBox(this);
        claw4.setRotationPoint(-1.5F, 0.0F, 0.0F);
        body.addChild(claw4);
        setRotationAngle(claw4, 0.0F, 0.0F, 0.7418F);
        claw4.setTextureOffset(14, 10).addBox(-8.0F, -2.0F, -1.5F, 8.0F, 2.0F, 3.0F, 0.0F, false);

        claw = new AdvancedModelBox(this);
        claw.setRotationPoint(0.0F, 0.0F, 1.5F);
        body.addChild(claw);
        setRotationAngle(claw, 0.7418F, 0.0F, 0.0F);
        claw.setTextureOffset(0, 10).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 2.0F, 8.0F, 0.0F, false);

        claw3 = new AdvancedModelBox(this);
        claw3.setRotationPoint(0.0F, 0.0F, -1.5F);
        body.addChild(claw3);
        setRotationAngle(claw3, -0.7418F, 0.0F, 0.0F);
        claw3.setTextureOffset(0, 0).addBox(-1.5F, -2.0F, -8.0F, 3.0F, 2.0F, 8.0F, 0.0F, false);
        this.updateDefaultPose();
    }

    /**
     * Sets this entity's model rotation angles
     */


    @Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(body,claw,claw2,claw3,claw4);
    }

    @Override
    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(body);
    }

    public void setupAnim(Tidal_Hook_Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }


    public Vec3 getChainPosition(Vec3 offset, PoseStack transform) {
        this.body.translateAndRotate(transform);
        Vector4f vec = new Vector4f((float) offset.x, (float) offset.y, (float) offset.z, 1.0F);
        vec.mul(transform.last().pose());
        return new Vec3(vec.x(), vec.y(), vec.z());
    }

    public void setRotationAngle(AdvancedModelBox AdvancedModelBox, float x, float y, float z) {
        AdvancedModelBox.rotateAngleX = x;
        AdvancedModelBox.rotateAngleY = y;
        AdvancedModelBox.rotateAngleZ = z;
    }

}