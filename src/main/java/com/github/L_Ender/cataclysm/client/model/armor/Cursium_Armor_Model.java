package com.github.L_Ender.cataclysm.client.model.armor;


import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Cursium_Armor_Model extends HumanoidModel {

    public Cursium_Armor_Model(ModelPart p_170677_) {
        super(p_170677_);


    }

    public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.getChild("head");
        PartDefinition body = partdefinition.getChild("body");
        PartDefinition rightArm = partdefinition.getChild("right_arm");
        PartDefinition leftArm = partdefinition.getChild("left_arm");
        PartDefinition rightLeg = partdefinition.getChild("right_leg");
        PartDefinition leftLeg = partdefinition.getChild("left_leg");

        PartDefinition RightCustomArm = rightArm.addOrReplaceChild("RightCustomArm", CubeListBuilder.create().texOffs(22, 89).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.525F))
                .texOffs(22, 105).addBox(-3.6F, 3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition right_shoulder = RightCustomArm.addOrReplaceChild("right_shoulder", CubeListBuilder.create(), PartPose.offset(-2.5F, 2.0F, 0.0F));


        PartDefinition rib = body.addOrReplaceChild("rib", CubeListBuilder.create().texOffs(100, 0).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.6F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition chestplate_r1 = right_shoulder.addOrReplaceChild("chestplate_r1", CubeListBuilder.create().texOffs(0, 92).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.55F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition LeftCustomArm = leftArm.addOrReplaceChild("LeftCustomArm", CubeListBuilder.create().texOffs(22, 89).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.525F)).mirror(false)
                .texOffs(22, 105).mirror().addBox(-0.4F, 3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.6F)).mirror(false), PartPose.offset(0.0F, 2.0F, 0.0F));

        PartDefinition left_shoulder = LeftCustomArm.addOrReplaceChild("left_shoulder", CubeListBuilder.create(), PartPose.offset(2.5F, 2.0F, 0.0F));

        PartDefinition chestplate_r2 = left_shoulder.addOrReplaceChild("chestplate_r2", CubeListBuilder.create().texOffs(0, 92).mirror().addBox(-2.5F, -6.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.55F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition right_leggings_plate = rightLeg.addOrReplaceChild("right_leggings_plate", CubeListBuilder.create().texOffs(62, 108).addBox(-5.8F, -12.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.8F)), PartPose.offsetAndRotation(1.9F, 11.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition left_leggings_plate = leftLeg.addOrReplaceChild("left_leggings_plate", CubeListBuilder.create().texOffs(62, 108).mirror().addBox(2.8F, -12.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.8F)).mirror(false), PartPose.offsetAndRotation(-1.9F, 11.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition right_horn = head.addOrReplaceChild("right_horn", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.2F, -10.0F, 0.0F, -0.2618F, 0.0F, -0.6545F));

        PartDefinition cube_r1 = right_horn.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 103).addBox(-5.811F, -19.4301F, 0.1321F, 12.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 118).addBox(-9.811F, -17.4301F, 0.1321F, 5.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(18, 115).addBox(-4.811F, -17.4301F, -1.8679F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 12.0F, 2.0F, 0.1309F, 0.0F, -0.3054F));

        PartDefinition cube_r2 = right_horn.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(1, 110).addBox(-0.811F, -17.4301F, -1.3679F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0196F, 12.0622F, 1.5043F, 0.1309F, 0.0F, -0.3054F));

        PartDefinition left_horn = head.addOrReplaceChild("left_horn", CubeListBuilder.create(), PartPose.offsetAndRotation(6.2F, -10.0F, 0.0F, -0.2618F, 0.0F, 0.6545F));

        PartDefinition cube_r3 = left_horn.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 103).mirror().addBox(-6.189F, -19.4301F, 0.1321F, 12.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 118).mirror().addBox(4.811F, -17.4301F, 0.1321F, 5.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(18, 115).mirror().addBox(0.811F, -17.4301F, -1.8679F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 12.0F, 2.0F, 0.1309F, 0.0F, 0.3054F));

        PartDefinition cube_r4 = left_horn.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(1, 110).mirror().addBox(-6.189F, -17.4301F, -1.3679F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0196F, 12.0622F, 1.5043F, 0.1309F, 0.0F, 0.3054F));

        PartDefinition right_plate = head.addOrReplaceChild("right_plate", CubeListBuilder.create().texOffs(35, 114).addBox(-6.5F, -5.5F, -5.0F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_plate = head.addOrReplaceChild("left_plate", CubeListBuilder.create().texOffs(35, 114).mirror().addBox(2.5F, -5.5F, -5.0F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

}
