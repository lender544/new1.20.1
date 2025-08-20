package com.github.L_Ender.cataclysm.client.model.entity;

import com.github.L_Ender.cataclysm.entity.InternalAnimationMonster.IABossMonsters.Test.Onyx_Entity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.phys.Vec3;

public class TestModel<T extends Onyx_Entity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;

    public TestModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild(
                "head",
                CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F).texOffs(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F),
                PartPose.offset(0.0F, -7.0F, -2.0F)
        );
        partdefinition.addOrReplaceChild(
                "body",
                CubeListBuilder.create()
                        .texOffs(0, 40)
                        .addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F)
                        .texOffs(0, 70)
                        .addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)),
                PartPose.offset(0.0F, -7.0F, 0.0F)
        );
        partdefinition.addOrReplaceChild(
                "right_arm", CubeListBuilder.create().texOffs(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F), PartPose.offset(0.0F, -7.0F, 0.0F)
        );
        partdefinition.addOrReplaceChild(
                "left_arm", CubeListBuilder.create().texOffs(60, 58).addBox(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F), PartPose.offset(0.0F, -7.0F, 0.0F)
        );
        partdefinition.addOrReplaceChild(
                "right_leg", CubeListBuilder.create().texOffs(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F), PartPose.offset(-4.0F, 11.0F, 0.0F)
        );
        partdefinition.addOrReplaceChild(
                "left_leg", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F), PartPose.offset(5.0F, 11.0F, 0.0F)
        );
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    /**
     * Sets this entity's model rotation angles
     */
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.head.yRot = netHeadYaw * (float) (Math.PI / 180.0);
        this.head.xRot = headPitch * (float) (Math.PI / 180.0);


        Vec3 moveVec = entity.getDeltaMovement().normalize().yRot((float) Math.toRadians(entity.yBodyRot + 90.0));
        float forward = (float) Math.max(0, new Vec3(1.0, 0, 0).dot(moveVec));
        float backward = (float) Math.max(0, new Vec3(-1.0, 0, 0).dot(moveVec));
        float left = (float) Math.max(0, new Vec3(0, 0, -1.0).dot(moveVec));
        float right = (float) Math.max(0, new Vec3(0, 0, 1.0).dot(moveVec));
        float walkAnim = 1.0F;
        float animSpeed = 1.0F;
        limbSwingAmount *= 2;
        limbSwingAmount = Math.min(0.7f, limbSwingAmount);
        walkLeftAnim(left  * walkAnim, limbSwing, limbSwingAmount, animSpeed);
        walkRightAnim(right  * walkAnim, limbSwing, limbSwingAmount, animSpeed);

    }


    private void walkForwardAnim(float blend, float limbSwing, float limbSwingAmount, float speed) {


        float globalHeight = 1.5f;
        float globalDegree = 1.5f;

        leftLeg.xRot +=(blend * (float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.55f * globalDegree) * limbSwingAmount);
        leftLeg.yRot +=(blend * (float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.1f * globalDegree - 0.15f) * limbSwingAmount);

        rightLeg.xRot +=(blend * -(float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.55f * globalDegree) * limbSwingAmount);
        rightLeg.yRot +=(blend * (float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.1f * globalDegree + 0.15f) * limbSwingAmount);

    }

    private void walkBackwardAnim(float blend, float limbSwing, float limbSwingAmount, float speed) {

        float globalHeight = 1.5f;
        float globalDegree = 1.5f;

        leftLeg.xRot =(blend * (float) (Math.cos(limbSwing * speed * 0.5 - 1.5) * 0.55f * globalDegree - 0.3 * globalDegree) * limbSwingAmount);
        leftLeg.yRot =(blend * (float) (Math.cos(limbSwing * speed * 0.5 - 1.5) * 0.1f * globalDegree - 0.15f) * limbSwingAmount);

        rightLeg.xRot =(blend * -(float) (Math.cos(limbSwing * speed * 0.5 - 1.5) * 0.55f * globalDegree + 0.3 * globalDegree) * limbSwingAmount);
        rightLeg.yRot =(blend * (float) (Math.cos(limbSwing * speed * 0.5 - 1.5) * 0.1f * globalDegree + 0.15f) * limbSwingAmount);

    }

    private void walkLeftAnim(float blend, float limbSwing, float limbSwingAmount, float speed) {

        float globalHeight = 1.5f;
        float globalDegree = 1.5f;

        leftLeg.xRot +=(blend * -0.05f * limbSwingAmount * globalHeight);
        leftLeg.zRot +=(blend * -(float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.55f * globalDegree + 0.05 * globalDegree) * limbSwingAmount);
        leftLeg.yRot +=(blend * (float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.1f * globalDegree - 0.15) * limbSwingAmount);

        rightLeg.xRot +=(blend * 0.05f * limbSwingAmount * globalHeight);
        rightLeg.zRot +=(blend * (float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.55f * globalDegree - 0.05 * globalDegree) * limbSwingAmount);
        rightLeg.yRot +=(blend * (float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.1f * globalDegree + 0.15) * limbSwingAmount);
    }

    private void walkRightAnim(float blend, float limbSwing, float limbSwingAmount, float speed) {

        float globalHeight = 1.5f;
        float globalDegree = 1.5f;

        leftLeg.xRot +=(blend * 0.05f * limbSwingAmount * globalHeight);
        leftLeg.zRot +=(blend * (float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.55f * globalDegree + 0.05 * globalDegree) * limbSwingAmount);
        leftLeg.yRot +=(blend * (float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.1f * globalDegree - 0.15) * limbSwingAmount);

        rightLeg.xRot +=(blend * -0.05f * limbSwingAmount * globalHeight);
        rightLeg.zRot +=(blend * -(float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.55f * globalDegree - 0.05 * globalDegree) * limbSwingAmount);
        rightLeg.yRot +=(blend * (float) (Math.cos(limbSwing * speed * 0.5 + 1.5) * 0.1f * globalDegree + 0.15) * limbSwingAmount);
    }


    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount, float partialTick) {

    }

    public ModelPart getFlowerHoldingArm() {
        return this.rightArm;
    }
}