package com.github.L_Ender.cataclysm.client.model.armor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class Modelignitium_Elytra_chestplate extends HumanoidModel {
    private final ModelPart rightWing;
    private final ModelPart leftWing;

    public Modelignitium_Elytra_chestplate(ModelPart part) {
        super(part);
        this.leftWing = part.getChild("body").getChild("left_wing");
        this.rightWing = part.getChild("body").getChild("right_wing");
    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition body = meshdefinition.getRoot().getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");
        body.addOrReplaceChild("left_wing", CubeListBuilder.create()
                        .texOffs(0, 65)
                        .mirror()
                        .addBox(-10.0F, 0.0F, 1.5F, 11.0F, 23.0F, 2.0F,  new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(5.0F, 0.0F, 1.5F, 0.2617994F, 0.0F, -0.2617994F));
        body.addOrReplaceChild("right_wing", CubeListBuilder.create()
                        .texOffs(0, 65)
                        .addBox(0.0F, 0.0F, 1.5F, 11.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-5.0F, 0.0F, 1.5F, 0.2617994F, 0.0F, 0.2617994F));
        body.addOrReplaceChild("outer_body", CubeListBuilder.create()
                .texOffs(30, 47)
                .addBox(-4.5F, 1.0F, -2.5F, 9.0F, 12.0F, 5.0F,
                        new CubeDeformation(0.4F)), PartPose
                .offset(0.0F, -1.0F, 0.0F));

        body.addOrReplaceChild("inner_body", CubeListBuilder.create()
                .texOffs(0, 51)
                .addBox(-4.0F, -6.0F, -2.0F, 8.0F, 9.0F, 4.0F,
                        new CubeDeformation(0.5F)), PartPose
                .offset(0.0F, 11.0F, 0.0F));

        PartDefinition left_shoulderpad = leftArm.addOrReplaceChild("left_shoulderpad", CubeListBuilder.create()
                .texOffs(30, 33)
                .addBox(-6.0F, -7.0F, -3.0F, 5.0F, 7.0F, 6.0F,
                        new CubeDeformation(0.3F)), PartPose
                .offset(5.0F, 4.0F, 0.0F));

        PartDefinition left_spike = left_shoulderpad.addOrReplaceChild("left_spike", CubeListBuilder.create()
                .texOffs(21, 43)
                .addBox(-1.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F,
                        new CubeDeformation(0.0F)), PartPose
                .offsetAndRotation(-1.0F, -8.5F, 0.0F, 0.0F, 0.0F, 0.6109F));

        left_spike.addOrReplaceChild("left_side_spike", CubeListBuilder.create()
                .texOffs(30, 47)
                .addBox(0.5F, -3.5F, -0.5F, 2.0F, 4.0F, 0.0F,
                        new CubeDeformation(0.0F)), PartPose
                .offsetAndRotation(2.5F, 3.0F, 0.5F, 0.0F, 0.0F, 0.829F));

        PartDefinition right_shoulderpad = rightArm.addOrReplaceChild("right_shoulderpad", CubeListBuilder.create()
                .texOffs(30, 33)
                .mirror()
                .addBox(0.0F, -7.0F, -3.0F, 5.0F, 7.0F, 6.0F,
                        new CubeDeformation(0.3F)).mirror(false), PartPose
                .offset(-4.0F, 4.0F, 0.0F));

        PartDefinition right_spike = right_shoulderpad.addOrReplaceChild("right_spike", CubeListBuilder.create()
                .texOffs(21, 43)
                .mirror()
                .addBox(-3.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose
                .offsetAndRotation(0.0F, -8.5F, 0.0F, 0.0F, 0.0F, -0.6109F));

        right_spike.addOrReplaceChild("right_side_spike", CubeListBuilder.create()
                .texOffs(30, 47)
                .mirror()
                .addBox(-2.5F, -3.5F, -0.5F, 2.0F, 4.0F, 0.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose
                .offsetAndRotation(-2.5F, 3.0F, 0.5F, 0.0F, 0.0F, -0.829F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public Modelignitium_Elytra_chestplate withAnimations(LivingEntity entity){
        float partialTick = Minecraft.getInstance().getFrameTime();
        float limbSwingAmount = entity.walkAnimation.speed(partialTick);
        float limbSwing = entity.walkAnimation.position() + partialTick;
        setupAnim(entity, limbSwing, limbSwingAmount, entity.tickCount + partialTick, 0, 0);
        return  this;
    }

    public void setupAnim(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 0.2617994F;
        float f1 = -0.2617994F;
        float f2 = 0.0F;
        float f3 = 0.0F;
        if (entityIn.isFallFlying()) {
            float f4 = 1.0F;
            Vec3 vector3d = entityIn.getDeltaMovement();
            if (vector3d.y < 0.0D) {
                Vec3 vector3d1 = vector3d.normalize();
                f4 = 1.0F - (float)Math.pow(-vector3d1.y, 1.5D);
            }

            f = f4 * 0.34906584F + (1.0F - f4) * f;
            f1 = f4 * (-(float)Math.PI / 2F) + (1.0F - f4) * f1;
        } else if (entityIn.isCrouching()) {
            f = 0.6981317F;
            f1 = (-(float)Math.PI / 4F);
            f2 = -1.0F;
            f3 = 0.08726646F;
        }

        this.leftWing.x = 5.0F;
        this.leftWing.y = f2;
        if (entityIn instanceof AbstractClientPlayer) {
            AbstractClientPlayer abstractclientplayerentity = (AbstractClientPlayer)entityIn;
            abstractclientplayerentity.elytraRotX = (float)((double)abstractclientplayerentity.elytraRotX + (double)(f - abstractclientplayerentity.elytraRotX) * 0.1D);
            abstractclientplayerentity.elytraRotY = (float)((double)abstractclientplayerentity.elytraRotY + (double)(f3 - abstractclientplayerentity.elytraRotY) * 0.1D);
            abstractclientplayerentity.elytraRotZ = (float)((double)abstractclientplayerentity.elytraRotZ + (double)(f1 - abstractclientplayerentity.elytraRotZ) * 0.1D);
            this.leftWing.xRot = abstractclientplayerentity.elytraRotX;
            this.leftWing.yRot = abstractclientplayerentity.elytraRotY;
            this.leftWing.zRot = abstractclientplayerentity.elytraRotZ;
        } else {
            this.leftWing.xRot = f;
            this.leftWing.zRot = f1;
            this.leftWing.yRot = f3;
        }

        this.rightWing.x = -this.leftWing.x;
        this.rightWing.yRot = -this.leftWing.yRot;
        this.rightWing.y = this.leftWing.y;
        this.rightWing.xRot = this.leftWing.xRot;
        this.rightWing.zRot = -this.leftWing.zRot;
    }
}
